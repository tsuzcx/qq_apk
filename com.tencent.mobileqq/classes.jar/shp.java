import android.os.Handler;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class shp
  implements Runnable
{
  public shp(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void run()
  {
    Object localObject1 = null;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (this.a.jdField_a_of_type_AndroidOsHandler == null)) {}
    do
    {
      return;
      localObject2 = this.a.app.getEntityManagerFactory().createEntityManager();
      if (localObject2 != null)
      {
        localObject1 = ((EntityManager)localObject2).a(TroopMemberInfo.class, false, "troopuin=? ", new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin }, null, null, null, null);
        ((EntityManager)localObject2).a();
      }
    } while (localObject1 == null);
    Object localObject2 = new ArrayList(((List)localObject1).size());
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)((Iterator)localObject1).next();
      if (Utils.d(localTroopMemberInfo.memberuin)) {
        ((ArrayList)localObject2).add(localTroopMemberInfo.memberuin);
      }
    }
    this.a.jdField_a_of_type_AndroidOsHandler.post(new shq(this, (ArrayList)localObject2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     shp
 * JD-Core Version:    0.7.0.1
 */