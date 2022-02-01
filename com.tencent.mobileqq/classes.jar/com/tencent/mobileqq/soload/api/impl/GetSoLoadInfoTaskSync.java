package com.tencent.mobileqq.soload.api.impl;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.soload.biz.entity.LoadOptions;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.soload.biz.entity.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.biz.entity.SoDetailInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLoadInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLocalInfo;
import com.tencent.mobileqq.soload.config.SoConfigManager;
import com.tencent.mobileqq.soload.entity.SoCrashInfo;
import com.tencent.mobileqq.soload.util.SoLoadUtils;
import com.tencent.qphone.base.util.QLog;

public class GetSoLoadInfoTaskSync
  extends AbsGetSoLoadInfoTask
{
  public GetSoLoadInfoTaskSync(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem)
  {
    super(paramLoadParam, paramLoadItem);
  }
  
  private SoLoadInfo a(SoCrashInfo paramSoCrashInfo)
  {
    if (paramSoCrashInfo != null)
    {
      StringBuilder localStringBuilder;
      if (paramSoCrashInfo.d())
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[handleConfig] InLoadCrashProtectMode, crashInfo=");
          localStringBuilder.append(paramSoCrashInfo);
          QLog.i("SoLoadWidget.GetSoTaskSync", 2, localStringBuilder.toString());
        }
        this.i = "loadcrash";
        return b(8);
      }
      if (paramSoCrashInfo.b())
      {
        if (paramSoCrashInfo.c())
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[handleConfig] InRunCrashProtectMode, crashInfo=");
            localStringBuilder.append(paramSoCrashInfo);
            QLog.i("SoLoadWidget.GetSoTaskSync", 2, localStringBuilder.toString());
          }
          this.i = "runcrash";
          return b(8);
        }
        SoLoadUtils.f(this.b.name);
        return null;
      }
      if (paramSoCrashInfo.f()) {
        SoConfigManager.a().a(this.b.name, paramSoCrashInfo, null);
      }
    }
    return null;
  }
  
  private SoLoadInfo b(int paramInt)
  {
    return a(paramInt);
  }
  
  private SoLoadInfo b(SoLocalInfo paramSoLocalInfo)
  {
    boolean bool2 = a(paramSoLocalInfo);
    boolean bool3 = a(paramSoLocalInfo, this.h);
    boolean bool1;
    if ((this.b.lops.flag & 0x4) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[handleConfigSync] isSoExist=");
      ((StringBuilder)localObject).append(bool2);
      ((StringBuilder)localObject).append(",isRFReady=");
      ((StringBuilder)localObject).append(bool3);
      ((StringBuilder)localObject).append(",isWeak:");
      ((StringBuilder)localObject).append(bool1);
      QLog.i("SoLoadWidget.GetSoTaskSync", 2, ((StringBuilder)localObject).toString());
    }
    if (!bool2) {
      return b(3);
    }
    if ((!bool3) && (!bool1)) {
      return b(11);
    }
    this.e = false;
    Object localObject = paramSoLocalInfo.mSoPath;
    if (!a((String)localObject, paramSoLocalInfo.mSoCRC, this.b, this.h, 1)) {
      return b(10);
    }
    this.f = ((String)localObject);
    if (bool3) {
      this.g = paramSoLocalInfo.mRFileFolder;
    }
    return b(0);
  }
  
  private SoLoadInfo d()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NonNull
  public SoLoadInfo c()
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.GetSoTaskSync", 2, "not main process get loadInfo sync by IPC");
      }
      return SoLoadUtils.a(this.a, this.b);
    }
    SoLoadInfo localSoLoadInfo = d();
    if (localSoLoadInfo != null) {
      return localSoLoadInfo;
    }
    localSoLoadInfo = a(SoLoadUtils.a(this.b.name, this.h.ver));
    if (localSoLoadInfo != null) {
      return localSoLoadInfo;
    }
    return b(SoLoadUtils.a(this.b, this.h));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.GetSoLoadInfoTaskSync
 * JD-Core Version:    0.7.0.1
 */