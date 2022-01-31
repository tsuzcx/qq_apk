import android.widget.ImageView;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;

class swu
  implements Runnable
{
  swu(swt paramswt, ExtensionInfo paramExtensionInfo) {}
  
  public void run()
  {
    this.jdField_a_of_type_Swt.a.b.setVisibility(0);
    ((AvatarPendantManager)this.jdField_a_of_type_Swt.a.app.getManager(45)).a(this.jdField_a_of_type_Swt.a.a).a(this.jdField_a_of_type_Swt.a.b, 1, PendantInfo.d, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.uin, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     swu
 * JD-Core Version:    0.7.0.1
 */