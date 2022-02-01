package com.tencent.mobileqq.minigame.ui;

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
import bjjo;
import bnwo;
import bnwq;
import bnwr;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import common.config.service.QzoneConfig;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

public class MiniGameAdBannerPopup
{
  private static String APPID_BLACK_LIST;
  private static String APPID_WHITE_LIST;
  private static MiniGameAdBannerPopup.GetAdCallback GET_AD_CALLBACK;
  private static final String PREF_KEY_CURRENT_SHOW_TIMES = "pref_key_banner_ad_current_show_times";
  private static final String PREF_KEY_LAST_SHOW_TIME_MILLIS = "pref_key_banner_ad_popup_last_show_time_millis";
  private static String REFER_BLACK_LIST = QzoneConfig.getInstance().getConfig("qqminiapp", "banner_ad_popup_refer_black_list", "");
  private static String REFER_WHITE_LIST;
  private static int SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH = QzoneConfig.getInstance().getConfig("qqminiapp", "banner_ad_popup_show_delay_seconds_after_game_launch", 0);
  private static final String TAG = "MiniGameAdBannerPopup";
  private static final String WNS_KEY_APPID_BLACK_LIST = "banner_ad_popup_appid_black_list";
  private static final String WNS_KEY_APPID_WHITE_LIST = "banner_ad_popup_appid_white_list";
  private static final String WNS_KEY_REFER_BLACK_LIST = "banner_ad_popup_refer_black_list";
  private static final String WNS_KEY_REFER_WHITE_LIST = "banner_ad_popup_refer_white_list";
  private static final String WNS_KEY_SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH = "banner_ad_popup_show_delay_seconds_after_game_launch";
  
  static
  {
    APPID_WHITE_LIST = QzoneConfig.getInstance().getConfig("qqminiapp", "banner_ad_popup_appid_white_list", "");
    APPID_BLACK_LIST = QzoneConfig.getInstance().getConfig("qqminiapp", "banner_ad_popup_appid_black_list", "");
    REFER_WHITE_LIST = QzoneConfig.getInstance().getConfig("qqminiapp", "banner_ad_popup_refer_white_list", "");
  }
  
