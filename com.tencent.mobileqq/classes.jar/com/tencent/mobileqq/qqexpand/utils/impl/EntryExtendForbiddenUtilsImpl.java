package com.tencent.mobileqq.qqexpand.utils.impl;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.TextView;
import com.google.gson.Gson;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqexpand.bean.profile.ExpandForbiddenInfo;
import com.tencent.mobileqq.qqexpand.network.ExpandCmdHandler;
import com.tencent.mobileqq.qqexpand.utils.IEntryExtendForbiddenUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.usercategory.ExtendFriendUserCategory.ForbiddenInfo;
import tencent.im.usercategory.ExtendFriendUserCategory.GetUserStatusReq;
import tencent.im.usercategory.ExtendFriendUserCategory.GetUserStatusRsp;

public class EntryExtendForbiddenUtilsImpl
  implements IEntryExtendForbiddenUtils
{
  private static final String SP_EXPAND_FORBIDDEN_INFO = "sp_expand_forbidden_info";
  private static final String SP_EXTEND_FRIEND_CHECK_INTERVAL = "sp_entry_expand_check_interval";
  private static final String SP_EXTEND_FRIEND_FORBIDDEN_END_TIME = "sp_extend_forbidden_end_time";
  private static final String SP_EXTEND_FRIEND_IS_FORBIDDEN = "sp_extend_friend_is_forbidden";
  private static final String SP_EXTEND_FRIEND_LENGGONG = "sp_entry_expand_lenggong";
  private static final String TAG = "EntryExpandForbiddenUtilsImpl";
  private static int count = 0;
  private static boolean isShowDialog = false;
  QQCustomDialog qqDialog;
  
  private void adaptionNightMode(QQCustomDialog paramQQCustomDialog)
  {
    if (paramQQCustomDialog == null) {
      return;
    }
    Context localContext = paramQQCustomDialog.getContext();
    if (localContext == null) {
      return;
    }
    Resources localResources = localContext.getResources();
    if (localResources == null) {
      return;
    }
    View localView = paramQQCustomDialog.findViewById(2131433638);
    if (localView == null) {
      localView = paramQQCustomDialog.findViewById(2131431871);
    } else {
      localView = localView.findViewById(2131431871);
    }
    if (localView == null) {
      return;
    }
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(localResources.getColor(2131168094));
    localGradientDrawable.setCornerRadius(DisplayUtil.a(localContext, 4.0F));
    localView.setBackgroundDrawable(localGradientDrawable);
    paramQQCustomDialog.getTitleTextView().setTextColor(Color.parseColor("#ffffff"));
    paramQQCustomDialog.getBtnight().setTextColor(Color.parseColor("#ffffff"));
  }
  
  private void dialog(Activity paramActivity, ExpandForbiddenInfo paramExpandForbiddenInfo)
  {
    String str = paramExpandForbiddenInfo.getForbiddenTips();
    long l = paramExpandForbiddenInfo.getForbiddenDuration();
    boolean bool = paramExpandForbiddenInfo.isForbidden();
    int j = paramExpandForbiddenInfo.getForbiddenType();
    paramExpandForbiddenInfo = getDialogMessage(paramActivity, str, false, l, bool);
    int i;
    if (bool) {
      i = 2131896787;
    } else {
      i = 2131896755;
    }
    ThreadManager.getUIHandlerV2().post(new EntryExtendForbiddenUtilsImpl.1(this, paramActivity, i, paramExpandForbiddenInfo, j, bool));
  }
  
  private ExpandForbiddenInfo getExtendInfoBySp()
  {
    String str = SharedPreUtils.a(MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentAccountUin(), "extend_friend_config_785").getString("sp_expand_forbidden_info", "");
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return (ExpandForbiddenInfo)new Gson().fromJson(str, ExpandForbiddenInfo.class);
  }
  
  private static ArrayList<String> getForbidTimeText(Activity paramActivity, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramLong > 86400L)
    {
      localArrayList.add(String.valueOf((paramLong + 86400L - 1L) / 86400L));
      localArrayList.add(paramActivity.getString(2131888406));
      return localArrayList;
    }
    if (paramLong > 3600L)
    {
      localArrayList.add(String.valueOf((paramLong + 3600L - 1L) / 3600L));
      localArrayList.add(paramActivity.getString(2131890771));
      return localArrayList;
    }
    if (paramLong > 60L)
    {
      localArrayList.add(String.valueOf((paramLong + 60L - 1L) / 60L));
      localArrayList.add(paramActivity.getString(2131891826));
      return localArrayList;
    }
    if (paramLong > 0L)
    {
      localArrayList.add(String.valueOf(paramLong));
      localArrayList.add(paramActivity.getString(2131916153));
      return localArrayList;
    }
    localArrayList.add(String.valueOf(0));
    localArrayList.add(paramActivity.getString(2131916153));
    return localArrayList;
  }
  
  public static void getInfoFromNet(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EntryExpandForbiddenUtilsImpl", 2, "getForbiddenInfo ");
    }
    ExtendFriendUserCategory.GetUserStatusReq localGetUserStatusReq = new ExtendFriendUserCategory.GetUserStatusReq();
    localGetUserStatusReq.ReqForbiddenInfo.set(true);
    paramQQAppInterface = ExpandCmdHandler.a(paramQQAppInterface);
    if (paramQQAppInterface == null)
    {
      QLog.w("EntryExpandForbiddenUtilsImpl", 1, "getForbiddenInfo cmdHandler is null!");
      return;
    }
    paramQQAppInterface.a("QQExpand.UserInfo.GetUserStatus", localGetUserStatusReq.toByteArray(), new EntryExtendForbiddenUtilsImpl.2());
  }
  
  private boolean isInNightMode()
  {
    return QQTheme.isNowThemeIsNight();
  }
  
  private boolean isNeedGetInfoFromNet()
  {
    SharedPreferences localSharedPreferences = SharedPreUtils.a(MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentAccountUin(), "extend_friend_config_785");
    long l1 = localSharedPreferences.getLong("sp_entry_expand_check_interval", 0L) / 1000L;
    long l2 = localSharedPreferences.getLong("sp_extend_forbidden_update_time", 0L);
    boolean bool = true;
    if (l2 != 0L)
    {
      if (l1 == 0L) {
        return true;
      }
      if (System.currentTimeMillis() - l2 > l1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static void updateForbiddenInfo(ExtendFriendUserCategory.GetUserStatusRsp paramGetUserStatusRsp)
  {
    boolean bool = paramGetUserStatusRsp.forbiddenInfo.isForbidden.get();
    long l1 = paramGetUserStatusRsp.forbiddenInfo.forbiddenEndTime.get();
    int i = paramGetUserStatusRsp.forbiddenInfo.forbiddenDuration.get();
    int j = paramGetUserStatusRsp.forbiddenInfo.fobiddenType.get();
    int k = paramGetUserStatusRsp.forbiddenInfo.beat_reason.get();
    String str = paramGetUserStatusRsp.forbiddenInfo.fobiddenTips.get();
    long l2 = paramGetUserStatusRsp.check_interval_ms.get();
    if (QLog.isColorLevel())
    {
      paramGetUserStatusRsp = new StringBuilder();
      paramGetUserStatusRsp.append("updateForbiddenInfo isForbidden ");
      paramGetUserStatusRsp.append(bool);
      paramGetUserStatusRsp.append(" forbiddenEndTime ");
      paramGetUserStatusRsp.append(l1);
      paramGetUserStatusRsp.append(" forbiddenDuration ");
      paramGetUserStatusRsp.append(i);
      paramGetUserStatusRsp.append(" forbiddenTips ");
      paramGetUserStatusRsp.append(str);
      paramGetUserStatusRsp.append(" forbiddenType ");
      paramGetUserStatusRsp.append(j);
      QLog.w("EntryExpandForbiddenUtilsImpl", 2, paramGetUserStatusRsp.toString());
      paramGetUserStatusRsp = new StringBuilder();
      paramGetUserStatusRsp.append("updateForbiddenInfo checkInterval ");
      paramGetUserStatusRsp.append(l2);
      QLog.w("EntryExpandForbiddenUtilsImpl", 2, paramGetUserStatusRsp.toString());
    }
    Object localObject = SharedPreUtils.a(MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentAccountUin(), "extend_friend_config_785");
    paramGetUserStatusRsp = ((SharedPreferences)localObject).edit();
    if (l1 != ((SharedPreferences)localObject).getLong("sp_extend_forbidden_end_time", 0L)) {
      paramGetUserStatusRsp.putLong("sp_extend_forbidden_update_time", System.currentTimeMillis());
    }
    ExpandForbiddenInfo localExpandForbiddenInfo = new ExpandForbiddenInfo(bool, l1, i, j, k, str);
    paramGetUserStatusRsp.putLong("sp_entry_expand_check_interval", l2);
    paramGetUserStatusRsp.putBoolean("sp_extend_friend_is_forbidden", bool);
    paramGetUserStatusRsp.putLong("sp_extend_forbidden_end_time", l1);
    Gson localGson = new Gson();
    if (j == 2)
    {
      localObject = ((SharedPreferences)localObject).getString("sp_expand_forbidden_info", null);
      if ((localObject != null) && (!((ExpandForbiddenInfo)localGson.fromJson((String)localObject, ExpandForbiddenInfo.class)).getForbiddenTips().equals(str))) {
        paramGetUserStatusRsp.putBoolean("sp_entry_expand_lenggong", false);
      }
    }
    paramGetUserStatusRsp.putString("sp_expand_forbidden_info", localGson.toJson(localExpandForbiddenInfo));
    paramGetUserStatusRsp.apply();
  }
  
  public SpannableStringBuilder getDialogMessage(Activity paramActivity, String paramString, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    Object localObject1 = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject1 = BaseApplicationImpl.getContext().getString(1913061382);
    }
    localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
    if (isInNightMode()) {
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(Color.parseColor("#ffffff")), 0, ((SpannableStringBuilder)localObject1).length(), 17);
    }
    if (!paramBoolean1)
    {
      if (!paramBoolean2) {
        return localObject1;
      }
      ((SpannableStringBuilder)localObject1).append("\n");
      Object localObject2 = new SpannableString("图");
      int i = ViewUtils.dip2px(20.0F);
      if (isInNightMode()) {
        paramString = paramActivity.getResources().getDrawable(2130842280);
      } else {
        paramString = paramActivity.getResources().getDrawable(2130842279);
      }
      paramString.setBounds(0, 0, i, i);
      ((SpannableString)localObject2).setSpan(new ImageSpan(paramString, 0), 0, ((SpannableString)localObject2).length(), 17);
      ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2);
      ((SpannableStringBuilder)localObject1).append(" ");
      paramString = paramActivity.getString(2131896788);
      localObject2 = getForbidTimeText(paramActivity, paramLong);
      paramActivity = String.format(" %s ", new Object[] { ((ArrayList)localObject2).get(0) });
      localObject2 = (String)((ArrayList)localObject2).get(1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(paramActivity);
      localStringBuilder.append((String)localObject2);
      localObject2 = new SpannableString(localStringBuilder.toString());
      ((SpannableString)localObject2).setSpan(new AbsoluteSizeSpan(14, true), 0, ((SpannableString)localObject2).length(), 17);
      ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(Color.parseColor("#878B99")), 0, ((SpannableString)localObject2).length(), 17);
      i = paramString.length();
      int j = paramString.length() + paramActivity.length();
      ((SpannableString)localObject2).setSpan(new AbsoluteSizeSpan(14, true), i, j, 33);
      if (QQTheme.isNowThemeIsNight()) {
        paramActivity = new ForegroundColorSpan(Color.parseColor("#FF5967"));
      } else {
        paramActivity = new ForegroundColorSpan(Color.parseColor("#D94C58"));
      }
      ((SpannableString)localObject2).setSpan(paramActivity, i, j, 17);
      ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2);
    }
    return localObject1;
  }
  
  public ExpandForbiddenInfo getForbiddenInfo(AppRuntime paramAppRuntime)
  {
    if (isNeedGetInfoFromNet()) {
      getInfoFromNet((QQAppInterface)paramAppRuntime);
    }
    return getExtendInfoBySp();
  }
  
  public boolean isNeedShowDiaLog(Context paramContext, AppRuntime paramAppRuntime)
  {
    if (!isNetSupport(paramContext)) {
      return true;
    }
    Object localObject = SharedPreUtils.a(MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentAccountUin(), "extend_friend_config_785");
    ExpandForbiddenInfo localExpandForbiddenInfo = getExtendInfoBySp();
    if (localExpandForbiddenInfo == null)
    {
      isShowDialog = true;
    }
    else if (localExpandForbiddenInfo.isForbidden())
    {
      isShowDialog = true;
    }
    else
    {
      if ((localExpandForbiddenInfo.getForbiddenType() != 2) || (((SharedPreferences)localObject).getBoolean("sp_entry_expand_lenggong", false))) {
        break label120;
      }
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("sp_entry_expand_lenggong", true);
      ((SharedPreferences.Editor)localObject).apply();
      isShowDialog = true;
    }
    showDialog((Activity)paramContext, paramAppRuntime);
    return isShowDialog;
    label120:
    return false;
  }
  
  public boolean isNetSupport(Context paramContext)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      QQToast.makeText(paramContext, 1, "网络连接异常，请检查后重试", 0).show();
      return false;
    }
    return true;
  }
  
  public void reportExposure(Object paramObject, int paramInt1, int paramInt2)
  {
    VideoReport.setPageId(paramObject, "pg_kl_limit_windows");
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("kl_limit_reason", String.valueOf(paramInt1));
    localHashMap.put("kl_isForbidden", String.valueOf(paramInt2));
    VideoReport.setPageParams(paramObject, new PageParams(localHashMap));
  }
  
  public void showDialog(Activity paramActivity, AppRuntime paramAppRuntime)
  {
    paramAppRuntime = getForbiddenInfo(paramAppRuntime);
    if (paramAppRuntime == null) {
      return;
    }
    dialog(paramActivity, paramAppRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.impl.EntryExtendForbiddenUtilsImpl
 * JD-Core Version:    0.7.0.1
 */