package com.tencent.mobileqq.troop.shortcutbar.troopapp;

import android.view.View;
import android.widget.LinearLayout;
import bflv;
import bflx;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView;

public class AppShortcutBarPanel$1
  implements Runnable
{
  public AppShortcutBarPanel$1(bflv parambflv) {}
  
  public void run()
  {
    this.this$0.d();
    if ((bflv.a(this.this$0) != null) && (bflv.a(this.this$0) != null) && (bflv.a(this.this$0) != null) && (bflv.b(this.this$0) != null) && (bflv.a(this.this$0) != null) && (bflv.a(this.this$0).jdField_a_of_type_Boolean) && (bflv.a(this.this$0).jdField_a_of_type_Int > 4) && (bflv.b(this.this$0).getChildCount() == 0))
    {
      View localView1 = bflv.a(this.this$0).findViewById((int)bflv.a(this.this$0).jdField_a_of_type_Long);
      View localView2 = bflv.a(this.this$0).findViewById((int)bflv.a(this.this$0).b);
      int i = localView1.getLeft();
      int j = localView2.getLeft();
      bflv.a(this.this$0).scrollBy(i - j, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.troopapp.AppShortcutBarPanel.1
 * JD-Core Version:    0.7.0.1
 */