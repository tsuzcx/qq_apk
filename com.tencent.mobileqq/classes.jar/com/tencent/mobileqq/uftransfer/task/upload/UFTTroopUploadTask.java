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
  protected UFTCalcHashOp a;
  protected UFTTroopFetchUploadUrlOp a;
  protected UFTTroopUploadFileOp a;
  protected boolean b = false;
  
  protected UFTTroopUploadTask(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTTroopUploadTaskInfo paramUFTTroopUploadTaskInfo, IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    super(paramAppRuntime, paramUFTTransferKey, paramUFTTroopUploadTaskInfo, paramIUFTTaskCallback, paramIUFTUploadCallback);
  }
  
  public static UFTTroopUploadTask a(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTTroopUploadTaskInfo paramUFTTroopUploadTaskInfo, IUFTTaskCallback paramIUFTTaskCallback, IUFTUploadCallback paramIUFTUploadCallback)
  {
    if (a(paramAppRuntime, paramUFTTransferKey, paramUFTTroopUploadTaskInfo, paramIUFTTaskCallback, "[UFTTransfer] UFTTroopUploadTask")) {
      return new UFTTroopUploadTask(paramAppRuntime, paramUFTTransferKey, paramUFTTroopUploadTaskInfo, paramIUFTTaskCallback, paramIUFTUploadCallback);
    }
    return null;
  }
  
  protected int a()
  {
    return 0;
  }
  
  protected UFTTroopReportData a(int paramInt1, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected UFTTroopUploadTask.UFTToopUploadTaskCompParam a(int paramInt, String paramString)
  {
    paramString = new UFTTroopUploadTask.UFTToopUploadTaskCompParam(paramInt, paramString);
    paramString.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.c();
    paramString.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a();
    paramString.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.k();
    paramString.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.l();
    return paramString;
  }
  
  protected UFTUploadCompleteInfo a(UFTTroopUploadTask.UFTToopUploadTaskCompParam paramUFTToopUploadTaskCompParam)
  {
    UFTUploadCompleteInfo localUFTUploadCompleteInfo = new UFTUploadCompleteInfo();
    UFTTroopUploadTaskInfo localUFTTroopUploadTaskInfo = (UFTTroopUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo;
    localUFTUploadCompleteInfo.a(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a());
    localUFTUploadCompleteInfo.a(localUFTTroopUploadTaskInfo.b());
    localUFTUploadCompleteInfo.c(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a());
    localUFTUploadCompleteInfo.b(paramUFTToopUploadTaskCompParam.jdField_a_of_type_JavaLangString);
    localUFTUploadCompleteInfo.a(paramUFTToopUploadTaskCompParam.h);
    return localUFTUploadCompleteInfo;
  }
  
  public String a()
  {
    return ((UFTTroopUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo).d();
  }
  
  protected void a()
  {
    this.b = false;
    d();
  }
  
  protected void a(int paramInt, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("exception broken");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    localObject = a(7, ((StringBuilder)localObject).toString());
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
    b(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i(), (UFTTroopUploadTask.UFTToopUploadTaskCompParam)localObject);
    a((UFTTroopUploadTask.UFTToopUploadTaskCompParam)localObject);
    i = j;
    if (paramInt != 1) {
      if (paramInt == 2) {
        i = j;
      } else {
        i = 0;
      }
    }
    f();
    super.a(paramBundle);
    if (i != 0)
    {
      paramBundle = a((UFTTroopUploadTask.UFTToopUploadTaskCompParam)localObject);
      paramBundle.b(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, 1000, paramBundle);
    }
  }
  
  protected void a(int paramInt, UFTTroopUploadTask.UFTToopUploadTaskCompParam paramUFTToopUploadTaskCompParam)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] doUploadCompleted errCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramUFTToopUploadTaskCompParam.jdField_a_of_type_JavaLangString);
    UFTLog.b("[UFTTransfer] UFTTroopUploadTask", 1, localStringBuilder.toString());
    f();
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.b(System.currentTimeMillis());
    if (paramInt != 0)
    {
      b(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i(), paramUFTToopUploadTaskCompParam);
      a(paramUFTToopUploadTaskCompParam);
    }
    else
    {
      g();
    }
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, paramInt, a(paramUFTToopUploadTaskCompParam));
    a(paramInt);
  }
  
  protected void a(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("] onSendMsgDone errCode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" errMsg:");
    ((StringBuilder)localObject).append(paramString);
    UFTLog.b("[UFTTransfer] UFTTroopUploadTask", 1, ((StringBuilder)localObject).toString());
    if (paramInt != 0)
    {
      localObject = new UFTTroopUploadTask.UFTToopUploadTaskCompParam(6, paramString, "", false, null);
      ((UFTTroopUploadTask.UFTToopUploadTaskCompParam)localObject).a(13, 1301, 3, paramInt);
      b(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i(), (UFTTroopUploadTask.UFTToopUploadTaskCompParam)localObject);
    }
    a(0, a(6, paramString));
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("] onFetchUrlOpDone errCode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" errMsg:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" showWording:");
    ((StringBuilder)localObject).append(paramString2);
    UFTLog.b("[UFTTransfer] UFTTroopUploadTask", 1, ((StringBuilder)localObject).toString());
    localObject = (UFTTroopUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo;
    if (paramInt != 0)
    {
      b(paramInt, paramString1, paramString2);
      return;
    }
    paramString1 = new UFTTroopFileUploadBusinessInfo();
    paramString1.a(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.b());
    paramString1.a(((UFTTroopUploadTaskInfo)localObject).b());
    paramString1.b(((UFTTroopUploadTaskInfo)localObject).g());
    paramString1.d(((UFTTroopUploadTaskInfo)localObject).h());
    paramString1.a(((UFTTroopUploadTaskInfo)localObject).a());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, paramString1);
    b();
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.g() > 0L) {
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.h(System.currentTimeMillis());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadFileOp != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadFileOp.c());
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.k(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadFileOp.d());
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.l(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadFileOp.e());
    }
    int i = 0;
    if (paramBundle != null) {
      i = paramBundle.getInt("REASON");
    }
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.b(System.currentTimeMillis());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
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
    UFTTroopUploadTask.UFTToopUploadTaskCompParam localUFTToopUploadTaskCompParam = a(4, paramUploadFileOpRetData.a());
    localUFTToopUploadTaskCompParam.jdField_a_of_type_Boolean = paramUploadFileOpRetData.c();
    int k = 1;
    if ((i != 1) && (i != 2))
    {
      int n = 3;
      if ((i != 3) && (i != 4))
      {
        int m = UFTTransferUtility.a(paramUploadFileOpRetData.a());
        int j = m;
        if (m == 0) {
          j = UFTTransferUtility.b(paramUploadFileOpRetData.c());
        }
        int i3 = UFTTransferUtility.c(paramUploadFileOpRetData.a());
        int i2 = UFTTroopReportData.a(i, i3);
        boolean bool = UFTDependFeatureApi.a();
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
                if (paramUploadFileOpRetData.b())
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
  
  protected final void a(UFTTroopUploadTask.UFTToopUploadTaskCompParam paramUFTToopUploadTaskCompParam)
  {
    UFTTroopReportData localUFTTroopReportData = a(paramUFTToopUploadTaskCompParam.jdField_a_of_type_Int, paramUFTToopUploadTaskCompParam.jdField_b_of_type_Int);
    localUFTTroopReportData.jdField_e_of_type_Int = paramUFTToopUploadTaskCompParam.jdField_e_of_type_Int;
    localUFTTroopReportData.f = paramUFTToopUploadTaskCompParam.f;
    localUFTTroopReportData.d = paramUFTToopUploadTaskCompParam.jdField_b_of_type_JavaLangString;
    localUFTTroopReportData.jdField_c_of_type_JavaLangString = paramUFTToopUploadTaskCompParam.jdField_a_of_type_JavaLangString;
    localUFTTroopReportData.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.k();
    localUFTTroopReportData.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.l();
    localUFTTroopReportData.a();
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopFetchUploadUrlOp != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(a());
      localStringBuilder.append("] FetchUrlOp had do");
      UFTLog.d("[UFTTransfer] UFTTroopUploadTask", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] doFetchUrlOp...");
    UFTLog.b("[UFTTransfer] UFTTroopUploadTask", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, 3, null);
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopFetchUploadUrlOp = new UFTTroopFetchUploadUrlOp(this.jdField_a_of_type_MqqAppAppRuntime, (UFTTroopUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo, this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, paramBoolean, new UFTTroopUploadTask.3(this));
    int i = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopFetchUploadUrlOp.a();
    if (i != 0) {
      a(i, this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopFetchUploadUrlOp.a(), "");
    }
  }
  
  protected int b()
  {
    UFTUploadSrvBusiProp.TroopUploadSrvBusiProp localTroopUploadSrvBusiProp = ((UFTTroopUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo).a();
    if ((localTroopUploadSrvBusiProp != null) && (localTroopUploadSrvBusiProp.b()))
    {
      if (localTroopUploadSrvBusiProp.c()) {
        return 3;
      }
      return 2;
    }
    return 1;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadFileOp != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append("] UploadFileOp had do");
      UFTLog.d("[UFTTransfer] UFTTroopUploadTask", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("] doUploadFileOp...");
    UFTLog.b("[UFTTransfer] UFTTroopUploadTask", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.g(System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, 4, null);
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadFileOp = new UFTTroopUploadFileOp(this.jdField_a_of_type_MqqAppAppRuntime, (UFTTroopUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo, this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, new UFTTroopUploadTask.4(this));
    int i = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadFileOp.a();
    if (i != 0)
    {
      localObject = new UFTBaseUploadFileOp.UploadFileOpRetData();
      ((UFTBaseUploadFileOp.UploadFileOpRetData)localObject).a(i);
      ((UFTBaseUploadFileOp.UploadFileOpRetData)localObject).a("start upload file op fail");
      b((UFTBaseUploadFileOp.UploadFileOpRetData)localObject);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadFileOp.b());
  }
  
  protected void b(int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (this.b)
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
                  paramString2 = (UFTTroopUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo;
                  if (paramString2.b() != 104)
                  {
                    paramString2.b(104);
                    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopFetchUploadUrlOp = null;
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
      paramString1 = a(3, paramString1);
      paramString1.a(1, paramInt, 2, paramInt);
      a(i, paramString1);
      return;
    }
    paramString1 = a(3, paramString1);
    paramString1.a(1, 103, 1, 101);
    a(207, paramString1);
  }
  
  protected final void b(long paramLong, UFTTroopUploadTask.UFTToopUploadTaskCompParam paramUFTToopUploadTaskCompParam)
  {
    UFTTroopReportData localUFTTroopReportData = a(paramUFTToopUploadTaskCompParam.jdField_a_of_type_Int, paramUFTToopUploadTaskCompParam.jdField_b_of_type_Int);
    if (paramLong > this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.j()) {
      localUFTTroopReportData.jdField_b_of_type_Long = (paramLong - this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.j());
    }
    localUFTTroopReportData.jdField_e_of_type_Int = paramUFTToopUploadTaskCompParam.jdField_e_of_type_Int;
    localUFTTroopReportData.f = paramUFTToopUploadTaskCompParam.f;
    localUFTTroopReportData.d = paramUFTToopUploadTaskCompParam.jdField_b_of_type_JavaLangString;
    localUFTTroopReportData.jdField_c_of_type_JavaLangString = paramUFTToopUploadTaskCompParam.jdField_a_of_type_JavaLangString;
    localUFTTroopReportData.jdField_c_of_type_Long = paramUFTToopUploadTaskCompParam.jdField_a_of_type_Long;
    localUFTTroopReportData.jdField_e_of_type_Long = paramUFTToopUploadTaskCompParam.jdField_b_of_type_Long;
    localUFTTroopReportData.b();
  }
  
  protected void b(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(true);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("userCancel");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    localObject = a(7, ((StringBuilder)localObject).toString());
    ((UFTTroopUploadTask.UFTToopUploadTaskCompParam)localObject).a(8, 0, 0, 0);
    b(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i(), (UFTTroopUploadTask.UFTToopUploadTaskCompParam)localObject);
    a((UFTTroopUploadTask.UFTToopUploadTaskCompParam)localObject);
    f();
    super.a(paramBundle);
  }
  
  protected void b(UFTBaseUploadFileOp.UploadFileOpRetData paramUploadFileOpRetData)
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.h(System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a(paramUploadFileOpRetData.a());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.b(paramUploadFileOpRetData.c());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a(paramUploadFileOpRetData.a());
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadFileOp != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadFileOp.b());
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.j(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadFileOp.b());
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadFileOp.c());
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadFileOp.c());
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.k(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadFileOp.d());
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.l(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadFileOp.e());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("] on upload file op done. errCode:");
    ((StringBuilder)localObject).append(paramUploadFileOpRetData.a());
    ((StringBuilder)localObject).append(" flash:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a());
    ((StringBuilder)localObject).append(" speed:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.l());
    ((StringBuilder)localObject).append(" httpTime:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.k());
    ((StringBuilder)localObject).append(" url:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a());
    ((StringBuilder)localObject).append(" upStartSize:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.j());
    ((StringBuilder)localObject).append(" upEndSize:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i());
    UFTLog.b("[UFTTransfer] UFTTroopUploadTask", 1, ((StringBuilder)localObject).toString());
    if (paramUploadFileOpRetData.a() != 0)
    {
      a(paramUploadFileOpRetData);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.i(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.b());
    if (((UFTTroopUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo).a())
    {
      e();
      return;
    }
    localObject = a(4, paramUploadFileOpRetData.a());
    ((UFTTroopUploadTask.UFTToopUploadTaskCompParam)localObject).jdField_a_of_type_Boolean = paramUploadFileOpRetData.c();
    a(0, (UFTTroopUploadTask.UFTToopUploadTaskCompParam)localObject);
  }
  
  protected void c(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("] onCalcHashOpDone errCode:");
    ((StringBuilder)localObject).append(paramInt);
    UFTLog.b("[UFTTransfer] UFTTroopUploadTask", 1, ((StringBuilder)localObject).toString());
    if (paramInt != 0)
    {
      localObject = a(2, "get md5 failed");
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
          break label170;
          if (paramInt == 4)
          {
            i = 502;
            j = 205;
            paramInt = 1;
            break label170;
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
      label170:
      ((UFTTroopUploadTask.UFTToopUploadTaskCompParam)localObject).a(k, i, 1, paramInt);
      a(j, (UFTTroopUploadTask.UFTToopUploadTaskCompParam)localObject);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a());
    a(false);
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
    paramString1 = a(3, paramString1);
    paramString1.a(1, paramInt, 2, paramInt);
    a(i, paramString1);
  }
  
  protected boolean c()
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a();
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(false);
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a(System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey);
    UFTLogicThread.a().a(new UFTTroopUploadTask.1(this));
    return true;
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskCommonopUFTCalcHashOp != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append("] CalcHashOp had do");
      UFTLog.d("[UFTTransfer] UFTTroopUploadTask", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().d();
    byte[] arrayOfByte = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().b();
    if ((localObject != null) && (localObject.length > 0) && (arrayOfByte != null) && (arrayOfByte.length > 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append("] file hash exist and calc hash done");
      UFTLog.b("[UFTTransfer] UFTTroopUploadTask", 1, ((StringBuilder)localObject).toString());
      c(0);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("] doCalcHashOp...");
    UFTLog.b("[UFTTransfer] UFTTroopUploadTask", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, 2, null);
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskCommonopUFTCalcHashOp = new UFTCalcHashOp(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo, this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, a(), 30L, new UFTTroopUploadTask.2(this));
    int i = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskCommonopUFTCalcHashOp.a();
    if (i != 0) {
      c(i);
    }
  }
  
  protected boolean d()
  {
    UFTUploadSrvBusiProp.TroopUploadSrvBusiProp localTroopUploadSrvBusiProp = ((UFTTroopUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo).a();
    if (localTroopUploadSrvBusiProp != null) {
      return localTroopUploadSrvBusiProp.a();
    }
    return false;
  }
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, 6, null);
    int i = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTUploadCbWrapper.a(this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey, null, new UFTTroopUploadTask.5(this));
    if (i != 0) {
      a(i, "send msg fail");
    }
  }
  
  protected void f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskCommonopUFTCalcHashOp;
    if (localObject != null)
    {
      ((UFTCalcHashOp)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskCommonopUFTCalcHashOp = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopFetchUploadUrlOp;
    if (localObject != null)
    {
      ((UFTTroopFetchUploadUrlOp)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopFetchUploadUrlOp = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadFileOp;
    if (localObject != null)
    {
      ((UFTTroopUploadFileOp)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTTroopUploadFileOp = null;
    }
  }
  
  protected final void g()
  {
    UFTTroopReportData localUFTTroopReportData = a(0, 0);
    if ((!this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a()) && (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().a() > this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.j())) {
      localUFTTroopReportData.jdField_b_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().a() - this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.j());
    }
    localUFTTroopReportData.jdField_e_of_type_Int = 0;
    localUFTTroopReportData.f = 0;
    localUFTTroopReportData.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.a();
    localUFTTroopReportData.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.k();
    localUFTTroopReportData.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTUploadTaskRunNotesInfo.l();
    localUFTTroopReportData.c();
    localUFTTroopReportData.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTTroopUploadTask
 * JD-Core Version:    0.7.0.1
 */