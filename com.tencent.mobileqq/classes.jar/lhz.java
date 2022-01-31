import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class lhz
  implements Runnable
{
  public lhz(ReadinjoySubscriptManagerActivity paramReadinjoySubscriptManagerActivity) {}
  
  public void run()
  {
    Object localObject = TroopBarAssistantManager.a().c(this.a.app);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((Iterator)localObject).next();
        lih locallih = new lih(this.a, null);
        lih.a(locallih, localPublicAccountInfo.getUin());
        lih.b(locallih, localPublicAccountInfo.name);
        lih.c(locallih, ChnToSpell.a(lih.b(locallih), 2));
        if (PublicAccountUtil.b(this.a.app, localPublicAccountInfo.getUin())) {
          localArrayList2.add(locallih);
        } else {
          localArrayList1.add(locallih);
        }
      }
    }
    Collections.sort(localArrayList1, ReadinjoySubscriptManagerActivity.a(this.a));
    Collections.sort(localArrayList2, ReadinjoySubscriptManagerActivity.a(this.a));
    localArrayList2.addAll(localArrayList1);
    ThreadManager.getUIHandler().post(new lia(this, localArrayList2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lhz
 * JD-Core Version:    0.7.0.1
 */