import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class qha
{
  private static volatile qha jdField_a_of_type_Qha;
  private boolean jdField_a_of_type_Boolean;
  
  private List<Integer> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new ArrayList();
      return paramString;
    }
    String[] arrayOfString = paramString.split("\\.");
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      paramString = localArrayList;
      if (i >= j) {
        break;
      }
      paramString = arrayOfString[i];
      try
      {
        localArrayList.add(Integer.valueOf(Integer.parseInt(paramString)));
        i += 1;
      }
      catch (NumberFormatException paramString)
      {
        QLog.e("PTSSoLoader", 1, "[getVersionList] error, e = " + paramString);
      }
    }
    return new ArrayList();
  }
  
  public static qha a()
  {
    if (jdField_a_of_type_Qha == null) {}
    try
    {
      if (jdField_a_of_type_Qha == null) {
        jdField_a_of_type_Qha = new qha();
      }
      return jdField_a_of_type_Qha;
    }
    finally {}
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    paramString1 = new qhz().a("name", paramString1).a("resCode", "" + paramInt).a("version", paramString2).a();
    if (paramInt == 0)
    {
      qhy.a("0X800A832", "", "", "", paramString1);
      return;
    }
    qhy.a("0X800A833", "", "", "", paramString1);
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    QLog.i("PTSSoLoader", 1, "[isVersionValid], currentVersion = " + paramString1 + ", supportMinVersion = " + paramString2);
    List localList = a(paramString1);
    paramString2 = a(paramString2);
    if (paramString1.length() <= 0)
    {
      QLog.i("PTSSoLoader", 1, "[isVersionValid] false, currentVersion = " + paramString1);
      return false;
    }
    int j = Math.min(localList.size(), paramString2.size());
    int i = 0;
    while (i < j)
    {
      if (((Integer)localList.get(i)).intValue() < ((Integer)paramString2.get(i)).intValue())
      {
        QLog.i("PTSSoLoader", 1, "[isVersionValid] = false");
        return false;
      }
      if (((Integer)localList.get(i)).intValue() > ((Integer)paramString2.get(i)).intValue())
      {
        QLog.i("PTSSoLoader", 1, "[isVersionValid] = true");
        return true;
      }
      i += 1;
    }
    if (localList.size() >= paramString2.size()) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("PTSSoLoader", 1, "[isVersionValid] = " + bool);
      return bool;
    }
  }
  
  public void a(String paramString)
  {
    QLog.i("PTSSoLoader", 1, "[load], name = " + paramString);
    bdgx.a().a(paramString, new qhb(this, paramString));
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qha
 * JD-Core Version:    0.7.0.1
 */