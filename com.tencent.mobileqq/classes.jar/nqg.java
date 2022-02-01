import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class nqg
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<nqh> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private HashMap<Integer, List<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private nqn jdField_a_of_type_Nqn = new nqn(nqm.jdField_a_of_type_Nqn);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, String> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private nqn jdField_b_of_type_Nqn = new nqn(nqm.jdField_b_of_type_Nqn);
  private int jdField_c_of_type_Int;
  private nqn jdField_c_of_type_Nqn = new nqn(nqm.jdField_c_of_type_Nqn);
  private int d = -1;
  
  public static nqg a(aqxa paramaqxa)
  {
    boolean bool = true;
    nqg localnqg = new nqg();
    if (paramaqxa != null) {
      if (QLog.isColorLevel()) {
        QLog.d("AvGameConfBean", 2, "parse taskid->" + paramaqxa.jdField_a_of_type_Int + " content->" + paramaqxa.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      try
      {
        paramaqxa = new JSONObject(paramaqxa.jdField_a_of_type_JavaLangString);
        localnqg.a(paramaqxa.optInt("ifShow", 0));
        localnqg.a(paramaqxa.optString("resUrl", ""));
        localnqg.b(paramaqxa.optString("resMd5", ""));
        localnqg.b(paramaqxa.optInt("quitTime", 0));
        if (QLog.isDevelopLevel()) {
          QLog.d("AvGameConfBean", 4, "mLoadingEnableExitTime[" + localnqg.jdField_c_of_type_Int + "]");
        }
        Object localObject1 = paramaqxa.optJSONObject("androidMachineLevels");
        if (localObject1 != null)
        {
          localnqg.c(((JSONObject)localObject1).optString("high", ""));
          localnqg.d(((JSONObject)localObject1).optString("middle", ""));
          localnqg.e(((JSONObject)localObject1).optString("low", ""));
        }
        localObject1 = paramaqxa.getJSONArray("gameBgMusic");
        int i = 0;
        Object localObject2;
        if (i < ((JSONArray)localObject1).length())
        {
          localObject2 = ((JSONArray)localObject1).getJSONObject(i);
          int k = ((JSONObject)localObject2).getInt("type");
          localObject2 = ((JSONObject)localObject2).getJSONArray("nameList");
          ArrayList localArrayList = new ArrayList();
          int j = 0;
          if (j < ((JSONArray)localObject2).length())
          {
            Object localObject3 = ((JSONArray)localObject2).getJSONObject(j);
            String str = ((JSONObject)localObject3).optString("name", "");
            localObject3 = ((JSONObject)localObject3).optString("proportion", "");
            localArrayList.add(str);
            localnqg.a(str, (String)localObject3);
            j += 1;
            continue;
          }
          localnqg.a(k, localArrayList);
          i += 1;
          continue;
        }
        localObject1 = paramaqxa.optJSONObject("recordParam");
        if (localObject1 != null)
        {
          localObject2 = ((JSONObject)localObject1).optJSONObject("gameAction");
          if (localObject2 != null) {
            localnqg.a(new nqh(1, ((JSONObject)localObject2).optInt("start", 10), ((JSONObject)localObject2).optInt("duration", 15)));
          }
          localObject2 = ((JSONObject)localObject1).optJSONObject("gameMosaic");
          if (localObject2 != null) {
            localnqg.a(new nqh(2, ((JSONObject)localObject2).optInt("start", 10), ((JSONObject)localObject2).optInt("duration", 15)));
          }
          localObject2 = ((JSONObject)localObject1).optJSONObject("gameVideo");
          if (localObject2 != null) {
            localnqg.a(new nqh(3, ((JSONObject)localObject2).optInt("start", 10), ((JSONObject)localObject2).optInt("duration", 15)));
          }
          localObject1 = ((JSONObject)localObject1).optJSONObject("gameVideo");
          if (localObject1 != null) {
            localnqg.a(new nqh(4, ((JSONObject)localObject1).optInt("start", 10), ((JSONObject)localObject1).optInt("duration", 15)));
          }
        }
        if (paramaqxa.has("disableSmallPicFlag"))
        {
          localnqg.jdField_b_of_type_Int = paramaqxa.optInt("disableSmallPicFlag");
          if (QLog.isDevelopLevel()) {
            QLog.i("AvGameConfBean", 4, "disableSmallPicFlag[" + localnqg.jdField_b_of_type_Int + "]");
          }
        }
        localObject1 = paramaqxa.optJSONArray("aioText");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          localObject2 = new ArrayList(((JSONArray)localObject1).length());
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            ((ArrayList)localObject2).add(((JSONArray)localObject1).optString(i, ""));
            i += 1;
            continue;
          }
          localnqg.a((ArrayList)localObject2);
        }
        if (paramaqxa.optInt("isShowMatch", 0) != 1) {
          continue;
        }
        localnqg.jdField_a_of_type_Boolean = bool;
        if (paramaqxa.has("useLocalVoiceRecogUin"))
        {
          localnqg.d = paramaqxa.optInt("useLocalVoiceRecogUin");
          if (QLog.isDevelopLevel()) {
            QLog.i("AvGameConfBean", 4, "mUseLocalVoiceRecogUin[" + localnqg.d + "]");
          }
        }
      }
      catch (Exception paramaqxa)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("AvGameConfBean", 2, "parse error->" + paramaqxa.toString());
      }
      return localnqg;
      bool = false;
    }
    return localnqg;
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
  
  public List<nqh> a()
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
  
  public nqn a()
  {
    return this.jdField_a_of_type_Nqn;
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
  
  public void a(nqh paramnqh)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramnqh);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public boolean a(long paramLong)
  {
    boolean bool = false;
    if (this.d <= -1) {}
    for (;;)
    {
      QLog.i("AvGameConfBean", 1, "isUseLocalVoiceRecog. mUseLocalVoiceRecogUin = " + this.d + ", useLocalVoiceRecog = " + bool);
      return bool;
      if (paramLong % 10L <= this.d) {
        bool = true;
      }
    }
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public nqn b()
  {
    return this.jdField_b_of_type_Nqn;
  }
  
  void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public nqn c()
  {
    return this.jdField_c_of_type_Nqn;
  }
  
  void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AvGameConfBean", 2, "setHighMachineLevel str EMPTY");
      return;
    }
    this.jdField_a_of_type_Nqn.a(paramString);
  }
  
  void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AvGameConfBean", 2, "setMiddleMachineLevel str EMPTY");
      return;
    }
    this.jdField_b_of_type_Nqn.a(paramString);
  }
  
  void e(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AvGameConfBean", 2, "setLowMachineLevel str EMPTY");
      return;
    }
    this.jdField_c_of_type_Nqn.a(paramString);
  }
  
  public String toString()
  {
    return String.format("mAvGameShowInPlus:%d ", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nqg
 * JD-Core Version:    0.7.0.1
 */