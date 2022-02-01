package com.tencent.qapmsdk.base.monitorplugin;

import android.content.SharedPreferences;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig.ResourcePlugin.ResourceType;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.config.PluginCombination.Companion;
import com.tencent.qapmsdk.base.config.SDKConfig;
import com.tencent.qapmsdk.base.config.SDKConfig.Companion;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.common.util.AsyncSPEditor;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/monitorplugin/PluginController;", "", "()V", "KEY_COUNT_PLUGIN_PREFIX", "", "KEY_COUNT_TODAY_AUSTERITY_REPORTED", "KEY_COUNT_TODAY_LOOSE_REPORTED", "KEY_LAST_START_DATE", "austerityReportNum", "", "getAusterityReportNum", "()I", "setAusterityReportNum", "(I)V", "looseReportNum", "getLooseReportNum", "setLooseReportNum", "startDate", "", "startedPluginMode", "addPluginReportNum", "", "plugin", "canCollect", "", "flushReportNum", "resetPlugin", "threshold", "maxReportNun", "eventSampleRatio", "", "stackDepth", "resetReportNum", "whetherPluginSampling", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class PluginController
{
  public static final PluginController INSTANCE = new PluginController();
  @NotNull
  public static final String KEY_COUNT_PLUGIN_PREFIX = "count_plugin_";
  @NotNull
  public static final String KEY_COUNT_TODAY_AUSTERITY_REPORTED = "count_today_austerity_reported";
  @NotNull
  public static final String KEY_COUNT_TODAY_LOOSE_REPORTED = "count_today_loose_reported";
  private static final String KEY_LAST_START_DATE = "last_start_date";
  private static int austerityReportNum;
  private static int looseReportNum;
  private static final long startDate = (float)Math.rint((float)(System.currentTimeMillis() / 86400000));
  @JvmField
  public static int startedPluginMode;
  
  public final void addPluginReportNum(int paramInt)
  {
    PluginCombination.Companion.handle(paramInt, (Function1)PluginController.addPluginReportNum.1.INSTANCE);
  }
  
  public final boolean canCollect(int paramInt)
  {
    Object localObject2 = ((Iterable)PluginCombination.Companion.getLoosePlugins$qapmbase_release()).iterator();
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
      if (((DefaultPluginConfig)localObject1).plugin == paramInt) {
        i = 1;
      } else {
        i = 0;
      }
    } while (i == 0);
    break label70;
    Object localObject1 = null;
    label70:
    localObject1 = (DefaultPluginConfig)localObject1;
    if (looseReportNum > SDKConfig.Companion.getMAX_LOOSE_REPORT_NUM()) {
      return false;
    }
    if ((paramInt == PluginCombination.resourcePlugin.plugin) && (((startedPluginMode & PluginCombination.resourcePlugin.mode) == 0) || ((SDKConfig.RES_TYPE & DefaultPluginConfig.ResourcePlugin.ResourceType.OPEN_TAG.getValue()) == 0))) {
      return false;
    }
    if ((PluginCombination.Companion.isAusterityPlugin(paramInt)) && (austerityReportNum > SDKConfig.Companion.getMAX_AUSTERITY_REPORT_NUM())) {
      return false;
    }
    localObject2 = PluginCombination.Companion.handle(paramInt, (Function1)PluginController.canCollect.3.INSTANCE);
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
  
  public final void flushReportNum()
  {
    BaseInfo.editor.putInt("count_today_austerity_reported", austerityReportNum).putInt("count_today_loose_reported", looseReportNum).apply();
  }
  
  public final int getAusterityReportNum()
  {
    return austerityReportNum;
  }
  
  public final int getLooseReportNum()
  {
    return looseReportNum;
  }
  
  public final void resetPlugin(int paramInt1, int paramInt2, int paramInt3, float paramFloat, int paramInt4)
  {
    PluginCombination.Companion.handle(paramInt1, (Function1)new PluginController.resetPlugin.1(paramInt2, paramInt3, paramFloat, paramInt4));
  }
  
  public final void resetReportNum()
  {
    SharedPreferences localSharedPreferences = BaseInfo.sharePreference;
    long l;
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong("last_start_date", 0L);
    } else {
      l = startDate;
    }
    if (startDate - l > 0L)
    {
      BaseInfo.editor.putLong("last_start_date", startDate);
      BaseInfo.editor.putInt("count_today_austerity_reported", 0);
      BaseInfo.editor.putInt("count_today_loose_reported", 0);
      PluginCombination.Companion.each((Function1)PluginController.resetReportNum.1.INSTANCE);
      BaseInfo.editor.apply();
      return;
    }
    localSharedPreferences = BaseInfo.sharePreference;
    if (localSharedPreferences != null)
    {
      austerityReportNum = localSharedPreferences.getInt("count_today_austerity_reported", 0);
      looseReportNum = localSharedPreferences.getInt("count_today_loose_reported", 0);
      PluginCombination.Companion.each((Function1)new PluginController.resetReportNum.2.1(localSharedPreferences));
    }
  }
  
  public final void setAusterityReportNum(int paramInt)
  {
    austerityReportNum = paramInt;
  }
  
  public final void setLooseReportNum(int paramInt)
  {
    looseReportNum = paramInt;
  }
  
  public final boolean whetherPluginSampling(int paramInt)
  {
    boolean bool3 = canCollect(paramInt);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      Object localObject2 = PluginCombination.Companion.handle(paramInt, (Function1)PluginController.whetherPluginSampling.familySampleRatio.1.INSTANCE);
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof Float)) {
        localObject1 = null;
      }
      localObject1 = (Float)localObject1;
      float f;
      if (localObject1 != null) {
        f = ((Float)localObject1).floatValue();
      } else {
        f = 0.0F;
      }
      bool1 = bool2;
      if (Math.random() < f) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.base.monitorplugin.PluginController
 * JD-Core Version:    0.7.0.1
 */