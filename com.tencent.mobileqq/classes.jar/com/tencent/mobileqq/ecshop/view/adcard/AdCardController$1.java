package com.tencent.mobileqq.ecshop.view.adcard;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.ecshop.utils.QQShopPicUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AdCardController$1
  implements Runnable
{
  AdCardController$1(AdCardController paramAdCardController) {}
  
  public final void run()
  {
    Object localObject1 = AdCardController.a(this.this$0);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "adCardCorporateImage");
    localObject1 = (View)localObject1;
    Object localObject2 = AdCardController.a(this.this$0);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "adCardCorporateImage");
    QQShopPicUtil.a((View)localObject1, ((ImageView)localObject2).getHeight() / 2.0F);
    localObject1 = AdCardController.b(this.this$0);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "adCardCorporateImageBg");
    localObject1 = (View)localObject1;
    localObject2 = AdCardController.b(this.this$0);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "adCardCorporateImageBg");
    QQShopPicUtil.a((View)localObject1, ((FrameLayout)localObject2).getHeight() / 2.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.adcard.AdCardController.1
 * JD-Core Version:    0.7.0.1
 */