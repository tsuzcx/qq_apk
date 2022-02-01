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
  public static final ColdPalaceHelper.Companion f = new ColdPalaceHelper.Companion(null);
  @NotNull
  public volatile String a;
  @NotNull
  public volatile String b;
  @NotNull
  public volatile String c;
  @NotNull
  public volatile String d;
  @NotNull
  public volatile String e;
  @NotNull
  private final Lazy g;
  @NotNull
  private final Lazy h;
  @NotNull
  private final Lazy i;
  @NotNull
  private final Lazy j;
  @NotNull
  private final Lazy k;
  private volatile long l;
  private volatile long m;
  private volatile int n;
  private volatile int o;
  private volatile boolean p;
  private volatile boolean q;
  @NotNull
  private final Lazy r;
  @NotNull
  private final QQAppInterface s;
  
  public ColdPalaceHelper(@NotNull QQAppInterface paramQQAppInterface)
  {
    this.s = paramQQAppInterface;
    this.g = LazyKt.lazy((Function0)new ColdPalaceHelper.strSkillTip.2(this));
    this.h = LazyKt.lazy((Function0)new ColdPalaceHelper.strSkillUseupTip.2(this));
    this.i = LazyKt.lazy((Function0)new ColdPalaceHelper.strWarnMeInColdPalace.2(this));
    this.j = LazyKt.lazy((Function0)new ColdPalaceHelper.strWarnMeForbbiden.2(this));
    this.k = LazyKt.lazy((Function0)new ColdPalaceHelper.strWarnMeFreeTime.2(this));
    this.n = -2147483648;
    this.r = LazyKt.lazy((Function0)new ColdPalaceHelper.sp.2(this));
    paramQQAppInterface = g().getString("key_skill_tip", "");
    Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "sp.getString(SP_KEY_SKILL_TIP, \"\")");
    this.a = paramQQAppInterface;
    paramQQAppInterface = g().getString("key_skill_useup_tip", "");
    Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "sp.getString(SP_KEY_SKILL_USEUP_TIP, \"\")");
    this.b = paramQQAppInterface;
    paramQQAppInterface = g().getString("key_skill_useup_title", "");
    Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "sp.getString(SP_KEY_SKILL_USEUP_TITLE, \"\")");
    this.c = paramQQAppInterface;
    paramQQAppInterface = g().getString("key_warn_me_in_coldpalace", "");
    Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "sp.getString(SP_KEY_WARN_ME_IN_COLDPALACE, \"\")");
    this.d = paramQQAppInterface;
    paramQQAppInterface = g().getString("key_warn_me_forbbiden", "");
    Intrinsics.checkExpressionValueIsNotNull(paramQQAppInterface, "sp.getString(SP_KEY_WARN_ME_FORBBIDEN, \"\")");
    this.e = paramQQAppInterface;
    this.l = g().getLong("key_punish_left_time", 0L);
    this.m = g().getLong("key_punish_time_since", 0L);
    this.q = g().getBoolean("key_show_gray_tip_entry", this.q);
    this.o = g().getInt("key_me_in_cold_palace_times", 0);
  }
  
  @JvmStatic
  @NotNull
  public static final ColdPalaceHelper a(@NotNull BaseQQAppInterface paramBaseQQAppInterface)
  {
    return f.a(paramBaseQQAppInterface);
  }
  
  @NotNull
  public final String a()
  {
    return (String)this.g.getValue();
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
            str = this.e;
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
          str = this.d;
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
        str = this.b;
        if (str == null) {
          Intrinsics.throwUninitializedPropertyAccessException("svrStrSkillUseupTip");
        }
        localObject2[0] = str;
        localObject1 = String.format((String)localObject1, Arrays.copyOf((Object[])localObject2, localObject2.length));
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(format, *args)");
        return localObject1;
      }
      localObject2 = this.c;
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
      str = this.a;
      if (str == null) {
        Intrinsics.throwUninitializedPropertyAccessException("svrStrSkillTip");
      }
      localObject2[0] = str;
      localObject1 = String.format((String)localObject1, Arrays.copyOf((Object[])localObject2, localObject2.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(format, *args)");
    }
    return localObject1;
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
            this.e = paramString;
            g().edit().putString("key_warn_me_forbbiden", paramString).apply();
            return;
          }
          this.d = paramString;
          g().edit().putString("key_warn_me_in_coldpalace", paramString).apply();
          return;
        }
        this.b = paramString;
        g().edit().putString("key_skill_useup_tip", paramString).apply();
        return;
      }
      this.c = paramString;
      g().edit().putString("key_skill_useup_title", paramString).apply();
      return;
    }
    this.a = paramString;
    g().edit().putString("key_skill_tip", paramString).apply();
  }
  
  public final void a(long paramLong1, long paramLong2)
  {
    this.l = paramLong1;
    this.m = paramLong2;
    g().edit().putLong("key_punish_left_time", paramLong1);
    g().edit().putLong("key_punish_time_since", paramLong2);
    g().edit().apply();
  }
  
  public final void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "frdUin");
    ThreadManager.executeOnSubThread((Runnable)new ColdPalaceHelper.addMeBlockedGrayTip.1(this, paramString, paramInt));
  }
  
  public final void a(boolean paramBoolean)
  {
    this.q = paramBoolean;
    g().edit().putBoolean("key_show_gray_tip_entry", this.q).apply();
  }
  
  @NotNull
  public final String b()
  {
    return (String)this.h.getValue();
  }
  
  public final void b(int paramInt)
  {
    this.n = paramInt;
  }
  
  @NotNull
  public final String c()
  {
    return (String)this.i.getValue();
  }
  
  public final void c(int paramInt)
  {
    if ((paramInt > 0) && (paramInt != this.o)) {
      this.p = true;
    }
    if (paramInt <= 0) {
      this.p = false;
    }
    this.o = paramInt;
    g().edit().putInt("key_me_in_cold_palace_times", paramInt);
  }
  
  @NotNull
  public final String d()
  {
    return (String)this.j.getValue();
  }
  
  @NotNull
  public final String e()
  {
    return (String)this.k.getValue();
  }
  
  public final boolean f()
  {
    return this.q;
  }
  
  @NotNull
  public final SharedPreferences g()
  {
    return (SharedPreferences)this.r.getValue();
  }
  
  public final int h()
  {
    return this.n;
  }
  
  @NotNull
  public final QQAppInterface i()
  {
    return this.s;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper
 * JD-Core Version:    0.7.0.1
 */