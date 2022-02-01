package com.tencent.mobileqq.service.message;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.api.IQMessageProtoCodecService;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import java.util.ArrayList;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;

public class QMessageProtoCodec$EncodeRichTextFromStringMsgOne
{
  public int a;
  public String a;
  public StringBuilder a;
  private ArrayList<AtTroopMemberInfo> a;
  public im_msg_body.RichText a;
  public int b;
  private int c;
  
  QMessageProtoCodec$EncodeRichTextFromStringMsgOne(im_msg_body.RichText paramRichText, String paramString, ArrayList<AtTroopMemberInfo> paramArrayList, int paramInt1, int paramInt2, StringBuilder paramStringBuilder, int paramInt3)
  {
    this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText = paramRichText;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Int = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_JavaLangStringBuilder = paramStringBuilder;
    this.b = paramInt3;
  }
  
  @Nullable
  private AtTroopMemberInfo a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      while (this.c < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        AtTroopMemberInfo localAtTroopMemberInfo = (AtTroopMemberInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.c);
        if ((localAtTroopMemberInfo != null) && (localAtTroopMemberInfo.isValid())) {
          return localAtTroopMemberInfo;
        }
        this.c += 1;
      }
    }
    return null;
  }
  
  private void a(AtTroopMemberInfo paramAtTroopMemberInfo)
  {
    if (this.jdField_a_of_type_JavaLangStringBuilder.length() > 0)
    {
      localObject = this.jdField_a_of_type_JavaLangStringBuilder.toString();
      QMessageProtoCodec.a(this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText, (String)localObject);
      localObject = this.jdField_a_of_type_JavaLangStringBuilder;
      ((StringBuilder)localObject).delete(0, ((StringBuilder)localObject).length());
      this.jdField_a_of_type_Int += 1;
    }
    Object localObject = this.jdField_a_of_type_JavaLangString.substring(paramAtTroopMemberInfo.startPos, paramAtTroopMemberInfo.startPos + paramAtTroopMemberInfo.textLen);
    localObject = QMessageProtoCodec.a(this.jdField_a_of_type_TencentImMsgIm_msg_body$RichText, (String)localObject);
    this.c += 1;
    short s = paramAtTroopMemberInfo.startPos;
    paramAtTroopMemberInfo.startPos = 0;
    a(paramAtTroopMemberInfo, (im_msg_body.Elem)localObject);
    paramAtTroopMemberInfo.startPos = s;
    localObject = this.jdField_a_of_type_JavaLangStringBuilder;
    ((StringBuilder)localObject).delete(0, ((StringBuilder)localObject).length());
    this.jdField_a_of_type_Int += 1;
    this.b += paramAtTroopMemberInfo.textLen - 1;
  }
  
  private static void a(AtTroopMemberInfo paramAtTroopMemberInfo, im_msg_body.Elem paramElem)
  {
    if (paramAtTroopMemberInfo != null)
    {
      byte[] arrayOfByte = new byte[13];
      PkgTools.word2Byte(arrayOfByte, 0, (short)1);
      paramAtTroopMemberInfo.writeTo(arrayOfByte, 2);
      paramElem.text.attr_6_buf.set(ByteStringMicro.copyFrom(arrayOfByte));
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public EncodeRichTextFromStringMsgOne a()
  {
    AtTroopMemberInfo localAtTroopMemberInfo = a();
    if ((localAtTroopMemberInfo != null) && (localAtTroopMemberInfo.startPos <= this.b))
    {
      a(localAtTroopMemberInfo);
      return this;
    }
    if (((IQMessageProtoCodecService)QRoute.api(IQMessageProtoCodecService.class)).needProcessEmotion(this.jdField_a_of_type_JavaLangString, this.b))
    {
      ((IQMessageProtoCodecService)QRoute.api(IQMessageProtoCodecService.class)).processEmotion(this);
      return this;
    }
    this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_JavaLangString.charAt(this.b));
    return this;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.QMessageProtoCodec.EncodeRichTextFromStringMsgOne
 * JD-Core Version:    0.7.0.1
 */