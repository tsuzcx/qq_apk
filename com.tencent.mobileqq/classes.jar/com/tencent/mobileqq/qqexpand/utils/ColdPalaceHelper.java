package com.tencent.mobileqq.qqexpand.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/utils/ColdPalaceHelper;", "", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "getApp", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "needWarnMeInColdPalace", "", "getNeedWarnMeInColdPalace", "()Z", "setNeedWarnMeInColdPalace", "(Z)V", "sp", "Landroid/content/SharedPreferences;", "getSp", "()Landroid/content/SharedPreferences;", "sp$delegate", "Lkotlin/Lazy;", "strSkillTip", "", "getStrSkillTip", "()Ljava/lang/String;", "strSkillTip$delegate", "strSkillUseupTip", "getStrSkillUseupTip", "strSkillUseupTip$delegate", "strWarnMeForbbiden", "getStrWarnMeForbbiden", "strWarnMeForbbiden$delegate", "strWarnMeFreeTime", "getStrWarnMeFreeTime", "strWarnMeFreeTime$delegate", "strWarnMeInColdPalace", "getStrWarnMeInColdPalace", "strWarnMeInColdPalace$delegate", "svrMeInColdPalaceTimes", "", "getSvrMeInColdPalaceTimes", "()I", "setSvrMeInColdPalaceTimes", "(I)V", "svrPunishLeftTime", "", "getSvrPunishLeftTime", "()J", "setSvrPunishLeftTime", "(J)V", "svrPunishTimeSince", "getSvrPunishTimeSince", "setSvrPunishTimeSince", "svrShowGrayTipEntry", "getSvrShowGrayTipEntry", "setSvrShowGrayTipEntry", "svrSkillTimesLeft", "getSvrSkillTimesLeft", "setSvrSkillTimesLeft", "svrStrSkillTip", "getSvrStrSkillTip", "setSvrStrSkillTip", "(Ljava/lang/String;)V", "svrStrSkillUseupTip", "getSvrStrSkillUseupTip", "setSvrStrSkillUseupTip", "svrStrSkillUseupTitle", "getSvrStrSkillUseupTitle", "setSvrStrSkillUseupTitle", "svrStrWarnMeForbbiden", "getSvrStrWarnMeForbbiden", "setSvrStrWarnMeForbbiden", "svrStrWarnMeInColdPalace", "getSvrStrWarnMeInColdPalace", "setSvrStrWarnMeInColdPalace", "addMeBlockedGrayTip", "", "frdUin", "uinType", "getMeInColdPalaceTimes", "getPunishLeftTime", "nowTs", "getSkillTimesLeft", "getWording", "type", "needWarnMePunish", "onGetWording", "wording", "setMeInColdPalaceTimes", "times", "setNeedShowGrayTipEntry", "show", "setPunishLeftTime", "time", "setSkillTimesLeft", "Companion", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ColdPalaceHelper
{
  public static final ColdPalaceHelper.Companion a;
  private volatile int jdField_a_of_type_Int;
  private volatile long jdField_a_of_type_Long;
  @NotNull
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  @NotNull
  public volatile String a;
  @NotNull
  private final Lazy jdField_a_of_type_KotlinLazy;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile int jdField_b_of_type_Int;
  private volatile long jdField_b_of_type_Long;
  @NotNull
  public volatile String b;
  @NotNull
  private final Lazy jdField_b_of_type_KotlinLazy;
  private volatile boolean jdField_b_of_type_Boolean;
  @NotNull
  public volatile String c;
  @NotNull
  private final Lazy c;
  @NotNull
  public volatile String d;
  @NotNull
  private final Lazy d;
  @NotNull
  public volatile String e;
  @NotNull
  private final Lazy e;
  @NotNull
  private final Lazy f;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqQqexpandUtilsColdPalaceHelper$Companion = new ColdPalaceHelper.Companion(null);
  }
  
  public ColdPalaceHelper(@NotNull QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)new ColdPalaceHelper.strSkillTip.2(this));
    this.jdField_b_of_type_KotlinLazy = LazyKt.lazy((Function0)new ColdPalaceHelper.strSkillUseupTip.2(this));
    this.jdField_c_of_type_KotlinLazy = LazyKt.lazy((Function0)new ColdPalaceHelper.strWarnMeInColdPalace.2(this));
    this.jdField_d_of_type_KotlinLazy = LazyKt.lazy((Function0)new ColdPalaceHelper.strWarnMeForbbiden.2(this));
    this.jdField_e_of_type_KotlinLazy = LazyKt.lazy((Function0)new ColdPalaceHelper.strWarnMeFreeTime.2(this));
    this.jdField_a_of_type_Int = -2147483648;
    this.f = LazyKt.lazy((Function0)new ColdPalaceHelper.sp.2(this));
    paramQQAppInterface = a().getString("key_skill_tip", "");
    Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "sp.getString(SP_KEY_SKILL_TIP, \"\")");
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface;
    paramQQAppInterface = a().getString("key_skill_useup_tip", "");
    Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "sp.getString(SP_KEY_SKILL_USEUP_TIP, \"\")");
    this.jdField_b_of_type_JavaLangString = paramQQAppInterface;
    paramQQAppInterface = a().getString("key_skill_useup_title", "");
    Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "sp.getString(SP_KEY_SKILL_USEUP_TITLE, \"\")");
    this.jdField_c_of_type_JavaLangString = paramQQAppInterface;
    paramQQAppInterface = a().getString("key_warn_me_in_coldpalace", "");
    Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "sp.getString(SP_KEY_WARN_ME_IN_COLDPALACE, \"\")");
    this.jdField_d_of_type_JavaLangString = paramQQAppInterface;
    paramQQAppInterface = a().getString("key_warn_me_forbbiden", "");
    Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "sp.getString(SP_KEY_WARN_ME_FORBBIDEN, \"\")");
    this.jdField_e_of_type_JavaLangString = paramQQAppInterface;
    this.jdField_a_of_type_Long = a().getLong("key_punish_left_time", 0L);
    this.jdField_b_of_type_Long = a().getLong("key_punish_time_since", 0L);
    this.jdField_b_of_type_Boolean = a().getBoolean("key_show_gray_tip_entry", this.jdField_b_of_type_Boolean);
    this.jdField_b_of_type_Int = a().getInt("key_me_in_cold_palace_times", 0);
  }
  
  @JvmStatic
  @NotNull
  public static final ColdPalaceHelper a(@NotNull BaseQQAppInterface paramBaseQQAppInterface)
  {
    return jdField_a_of_type_ComTencentMobileqqQqexpandUtilsColdPalaceHelper$Companion.a(paramBaseQQAppInterface);
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final SharedPreferences a()
  {
    return (SharedPreferences)this.f.getValue();
  }
  
  @NotNull
  public final QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  @NotNull
  public final String a()
  {
    return (String)this.jdField_a_of_type_KotlinLazy.getValue();
  }
  
  @NotNull
  public final String a(int paramInt)
  {
    Object localObject1;
    Object localObject2;
    String str;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return "";
              }
              localObject1 = StringCompanionObject.INSTANCE;
              localObject1 = e();
              localObject2 = new Object[0];
              localObject1 = String.format((String)localObject1, Arrays.copyOf((Object[])localObject2, localObject2.length));
              Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(format, *args)");
              return localObject1;
            }
            localObject1 = StringCompanionObject.INSTANCE;
            localObject1 = d();
            localObject2 = new Object[1];
            str = this.jdField_e_of_type_JavaLangString;
            if (str == null) {
              Intrinsics.throwUninitializedPropertyAccessException("svrStrWarnMeForbbiden");
            }
            localObject2[0] = str;
            localObject1 = String.format((String)localObject1, Arrays.copyOf((Object[])localObject2, localObject2.length));
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(format, *args)");
            return localObject1;
          }
          localObject1 = StringCompanionObject.INSTANCE;
          localObject1 = c();
          localObject2 = new Object[1];
          str = this.jdField_d_of_type_JavaLangString;
          if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("svrStrWarnMeInColdPalace");
          }
          localObject2[0] = str;
          localObject1 = String.format((String)localObject1, Arrays.copyOf((Object[])localObject2, localObject2.length));
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(format, *args)");
          return localObject1;
        }
        localObject1 = StringCompanionObject.INSTANCE;
        localObject1 = b();
        localObject2 = new Object[1];
        str = this.jdField_b_of_type_JavaLangString;
        if (str == null) {
          Intrinsics.throwUninitializedPropertyAccessException("svrStrSkillUseupTip");
        }
        localObject2[0] = str;
        localObject1 = String.format((String)localObject1, Arrays.copyOf((Object[])localObject2, localObject2.length));
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(format, *args)");
        return localObject1;
      }
      localObject2 = this.jdField_c_of_type_JavaLangString;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        Intrinsics.throwUninitializedPropertyAccessException("svrStrSkillUseupTitle");
        return localObject2;
      }
    }
    else
    {
      localObject1 = StringCompanionObject.INSTANCE;
      localObject1 = a();
      localObject2 = new Object[1];
      str = this.jdField_a_of_type_JavaLangString;
      if (str == null) {
        Intrinsics.throwUninitializedPropertyAccessException("svrStrSkillTip");
      }
      localObject2[0] = str;
      localObject1 = String.format((String)localObject1, Arrays.copyOf((Object[])localObject2, localObject2.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(format, *args)");
    }
    return localObject1;
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(int paramInt, @Nullable String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return;
            }
            this.jdField_e_of_type_JavaLangString = paramString;
            a().edit().putString("key_warn_me_forbbiden", paramString).apply();
            return;
          }
          this.jdField_d_of_type_JavaLangString = paramString;
          a().edit().putString("key_warn_me_in_coldpalace", paramString).apply();
          return;
        }
        this.jdField_b_of_type_JavaLangString = paramString;
        a().edit().putString("key_skill_useup_tip", paramString).apply();
        return;
      }
      this.jdField_c_of_type_JavaLangString = paramString;
      a().edit().putString("key_skill_useup_title", paramString).apply();
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    a().edit().putString("key_skill_tip", paramString).apply();
  }
  
  public final void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    a().edit().putLong("key_punish_left_time", paramLong1);
    a().edit().putLong("key_punish_time_since", paramLong2);
    a().edit().apply();
  }
  
  public final void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "frdUin");
    ThreadManager.executeOnSubThread((Runnable)new ColdPalaceHelper.addMeBlockedGrayTip.1(this, paramString, paramInt));
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    a().edit().putBoolean("key_show_gray_tip_entry", this.jdField_b_of_type_Boolean).apply();
  }
  
  public final boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  @NotNull
  public final String b()
  {
    return (String)this.jdField_b_of_type_KotlinLazy.getValue();
  }
  
  public final void b(int paramInt)
  {
    if ((paramInt > 0) && (paramInt != this.jdField_b_of_type_Int)) {
      this.jdField_a_of_type_Boolean = true;
    }
    if (paramInt <= 0) {
      this.jdField_a_of_type_Boolean = false;
    }
    this.jdField_b_of_type_Int = paramInt;
    a().edit().putInt("key_me_in_cold_palace_times", paramInt);
  }
  
  @NotNull
  public final String c()
  {
    return (String)this.jdField_c_of_type_KotlinLazy.getValue();
  }
  
  @NotNull
  public final String d()
  {
    return (String)this.jdField_d_of_type_KotlinLazy.getValue();
  }
  
  @NotNull
  public final String e()
  {
    return (String)this.jdField_e_of_type_KotlinLazy.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper
 * JD-Core Version:    0.7.0.1
 */