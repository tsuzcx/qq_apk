import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public final class nyo
  implements aufz<apym, char[]>
{
  public char[] a(apym paramapym)
  {
    try
    {
      int i = Integer.parseInt(paramapym.a.eId);
      int j = Integer.parseInt(paramapym.a.epId);
      Object localObject = apmq.a(j, i);
      paramapym = new char[5];
      paramapym[0] = 20;
      paramapym[1] = localObject[3];
      paramapym[2] = localObject[2];
      paramapym[3] = localObject[1];
      paramapym[4] = localObject[0];
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((aufn)((AppRuntime)localObject).getManager(14)).a(String.valueOf(j));
        if ((localObject != null) && (((EmoticonPackage)localObject).isAPNG == 2)) {
          paramapym[1] = 511;
        }
      }
      return paramapym;
    }
    catch (NumberFormatException paramapym)
    {
      QLog.e("ReadInJoyBaseDeliverActivity", 1, "kandian fail to send small_emotion. id is not Int.");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nyo
 * JD-Core Version:    0.7.0.1
 */