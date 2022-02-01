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
    int i = this.c.getStatus();
    Integer localInteger = Integer.valueOf(1);
    if (i != 1) {
      this.c.downloadImediatly(false);
    }
    URLDrawable.removeMemoryCacheByUrl(this.c.getURL().toString());
    paramVarArgs = ((MessageForPic)this.c.getTag()).path;
    paramVarArgs = EmojiStickerManager.a(this.d, paramVarArgs);
    if (paramVarArgs != null)
    {
      AIOGalleryUtils.a(this.d, null, paramVarArgs);
      return Integer.valueOf(2);
    }
    paramVarArgs = this.c.getURL().toString();
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
      localObject1 = this.d.getCurrentAccountUin();
      Object localObject2 = this.e;
      if ((localObject2 != null) && (((PicMessageExtraData)localObject2).isDiyDouTu())) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("_diydoutu@");
        if (TextUtils.isEmpty(this.e.emojiId)) {
          str = "0";
        } else {
          str = this.e.emojiId;
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
        this.c.saveTo(paramVarArgs);
        return Integer.valueOf(EmojiStickerManager.a(this.d, paramVarArgs, null, this.e));
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
    this.a.putBundle("response", paramInteger);
    this.b.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiStickerManager.3
 * JD-Core Version:    0.7.0.1
 */