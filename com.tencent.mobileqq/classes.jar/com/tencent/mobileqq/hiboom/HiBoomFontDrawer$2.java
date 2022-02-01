package com.tencent.mobileqq.hiboom;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasCommonAdapter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

class HiBoomFontDrawer$2
  implements Runnable
{
  HiBoomFontDrawer$2(HiBoomFontDrawer paramHiBoomFontDrawer) {}
  
  public void run()
  {
    ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).checkFZEngineReady();
    if (this.this$0.e == -1)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.this$0.l.a());
      ((StringBuilder)localObject).append(this.this$0.c);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(this.this$0.c);
      ((StringBuilder)localObject).append(".fz4");
      localObject = ((StringBuilder)localObject).toString();
      this.this$0.e = ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).initColorFont(this.this$0.c, (String)localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initColorFont: fontid=");
        ((StringBuilder)localObject).append(this.this$0.c);
        ((StringBuilder)localObject).append(" result=");
        ((StringBuilder)localObject).append(this.this$0.e);
        QLog.d("HiBoomFont.FontDrawer", 2, ((StringBuilder)localObject).toString());
      }
      this.this$0.g.set(true);
      this.this$0.h.set(false);
      if (this.this$0.g.get()) {
        HiBoomFontDrawer.a(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomFontDrawer.2
 * JD-Core Version:    0.7.0.1
 */