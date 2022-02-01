package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.IAnimationMessage;
import localpb.richMsg.RichMsg.PicRec;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb.AnimationImageShow;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb.ResvAttr;

public class MessageForTroopEffectPic
  extends MessageForPic
  implements AIOAnimationControlManager.IAnimationMessage
{
  public int effectId;
  
  public void doParse()
  {
    super.doParse();
    RichMsg.PicRec localPicRec = new RichMsg.PicRec();
    try
    {
      localPicRec.mergeFrom(this.msgData);
      if (localPicRec.bytes_pb_reserved.has())
      {
        CustomFaceExtPb.ResvAttr localResvAttr = new CustomFaceExtPb.ResvAttr();
        try
        {
          localResvAttr.mergeFrom(localPicRec.bytes_pb_reserved.get().toByteArray());
          if (localResvAttr.msg_image_show.has())
          {
            this.effectId = ((CustomFaceExtPb.AnimationImageShow)localResvAttr.msg_image_show.get()).int32_effect_id.get();
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          for (;;)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public String getFriendUin()
  {
    return this.frienduin;
  }
  
  public int getLimitType()
  {
    return 0;
  }
  
  public long getSenderUin()
  {
    return Long.parseLong(this.senderuin);
  }
  
  public long getShmsgseq()
  {
    return this.shmsgseq;
  }
  
  public String getSummaryMsg()
  {
    return HardCodeUtil.a(2131706586);
  }
  
  public boolean isReaded()
  {
    return this.isRead;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTroopEffectPic
 * JD-Core Version:    0.7.0.1
 */