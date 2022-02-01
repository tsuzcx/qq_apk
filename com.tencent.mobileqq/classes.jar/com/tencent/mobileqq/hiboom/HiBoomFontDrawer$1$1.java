package com.tencent.mobileqq.hiboom;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasCommonAdapter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

class HiBoomFontDrawer$1$1
  implements Runnable
{
  HiBoomFontDrawer$1$1(HiBoomFontDrawer.1 param1) {}
  
  public void run()
  {
    ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).checkFZEngineReady();
    if (this.a.this$0.c == -1)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.this$0.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader.a());
      ((StringBuilder)localObject).append(this.a.this$0.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(this.a.this$0.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append(".fz4");
      localObject = ((StringBuilder)localObject).toString();
      this.a.this$0.c = ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).initColorFont(this.a.this$0.jdField_b_of_type_Int, (String)localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initColorFont: fontid=");
        ((StringBuilder)localObject).append(this.a.this$0.jdField_b_of_type_Int);
        ((StringBuilder)localObject).append(" result=");
        ((StringBuilder)localObject).append(this.a.this$0.c);
        QLog.d("HiBoomFont.FontDrawer", 2, ((StringBuilder)localObject).toString());
      }
      this.a.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.a.this$0.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      if (this.a.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        HiBoomFontDrawer.a(this.a.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomFontDrawer.1.1
 * JD-Core Version:    0.7.0.1
 */