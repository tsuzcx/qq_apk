package com.tencent.mobileqq.ecshop.view;

import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

class EcshopWebviewPool$1
  implements Runnable
{
  public void run()
  {
    if (!this.this$0.a(this.a))
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putInt("_accelerator_mode_", 3);
      SwiftWebAccelerator.a().a((Bundle)localObject);
      localObject = EcshopWebview.a(MobileQQ.getContext());
      EcshopWebviewPool.a(this.this$0).put(this.a, localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("【init】webViewLinkedList.size: ");
        ((StringBuilder)localObject).append(EcshopWebviewPool.a(this.this$0).size());
        QLog.i("Ecshop_EcshopWebviewPool", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.EcshopWebviewPool.1
 * JD-Core Version:    0.7.0.1
 */