package com.tencent.mobileqq.qmcf;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.shortvideo.util.SoLoader;
import com.tencent.sveffects.DpcSwitcher;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import org.json.JSONObject;

public class QmcfSwitchStrategy
{
  public static final int QMCF_ENTRANCE_DEFAULT = -1;
  public static final int QMCF_ENTRANCE_DPC_OFF = 4;
  public static final int QMCF_ENTRANCE_GPU_NOTSUPPORT = 2;
  public static final int QMCF_ENTRANCE_INIT_FAILED_NATIVE = 5;
  public static final int QMCF_ENTRANCE_INIT_FAILED_NONATIVE = 6;
  public static final int QMCF_ENTRANCE_LOADSO_FAILED = 7;
  public static final int QMCF_ENTRANCE_MAIN_SWITCHOFF = 3;
  public static final int QMCF_ENTRANCE_SUPPORT = 0;
  public static final int QMCF_ENTRANCE_VERSION_TOOLOW = 1;
  public static final String QMCF_EXCEPTION_CURR_COUNT_ART = "qmcf_exception_curr_count_art";
  public static final String QMCF_EXCEPTION_CURR_COUNT_BIGHEAD = "qmcf_exception_curr_count_bighead";
  public static final String QMCF_EXCEPTION_CURR_COUNT_DANCE = "qmcf_exception_curr_count_dance";
  public static final String QMCF_EXCEPTION_MAX_COUNT = "qmcf_exception_max_count";
  public static final String QMCF_MAIN_SWITCH = "qmcf_main_switch";
  public static final String QMCF_MOBILEQ_SUPPORT = "qmcf_mobile_support";
  public static final String SP_TAG = "QmcfConfig";
  public static final int SVAF_SWITCH_ON = 1;
  private static final String TAG = "QmcfSwitchStrategy";
  private int artCurrExcpCount = -1;
  private boolean artFilterDpcSwitch = false;
  private int artFrameExcpCount = 0;
  private int bigHeadCurrExcpCount = -1;
  private int bigHeadFrameExcpCount = 0;
  private int currEntranceState = -1;
  private int danceCurrExcpCount = -1;
  private int danceFrameExcpCount = 0;
  private boolean initSuccess = true;
  private int qmcfMainSwitch = -1;
  private int qmcfMaxExcpCount = -1;
  private int qmcfMobileSupport = -1;
  
  public int getEntranceState()
  {
    if (this.currEntranceState > -1) {
      return this.currEntranceState;
    }
    if (Build.VERSION.SDK_INT < 21) {
      this.currEntranceState = 1;
    }
    for (;;)
    {
      return this.currEntranceState;
      if (this.qmcfMobileSupport == 0) {
        this.currEntranceState = 2;
      } else if (this.qmcfMainSwitch == 0) {
        this.currEntranceState = 3;
      } else if (this.danceCurrExcpCount >= this.qmcfMaxExcpCount) {
        this.currEntranceState = 5;
      } else if (!this.initSuccess) {
        this.currEntranceState = 6;
      } else if (!SoLoader.isLoadArtFilterSuccess()) {
        this.currEntranceState = 7;
      } else {
        this.currEntranceState = 0;
      }
    }
  }
  
