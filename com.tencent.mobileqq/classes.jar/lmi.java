import com.tencent.av.gameplay.GPNativeSoLoader.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class lmi
{
  public static boolean a;
  private static boolean b;
  
  public static byte a(String paramString)
  {
    byte b1 = 0;
    if (paramString == null) {
      return -1;
    }
    lmj locallmj = lmj.a();
    String str = lmr.a() + "lib" + paramString + ".so";
    if (QLog.isColorLevel()) {
      QLog.i("Qav_GamePlayNativeSoLoader", 2, "start arNativeSo: " + str);
    }
    Object localObject = new File(str);
    if ((!a) && (((File)localObject).exists())) {}
    for (;;)
    {
      try
      {
        System.load(str);
        b = true;
        localObject = "null";
        if (locallmj != null) {
          localObject = locallmj.b;
        }
        QLog.w("Qav_GamePlayNativeSoLoader", 1, "loadGamePlayNativeSo, libPath[" + str + "], libName[" + paramString + "], md5[" + (String)localObject + "], isLoadSo[" + b + "], result[" + b1 + "]");
        return b1;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        b1 = -3;
        QLog.i("Qav_GamePlayNativeSoLoader", 1, "loadGamePlayNativeSo load fail", localUnsatisfiedLinkError);
        continue;
      }
      b1 = -2;
    }
  }
  
  public static boolean a()
  {
    if (b) {}
    do
    {
      return true;
      if (!lmk.a().b()) {
        break;
      }
    } while (a("qavgameplayengine") == 0);
    return false;
    ThreadManager.getUIHandler().post(new GPNativeSoLoader.1());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lmi
 * JD-Core Version:    0.7.0.1
 */