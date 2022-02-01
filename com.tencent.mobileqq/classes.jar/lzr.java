import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class lzr
  extends BroadcastReceiver
{
  lzr(lzq paramlzq) {}
  
  public void onReceive(Context arg1, Intent arg2)
  {
    if ((??? == null) || (???.getAction() == null)) {}
    do
    {
      for (;;)
      {
        return;
        ??? = ???.getAction();
        if ("ACTION_QAV_RES_DOWNLOAD_STATE_NOTIFY".equals(???))
        {
          int i = ???.getIntExtra("ACTION_FIELD_DOWNLOAD_STATE", 0);
          int j = ???.getIntExtra("ACTION_FIELD_DOWNLOAD_PROGRESS", 0);
          ??? = ???.getStringExtra("ACTION_FIELD_RES_MD5");
          if (i == 2)
          {
            localArrayList = new ArrayList();
            synchronized (this.a.a)
            {
              localArrayList.addAll(this.a.a);
              ??? = localArrayList.iterator();
              if (!???.hasNext()) {
                continue;
              }
              ((lzs)???.next()).b(j, ???);
            }
          }
          ArrayList localArrayList = new ArrayList();
          synchronized (this.a.a)
          {
            localArrayList.addAll(this.a.a);
            ??? = localArrayList.iterator();
            if (???.hasNext()) {
              ((lzs)???.next()).a(i, ???);
            }
          }
        }
      }
    } while (!"ACTION_QAV_RES_NEW_CONFIG_NOTIFY".equals(???));
    QLog.i("ResMgr", 1, "new config has been downloaded.");
    synchronized (lzq.a(this.a))
    {
      lzq.a(this.a).clear();
      ??? = lzq.a();
      if (??? != null) {
        lzq.a(this.a, ???);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lzr
 * JD-Core Version:    0.7.0.1
 */