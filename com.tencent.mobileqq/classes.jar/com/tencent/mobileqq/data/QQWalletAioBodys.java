package com.tencent.mobileqq.data;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.msg.im_msg_body.QQWalletAioBody;
import tencent.im.qqwallet.qqwalletaio_resv.qqwalletaio_body_resv;

public class QQWalletAioBodys
{
  public int pfa_type;
  
  public QQWalletAioBodys() {}
  
  public QQWalletAioBodys(im_msg_body.QQWalletAioBody paramQQWalletAioBody)
  {
    if (paramQQWalletAioBody == null) {}
    for (;;)
    {
      return;
      if (paramQQWalletAioBody.bytes_pb_reserve.has()) {
        try
        {
          qqwalletaio_resv.qqwalletaio_body_resv localqqwalletaio_body_resv = new qqwalletaio_resv.qqwalletaio_body_resv();
          localqqwalletaio_body_resv.mergeFrom(paramQQWalletAioBody.bytes_pb_reserve.get().toByteArray());
          if (localqqwalletaio_body_resv.uint32_pfa_type.has())
          {
            this.pfa_type = localqqwalletaio_body_resv.uint32_pfa_type.get();
            return;
          }
        }
        catch (Throwable paramQQWalletAioBody)
        {
          paramQQWalletAioBody.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQWalletAioBodys
 * JD-Core Version:    0.7.0.1
 */