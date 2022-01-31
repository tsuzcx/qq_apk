import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public final class nvn
  implements askp<aocb, char[]>
{
  public char[] a(aocb paramaocb)
  {
    try
    {
      int i = Integer.parseInt(paramaocb.a.eId);
      int j = Integer.parseInt(paramaocb.a.epId);
      Object localObject = anqu.a(j, i);
      paramaocb = new char[5];
      paramaocb[0] = 20;
      paramaocb[1] = localObject[3];
      paramaocb[2] = localObject[2];
      paramaocb[3] = localObject[1];
      paramaocb[4] = localObject[0];
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((askd)((AppRuntime)localObject).getManager(14)).a(String.valueOf(j));
        if ((localObject != null) && (((EmoticonPackage)localObject).isAPNG == 2)) {
          paramaocb[1] = 511;
        }
      }
      return paramaocb;
    }
    catch (NumberFormatException paramaocb)
    {
      QLog.e("ReadInJoyBaseDeliverActivity", 1, "kandian fail to send small_emotion. id is not Int.");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nvn
 * JD-Core Version:    0.7.0.1
 */