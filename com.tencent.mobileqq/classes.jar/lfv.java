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

public class lfv
  implements Runnable
{
  public lfv(ReadinjoySubscriptManagerActivity paramReadinjoySubscriptManagerActivity) {}
  
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
        lgd locallgd = new lgd(this.a, null);
        lgd.a(locallgd, localPublicAccountInfo.getUin());
        lgd.b(locallgd, localPublicAccountInfo.name);
        lgd.c(locallgd, ChnToSpell.a(lgd.b(locallgd), 2));
        if (PublicAccountUtil.b(this.a.app, localPublicAccountInfo.getUin())) {
          localArrayList2.add(locallgd);
        } else {
          localArrayList1.add(locallgd);
        }
      }
    }
    Collections.sort(localArrayList1, ReadinjoySubscriptManagerActivity.a(this.a));
    Collections.sort(localArrayList2, ReadinjoySubscriptManagerActivity.a(this.a));
    localArrayList2.addAll(localArrayList1);
    ThreadManager.getUIHandler().post(new lfw(this, localArrayList2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lfv
 * JD-Core Version:    0.7.0.1
 */