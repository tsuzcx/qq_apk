package com.tencent.mobileqq.vassplash.common;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.splashad.SplashADUtil;
import com.tencent.mobileqq.vassplash.model.SplashItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class VasSplashCacheManager
{
  public static ArrayList<SplashItem> a(QQAppInterface paramQQAppInterface, String paramString, List<SplashItem> paramList)
  {
    localArrayList = new ArrayList();
    try
    {
      SplashADUtil.a(paramQQAppInterface.getApp(), VasSplashUtil.e(paramString));
      Object localObject1 = VasSplashUtil.a(BaseApplicationImpl.getContext(), paramString);
      localArrayList.clear();
      try
      {
        paramList = paramList.iterator();
        Object localObject2;
        while (paramList.hasNext())
        {
          localObject2 = (SplashItem)paramList.next();
          if (localObject2 != null)
          {
            localArrayList.add(localObject2);
            if ((((SplashItem)localObject2).g == 3) || (((SplashItem)localObject2).g == 2)) {
              ((IMiniAppService)QRoute.api(IMiniAppService.class)).prePullAppinfoByLink(((SplashItem)localObject2).h, false, null);
            }
            VasSplashUtil.e.put(((SplashItem)localObject2).b, localObject2);
          }
        }
        if (localArrayList.size() > 0)
        {
          localObject1 = ((SharedPreferences)localObject1).edit();
          Object localObject3 = VasSplashUtil.b(BaseApplicationImpl.getContext(), paramString);
          paramList = new HashSet();
          localObject2 = new StringBuffer();
          Object localObject4 = localArrayList.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            SplashItem localSplashItem = (SplashItem)((Iterator)localObject4).next();
            String str = localSplashItem.b;
            paramList.add(str);
            ((StringBuffer)localObject2).append(str);
            ((StringBuffer)localObject2).append(",");
            ((StringBuffer)localObject2).append(localSplashItem.c);
            ((StringBuffer)localObject2).append(",");
            ((StringBuffer)localObject2).append(localSplashItem.d);
            ((StringBuffer)localObject2).append(",");
            if (((Set)localObject3).contains(str))
            {
              ((Set)localObject3).remove(str);
              a((SharedPreferences.Editor)localObject1, localSplashItem, false);
            }
            else
            {
              a((SharedPreferences.Editor)localObject1, localSplashItem, true);
            }
          }
          localObject3 = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
          ((SharedPreferences.Editor)localObject1).putString("splash_ad_ids", VasSplashUtil.a(paramList));
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("vas_splash_ad_ids_with_showdate_with_priority_");
          ((StringBuilder)localObject4).append(paramString);
          ((SharedPreferences.Editor)localObject3).putString(((StringBuilder)localObject4).toString(), ((StringBuffer)localObject2).substring(0, ((StringBuffer)localObject2).length() - 1));
          ((SharedPreferences.Editor)localObject1).apply();
          ((SharedPreferences.Editor)localObject3).apply();
          paramString = new StringBuilder();
          paramString.append("saveSplashInfoToSP : updateIds = ");
          paramString.append(paramList);
          QLog.i("QSplash@VasSplashCacheManager", 1, paramString.toString());
          VasSplashDownloadManager.a(paramQQAppInterface, localArrayList);
          return localArrayList;
        }
      }
      finally {}
      return localArrayList;
    }
    catch (Exception paramQQAppInterface)
    {
      paramString = new StringBuilder();
      paramString.append("saveSplashInfoToSP Exception: ");
      paramString.append(paramQQAppInterface);
      QLog.e("QSplash@VasSplashCacheManager", 1, paramString.toString());
    }
  }
  
  public static void a(SharedPreferences.Editor paramEditor, SplashItem paramSplashItem, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("vas_splash_ad_begin_time_");
    ((StringBuilder)localObject1).append(paramSplashItem.b);
    paramEditor.putString(((StringBuilder)localObject1).toString(), paramSplashItem.c);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("vas_splash_ad_end_time_");
    ((StringBuilder)localObject1).append(paramSplashItem.b);
    paramEditor.putString(((StringBuilder)localObject1).toString(), paramSplashItem.d);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("vas_plash_ad_content_type_");
    ((StringBuilder)localObject1).append(paramSplashItem.b);
    paramEditor.putInt(((StringBuilder)localObject1).toString(), paramSplashItem.e);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("vas_splash_ad_download_url_");
    ((StringBuilder)localObject1).append(paramSplashItem.b);
    paramEditor.putString(((StringBuilder)localObject1).toString(), paramSplashItem.f);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("vas_splash_ad_jumptype_");
    ((StringBuilder)localObject1).append(paramSplashItem.b);
    paramEditor.putInt(((StringBuilder)localObject1).toString(), paramSplashItem.g);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("vas_splash_ad_jump_h5_url_");
    ((StringBuilder)localObject1).append(paramSplashItem.b);
    paramEditor.putString(((StringBuilder)localObject1).toString(), paramSplashItem.h);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("vas_splash_ad_showpriority_");
    ((StringBuilder)localObject1).append(paramSplashItem.b);
    paramEditor.putInt(((StringBuilder)localObject1).toString(), paramSplashItem.m);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("vas_exposure_is_low_device_limit_");
    ((StringBuilder)localObject1).append(paramSplashItem.b);
    paramEditor.putBoolean(((StringBuilder)localObject1).toString(), paramSplashItem.q);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("vas_splash_ad_exposure_platform_");
    ((StringBuilder)localObject1).append(paramSplashItem.b);
    paramEditor.putInt(((StringBuilder)localObject1).toString(), paramSplashItem.i);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("vas_splash_info_report_");
    ((StringBuilder)localObject1).append(paramSplashItem.b);
    paramEditor.putString(((StringBuilder)localObject1).toString(), paramSplashItem.n);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("vas_splash_resource_md5_");
    ((StringBuilder)localObject1).append(paramSplashItem.b);
    paramEditor.putString(((StringBuilder)localObject1).toString(), paramSplashItem.o);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("vas_splash_should_show_ad_mark_");
    ((StringBuilder)localObject1).append(paramSplashItem.b);
    paramEditor.putInt(((StringBuilder)localObject1).toString(), paramSplashItem.p);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("vas_splash_union_banner_type_");
    ((StringBuilder)localObject1).append(paramSplashItem.b);
    paramEditor.putString(((StringBuilder)localObject1).toString(), paramSplashItem.s);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("vas_splash_ad_entry_text_");
    ((StringBuilder)localObject1).append(paramSplashItem.b);
    paramEditor.putString(((StringBuilder)localObject1).toString(), paramSplashItem.t);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("vas_splash_ad_entry_text_color_");
    ((StringBuilder)localObject1).append(paramSplashItem.b);
    paramEditor.putString(((StringBuilder)localObject1).toString(), paramSplashItem.u);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("vas_splash_ad_entry_text_bg_color_");
    ((StringBuilder)localObject1).append(paramSplashItem.b);
    paramEditor.putString(((StringBuilder)localObject1).toString(), paramSplashItem.v);
    Object localObject2 = paramSplashItem.j;
    localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (!((String)localObject2).startsWith("https")) {
        localObject1 = paramSplashItem.j.replaceFirst("http", "https");
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("vas_exposure_url_");
    ((StringBuilder)localObject2).append(paramSplashItem.b);
    paramEditor.putString(((StringBuilder)localObject2).toString(), (String)localObject1);
    localObject1 = paramSplashItem.k;
    paramBoolean = true;
    boolean bool = SplashItem.a((String)localObject1, true);
    if ((paramSplashItem.q) || (!bool) || (!paramSplashItem.d())) {
      paramBoolean = false;
    }
    paramSplashItem.r = paramBoolean;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("vas_splash_ad_is_limited_");
    ((StringBuilder)localObject1).append(paramSplashItem.b);
    paramEditor.putBoolean(((StringBuilder)localObject1).toString(), paramSplashItem.r);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("vas_splash_ad_entry_btn_type");
    ((StringBuilder)localObject1).append(paramSplashItem.b);
    paramEditor.putInt(((StringBuilder)localObject1).toString(), paramSplashItem.w);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("vas_splash_ad_entry_btn_url");
    ((StringBuilder)localObject1).append(paramSplashItem.b);
    paramEditor.putString(((StringBuilder)localObject1).toString(), paramSplashItem.x);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vassplash.common.VasSplashCacheManager
 * JD-Core Version:    0.7.0.1
 */