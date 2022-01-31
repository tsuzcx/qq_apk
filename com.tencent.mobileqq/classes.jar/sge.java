import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.app.ThreadManager;

public class sge
  implements DialogInterface.OnClickListener
{
  public sge(ChatHistoryImageView paramChatHistoryImageView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a;
    sgi localsgi = new sgi(this.a, this.a.jdField_a_of_type_JavaUtilArrayList, true, false);
    paramDialogInterface.jdField_a_of_type_Sgi = localsgi;
    ThreadManager.post(localsgi, 5, null, true);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sge
 * JD-Core Version:    0.7.0.1
 */