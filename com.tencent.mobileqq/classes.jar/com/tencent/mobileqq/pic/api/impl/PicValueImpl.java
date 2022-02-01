package com.tencent.mobileqq.pic.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.pic.api.IPicValue;

public class PicValueImpl
  implements IPicValue
{
  public void fillStickInfo(MessageForPic paramMessageForPic)
  {
    Object localObject;
    if (((paramMessageForPic.extLong & 0x4) > 0) && (EmojiStickerManager.f))
    {
      System.currentTimeMillis();
      localObject = paramMessageForPic.getExtInfoFromExtStr("sticker_info");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (paramMessageForPic.msgtype == -2000) {
          paramMessageForPic.msgtype = -2058;
        }
        localObject = StickerInfo.transformFromJson((String)localObject);
        if (localObject != null)
        {
          ((StickerInfo)localObject).isDisplayed = paramMessageForPic.isread;
          paramMessageForPic.stickerInfo = localObject;
          System.currentTimeMillis();
        }
      }
    }
    else if (paramMessageForPic.msgtype == -2058)
    {
      localObject = paramMessageForPic.getExtInfoFromExtStr("sticker_info");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = StickerInfo.transformFromJson((String)localObject);
        if (localObject != null)
        {
          ((StickerInfo)localObject).isDisplayed = paramMessageForPic.isread;
          paramMessageForPic.stickerInfo = localObject;
        }
      }
    }
  }
  
  public int getAioOtherSpaceValue()
  {
    return BaseChatItemLayout.j + 108 + BaseChatItemLayout.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.api.impl.PicValueImpl
 * JD-Core Version:    0.7.0.1
 */