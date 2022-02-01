package com.tencent.qqmini.minigame.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.minigame.R.id;
import com.tencent.qqmini.minigame.R.layout;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MiniGameAdBannerPopup
{
  private static String APPID_BLACK_LIST;
  private static String APPID_WHITE_LIST;
  private static final String PREF_KEY_CURRENT_SHOW_TIMES = "pref_key_banner_ad_current_show_times";
  private static final String PREF_KEY_LAST_SHOW_TIME_MILLIS = "pref_key_banner_ad_popup_last_show_time_millis";
  private static String REFER_BLACK_LIST = WnsConfig.getConfig("qqminiapp", "banner_ad_popup_refer_black_list", "");
  private static String REFER_WHITE_LIST;
  private static int SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH = WnsConfig.getConfig("qqminiapp", "banner_ad_popup_show_delay_seconds_after_game_launch", 0);
  private static final String TAG = "MiniGameAdBannerPopup";
  private static final String WNS_KEY_APPID_BLACK_LIST = "banner_ad_popup_appid_black_list";
  private static final String WNS_KEY_APPID_WHITE_LIST = "banner_ad_popup_appid_white_list";
  private static final String WNS_KEY_REFER_BLACK_LIST = "banner_ad_popup_refer_black_list";
  private static final String WNS_KEY_REFER_WHITE_LIST = "banner_ad_popup_refer_white_list";
  private static final String WNS_KEY_SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH = "banner_ad_popup_show_delay_seconds_after_game_launch";
  
  static
  {
    APPID_WHITE_LIST = WnsConfig.getConfig("qqminiapp", "banner_ad_popup_appid_white_list", "");
    APPID_BLACK_LIST = WnsConfig.getConfig("qqminiapp", "banner_ad_popup_appid_black_list", "");
    REFER_WHITE_LIST = WnsConfig.getConfig("qqminiapp", "banner_ad_popup_refer_white_list", "");
  }
  
  private static boolean allowShowForAppId(String paramString)
  {
    try
    {
      if ((TextUtils.isEmpty(APPID_WHITE_LIST)) && (TextUtils.isEmpty(APPID_BLACK_LIST))) {
        return true;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("allowShowForAppId check if appid ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" in whitelist ");
      localStringBuilder.append(APPID_WHITE_LIST);
      localStringBuilder.append(" or blacklist ");
      localStringBuilder.append(APPID_BLACK_LIST);
      QMLog.d("MiniGameAdBannerPopup", localStringBuilder.toString());
      if (!TextUtils.isEmpty(APPID_WHITE_LIST)) {
        return checkWhiteList(paramString);
      }
      if (!TextUtils.isEmpty(APPID_BLACK_LIST))
      {
        boolean bool = checkBlackList(paramString);
        return bool;
      }
    }
    catch (Exception paramString)
    {
      QMLog.e("MiniGameAdBannerPopup", "allowShowForAppId", paramString);
    }
    return true;
  }
  
  private static boolean allowShowForRefer(int paramInt)
  {
    for (;;)
    {
      int i;
      try
      {
        if ((TextUtils.isEmpty(REFER_WHITE_LIST)) && (TextUtils.isEmpty(REFER_BLACK_LIST))) {
          return true;
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("allowShowForRefer check if scene ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(" in whitelist ");
        ((StringBuilder)localObject).append(REFER_WHITE_LIST);
        ((StringBuilder)localObject).append(" or blacklist ");
        ((StringBuilder)localObject).append(REFER_BLACK_LIST);
        QMLog.d("MiniGameAdBannerPopup", ((StringBuilder)localObject).toString());
        int j;
        if (!TextUtils.isEmpty(REFER_WHITE_LIST))
        {
          localObject = getWhiteListRefers();
          if (localObject == null) {
            break;
          }
          j = localObject.length;
          i = 0;
          if (i >= j) {
            break;
          }
          if (Integer.parseInt(localObject[i]) != paramInt) {
            break label198;
          }
          return true;
        }
        if (!TextUtils.isEmpty(REFER_BLACK_LIST))
        {
          localObject = getBlackListRefers();
          if (localObject != null)
          {
            j = localObject.length;
            i = 0;
            if (i < j)
            {
              int k = Integer.parseInt(localObject[i]);
              if (k == paramInt) {
                return false;
              }
              i += 1;
              continue;
            }
          }
          return true;
        }
      }
      catch (Exception localException)
      {
        QMLog.e("MiniGameAdBannerPopup", "allowShowForRefer", localException);
      }
      return true;
      label198:
      i += 1;
    }
    return false;
  }
  
  private static boolean checkBlackList(String paramString)
  {
    Object localObject = APPID_BLACK_LIST;
    String str = ",";
    if (((String)localObject).contains(","))
    {
      localObject = APPID_BLACK_LIST;
    }
    else
    {
      localObject = APPID_BLACK_LIST;
      str = ";";
    }
    localObject = ((String)localObject).split(str);
    if (localObject != null)
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        str = localObject[i];
        if ((str != null) && (str.equals(paramString))) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  public static void checkShouldShow(Context paramContext, String paramString, int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new MiniGameAdBannerPopup.1(paramContext, paramString, paramInt));
  }
  
  private static void checkShouldShowInternal(Context paramContext, String paramString, int paramInt)
  {
    if (paramContext != null)
    {
      if (paramString == null) {
        return;
      }
      Object localObject = new WeakReference(paramContext);
      if (!((ChannelProxy)ProxyManager.get(ChannelProxy.class)).tianshuRequestAdv(paramContext, paramString, paramInt, 258, 1, new MiniGameAdBannerPopup.2((WeakReference)localObject, paramString, paramInt)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("暂不支持在");
        ((StringBuilder)localObject).append(QUAUtil.getApplicationName(paramContext));
        ((StringBuilder)localObject).append("中请求广告弹窗");
        MiniToast.makeText(paramContext, 0, ((StringBuilder)localObject).toString(), 1);
        handleGetAdResult(paramContext, paramString, paramInt, false, null);
      }
    }
  }
  
  private static boolean checkWhiteList(String paramString)
  {
    Object localObject = APPID_WHITE_LIST;
    String str = ",";
    if (((String)localObject).contains(","))
    {
      localObject = APPID_WHITE_LIST;
    }
    else
    {
      localObject = APPID_WHITE_LIST;
      str = ";";
    }
    localObject = ((String)localObject).split(str);
    if (localObject != null)
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        str = localObject[i];
        if ((str != null) && (str.equals(paramString))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private static String[] getBlackListRefers()
  {
    String str1 = REFER_BLACK_LIST;
    String str2 = ",";
    if (str1.contains(","))
    {
      str1 = REFER_BLACK_LIST;
    }
    else
    {
      str1 = REFER_BLACK_LIST;
      str2 = ";";
    }
    return str1.split(str2);
  }
  
  private static String[] getWhiteListRefers()
  {
    String str1 = REFER_WHITE_LIST;
    String str2 = ",";
    if (str1.contains(","))
    {
      str1 = REFER_WHITE_LIST;
    }
    else
    {
      str1 = REFER_WHITE_LIST;
      str2 = ";";
    }
    return str1.split(str2);
  }
  
  private static void handleGetAdResult(Context paramContext, String paramString, int paramInt, boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    Object localObject9 = null;
    Object localObject5 = null;
    if ((paramBoolean) && (paramGetAdsRsp != null))
    {
      if (!paramGetAdsRsp.mapAds.isEmpty())
      {
        paramGetAdsRsp = (TianShuAccess.RspEntry)paramGetAdsRsp.mapAds.get(0);
        if ((paramGetAdsRsp != null) && (paramGetAdsRsp.value != null) && (!paramGetAdsRsp.value.lst.isEmpty()))
        {
          TianShuAccess.AdItem localAdItem = (TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0);
          if ((localAdItem != null) && (localAdItem.argList != null) && (!localAdItem.argList.isEmpty()))
          {
            Iterator localIterator = localAdItem.argList.get().iterator();
            localObject4 = null;
            localObject1 = localObject4;
            paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject1;
            for (;;)
            {
              localObject9 = localObject5;
              localObject8 = localObject4;
              localObject6 = localObject1;
              Object localObject2 = paramGetAdsRsp;
              localObject7 = localAdItem;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject2 = (TianShuAccess.MapEntry)localIterator.next();
              if ("type".equals(((TianShuAccess.MapEntry)localObject2).key.get())) {
                localObject5 = ((TianShuAccess.MapEntry)localObject2).value.get();
              } else if ("url".equals(((TianShuAccess.MapEntry)localObject2).key.get())) {
                localObject4 = ((TianShuAccess.MapEntry)localObject2).value.get();
              } else if ("text".equals(((TianShuAccess.MapEntry)localObject2).key.get())) {
                localObject1 = ((TianShuAccess.MapEntry)localObject2).value.get();
              } else if ("pic".equals(((TianShuAccess.MapEntry)localObject2).key.get())) {
                paramGetAdsRsp = ((TianShuAccess.MapEntry)localObject2).value.get();
              } else if ("appid_on".equals(((TianShuAccess.MapEntry)localObject2).key.get())) {
                APPID_WHITE_LIST = ((TianShuAccess.MapEntry)localObject2).value.get();
              } else if ("appid_off".equals(((TianShuAccess.MapEntry)localObject2).key.get())) {
                APPID_BLACK_LIST = ((TianShuAccess.MapEntry)localObject2).value.get();
              } else if ("refer_on".equals(((TianShuAccess.MapEntry)localObject2).key.get())) {
                REFER_WHITE_LIST = ((TianShuAccess.MapEntry)localObject2).value.get();
              } else if ("refer_off".equals(((TianShuAccess.MapEntry)localObject2).key.get())) {
                REFER_BLACK_LIST = ((TianShuAccess.MapEntry)localObject2).value.get();
              } else if (("show_time".equals(((TianShuAccess.MapEntry)localObject2).key.get())) && (!TextUtils.isEmpty(((TianShuAccess.MapEntry)localObject2).value.get()))) {
                try
                {
                  SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH = Integer.parseInt(((TianShuAccess.MapEntry)localObject2).value.get());
                }
                catch (Exception localException)
                {
                  QMLog.e("MiniGameAdBannerPopup", "handleGetAdResult", localException);
                }
              }
            }
          }
          QMLog.e("MiniGameAdBannerPopup", "onGetAdvs no ad item");
        }
        else
        {
          QMLog.e("MiniGameAdBannerPopup", "onGetAdvs no ad data");
        }
        localObject7 = null;
        Object localObject8 = localObject7;
        Object localObject6 = localObject8;
        localObject3 = localObject6;
        paramGetAdsRsp = localObject9;
        localObject1 = localObject8;
        localObject4 = localObject3;
        localObject3 = localObject6;
        break label579;
      }
    }
    else {
      QMLog.e("MiniGameAdBannerPopup", "onGetAdvs no ad result");
    }
    localObject5 = null;
    paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject5;
    Object localObject1 = paramGetAdsRsp;
    Object localObject3 = localObject1;
    Object localObject7 = localObject3;
    Object localObject4 = localObject3;
    localObject3 = localObject1;
    localObject1 = paramGetAdsRsp;
    paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject5;
    label579:
    localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append("handleGetAdResult appid whitelist ");
    ((StringBuilder)localObject5).append(APPID_WHITE_LIST);
    ((StringBuilder)localObject5).append("\n appid blacklist ");
    ((StringBuilder)localObject5).append(APPID_BLACK_LIST);
    ((StringBuilder)localObject5).append("\n refer whitelist ");
    ((StringBuilder)localObject5).append(REFER_WHITE_LIST);
    ((StringBuilder)localObject5).append("\n refer blacklist ");
    ((StringBuilder)localObject5).append(REFER_BLACK_LIST);
    ((StringBuilder)localObject5).append("\n show time ");
    ((StringBuilder)localObject5).append(SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH);
    QMLog.d("MiniGameAdBannerPopup", ((StringBuilder)localObject5).toString());
    showAdBanner(paramContext, paramString, paramInt, paramGetAdsRsp, (String)localObject1, localObject3, (String)localObject4, (TianShuAccess.AdItem)localObject7);
  }
  
  private static boolean isParamEmpty(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return (paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3));
  }
  
  private static void performReport(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new MiniGameAdBannerPopup.7(paramAdItem, paramString, paramInt));
  }
  
  private static void showAdBanner(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, TianShuAccess.AdItem paramAdItem)
  {
    if (!allowShowForAppId(paramString1))
    {
      paramContext = new StringBuilder();
      paramContext.append("handleGetAdResult not allow for appid ");
      paramContext.append(paramString1);
      QMLog.e("MiniGameAdBannerPopup", paramContext.toString());
      return;
    }
    if (!allowShowForRefer(paramInt))
    {
      paramContext = new StringBuilder();
      paramContext.append("handleGetAdResult not allow for refer ");
      paramContext.append(paramInt);
      QMLog.e("MiniGameAdBannerPopup", paramContext.toString());
      return;
    }
    if ((paramString2 != null) && (paramString3 != null) && (paramString4 != null) && (paramString5 != null) && (paramAdItem != null)) {
      ThreadManager.getUIHandler().postDelayed(new MiniGameAdBannerPopup.3(paramContext, paramString2, paramString4, paramString5, paramString3, paramAdItem), TimeUnit.SECONDS.toMillis(SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH));
    }
  }
  
  private static void showAdBannerPopupWindow(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, TianShuAccess.AdItem paramAdItem)
  {
    if (isParamEmpty(paramContext, paramString2, paramString3, paramString4)) {
      return;
    }
    if (!(paramContext instanceof Activity)) {
      return;
    }
    Object localObject1 = (Activity)paramContext;
    if (!((Activity)localObject1).isFinishing())
    {
      if ((Build.VERSION.SDK_INT >= 17) && (((Activity)localObject1).isDestroyed())) {
        return;
      }
      localObject1 = LayoutInflater.from(paramContext).inflate(R.layout.mini_sdk_ad_banner_popup_dialog, null);
      Object localObject2 = (TextView)((View)localObject1).findViewById(R.id.mini_sdk_ad_banner_popup_dialog_title);
      ReportDialog localReportDialog = new ReportDialog(paramContext);
      localReportDialog.setCancelable(false);
      if (localReportDialog.getWindow() != null)
      {
        localReportDialog.getWindow().requestFeature(1);
        localReportDialog.getWindow().setBackgroundDrawableResource(17170445);
      }
      localReportDialog.setContentView((View)localObject1, new ViewGroup.LayoutParams(-1, -1));
      localReportDialog.setOnShowListener(new MiniGameAdBannerPopup.4(paramAdItem, paramString1));
      ((ImageView)((View)localObject1).findViewById(R.id.mini_sdk_ad_banner_popup_dialog_close_button)).setOnClickListener(new MiniGameAdBannerPopup.5(localReportDialog, paramAdItem, paramString1));
      if (!TextUtils.isEmpty(paramString2)) {
        ((TextView)localObject2).setText(paramString2);
      }
      paramString2 = new MiniGameAdBannerPopup.BottomCornerURLImageView(paramContext);
      paramString2.setAdjustViewBounds(true);
      paramString2.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramString2.setClickable(true);
      localObject2 = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      paramString2.setImageDrawable(((MiniAppProxy)localObject2).getDrawable(paramContext, paramString3, 0, 0, null));
      paramString2.setOnClickListener(new MiniGameAdBannerPopup.6(localReportDialog, paramContext, paramString4, (MiniAppProxy)localObject2, paramAdItem, paramString1));
      paramContext = new LinearLayout.LayoutParams(-1, (int)TypedValue.applyDimension(1, 229.0F, paramContext.getResources().getDisplayMetrics()));
      paramContext.gravity = 1;
      ((LinearLayout)((View)localObject1).findViewById(R.id.mini_game_ad_banner_popup_dialog_content_layout)).addView(paramString2, paramContext);
      localReportDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.MiniGameAdBannerPopup
 * JD-Core Version:    0.7.0.1
 */