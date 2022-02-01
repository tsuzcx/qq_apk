package com.tencent.mobileqq.troop.shortcutbar.troopapp;

import android.view.View;
import android.widget.LinearLayout;
import bgcr;
import bgct;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView;

public class AppShortcutBarPanel$1
  implements Runnable
{
  public AppShortcutBarPanel$1(bgcr parambgcr) {}
  
  public void run()
  {
    this.this$0.e();
    if ((bgcr.a(this.this$0) != null) && (bgcr.a(this.this$0) != null) && (bgcr.a(this.this$0) != null) && (bgcr.b(this.this$0) != null) && (bgcr.a(this.this$0) != null) && (bgcr.a(this.this$0).jdField_a_of_type_Boolean) && (bgcr.a(this.this$0).jdField_a_of_type_Int > 4) && (bgcr.b(this.this$0).getChildCount() == 0))
    {
      View localView1 = bgcr.a(this.this$0).findViewById((int)bgcr.a(this.this$0).jdField_a_of_type_Long);
      View localView2 = bgcr.a(this.this$0).findViewById((int)bgcr.a(this.this$0).b);
      int i = localView1.getLeft();
      int j = localView2.getLeft();
      bgcr.a(this.this$0).scrollBy(i - j, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.troopapp.AppShortcutBarPanel.1
 * JD-Core Version:    0.7.0.1
 */