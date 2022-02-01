import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.SmallEmoticonInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public final class old
  implements avtc<SmallEmoticonInfo, char[]>
{
  public char[] a(SmallEmoticonInfo paramSmallEmoticonInfo)
  {
    try
    {
      int i = Integer.parseInt(paramSmallEmoticonInfo.emoticon.eId);
      int j = Integer.parseInt(paramSmallEmoticonInfo.emoticon.epId);
      Object localObject = aqyy.a(j, i);
      paramSmallEmoticonInfo = new char[5];
      paramSmallEmoticonInfo[0] = 20;
      paramSmallEmoticonInfo[1] = localObject[3];
      paramSmallEmoticonInfo[2] = localObject[2];
      paramSmallEmoticonInfo[3] = localObject[1];
      paramSmallEmoticonInfo[4] = localObject[0];
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((avsq)((AppRuntime)localObject).getManager(14)).a(String.valueOf(j));
        if ((localObject != null) && (((EmoticonPackage)localObject).isAPNG == 2)) {
          paramSmallEmoticonInfo[1] = 511;
        }
      }
      return paramSmallEmoticonInfo;
    }
    catch (NumberFormatException paramSmallEmoticonInfo)
    {
      QLog.e("ReadInJoyBaseDeliverActivity", 1, "kandian fail to send small_emotion. id is not Int.");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     old
 * JD-Core Version:    0.7.0.1
 */