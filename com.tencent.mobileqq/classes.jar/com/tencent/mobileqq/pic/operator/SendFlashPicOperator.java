package com.tencent.mobileqq.pic.operator;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;

public class SendFlashPicOperator
  extends UploadPicOperator
{
  protected void a(MessageForPic paramMessageForPic)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mUseMemoryCache = false;
    localURLDrawableOptions.mLoadingDrawable = ((IPicFlash)QRoute.api(IPicFlash.class)).getFlashPicReadedDrawable();
    paramMessageForPic = ((IPicHelper)QRoute.api(IPicHelper.class)).getDrawable(paramMessageForPic, 65537, null, localURLDrawableOptions);
    localURLDrawableOptions.isFlashPic = true;
    paramMessageForPic.setDecodeHandler(((IPicFlash)QRoute.api(IPicFlash.class)).getFlashPicDecodeHandler());
    paramMessageForPic.downloadImediatly();
  }
  
  protected void a(MessageForPic paramMessageForPic, PicUploadInfo paramPicUploadInfo)
  {
    super.a(paramMessageForPic, paramPicUploadInfo);
    FlashPicHelper.a(paramMessageForPic, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.SendFlashPicOperator
 * JD-Core Version:    0.7.0.1
 */