  private static boolean allowShowForAppId(MiniAppConfig paramMiniAppConfig)
  {
    for (;;)
    {
      int i;
      try
      {
        if ((TextUtils.isEmpty(APPID_WHITE_LIST)) && (TextUtils.isEmpty(APPID_BLACK_LIST))) {
          return true;
        }
        if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null))
        {
          QLog.d("MiniGameAdBannerPopup", 1, new Object[] { "allowShowForAppId", " check if appid " + paramMiniAppConfig.config.appId + " in whitelist " + APPID_WHITE_LIST + " or blacklist " + APPID_BLACK_LIST });
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
                break label280;
              }
              if (!str.equals(paramMiniAppConfig.config.appId)) {
                break label280;
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
                break label278;
              }
              j = arrayOfString.length;
              i = 0;
              if (i >= j) {
                break label278;
              }
              str = arrayOfString[i];
              if ((str != null) && (str.equals(paramMiniAppConfig.config.appId))) {
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
        }
        return true;
      }
      catch (Exception paramMiniAppConfig)
      {
        QLog.e("MiniGameAdBannerPopup", 1, "allowShowForAppId", paramMiniAppConfig);
      }
      label278:
      label280:
      i += 1;
    }
    return false;
  }
  
  private static boolean allowShowForRefer(MiniAppConfig paramMiniAppConfig)
  {
    try
    {
      if ((TextUtils.isEmpty(REFER_WHITE_LIST)) && (TextUtils.isEmpty(REFER_BLACK_LIST))) {
        return true;
      }
      if ((paramMiniAppConfig != null) && (paramMiniAppConfig.launchParam != null))
      {
        QLog.d("MiniGameAdBannerPopup", 1, new Object[] { "allowShowForRefer", " check if scene " + paramMiniAppConfig.launchParam.scene + " in whitelist " + REFER_WHITE_LIST + " or blacklist " + REFER_BLACK_LIST });
        String[] arrayOfString;
        int j;
        int i;
        if (!TextUtils.isEmpty(REFER_WHITE_LIST))
        {
          if (REFER_WHITE_LIST.contains(",")) {}
          for (arrayOfString = REFER_WHITE_LIST.split(",");; arrayOfString = REFER_WHITE_LIST.split(";"))
          {
            if (arrayOfString == null) {
              break label266;
            }
            j = arrayOfString.length;
            i = 0;
            for (;;)
            {
              if (i >= j) {
                break label266;
              }
              if (Integer.parseInt(arrayOfString[i]) == paramMiniAppConfig.launchParam.scene) {
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
                break label264;
              }
              if (Integer.parseInt(arrayOfString[i]) == paramMiniAppConfig.launchParam.scene)
              {
                return false;
                arrayOfString = REFER_BLACK_LIST.split(";");
                break;
              }
              i += 1;
            }
          }
        }
      }
      return true;
    }
    catch (Exception paramMiniAppConfig)
    {
      QLog.e("MiniGameAdBannerPopup", 1, "allowShowForRefer", paramMiniAppConfig);
    }
    label264:
    label266:
    return false;
  }
  
  public static void checkShouldShow(Context paramContext, MiniAppConfig paramMiniAppConfig)
  {
    ThreadManagerV2.executeOnSubThread(new MiniGameAdBannerPopup.1(paramContext, paramMiniAppConfig));
  }
  
  private static void checkShouldShowInternal(Context paramContext, MiniAppConfig paramMiniAppConfig)
  {
    if ((paramContext == null) || (paramMiniAppConfig == null) || (!paramMiniAppConfig.isEngineTypeMiniGame())) {
      return;
    }
    try
    {
      bnwo localbnwo = new bnwo();
      localbnwo.jdField_a_of_type_Int = 258;
      localbnwo.b = 1;
      GET_AD_CALLBACK = new MiniGameAdBannerPopup.GetAdCallback(paramContext, paramMiniAppConfig);
      bnwq.a().a(Collections.singletonList(localbnwo), GET_AD_CALLBACK);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("MiniGameAdBannerPopup", 1, "requestAdBannerPopupInfo", paramContext);
    }
  }
  
  private static void handleGetAdResult(Context paramContext, MiniAppConfig paramMiniAppConfig, boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    Object localObject6 = null;
    Object localObject9 = null;
    Object localObject1 = null;
    Object localObject7 = null;
    Iterator localIterator = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject8 = null;
    Object localObject2 = null;
    Object localObject5;
    if ((paramBoolean) && (paramGetAdsRsp != null))
    {
      if (paramGetAdsRsp.mapAds.isEmpty()) {
        break label969;
      }
      paramGetAdsRsp = (TianShuAccess.RspEntry)paramGetAdsRsp.mapAds.get(0);
      if ((paramGetAdsRsp != null) && (paramGetAdsRsp.value != null) && (!paramGetAdsRsp.value.lst.isEmpty()))
      {
        TianShuAccess.AdItem localAdItem = (TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0);
        if ((localAdItem != null) && (localAdItem.argList != null) && (!localAdItem.argList.isEmpty()))
        {
          localIterator = localAdItem.argList.get().iterator();
          paramGetAdsRsp = localObject9;
          localObject1 = localObject7;
          if (localIterator.hasNext())
          {
            localObject4 = (TianShuAccess.MapEntry)localIterator.next();
            if ("type".equals(((TianShuAccess.MapEntry)localObject4).key.get()))
            {
              localObject4 = ((TianShuAccess.MapEntry)localObject4).value.get();
              paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject3;
              localObject3 = localObject4;
              localObject4 = localObject2;
              localObject2 = localObject1;
              localObject1 = paramGetAdsRsp;
              paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject4;
            }
            for (;;)
            {
              localObject4 = localObject3;
              localObject6 = localObject2;
              localObject2 = paramGetAdsRsp;
              localObject3 = localObject1;
              localObject1 = localObject6;
              paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject4;
              break;
              if ("url".equals(((TianShuAccess.MapEntry)localObject4).key.get()))
              {
                localObject6 = ((TianShuAccess.MapEntry)localObject4).value.get();
                localObject4 = paramGetAdsRsp;
                paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject2;
                localObject1 = localObject3;
                localObject2 = localObject6;
                localObject3 = localObject4;
              }
              else if ("text".equals(((TianShuAccess.MapEntry)localObject4).key.get()))
              {
                localObject6 = ((TianShuAccess.MapEntry)localObject4).value.get();
                localObject3 = localObject1;
                localObject4 = paramGetAdsRsp;
                localObject1 = localObject6;
                paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject2;
                localObject2 = localObject3;
                localObject3 = localObject4;
              }
              else if ("pic".equals(((TianShuAccess.MapEntry)localObject4).key.get()))
              {
                localObject6 = ((TianShuAccess.MapEntry)localObject4).value.get();
                localObject2 = localObject1;
                localObject4 = paramGetAdsRsp;
                paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject6;
                localObject1 = localObject3;
                localObject3 = localObject4;
              }
              else if ("appid_on".equals(((TianShuAccess.MapEntry)localObject4).key.get()))
              {
                APPID_WHITE_LIST = ((TianShuAccess.MapEntry)localObject4).value.get();
                localObject4 = localObject1;
                localObject6 = paramGetAdsRsp;
                paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject2;
                localObject1 = localObject3;
                localObject2 = localObject4;
                localObject3 = localObject6;
              }
              else if ("appid_off".equals(((TianShuAccess.MapEntry)localObject4).key.get()))
              {
                APPID_BLACK_LIST = ((TianShuAccess.MapEntry)localObject4).value.get();
                localObject4 = localObject1;
                localObject6 = paramGetAdsRsp;
                paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject2;
                localObject1 = localObject3;
                localObject2 = localObject4;
                localObject3 = localObject6;
              }
              else if ("refer_on".equals(((TianShuAccess.MapEntry)localObject4).key.get()))
              {
                REFER_WHITE_LIST = ((TianShuAccess.MapEntry)localObject4).value.get();
                localObject4 = localObject1;
                localObject6 = paramGetAdsRsp;
                paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject2;
                localObject1 = localObject3;
                localObject2 = localObject4;
                localObject3 = localObject6;
              }
              else if ("refer_off".equals(((TianShuAccess.MapEntry)localObject4).key.get()))
              {
                REFER_BLACK_LIST = ((TianShuAccess.MapEntry)localObject4).value.get();
                localObject4 = localObject1;
                localObject6 = paramGetAdsRsp;
                paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject2;
                localObject1 = localObject3;
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
                  paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject2;
                  localObject1 = localObject3;
                  localObject2 = localObject4;
                  localObject3 = localObject6;
                }
                catch (Exception localException)
                {
                  QLog.e("MiniGameAdBannerPopup", 1, "handleGetAdResult", localException);
                }
              }
              else
              {
                localObject5 = localObject1;
                localObject6 = paramGetAdsRsp;
                paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject2;
                localObject1 = localObject3;
                localObject2 = localObject5;
                localObject3 = localObject6;
              }
            }
          }
          bnwq.a().a(localAdItem);
          localObject5 = localAdItem;
          localObject6 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject6;
          label730:
          QLog.d("MiniGameAdBannerPopup", 1, new Object[] { "handleGetAdResult", " appid whitelist " + APPID_WHITE_LIST + "\n appid blacklist " + APPID_BLACK_LIST + "\n refer whitelist " + REFER_WHITE_LIST + "\n refer blacklist " + REFER_BLACK_LIST + "\n show time " + SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH });
          if (allowShowForAppId(paramMiniAppConfig)) {
            break label991;
          }
          if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null)) {
            QLog.e("MiniGameAdBannerPopup", 1, new Object[] { "handleGetAdResult", " not allow for appid " + paramMiniAppConfig.config.appId });
          }
        }
      }
    }
    label969:
    label991:
    do
    {
      do
      {
        return;
        QLog.e("MiniGameAdBannerPopup", 1, new Object[] { "onGetAdvs", " no ad item" });
        for (;;)
        {
          localObject5 = null;
          localObject2 = localObject8;
          localObject3 = localIterator;
          paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject6;
          break;
          QLog.e("MiniGameAdBannerPopup", 1, new Object[] { "onGetAdvs", " no ad data" });
        }
        QLog.e("MiniGameAdBannerPopup", 1, new Object[] { "onGetAdvs", " no ad result" });
        localObject6 = null;
        paramGetAdsRsp = null;
        localObject2 = null;
        localObject1 = null;
        localObject3 = localObject5;
        localObject5 = localObject6;
        break label730;
        if (allowShowForRefer(paramMiniAppConfig)) {
          break label1055;
        }
      } while ((paramMiniAppConfig == null) || (paramMiniAppConfig.launchParam == null));
      QLog.e("MiniGameAdBannerPopup", 1, new Object[] { "handleGetAdResult", " not allow for refer " + paramMiniAppConfig.launchParam.scene });
      return;
    } while ((paramGetAdsRsp == null) || (localObject2 == null) || (localObject3 == null) || (localObject1 == null) || (localObject5 == null));
    label1055:
    ThreadManagerV2.getUIHandlerV2().postDelayed(new MiniGameAdBannerPopup.2(paramContext, paramGetAdsRsp, (String)localObject3, (String)localObject1, (String)localObject2, localObject5), TimeUnit.SECONDS.toMillis(SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH));
  }
  
  @NotNull
  private static bnwr newTianShuReportData(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt)
  {
    int i = (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    bnwr localbnwr = new bnwr();
    localbnwr.b = (String.valueOf(bjjo.a().a()) + '_' + i);
    localbnwr.d = paramInt;
    localbnwr.jdField_e_of_type_Int = 1;
    localbnwr.g = String.valueOf(paramAdItem.iAdId.get());
    localbnwr.n = paramString;
    localbnwr.jdField_a_of_type_Long = i;
    localbnwr.jdField_a_of_type_Int = 1;
    localbnwr.jdField_e_of_type_JavaLangString = "tianshu.81";
    localbnwr.i = "";
    return localbnwr;
  }
  
  private static void performReport(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt)
  {
    ThreadManagerV2.executeOnSubThread(new MiniGameAdBannerPopup.6(paramAdItem, paramString, paramInt));
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
      localObject = (Activity)paramContext;
    } while ((((Activity)localObject).isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (((Activity)localObject).isDestroyed())));
    View localView = LayoutInflater.from(paramContext).inflate(2131559420, null);
    ImageView localImageView = (ImageView)localView.findViewById(2131371184);
    TextView localTextView = (TextView)localView.findViewById(2131371187);
    Object localObject = (LinearLayout)localView.findViewById(2131371185);
    ReportDialog localReportDialog = new ReportDialog(paramContext);
    localReportDialog.setCancelable(false);
    if (localReportDialog.getWindow() != null)
    {
      localReportDialog.getWindow().requestFeature(1);
      localReportDialog.getWindow().setBackgroundDrawableResource(17170445);
    }
    localReportDialog.setContentView(localView, new ViewGroup.LayoutParams(-1, -1));
    localReportDialog.setOnShowListener(new MiniGameAdBannerPopup.3(paramAdItem, paramString1));
    localImageView.setOnClickListener(new MiniGameAdBannerPopup.4(localReportDialog, paramAdItem, paramString1));
    if (!TextUtils.isEmpty(paramString2)) {
      localTextView.setText(paramString2);
    }
    paramString2 = new MiniGameAdBannerPopup.BottomCornerURLImageView(paramContext);
    paramString2.setAdjustViewBounds(true);
    paramString2.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramString2.setClickable(true);
    paramString2.setImageDrawable(URLDrawable.getDrawable(paramString3));
    paramString2.setOnClickListener(new MiniGameAdBannerPopup.5(localReportDialog, paramContext, paramString4, paramAdItem, paramString1));
    paramContext = new LinearLayout.LayoutParams(-1, (int)TypedValue.applyDimension(1, 229.0F, paramContext.getResources().getDisplayMetrics()));
    paramContext.gravity = 1;
    ((LinearLayout)localObject).addView(paramString2, paramContext);
    localReportDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.MiniGameAdBannerPopup
 * JD-Core Version:    0.7.0.1
 */