package com.tencent.mobileqq.videoplatform.api;

import java.util.Arrays;

public class VideoPlayParam
{
  public VideoPlayerCallback mCallback;
  public String mFileID;
  public long mFileSize;
  public boolean mIsLocal;
  public boolean mIsLoop;
  public boolean mIsMute;
  public long mLastPlayPosMs;
  public long mMaxPlayTimeMs;
  public boolean mNeedPlayProgress;
  public String mSavePath;
  public int mSceneId;
  public String mSceneName;
  public String[] mUrls;
  public long mVideoFileTimeMs;
  public String mVideoPath;
  
  public boolean isSameVideo(Object paramObject)
  {
    if (!(paramObject instanceof VideoPlayParam)) {}
    do
    {
      do
      {
        return false;
        paramObject = (VideoPlayParam)paramObject;
      } while ((paramObject.mIsLocal != this.mIsLocal) || (paramObject.mIsLoop != this.mIsLoop) || (paramObject.mIsMute != this.mIsMute));
      if ((paramObject.mVideoPath != null) && (this.mVideoPath != null) && (paramObject.mVideoPath.equals(this.mVideoPath))) {
        return true;
      }
    } while ((paramObject.mUrls == null) || (this.mUrls == null) || (!Arrays.equals(paramObject.mUrls, this.mUrls)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.api.VideoPlayParam
 * JD-Core Version:    0.7.0.1
 */