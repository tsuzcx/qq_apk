import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public final class nyo
  implements aubq<apud, char[]>
{
  public char[] a(apud paramapud)
  {
    try
    {
      int i = Integer.parseInt(paramapud.a.eId);
      int j = Integer.parseInt(paramapud.a.epId);
      Object localObject = apih.a(j, i);
      paramapud = new char[5];
      paramapud[0] = 20;
      paramapud[1] = localObject[3];
      paramapud[2] = localObject[2];
      paramapud[3] = localObject[1];
      paramapud[4] = localObject[0];
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((aube)((AppRuntime)localObject).getManager(14)).a(String.valueOf(j));
        if ((localObject != null) && (((EmoticonPackage)localObject).isAPNG == 2)) {
          paramapud[1] = 511;
        }
      }
      return paramapud;
    }
    catch (NumberFormatException paramapud)
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