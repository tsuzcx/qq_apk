import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager.FavEmotionDataInPanelCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class smw
  implements FavroamingDBManager.FavEmotionDataInPanelCallback
{
  public smw(FavEmosmManageActivity paramFavEmosmManageActivity) {}
  
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
      if (this.a.a != null) {
        this.a.a.obtainMessage(206, localObject).sendToTarget();
      }
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
 * Qualified Name:     smw
 * JD-Core Version:    0.7.0.1
 */