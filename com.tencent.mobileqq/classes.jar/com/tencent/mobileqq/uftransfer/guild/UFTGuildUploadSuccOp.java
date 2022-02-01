package com.tencent.mobileqq.uftransfer.guild;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.file.IGuildFileHandler;
import com.tencent.mobileqq.guild.file.IGuildUploadSuccReqCallback;
import com.tencent.mobileqq.guild.file.UFTGuildUploadSuccReq;
import com.tencent.mobileqq.guild.file.UFTGuildUploadSuccRsp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.OpRetData;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.UFTOpCallback;
import mqq.app.AppRuntime;

public class UFTGuildUploadSuccOp
  extends UFTBaseOp
  implements IGuildUploadSuccReqCallback
{
  private static int a;
  
  public UFTGuildUploadSuccOp(AppRuntime paramAppRuntime, UFTGuildUploadTaskInfo paramUFTGuildUploadTaskInfo, UFTTransferKey paramUFTTransferKey, UFTBaseOp.UFTOpCallback paramUFTOpCallback)
  {
    super(paramAppRuntime, paramUFTGuildUploadTaskInfo, paramUFTTransferKey, paramUFTOpCallback);
  }
  
  public static int a()
  {
    try
    {
      int i = a + 1;
      a = i;
      return i;
    }
    finally {}
  }
  
  private void b(UFTGuildUploadSuccRsp paramUFTGuildUploadSuccRsp)
  {
    a(paramUFTGuildUploadSuccRsp);
    UFTBaseOp.OpRetData localOpRetData = new UFTBaseOp.OpRetData();
    localOpRetData.a(0);
    localOpRetData.a(paramUFTGuildUploadSuccRsp.a());
    localOpRetData.a(paramUFTGuildUploadSuccRsp.b());
    a(localOpRetData);
  }
  
  private boolean b(UFTGuildUploadSuccReq paramUFTGuildUploadSuccReq)
  {
    if (paramUFTGuildUploadSuccReq == null) {
      return false;
    }
    ((IGuildFileHandler)((AppInterface)this.g).getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildFileHandlerName())).a(paramUFTGuildUploadSuccReq, this);
    return true;
  }
  
  private void c(UFTGuildUploadSuccRsp paramUFTGuildUploadSuccRsp)
  {
    int i;
    if (paramUFTGuildUploadSuccRsp != null)
    {
      i = paramUFTGuildUploadSuccRsp.a();
      localObject1 = paramUFTGuildUploadSuccRsp.b();
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
    ((StringBuilder)localObject1).append("] request c2c upload url fail. errCode:");
    ((StringBuilder)localObject1).append(j);
    UFTLog.d("UFTGuildUploadSuccOp", 1, ((StringBuilder)localObject1).toString());
    localObject1 = new UFTBaseOp.OpRetData();
    ((UFTBaseOp.OpRetData)localObject1).a(j);
    ((UFTBaseOp.OpRetData)localObject1).a((String)localObject2);
    a(paramUFTGuildUploadSuccRsp);
    a((UFTBaseOp.OpRetData)localObject1);
  }
  
  protected int a(UFTGuildUploadSuccReq paramUFTGuildUploadSuccReq)
  {
    UFTGuildUploadTaskInfo localUFTGuildUploadTaskInfo = (UFTGuildUploadTaskInfo)this.h;
    paramUFTGuildUploadSuccReq.a(a());
    paramUFTGuildUploadSuccReq.a(localUFTGuildUploadTaskInfo.c());
    paramUFTGuildUploadSuccReq.b(localUFTGuildUploadTaskInfo.d());
    paramUFTGuildUploadSuccReq.b(4202);
    paramUFTGuildUploadSuccReq.c(localUFTGuildUploadTaskInfo.q());
    paramUFTGuildUploadSuccReq.a(localUFTGuildUploadTaskInfo.g());
    return 0;
  }
  
  protected void a(UFTGuildUploadSuccRsp paramUFTGuildUploadSuccRsp)
  {
    if (paramUFTGuildUploadSuccRsp == null) {
      return;
    }
    UFTGuildUploadTaskInfo localUFTGuildUploadTaskInfo = (UFTGuildUploadTaskInfo)this.h;
    if (!TextUtils.isEmpty(paramUFTGuildUploadSuccRsp.c())) {
      localUFTGuildUploadTaskInfo.b(paramUFTGuildUploadSuccRsp.c());
    }
    localUFTGuildUploadTaskInfo.a(paramUFTGuildUploadSuccRsp);
  }
  
  public void a(boolean paramBoolean, UFTGuildUploadSuccRsp paramUFTGuildUploadSuccRsp)
  {
    if ((paramBoolean) && (paramUFTGuildUploadSuccRsp != null))
    {
      b(paramUFTGuildUploadSuccRsp);
      return;
    }
    c(paramUFTGuildUploadSuccRsp);
  }
  
  protected int c()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TId[");
    ((StringBuilder)localObject).append(i());
    ((StringBuilder)localObject).append("] do set upload suc op");
    UFTLog.b("UFTGuildUploadSuccOp", 1, ((StringBuilder)localObject).toString());
    localObject = new UFTGuildUploadSuccReq();
    int i = a((UFTGuildUploadSuccReq)localObject);
    if (i != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(i());
      ((StringBuilder)localObject).append("] report upload guild file succ fail. build req fail. retCode:");
      ((StringBuilder)localObject).append(i);
      UFTLog.d("UFTGuildUploadSuccOp", 1, ((StringBuilder)localObject).toString());
      return i;
    }
    if (!b((UFTGuildUploadSuccReq)localObject))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TId[");
      ((StringBuilder)localObject).append(i());
      ((StringBuilder)localObject).append("] report upload guild file succ fail. request fail. retCode:");
      ((StringBuilder)localObject).append(i);
      UFTLog.d("UFTGuildUploadSuccOp", 1, ((StringBuilder)localObject).toString());
      c("request fail");
      return 9001;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.guild.UFTGuildUploadSuccOp
 * JD-Core Version:    0.7.0.1
 */