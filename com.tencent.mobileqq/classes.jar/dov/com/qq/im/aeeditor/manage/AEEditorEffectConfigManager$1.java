package dov.com.qq.im.aeeditor.manage;

class AEEditorEffectConfigManager$1
  implements Runnable
{
  AEEditorEffectConfigManager$1(AEEditorEffectConfigManager paramAEEditorEffectConfigManager, AEEditorEffectGroupListBean paramAEEditorEffectGroupListBean) {}
  
  public void run()
  {
    synchronized ()
    {
      AEEditorEffectUtils.a(this.a, AEEditorEffectConfigManager.a());
      if (AEEditorEffectConfigManager.a(this.this$0) != null) {
        AEEditorEffectConfigManager.a(this.this$0).a(AEEditorEffectConfigManager.a());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.manage.AEEditorEffectConfigManager.1
 * JD-Core Version:    0.7.0.1
 */