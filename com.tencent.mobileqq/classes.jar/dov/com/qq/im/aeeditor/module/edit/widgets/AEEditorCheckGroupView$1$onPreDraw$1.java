package dov.com.qq.im.aeeditor.module.edit.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class AEEditorCheckGroupView$1$onPreDraw$1
  implements View.OnClickListener
{
  AEEditorCheckGroupView$1$onPreDraw$1(AEEditorCheckGroupView.1 param1, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - AEEditorCheckGroupView.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditWidgetsAEEditorCheckGroupView$1.a) > 500) {
      AEEditorCheckGroupView.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditWidgetsAEEditorCheckGroupView$1.a, this.jdField_a_of_type_Int, false, false, 6, null);
    }
    for (;;)
    {
      AEEditorCheckGroupView.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditWidgetsAEEditorCheckGroupView$1.a, l);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      AEEditorCheckGroupView.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditWidgetsAEEditorCheckGroupView$1.a, this.jdField_a_of_type_Int, true, false, 4, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.widgets.AEEditorCheckGroupView.1.onPreDraw.1
 * JD-Core Version:    0.7.0.1
 */