package com.tencent.mobileqq.videoplatform.api;

import java.util.ArrayList;
import java.util.Arrays;

public class VideoPlayParam
{
  public VideoPlayerCallback mCallback;
  public ArrayList<String> mCookies;
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
  public long mStartPlayPosMs;
  public String[] mUrls;
  public long mVideoFileTimeMs;
  public int mVideoFormat = 101;
  public String mVideoPath;
  
  public boolean isSameVideo(Object paramObject)
  {
    boolean bool1 = paramObject instanceof VideoPlayParam;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (VideoPlayParam)paramObject;
    bool1 = bool2;
    if (paramObject.mIsLocal == this.mIsLocal)
    {
      bool1 = bool2;
      if (paramObject.mIsLoop == this.mIsLoop)
      {
        if (paramObject.mIsMute != this.mIsMute) {
          return false;
        }
        Object localObject = paramObject.mVideoPath;
        if (localObject != null)
        {
          String str = this.mVideoPath;
          if ((str != null) && (((String)localObject).equals(str))) {
            return true;
          }
        }
        paramObject = paramObject.mUrls;
        bool1 = bool2;
        if (paramObject != null)
        {
          localObject = this.mUrls;
          bool1 = bool2;
          if (localObject != null)
          {
            bool1 = bool2;
            if (Arrays.equals(paramObject, (Object[])localObject)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.api.VideoPlayParam
 * JD-Core Version:    0.7.0.1
 */