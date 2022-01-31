package com.tencent.qidian.controller;

import alus;
import alut;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_head.Head;
import tencent.im.msg.im_msg_head.HttpConnHead;
import tencent.im.msg.im_msg_head.LoginSig;

public abstract class BigDataHandler
  extends BusinessHandler
{
  private INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  private BigDataGetIpHandler jdField_a_of_type_ComTencentQidianControllerBigDataGetIpHandler;
  public QidianBusinessObserver a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  
  protected BigDataHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new alus(this);
    this.jdField_a_of_type_ComTencentQidianControllerBigDataGetIpHandler = ((BigDataGetIpHandler)paramQQAppInterface.a(104));
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = paramQQAppInterface.getNetEngine(0);
  }
  
  private int a(int paramInt1, MessageMicro paramMessageMicro, boolean paramBoolean, int paramInt2, Object paramObject)
  {
    int i = 1;
    String str = this.jdField_a_of_type_ComTencentQidianControllerBigDataGetIpHandler.a();
    if (this.jdField_a_of_type_ComTencentQidianControllerBigDataGetIpHandler.a() == null) {
      if (paramBoolean) {
        i = 2;
      }
    }
    do
    {
      do
      {
        do
        {
          return i;
        } while (this.jdField_a_of_type_ComTencentQidianControllerBigDataGetIpHandler.a(paramInt1, paramMessageMicro, paramInt2, paramObject));
        return 3;
        if (this.jdField_a_of_type_ComTencentQidianControllerBigDataGetIpHandler.b() != null) {
          break;
        }
        if (paramBoolean) {
          return 4;
        }
      } while (this.jdField_a_of_type_ComTencentQidianControllerBigDataGetIpHandler.a(paramInt1, paramMessageMicro, paramInt2, paramObject));
      return 5;
      if ((str != null) && (str.length() != 0)) {
        break;
      }
      if (paramBoolean) {
        return 6;
      }
    } while (this.jdField_a_of_type_ComTencentQidianControllerBigDataGetIpHandler.a(paramInt1, paramMessageMicro, paramInt2, paramObject));
    return 7;
    return 0;
  }
  
  private void a(int paramInt1, MessageMicro paramMessageMicro, boolean paramBoolean, int paramInt2, Object paramObject)
  {
    int i = a(paramInt1, paramMessageMicro, paramBoolean, paramInt2, paramObject);
    if (i == 1)
    {
      QLog.d("BigDataHandler", 1, "We will wait getIPList call back to do bigData Req" + paramInt1);
      if (!paramBoolean) {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_JavaUtilList.add(new BigDataHandler.ReqStruct(paramInt1, paramMessageMicro, paramInt2, paramObject));
          return;
        }
      }
    }
    else
    {
      if (i != 0)
      {
        QLog.d("BigDataHandler", 1, "USER command get key error status: " + i);
        a(paramInt1, false, null, paramInt2, paramObject);
        return;
      }
      long l;
      Object localObject2;
      try
      {
        l = Long.parseLong(this.b.getCurrentAccountUin());
        localObject2 = new Cryptor().encrypt(paramMessageMicro.toByteArray(), this.jdField_a_of_type_ComTencentQidianControllerBigDataGetIpHandler.a());
        paramMessageMicro = new String();
        i = 0;
        while (i < "7.6.8".length())
        {
          ??? = paramMessageMicro;
          if ("7.6.8".charAt(i) != '.') {
            ??? = paramMessageMicro.concat(Character.toString("7.6.8".charAt(i)));
          }
          i += 1;
          paramMessageMicro = (MessageMicro)???;
        }
        ??? = new im_msg_head.LoginSig();
      }
      catch (Exception paramMessageMicro)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigDataHandler", 2, paramInt1 + " uin case long fail");
        }
        a(paramInt1, false, null, paramInt2, paramObject);
        return;
      }
      ((im_msg_head.LoginSig)???).uint32_type.set(22);
      ((im_msg_head.LoginSig)???).bytes_sig.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentQidianControllerBigDataGetIpHandler.b()));
      Object localObject3 = new im_msg_head.HttpConnHead();
      ((im_msg_head.HttpConnHead)localObject3).uint64_uin.set(l);
      ((im_msg_head.HttpConnHead)localObject3).uint32_command.set(1791);
      ((im_msg_head.HttpConnHead)localObject3).uint32_sub_command.set(paramInt2);
      ((im_msg_head.HttpConnHead)localObject3).uint32_seq.set(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet());
      ((im_msg_head.HttpConnHead)localObject3).uint32_version.set(Integer.parseInt(paramMessageMicro));
      ((im_msg_head.HttpConnHead)localObject3).uint32_flag.set(1);
      ((im_msg_head.HttpConnHead)localObject3).uint32_compress_type.set(0);
      ((im_msg_head.HttpConnHead)localObject3).uint32_error_code.set(0);
      paramMessageMicro = new im_msg_head.Head();
      paramMessageMicro.uint32_head_type.set(4);
      paramMessageMicro.msg_login_sig.set((MessageMicro)???);
      paramMessageMicro.msg_httpconn_head.set((MessageMicro)localObject3);
      ??? = paramMessageMicro.toByteArray();
      paramMessageMicro = new ByteArrayOutputStream();
      try
      {
        localObject3 = new DataOutputStream(paramMessageMicro);
        ((DataOutputStream)localObject3).write(40);
        ((DataOutputStream)localObject3).writeInt(???.length);
        ((DataOutputStream)localObject3).writeInt(localObject2.length);
        ((DataOutputStream)localObject3).write((byte[])???);
        ((DataOutputStream)localObject3).write((byte[])localObject2);
        ((DataOutputStream)localObject3).write(41);
        ((DataOutputStream)localObject3).flush();
        ??? = this.jdField_a_of_type_ComTencentQidianControllerBigDataGetIpHandler.a();
        ??? = (String)??? + "cgi-bin/httpconn";
        paramMessageMicro = paramMessageMicro.toByteArray();
        localObject2 = new HttpNetReq();
        ((HttpNetReq)localObject2).a(paramObject);
        ((HttpNetReq)localObject2).jdField_a_of_type_ArrayOfByte = paramMessageMicro;
        ((HttpNetReq)localObject2).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new alut(paramInt1, this, this.jdField_a_of_type_ComTencentQidianControllerBigDataGetIpHandler.a(), paramInt2, paramObject);
        ((HttpNetReq)localObject2).jdField_a_of_type_JavaLangString = ((String)???);
        ((HttpNetReq)localObject2).jdField_a_of_type_Int = 1;
        ((HttpNetReq)localObject2).jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a((NetReq)localObject2);
          return;
        }
      }
      catch (Exception paramMessageMicro)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigDataHandler", 2, paramMessageMicro.getMessage());
        }
        a(paramInt1, false, null, paramInt2, paramObject);
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          BigDataHandler.ReqStruct localReqStruct = (BigDataHandler.ReqStruct)localIterator.next();
          a(localReqStruct.a(), localReqStruct.a(), true, localReqStruct.b(), localReqStruct.a());
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          BigDataHandler.ReqStruct localReqStruct = (BigDataHandler.ReqStruct)localIterator.next();
          a(localReqStruct.a(), false, null, localReqStruct.b(), localReqStruct.a());
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a()
  {
    super.a();
    if (this.b != null) {
      this.b.removeObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    }
  }
  
  public void a(int paramInt1, MessageMicro paramMessageMicro, int paramInt2, Object paramObject)
  {
    a(paramInt1, paramMessageMicro, false, paramInt2, paramObject);
  }
  
  public abstract void a(int paramInt1, boolean paramBoolean, byte[] paramArrayOfByte, int paramInt2, Object paramObject);
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.qidian.controller.BigDataHandler
 * JD-Core Version:    0.7.0.1
 */