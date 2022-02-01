package com.tencent.tkd.topicsdk.publisharticle;

import android.os.IBinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.tkd.topicsdk.common.InputMethodUtils;
import com.tencent.tkd.weibo.richEditText.RichEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initBottomSelectorLayout$4
  implements View.OnTouchListener
{
  PublishArticlePage$initBottomSelectorLayout$4(PublishArticlePage paramPublishArticlePage, ViewGroup paramViewGroup) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0)
    {
      paramView = InputMethodUtils.a;
      paramMotionEvent = this.jdField_a_of_type_AndroidViewViewGroup.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramMotionEvent, "frameLayout.context");
      IBinder localIBinder = PublishArticlePage.a(this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticlePage).getWindowToken();
      Intrinsics.checkExpressionValueIsNotNull(localIBinder, "richEditText.windowToken");
      paramView.a(paramMotionEvent, localIBinder);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.initBottomSelectorLayout.4
 * JD-Core Version:    0.7.0.1
 */