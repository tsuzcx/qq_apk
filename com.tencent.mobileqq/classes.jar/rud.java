import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public final class rud
  implements DialogInterface.OnClickListener
{
  public rud(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener, String paramString, int paramInt3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, this.b);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(paramDialogInterface, paramInt);
    ReportController.b(null, "dc00899", "Grp_video", "", "video_jump", "Clk_jump", 0, 0, this.jdField_a_of_type_JavaLangString + "", this.c + "", "0", "");
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rud
 * JD-Core Version:    0.7.0.1
 */