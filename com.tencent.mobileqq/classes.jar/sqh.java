import android.graphics.Bitmap;
import android.os.Message;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.anim.FriendProfileCardBgDrawable;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.mobileqq.utils.StackBlur;
import com.tencent.util.WeakReferenceHandler;

public class sqh
  implements Runnable
{
  public sqh(FriendProfileCardActivity paramFriendProfileCardActivity, Bitmap paramBitmap) {}
  
  public void run()
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    Object localObject = localBitmap;
    if (localBitmap == null) {
      localObject = ((FriendProfileCardBgDrawable)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable).b();
    }
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      localObject = Bitmap.createScaledBitmap((Bitmap)localObject, (int)(((Bitmap)localObject).getWidth() * 0.125F), (int)(((Bitmap)localObject).getHeight() * 0.125F), true);
      StackBlur.a((Bitmap)localObject, 2);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a != null))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b.obtainMessage(12, localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileShoppingPhotoInfo = ProfileShoppingPhotoInfo.getPhotoInfo(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a);
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b.sendMessage((Message)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sqh
 * JD-Core Version:    0.7.0.1
 */