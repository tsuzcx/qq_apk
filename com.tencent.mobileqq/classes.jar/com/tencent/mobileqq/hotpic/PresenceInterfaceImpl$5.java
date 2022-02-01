package com.tencent.mobileqq.hotpic;

import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class PresenceInterfaceImpl$5
  implements Runnable
{
  PresenceInterfaceImpl$5(PresenceInterfaceImpl paramPresenceInterfaceImpl) {}
  
  public void run()
  {
    if (this.this$0.c.g == null) {
      return;
    }
    this.this$0.c.g.setVisibility(0);
    this.this$0.d.a(this.this$0.c.g);
    boolean bool;
    if ((this.this$0.g != null) && ((HotPicPageView)this.this$0.g.get() != null)) {
      bool = HotPicPageView.o;
    } else {
      bool = false;
    }
    this.this$0.d.a(this.this$0.c.f.c, this.this$0.c.f.g, 0L, this.this$0.c.f.d, bool);
    String str;
    if (this.this$0.d.b()) {
      str = "0X8007ED5";
    } else {
      str = "0X8007ED6";
    }
    ReportController.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    QLog.d("PresenceInterfaceImpl", 2, "have run mVideoPlayControl.startPlay");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.PresenceInterfaceImpl.5
 * JD-Core Version:    0.7.0.1
 */