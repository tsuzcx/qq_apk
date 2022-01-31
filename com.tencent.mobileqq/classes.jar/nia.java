import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qqstory.playmode.child.FeedsPlayModeBase;
import com.tencent.qphone.base.util.QLog;

public class nia
  implements DialogInterface.OnDismissListener
{
  public nia(FeedsPlayModeBase paramFeedsPlayModeBase, Boolean[] paramArrayOfBoolean) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FeedsPlayModeBase", 2, "[az]isResumeVideoPlaySelf === >" + this.jdField_a_of_type_ArrayOfJavaLangBoolean);
    }
    if (!this.jdField_a_of_type_ArrayOfJavaLangBoolean[0].booleanValue()) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase.s();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nia
 * JD-Core Version:    0.7.0.1
 */