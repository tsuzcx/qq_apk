import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.ecshopassit.EcshopCacheTool;
import com.tencent.biz.pubaccount.ecshopassit.ShopWebViewFragment;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class lcj
  implements Runnable
{
  public lcj(EcshopCacheTool paramEcshopCacheTool) {}
  
  public void run()
  {
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Friends.class, " SELECT * FROM Friends ", new String[0]);
    this.a.jdField_a_of_type_JavaUtilMap = new HashMap();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Friends localFriends = (Friends)((Iterator)localObject).next();
        this.a.jdField_a_of_type_JavaUtilMap.put(localFriends.uin, localFriends);
      }
    }
    if ((this.a.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment != null) && (this.a.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment.a != null)) {
      this.a.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment.getActivity().runOnUiThread(new lck(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lcj
 * JD-Core Version:    0.7.0.1
 */