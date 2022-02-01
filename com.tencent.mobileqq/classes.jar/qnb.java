import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class qnb
{
  private static volatile qnb jdField_a_of_type_Qnb;
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
  
  public static qnb a()
  {
    if (jdField_a_of_type_Qnb == null) {}
    try
    {
      if (jdField_a_of_type_Qnb == null) {
        jdField_a_of_type_Qnb = new qnb();
      }
      return jdField_a_of_type_Qnb;
    }
    finally {}
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    paramString1 = new qoc().a("name", paramString1).a("resCode", "" + paramInt).a("version", paramString2).a();
    if (paramInt == 0)
    {
      qob.a("0X800A832", "", "", "", paramString1);
      return;
    }
    qob.a("0X800A833", "", "", "", paramString1);
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
    bbzm.a().a(paramString, new qnc(this, paramString));
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qnb
 * JD-Core Version:    0.7.0.1
 */