package com.tencent.mobileqq.qcircle.api.global;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.helper.QCircleChatBoxHelper;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudEeveeBase.StEeveeAttachInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class QCircleHostGlobalInfo
{
  private static final String TAG = "QCircleHostGlobalInfo";
  private static boolean mCurrentQCircleTabIsActive = false;
  private static ArrayList<String> mExposedGuideFeedIdList = new ArrayList();
  private static String mVideoCoverTempPath;
  private static String sCurMsfServerId = "";
  private static List<byte[]> sEeveeAttachInfos = new ArrayList();
  private static boolean sIsLostUser = false;
  
  public static void addExposedGuideFeedId(String paramString)
  {
    ArrayList localArrayList = mExposedGuideFeedIdList;
    if ((localArrayList != null) && (!localArrayList.contains(paramString))) {
      mExposedGuideFeedIdList.add(paramString);
    }
  }
  
  public static void clearExposedGuideFeedIdList()
  {
    ArrayList localArrayList = mExposedGuideFeedIdList;
    if (localArrayList != null) {
      localArrayList.clear();
    }
  }
  
  public static String getCurMsfServerId()
  {
    if (TextUtils.isEmpty(sCurMsfServerId))
    {
      SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("QCIRCLE_PLUGIN_SHARE", 0);
      if (localSharedPreferences != null) {
        sCurMsfServerId = localSharedPreferences.getString("qcircle_msf_server_id", "production");
      }
    }
    return sCurMsfServerId;
  }
  
  public static List<byte[]> getEeveeAttachInfos()
  {
    return sEeveeAttachInfos;
  }
  
  public static ArrayList<String> getExposedGuideFeedIdList()
  {
    return mExposedGuideFeedIdList;
  }
  
  public static String getVideoCoverTempPath()
  {
    return mVideoCoverTempPath;
  }
  
  public static boolean isCurrentTabActive()
  {
    return mCurrentQCircleTabIsActive;
  }
  
  public static boolean isLostUser()
  {
    return sIsLostUser;
  }
  
  public static void releaseWhenAccountChange() {}
  
  public static void setCurMsfServerId(String paramString)
  {
    sCurMsfServerId = paramString;
    if (!TextUtils.isEmpty(sCurMsfServerId))
    {
      paramString = MobileQQ.sMobileQQ.getSharedPreferences("QCIRCLE_PLUGIN_SHARE", 0);
      if (paramString != null) {
        paramString.edit().putString("qcircle_msf_server_id", sCurMsfServerId).apply();
      }
    }
  }
  
  public static void setCurrentTabActive(boolean paramBoolean)
  {
    mCurrentQCircleTabIsActive = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setCurrentIsActive:");
    localStringBuilder.append(paramBoolean);
    QLog.d("QCircleHostGlobalInfo", 4, localStringBuilder.toString());
  }
  
  public static void setEeveeAttachInfos(List<FeedCloudEeveeBase.StEeveeAttachInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      sEeveeAttachInfos.clear();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setEeveeAttachInfos size =");
      ((StringBuilder)localObject).append(paramList.size());
      QLog.d("QCircleHostGlobalInfo", 1, ((StringBuilder)localObject).toString());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (FeedCloudEeveeBase.StEeveeAttachInfo)paramList.next();
        sEeveeAttachInfos.add(((FeedCloudEeveeBase.StEeveeAttachInfo)localObject).toByteArray());
      }
    }
  }
  
  public static void setIsLostUser(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setIsLostUser ");
    localStringBuilder.append(paramBoolean);
    QLog.d("QCircleHostGlobalInfo", 1, localStringBuilder.toString());
    sIsLostUser = paramBoolean;
  }
  
  public static void setVideoCoverTempPath(String paramString)
  {
    mVideoCoverTempPath = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo
 * JD-Core Version:    0.7.0.1
 */