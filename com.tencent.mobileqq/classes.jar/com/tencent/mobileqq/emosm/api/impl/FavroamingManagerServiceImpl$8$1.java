package com.tencent.mobileqq.emosm.api.impl;

import android.os.Message;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService.AddCustomEmotionsCallback;
import com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback.UploadListener;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;
import mqq.os.MqqHandler;

class FavroamingManagerServiceImpl$8$1
  implements EmoAddedAuthCallback.UploadListener
{
  private int jdField_a_of_type_Int;
  
  FavroamingManagerServiceImpl$8$1(FavroamingManagerServiceImpl.8 param8, List paramList) {}
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(paramInt));
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int <= this.jdField_a_of_type_ComTencentMobileqqEmosmApiImplFavroamingManagerServiceImpl$8.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmApiImplFavroamingManagerServiceImpl$8.this$0.notifyFavEmoticonUploaded();
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmApiImplFavroamingManagerServiceImpl$8.jdField_a_of_type_ComTencentMobileqqEmosmApiIFavroamingManagerService$AddCustomEmotionsCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmApiImplFavroamingManagerServiceImpl$8.jdField_a_of_type_ComTencentMobileqqEmosmApiIFavroamingManagerService$AddCustomEmotionsCallback.a(this.jdField_a_of_type_Int / this.jdField_a_of_type_ComTencentMobileqqEmosmApiImplFavroamingManagerServiceImpl$8.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilList);
      }
    }
    if (this.jdField_a_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqEmosmApiImplFavroamingManagerServiceImpl$8.jdField_a_of_type_Int)
    {
      if (!FavroamingManagerServiceImpl.access$1800(this.jdField_a_of_type_ComTencentMobileqqEmosmApiImplFavroamingManagerServiceImpl$8.this$0))
      {
        paramString = (String)this.jdField_a_of_type_ComTencentMobileqqEmosmApiImplFavroamingManagerServiceImpl$8.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
        FavroamingManagerServiceImpl.access$1900(this.jdField_a_of_type_ComTencentMobileqqEmosmApiImplFavroamingManagerServiceImpl$8.this$0, paramString, FavroamingManagerServiceImpl.access$1700(this.jdField_a_of_type_ComTencentMobileqqEmosmApiImplFavroamingManagerServiceImpl$8.this$0));
      }
    }
    else
    {
      paramString = FavroamingManagerServiceImpl.access$2000(this.jdField_a_of_type_ComTencentMobileqqEmosmApiImplFavroamingManagerServiceImpl$8.this$0).getHandler(((IEmosmService)QRoute.api(IEmosmService.class)).getChatActivityClass());
      if (paramString != null) {
        paramString.obtainMessage(10).sendToTarget();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmApiImplFavroamingManagerServiceImpl$8.jdField_a_of_type_ComTencentMobileqqEmosmApiIFavroamingManagerService$AddCustomEmotionsCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmApiImplFavroamingManagerServiceImpl$8.jdField_a_of_type_ComTencentMobileqqEmosmApiIFavroamingManagerService$AddCustomEmotionsCallback.a(this.jdField_a_of_type_JavaUtilList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.FavroamingManagerServiceImpl.8.1
 * JD-Core Version:    0.7.0.1
 */