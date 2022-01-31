import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ond
{
  private static String a(String paramString)
  {
    paramString = paramString.getBytes();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((byte)(paramString[i] ^ 0xB6));
      i += 1;
    }
    return bbca.encodeToString(paramString, 2);
  }
  
  public static void a()
  {
    Object localObject1 = onk.a().getApplication().getPackageManager();
    Object localObject2 = ((PackageManager)localObject1).getInstalledPackages(0);
    String str = onk.a();
    if (localObject2 != null)
    {
      ArrayList localArrayList = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        PackageInfo localPackageInfo = (PackageInfo)((Iterator)localObject2).next();
        try
        {
          if (((PackageManager)localObject1).getLaunchIntentForPackage(localPackageInfo.packageName) != null)
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("package_name", localPackageInfo.packageName);
            localJSONObject.put("version_name", localPackageInfo.versionName);
            localJSONObject.put("first_install_time", localPackageInfo.firstInstallTime);
            localJSONObject.put("last_update_time", localPackageInfo.lastUpdateTime);
            localArrayList.add(localJSONObject);
          }
        }
        catch (JSONException localJSONException)
        {
          QLog.e("ReadInJoyRUA", 2, "reportUserApps: ", localJSONException);
        }
      }
      int k = localArrayList.size();
      int m = k / 4;
      int i = 0;
      while (i < m + 1)
      {
        localObject1 = new JSONArray();
        int j = 0;
        while (j < 4)
        {
          int n = i * 4 + j;
          if (n >= k) {
            break;
          }
          ((JSONArray)localObject1).put(localArrayList.get(n));
          j += 1;
        }
        localObject1 = a(((JSONArray)localObject1).toString());
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("uin", str);
        ((HashMap)localObject2).put("data", localObject1);
        QLog.d("ReadInJoyRUA", 2, "reportUserApps: " + (String)localObject1);
        axrl.a(onk.a().getApplication()).a(str, "actKandianRUA", true, 1L, 0L, (HashMap)localObject2, null, false);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ond
 * JD-Core Version:    0.7.0.1
 */