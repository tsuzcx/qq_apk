import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public final class nvk
  implements askr<aocg, char[]>
{
  public char[] a(aocg paramaocg)
  {
    try
    {
      int i = Integer.parseInt(paramaocg.a.eId);
      int j = Integer.parseInt(paramaocg.a.epId);
      Object localObject = anqz.a(j, i);
      paramaocg = new char[5];
      paramaocg[0] = 20;
      paramaocg[1] = localObject[3];
      paramaocg[2] = localObject[2];
      paramaocg[3] = localObject[1];
      paramaocg[4] = localObject[0];
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((askf)((AppRuntime)localObject).getManager(14)).a(String.valueOf(j));
        if ((localObject != null) && (((EmoticonPackage)localObject).isAPNG == 2)) {
          paramaocg[1] = 511;
        }
      }
      return paramaocg;
    }
    catch (NumberFormatException paramaocg)
    {
      QLog.e("ReadInJoyBaseDeliverActivity", 1, "kandian fail to send small_emotion. id is not Int.");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nvk
 * JD-Core Version:    0.7.0.1
 */