import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.text.TextUtils;
import com.tencent.component.utils.preference.SharedPreferencesWrapper;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public class pqr
  extends SharedPreferencesWrapper
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private SharedPreferences.OnSharedPreferenceChangeListener jdField_a_of_type_AndroidContentSharedPreferences$OnSharedPreferenceChangeListener;
  private final String jdField_a_of_type_JavaLangString;
  private final WeakHashMap jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  private final boolean jdField_a_of_type_Boolean;
  
  public pqr(SharedPreferences paramSharedPreferences, String paramString, boolean paramBoolean)
  {
    super(paramSharedPreferences, new pqs(paramString));
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences$OnSharedPreferenceChangeListener == null)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences$OnSharedPreferenceChangeListener = new pqt(this);
      a().registerOnSharedPreferenceChangeListener(this.jdField_a_of_type_AndroidContentSharedPreferences$OnSharedPreferenceChangeListener);
    }
  }
  
  private void a(String paramString)
  {
    Object localObject1 = null;
    synchronized (this.jdField_a_of_type_JavaUtilWeakHashMap)
    {
      if (!this.jdField_a_of_type_JavaUtilWeakHashMap.isEmpty())
      {
        localObject1 = new HashSet(this.jdField_a_of_type_JavaUtilWeakHashMap.keySet());
        if (localObject1 != null)
        {
          localObject1 = ((Collection)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            ??? = (SharedPreferences.OnSharedPreferenceChangeListener)((Iterator)localObject1).next();
            if (??? != null) {
              ((SharedPreferences.OnSharedPreferenceChangeListener)???).onSharedPreferenceChanged(this, paramString);
            }
          }
        }
      }
      else
      {
        b();
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences$OnSharedPreferenceChangeListener != null)
    {
      a().unregisterOnSharedPreferenceChangeListener(this.jdField_a_of_type_AndroidContentSharedPreferences$OnSharedPreferenceChangeListener);
      this.jdField_a_of_type_AndroidContentSharedPreferences$OnSharedPreferenceChangeListener = null;
    }
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    return (TextUtils.isEmpty(paramString1)) || ((!TextUtils.isEmpty(paramString2)) && (paramString2.startsWith(paramString1)));
  }
  
  private static String c(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    if (paramString2 == null) {
      throw new RuntimeException("null key is not supported when contains key prefix " + paramString1);
    }
    return paramString1 + paramString2;
  }
  
  private static String d(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    if ((TextUtils.isEmpty(paramString2)) || (!paramString2.startsWith(paramString1))) {
      return null;
    }
    return paramString2.substring(paramString1.length());
  }
  
  public SharedPreferences.Editor edit()
  {
    SharedPreferences.Editor localEditor = super.edit();
    if (localEditor != null) {
      return new pqu(this, localEditor);
    }
    return null;
  }
  
  public Map getAll()
  {
    Object localObject2 = super.getAll();
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!((Map)localObject2).isEmpty())
        {
          localObject1 = new HashMap();
          localObject2 = ((Map)localObject2).entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
            String str = d(this.jdField_a_of_type_JavaLangString, (String)localEntry.getKey());
            if ((str != null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
              ((Map)localObject1).put(str, localEntry.getValue());
            }
          }
        }
      }
    }
    return localObject1;
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilWeakHashMap)
    {
      if (this.jdField_a_of_type_JavaUtilWeakHashMap.isEmpty()) {
        a();
      }
      this.jdField_a_of_type_JavaUtilWeakHashMap.put(paramOnSharedPreferenceChangeListener, jdField_a_of_type_JavaLangObject);
      return;
    }
  }
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilWeakHashMap)
    {
      this.jdField_a_of_type_JavaUtilWeakHashMap.remove(paramOnSharedPreferenceChangeListener);
      if (this.jdField_a_of_type_JavaUtilWeakHashMap.isEmpty()) {
        b();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     pqr
 * JD-Core Version:    0.7.0.1
 */