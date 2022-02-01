import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public final class ojr
  implements axfv<asrv, char[]>
{
  public char[] a(asrv paramasrv)
  {
    try
    {
      int i = Integer.parseInt(paramasrv.a.eId);
      int j = Integer.parseInt(paramasrv.a.epId);
      Object localObject = asfa.a(j, i);
      paramasrv = new char[5];
      paramasrv[0] = 20;
      paramasrv[1] = localObject[3];
      paramasrv[2] = localObject[2];
      paramasrv[3] = localObject[1];
      paramasrv[4] = localObject[0];
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((axfj)((AppRuntime)localObject).getManager(14)).a(String.valueOf(j));
        if ((localObject != null) && (((EmoticonPackage)localObject).isAPNG == 2)) {
          paramasrv[1] = 511;
        }
      }
      return paramasrv;
    }
    catch (NumberFormatException paramasrv)
    {
      QLog.e("ReadInJoyBaseDeliverActivity", 1, "kandian fail to send small_emotion. id is not Int.");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ojr
 * JD-Core Version:    0.7.0.1
 */