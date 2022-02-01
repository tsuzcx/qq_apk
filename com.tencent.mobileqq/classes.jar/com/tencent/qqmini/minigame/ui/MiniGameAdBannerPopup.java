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
    for (;;)
    {
      int i;
      try
      {
        if ((TextUtils.isEmpty(APPID_WHITE_LIST)) && (TextUtils.isEmpty(APPID_BLACK_LIST))) {
          return true;
        }
        QMLog.d("MiniGameAdBannerPopup", "allowShowForAppId check if appid " + paramString + " in whitelist " + APPID_WHITE_LIST + " or blacklist " + APPID_BLACK_LIST);
        String[] arrayOfString;
        int j;
        String str;
        if (!TextUtils.isEmpty(APPID_WHITE_LIST))
        {
          if (APPID_WHITE_LIST.contains(","))
          {
            arrayOfString = APPID_WHITE_LIST.split(",");
            if (arrayOfString == null) {
              break;
            }
            j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              break;
            }
            str = arrayOfString[i];
            if (str == null) {
              break label237;
            }
            if (!str.equals(paramString)) {
              break label237;
            }
          }
          else
          {
            arrayOfString = APPID_WHITE_LIST.split(";");
            continue;
          }
        }
        else if (!TextUtils.isEmpty(APPID_BLACK_LIST))
        {
          if (APPID_BLACK_LIST.contains(","))
          {
            arrayOfString = APPID_BLACK_LIST.split(",");
            if (arrayOfString == null) {
              break label235;
            }
            j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              break label235;
            }
            str = arrayOfString[i];
            if ((str != null) && (str.equals(paramString))) {
              return false;
            }
          }
          else
          {
            arrayOfString = APPID_BLACK_LIST.split(";");
            continue;
          }
          i += 1;
          continue;
        }
        return true;
      }
      catch (Exception paramString)
      {
        QMLog.e("MiniGameAdBannerPopup", "allowShowForAppId", paramString);
      }
      label235:
      label237:
      i += 1;
    }
    return false;
  }
  
  private static boolean allowShowForRefer(int paramInt)
  {
    try
    {
      if ((TextUtils.isEmpty(REFER_WHITE_LIST)) && (TextUtils.isEmpty(REFER_BLACK_LIST))) {
        return true;
      }
      QMLog.d("MiniGameAdBannerPopup", "allowShowForRefer check if scene " + paramInt + " in whitelist " + REFER_WHITE_LIST + " or blacklist " + REFER_BLACK_LIST);
      String[] arrayOfString;
      int j;
      int i;
      if (!TextUtils.isEmpty(REFER_WHITE_LIST))
      {
        if (REFER_WHITE_LIST.contains(",")) {}
        for (arrayOfString = REFER_WHITE_LIST.split(",");; arrayOfString = REFER_WHITE_LIST.split(";"))
        {
          if (arrayOfString == null) {
            break label223;
          }
          j = arrayOfString.length;
          i = 0;
          for (;;)
          {
            if (i >= j) {
              break label223;
            }
            if (Integer.parseInt(arrayOfString[i]) == paramInt) {
              break;
            }
            i += 1;
          }
        }
      }
      if (!TextUtils.isEmpty(REFER_BLACK_LIST)) {
        if (REFER_BLACK_LIST.contains(","))
        {
          arrayOfString = REFER_BLACK_LIST.split(",");
          if (arrayOfString != null)
          {
            j = arrayOfString.length;
            i = 0;
          }
        }
        else
        {
          for (;;)
          {
            if (i >= j) {
              break label221;
            }
            if (Integer.parseInt(arrayOfString[i]) == paramInt)
            {
              return false;
              arrayOfString = REFER_BLACK_LIST.split(";");
              break;
            }
            i += 1;
          }
        }
      }
      return true;
    }
    catch (Exception localException)
    {
      QMLog.e("MiniGameAdBannerPopup", "allowShowForRefer", localException);
    }
    label221:
    label223:
    return false;
  }
  
  public static void checkShouldShow(Context paramContext, String paramString, int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new MiniGameAdBannerPopup.1(paramContext, paramString, paramInt));
  }
  
  private static void checkShouldShowInternal(Context paramContext, String paramString, int paramInt)
  {
    if ((paramContext == null) || (paramString == null)) {}
    WeakReference localWeakReference;
    do
    {
      return;
      localWeakReference = new WeakReference(paramContext);
    } while (((ChannelProxy)ProxyManager.get(ChannelProxy.class)).tianshuRequestAdv(paramContext, paramString, paramInt, 258, 1, new MiniGameAdBannerPopup.2(localWeakReference, paramString, paramInt)));
    MiniToast.makeText(paramContext, 0, "暂不支持在" + QUAUtil.getApplicationName(paramContext) + "中请求广告弹窗", 1);
    handleGetAdResult(paramContext, paramString, paramInt, false, null);
  }
  
  private static void handleGetAdResult(Context paramContext, String paramString, int paramInt, boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    Object localObject8 = null;
    Object localObject3 = null;
    Object localObject2;
    Object localObject1;
    Object localObject6;
    Object localObject5;
    if ((paramBoolean) && (paramGetAdsRsp != null))
    {
      if (paramGetAdsRsp.mapAds.isEmpty()) {
        break label884;
      }
      paramGetAdsRsp = (TianShuAccess.RspEntry)paramGetAdsRsp.mapAds.get(0);
      if ((paramGetAdsRsp != null) && (paramGetAdsRsp.value != null) && (!paramGetAdsRsp.value.lst.isEmpty()))
      {
        TianShuAccess.AdItem localAdItem2 = (TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0);
        TianShuAccess.AdItem localAdItem1;
        Object localObject7;
        if ((localAdItem2 != null) && (localAdItem2.argList != null) && (!localAdItem2.argList.isEmpty()))
        {
          Iterator localIterator = localAdItem2.argList.get().iterator();
          localObject2 = null;
          localObject1 = null;
          paramGetAdsRsp = null;
          localAdItem1 = localAdItem2;
          localObject8 = localObject3;
          localObject7 = localObject2;
          Object localObject4 = localObject1;
          localObject6 = paramGetAdsRsp;
          if (localIterator.hasNext())
          {
            localObject4 = (TianShuAccess.MapEntry)localIterator.next();
            if ("type".equals(((TianShuAccess.MapEntry)localObject4).key.get()))
            {
              localObject4 = ((TianShuAccess.MapEntry)localObject4).value.get();
              paramGetAdsRsp = localObject2;
              localObject2 = localObject4;
              localObject4 = localObject3;
              localObject3 = localObject2;
              localObject2 = localObject1;
              localObject1 = paramGetAdsRsp;
              paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject4;
            }
            for (;;)
            {
              localObject4 = localObject3;
              localObject6 = localObject2;
              localObject3 = paramGetAdsRsp;
              localObject2 = localObject1;
              localObject1 = localObject6;
              paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject4;
              break;
              if ("url".equals(((TianShuAccess.MapEntry)localObject4).key.get()))
              {
                localObject6 = ((TianShuAccess.MapEntry)localObject4).value.get();
                localObject4 = paramGetAdsRsp;
                paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject3;
                localObject1 = localObject2;
                localObject2 = localObject6;
                localObject3 = localObject4;
              }
              else if ("text".equals(((TianShuAccess.MapEntry)localObject4).key.get()))
              {
                localObject6 = ((TianShuAccess.MapEntry)localObject4).value.get();
                localObject2 = localObject1;
                localObject4 = paramGetAdsRsp;
                localObject1 = localObject6;
                paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject3;
                localObject3 = localObject4;
              }
              else if ("pic".equals(((TianShuAccess.MapEntry)localObject4).key.get()))
              {
                localObject6 = ((TianShuAccess.MapEntry)localObject4).value.get();
                localObject3 = localObject1;
                localObject4 = paramGetAdsRsp;
                paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject6;
                localObject1 = localObject2;
                localObject2 = localObject3;
                localObject3 = localObject4;
              }
              else if ("appid_on".equals(((TianShuAccess.MapEntry)localObject4).key.get()))
              {
                APPID_WHITE_LIST = ((TianShuAccess.MapEntry)localObject4).value.get();
                localObject4 = localObject1;
                localObject6 = paramGetAdsRsp;
                paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject3;
                localObject1 = localObject2;
                localObject2 = localObject4;
                localObject3 = localObject6;
              }
              else if ("appid_off".equals(((TianShuAccess.MapEntry)localObject4).key.get()))
              {
                APPID_BLACK_LIST = ((TianShuAccess.MapEntry)localObject4).value.get();
                localObject4 = localObject1;
                localObject6 = paramGetAdsRsp;
                paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject3;
                localObject1 = localObject2;
                localObject2 = localObject4;
                localObject3 = localObject6;
              }
              else if ("refer_on".equals(((TianShuAccess.MapEntry)localObject4).key.get()))
              {
                REFER_WHITE_LIST = ((TianShuAccess.MapEntry)localObject4).value.get();
                localObject4 = localObject1;
                localObject6 = paramGetAdsRsp;
                paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject3;
                localObject1 = localObject2;
                localObject2 = localObject4;
                localObject3 = localObject6;
              }
              else if ("refer_off".equals(((TianShuAccess.MapEntry)localObject4).key.get()))
              {
                REFER_BLACK_LIST = ((TianShuAccess.MapEntry)localObject4).value.get();
                localObject4 = localObject1;
                localObject6 = paramGetAdsRsp;
                paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject3;
                localObject1 = localObject2;
                localObject2 = localObject4;
                localObject3 = localObject6;
              }
              else if (("show_time".equals(((TianShuAccess.MapEntry)localObject4).key.get())) && (!TextUtils.isEmpty(((TianShuAccess.MapEntry)localObject4).value.get())))
              {
                try
                {
                  SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH = Integer.parseInt(((TianShuAccess.MapEntry)localObject4).value.get());
                  localObject4 = localObject1;
                  localObject6 = paramGetAdsRsp;
                  paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject3;
                  localObject1 = localObject2;
                  localObject2 = localObject4;
                  localObject3 = localObject6;
                }
                catch (Exception localException)
                {
                  QMLog.e("MiniGameAdBannerPopup", "handleGetAdResult", localException);
                }
              }
              else
              {
                localObject5 = localObject1;
                localObject6 = paramGetAdsRsp;
                paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject3;
                localObject1 = localObject2;
                localObject2 = localObject5;
                localObject3 = localObject6;
              }
            }
          }
        }
        else
        {
          QMLog.e("MiniGameAdBannerPopup", "onGetAdvs no ad item");
          localAdItem1 = null;
          localObject7 = null;
          localObject5 = null;
          localObject6 = null;
        }
        localObject2 = localAdItem1;
        localObject1 = localObject8;
        paramGetAdsRsp = localObject7;
      }
    }
    for (;;)
    {
      QMLog.d("MiniGameAdBannerPopup", "handleGetAdResult appid whitelist " + APPID_WHITE_LIST + "\n appid blacklist " + APPID_BLACK_LIST + "\n refer whitelist " + REFER_WHITE_LIST + "\n refer blacklist " + REFER_BLACK_LIST + "\n show time " + SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH);
      showAdBanner(paramContext, paramString, paramInt, (String)localObject6, localObject5, paramGetAdsRsp, (String)localObject1, localObject2);
      return;
      QMLog.e("MiniGameAdBannerPopup", "onGetAdvs no ad data");
      break;
      QMLog.e("MiniGameAdBannerPopup", "onGetAdvs no ad result");
      label884:
      localObject2 = null;
      localObject1 = null;
      paramGetAdsRsp = null;
      localObject5 = null;
      localObject6 = null;
    }
  }
  
  private static void performReport(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new MiniGameAdBannerPopup.7(paramAdItem, paramString, paramInt));
  }
  
  private static void showAdBanner(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, TianShuAccess.AdItem paramAdItem)
  {
    if (!allowShowForAppId(paramString1)) {
      QMLog.e("MiniGameAdBannerPopup", "handleGetAdResult not allow for appid " + paramString1);
    }
    do
    {
      return;
      if (!allowShowForRefer(paramInt))
      {
        QMLog.e("MiniGameAdBannerPopup", "handleGetAdResult not allow for refer " + paramInt);
        return;
      }
    } while ((paramString2 == null) || (paramString3 == null) || (paramString4 == null) || (paramString5 == null) || (paramAdItem == null));
    ThreadManager.getUIHandler().postDelayed(new MiniGameAdBannerPopup.3(paramContext, paramString2, paramString4, paramString5, paramString3, paramAdItem), TimeUnit.SECONDS.toMillis(SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH));
  }
  
  private static void showAdBannerPopupWindow(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, TianShuAccess.AdItem paramAdItem)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString4))) {}
    do
    {
      do
      {
        return;
      } while (!(paramContext instanceof Activity));
      localObject1 = (Activity)paramContext;
    } while ((((Activity)localObject1).isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (((Activity)localObject1).isDestroyed())));
    Object localObject2 = LayoutInflater.from(paramContext).inflate(R.layout.mini_sdk_ad_banner_popup_dialog, null);
    ImageView localImageView = (ImageView)((View)localObject2).findViewById(R.id.mini_sdk_ad_banner_popup_dialog_close_button);
    TextView localTextView = (TextView)((View)localObject2).findViewById(R.id.mini_sdk_ad_banner_popup_dialog_title);
    Object localObject1 = (LinearLayout)((View)localObject2).findViewById(R.id.mini_game_ad_banner_popup_dialog_content_layout);
    ReportDialog localReportDialog = new ReportDialog(paramContext);
    localReportDialog.setCancelable(false);
    if (localReportDialog.getWindow() != null)
    {
      localReportDialog.getWindow().requestFeature(1);
      localReportDialog.getWindow().setBackgroundDrawableResource(17170445);
    }
    localReportDialog.setContentView((View)localObject2, new ViewGroup.LayoutParams(-1, -1));
    localReportDialog.setOnShowListener(new MiniGameAdBannerPopup.4(paramAdItem, paramString1));
    localImageView.setOnClickListener(new MiniGameAdBannerPopup.5(localReportDialog, paramAdItem, paramString1));
    if (!TextUtils.isEmpty(paramString2)) {
      localTextView.setText(paramString2);
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
    ((LinearLayout)localObject1).addView(paramString2, paramContext);
    localReportDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.MiniGameAdBannerPopup
 * JD-Core Version:    0.7.0.1
 */