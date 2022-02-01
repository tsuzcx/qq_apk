import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.HexUtil;
import mqq.app.AppRuntime;
import mqq.manager.WtloginManager;

public class pnn
{
  public static long a()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.getRuntime();
    }
    if (localAppRuntime == null) {
      return 0L;
    }
    return localAppRuntime.getLongAccountUin();
  }
  
  public static QQAppInterface a()
  {
    AppRuntime localAppRuntime = a();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static String a()
  {
    Object localObject1 = null;
    Object localObject2 = BaseApplicationImpl.getApplication();
    if (localObject2 != null) {
      localObject1 = ((BaseApplicationImpl)localObject2).getRuntime();
    }
    if (localObject1 == null) {
      localObject1 = "0";
    }
    do
    {
      return localObject1;
      localObject2 = ((AppRuntime)localObject1).getAccount();
      localObject1 = localObject2;
    } while (localObject2 != null);
    return "0";
  }
  
  public static AppRuntime a()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.getRuntime();
    }
    return localAppRuntime;
  }
  
  public static boolean a()
  {
    return a() instanceof QQAppInterface;
  }
  
  public static QQAppInterface b()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static String b()
  {
    if (BaseApplicationImpl.getApplication() == null) {
      return null;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {
      return null;
    }
    localObject = (WtloginManager)((AppRuntime)localObject).getManager(1);
    if (localObject == null) {
      return null;
    }
    localObject = ((WtloginManager)localObject).getGUID();
    if ((localObject == null) || (localObject.length <= 0)) {
      return null;
    }
    return HexUtil.bytes2HexStr((byte[])localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pnn
 * JD-Core Version:    0.7.0.1
 */