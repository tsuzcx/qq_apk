package com.tencent.mobileqq.ecshop.view.controller;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.ecshop.utils.QQShopPicUtil;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TitleLayoutController$initFaceView$2
  implements Runnable
{
  TitleLayoutController$initFaceView$2(TitleLayoutController paramTitleLayoutController) {}
  
  public final void run()
  {
    QQShopPicUtil.a.a((View)TitleLayoutController.a(this.this$0), TitleLayoutController.a(this.this$0).getHeight() / 2.0F);
    QQShopPicUtil.a.a(TitleLayoutController.a(this.this$0), TitleLayoutController.a(this.this$0).getHeight() / 2.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.TitleLayoutController.initFaceView.2
 * JD-Core Version:    0.7.0.1
 */