package dov.com.qq.im.aeeditor.module.edit;

import android.util.SparseArray;
import com.tencent.tavcut.session.TAVCutImageSession;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.aeeditor.module.filter.AEEditorResourceManager;
import dov.com.qq.im.aeeditor.module.frame.AEFrameColorListAdapter.OnFrameColorSelectedListener;

class AEEditorImageEditFragment$4
  implements AEFrameColorListAdapter.OnFrameColorSelectedListener
{
  AEEditorImageEditFragment$4(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void a()
  {
    if (AEEditorImageEditFragment.a(this.a) != null)
    {
      AEEditorImageEditFragment.a(this.a).put(AEEditorImageEditFragment.a(this.a), null);
      AEEditorImageEditFragment.a(this.a).removeFrame(AEEditorImageEditFragment.a(this.a));
    }
    AEBaseDataReporter.a().c(null);
  }
  
  public void a(String paramString)
  {
    if (AEEditorImageEditFragment.a(this.a) != null)
    {
      AEEditorImageEditFragment.a(this.a).put(AEEditorImageEditFragment.a(this.a), paramString);
      AEEditorImageEditFragment.a(this.a).addFrame(AEEditorImageEditFragment.a(this.a), AEEditorResourceManager.d, paramString);
    }
    AEBaseDataReporter.a().c(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.4
 * JD-Core Version:    0.7.0.1
 */