package dov.com.qq.im.aeeditor.module.edit.multi;

import android.animation.Animator;
import android.arch.lifecycle.MutableLiveData;
import android.content.res.Resources;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.RequiresApi;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.weishi.module.edit.cut.CutExtKt;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.module.edit.multi.action.ActionFactory;
import dov.com.qq.im.aeeditor.module.edit.multi.viewmodel.MvVideoViewModel;
import dov.com.qq.im.aeeditor.view.reorder.ReorderContainerView;
import dov.com.qq.im.aeeditor.view.reorder.ReorderListener;
import dov.com.qq.im.aeeditor.view.reorder.ReorderTransition;
import dov.com.qq.im.aeeditor.view.timeline.ScaleScrollLayout;
import dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView;
import java.util.LinkedList;

class AEEditorMultiCutEditFragment$1
  implements ReorderListener
{
  AEEditorMultiCutEditFragment$1(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  @RequiresApi(api=16)
  public void a(@NonNull String paramString, int paramInt)
  {
    if (AEEditorMultiCutEditFragment.a(this.a) != null) {
      AEEditorMultiCutEditFragment.a(this.a).setVisibility(4);
    }
    if (AEEditorMultiCutEditFragment.a(this.a) != null)
    {
      AEEditorMultiCutEditFragment.a(this.a).setVisibility(0);
      AEEditorMultiCutEditFragment.a(this.a).setHandleView(null);
    }
    if (AEEditorMultiCutEditFragment.a(this.a) != null) {
      AEEditorMultiCutEditFragment.a(this.a).setVisibility(0);
    }
    if (AEEditorMultiCutEditFragment.a(this.a) != null) {
      AEEditorMultiCutEditFragment.a(this.a).setVisibility(0);
    }
    AEEditorMultiCutEditFragment.a(this.a, true);
    if ((AEEditorMultiCutEditFragment.a(this.a) != null) && (!paramString.isEmpty()) && (paramInt != -1))
    {
      long l = CutExtKt.calculateReorderSeek(AEEditorMultiCutEditFragment.a(this.a), new LinkedList(), paramString, paramInt);
      if (l >= 0L) {
        AEEditorMultiCutEditFragment.a(this.a, l);
      }
      AEEditorMultiCutEditFragment.a(this.a).a.postValue(ActionFactory.a(paramString, paramInt, AEEditorMultiCutEditFragment.a(this.a), AEEditorMultiCutEditFragment.a(this.a).getMediaModel()));
      AEBaseDataReporter.a().C();
      AEReportUtils.p();
    }
  }
  
  @RequiresApi(api=19)
  public void a(@NonNull String paramString, @NonNull Point paramPoint)
  {
    AEEditorMultiCutEditFragment.a(this.a).setVisibility(8);
    AEEditorMultiCutEditFragment.a(this.a).setVisibility(8);
    AEEditorMultiCutEditFragment.a(this.a, false);
    if (AEEditorMultiCutEditFragment.a(this.a) != null) {}
    for (int i = AEEditorMultiCutEditFragment.a(this.a).a(paramString, paramPoint);; i = -1)
    {
      AEQLog.b("AEEditorMultiCutEditFragment", "dragIndex: " + i);
      if (i != -1)
      {
        int j = this.a.getResources().getDimensionPixelSize(2131296320);
        int k = paramPoint.x;
        int m = this.a.getResources().getDimensionPixelSize(2131296344);
        paramString = ReorderTransition.a(this.a.a.a(), i, k - m, j);
        paramString.setDuration(200L);
        AEEditorMultiCutEditFragment.a(this.a).a();
        paramString.addListener(new AEEditorMultiCutEditFragment.1.1(this, i));
        paramString.start();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.1
 * JD-Core Version:    0.7.0.1
 */