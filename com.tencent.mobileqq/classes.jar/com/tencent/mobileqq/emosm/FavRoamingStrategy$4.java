package com.tencent.mobileqq.emosm;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FunnyPicHelperConstant;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class FavRoamingStrategy$4
  implements Runnable
{
  FavRoamingStrategy$4(FavRoamingStrategy paramFavRoamingStrategy, Object paramObject, IVipComicMqqManagerService paramIVipComicMqqManagerService, int paramInt) {}
  
  public void run()
  {
    Object localObject2 = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.i("FavRoamingStrategy", 2, "Call getEmoticonDataList-2 from doDelete.");
    }
    Object localObject1 = this.this$0.a().getEmoticonDataList();
    Object localObject3;
    Object localObject4;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject3 = ((List)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (CustomEmotionData)((Iterator)localObject3).next();
        if (localObject4 != null)
        {
          localObject1 = this.jdField_a_of_type_JavaLangObject;
          if ((localObject1 instanceof PicEmoticonInfo))
          {
            localObject1 = ((PicEmoticonInfo)localObject1).emoticon;
            if ((!TextUtils.isEmpty(((CustomEmotionData)localObject4).eId)) && (localObject1 != null) && (((CustomEmotionData)localObject4).eId.equals(((Emoticon)localObject1).eId))) {
              ((List)localObject2).add(localObject4);
            }
          }
          else if ((localObject1 instanceof FavoriteEmoticonInfo))
          {
            if (this.this$0.a.contains(this.jdField_a_of_type_JavaLangObject))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(AppConstants.SDCARD_IMG_FAVORITE);
              ((StringBuilder)localObject1).append(FunnyPicHelperConstant.a(((FavoriteEmoticonInfo)this.jdField_a_of_type_JavaLangObject).path));
              localObject1 = ((StringBuilder)localObject1).toString();
            }
            else
            {
              localObject1 = ((FavoriteEmoticonInfo)this.jdField_a_of_type_JavaLangObject).path;
            }
            if ((!TextUtils.isEmpty(((CustomEmotionData)localObject4).emoPath)) && (((CustomEmotionData)localObject4).emoPath.equals(localObject1))) {
              ((List)localObject2).add(localObject4);
            }
            if ((TextUtils.isEmpty(((CustomEmotionData)localObject4).emoPath)) && ("init".equals(((CustomEmotionData)localObject4).RomaingType)))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("delete failed, path is null, state is init. data: ");
              ((StringBuilder)localObject1).append(localObject4);
              QLog.e("FavRoamingStrategy", 2, ((StringBuilder)localObject1).toString());
            }
          }
        }
      }
    }
    if (((List)localObject2).size() > 0)
    {
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (CustomEmotionData)((Iterator)localObject2).next();
        if (!TextUtils.isEmpty(((CustomEmotionData)localObject3).resid))
        {
          ((CustomEmotionData)localObject3).RomaingType = "needDel";
          this.this$0.a().updateCustomEmotion((CustomEmotionBase)localObject3);
          FavRoamingStrategy.a(this.this$0).add(((CustomEmotionData)localObject3).resid);
          if (!TextUtils.isEmpty(((CustomEmotionData)localObject3).md5)) {
            ((List)localObject1).add(((CustomEmotionData)localObject3).md5);
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("delete from local, Roma Type: ");
            ((StringBuilder)localObject4).append(((CustomEmotionData)localObject3).RomaingType);
            QLog.d("FavRoamingStrategy", 2, ((StringBuilder)localObject4).toString());
          }
          this.this$0.a().deleteCustomEmotion((CustomEmotionBase)localObject3);
          if (!TextUtils.isEmpty(((CustomEmotionData)localObject3).md5)) {
            ((List)localObject1).add(((CustomEmotionData)localObject3).md5);
          }
        }
      }
      if (((List)localObject1).size() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmApiIVipComicMqqManagerService.delComicEmoticonList((List)localObject1);
      }
    }
    else
    {
      QLog.e("FavRoamingStrategy", 1, "delete failed, not find original emotion data");
    }
    if (FavRoamingStrategy.a(this.this$0) != null) {
      FavRoamingStrategy.a(this.this$0).obtainMessage(207, Integer.valueOf(this.jdField_a_of_type_Int)).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavRoamingStrategy.4
 * JD-Core Version:    0.7.0.1
 */