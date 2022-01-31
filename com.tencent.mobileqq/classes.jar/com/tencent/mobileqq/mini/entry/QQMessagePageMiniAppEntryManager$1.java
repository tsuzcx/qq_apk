package com.tencent.mobileqq.mini.entry;

import amcz;
import amda;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import baig;
import com.tencent.mobileqq.app.QQAppInterface;

class QQMessagePageMiniAppEntryManager$1
  implements View.OnLayoutChangeListener
{
  QQMessagePageMiniAppEntryManager$1(QQMessagePageMiniAppEntryManager paramQQMessagePageMiniAppEntryManager) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramInt4 - paramInt2 > 0) && (paramInt3 - paramInt1 > 0) && (baig.G(QQMessagePageMiniAppEntryManager.access$000(this.this$0)) == 0) && (QQMessagePageMiniAppEntryManager.access$100(this.this$0) != 3))
    {
      paramView = (MiniAppUserAppInfoListManager)QQMessagePageMiniAppEntryManager.access$200(this.this$0).getManager(309);
      if ((paramView != null) && (paramView.checkAutoShowPullDownEntry()) && (paramView.getPullDownEntryExtInfo() != null))
      {
        paramView = amda.a();
        if ((paramView != null) && (paramView.d()) && (QQMessagePageMiniAppEntryManager.access$300(this.this$0) != null) && (QQMessagePageMiniAppEntryManager.access$300(this.this$0).getRecyclerView() != null))
        {
          this.this$0.showMicroAppEntry();
          QQMessagePageMiniAppEntryManager.access$300(this.this$0).getRecyclerView().requestLayout();
          baig.v(QQMessagePageMiniAppEntryManager.access$000(this.this$0), 1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.QQMessagePageMiniAppEntryManager.1
 * JD-Core Version:    0.7.0.1
 */