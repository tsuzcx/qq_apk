import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class sch
  extends TroopObserver
{
  public sch(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void a(boolean paramBoolean, int paramInt, ArrayList paramArrayList, String paramString)
  {
    super.a(paramBoolean, paramInt, paramArrayList, paramString);
    if (!paramBoolean) {}
    Object localObject1;
    do
    {
      return;
      localObject2 = "";
      localObject1 = localObject2;
      if (this.a.a != null)
      {
        localObject1 = localObject2;
        if (this.a.a.troopuin != null) {
          localObject1 = this.a.a.troopuin;
        }
      }
    } while (this.a.e == null);
    Object localObject2 = new HashSet();
    if ((paramString != null) && (paramString.equals(localObject1)))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramString = (String)paramArrayList.next();
        localObject1 = this.a.e.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          oidb_0x899.memberlist localmemberlist = (oidb_0x899.memberlist)((Iterator)localObject1).next();
          if (paramString.equals(localmemberlist.uint64_member_uin.get() + "")) {
            ((Collection)localObject2).add(localmemberlist);
          }
        }
      }
      paramArrayList = ((Collection)localObject2).iterator();
      while (paramArrayList.hasNext())
      {
        paramString = (oidb_0x899.memberlist)paramArrayList.next();
        this.a.e.remove(paramString);
      }
    }
    this.a.a(this.a.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sch
 * JD-Core Version:    0.7.0.1
 */