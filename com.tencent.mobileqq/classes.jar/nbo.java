import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.lang.ref.WeakReference;

public class nbo
{
  private static nbo jdField_a_of_type_Nbo;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  
  private nbo(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    if (paramContext != null) {
      this.jdField_a_of_type_JavaLangString = paramContext.getSharedPreferences("AV_CameraParameters", 0).getString("CP", "preview-size-values=320x240,640x480;");
    }
  }
  
  public static nbo a(Context paramContext)
  {
    if (jdField_a_of_type_Nbo == null) {}
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_Nbo == null) {
          jdField_a_of_type_Nbo = new nbo(paramContext);
        }
        return jdField_a_of_type_Nbo;
      }
      finally {}
      jdField_a_of_type_Nbo.a(paramContext);
    }
  }
  
  private void a(Context paramContext)
  {
    if ((paramContext != null) && ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null))) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    }
  }
  
  public String a()
  {
    try
    {
      String str2 = this.jdField_a_of_type_JavaLangString;
      String str1 = str2;
      if (str2 == null) {
        str1 = "preview-size-values=320x240,640x480;";
      }
      return str1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    for (Object localObject = null;; localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      if (localObject != null)
      {
        localObject = ((Context)localObject).getSharedPreferences("AV_CameraParameters", 0).edit();
        ((SharedPreferences.Editor)localObject).putString("CP", paramString);
        ((SharedPreferences.Editor)localObject).apply();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nbo
 * JD-Core Version:    0.7.0.1
 */