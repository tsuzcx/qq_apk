import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.text.TextUtils;

class pkh
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  pkh(pkf parampkf) {}
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramSharedPreferences = pkf.b(pkf.a(this.a), paramString);
    if ((paramSharedPreferences != null) || (TextUtils.isEmpty(pkf.a(this.a)))) {
      pkf.a(this.a, paramSharedPreferences);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     pkh
 * JD-Core Version:    0.7.0.1
 */