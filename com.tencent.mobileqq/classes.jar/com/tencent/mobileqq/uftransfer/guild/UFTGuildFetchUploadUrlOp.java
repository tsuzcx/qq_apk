package com.tencent.mobileqq.uftransfer.guild;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.filemanager.api.IFileManagerUtil;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.file.IGuildFileHandler;
import com.tencent.mobileqq.guild.file.IGuildUploadReqCallback;
import com.tencent.mobileqq.guild.file.UFTGuildUploadReq;
import com.tencent.mobileqq.guild.file.UFTGuildUploadRsp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig.UploadConfig;
import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.OpRetData;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.UFTOpCallback;
import java.util.HashMap;
import java.util.Locale;
import mqq.app.AppRuntime;

public class UFTGuildFetchUploadUrlOp
  extends UFTBaseOp
  implements IGuildUploadReqCallback
{
  public static HashMap<Integer, Integer> f = new UFTGuildFetchUploadUrlOp.1();
  private static int n = 0;
  protected final boolean a;
  protected final boolean b;
  protected final boolean c;
  protected final boolean d;
  protected String e;
  
  public UFTGuildFetchUploadUrlOp(AppRuntime paramAppRuntime, UFTGuildUploadTaskInfo paramUFTGuildUploadTaskInfo, UFTTransferKey paramUFTTransferKey, UFTBaseOp.UFTOpCallback paramUFTOpCallback)
  {
    super(paramAppRuntime, paramUFTGuildUploadTaskInfo, paramUFTTransferKey, paramUFTOpCallback);
    this.a = paramUFTGuildUploadTaskInfo.s().a().c();
    this.b = paramUFTGuildUploadTaskInfo.s().a().d();
    this.c = paramUFTGuildUploadTaskInfo.s().a().a();
    this.d = paramUFTGuildUploadTaskInfo.s().a().e();
    d();
  }
  
  public static int a()
  {
    try
    {
      int i = n + 1;
      n = i;
      return i;
    }
    finally {}
  }
  
  private void a(UFTGuildUploadReq paramUFTGuildUploadReq, String paramString)
  {
    int i = ((IFileManagerUtil)QRoute.api(IFileManagerUtil.class)).getFileType(paramString);
    if (f.containsKey(Integer.valueOf(i))) {
      i = ((Integer)f.get(Integer.valueOf(i))).intValue();
    } else {
      i = 0;
    }
    paramUFTGuildUploadReq.c(i);
  }
  
  private void b(UFTGuildUploadRsp paramUFTGuildUploadRsp)
  {
    a(paramUFTGuildUploadRsp);
    UFTBaseOp.OpRetData localOpRetData = new UFTBaseOp.OpRetData();
    localOpRetData.a(0);
    localOpRetData.a(paramUFTGuildUploadRsp.a());
    localOpRetData.a(paramUFTGuildUploadRsp.b());
    a(localOpRetData);
  }
  
  private void c(UFTGuildUploadRsp paramUFTGuildUploadRsp)
  {
    int i;
    if (paramUFTGuildUploadRsp != null)
    {
      i = paramUFTGuildUploadRsp.a();
      localObject1 = paramUFTGuildUploadRsp.b();
    }
    else
    {
      localObject1 = "";
      i = -2147483648;
    }
    int j = i;
    if (i == -2147483648) {
      j = 9001;
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "request url rsp fail";
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TId[");
    ((StringBuilder)localObject1).append(i());
    ((StringBuilder)localObject1).append("] request guild upload url fail. errCode:");
    ((StringBuilder)localObject1).append(j);
    UFTLog.d("[UFTTransfer] UFTGuildFetchUploadUrlOp", 1, ((StringBuilder)localObject1).toString());
    localObject1 = new UFTBaseOp.OpRetData();
    ((UFTBaseOp.OpRetData)localObject1).a(j);
    ((UFTBaseOp.OpRetData)localObject1).a((String)localObject2);
    a(paramUFTGuildUploadRsp);
    a((UFTBaseOp.OpRetData)localObject1);
  }
  
  private void d()
  {
    UFTGuildUploadTaskInfo localUFTGuildUploadTaskInfo = (UFTGuildUploadTaskInfo)this.h;
    byte[] arrayOfByte1 = localUFTGuildUploadTaskInfo.r().c();
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 4];
    UFTDependFeatureApi.a(arrayOfByte2, 0, arrayOfByte1, arrayOfByte1.length);
    UFTDependFeatureApi.a(arrayOfByte2, arrayOfByte1.length, localUFTGuildUploadTaskInfo.p());
    this.e = UFTDependFeatureApi.a(arrayOfByte2).toLowerCase(Locale.US);
  }
  
  protected int a(UFTGuildUploadReq paramUFTGuildUploadReq)
  {
    UFTGuildUploadTaskInfo localUFTGuildUploadTaskInfo = (UFTGuildUploadTaskInfo)this.h;
    try
    {
      byte[] arrayOfByte1 = localUFTGuildUploadTaskInfo.o().getBytes("utf-8");
      byte[] arrayOfByte2 = localUFTGuildUploadTaskInfo.a().getBytes("utf-8");
      paramUFTGuildUploadReq.a(a());
      paramUFTGuildUploadReq.a(localUFTGuildUploadTaskInfo.c());
      paramUFTGuildUploadReq.b(localUFTGuildUploadTaskInfo.d());
      paramUFTGuildUploadReq.a(localUFTGuildUploadTaskInfo.p());
      paramUFTGuildUploadReq.c(new String(arrayOfByte1));
      paramUFTGuildUploadReq.d(new String(arrayOfByte2));
      paramUFTGuildUploadReq.b(4202);
      paramUFTGuildUploadReq.a(localUFTGuildUploadTaskInfo.r().c());
      paramUFTGuildUploadReq.b(localUFTGuildUploadTaskInfo.r().e());
      a(paramUFTGuildUploadReq, paramUFTGuildUploadReq.g());
      return 0;
    }
    catch (Exception paramUFTGuildUploadReq)
    {
      label125:
      break label125;
    }
    c("strFilePath to bytes fail");
    return 9005;
  }
  
  protected void a(UFTGuildUploadRsp paramUFTGuildUploadRsp)
  {
    if (paramUFTGuildUploadRsp == null) {
      return;
    }
    UFTGuildUploadTaskInfo localUFTGuildUploadTaskInfo = (UFTGuildUploadTaskInfo)this.h;
    if (!TextUtils.isEmpty(paramUFTGuildUploadRsp.c())) {
      localUFTGuildUploadTaskInfo.b(paramUFTGuildUploadRsp.c());
    }
    localUFTGuildUploadTaskInfo.a(paramUFTGuildUploadRsp);
  }
  
  public void a(boolean paramBoolean, UFTGuildUploadRsp paramUFTGuildUploadRsp)
  {
    b(paramBoolean, paramUFTGuildUploadRsp);
  }
  
  protected String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" cfg = useHttps:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" useIPv6:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" useExtf:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ftnSpTst:");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
  
  protected void b(boolean paramBoolean, UFTGuildUploadRsp paramUFTGuildUploadRsp)
  {
    if ((paramBoolean) && (paramUFTGuildUploadRsp != null))
    {
      b(paramUFTGuildUploadRsp);
      return;
    }
    c(paramUFTGuildUploadRsp);
  }
  
  protected boolean b(UFTGuildUploadReq paramUFTGuildUploadReq)
  {
    ((IGuildFileHandler)((AppInterface)this.g).getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildFileHandlerName())).a(paramUFTGuildUploadReq, this);
    return true;
  }
  
  protected int c()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(i());
    ((StringBuilder)localObject).append("] do fetch guild upload url op.");
    ((StringBuilder)localObject).append(b());
    UFTLog.b("[UFTTransfer] UFTGuildFetchUploadUrlOp", 1, ((StringBuilder)localObject).toString());
    localObject = new UFTGuildUploadReq();
    int i = a((UFTGuildUploadReq)localObject);
    if (i != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(i());
      ((StringBuilder)localObject).append("] fetch guild upload url fail. build upload req fail. retCode:");
      ((StringBuilder)localObject).append(i);
      UFTLog.d("[UFTTransfer] UFTGuildFetchUploadUrlOp", 1, ((StringBuilder)localObject).toString());
      return i;
    }
    if (!b((UFTGuildUploadReq)localObject))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(i());
      ((StringBuilder)localObject).append("] request guild upload url fail");
      UFTLog.d("[UFTTransfer] UFTGuildFetchUploadUrlOp", 1, ((StringBuilder)localObject).toString());
      c("request url fail");
      return 9001;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.guild.UFTGuildFetchUploadUrlOp
 * JD-Core Version:    0.7.0.1
 */