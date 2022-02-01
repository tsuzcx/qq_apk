package dov.com.qq.im.aeeditor.module.edit;

import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAIFilterManager.AIFilterObserver;
import dov.com.qq.im.aeeditor.module.aifilter.AIFilterResult;
import dov.com.qq.im.aeeditor.module.aifilter.VideoAIFilterResult;

class AEEditorVideoEditFragment$17
  implements AEEditorAIFilterManager.AIFilterObserver
{
  AEEditorVideoEditFragment$17(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void a(int paramInt, AIFilterResult paramAIFilterResult)
  {
    if ((paramAIFilterResult instanceof VideoAIFilterResult)) {
      this.a.a = ((VideoAIFilterResult)paramAIFilterResult);
    }
  }
  
  public void aJ_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment.17
 * JD-Core Version:    0.7.0.1
 */