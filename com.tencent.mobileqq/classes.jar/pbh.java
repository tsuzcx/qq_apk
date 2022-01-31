import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.biz.webviewplugin.HotchatPlugin;
import java.util.ArrayList;
import java.util.HashMap;

public class pbh
  implements TroopMemberApiClient.Callback
{
  public pbh(HotchatPlugin paramHotchatPlugin) {}
  
  public void a(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.getBoolean("isSuccess")))
    {
      ArrayList localArrayList = paramBundle.getStringArrayList("uins");
      paramBundle = paramBundle.getStringArrayList("tinyIds");
      int i = 0;
      while (i < localArrayList.size())
      {
        HotchatPlugin.a(this.a).put(paramBundle.get(i), localArrayList.get(i));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pbh
 * JD-Core Version:    0.7.0.1
 */