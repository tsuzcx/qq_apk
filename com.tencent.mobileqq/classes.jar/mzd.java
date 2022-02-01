import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.av.wtogether.fragment.AVRecentFileSelectFragment;
import com.tencent.qphone.base.util.QLog;

public class mzd
  implements DialogInterface.OnClickListener
{
  public mzd(AVRecentFileSelectFragment paramAVRecentFileSelectFragment, ChooseFileInfo paramChooseFileInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.d("AVRecentFileSelectFragment", 1, "enter video[" + this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo + "]");
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("watch_together_uinType", AVRecentFileSelectFragment.a(this.jdField_a_of_type_ComTencentAvWtogetherFragmentAVRecentFileSelectFragment));
    paramDialogInterface.putExtra("watch_together_uin", AVRecentFileSelectFragment.a(this.jdField_a_of_type_ComTencentAvWtogetherFragmentAVRecentFileSelectFragment));
    paramDialogInterface.putExtra("ChooseFileInfo", this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo);
    AVRecentFileSelectFragment.a(this.jdField_a_of_type_ComTencentAvWtogetherFragmentAVRecentFileSelectFragment).setResult(-1, paramDialogInterface);
    AVRecentFileSelectFragment.a(this.jdField_a_of_type_ComTencentAvWtogetherFragmentAVRecentFileSelectFragment).superFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mzd
 * JD-Core Version:    0.7.0.1
 */