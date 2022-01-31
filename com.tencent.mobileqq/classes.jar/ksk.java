import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public abstract class ksk<T>
  extends alzl<T>
{
  final int jdField_a_of_type_Int;
  final String jdField_a_of_type_JavaLangString;
  
  public ksk(int paramInt)
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
  
  @NonNull
  static alzs a(String paramString, int paramInt, alzs[] paramArrayOfalzs)
  {
    int i;
    Object localObject2;
    Object localObject4;
    Object localObject3;
    int j;
    if ((QLog.isDevelopLevel()) || (paramArrayOfalzs.length > 1))
    {
      i = 1;
      Object localObject1 = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
      paramInt = alzw.a().a(paramInt, ((AppInterface)localObject1).getCurrentAccountUin());
      localObject2 = null;
      if (i != 0) {
        localObject2 = "getSuitableItem, Version[" + paramInt + "], size[" + paramArrayOfalzs.length + "]";
      }
      localObject1 = paramArrayOfalzs[0];
      localObject4 = localObject2;
      localObject3 = localObject1;
      if (paramArrayOfalzs.length <= 1) {
        break label237;
      }
      int k = paramArrayOfalzs.length;
      paramInt = 0;
      j = 0;
      label109:
      localObject4 = localObject2;
      localObject3 = localObject1;
      if (paramInt >= k) {
        break label237;
      }
      localObject4 = paramArrayOfalzs[paramInt];
      int m = a(((alzs)localObject4).jdField_a_of_type_JavaLangString);
      localObject3 = localObject2;
      if (i != 0) {
        localObject3 = (String)localObject2 + ", \nindex[" + j + "], taskId[" + ((alzs)localObject4).jdField_a_of_type_Int + "], task_id[" + m + "]";
      }
      if (m != ((alzs)localObject4).jdField_a_of_type_Int) {
        break label305;
      }
      localObject1 = localObject4;
    }
    label305:
    for (;;)
    {
      j += 1;
      paramInt += 1;
      localObject2 = localObject3;
      break label109;
      i = 0;
      break;
      label237:
      if (i != 0)
      {
        paramArrayOfalzs = (String)localObject4 + ", \nselect taskId[" + ((alzs)localObject3).jdField_a_of_type_Int;
        QLog.w(paramString, 1, paramArrayOfalzs + "], content\n" + ((alzs)localObject3).jdField_a_of_type_JavaLangString);
      }
      return localObject3;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NonNull
  protected abstract T a(alzs[] paramArrayOfalzs);
  
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
  public final T b(alzs[] paramArrayOfalzs)
  {
    try
    {
      Object localObject = a(paramArrayOfalzs);
      return localObject;
    }
    catch (Exception localException)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onParsed, 配置解析异常, [\n" + paramArrayOfalzs[0].jdField_a_of_type_JavaLangString + "\n]", localException);
      AudioHelper.c(this.jdField_a_of_type_JavaLangString + ajjy.a(2131643116));
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
    return alzw.a().a(this.jdField_a_of_type_Int, str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ksk
 * JD-Core Version:    0.7.0.1
 */