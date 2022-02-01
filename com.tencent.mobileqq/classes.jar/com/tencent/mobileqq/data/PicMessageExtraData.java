package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
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
  public int from = 0;
  public String iconUrl;
  public int imageBizType;
  public String mAdEmoDescStr;
  public String mAdEmoJumpUrl;
  public String mTemplateId;
  public String mTemplateName;
  public String packageName;
  public String source;
  public EmojiStickerManager.StickerInfo stickerInfo;
  public String textSummary = "";
  public String webUrl;
  
  public PicMessageExtraData() {}
  
  public PicMessageExtraData(CustomFaceExtPb.ResvAttr paramResvAttr)
  {
    this.imageBizType = paramResvAttr.uint32_image_biz_type.get();
    this.customFaceType = paramResvAttr.uint32_customface_type.get();
    this.emojiPkgId = String.valueOf(paramResvAttr.uint32_emoji_packageid.get());
    this.emojiId = String.valueOf(paramResvAttr.uint32_emoji_id.get());
    this.doutuSupplier = String.valueOf(paramResvAttr.string_doutu_suppliers.get());
    this.animationImageShow = ((CustomFaceExtPb.AnimationImageShow)paramResvAttr.msg_image_show.get());
    if (paramResvAttr.bytes_text_summary.has()) {
      this.textSummary = paramResvAttr.bytes_text_summary.get().toStringUtf8();
    }
    this.from = paramResvAttr.uint32_emoji_from.get();
    this.source = paramResvAttr.string_emoji_source.get();
    this.webUrl = paramResvAttr.string_emoji_webUrl.get();
    this.iconUrl = paramResvAttr.string_emoji_iconUrl.get();
    this.packageName = paramResvAttr.string_emoji_marketFaceName.get();
    this.mTemplateId = paramResvAttr.string_camera_capture_templateinfo.get();
    this.mTemplateName = paramResvAttr.string_camera_capture_materialname.get();
    this.mAdEmoJumpUrl = paramResvAttr.string_ad_emo_jump_url.get();
    this.mAdEmoDescStr = paramResvAttr.string_ad_emo_desc_str.get();
  }
  
  public PicMessageExtraData(NotOnlineImageExtPb.ResvAttr paramResvAttr)
  {
    this.imageBizType = paramResvAttr.uint32_image_biz_type.get();
    this.customFaceType = paramResvAttr.uint32_customface_type.get();
    this.emojiPkgId = String.valueOf(paramResvAttr.uint32_emoji_packageid.get());
    this.emojiId = String.valueOf(paramResvAttr.uint32_emoji_id.get());
    this.doutuSupplier = paramResvAttr.string_doutu_suppliers.get();
    if (paramResvAttr.bytes_text_summary.has()) {
      this.textSummary = paramResvAttr.bytes_text_summary.get().toStringUtf8();
    }
    this.from = paramResvAttr.uint32_emoji_from.get();
    this.source = paramResvAttr.string_emoji_source.get();
    this.webUrl = paramResvAttr.string_emoji_webUrl.get();
    this.iconUrl = paramResvAttr.string_emoji_iconUrl.get();
    this.packageName = paramResvAttr.string_emoji_marketFaceName.get();
    this.mTemplateId = paramResvAttr.string_camera_capture_templateinfo.get();
    this.mTemplateName = paramResvAttr.string_camera_capture_materialname.get();
    this.mAdEmoJumpUrl = paramResvAttr.string_ad_emo_jump_url.get();
    this.mAdEmoDescStr = paramResvAttr.string_ad_emo_desc_str.get();
  }
  
  public CustomFaceExtPb.ResvAttr getCustomFaceResvAttr()
  {
    CustomFaceExtPb.ResvAttr localResvAttr = new CustomFaceExtPb.ResvAttr();
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
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    if ((this.animationImageShow != null) && (this.animationImageShow.has())) {
      localResvAttr.msg_image_show.set(this.animationImageShow);
    }
    if (!TextUtils.isEmpty(this.textSummary)) {
      localResvAttr.bytes_text_summary.set(ByteStringMicro.copyFromUtf8(this.textSummary));
    }
    localResvAttr.uint32_emoji_from.set(this.from);
    if (!TextUtils.isEmpty(this.source)) {
      localResvAttr.string_emoji_source.set(this.source);
    }
    if (!TextUtils.isEmpty(this.webUrl)) {
      localResvAttr.string_emoji_webUrl.set(this.webUrl);
    }
    if (!TextUtils.isEmpty(this.iconUrl)) {
      localResvAttr.string_emoji_iconUrl.set(this.iconUrl);
    }
    if (!TextUtils.isEmpty(this.packageName)) {
      localResvAttr.string_emoji_marketFaceName.set(this.packageName);
    }
    if (!TextUtils.isEmpty(this.mTemplateId)) {
      localResvAttr.string_camera_capture_templateinfo.set(this.mTemplateId);
    }
    if (!TextUtils.isEmpty(this.mTemplateName)) {
      localResvAttr.string_camera_capture_materialname.set(this.mTemplateName);
    }
    if (!TextUtils.isEmpty(this.mAdEmoJumpUrl)) {
      localResvAttr.string_ad_emo_jump_url.set(this.mAdEmoJumpUrl);
    }
    if (!TextUtils.isEmpty(this.mAdEmoDescStr)) {
      localResvAttr.string_ad_emo_desc_str.set(this.mAdEmoDescStr);
    }
    return localResvAttr;
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
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    if (!TextUtils.isEmpty(this.textSummary)) {
      localResvAttr.bytes_text_summary.set(ByteStringMicro.copyFromUtf8(this.textSummary));
    }
    localResvAttr.uint32_emoji_from.set(this.from);
    if (!TextUtils.isEmpty(this.source)) {
      localResvAttr.string_emoji_source.set(this.source);
    }
    if (!TextUtils.isEmpty(this.webUrl)) {
      localResvAttr.string_emoji_webUrl.set(this.webUrl);
    }
    if (!TextUtils.isEmpty(this.iconUrl)) {
      localResvAttr.string_emoji_iconUrl.set(this.iconUrl);
    }
    if (!TextUtils.isEmpty(this.packageName)) {
      localResvAttr.string_emoji_marketFaceName.set(this.packageName);
    }
    if (!TextUtils.isEmpty(this.mTemplateId)) {
      localResvAttr.string_camera_capture_templateinfo.set(this.mTemplateId);
    }
    if (!TextUtils.isEmpty(this.mTemplateName)) {
      localResvAttr.string_camera_capture_materialname.set(this.mTemplateName);
    }
    if (!TextUtils.isEmpty(this.mAdEmoJumpUrl)) {
      localResvAttr.string_ad_emo_jump_url.set(this.mAdEmoJumpUrl);
    }
    if (!TextUtils.isEmpty(this.mAdEmoDescStr)) {
      localResvAttr.string_ad_emo_desc_str.set(this.mAdEmoDescStr);
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
  
  public boolean isDoutu()
  {
    return this.imageBizType == 3;
  }
  
  public boolean isEmotion()
  {
    return (isCustomFace()) || (isStickerPics()) || (isStickerAdPic()) || (isDiyDouTu()) || (isHotPics()) || (isZhitu()) || (isSelfieFace()) || (isDoutu()) || (isRelatedEmo()) || (isHotSearch());
  }
  
  public boolean isHotPics()
  {
    return this.imageBizType == 2;
  }
  
  public boolean isHotSearch()
  {
    return this.imageBizType == 13;
  }
  
  public boolean isRelatedEmo()
  {
    return this.imageBizType == 10;
  }
  
  public boolean isSelfieFace()
  {
    return this.imageBizType == 8;
  }
  
  public boolean isStickerAdPic()
  {
    return this.imageBizType == 9;
  }
  
  public boolean isStickerPics()
  {
    return this.imageBizType == 7;
  }
  
  public boolean isZhitu()
  {
    return this.imageBizType == 4;
  }
  
  public void setAdEmoDescStr(String paramString)
  {
    this.mAdEmoDescStr = paramString;
    if ((QLog.isColorLevel()) && (paramString != null)) {
      QLog.d("PicMessageExtraData", 0, "adEmoDescStr, length = " + paramString.length());
    }
  }
  
  public void setAdEmoJumpUrl(String paramString)
  {
    this.mAdEmoJumpUrl = paramString;
    if ((QLog.isColorLevel()) && (paramString != null)) {
      QLog.d("PicMessageExtraData", 0, "setAdEmoJumpUrl, length = " + paramString.length());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.PicMessageExtraData
 * JD-Core Version:    0.7.0.1
 */