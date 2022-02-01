package com.tencent.qqmusic.mediaplayer.codec;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.AudioRecognition;
import com.tencent.qqmusic.mediaplayer.NativeLibs;
import com.tencent.qqmusic.mediaplayer.codec.ffmpeg.FfmpegRecognition;
import com.tencent.qqmusic.mediaplayer.codec.flac.FLACRecognition;
import com.tencent.qqmusic.mediaplayer.codec.wav.WavRecognition;
import com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.flac.FlacSeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.mp3.Mp3SeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.Mp4SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(23)
public class MediaCodecDecoder
  extends BaseDecoder
{
  private static final int CONTINUOUS_TIMEOUT_COUNT = 500;
  private static final String KEY_BIT_RATE = "bit-rate";
  private static final String KEY_PCM_ENCODING = "pcm-encoding";
  private static final String TAG = "MediaCodecDecoder";
  private static final long TIMEOUT_AUTO_SEEK_INTERVAL_MS = 5000L;
  private static final int TIMEOUT_US = 1000;
  @NonNull
  private WeakReference<AudioTrack> mAudioTrackRef = new WeakReference(null);
  private long mCurrentDecodeTime = 0L;
  private boolean mDecoderFinished = false;
  private long mFileSize = 0L;
  private AudioInformation mInfo = null;
  private MediaCodec mMediaCodec = null;
  private final MediaExtractor mMediaExtractor = new MediaExtractor();
  private volatile byte[] mRemainBuffer = null;
  private SeekTable mSeekTable = null;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
  }
  
  private int decodeDataInternal(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject1 = this.mRemainBuffer;
    int i;
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      if (paramInt >= localObject1.length)
      {
        System.arraycopy(localObject1, 0, paramArrayOfByte, 0, localObject1.length);
        paramInt = localObject1.length;
        this.mRemainBuffer = null;
        return paramInt;
      }
      System.arraycopy(localObject1, 0, paramArrayOfByte, 0, paramInt);
      i = localObject1.length - paramInt;
      paramArrayOfByte = new byte[i];
      System.arraycopy(localObject1, paramInt, paramArrayOfByte, 0, i);
      this.mRemainBuffer = paramArrayOfByte;
      return paramInt;
    }
    if (this.mMediaCodec != null)
    {
      localObject1 = new MediaCodec.BufferInfo();
      int j = 0;
      i = 0;
      while ((!this.mDecoderFinished) && (j <= 0)) {
        try
        {
          int k = processInputOutputBuffer((MediaCodec.BufferInfo)localObject1);
          int m;
          if (k != -3)
          {
            Object localObject2;
            if (k != -2)
            {
              if (k != -1)
              {
                localObject2 = this.mMediaCodec.getOutputBuffer(k);
                if (localObject2 == null) {
                  continue;
                }
                j = Math.min(Math.min(paramInt, ((ByteBuffer)localObject2).remaining()), paramArrayOfByte.length);
                ((ByteBuffer)localObject2).get(paramArrayOfByte, 0, j);
                if (((MediaCodec.BufferInfo)localObject1).size > paramInt)
                {
                  m = ((MediaCodec.BufferInfo)localObject1).size - paramInt;
                  this.mRemainBuffer = new byte[m];
                  ((ByteBuffer)localObject2).get(this.mRemainBuffer, 0, m);
                }
                ((ByteBuffer)localObject2).clear();
                this.mMediaCodec.releaseOutputBuffer(k, false);
                long l1 = this.mCurrentDecodeTime;
                this.mCurrentDecodeTime = (((MediaCodec.BufferInfo)localObject1).presentationTimeUs / 1000L);
                localObject2 = this.mInfo;
                k = j;
                m = i;
                if (localObject2 != null)
                {
                  k = j;
                  m = i;
                  if (((AudioInformation)localObject2).getBitDepth() == 0)
                  {
                    long l2 = this.mCurrentDecodeTime;
                    k = AudioRecognition.calcBitDept(((MediaCodec.BufferInfo)localObject1).size, l2 - l1, this.mInfo.getChannels(), this.mInfo.getSampleRate());
                    this.mInfo.setBitDept(k);
                    k = j;
                    m = i;
                  }
                }
              }
              else
              {
                m = i + 1;
                Logger.i("MediaCodecDecoder", "dequeueOutputBuffer timed out!");
                if (m != 500) {
                  k = j;
                } else {
                  throw new MediaCodecDecoder.BufferTimeoutException();
                }
              }
            }
            else
            {
              localObject2 = this.mMediaCodec.getOutputFormat();
              Object localObject3 = (AudioTrack)this.mAudioTrackRef.get();
              if ((localObject3 != null) && (localObject2 != null)) {
                ((AudioTrack)localObject3).setPlaybackRate(((MediaFormat)localObject2).getInteger("sample-rate"));
              }
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("New format ");
              ((StringBuilder)localObject3).append(localObject2);
              Logger.i("MediaCodecDecoder", ((StringBuilder)localObject3).toString());
              k = j;
              m = i;
            }
          }
          else
          {
            Logger.i("MediaCodecDecoder", "INFO_OUTPUT_BUFFERS_CHANGED");
            m = i;
            k = j;
          }
          j = k;
          i = m;
          if ((((MediaCodec.BufferInfo)localObject1).flags & 0x4) != 0)
          {
            this.mDecoderFinished = true;
            this.mCurrentDecodeTime = getDuration();
            Logger.i("MediaCodecDecoder", "OutputBuffer BUFFER_FLAG_END_OF_STREAM");
            j = k;
            i = m;
          }
        }
        catch (MediaCodecDecoder.NullInputBufferException localNullInputBufferException)
        {
          label534:
          break label534;
        }
      }
      return j;
    }
    return 0;
  }
  
  @TargetApi(16)
  private static AudioFormat.AudioType getAudioType(MediaExtractor paramMediaExtractor, IDataSource paramIDataSource)
  {
    AudioFormat.AudioType localAudioType = AudioFormat.AudioType.UNSUPPORT;
    Object localObject = getMediaFormatByExtractor(paramMediaExtractor);
    paramMediaExtractor = localAudioType;
    if (localObject != null)
    {
      localObject = ((MediaFormat)localObject).getString("mime");
      paramMediaExtractor = localAudioType;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramMediaExtractor = localAudioType;
        if (((String)localObject).startsWith("audio"))
        {
          int i = -1;
          switch (((String)localObject).hashCode())
          {
          default: 
            break;
          case 1504831518: 
            if (((String)localObject).equals("audio/mpeg")) {
              i = 4;
            }
            break;
          case 1504619009: 
            if (((String)localObject).equals("audio/flac")) {
              i = 1;
            }
            break;
          case 187094639: 
            if (((String)localObject).equals("audio/raw")) {
              i = 2;
            }
            break;
          case -53558318: 
            if (((String)localObject).equals("audio/mp4a-latm")) {
              i = 3;
            }
            break;
          case -1003765268: 
            if (((String)localObject).equals("audio/vorbis")) {
              i = 0;
            }
            break;
          }
          if (i != 0)
          {
            if (i != 1)
            {
              if (i != 2)
              {
                if (i != 3)
                {
                  if (i != 4) {
                    return localAudioType;
                  }
                  return AudioFormat.AudioType.MP3;
                }
                paramMediaExtractor = localAudioType;
                if (FfmpegRecognition.isM4a(paramIDataSource)) {
                  return AudioFormat.AudioType.M4A;
                }
              }
              else
              {
                if (FLACRecognition.isFlac(paramIDataSource)) {
                  return AudioFormat.AudioType.FLAC;
                }
                paramMediaExtractor = localAudioType;
                if (WavRecognition.isWav(paramIDataSource)) {
                  return AudioFormat.AudioType.WAV;
                }
              }
            }
            else {
              return AudioFormat.AudioType.FLAC;
            }
          }
          else {
            paramMediaExtractor = AudioFormat.AudioType.OGG;
          }
        }
      }
    }
    return paramMediaExtractor;
  }
  
  public static AudioFormat.AudioType getAudioType(String paramString)
  {
    AudioFormat.AudioType localAudioType = AudioFormat.AudioType.UNSUPPORT;
    if (Build.VERSION.SDK_INT >= 16)
    {
      Object localObject = new MediaExtractor();
      int i;
      try
      {
        ((MediaExtractor)localObject).setDataSource(paramString);
        i = 1;
      }
      catch (Throwable localThrowable)
      {
        Logger.e("MediaCodecDecoder", "getAudioType", localThrowable);
        i = 0;
      }
      if (i != 0)
      {
        paramString = new FileDataSource(paramString);
        paramString.open();
        localObject = getAudioType((MediaExtractor)localObject, paramString);
        paramString.close();
        return localObject;
      }
    }
    return localAudioType;
  }
  
  private static MediaFormat getMediaFormatByExtractor(MediaExtractor paramMediaExtractor)
  {
    int i = 0;
    while (i < paramMediaExtractor.getTrackCount())
    {
      MediaFormat localMediaFormat = paramMediaExtractor.getTrackFormat(i);
      String str = localMediaFormat.getString("mime");
      if ((!TextUtils.isEmpty(str)) && (str.startsWith("audio"))) {
        return localMediaFormat;
      }
      i += 1;
    }
    return null;
  }
  
  private boolean initAudioInformation(String paramString, int paramInt, MediaFormat paramMediaFormat, IDataSource paramIDataSource, AudioFormat.AudioType paramAudioType)
  {
    this.mMediaExtractor.selectTrack(paramInt);
    this.mMediaCodec = MediaCodec.createDecoderByType(paramString);
    this.mMediaCodec.configure(paramMediaFormat, null, null, 0);
    this.mMediaCodec.start();
    paramInt = 0;
    int i = -1;
    while ((paramInt < 500) && ((i == -1) || (i == -3)))
    {
      try
      {
        int j = processInputOutputBuffer(new MediaCodec.BufferInfo());
        i = j;
        if (j == -2) {
          paramString = this.mMediaCodec.getOutputFormat();
        }
      }
      catch (MediaCodecDecoder.NullInputBufferException paramString)
      {
        label94:
        Object localObject;
        break label94;
      }
      paramInt += 1;
    }
    paramString = null;
    if (paramString != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("format:");
      ((StringBuilder)localObject).append(paramMediaFormat);
      ((StringBuilder)localObject).append(" outputFormat:");
      ((StringBuilder)localObject).append(paramString);
      Logger.i("MediaCodecDecoder", ((StringBuilder)localObject).toString());
      if (paramString.containsKey(KEY_PCM_ENCODING))
      {
        localObject = KEY_PCM_ENCODING;
        paramMediaFormat.setInteger((String)localObject, paramString.getInteger((String)localObject));
      }
      if (paramString.containsKey("sample-rate")) {
        paramMediaFormat.setInteger("sample-rate", paramString.getInteger("sample-rate"));
      }
      if (paramString.containsKey("channel-count")) {
        paramMediaFormat.setInteger("channel-count", paramString.getInteger("channel-count"));
      }
      setAudioInformationByMediaFormat(this.mInfo, paramMediaFormat, paramIDataSource.getSize());
      if (paramAudioType == AudioFormat.AudioType.FLAC) {
        this.mSeekTable = new FlacSeekTable((int)this.mInfo.getSampleRate());
      } else if ((paramAudioType != AudioFormat.AudioType.M4A) && (paramAudioType != AudioFormat.AudioType.MP4))
      {
        if (paramAudioType == AudioFormat.AudioType.MP3) {
          this.mSeekTable = new Mp3SeekTable();
        }
      }
      else {
        this.mSeekTable = new Mp4SeekTable();
      }
      paramString = this.mSeekTable;
      if (paramString != null) {
        try
        {
          paramString.parse(paramIDataSource);
        }
        catch (InvalidBoxException paramString)
        {
          this.mSeekTable = null;
          Logger.e("MediaCodecDecoder", "seek table parse", paramString);
        }
      }
      if ((this.mInfo.getDuration() > 0L) && (this.mInfo.getChannels() >= 2)) {
        return true;
      }
    }
    else
    {
      this.mMediaCodec.release();
    }
    return false;
  }
  
  private boolean initMediaCodecAndFormat(IDataSource paramIDataSource)
  {
    int i = 0;
    while (i < this.mMediaExtractor.getTrackCount())
    {
      MediaFormat localMediaFormat = this.mMediaExtractor.getTrackFormat(i);
      String str = localMediaFormat.getString("mime");
      if ((!TextUtils.isEmpty(str)) && (str.startsWith("audio")))
      {
        this.mInfo = new AudioInformation();
        AudioFormat.AudioType localAudioType = paramIDataSource.getAudioType();
        this.mInfo.setAudioType(localAudioType);
        setAudioType(localAudioType);
        return initAudioInformation(str, i, localMediaFormat, paramIDataSource, localAudioType);
      }
      i += 1;
    }
    return false;
  }
  
  private int processInputOutputBuffer(MediaCodec.BufferInfo paramBufferInfo)
  {
    int i = this.mMediaCodec.dequeueInputBuffer(1000L);
    if (i >= 0)
    {
      ByteBuffer localByteBuffer = this.mMediaCodec.getInputBuffer(i);
      if (localByteBuffer != null)
      {
        int j = this.mMediaExtractor.readSampleData(localByteBuffer, 0);
        if (j < 0)
        {
          Logger.i("MediaCodecDecoder", "InputBuffer BUFFER_FLAG_END_OF_STREAM");
          this.mMediaCodec.queueInputBuffer(i, 0, 0, 0L, 4);
        }
        else
        {
          this.mMediaCodec.queueInputBuffer(i, 0, j, this.mMediaExtractor.getSampleTime(), 0);
          this.mMediaExtractor.advance();
        }
      }
      else
      {
        throw new MediaCodecDecoder.NullInputBufferException();
      }
    }
    return this.mMediaCodec.dequeueOutputBuffer(paramBufferInfo, 1000L);
  }
  
  private static void setAudioInformationByMediaFormat(AudioInformation paramAudioInformation, MediaFormat paramMediaFormat, long paramLong)
  {
    int n = paramMediaFormat.getInteger("sample-rate");
    int i1 = paramMediaFormat.getInteger("channel-count");
    boolean bool = paramMediaFormat.containsKey("bitrate");
    int k = 0;
    int i;
    if (bool) {
      i = paramMediaFormat.getInteger("bitrate") / 1000;
    } else if (paramMediaFormat.containsKey("bit-rate")) {
      i = paramMediaFormat.getInteger("bit-rate") / 1000;
    } else {
      i = 0;
    }
    long l = 0L;
    if (i > 0)
    {
      if (paramMediaFormat.containsKey("durationUs")) {
        l = paramMediaFormat.getLong("durationUs") / 1000L;
      } else {
        l = (int)(paramLong / i * 8L);
      }
    }
    else if (paramMediaFormat.containsKey("durationUs"))
    {
      l = paramMediaFormat.getLong("durationUs") / 1000L;
      if (l > 0L) {
        i = (int)(paramLong / l * 8L);
      } else {
        i = 0;
      }
    }
    int m;
    if (paramMediaFormat.containsKey(KEY_PCM_ENCODING))
    {
      m = paramMediaFormat.getInteger(KEY_PCM_ENCODING);
      j = 4;
      if (m != 3)
      {
        if (m == 4) {
          break label220;
        }
      }
      else
      {
        j = 1;
        break label220;
      }
    }
    int j = 2;
    label220:
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      m = paramMediaFormat.getInteger("bitrate-mode");
      k = m;
    }
    catch (Exception paramMediaFormat)
    {
      label241:
      break label241;
    }
    if (k != 1)
    {
      if (k == 2) {
        paramAudioInformation.setCbr(1);
      }
    }
    else {
      paramAudioInformation.setCbr(3);
    }
    paramAudioInformation.setSampleRate(n);
    paramAudioInformation.setChannels(i1);
    paramAudioInformation.setDuration(l);
    paramAudioInformation.setBitrate(i);
    paramAudioInformation.setBitDept(j);
  }
  
  public int decodeData(int paramInt, byte[] paramArrayOfByte)
  {
    label9:
    label79:
    do
    {
      try
      {
        i = decodeDataInternal(paramInt, paramArrayOfByte);
        return i;
      }
      catch (MediaCodecDecoder.BufferTimeoutException localBufferTimeoutException1)
      {
        int i;
        long l;
        StringBuilder localStringBuilder;
        break label9;
      }
      l = getCurrentTime() + 5000L;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("decodeData buffer timeout, seekTime:");
      localStringBuilder.append(l);
      Logger.i("MediaCodecDecoder", localStringBuilder.toString());
      seekTo((int)Math.min(getDuration(), l));
      try
      {
        i = decodeDataInternal(paramInt, paramArrayOfByte);
        return i;
      }
      catch (MediaCodecDecoder.BufferTimeoutException localBufferTimeoutException2)
      {
        break label79;
      }
    } while (l < getDuration());
    return -1;
  }
  
  public AudioInformation getAudioInformation()
  {
    return this.mInfo;
  }
  
  public long getBytePositionOfTime(long paramLong)
  {
    int i = this.mInfo.getBitrate();
    SeekTable localSeekTable = this.mSeekTable;
    if (localSeekTable != null) {
      return localSeekTable.seek(paramLong);
    }
    if (i > 0) {
      return paramLong * i;
    }
    if (getDuration() > 0L) {
      return this.mFileSize * paramLong / getDuration();
    }
    return 0L;
  }
  
  public long getCurrentTime()
  {
    return this.mCurrentDecodeTime;
  }
  
  public long getDuration()
  {
    AudioInformation localAudioInformation = this.mInfo;
    if (localAudioInformation != null) {
      return localAudioInformation.getDuration();
    }
    return 0L;
  }
  
  public int getErrorCodeMask()
  {
    return -1;
  }
  
  public long getMinBufferSize()
  {
    AudioInformation localAudioInformation = this.mInfo;
    if (localAudioInformation != null)
    {
      int j = localAudioInformation.getBitDepth();
      int i = 4;
      if (j == 1) {
        i = 3;
      } else if ((j != 4) || (Build.VERSION.SDK_INT < 21)) {
        i = 2;
      }
      return AudioTrack.getMinBufferSize((int)this.mInfo.getSampleRate(), 12, i);
    }
    return 0L;
  }
  
  protected List<NativeLibs> getNativeLibs()
  {
    return new ArrayList();
  }
  
  @TargetApi(23)
  public int init(IDataSource paramIDataSource)
  {
    if (paramIDataSource != null) {
      try
      {
        paramIDataSource.open();
        this.mMediaExtractor.setDataSource(new MediaCodecDecoder.1(this, paramIDataSource));
        this.mFileSize = paramIDataSource.getSize();
        boolean bool = initMediaCodecAndFormat(paramIDataSource);
        if (bool) {
          return 0;
        }
      }
      catch (Throwable paramIDataSource)
      {
        Logger.e("MediaCodecDecoder", "init", paramIDataSource);
      }
    }
    return -1;
  }
  
  public int init(INativeDataSource paramINativeDataSource)
  {
    return -1;
  }
  
  public int init(String paramString, boolean paramBoolean)
  {
    return init(new FileDataSource(paramString));
  }
  
  public int release()
  {
    this.mMediaExtractor.release();
    MediaCodec localMediaCodec = this.mMediaCodec;
    if (localMediaCodec != null) {
      localMediaCodec.release();
    }
    return 0;
  }
  
  public int seekTo(int paramInt)
  {
    this.mMediaCodec.flush();
    this.mRemainBuffer = null;
    this.mMediaExtractor.seekTo(paramInt * 1000, 2);
    this.mCurrentDecodeTime = paramInt;
    return paramInt;
  }
  
  public void setAudioTrack(AudioTrack paramAudioTrack)
  {
    this.mAudioTrackRef = new WeakReference(paramAudioTrack);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.MediaCodecDecoder
 * JD-Core Version:    0.7.0.1
 */