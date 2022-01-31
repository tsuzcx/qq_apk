import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class sgk
{
  private Map<String, String[]> jdField_a_of_type_JavaUtilMap = new HashMap();
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  
  public sgk(Context paramContext, String paramString)
  {
    a(paramContext, paramString);
  }
  
  private void a(Context paramContext, String paramString)
  {
    b(paramContext, paramString);
  }
  
  private boolean a(String paramString)
  {
    return (paramString == null) || (paramString.endsWith(".geojson")) || (paramString.equals("manifest"));
  }
  
  private void b(Context paramContext, String paramString)
  {
    try
    {
      String[] arrayOfString = paramContext.getAssets().list(paramString);
      if (arrayOfString != null)
      {
        this.jdField_a_of_type_JavaUtilMap.put(paramString, arrayOfString);
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if (!a(str)) {
            b(paramContext, paramString + "/" + str);
          }
          i += 1;
        }
      }
      return;
    }
    catch (IOException paramContext)
    {
      QLog.e("Q.readinjoy.proteus", 1, "addFolderChild", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sgk
 * JD-Core Version:    0.7.0.1
 */