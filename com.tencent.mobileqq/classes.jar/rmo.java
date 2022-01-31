import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class rmo
  implements Runnable
{
  public rmo(AssociatedAccountActivity paramAssociatedAccountActivity, QQMessageFacade paramQQMessageFacade) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity.isFinishing()) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity.getString(2131433297);
    int i;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade != null)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b();
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity.app.a();
      if ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity.a == null)) {
        break label231;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity.a);
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext()) {
        i -= ((ConversationFacade)localObject).a(((SubAccountInfo)localIterator.next()).subuin, 7000);
      }
      localArrayList.clear();
    }
    label231:
    for (;;)
    {
      if (i > 0)
      {
        localObject = Integer.toString(i);
        if (i > 99) {
          localObject = "99+";
        }
        if (QLog.isColorLevel()) {
          QLog.d("AssociatedAccountActivity", 2, "updateUnreadNumOnTitleBar unreadText = " + (String)localObject);
        }
      }
      for (localObject = str + "(" + (String)localObject + ")";; localObject = str)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity.runOnUiThread(new rmp(this, (String)localObject));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rmo
 * JD-Core Version:    0.7.0.1
 */