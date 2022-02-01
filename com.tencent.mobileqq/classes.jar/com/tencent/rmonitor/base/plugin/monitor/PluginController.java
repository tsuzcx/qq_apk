package com.tencent.rmonitor.base.plugin.monitor;

import android.content.SharedPreferences;
import com.tencent.rmonitor.base.config.ConfigCenter;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.DefaultPluginConfig;
import com.tencent.rmonitor.base.config.PluginCombination;
import com.tencent.rmonitor.base.config.PluginCombination.Companion;
import com.tencent.rmonitor.base.config.data.RPluginConfig;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.AsyncSPEditor;
import com.tencent.rmonitor.resource.RunTimeEnv;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/plugin/monitor/PluginController;", "", "()V", "KEY_COUNT_PLUGIN_PREFIX", "", "KEY_COUNT_TODAY_AUSTERITY_REPORTED", "KEY_COUNT_TODAY_LOOSE_REPORTED", "KEY_LAST_START_DATE", "austerityReportNum", "", "getAusterityReportNum", "()I", "setAusterityReportNum", "(I)V", "inDebugMode", "", "getInDebugMode", "()Z", "setInDebugMode", "(Z)V", "looseReportNum", "getLooseReportNum", "setLooseReportNum", "startDate", "", "startedPluginMode", "addPluginReportNum", "", "plugin", "canCollect", "checkMaxAusterityReportNum", "checkMaxLooseReportNum", "flushReportNum", "increaseReportNum", "resetPlugin", "pluginConfig", "Lcom/tencent/rmonitor/base/config/data/RPluginConfig;", "resetReportNum", "updateStartPluginMode", "mode", "whetherPluginSampling", "sampleRatio", "", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class PluginController
{
  @JvmField
  public static int a;
  public static final PluginController b = new PluginController();
  private static boolean c;
  private static int d;
  private static int e;
  private static final long f = (float)Math.rint((float)(System.currentTimeMillis() / 86400000));
  
  @JvmStatic
  public static final boolean a(int paramInt, float paramFloat)
  {
    if (c) {
      return true;
    }
    boolean bool3 = b.b(paramInt);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (Math.random() < paramFloat) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final void a(int paramInt)
  {
    PluginCombination.a.a(paramInt, (Function1)PluginController.addPluginReportNum.1.INSTANCE);
  }
  
  public final void a(int paramInt, @NotNull RPluginConfig paramRPluginConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramRPluginConfig, "pluginConfig");
    PluginCombination.a.a(paramInt, (Function1)new PluginController.resetPlugin.1(paramRPluginConfig));
  }
  
  public final boolean a()
  {
    return c;
  }
  
  public final int b()
  {
    return d;
  }
  
  public final boolean b(int paramInt)
  {
    if (c) {
      return true;
    }
    Object localObject2 = ((Iterable)PluginCombination.a.d()).iterator();
    boolean bool1;
    int i;
    do
    {
      boolean bool2 = ((Iterator)localObject2).hasNext();
      bool1 = false;
      if (!bool2) {
        break;
      }
      localObject1 = ((Iterator)localObject2).next();
      if (((DefaultPluginConfig)localObject1).a == paramInt) {
        i = 1;
      } else {
        i = 0;
      }
    } while (i == 0);
    break label78;
    Object localObject1 = null;
    label78:
    localObject1 = (DefaultPluginConfig)localObject1;
    if (b.e()) {
      return false;
    }
    if ((paramInt == 138) && (((a & 0x200) == 0) || (!RunTimeEnv.c()))) {
      return false;
    }
    if ((PluginCombination.a.a(paramInt)) && (f())) {
      return false;
    }
    localObject2 = PluginCombination.a.a(paramInt, (Function1)PluginController.canCollect.3.INSTANCE);
    localObject1 = localObject2;
    if (!(localObject2 instanceof Boolean)) {
      localObject1 = null;
    }
    localObject1 = (Boolean)localObject1;
    if (localObject1 != null) {
      bool1 = ((Boolean)localObject1).booleanValue();
    }
    return bool1;
  }
  
  public final void c()
  {
    SharedPreferences localSharedPreferences = BaseInfo.sharePreference;
    long l;
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong("last_start_date", 0L);
    } else {
      l = f;
    }
    if (f - l > 0L)
    {
      BaseInfo.editor.a("last_start_date", f);
      BaseInfo.editor.a("count_today_austerity_reported", 0);
      BaseInfo.editor.a("count_today_loose_reported", 0);
      PluginCombination.a.a((Function1)PluginController.resetReportNum.1.INSTANCE);
      BaseInfo.editor.b();
      return;
    }
    localSharedPreferences = BaseInfo.sharePreference;
    if (localSharedPreferences != null)
    {
      d = localSharedPreferences.getInt("count_today_austerity_reported", 0);
      e = localSharedPreferences.getInt("count_today_loose_reported", 0);
      PluginCombination.a.a((Function1)new PluginController.resetReportNum.2.1(localSharedPreferences));
    }
  }
  
  public final void c(int paramInt)
  {
    if (PluginCombination.a.b(paramInt))
    {
      e += 1;
      if (e % 5 == 0) {
        BaseInfo.editor.a("count_today_loose_reported", e).b();
      }
    }
    if (PluginCombination.a.a(paramInt))
    {
      d += 1;
      if (d % 10 == 0) {
        BaseInfo.editor.a("count_today_austerity_reported", d).b();
      }
    }
  }
  
  public final void d()
  {
    BaseInfo.editor.a("count_today_austerity_reported", d).a("count_today_loose_reported", e).b();
  }
  
  public final boolean d(int paramInt)
  {
    if (c) {
      return true;
    }
    boolean bool3 = b(paramInt);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      Object localObject2 = PluginCombination.a.a(paramInt, (Function1)PluginController.whetherPluginSampling.familySampleRatio.1.INSTANCE);
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof Float)) {
        localObject1 = null;
      }
      localObject1 = (Float)localObject1;
      float f1;
      if (localObject1 != null) {
        f1 = ((Float)localObject1).floatValue();
      } else {
        f1 = 0.0F;
      }
      bool1 = bool2;
      if (Math.random() < f1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final void e(int paramInt)
  {
    if (a != paramInt)
    {
      Logger.b.w(new String[] { "updateStartPluginMode, from: ", String.valueOf(paramInt), ", current: ", String.valueOf(a) });
      a = paramInt;
    }
  }
  
  public final boolean e()
  {
    return (!c) && (e > ConfigProxy.INSTANCE.getConfig().a("MAX_LOOSE_REPORT_NUM"));
  }
  
  public final boolean f()
  {
    return (!c) && (d > ConfigProxy.INSTANCE.getConfig().a("MAX_AUSTERITY_REPORT_NUM"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.plugin.monitor.PluginController
 * JD-Core Version:    0.7.0.1
 */