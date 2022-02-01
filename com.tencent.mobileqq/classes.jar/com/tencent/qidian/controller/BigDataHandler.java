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
  public QidianBusinessObserver b = new BigDataHandler.1(this);
  private Object c = new Object();
  private final AtomicInteger d = new AtomicInteger();
  private List<BigDataHandler.ReqStruct> e = null;
  private BigDataGetIpHandler f = null;
  private IHttpEngineService g;
  
  protected BigDataHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.e = new ArrayList();
    this.f = ((BigDataGetIpHandler)this.a.getBusinessHandler(BusinessHandlerFactory.BIG_DATA_GET_IP_HANDLER));
    this.a.addObserver(this.b);
    this.g = ((IHttpEngineService)this.a.getRuntimeService(IHttpEngineService.class, "all"));
  }
  
  protected BigDataHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
    this.e = new ArrayList();
    this.f = ((BigDataGetIpHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIG_DATA_GET_IP_HANDLER));
    paramQQAppInterface.addObserver(this.b);
    this.g = ((IHttpEngineService)paramQQAppInterface.getRuntimeService(IHttpEngineService.class, "all"));
  }
  
  private void a()
  {
    if (this.e != null) {
      synchronized (this.c)
      {
        Iterator localIterator = this.e.iterator();
        while (localIterator.hasNext())
        {
          BigDataHandler.ReqStruct localReqStruct = (BigDataHandler.ReqStruct)localIterator.next();
          a(localReqStruct.a(), localReqStruct.b(), true, localReqStruct.c(), localReqStruct.d());
        }
        this.e.clear();
        return;
      }
    }
  }
  
  private void a(int paramInt1, MessageMicro<?> paramMessageMicro, boolean paramBoolean, int paramInt2, Object paramObject)
  {
    int i = b(paramInt1, paramMessageMicro, paramBoolean, paramInt2, paramObject);
    if (i == 1)
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("We will wait getIPList call back to do bigData Req");
      ((StringBuilder)???).append(paramInt1);
      QLog.d("BigDataHandler", 1, ((StringBuilder)???).toString());
      if (!paramBoolean) {
        synchronized (this.c)
        {
          this.e.add(new BigDataHandler.ReqStruct(paramInt1, paramMessageMicro, paramInt2, paramObject));
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
      long l = Long.parseLong(this.a.getCurrentAccountUin());
      Object localObject2 = new Cryptor().encrypt(paramMessageMicro.toByteArray(), this.f.a());
      paramMessageMicro = new String();
      i = 0;
      while (i < 6)
      {
        ??? = paramMessageMicro;
        if ("8.8.17".charAt(i) != '.') {
          ??? = paramMessageMicro.concat(Character.toString("8.8.17".charAt(i)));
        }
        i += 1;
        paramMessageMicro = (MessageMicro<?>)???;
      }
      ??? = new im_msg_head.LoginSig();
      ((im_msg_head.LoginSig)???).uint32_type.set(22);
      ((im_msg_head.LoginSig)???).bytes_sig.set(ByteStringMicro.copyFrom(this.f.c()));
      Object localObject3 = new im_msg_head.HttpConnHead();
      ((im_msg_head.HttpConnHead)localObject3).uint64_uin.set(l);
      ((im_msg_head.HttpConnHead)localObject3).uint32_command.set(1791);
      ((im_msg_head.HttpConnHead)localObject3).uint32_sub_command.set(paramInt2);
      ((im_msg_head.HttpConnHead)localObject3).uint32_seq.set(this.d.incrementAndGet());
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
        ??? = this.f.b();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)???);
        ((StringBuilder)localObject2).append("cgi-bin/httpconn");
        ??? = ((StringBuilder)localObject2).toString();
        localObject2 = paramMessageMicro.toByteArray();
        paramMessageMicro = new HttpNetReq();
        paramMessageMicro.setUserData(paramObject);
        paramMessageMicro.mSendData = ((byte[])localObject2);
        paramMessageMicro.mCallback = new BigDataHandler.BigDataDownloadListener(paramInt1, this, this.f.a(), paramInt2, paramObject);
        paramMessageMicro.mReqUrl = ((String)???);
        paramMessageMicro.mHttpMethod = 1;
        paramMessageMicro.mReqProperties.put("Accept-Encoding", "identity");
        paramObject = this.g;
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
      label650:
      break label650;
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
  
  private int b(int paramInt1, MessageMicro<?> paramMessageMicro, boolean paramBoolean, int paramInt2, Object paramObject)
  {
    String str = this.f.b();
    if (this.f.a() == null)
    {
      if (paramBoolean) {
        return 2;
      }
      if (this.f.a(paramInt1, paramMessageMicro, paramInt2, paramObject)) {
        return 1;
      }
      return 3;
    }
    if (this.f.c() == null)
    {
      if (paramBoolean) {
        return 4;
      }
      if (this.f.a(paramInt1, paramMessageMicro, paramInt2, paramObject)) {
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
    if (this.f.a(paramInt1, paramMessageMicro, paramInt2, paramObject)) {
      return 1;
    }
    return 7;
  }
  
  private void b()
  {
    if (this.e != null) {
      synchronized (this.c)
      {
        Iterator localIterator = this.e.iterator();
        while (localIterator.hasNext())
        {
          BigDataHandler.ReqStruct localReqStruct = (BigDataHandler.ReqStruct)localIterator.next();
          a(localReqStruct.a(), false, null, localReqStruct.c(), localReqStruct.d());
        }
        this.e.clear();
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
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.b);
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.controller.BigDataHandler
 * JD-Core Version:    0.7.0.1
 */