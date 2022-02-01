package com.tencent.qidian.controller;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro<*>;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
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
  public QQAppInterface a;
  private IHttpEngineService jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService;
  private BigDataGetIpHandler jdField_a_of_type_ComTencentQidianControllerBigDataGetIpHandler = null;
  public QidianBusinessObserver a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private List<BigDataHandler.ReqStruct> jdField_a_of_type_JavaUtilList = null;
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  
  protected BigDataHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new BigDataHandler.1(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentQidianControllerBigDataGetIpHandler = ((BigDataGetIpHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIG_DATA_GET_IP_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService = ((IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all"));
  }
  
  protected BigDataHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new BigDataHandler.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentQidianControllerBigDataGetIpHandler = ((BigDataGetIpHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIG_DATA_GET_IP_HANDLER));
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService = ((IHttpEngineService)paramQQAppInterface.getRuntimeService(IHttpEngineService.class, "all"));
  }
  
  private int a(int paramInt1, MessageMicro<?> paramMessageMicro, boolean paramBoolean, int paramInt2, Object paramObject)
  {
    String str = this.jdField_a_of_type_ComTencentQidianControllerBigDataGetIpHandler.a();
    if (this.jdField_a_of_type_ComTencentQidianControllerBigDataGetIpHandler.a() == null)
    {
      if (paramBoolean) {
        return 2;
      }
      if (this.jdField_a_of_type_ComTencentQidianControllerBigDataGetIpHandler.a(paramInt1, paramMessageMicro, paramInt2, paramObject)) {
        return 1;
      }
      return 3;
    }
    if (this.jdField_a_of_type_ComTencentQidianControllerBigDataGetIpHandler.b() == null)
    {
      if (paramBoolean) {
        return 4;
      }
      if (this.jdField_a_of_type_ComTencentQidianControllerBigDataGetIpHandler.a(paramInt1, paramMessageMicro, paramInt2, paramObject)) {
        return 1;
      }
      return 5;
    }
    if ((str != null) && (str.length() != 0)) {
      return 0;
    }
    if (paramBoolean) {
      return 6;
    }
    if (this.jdField_a_of_type_ComTencentQidianControllerBigDataGetIpHandler.a(paramInt1, paramMessageMicro, paramInt2, paramObject)) {
      return 1;
    }
    return 7;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          BigDataHandler.ReqStruct localReqStruct = (BigDataHandler.ReqStruct)localIterator.next();
          a(localReqStruct.a(), localReqStruct.a(), true, localReqStruct.b(), localReqStruct.a());
        }
        this.jdField_a_of_type_JavaUtilList.clear();
        return;
      }
    }
  }
  
  private void a(int paramInt1, MessageMicro<?> paramMessageMicro, boolean paramBoolean, int paramInt2, Object paramObject)
  {
    int i = a(paramInt1, paramMessageMicro, paramBoolean, paramInt2, paramObject);
    if (i == 1)
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("We will wait getIPList call back to do bigData Req");
      ((StringBuilder)???).append(paramInt1);
      QLog.d("BigDataHandler", 1, ((StringBuilder)???).toString());
      if (!paramBoolean) {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_JavaUtilList.add(new BigDataHandler.ReqStruct(paramInt1, paramMessageMicro, paramInt2, paramObject));
          return;
        }
      }
      return;
    }
    if (i != 0)
    {
      paramMessageMicro = new StringBuilder();
      paramMessageMicro.append("USER command get key error status: ");
      paramMessageMicro.append(i);
      QLog.d("BigDataHandler", 1, paramMessageMicro.toString());
      a(paramInt1, false, null, paramInt2, paramObject);
      return;
    }
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      Object localObject2 = new Cryptor().encrypt(paramMessageMicro.toByteArray(), this.jdField_a_of_type_ComTencentQidianControllerBigDataGetIpHandler.a());
      paramMessageMicro = new String();
      i = 0;
      while (i < 5)
      {
        ??? = paramMessageMicro;
        if ("8.7.0".charAt(i) != '.') {
          ??? = paramMessageMicro.concat(Character.toString("8.7.0".charAt(i)));
        }
        i += 1;
        paramMessageMicro = (MessageMicro<?>)???;
      }
      ??? = new im_msg_head.LoginSig();
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
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)???);
        ((StringBuilder)localObject2).append("cgi-bin/httpconn");
        ??? = ((StringBuilder)localObject2).toString();
        localObject2 = paramMessageMicro.toByteArray();
        paramMessageMicro = new HttpNetReq();
        paramMessageMicro.setUserData(paramObject);
        paramMessageMicro.mSendData = ((byte[])localObject2);
        paramMessageMicro.mCallback = new BigDataHandler.BigDataDownloadListener(paramInt1, this, this.jdField_a_of_type_ComTencentQidianControllerBigDataGetIpHandler.a(), paramInt2, paramObject);
        paramMessageMicro.mReqUrl = ((String)???);
        paramMessageMicro.mHttpMethod = 1;
        paramMessageMicro.mReqProperties.put("Accept-Encoding", "identity");
        paramObject = this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService;
        if (paramObject != null) {
          paramObject.sendReq(paramMessageMicro);
        }
        return;
      }
      catch (Exception paramMessageMicro)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigDataHandler", 2, paramMessageMicro.getMessage());
        }
        a(paramInt1, false, null, paramInt2, paramObject);
        return;
      }
    }
    catch (Exception paramMessageMicro)
    {
      label649:
      break label649;
    }
    if (QLog.isColorLevel())
    {
      paramMessageMicro = new StringBuilder();
      paramMessageMicro.append(paramInt1);
      paramMessageMicro.append(" uin case long fail");
      QLog.d("BigDataHandler", 2, paramMessageMicro.toString());
    }
    a(paramInt1, false, null, paramInt2, paramObject);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          BigDataHandler.ReqStruct localReqStruct = (BigDataHandler.ReqStruct)localIterator.next();
          a(localReqStruct.a(), false, null, localReqStruct.b(), localReqStruct.a());
        }
        this.jdField_a_of_type_JavaUtilList.clear();
        return;
      }
    }
  }
  
  public void a(int paramInt1, MessageMicro<?> paramMessageMicro, int paramInt2, Object paramObject)
  {
    a(paramInt1, paramMessageMicro, false, paramInt2, paramObject);
  }
  
  protected abstract void a(int paramInt1, boolean paramBoolean, byte[] paramArrayOfByte, int paramInt2, Object paramObject);
  
  public void onDestroy()
  {
    super.onDestroy();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.controller.BigDataHandler
 * JD-Core Version:    0.7.0.1
 */