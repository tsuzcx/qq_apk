package com.tencent.mobileqq.emosm.favroaming;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EmoAddedAuthCallback$1
  implements View.OnClickListener
{
  EmoAddedAuthCallback$1(EmoAddedAuthCallback paramEmoAddedAuthCallback, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    IFavroamingDBManagerService localIFavroamingDBManagerService = (IFavroamingDBManagerService)this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoAddedAuthCallback.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
    CustomEmotionData localCustomEmotionData = this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoAddedAuthCallback.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
    FavoriteEmoticonInfo localFavoriteEmoticonInfo = new FavoriteEmoticonInfo();
    localFavoriteEmoticonInfo.type = 4;
    localFavoriteEmoticonInfo.path = localIFavroamingDBManagerService.getCustomEmoticonPath(localCustomEmotionData);
    localFavoriteEmoticonInfo.srcType = 2;
    localFavoriteEmoticonInfo.eId = localCustomEmotionData.eId;
    localFavoriteEmoticonInfo.url = localCustomEmotionData.url;
    localFavoriteEmoticonInfo.roamingType = localCustomEmotionData.RomaingType;
    localFavoriteEmoticonInfo.emoId = localCustomEmotionData.emoId;
    localFavoriteEmoticonInfo.resID = localCustomEmotionData.resid;
    ((IEmosmService)QRoute.api(IEmosmService.class)).enterEmotionPreview(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoAddedAuthCallback.jdField_a_of_type_AndroidContentContext, localFavoriteEmoticonInfo, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback.1
 * JD-Core Version:    0.7.0.1
 */