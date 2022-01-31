import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.text.TextUtils;

class pqt
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  pqt(pqr parampqr) {}
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramSharedPreferences = pqr.b(pqr.a(this.a), paramString);
    if ((paramSharedPreferences != null) || (TextUtils.isEmpty(pqr.a(this.a)))) {
      pqr.a(this.a, paramSharedPreferences);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     pqt
 * JD-Core Version:    0.7.0.1
 */