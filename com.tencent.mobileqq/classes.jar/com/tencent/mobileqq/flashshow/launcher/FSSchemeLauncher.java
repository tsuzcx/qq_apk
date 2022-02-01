package com.tencent.mobileqq.flashshow.launcher;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.flashshow.api.bean.FSFolderBean;
import com.tencent.mobileqq.flashshow.api.bean.FSLayerPageInitBean;
import com.tencent.mobileqq.flashshow.api.bean.FSPageListBean;
import com.tencent.mobileqq.flashshow.api.bean.FSPersonalDetailBean;
import com.tencent.mobileqq.flashshow.bean.FSSchemeBean;
import com.tencent.mobileqq.flashshow.report.datong.FSDaTongLoginReporter;
import com.tencent.mobileqq.jump.api.IJumpApi;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StIconInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.HashMap;

public class FSSchemeLauncher
{
  public static void a(Context paramContext, FSSchemeBean paramFSSchemeBean)
  {
    if (paramFSSchemeBean == null)
    {
      QLog.e("FSSchemeLauncher", 1, "launchByScheme error because bean is null");
      return;
    }
    if (TextUtils.isEmpty(paramFSSchemeBean.getSchemeAction()))
    {
      QLog.e("FSSchemeLauncher", 1, "launchByScheme error because action is empty");
      return;
    }
    String str = paramFSSchemeBean.getSchemeAction();
    paramFSSchemeBean = paramFSSchemeBean.getAttrs();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("launchFlashShowByScheme actionName");
    localStringBuilder.append(str);
    QLog.d("FSSchemeLauncher", 1, localStringBuilder.toString());
    FSDaTongLoginReporter.a(paramFSSchemeBean);
    if ("openfolder".equals(str))
    {
      a(paramContext, paramFSSchemeBean);
      return;
    }
    if ("openlayerpage".equals(str))
    {
      b(paramContext, paramFSSchemeBean);
      return;
    }
    if ("openmainpage".equals(str))
    {
      c(paramContext, paramFSSchemeBean);
      return;
    }
    if ("opennoticelist".equals(str)) {
      d(paramContext, paramFSSchemeBean);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    ((IJumpApi)QRoute.api(IJumpApi.class)).doJumpAction(paramContext, paramString);
  }
  
  private static void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    FSFolderBean localFSFolderBean = new FSFolderBean(null);
    localFSFolderBean.setAttrs(paramHashMap);
    FSNativeLauncher.a(paramContext, localFSFolderBean);
  }
  
  private static void b(Context paramContext, HashMap<String, String> paramHashMap)
  {
    FSLayerPageInitBean localFSLayerPageInitBean = new FSLayerPageInitBean(null);
    if (paramHashMap.containsKey("uin")) {
      localFSLayerPageInitBean.setUserId((String)paramHashMap.get("uin"));
    }
    if (paramHashMap.containsKey("feedid")) {
      localFSLayerPageInitBean.setFeedId((String)paramHashMap.get("feedid"));
    }
    if (paramHashMap.containsKey("createtime"))
    {
      paramHashMap = (String)paramHashMap.get("createtime");
      long l1 = 0L;
      try
      {
        long l2 = Long.parseLong(paramHashMap);
        l1 = l2;
      }
      catch (NumberFormatException paramHashMap)
      {
        paramHashMap.printStackTrace();
      }
      localFSLayerPageInitBean.setCreateTime(l1);
    }
    localFSLayerPageInitBean.setSourceType(2);
    FSNativeLauncher.a(paramContext, localFSLayerPageInitBean);
  }
  
  private static void c(Context paramContext, HashMap<String, String> paramHashMap)
  {
    FSPersonalDetailBean localFSPersonalDetailBean = new FSPersonalDetailBean(null);
    if (paramHashMap.containsKey("uin"))
    {
      Object localObject1 = (String)paramHashMap.get("uin");
      String str2 = (String)paramHashMap.get("nick");
      String str1 = (String)paramHashMap.get("icon_url");
      paramHashMap = (String)paramHashMap.get("followstate");
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("uin = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("nick = ");
      ((StringBuilder)localObject2).append(str2);
      ((StringBuilder)localObject2).append("icon_url = ");
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append("followstate");
      ((StringBuilder)localObject2).append(paramHashMap);
      QLog.i("FSSchemeLauncher", 1, ((StringBuilder)localObject2).toString());
      localObject2 = new FeedCloudMeta.StUser();
      if (localObject1 != null) {
        ((FeedCloudMeta.StUser)localObject2).id.set((String)localObject1);
      }
      if (str2 != null) {
        ((FeedCloudMeta.StUser)localObject2).nick.set(str2);
      }
      if (str1 != null)
      {
        localObject1 = new FeedCloudMeta.StIconInfo();
        ((FeedCloudMeta.StIconInfo)localObject1).iconUrl.set(str1);
        ((FeedCloudMeta.StUser)localObject2).icon.set((MessageMicro)localObject1);
      }
      if (paramHashMap != null) {
        try
        {
          ((FeedCloudMeta.StUser)localObject2).followState.set(Integer.parseInt(paramHashMap));
        }
        catch (Exception paramHashMap)
        {
          QLog.i("FSSchemeLauncher", 1, paramHashMap.getMessage());
        }
      }
      localFSPersonalDetailBean.setUser((FeedCloudMeta.StUser)localObject2);
    }
    FSNativeLauncher.a(paramContext, localFSPersonalDetailBean);
  }
  
  private static void d(Context paramContext, HashMap<String, String> paramHashMap)
  {
    FSPageListBean localFSPageListBean = new FSPageListBean(null);
    if ((paramHashMap != null) && (paramHashMap.containsKey("to")))
    {
      paramHashMap = (String)paramHashMap.get("to");
      try
      {
        if (!TextUtils.isEmpty(paramHashMap)) {
          localFSPageListBean.setLaunchTo(Integer.parseInt(paramHashMap));
        }
      }
      catch (NumberFormatException paramHashMap)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("launchMessageNoticePage parseNumError:");
        localStringBuilder.append(paramHashMap.getMessage());
        QLog.d("FSSchemeLauncher", 1, localStringBuilder.toString());
      }
    }
    FSNativeLauncher.a(paramContext, localFSPageListBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.launcher.FSSchemeLauncher
 * JD-Core Version:    0.7.0.1
 */