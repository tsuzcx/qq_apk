package com.tencent.mobileqq.intervideo.huayang.impl;

import android.os.Handler;
import android.os.Looper;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper.GetLoginKeyListener;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.huayang.IHuayangPluginNewDownloader.HuayangPluginLoadStatusListener;
import com.tencent.qphone.base.util.QLog;

class HuayangDowanloadHelperImpl$GetLoginKeyDataListener
  implements ILoginKeyHelper.GetLoginKeyListener
{
  private final IVPluginInfo b;
  private final InstalledPlugin c;
  private final boolean d;
  private final String e;
  private final long f;
  private volatile boolean g;
  private Handler h = new Handler(Looper.getMainLooper());
  
  public HuayangDowanloadHelperImpl$GetLoginKeyDataListener(HuayangDowanloadHelperImpl paramHuayangDowanloadHelperImpl, String paramString, IVPluginInfo paramIVPluginInfo, InstalledPlugin paramInstalledPlugin, boolean paramBoolean, long paramLong)
  {
    this.e = paramString;
    this.b = paramIVPluginInfo;
    this.c = paramInstalledPlugin;
    this.d = paramBoolean;
    this.f = paramLong;
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!paramBoolean2))
    {
      HuayangDowanloadHelperImpl.access$1000(this.a).a(5, new Object[] { "" });
      return;
    }
    long l;
    if (paramBoolean1) {
      l = 0L;
    } else {
      l = 2000L;
    }
    if (this.g)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IHuayangPluginNewDownloader", 2, "需要stop");
      }
      return;
    }
    this.h.postDelayed(new HuayangDowanloadHelperImpl.GetLoginKeyDataListener.1(this, paramBoolean1, paramBoolean2), l);
  }
  
  public void a()
  {
    this.g = true;
    this.h.removeCallbacksAndMessages(null);
  }
  
  public void onGetKeyComplete(String paramString, boolean paramBoolean, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.impl.HuayangDowanloadHelperImpl.GetLoginKeyDataListener
 * JD-Core Version:    0.7.0.1
 */