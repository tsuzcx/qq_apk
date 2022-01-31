import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public final class rzk
  implements Runnable
{
  public rzk(Context paramContext, ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ChatActivityFacade.jdField_a_of_type_ComTencentWidgetActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    ChatActivityFacade.jdField_a_of_type_ComTencentMobileqqDataChatMessage = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430178);
    ChatActivityFacade.jdField_a_of_type_ComTencentWidgetActionSheet.a(str);
    ChatActivityFacade.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131434057, 3);
    ChatActivityFacade.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131433029);
    ChatActivityFacade.jdField_a_of_type_ComTencentWidgetActionSheet.a(new rzl(this));
    ChatActivityFacade.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rzk
 * JD-Core Version:    0.7.0.1
 */