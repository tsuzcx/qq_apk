package com.tencent.mobileqq.qcircle.api.global;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class QCircleHostGlobalInfo
{
  private static final String TAG = "QCircleHostGlobalInfo";
  private static boolean mCurrentQCircleTabIsActive = false;
  private static long mDataStatePos;
  private static ArrayList<String> mExposedGuideFeedIdList = new ArrayList();
  private static String mFeedId;
  private static Bitmap mFrameSnapShot;
  private static boolean mHasRestoreState;
  private static String mVideoCoverTempPath;
  
  public static void addExposedGuideFeedId(String paramString)
  {
    if ((mExposedGuideFeedIdList != null) && (!mExposedGuideFeedIdList.contains(paramString))) {
      mExposedGuideFeedIdList.add(paramString);
    }
  }
  
  public static void clearExposedGuideFeedIdList()
  {
    if (mExposedGuideFeedIdList != null) {
      mExposedGuideFeedIdList.clear();
    }
  }
  
  public static long getDataStatePos()
  {
    return mDataStatePos;
  }
  
  public static ArrayList<String> getExposedGuideFeedIdList()
  {
    return mExposedGuideFeedIdList;
  }
  
  public static String getFeedId()
  {
    return mFeedId;
  }
  
  public static Bitmap getFrameSnapShot()
  {
    return mFrameSnapShot;
  }
  
  public static String getVideoCoverTempPath()
  {
    return mVideoCoverTempPath;
  }
  
  public static boolean isCurrentTabActive()
  {
    return mCurrentQCircleTabIsActive;
  }
  
  public static boolean isHasRestoreState()
  {
    return mHasRestoreState;
  }
  
  public static void releaseWhenAccountChange() {}
  
  public static void saveFeedStatePos(String paramString, long paramLong)
  {
    mFeedId = paramString;
    mDataStatePos = paramLong;
  }
  
  public static void setCurrentTabActive(boolean paramBoolean)
  {
    mCurrentQCircleTabIsActive = paramBoolean;
    QLog.d("QCircleHostGlobalInfo", 4, "setCurrentIsActive:" + paramBoolean);
  }
  
  public static void setFrameSnapShot(Bitmap paramBitmap)
  {
    mFrameSnapShot = paramBitmap;
  }
  
  public static void setHasRestoreState(boolean paramBoolean)
  {
    mHasRestoreState = paramBoolean;
  }
  
  public static void setVideoCoverTempPath(String paramString)
  {
    mVideoCoverTempPath = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo
 * JD-Core Version:    0.7.0.1
 */