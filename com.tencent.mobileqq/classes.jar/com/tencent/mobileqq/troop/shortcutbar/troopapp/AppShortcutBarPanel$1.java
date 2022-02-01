package com.tencent.mobileqq.troop.shortcutbar.troopapp;

import android.view.View;
import android.widget.LinearLayout;
import bevi;
import bevk;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView;

public class AppShortcutBarPanel$1
  implements Runnable
{
  public AppShortcutBarPanel$1(bevi parambevi) {}
  
  public void run()
  {
    this.this$0.d();
    if ((bevi.a(this.this$0) != null) && (bevi.a(this.this$0) != null) && (bevi.a(this.this$0) != null) && (bevi.b(this.this$0) != null) && (bevi.a(this.this$0) != null) && (bevi.a(this.this$0).jdField_a_of_type_Boolean) && (bevi.a(this.this$0).jdField_a_of_type_Int > 4) && (bevi.b(this.this$0).getChildCount() == 0))
    {
      View localView1 = bevi.a(this.this$0).findViewById((int)bevi.a(this.this$0).jdField_a_of_type_Long);
      View localView2 = bevi.a(this.this$0).findViewById((int)bevi.a(this.this$0).b);
      int i = localView1.getLeft();
      int j = localView2.getLeft();
      bevi.a(this.this$0).scrollBy(i - j, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.troopapp.AppShortcutBarPanel.1
 * JD-Core Version:    0.7.0.1
 */