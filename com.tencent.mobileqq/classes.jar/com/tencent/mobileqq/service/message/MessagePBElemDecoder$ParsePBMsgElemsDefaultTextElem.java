package com.tencent.mobileqq.service.message;

import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.Face;
import tencent.im.msg.im_msg_body.OnlineImage;
import tencent.im.msg.im_msg_body.SmallEmoji;

class MessagePBElemDecoder$ParsePBMsgElemsDefaultTextElem
  extends QParsePBMsgElemsDefaultTextElem
{
  MessagePBElemDecoder$ParsePBMsgElemsDefaultTextElem(AppRuntime paramAppRuntime, StringBuilder paramStringBuilder1, long paramLong, MessageInfo paramMessageInfo, ArrayList<AtTroopMemberInfo> paramArrayList, AtTroopMemberInfo paramAtTroopMemberInfo1, AtTroopMemberInfo paramAtTroopMemberInfo2, byte[] paramArrayOfByte, StringBuilder paramStringBuilder2, boolean paramBoolean, im_msg_body.Elem paramElem)
  {
    super(paramStringBuilder1, paramLong, ???, paramArrayList, paramAtTroopMemberInfo1, paramAtTroopMemberInfo2, paramArrayOfByte, paramStringBuilder2, paramBoolean, paramElem, localElem1);
  }
  
  private boolean g()
  {
    if (QLog.isColorLevel()) {
      this.b.append("elemType: bankcode_ctrlinfo;\n");
    }
    byte[] arrayOfByte = this.h.bankcode_ctrl_info.get().toByteArray();
    int i = arrayOfByte[0];
    int j = arrayOfByte[(arrayOfByte.length - 1)];
    if ((i == 40) && (j == 41))
    {
      if (ByteBuffer.wrap(arrayOfByte, 2, 2).getShort() != 29786) {
        return true;
      }
      i = ByteBuffer.wrap(arrayOfByte, 4, 2).getShort();
      if (i <= 0) {
        return true;
      }
      this.e = new byte[i];
      System.arraycopy(arrayOfByte, 6, this.e, 0, i);
      return false;
    }
    if (QLog.isColorLevel()) {
      this.b.append("elemType: bankcode_ctrlinfo buffer error;\n");
    }
    return true;
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      this.b.append("elemType:NewSysFaceMsg;\n");
    }
    this.f.append(this.a.a((im_msg_body.CommonElem)this.h.common_elem.get()));
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      this.b.append("elemType:OnlineImage;\n");
    }
    this.f.append(BaseApplication.getContext().getString(2131892290));
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      this.b.append("elemType:small_emoji;\n");
    }
    if (!((im_msg_body.SmallEmoji)this.h.small_emoji.get()).packIdSum.has()) {
      return;
    }
    int i = (((im_msg_body.SmallEmoji)this.h.small_emoji.get()).packIdSum.get() & 0xFFFF0000) >> 16;
    int j = ((im_msg_body.SmallEmoji)this.h.small_emoji.get()).packIdSum.get() & 0xFFFF;
    char[] arrayOfChar = EmosmUtils.b(i, j);
    if ((((im_msg_body.SmallEmoji)this.h.small_emoji.get()).imageType.has()) && ((0xFFFF & ((im_msg_body.SmallEmoji)this.h.small_emoji.get()).imageType.get()) == 2))
    {
      arrayOfChar[3] = 'ǿ';
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get apng epid = ");
        localStringBuilder.append(i);
        localStringBuilder.append(" eid = ");
        localStringBuilder.append(j);
        QLog.d("DecodeMsg", 2, localStringBuilder.toString());
      }
    }
    this.f.append('\024');
    this.f.append(arrayOfChar[3]);
    this.f.append(arrayOfChar[2]);
    this.f.append(arrayOfChar[1]);
    this.f.append(arrayOfChar[0]);
    this.g = true;
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      this.b.append("elemType:Face;\n");
    }
    if (!((im_msg_body.Face)this.h.face.get()).index.has()) {
      return;
    }
    int i = QQSysFaceUtil.convertToLocal(((im_msg_body.Face)this.h.face.get()).index.get());
    if (i < 0) {
      return;
    }
    this.f.append('\024');
    this.f.append((char)i);
  }
  
  protected void a()
  {
    if (this.h.face.has())
    {
      k();
      return;
    }
    if (this.h.small_emoji.has())
    {
      j();
      return;
    }
    if (this.h.online_image.has())
    {
      i();
      return;
    }
    if (this.h.bankcode_ctrl_info.has())
    {
      g();
      return;
    }
    if ((this.h.common_elem.has()) && (33 == this.h.common_elem.uint32_service_type.get())) {
      h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessagePBElemDecoder.ParsePBMsgElemsDefaultTextElem
 * JD-Core Version:    0.7.0.1
 */