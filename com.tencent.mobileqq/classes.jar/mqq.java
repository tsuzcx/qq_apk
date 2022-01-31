import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.qphone.base.util.QLog;

public class mqq
  implements Runnable
{
  public mqq(ItemShowDispatcher paramItemShowDispatcher) {}
  
  public void run()
  {
    QLog.d("ItemShowDispatcher_time", 2, "  1秒到了 ");
    ItemShowDispatcher.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mqq
 * JD-Core Version:    0.7.0.1
 */