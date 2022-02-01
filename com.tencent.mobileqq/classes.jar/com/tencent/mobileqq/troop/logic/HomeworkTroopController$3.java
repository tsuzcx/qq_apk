package com.tencent.mobileqq.troop.logic;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.Builder;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.DrawableBuilder;
import java.lang.ref.WeakReference;

class HomeworkTroopController$3
  implements Runnable
{
  HomeworkTroopController$3(HomeworkTroopController paramHomeworkTroopController, int paramInt) {}
  
  public void run()
  {
    Object localObject2 = (BaseActivity)HomeworkTroopController.m(this.this$0).get();
    if (localObject2 == null) {
      return;
    }
    int i;
    if (this.a == 1) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject1 = this.this$0.f;
    int j;
    if (i != 0) {
      j = 32;
    } else {
      j = 31;
    }
    localObject1 = ((PanelIconLinearLayout)localObject1).findViewWithTag(Integer.valueOf(j));
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, "showAIOPanelTip anchorView null.");
      }
      return;
    }
    this.this$0.a();
    CalloutPopupWindow.Builder localBuilder = CalloutPopupWindow.a((Context)localObject2).b(0).a(true);
    if (i != 0) {
      i = 2131895276;
    } else {
      i = 2131895277;
    }
    localObject2 = localBuilder.a(((BaseActivity)localObject2).getString(i)).a(16.0F).a(-1);
    ((CalloutPopupWindow.Builder)localObject2).c(49);
    localObject2 = new CalloutPopupWindow.DrawableBuilder((CalloutPopupWindow.Builder)localObject2).b(Color.argb(255, 0, 0, 0)).a(5).a();
    if (localObject2 != null) {
      this.this$0.g = ((CalloutPopupWindow.Builder)localObject2).a();
    }
    if (this.this$0.g != null)
    {
      localObject2 = this.this$0;
      ((HomeworkTroopController)localObject2).h = this.a;
      ((HomeworkTroopController)localObject2).g.a(82);
      this.this$0.g.a(new HomeworkTroopController.3.1(this));
      this.this$0.g.a((View)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.logic.HomeworkTroopController.3
 * JD-Core Version:    0.7.0.1
 */