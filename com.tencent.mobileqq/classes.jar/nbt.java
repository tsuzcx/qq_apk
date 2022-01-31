import com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class nbt
{
  public int a;
  public List<nbu> a;
  
  public nbt()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public nbt(int paramInt, mobileqq_mp.ConfigGroupInfo paramConfigGroupInfo)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramConfigGroupInfo == null) {}
    for (;;)
    {
      return;
      paramConfigGroupInfo = paramConfigGroupInfo.config_info.get();
      this.jdField_a_of_type_JavaUtilList = new ArrayList(paramConfigGroupInfo.size());
      paramConfigGroupInfo = paramConfigGroupInfo.iterator();
      while (paramConfigGroupInfo.hasNext()) {
        this.jdField_a_of_type_JavaUtilList.add(new nbu((mobileqq_mp.ConfigInfo)paramConfigGroupInfo.next()));
      }
    }
  }
  
  public nbt(mobileqq_mp.ConfigGroupInfo paramConfigGroupInfo)
  {
    this(0, paramConfigGroupInfo);
  }
  
  public static List<nbt> a(List<mobileqq_mp.ConfigGroupInfo> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new nbt((mobileqq_mp.ConfigGroupInfo)paramList.next()));
    }
    return localArrayList;
  }
  
  public static List<nbt> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray == null) {
      return localArrayList;
    }
    for (;;)
    {
      try
      {
        int k = paramJSONArray.length();
        int i = 0;
        if (i >= k) {
          break;
        }
        Object localObject = paramJSONArray.getJSONObject(i);
        nbt localnbt = new nbt();
        localnbt.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("type");
        localObject = ((JSONObject)localObject).getJSONArray("config");
        int m = ((JSONArray)localObject).length();
        int j = 0;
        if (j < m)
        {
          nbu localnbu = nbu.a(((JSONArray)localObject).getJSONObject(j));
          if (localnbu != null) {
            localnbt.jdField_a_of_type_JavaUtilList.add(localnbu);
          }
        }
        else
        {
          localArrayList.add(localnbt);
          i += 1;
          continue;
        }
        j += 1;
      }
      catch (Exception paramJSONArray)
      {
        paramJSONArray.printStackTrace();
        return localArrayList;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nbt
 * JD-Core Version:    0.7.0.1
 */