package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.QQWalletAioBody;

public class QQWalletTransferMsg
  implements ISafeStream
{
  public QQWalletAioBodyReserve body;
  private int channelId;
  public QQWalletBaseMsgElem elem;
  public String listId;
  private int resend;
  public int templateId;
  
  public QQWalletTransferMsg()
  {
    this.body = new QQWalletAioBodyReserve();
    this.elem = new QQWalletBaseMsgElem();
  }
  
  public QQWalletTransferMsg(im_msg_body.QQWalletAioBody paramQQWalletAioBody, String paramString)
  {
    if ((paramQQWalletAioBody != null) && (!TextUtils.isEmpty(paramString)))
    {
      if ((paramQQWalletAioBody.sint32_msgtype.has()) && (paramQQWalletAioBody.sint32_msgtype.get() == 16))
      {
        this.elem = new QQWalletBaseMsgElem(paramQQWalletAioBody.receiver);
      }
      else
      {
        long l = paramQQWalletAioBody.uint64_senduin.get();
        if (l != 0L)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(l);
          if (paramString.compareTo(localStringBuilder.toString()) == 0)
          {
            this.elem = new QQWalletBaseMsgElem(paramQQWalletAioBody.sender);
            break label141;
          }
        }
        this.elem = new QQWalletBaseMsgElem(paramQQWalletAioBody.receiver);
      }
      label141:
      this.channelId = paramQQWalletAioBody.sint32_channelid.get();
      this.templateId = paramQQWalletAioBody.sint32_templateid.get();
      this.resend = paramQQWalletAioBody.uint32_resend.get();
      if (paramQQWalletAioBody.bytes_billno.has()) {
        this.listId = paramQQWalletAioBody.bytes_billno.get().toStringUtf8();
      }
      this.body = new QQWalletAioBodyReserve(paramQQWalletAioBody);
      return;
    }
    this.body = new QQWalletAioBodyReserve();
    this.elem = new QQWalletBaseMsgElem();
  }
  
  public byte[] flushMsgData(int paramInt)
  {
    QwSafeOutputStream localQwSafeOutputStream1;
    QwSafeOutputStream localQwSafeOutputStream2;
    try
    {
      localQwSafeOutputStream1 = new QwSafeOutputStream();
      try
      {
        writeHeader(localQwSafeOutputStream1, paramInt);
        writeExternal(localQwSafeOutputStream1);
        localQwSafeOutputStream2 = localQwSafeOutputStream1;
      }
      catch (Exception localException1) {}
      localQwSafeOutputStream2 = localQwSafeOutputStream1;
    }
    catch (Exception localException2)
    {
      localQwSafeOutputStream1 = null;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("Q.msg.qqwalletmsg", 2, "QQWalletTransferMsg write Exception", localException2);
      localQwSafeOutputStream2 = localQwSafeOutputStream1;
    }
    if (localQwSafeOutputStream2 != null) {
      return localQwSafeOutputStream2.flushDataAndCloseStream();
    }
    return null;
  }
  
  public void readExternal(QwSafeInputStream paramQwSafeInputStream)
  {
    this.elem.a = paramQwSafeInputStream.readInt();
    this.elem.b = paramQwSafeInputStream.readInt();
    this.elem.c = paramQwSafeInputStream.readUTF();
    this.elem.d = paramQwSafeInputStream.readUTF();
    this.elem.e = paramQwSafeInputStream.readUTF();
    this.elem.f = paramQwSafeInputStream.readUTF();
    this.elem.g = paramQwSafeInputStream.readUTF();
    this.elem.h = paramQwSafeInputStream.readUTF();
    this.channelId = paramQwSafeInputStream.readInt();
    this.templateId = paramQwSafeInputStream.readInt();
    this.resend = paramQwSafeInputStream.readInt();
    this.elem.i = paramQwSafeInputStream.readInt(-1);
    this.elem.j = paramQwSafeInputStream.readInt(-1);
    this.elem.k = paramQwSafeInputStream.readUTF();
    this.elem.l = paramQwSafeInputStream.readUTF();
    this.elem.m = paramQwSafeInputStream.readUTF();
    this.elem.n = paramQwSafeInputStream.readUTF();
    this.elem.o = paramQwSafeInputStream.readInt(13487565);
    this.elem.p = paramQwSafeInputStream.readInt(-1);
    this.elem.q = paramQwSafeInputStream.readUTF();
    this.elem.r = paramQwSafeInputStream.readUTF();
    this.elem.s = paramQwSafeInputStream.readUTF();
    this.body.pfa_type = paramQwSafeInputStream.readInt();
    this.elem.a(paramQwSafeInputStream.readUTF());
    this.listId = paramQwSafeInputStream.readUTF();
  }
  
  public void writeExternal(QwSafeOutputStream paramQwSafeOutputStream)
  {
    paramQwSafeOutputStream.writeInt(this.elem.a);
    paramQwSafeOutputStream.writeInt(this.elem.b);
    paramQwSafeOutputStream.writeUTF(this.elem.c);
    paramQwSafeOutputStream.writeUTF(this.elem.d);
    paramQwSafeOutputStream.writeUTF(this.elem.e);
    paramQwSafeOutputStream.writeUTF(this.elem.f);
    paramQwSafeOutputStream.writeUTF(this.elem.g);
    paramQwSafeOutputStream.writeUTF(this.elem.h);
    paramQwSafeOutputStream.writeInt(this.channelId);
    paramQwSafeOutputStream.writeInt(this.templateId);
    paramQwSafeOutputStream.writeInt(this.resend);
    paramQwSafeOutputStream.writeInt(this.elem.i);
    paramQwSafeOutputStream.writeInt(this.elem.j);
    paramQwSafeOutputStream.writeUTF(this.elem.k);
    paramQwSafeOutputStream.writeUTF(this.elem.l);
    paramQwSafeOutputStream.writeUTF(this.elem.m);
    paramQwSafeOutputStream.writeUTF(this.elem.n);
    paramQwSafeOutputStream.writeInt(this.elem.o);
    paramQwSafeOutputStream.writeInt(this.elem.p);
    paramQwSafeOutputStream.writeUTF(this.elem.q);
    paramQwSafeOutputStream.writeUTF(this.elem.r);
    paramQwSafeOutputStream.writeUTF(this.elem.s);
    paramQwSafeOutputStream.writeInt(this.body.pfa_type);
    paramQwSafeOutputStream.writeUTF(this.elem.a());
    paramQwSafeOutputStream.writeUTF(this.listId);
  }
  
  public void writeHeader(QwSafeOutputStream paramQwSafeOutputStream, int paramInt)
  {
    paramQwSafeOutputStream.writeInt(32);
    paramQwSafeOutputStream.writeInt(1);
    paramQwSafeOutputStream.writeInt(4);
    paramQwSafeOutputStream.writeInt(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQWalletTransferMsg
 * JD-Core Version:    0.7.0.1
 */