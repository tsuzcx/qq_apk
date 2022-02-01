package dov.com.qq.im.aeeditor.module.edit.multi;

import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAIFilterManager.AIFilterObserver;
import dov.com.qq.im.aeeditor.module.aifilter.AIFilterResult;
import dov.com.qq.im.aeeditor.module.aifilter.VideoAIFilterResult;

class AEEditorMultiVideoEditFragment$2
  implements AEEditorAIFilterManager.AIFilterObserver
{
  AEEditorMultiVideoEditFragment$2(AEEditorMultiVideoEditFragment paramAEEditorMultiVideoEditFragment) {}
  
  public void a(int paramInt, AIFilterResult paramAIFilterResult)
  {
    if ((paramAIFilterResult instanceof VideoAIFilterResult)) {
      AEEditorMultiVideoEditFragment.a(this.a, (VideoAIFilterResult)paramAIFilterResult);
    }
  }
  
  public void aJ_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiVideoEditFragment.2
 * JD-Core Version:    0.7.0.1
 */