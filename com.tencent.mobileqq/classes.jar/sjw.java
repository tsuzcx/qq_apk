import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager.FavEmotionDataInPanelCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sjw
  implements FavroamingDBManager.FavEmotionDataInPanelCallback
{
  public sjw(FavEmosmManageActivity paramFavEmosmManageActivity) {}
  
  public void a(List paramList)
  {
    List localList2 = paramList;
    if (paramList != null) {
      localList1 = paramList;
    }
    try
    {
      Collections.reverse(paramList);
      localList2 = paramList;
      localList1 = paramList;
      if (paramList.size() > FavEmoConstant.b)
      {
        localList1 = paramList;
        int i = paramList.size() - FavEmoConstant.b;
        localList1 = paramList;
        paramList = paramList.subList(i, paramList.size());
        localList2 = paramList;
        localList1 = paramList;
        if (QLog.isColorLevel())
        {
          localList1 = paramList;
          QLog.d("FavEmoRoamingHandler", 2, "fav emoticon overflow size" + i);
          localList2 = paramList;
        }
      }
      paramList = localList2;
    }
    catch (UnsupportedOperationException paramList)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FavEmoRoamingHandler", 2, paramList.getMessage());
        }
        paramList = localList1;
      }
    }
    if (paramList == null)
    {
      paramList = new ArrayList();
      if (paramList.size() >= FavEmoConstant.a) {
        ReportController.b(this.a.app, "CliOper", "", "", "0X8005CFA", "0X8005CFA", 0, 0, "", "", "", "");
      }
      if (paramList.size() >= FavEmoConstant.b) {
        ReportController.b(this.a.app, "CliOper", "", "", "0X8005CFB", "0X8005CFB", 0, 0, "", "", "", "");
      }
      paramList.add(0, new EmoticonInfo());
      this.a.a(paramList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sjw
 * JD-Core Version:    0.7.0.1
 */