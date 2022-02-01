package com.tencent.mobileqq.uftransfer.task.upload;

import android.os.Bundle;
import com.tencent.mobileqq.uftransfer.UFTLogicThread;
import com.tencent.mobileqq.uftransfer.api.IUFTUploadCallback;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.UFTTroopFileUploadBusinessInfo;
import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.task.IUFTTaskCallback;
import com.tencent.mobileqq.uftransfer.task.commonop.UFTCalcHashOp;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTTroopUploadTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadSrvBusiProp.TroopUploadSrvBusiProp;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadTaskRunNotesInfo;
import com.tencent.mobileqq.uftransfer.utility.UFTTransferUtility;
import mqq.app.AppRuntime;

public class UFTTroopUploadTask
  extends UFTBaseUploadTask
{
  protected boolean c = false;
  protected UFTCalcHashOp d;
  protected UFTTroopFetchUploadUrlOp e;
  protected UFTTroopUploadFileOp l;
  
  protected UFTTroopUploadTask(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTTroopUploadTaskInfo paramUFTTroopUploadTaskInfo, IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    super(paramAppRuntime, paramUFTTransferKey, paramUFTTroopUploadTaskInfo, paramIUFTTaskCallback, paramIUFTUploadCallback);
  }
  
  public static UFTTroopUploadTask b(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTTroopUploadTaskInfo paramUFTTroopUploadTaskInfo, IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    if (a(paramAppRuntime, paramUFTTransferKey, paramUFTTroopUploadTaskInfo, paramIUFTTaskCallback, "[UFTTransfer] UFTTroopUploadTask")) {
      return new UFTTroopUploadTask(paramAppRuntime, paramUFTTransferKey, paramUFTTroopUploadTaskInfo, paramIUFTTaskCallback, paramIUFTUploadCallback);
    }
    return null;
  }
  
  protected UFTTroopReportData a(int paramInt1, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected UFTUploadCompleteInfo a(UFTTroopUploadTask.UFTToopUploadTaskCompParam paramUFTToopUploadTaskCompParam)
  {
    UFTUploadCompleteInfo localUFTUploadCompleteInfo = new UFTUploadCompleteInfo();
    UFTTroopUploadTaskInfo localUFTTroopUploadTaskInfo = (UFTTroopUploadTaskInfo)this.h;
    localUFTUploadCompleteInfo.a(this.j.i());
    localUFTUploadCompleteInfo.a(localUFTTroopUploadTaskInfo.q());
    localUFTUploadCompleteInfo.c(this.j.m());
    localUFTUploadCompleteInfo.b(paramUFTToopUploadTaskCompParam.i);
    localUFTUploadCompleteInfo.a(paramUFTToopUploadTaskCompParam.h);
    return localUFTUploadCompleteInfo;
  }
  
  protected void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(m());
    ((StringBuilder)localObject).append("] onCalcHashOpDone errCode:");
    ((StringBuilder)localObject).append(paramInt);
    UFTLog.b("[UFTTransfer] UFTTroopUploadTask", 1, ((StringBuilder)localObject).toString());
    if (paramInt != 0)
    {
      localObject = b(2, "get md5 failed");
      int i = 503;
      int k = 5;
      int j;
      if (paramInt == 2)
      {
        i = 501;
        j = 102;
        paramInt = 107;
      }
      else
      {
        if (paramInt == 1)
        {
          i = 700;
          j = 201;
        }
        for (paramInt = 3;; paramInt = 6)
        {
          k = 7;
          break label168;
          if (paramInt == 4)
          {
            i = 502;
            j = 205;
            paramInt = 1;
            break label168;
          }
          if (paramInt != 3) {
            break;
          }
          i = 701;
          j = 203;
        }
        if (paramInt == 7) {
          j = 211;
        } else {
          j = 1;
        }
        paramInt = 8;
      }
      label168:
      ((UFTTroopUploadTask.UFTToopUploadTaskCompParam)localObject).a(k, i, 1, paramInt);
      a(j, (UFTTroopUploadTask.UFTToopUploadTaskCompParam)localObject);
      return;
    }
    this.k.a(this.g, this.h.r());
    a(false);
  }
  
  protected void a(int paramInt, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("exception broken");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    localObject = b(7, ((StringBuilder)localObject).toString());
    int i = 11;
    int j = 1;
    if (paramInt != 1) {
      if (paramInt == 3) {
        i = 12;
      } else if (paramInt != 2) {
        i = 8;
      }
    }
    ((UFTTroopUploadTask.UFTToopUploadTaskCompParam)localObject).a(i, 0, 0, 0);
    b(this.j.j(), (UFTTroopUploadTask.UFTToopUploadTaskCompParam)localObject);
    b((UFTTroopUploadTask.UFTToopUploadTaskCompParam)localObject);
    i = j;
    if (paramInt != 1) {
      if (paramInt == 2) {
        i = j;
      } else {
        i = 0;
      }
    }
    j();
    super.a(paramBundle);
    if (i != 0)
    {
      paramBundle = a((UFTTroopUploadTask.UFTToopUploadTaskCompParam)localObject);
      paramBundle.b(paramInt);
      this.k.a(this.g, 1000, paramBundle);
    }
  }
  
  protected void a(int paramInt, UFTTroopUploadTask.UFTToopUploadTaskCompParam paramUFTToopUploadTaskCompParam)
  {
    if (this.i) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] doUploadCompleted errCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramUFTToopUploadTaskCompParam.i);
    UFTLog.b("[UFTTransfer] UFTTroopUploadTask", 1, localStringBuilder.toString());
    j();
    this.j.b(System.currentTimeMillis());
    if (paramInt != 0)
    {
      b(this.j.j(), paramUFTToopUploadTaskCompParam);
      b(paramUFTToopUploadTaskCompParam);
    }
    else
    {
      p();
    }
    this.k.a(this.g, paramInt, a(paramUFTToopUploadTaskCompParam));
    b(paramInt);
  }
  
  protected void a(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(m());
    ((StringBuilder)localObject).append("] onSendMsgDone errCode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" errMsg:");
    ((StringBuilder)localObject).append(paramString);
    UFTLog.b("[UFTTransfer] UFTTroopUploadTask", 1, ((StringBuilder)localObject).toString());
    if (paramInt != 0)
    {
      localObject = new UFTTroopUploadTask.UFTToopUploadTaskCompParam(6, paramString, "", false, null);
      ((UFTTroopUploadTask.UFTToopUploadTaskCompParam)localObject).a(13, 1301, 3, paramInt);
      b(this.j.j(), (UFTTroopUploadTask.UFTToopUploadTaskCompParam)localObject);
    }
    a(0, b(6, paramString));
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(m());
    ((StringBuilder)localObject).append("] onFetchUrlOpDone errCode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" errMsg:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" showWording:");
    ((StringBuilder)localObject).append(paramString2);
    UFTLog.b("[UFTTransfer] UFTTroopUploadTask", 1, ((StringBuilder)localObject).toString());
    localObject = (UFTTroopUploadTaskInfo)this.h;
    if (paramInt != 0)
    {
      b(paramInt, paramString1, paramString2);
      return;
    }
    paramString1 = new UFTTroopFileUploadBusinessInfo();
    paramString1.a(this.h.q());
    paramString1.a(((UFTTroopUploadTaskInfo)localObject).d());
    paramString1.b(((UFTTroopUploadTaskInfo)localObject).i());
    paramString1.d(((UFTTroopUploadTaskInfo)localObject).j());
    paramString1.a(((UFTTroopUploadTaskInfo)localObject).k());
    this.k.a(this.g, paramString1);
    c();
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.j.g() > 0L) {
      this.j.h(System.currentTimeMillis());
    }
    if (this.l != null)
    {
      this.j.i(this.l.k());
      this.j.k(this.l.b());
      this.j.l(this.l.d());
    }
    int i = 0;
    if (paramBundle != null) {
      i = paramBundle.getInt("REASON");
    }
    this.j.b(System.currentTimeMillis());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] stop ...");
    localStringBuilder.append(i);
    UFTLog.c("[UFTTransfer] UFTTroopUploadTask", 1, localStringBuilder.toString());
    if (i == 0)
    {
      b(paramBundle);
      return;
    }
    a(i, paramBundle);
  }
  
  protected void a(UFTBaseUploadFileOp.UploadFileOpRetData paramUploadFileOpRetData)
  {
    int i = paramUploadFileOpRetData.a();
    UFTTroopUploadTask.UFTToopUploadTaskCompParam localUFTToopUploadTaskCompParam = b(4, paramUploadFileOpRetData.b());
    localUFTToopUploadTaskCompParam.l = paramUploadFileOpRetData.h();
    int k = 1;
    if ((i != 1) && (i != 2))
    {
      int n = 3;
      if ((i != 3) && (i != 4))
      {
        int m = UFTTransferUtility.c(paramUploadFileOpRetData.b());
        int j = m;
        if (m == 0) {
          j = UFTTransferUtility.d(paramUploadFileOpRetData.e());
        }
        int i3 = UFTTransferUtility.e(paramUploadFileOpRetData.b());
        int i2 = UFTTroopReportData.a(i, i3);
        boolean bool = UFTDependFeatureApi.c();
        m = 206;
        int i1;
        if (!bool)
        {
          i2 = 306;
          i = 7;
          m = 106;
          i1 = j;
          j = i2;
        }
        else
        {
          if (i == 9009) {
            m = 312;
          }
          for (i = 111;; i = 112)
          {
            k = 3;
            i2 = 102;
            i1 = j;
            j = m;
            m = i2;
            break label376;
            if (i != 9001) {
              break;
            }
            m = 321;
          }
          if (i == 9343)
          {
            m = 313;
            i = -97;
            k = 3;
            i2 = 1;
            i1 = j;
            j = m;
            m = i2;
          }
          else if (i == 9303)
          {
            i2 = 707;
            i = 6;
            n = 7;
            m = 203;
            i1 = j;
            j = i2;
          }
          else
          {
            if (i == 9042) {}
            for (i = 3;; i = j)
            {
              k = 3;
              i2 = 311;
              i1 = j;
              j = i2;
              break label376;
              if ((j != -38006) && (j != -38007) && (j != -38020))
              {
                if (i == -29120)
                {
                  j = 302;
                  i1 = i;
                  k = 3;
                  break label376;
                }
                if (paramUploadFileOpRetData.g())
                {
                  if (j != 0) {
                    i = j;
                  }
                  k = 3;
                  n = 4;
                  m = 105;
                  i1 = j;
                  j = i2;
                  break label376;
                }
                m = i2;
                if (j == 0) {
                  break;
                }
                i = j;
                m = i2;
                break;
              }
            }
          }
        }
        label376:
        localUFTToopUploadTaskCompParam.a(n, j, k, i);
        localUFTToopUploadTaskCompParam.a(i3);
        localUFTToopUploadTaskCompParam.b(i1);
        a(m, localUFTToopUploadTaskCompParam);
        return;
      }
    }
    localUFTToopUploadTaskCompParam.a(9, 904, 1, 112);
    a(1, localUFTToopUploadTaskCompParam);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.e != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(m());
      localStringBuilder.append("] FetchUrlOp had do");
      UFTLog.d("[UFTTransfer] UFTTroopUploadTask", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(m());
    localStringBuilder.append("] doFetchUrlOp...");
    UFTLog.b("[UFTTransfer] UFTTroopUploadTask", 1, localStringBuilder.toString());
    this.k.a(this.g, 3, null);
    this.e = new UFTTroopFetchUploadUrlOp(this.f, (UFTTroopUploadTaskInfo)this.h, this.g, paramBoolean, new UFTTroopUploadTask.3(this));
    int i = this.e.e();
    if (i != 0) {
      a(i, this.e.h(), "");
    }
  }
  
  protected UFTTroopUploadTask.UFTToopUploadTaskCompParam b(int paramInt, String paramString)
  {
    paramString = new UFTTroopUploadTask.UFTToopUploadTaskCompParam(paramInt, paramString);
    paramString.j = this.j.q();
    paramString.k = this.j.r();
    paramString.m = this.j.t();
    paramString.n = this.j.u();
    return paramString;
  }
  
  protected void b()
  {
    this.c = false;
    g();
  }
  
  protected void b(int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (this.c)
      {
        c(paramInt, paramString1, paramString2);
        return;
      }
      int i;
      if (paramInt != -25126)
      {
        if ((paramInt != -312) && (paramInt != -136))
        {
          if (paramInt != -134)
          {
            if ((paramInt != -107) && (paramInt != -102)) {
              if (paramInt != -36)
              {
                if ((paramInt != -20001) && (paramInt != -20000) && (paramInt != -403))
                {
                  if (paramInt != -402)
                  {
                    if ((paramInt != -139) && (paramInt != -138))
                    {
                      if (paramInt != -2)
                      {
                        if (paramInt == -1) {
                          break label209;
                        }
                        i = 1;
                        break label230;
                      }
                    }
                    else
                    {
                      i = -138;
                      break label230;
                    }
                  }
                  else
                  {
                    i = 704;
                    paramString1 = paramString2;
                    break label230;
                  }
                }
                else
                {
                  paramString2 = (UFTTroopUploadTaskInfo)this.h;
                  if (paramString2.d() != 104)
                  {
                    paramString2.b(104);
                    this.e = null;
                    a(false);
                    return;
                  }
                  i = 204;
                  break label230;
                }
              }
              else
              {
                i = 210;
                break label230;
              }
            }
            i = 208;
            break label230;
          }
          label209:
          i = 202;
        }
        else
        {
          i = -136;
        }
      }
      else {
        i = 209;
      }
      label230:
      paramString1 = b(3, paramString1);
      paramString1.a(1, paramInt, 2, paramInt);
      a(i, paramString1);
      return;
    }
    paramString1 = b(3, paramString1);
    paramString1.a(1, 103, 1, 101);
    a(207, paramString1);
  }
  
  protected final void b(long paramLong, UFTTroopUploadTask.UFTToopUploadTaskCompParam paramUFTToopUploadTaskCompParam)
  {
    UFTTroopReportData localUFTTroopReportData = a(paramUFTToopUploadTaskCompParam.a, paramUFTToopUploadTaskCompParam.b);
    if (paramLong > this.j.k()) {
      localUFTTroopReportData.g = (paramLong - this.j.k());
    }
    localUFTTroopReportData.n = paramUFTToopUploadTaskCompParam.e;
    localUFTTroopReportData.o = paramUFTToopUploadTaskCompParam.f;
    localUFTTroopReportData.s = paramUFTToopUploadTaskCompParam.j;
    localUFTTroopReportData.r = paramUFTToopUploadTaskCompParam.i;
    localUFTTroopReportData.h = paramUFTToopUploadTaskCompParam.m;
    localUFTTroopReportData.j = paramUFTToopUploadTaskCompParam.n;
    localUFTTroopReportData.b();
  }
  
  protected void b(Bundle paramBundle)
  {
    this.k.a(true);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("userCancel");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    localObject = b(7, ((StringBuilder)localObject).toString());
    ((UFTTroopUploadTask.UFTToopUploadTaskCompParam)localObject).a(8, 0, 0, 0);
    b(this.j.j(), (UFTTroopUploadTask.UFTToopUploadTaskCompParam)localObject);
    b((UFTTroopUploadTask.UFTToopUploadTaskCompParam)localObject);
    j();
    super.a(paramBundle);
  }
  
  protected void b(UFTBaseUploadFileOp.UploadFileOpRetData paramUploadFileOpRetData)
  {
    this.j.h(System.currentTimeMillis());
    this.j.a(paramUploadFileOpRetData.d());
    this.j.b(paramUploadFileOpRetData.e());
    this.j.a(paramUploadFileOpRetData.f());
    if (this.l != null)
    {
      this.j.a(this.l.m());
      this.j.j(this.l.j());
      this.j.i(this.l.k());
      this.j.a(this.l.l());
      this.j.k(this.l.b());
      this.j.l(this.l.d());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(m());
    ((StringBuilder)localObject).append("] on upload file op done. errCode:");
    ((StringBuilder)localObject).append(paramUploadFileOpRetData.a());
    ((StringBuilder)localObject).append(" flash:");
    ((StringBuilder)localObject).append(this.j.i());
    ((StringBuilder)localObject).append(" speed:");
    ((StringBuilder)localObject).append(this.j.u());
    ((StringBuilder)localObject).append(" httpTime:");
    ((StringBuilder)localObject).append(this.j.t());
    ((StringBuilder)localObject).append(" url:");
    ((StringBuilder)localObject).append(this.j.m());
    ((StringBuilder)localObject).append(" upStartSize:");
    ((StringBuilder)localObject).append(this.j.k());
    ((StringBuilder)localObject).append(" upEndSize:");
    ((StringBuilder)localObject).append(this.j.j());
    UFTLog.b("[UFTTransfer] UFTTroopUploadTask", 1, ((StringBuilder)localObject).toString());
    if (paramUploadFileOpRetData.a() != 0)
    {
      a(paramUploadFileOpRetData);
      return;
    }
    this.j.i(this.h.p());
    if (((UFTTroopUploadTaskInfo)this.h).h())
    {
      h();
      return;
    }
    localObject = b(4, paramUploadFileOpRetData.b());
    ((UFTTroopUploadTask.UFTToopUploadTaskCompParam)localObject).l = paramUploadFileOpRetData.h();
    a(0, (UFTTroopUploadTask.UFTToopUploadTaskCompParam)localObject);
  }
  
  protected final void b(UFTTroopUploadTask.UFTToopUploadTaskCompParam paramUFTToopUploadTaskCompParam)
  {
    UFTTroopReportData localUFTTroopReportData = a(paramUFTToopUploadTaskCompParam.a, paramUFTToopUploadTaskCompParam.b);
    localUFTTroopReportData.n = paramUFTToopUploadTaskCompParam.e;
    localUFTTroopReportData.o = paramUFTToopUploadTaskCompParam.f;
    localUFTTroopReportData.s = paramUFTToopUploadTaskCompParam.j;
    localUFTTroopReportData.r = paramUFTToopUploadTaskCompParam.i;
    localUFTTroopReportData.h = this.j.t();
    localUFTTroopReportData.j = this.j.u();
    localUFTTroopReportData.a();
  }
  
  protected void c()
  {
    if (this.l != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(m());
      ((StringBuilder)localObject).append("] UploadFileOp had do");
      UFTLog.d("[UFTTransfer] UFTTroopUploadTask", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(m());
    ((StringBuilder)localObject).append("] doUploadFileOp...");
    UFTLog.b("[UFTTransfer] UFTTroopUploadTask", 1, ((StringBuilder)localObject).toString());
    this.j.g(System.currentTimeMillis());
    this.k.a(this.g, 4, null);
    this.l = new UFTTroopUploadFileOp(this.f, (UFTTroopUploadTaskInfo)this.h, this.g, new UFTTroopUploadTask.4(this));
    int i = this.l.e();
    if (i != 0)
    {
      localObject = new UFTBaseUploadFileOp.UploadFileOpRetData();
      ((UFTBaseUploadFileOp.UploadFileOpRetData)localObject).a(i);
      ((UFTBaseUploadFileOp.UploadFileOpRetData)localObject).a("start upload file op fail");
      b((UFTBaseUploadFileOp.UploadFileOpRetData)localObject);
      return;
    }
    this.j.a(this.l.m());
  }
  
  protected void c(int paramInt, String paramString1, String paramString2)
  {
    int j = -138;
    int i;
    if ((paramInt != -312) && (paramInt != -136))
    {
      if (paramInt != -107)
      {
        i = j;
        if (paramInt == -139) {
          break label129;
        }
        i = j;
        if (paramInt == -138) {
          break label129;
        }
        if (paramInt != -103)
        {
          if (paramInt != -102) {
            if (paramInt != -2)
            {
              if (paramInt == -1) {}
            }
            else {
              switch (paramInt)
              {
              default: 
                i = 1;
                break;
              case -303: 
                i = 102;
                break;
              }
            }
          }
        }
        else
        {
          i = 206;
          break label129;
        }
      }
      i = 101;
    }
    else
    {
      i = -136;
    }
    label129:
    paramString1 = b(3, paramString1);
    paramString1.a(1, paramInt, 2, paramInt);
    a(i, paramString1);
  }
  
  protected int d()
  {
    return 0;
  }
  
  protected boolean dy_()
  {
    this.j.v();
    this.k.a(false);
    this.j.a(System.currentTimeMillis());
    this.k.a(this.g);
    UFTLogicThread.a().a(new UFTTroopUploadTask.1(this));
    return true;
  }
  
  protected void g()
  {
    if (this.d != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(m());
      ((StringBuilder)localObject).append("] CalcHashOp had do");
      UFTLog.d("[UFTTransfer] UFTTroopUploadTask", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = this.h.r().e();
    byte[] arrayOfByte = this.h.r().c();
    if ((localObject != null) && (localObject.length > 0) && (arrayOfByte != null) && (arrayOfByte.length > 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(m());
      ((StringBuilder)localObject).append("] file hash exist and calc hash done");
      UFTLog.b("[UFTTransfer] UFTTroopUploadTask", 1, ((StringBuilder)localObject).toString());
      a(0);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(m());
    ((StringBuilder)localObject).append("] doCalcHashOp...");
    UFTLog.b("[UFTTransfer] UFTTroopUploadTask", 1, ((StringBuilder)localObject).toString());
    this.k.a(this.g, 2, null);
    this.d = new UFTCalcHashOp(this.f, this.h, this.g, i(), 30L, new UFTTroopUploadTask.2(this));
    int i = this.d.e();
    if (i != 0) {
      a(i);
    }
  }
  
  protected void h()
  {
    this.k.a(this.g, 6, null);
    int i = this.k.a(this.g, null, new UFTTroopUploadTask.5(this));
    if (i != 0) {
      a(i, "send msg fail");
    }
  }
  
  public String i()
  {
    return ((UFTTroopUploadTaskInfo)this.h).b();
  }
  
  protected void j()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      ((UFTCalcHashOp)localObject).f();
      this.d = null;
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((UFTTroopFetchUploadUrlOp)localObject).f();
      this.e = null;
    }
    localObject = this.l;
    if (localObject != null)
    {
      ((UFTTroopUploadFileOp)localObject).f();
      this.l = null;
    }
  }
  
  protected int n()
  {
    UFTUploadSrvBusiProp.TroopUploadSrvBusiProp localTroopUploadSrvBusiProp = ((UFTTroopUploadTaskInfo)this.h).l();
    if ((localTroopUploadSrvBusiProp != null) && (localTroopUploadSrvBusiProp.e()))
    {
      if (localTroopUploadSrvBusiProp.f()) {
        return 3;
      }
      return 2;
    }
    return 1;
  }
  
  protected boolean o()
  {
    UFTUploadSrvBusiProp.TroopUploadSrvBusiProp localTroopUploadSrvBusiProp = ((UFTTroopUploadTaskInfo)this.h).l();
    if (localTroopUploadSrvBusiProp != null) {
      return localTroopUploadSrvBusiProp.c();
    }
    return false;
  }
  
  protected final void p()
  {
    UFTTroopReportData localUFTTroopReportData = a(0, 0);
    if ((!this.j.i()) && (this.h.r().a() > this.j.k())) {
      localUFTTroopReportData.g = (this.h.r().a() - this.j.k());
    }
    localUFTTroopReportData.n = 0;
    localUFTTroopReportData.o = 0;
    localUFTTroopReportData.k = this.j.i();
    localUFTTroopReportData.h = this.j.t();
    localUFTTroopReportData.j = this.j.u();
    localUFTTroopReportData.c();
    localUFTTroopReportData.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTTroopUploadTask
 * JD-Core Version:    0.7.0.1
 */