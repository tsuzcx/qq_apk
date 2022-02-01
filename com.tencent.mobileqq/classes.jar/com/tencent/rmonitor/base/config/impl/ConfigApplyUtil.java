package com.tencent.rmonitor.base.config.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.common.util.AsyncSPEditor;
import com.tencent.rmonitor.common.util.ProcessUtil;
import com.tencent.rmonitor.common.util.ProcessUtil.Companion;
import java.util.Calendar;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/config/impl/ConfigApplyUtil;", "", "()V", "flushConfigSp", "", "preHit", "", "serviceSwitch", "getHit", "getLastMode", "getNextFlushHitTime", "", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class ConfigApplyUtil
{
  public static final ConfigApplyUtil.Companion a = new ConfigApplyUtil.Companion(null);
  
  private final long c()
  {
    return System.currentTimeMillis() + 2592000000L;
  }
  
  public final int a()
  {
    SharedPreferences localSharedPreferences = BaseInfo.sharePreference;
    if (localSharedPreferences != null)
    {
      int i = localSharedPreferences.getInt("config_last_day", 0);
      int j = Calendar.getInstance().get(6);
      if (i != 0)
      {
        if (i != j)
        {
          BaseInfo.editor.a("config_last_day", j).a("config_last_mode", 0).b();
          return 0;
        }
        return localSharedPreferences.getInt("config_last_mode", 0);
      }
      BaseInfo.editor.a("config_last_day", j).b();
    }
    return 0;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    SharedPreferences localSharedPreferences = BaseInfo.sharePreference;
    if (localSharedPreferences != null)
    {
      if ((paramInt2 > 0) && (ProcessUtil.a.b((Context)BaseInfo.app))) {
        BaseInfo.editor.a("new_start_open", true);
      } else {
        BaseInfo.editor.a("new_start_open", false);
      }
      if ((paramInt1 == 0) && (paramInt2 > 0)) {
        BaseInfo.editor.a("config_hit_over_time", c()).a("config_hit", 1);
      }
      paramInt1 = localSharedPreferences.getInt("config_last_mode", 0);
      BaseInfo.editor.a("config_last_mode", paramInt2 | paramInt1);
      BaseInfo.editor.b();
    }
  }
  
  public final int b()
  {
    SharedPreferences localSharedPreferences = BaseInfo.sharePreference;
    if (localSharedPreferences != null)
    {
      if (localSharedPreferences.getLong("config_hit_over_time", 0L) < System.currentTimeMillis()) {
        BaseInfo.editor.a("config_hit_over_time", c()).a("config_hit", 0).b();
      }
      return localSharedPreferences.getInt("config_hit", 0);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.config.impl.ConfigApplyUtil
 * JD-Core Version:    0.7.0.1
 */