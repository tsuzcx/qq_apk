import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

class nac
  implements DialogInterface.OnClickListener
{
  nac(nab paramnab, int paramInt, String paramString, ChooseFileInfo paramChooseFileInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      mzq.a().a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo);
      aftr.a(nab.a(this.jdField_a_of_type_Nab).getApp(), nab.a(this.jdField_a_of_type_Nab).getActivity(), nab.a(this.jdField_a_of_type_Nab).getSessionInfo(), true, "AIOQAVWatchTogether", null);
      return;
    }
    QLog.e(nab.jdField_a_of_type_JavaLangString, 1, "deny permission");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nac
 * JD-Core Version:    0.7.0.1
 */