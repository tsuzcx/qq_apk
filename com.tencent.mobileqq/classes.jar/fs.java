import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.qphone.base.util.QLog;

class fs
  implements View.OnClickListener
{
  fs(fq paramfq) {}
  
  public void onClick(View paramView)
  {
    paramView = (fw)paramView.getTag();
    if (paramView == null) {}
    DataLineMsgSet localDataLineMsgSet;
    do
    {
      return;
      localDataLineMsgSet = paramView.a();
    } while (localDataLineMsgSet == null);
    long l = 0L;
    if (localDataLineMsgSet.getFirstItem() != null) {
      l = localDataLineMsgSet.getFirstItem().sessionid;
    }
    for (;;)
    {
      localDataLineMsgSet.setPaused(true);
      ((ajuo)this.a.a.a(8)).a(localDataLineMsgSet.getGroupId(), l, false);
      fq.a(this.a, paramView, localDataLineMsgSet);
      return;
      QLog.e("DatalineSessionAdapterUseNewFileBubble", 1, "stop recv but no sessionid");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     fs
 * JD-Core Version:    0.7.0.1
 */