import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public final class oij
  implements awnd<asch, char[]>
{
  public char[] a(asch paramasch)
  {
    try
    {
      int i = Integer.parseInt(paramasch.a.eId);
      int j = Integer.parseInt(paramasch.a.epId);
      Object localObject = arpm.a(j, i);
      paramasch = new char[5];
      paramasch[0] = 20;
      paramasch[1] = localObject[3];
      paramasch[2] = localObject[2];
      paramasch[3] = localObject[1];
      paramasch[4] = localObject[0];
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((awmr)((AppRuntime)localObject).getManager(14)).a(String.valueOf(j));
        if ((localObject != null) && (((EmoticonPackage)localObject).isAPNG == 2)) {
          paramasch[1] = 511;
        }
      }
      return paramasch;
    }
    catch (NumberFormatException paramasch)
    {
      QLog.e("ReadInJoyBaseDeliverActivity", 1, "kandian fail to send small_emotion. id is not Int.");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oij
 * JD-Core Version:    0.7.0.1
 */