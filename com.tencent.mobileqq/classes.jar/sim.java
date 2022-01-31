import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.util.Pair;
import java.util.ArrayList;

class sim
  implements Runnable
{
  sim(sil paramsil) {}
  
  public void run()
  {
    if (this.a.a.j) {}
    for (;;)
    {
      return;
      SubAccountControll localSubAccountControll = (SubAccountControll)this.a.a.a.getManager(61);
      if (localSubAccountControll != null)
      {
        ArrayList localArrayList = localSubAccountControll.a("sub.uin.all");
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          Pair localPair = (Pair)localArrayList.get(i);
          localSubAccountControll.a(this.a.a.a, this.a.a.a(), localPair, new sin(this, localSubAccountControll, localPair));
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sim
 * JD-Core Version:    0.7.0.1
 */