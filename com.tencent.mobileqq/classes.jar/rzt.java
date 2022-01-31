import com.tencent.biz.helper.TroopCardAppInfoHelper.IGetAppInfoCB;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.ArrayList;
import java.util.Iterator;

public class rzt
  implements TroopCardAppInfoHelper.IGetAppInfoCB
{
  public rzt(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void a() {}
  
  public void a(ArrayList paramArrayList)
  {
    if ((this.a.isFinishing()) || (paramArrayList == null) || (paramArrayList.size() == 0)) {}
    do
    {
      return;
      ArrayList localArrayList = new ArrayList();
      TroopInfoManager localTroopInfoManager = (TroopInfoManager)this.a.app.getManager(36);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        TroopAppInfo localTroopAppInfo = (TroopAppInfo)paramArrayList.next();
        localTroopInfoManager.a(Long.valueOf(localTroopAppInfo.appId), localTroopAppInfo);
        localArrayList.add(Long.valueOf(localTroopAppInfo.appId));
      }
      localTroopInfoManager.a(this.a.a.troopUin, localArrayList);
    } while (this.a.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rzt
 * JD-Core Version:    0.7.0.1
 */