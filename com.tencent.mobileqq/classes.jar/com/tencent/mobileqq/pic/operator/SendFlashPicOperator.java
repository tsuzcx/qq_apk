package com.tencent.mobileqq.pic.operator;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;

public class SendFlashPicOperator
  extends UploadPicOperator
{
  protected void a(MessageForPic paramMessageForPic)
  {
    if ((HotChatHelper.a(paramMessageForPic)) || (FlashPicHelper.a(paramMessageForPic)))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseMemoryCache = false;
      localURLDrawableOptions.mLoadingDrawable = FlashPicItemBuilder.a(BaseApplicationImpl.getApplication().getResources());
      URLDrawable localURLDrawable = URLDrawableHelper.getDrawable(paramMessageForPic, 65537, null, localURLDrawableOptions);
      if (FlashPicHelper.a(paramMessageForPic)) {
        localURLDrawableOptions.isFlashPic = true;
      }
      localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.o);
      localURLDrawable.downloadImediatly();
    }
  }
  
  protected void a(MessageForPic paramMessageForPic, PicUploadInfo paramPicUploadInfo)
  {
    super.a(paramMessageForPic, paramPicUploadInfo);
    if (paramPicUploadInfo.a == 1039) {
      HotChatHelper.a(paramMessageForPic, false);
    }
    if (paramPicUploadInfo.a == 1040) {
      FlashPicHelper.a(paramMessageForPic, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.SendFlashPicOperator
 * JD-Core Version:    0.7.0.1
 */