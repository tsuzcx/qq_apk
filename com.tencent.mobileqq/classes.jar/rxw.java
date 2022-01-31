import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.BaseApplication;

class rxw
  implements Runnable
{
  rxw(rxt paramrxt) {}
  
  public void run()
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("free_call", 0);
    long l = MessageCache.a();
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString(this.a.a, String.valueOf(l * 1000L));
    ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rxw
 * JD-Core Version:    0.7.0.1
 */