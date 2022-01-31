import android.os.Message;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.QZonePhotoWall;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.List;

public class stk
  implements Runnable
{
  public stk(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void run()
  {
    Object localObject1 = ((FriendsManager)this.a.app.getManager(50)).b(this.a.app.getCurrentAccountUin());
    this.a.a((Card)localObject1);
    this.a.app.runOnUiThread(new stl(this, (Card)localObject1));
    this.a.jdField_a_of_type_ComTencentMobileqqAppCardHandler.h();
    Object localObject2 = (QZonePhotoWall)this.a.app.getEntityManagerFactory().createEntityManager().a(QZonePhotoWall.class, this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
    localObject1 = new ArrayList();
    if (localObject2 != null) {
      this.a.a(((QZonePhotoWall)localObject2).totalPic, ((QZonePhotoWall)localObject2).hasMore, ((QZonePhotoWall)localObject2).attachInfo, ((QZonePhotoWall)localObject2).unpackPhotoWallData(), (List)localObject1);
    }
    localObject2 = this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1001);
    ((Message)localObject2).obj = localObject1;
    this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     stk
 * JD-Core Version:    0.7.0.1
 */