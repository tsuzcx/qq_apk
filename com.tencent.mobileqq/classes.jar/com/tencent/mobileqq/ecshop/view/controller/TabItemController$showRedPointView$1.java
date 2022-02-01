package com.tencent.mobileqq.ecshop.view.controller;

import android.widget.ImageView;
import com.tencent.mobileqq.ecshop.redpoint.QQShopRedPointUtil;
import com.tencent.mobileqq.ecshop.redpoint.RedPointInfo;
import com.tencent.mobileqq.utils.StringUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TabItemController$showRedPointView$1
  implements Runnable
{
  TabItemController$showRedPointView$1(TabItemController paramTabItemController, RedPointInfo paramRedPointInfo) {}
  
  public final void run()
  {
    QQShopRedPointUtil.a(this.a.mTabId);
    TabItemController.a(this.this$0).setVisibility(0);
    TabItemController.a(this.this$0, this.a.mTashId);
    String str = this.a.mRedUrl;
    if (!StringUtil.a(str))
    {
      TabItemController localTabItemController = this.this$0;
      Intrinsics.checkExpressionValueIsNotNull(str, "redPointUrl");
      TabItemController.a(localTabItemController, str, this.a.mRedType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.TabItemController.showRedPointView.1
 * JD-Core Version:    0.7.0.1
 */