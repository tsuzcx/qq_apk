package com.tencent.mobileqq.ecshop.view.controller;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.ecshop.report.ReportUtil;
import com.tencent.mobileqq.ecshop.utils.QQShopPicUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TitleLayoutController$initFaceView$2
  implements Runnable
{
  TitleLayoutController$initFaceView$2(TitleLayoutController paramTitleLayoutController, boolean paramBoolean1, boolean paramBoolean2, List paramList) {}
  
  public final void run()
  {
    QQShopPicUtil.a((View)TitleLayoutController.d(this.this$0), TitleLayoutController.d(this.this$0).getHeight() / 2.0F);
    QQShopPicUtil.a(TitleLayoutController.e(this.this$0), TitleLayoutController.e(this.this$0).getHeight() / 2.0F);
    if (this.a) {
      TitleLayoutController.c(this.this$0).setVisibility(0);
    }
    if (this.b)
    {
      Object localObject = TitleLayoutController.b(this.this$0).get("pvsrc");
      String str = "";
      if (localObject != null) {
        localObject = (String)TitleLayoutController.b(this.this$0).get("pvsrc");
      } else {
        localObject = "";
      }
      if (TitleLayoutController.b(this.this$0).get("ext10") != null) {
        str = (String)TitleLayoutController.b(this.this$0).get("ext10");
      }
      TitleLayoutController localTitleLayoutController = this.this$0;
      TitleLayoutController.a(localTitleLayoutController, new BubbleController((View)TitleLayoutController.d(localTitleLayoutController), (View.OnClickListener)new TitleLayoutController.initFaceView.2.1(this, (String)localObject, str)));
      ReportUtil.a("qgg_orderbubble_show", "", String.valueOf(NetConnInfoCenter.getServerTimeMillis()), "", (String)localObject, str, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.TitleLayoutController.initFaceView.2
 * JD-Core Version:    0.7.0.1
 */