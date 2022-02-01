package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.msg.im_msg_body.QQWalletAioBody;
import tencent.im.qqwallet.qqwalletaio_resv.qqwalletaio_body_resv;

public class QQWalletAioBodyReserve
{
  public String feedId = "";
  public String makeHbExtend;
  public int pfa_type;
  public String poemRule;
  public String shengpiziMD5 = "";
  public String shengpiziMask = "";
  public int subChannel;
  
  public QQWalletAioBodyReserve() {}
  
  public QQWalletAioBodyReserve(String paramString)
  {
    if (paramString == null) {
      return;
    }
    try
    {
      init(paramString.getBytes());
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public QQWalletAioBodyReserve(im_msg_body.QQWalletAioBody paramQQWalletAioBody)
  {
    if (paramQQWalletAioBody == null) {
      return;
    }
    if (paramQQWalletAioBody.bytes_pb_reserve.has()) {
      try
      {
        init(paramQQWalletAioBody.bytes_pb_reserve.get().toByteArray());
        return;
      }
      catch (Throwable paramQQWalletAioBody)
      {
        paramQQWalletAioBody.printStackTrace();
      }
    }
  }
  
  public void init(byte[] paramArrayOfByte)
  {
    try
    {
      qqwalletaio_resv.qqwalletaio_body_resv localqqwalletaio_body_resv = new qqwalletaio_resv.qqwalletaio_body_resv();
      localqqwalletaio_body_resv.mergeFrom(paramArrayOfByte);
      if (localqqwalletaio_body_resv.uint32_pfa_type.has()) {
        this.pfa_type = localqqwalletaio_body_resv.uint32_pfa_type.get();
      }
      boolean bool = localqqwalletaio_body_resv.bytes_feeds_id.has();
      if (bool) {
        this.feedId = localqqwalletaio_body_resv.bytes_feeds_id.get().toStringUtf8();
      } else {
        this.feedId = "";
      }
      if (localqqwalletaio_body_resv.uint32_subchannel.has()) {
        this.subChannel = localqqwalletaio_body_resv.uint32_subchannel.get();
      }
      if (localqqwalletaio_body_resv.bytes_poem_rule.has()) {
        this.poemRule = localqqwalletaio_body_resv.bytes_poem_rule.get().toStringUtf8();
      } else {
        this.poemRule = "";
      }
      if (localqqwalletaio_body_resv.bytes_client_extend.has()) {
        this.makeHbExtend = localqqwalletaio_body_resv.bytes_client_extend.get().toStringUtf8();
      } else {
        this.makeHbExtend = "";
      }
      if (localqqwalletaio_body_resv.bytes_rareword_rule.has())
      {
        paramArrayOfByte = localqqwalletaio_body_resv.bytes_rareword_rule.get().toStringUtf8();
        if (!TextUtils.isEmpty(paramArrayOfByte))
        {
          int i = paramArrayOfByte.indexOf("|");
          if (i > -1)
          {
            this.shengpiziMask = paramArrayOfByte.substring(0, i);
            this.shengpiziMD5 = paramArrayOfByte.substring(i + 1);
            return;
          }
        }
      }
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQWalletAioBodyReserve{pfa_type=");
    localStringBuilder.append(this.pfa_type);
    localStringBuilder.append(", feedId='");
    localStringBuilder.append(this.feedId);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQWalletAioBodyReserve
 * JD-Core Version:    0.7.0.1
 */