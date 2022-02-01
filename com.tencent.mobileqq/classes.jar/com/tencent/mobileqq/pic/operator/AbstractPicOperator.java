package com.tencent.mobileqq.pic.operator;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.UiCallBack;

public abstract class AbstractPicOperator
{
  public String a;
  public String b;
  public PicReq c;
  protected UiCallBack d;
  protected AppInterface e;
  protected Handler f;
  protected String g;
  
  public AbstractPicOperator()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PicOperator.");
    localStringBuilder.append(getClass().getSimpleName());
    this.g = localStringBuilder.toString();
    this.e = PicBusiManager.a();
  }
  
  public abstract void a();
  
  protected void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.f == null) {
      return;
    }
    Message localMessage = new Message();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.obj = paramObject;
    this.f.sendMessage(localMessage);
  }
  
  protected void a(int paramInt, PicInfoInterface.ErrInfo paramErrInfo)
  {
    PicResult localPicResult = new PicResult();
    localPicResult.c = this.c;
    localPicResult.b = paramErrInfo;
    localPicResult.a = -1;
    a(paramInt, -1, localPicResult);
    if (paramErrInfo != null)
    {
      Logger.b(this.b, this.a, paramErrInfo.a, paramErrInfo.b);
      return;
    }
    Logger.b(this.b, this.a, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, PicResult paramPicResult)
  {
    Object localObject = paramPicResult;
    if (paramPicResult == null) {
      localObject = new PicResult();
    }
    ((PicResult)localObject).a = 0;
    ((PicResult)localObject).c = this.c;
    a(paramInt, 0, localObject);
    paramPicResult = this.b;
    localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("what:");
    localStringBuilder.append(paramInt);
    Logger.a(paramPicResult, (String)localObject, "handleSuccess", localStringBuilder.toString());
  }
  
  public void a(UiCallBack paramUiCallBack)
  {
    this.d = paramUiCallBack;
    if (paramUiCallBack == null) {
      return;
    }
    this.f = new AbstractPicOperator.1(this, Looper.getMainLooper());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.AbstractPicOperator
 * JD-Core Version:    0.7.0.1
 */