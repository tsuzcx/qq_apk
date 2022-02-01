package com.tencent.mobileqq.service.message;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import tencent.im.msg.hummer.resv1.TextMsgExtPb.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.Text;

public class QParsePBMsgElemsDefaultTextElem
{
  private ArrayList<AtTroopMemberInfo> a;
  protected StringBuilder b;
  protected long c;
  protected MessageInfo d;
  protected byte[] e;
  protected StringBuilder f;
  protected boolean g;
  protected im_msg_body.Elem h;
  protected AppRuntime i;
  private AtTroopMemberInfo j;
  private AtTroopMemberInfo k;
  
  public QParsePBMsgElemsDefaultTextElem(AppRuntime paramAppRuntime, StringBuilder paramStringBuilder1, long paramLong, MessageInfo paramMessageInfo, ArrayList<AtTroopMemberInfo> paramArrayList, AtTroopMemberInfo paramAtTroopMemberInfo1, AtTroopMemberInfo paramAtTroopMemberInfo2, byte[] paramArrayOfByte, StringBuilder paramStringBuilder2, boolean paramBoolean, im_msg_body.Elem paramElem)
  {
    this.b = paramStringBuilder1;
    this.c = paramLong;
    this.d = paramMessageInfo;
    this.a = paramArrayList;
    this.j = paramAtTroopMemberInfo1;
    this.k = paramAtTroopMemberInfo2;
    this.e = paramArrayOfByte;
    this.f = paramStringBuilder2;
    this.g = paramBoolean;
    this.h = paramElem;
    this.i = paramAppRuntime;
  }
  
  private void a(int paramInt, byte[] paramArrayOfByte)
  {
    int n = 0;
    int i3 = PkgTools.getShortData(paramArrayOfByte, 0);
    int m = 2;
    while ((n < i3) && (m < 2048))
    {
      AtTroopMemberInfo localAtTroopMemberInfo1 = new AtTroopMemberInfo();
      if ((n == 0) && (this.j == null)) {
        this.j = localAtTroopMemberInfo1;
      }
      if (!localAtTroopMemberInfo1.readFrom(paramArrayOfByte, m)) {
        return;
      }
      int i1 = m + localAtTroopMemberInfo1.length();
      localAtTroopMemberInfo1.startPos = ((short)(localAtTroopMemberInfo1.startPos + paramInt));
      int i2 = (short)(n + 1);
      if (localAtTroopMemberInfo1.isIncludingAll()) {
        this.d.c.c(13, this.c);
      }
      n = i2;
      m = i1;
      if (localAtTroopMemberInfo1.isIncludingMe(this.i.getLongAccountUin()))
      {
        this.d.c.c(24, this.c);
        AtTroopMemberInfo localAtTroopMemberInfo2 = this.j;
        n = i2;
        m = i1;
        if (localAtTroopMemberInfo1 != localAtTroopMemberInfo2)
        {
          n = i2;
          m = i1;
          if (this.k == null)
          {
            n = i2;
            m = i1;
            if (localAtTroopMemberInfo2.isIncludingMe(this.i.getLongAccountUin()))
            {
              this.k = localAtTroopMemberInfo1;
              n = i2;
              m = i1;
            }
          }
        }
      }
    }
  }
  
  private void a(ByteStringMicro paramByteStringMicro, int paramInt)
  {
    if (paramByteStringMicro != null) {
      paramByteStringMicro = paramByteStringMicro.toByteArray();
    } else {
      paramByteStringMicro = null;
    }
    MessageInfo localMessageInfo = this.d;
    if ((localMessageInfo != null) && ((localMessageInfo.b == 3000) || (this.d.b == 1)) && (this.a != null) && (paramByteStringMicro != null) && (paramByteStringMicro.length != 0)) {
      b(paramInt, paramByteStringMicro);
    }
    localMessageInfo = this.d;
    if (localMessageInfo != null)
    {
      if ((!localMessageInfo.c.a(24, this.c)) && (!this.d.c.a(13, this.c)) && (this.k != null)) {
        return;
      }
      if (paramByteStringMicro != null)
      {
        if (paramByteStringMicro.length == 0) {
          return;
        }
        a(paramInt, paramByteStringMicro);
      }
    }
  }
  
