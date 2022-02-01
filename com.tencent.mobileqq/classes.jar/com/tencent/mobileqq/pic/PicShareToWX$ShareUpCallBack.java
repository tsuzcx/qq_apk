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
  private String b;
  
  PicShareToWX$ShareUpCallBack(PicShareToWX paramPicShareToWX, String paramString)
  {
    this.b = paramString;
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
    if (PicShareToWX.a(this.a) != null) {
      ThreadManager.getUIHandler().removeCallbacks(PicShareToWX.a(this.a));
    }
    if (this.a.a != null) {
      this.a.a.dismiss();
    }
    if (paramSendResult.a != 0)
    {
      if (this.a.f != null) {
        this.a.f.callbackResult(this.a.g, EIPCResult.createResult(-102, null));
      }
      if (this.a.d != null) {
        QQToast.makeText(this.a.d, 2131916545, 0).show();
      }
      PicShareToWX.a(this.a.e, false);
      PicShareToWX.a(this.a, false, paramSendResult.a, 0);
    }
    else if (this.a.f != null)
    {
      this.a.f.callbackResult(this.a.g, EIPCResult.createSuccessResult(null));
    }
    this.a.a();
    if ((paramSendResult.a == 0) && (!PicShareToWX.b(this.a)))
    {
      paramSendResult = paramSendResult.m;
      localObject = new BitmapFactory.Options();
      ImageUtil.a((BitmapFactory.Options)localObject, this.b, 400);
      localObject = SafeBitmapFactory.decodeFile(this.b, (BitmapFactory.Options)localObject);
      PicShareToWX localPicShareToWX = this.a;
      localPicShareToWX.a(paramSendResult, (Bitmap)localObject, localPicShareToWX.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicShareToWX.ShareUpCallBack
 * JD-Core Version:    0.7.0.1
 */