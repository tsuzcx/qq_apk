package com.tencent.mobileqq.emoticon;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;

final class EmojiStickerManager$3
  extends AsyncTask<Void, Void, Integer>
{
  EmojiStickerManager$3(Bundle paramBundle, MessengerService paramMessengerService, URLDrawable paramURLDrawable, QQAppInterface paramQQAppInterface, PicMessageExtraData paramPicMessageExtraData) {}
  
  protected Integer a(Void... paramVarArgs)
  {
    int i = this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus();
    Integer localInteger = Integer.valueOf(1);
    if (i != 1) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.downloadImediatly(false);
    }
    URLDrawable.removeMemoryCacheByUrl(this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString());
    paramVarArgs = ((MessageForPic)this.jdField_a_of_type_ComTencentImageURLDrawable.getTag()).path;
    paramVarArgs = EmojiStickerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramVarArgs);
    if (paramVarArgs != null)
    {
      AIOGalleryUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, paramVarArgs);
      return Integer.valueOf(2);
    }
    paramVarArgs = this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString();
    if (!AbsDownloader.hasFile(paramVarArgs)) {
      return localInteger;
    }
    paramVarArgs = AbsDownloader.getFile(paramVarArgs);
    if (paramVarArgs != null) {
      paramVarArgs = SecUtil.getFileMd5(paramVarArgs.getAbsolutePath());
    } else {
      paramVarArgs = null;
    }
    if (paramVarArgs != null)
    {
      String str = "";
      if ("".equals(paramVarArgs)) {
        return localInteger;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(AppConstants.SDCARD_IMG_FAVORITE);
      ((StringBuilder)localObject1).append(".nomedia");
      FileUtils.createFileIfNotExits(((StringBuilder)localObject1).toString());
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
      if ((localObject2 != null) && (((PicMessageExtraData)localObject2).isDiyDouTu())) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("_diydoutu@");
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData.emojiId)) {
          str = "0";
        } else {
          str = this.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData.emojiId;
        }
        ((StringBuilder)localObject2).append(str);
        str = ((StringBuilder)localObject2).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(AppConstants.SDCARD_IMG_FAVORITE);
      ((StringBuilder)localObject2).append(DiySecureFileHelper.a((String)localObject1));
      ((StringBuilder)localObject2).append(paramVarArgs);
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append(".jpg");
      paramVarArgs = ((StringBuilder)localObject2).toString();
      try
      {
        this.jdField_a_of_type_ComTencentImageURLDrawable.saveTo(paramVarArgs);
        return Integer.valueOf(EmojiStickerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramVarArgs, null, this.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData));
      }
      catch (IOException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        QLog.d("EmojiStickerManager", 1, paramVarArgs, new Object[0]);
      }
    }
    return localInteger;
  }
  
  protected void a(Integer paramInteger)
  {
    int j = paramInteger.intValue();
    int i = -1;
    if (j == 0) {
      i = 0;
    } else if ((paramInteger.intValue() != 2) && (paramInteger.intValue() == 1)) {
      i = -2;
    }
    paramInteger = new Bundle();
    paramInteger.putInt("result", i);
    this.jdField_a_of_type_AndroidOsBundle.putBundle("response", paramInteger);
    this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiStickerManager.3
 * JD-Core Version:    0.7.0.1
 */