import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public abstract class ley<T>
  extends aokh<T>
{
  final int jdField_a_of_type_Int;
  final String jdField_a_of_type_JavaLangString;
  
  public ley(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = ("QAVConfig_" + this.jdField_a_of_type_Int);
  }
  
  private static int a(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).optInt("task_id");
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  @Nullable
  static aoko a(String paramString, int paramInt, aoko[] paramArrayOfaoko)
  {
    Object localObject1 = null;
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length == 0))
    {
      paramArrayOfaoko = (aoko[])localObject1;
      if (QLog.isColorLevel())
      {
        QLog.i(paramString, 2, "getSuitableItem, confFiles is null or empty.");
        paramArrayOfaoko = (aoko[])localObject1;
      }
      return paramArrayOfaoko;
    }
    int i;
    if ((QLog.isDevelopLevel()) || (paramArrayOfaoko.length > 1))
    {
      i = 1;
      label47:
      localObject1 = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
      paramInt = aoks.a().a(paramInt, ((AppInterface)localObject1).getCurrentAccountUin());
      if (i == 0) {
        break label341;
      }
    }
    label139:
    label338:
    label341:
    for (Object localObject2 = "getSuitableItem, Version[" + paramInt + "], size[" + paramArrayOfaoko.length + "]";; localObject2 = null)
    {
      localObject1 = paramArrayOfaoko[0];
      Object localObject4 = localObject2;
      Object localObject3 = localObject1;
      int j;
      if (paramArrayOfaoko.length > 1)
      {
        int k = paramArrayOfaoko.length;
        paramInt = 0;
        j = 0;
        localObject4 = localObject2;
        localObject3 = localObject1;
        if (paramInt < k)
        {
          localObject4 = paramArrayOfaoko[paramInt];
          int m = a(((aoko)localObject4).jdField_a_of_type_JavaLangString);
          localObject3 = localObject2;
          if (i != 0) {
            localObject3 = (String)localObject2 + ", \nindex[" + j + "], taskId[" + ((aoko)localObject4).jdField_a_of_type_Int + "], task_id[" + m + "]";
          }
          if (m != ((aoko)localObject4).jdField_a_of_type_Int) {
            break label338;
          }
          localObject1 = localObject4;
        }
      }
      for (;;)
      {
        j += 1;
        paramInt += 1;
        localObject2 = localObject3;
        break label139;
        i = 0;
        break label47;
        paramArrayOfaoko = (aoko[])localObject3;
        if (i == 0) {
          break;
        }
        paramArrayOfaoko = (String)localObject4 + ", \nselect taskId[" + ((aoko)localObject3).jdField_a_of_type_Int;
        QLog.w(paramString, 1, paramArrayOfaoko + "], content\n" + ((aoko)localObject3).jdField_a_of_type_JavaLangString);
        return localObject3;
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NonNull
  protected abstract T a(aoko[] paramArrayOfaoko);
  
  public void a()
  {
    if (QLog.isDevelopLevel())
    {
      int i = c();
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onReqNoReceive, version[" + i + "]");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      int i = c();
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onReqFailed, failCode[" + paramInt + "], version[" + i + "]");
    }
  }
  
  public void a(T paramT)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onUpdate, " + paramT);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return 0;
  }
  
  @Nullable
  public final T b(aoko[] paramArrayOfaoko)
  {
    try
    {
      Object localObject = a(paramArrayOfaoko);
      return localObject;
    }
    catch (Exception localException)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onParsed, 配置解析异常, [\n" + paramArrayOfaoko[0].jdField_a_of_type_JavaLangString + "\n]", localException);
      AudioHelper.c(this.jdField_a_of_type_JavaLangString + alud.a(2131709296));
    }
    return a(a());
  }
  
  public boolean b()
  {
    return false;
  }
  
  public int c()
  {
    String str = "";
    if (a()) {
      str = ((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin();
    }
    return aoks.a().a(this.jdField_a_of_type_Int, str);
  }
  
  public boolean c()
  {
    return true;
  }
  
  public boolean d()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ley
 * JD-Core Version:    0.7.0.1
 */