package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class OldHttpEngine
  implements INetEngine
{
  private static volatile int jdField_a_of_type_Int = -1;
  HttpCommunicator jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  boolean jdField_a_of_type_Boolean;
  
  public OldHttpEngine(HttpCommunicator paramHttpCommunicator, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.OldHttpEngine", 2, "construct " + this);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator = paramHttpCommunicator;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private HttpMsg a(NetReq paramNetReq)
  {
    if (paramNetReq == null) {
      return null;
    }
    HttpNetReq localHttpNetReq;
    OldHttpEngine.OldHttpCommunicatorListner localOldHttpCommunicatorListner;
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if ((paramNetReq.jdField_b_of_type_Int == 0) && ((paramNetReq instanceof HttpNetReq)))
    {
      localHttpNetReq = (HttpNetReq)paramNetReq;
      localOldHttpCommunicatorListner = (OldHttpEngine.OldHttpCommunicatorListner)localHttpNetReq.jdField_a_of_type_JavaLangObject;
      if ((localOldHttpCommunicatorListner == null) || (localOldHttpCommunicatorListner.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
        return null;
      }
      localObject1 = localHttpNetReq.jdField_a_of_type_JavaLangString;
      if ((!localHttpNetReq.jdField_a_of_type_Boolean) || (localHttpNetReq.jdField_a_of_type_JavaLangString == null) || (localHttpNetReq.jdField_a_of_type_JavaLangString.startsWith("https"))) {
        break label694;
      }
      localObject3 = InnerDns.a(localHttpNetReq.jdField_a_of_type_JavaLangString);
      localObject2 = InnerDns.a().a((String)localObject3, 1002);
      localObject2 = InnerDns.a(localHttpNetReq.jdField_a_of_type_JavaLangString, (String)localObject2);
      if ((localObject2 == null) || (((String)localObject2).equals(localHttpNetReq.jdField_a_of_type_JavaLangString))) {
        break label694;
      }
      if (!StringUtil.a((String)localObject3)) {
        paramNetReq.jdField_a_of_type_JavaUtilHashMap.put("host", localObject3);
      }
      localHttpNetReq.jdField_b_of_type_Boolean = true;
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.richmedia.OldHttpEngine", 2, "NeedIpConnect url=" + localHttpNetReq.jdField_a_of_type_JavaLangString + " ipUrl=" + (String)localObject2);
        localObject1 = localObject2;
      }
    }
    label694:
    for (;;)
    {
      localObject2 = new HttpMsg((String)localObject1, localHttpNetReq.jdField_a_of_type_ArrayOfByte, localOldHttpCommunicatorListner);
      if (localHttpNetReq.jdField_a_of_type_Int == 0) {}
      for (localObject1 = "GET";; localObject1 = "POST")
      {
        ((HttpMsg)localObject2).b((String)localObject1);
        localObject1 = localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          ((HttpMsg)localObject2).a((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
        }
      }
      ((HttpMsg)localObject2).j = localHttpNetReq.f;
      ((HttpMsg)localObject2).jdField_e_of_type_JavaLangString = localHttpNetReq.jdField_b_of_type_JavaLangString;
      ((HttpMsg)localObject2).k = localHttpNetReq.g;
      ((HttpMsg)localObject2).l = localHttpNetReq.jdField_h_of_type_Boolean;
      ((HttpMsg)localObject2).jdField_h_of_type_Boolean = localHttpNetReq.jdField_b_of_type_Boolean;
      ((HttpMsg)localObject2).jdField_c_of_type_Boolean = localHttpNetReq.jdField_c_of_type_Boolean;
      ((HttpMsg)localObject2).jdField_a_of_type_JavaLangString = paramNetReq.jdField_e_of_type_JavaLangString;
      ((HttpMsg)localObject2).jdField_c_of_type_Int = paramNetReq.g;
      ((HttpMsg)localObject2).jdField_b_of_type_Int = paramNetReq.jdField_f_of_type_Int;
      ((HttpMsg)localObject2).jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam = localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam;
      ((HttpMsg)localObject2).jdField_a_of_type_ArrayOfJavaLangString = localHttpNetReq.jdField_a_of_type_ArrayOfJavaLangString;
      ((HttpMsg)localObject2).jdField_e_of_type_Boolean = localHttpNetReq.o;
      ((HttpMsg)localObject2).d = paramNetReq.l;
      ((HttpMsg)localObject2).i = localHttpNetReq.jdField_e_of_type_Boolean;
      if (jdField_a_of_type_Int == -1) {
        b();
      }
      switch (jdField_a_of_type_Int)
      {
      }
      for (;;)
      {
        if (paramNetReq.jdField_e_of_type_Int == 1)
        {
          ((HttpMsg)localObject2).jdField_a_of_type_Int = 201;
          label507:
          if ((localHttpNetReq.jdField_a_of_type_JavaIoOutputStream != null) || (localHttpNetReq.jdField_c_of_type_JavaLangString != null)) {
            ((HttpMsg)localObject2).a(true);
          }
          localOldHttpCommunicatorListner.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = ((HttpMsg)localObject2);
        }
        try
        {
          paramNetReq = new URL(((HttpMsg)localObject2).a());
          localObject1 = localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
          ((NetResp)localObject1).jdField_a_of_type_JavaUtilHashMap.put("serverip", paramNetReq.getHost());
          ((NetResp)localObject1).jdField_a_of_type_JavaUtilHashMap.put("param_url", ((HttpMsg)localObject2).a());
          return localObject2;
          if (localHttpNetReq.d)
          {
            ((HttpMsg)localObject2).jdField_h_of_type_Int = jdField_a_of_type_Int;
            continue;
            ((HttpMsg)localObject2).jdField_h_of_type_Int = (jdField_a_of_type_Int / 4);
            continue;
            if (paramNetReq.jdField_e_of_type_Int == 2)
            {
              ((HttpMsg)localObject2).jdField_a_of_type_Int = 202;
              break label507;
            }
            if (paramNetReq.jdField_e_of_type_Int != 0) {
              break label507;
            }
            ((HttpMsg)localObject2).jdField_a_of_type_Int = 200;
          }
        }
        catch (Exception paramNetReq)
        {
          for (;;)
          {
            paramNetReq.printStackTrace();
          }
        }
      }
      if (paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener != null)
      {
        paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.a(1, 9302, "not support by HttpOldEngine", null);
        paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener.a(paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileNetResp);
      }
      return null;
    }
  }
  
  private boolean a(HttpMsg paramHttpMsg, HttpNetReq paramHttpNetReq)
  {
    boolean bool = paramHttpMsg.c();
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.OldHttpEngine", 2, "404:" + bool + " ip:" + paramHttpNetReq.jdField_b_of_type_Boolean);
    }
    return (bool) && (paramHttpNetReq.jdField_b_of_type_Boolean);
  }
  
  private static String b(NetReq paramNetReq, String paramString1, String paramString2)
  {
    if ((paramNetReq.d != null) && (paramNetReq.d.length() > 0)) {
      return paramNetReq.d;
    }
    return paramString1 + "." + MD5.toMD5(RichMediaUtil.a(paramString2, false)) + ".tmp";
  }
  
  public static void b()
  {
    if (jdField_a_of_type_Int >= 0) {}
    for (;;)
    {
      return;
      Object localObject = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.aio_config.name(), "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length < 5) {}
      }
      try
      {
        jdField_a_of_type_Int = Integer.valueOf(localObject[4]).intValue();
        label56:
        if (jdField_a_of_type_Int == -1) {
          jdField_a_of_type_Int = 1;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.richmedia.OldHttpEngine", 2, "[initCmwapConnectionTypeFromDpc]: " + jdField_a_of_type_Int);
        return;
      }
      catch (Exception localException)
      {
        break label56;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.OldHttpEngine", 2, "destroy " + this);
      }
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator != null)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator = null;
    }
  }
  
  public void a(NetReq paramNetReq)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int j;
    Object localObject3;
    if ((paramNetReq != null) && (paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener != null))
    {
      j = 0;
      localObject1 = localObject2;
      i = j;
      if ((paramNetReq instanceof HttpNetReq))
      {
        localObject3 = (HttpNetReq)paramNetReq;
        localObject1 = localObject2;
        i = j;
        if (((HttpNetReq)localObject3).jdField_a_of_type_Int == 0)
        {
          localObject1 = localObject2;
          i = j;
          if (paramNetReq.jdField_c_of_type_JavaLangString != null)
          {
            localObject1 = b(paramNetReq, paramNetReq.jdField_c_of_type_JavaLangString, ((HttpNetReq)localObject3).jdField_a_of_type_JavaLangString);
            paramNetReq.jdField_f_of_type_JavaLangString = ((String)localObject1);
            if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(localObject1, localObject1) == null) {
              break label342;
            }
          }
        }
      }
    }
    label200:
    label342:
    for (int i = 1;; i = j)
    {
      if ((paramNetReq.jdField_b_of_type_Int == 0) && ((paramNetReq instanceof HttpNetReq)))
      {
        localObject2 = (HttpNetReq)paramNetReq;
        ((HttpNetReq)localObject2).jdField_a_of_type_ComTencentMobileqqTransfileNetResp = new NetResp((NetReq)localObject2);
        localObject3 = new OldHttpEngine.OldHttpCommunicatorListner(this);
        ((HttpNetReq)localObject2).jdField_a_of_type_JavaLangObject = localObject3;
        ((OldHttpEngine.OldHttpCommunicatorListner)localObject3).jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = ((HttpNetReq)localObject2);
        ((OldHttpEngine.OldHttpCommunicatorListner)localObject3).jdField_a_of_type_ComTencentMobileqqTransfileNetResp = ((HttpNetReq)localObject2).jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
        ((OldHttpEngine.OldHttpCommunicatorListner)localObject3).b();
        if ((paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_Int == 2) && (!((OldHttpEngine.OldHttpCommunicatorListner)localObject3).jdField_b_of_type_Boolean)) {
          break label200;
        }
        OldHttpEngine.OldHttpCommunicatorListner.a((OldHttpEngine.OldHttpCommunicatorListner)localObject3);
      }
      do
      {
        return;
        if (i != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.richmedia.OldHttpEngine", 2, "sendReq:" + paramNetReq + " _id:" + paramNetReq.jdField_e_of_type_JavaLangString + " isDownloading _key:" + (String)localObject1);
          }
          paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_Int = 3;
          OldHttpEngine.OldHttpCommunicatorListner.a((OldHttpEngine.OldHttpCommunicatorListner)localObject3);
          return;
        }
        c(paramNetReq);
        return;
      } while (!QLog.isColorLevel());
      localObject2 = new StringBuilder().append("req:").append(paramNetReq).append(" callback:");
      if (paramNetReq == null) {}
      for (paramNetReq = (NetReq)localObject1;; paramNetReq = paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener)
      {
        QLog.e("Q.richmedia.OldHttpEngine", 2, paramNetReq);
        return;
      }
    }
  }
  
  public void a(HttpMsg paramHttpMsg)
  {
    if ((paramHttpMsg != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator != null)) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(paramHttpMsg);
    }
  }
  
  public void b(NetReq paramNetReq)
  {
    if (paramNetReq == null) {}
    do
    {
      return;
      if (paramNetReq.jdField_f_of_type_JavaLangString != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramNetReq.jdField_f_of_type_JavaLangString);
      }
    } while (!OldHttpEngine.OldHttpCommunicatorListner.class.isInstance(paramNetReq.jdField_a_of_type_JavaLangObject));
    Object localObject = (HttpNetReq)paramNetReq;
    int i = paramNetReq.g;
    boolean bool;
    if (((HttpNetReq)localObject).jdField_a_of_type_Int == 1) {
      bool = true;
    }
    for (;;)
    {
      RichMediaUtil.a(i, bool, paramNetReq.jdField_f_of_type_Int, paramNetReq.jdField_e_of_type_JavaLangString, "cancelReq", "");
      localObject = (OldHttpEngine.OldHttpCommunicatorListner)paramNetReq.jdField_a_of_type_JavaLangObject;
      if (QLog.isColorLevel())
      {
        QLog.d("OldHttpEngine", 2, "cancelReq ====== listener = " + localObject);
        if (localObject != null) {
          QLog.d("OldHttpEngine", 2, "cancelReq ====== listener.mIsCancelled = " + ((OldHttpEngine.OldHttpCommunicatorListner)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
        }
      }
      if (localObject == null) {
        break;
      }
      ((OldHttpEngine.OldHttpCommunicatorListner)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      HttpMsg localHttpMsg = ((OldHttpEngine.OldHttpCommunicatorListner)localObject).jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
      if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator != null)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(localHttpMsg);
      }
      try
      {
        if ((paramNetReq.jdField_c_of_type_JavaLangString != null) && (((OldHttpEngine.OldHttpCommunicatorListner)localObject).jdField_a_of_type_JavaIoOutputStream != null)) {
          ((OldHttpEngine.OldHttpCommunicatorListner)localObject).jdField_a_of_type_JavaIoOutputStream.close();
        }
        ((OldHttpEngine.OldHttpCommunicatorListner)localObject).a();
        return;
        bool = false;
      }
      catch (IOException paramNetReq)
      {
        for (;;)
        {
          paramNetReq.printStackTrace();
        }
      }
    }
  }
  
  public void c(NetReq paramNetReq)
  {
    OldHttpEngine.OldHttpCommunicatorListner localOldHttpCommunicatorListner;
    do
    {
      try
      {
        HttpMsg localHttpMsg1 = a(paramNetReq);
        localOldHttpCommunicatorListner = (OldHttpEngine.OldHttpCommunicatorListner)paramNetReq.jdField_a_of_type_JavaLangObject;
        if ((localHttpMsg1 != null) && (localOldHttpCommunicatorListner != null))
        {
          NetResp localNetResp = paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
          localNetResp.d += 1;
          localOldHttpCommunicatorListner.jdField_b_of_type_Int = 0;
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            a(localHttpMsg1);
            return;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        for (;;)
        {
          System.gc();
          try
          {
            HttpMsg localHttpMsg2 = a(paramNetReq);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.richmedia.OldHttpEngine", 2, "OOM in makeNewHttpMsgFromNetReq", localOutOfMemoryError2);
            }
            Object localObject = null;
          }
        }
        paramNetReq = paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
        paramNetReq.jdField_b_of_type_Int = 9366;
        paramNetReq.jdField_a_of_type_JavaLangString = "oldengine close";
        paramNetReq.jdField_a_of_type_Int = 1;
        OldHttpEngine.OldHttpCommunicatorListner.a(localOldHttpCommunicatorListner);
        return;
      }
    } while ((localOldHttpCommunicatorListner == null) || (localOldHttpCommunicatorListner.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()));
    paramNetReq = paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
    paramNetReq.jdField_b_of_type_Int = 9369;
    paramNetReq.jdField_a_of_type_JavaLangString = "Out of memory";
    paramNetReq.jdField_a_of_type_Int = 1;
    OldHttpEngine.OldHttpCommunicatorListner.a(localOldHttpCommunicatorListner);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.OldHttpEngine
 * JD-Core Version:    0.7.0.1
 */