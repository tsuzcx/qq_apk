package com.tencent.mobileqq.data;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.msg.im_msg_body.QQWalletAioBody;
import tencent.im.qqwallet.qqwalletaio_resv.qqwalletaio_body_resv;

public class QQWalletAioBodyReserve
{
  public String feedId = "";
  public int pfa_type;
  
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
    if (paramQQWalletAioBody == null) {}
    while (!paramQQWalletAioBody.bytes_pb_reserve.has()) {
      return;
    }
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
  
  public void init(byte[] paramArrayOfByte)
  {
    try
    {
      qqwalletaio_resv.qqwalletaio_body_resv localqqwalletaio_body_resv = new qqwalletaio_resv.qqwalletaio_body_resv();
      localqqwalletaio_body_resv.mergeFrom(paramArrayOfByte);
      if (localqqwalletaio_body_resv.uint32_pfa_type.has()) {
        this.pfa_type = localqqwalletaio_body_resv.uint32_pfa_type.get();
      }
      if (localqqwalletaio_body_resv.bytes_feeds_id.has())
      {
        this.feedId = localqqwalletaio_body_resv.bytes_feeds_id.get().toStringUtf8();
        return;
      }
      this.feedId = "";
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public String toString()
  {
    return "QQWalletAioBodyReserve{pfa_type=" + this.pfa_type + ", feedId='" + this.feedId + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQWalletAioBodyReserve
 * JD-Core Version:    0.7.0.1
 */