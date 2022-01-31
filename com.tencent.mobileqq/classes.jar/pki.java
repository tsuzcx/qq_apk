import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class pki
  extends pkj
{
  public pki(pkf parampkf, SharedPreferences.Editor paramEditor)
  {
    super(paramEditor, parampkf.a());
  }
  
  public SharedPreferences.Editor clear()
  {
    if (TextUtils.isEmpty(pkf.a(this.a))) {
      super.clear();
    }
    for (;;)
    {
      return this;
      Object localObject = this.a.a().getAll();
      if ((localObject != null) && (!((Map)localObject).isEmpty()))
      {
        localObject = ((Map)localObject).keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if (pkf.a(pkf.a(this.a), str)) {
            super.remove(str);
          }
        }
      }
    }
  }
  
  public boolean commit()
  {
    if ((pkf.a(this.a)) && (Build.VERSION.SDK_INT >= 9))
    {
      super.apply();
      return true;
    }
    return super.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     pki
 * JD-Core Version:    0.7.0.1
 */