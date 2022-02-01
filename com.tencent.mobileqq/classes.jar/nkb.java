import android.content.SharedPreferences;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class nkb
{
  public SharedPreferences a;
  public nkb a;
  
  public nkb(SharedPreferences paramSharedPreferences, nkb paramnkb)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramSharedPreferences;
    this.jdField_a_of_type_Nkb = paramnkb;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public abstract int a(String paramString1, String paramString2);
  
  public int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    if (paramBoolean1) {}
    for (int i = 1;; i = 0)
    {
      if (paramBoolean2) {
        j = 2;
      }
      return j | i;
    }
  }
  
  public abstract String a();
  
  public abstract JSONArray a(String paramString);
  
  public abstract JSONObject a();
  
  public abstract boolean a();
  
  public abstract String b();
  
  public abstract String c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nkb
 * JD-Core Version:    0.7.0.1
 */