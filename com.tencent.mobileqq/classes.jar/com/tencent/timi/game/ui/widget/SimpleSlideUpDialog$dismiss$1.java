package com.tencent.timi.game.ui.widget;

import android.view.View;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class SimpleSlideUpDialog$dismiss$1
  implements Runnable
{
  SimpleSlideUpDialog$dismiss$1(SimpleSlideUpDialog paramSimpleSlideUpDialog, View paramView1, View paramView2) {}
  
  public final void run()
  {
    int i = this.a.getHeight();
    this.a.setTranslationY(0.0F);
    this.a.setVisibility(0);
    SimpleSlideUpDialog.a(this.this$0, (Runnable)new SimpleSlideUpDialog.dismiss.1.1(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.SimpleSlideUpDialog.dismiss.1
 * JD-Core Version:    0.7.0.1
 */