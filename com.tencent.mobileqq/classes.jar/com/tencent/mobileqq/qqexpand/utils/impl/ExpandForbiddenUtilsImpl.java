package com.tencent.mobileqq.qqexpand.utils.impl;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import com.google.gson.Gson;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqexpand.bean.profile.ExpandForbiddenInfo;
import com.tencent.mobileqq.qqexpand.manager.ExpandManager;
import com.tencent.mobileqq.qqexpand.manager.config.ExpandConfigManager;
import com.tencent.mobileqq.qqexpand.utils.ExpandReportUtils;
import com.tencent.mobileqq.qqexpand.utils.IExpandForbiddenUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.usercategory.ExtendFriendUserCategory.ForbiddenInfo;
import tencent.im.usercategory.ExtendFriendUserCategory.GetUserStatusRsp;

public class ExpandForbiddenUtilsImpl
  implements IExpandForbiddenUtils
{
  private static final String SP_EXPAND_FORBIDDEN_INFO = "sp_expand_forbidden_info";
  private static final String SP_EXTEND_FRIEND_FORBIDDEN_END_TIME = "sp_extend_forbidden_end_time";
  private static final String SP_EXTEND_FRIEND_IS_FORBIDDEN = "sp_extend_friend_is_forbidden";
  private static final String TAG = "ExpandForbiddenUtilsImpl";
  
  private static ArrayList<String> getRemainingForbidTimeText(Activity paramActivity, long paramLong)
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
  
  private static boolean isNeedReport(long paramLong1, long paramLong2, long paramLong3)
  {
    return (paramLong1 != paramLong3) && (paramLong1 != 0L) && (paramLong2 != 0L);
  }
  
  private static boolean isPassMinute(long paramLong, int paramInt)
  {
    boolean bool;
    if (System.currentTimeMillis() - paramLong >= paramInt * 60 * 1000) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("is pass ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ");
    localStringBuilder.append(bool);
    QLog.d("ExpandForbiddenUtilsImpl", 4, localStringBuilder.toString());
    return bool;
  }
  
  private static void reportLimitInfo(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("limit_days", String.valueOf(paramInt1));
    localHashMap.put("limit_reason", String.valueOf(paramInt2));
    ExpandReportUtils.a("success#limit_done#view", true, localHashMap);
  }
  
  public static void updateForbiddenInfo(ExtendFriendUserCategory.GetUserStatusRsp paramGetUserStatusRsp)
  {
    boolean bool = paramGetUserStatusRsp.forbiddenInfo.isForbidden.get();
    long l1 = paramGetUserStatusRsp.forbiddenInfo.forbiddenEndTime.get();
    int i = paramGetUserStatusRsp.forbiddenInfo.forbiddenDuration.get();
    int j = paramGetUserStatusRsp.forbiddenInfo.fobiddenType.get();
    int k = paramGetUserStatusRsp.forbiddenInfo.beat_reason.get();
    paramGetUserStatusRsp = paramGetUserStatusRsp.forbiddenInfo.fobiddenTips.get();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateForbiddenInfo isForbidden ");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(" forbiddenEndTime ");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(" forbiddenDuration ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" forbiddenTips ");
      ((StringBuilder)localObject).append(paramGetUserStatusRsp);
      ((StringBuilder)localObject).append(" forbiddenType ");
      ((StringBuilder)localObject).append(j);
      QLog.w("ExpandForbiddenUtilsImpl", 2, ((StringBuilder)localObject).toString());
    }
    SharedPreferences localSharedPreferences = SharedPreUtils.a(MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentAccountUin(), "extend_friend_config_785");
    Object localObject = localSharedPreferences.edit();
    long l2 = localSharedPreferences.getLong("sp_extend_forbidden_end_time", 0L);
    long l3 = i;
    if (isNeedReport(l1, l3, l2)) {
      reportLimitInfo(i, k);
    }
    if (l1 != l2) {
      ((SharedPreferences.Editor)localObject).putLong("sp_extend_forbidden_update_time", System.currentTimeMillis());
    }
    paramGetUserStatusRsp = new ExpandForbiddenInfo(bool, l1, l3, j, k, paramGetUserStatusRsp);
    ((SharedPreferences.Editor)localObject).putBoolean("sp_extend_friend_is_forbidden", bool);
    ((SharedPreferences.Editor)localObject).putLong("sp_extend_forbidden_end_time", l1);
    ((SharedPreferences.Editor)localObject).putString("sp_expand_forbidden_info", new Gson().toJson(paramGetUserStatusRsp));
    ((SharedPreferences.Editor)localObject).apply();
  }
  
  public SpannableStringBuilder getForbidDialogMessage(Activity paramActivity, String paramString, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    Object localObject1 = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject1 = BaseApplicationImpl.getContext().getString(1913061382);
    }
    paramString = new SpannableStringBuilder((CharSequence)localObject1);
    if (!paramBoolean1)
    {
      if (!paramBoolean2) {
        return paramString;
      }
      paramString.append("\n");
      localObject1 = new SpannableString("图");
      int i = ViewUtils.dip2px(20.0F);
      Object localObject2 = paramActivity.getResources().getDrawable(2130842279);
      ((Drawable)localObject2).setBounds(0, 0, i, i);
      ((SpannableString)localObject1).setSpan(new ImageSpan((Drawable)localObject2, 1), 0, ((SpannableString)localObject1).length(), 17);
      paramString.append((CharSequence)localObject1);
      paramString.append(" ");
      localObject1 = paramActivity.getString(2131896788);
      localObject2 = getRemainingForbidTimeText(paramActivity, paramLong);
      paramActivity = String.format(" %s ", new Object[] { ((ArrayList)localObject2).get(0) });
      localObject2 = (String)((ArrayList)localObject2).get(1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(paramActivity);
      localStringBuilder.append((String)localObject2);
      localObject2 = new SpannableString(localStringBuilder.toString());
      ((SpannableString)localObject2).setSpan(new AbsoluteSizeSpan(14, true), 0, ((SpannableString)localObject2).length(), 17);
      ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(Color.parseColor("#878B99")), 0, ((SpannableString)localObject2).length(), 17);
      i = ((String)localObject1).length();
      int j = ((String)localObject1).length() + paramActivity.length();
      ((SpannableString)localObject2).setSpan(new AbsoluteSizeSpan(24, true), i, j, 33);
      ((SpannableString)localObject2).setSpan(new StyleSpan(1), i, j, 33);
      paramString.append((CharSequence)localObject2);
    }
    return paramString;
  }
  
  @Nullable
  public ExpandForbiddenInfo getForbiddenInfo()
  {
    Object localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    ((ExpandManager)((AppRuntime)localObject1).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).q().l();
    localObject1 = SharedPreUtils.a(((AppRuntime)localObject1).getCurrentAccountUin(), "extend_friend_config_785");
    Object localObject2 = ((SharedPreferences)localObject1).getString("sp_expand_forbidden_info", "");
    if ((TextUtils.isEmpty((CharSequence)localObject2)) && (((SharedPreferences)localObject1).getBoolean("sp_extend_friend_is_forbidden", false))) {
      return new ExpandForbiddenInfo(true, ((SharedPreferences)localObject1).getLong("sp_extend_forbidden_end_time", 0L), 0L, 1, 1, BaseApplicationImpl.getContext().getString(1913061382));
    }
    localObject2 = (ExpandForbiddenInfo)new Gson().fromJson((String)localObject2, ExpandForbiddenInfo.class);
    if ((((ExpandForbiddenInfo)localObject2).getForbiddenType() == 3) && (!isPassMinute(((SharedPreferences)localObject1).getLong("sp_extend_forbidden_update_time", System.currentTimeMillis()), 5))) {
      ((ExpandForbiddenInfo)localObject2).setForbidden(false);
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.impl.ExpandForbiddenUtilsImpl
 * JD-Core Version:    0.7.0.1
 */