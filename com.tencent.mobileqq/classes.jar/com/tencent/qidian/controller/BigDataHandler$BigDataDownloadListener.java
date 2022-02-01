package com.tencent.qidian.controller;

import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.lang.ref.WeakReference;
import tencent.im.msg.im_msg_head.Head;
import tencent.im.msg.im_msg_head.HttpConnHead;

class BigDataHandler$BigDataDownloadListener
  implements INetEngineListener
{
  private int a = -1;
  private int b = -1;
  private Object c = null;
  private WeakReference<BigDataHandler> d = null;
  private byte[] e = null;
  
  public BigDataHandler$BigDataDownloadListener(int paramInt1, BigDataHandler paramBigDataHandler, byte[] paramArrayOfByte, int paramInt2, Object paramObject)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramObject;
    this.d = new WeakReference(paramBigDataHandler);
    this.e = paramArrayOfByte;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp");
    }
    BigDataHandler localBigDataHandler = (BigDataHandler)this.d.get();
    if (localBigDataHandler == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp handler is null");
      }
      return;
    }
    int j = 0;
    int i = 0;
    Object localObject1;
    if ((paramNetResp != null) && (paramNetResp.mResult == 0)) {
      try
      {
        Object localObject2 = paramNetResp.mRespData;
        int m = localObject2.length;
        if ((localObject2[0] == 40) && (localObject2[(m - 1)] == 41))
        {
          paramNetResp = new DataInputStream(new ByteArrayInputStream((byte[])localObject2));
          paramNetResp.readByte();
          int k = paramNetResp.readInt();
          j = paramNetResp.readInt();
          if ((k <= m) && (j <= m))
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("BigDataDownloadListener$onResp | headLen=");
              ((StringBuilder)localObject1).append(k);
              ((StringBuilder)localObject1).append(" | bodyLen=");
              ((StringBuilder)localObject1).append(j);
              QLog.d("BigDataHandler", 2, ((StringBuilder)localObject1).toString());
            }
            if (k > 0)
            {
              localObject1 = new byte[k];
              paramNetResp.read((byte[])localObject1);
              localObject2 = new im_msg_head.Head();
              ((im_msg_head.Head)localObject2).mergeFrom((byte[])localObject1);
              i = ((im_msg_head.HttpConnHead)((im_msg_head.Head)localObject2).msg_httpconn_head.get()).uint32_error_code.get();
            }
            if ((j > 0) && (i == 0))
            {
              localObject1 = new byte[j];
              paramNetResp.read((byte[])localObject1);
              paramNetResp = new Cryptor().decrypt((byte[])localObject1, this.e);
              localBigDataHandler.a(this.a, true, paramNetResp, this.b, this.c);
              return;
            }
            if (QLog.isColorLevel())
            {
              paramNetResp = new StringBuilder();
              paramNetResp.append("BigDataDownloadListener$onResp | errorCode:");
              paramNetResp.append(i);
              QLog.d("BigDataHandler", 2, paramNetResp.toString());
            }
            localBigDataHandler.a(this.a, false, null, this.b, this.c);
            return;
          }
          if (QLog.isColorLevel())
          {
            paramNetResp = new StringBuilder();
            paramNetResp.append("unexpected length, headLen=");
            paramNetResp.append(k);
            paramNetResp.append(", bodyLen=");
            paramNetResp.append(j);
            QLog.d("BigDataHandler", 2, paramNetResp.toString());
          }
          localBigDataHandler.a(this.a, false, null, this.b, this.c);
          return;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("unexpected body data, len=");
        ((StringBuilder)localObject1).append(m);
        ((StringBuilder)localObject1).append(", data=");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = localObject2.toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localObject1 = localObject2;
        if (((String)localObject2).length() > 20) {
          localObject1 = ((String)localObject2).substring(0, 20);
        }
        localStringBuilder.append((String)localObject1);
        localObject1 = localStringBuilder.toString();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("BigDataDownloadListener$onResp | resp = ");
          ((StringBuilder)localObject2).append(paramNetResp);
          ((StringBuilder)localObject2).append(" | mResult=");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("BigDataHandler", 2, ((StringBuilder)localObject2).toString());
        }
        localBigDataHandler.a(this.a, false, null, this.b, this.c);
        return;
      }
      catch (Exception paramNetResp)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("BigDataDownloadListener$onResp | Exception:");
          ((StringBuilder)localObject1).append(paramNetResp.getMessage());
          QLog.d("BigDataHandler", 2, ((StringBuilder)localObject1).toString());
        }
        localBigDataHandler.a(this.a, false, null, this.b, this.c);
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("BigDataDownloadListener$onResp | resp = ");
      ((StringBuilder)localObject1).append(paramNetResp);
      ((StringBuilder)localObject1).append(" | mResult=");
      i = j;
      if (paramNetResp != null) {
        i = paramNetResp.mResult;
      }
      ((StringBuilder)localObject1).append(i);
      QLog.d("BigDataHandler", 2, ((StringBuilder)localObject1).toString());
    }
    localBigDataHandler.a(this.a, false, null, this.b, this.c);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.controller.BigDataHandler.BigDataDownloadListener
 * JD-Core Version:    0.7.0.1
 */