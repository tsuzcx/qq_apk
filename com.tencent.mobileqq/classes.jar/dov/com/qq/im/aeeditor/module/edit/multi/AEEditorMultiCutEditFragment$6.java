package dov.com.qq.im.aeeditor.module.edit.multi;

import android.arch.lifecycle.Observer;
import androidx.annotation.RequiresApi;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.weishi.module.edit.widget.playtrack.provider.VideoThumbProviderManager;
import com.tencent.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.weseevideo.camera.mvauto.redo.ResourceModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import dov.com.qq.im.aeeditor.view.timebar.scale.ScaleAdapter;
import dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jetbrains.annotations.Nullable;

class AEEditorMultiCutEditFragment$6
  implements Observer<ResourceModel>
{
  AEEditorMultiCutEditFragment$6(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  @RequiresApi(api=17)
  public void a(@Nullable ResourceModel paramResourceModel)
  {
    if (paramResourceModel == null) {
      return;
    }
    AEEditorMultiCutEditFragment.a(this.a, false);
    AEEditorMultiCutEditFragment.b(this.a, false);
    if (AEEditorMultiCutEditFragment.a(this.a))
    {
      int i = AEEditorMultiCutEditFragment.a(this.a, paramResourceModel.getData());
      AEEditorMultiCutEditFragment.a(this.a).c(i);
    }
    AEEditorMultiCutEditFragment.a(this.a, paramResourceModel);
    AEEditorMultiCutEditFragment.b(this.a, paramResourceModel);
    AEEditorMultiCutEditFragment.a(this.a, paramResourceModel.getData());
    if ((this.a.b()) && (AEEditorMultiCutEditFragment.a(this.a).size() >= 2)) {
      AEEditorMultiCutEditFragment.b(this.a);
    }
    if (AEEditorMultiCutEditFragment.a(this.a)) {
      AEEditorMultiCutEditFragment.c(this.a, false);
    }
    for (;;)
    {
      AEEditorMultiCutEditFragment.a(this.a, true);
      paramResourceModel = new LinkedList();
      localObject = AEEditorMultiCutEditFragment.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramResourceModel.add(((CutModelKt)((Iterator)localObject).next()).convert());
      }
      AEEditorMultiCutEditFragment.a(this.a).updateTemplateComposition(true);
    }
    Object localObject = new MediaResourceModel();
    ((MediaResourceModel)localObject).setVideos(paramResourceModel);
    VideoThumbProviderManager.getInstance().reset((MediaResourceModel)localObject, String.valueOf(this.a.getActivity().hashCode()));
    this.a.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.6
 * JD-Core Version:    0.7.0.1
 */