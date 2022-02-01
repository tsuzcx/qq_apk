package cooperation.ilive.config;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.litelivesdk.utils.ConfigUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class IliveManagerCfgBean
{
  private long jdField_a_of_type_Long;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private ArrayList<Integer> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = true;
  
  public static IliveManagerCfgBean a(String paramString)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {
      return new IliveManagerCfgBean();
    }
    IliveManagerCfgBean localIliveManagerCfgBean = new IliveManagerCfgBean();
    try
    {
      paramString = new JSONObject(paramString);
      if (Integer.parseInt(paramString.getString("isLite")) != 1) {
        break label261;
      }
      bool = true;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        Object localObject;
        ArrayList localArrayList;
        int i;
        QLog.e("IliveManagerCfgBean", 1, "error parse bean " + paramString);
        continue;
        boolean bool = false;
        continue;
        bool = false;
      }
    }
    localIliveManagerCfgBean.jdField_a_of_type_Boolean = bool;
    if (paramString.has("heartTimeLong")) {
      localIliveManagerCfgBean.jdField_a_of_type_Long = Long.parseLong(paramString.optString("heartTimeLong"));
    }
    if (paramString.has("heartSwitch"))
    {
      if (Integer.parseInt(paramString.optString("heartSwitch")) == 1)
      {
        bool = true;
        localIliveManagerCfgBean.jdField_b_of_type_Boolean = bool;
      }
    }
    else
    {
      localObject = paramString.optJSONArray("blackList");
      if (localObject != null)
      {
        localArrayList = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localArrayList.add((String)((JSONArray)localObject).get(i));
          i += 1;
        }
        localIliveManagerCfgBean.jdField_a_of_type_JavaUtilArrayList = localArrayList;
      }
      paramString = paramString.optJSONArray("blackVersionList");
      if (paramString != null)
      {
        localObject = new ArrayList();
        i = j;
        while (i < paramString.length())
        {
          ((ArrayList)localObject).add((Integer)paramString.get(i));
          i += 1;
        }
        localIliveManagerCfgBean.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)localObject);
      }
      return localIliveManagerCfgBean;
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if ((localInteger != null) && (localInteger.intValue() == Build.VERSION.SDK_INT)) {
          return false;
        }
      }
      QLog.e("IliveManagerCfgBean", 1, "isManagerConfigEnable IliveManagerCfnBean has not data , currentVersion = " + Build.VERSION.SDK_INT);
    }
    if (!ConfigUtil.a(this.jdField_a_of_type_JavaUtilArrayList)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.config.IliveManagerCfgBean
 * JD-Core Version:    0.7.0.1
 */