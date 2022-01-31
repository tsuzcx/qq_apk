import android.annotation.SuppressLint;
import android.content.SharedPreferences.Editor;
import java.util.Set;

public class pqv
  implements SharedPreferences.Editor
{
  private final SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private final pqq jdField_a_of_type_Pqq;
  
  public pqv(SharedPreferences.Editor paramEditor, pqq parampqq)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = paramEditor;
    this.jdField_a_of_type_Pqq = parampqq;
  }
  
  private String a(String paramString)
  {
    if (this.jdField_a_of_type_Pqq != null) {
      return this.jdField_a_of_type_Pqq.a(paramString);
    }
    return null;
  }
  
  @SuppressLint({"NewApi"})
  public void apply()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
  }
  
  public SharedPreferences.Editor clear()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.clear();
    return this;
  }
  
  public boolean commit()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putBoolean(a(paramString), paramBoolean);
    return this;
  }
  
  public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putFloat(a(paramString), paramFloat);
    return this;
  }
  
  public SharedPreferences.Editor putInt(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt(a(paramString), paramInt);
    return this;
  }
  
  public SharedPreferences.Editor putLong(String paramString, long paramLong)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(a(paramString), paramLong);
    return this;
  }
  
  public SharedPreferences.Editor putString(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString(a(paramString1), paramString2);
    return this;
  }
  
  @SuppressLint({"NewApi"})
  public SharedPreferences.Editor putStringSet(String paramString, Set paramSet)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putStringSet(a(paramString), paramSet);
    return this;
  }
  
  public SharedPreferences.Editor remove(String paramString)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.remove(a(paramString));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     pqv
 * JD-Core Version:    0.7.0.1
 */