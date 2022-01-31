import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileImageAvatar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.util.ProfileCardUtil;
import mqq.os.MqqHandler;

public class spl
  implements Runnable
{
  public spl(FriendProfileImageAvatar paramFriendProfileImageAvatar, String paramString) {}
  
  public void run()
  {
    if (FileUtil.a(ProfileCardUtil.a(String.valueOf(this.jdField_a_of_type_JavaLangString)))) {
      if (NearbyUtils.a()) {
        NearbyUtils.a("Q.profilecard.Avatar", "downloadHDAvatar hd avatar file exist 1", new Object[0]);
      }
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.c) {
        break;
      }
    } while (!NearbyUtils.a());
    NearbyUtils.a("Q.profilecard.Avatar", "downloadHDAvatar makingHDUrl return 2", new Object[0]);
    return;
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.c = true;
    Setting localSetting = (Setting)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(Setting.class, this.jdField_a_of_type_JavaLangString);
    if ((localSetting != null) && (!TextUtils.isEmpty(localSetting.url)))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 5;
      localMessage.obj = localSetting;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.c = false;
      if (!NearbyUtils.a()) {
        break;
      }
      NearbyUtils.a("Q.profilecard.Avatar", "downloadHDAvatar end of makingHDUrl", new Object[0]);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageAvatar.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     spl
 * JD-Core Version:    0.7.0.1
 */