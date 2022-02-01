package com.tencent.mobileqq.webview.swift.component;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.common.util.ImageUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.kandian.biz.share.api.IScreenShotShareHelper;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class SwiftBrowserScreenShotHandler$6
  implements Runnable
{
  SwiftBrowserScreenShotHandler$6(SwiftBrowserScreenShotHandler paramSwiftBrowserScreenShotHandler, String paramString, Bundle paramBundle, boolean paramBoolean) {}
  
  public void run()
  {
    String str = ImageUtil.a(BaseApplication.getContext(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
    boolean bool2 = SwiftBrowserScreenShotHandler.a(this.this$0).a().isShowing();
    boolean bool1;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(this.this$0.b))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "doMultiShare download Finish!");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isGif:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(", imgUrl:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("SwiftBrowserScreenShotHandler", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isLastMultiShare:");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(", mLastMultiShareUrl:");
      ((StringBuilder)localObject).append(this.this$0.b);
      QLog.d("SwiftBrowserScreenShotHandler", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isDialogShowing:");
      ((StringBuilder)localObject).append(bool2);
      ((StringBuilder)localObject).append(", localPath:");
      ((StringBuilder)localObject).append(str);
      QLog.d("SwiftBrowserScreenShotHandler", 2, ((StringBuilder)localObject).toString());
    }
    if ((bool2) && (bool1))
    {
      this.this$0.jdField_a_of_type_AndroidOsHandler.post(new SwiftBrowserScreenShotHandler.6.1(this));
      if (!TextUtils.isEmpty(str))
      {
        localObject = this.this$0;
        ((SwiftBrowserScreenShotHandler)localObject).jdField_a_of_type_JavaLangString = str;
        SwiftBrowserScreenShotHandler.a((SwiftBrowserScreenShotHandler)localObject).a(3);
        if (this.jdField_a_of_type_Boolean)
        {
          SwiftBrowserScreenShotHandler.a(this.this$0).d(this.this$0.jdField_a_of_type_JavaLangString);
          return;
        }
        this.this$0.jdField_a_of_type_AndroidOsHandler.post(new SwiftBrowserScreenShotHandler.6.2(this));
        return;
      }
      QRUtils.a(1, 2131695240);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler.6
 * JD-Core Version:    0.7.0.1
 */