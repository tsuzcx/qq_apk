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

public class lfl
  implements Runnable
{
  public lfl(ReadinjoySubscriptManagerActivity paramReadinjoySubscriptManagerActivity) {}
  
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
        lft locallft = new lft(this.a, null);
        lft.a(locallft, localPublicAccountInfo.getUin());
        lft.b(locallft, localPublicAccountInfo.name);
        lft.c(locallft, ChnToSpell.a(lft.b(locallft), 2));
        if (PublicAccountUtil.b(this.a.app, localPublicAccountInfo.getUin())) {
          localArrayList2.add(locallft);
        } else {
          localArrayList1.add(locallft);
        }
      }
    }
    Collections.sort(localArrayList1, ReadinjoySubscriptManagerActivity.a(this.a));
    Collections.sort(localArrayList2, ReadinjoySubscriptManagerActivity.a(this.a));
    localArrayList2.addAll(localArrayList1);
    ThreadManager.getUIHandler().post(new lfm(this, localArrayList2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lfl
 * JD-Core Version:    0.7.0.1
 */