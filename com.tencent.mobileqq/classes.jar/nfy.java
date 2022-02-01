import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class nfy
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<nfz> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private HashMap<Integer, List<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ngf jdField_a_of_type_Ngf = new ngf(nge.jdField_a_of_type_Ngf);
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private HashMap<String, String> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private ngf jdField_b_of_type_Ngf = new ngf(nge.jdField_b_of_type_Ngf);
  private int jdField_c_of_type_Int;
  private ngf jdField_c_of_type_Ngf = new ngf(nge.jdField_c_of_type_Ngf);
  
  public static nfy a(aqlg paramaqlg)
  {
    nfy localnfy = new nfy();
    if (paramaqlg != null) {
      if (QLog.isColorLevel()) {
        QLog.d("AvGameConfBean", 2, "parse taskid->" + paramaqlg.jdField_a_of_type_Int + " content->" + paramaqlg.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramaqlg = new JSONObject(paramaqlg.jdField_a_of_type_JavaLangString);
      localnfy.a(paramaqlg.optInt("ifShow", 0));
      localnfy.a(paramaqlg.optString("resUrl", ""));
      localnfy.b(paramaqlg.optString("resMd5", ""));
      localnfy.b(paramaqlg.optInt("quitTime", 0));
      if (QLog.isDevelopLevel()) {
        QLog.d("AvGameConfBean", 4, "mLoadingEnableExitTime[" + localnfy.jdField_c_of_type_Int + "]");
      }
      Object localObject1 = paramaqlg.optJSONObject("androidMachineLevels");
      if (localObject1 != null)
      {
        localnfy.c(((JSONObject)localObject1).optString("high", ""));
        localnfy.d(((JSONObject)localObject1).optString("middle", ""));
        localnfy.e(((JSONObject)localObject1).optString("low", ""));
      }
      localObject1 = paramaqlg.getJSONArray("gameBgMusic");
      int i = 0;
      Object localObject2;
      while (i < ((JSONArray)localObject1).length())
      {
        localObject2 = ((JSONArray)localObject1).getJSONObject(i);
        int k = ((JSONObject)localObject2).getInt("type");
        localObject2 = ((JSONObject)localObject2).getJSONArray("nameList");
        ArrayList localArrayList = new ArrayList();
        int j = 0;
        while (j < ((JSONArray)localObject2).length())
        {
          Object localObject3 = ((JSONArray)localObject2).getJSONObject(j);
          String str = ((JSONObject)localObject3).optString("name", "");
          localObject3 = ((JSONObject)localObject3).optString("proportion", "");
          localArrayList.add(str);
          localnfy.a(str, (String)localObject3);
          j += 1;
        }
        localnfy.a(k, localArrayList);
        i += 1;
      }
      localObject1 = paramaqlg.optJSONObject("recordParam");
      if (localObject1 != null)
      {
        localObject2 = ((JSONObject)localObject1).optJSONObject("gameAction");
        if (localObject2 != null) {
          localnfy.a(new nfz(1, ((JSONObject)localObject2).optInt("start", 10), ((JSONObject)localObject2).optInt("duration", 15)));
        }
        localObject2 = ((JSONObject)localObject1).optJSONObject("gameMosaic");
        if (localObject2 != null) {
          localnfy.a(new nfz(2, ((JSONObject)localObject2).optInt("start", 10), ((JSONObject)localObject2).optInt("duration", 15)));
        }
        localObject2 = ((JSONObject)localObject1).optJSONObject("gameVideo");
        if (localObject2 != null) {
          localnfy.a(new nfz(3, ((JSONObject)localObject2).optInt("start", 10), ((JSONObject)localObject2).optInt("duration", 15)));
        }
        localObject1 = ((JSONObject)localObject1).optJSONObject("gameVideo");
        if (localObject1 != null) {
          localnfy.a(new nfz(4, ((JSONObject)localObject1).optInt("start", 10), ((JSONObject)localObject1).optInt("duration", 15)));
        }
      }
      if (paramaqlg.has("disableSmallPicFlag"))
      {
        localnfy.jdField_b_of_type_Int = paramaqlg.optInt("disableSmallPicFlag");
        if (QLog.isDevelopLevel()) {
          QLog.i("AvGameConfBean", 4, "disableSmallPicFlag[" + localnfy.jdField_b_of_type_Int + "]");
        }
      }
    }
    catch (Exception paramaqlg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("AvGameConfBean", 2, "parse error->" + paramaqlg.toString());
    }
    return localnfy;
    return localnfy;
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
  
  public List<nfz> a()
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
  
  public ngf a()
  {
    return this.jdField_a_of_type_Ngf;
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
  
  public void a(nfz paramnfz)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramnfz);
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
  
  public ngf b()
  {
    return this.jdField_b_of_type_Ngf;
  }
  
  void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public ngf c()
  {
    return this.jdField_c_of_type_Ngf;
  }
  
  void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AvGameConfBean", 2, "setHighMachineLevel str EMPTY");
      return;
    }
    this.jdField_a_of_type_Ngf.a(paramString);
  }
  
  void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AvGameConfBean", 2, "setMiddleMachineLevel str EMPTY");
      return;
    }
    this.jdField_b_of_type_Ngf.a(paramString);
  }
  
  void e(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AvGameConfBean", 2, "setLowMachineLevel str EMPTY");
      return;
    }
    this.jdField_c_of_type_Ngf.a(paramString);
  }
  
  public String toString()
  {
    return String.format("mAvGameShowInPlus:%d ", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nfy
 * JD-Core Version:    0.7.0.1
 */