package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.avgame.util.AvGameEntranceUtils;
import com.tencent.biz.qqstory.troop.TroopStoryUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.LiangGroupHelper;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.TogetherConfigureBean;
import com.tencent.mobileqq.config.business.WatchTogetherBean;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.gamecenter.util.QQGameTroopManager;
import com.tencent.mobileqq.listentogether.ListenTogetherUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studyroom.api.IStudyRoomReporter;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.mobileqq.together.TogetherUtils;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarConfig;
import com.tencent.mobileqq.troop.troopapps.AppsAioShortCutViewBuilder.AioShortCutInfo;
import com.tencent.mobileqq.troop.troopreddot.api.ITroopRedDotHandler;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class TroopAppShortcutUtils
{
  public static Drawable a(Context paramContext, String paramString, float paramFloat1, float paramFloat2)
  {
    Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = false;
    int i = ViewUtils.b(paramFloat1);
    ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i;
    ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = i;
    ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = paramContext.getResources().getDrawable(2130843873);
    ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = paramContext.getResources().getDrawable(2130843873);
    try
    {
      paramContext = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1);
      if (paramFloat2 > 0.0F) {}
      try
      {
        paramContext.setTag(URLDrawableDecodeHandler.b(i, i, ViewUtils.b(paramFloat2)));
        paramContext.setDecodeHandler(URLDrawableDecodeHandler.i);
        localObject1 = paramContext;
        if (paramContext.getStatus() != 2) {
          break label172;
        }
        paramContext.restartDownload();
        return paramContext;
      }
      catch (Exception localException1) {}
      localException2.printStackTrace();
    }
    catch (Exception localException2)
    {
      paramContext = null;
    }
    Object localObject2 = paramContext;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getIcon url: ");
      ((StringBuilder)localObject2).append(paramString);
      QLog.e("TroopAppShortcutUtils", 2, ((StringBuilder)localObject2).toString());
      localObject2 = paramContext;
    }
    label172:
    return localObject2;
  }
  
  private static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong, TroopInfo paramTroopInfo, boolean paramBoolean, int paramInt)
  {
    boolean bool = paramTroopInfo.isTroopOwner(paramQQAppInterface.getCurrentAccountUin());
    String str2 = "1";
    String str1;
    if (bool) {
      str1 = "0";
    } else if (paramTroopInfo.isAdmin()) {
      str1 = "1";
    } else {
      str1 = "2";
    }
    paramString2 = paramString2.replace("$GCODE$", paramString1).replace("$CLIENTVER$", "android8.7.0").replace("$UIN$", paramQQAppInterface.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(paramLong)).replace("$ROLE$", str1);
    if (paramBoolean) {
      paramQQAppInterface = str2;
    } else {
      paramQQAppInterface = "2";
    }
    paramString1 = paramString2.replace("$ENTERSOURCE$", paramQQAppInterface).replace("$GUIN$", paramString1).replace("$UNREADNUM$", String.valueOf(paramInt));
    paramQQAppInterface = paramString1;
    if (!TextUtils.isEmpty(paramTroopInfo.newTroopName)) {
      paramQQAppInterface = paramString1.replace("$GNAME$", paramTroopInfo.newTroopName);
    }
    return paramQQAppInterface;
  }
  
  public static void a(int paramInt, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, QBaseActivity paramQBaseActivity)
  {
    if (a(paramQQAppInterface, paramLong))
    {
      long l2 = 0L;
      int j = 0;
      Object localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      long l1 = l2;
      int i = j;
      if (localObject != null)
      {
        localObject = ((TroopManager)localObject).b(String.valueOf(paramLong));
        l1 = l2;
        i = j;
        if (localObject != null)
        {
          l2 = ((TroopInfo)localObject).dwGroupClassExt;
          if (((TroopInfo)localObject).isTroopOwner(paramQQAppInterface.getCurrentUin()))
          {
            i = 1;
            l1 = l2;
          }
          else
          {
            l1 = l2;
            i = j;
            if (((TroopInfo)localObject).isTroopAdmin(paramQQAppInterface.getCurrentUin()))
            {
              i = 2;
              l1 = l2;
            }
          }
        }
      }
      paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
      paramQQAppInterface.putExtra("url", "https://qun.qq.com/slidepanel/manage?_wv=16777218&_cwv=9&_wwv=129&gc=$GCODE$&gid=$GID$&gtype=$GTYPE$&gfrom=$GFROM".replace("$GCODE$", Long.toString(paramLong)).replace("$GID$", Integer.toString(i)).replace("$GTYPE$", Long.toString(l1)).replace("$GFROM", Integer.toString(paramInt)));
      paramQQAppInterface.putExtra("webStyle", "noBottomBar");
      paramQQAppInterface.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramQBaseActivity.startActivityForResult(paramQQAppInterface, 20006);
      if (paramInt == 1)
      {
        ReportController.b(null, "dc00898", "", Long.toString(paramLong), "0X800AD0B", "0X800AD0B", 0, 0, String.valueOf(l1), "", "", "");
        return;
      }
      if (paramInt == 2) {
        ReportController.b(null, "dc00898", "", Long.toString(paramLong), "0X800AFC6", "0X800AFC6", 0, 0, String.valueOf(l1), "", "", "");
      }
    }
  }
  
  public static void a(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, BaseActivity paramBaseActivity)
  {
    if (a(paramQQAppInterface, paramLong))
    {
      long l2 = 0L;
      int j = 0;
      Object localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      long l1 = l2;
      int i = j;
      if (localObject != null)
      {
        localObject = ((TroopManager)localObject).b(String.valueOf(paramLong));
        l1 = l2;
        i = j;
        if (localObject != null)
        {
          l2 = ((TroopInfo)localObject).dwGroupClassExt;
          if (((TroopInfo)localObject).isTroopOwner(paramQQAppInterface.getCurrentUin()))
          {
            i = 1;
            l1 = l2;
          }
          else
          {
            l1 = l2;
            i = j;
            if (((TroopInfo)localObject).isTroopAdmin(paramQQAppInterface.getCurrentUin()))
            {
              i = 2;
              l1 = l2;
            }
          }
        }
      }
      paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
      paramQQAppInterface.putExtra("url", "https://qun.qq.com/slidepanel/search?_wv=16777218&_cwv=9&_wwv=129&gc=$GCODE$&gid=$GID$&gtype=$GTYPE$".replace("$GCODE$", Long.toString(paramLong)).replace("$GID$", Integer.toString(i)).replace("$GTYPE$", Long.toString(l1)));
      paramQQAppInterface.putExtra("webStyle", "noBottomBar");
      paramQQAppInterface.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramBaseActivity.startActivityForResult(paramQQAppInterface, 20007);
    }
  }
  
  public static void a(Context paramContext, ImageView paramImageView, String paramString, float paramFloat, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if (paramImageView == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramString))
      {
        float f = paramFloat / 10.0F;
        try
        {
          paramImageView.setImageDrawable(a(paramContext, paramString, paramFloat, f));
          a(paramImageView, paramBoolean, f);
          return;
        }
        catch (Exception paramString)
        {
          QLog.e("TroopAppShortcutUtils", 1, "fetchDrawable: failed. ", paramString);
          paramImageView.setImageDrawable(paramContext.getResources().getDrawable(2130843873));
          a(paramImageView, false, 0.0F);
          return;
        }
      }
      paramImageView.setImageDrawable(paramContext.getResources().getDrawable(2130843873));
      a(paramImageView, false, 0.0F);
    }
  }
  
  private static void a(Intent paramIntent, long paramLong)
  {
    if (paramIntent == null) {
      return;
    }
    String str = null;
    if (paramLong == 101914115L) {
      str = "biz_src_zf_games";
    }
    if (!TextUtils.isEmpty(str)) {
      paramIntent.putExtra("big_brother_source_key", str);
    }
  }
  
  public static void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.setOnTouchListener(new TroopAppShortcutUtils.2());
  }
  
  public static void a(View paramView, boolean paramBoolean, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    if (paramBoolean)
    {
      int i = ViewUtils.b(0.5F);
      paramView.setPadding(i, i, i, i);
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(ViewUtils.b(paramFloat));
      localGradientDrawable.setStroke(ViewUtils.b(0.5F), Color.parseColor("#FFE5E5E5"));
      if (Build.VERSION.SDK_INT >= 16)
      {
        paramView.setBackground(localGradientDrawable);
        return;
      }
      paramView.setBackgroundDrawable(localGradientDrawable);
      return;
    }
    paramView.setPadding(0, 0, 0, 0);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.setBackground(null);
      return;
    }
    paramView.setBackgroundDrawable(null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, BaseActivity paramBaseActivity, String paramString1, long paramLong, String paramString2, int paramInt1, int paramInt2)
  {
    if ((paramQQAppInterface != null) && (paramContext != null))
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      TroopInfo localTroopInfo = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString1);
      if (localTroopInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopAppShortcutUtils", 2, "OnClickListener. troopInfo is null.");
        }
        return;
      }
      if (paramInt2 != 0) {
        ((ITroopRedDotHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER)).a(paramString1, (int)paramLong);
      }
      if (paramLong == 101761547L)
      {
        ListenTogetherUtils.b(paramQQAppInterface, paramContext, 1, paramString1, 0);
        return;
      }
      if (paramLong == 101793773L)
      {
        a(paramQQAppInterface, paramContext, localTroopInfo, paramString1);
        return;
      }
      if (paramLong == 101817424L)
      {
        b(paramQQAppInterface, paramContext, localTroopInfo, paramString1);
        return;
      }
      if (paramLong == 101847770L)
      {
        paramQQAppInterface = new Intent();
        paramQQAppInterface.putExtra("troop_uin", paramString1);
        paramQQAppInterface.putExtra("param_from", 19);
        paramQQAppInterface.putExtra("TROOP_INFO_MEMBER_NUM", localTroopInfo.wMemberNum);
        RouteUtils.a(paramContext, paramQQAppInterface, "/troop/memberlist/TroopMemberList");
        return;
      }
      int j = 3;
      if ((paramLong == 101872203L) && (paramBaseActivity != null))
      {
        if (AvGameEntranceUtils.a(paramBaseActivity, paramString1)) {
          return;
        }
        paramContext = (IAvGameManager)paramQQAppInterface.getRuntimeService(IAvGameManager.class, "");
        if (paramContext != null)
        {
          paramContext.createAvGameRoom(paramBaseActivity, 3, paramString1, 0);
          if (paramInt1 == 0) {
            paramQQAppInterface = "0X800B4E4";
          } else {
            paramQQAppInterface = "0X800B4E3";
          }
          if (paramContext.isAvGameRoomExist()) {
            paramInt1 = 1;
          } else {
            paramInt1 = 2;
          }
          ReportController.b(null, "dc00898", "", "", paramQQAppInterface, paramQQAppInterface, paramInt1, 0, "", "", localTroopInfo.troopuin, "");
        }
        return;
      }
      ((IStudyRoomReporter)QRoute.api(IStudyRoomReporter.class)).reportForTroopEntry(paramLong, paramString1);
      if (paramLong == 101914115L) {
        QQGameTroopManager.a(paramInt1, paramString1, false);
      }
      if ((paramLong == 1101236949L) && (QVipBigTroopExpiredProcessor.c().mIsEnable) && (localTroopInfo.mIsFreezed == 1) && ((localTroopInfo.isAdmin()) || (localTroopInfo.isTroopOwner(paramQQAppInterface.getCurrentAccountUin()))))
      {
        boolean bool = TroopManager.LiangGroupHelper.c(localTroopInfo.groupFreezeReason);
        if (localTroopInfo.isTroopOwner(paramQQAppInterface.getCurrentAccountUin()))
        {
          if (bool) {
            i = 15;
          } else {
            i = 8;
          }
          String str1 = VipUtils.a(0, i).toString();
          String str2 = HardCodeUtil.a(2131701953);
          TroopAppShortcutUtils.1 local1 = new TroopAppShortcutUtils.1();
          if (bool) {
            paramBaseActivity = "0X800A57F";
          } else {
            paramBaseActivity = "0X8009E38";
          }
          int i = j;
          if (bool) {
            i = 1;
          }
          VipUtils.a(paramContext, paramString1, str1, str2, local1, paramBaseActivity, i, bool);
        }
        else
        {
          VipUtils.a(paramContext, bool);
        }
      }
      if (paramInt1 == 0) {
        paramInt1 = 4007;
      } else {
        paramInt1 = 4008;
      }
      if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramString2))
      {
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramContext, a(paramQQAppInterface, paramString1, paramString2, paramLong, localTroopInfo, true, paramInt2), paramInt1, ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).createEntryModel(localTroopInfo, paramString1), null);
        return;
      }
      if ((!paramString2.startsWith("http")) && (!paramString2.startsWith("https")))
      {
        if (paramString2.startsWith("mqqapi"))
        {
          paramBaseActivity = a(paramQQAppInterface, paramString1, paramString2, paramLong, localTroopInfo, true, paramInt2);
          paramString1 = new Intent(paramContext, JumpActivity.class);
          paramQQAppInterface = paramBaseActivity;
          if (paramLong == 1105981808L) {
            paramQQAppInterface = TroopStoryUtil.a(paramString1, paramBaseActivity, null);
          }
          paramString1.setData(Uri.parse(paramQQAppInterface));
          paramContext.startActivity(paramString1);
        }
      }
      else
      {
        paramBaseActivity = new Intent(paramContext, QQBrowserActivity.class);
        paramBaseActivity.putExtra("url", a(paramQQAppInterface, paramString1, paramString2, paramLong, localTroopInfo, true, paramInt2));
        paramBaseActivity.putExtra("webStyle", "noBottomBar");
        paramBaseActivity.putExtra("startOpenPageTime", System.currentTimeMillis());
        a(paramBaseActivity, paramLong);
        paramContext.startActivity(paramBaseActivity);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, TroopInfo paramTroopInfo, String paramString)
  {
    TogetherConfigureBean localTogetherConfigureBean = (TogetherConfigureBean)QConfigManager.a().a(535);
    if ((localTogetherConfigureBean != null) && (localTogetherConfigureBean.a != null))
    {
      TogetherControlManager localTogetherControlManager = (TogetherControlManager)paramQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
      boolean bool = localTogetherControlManager.a(2, 1, paramTroopInfo.uin);
      paramString = TogetherUtils.a(bool, paramTroopInfo.isTroopOwner(paramQQAppInterface.getCurrentAccountUin()), paramTroopInfo.isAdmin(), paramTroopInfo.troopowneruin, paramString, 0);
      int i = localTogetherConfigureBean.a.a();
      if (i != 0)
      {
        if (i != 1)
        {
          if (localTogetherControlManager.a(paramContext, 2, paramTroopInfo.troopuin, 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TroopAppShortcutUtils", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(0) });
            }
          }
          else {
            TogetherUtils.a(paramQQAppInterface, localTogetherConfigureBean.a.b(), localTogetherConfigureBean.a.a(), localTogetherConfigureBean.a.b(), paramString, 1);
          }
        }
        else
        {
          if (bool)
          {
            localTogetherControlManager.b(paramContext, paramTroopInfo.troopuin, 1, 2, 0, paramString);
            return;
          }
          localTogetherControlManager.a(paramContext, paramTroopInfo.troopuin, 1, 2, 0, paramString);
        }
      }
      else {
        QQToast.a(paramContext, 0, 2131693100, 0).a();
      }
      return;
    }
    QQToast.a(paramContext, 0, 2131693100, 0).a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AppsAioShortCutViewBuilder.AioShortCutInfo paramAioShortCutInfo, long paramLong)
  {
    if (paramAioShortCutInfo == null) {
      return;
    }
    TroopShortcutBarConfig localTroopShortcutBarConfig = (TroopShortcutBarConfig)QConfigManager.a().a(590);
    if (localTroopShortcutBarConfig == null) {
      return;
    }
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.b(String.valueOf(paramLong));
    if (paramQQAppInterface == null) {
      return;
    }
    paramAioShortCutInfo.c = localTroopShortcutBarConfig.a((int)paramQQAppInterface.dwGroupClassExt);
    boolean bool;
    if (localTroopShortcutBarConfig.a == TroopShortcutBarConfig.c) {
      bool = true;
    } else {
      bool = false;
    }
    paramAioShortCutInfo.d = bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return (((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isTroopAdmin(paramQQAppInterface, Long.toString(paramLong), paramQQAppInterface.getCurrentUin())) || (TroopUtils.a(paramQQAppInterface, Long.toString(paramLong), paramQQAppInterface.getCurrentUin()));
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, TroopInfo paramTroopInfo, String paramString)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = (TogetherControlManager)paramQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
    boolean bool = paramQQAppInterface.a(4, -1, paramString);
    paramTroopInfo = TogetherUtils.a(bool, paramTroopInfo.isTroopOwner(str), paramTroopInfo.isAdmin(), paramTroopInfo.troopowneruin, paramString, 0);
    if (bool)
    {
      paramQQAppInterface.b(paramContext, paramString, 1, 4, 0, paramTroopInfo);
      return;
    }
    paramQQAppInterface.a(paramContext, paramString, 1, 4, 0, paramTroopInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopAppShortcutUtils
 * JD-Core Version:    0.7.0.1
 */