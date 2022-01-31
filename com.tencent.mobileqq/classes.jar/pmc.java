import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class pmc
  extends pmd
{
  public pmc(plz paramplz, SharedPreferences.Editor paramEditor)
  {
    super(paramEditor, paramplz.a());
  }
  
  public SharedPreferences.Editor clear()
  {
    if (TextUtils.isEmpty(plz.a(this.a))) {
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
          if (plz.a(plz.a(this.a), str)) {
            super.remove(str);
          }
        }
      }
    }
  }
  
  public boolean commit()
  {
    if ((plz.a(this.a)) && (Build.VERSION.SDK_INT >= 9))
    {
      super.apply();
      return true;
    }
    return super.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     pmc
 * JD-Core Version:    0.7.0.1
 */