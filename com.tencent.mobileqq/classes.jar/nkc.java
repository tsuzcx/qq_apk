import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public final class nkc
  implements arol<anlr, char[]>
{
  public char[] a(anlr paramanlr)
  {
    try
    {
      int i = Integer.parseInt(paramanlr.a.eId);
      int j = Integer.parseInt(paramanlr.a.epId);
      Object localObject = anam.a(j, i);
      paramanlr = new char[5];
      paramanlr[0] = 20;
      paramanlr[1] = localObject[3];
      paramanlr[2] = localObject[2];
      paramanlr[3] = localObject[1];
      paramanlr[4] = localObject[0];
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((arnz)((AppRuntime)localObject).getManager(14)).a(String.valueOf(j));
        if ((localObject != null) && (((EmoticonPackage)localObject).isAPNG == 2)) {
          paramanlr[1] = 511;
        }
      }
      return paramanlr;
    }
    catch (NumberFormatException paramanlr)
    {
      QLog.e("ReadInJoyBaseDeliverActivity", 1, "kandian fail to send small_emotion. id is not Int.");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nkc
 * JD-Core Version:    0.7.0.1
 */