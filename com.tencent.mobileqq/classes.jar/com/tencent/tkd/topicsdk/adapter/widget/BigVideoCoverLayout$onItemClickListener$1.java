package com.tencent.tkd.topicsdk.adapter.widget;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class BigVideoCoverLayout$onItemClickListener$1
  implements View.OnClickListener
{
  BigVideoCoverLayout$onItemClickListener$1(BigVideoCoverLayout paramBigVideoCoverLayout, Function1 paramFunction1) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterWidgetBigVideoCoverLayout.a();
    if ((paramView != null) && (paramView != null))
    {
      Function1 localFunction1 = this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
      if (localFunction1 != null) {
        paramView = (Unit)localFunction1.invoke(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.widget.BigVideoCoverLayout.onItemClickListener.1
 * JD-Core Version:    0.7.0.1
 */