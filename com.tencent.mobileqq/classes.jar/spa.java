import android.widget.ImageView;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;

class spa
  implements Runnable
{
  spa(soz paramsoz, ExtensionInfo paramExtensionInfo) {}
  
  public void run()
  {
    this.jdField_a_of_type_Soz.a.b.setVisibility(0);
    ((AvatarPendantManager)this.jdField_a_of_type_Soz.a.app.getManager(45)).a(this.jdField_a_of_type_Soz.a.a).a(this.jdField_a_of_type_Soz.a.b, 1, PendantInfo.d, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.uin, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     spa
 * JD-Core Version:    0.7.0.1
 */