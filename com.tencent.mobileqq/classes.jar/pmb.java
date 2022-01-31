import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.text.TextUtils;

class pmb
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  pmb(plz paramplz) {}
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramSharedPreferences = plz.b(plz.a(this.a), paramString);
    if ((paramSharedPreferences != null) || (TextUtils.isEmpty(plz.a(this.a)))) {
      plz.a(this.a, paramSharedPreferences);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     pmb
 * JD-Core Version:    0.7.0.1
 */