package cooperation.ilive.config;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class IliveManagerCfgBean
{
  private boolean a = false;
  private ArrayList<String> b = new ArrayList();
  private ArrayList<Integer> c = new ArrayList();
  private long d;
  private boolean e = true;
  private long f;
  private boolean g = true;
  private boolean h = false;
  private boolean i = false;
  
  public static IliveManagerCfgBean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new IliveManagerCfgBean();
    }
    IliveManagerCfgBean localIliveManagerCfgBean = new IliveManagerCfgBean();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        int j = Integer.parseInt(paramString.getString("isLite"));
        int k = 0;
        if (j != 1) {
          break label381;
        }
        bool = true;
        localIliveManagerCfgBean.a = bool;
        if (paramString.has("heartTimeLong")) {
          localIliveManagerCfgBean.d = Long.parseLong(paramString.optString("heartTimeLong"));
        }
        if (paramString.has("heartSwitch"))
        {
          if (Integer.parseInt(paramString.optString("heartSwitch")) != 1) {
            break label386;
          }
          bool = true;
          localIliveManagerCfgBean.e = bool;
        }
        if (paramString.has("floatWindowSwitch"))
        {
          if (Integer.parseInt(paramString.optString("floatWindowSwitch")) != 1) {
            break label391;
          }
          bool = true;
          localIliveManagerCfgBean.g = bool;
        }
        if (paramString.has("floatWindowShowInterval")) {
          localIliveManagerCfgBean.f = Long.parseLong(paramString.optString("floatWindowShowInterval"));
        }
        if (paramString.has("isEnableSingleWebview")) {
          localIliveManagerCfgBean.h = a(paramString.optJSONArray("isEnableSingleWebview"));
        }
        if (paramString.has("isEnablePreload")) {
          localIliveManagerCfgBean.i = a(paramString.optJSONArray("isEnablePreload"));
        }
        localObject = paramString.optJSONArray("blackList");
        if (localObject != null)
        {
          ArrayList localArrayList = new ArrayList();
          j = 0;
          if (j < ((JSONArray)localObject).length())
          {
            localArrayList.add((String)((JSONArray)localObject).get(j));
            j += 1;
            continue;
          }
          localIliveManagerCfgBean.b = localArrayList;
        }
        paramString = paramString.optJSONArray("blackVersionList");
        if (paramString != null)
        {
          localObject = new ArrayList();
          j = k;
          if (j < paramString.length())
          {
            ((ArrayList)localObject).add((Integer)paramString.get(j));
            j += 1;
            continue;
          }
          localIliveManagerCfgBean.c = ((ArrayList)localObject);
          return localIliveManagerCfgBean;
        }
      }
      catch (Throwable paramString)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("error parse bean ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("IliveManagerCfgBean", 1, ((StringBuilder)localObject).toString());
      }
      return localIliveManagerCfgBean;
      label381:
      boolean bool = false;
      continue;
      label386:
      bool = false;
      continue;
      label391:
      bool = false;
    }
  }
  
  private static boolean a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return false;
    }
    int k = DeviceInfoUtils.getPerfLevel();
    int j = 0;
    try
    {
      while (j < paramJSONArray.length())
      {
        int m = paramJSONArray.getInt(j);
        if (k == m) {
          return true;
        }
        j += 1;
      }
      return false;
    }
    catch (Throwable paramJSONArray)
    {
      paramJSONArray.printStackTrace();
    }
  }
  
  public boolean a()
  {
    return this.h;
  }
  
  public long b()
  {
    return this.d;
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  public boolean d()
  {
    return true;
  }
  
  public long e()
  {
    return this.f;
  }
  
  public boolean f()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.config.IliveManagerCfgBean
 * JD-Core Version:    0.7.0.1
 */