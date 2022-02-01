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
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import cooperation.vip.tianshu.TianShuManager;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

public class MiniGameAdBannerPopup
{
  private static String APPID_BLACK_LIST;
  private static String APPID_WHITE_LIST;
  private static MiniGameAdBannerPopup.GetAdCallback GET_AD_CALLBACK = null;
  private static final String PREF_KEY_CURRENT_SHOW_TIMES = "pref_key_banner_ad_current_show_times";
  private static final String PREF_KEY_LAST_SHOW_TIME_MILLIS = "pref_key_banner_ad_popup_last_show_time_millis";
  private static String REFER_BLACK_LIST;
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
    REFER_BLACK_LIST = QzoneConfig.getInstance().getConfig("qqminiapp", "banner_ad_popup_refer_black_list", "");
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
          Object localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(" check if appid ");
          ((StringBuilder)localObject1).append(paramMiniAppConfig.config.appId);
          ((StringBuilder)localObject1).append(" in whitelist ");
          ((StringBuilder)localObject1).append(APPID_WHITE_LIST);
          ((StringBuilder)localObject1).append(" or blacklist ");
          ((StringBuilder)localObject1).append(APPID_BLACK_LIST);
          QLog.d("MiniGameAdBannerPopup", 1, new Object[] { "allowShowForAppId", ((StringBuilder)localObject1).toString() });
          boolean bool = TextUtils.isEmpty(APPID_WHITE_LIST);
          int j;
          Object localObject2;
          if (!bool)
          {
            if (APPID_WHITE_LIST.contains(",")) {
              localObject1 = APPID_WHITE_LIST.split(",");
            } else {
              localObject1 = APPID_WHITE_LIST.split(";");
            }
            if (localObject1 == null) {
              break;
            }
            j = localObject1.length;
            i = 0;
            if (i >= j) {
              break;
            }
            localObject2 = localObject1[i];
            if ((localObject2 == null) || (!localObject2.equals(paramMiniAppConfig.config.appId))) {
              break label317;
            }
            return true;
          }
          if (!TextUtils.isEmpty(APPID_BLACK_LIST))
          {
            if (APPID_BLACK_LIST.contains(",")) {
              localObject1 = APPID_BLACK_LIST.split(",");
            } else {
              localObject1 = APPID_BLACK_LIST.split(";");
            }
            if (localObject1 != null)
            {
              j = localObject1.length;
              i = 0;
              if (i < j)
              {
                localObject2 = localObject1[i];
                if (localObject2 != null)
                {
                  bool = localObject2.equals(paramMiniAppConfig.config.appId);
                  if (bool) {
                    return false;
                  }
                }
                i += 1;
                continue;
              }
            }
            return true;
          }
        }
      }
      catch (Exception paramMiniAppConfig)
      {
        QLog.e("MiniGameAdBannerPopup", 1, "allowShowForAppId", paramMiniAppConfig);
      }
      return true;
      label317:
      i += 1;
    }
    return false;
  }
  
  private static boolean allowShowForRefer(MiniAppConfig paramMiniAppConfig)
  {
    for (;;)
    {
      int i;
      try
      {
        if ((TextUtils.isEmpty(REFER_WHITE_LIST)) && (TextUtils.isEmpty(REFER_BLACK_LIST))) {
          return true;
        }
        if ((paramMiniAppConfig != null) && (paramMiniAppConfig.launchParam != null))
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" check if scene ");
          ((StringBuilder)localObject).append(paramMiniAppConfig.launchParam.scene);
          ((StringBuilder)localObject).append(" in whitelist ");
          ((StringBuilder)localObject).append(REFER_WHITE_LIST);
          ((StringBuilder)localObject).append(" or blacklist ");
          ((StringBuilder)localObject).append(REFER_BLACK_LIST);
          QLog.d("MiniGameAdBannerPopup", 1, new Object[] { "allowShowForRefer", ((StringBuilder)localObject).toString() });
          boolean bool = TextUtils.isEmpty(REFER_WHITE_LIST);
          int j;
          if (!bool)
          {
            if (REFER_WHITE_LIST.contains(",")) {
              localObject = REFER_WHITE_LIST.split(",");
            } else {
              localObject = REFER_WHITE_LIST.split(";");
            }
            if (localObject == null) {
              break;
            }
            j = localObject.length;
            i = 0;
            if (i >= j) {
              break;
            }
            if (Integer.parseInt(localObject[i]) != paramMiniAppConfig.launchParam.scene) {
              break label305;
            }
            return true;
          }
          if (!TextUtils.isEmpty(REFER_BLACK_LIST))
          {
            if (REFER_BLACK_LIST.contains(",")) {
              localObject = REFER_BLACK_LIST.split(",");
            } else {
              localObject = REFER_BLACK_LIST.split(";");
            }
            if (localObject != null)
            {
              j = localObject.length;
              i = 0;
              if (i < j)
              {
                int k = Integer.parseInt(localObject[i]);
                int m = paramMiniAppConfig.launchParam.scene;
                if (k == m) {
                  return false;
                }
                i += 1;
                continue;
              }
            }
            return true;
          }
        }
      }
      catch (Exception paramMiniAppConfig)
      {
        QLog.e("MiniGameAdBannerPopup", 1, "allowShowForRefer", paramMiniAppConfig);
      }
      return true;
      label305:
      i += 1;
    }
    return false;
  }
  
  public static void checkShouldShow(Context paramContext, MiniAppConfig paramMiniAppConfig)
  {
    ThreadManagerV2.executeOnSubThread(new MiniGameAdBannerPopup.1(paramContext, paramMiniAppConfig));
  }
  
  private static void checkShouldShowInternal(Context paramContext, MiniAppConfig paramMiniAppConfig)
  {
    if ((paramContext != null) && (paramMiniAppConfig != null))
    {
      if (!paramMiniAppConfig.isEngineTypeMiniGame()) {
        return;
      }
      try
      {
        TianShuAdPosItemData localTianShuAdPosItemData = new TianShuAdPosItemData();
        localTianShuAdPosItemData.jdField_a_of_type_Int = 258;
        localTianShuAdPosItemData.b = 1;
        GET_AD_CALLBACK = new MiniGameAdBannerPopup.GetAdCallback(paramContext, paramMiniAppConfig);
        TianShuManager.getInstance().requestAdv(Collections.singletonList(localTianShuAdPosItemData), GET_AD_CALLBACK);
        return;
      }
      catch (Exception paramContext)
      {
        QLog.e("MiniGameAdBannerPopup", 1, "requestAdBannerPopupInfo", paramContext);
      }
    }
  }
  
  private static void handleGetAdResult(Context paramContext, MiniAppConfig paramMiniAppConfig, boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    Object localObject6 = null;
    String str = null;
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
            localObject2 = null;
            localObject1 = localObject2;
            paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject1;
            for (;;)
            {
              localObject6 = str;
              localObject8 = localAdItem;
              localObject7 = localObject2;
              Object localObject3 = localObject1;
              localObject5 = paramGetAdsRsp;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject3 = (TianShuAccess.MapEntry)localIterator.next();
              if ("type".equals(((TianShuAccess.MapEntry)localObject3).key.get())) {
                str = ((TianShuAccess.MapEntry)localObject3).value.get();
              } else if ("url".equals(((TianShuAccess.MapEntry)localObject3).key.get())) {
                localObject2 = ((TianShuAccess.MapEntry)localObject3).value.get();
              } else if ("text".equals(((TianShuAccess.MapEntry)localObject3).key.get())) {
                localObject1 = ((TianShuAccess.MapEntry)localObject3).value.get();
              } else if ("pic".equals(((TianShuAccess.MapEntry)localObject3).key.get())) {
                paramGetAdsRsp = ((TianShuAccess.MapEntry)localObject3).value.get();
              } else if ("appid_on".equals(((TianShuAccess.MapEntry)localObject3).key.get())) {
                APPID_WHITE_LIST = ((TianShuAccess.MapEntry)localObject3).value.get();
              } else if ("appid_off".equals(((TianShuAccess.MapEntry)localObject3).key.get())) {
                APPID_BLACK_LIST = ((TianShuAccess.MapEntry)localObject3).value.get();
              } else if ("refer_on".equals(((TianShuAccess.MapEntry)localObject3).key.get())) {
                REFER_WHITE_LIST = ((TianShuAccess.MapEntry)localObject3).value.get();
              } else if ("refer_off".equals(((TianShuAccess.MapEntry)localObject3).key.get())) {
                REFER_BLACK_LIST = ((TianShuAccess.MapEntry)localObject3).value.get();
              } else if (("show_time".equals(((TianShuAccess.MapEntry)localObject3).key.get())) && (!TextUtils.isEmpty(((TianShuAccess.MapEntry)localObject3).value.get()))) {
                try
                {
                  SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH = Integer.parseInt(((TianShuAccess.MapEntry)localObject3).value.get());
                }
                catch (Exception localException)
                {
                  QLog.e("MiniGameAdBannerPopup", 1, "handleGetAdResult", localException);
                }
              }
            }
          }
          QLog.e("MiniGameAdBannerPopup", 1, new Object[] { "onGetAdvs", " no ad item" });
        }
        else
        {
          QLog.e("MiniGameAdBannerPopup", 1, new Object[] { "onGetAdvs", " no ad data" });
        }
        localObject8 = null;
        localObject7 = localObject8;
        localObject4 = localObject7;
        Object localObject5 = localObject4;
        localObject2 = localObject5;
        localObject1 = localObject4;
        paramGetAdsRsp = localObject6;
        break label602;
      }
    }
    else {
      QLog.e("MiniGameAdBannerPopup", 1, new Object[] { "onGetAdvs", " no ad result" });
    }
    Object localObject4 = null;
    paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject4;
    Object localObject1 = paramGetAdsRsp;
    Object localObject2 = localObject1;
    Object localObject8 = localObject2;
    Object localObject7 = localObject2;
    localObject2 = localObject1;
    localObject1 = paramGetAdsRsp;
    paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject4;
    label602:
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(" appid whitelist ");
    ((StringBuilder)localObject4).append(APPID_WHITE_LIST);
    ((StringBuilder)localObject4).append("\n appid blacklist ");
    ((StringBuilder)localObject4).append(APPID_BLACK_LIST);
    ((StringBuilder)localObject4).append("\n refer whitelist ");
    ((StringBuilder)localObject4).append(REFER_WHITE_LIST);
    ((StringBuilder)localObject4).append("\n refer blacklist ");
    ((StringBuilder)localObject4).append(REFER_BLACK_LIST);
    ((StringBuilder)localObject4).append("\n show time ");
    ((StringBuilder)localObject4).append(SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH);
    QLog.d("MiniGameAdBannerPopup", 1, new Object[] { "handleGetAdResult", ((StringBuilder)localObject4).toString() });
    if (!allowShowForAppId(paramMiniAppConfig))
    {
      if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null))
      {
        paramContext = new StringBuilder();
        paramContext.append(" not allow for appid ");
        paramContext.append(paramMiniAppConfig.config.appId);
        QLog.e("MiniGameAdBannerPopup", 1, new Object[] { "handleGetAdResult", paramContext.toString() });
      }
      return;
    }
    if (!allowShowForRefer(paramMiniAppConfig))
    {
      if ((paramMiniAppConfig != null) && (paramMiniAppConfig.launchParam != null))
      {
        paramContext = new StringBuilder();
        paramContext.append(" not allow for refer ");
        paramContext.append(paramMiniAppConfig.launchParam.scene);
        QLog.e("MiniGameAdBannerPopup", 1, new Object[] { "handleGetAdResult", paramContext.toString() });
      }
      return;
    }
    if ((paramGetAdsRsp != null) && (localObject7 != null) && (localObject1 != null) && (localObject2 != null) && (localObject8 != null)) {
      ThreadManagerV2.getUIHandlerV2().postDelayed(new MiniGameAdBannerPopup.2(paramContext, paramGetAdsRsp, (String)localObject1, (String)localObject2, localObject7, (TianShuAccess.AdItem)localObject8), TimeUnit.SECONDS.toMillis(SHOW_DELAY_SECONDS_AFTER_GAME_LAUNCH));
    }
  }
  
  @NotNull
  private static TianShuReportData newTianShuReportData(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt)
  {
    int i = (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    TianShuReportData localTianShuReportData = new TianShuReportData();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(CommonDataAdapter.a().a()));
    localStringBuilder.append('_');
    localStringBuilder.append(i);
    localTianShuReportData.b = localStringBuilder.toString();
    localTianShuReportData.d = paramInt;
    localTianShuReportData.jdField_e_of_type_Int = 1;
    localTianShuReportData.g = String.valueOf(paramAdItem.iAdId.get());
    localTianShuReportData.n = paramString;
    localTianShuReportData.jdField_a_of_type_Long = i;
    localTianShuReportData.jdField_a_of_type_Int = 1;
    localTianShuReportData.jdField_e_of_type_JavaLangString = "tianshu.81";
    localTianShuReportData.i = "";
    return localTianShuReportData;
  }
  
  private static void performReport(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt)
  {
    ThreadManagerV2.executeOnSubThread(new MiniGameAdBannerPopup.6(paramAdItem, paramString, paramInt));
  }
  
  private static void showAdBannerPopupWindow(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, TianShuAccess.AdItem paramAdItem)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      if (TextUtils.isEmpty(paramString4)) {
        return;
      }
      if (!(paramContext instanceof Activity)) {
        return;
      }
      Object localObject = (Activity)paramContext;
      if (!((Activity)localObject).isFinishing())
      {
        if ((Build.VERSION.SDK_INT >= 17) && (((Activity)localObject).isDestroyed())) {
          return;
        }
        View localView = LayoutInflater.from(paramContext).inflate(2131559400, null);
        ImageView localImageView = (ImageView)localView.findViewById(2131371245);
        TextView localTextView = (TextView)localView.findViewById(2131371248);
        localObject = (LinearLayout)localView.findViewById(2131371246);
        Dialog localDialog = new Dialog(paramContext);
        localDialog.setCancelable(false);
        if (localDialog.getWindow() != null)
        {
          localDialog.getWindow().requestFeature(1);
          localDialog.getWindow().setBackgroundDrawableResource(17170445);
        }
        localDialog.setContentView(localView, new ViewGroup.LayoutParams(-1, -1));
        localDialog.setOnShowListener(new MiniGameAdBannerPopup.3(paramAdItem, paramString1));
        localImageView.setOnClickListener(new MiniGameAdBannerPopup.4(localDialog, paramAdItem, paramString1));
        if (!TextUtils.isEmpty(paramString2)) {
          localTextView.setText(paramString2);
        }
        paramString2 = new MiniGameAdBannerPopup.BottomCornerURLImageView(paramContext);
        paramString2.setAdjustViewBounds(true);
        paramString2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramString2.setClickable(true);
        paramString2.setImageDrawable(URLDrawable.getDrawable(paramString3));
        paramString2.setOnClickListener(new MiniGameAdBannerPopup.5(localDialog, paramContext, paramString4, paramAdItem, paramString1));
        paramContext = new LinearLayout.LayoutParams(-1, (int)TypedValue.applyDimension(1, 229.0F, paramContext.getResources().getDisplayMetrics()));
        paramContext.gravity = 1;
        ((LinearLayout)localObject).addView(paramString2, paramContext);
        localDialog.show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.MiniGameAdBannerPopup
 * JD-Core Version:    0.7.0.1
 */