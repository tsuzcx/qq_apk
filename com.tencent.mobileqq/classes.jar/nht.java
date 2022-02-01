import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class nht
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<nhu> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private HashMap<Integer, List<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private nia jdField_a_of_type_Nia = new nia(nhz.jdField_a_of_type_Nia);
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, String> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private nia jdField_b_of_type_Nia = new nia(nhz.jdField_b_of_type_Nia);
  private int jdField_c_of_type_Int;
  private nia jdField_c_of_type_Nia = new nia(nhz.jdField_c_of_type_Nia);
  
  public static nht a(araj paramaraj)
  {
    int k = 0;
    nht localnht = new nht();
    if (paramaraj != null) {
      if (QLog.isColorLevel()) {
        QLog.d("AvGameConfBean", 2, "parse taskid->" + paramaraj.jdField_a_of_type_Int + " content->" + paramaraj.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramaraj = new JSONObject(paramaraj.jdField_a_of_type_JavaLangString);
      localnht.a(paramaraj.optInt("ifShow", 0));
      localnht.a(paramaraj.optString("resUrl", ""));
      localnht.b(paramaraj.optString("resMd5", ""));
      localnht.b(paramaraj.optInt("quitTime", 0));
      if (QLog.isDevelopLevel()) {
        QLog.d("AvGameConfBean", 4, "mLoadingEnableExitTime[" + localnht.jdField_c_of_type_Int + "]");
      }
      Object localObject1 = paramaraj.optJSONObject("androidMachineLevels");
      if (localObject1 != null)
      {
        localnht.c(((JSONObject)localObject1).optString("high", ""));
        localnht.d(((JSONObject)localObject1).optString("middle", ""));
        localnht.e(((JSONObject)localObject1).optString("low", ""));
      }
      localObject1 = paramaraj.getJSONArray("gameBgMusic");
      int i = 0;
      Object localObject2;
      while (i < ((JSONArray)localObject1).length())
      {
        localObject2 = ((JSONArray)localObject1).getJSONObject(i);
        int m = ((JSONObject)localObject2).getInt("type");
        localObject2 = ((JSONObject)localObject2).getJSONArray("nameList");
        ArrayList localArrayList = new ArrayList();
        int j = 0;
        while (j < ((JSONArray)localObject2).length())
        {
          Object localObject3 = ((JSONArray)localObject2).getJSONObject(j);
          String str = ((JSONObject)localObject3).optString("name", "");
          localObject3 = ((JSONObject)localObject3).optString("proportion", "");
          localArrayList.add(str);
          localnht.a(str, (String)localObject3);
          j += 1;
        }
        localnht.a(m, localArrayList);
        i += 1;
      }
      localObject1 = paramaraj.optJSONObject("recordParam");
      if (localObject1 != null)
      {
        localObject2 = ((JSONObject)localObject1).optJSONObject("gameAction");
        if (localObject2 != null) {
          localnht.a(new nhu(1, ((JSONObject)localObject2).optInt("start", 10), ((JSONObject)localObject2).optInt("duration", 15)));
        }
        localObject2 = ((JSONObject)localObject1).optJSONObject("gameMosaic");
        if (localObject2 != null) {
          localnht.a(new nhu(2, ((JSONObject)localObject2).optInt("start", 10), ((JSONObject)localObject2).optInt("duration", 15)));
        }
        localObject2 = ((JSONObject)localObject1).optJSONObject("gameVideo");
        if (localObject2 != null) {
          localnht.a(new nhu(3, ((JSONObject)localObject2).optInt("start", 10), ((JSONObject)localObject2).optInt("duration", 15)));
        }
        localObject1 = ((JSONObject)localObject1).optJSONObject("gameVideo");
        if (localObject1 != null) {
          localnht.a(new nhu(4, ((JSONObject)localObject1).optInt("start", 10), ((JSONObject)localObject1).optInt("duration", 15)));
        }
      }
      if (paramaraj.has("disableSmallPicFlag"))
      {
        localnht.jdField_b_of_type_Int = paramaraj.optInt("disableSmallPicFlag");
        if (QLog.isDevelopLevel()) {
          QLog.i("AvGameConfBean", 4, "disableSmallPicFlag[" + localnht.jdField_b_of_type_Int + "]");
        }
      }
      paramaraj = paramaraj.optJSONArray("aioText");
      if ((paramaraj != null) && (paramaraj.length() > 0))
      {
        localObject1 = new ArrayList(paramaraj.length());
        i = k;
        while (i < paramaraj.length())
        {
          ((ArrayList)localObject1).add(paramaraj.optString(i, ""));
          i += 1;
        }
        localnht.a((ArrayList)localObject1);
      }
    }
    catch (Exception paramaraj)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("AvGameConfBean", 2, "parse error->" + paramaraj.toString());
    }
    return localnht;
    return localnht;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilHashMap == null) {
      return null;
    }
    return (String)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public ArrayList<String> a()
  {
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public List<nhu> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public List<String> a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      return null;
    }
    return (List)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  public nia a()
  {
    return this.jdField_a_of_type_Nia;
  }
  
  void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  void a(int paramInt, List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramList);
  }
  
  void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  void a(String paramString1, String paramString2)
  {
    this.jdField_b_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  void a(ArrayList<String> paramArrayList)
  {
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void a(nhu paramnhu)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramnhu);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public nia b()
  {
    return this.jdField_b_of_type_Nia;
  }
  
  void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public nia c()
  {
    return this.jdField_c_of_type_Nia;
  }
  
  void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AvGameConfBean", 2, "setHighMachineLevel str EMPTY");
      return;
    }
    this.jdField_a_of_type_Nia.a(paramString);
  }
  
  void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AvGameConfBean", 2, "setMiddleMachineLevel str EMPTY");
      return;
    }
    this.jdField_b_of_type_Nia.a(paramString);
  }
  
  void e(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AvGameConfBean", 2, "setLowMachineLevel str EMPTY");
      return;
    }
    this.jdField_c_of_type_Nia.a(paramString);
  }
  
  public String toString()
  {
    return String.format("mAvGameShowInPlus:%d ", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nht
 * JD-Core Version:    0.7.0.1
 */