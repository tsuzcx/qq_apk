package cooperation.qqfav.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.io.IOException;
import java.io.InputStream;

class QfavJumpActivity$1
  implements DialogInterface.OnClickListener
{
  QfavJumpActivity$1(QfavJumpActivity paramQfavJumpActivity, InputStream paramInputStream) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaIoInputStream.close();
    }
    catch (IOException paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
    this.jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqfav.widget.QfavJumpActivity.1
 * JD-Core Version:    0.7.0.1
 */