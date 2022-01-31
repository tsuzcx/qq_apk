import android.widget.Button;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.AVEffectPendantReport;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.opengl.effects.EffectController;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.AVEffectReport;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.EffectToolbar;
import com.tencent.av.ui.QAVPtvTemplateAdapter.IEffectCallback;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.statistics.MultiVideoRichActionReportCollection;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;

public class jwe
  implements QAVPtvTemplateAdapter.IEffectCallback
{
  public jwe(EffectToolbar paramEffectToolbar) {}
  
  public void a()
  {
    EffectSettingUi.a(this.a.mApp);
  }
  
  public void a(QavListItemBase.ItemInfo paramItemInfo)
  {
    if (this.a.mApp == null) {
      AVLog.e("EffectToolbar", "mApp is null");
    }
    do
    {
      return;
      EffectSettingUi.a(this.a.mApp);
      localObject1 = VideoController.a();
      localObject2 = ((VideoController)localObject1).a(((AVActivity)this.a.mActivity.get()).getApplicationContext());
      if (localObject2 != null)
      {
        QLog.i("EffectToolbar", 2, String.format("onEffectClick, clearState", new Object[0]));
        ((EffectController)localObject2).b();
      }
      if (paramItemInfo.jdField_a_of_type_JavaLangString.equals("0"))
      {
        EffectToolbar.access$000(this.a, null);
        this.a.mEarbackBtn.setVisibility(4);
        this.a.mApp.a().a().T = 0;
        this.a.mApp.a().K();
        return;
      }
    } while (!paramItemInfo.jdField_a_of_type_Boolean);
    Object localObject3 = PtvTemplateManager.jdField_a_of_type_JavaLangString + paramItemInfo.jdField_c_of_type_JavaLangString;
    Object localObject2 = paramItemInfo.jdField_a_of_type_JavaLangString;
    boolean bool = this.a.isEffectBtnEnable();
    if (QLog.isColorLevel()) {
      QLog.i("EffectToolbar", 2, String.format("setVideoFilter path[%s], isUserEffectFace[%s]", new Object[] { localObject3, Boolean.valueOf(bool) }));
    }
    EffectToolbar.access$000(this.a, paramItemInfo.jdField_a_of_type_JavaLangString);
    MultiVideoRichActionReportCollection.b((String)localObject2);
    localObject3 = ((VideoController)localObject1).a();
    int i = ((SessionInfo)localObject3).L;
    int j = ((SessionInfo)localObject3).F;
    long l = ((VideoController)localObject1).f();
    Object localObject1 = (PendantItem)this.a.mPtvTemplateInfoMap.get(localObject2);
    QLog.i("EffectToolbar", 2, "onEffectClick voiceid : " + paramItemInfo.jdField_c_of_type_Int);
    this.a.mApp.a().a().T = paramItemInfo.jdField_c_of_type_Int;
    this.a.mApp.a().K();
    if (paramItemInfo.jdField_c_of_type_Int > 0)
    {
      this.a.mEarbackBtn.setVisibility(0);
      EffectToolbar.access$100(this.a);
    }
    for (;;)
    {
      AVEffectPendantReport.b();
      AVEffectReport.a(j, i, l, (String)localObject2, ((PendantItem)localObject1).getCategory());
      return;
      this.a.mEarbackBtn.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jwe
 * JD-Core Version:    0.7.0.1
 */