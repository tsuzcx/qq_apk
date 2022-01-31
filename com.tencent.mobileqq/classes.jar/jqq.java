import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.BeautySettingUi;

public class jqq
  implements DialogInterface.OnClickListener
{
  public jqq(BeautySettingUi paramBeautySettingUi, AVActivity paramAVActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = this.jdField_a_of_type_ComTencentAvUiAVActivity.getIntent().getBooleanExtra("is_video", false);
    String str = this.jdField_a_of_type_ComTencentAvUiBeautySettingUi.a.getCurrentAccountUin();
    SmallScreenUtils.a(str, SmallScreenUtils.a(str, bool) + 1, bool);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jqq
 * JD-Core Version:    0.7.0.1
 */