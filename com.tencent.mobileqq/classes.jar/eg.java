import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class eg
  implements View.OnClickListener
{
  eg(ee paramee) {}
  
  public void onClick(View paramView)
  {
    ek localek = (ek)paramView.getTag();
    if (localek == null) {}
    DataLineMsgSet localDataLineMsgSet;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localDataLineMsgSet = localek.a();
    } while (localDataLineMsgSet == null);
    long l = 0L;
    if (localDataLineMsgSet.getFirstItem() != null) {
      l = localDataLineMsgSet.getFirstItem().sessionid;
    }
    for (;;)
    {
      localDataLineMsgSet.setPaused(true);
      ((anvu)this.a.a.a(8)).a(localDataLineMsgSet.getGroupId(), l, false);
      ee.a(this.a, localek, localDataLineMsgSet);
      break;
      QLog.e("DatalineSessionAdapterUseNewFileBubble", 1, "stop recv but no sessionid");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     eg
 * JD-Core Version:    0.7.0.1
 */