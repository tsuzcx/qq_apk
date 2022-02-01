package com.tencent.mobileqq.openapi;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class OpenApiManager$2
  implements Runnable
{
  OpenApiManager$2(OpenApiManager paramOpenApiManager, QQAppInterface paramQQAppInterface, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenApi.Manager", 2, "onRuntimeDisactive, app = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface + ", current = " + OpenApiManager.access$000(this.this$0) + ", " + this.jdField_a_of_type_Boolean);
    }
    if ((OpenApiManager.access$000(this.this$0) != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == OpenApiManager.access$000(this.this$0)))
    {
      OpenApiManager.access$000(this.this$0).removeObserver(OpenApiManager.access$100(this.this$0));
      OpenApiManager.access$200(this.this$0).clear();
      OpenApiManager.access$300(this.this$0).clear();
      OpenApiManager.access$402(this.this$0, 0);
      OpenApiManager.access$502(this.this$0, 0);
      OpenApiManager.access$002(this.this$0, null);
      BaseApplicationImpl.sApplication.sendBroadcast(new Intent("com.tencent.mobileqq.openapi.ACTION_LOGOUT"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.openapi.OpenApiManager.2
 * JD-Core Version:    0.7.0.1
 */