package dov.com.qq.im.aeeditor.module.edit;

import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAIFilterManager.AIFilterObserver;
import dov.com.qq.im.aeeditor.module.aifilter.AIFilterResult;
import dov.com.qq.im.aeeditor.module.aifilter.BatchImageAIFilterResult;

class AEEditorImageEditFragment$14
  implements AEEditorAIFilterManager.AIFilterObserver
{
  AEEditorImageEditFragment$14(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void a(int paramInt, AIFilterResult paramAIFilterResult)
  {
    if ((paramAIFilterResult instanceof BatchImageAIFilterResult)) {
      AEEditorImageEditFragment.a(this.a, (BatchImageAIFilterResult)paramAIFilterResult);
    }
  }
  
  public void aJ_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.14
 * JD-Core Version:    0.7.0.1
 */