  public boolean isArtFilterSupported()
  {
    if (this.qmcfMainSwitch == -1) {
      this.qmcfMainSwitch = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).getInt("qmcf_main_switch", 1);
    }
    if (this.qmcfMobileSupport == -1) {
      if (SdkContext.getInstance().getApplication() != null) {}
    }
    do
    {
      return true;
      this.qmcfMobileSupport = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).getInt("qmcf_mobile_support", 1);
      this.artFilterDpcSwitch = SdkContext.getInstance().getDpcSwitcher().isSvafSwitchOpen();
      if ((this.artCurrExcpCount == -1) || (this.qmcfMaxExcpCount == -1))
      {
        SharedPreferences localSharedPreferences = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4);
        this.artCurrExcpCount = localSharedPreferences.getInt("qmcf_exception_curr_count_art", 0);
        this.qmcfMaxExcpCount = localSharedPreferences.getInt("qmcf_exception_max_count", 2);
      }
      if (SLog.isEnable()) {
        SLog.d("QmcfSwitchStrategy", String.format("ArtMode: MainSwitch[%s], MobileSupport[%s], DPCSwitch[%s], currCount[%s], maxCount[%s]", new Object[] { Integer.valueOf(this.qmcfMainSwitch), Integer.valueOf(this.qmcfMobileSupport), Boolean.valueOf(this.artFilterDpcSwitch), Integer.valueOf(this.artCurrExcpCount), Integer.valueOf(this.qmcfMaxExcpCount) }));
      }
    } while ((this.qmcfMainSwitch == 1) && (this.qmcfMobileSupport == 1) && (this.artFilterDpcSwitch) && (this.artCurrExcpCount < this.qmcfMaxExcpCount));
    return false;
  }
  
  public boolean isBigHeadSupported()
  {
    if (this.qmcfMainSwitch == -1) {
      this.qmcfMainSwitch = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).getInt("qmcf_main_switch", 1);
    }
    if (this.qmcfMobileSupport == -1) {
      if (SdkContext.getInstance().getApplication() != null) {}
    }
    do
    {
      return true;
      this.qmcfMobileSupport = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).getInt("qmcf_mobile_support", 1);
      if ((this.bigHeadCurrExcpCount == -1) || (this.qmcfMaxExcpCount == -1))
      {
        SharedPreferences localSharedPreferences = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4);
        this.bigHeadCurrExcpCount = localSharedPreferences.getInt("qmcf_exception_curr_count_bighead", 0);
        this.qmcfMaxExcpCount = localSharedPreferences.getInt("qmcf_exception_max_count", 2);
      }
      if (SLog.isEnable()) {
        SLog.d("QmcfSwitchStrategy", String.format("BigheadMode: MainSwitch[%s], MobileSupport[%s], currCount[%s], maxCount[%s]", new Object[] { Integer.valueOf(this.qmcfMainSwitch), Integer.valueOf(this.qmcfMobileSupport), Integer.valueOf(this.bigHeadCurrExcpCount), Integer.valueOf(this.qmcfMaxExcpCount) }));
      }
    } while ((this.qmcfMainSwitch == 1) && (this.qmcfMobileSupport == 1) && (this.bigHeadCurrExcpCount < this.qmcfMaxExcpCount));
    return false;
  }
  
  public boolean isDanceGameSupported()
  {
    if (this.qmcfMainSwitch == -1) {
      this.qmcfMainSwitch = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).getInt("qmcf_main_switch", 1);
    }
    if (this.qmcfMobileSupport == -1) {
      if (SdkContext.getInstance().getApplication() != null) {}
    }
    do
    {
      return true;
      this.qmcfMobileSupport = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).getInt("qmcf_mobile_support", 1);
      if ((this.danceCurrExcpCount == -1) || (this.qmcfMaxExcpCount == -1))
      {
        SharedPreferences localSharedPreferences = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4);
        this.danceCurrExcpCount = localSharedPreferences.getInt("qmcf_exception_curr_count_dance", 0);
        this.qmcfMaxExcpCount = localSharedPreferences.getInt("qmcf_exception_max_count", 2);
      }
      if (SLog.isEnable()) {
        SLog.d("QmcfSwitchStrategy", String.format("DanceMode: MainSwitch[%s], MobileSupport[%s], currCount[%s], maxCount[%s]", new Object[] { Integer.valueOf(this.qmcfMainSwitch), Integer.valueOf(this.qmcfMobileSupport), Integer.valueOf(this.danceCurrExcpCount), Integer.valueOf(this.qmcfMaxExcpCount) }));
      }
    } while ((this.qmcfMainSwitch == 1) && (this.qmcfMobileSupport == 1) && (this.danceCurrExcpCount < this.qmcfMaxExcpCount));
    return false;
  }
  
  public boolean isMobileSupported()
  {
    if (this.qmcfMobileSupport == -1) {
      if (SdkContext.getInstance().getApplication() != null) {}
    }
    while (this.qmcfMobileSupport == 1)
    {
      return true;
      this.qmcfMobileSupport = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).getInt("qmcf_mobile_support", 1);
    }
    return false;
  }
  
  public boolean isModeSupported(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      SLog.d("QmcfSwitchStrategy", "unknown mode:" + paramInt);
      return false;
    case 1: 
      return isArtFilterSupported();
    case 2: 
      return isDanceGameSupported();
    }
    return isBigHeadSupported();
  }
  
  public void setArtFilterRunSupport(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      if (!paramBoolean1)
      {
        int i = this.artFrameExcpCount + 1;
        this.artFrameExcpCount = i;
        if (i <= 5) {}
      }
    }
    else
    {
      if (!paramBoolean1) {
        break label120;
      }
      this.artCurrExcpCount = 0;
    }
    for (;;)
    {
      SharedPreferences.Editor localEditor = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).edit();
      localEditor.putInt("qmcf_exception_curr_count_art", this.artCurrExcpCount);
      localEditor.commit();
      if (SLog.isEnable()) {
        SLog.d("QmcfSwitchStrategy", String.format("ArtMode: isSuccess[%s], forceUpdate[%s], currCount[%s]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(this.artCurrExcpCount) }));
      }
      return;
      label120:
      this.artCurrExcpCount += 1;
      this.artFrameExcpCount = 0;
    }
  }
  
  public void setBigHeadRunSupport(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      if (!paramBoolean1)
      {
        int i = this.bigHeadFrameExcpCount + 1;
        this.bigHeadFrameExcpCount = i;
        if (i <= 5) {}
      }
    }
    else
    {
      if (!paramBoolean1) {
        break label120;
      }
      this.bigHeadCurrExcpCount = 0;
    }
    for (;;)
    {
      SharedPreferences.Editor localEditor = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).edit();
      localEditor.putInt("qmcf_exception_curr_count_bighead", this.bigHeadCurrExcpCount);
      localEditor.commit();
      if (SLog.isEnable()) {
        SLog.d("QmcfSwitchStrategy", String.format("BigHeadMode: isSuccess[%s], forceUpdate[%s], currCount[%s]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(this.bigHeadCurrExcpCount) }));
      }
      return;
      label120:
      this.bigHeadCurrExcpCount += 1;
      this.bigHeadFrameExcpCount = 0;
    }
  }
  
  public void setDanceGameRunSupport(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      if (!paramBoolean1)
      {
        int i = this.danceFrameExcpCount + 1;
        this.danceFrameExcpCount = i;
        if (i <= 5) {}
      }
    }
    else
    {
      if (!paramBoolean1) {
        break label120;
      }
      this.danceCurrExcpCount = 0;
    }
    for (;;)
    {
      SharedPreferences.Editor localEditor = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).edit();
      localEditor.putInt("qmcf_exception_curr_count_dance", this.danceCurrExcpCount);
      localEditor.commit();
      if (SLog.isEnable()) {
        SLog.d("QmcfSwitchStrategy", String.format("DanceMode: isSuccess[%s], forceUpdate[%s], currCount[%s]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(this.danceCurrExcpCount) }));
      }
      return;
      label120:
      this.danceCurrExcpCount += 1;
      this.danceFrameExcpCount = 0;
    }
  }
  
  public void setInitSuccess(boolean paramBoolean)
  {
    this.initSuccess = paramBoolean;
  }
  
  public void setMobileSupport(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.qmcfMobileSupport = i;
      SharedPreferences.Editor localEditor = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).edit();
      localEditor.putInt("qmcf_mobile_support", this.qmcfMobileSupport);
      localEditor.commit();
      if (SLog.isEnable()) {
        SLog.d("QmcfSwitchStrategy", "setMobileSupport :" + this.qmcfMobileSupport);
      }
      return;
    }
  }
  
  public void setQmcfRunSupported(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      setArtFilterRunSupport(paramBoolean1, paramBoolean2);
      return;
    case 2: 
      setDanceGameRunSupport(paramBoolean1, paramBoolean2);
      return;
    }
    setBigHeadRunSupport(paramBoolean1, paramBoolean2);
  }
  
  public void updateMainSwitch(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      int i = paramJSONObject.optInt("svaf_switch", 1);
      int j = paramJSONObject.optInt("svaf_maxCount", -1);
      paramJSONObject = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).edit();
      paramJSONObject.putInt("qmcf_main_switch", i);
      if (j != -1)
      {
        this.qmcfMaxExcpCount = j;
        paramJSONObject.putInt("qmcf_exception_max_count", j);
      }
      paramJSONObject.commit();
      if (SLog.isEnable()) {
        SLog.d("QmcfSwitchStrategy", String.format("updateMainSwitch, mainSwitch[%s], maxCount[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qmcf.QmcfSwitchStrategy
 * JD-Core Version:    0.7.0.1
 */