package com.tencent.mobileqq.emosm.favroaming;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IEmoticonFromGroupDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.URL;
import java.util.List;

class EmoticonFromGroupManager$5$1
  implements URLDrawable.URLDrawableListener
{
  EmoticonFromGroupManager$5$1(EmoticonFromGroupManager.5 param5, URLDrawable paramURLDrawable, CustomEmotionData paramCustomEmotionData, IFavroamingManagerService paramIFavroamingManagerService, IFavroamingDBManagerService paramIFavroamingDBManagerService) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    EmoticonFromGroupManager.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager$5.this$0).getUploadDrawableList().remove(this.jdField_a_of_type_ComTencentImageURLDrawable);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    EmoticonFromGroupManager.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager$5.this$0).getUploadDrawableList().remove(this.jdField_a_of_type_ComTencentImageURLDrawable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    EmoticonFromGroupManager.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager$5.this$0).getUploadDrawableList().remove(this.jdField_a_of_type_ComTencentImageURLDrawable);
    paramURLDrawable = this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager$5.this$0.a(this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString());
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager$5.this$0.a(paramURLDrawable)) {
      return;
    }
    String str = EmoticonFromGroupManager.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager$5.this$0, paramURLDrawable);
    if (!"".equals(str))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
      ((CustomEmotionData)localObject).emoPath = str;
      ((CustomEmotionData)localObject).md5 = paramURLDrawable;
      if (!"".equals(str)) {
        try
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onLoadSuccessed upload emo ");
            ((StringBuilder)localObject).append(paramURLDrawable);
            QLog.i("EmoticonFromGroup_Manager", 4, ((StringBuilder)localObject).toString());
          }
          this.jdField_a_of_type_ComTencentImageURLDrawable.saveTo(str);
          this.jdField_a_of_type_ComTencentMobileqqEmosmApiIFavroamingManagerService.syncUpload(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
          this.jdField_a_of_type_ComTencentMobileqqEmosmApiIFavroamingDBManagerService.insertCustomEmotion(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
          return;
        }
        catch (IOException paramURLDrawable)
        {
          paramURLDrawable.printStackTrace();
          QLog.d("EmoticonFromGroup_Manager", 1, paramURLDrawable, new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager.5.1
 * JD-Core Version:    0.7.0.1
 */