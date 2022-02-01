package com.tencent.mobileqq.service.message;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.api.IQMessageProtoCodecService;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import java.util.ArrayList;
import tencent.im.msg.hummer.resv1.TextMsgExtPb.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;

public class QMessageProtoCodec$EncodeRichTextFromStringMsgOne
{
  public im_msg_body.RichText a;
  public String b;
  public int c;
  public StringBuilder d;
  public int e;
  private ArrayList<AtTroopMemberInfo> f;
  private int g;
  
  QMessageProtoCodec$EncodeRichTextFromStringMsgOne(im_msg_body.RichText paramRichText, String paramString, ArrayList<AtTroopMemberInfo> paramArrayList, int paramInt1, int paramInt2, StringBuilder paramStringBuilder, int paramInt3)
  {
    this.a = paramRichText;
    this.b = paramString;
    this.f = paramArrayList;
    this.c = paramInt1;
    this.g = paramInt2;
    this.d = paramStringBuilder;
    this.e = paramInt3;
  }
  
  private void a(AtTroopMemberInfo paramAtTroopMemberInfo)
  {
    if (this.d.length() > 0)
    {
      localObject = this.d.toString();
      QMessageProtoCodec.a(this.a, (String)localObject);
      localObject = this.d;
      ((StringBuilder)localObject).delete(0, ((StringBuilder)localObject).length());
      this.c += 1;
    }
    Object localObject = this.b.substring(paramAtTroopMemberInfo.startPos, paramAtTroopMemberInfo.startPos + paramAtTroopMemberInfo.textLen);
    localObject = QMessageProtoCodec.a(this.a, (String)localObject);
    this.g += 1;
    short s = paramAtTroopMemberInfo.startPos;
    paramAtTroopMemberInfo.startPos = 0;
    a(paramAtTroopMemberInfo, (im_msg_body.Elem)localObject);
    paramAtTroopMemberInfo.startPos = s;
    localObject = this.d;
    ((StringBuilder)localObject).delete(0, ((StringBuilder)localObject).length());
    this.c += 1;
    this.e += paramAtTroopMemberInfo.textLen - 1;
  }
  
  private static void a(AtTroopMemberInfo paramAtTroopMemberInfo, im_msg_body.Elem paramElem)
  {
    if (paramAtTroopMemberInfo != null)
    {
      boolean bool = paramAtTroopMemberInfo.isResvAttr;
      int i = 2;
      if (!bool)
      {
        localObject = new byte[13];
        PkgTools.word2Byte((byte[])localObject, 0, (short)1);
        paramAtTroopMemberInfo.writeTo((byte[])localObject, 2);
        paramElem.text.attr_6_buf.set(ByteStringMicro.copyFrom((byte[])localObject));
        return;
      }
      Object localObject = new TextMsgExtPb.ResvAttr();
      PBUInt32Field localPBUInt32Field = ((TextMsgExtPb.ResvAttr)localObject).at_type;
      if (paramAtTroopMemberInfo.flag == 1) {
        i = 1;
      }
      localPBUInt32Field.set(i);
      ((TextMsgExtPb.ResvAttr)localObject).at_member_tinyid.set(paramAtTroopMemberInfo.uin);
      paramElem.text.bytes_pb_reserve.set(ByteStringMicro.copyFrom(((TextMsgExtPb.ResvAttr)localObject).toByteArray()));
    }
  }
  
  @Nullable
  private AtTroopMemberInfo e()
  {
    if (this.f != null) {
      while (this.g < this.f.size())
      {
        AtTroopMemberInfo localAtTroopMemberInfo = (AtTroopMemberInfo)this.f.get(this.g);
        if ((localAtTroopMemberInfo != null) && (localAtTroopMemberInfo.isValid())) {
          return localAtTroopMemberInfo;
        }
        this.g += 1;
      }
    }
    return null;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public int b()
  {
    return this.g;
  }
  
  public int c()
  {
    return this.e;
  }
  
  public EncodeRichTextFromStringMsgOne d()
  {
    AtTroopMemberInfo localAtTroopMemberInfo = e();
    if ((localAtTroopMemberInfo != null) && (localAtTroopMemberInfo.startPos <= this.e))
    {
      a(localAtTroopMemberInfo);
      return this;
    }
    if (((IQMessageProtoCodecService)QRoute.api(IQMessageProtoCodecService.class)).needProcessEmotion(this.b, this.e))
    {
      ((IQMessageProtoCodecService)QRoute.api(IQMessageProtoCodecService.class)).processEmotion(this);
      return this;
    }
    this.d.append(this.b.charAt(this.e));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.QMessageProtoCodec.EncodeRichTextFromStringMsgOne
 * JD-Core Version:    0.7.0.1
 */