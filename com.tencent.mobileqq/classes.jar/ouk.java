import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.intervideo.IVPluginEvtListener;

public class ouk
  implements IVPluginEvtListener
{
  public ouk(TroopMemberApiService paramTroopMemberApiService) {}
  
  public void a(Activity paramActivity) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    paramString1 = new Bundle();
    paramString1.putInt("errCode", paramInt);
    paramString1.putString("desc", paramString2);
    paramString1.putInt("msg", 92);
    this.a.a(92, paramString1);
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle) {}
  
  public void b(String paramString)
  {
    paramString = new Bundle();
    paramString.putInt("state", 1);
    paramString.putInt("msg", 91);
    this.a.a(91, paramString);
  }
  
  public void c(String paramString) {}
  
  public void d(String paramString)
  {
    paramString = new Bundle();
    paramString.putInt("errCode", 0);
    paramString.putInt("msg", 92);
    this.a.a(92, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ouk
 * JD-Core Version:    0.7.0.1
 */