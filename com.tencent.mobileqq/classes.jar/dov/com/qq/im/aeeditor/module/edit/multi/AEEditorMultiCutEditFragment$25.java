package dov.com.qq.im.aeeditor.module.edit.multi;

import android.arch.lifecycle.MutableLiveData;
import android.content.res.Resources;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.weishi.module.edit.cut.CutExtKt;
import com.tencent.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.weseevideo.camera.mvauto.redo.VideoResourceModelKt;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.module.clip.video.VideoSetSpeedDialog;
import dov.com.qq.im.aeeditor.module.clip.video.VideoSetSpeedDialog.OnSpeedChangeListener;
import dov.com.qq.im.aeeditor.module.edit.multi.action.ActionFactory;
import dov.com.qq.im.aeeditor.module.edit.multi.data.SpeedFloatUtil;
import dov.com.qq.im.aeeditor.module.edit.multi.viewmodel.MvVideoViewModel;
import dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView;
import java.util.LinkedList;

class AEEditorMultiCutEditFragment$25
  implements VideoSetSpeedDialog.OnSpeedChangeListener
{
  AEEditorMultiCutEditFragment$25(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  @RequiresApi(api=16)
  public void a(float paramFloat)
  {
    AEBaseDataReporter.a().a(paramFloat, "combine");
    AEReportUtils.i(String.valueOf(paramFloat));
    CutModelKt localCutModelKt = this.a.a.a();
    if ((localCutModelKt == null) || (localCutModelKt.getResource() == null)) {
      return;
    }
    float f = localCutModelKt.getResource().getScaleSpeed();
    if (SpeedFloatUtil.a(f, paramFloat))
    {
      AEQLog.a("AEEditorMultiCutEditFragment", "[onChangeSpeed] currentSpeed==newSpeed");
      return;
    }
    if ((float)localCutModelKt.getResource().getSelectTimeDuration() / paramFloat < 1000.0F)
    {
      AEEditorMultiCutEditFragment.a(this.a).a(f);
      QQToast.a(this.a.getActivity(), this.a.getResources().getString(2131689717, new Object[] { Integer.valueOf(1) }), 0).a();
      AEQLog.a("AEEditorMultiCutEditFragment", "[onChangeSpeed] new duration < Config.MIN_VIDEO_CLIP_DURATION_IN_MS");
      return;
    }
    AEEditorMultiCutEditFragment.a(this.a).a(paramFloat);
    long l = CutExtKt.calculateSpeedSeek(AEEditorMultiCutEditFragment.a(this.a), new LinkedList(), localCutModelKt.getUuid());
    if (l >= 0L) {
      AEEditorMultiCutEditFragment.a(this.a, l);
    }
    AEEditorMultiCutEditFragment.a(this.a).a.postValue(ActionFactory.a(localCutModelKt.getUuid(), paramFloat, AEEditorMultiCutEditFragment.a(this.a), AEEditorMultiCutEditFragment.a(this.a).getMediaModel()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.25
 * JD-Core Version:    0.7.0.1
 */