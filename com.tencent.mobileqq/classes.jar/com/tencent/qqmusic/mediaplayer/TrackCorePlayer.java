package com.tencent.qqmusic.mediaplayer;

import android.os.Looper;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.TrackDataSource.TrackStateCallback;
import com.tencent.qqmusic.mediaplayer.util.Logger;

class TrackCorePlayer
  extends CorePlayer
  implements TrackDataSource.TrackStateCallback
{
  private static final String TAG = "TrackCorePlayer";
  private long mStartPosition = 0L;
  
  TrackCorePlayer(@NonNull IDataSource paramIDataSource, @NonNull PlayerCallback paramPlayerCallback, @NonNull Looper paramLooper, @NonNull QMThreadExecutor paramQMThreadExecutor)
  {
    super(paramIDataSource, null, paramPlayerCallback, paramLooper, new NativeDecoder(), paramQMThreadExecutor);
  }
  
  long getCurPosition()
  {
    return super.getCurPosition() - this.mStartPosition;
  }
  
  public void onTrackPrepared(TrackInfo paramTrackInfo)
  {
    this.mStartPosition = ((Long)paramTrackInfo.getRange().first).longValue();
    long l1 = ((Long)paramTrackInfo.getRange().second).longValue();
    long l2 = ((Long)paramTrackInfo.getRange().first).longValue();
    paramTrackInfo = new StringBuilder();
    paramTrackInfo.append("onTrackPrepared, start byte: ");
    paramTrackInfo.append(l2);
    paramTrackInfo.append(", end byte: ");
    paramTrackInfo.append(l1);
    Logger.i("TrackCorePlayer", paramTrackInfo.toString());
    this.mInformation.setDuration(l1 - l2);
  }
  
  public void seek(int paramInt)
  {
    int i = (int)(paramInt + this.mStartPosition);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seek, position: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ,realseek: ");
    localStringBuilder.append(i);
    Logger.i("TrackCorePlayer", localStringBuilder.toString());
    super.seek(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.TrackCorePlayer
 * JD-Core Version:    0.7.0.1
 */