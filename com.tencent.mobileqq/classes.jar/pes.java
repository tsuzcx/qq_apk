import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class pes
{
  private List<pev> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public static pes a()
  {
    return peu.a();
  }
  
  public pev a()
  {
    pev localpev1 = new pev();
    long l = NetConnInfoCenter.getServerTime();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      pev localpev2 = (pev)localIterator.next();
      if (localpev2.jdField_a_of_type_Long + localpev2.jdField_a_of_type_Int > l)
      {
        localpev1.jdField_a_of_type_JavaUtilSet.addAll(localpev2.jdField_a_of_type_JavaUtilSet);
        localpev1.b.addAll(localpev2.b);
      }
    }
    localpev1.b.removeAll(localpev1.jdField_a_of_type_JavaUtilSet);
    QLog.e("UserReadUnReadInfoManager", 1, "getEffectUserReadInfo:" + localpev1);
    return localpev1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Boolean = false;
    QLog.e("UserReadUnReadInfoManager", 1, "clearUserReadUnRead");
  }
  
  public void a(JSONObject paramJSONObject)
  {
    int j = 0;
    pev localpev = new pev();
    localpev.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
    try
    {
      localpev.jdField_a_of_type_Int = (paramJSONObject.getInt("effective_time") * 1000);
      Object localObject = paramJSONObject.optJSONArray("clicked_rowkey");
      JSONArray localJSONArray = paramJSONObject.optJSONArray("expose_rowkey");
      int i;
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          String str = ((JSONArray)localObject).getString(i);
          localpev.jdField_a_of_type_JavaUtilSet.add(str);
          i += 1;
        }
      }
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        i = j;
        while (i < localJSONArray.length())
        {
          localObject = localJSONArray.getString(i);
          localpev.b.add(localObject);
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("UserReadUnReadInfoManager", 1, "", localException);
      QLog.i("UserReadUnReadInfoManager", 1, "addUserReadInfo:" + paramJSONObject);
      this.jdField_a_of_type_JavaUtilList.add(localpev);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    pev localpev = a();
    return (!localpev.jdField_a_of_type_JavaUtilSet.isEmpty()) || (!localpev.b.isEmpty());
  }
  
  public void b()
  {
    QLog.e("UserReadUnReadInfoManager", 1, "onStart");
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    QLog.e("UserReadUnReadInfoManager", 1, "onStop");
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pes
 * JD-Core Version:    0.7.0.1
 */