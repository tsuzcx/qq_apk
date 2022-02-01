package com.tencent.mobileqq.pic;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public class PicShareToWX$ShareUpCallBack
  implements UpCallBack
{
  private String jdField_a_of_type_JavaLangString;
  
  PicShareToWX$ShareUpCallBack(PicShareToWX paramPicShareToWX, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSend, result.result = ");
      ((StringBuilder)localObject).append(paramSendResult.a);
      QLog.d("PicShareToWX", 1, ((StringBuilder)localObject).toString());
    }
    if (PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX) != null) {
      ThreadManager.getUIHandler().removeCallbacks(PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX.a.dismiss();
    }
    if (paramSendResult.a != 0)
    {
      if (PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX) != null) {
        PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX).callbackResult(PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX), EIPCResult.createResult(-102, null));
      }
      if (PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX) != null) {
        QQToast.a(PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX), 2131719010, 0).a();
      }
      PicShareToWX.a(PicShareToWX.b(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX), false);
      PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX, false, paramSendResult.a, 0);
    }
    else if (PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX) != null)
    {
      PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX).callbackResult(PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX), EIPCResult.createSuccessResult(null));
    }
    this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX.a();
    if ((paramSendResult.a == 0) && (!PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX)))
    {
      paramSendResult = paramSendResult.e;
      localObject = new BitmapFactory.Options();
      ImageUtil.a((BitmapFactory.Options)localObject, this.jdField_a_of_type_JavaLangString, 400);
      localObject = SafeBitmapFactory.decodeFile(this.jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      PicShareToWX localPicShareToWX = this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX;
      localPicShareToWX.a(paramSendResult, (Bitmap)localObject, PicShareToWX.b(localPicShareToWX));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicShareToWX.ShareUpCallBack
 * JD-Core Version:    0.7.0.1
 */