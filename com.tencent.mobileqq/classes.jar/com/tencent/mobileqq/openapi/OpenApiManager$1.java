package com.tencent.mobileqq.openapi;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class OpenApiManager$1
  implements Runnable
{
  OpenApiManager$1(OpenApiManager paramOpenApiManager, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onRuntimeCreate, app = ");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(", current = ");
      ((StringBuilder)localObject).append(OpenApiManager.access$000(this.this$0));
      ((StringBuilder)localObject).append(", bg = ");
      ((StringBuilder)localObject).append(BaseApplicationImpl.sIsBgStartup);
      QLog.d("OpenApi.Manager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.this$0;
    ((OpenApiManager)localObject).onRuntimeDestroy(OpenApiManager.access$000((OpenApiManager)localObject));
    OpenApiManager.access$002(this.this$0, this.a);
    localObject = new Intent("com.tencent.mobileqq.openapi.ACTION_LOGIN");
    if (BaseApplicationImpl.sIsBgStartup) {
      ((Intent)localObject).putExtra("imm_reg", true);
    }
    BaseApplicationImpl.sApplication.sendBroadcast((Intent)localObject);
    OpenApiManager.access$000(this.this$0).addObserver(OpenApiManager.access$100(this.this$0), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.openapi.OpenApiManager.1
 * JD-Core Version:    0.7.0.1
 */