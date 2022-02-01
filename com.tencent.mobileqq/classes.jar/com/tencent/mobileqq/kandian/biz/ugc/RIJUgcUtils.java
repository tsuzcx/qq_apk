package com.tencent.mobileqq.kandian.biz.ugc;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.account.api.impl.RIJUserProtoUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSLiteSwitchManager;
import com.tencent.mobileqq.kandian.biz.tab.RIJTabFrameDeliverPopupUtil;
import com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame;
import com.tencent.mobileqq.kandian.biz.ugc.account.RIJUGCAddAccountFragment;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcEntryExtraInfo;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.mobileqq.kandian.biz.ugc.selectvideo.SelectVideoFragment;
import com.tencent.mobileqq.kandian.biz.ugc.selectvideotab.SelectVideoTabFragment;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.viola.event.ViolaEvent;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.account.UserLevelInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.ColumnInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.JumpInfo;
import com.tencent.mobileqq.kandian.repo.ugc.RIJUGCAccountCreateModule;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJUgcUtils
{
  @VisibleForTesting
  static int a(UgcVideo paramUgcVideo)
  {
    int k = paramUgcVideo.status;
    int m = UgcVideo.STATUS_IDLE;
    int j = 8;
    int i = j;
    if (k != m)
    {
      if (paramUgcVideo.status == UgcVideo.STATUS_PAUSE) {
        return 8;
      }
      if (paramUgcVideo.status == UgcVideo.STATUS_UPLOADING)
      {
        if (paramUgcVideo.uploadVideoStatus == UgcVideo.SUBSTATUS_COMPRESS_VIDEO) {
          return 1;
        }
        i = j;
        if (paramUgcVideo.uploadVideoStatus == UgcVideo.SUBSTATUS_UPLOADING_VIDEO) {
          return 6;
        }
      }
      else
      {
        if (paramUgcVideo.status == UgcVideo.STATUS_FINISH) {
          return 13;
        }
        if (paramUgcVideo.status == UgcVideo.STATUS_FAILED) {
          return 9;
        }
        i = 0;
      }
    }
    return i;
  }
  
  @NotNull
  public static RIJTransMergeKanDianReport.ReportR5Builder a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    return new RIJTransMergeKanDianReport.ReportR5Builder().addValueSafe("uin", paramQQAppInterface.getCurrentAccountUin()).addValueSafe("page_type", Integer.valueOf(paramInt1)).addValueSafe("secret_flag", Integer.valueOf(paramInt2));
  }
  
  @NotNull
  public static RIJTransMergeKanDianReport.ReportR5Builder a(@Nullable QQAppInterface paramQQAppInterface, @NotNull UgcVideo paramUgcVideo)
  {
    if (paramQQAppInterface != null) {
      paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    } else {
      paramQQAppInterface = "";
    }
    return new RIJTransMergeKanDianReport.ReportR5Builder().addValueSafe("uin", paramQQAppInterface).addValueSafe("seqId", paramUgcVideo.seqId).addValueSafe("file_size", Long.valueOf(paramUgcVideo.fileSize)).addValueSafe("format", a(paramUgcVideo.filePath)).addValueSafe("bit_rate", Long.valueOf(paramUgcVideo.bitrate)).addValueSafe("heigth", Integer.valueOf(paramUgcVideo.height)).addValueSafe("width", Integer.valueOf(paramUgcVideo.width)).addValueSafe("video_duration", Integer.valueOf(paramUgcVideo.duration));
  }
  
  public static String a(long paramLong)
  {
    if (paramLong < 1024L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong);
      localStringBuilder.append("B");
      return localStringBuilder.toString();
    }
    if (paramLong < 1048576L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.format(Locale.getDefault(), "%.1f", new Object[] { Float.valueOf((float)paramLong / 1024.0F) }));
      localStringBuilder.append("KB");
      return localStringBuilder.toString();
    }
    if (paramLong < 1073741824L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.format(Locale.getDefault(), "%.1f", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F) }));
      localStringBuilder.append("MB");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format(Locale.getDefault(), "%.1f", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F / 1024.0F) }));
    localStringBuilder.append("GB");
    return localStringBuilder.toString();
  }
  
  public static String a(Context paramContext)
  {
    return Aladdin.getConfig(277).getString("ugc_publish_create_text", paramContext.getResources().getString(2131915352));
  }
  
  @NotNull
  public static String a(@Nullable String paramString)
  {
    if (paramString != null)
    {
      if (paramString.isEmpty()) {
        return "";
      }
      int i = paramString.lastIndexOf(".");
      if (i >= 0)
      {
        if (i >= paramString.length() - 1) {
          return "";
        }
        return paramString.substring(i + 1).toLowerCase();
      }
    }
    return "";
  }
  
  public static JSONArray a(@NotNull List<UgcVideo> paramList)
  {
    localJSONArray = new JSONArray();
    try
    {
      Object localObject = new DecimalFormat("0.00");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        UgcVideo localUgcVideo = (UgcVideo)paramList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("vid", String.valueOf(localUgcVideo.seqId));
        localJSONObject.put("status", a(localUgcVideo));
        localJSONObject.put("totalSize", a(localUgcVideo.fileSize));
        localJSONObject.put("duration", localUgcVideo.duration);
        localJSONObject.put("title", localUgcVideo.title);
        localJSONObject.put("coverUrl", localUgcVideo.coverUrl);
        localJSONObject.put("compressProgress", ((DecimalFormat)localObject).format(localUgcVideo.compressProgress * 1.0F / 100.0F));
        localJSONObject.put("uploadingProgress", ((DecimalFormat)localObject).format(localUgcVideo.videoProgress * 1.0F / 100.0F));
        localJSONObject.put("networkSpeed", localUgcVideo.uploadSpeed);
        localJSONObject.put("uploadSize", a(localUgcVideo.fileSize * localUgcVideo.videoProgress / 100L));
        localJSONArray.put(localJSONObject);
      }
      return localJSONArray;
    }
    catch (Exception paramList)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getUploadVideoListForViola exception, e=");
      ((StringBuilder)localObject).append(QLog.getStackTraceString(paramList));
      QLog.i("RIJUGC.RIJUgcUtils", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    QPublicFragmentActivity.Launcher.a(paramActivity, localIntent, QPublicTransFragmentActivity.class, RIJUGCAddAccountFragment.class, 10000);
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    RIJUserProtoUtils.INSTANCE.check(paramActivity, new RIJUgcUtils.8(paramActivity, paramInt));
  }
  
  private static void a(Activity paramActivity, int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramActivity == null) {
      return;
    }
    paramString = DialogUtil.a(paramActivity, 0, paramActivity.getString(2131915772), paramActivity.getString(2131915771), paramActivity.getString(2131915799), paramActivity.getString(2131915816), new RIJUgcUtils.4(paramString, paramActivity), new RIJUgcUtils.5());
    paramString.getBtnLeft().setTextColor(Color.parseColor("#03081A"));
    paramString.getBtnight().setTextColor(Color.parseColor("#00CAFC"));
    paramString.getMessageTextView().setTextColor(Color.parseColor("#878B99"));
    paramString.getTitleTextView().setTextColor(Color.parseColor("#03081A"));
    if (paramBoolean)
    {
      paramActivity = paramActivity.getString(2131915771);
      paramString.getMessageTextView().setText(String.format(paramActivity, new Object[] { Integer.valueOf(paramInt) }));
    }
    else
    {
      paramActivity = paramActivity.getString(2131915770);
      paramString.getMessageTextView().setText(String.format(paramActivity, new Object[] { Integer.valueOf(paramInt) }));
    }
    try
    {
      paramString.show();
    }
    catch (Throwable paramActivity)
    {
      QLog.e("RIJUGC.RIJUgcUtils", 1, "showCantUploadTips error", paramActivity);
    }
    ThreadManager.executeOnSubThread(new RIJUgcUtils.6());
  }
  
  public static void a(Activity paramActivity, RIJUgcUtils.RIJUGCAccountStatusCheckCallback paramRIJUGCAccountStatusCheckCallback)
  {
    if (ReadInJoyHelper.X())
    {
      a(paramRIJUGCAccountStatusCheckCallback);
      QLog.e("showOrDelayShowUGCAccountGuide", 1, "try to set UGCAccountGuide but do Nothing");
      return;
    }
    a(paramActivity);
  }
  
  public static void a(Activity paramActivity, UserLevelInfo paramUserLevelInfo)
  {
    if (paramActivity != null)
    {
      if (paramUserLevelInfo == null) {
        return;
      }
      Object localObject;
      if ((paramUserLevelInfo.opesAllowedMap != null) && (paramUserLevelInfo.opesAllowedMap.size() > 0))
      {
        localObject = (Boolean)paramUserLevelInfo.opesAllowedMap.get(Integer.valueOf(7));
        if ((localObject != null) && (!((Boolean)localObject).booleanValue()))
        {
          bool1 = false;
          break label67;
        }
      }
      boolean bool1 = true;
      label67:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleDeliverImageMenuItemClick(): isMatchUploadLevel:");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append(" userLevelInfo:");
        ((StringBuilder)localObject).append(paramUserLevelInfo);
        QLog.d("RIJUGC.RIJUgcUtils", 2, ((StringBuilder)localObject).toString());
      }
      if (bool1)
      {
        boolean bool2 = ReadInJoyHelper.V();
        boolean bool3 = PTSLiteSwitchManager.a().b();
        if ((!bool2) && (bool3)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if (QLog.isColorLevel())
        {
          paramUserLevelInfo = new StringBuilder();
          paramUserLevelInfo.append("handleDeliverImageMenuItemClick(): needShowUGCAccountGuide:");
          paramUserLevelInfo.append(bool1);
          paramUserLevelInfo.append(", isCompeteUseAccountGuide: ");
          paramUserLevelInfo.append(bool2);
          paramUserLevelInfo.append(", isPtsLiteEnable:");
          paramUserLevelInfo.append(bool3);
          QLog.d("RIJUGC.RIJUgcUtils", 2, paramUserLevelInfo.toString());
        }
        if (bool1)
        {
          a(paramActivity, new RIJUgcUtils.RIJUGCAccountStatusCheckCallback(paramActivity, 2));
          QLog.e("deliverImageUserLevelRequestCallback", 1, "try to go to an unpublished function");
          return;
        }
        a(paramActivity, 0);
        return;
      }
      a(paramActivity, (int)paramUserLevelInfo.level, paramUserLevelInfo.jumpUrl, false);
    }
  }
  
  public static void a(Activity paramActivity, @Nullable ColumnInfo paramColumnInfo, int paramInt)
  {
    Intent localIntent = new Intent();
    if (paramColumnInfo != null) {
      localIntent.putExtra("key_column_info", paramColumnInfo);
    }
    localIntent.putExtra("key_from", paramInt);
    if ((paramInt != 1) && (paramInt != 2))
    {
      if ((paramInt == 3) || (paramInt == 4)) {
        PublicFragmentActivity.a(paramActivity, localIntent, SelectVideoTabFragment.class);
      }
    }
    else {
      PublicFragmentActivity.a(paramActivity, localIntent, SelectVideoFragment.class);
    }
    RIJTabFrameDeliverPopupUtil.a("0X800AC6D", paramInt);
  }
  
  public static void a(Activity paramActivity, @Nullable ColumnInfo paramColumnInfo, @Nullable CommunityInfo paramCommunityInfo, int paramInt1, @Nullable String paramString, int paramInt2)
  {
    a(paramActivity, paramColumnInfo, paramCommunityInfo, null, paramInt1, paramString, paramInt2);
  }
  
  public static void a(Activity paramActivity, @Nullable ColumnInfo paramColumnInfo, @Nullable CommunityInfo paramCommunityInfo, @Nullable UgcEntryExtraInfo paramUgcEntryExtraInfo, int paramInt1, @Nullable String paramString, int paramInt2)
  {
    Intent localIntent = new Intent();
    if (paramColumnInfo != null) {
      localIntent.putExtra("key_column_info", paramColumnInfo);
    }
    if (paramCommunityInfo != null) {
      localIntent.putExtra("key_kd_community_info", paramCommunityInfo);
    }
    if (paramUgcEntryExtraInfo != null) {
      localIntent.putExtra("key_ugc_entry_extra_info", paramUgcEntryExtraInfo);
    }
    localIntent.putExtra("key_from", paramInt1);
    if (paramString != null) {
      localIntent.putExtra("arg_callback", paramString);
    }
    if ((paramInt1 != 3) && (paramInt1 != 4)) {
      PublicFragmentActivity.a(paramActivity, localIntent, SelectVideoFragment.class, paramInt2);
    } else {
      PublicFragmentActivity.a(paramActivity, localIntent, SelectVideoTabFragment.class, paramInt2);
    }
    RIJTabFrameDeliverPopupUtil.a("0X800AC6D", paramInt1);
  }
  
  public static void a(@NotNull Context paramContext, long paramLong, @NotNull RIJUgcUtils.IUploadActionCallback paramIUploadActionCallback, @Nullable DialogInterface.OnDismissListener paramOnDismissListener)
  {
    paramContext = DialogUtil.a(paramContext, 230).setMessage(paramContext.getResources().getString(2131915558, new Object[] { a(paramLong) })).setNegativeButton(paramContext.getResources().getString(2131915302), new RIJUgcUtils.2(paramIUploadActionCallback)).setPositiveButton(paramContext.getResources().getString(2131915460), new RIJUgcUtils.1(paramIUploadActionCallback));
    if (paramOnDismissListener != null) {
      paramContext.setOnDismissListener(new RIJUgcUtils.3(paramOnDismissListener));
    }
    paramContext.show();
  }
  
  private static void a(RIJUgcUtils.RIJUGCAccountStatusCheckCallback paramRIJUGCAccountStatusCheckCallback)
  {
    RIJUGCAccountCreateModule localRIJUGCAccountCreateModule = ReadInJoyLogicEngine.a().o();
    if (localRIJUGCAccountCreateModule == null) {
      return;
    }
    localRIJUGCAccountCreateModule.a(RIJQQAppInterfaceUtil.c(), paramRIJUGCAccountStatusCheckCallback);
  }
  
  public static void a(String paramString, UgcVideo paramUgcVideo)
  {
    long l2 = System.currentTimeMillis() - paramUgcVideo.startUploadingTime;
    paramUgcVideo.uploadTotalCostTime += l2;
    long l3 = paramUgcVideo.startUserWaitingTime;
    long l1 = 0L;
    if (l3 > 0L)
    {
      l1 = System.currentTimeMillis() - paramUgcVideo.startUserWaitingTime;
      paramUgcVideo.userWaitingTotalCostTime += l1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("calculateUploadingCost,");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", cost=");
    localStringBuilder.append(l2);
    localStringBuilder.append(",totalCost=");
    localStringBuilder.append(paramUgcVideo.uploadTotalCostTime);
    localStringBuilder.append(", waitingCost=");
    localStringBuilder.append(l1);
    localStringBuilder.append(", totalWaitingCost=");
    localStringBuilder.append(paramUgcVideo.userWaitingTotalCostTime);
    QLog.i("RIJUGC.RIJUgcUtils", 1, localStringBuilder.toString());
  }
  
  public static boolean a()
  {
    if (u()) {
      return true;
    }
    return (b() == 1) && (!ReadInJoyHelper.V());
  }
  
  public static boolean a(int paramInt)
  {
    if (u()) {
      return true;
    }
    if (UgcPublishPermissionUtil.a.a()) {
      return false;
    }
    return (paramInt & 0x2) != 0;
  }
  
  public static boolean a(@Nullable QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (u()) {
      return true;
    }
    boolean bool2 = false;
    if (paramQQAppInterface == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (k())
    {
      bool1 = bool2;
      if (!paramBoolean) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static int b()
  {
    if (u()) {
      return 2;
    }
    return Aladdin.getConfig(277).getIntegerFromString("ugc_video_upload_main_switch", 0);
  }
  
  public static long b(@NotNull UgcVideo paramUgcVideo)
  {
    long l2 = paramUgcVideo.fileSize - paramUgcVideo.videoProgress * paramUgcVideo.fileSize / 100L;
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 0L;
    }
    return l1;
  }
  
  public static long b(@NotNull List<UgcVideo> paramList)
  {
    boolean bool = paramList.isEmpty();
    long l = 0L;
    if (bool) {
      return 0L;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      l += b((UgcVideo)paramList.next());
    }
    return l;
  }
  
  public static String b(Context paramContext)
  {
    return Aladdin.getConfig(277).getString("ugc_video_create_text", paramContext.getResources().getString(2131915478));
  }
  
  public static void b(Activity paramActivity)
  {
    if (UgcPublishPermissionUtil.a.a())
    {
      RIJUserLevelModule.getInstance().requestUserLevel(7, new RIJUgcUtils.7(paramActivity));
      return;
    }
    a(paramActivity, 0);
  }
  
  public static void b(Activity paramActivity, UserLevelInfo paramUserLevelInfo)
  {
    if (paramActivity != null)
    {
      if (paramUserLevelInfo == null) {
        return;
      }
      boolean bool2 = false;
      Object localObject;
      if ((paramUserLevelInfo != null) && (paramUserLevelInfo.opesAllowedMap != null) && (paramUserLevelInfo.opesAllowedMap.size() > 0))
      {
        localObject = (Boolean)paramUserLevelInfo.opesAllowedMap.get(Integer.valueOf(6));
        if ((localObject != null) && (!((Boolean)localObject).booleanValue()))
        {
          bool1 = false;
          break label73;
        }
      }
      boolean bool1 = true;
      label73:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleUploadVideoMenuItemClick(): isMatchUploadLevel:");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append(" userLevelInfo:");
        ((StringBuilder)localObject).append(paramUserLevelInfo);
        QLog.d("RIJUGC.RIJUgcUtils", 2, ((StringBuilder)localObject).toString());
      }
      if (bool1)
      {
        boolean bool3 = ReadInJoyHelper.V();
        boolean bool4 = PTSLiteSwitchManager.a().b();
        bool1 = bool2;
        if (!bool3)
        {
          bool1 = bool2;
          if (bool4) {
            bool1 = true;
          }
        }
        if (QLog.isColorLevel())
        {
          paramUserLevelInfo = new StringBuilder();
          paramUserLevelInfo.append("handleUploadVideoMenuItemClick():  needShowUGCAccountGuide:");
          paramUserLevelInfo.append(bool1);
          paramUserLevelInfo.append(", isCompeteUseAccountGuide: ");
          paramUserLevelInfo.append(bool3);
          paramUserLevelInfo.append(", isPtsLiteEnable:");
          paramUserLevelInfo.append(bool4);
          QLog.d("RIJUGC.RIJUgcUtils", 2, paramUserLevelInfo.toString());
        }
        if (bool1)
        {
          a(paramActivity, new RIJUgcUtils.RIJUGCAccountStatusCheckCallback(paramActivity, 1));
          QLog.e("uploadVideoUserLevelRequestCallback", 1, "try to go to an unpublished function");
          return;
        }
        a(paramActivity, null, 1);
        return;
      }
      a(paramActivity, (int)paramUserLevelInfo.level, paramUserLevelInfo.jumpUrl, true);
    }
  }
  
  public static String c(Context paramContext)
  {
    return Aladdin.getConfig(295).getString("ugc_video_publish_public_and_remind_title", paramContext.getResources().getString(2131915472));
  }
  
  public static void c(Activity paramActivity)
  {
    if (UgcPublishPermissionUtil.a.a()) {
      RIJUserLevelModule.getInstance().requestUserLevel(6, new RIJUgcUtils.9(paramActivity));
    } else {
      a(paramActivity, null, 1);
    }
    ReadinjoyTabFrame.E();
  }
  
  private static void c(Activity paramActivity, int paramInt)
  {
    
    if (paramInt == 1)
    {
      a(paramActivity, null, 1);
      return;
    }
    if (paramInt == 2) {
      a(paramActivity, 0);
    }
  }
  
  public static void c(@NotNull UgcVideo paramUgcVideo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("vid", paramUgcVideo.seqId);
      localJSONObject.put("title", paramUgcVideo.title);
      localJSONObject.put("coverUrl", paramUgcVideo.coverUrl);
      localJSONObject.put("coverLocalPath", paramUgcVideo.coverPath);
      localJSONObject.put("coverWidth", paramUgcVideo.width);
      localJSONObject.put("coverHeight", paramUgcVideo.height);
      localJSONObject.put("duration", paramUgcVideo.duration * 1000);
      paramUgcVideo = paramUgcVideo.getMultiTitleStruct();
      if (paramUgcVideo != null)
      {
        paramUgcVideo = paramUgcVideo.iterator();
        while (paramUgcVideo.hasNext())
        {
          BiuCommentInfo localBiuCommentInfo = (BiuCommentInfo)paramUgcVideo.next();
          if ((localBiuCommentInfo.mOpType == 4) && (localBiuCommentInfo.jumpInfo != null)) {
            localJSONObject.put("kdCommunityId", localBiuCommentInfo.jumpInfo.getId());
          }
        }
      }
    }
    catch (JSONException paramUgcVideo)
    {
      QLog.e("RIJUGC.RIJUgcUtils", 1, "sendAddOrUpdateUgcVideoInfo", paramUgcVideo);
    }
    if (QLog.isColorLevel())
    {
      paramUgcVideo = new StringBuilder();
      paramUgcVideo.append("sendAddOrUpdateUgcVideoInfo, params=");
      paramUgcVideo.append(localJSONObject);
      QLog.i("RIJUGC.RIJUgcUtils", 2, paramUgcVideo.toString());
    }
    SimpleEventBus.getInstance().dispatchEvent(new ViolaEvent("addOrUpdateUgcVideoInfo", localJSONObject));
  }
  
  public static boolean c()
  {
    if (u()) {
      return true;
    }
    if (b() == 2) {
      return true;
    }
    if (b() == 1) {
      return ReadInJoyHelper.V();
    }
    return false;
  }
  
  public static String d(Context paramContext)
  {
    return Aladdin.getConfig(295).getString("ugc_video_publish_public_and_remind_tips", paramContext.getResources().getString(2131915473));
  }
  
  public static boolean d()
  {
    boolean bool2 = u();
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    if (Aladdin.getConfig(354).getIntegerFromString("ugc_publish_function_gif", 1) == 0) {
      bool1 = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showUgcPublishGifSwitch | show ");
    localStringBuilder.append(bool1);
    QLog.d("RIJUGC.RIJUgcUtils", 2, localStringBuilder.toString());
    return bool1;
  }
  
  public static String e(Context paramContext)
  {
    return Aladdin.getConfig(295).getString("ugc_video_publish_public_title", paramContext.getResources().getString(2131915471));
  }
  
  public static boolean e()
  {
    boolean bool2 = u();
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    if (Aladdin.getConfig(354).getIntegerFromString("ugc_publish_function_location", 0) == 0) {
      bool1 = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showUgcPublishLocationSwitch | show ");
    localStringBuilder.append(bool1);
    QLog.d("RIJUGC.RIJUgcUtils", 2, localStringBuilder.toString());
    return bool1;
  }
  
  public static String f(Context paramContext)
  {
    return Aladdin.getConfig(295).getString("ugc_video_publish_public_tips", paramContext.getResources().getString(2131915474));
  }
  
  public static boolean f()
  {
    boolean bool2 = u();
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    if (Aladdin.getConfig(354).getIntegerFromString("ugc_publish_entrance_topic", 0) == 0) {
      bool1 = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showUgcPublishTopicSwitch | show ");
    localStringBuilder.append(bool1);
    QLog.d("RIJUGC.RIJUgcUtils", 2, localStringBuilder.toString());
    return bool1;
  }
  
  public static int g()
  {
    int i = Aladdin.getConfig(354).getIntegerFromString("ugc_publish_restriction_textLength", 100);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getUgcPublishTextMaxLength | length ");
    localStringBuilder.append(i);
    QLog.d("RIJUGC.RIJUgcUtils", 2, localStringBuilder.toString());
    return i;
  }
  
  public static String g(Context paramContext)
  {
    return Aladdin.getConfig(295).getString("ugc_video_publish_private_title", paramContext.getResources().getString(2131915454));
  }
  
  public static String h(Context paramContext)
  {
    return Aladdin.getConfig(295).getString("ugc_video_publish_private_tips", paramContext.getResources().getString(2131915455));
  }
  
  public static boolean h()
  {
    boolean bool2 = u();
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    if (UgcPublishPermissionUtil.a.a()) {
      return true;
    }
    Object localObject = Aladdin.getConfig(277);
    if ((!c()) || (((AladdinConfig)localObject).getIntegerFromString("ugc_publish_create_entrance", 0) == 0)) {
      bool1 = false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showUgcPublishCreateEntrance | show ");
    ((StringBuilder)localObject).append(bool1);
    QLog.d("RIJUGC.RIJUgcUtils", 2, ((StringBuilder)localObject).toString());
    return bool1;
  }
  
  public static boolean i()
  {
    if (u()) {
      return true;
    }
    if (UgcPublishPermissionUtil.a.a()) {
      return true;
    }
    if (c()) {
      return j();
    }
    return false;
  }
  
  public static boolean j()
  {
    if (u()) {
      return true;
    }
    Object localObject = Aladdin.getConfig(277);
    boolean bool2 = false;
    int i = ((AladdinConfig)localObject).getIntegerFromString("ugc_video_upload_entrance", 0);
    int j = ((AladdinConfig)localObject).getIntegerFromString("ugc_upload_video_authority", 0);
    boolean bool1 = bool2;
    if (i == 1)
    {
      bool1 = bool2;
      if (j != 0) {
        bool1 = true;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showPublishVideoEntry | show ");
    ((StringBuilder)localObject).append(bool1);
    QLog.d("RIJUGC.RIJUgcUtils", 1, ((StringBuilder)localObject).toString());
    return bool1;
  }
  
  public static boolean k()
  {
    if (u()) {
      return true;
    }
    if (c()) {
      return Aladdin.getConfig(277).getIntegerFromString("add_to_column_entrance", 0) != 0;
    }
    return false;
  }
  
  public static boolean l()
  {
    if (u()) {
      return true;
    }
    if (UgcPublishPermissionUtil.a.a()) {
      return UgcPublishPermissionUtil.a.b();
    }
    return (c()) && (n());
  }
  
  public static boolean m()
  {
    if (u()) {
      return true;
    }
    return (ReadInJoyHelper.K(RIJQQAppInterfaceUtil.e()) & 0x2) != 0;
  }
  
  public static boolean n()
  {
    boolean bool1 = u();
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    bool1 = bool2;
    if (!h())
    {
      bool1 = bool2;
      if (!j())
      {
        if (m()) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public static int o()
  {
    return Aladdin.getConfig(279).getIntegerFromString("ugc_video_title_max_length", 36);
  }
  
  public static int p()
  {
    if (Aladdin.getConfig(295).getIntegerFromString("ugc_video_publish_show_public", 0) == 1) {
      return 0;
    }
    return 8;
  }
  
  public static int q()
  {
    int i = Aladdin.getConfig(295).getIntegerFromString("ugc_video_publish_public_default", 2);
    if (i == 1) {
      return UgcVideo.TYPE_PUBLIC_AND_REMIND;
    }
    if (i == 3) {
      return UgcVideo.TYPE_NO_PUBLIC;
    }
    return UgcVideo.TYPE_PUBLIC;
  }
  
  public static int r()
  {
    return Aladdin.getConfig(283).getIntegerFromString("upload_video_redirect", 2);
  }
  
  public static String s()
  {
    String str = Aladdin.getConfig(284).getString("ugc_topic_detail_page_url", "");
    if (!str.isEmpty()) {
      try
      {
        str = URLDecoder.decode(str, "UTF-8");
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getViolaColumnDetailPageUrl decode fail. e : ");
        localStringBuilder.append(localUnsupportedEncodingException.toString());
        QLog.e("RIJUGC.RIJUgcUtils", 1, localStringBuilder.toString());
        return "https://viola.qq.com/js/columnDetail.js?_rij_violaUrl=1&v_tid=6&v_bundleName=columnDetail&hideNav=1&v_nav_immer=1&statusColor=1&v_bid=3740&from_page=4&topicId=";
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("RIJUGC.RIJUgcUtils", 2, "getViolaColumnDetailPageUrl from aladdin fail.");
    }
    return "https://viola.qq.com/js/columnDetail.js?_rij_violaUrl=1&v_tid=6&v_bundleName=columnDetail&hideNav=1&v_nav_immer=1&statusColor=1&v_bid=3740&from_page=4&topicId=";
  }
  
  public static String t()
  {
    String str = Aladdin.getConfig(284).getString("ugc_my_video_list_page_url", "");
    if (!str.isEmpty()) {
      try
      {
        str = URLDecoder.decode(str, "UTF-8");
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getViolaMyVideoListPageUrl decode fail. e : ");
        localStringBuilder.append(localUnsupportedEncodingException.toString());
        QLog.e("RIJUGC.RIJUgcUtils", 1, localStringBuilder.toString());
        return "https://viola.qq.com/js/columnAddVideo.js?_rij_violaUrl=1&hideNav=1&v_nav_immer=1&v_tid=2&v_bundleName=columnAddVideo&v_bid=3740&colid=";
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("RIJUGC.RIJUgcUtils", 2, "getViolaMyVideoListPageUrl from aladdin fail.");
    }
    return "https://viola.qq.com/js/columnAddVideo.js?_rij_violaUrl=1&hideNav=1&v_nav_immer=1&v_tid=2&v_bundleName=columnAddVideo&v_bid=3740&colid=";
  }
  
  private static boolean u()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils
 * JD-Core Version:    0.7.0.1
 */