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
  private int jdField_a_of_type_Int = -1;
  private Object jdField_a_of_type_JavaLangObject = null;
  private WeakReference<BigDataHandler> jdField_a_of_type_JavaLangRefWeakReference = null;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private int b = -1;
  
  public BigDataHandler$BigDataDownloadListener(int paramInt1, BigDataHandler paramBigDataHandler, byte[] paramArrayOfByte, int paramInt2, Object paramObject)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBigDataHandler);
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp");
    }
    BigDataHandler localBigDataHandler = (BigDataHandler)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localBigDataHandler == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp handler is null");
      }
      return;
    }
    Object localObject1;
    if ((paramNetResp == null) || (paramNetResp.mResult != 0))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("BigDataDownloadListener$onResp | resp = ").append(paramNetResp).append(" | mResult=");
        if (paramNetResp == null) {
          break label130;
        }
      }
      label130:
      for (i = paramNetResp.mResult;; i = 0)
      {
        QLog.d("BigDataHandler", 2, i);
        localBigDataHandler.a(this.jdField_a_of_type_Int, false, null, this.b, this.jdField_a_of_type_JavaLangObject);
        return;
      }
    }
    Object localObject2;
    try
    {
      localObject2 = paramNetResp.mRespData;
      i = localObject2.length;
      if ((localObject2[0] != 40) || (localObject2[(i - 1)] != 41))
      {
        localObject1 = "unexpected body data, len=" + i + ", data=";
        localObject2 = localObject2.toString();
        StringBuilder localStringBuilder = new StringBuilder().append((String)localObject1);
        localObject1 = localObject2;
        if (((String)localObject2).length() > 20) {
          localObject1 = ((String)localObject2).substring(0, 20);
        }
        localObject1 = (String)localObject1;
        if (QLog.isColorLevel()) {
          QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp | resp = " + paramNetResp + " | mResult=" + (String)localObject1);
        }
        localBigDataHandler.a(this.jdField_a_of_type_Int, false, null, this.b, this.jdField_a_of_type_JavaLangObject);
        return;
      }
    }
    catch (Exception paramNetResp)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp | Exception:" + paramNetResp.getMessage());
      }
      localBigDataHandler.a(this.jdField_a_of_type_Int, false, null, this.b, this.jdField_a_of_type_JavaLangObject);
      return;
    }
    paramNetResp = new DataInputStream(new ByteArrayInputStream((byte[])localObject2));
    paramNetResp.readByte();
    int k = paramNetResp.readInt();
    int j = paramNetResp.readInt();
    if ((k > i) || (j > i))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BigDataHandler", 2, "unexpected length, headLen=" + k + ", bodyLen=" + j);
      }
      localBigDataHandler.a(this.jdField_a_of_type_Int, false, null, this.b, this.jdField_a_of_type_JavaLangObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp | headLen=" + k + " | bodyLen=" + j);
    }
    if (k > 0)
    {
      localObject1 = new byte[k];
      paramNetResp.read((byte[])localObject1);
      localObject2 = new im_msg_head.Head();
      ((im_msg_head.Head)localObject2).mergeFrom((byte[])localObject1);
    }
    for (int i = ((im_msg_head.HttpConnHead)((im_msg_head.Head)localObject2).msg_httpconn_head.get()).uint32_error_code.get();; i = 0)
    {
      if ((j > 0) && (i == 0))
      {
        localObject1 = new byte[j];
        paramNetResp.read((byte[])localObject1);
        paramNetResp = new Cryptor().decrypt((byte[])localObject1, this.jdField_a_of_type_ArrayOfByte);
        localBigDataHandler.a(this.jdField_a_of_type_Int, true, paramNetResp, this.b, this.jdField_a_of_type_JavaLangObject);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp | errorCode:" + i);
      }
      localBigDataHandler.a(this.jdField_a_of_type_Int, false, null, this.b, this.jdField_a_of_type_JavaLangObject);
      return;
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qidian.controller.BigDataHandler.BigDataDownloadListener
 * JD-Core Version:    0.7.0.1
 */