import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class pqj
{
  private List<pqm> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public static pqj a()
  {
    return pql.a();
  }
  
  public pqm a()
  {
    pqm localpqm1 = new pqm();
    long l = NetConnInfoCenter.getServerTime();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      pqm localpqm2 = (pqm)localIterator.next();
      if (localpqm2.jdField_a_of_type_Long + localpqm2.jdField_a_of_type_Int > l)
      {
        localpqm1.jdField_a_of_type_JavaUtilSet.addAll(localpqm2.jdField_a_of_type_JavaUtilSet);
        localpqm1.b.addAll(localpqm2.b);
      }
    }
    localpqm1.b.removeAll(localpqm1.jdField_a_of_type_JavaUtilSet);
    QLog.e("UserReadUnReadInfoManager", 1, "getEffectUserReadInfo:" + localpqm1);
    return localpqm1;
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
    pqm localpqm = new pqm();
    localpqm.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
    try
    {
      localpqm.jdField_a_of_type_Int = (paramJSONObject.getInt("effective_time") * 1000);
      Object localObject = paramJSONObject.optJSONArray("clicked_rowkey");
      JSONArray localJSONArray = paramJSONObject.optJSONArray("expose_rowkey");
      int i;
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          String str = ((JSONArray)localObject).getString(i);
          localpqm.jdField_a_of_type_JavaUtilSet.add(str);
          i += 1;
        }
      }
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        i = j;
        while (i < localJSONArray.length())
        {
          localObject = localJSONArray.getString(i);
          localpqm.b.add(localObject);
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("UserReadUnReadInfoManager", 1, "", localException);
      QLog.i("UserReadUnReadInfoManager", 1, "addUserReadInfo:" + paramJSONObject);
      this.jdField_a_of_type_JavaUtilList.add(localpqm);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    pqm localpqm = a();
    return (!localpqm.jdField_a_of_type_JavaUtilSet.isEmpty()) || (!localpqm.b.isEmpty());
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
 * Qualified Name:     pqj
 * JD-Core Version:    0.7.0.1
 */