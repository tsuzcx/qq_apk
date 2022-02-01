package com.tencent.mobileqq.mini.entry;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.MiniAppConfBean;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.utils.SharedPreUtils;

class QQMessagePageMiniAppEntryManager$1
  implements View.OnLayoutChangeListener
{
  QQMessagePageMiniAppEntryManager$1(QQMessagePageMiniAppEntryManager paramQQMessagePageMiniAppEntryManager) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramInt4 - paramInt2 > 0) && (paramInt3 - paramInt1 > 0) && (SharedPreUtils.aa(QQMessagePageMiniAppEntryManager.access$000(this.this$0)) == 0) && (QQMessagePageMiniAppEntryManager.access$100(this.this$0) != 3))
    {
      paramView = (MiniAppUserAppInfoListManager)QQMessagePageMiniAppEntryManager.access$200(this.this$0).getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER);
      if ((paramView != null) && (paramView.checkAutoShowPullDownEntry()) && (paramView.getPullDownEntryExtInfo() != null))
      {
        paramView = MiniAppConfProcessor.a();
        if ((paramView != null) && (paramView.e()) && (QQMessagePageMiniAppEntryManager.access$300(this.this$0) != null) && (QQMessagePageMiniAppEntryManager.access$300(this.this$0).getRecyclerView() != null))
        {
          this.this$0.showMicroAppEntry();
          QQMessagePageMiniAppEntryManager.access$300(this.this$0).getRecyclerView().requestLayout();
          SharedPreUtils.u(QQMessagePageMiniAppEntryManager.access$000(this.this$0), 1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.QQMessagePageMiniAppEntryManager.1
 * JD-Core Version:    0.7.0.1
 */