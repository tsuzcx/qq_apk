package com.tencent.tav.decoder.muxer;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import org.jetbrains.annotations.NotNull;

@RequiresApi(api=18)
public class DefaultMediaMuxer
  implements IMediaMuxer
{
  private final String TAG = "DefaultMediaMuxer";
  private int audioTrackIndex = -1;
  private boolean isStarted = false;
  private final MediaMuxer muxer;
  private int videoTrackIndex = -1;
  
  public DefaultMediaMuxer(@NonNull String paramString, int paramInt)
  {
    this.muxer = new MediaMuxer(paramString, paramInt);
  }
  
  public int addTrack(@NonNull MediaFormat paramMediaFormat)
  {
    int i = this.muxer.addTrack(paramMediaFormat);
    if (paramMediaFormat.containsKey("mime"))
    {
      paramMediaFormat = paramMediaFormat.getString("mime");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("add track mime:");
      localStringBuilder.append(paramMediaFormat);
      Logger.i("DefaultMediaMuxer", localStringBuilder.toString());
      if (paramMediaFormat.contains("video"))
      {
        this.videoTrackIndex = i;
        return i;
      }
      if (paramMediaFormat.contains("audio")) {
        this.audioTrackIndex = i;
      }
    }
    return i;
  }
  
  public int audioTrackIndex()
  {
    return this.audioTrackIndex;
  }
  
  public boolean ignoreHeader()
  {
    return true;
  }
  
  public boolean isMuxerStarted()
  {
    return this.isStarted;
  }
  
  public void release()
  {
    this.muxer.release();
    this.isStarted = false;
    Logger.i("DefaultMediaMuxer", "release muxer");
  }
  
  public void setExportConfig(@NotNull ExportConfig paramExportConfig)
  {
    this.muxer.setOrientationHint(paramExportConfig.getOutputRotate() * 90);
  }
  
  public void start()
  {
    this.muxer.start();
    this.isStarted = true;
  }
  
  public void stop()
  {
    this.muxer.stop();
    this.isStarted = false;
    Logger.i("DefaultMediaMuxer", "stop muxer");
  }
  
  public int videoTrackIndex()
  {
    return this.videoTrackIndex;
  }
  
  public void writeSampleData(int paramInt, @NonNull ByteBuffer paramByteBuffer, @NonNull MediaCodec.BufferInfo paramBufferInfo)
  {
    this.muxer.writeSampleData(paramInt, paramByteBuffer, paramBufferInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.muxer.DefaultMediaMuxer
 * JD-Core Version:    0.7.0.1
 */