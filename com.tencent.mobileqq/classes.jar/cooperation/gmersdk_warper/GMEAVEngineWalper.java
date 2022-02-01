package cooperation.gmersdk_warper;

import android.content.Context;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.qqavopensdk.AVEngineEventHandler;
import java.util.HashMap;
import java.util.Map;

public class GMEAVEngineWalper
{
  static GMEAVEngineWalper d;
  private static String h = "GMEAVEngineWalper";
  Context a;
  AVEngineEventHandler b;
  Map<String, Integer> c = new HashMap();
  String e = "";
  int f = 0;
  private boolean g = false;
  private AVCallback i = new GMEAVEngineWalper.7(this);
  private GMEAVManager.RoomInfoListener j = new GMEAVEngineWalper.8(this);
  
  public static GMEAVEngineWalper a()
  {
    if (d == null) {
      d = new GMEAVEngineWalper();
    }
    return d;
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMEAVManager.a(this.a).a(paramString, paramBoolean1, paramBoolean2, this.f, new GMEAVEngineWalper.2(this));
  }
  
  public void b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramString, paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.gmersdk_warper.GMEAVEngineWalper
 * JD-Core Version:    0.7.0.1
 */