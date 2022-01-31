import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.qphone.base.util.QLog;

class ea
  implements View.OnClickListener
{
  ea(dz paramdz) {}
  
  public void onClick(View paramView)
  {
    paramView = (ef)paramView.getTag();
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
      ((alqo)this.a.a.a(8)).a(localDataLineMsgSet.getGroupId(), l, false);
      dz.a(this.a, paramView, localDataLineMsgSet);
      return;
      QLog.e("DatalineSessionAdapterUseNewFileBubble", 1, "stop send but no sessionid");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ea
 * JD-Core Version:    0.7.0.1
 */