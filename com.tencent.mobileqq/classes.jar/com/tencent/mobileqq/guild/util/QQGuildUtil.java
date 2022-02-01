package com.tencent.mobileqq.guild.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.config.QQGuildConfigBean;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserProfileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.URLUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

public class QQGuildUtil
{
  public static long a;
  public static final DownloadParams.DecodeHandler b = new QQGuildUtil.5();
  public static final DownloadParams.DecodeHandler c = new QQGuildUtil.6();
  public static final DownloadParams.DecodeHandler d = new QQGuildUtil.7();
  private static Map<String, Boolean> e = new HashMap();
  private static String f = "";
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBitmap == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
        Canvas localCanvas = new Canvas(localBitmap);
        Paint localPaint = new Paint();
        if (paramBitmap.getWidth() < paramInt1)
        {
          i = (paramInt1 - paramBitmap.getWidth()) / 2;
          if (paramBitmap.getHeight() >= paramInt2) {
            break label366;
          }
          j = (paramInt2 - paramBitmap.getHeight()) / 2;
          Rect localRect2 = new Rect(i, j, paramBitmap.getWidth() - i, paramBitmap.getHeight() - j);
          Rect localRect3 = new Rect(i, j, paramInt1 - i, paramInt2 - j);
          RectF localRectF = new RectF(localRect3);
          Rect localRect1;
          if (paramInt4 != 1)
          {
            if (paramInt4 != 2)
            {
              if (paramInt4 != 3)
              {
                if (paramInt4 != 4) {
                  localRect1 = null;
                } else {
                  localRect1 = new Rect(-paramInt3, 0, paramInt1 - paramInt3, paramInt2);
                }
              }
              else {
                localRect1 = new Rect(paramInt3, 0, paramInt1 + paramInt3, paramInt2);
              }
            }
            else {
              localRect1 = new Rect(0, -paramInt3, paramInt1, paramInt2 - paramInt3);
            }
          }
          else {
            localRect1 = new Rect(0, paramInt3, paramInt1, paramInt2 + paramInt3);
          }
          localPaint.setAntiAlias(true);
          localPaint.setDither(true);
          localPaint.setFilterBitmap(true);
          localCanvas.drawARGB(0, 0, 0, 0);
          localPaint.setColor(-16777216);
          float f1 = paramInt3;
          localCanvas.drawRoundRect(localRectF, f1, f1, localPaint);
          if (localRect1 != null) {
            localCanvas.drawRect(localRect1, localPaint);
          }
          localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
          localCanvas.drawBitmap(paramBitmap, localRect2, localRect3, localPaint);
          paramBitmap.recycle();
          return localBitmap;
        }
      }
      catch (Throwable paramBitmap)
      {
        paramBitmap.printStackTrace();
        if (QLog.isDevelopLevel()) {
          QLog.w("QQGuildUtil", 2, "ROUND_CORNER_DECODER bitmap == null, ", paramBitmap);
        }
        return null;
      }
      int i = 0;
      continue;
      label366:
      int j = 0;
    }
  }
  
  public static IGProChannelInfo a(@NonNull String paramString, AppRuntime paramAppRuntime)
  {
    paramAppRuntime = ((IGPSService)paramAppRuntime.getRuntimeService(IGPSService.class, "")).getChannelList(paramString);
    if ((paramAppRuntime != null) && (paramAppRuntime.size() != 0)) {
      return a(paramAppRuntime);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getHomePageChannel: list = ");
    localStringBuilder.append(paramAppRuntime);
    paramAppRuntime = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId = ");
    localStringBuilder.append(paramString);
    QLog.e("QQGuildUtil", 2, new Object[] { paramAppRuntime, localStringBuilder.toString() });
    return null;
  }
  
  public static IGProChannelInfo a(@NonNull List<IGProChannelInfo> paramList)
  {
    return b(paramList);
  }
  
  public static <T> T a(@NonNull Class<T> paramClass)
  {
    return g().getBusinessHandler(paramClass.getName());
  }
  
  public static String a(int paramInt)
  {
    QQGuildConfigBean localQQGuildConfigBean = c();
    if ((paramInt > 0) && (paramInt <= localQQGuildConfigBean.j.size())) {
      return (String)localQQGuildConfigBean.j.get(paramInt - 1);
    }
    return "";
  }
  
  public static String a(IGProUserInfo paramIGProUserInfo)
  {
    if (paramIGProUserInfo == null) {
      return "";
    }
    if (TextUtils.isEmpty(paramIGProUserInfo.b())) {
      paramIGProUserInfo = paramIGProUserInfo.c();
    } else {
      paramIGProUserInfo = paramIGProUserInfo.b();
    }
    if (!TextUtils.isEmpty(paramIGProUserInfo)) {
      return paramIGProUserInfo;
    }
    return "";
  }
  
  public static String a(IGProUserProfileInfo paramIGProUserProfileInfo)
  {
    if (paramIGProUserProfileInfo == null) {
      return "";
    }
    String str;
    if (TextUtils.isEmpty(paramIGProUserProfileInfo.l())) {
      str = paramIGProUserProfileInfo.c();
    } else {
      str = paramIGProUserProfileInfo.l();
    }
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return paramIGProUserProfileInfo.a();
  }
  
  public static <T extends IRuntimeService> T a(@NonNull Class<T> paramClass, String paramString)
  {
    return g().getRuntimeService(paramClass, paramString);
  }
  
  public static void a(@NonNull Activity paramActivity, int paramInt, String paramString, @Nullable IGProSecurityResult paramIGProSecurityResult)
  {
    a(paramActivity, paramInt, paramString, paramIGProSecurityResult);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    int i = ImmersiveUtils.getStatusBarHeight(paramActivity);
    if (LiuHaiUtils.c(paramActivity)) {
      i = LiuHaiUtils.e(paramActivity);
    }
    paramString = URLUtil.b(paramString, "nav_height", String.valueOf(i));
    Intent localIntent = new Intent();
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("finish_animation_out_to_right", true);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Jumping to a H5 page: ");
      localStringBuilder.append(paramString);
      QLog.d("QQGuildUtil", 2, localStringBuilder.toString());
    }
    RouteUtils.a(paramActivity, localIntent, "/base/browser");
    paramActivity.overridePendingTransition(2130772134, 2130772007);
  }
  
  @Deprecated
  public static void a(@NonNull Context paramContext, int paramInt, String paramString)
  {
    a(paramContext, paramInt, paramString, null);
  }
  
  @Deprecated
  public static void a(@NonNull Context paramContext, int paramInt, String paramString, @Nullable IGProSecurityResult paramIGProSecurityResult)
  {
    if (paramContext == null) {
      return;
    }
    if ((paramInt == 0) && (a(paramIGProSecurityResult))) {
      return;
    }
    if ((paramIGProSecurityResult != null) && (paramIGProSecurityResult.a() != 0L))
    {
      if ((paramIGProSecurityResult.a() == 200L) && (!paramIGProSecurityResult.b().isEmpty()))
      {
        DialogUtil.a(paramContext, 230, null, paramIGProSecurityResult.b(), null, paramContext.getString(2131890251), new QQGuildUtil.9(), null).show();
        return;
      }
      if (a(paramContext, paramIGProSecurityResult)) {
        return;
      }
      if (!TextUtils.isEmpty(paramIGProSecurityResult.b())) {
        paramIGProSecurityResult = paramIGProSecurityResult.b();
      } else {
        paramIGProSecurityResult = paramContext.getResources().getString(2131890563);
      }
    }
    else if (paramInt == 22000)
    {
      paramIGProSecurityResult = paramContext.getResources().getString(2131890220);
    }
    else if (paramInt == 22001)
    {
      paramIGProSecurityResult = paramContext.getResources().getString(2131890219);
    }
    else if (paramInt == 22005)
    {
      paramIGProSecurityResult = paramContext.getResources().getString(2131890218);
    }
    else if (paramInt == 29001)
    {
      paramIGProSecurityResult = paramContext.getResources().getString(2131890284);
    }
    else if (paramInt == 30006)
    {
      paramIGProSecurityResult = paramContext.getResources().getString(2131890530);
    }
    else if (paramInt == 10011)
    {
      paramIGProSecurityResult = paramContext.getResources().getString(2131890534);
    }
    else if (paramInt != 29100)
    {
      paramIGProSecurityResult = paramString;
      if (paramInt != 29101) {}
    }
    else
    {
      paramIGProSecurityResult = paramString;
      if (!paramString.isEmpty())
      {
        DialogUtil.a(paramContext, 230, null, paramString, null, paramContext.getString(2131890251), new QQGuildUtil.10(), null).show();
        return;
      }
    }
    paramString = paramIGProSecurityResult;
    if (TextUtils.isEmpty(paramIGProSecurityResult)) {
      paramString = paramContext.getResources().getString(2131890335);
    }
    QQToast.makeText(paramContext, 1, paramString, 1).show();
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGuildUtil", 2, new Object[] { "addGuildByShareUrl context: ", paramContext, " url: ", paramString });
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("jumpType", 0);
    localBundle.putString("GuildShareUrl", paramString);
    ((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).gotoGuildTab(paramContext, GuildMainFrameConstants.q, localBundle);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGuildUtil", 2, new Object[] { "navigateToGuildByInvitedInfo context: ", paramContext, " code: ", paramString, " from: ", Integer.valueOf(paramInt) });
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("jumpType", 3);
    localBundle.putString("inviteCode", paramString);
    localBundle.putInt("from", paramInt);
    ((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).gotoGuildTab(paramContext, GuildMainFrameConstants.q, localBundle);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("jumpType", 1);
    localBundle.putString("guildId", paramString1);
    localBundle.putString("authSig", paramString2);
    localBundle.putInt("from", paramInt);
    ((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).gotoGuildTab(paramContext, GuildMainFrameConstants.q, localBundle);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    QQGuildConfigBean localQQGuildConfigBean = c();
    if ((localQQGuildConfigBean != null) && (!localQQGuildConfigBean.d.isEmpty()))
    {
      if ((paramString2 != null) && (!paramString2.isEmpty()))
      {
        paramString3 = new StringBuilder();
        paramString3.append(localQQGuildConfigBean.d);
        paramString3.append("&gc=");
        paramString3.append(paramString1);
        paramString3.append("&robot_tid=");
        paramString3.append(paramString2);
        paramString1 = paramString3.toString();
      }
      else
      {
        paramString2 = new StringBuilder();
        paramString2.append(localQQGuildConfigBean.d);
        paramString2.append("&gc=");
        paramString2.append(paramString1);
        paramString2.append("&robot_uin=");
        paramString2.append(paramString3);
        paramString1 = paramString2.toString();
      }
      paramString2 = new Intent(paramContext, QQBrowserActivity.class);
      paramString2.putExtra("url", paramString1);
      paramContext.startActivity(paramString2);
    }
  }
  
  public static void a(View paramView, String paramString, ClickPolicy paramClickPolicy, ExposurePolicy paramExposurePolicy)
  {
    VideoReport.setElementId(paramView, paramString);
    VideoReport.setElementClickPolicy(paramView, paramClickPolicy);
    VideoReport.setElementExposePolicy(paramView, paramExposurePolicy);
  }
  
  public static void a(@NonNull ImageView paramImageView, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramImageView.setVisibility(0);
      b(paramImageView, paramString);
      return;
    }
    paramImageView.setVisibility(8);
  }
  
  public static void a(AppInterface paramAppInterface, Activity paramActivity, String paramString1, IGProUserInfo paramIGProUserInfo, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3)
  {
    IGPSService localIGPSService = (IGPSService)paramAppInterface.getRuntimeService(IGPSService.class, "");
    boolean bool2 = false;
    boolean bool1;
    if (paramInt2 == 24000)
    {
      bool1 = bool2;
    }
    else
    {
      if (paramInt1 == 2) {}
      do
      {
        bool1 = true;
        break;
        bool1 = bool2;
        if (paramInt1 != 1) {
          break;
        }
        bool1 = bool2;
        if (paramIGProUserInfo == null) {
          break;
        }
        bool1 = bool2;
        if (paramIGProUserInfo.d() == 1) {
          break;
        }
        bool1 = bool2;
      } while (paramIGProUserInfo.d() != 2);
    }
    paramAppInterface = new AllInOne(paramString1, 122);
    paramAppInterface.troopCode = paramString4;
    paramAppInterface.troopUin = paramString2;
    if (paramIGProUserInfo != null)
    {
      paramAppInterface.nickname = paramIGProUserInfo.c();
      paramAppInterface.remark = paramIGProUserInfo.b();
      paramAppInterface.extras.putInt("guild_open_user_type", paramIGProUserInfo.d());
      paramAppInterface.extras.putInt("guild_open_robot_type", paramIGProUserInfo.f());
      paramAppInterface.extras.putBoolean("guild_open_user_guild_mute", paramIGProUserInfo.g());
    }
    paramAppInterface.extras.putBoolean("guild_is_self", paramString1.equals(localIGPSService.getSelfTinyId()));
    paramAppInterface.extras.putBoolean("guild_user_allow_admin", bool1);
    paramAppInterface.extras.putInt("guild_self_user_type", paramInt1);
    paramAppInterface.extras.putString("guild_current_channel_id", paramString3);
    paramString1 = new StringBuilder();
    paramString1.append("openGuildMemberCard guild_user_allow_admin:");
    paramString1.append(bool1);
    paramString1.append(",guild_self_user_type:");
    paramString1.append(paramInt1);
    QLog.i("QQGuildUtil", 1, paramString1.toString());
    paramAppInterface.profileEntryType = 129;
    paramAppInterface.lastActivity = 3;
    ProfileUtils.openProfileCardForResult(paramActivity, paramAppInterface, paramInt3);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, IGProGuildInfo paramIGProGuildInfo, IGProChannelInfo paramIGProChannelInfo)
  {
    if ((paramAppInterface != null) && (paramContext != null) && (paramIGProGuildInfo != null) && (paramIGProChannelInfo != null))
    {
      if (paramIGProChannelInfo.getType() == 2)
      {
        ((ILaunchGuildChatPieApi)QRoute.api(ILaunchGuildChatPieApi.class)).launchAudioChatPie(paramContext, paramIGProGuildInfo, paramIGProChannelInfo, false);
        return;
      }
      paramAppInterface = new LaunchGuildChatPieParam().a(paramIGProGuildInfo.getGuildID()).b(paramIGProChannelInfo.getChannelUin()).a(null).b(false).c(false).b();
      ((ILaunchGuildChatPieApi)QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildChatPie(paramContext, paramAppInterface);
      return;
    }
    QLog.e("QQGuildUtil", 1, "openChannel error param");
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    e.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public static void a(AppRuntime paramAppRuntime, Context paramContext, Bundle paramBundle, boolean paramBoolean, String paramString)
  {
    a(paramAppRuntime, paramContext, paramBundle, paramBoolean, paramString, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, Context paramContext, Bundle paramBundle, boolean paramBoolean, String paramString1, String paramString2)
  {
    IGPSService localIGPSService = (IGPSService)paramAppRuntime.getRuntimeService(IGPSService.class, "");
    IGProGuildInfo localIGProGuildInfo = localIGPSService.getGuildInfo(paramString1);
    List localList = localIGPSService.getChannelList(paramString1);
    int i;
    if ((!TextUtils.isEmpty(paramString2)) && (localIGPSService.getChannelInfo(paramString2) == null)) {
      i = 0;
    } else {
      i = 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openGuild isCreate:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(",channelInfoList size:");
    Object localObject;
    if (localList == null) {
      localObject = "null";
    } else {
      localObject = Integer.valueOf(localList.size());
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(",channelId:");
    localStringBuilder.append(paramString2);
    QLog.i("QQGuildUtil", 1, localStringBuilder.toString());
    if ((localIGProGuildInfo != null) && (localList != null) && (localList.size() != 0) && (!paramBoolean) && (i != 0))
    {
      b(paramAppRuntime, paramContext, localList, paramString2, localIGProGuildInfo, paramBundle, paramBoolean);
      return;
    }
    localIGPSService.fetchGuildInfo(paramString1, new QQGuildUtil.2(localIGPSService, paramString1, paramString2, paramAppRuntime, paramContext, paramBundle, paramBoolean));
  }
  
  public static boolean a()
  {
    return true;
  }
  
  public static boolean a(Context paramContext, IGProSecurityResult paramIGProSecurityResult)
  {
    if ((paramIGProSecurityResult != null) && (paramIGProSecurityResult.a() == 102L))
    {
      paramContext = DialogUtil.a(paramContext, 230).setTitle("帐号实名认证").setMessage("为了满足相关法律法规的网络实名制要求，请提供真实信息进行实名认证。").setPositiveButton(2131892267, new QQGuildUtil.4(paramIGProSecurityResult, paramContext)).setNegativeButton(2131887648, new QQGuildUtil.3());
      paramContext.setCancelable(true);
      paramContext.setCanceledOnTouchOutside(true);
      paramContext.show();
      return true;
    }
    return false;
  }
  
  public static boolean a(QBaseActivity paramQBaseActivity, String paramString)
  {
    Object localObject = (IGPSService)paramQBaseActivity.getAppRuntime().getRuntimeService(IGPSService.class, "");
    paramQBaseActivity = ((IGPSService)localObject).getChannelCategoryList(paramString);
    paramString = ((IGPSService)localObject).getGuildInfo(paramString);
    boolean bool1 = false;
    if (paramString == null) {}
    while (paramString.getUserType() != 0)
    {
      i = 0;
      break;
    }
    int i = 1;
    paramQBaseActivity = paramQBaseActivity.iterator();
    boolean bool2;
    do
    {
      bool2 = bool1;
      if (!paramQBaseActivity.hasNext()) {
        break;
      }
      paramString = ((ICategoryInfo)paramQBaseActivity.next()).c().iterator();
      do
      {
        bool2 = bool1;
        if (!paramString.hasNext()) {
          break;
        }
        localObject = (IGProChannelInfo)paramString.next();
      } while ((((IGProChannelInfo)localObject).getType() != 1) || (((IGProChannelInfo)localObject).getTalkPermission() == 0) || ((((IGProChannelInfo)localObject).getTalkPermission() == 2) && (i != 0)));
      bool2 = true;
      bool1 = bool2;
    } while (!bool2);
    return bool2;
  }
  
  public static boolean a(IGProGuildInfo paramIGProGuildInfo)
  {
    if (paramIGProGuildInfo == null) {
      return false;
    }
    if (paramIGProGuildInfo.getUserType() != 2) {
      return paramIGProGuildInfo.getUserType() == 1;
    }
    return true;
  }
  
  public static boolean a(IGProSecurityResult paramIGProSecurityResult)
  {
    return (paramIGProSecurityResult == null) || (paramIGProSecurityResult.a() == 0L);
  }
  
  public static boolean a(String paramString)
  {
    int i;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("://qun.qq.com/qqweb/qunpro/share")) && (paramString.contains("inviteCode"))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return false;
    }
    return ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).isShowGuildTab();
  }
  
  public static IGProChannelInfo b(@NonNull List<IGProChannelInfo> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      IGProChannelInfo localIGProChannelInfo = (IGProChannelInfo)localIterator.next();
      if (localIGProChannelInfo.getType() == 1) {
        return localIGProChannelInfo;
      }
    }
    if ((paramList != null) && (paramList.size() > 0)) {
      return (IGProChannelInfo)paramList.get(0);
    }
    return null;
  }
  
  public static <T extends IRuntimeService> T b(@NonNull Class<T> paramClass)
  {
    return a(paramClass, "");
  }
  
  public static void b(Context paramContext, String paramString)
  {
    Object localObject = c();
    if ((localObject != null) && (!((QQGuildConfigBean)localObject).c.isEmpty()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((QQGuildConfigBean)localObject).c);
      localStringBuilder.append("&gc=");
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
      localObject = new Intent(paramContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramString);
      paramContext.startActivity((Intent)localObject);
      return;
    }
    if (localObject != null)
    {
      paramContext = new StringBuilder();
      paramContext.append("robotListUrl : ");
      paramContext.append(((QQGuildConfigBean)localObject).c);
      QLog.w("QQGuildUtil", 2, paramContext.toString());
    }
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramString1 = URLUtil.a(paramString1, "from", String.valueOf(paramInt));
    paramString2 = new Intent(paramContext, QQBrowserActivity.class);
    paramString2.putExtra("url", paramString1);
    paramContext.startActivity(paramString2);
  }
  
  private static void b(@NonNull ImageView paramImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable();
    paramImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
  }
  
  public static void b(String paramString) {}
  
  private static void b(AppRuntime paramAppRuntime, Context paramContext, List<IGProChannelInfo> paramList, String paramString, IGProGuildInfo paramIGProGuildInfo, Bundle paramBundle, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ((ILaunchGuildChatPieApi)QRoute.api(ILaunchGuildChatPieApi.class)).launchAudioChatPie(paramContext, paramIGProGuildInfo, ((IGPSService)paramAppRuntime.getRuntimeService(IGPSService.class, "")).getChannelInfo(paramString), false);
      return;
    }
    paramAppRuntime = a(paramList);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = new LaunchGuildChatPieParam().a(paramIGProGuildInfo.getGuildID()).b(paramAppRuntime.getChannelUin()).a(paramBundle).b(false).c(false).b();
    ((ILaunchGuildChatPieApi)QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildChatPie(paramContext, paramAppRuntime);
  }
  
  public static boolean b()
  {
    QQGuildConfigBean localQQGuildConfigBean = c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("is RobotEntrance open: ");
    boolean bool;
    if ((localQQGuildConfigBean != null) && (localQQGuildConfigBean.b)) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    QLog.d("QQGuildUtil", 4, localStringBuilder.toString());
    return (localQQGuildConfigBean != null) && (localQQGuildConfigBean.b);
  }
  
  public static boolean b(IGProGuildInfo paramIGProGuildInfo)
  {
    if (paramIGProGuildInfo == null) {
      return false;
    }
    return paramIGProGuildInfo.getUserType() == 2;
  }
  
  public static boolean b(IGProUserInfo paramIGProUserInfo)
  {
    return paramIGProUserInfo.d() == 2;
  }
  
  public static QQGuildConfigBean c()
  {
    return (QQGuildConfigBean)QConfigManager.b().b(733);
  }
  
  public static void c(Context paramContext, String paramString)
  {
    QQToast.makeText(paramContext, 2, paramString, 1).show();
  }
  
  public static void c(String paramString)
  {
    paramString = new QQGuildUtil.8(paramString);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramString.run();
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(paramString);
  }
  
  public static boolean c(IGProUserInfo paramIGProUserInfo)
  {
    int i = paramIGProUserInfo.d();
    boolean bool = true;
    if (i != 1)
    {
      if (paramIGProUserInfo.d() == 2) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static boolean d()
  {
    QQGuildConfigBean localQQGuildConfigBean = (QQGuildConfigBean)QConfigManager.b().b(733);
    return (localQQGuildConfigBean != null) && (localQQGuildConfigBean.g);
  }
  
  public static boolean d(IGProUserInfo paramIGProUserInfo)
  {
    return paramIGProUserInfo.d() == 0;
  }
  
  public static boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l > 0L;
    }
    catch (Exception paramString)
    {
      QLog.e("QQGuildUtil", 1, paramString, new Object[0]);
    }
    return true;
  }
  
  public static String e()
  {
    return f;
  }
  
  public static boolean e(IGProUserInfo paramIGProUserInfo)
  {
    return paramIGProUserInfo.f() == 1;
  }
  
  public static boolean e(String paramString)
  {
    boolean bool3 = e.containsKey(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramString = (Boolean)e.get(paramString);
      bool1 = bool2;
      if (paramString != null) {
        bool1 = paramString.booleanValue();
      }
    }
    return bool1;
  }
  
  @NonNull
  public static String f()
  {
    String str2 = g().getAccount();
    String str1 = str2;
    if (str2 == null) {
      str1 = "null";
    }
    return str1;
  }
  
  public static void f(String paramString)
  {
    f = paramString;
  }
  
  @NonNull
  public static Intent g(@NonNull String paramString)
  {
    Intent localIntent = new Intent(MobileQQ.sMobileQQ.getApplicationContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    return localIntent;
  }
  
  @NonNull
  public static AppInterface g()
  {
    return (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public static Context h()
  {
    return MobileQQ.sMobileQQ.getApplicationContext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.QQGuildUtil
 * JD-Core Version:    0.7.0.1
 */