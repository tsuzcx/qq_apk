package com.tencent.qqmusic.mediaplayer.upstream;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.io.IOException;

public class TrackDataSource
  implements PlayerListenerCallback, IDataSource
{
  private static final String TAG = "TrackDataSource";
  private IDataSource mDataSource;
  private long mEndBytePosition;
  private long mStartBytePosition;
  private long mStartTimePosition;
  private TrackInfo mTrackInfo;
  private TrackDataSource.TrackStateCallback mTrackStateCallback;
  
  public TrackDataSource(TrackInfo paramTrackInfo)
  {
    String str = paramTrackInfo.getUri();
    if (!TextUtils.isEmpty(paramTrackInfo.getUri()))
    {
      if (new File(str).exists())
      {
        this.mDataSource = new FileDataSource(paramTrackInfo.getUri());
        this.mTrackInfo = paramTrackInfo;
        return;
      }
      throw new DataSourceException(-1, "track info's media file not exists!", null);
    }
    throw new DataSourceException(-1, "track info has no media file path!", null);
  }
  
  public void close()
  {
    this.mDataSource.close();
  }
  
  public AudioFormat.AudioType getAudioType()
  {
    return this.mDataSource.getAudioType();
  }
  
  public long getSize()
  {
    return this.mDataSource.getSize();
  }
  
  public void onBufferingUpdate(BaseMediaPlayer paramBaseMediaPlayer, int paramInt) {}
  
  public void onCompletion(BaseMediaPlayer paramBaseMediaPlayer) {}
  
  public void onError(BaseMediaPlayer paramBaseMediaPlayer, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onPrepared(BaseMediaPlayer paramBaseMediaPlayer)
  {
    try
    {
      this.mDataSource.open();
      long l1 = this.mDataSource.getSize();
      paramBaseMediaPlayer = paramBaseMediaPlayer.createSeekTable();
      Pair localPair = this.mTrackInfo.getRange();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start time: ");
      localStringBuilder.append(localPair.first);
      localStringBuilder.append(", end time: ");
      localStringBuilder.append(localPair.second);
      Logger.i("TrackDataSource", localStringBuilder.toString());
      if (((Long)localPair.first).longValue() > ((Long)localPair.second).longValue())
      {
        Logger.e("TrackDataSource", "start range larger, return");
        return;
      }
      this.mStartTimePosition = ((Long)localPair.first).longValue();
      long l3 = paramBaseMediaPlayer.seek(((Long)localPair.first).longValue());
      long l2 = paramBaseMediaPlayer.seek(((Long)localPair.second).longValue());
      if ((l1 > 0L) && (l3 > l1))
      {
        Logger.e("TrackDataSource", "startBytePosition larger than size!");
        return;
      }
      if ((l1 <= 0L) || (l2 <= l1)) {
        l1 = l2;
      }
      this.mStartBytePosition = l3;
      this.mEndBytePosition = l1;
      paramBaseMediaPlayer = new StringBuilder();
      paramBaseMediaPlayer.append("start byte: ");
      paramBaseMediaPlayer.append(this.mStartBytePosition);
      paramBaseMediaPlayer.append(", end byte: ");
      paramBaseMediaPlayer.append(this.mEndBytePosition);
      Logger.i("TrackDataSource", paramBaseMediaPlayer.toString());
      paramBaseMediaPlayer = this.mTrackStateCallback;
      if (paramBaseMediaPlayer != null) {
        paramBaseMediaPlayer.onTrackPrepared(this.mTrackInfo);
      }
      return;
    }
    catch (IOException paramBaseMediaPlayer)
    {
      Logger.e("TrackDataSource", "dataSource open failed!", paramBaseMediaPlayer);
    }
  }
  
  public void onSeekComplete(BaseMediaPlayer paramBaseMediaPlayer, int paramInt) {}
  
  public void onStarted(BaseMediaPlayer paramBaseMediaPlayer)
  {
    paramBaseMediaPlayer.seekTo(0);
  }
  
  public void onStateChanged(BaseMediaPlayer paramBaseMediaPlayer, int paramInt) {}
  
  public void open()
  {
    this.mDataSource.open();
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = this.mEndBytePosition;
    if ((l > 0L) && (paramLong > l)) {
      return -1;
    }
    return this.mDataSource.readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void setEndBytePosition(long paramLong)
  {
    this.mEndBytePosition = paramLong;
  }
  
  public void setTrackStateCallback(TrackDataSource.TrackStateCallback paramTrackStateCallback)
  {
    this.mTrackStateCallback = paramTrackStateCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.TrackDataSource
 * JD-Core Version:    0.7.0.1
 */