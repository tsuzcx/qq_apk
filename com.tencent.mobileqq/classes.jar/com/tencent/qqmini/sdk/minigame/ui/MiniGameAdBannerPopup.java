package com.tencent.qqmini.sdk.minigame.ui;

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
import bgpx;
import bgrm;
import bhaa;
import bhab;
import bhac;
import bhad;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
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
  private static int jdField_a_of_type_Int = bgpx.a("qqminiapp", "banner_ad_popup_show_delay_seconds_after_game_launch", 0);
  private static String jdField_a_of_type_JavaLangString = bgpx.a("qqminiapp", "banner_ad_popup_appid_white_list", "");
  private static String b = bgpx.a("qqminiapp", "banner_ad_popup_appid_black_list", "");
  private static String c = bgpx.a("qqminiapp", "banner_ad_popup_refer_white_list", "");
  private static String d = bgpx.a("qqminiapp", "banner_ad_popup_refer_black_list", "");
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    ThreadManager.a().post(new MiniGameAdBannerPopup.1(paramContext, paramString, paramInt));
  }
  
  private static boolean a(int paramInt)
  {
    try
    {
      if ((TextUtils.isEmpty(c)) && (TextUtils.isEmpty(d))) {
        return true;
      }
      QMLog.d("MiniGameAdBannerPopup", "allowShowForRefer check if scene " + paramInt + " in whitelist " + c + " or blacklist " + d);
      String[] arrayOfString;
      int j;
      int i;
      if (!TextUtils.isEmpty(c))
      {
        if (c.contains(",")) {}
        for (arrayOfString = c.split(",");; arrayOfString = c.split(";"))
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
      if (!TextUtils.isEmpty(d)) {
        if (d.contains(","))
        {
          arrayOfString = d.split(",");
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
              arrayOfString = d.split(";");
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
  
  private static boolean a(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        if ((TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(b))) {
          return true;
        }
        QMLog.d("MiniGameAdBannerPopup", "allowShowForAppId check if appid " + paramString + " in whitelist " + jdField_a_of_type_JavaLangString + " or blacklist " + b);
        String[] arrayOfString;
        int j;
        String str;
        if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
        {
          if (jdField_a_of_type_JavaLangString.contains(","))
          {
            arrayOfString = jdField_a_of_type_JavaLangString.split(",");
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
            arrayOfString = jdField_a_of_type_JavaLangString.split(";");
            continue;
          }
        }
        else if (!TextUtils.isEmpty(b))
        {
          if (b.contains(","))
          {
            arrayOfString = b.split(",");
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
            arrayOfString = b.split(";");
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
  
  private static void b(Context paramContext, String paramString, int paramInt, boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    Object localObject7 = null;
    TianShuAccess.GetAdsRsp localGetAdsRsp = null;
    Object localObject3 = null;
    Object localObject2;
    Object localObject1;
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
        Object localObject6;
        if ((localAdItem2 != null) && (localAdItem2.argList != null) && (!localAdItem2.argList.isEmpty()))
        {
          Iterator localIterator = localAdItem2.argList.get().iterator();
          localObject2 = null;
          localObject1 = null;
          paramGetAdsRsp = null;
          localAdItem1 = localAdItem2;
          localObject7 = localObject3;
          Object localObject4 = localObject2;
          localObject6 = localObject1;
          localGetAdsRsp = paramGetAdsRsp;
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
                jdField_a_of_type_JavaLangString = ((TianShuAccess.MapEntry)localObject4).value.get();
                localObject4 = localObject1;
                localObject6 = paramGetAdsRsp;
                paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject3;
                localObject1 = localObject2;
                localObject2 = localObject4;
                localObject3 = localObject6;
              }
              else if ("appid_off".equals(((TianShuAccess.MapEntry)localObject4).key.get()))
              {
                b = ((TianShuAccess.MapEntry)localObject4).value.get();
                localObject4 = localObject1;
                localObject6 = paramGetAdsRsp;
                paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject3;
                localObject1 = localObject2;
                localObject2 = localObject4;
                localObject3 = localObject6;
              }
              else if ("refer_on".equals(((TianShuAccess.MapEntry)localObject4).key.get()))
              {
                c = ((TianShuAccess.MapEntry)localObject4).value.get();
                localObject4 = localObject1;
                localObject6 = paramGetAdsRsp;
                paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject3;
                localObject1 = localObject2;
                localObject2 = localObject4;
                localObject3 = localObject6;
              }
              else if ("refer_off".equals(((TianShuAccess.MapEntry)localObject4).key.get()))
              {
                d = ((TianShuAccess.MapEntry)localObject4).value.get();
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
                  jdField_a_of_type_Int = Integer.parseInt(((TianShuAccess.MapEntry)localObject4).value.get());
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
          localObject5 = null;
          localObject6 = null;
          localGetAdsRsp = null;
        }
        localObject2 = localAdItem1;
        localObject1 = localObject6;
        paramGetAdsRsp = localObject7;
        label765:
        QMLog.d("MiniGameAdBannerPopup", "handleGetAdResult appid whitelist " + jdField_a_of_type_JavaLangString + "\n appid blacklist " + b + "\n refer whitelist " + c + "\n refer blacklist " + d + "\n show time " + jdField_a_of_type_Int);
        if (a(paramString)) {
          break label899;
        }
        QMLog.e("MiniGameAdBannerPopup", "handleGetAdResult not allow for appid " + paramString);
      }
    }
    label884:
    do
    {
      return;
      QMLog.e("MiniGameAdBannerPopup", "onGetAdvs no ad data");
      break;
      QMLog.e("MiniGameAdBannerPopup", "onGetAdvs no ad result");
      localObject2 = null;
      paramGetAdsRsp = null;
      localObject5 = null;
      localObject1 = null;
      break label765;
      if (!a(paramInt))
      {
        QMLog.e("MiniGameAdBannerPopup", "handleGetAdResult not allow for refer " + paramInt);
        return;
      }
    } while ((localGetAdsRsp == null) || (localObject1 == null) || (localObject5 == null) || (paramGetAdsRsp == null) || (localObject2 == null));
    label899:
    ThreadManager.c().postDelayed(new MiniGameAdBannerPopup.3(paramContext, localGetAdsRsp, localObject5, paramGetAdsRsp, (String)localObject1, localObject2), TimeUnit.SECONDS.toMillis(jdField_a_of_type_Int));
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, TianShuAccess.AdItem paramAdItem)
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
    Object localObject2 = LayoutInflater.from(paramContext).inflate(2131559337, null);
    ImageView localImageView = (ImageView)((View)localObject2).findViewById(2131370588);
    TextView localTextView = (TextView)((View)localObject2).findViewById(2131370590);
    Object localObject1 = (LinearLayout)((View)localObject2).findViewById(2131370577);
    Dialog localDialog = new Dialog(paramContext);
    localDialog.setCancelable(false);
    if (localDialog.getWindow() != null)
    {
      localDialog.getWindow().requestFeature(1);
      localDialog.getWindow().setBackgroundDrawableResource(17170445);
    }
    localDialog.setContentView((View)localObject2, new ViewGroup.LayoutParams(-1, -1));
    localDialog.setOnShowListener(new bhab(paramAdItem, paramString1));
    localImageView.setOnClickListener(new bhac(localDialog, paramAdItem, paramString1));
    if (!TextUtils.isEmpty(paramString2)) {
      localTextView.setText(paramString2);
    }
    paramString2 = new MiniGameAdBannerPopup.BottomCornerURLImageView(paramContext);
    paramString2.setAdjustViewBounds(true);
    paramString2.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramString2.setClickable(true);
    localObject2 = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    paramString2.setImageDrawable(((MiniAppProxy)localObject2).getDrawable(paramContext, paramString3, 0, 0, null));
    paramString2.setOnClickListener(new bhad(localDialog, paramContext, paramString4, (MiniAppProxy)localObject2, paramAdItem, paramString1));
    paramContext = new LinearLayout.LayoutParams(-1, (int)TypedValue.applyDimension(1, 229.0F, paramContext.getResources().getDisplayMetrics()));
    paramContext.gravity = 1;
    ((LinearLayout)localObject1).addView(paramString2, paramContext);
    localDialog.show();
  }
  
  private static void b(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt)
  {
    ThreadManager.a().post(new MiniGameAdBannerPopup.7(paramAdItem, paramString, paramInt));
  }
  
  private static void c(Context paramContext, String paramString, int paramInt)
  {
    if ((paramContext == null) || (paramString == null)) {}
    WeakReference localWeakReference;
    do
    {
      return;
      localWeakReference = new WeakReference(paramContext);
    } while (((ChannelProxy)ProxyManager.get(ChannelProxy.class)).tianshuRequestAdv(paramContext, paramString, paramInt, 258, 1, new bhaa(localWeakReference, paramString, paramInt)));
    bgrm.a(paramContext, 0, "暂不支持在" + QUAUtil.getApplicationName(paramContext) + "中请求广告弹窗", 1);
    b(paramContext, paramString, paramInt, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.ui.MiniGameAdBannerPopup
 * JD-Core Version:    0.7.0.1
 */