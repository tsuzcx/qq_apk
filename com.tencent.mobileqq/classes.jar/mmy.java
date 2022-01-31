import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.qphone.base.util.QLog;

public class mmy
  implements Runnable
{
  public mmy(ItemShowDispatcher paramItemShowDispatcher) {}
  
  public void run()
  {
    QLog.d(ItemShowDispatcher.a(this.a), 2, "  1秒到了 ");
    ItemShowDispatcher.a(this.a, ItemShowDispatcher.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mmy
 * JD-Core Version:    0.7.0.1
 */