import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.magic.ReadInJoyWatcher;
import com.tencent.biz.pubaccount.readinjoy.magic.models.AndroidAPs;
import com.tencent.biz.pubaccount.readinjoy.struct.MagicEvent;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class lrl
  implements Runnable
{
  public lrl(ReadInJoyWatcher paramReadInJoyWatcher) {}
  
  public void run()
  {
    if (ReadInJoyWatcher.a(this.a) != null)
    {
      ReadInJoyWatcher.a(this.a, new MagicEvent(false, ReadInJoyWatcher.a(this.a).a(), NetConnInfoCenter.getServerTime()));
      ReadInJoyWatcher.a(this.a, null);
      ReadInJoyLogicEngine.a().p();
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lrl
 * JD-Core Version:    0.7.0.1
 */