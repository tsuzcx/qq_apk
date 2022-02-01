import com.google.gson.Gson;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class oet
{
  public static ArrayList<odx> a()
  {
    ArrayList localArrayList = new ArrayList();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      localArrayList = (ArrayList)new Gson().fromJson(oew.a(localAppRuntime, "redpoint_info_" + oer.a(localAppRuntime)), new oeu().getType());
    }
    return localArrayList;
  }
  
  public static void a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      oew.a(localAppRuntime, "redpoint_info_" + oer.a(localAppRuntime), "");
    }
  }
  
  public static void a(int paramInt)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      oew.a(localAppRuntime, "redpoint_show_" + paramInt + "_" + oer.a(localAppRuntime), true);
    }
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    QLog.i("Ecshop_RedPointUtil", 2, "[saveRedpoingClickTag]  taksId: " + paramInt2);
    if (localAppRuntime != null) {
      oew.a(localAppRuntime, "redpoint_click_" + paramInt1 + "_" + oer.a(localAppRuntime), paramInt2);
    }
  }
  
  public static void a(ArrayList<odx> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    AppRuntime localAppRuntime;
    do
    {
      return;
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    } while (localAppRuntime == null);
    oew.a(localAppRuntime, "redpoint_info_" + oer.a(localAppRuntime), new Gson().toJson(paramArrayList));
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = false;
    try
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if (localAppRuntime != null) {
        bool = oew.a(localAppRuntime, "redpoint_show_" + paramInt + "_" + oer.a(localAppRuntime));
      }
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("Ecshop_RedPointUtil", 1, "[getRedpointClickTag] fail.", localException);
    }
    return false;
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    try
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if (localAppRuntime != null)
      {
        paramInt1 = oew.a(localAppRuntime, "redpoint_click_" + paramInt1 + "_" + oer.a(localAppRuntime));
        if (QLog.isColorLevel()) {
          QLog.i("Ecshop_RedPointUtil", 2, "[getRedpointClickTag] cachedTaskId: " + paramInt1 + " taskId: " + paramInt2);
        }
        return paramInt1 == paramInt2;
      }
    }
    catch (Exception localException)
    {
      QLog.e("Ecshop_RedPointUtil", 1, "[getRedpointClickTag] fail.", localException);
    }
    return false;
  }
  
  public static void b(int paramInt)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      oew.a(localAppRuntime, "redpoint_show_" + paramInt + "_" + oer.a(localAppRuntime), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oet
 * JD-Core Version:    0.7.0.1
 */