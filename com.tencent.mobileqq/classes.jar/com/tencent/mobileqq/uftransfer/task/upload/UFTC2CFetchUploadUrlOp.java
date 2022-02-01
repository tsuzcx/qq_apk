package com.tencent.mobileqq.uftransfer.task.upload;

import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig.UploadConfig;
import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.proto.UFTC2CUploadReq;
import com.tencent.mobileqq.uftransfer.proto.UFTC2CUploadRsp;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.OpRetData;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.UFTOpCallback;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTC2CUploadTaskInfo;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTUploadSrvBusiProp.C2CUploadSrvBusiProp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;

public abstract class UFTC2CFetchUploadUrlOp
  extends UFTBaseOp
{
  protected String a;
  protected final boolean b;
  protected final boolean c;
  protected final boolean d;
  protected final boolean e;
  
  public UFTC2CFetchUploadUrlOp(AppRuntime paramAppRuntime, UFTC2CUploadTaskInfo paramUFTC2CUploadTaskInfo, UFTTransferKey paramUFTTransferKey, UFTBaseOp.UFTOpCallback paramUFTOpCallback)
  {
    super(paramAppRuntime, paramUFTC2CUploadTaskInfo, paramUFTTransferKey, paramUFTOpCallback);
    this.b = paramUFTC2CUploadTaskInfo.a().a().c();
    this.c = paramUFTC2CUploadTaskInfo.a().a().d();
    this.d = paramUFTC2CUploadTaskInfo.a().a().a();
    this.e = paramUFTC2CUploadTaskInfo.a().a().e();
    b();
  }
  
  private void b()
  {
    UFTC2CUploadTaskInfo localUFTC2CUploadTaskInfo = (UFTC2CUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo;
    byte[] arrayOfByte1 = localUFTC2CUploadTaskInfo.a().a();
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 4];
    UFTDependFeatureApi.a(arrayOfByte2, 0, arrayOfByte1, arrayOfByte1.length);
    UFTDependFeatureApi.a(arrayOfByte2, arrayOfByte1.length, localUFTC2CUploadTaskInfo.b());
    this.jdField_a_of_type_JavaLangString = UFTDependFeatureApi.a(arrayOfByte2).toLowerCase(Locale.US);
  }
  
  protected int a(UFTC2CUploadReq paramUFTC2CUploadReq)
  {
    UFTC2CUploadTaskInfo localUFTC2CUploadTaskInfo = (UFTC2CUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo;
    try
    {
      arrayOfByte1 = localUFTC2CUploadTaskInfo.a().getBytes("utf-8");
      arrayOfByte2 = localUFTC2CUploadTaskInfo.c().getBytes("utf-8");
      l1 = 0L;
    }
    catch (Exception paramUFTC2CUploadReq)
    {
      byte[] arrayOfByte1;
      byte[] arrayOfByte2;
      long l1;
      long l2;
      label53:
      StringBuilder localStringBuilder;
      break label199;
    }
    try
    {
      l2 = Long.parseLong(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label53;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] send uin err.");
    UFTLog.d("[UFTTransfer] UFTFetchC2CUploadUrlOp", 1, localStringBuilder.toString());
    paramUFTC2CUploadReq.a(l1);
    paramUFTC2CUploadReq.b(Long.parseLong(localUFTC2CUploadTaskInfo.d().replace("+", "")));
    paramUFTC2CUploadReq.c(localUFTC2CUploadTaskInfo.c());
    paramUFTC2CUploadReq.b(localUFTC2CUploadTaskInfo.a());
    paramUFTC2CUploadReq.b(localUFTC2CUploadTaskInfo.e());
    paramUFTC2CUploadReq.d(localUFTC2CUploadTaskInfo.b());
    paramUFTC2CUploadReq.a(new String(arrayOfByte1));
    paramUFTC2CUploadReq.c(new String(arrayOfByte2));
    paramUFTC2CUploadReq.a(localUFTC2CUploadTaskInfo.a().a());
    return 0;
    label199:
    c("strFilePath to bytes fail");
    return 9005;
  }
  
  protected UFTC2CFetchUploadUrlOp.UrlHostInfo a(UFTC2CUploadRsp paramUFTC2CUploadRsp)
  {
    Object localObject2 = paramUFTC2CUploadRsp.a();
    int j = paramUFTC2CUploadRsp.a();
    boolean bool1 = this.b;
    Object localObject1 = null;
    int i;
    boolean bool2;
    if ((bool1) && (!TextUtils.isEmpty(paramUFTC2CUploadRsp.c())))
    {
      localObject1 = paramUFTC2CUploadRsp.c();
      j = paramUFTC2CUploadRsp.b();
      i = j;
      if (j == 0) {
        i = 443;
      }
      bool2 = true;
    }
    else
    {
      i = j;
      if (j == 0) {
        i = 80;
      }
      bool2 = false;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(paramUFTC2CUploadRsp.b());
    ((StringBuilder)localObject3).append(":");
    ((StringBuilder)localObject3).append(i);
    localArrayList.add(((StringBuilder)localObject3).toString());
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append(":");
        localStringBuilder.append(i);
        if (!localArrayList.contains(localStringBuilder.toString()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append(":");
          localStringBuilder.append(i);
          localArrayList.add(localStringBuilder.toString());
        }
      }
    }
    if ((this.c) && (!TextUtils.isEmpty(paramUFTC2CUploadRsp.d())))
    {
      localObject2 = new ArrayList();
      i = UFTDependFeatureApi.a(this.jdField_a_of_type_MqqAppAppRuntime, paramUFTC2CUploadRsp.d(), i, 1, (List)localObject2);
      if (((List)localObject2).size() > 0)
      {
        if (i == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localArrayList.addAll(0, (Collection)localObject2);
        bool3 = true;
        break label350;
      }
    }
    boolean bool3 = false;
    bool1 = false;
    label350:
    if ((this.e) && (!bool2) && (!bool3))
    {
      localArrayList.clear();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("14.17.29.27:");
      ((StringBuilder)localObject2).append(paramUFTC2CUploadRsp.a());
      localArrayList.add(0, ((StringBuilder)localObject2).toString());
    }
    paramUFTC2CUploadRsp = new UFTC2CFetchUploadUrlOp.UrlHostInfo(this);
    paramUFTC2CUploadRsp.jdField_a_of_type_JavaUtilList = localArrayList;
    paramUFTC2CUploadRsp.jdField_a_of_type_Boolean = bool2;
    paramUFTC2CUploadRsp.jdField_a_of_type_JavaLangString = ((String)localObject1);
    paramUFTC2CUploadRsp.b = bool3;
    paramUFTC2CUploadRsp.c = bool1;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TId[");
    ((StringBuilder)localObject1).append(a());
    ((StringBuilder)localObject1).append("] c2c upload ftn host info is :");
    ((StringBuilder)localObject1).append(paramUFTC2CUploadRsp.toString());
    UFTLog.b("[UFTTransfer] UFTFetchC2CUploadUrlOp", 1, ((StringBuilder)localObject1).toString());
    return paramUFTC2CUploadRsp;
  }
  
  protected abstract void a(UFTC2CUploadRsp paramUFTC2CUploadRsp);
  
  protected void a(UFTUploadSrvBusiProp.C2CUploadSrvBusiProp paramC2CUploadSrvBusiProp)
  {
    if (paramC2CUploadSrvBusiProp == null) {
      return;
    }
    UFTC2CUploadTaskInfo localUFTC2CUploadTaskInfo = (UFTC2CUploadTaskInfo)this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo;
    if ((paramC2CUploadSrvBusiProp.a() != null) && (paramC2CUploadSrvBusiProp.a().length > 0)) {
      localUFTC2CUploadTaskInfo.b(new String(paramC2CUploadSrvBusiProp.a()));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] updateUploadTaskInfo srvBusiProp:");
    localStringBuilder.append(paramC2CUploadSrvBusiProp.toString());
    UFTLog.b("[UFTTransfer] UFTFetchC2CUploadUrlOp", 1, localStringBuilder.toString());
    localUFTC2CUploadTaskInfo.a(paramC2CUploadSrvBusiProp);
  }
  
  protected void a(boolean paramBoolean, UFTC2CUploadRsp paramUFTC2CUploadRsp)
  {
    UFTUploadSrvBusiProp.C2CUploadSrvBusiProp localC2CUploadSrvBusiProp = new UFTUploadSrvBusiProp.C2CUploadSrvBusiProp(paramUFTC2CUploadRsp);
    UFTBaseOp.OpRetData localOpRetData = new UFTBaseOp.OpRetData();
    Object localObject;
    int i;
    if (!paramBoolean)
    {
      int j = paramUFTC2CUploadRsp.a();
      localObject = paramUFTC2CUploadRsp.a();
      i = j;
      if (j == 0) {
        i = 9001;
      }
      paramUFTC2CUploadRsp = (UFTC2CUploadRsp)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramUFTC2CUploadRsp = "request url rsp fail";
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append("] request c2c upload url fail. errCode:");
      ((StringBuilder)localObject).append(i);
      UFTLog.d("[UFTTransfer] UFTFetchC2CUploadUrlOp", 1, ((StringBuilder)localObject).toString());
      localOpRetData.a(i);
      localOpRetData.a(paramUFTC2CUploadRsp);
      a(localC2CUploadSrvBusiProp);
      a(localOpRetData);
      return;
    }
    if (paramUFTC2CUploadRsp.a() != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append("] request c2c upload url return error. errCode:");
      ((StringBuilder)localObject).append(paramUFTC2CUploadRsp.a());
      UFTLog.d("[UFTTransfer] UFTFetchC2CUploadUrlOp", 1, ((StringBuilder)localObject).toString());
      localOpRetData.a(paramUFTC2CUploadRsp.a());
      localOpRetData.a(paramUFTC2CUploadRsp.a());
      a(localC2CUploadSrvBusiProp);
      a(localOpRetData);
      return;
    }
    paramBoolean = TextUtils.isEmpty(paramUFTC2CUploadRsp.b());
    if ((paramUFTC2CUploadRsp.a() != null) && (paramUFTC2CUploadRsp.a().length != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (((paramBoolean ^ true)) && (i != 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append("] request c2c upload url return empty uuid.");
      UFTLog.d("[UFTTransfer] UFTFetchC2CUploadUrlOp", 1, ((StringBuilder)localObject).toString());
      localOpRetData.a(9015);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uuid_null[");
      ((StringBuilder)localObject).append(paramUFTC2CUploadRsp.toString());
      ((StringBuilder)localObject).append("]");
      localOpRetData.a(((StringBuilder)localObject).toString());
      a(localC2CUploadSrvBusiProp);
      a(localOpRetData);
      return;
    }
    a(paramUFTC2CUploadRsp);
  }
  
  protected abstract boolean a(UFTC2CUploadReq paramUFTC2CUploadReq);
  
  protected int b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("] do fetch c2c upload url op.");
    ((StringBuilder)localObject).append(b());
    UFTLog.b("[UFTTransfer] UFTFetchC2CUploadUrlOp", 1, ((StringBuilder)localObject).toString());
    localObject = new UFTC2CUploadReq();
    int i = a((UFTC2CUploadReq)localObject);
    if (i != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append("] fetch c2c upload url fail. build upload req fail. retCode:");
      ((StringBuilder)localObject).append(i);
      UFTLog.d("[UFTTransfer] UFTFetchC2CUploadUrlOp", 1, ((StringBuilder)localObject).toString());
      return i;
    }
    if (!a((UFTC2CUploadReq)localObject))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append("] request c2c upload url fail");
      UFTLog.d("[UFTTransfer] UFTFetchC2CUploadUrlOp", 1, ((StringBuilder)localObject).toString());
      c("request url fail");
      return 9001;
    }
    return 0;
  }
  
  protected String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" cfg = useHttps:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" useIPv6:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" useExtf:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" ftnSpTst:");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CFetchUploadUrlOp
 * JD-Core Version:    0.7.0.1
 */