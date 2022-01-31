package com.tencent.mobileqq.data;

import ajyc;
import akwb;
import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.msg.im_msg_body.MarketFace;

public class MessageForMarketFace
  extends ChatMessage
{
  public static final String TAG = "MessageForMarketFace";
  public MarkFaceMessage mMarkFaceMessage;
  public int msgVia;
  public boolean needToPlay;
  public float playProgress;
  public String sendFaceName;
  public String timeStr;
  
  public static MessageForMarketFace parsePb(im_msg_body.MarketFace paramMarketFace)
  {
    MarkFaceMessage localMarkFaceMessage = new MarkFaceMessage();
    localMarkFaceMessage.cFaceInfo = paramMarketFace.uint32_face_info.get();
    localMarkFaceMessage.cSubType = paramMarketFace.uint32_sub_type.get();
    localMarkFaceMessage.dwMSGItemType = paramMarketFace.uint32_item_type.get();
    localMarkFaceMessage.dwTabID = paramMarketFace.uint32_tab_id.get();
    localMarkFaceMessage.sbfKey = paramMarketFace.bytes_key.get().toByteArray();
    localMarkFaceMessage.sbufID = paramMarketFace.bytes_face_id.get().toByteArray();
    localMarkFaceMessage.mediaType = paramMarketFace.uint32_media_type.get();
    localMarkFaceMessage.mobileparam = paramMarketFace.bytes_mobileparam.get().toByteArray();
    localMarkFaceMessage.resvAttr = paramMarketFace.bytes_pb_reserve.get().toByteArray();
    paramMarketFace = new MessageForMarketFace();
    paramMarketFace.mMarkFaceMessage = localMarkFaceMessage;
    return paramMarketFace;
  }
  
  protected void doParse()
  {
    try
    {
      this.mMarkFaceMessage = ((MarkFaceMessage)akwb.a(this.msgData));
      if ((EmojiStickerManager.e) && (this.mMarkFaceMessage != null) && (this.mMarkFaceMessage.stickerInfo != null))
      {
        if (this.msgtype == -2007) {
          this.msgtype = -2058;
        }
        this.mMarkFaceMessage.stickerInfo.isDisplayed = this.isread;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MessageForMarketFace", 1, "doParse: ", localException);
    }
  }
  
  public im_msg_body.MarketFace getSerialPB()
  {
    im_msg_body.MarketFace localMarketFace = new im_msg_body.MarketFace();
    if (this.mMarkFaceMessage.sbufID != null) {
      localMarketFace.bytes_face_id.set(ByteStringMicro.copyFrom(this.mMarkFaceMessage.sbufID));
    }
    if (this.mMarkFaceMessage.sbfKey != null) {
      localMarketFace.bytes_key.set(ByteStringMicro.copyFrom(this.mMarkFaceMessage.sbfKey));
    }
    localMarketFace.uint32_face_info.set(this.mMarkFaceMessage.cFaceInfo);
    localMarketFace.uint32_item_type.set(this.mMarkFaceMessage.dwMSGItemType);
    localMarketFace.uint32_sub_type.set(this.mMarkFaceMessage.cSubType);
    localMarketFace.uint32_tab_id.set(this.mMarkFaceMessage.dwTabID);
    localMarketFace.uint32_media_type.set(this.mMarkFaceMessage.mediaType);
    localMarketFace.bytes_mobileparam.set(ByteStringMicro.copyFrom(this.mMarkFaceMessage.mobileparam));
    localMarketFace.bytes_pb_reserve.set(ByteStringMicro.copyFrom(this.mMarkFaceMessage.resvAttr));
    return localMarketFace;
  }
  
  public String getSummaryMsg()
  {
    if ((this.mMarkFaceMessage != null) && (!TextUtils.isEmpty(this.mMarkFaceMessage.faceName)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[").append(this.mMarkFaceMessage.faceName).append("]");
      return localStringBuilder.toString();
    }
    return ajyc.a(2131706589);
  }
  
  public boolean isNewSoundType()
  {
    return (this.mMarkFaceMessage != null) && (this.mMarkFaceMessage.voicePrintItems != null) && (!this.mMarkFaceMessage.voicePrintItems.isEmpty());
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public boolean needVipBubble()
  {
    return false;
  }
  
  public void postRead()
  {
    parse();
  }
  
  public void prewrite()
  {
    if (this.mMarkFaceMessage != null) {}
    try
    {
      this.msgData = akwb.a(this.mMarkFaceMessage);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MessageForMarketFace", 1, "prewrite: ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForMarketFace
 * JD-Core Version:    0.7.0.1
 */