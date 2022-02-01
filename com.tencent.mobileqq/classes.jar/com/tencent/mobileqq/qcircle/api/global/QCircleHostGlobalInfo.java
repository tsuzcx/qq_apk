package com.tencent.mobileqq.qcircle.api.global;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.helper.QCircleChatBoxHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.cooperation.config.QCircleSpUtil;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudEeveeBase.StEeveeAttachInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class QCircleHostGlobalInfo
{
  public static final int QCIRCLE_INS_UI_TYPE = 1;
  public static final int QFS_NEW_LAYER_UI_TYPE_IN_DYNAMIC = 2;
  public static final int QFS_NEW_LAYER_UI_TYPE_IN_TAB = 3;
  private static final String TAG = "QCircleHostGlobalInfo";
  private static boolean isByShareOpenQCircle = false;
  private static boolean mCurrentQCircleTabIsActive = false;
  private static String mEntranceGuideTips;
  private static ArrayList<String> mExposedGuideFeedIdList = new ArrayList();
  private static int mFolderUIType = 1;
  private static final HashMap<String, Boolean> mHasShowEntranceGuideTipsMap;
  private static String mVideoCoverTempPath;
  private static String sCurMsfServerId = "";
  private static List<byte[]> sEeveeAttachInfos;
  private static boolean sIsLostUser = false;
  
  static
  {
    sEeveeAttachInfos = new ArrayList();
    mHasShowEntranceGuideTipsMap = new HashMap();
    mEntranceGuideTips = "";
  }
  
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
  
  public static boolean getByShareOpenQCircle()
  {
    return isByShareOpenQCircle;
  }
  
  public static String getCurMsfServerId()
  {
    if (TextUtils.isEmpty(sCurMsfServerId))
    {
      SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("RFW_COMMON_SHARE", 0);
      if (localSharedPreferences != null) {
        sCurMsfServerId = localSharedPreferences.getString("rfw_common_msf_server_id", "production");
      }
    }
    return sCurMsfServerId;
  }
  
  public static List<byte[]> getEeveeAttachInfos()
  {
    return sEeveeAttachInfos;
  }
  
  public static String getEntranceGuideTips()
  {
    String str2 = mEntranceGuideTips;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public static ArrayList<String> getExposedGuideFeedIdList()
  {
    return mExposedGuideFeedIdList;
  }
  
  public static int getFolderUIType()
  {
    return mFolderUIType;
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
  
  public static boolean needShowEntranceGuideTips()
  {
    Object localObject = ((IAccountRuntime)QRoute.api(IAccountRuntime.class)).getAccount();
    boolean bool1 = TextUtils.isEmpty((CharSequence)localObject);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    localObject = (Boolean)mHasShowEntranceGuideTipsMap.get(localObject);
    if ((localObject != null) && (((Boolean)localObject).booleanValue())) {
      return false;
    }
    boolean bool3 = ((Boolean)QCircleSpUtil.b("SP_KEY_HAS_SHOW_ENTRANCE_GUIDE_TIPS", Boolean.valueOf(false))).booleanValue();
    setHasShowEntranceGuideTips(bool3);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("needShowEntranceGuideTips  hasShowGuide = ");
    ((StringBuilder)localObject).append(bool3);
    ((StringBuilder)localObject).append(" getEntranceGuideTips() = ");
    ((StringBuilder)localObject).append(getEntranceGuideTips());
    QLog.d("QCircleHostGlobalInfo", 1, ((StringBuilder)localObject).toString());
    bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(getEntranceGuideTips())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void releaseWhenAccountChange() {}
  
  public static void setByShareOpenQCircle(boolean paramBoolean)
  {
    isByShareOpenQCircle = paramBoolean;
  }
  
  public static void setCurMsfServerId(String paramString)
  {
    sCurMsfServerId = paramString;
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
  
  public static void setEntranceGuideTips(String paramString)
  {
    mEntranceGuideTips = paramString;
  }
  
  public static void setFolderUIType(int paramInt)
  {
    mFolderUIType = paramInt;
  }
  
  public static void setHasShowEntranceGuideTips(boolean paramBoolean)
  {
    String str = ((IAccountRuntime)QRoute.api(IAccountRuntime.class)).getAccount();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    mHasShowEntranceGuideTipsMap.put(str, Boolean.valueOf(paramBoolean));
    QCircleSpUtil.a("SP_KEY_HAS_SHOW_ENTRANCE_GUIDE_TIPS", Boolean.valueOf(paramBoolean));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo
 * JD-Core Version:    0.7.0.1
 */