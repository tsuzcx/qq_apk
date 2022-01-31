import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.MagicDataReport;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.FaceToolbar;
import com.tencent.av.ui.QAVPtvTemplateAdapter.IEffectCallback;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.mobileqq.utils.AudioHelper;

public class jwh
  implements QAVPtvTemplateAdapter.IEffectCallback
{
  public jwh(FaceToolbar paramFaceToolbar) {}
  
  public void a()
  {
    EffectSettingUi.a(this.a.mApp);
  }
  
  public void a(QavListItemBase.ItemInfo paramItemInfo)
  {
    AVLog.c(FaceToolbar.TAG, "onEffectClick id: " + paramItemInfo.jdField_a_of_type_JavaLangString);
    EffectSettingUi.a(this.a.mApp);
    Object localObject = this.a.mApp.a();
    if (localObject == null) {
      AVLog.e(FaceToolbar.TAG, "videoController == null");
    }
    while (this.a.checkDimmStatus(paramItemInfo)) {
      return;
    }
    localObject = ((VideoController)localObject).a(this.a.mApp.a().a().c) + "";
    if (paramItemInfo.jdField_a_of_type_JavaLangString.equals("0"))
    {
      this.a.notifyEvent(Integer.valueOf(6101), null, Boolean.valueOf(true));
      MagicDataReport.a(2, (String)localObject);
      MagicDataReport.a(2);
      return;
    }
    AudioHelper.a(paramItemInfo.jdField_a_of_type_JavaLangString, false);
    this.a.notifyEvent(Integer.valueOf(6100), paramItemInfo.jdField_a_of_type_JavaLangString, Boolean.valueOf(true));
    MagicDataReport.a(paramItemInfo.jdField_a_of_type_JavaLangString, paramItemInfo.jdField_a_of_type_Int, (String)localObject);
    MagicDataReport.a(paramItemInfo.jdField_a_of_type_JavaLangString, paramItemInfo.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jwh
 * JD-Core Version:    0.7.0.1
 */