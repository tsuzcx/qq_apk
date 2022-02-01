package com.tencent.mobileqq.minigame.widget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import java.lang.ref.WeakReference;

class BlockAdView$SingleBlockAdView$1
  implements View.OnClickListener
{
  BlockAdView$SingleBlockAdView$1(BlockAdView.SingleBlockAdView paramSingleBlockAdView, GdtAd paramGdtAd) {}
  
  public void onClick(View paramView)
  {
    paramView = new GdtHandler.Params();
    paramView.c = 11;
    paramView.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((Activity)BlockAdView.SingleBlockAdView.access$000(this.this$1));
    paramView.jdField_a_of_type_ComTencentGdtadAditemGdtAd = this.val$gdtAd;
    paramView.jdField_a_of_type_Boolean = true;
    paramView.b = true;
    Bundle localBundle = new Bundle();
    localBundle.putString("big_brother_ref_source_key", "biz_src_miniappD");
    paramView.jdField_a_of_type_AndroidOsBundle = localBundle;
    GdtHandler.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.widget.BlockAdView.SingleBlockAdView.1
 * JD-Core Version:    0.7.0.1
 */