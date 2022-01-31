import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;

class sax
  extends AccountObserver
{
  sax(saw paramsaw) {}
  
  public void onRefreshDA2(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder().append("onRefrshDA2 result: ").append(paramBoolean).append(", da2 length: ");
      if (paramString2 != null) {
        break label70;
      }
    }
    label70:
    for (int i = 0;; i = paramString2.length())
    {
      QLog.e("ChatHistoryForC2C", 2, i);
      this.a.a.runOnUiThread(new say(this, paramBoolean));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sax
 * JD-Core Version:    0.7.0.1
 */