  private void a(ByteStringMicro paramByteStringMicro, int paramInt, short paramShort)
  {
    for (;;)
    {
      try
      {
        TextMsgExtPb.ResvAttr localResvAttr = new TextMsgExtPb.ResvAttr();
        localResvAttr.mergeFrom(paramByteStringMicro.toByteArray());
        paramByteStringMicro = new AtTroopMemberInfo();
        paramByteStringMicro.isResvAttr = true;
        if (localResvAttr.at_type.get() != 1) {
          break label222;
        }
        b1 = 1;
        paramByteStringMicro.flag = b1;
        paramByteStringMicro.startPos = ((short)(paramByteStringMicro.startPos + paramInt));
        paramByteStringMicro.textLen = paramShort;
        paramByteStringMicro.uin = localResvAttr.at_member_tinyid.get();
        if (this.a != null) {
          this.a.add(paramByteStringMicro);
        }
        if (this.d != null)
        {
          if ((!this.d.c.a(24, this.c)) && (!this.d.c.a(13, this.c))) {
            return;
          }
          if (paramByteStringMicro.isIncludingAll()) {
            this.d.c.c(13, this.c);
          }
          if (paramByteStringMicro.isIncludingMeTid(this.i)) {
            this.d.c.c(24, this.c);
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramByteStringMicro)
      {
        QLog.e("QParsePBMsgElemsDefaultTextElem", 1, new Object[] { "decodePbReserve error, ", paramByteStringMicro.getMessage() });
      }
      return;
      label222:
      byte b1 = 0;
    }
  }
  
  private void b(int paramInt, byte[] paramArrayOfByte)
  {
    int m = 0;
    int i1 = PkgTools.getShortData(paramArrayOfByte, 0);
    int n = 2;
    while ((m < i1) && (n < 2048))
    {
      AtTroopMemberInfo localAtTroopMemberInfo = new AtTroopMemberInfo();
      if (!localAtTroopMemberInfo.readFrom(paramArrayOfByte, n)) {
        return;
      }
      n += localAtTroopMemberInfo.length();
      localAtTroopMemberInfo.startPos = ((short)(localAtTroopMemberInfo.startPos + paramInt));
      m = (short)(m + 1);
      this.a.add(localAtTroopMemberInfo);
    }
  }
  
  @Nullable
  private QParsePBMsgElemsDefaultTextElem g()
  {
    if (QLog.isColorLevel()) {
      this.b.append("elemType:Text;\n");
    }
    boolean bool = this.g;
    short s = 0;
    if (bool)
    {
      this.g = false;
      return this;
    }
    im_msg_body.Text localText = (im_msg_body.Text)this.h.text.get();
    int m = this.f.length();
    if (localText.str.has())
    {
      String str = QMessageUtils.a(localText.str.get().toStringUtf8(), false);
      this.f.append(str);
      s = (short)str.length();
    }
    if (localText.attr_6_buf.has()) {
      a(localText.attr_6_buf.get(), m);
    } else if (localText.bytes_pb_reserve.has()) {
      a(localText.bytes_pb_reserve.get(), m, s);
    }
    return null;
  }
  
  protected void a() {}
  
  public AtTroopMemberInfo b()
  {
    return this.j;
  }
  
  public AtTroopMemberInfo c()
  {
    return this.k;
  }
  
  public byte[] d()
  {
    return this.e;
  }
  
  public boolean e()
  {
    return this.g;
  }
  
  public QParsePBMsgElemsDefaultTextElem f()
  {
    if (this.h.text.has())
    {
      QParsePBMsgElemsDefaultTextElem localQParsePBMsgElemsDefaultTextElem = g();
      if (localQParsePBMsgElemsDefaultTextElem != null) {
        return localQParsePBMsgElemsDefaultTextElem;
      }
    }
    else
    {
      a();
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.QParsePBMsgElemsDefaultTextElem
 * JD-Core Version:    0.7.0.1
 */