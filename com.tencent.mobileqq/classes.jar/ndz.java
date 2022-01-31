import com.tencent.biz.qqstory.msgTabNode.view.viewholder.FriendViewHolder;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class ndz
  implements Runnable
{
  public ndz(FriendViewHolder paramFriendViewHolder, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).c(this.jdField_a_of_type_JavaLangString) == null) {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ndz
 * JD-Core Version:    0.7.0.1
 */