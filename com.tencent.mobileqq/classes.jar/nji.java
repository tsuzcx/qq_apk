import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class nji
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<njj> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private HashMap<Integer, List<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private njp jdField_a_of_type_Njp = new njp(njo.jdField_a_of_type_Njp);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, String> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private njp jdField_b_of_type_Njp = new njp(njo.jdField_b_of_type_Njp);
  private int jdField_c_of_type_Int;
  private njp jdField_c_of_type_Njp = new njp(njo.jdField_c_of_type_Njp);
  private int d = -1;
  
  public static nji a(aptx paramaptx)
  {
    boolean bool = true;
    nji localnji = new nji();
    if (paramaptx != null) {
      if (QLog.isColorLevel()) {
        QLog.d("AvGameConfBean", 2, "parse taskid->" + paramaptx.jdField_a_of_type_Int + " content->" + paramaptx.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      try
      {
        paramaptx = new JSONObject(paramaptx.jdField_a_of_type_JavaLangString);
        localnji.a(paramaptx.optInt("ifShow", 0));
        localnji.a(paramaptx.optString("resUrl", ""));
        localnji.b(paramaptx.optString("resMd5", ""));
        localnji.b(paramaptx.optInt("quitTime", 0));
        if (QLog.isDevelopLevel()) {
          QLog.d("AvGameConfBean", 4, "mLoadingEnableExitTime[" + localnji.jdField_c_of_type_Int + "]");
        }
        Object localObject1 = paramaptx.optJSONObject("androidMachineLevels");
        if (localObject1 != null)
        {
          localnji.c(((JSONObject)localObject1).optString("high", ""));
          localnji.d(((JSONObject)localObject1).optString("middle", ""));
          localnji.e(((JSONObject)localObject1).optString("low", ""));
        }
        localObject1 = paramaptx.getJSONArray("gameBgMusic");
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
            localnji.a(str, (String)localObject3);
            j += 1;
            continue;
          }
          localnji.a(k, localArrayList);
          i += 1;
          continue;
        }
        localObject1 = paramaptx.optJSONObject("recordParam");
        if (localObject1 != null)
        {
          localObject2 = ((JSONObject)localObject1).optJSONObject("gameAction");
          if (localObject2 != null) {
            localnji.a(new njj(1, ((JSONObject)localObject2).optInt("start", 10), ((JSONObject)localObject2).optInt("duration", 15)));
          }
          localObject2 = ((JSONObject)localObject1).optJSONObject("gameMosaic");
          if (localObject2 != null) {
            localnji.a(new njj(2, ((JSONObject)localObject2).optInt("start", 10), ((JSONObject)localObject2).optInt("duration", 15)));
          }
          localObject2 = ((JSONObject)localObject1).optJSONObject("gameVideo");
          if (localObject2 != null) {
            localnji.a(new njj(3, ((JSONObject)localObject2).optInt("start", 10), ((JSONObject)localObject2).optInt("duration", 15)));
          }
          localObject1 = ((JSONObject)localObject1).optJSONObject("gameVideo");
          if (localObject1 != null) {
            localnji.a(new njj(4, ((JSONObject)localObject1).optInt("start", 10), ((JSONObject)localObject1).optInt("duration", 15)));
          }
        }
        if (paramaptx.has("disableSmallPicFlag"))
        {
          localnji.jdField_b_of_type_Int = paramaptx.optInt("disableSmallPicFlag");
          if (QLog.isDevelopLevel()) {
            QLog.i("AvGameConfBean", 4, "disableSmallPicFlag[" + localnji.jdField_b_of_type_Int + "]");
          }
        }
        localObject1 = paramaptx.optJSONArray("aioText");
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
          localnji.a((ArrayList)localObject2);
        }
        if (paramaptx.optInt("isShowMatch", 0) != 1) {
          continue;
        }
        localnji.jdField_a_of_type_Boolean = bool;
        if (paramaptx.has("useLocalVoiceRecogUin"))
        {
          localnji.d = paramaptx.optInt("useLocalVoiceRecogUin");
          if (QLog.isDevelopLevel()) {
            QLog.i("AvGameConfBean", 4, "mUseLocalVoiceRecogUin[" + localnji.d + "]");
          }
        }
      }
      catch (Exception paramaptx)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("AvGameConfBean", 2, "parse error->" + paramaptx.toString());
      }
      return localnji;
      bool = false;
    }
    return localnji;
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
  
  public List<njj> a()
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
  
  public njp a()
  {
    return this.jdField_a_of_type_Njp;
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
  
  public void a(njj paramnjj)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramnjj);
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
  
  public njp b()
  {
    return this.jdField_b_of_type_Njp;
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
  
  public njp c()
  {
    return this.jdField_c_of_type_Njp;
  }
  
  void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AvGameConfBean", 2, "setHighMachineLevel str EMPTY");
      return;
    }
    this.jdField_a_of_type_Njp.a(paramString);
  }
  
  void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AvGameConfBean", 2, "setMiddleMachineLevel str EMPTY");
      return;
    }
    this.jdField_b_of_type_Njp.a(paramString);
  }
  
  void e(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AvGameConfBean", 2, "setLowMachineLevel str EMPTY");
      return;
    }
    this.jdField_c_of_type_Njp.a(paramString);
  }
  
  public String toString()
  {
    return String.format("mAvGameShowInPlus:%d ", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nji
 * JD-Core Version:    0.7.0.1
 */