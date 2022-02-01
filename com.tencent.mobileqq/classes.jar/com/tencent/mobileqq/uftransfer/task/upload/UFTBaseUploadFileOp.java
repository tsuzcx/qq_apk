package com.tencent.mobileqq.uftransfer.task.upload;

import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.common.transfer.IUFTFileUploader;
import com.tencent.mobileqq.uftransfer.common.transfer.IUFTFileUploaderCallback;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo;
import mqq.app.AppRuntime;

public abstract class UFTBaseUploadFileOp
  extends UFTBaseOp
  implements IUFTFileUploaderCallback
{
  protected IUFTFileUploader a;
  protected UFTBaseUploadFileOp.UFTUploadFileOpCallback a;
  protected boolean b;
  
  public UFTBaseUploadFileOp(AppRuntime paramAppRuntime, UFTBaseTaskInfo paramUFTBaseTaskInfo, UFTTransferKey paramUFTTransferKey, UFTBaseUploadFileOp.UFTUploadFileOpCallback paramUFTUploadFileOpCallback)
  {
    super(paramAppRuntime, paramUFTBaseTaskInfo, paramUFTTransferKey, paramUFTUploadFileOpCallback);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTBaseUploadFileOp$UFTUploadFileOpCallback = paramUFTUploadFileOpCallback;
  }
  
  public int a()
  {
    this.jdField_b_of_type_Boolean = false;
    return super.a();
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTBaseUploadFileOp$UFTUploadFileOpCallback = null;
    IUFTFileUploader localIUFTFileUploader = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferIUFTFileUploader;
    if (localIUFTFileUploader != null) {
      localIUFTFileUploader.a();
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTBaseUploadFileOp$UFTUploadFileOpCallback != null))
    {
      if (UFTLog.a())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("TId[");
        localStringBuilder.append(a());
        localStringBuilder.append("] on upload progress. fsize:");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().a());
        localStringBuilder.append(" tsize:");
        localStringBuilder.append(paramLong1);
        localStringBuilder.append(" speed:");
        localStringBuilder.append(paramLong3);
        UFTLog.a("[UFTTransfer] UFTUploadFileBaseOp", 4, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTBaseUploadFileOp$UFTUploadFileOpCallback.a(paramLong1, paramLong2, paramLong3);
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTBaseUploadFileOp$UFTUploadFileOpCallback != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append("] on upload roll back. rollbackPos:");
      ((StringBuilder)localObject).append(paramLong);
      UFTLog.c("[UFTTransfer] UFTUploadFileBaseOp", 1, ((StringBuilder)localObject).toString());
      localObject = paramString1;
      if (TextUtils.isEmpty(paramString1))
      {
        paramString1 = new StringBuilder();
        paramString1.append("errMsgString_ServerRollback[");
        paramString1.append(9009);
        paramString1.append("]");
        localObject = paramString1.toString();
      }
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferIUFTFileUploader;
      if (paramString1 != null) {
        paramLong = paramString1.b_();
      } else {
        paramLong = 0L;
      }
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTBaseUploadFileOp$UFTUploadFileOpCallback.a(9009, (String)localObject, paramLong, paramString2, null);
    }
  }
  
  protected void a(UFTBaseUploadFileOp.UploadFileOpRetData paramUploadFileOpRetData)
  {
    a(paramUploadFileOpRetData);
  }
  
  public void a(Object paramObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("] on sub uploader success");
    UFTLog.b("[UFTTransfer] UFTUploadFileBaseOp", 1, ((StringBuilder)localObject).toString());
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTBaseUploadFileOp$UFTUploadFileOpCallback != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferIUFTFileUploader;
      long l;
      if (localObject != null) {
        l = ((IUFTFileUploader)localObject).b_();
      } else {
        l = 0L;
      }
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTBaseUploadFileOp$UFTUploadFileOpCallback.a(0, "", l, null, paramObject);
    }
  }
  
  public void a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      UFTBaseUploadFileOp.UFTUploadFileOpCallback localUFTUploadFileOpCallback = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTBaseUploadFileOp$UFTUploadFileOpCallback;
      if (localUFTUploadFileOpCallback != null) {
        localUFTUploadFileOpCallback.a(paramString);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, String paramString1, String paramString2, Object paramObject)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTBaseUploadFileOp$UFTUploadFileOpCallback != null))
    {
      if (paramInt == 0) {
        paramInt = 9001;
      }
      String str = paramString1;
      if (TextUtils.isEmpty(paramString1))
      {
        paramString1 = new StringBuilder();
        paramString1.append("errMsgString_NUll_retCode[");
        paramString1.append(paramInt);
        paramString1.append("]");
        str = paramString1.toString();
      }
      paramString1 = new StringBuilder();
      paramString1.append("TId[");
      paramString1.append(a());
      paramString1.append("] on upload err. finished:");
      paramString1.append(paramBoolean);
      paramString1.append(" errcode:");
      paramString1.append(paramInt);
      paramString1.append(" errmsg:");
      paramString1.append(str);
      paramString1.append(" tsize:");
      paramString1.append(paramLong);
      paramString1.append(" rspheader:");
      paramString1.append(paramString2);
      UFTLog.d("[UFTTransfer] UFTUploadFileBaseOp", 1, paramString1.toString());
      if (paramBoolean)
      {
        paramString1 = new UFTBaseUploadFileOp.UploadFileOpRetData();
        paramString1.a(paramInt);
        paramString1.a(str);
        UFTBaseUploadFileOp.UploadFileOpRetData.a(paramString1, paramObject);
        UFTBaseUploadFileOp.UploadFileOpRetData.a(paramString1, paramString2);
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferIUFTFileUploader;
        if (paramString2 != null) {
          UFTBaseUploadFileOp.UploadFileOpRetData.b(paramString1, paramString2.a());
        }
        UFTBaseUploadFileOp.UploadFileOpRetData.c(paramString1, a());
        a(paramString1);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTBaseUploadFileOp$UFTUploadFileOpCallback.a(paramInt, str, paramLong, paramString2, paramObject);
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTBaseUploadFileOp$UFTUploadFileOpCallback != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append("] on upload suc. isflash:");
      ((StringBuilder)localObject).append(paramBoolean);
      UFTLog.b("[UFTTransfer] UFTUploadFileBaseOp", 1, ((StringBuilder)localObject).toString());
      localObject = new UFTBaseUploadFileOp.UploadFileOpRetData();
      ((UFTBaseUploadFileOp.UploadFileOpRetData)localObject).a(0);
      UFTBaseUploadFileOp.UploadFileOpRetData.a((UFTBaseUploadFileOp.UploadFileOpRetData)localObject, paramBoolean);
      UFTBaseUploadFileOp.UploadFileOpRetData.a((UFTBaseUploadFileOp.UploadFileOpRetData)localObject, paramObject);
      paramObject = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferIUFTFileUploader;
      if (paramObject != null) {
        UFTBaseUploadFileOp.UploadFileOpRetData.b((UFTBaseUploadFileOp.UploadFileOpRetData)localObject, paramObject.a());
      }
      UFTBaseUploadFileOp.UploadFileOpRetData.c((UFTBaseUploadFileOp.UploadFileOpRetData)localObject, a());
      a((UFTBaseUploadFileOp.UploadFileOpRetData)localObject);
    }
  }
  
  public abstract boolean a();
  
  public void aS_()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("] on upload url or file id outdate");
    UFTLog.d("[UFTTransfer] UFTUploadFileBaseOp", 1, ((StringBuilder)localObject).toString());
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUploadUFTBaseUploadFileOp$UFTUploadFileOpCallback;
      if (localObject != null) {
        ((UFTBaseUploadFileOp.UFTUploadFileOpCallback)localObject).a();
      }
    }
  }
  
  public long b()
  {
    IUFTFileUploader localIUFTFileUploader = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferIUFTFileUploader;
    if (localIUFTFileUploader != null) {
      return localIUFTFileUploader.b();
    }
    return 0L;
  }
  
  public String b()
  {
    IUFTFileUploader localIUFTFileUploader = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferIUFTFileUploader;
    if (localIUFTFileUploader != null) {
      return localIUFTFileUploader.a();
    }
    return "";
  }
  
  public void b(String paramString) {}
  
  public int c()
  {
    IUFTFileUploader localIUFTFileUploader = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferIUFTFileUploader;
    if (localIUFTFileUploader != null) {
      return localIUFTFileUploader.a();
    }
    return 0;
  }
  
  public long c()
  {
    IUFTFileUploader localIUFTFileUploader = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferIUFTFileUploader;
    if (localIUFTFileUploader != null) {
      return localIUFTFileUploader.b_();
    }
    return 0L;
  }
  
  public long d()
  {
    if (this.jdField_a_of_type_Long > 0L)
    {
      long l1;
      if (this.jdField_b_of_type_Long > this.jdField_a_of_type_Long) {
        l1 = this.jdField_b_of_type_Long;
      }
      for (long l2 = this.jdField_a_of_type_Long;; l2 = this.jdField_a_of_type_Long)
      {
        return l1 - l2;
        l1 = System.currentTimeMillis();
        if (l1 <= this.jdField_a_of_type_Long) {
          break;
        }
      }
    }
    return 0L;
  }
  
  public long e()
  {
    if (this.jdField_b_of_type_Boolean) {
      return 0L;
    }
    long l2 = d();
    if (l2 <= 0L) {
      return 0L;
    }
    long l1;
    if (c() > b()) {
      l1 = c() - b();
    } else {
      l1 = 0L;
    }
    if (l1 < 1024L) {
      return 0L;
    }
    float f = (float)l2 / 1000.0F;
    return ((float)l1 / f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTBaseUploadFileOp
 * JD-Core Version:    0.7.0.1
 */