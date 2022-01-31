import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FunnyPicHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class srs
  implements Runnable
{
  public srs(FavEmosmManageActivity paramFavEmosmManageActivity, List paramList) {}
  
  public void run()
  {
    Object localObject1 = (FavroamingDBManager)this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.app.getManager(148);
    if (QLog.isColorLevel()) {
      QLog.i("FavEmosmManageActivity", 2, "Call getFavEmoticonList-1 from doDelete.");
    }
    Object localObject2 = ((FavroamingDBManager)localObject1).a();
    if (localObject2 != null)
    {
      int i = 1;
      int k = 0;
      for (;;)
      {
        j = i;
        if (k >= ((List)localObject2).size()) {
          break;
        }
        int m = ((CustomEmotionData)((List)localObject2).get(k)).emoId;
        j = i;
        if (i < m) {
          j = m;
        }
        k += 1;
        i = j;
      }
    }
    int j = 1;
    localObject2 = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FavoriteEmoticonInfo localFavoriteEmoticonInfo = (FavoriteEmoticonInfo)localIterator.next();
      if (!this.jdField_a_of_type_JavaUtilList.contains(localFavoriteEmoticonInfo))
      {
        CustomEmotionData localCustomEmotionData = new CustomEmotionData();
        localCustomEmotionData.uin = this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.app.getCurrentAccountUin();
        localCustomEmotionData.url = localFavoriteEmoticonInfo.d;
        localCustomEmotionData.eId = localFavoriteEmoticonInfo.c;
        localCustomEmotionData.md5 = localFavoriteEmoticonInfo.a;
        j += 1;
        localCustomEmotionData.emoId = j;
        localCustomEmotionData.emoPath = (AppConstants.aV + FunnyPicHelper.a(localFavoriteEmoticonInfo.d));
        ((FavroamingDBManager)localObject1).c(localCustomEmotionData);
        ((List)localObject2).add(localCustomEmotionData);
      }
    }
    localObject1 = (FavroamingManager)this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.app.getManager(102);
    if ((localObject1 != null) && (!((List)localObject2).isEmpty())) {
      ((FavroamingManager)localObject1).a((List)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     srs
 * JD-Core Version:    0.7.0.1
 */