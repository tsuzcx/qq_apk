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
    int i = this.currEntranceState;
    if (i > -1) {
      return i;
    }
    if (Build.VERSION.SDK_INT < 21) {
      this.currEntranceState = 1;
    } else if (this.qmcfMobileSupport == 0) {
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
    return this.currEntranceState;
  }
  
  public boolean isArtFilterSupported()
  {
    if (this.qmcfMainSwitch == -1) {
      this.qmcfMainSwitch = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).getInt("qmcf_main_switch", 1);
    }
    if (this.qmcfMobileSupport == -1)
    {
      if (SdkContext.getInstance().getApplication() == null) {
        return true;
      }
      this.qmcfMobileSupport = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).getInt("qmcf_mobile_support", 1);
    }
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
    return (this.qmcfMainSwitch == 1) && (this.qmcfMobileSupport == 1) && (this.artFilterDpcSwitch) && (this.artCurrExcpCount < this.qmcfMaxExcpCount);
  }
  
  public boolean isBigHeadSupported()
  {
    if (this.qmcfMainSwitch == -1) {
      this.qmcfMainSwitch = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).getInt("qmcf_main_switch", 1);
    }
    if (this.qmcfMobileSupport == -1)
    {
      if (SdkContext.getInstance().getApplication() == null) {
        return true;
      }
      this.qmcfMobileSupport = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).getInt("qmcf_mobile_support", 1);
    }
    if ((this.bigHeadCurrExcpCount == -1) || (this.qmcfMaxExcpCount == -1))
    {
      SharedPreferences localSharedPreferences = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4);
      this.bigHeadCurrExcpCount = localSharedPreferences.getInt("qmcf_exception_curr_count_bighead", 0);
      this.qmcfMaxExcpCount = localSharedPreferences.getInt("qmcf_exception_max_count", 2);
    }
    if (SLog.isEnable()) {
      SLog.d("QmcfSwitchStrategy", String.format("BigheadMode: MainSwitch[%s], MobileSupport[%s], currCount[%s], maxCount[%s]", new Object[] { Integer.valueOf(this.qmcfMainSwitch), Integer.valueOf(this.qmcfMobileSupport), Integer.valueOf(this.bigHeadCurrExcpCount), Integer.valueOf(this.qmcfMaxExcpCount) }));
    }
    return (this.qmcfMainSwitch == 1) && (this.qmcfMobileSupport == 1) && (this.bigHeadCurrExcpCount < this.qmcfMaxExcpCount);
  }
  
  public boolean isDanceGameSupported()
  {
    if (this.qmcfMainSwitch == -1) {
      this.qmcfMainSwitch = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).getInt("qmcf_main_switch", 1);
    }
    if (this.qmcfMobileSupport == -1)
    {
      if (SdkContext.getInstance().getApplication() == null) {
        return true;
      }
      this.qmcfMobileSupport = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).getInt("qmcf_mobile_support", 1);
    }
    if ((this.danceCurrExcpCount == -1) || (this.qmcfMaxExcpCount == -1))
    {
      SharedPreferences localSharedPreferences = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4);
      this.danceCurrExcpCount = localSharedPreferences.getInt("qmcf_exception_curr_count_dance", 0);
      this.qmcfMaxExcpCount = localSharedPreferences.getInt("qmcf_exception_max_count", 2);
    }
    if (SLog.isEnable()) {
      SLog.d("QmcfSwitchStrategy", String.format("DanceMode: MainSwitch[%s], MobileSupport[%s], currCount[%s], maxCount[%s]", new Object[] { Integer.valueOf(this.qmcfMainSwitch), Integer.valueOf(this.qmcfMobileSupport), Integer.valueOf(this.danceCurrExcpCount), Integer.valueOf(this.qmcfMaxExcpCount) }));
    }
    return (this.qmcfMainSwitch == 1) && (this.qmcfMobileSupport == 1) && (this.danceCurrExcpCount < this.qmcfMaxExcpCount);
  }
  
  public boolean isMobileSupported()
  {
    if (this.qmcfMobileSupport == -1)
    {
      if (SdkContext.getInstance().getApplication() == null) {
        return true;
      }
      this.qmcfMobileSupport = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).getInt("qmcf_mobile_support", 1);
    }
    return this.qmcfMobileSupport == 1;
  }
  
  public boolean isModeSupported(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("unknown mode:");
          localStringBuilder.append(paramInt);
          SLog.d("QmcfSwitchStrategy", localStringBuilder.toString());
          return false;
        }
        return isBigHeadSupported();
      }
      return isDanceGameSupported();
    }
    return isArtFilterSupported();
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
      if (paramBoolean1)
      {
        this.artCurrExcpCount = 0;
      }
      else
      {
        this.artCurrExcpCount += 1;
        this.artFrameExcpCount = 0;
      }
      SharedPreferences.Editor localEditor = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).edit();
      localEditor.putInt("qmcf_exception_curr_count_art", this.artCurrExcpCount);
      localEditor.commit();
      if (SLog.isEnable()) {
        SLog.d("QmcfSwitchStrategy", String.format("ArtMode: isSuccess[%s], forceUpdate[%s], currCount[%s]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(this.artCurrExcpCount) }));
      }
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
      if (paramBoolean1)
      {
        this.bigHeadCurrExcpCount = 0;
      }
      else
      {
        this.bigHeadCurrExcpCount += 1;
        this.bigHeadFrameExcpCount = 0;
      }
      SharedPreferences.Editor localEditor = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).edit();
      localEditor.putInt("qmcf_exception_curr_count_bighead", this.bigHeadCurrExcpCount);
      localEditor.commit();
      if (SLog.isEnable()) {
        SLog.d("QmcfSwitchStrategy", String.format("BigHeadMode: isSuccess[%s], forceUpdate[%s], currCount[%s]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(this.bigHeadCurrExcpCount) }));
      }
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
      if (paramBoolean1)
      {
        this.danceCurrExcpCount = 0;
      }
      else
      {
        this.danceCurrExcpCount += 1;
        this.danceFrameExcpCount = 0;
      }
      SharedPreferences.Editor localEditor = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).edit();
      localEditor.putInt("qmcf_exception_curr_count_dance", this.danceCurrExcpCount);
      localEditor.commit();
      if (SLog.isEnable()) {
        SLog.d("QmcfSwitchStrategy", String.format("DanceMode: isSuccess[%s], forceUpdate[%s], currCount[%s]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(this.danceCurrExcpCount) }));
      }
    }
  }
  
  public void setInitSuccess(boolean paramBoolean)
  {
    this.initSuccess = paramBoolean;
  }
  
  public void setMobileSupport(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void setQmcfRunSupported(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        setBigHeadRunSupport(paramBoolean1, paramBoolean2);
        return;
      }
      setDanceGameRunSupport(paramBoolean1, paramBoolean2);
      return;
    }
    setArtFilterRunSupport(paramBoolean1, paramBoolean2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qmcf.QmcfSwitchStrategy
 * JD-Core Version:    0.7.0.1
 */