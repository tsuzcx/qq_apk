package com.tencent.mobileqq.ecshop.widget;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.mtt.supportui.views.recyclerview.LinearLayoutManager;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/ecshop/widget/QQShopPAHippyFragment2$doHippyScrollWithHead$1", "Lcom/tencent/mtt/supportui/views/recyclerview/RecyclerView$OnListScrollListener;", "onDragEnd", "", "onScroll", "x", "", "y", "onScrollEnd", "onStartDrag", "onStartFling", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class QQShopPAHippyFragment2$doHippyScrollWithHead$1
  implements RecyclerView.OnListScrollListener
{
  QQShopPAHippyFragment2$doHippyScrollWithHead$1(View paramView) {}
  
  public void onDragEnd() {}
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    Object localObject = ((HippyListView)this.jdField_a_of_type_AndroidViewView).getLayoutManager();
    if (localObject != null)
    {
      if (((LinearLayoutManager)localObject).findFirstVisibleItemPosition() <= QQShopPAHippyFragment2.a(this.jdField_a_of_type_ComTencentMobileqqEcshopWidgetQQShopPAHippyFragment2)) {
        QQShopPAHippyFragment2.a(this.jdField_a_of_type_ComTencentMobileqqEcshopWidgetQQShopPAHippyFragment2).setVisibility(0);
      } else {
        QQShopPAHippyFragment2.a(this.jdField_a_of_type_ComTencentMobileqqEcshopWidgetQQShopPAHippyFragment2).setVisibility(8);
      }
      if (QQShopPAHippyFragment2.a(this.jdField_a_of_type_ComTencentMobileqqEcshopWidgetQQShopPAHippyFragment2).getVisibility() == 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqEcshopWidgetQQShopPAHippyFragment2;
        paramInt1 = ((QQShopPAHippyFragment2)localObject).a((HippyListView)this.jdField_a_of_type_AndroidViewView, QQShopPAHippyFragment2.a((QQShopPAHippyFragment2)localObject));
        QQShopPAHippyFragment2.a(this.jdField_a_of_type_ComTencentMobileqqEcshopWidgetQQShopPAHippyFragment2).scrollTo(0, paramInt1);
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mtt.supportui.views.recyclerview.LinearLayoutManager");
  }
  
  public void onScrollEnd() {}
  
  public void onStartDrag() {}
  
  public void onStartFling() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.widget.QQShopPAHippyFragment2.doHippyScrollWithHead.1
 * JD-Core Version:    0.7.0.1
 */