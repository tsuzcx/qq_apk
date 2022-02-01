import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class qja
{
  private List<qjd> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public static qja a()
  {
    return qjc.a();
  }
  
  public qjd a()
  {
    qjd localqjd1 = new qjd();
    long l = NetConnInfoCenter.getServerTime();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      qjd localqjd2 = (qjd)localIterator.next();
      if (localqjd2.jdField_a_of_type_Long + localqjd2.jdField_a_of_type_Int > l)
      {
        localqjd1.jdField_a_of_type_JavaUtilSet.addAll(localqjd2.jdField_a_of_type_JavaUtilSet);
        localqjd1.b.addAll(localqjd2.b);
      }
    }
    localqjd1.b.removeAll(localqjd1.jdField_a_of_type_JavaUtilSet);
    QLog.e("UserReadUnReadInfoManager", 1, "getEffectUserReadInfo:" + localqjd1);
    return localqjd1;
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
    qjd localqjd = new qjd();
    localqjd.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
    try
    {
      localqjd.jdField_a_of_type_Int = (paramJSONObject.getInt("effective_time") * 1000);
      Object localObject = paramJSONObject.optJSONArray("clicked_rowkey");
      JSONArray localJSONArray = paramJSONObject.optJSONArray("expose_rowkey");
      int i;
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          String str = ((JSONArray)localObject).getString(i);
          localqjd.jdField_a_of_type_JavaUtilSet.add(str);
          i += 1;
        }
      }
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        i = j;
        while (i < localJSONArray.length())
        {
          localObject = localJSONArray.getString(i);
          localqjd.b.add(localObject);
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("UserReadUnReadInfoManager", 1, "", localException);
      QLog.i("UserReadUnReadInfoManager", 1, "addUserReadInfo:" + paramJSONObject);
      this.jdField_a_of_type_JavaUtilList.add(localqjd);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    qjd localqjd = a();
    return (!localqjd.jdField_a_of_type_JavaUtilSet.isEmpty()) || (!localqjd.b.isEmpty());
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
 * Qualified Name:     qja
 * JD-Core Version:    0.7.0.1
 */