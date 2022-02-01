package cooperation.ilive.config;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.litelivesdk.utils.ConfigUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class IliveManagerCfgBean
{
  private long jdField_a_of_type_Long;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long;
  private ArrayList<Integer> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c = true;
  private boolean d = false;
  private boolean e = false;
  
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
        int i = Integer.parseInt(paramString.getString("isLite"));
        int j = 0;
        if (i != 1) {
          break label381;
        }
        bool = true;
        localIliveManagerCfgBean.jdField_a_of_type_Boolean = bool;
        if (paramString.has("heartTimeLong")) {
          localIliveManagerCfgBean.jdField_a_of_type_Long = Long.parseLong(paramString.optString("heartTimeLong"));
        }
        if (paramString.has("heartSwitch"))
        {
          if (Integer.parseInt(paramString.optString("heartSwitch")) != 1) {
            break label386;
          }
          bool = true;
          localIliveManagerCfgBean.jdField_b_of_type_Boolean = bool;
        }
        if (paramString.has("floatWindowSwitch"))
        {
          if (Integer.parseInt(paramString.optString("floatWindowSwitch")) != 1) {
            break label391;
          }
          bool = true;
          localIliveManagerCfgBean.c = bool;
        }
        if (paramString.has("floatWindowShowInterval")) {
          localIliveManagerCfgBean.jdField_b_of_type_Long = Long.parseLong(paramString.optString("floatWindowShowInterval"));
        }
        if (paramString.has("isEnableSingleWebview")) {
          localIliveManagerCfgBean.d = a(paramString.optJSONArray("isEnableSingleWebview"));
        }
        if (paramString.has("isEnablePreload")) {
          localIliveManagerCfgBean.e = a(paramString.optJSONArray("isEnablePreload"));
        }
        localObject = paramString.optJSONArray("blackList");
        if (localObject != null)
        {
          ArrayList localArrayList = new ArrayList();
          i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            localArrayList.add((String)((JSONArray)localObject).get(i));
            i += 1;
            continue;
          }
          localIliveManagerCfgBean.jdField_a_of_type_JavaUtilArrayList = localArrayList;
        }
        paramString = paramString.optJSONArray("blackVersionList");
        if (paramString != null)
        {
          localObject = new ArrayList();
          i = j;
          if (i < paramString.length())
          {
            ((ArrayList)localObject).add((Integer)paramString.get(i));
            i += 1;
            continue;
          }
          localIliveManagerCfgBean.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)localObject);
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
    int j = DeviceInfoUtils.a();
    int i = 0;
    try
    {
      while (i < paramJSONArray.length())
      {
        int k = paramJSONArray.getInt(i);
        if (j == k) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (Throwable paramJSONArray)
    {
      paramJSONArray.printStackTrace();
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public boolean b()
  {
    if (DeviceInfoUtils.b()) {
      return false;
    }
    return this.e;
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    Object localObject = this.jdField_b_of_type_JavaUtilArrayList;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        if ((localInteger != null) && (localInteger.intValue() == Build.VERSION.SDK_INT)) {
          return false;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isManagerConfigEnable IliveManagerCfnBean has not data , currentVersion = ");
      ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
      QLog.e("IliveManagerCfgBean", 1, ((StringBuilder)localObject).toString());
    }
    return ConfigUtil.a(this.jdField_a_of_type_JavaUtilArrayList) ^ true;
  }
  
  public boolean e()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.config.IliveManagerCfgBean
 * JD-Core Version:    0.7.0.1
 */