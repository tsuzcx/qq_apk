package com.tencent.mobileqq.kandian.biz.pts.item;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2;
import com.tencent.mobileqq.kandian.glue.viola.modules.QShareUtils;

class PgcShortContentProteusItem$12
  implements View.OnAttachStateChangeListener
{
  PgcShortContentProteusItem$12(PgcShortContentProteusItem paramPgcShortContentProteusItem) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (PgcShortContentProteusItem.a(this.a) != null)
    {
      PgcShortContentProteusItem.a(this.a).c();
      PgcShortContentProteusItem.a(this.a, null);
    }
    if (PgcShortContentProteusItem.b(this.a) != null)
    {
      PgcShortContentProteusItem.b(this.a).a();
      PgcShortContentProteusItem.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.PgcShortContentProteusItem.12
 * JD-Core Version:    0.7.0.1
 */