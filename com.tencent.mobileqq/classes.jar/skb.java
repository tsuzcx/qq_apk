import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FunnyPicHelper;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqManager;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class skb
  implements Runnable
{
  public skb(FavEmosmManageActivity paramFavEmosmManageActivity, Object paramObject, VipComicMqqManager paramVipComicMqqManager, int paramInt) {}
  
  public void run()
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.i("FavEmosmManageActivity", 2, "Call getFavEmoticonList-2 from doDelete.");
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingDBManager.a();
    int i;
    Object localObject1;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      i = 0;
      if (i < ((List)localObject2).size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)((List)localObject2).get(i);
        if (localCustomEmotionData == null) {}
        label154:
        do
        {
          for (;;)
          {
            i += 1;
            break;
            if (!(this.jdField_a_of_type_JavaLangObject instanceof PicEmoticonInfo)) {
              break label154;
            }
            localObject1 = ((PicEmoticonInfo)this.jdField_a_of_type_JavaLangObject).a;
            if ((!TextUtils.isEmpty(localCustomEmotionData.eId)) && (localObject1 != null) && (localCustomEmotionData.eId.equals(((Emoticon)localObject1).eId))) {
              localArrayList.add(localCustomEmotionData);
            }
          }
        } while (!(this.jdField_a_of_type_JavaLangObject instanceof FavoriteEmoticonInfo));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.jdField_a_of_type_JavaUtilList.contains(this.jdField_a_of_type_JavaLangObject)) {}
        for (localObject1 = AppConstants.aU + FunnyPicHelper.a(((FavoriteEmoticonInfo)this.jdField_a_of_type_JavaLangObject).d);; localObject1 = ((FavoriteEmoticonInfo)this.jdField_a_of_type_JavaLangObject).d)
        {
          if ((!TextUtils.isEmpty(localCustomEmotionData.emoPath)) && (localCustomEmotionData.emoPath.equals(localObject1))) {
            localArrayList.add(localCustomEmotionData);
          }
          if ((!TextUtils.isEmpty(localCustomEmotionData.emoPath)) || (!"init".equals(localCustomEmotionData.RomaingType))) {
            break;
          }
          QLog.e("FavEmosmManageActivity", 2, "delete failed, path is null, state is init. data: " + localCustomEmotionData);
          break;
        }
      }
    }
    if (localArrayList.size() > 0)
    {
      localObject1 = new ArrayList();
      i = j;
      if (i < localArrayList.size())
      {
        localObject2 = (CustomEmotionData)localArrayList.get(i);
        if (!TextUtils.isEmpty(((CustomEmotionData)localObject2).resid))
        {
          ((CustomEmotionData)localObject2).RomaingType = "needDel";
          this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingDBManager.b((CustomEmotionData)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.b.add(((CustomEmotionData)localObject2).resid);
          if (!TextUtils.isEmpty(((CustomEmotionData)localObject2).md5)) {
            ((List)localObject1).add(((CustomEmotionData)localObject2).md5);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("FavEmosmManageActivity", 2, "delete from local, Roma Type: " + ((CustomEmotionData)localObject2).RomaingType);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingDBManager.a((CustomEmotionData)localObject2);
          if (!TextUtils.isEmpty(((CustomEmotionData)localObject2).md5)) {
            ((List)localObject1).add(((CustomEmotionData)localObject2).md5);
          }
        }
      }
      if (((List)localObject1).size() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmVipcomicVipComicMqqManager.a((List)localObject1);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFavEmosmManageActivity.jdField_a_of_type_AndroidOsHandler.obtainMessage(207, Integer.valueOf(this.jdField_a_of_type_Int)).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     skb
 * JD-Core Version:    0.7.0.1
 */