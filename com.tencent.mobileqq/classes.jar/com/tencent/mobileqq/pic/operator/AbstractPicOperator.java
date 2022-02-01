package com.tencent.mobileqq.pic.operator;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.UiCallBack;

public abstract class AbstractPicOperator
{
  protected Handler a;
  protected QQAppInterface a;
  public PicReq a;
  protected UiCallBack a;
  public String a;
  public String b;
  protected String c = "PicOperator." + getClass().getSimpleName();
  
  public AbstractPicOperator()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = PicBusiManager.a();
  }
  
  public abstract void a();
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    Message localMessage = new Message();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.obj = paramObject;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  protected void a(int paramInt, PicInfoInterface.ErrInfo paramErrInfo)
  {
    PicResult localPicResult = new PicResult();
    localPicResult.jdField_a_of_type_ComTencentMobileqqPicPicReq = this.jdField_a_of_type_ComTencentMobileqqPicPicReq;
    localPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = paramErrInfo;
    localPicResult.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localPicResult);
    if (paramErrInfo != null)
    {
      Logger.b(this.b, this.jdField_a_of_type_JavaLangString, paramErrInfo.jdField_a_of_type_JavaLangString, paramErrInfo.b);
      return;
    }
    Logger.b(this.b, this.jdField_a_of_type_JavaLangString, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, PicResult paramPicResult)
  {
    PicResult localPicResult = paramPicResult;
    if (paramPicResult == null) {
      localPicResult = new PicResult();
    }
    localPicResult.jdField_a_of_type_Int = 0;
    localPicResult.jdField_a_of_type_ComTencentMobileqqPicPicReq = this.jdField_a_of_type_ComTencentMobileqqPicPicReq;
    a(paramInt, 0, localPicResult);
    Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(UiCallBack paramUiCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqPicUiCallBack = paramUiCallBack;
    if (paramUiCallBack == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler = new AbstractPicOperator.1(this, Looper.getMainLooper());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.AbstractPicOperator
 * JD-Core Version:    0.7.0.1
 */