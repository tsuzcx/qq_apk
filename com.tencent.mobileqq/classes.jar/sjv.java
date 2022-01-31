import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager.FavEmotionDataInPanelCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class sjv
  implements FavroamingDBManager.FavEmotionDataInPanelCallback
{
  sjv(sju paramsju) {}
  
  public void a(List paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    try
    {
      Collections.reverse((List)localObject);
      ((List)localObject).add(0, new EmoticonInfo());
      this.a.a.b((List)localObject);
      return;
    }
    catch (UnsupportedOperationException paramList)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FavEmoRoamingHandler", 2, paramList.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sjv
 * JD-Core Version:    0.7.0.1
 */