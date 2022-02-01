package com.tencent.mobileqq.emosm.favroaming;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EmoAddedAuthCallback$1
  implements View.OnClickListener
{
  EmoAddedAuthCallback$1(EmoAddedAuthCallback paramEmoAddedAuthCallback, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    FavroamingDBManager localFavroamingDBManager = (FavroamingDBManager)this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoAddedAuthCallback.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
    CustomEmotionData localCustomEmotionData = this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoAddedAuthCallback.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
    FavoriteEmoticonInfo localFavoriteEmoticonInfo = new FavoriteEmoticonInfo();
    localFavoriteEmoticonInfo.type = 4;
    localFavoriteEmoticonInfo.path = localFavroamingDBManager.a(localCustomEmotionData);
    localFavoriteEmoticonInfo.src_type = 2;
    localFavoriteEmoticonInfo.eId = localCustomEmotionData.eId;
    localFavoriteEmoticonInfo.url = localCustomEmotionData.url;
    localFavoriteEmoticonInfo.roamingType = localCustomEmotionData.RomaingType;
    localFavoriteEmoticonInfo.emoId = localCustomEmotionData.emoId;
    localFavoriteEmoticonInfo.resID = localCustomEmotionData.resid;
    AIOEmotionFragment.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoAddedAuthCallback.jdField_a_of_type_AndroidContentContext, localFavoriteEmoticonInfo, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback.1
 * JD-Core Version:    0.7.0.1
 */