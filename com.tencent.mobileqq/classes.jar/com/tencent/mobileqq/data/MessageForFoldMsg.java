package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import localpb.richMsg.RichMsg.FoldMsg;

public class MessageForFoldMsg
  extends MessageForText
{
  public boolean foldFlag;
  public boolean foldFlagTemp;
  public String redBagId;
  public String redBagIndex;
  
  protected void doParse()
  {
    doParse(false);
  }
  
  public void init(boolean paramBoolean1, String paramString1, String paramString2, long paramLong, boolean paramBoolean2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      this.redBagId = paramString1;
      this.redBagIndex = paramString2;
      this.mPasswdRedBagSender = paramLong;
      this.foldFlag = paramBoolean1;
      if (paramBoolean2) {
        if (!this.foldFlag) {
          break label62;
        }
      }
    }
    label62:
    for (this.msgtype = -2006;; this.msgtype = -1000)
    {
      saveExtInfoToExtStr("redbag_fold_msg", "true");
      return;
      paramString1 = "";
      break;
    }
  }
  
  public boolean isSupportFTS()
  {
    if (!this.foldFlag) {
      return super.isSupportFTS();
    }
    return false;
  }
  
  public void postRead()
  {
    boolean bool = true;
    if (this.istroop != 1)
    {
      super.postRead();
      return;
    }
    RichMsg.FoldMsg localFoldMsg = new RichMsg.FoldMsg();
    for (;;)
    {
      try
      {
        localFoldMsg.mergeFrom(this.msgData);
        if (localFoldMsg.fold_flags.get() != 1) {
          break label144;
        }
        this.foldFlag = bool;
        this.redBagId = localFoldMsg.redbag_id.get().toStringUtf8();
        this.msg = localFoldMsg.msg_content.get().toStringUtf8();
        this.mPasswdRedBagSender = localFoldMsg.redbag_sender_uin.get();
        this.redBagIndex = localFoldMsg.redbag_index.get().toStringUtf8();
        init(this.foldFlag, this.redBagId, this.redBagIndex, this.mPasswdRedBagSender, false);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("msgFold", 2, "MessageForFoldMsg postRead error ", localException);
      return;
      label144:
      bool = false;
    }
  }
  
  public void prewrite()
  {
    int i = 1;
    if (this.istroop != 1)
    {
      super.prewrite();
      return;
    }
    RichMsg.FoldMsg localFoldMsg = new RichMsg.FoldMsg();
    PBUInt32Field localPBUInt32Field = localFoldMsg.fold_flags;
    if (this.foldFlag) {}
    for (;;)
    {
      localPBUInt32Field.set(i);
      localFoldMsg.redbag_sender_uin.set(this.mPasswdRedBagSender);
      localFoldMsg.redbag_id.set(ByteStringMicro.copyFromUtf8(this.redBagId));
      localFoldMsg.msg_content.set(ByteStringMicro.copyFromUtf8(this.msg));
      localFoldMsg.redbag_index.set(ByteStringMicro.copyFromUtf8(this.redBagIndex));
      this.msgData = localFoldMsg.toByteArray();
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForFoldMsg
 * JD-Core Version:    0.7.0.1
 */