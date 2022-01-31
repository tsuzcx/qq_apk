import com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class npn
{
  public int a;
  public List<npo> a;
  
  public npn()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public npn(int paramInt, mobileqq_mp.ConfigGroupInfo paramConfigGroupInfo)
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
        this.jdField_a_of_type_JavaUtilList.add(new npo((mobileqq_mp.ConfigInfo)paramConfigGroupInfo.next()));
      }
    }
  }
  
  public npn(mobileqq_mp.ConfigGroupInfo paramConfigGroupInfo)
  {
    this(0, paramConfigGroupInfo);
  }
  
  public static List<npn> a(List<mobileqq_mp.ConfigGroupInfo> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new npn((mobileqq_mp.ConfigGroupInfo)paramList.next()));
    }
    return localArrayList;
  }
  
  public static List<npn> a(JSONArray paramJSONArray)
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
        npn localnpn = new npn();
        localnpn.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("type");
        localObject = ((JSONObject)localObject).getJSONArray("config");
        int m = ((JSONArray)localObject).length();
        int j = 0;
        if (j < m)
        {
          npo localnpo = npo.a(((JSONArray)localObject).getJSONObject(j));
          if (localnpo != null) {
            localnpn.jdField_a_of_type_JavaUtilList.add(localnpo);
          }
        }
        else
        {
          localArrayList.add(localnpn);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     npn
 * JD-Core Version:    0.7.0.1
 */