package com.tencent.mobileqq.filemanager.fileassistant.forward;

import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class QFileAssistantForwardManager$1
  implements Runnable
{
  QFileAssistantForwardManager$1(QFileAssistantForwardManager paramQFileAssistantForwardManager, String paramString) {}
  
  public void run()
  {
    if (NetworkUtil.getSystemNetwork(BaseApplication.getContext()) != 0) {
      QQToast.a(QFileAssistantForwardManager.a(this.this$0).getApp(), 2, this.a, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299168));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.forward.QFileAssistantForwardManager.1
 * JD-Core Version:    0.7.0.1
 */