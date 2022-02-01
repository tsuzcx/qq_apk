package com.tencent.mobileqq.data;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype37;

public class MessageForAniSticker
  extends ChatMessage
{
  public static final int STATE_PLAY_NONE = 0;
  public static final int STATE_PLAY_SECOND_FINISH = 2;
  public static final int STATE_PLAY_START = 1;
  public static final int STATE_PLAY_SURPRISE_FINISH = 3;
  public static final String TAG = "MessageForAniSticker";
  public int isMsgPlay = 0;
  public int isMsgRead = 0;
  public int msgVia;
  public String packId;
  public int randomType = 1;
  public String resultId;
  public int sevrId;
  public int sourceType = 1;
  public String stickerId;
  public int stickerType = 1;
  public String surpriseId;
  public String text;
  
  public MessageForAniSticker()
  {
    this.msgtype = -8018;
    this.isFlowMessage = false;
  }
  
  private void updateMsgRecordStatus()
  {
    if (this.isread) {
      setIsMsgRead(1);
    }
  }
  
  public boolean checkMsgCanPreview()
  {
    boolean bool3 = isAniStickerRandom();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (bool3)
    {
      int i = this.isMsgPlay;
      bool1 = bool2;
      if (i != 2)
      {
        if (i == 3) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public void deserializeMsgBody(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length < 1) {
        return;
      }
      hummer_commelem.MsgElemInfo_servtype37 localMsgElemInfo_servtype37 = new hummer_commelem.MsgElemInfo_servtype37();
      try
      {
        localMsgElemInfo_servtype37.mergeFrom(paramArrayOfByte);
        this.packId = localMsgElemInfo_servtype37.bytes_packid.get().toStringUtf8();
        this.stickerId = localMsgElemInfo_servtype37.bytes_stickerid.get().toStringUtf8();
        this.sevrId = localMsgElemInfo_servtype37.uint32_qsid.get();
        this.resultId = localMsgElemInfo_servtype37.bytes_resultid.get().toStringUtf8();
        this.surpriseId = localMsgElemInfo_servtype37.bytes_surpriseid.get().toStringUtf8();
        this.text = localMsgElemInfo_servtype37.bytes_text.get().toStringUtf8();
        this.randomType = localMsgElemInfo_servtype37.uint32_randomtype.get();
        this.sourceType = localMsgElemInfo_servtype37.uint32_sourcetype.get();
        this.stickerType = localMsgElemInfo_servtype37.uint32_stickertype.get();
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public void deserializeMsgData(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length < 3) {
        return;
      }
      int i = paramArrayOfByte[(paramArrayOfByte.length - 1)];
      int j = paramArrayOfByte[(paramArrayOfByte.length - 2)];
      this.isMsgPlay = (i & 0xFF);
      this.isMsgRead = (j & 0xFF);
      byte[] arrayOfByte = new byte[paramArrayOfByte.length - 2];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, arrayOfByte.length);
      deserializeMsgBody(arrayOfByte);
    }
  }
  
  protected void doParse()
  {
    try
    {
      deserializeMsgData(this.msgData);
      return;
    }
    finally {}
  }
  
  public int getAniStickerType()
  {
    return this.sourceType;
  }
  
  public String getSummaryMsg()
  {
    return QQSysFaceUtil.getFaceString(QQSysFaceUtil.convertToLocal(this.sevrId));
  }
  
  public boolean isAniStickerRandom()
  {
    return this.stickerType == 2;
  }
  
  public boolean isFollowMessage()
  {
    return super.isFollowMessage();
  }
  
  public boolean isMsgPlayState()
  {
    int i = this.isMsgPlay;
    return (i == 2) || (i == 3);
  }
  
  public boolean isMsgReadState()
  {
    return this.isMsgRead == 1;
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public boolean needVipBubble()
  {
    return false;
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    try
    {
      this.msgData = serializeMsgData();
      return;
    }
    finally {}
  }
  
  public byte[] serializeMsgBody()
  {
    hummer_commelem.MsgElemInfo_servtype37 localMsgElemInfo_servtype37 = new hummer_commelem.MsgElemInfo_servtype37();
    localMsgElemInfo_servtype37.setHasFlag(true);
    PBBytesField localPBBytesField = localMsgElemInfo_servtype37.bytes_packid;
    String str2 = this.packId;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localPBBytesField.set(ByteStringMicro.copyFromUtf8(str1));
    localPBBytesField = localMsgElemInfo_servtype37.bytes_stickerid;
    str2 = this.stickerId;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localPBBytesField.set(ByteStringMicro.copyFromUtf8(str1));
    localMsgElemInfo_servtype37.uint32_qsid.set(this.sevrId);
    localPBBytesField = localMsgElemInfo_servtype37.bytes_resultid;
    str2 = this.resultId;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localPBBytesField.set(ByteStringMicro.copyFromUtf8(str1));
    localPBBytesField = localMsgElemInfo_servtype37.bytes_surpriseid;
    str2 = this.surpriseId;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localPBBytesField.set(ByteStringMicro.copyFromUtf8(str1));
    localPBBytesField = localMsgElemInfo_servtype37.bytes_text;
    str2 = this.text;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localPBBytesField.set(ByteStringMicro.copyFromUtf8(str1));
    localMsgElemInfo_servtype37.uint32_randomtype.set(this.randomType);
    localMsgElemInfo_servtype37.uint32_sourcetype.set(this.sourceType);
    localMsgElemInfo_servtype37.uint32_stickertype.set(this.stickerType);
    return localMsgElemInfo_servtype37.toByteArray();
  }
  
  public byte[] serializeMsgData()
  {
    byte[] arrayOfByte1 = serializeMsgBody();
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 2];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    arrayOfByte2[(arrayOfByte2.length - 1)] = ((byte)this.isMsgPlay);
    arrayOfByte2[(arrayOfByte2.length - 2)] = ((byte)this.isMsgRead);
    return arrayOfByte2;
  }
  
  public void setIsMsgRead(int paramInt)
  {
    if (this.isMsgRead != paramInt) {
      this.isMsgRead = paramInt;
    }
  }
  
  @NonNull
  public String toString()
  {
    return String.format("msgseq:%s uid:%s sevrId=%s packId=%s stickerId=%s stickerType=%s sourceType=%s text=%s surpriseId=%s resultId=%s]", new Object[] { Long.valueOf(this.msgseq), Long.valueOf(this.msgUid), Integer.valueOf(this.sevrId), this.packId, this.stickerId, Integer.valueOf(this.stickerType), Integer.valueOf(this.sourceType), this.text, this.surpriseId, this.resultId });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForAniSticker
 * JD-Core Version:    0.7.0.1
 */