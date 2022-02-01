import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class qgy
{
  public static String a(String paramString)
  {
    QLog.i("PTSOfflineUtil", 1, "[loadFilePathAsString], path = " + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = new File(paramString);
    try
    {
      if (!paramString.exists())
      {
        QLog.i("PTSOfflineUtil", 1, "[loadFilePathAsString], file not exist.");
        return "";
      }
      paramString = new FileInputStream(paramString);
      byte[] arrayOfByte = new byte[paramString.available()];
      paramString.read(arrayOfByte);
      paramString.close();
      paramString = new String(arrayOfByte);
      return paramString;
    }
    catch (IOException paramString)
    {
      QLog.e("PTSOfflineUtil", 1, "[loadFilePathAsString], e = " + paramString);
      return "";
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        QLog.e("PTSOfflineUtil", 1, "[loadFilePathAsString], t = " + paramString);
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("PTSOfflineUtil", 1, "[checkOfflineVersionIsValid], configStr = " + (String)localObject);
      }
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      bool1 = svr.a(((JSONObject)localObject).optString("min_version", null), ((JSONObject)localObject).optString("max_version", null), ((JSONObject)localObject).optString("min_android_build", null), ((JSONObject)localObject).optString("max_android_build", null));
      QLog.i("PTSOfflineUtil", 1, "[checkOfflineVersionIsValid], res = " + bool1 + ", configPath = " + paramString);
      return bool1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.i("PTSOfflineUtil", 1, "[checkOfflineVersionIsValid], e = " + localJSONException);
        bool1 = bool2;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.i("PTSOfflineUtil", 1, "[checkOfflineVersionIsValid], t = " + localThrowable);
        bool1 = bool2;
      }
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = nnz.a(paramString1, paramString2);
      bool1 = bool2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.i("PTSOfflineUtil", 1, "[checkOfflineDirIsValid], t = " + localThrowable);
      }
    }
    QLog.i("PTSOfflineUtil", 1, "[checkOfflineDirIsValid], res = " + bool1 + ", bid = " + paramString2 + ", dir = " + paramString1);
    return bool1;
  }
  
  public static String b(String paramString)
  {
    String str4 = "no version";
    String str1 = str4;
    if (!TextUtils.isEmpty(paramString))
    {
      str1 = a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("PTSOfflineUtil", 1, "[getOfflineCurrentVersion], configStr = " + str1);
      }
    }
    try
    {
      str1 = new JSONObject(str1).optString("pts_version", "no version");
      QLog.i("PTSOfflineUtil", 1, "[getOfflineCurrentVersion], res = " + str1 + ", configPath = " + paramString);
      return str1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.i("PTSOfflineUtil", 1, "[getOfflineCurrentVersion], e = " + localJSONException);
        String str2 = str4;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.i("PTSOfflineUtil", 1, "[getOfflineCurrentVersion], t = " + localThrowable);
        String str3 = str4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qgy
 * JD-Core Version:    0.7.0.1
 */