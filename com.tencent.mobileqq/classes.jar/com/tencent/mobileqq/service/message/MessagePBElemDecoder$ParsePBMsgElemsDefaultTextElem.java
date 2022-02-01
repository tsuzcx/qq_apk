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
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_JavaLangStringBuilder.append("elemType:NewSysFaceMsg;\n");
    }
    this.b.append(this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessagePBElemDecoder.a((im_msg_body.CommonElem)this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.common_elem.get()));
  }
  
  private boolean b()
  {
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_JavaLangStringBuilder.append("elemType: bankcode_ctrlinfo;\n");
    }
    byte[] arrayOfByte = this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.bankcode_ctrl_info.get().toByteArray();
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
      this.jdField_a_of_type_ArrayOfByte = new byte[i];
      System.arraycopy(arrayOfByte, 6, this.jdField_a_of_type_ArrayOfByte, 0, i);
      return false;
    }
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_JavaLangStringBuilder.append("elemType: bankcode_ctrlinfo buffer error;\n");
    }
    return true;
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_JavaLangStringBuilder.append("elemType:OnlineImage;\n");
    }
    this.b.append(BaseApplication.getContext().getString(2131694606));
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_JavaLangStringBuilder.append("elemType:small_emoji;\n");
    }
    if (!((im_msg_body.SmallEmoji)this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.small_emoji.get()).packIdSum.has()) {
      return;
    }
    int i = (((im_msg_body.SmallEmoji)this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.small_emoji.get()).packIdSum.get() & 0xFFFF0000) >> 16;
    int j = ((im_msg_body.SmallEmoji)this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.small_emoji.get()).packIdSum.get() & 0xFFFF;
    char[] arrayOfChar = EmosmUtils.b(i, j);
    if ((((im_msg_body.SmallEmoji)this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.small_emoji.get()).imageType.has()) && ((0xFFFF & ((im_msg_body.SmallEmoji)this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.small_emoji.get()).imageType.get()) == 2))
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
    this.b.append('\024');
    this.b.append(arrayOfChar[3]);
    this.b.append(arrayOfChar[2]);
    this.b.append(arrayOfChar[1]);
    this.b.append(arrayOfChar[0]);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_JavaLangStringBuilder.append("elemType:Face;\n");
    }
    if (!((im_msg_body.Face)this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.face.get()).index.has()) {
      return;
    }
    int i = QQSysFaceUtil.convertToLocal(((im_msg_body.Face)this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.face.get()).index.get());
    if (i < 0) {
      return;
    }
    this.b.append('\024');
    this.b.append((char)i);
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.face.has())
    {
      e();
      return;
    }
    if (this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.small_emoji.has())
    {
      d();
      return;
    }
    if (this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.online_image.has())
    {
      c();
      return;
    }
    if (this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.bankcode_ctrl_info.has())
    {
      b();
      return;
    }
    if ((this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.common_elem.has()) && (33 == this.jdField_a_of_type_TencentImMsgIm_msg_body$Elem.common_elem.uint32_service_type.get())) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessagePBElemDecoder.ParsePBMsgElemsDefaultTextElem
 * JD-Core Version:    0.7.0.1
 */