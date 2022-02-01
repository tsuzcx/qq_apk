package dov.com.qq.im.aeeditor.module.edit;

import com.tencent.tavcut.session.TAVCutImageSession;
import dov.com.qq.im.aeeditor.data.AEEditorImageInfo;
import dov.com.qq.im.aeeditor.module.clip.image.AEEditorCropperPanel.CropChangeCallback;
import java.util.List;

class AEEditorImageEditFragment$5
  implements AEEditorCropperPanel.CropChangeCallback
{
  AEEditorImageEditFragment$5(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void a()
  {
    int i = 0;
    if (i < AEEditorImageEditFragment.a(this.a).size())
    {
      if (i == AEEditorImageEditFragment.a(this.a)) {}
      for (;;)
      {
        i += 1;
        break;
        AEEditorImageEditFragment.a(this.a).setCrop(i, ((AEEditorImageInfo)AEEditorImageEditFragment.a(this.a).get(i)).a);
        AEEditorImageEditFragment.a(this.a, i);
      }
    }
  }
  
  public void b()
  {
    AEEditorImageEditFragment.a(this.a).setCrop(AEEditorImageEditFragment.a(this.a), ((AEEditorImageInfo)AEEditorImageEditFragment.a(this.a).get(AEEditorImageEditFragment.a(this.a))).a);
    AEEditorImageEditFragment.a(this.a, AEEditorImageEditFragment.a(this.a));
    this.a.t();
  }
  
  public void c()
  {
    this.a.t();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.5
 * JD-Core Version:    0.7.0.1
 */