package com.tencent.mobileqq.wink.editor;

import com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateViewModel.UpdateTemplateAction;
import com.tencent.tavcut.operator.DefaultCopiedSourceInsertedStrategy;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wink/editor/WinkVideoTavCut$updateTemplate$1", "Lcom/tencent/tavcut/operator/DefaultCopiedSourceInsertedStrategy;", "enableImageEffect", "", "modifyClipsDuration", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class WinkVideoTavCut$updateTemplate$1
  extends DefaultCopiedSourceInsertedStrategy
{
  WinkVideoTavCut$updateTemplate$1(WinkEditorTemplateViewModel.UpdateTemplateAction paramUpdateTemplateAction) {}
  
  public boolean a()
  {
    String str = WinkVideoTavCut.a(this.a);
    int i;
    if ((str != null) && (((CharSequence)str).length() == 0)) {
      i = 1;
    } else {
      i = 0;
    }
    return (i != 0) && (this.a.o());
  }
  
  public boolean b()
  {
    return this.b.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkVideoTavCut.updateTemplate.1
 * JD-Core Version:    0.7.0.1
 */