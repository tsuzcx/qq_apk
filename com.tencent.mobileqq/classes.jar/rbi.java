import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class rbi
{
  private List<rbl> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public static rbi a()
  {
    return rbk.a();
  }
  
  public rbl a()
  {
    rbl localrbl1 = new rbl();
    long l = NetConnInfoCenter.getServerTime();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      rbl localrbl2 = (rbl)localIterator.next();
      if (localrbl2.jdField_a_of_type_Long + localrbl2.jdField_a_of_type_Int > l)
      {
        localrbl1.jdField_a_of_type_JavaUtilSet.addAll(localrbl2.jdField_a_of_type_JavaUtilSet);
        localrbl1.b.addAll(localrbl2.b);
      }
    }
    localrbl1.b.removeAll(localrbl1.jdField_a_of_type_JavaUtilSet);
    QLog.e("UserReadUnReadInfoManager", 1, "getEffectUserReadInfo:" + localrbl1);
    return localrbl1;
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
    rbl localrbl = new rbl();
    localrbl.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
    try
    {
      localrbl.jdField_a_of_type_Int = (paramJSONObject.getInt("effective_time") * 1000);
      Object localObject = paramJSONObject.optJSONArray("clicked_rowkey");
      JSONArray localJSONArray = paramJSONObject.optJSONArray("expose_rowkey");
      int i;
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          String str = ((JSONArray)localObject).getString(i);
          localrbl.jdField_a_of_type_JavaUtilSet.add(str);
          i += 1;
        }
      }
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        i = j;
        while (i < localJSONArray.length())
        {
          localObject = localJSONArray.getString(i);
          localrbl.b.add(localObject);
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("UserReadUnReadInfoManager", 1, "", localException);
      QLog.i("UserReadUnReadInfoManager", 1, "addUserReadInfo:" + paramJSONObject);
      this.jdField_a_of_type_JavaUtilList.add(localrbl);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    rbl localrbl = a();
    return (!localrbl.jdField_a_of_type_JavaUtilSet.isEmpty()) || (!localrbl.b.isEmpty());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rbi
 * JD-Core Version:    0.7.0.1
 */