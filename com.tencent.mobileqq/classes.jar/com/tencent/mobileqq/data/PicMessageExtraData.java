package com.tencent.mobileqq.data;

import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb.AnimationImageShow;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb.ResvAttr;
import tencent.im.msg.hummer.resv6.NotOnlineImageExtPb.ResvAttr;

public class PicMessageExtraData
{
  public CustomFaceExtPb.AnimationImageShow animationImageShow;
  public int customFaceType;
  public String doutuSupplier = "";
  public String emojiId;
  public String emojiPkgId;
  public int imageBizType;
  public EmojiStickerManager.StickerInfo stickerInfo;
  
  public PicMessageExtraData() {}
  
  public PicMessageExtraData(CustomFaceExtPb.ResvAttr paramResvAttr)
  {
    this.imageBizType = paramResvAttr.uint32_image_biz_type.get();
    this.customFaceType = paramResvAttr.uint32_customface_type.get();
    this.emojiPkgId = String.valueOf(paramResvAttr.uint32_emoji_packageid.get());
    this.emojiId = String.valueOf(paramResvAttr.uint32_emoji_id.get());
    this.doutuSupplier = String.valueOf(paramResvAttr.string_doutu_suppliers.get());
    this.animationImageShow = ((CustomFaceExtPb.AnimationImageShow)paramResvAttr.msg_image_show.get());
  }
  
  public PicMessageExtraData(NotOnlineImageExtPb.ResvAttr paramResvAttr)
  {
    this.imageBizType = paramResvAttr.uint32_image_biz_type.get();
    this.customFaceType = paramResvAttr.uint32_customface_type.get();
    this.emojiPkgId = String.valueOf(paramResvAttr.uint32_emoji_packageid.get());
    this.emojiId = String.valueOf(paramResvAttr.uint32_emoji_id.get());
    this.doutuSupplier = paramResvAttr.string_doutu_suppliers.get();
  }
  
  public CustomFaceExtPb.ResvAttr getCustomFaceResvAttr()
  {
    CustomFaceExtPb.ResvAttr localResvAttr = new CustomFaceExtPb.ResvAttr();
    localResvAttr.uint32_image_biz_type.set(this.imageBizType);
    localResvAttr.uint32_customface_type.set(this.customFaceType);
    localResvAttr.string_doutu_suppliers.set(this.doutuSupplier);
    try
    {
      localResvAttr.uint32_emoji_packageid.set(Integer.parseInt(this.emojiPkgId));
      localResvAttr.uint32_emoji_id.set(Integer.parseInt(this.emojiId));
      if ((this.animationImageShow != null) && (this.animationImageShow.has())) {
        localResvAttr.msg_image_show.set(this.animationImageShow);
      }
      return localResvAttr;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
      }
    }
  }
  
  public NotOnlineImageExtPb.ResvAttr getOfflineImageResvAttr()
  {
    NotOnlineImageExtPb.ResvAttr localResvAttr = new NotOnlineImageExtPb.ResvAttr();
    localResvAttr.uint32_image_biz_type.set(this.imageBizType);
    localResvAttr.uint32_customface_type.set(this.customFaceType);
    localResvAttr.string_doutu_suppliers.set(this.doutuSupplier);
    try
    {
      if (this.emojiPkgId != null) {
        localResvAttr.uint32_emoji_packageid.set(Integer.parseInt(this.emojiPkgId));
      }
      if (this.emojiId != null) {
        localResvAttr.uint32_emoji_id.set(Integer.parseInt(this.emojiId));
      }
      return localResvAttr;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
    }
    return localResvAttr;
  }
  
  public boolean isCustomFace()
  {
    return this.imageBizType == 1;
  }
  
  public boolean isDiyDouTu()
  {
    return (isCustomFace()) && (2 == this.customFaceType);
  }
  
  public boolean isHotPics()
  {
    return this.imageBizType == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.PicMessageExtraData
 * JD-Core Version:    0.7.0.1
 */