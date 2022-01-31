package com.tencent.mobileqq.utils.httputils;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import axrn;
import aypb;
import ayta;
import ayuc;
import ayuf;
import ayui;
import ayuk;
import bbmr;
import bbms;
import bbmt;
import bbmu;
import bbmv;
import bbmw;
import bbmx;
import bbmy;
import bgbf;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import javax.net.ssl.HttpsURLConnection;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class HttpCommunicator
  implements bgbf
{
  private static long jdField_a_of_type_Long = 1L;
  private int jdField_a_of_type_Int;
  private bbmt jdField_a_of_type_Bbmt = new bbmt();
  private Object jdField_a_of_type_JavaLangObject = new ReentrantLock();
  private Runnable jdField_a_of_type_JavaLangRunnable;
  String jdField_a_of_type_JavaLangString = null;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private WeakReference<bbmv> jdField_a_of_type_MqqUtilWeakReference;
  boolean jdField_a_of_type_Boolean = true;
  private bbms[] jdField_a_of_type_ArrayOfBbms;
  private final int jdField_b_of_type_Int = 4;
  private volatile boolean jdField_b_of_type_Boolean;
  private final int jdField_c_of_type_Int;
  private volatile boolean jdField_c_of_type_Boolean;
  private int d;
  private int e;
  
  public HttpCommunicator(bbmv parambbmv, int paramInt)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(parambbmv);
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.HttpCommunicator", 2, "construct HTTPcomm");
    }
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_d_of_type_Int = 4;
    this.e = 0;
    if (Integer.parseInt(Build.VERSION.SDK) < 8) {
      System.setProperty("http.keepAlive", "false");
    }
    System.setProperty("http.maxConnections", "2");
  }
  
  private HttpURLConnection a(bbmu parambbmu)
  {
    Object localObject1 = parambbmu.a();
    String str1 = (String)parambbmu.jdField_a_of_type_JavaUtilHashMap.remove("mType");
    String str2;
    int i1;
    int k;
    int i;
    label52:
    Object localObject2;
    int j;
    if (str1 != null)
    {
      str1 = MsfSdkUtils.insertMtype(str1, (String)localObject1);
      localObject1 = null;
      str2 = android.net.Proxy.getDefaultHost();
      i1 = android.net.Proxy.getDefaultPort();
      k = 0;
      i = 0;
      if ((i != 0) || (k >= 2)) {
        break label946;
      }
      localObject2 = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      localObject1 = null;
      if (localObject2 == null) {
        break label955;
      }
      j = ((NetworkInfo)localObject2).getType();
      localObject1 = ((NetworkInfo)localObject2).getExtraInfo();
    }
    for (;;)
    {
      String str3 = bbmx.b((String)localObject1);
      parambbmu.jdField_f_of_type_Boolean = bbmx.jdField_d_of_type_JavaLangString.equals(str3);
      if (!str3.equals(this.jdField_a_of_type_JavaLangString))
      {
        if ((j == 1) || (str3.equals(bbmx.jdField_d_of_type_JavaLangString))) {
          this.jdField_a_of_type_Boolean = false;
        }
      }
      else
      {
        label151:
        if ((j == 1) && (("10.0.0.172".equals(str2)) || ("10.0.0.200".equals(str2)))) {
          this.jdField_a_of_type_Boolean = true;
        }
        if ((str2 == null) || (i1 <= 0)) {
          break label949;
        }
      }
      label285:
      label946:
      label949:
      for (int m = 1;; m = 0)
      {
        int i2;
        Object localObject3;
        int n;
        if ((!this.jdField_a_of_type_Boolean) && (m != 0)) {
          if ((str3.equals(bbmx.jdField_d_of_type_JavaLangString)) || (str3.equals(bbmx.jdField_f_of_type_JavaLangString)) || (str3.equals(bbmx.h))) {
            if (!parambbmu.jdField_g_of_type_Boolean) {
              switch (parambbmu.jdField_h_of_type_Int)
              {
              default: 
                localObject1 = bbmx.b(str1, str2, i1);
                i = 1;
                a((HttpURLConnection)localObject1, parambbmu);
                parambbmu.jdField_d_of_type_Int = j;
                i2 = ayta.a().a();
                if (parambbmu.jdField_a_of_type_Ayui == null)
                {
                  localObject3 = ayuc.a(i2);
                  n = ((ayuf)localObject3).a();
                  if ("POST".equals(parambbmu.e())) {
                    j = 89500;
                  }
                }
                break;
              }
            }
          }
        }
        for (;;)
        {
          ((HttpURLConnection)localObject1).setConnectTimeout(n);
          ((HttpURLConnection)localObject1).setReadTimeout(j);
          a(parambbmu, "gettingConn", "getConnection type:" + i2 + " activeNetworkInfo: " + localObject2 + " defaultHost:" + str2 + " defaultPort: " + i1 + " last apnType:" + this.jdField_a_of_type_JavaLangString + " forceDirect:" + this.jdField_a_of_type_Boolean + ",connectTimeOut:" + n + ",readTimeout:" + j);
          ((HttpURLConnection)localObject1).setInstanceFollowRedirects(false);
          localObject2 = parambbmu.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject2).next();
            ((HttpURLConnection)localObject1).setRequestProperty((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
          }
          str1 = MsfSdkUtils.insertMtype("Other", (String)localObject1);
          break;
          this.jdField_a_of_type_Boolean = true;
          break label151;
          localObject1 = (HttpURLConnection)new URL(str1).openConnection(java.net.Proxy.NO_PROXY);
          i = 0;
          break label285;
          localObject1 = bbmx.a(str1, str2, i1);
          i = 1;
          break label285;
          localObject1 = bbmx.b(str1, str2, i1);
          i = 1;
          break label285;
          if (str3.equals(bbmx.b))
          {
            localObject1 = bbmx.a(str1, str2, i1);
            i = 1;
            break label285;
          }
          localObject1 = bbmx.a(str1, str2, i1);
          i = 1;
          break label285;
          localObject1 = (HttpURLConnection)new URL(str1).openConnection();
          i = 0;
          break label285;
          j = ((ayuf)localObject3).b();
          continue;
          n = parambbmu.jdField_a_of_type_Ayui.b(i2);
          j = parambbmu.jdField_a_of_type_Ayui.a(i2);
        }
        if (parambbmu.e().equals("POST"))
        {
          ((HttpURLConnection)localObject1).setDoOutput(true);
          if (parambbmu.b() != null) {
            ((HttpURLConnection)localObject1).setFixedLengthStreamingMode(parambbmu.b().length);
          }
        }
        parambbmu.jdField_c_of_type_JavaLangString = ((HttpURLConnection)localObject1).getRequestProperties().toString();
        try
        {
          ((HttpURLConnection)localObject1).connect();
          i = 1;
        }
        catch (Exception localException)
        {
          while (m != 0) {
            if ((i != 0) && (m != 0))
            {
              i = 0;
              this.jdField_a_of_type_Boolean = true;
            }
            else if ((m != 0) && (i == 0))
            {
              i = 0;
              this.jdField_a_of_type_Boolean = false;
            }
            else
            {
              throw localException;
            }
          }
          throw localException;
        }
        catch (AssertionError localAssertionError)
        {
          String str4;
          for (;;)
          {
            str4 = localAssertionError.getMessage();
            if (QLog.isColorLevel()) {
              QLog.d("Q.richmedia.HttpCommunicator", 2, "assertion:" + str4);
            }
            if (m == 0) {
              break;
            }
            if ((i != 0) && (m != 0))
            {
              i = 0;
              this.jdField_a_of_type_Boolean = true;
            }
            else if ((m != 0) && (i == 0))
            {
              i = 0;
              this.jdField_a_of_type_Boolean = false;
            }
            else
            {
              i = 1;
            }
          }
          throw new SocketException("AssertionError : " + str4);
        }
        this.jdField_a_of_type_JavaLangString = str3;
        k += 1;
        break label52;
        return localObject1;
      }
      label955:
      j = -1;
    }
  }
  
  private void a(bbmu parambbmu1, bbmu parambbmu2, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SSCM", 2, "msg statuschanged: " + paramInt);
      }
      parambbmu1.a().a(parambbmu1, parambbmu2, paramInt);
    }
  }
  
  private void a(HttpURLConnection paramHttpURLConnection, bbmu parambbmu)
  {
    String str;
    bbmr localbbmr;
    if ((parambbmu.j) && ((paramHttpURLConnection instanceof HttpsURLConnection)))
    {
      paramHttpURLConnection = (HttpsURLConnection)paramHttpURLConnection;
      str = parambbmu.jdField_e_of_type_JavaLangString;
      localbbmr = new bbmr(this, str, parambbmu);
      if (parambbmu.k)
      {
        paramHttpURLConnection.setRequestProperty("host", str);
        paramHttpURLConnection.setSSLSocketFactory(new bbmy(str, localbbmr));
        paramHttpURLConnection.setHostnameVerifier(localbbmr);
      }
    }
    else
    {
      return;
    }
    paramHttpURLConnection.setRequestProperty("host", str);
    paramHttpURLConnection.setHostnameVerifier(localbbmr);
  }
  
  private boolean a(boolean paramBoolean)
  {
    int j = 0;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_c_of_type_Boolean) {
        return false;
      }
      if (!this.jdField_b_of_type_Boolean) {
        return true;
      }
      if (this.jdField_a_of_type_Bbmt.a() > 0) {
        return false;
      }
    }
    if ((this.jdField_a_of_type_ArrayOfBbms == null) || (this.jdField_a_of_type_ArrayOfBbms.length == 0)) {
      return false;
    }
    if (this.e > 0) {
      return false;
    }
    bbms[] arrayOfbbms = this.jdField_a_of_type_ArrayOfBbms;
    int k = arrayOfbbms.length;
    int i = 0;
    for (;;)
    {
      if (i < k)
      {
        bbms localbbms = arrayOfbbms[i];
        if ((localbbms != null) && (localbbms.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) && (localbbms.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
          return false;
        }
      }
      else
      {
        if (paramBoolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.richmedia.HttpCommunicator", 2, "HttpCommunicator checkThreadPoolIdle ，ThreadPool Quit ");
          }
          arrayOfbbms = this.jdField_a_of_type_ArrayOfBbms;
          k = arrayOfbbms.length;
          i = j;
          while (i < k)
          {
            arrayOfbbms[i].sendEmptyMessage(1);
            i += 1;
          }
          this.e = 0;
          this.jdField_d_of_type_Int = 0;
          this.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_ArrayOfBbms = null;
        }
        return true;
      }
      i += 1;
    }
  }
  
  public int a(bbmu parambbmu)
  {
    int i = -1;
    int k = this.jdField_c_of_type_Int;
    int j = 1;
    if (this.jdField_c_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.richmedia.HttpCommunicator", 2, "sendMsg closed");
      }
      if ((parambbmu != null) && (parambbmu.a() != null))
      {
        parambbmu.a(9366, -1, "close");
        parambbmu.a().b(parambbmu, parambbmu);
        k = i;
        return k;
      }
    }
    if (!this.jdField_b_of_type_Boolean) {
      a();
    }
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if (parambbmu != null) {}
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Bbmt.a() < k)
        {
          i = this.jdField_a_of_type_Int + 1;
          this.jdField_a_of_type_Int = i;
          parambbmu.a(i);
          parambbmu.jdField_g_of_type_Long = SystemClock.uptimeMillis();
          this.jdField_a_of_type_Bbmt.a(parambbmu);
          parambbmu.a().a(parambbmu, null, 0);
          i = this.jdField_a_of_type_Int;
          k = i;
          if (j == 0) {
            break;
          }
          a("sendMsg");
          return i;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.richmedia.HttpCommunicator", 2, "exceed queue limit");
        }
        if ((parambbmu != null) && (parambbmu.a() != null))
        {
          parambbmu.a(9367, -1, "queen full");
          parambbmu.a().b(parambbmu, parambbmu);
        }
      }
      finally {}
      j = 0;
    }
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Bbmt != null) {
      return this.jdField_a_of_type_Bbmt.a();
    }
    return "";
  }
  
  public void a()
  {
    int i = 0;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_c_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
          return;
        }
        if ((this.jdField_a_of_type_MqqOsMqqHandler != null) && (this.jdField_a_of_type_JavaLangRunnable != null)) {
          this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        }
        this.jdField_b_of_type_Boolean = true;
        this.e = 0;
        if (this.jdField_a_of_type_MqqOsMqqHandler == null) {
          this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
        }
        if (this.jdField_a_of_type_ArrayOfBbms == null)
        {
          this.jdField_a_of_type_ArrayOfBbms = new bbms[4];
          if (i < 4)
          {
            HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("httpcommunicator_norm_" + i, 5);
            localHandlerThread.start();
            this.jdField_a_of_type_ArrayOfBbms[i] = new bbms(this, localHandlerThread.getLooper());
            this.jdField_a_of_type_ArrayOfBbms[i].jdField_a_of_type_Int = i;
            i += 1;
            continue;
          }
        }
        i = ayta.a().a();
        if ((i == 2) || (i == 3))
        {
          this.jdField_d_of_type_Int = 3;
          return;
        }
      }
      this.jdField_d_of_type_Int = 4;
    }
  }
  
  public void a(int paramInt)
  {
    localObject1 = this.jdField_a_of_type_JavaLangObject;
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        this.jdField_d_of_type_Int = 4;
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.HttpCommunicator", 2, "netType:" + paramInt + " concurrent:" + this.jdField_d_of_type_Int);
        }
        a("netChange");
        return;
      }
      finally {}
      this.jdField_d_of_type_Int = 3;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
  }
  
  void a(int paramInt, HttpURLConnection paramHttpURLConnection, bbmu parambbmu)
  {
    if ((paramHttpURLConnection == null) || (parambbmu == null)) {
      return;
    }
    parambbmu.c(paramInt);
    parambbmu.b("Content-Type", paramHttpURLConnection.getContentType());
    parambbmu.jdField_d_of_type_JavaLangString = paramHttpURLConnection.getHeaderFields().toString();
    if (paramHttpURLConnection.getHeaderField("User-ReturnCode") != null) {
      parambbmu.b("User-ReturnCode", paramHttpURLConnection.getHeaderField("User-ReturnCode"));
    }
    if (paramHttpURLConnection.getHeaderField("X-User-ReturnCode") != null) {
      parambbmu.b("X-User-ReturnCode", paramHttpURLConnection.getHeaderField("X-User-ReturnCode"));
    }
    if (paramHttpURLConnection.getHeaderField("content-range") != null) {
      parambbmu.b("content-range", paramHttpURLConnection.getHeaderField("content-range"));
    }
    if (paramHttpURLConnection.getHeaderField("Range") != null) {
      parambbmu.b("Range", paramHttpURLConnection.getHeaderField("Range"));
    }
    if (paramHttpURLConnection.getHeaderField("X-Range") != null) {
      parambbmu.b("X-Range", paramHttpURLConnection.getHeaderField("X-Range"));
    }
    if (paramHttpURLConnection.getHeaderField("Content-Encoding") != null) {
      parambbmu.b("Content-Encoding", paramHttpURLConnection.getHeaderField("Content-Encoding"));
    }
    if (paramHttpURLConnection.getHeaderField("Transfer-Encoding") != null) {
      parambbmu.b("Transfer-Encoding", paramHttpURLConnection.getHeaderField("Transfer-Encoding"));
    }
    if (paramHttpURLConnection.getHeaderField("X-RtFlag") != null) {
      parambbmu.b("X-RtFlag", paramHttpURLConnection.getHeaderField("X-RtFlag"));
    }
    if (paramHttpURLConnection.getHeaderField("X-httime") != null) {
      parambbmu.b("X-httime", paramHttpURLConnection.getHeaderField("X-httime"));
    }
    if (paramHttpURLConnection.getHeaderField("X-piccachetime") != null) {
      parambbmu.b("X-piccachetime", paramHttpURLConnection.getHeaderField("X-piccachetime"));
    }
    parambbmu.jdField_a_of_type_Long = -1L;
    String str = paramHttpURLConnection.getHeaderField("content-range");
    int i;
    if (str != null) {
      i = str.lastIndexOf("/");
    }
    for (;;)
    {
      try
      {
        parambbmu.jdField_a_of_type_Long = Long.valueOf(str.substring(i + 1)).longValue();
        parambbmu.jdField_b_of_type_Long = paramHttpURLConnection.getContentLength();
        a(parambbmu, "copyRespHeader", "resultCode:" + paramInt + " totalLen:" + parambbmu.jdField_a_of_type_Long + ",totalBlockLen:" + parambbmu.jdField_b_of_type_Long);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      parambbmu.jdField_a_of_type_Long = paramHttpURLConnection.getContentLength();
      parambbmu.jdField_b_of_type_Long = parambbmu.jdField_a_of_type_Long;
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    int i = 4;
    int j = (int)(2L * paramLong / 90000L);
    if (j > 4) {}
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(i + 9400));
      localHashMap.put("param_PostSize", String.valueOf(paramInt));
      axrn.a(BaseApplication.getContext()).a(null, "LongHttpRespTime", false, paramLong, 0L, localHashMap, "");
      return;
      i = j;
    }
  }
  
  public void a(bbms parambbms)
  {
    if (this.jdField_c_of_type_Boolean) {}
    int i;
    do
    {
      do
      {
        return;
      } while (parambbms == null);
      parambbms.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      i = parambbms.jdField_a_of_type_Int;
      if ((i >= 0) && (i < 4))
      {
        ??? = new HandlerThread("httpcommunicator_norm_new_" + i, 5);
        ((HandlerThread)???).start();
        bbms localbbms = new bbms(this, ((HandlerThread)???).getLooper());
        localbbms.jdField_a_of_type_Int = i;
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_ArrayOfBbms[i] = localbbms;
          if (parambbms.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            this.e -= 1;
          }
          a("replaceNewThread index:" + i);
          return;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.richmedia.HttpCommunicator", 2, "replaceNewThread,index error occurs. " + i);
  }
  
  void a(bbms parambbms, bbmu parambbmu)
  {
    if (!this.jdField_b_of_type_Boolean) {
      throw new IOException("httpcommunicator closed");
    }
    if (parambbmu.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      throw new IOException("request cancelled");
    }
    if ((parambbms != null) && (parambbms.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
      throw new RuntimeException("thread should close");
    }
    if (parambbmu.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      a(parambbmu, "interrupt", "preempted");
      throw new IOException("preempted by higher msg");
    }
  }
  
  public void a(bbmu parambbmu)
  {
    if (parambbmu == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Bbmt.a(parambbmu);
      parambbmu.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return;
    }
  }
  
  public void a(bbmu parambbmu, bbms parambbms)
  {
    int i = 0;
    if ((parambbmu != null) && (parambbms != null)) {
      try
      {
        a(parambbmu, "responseTimeout", "");
        if (parambbmu.b() == null) {}
        for (;;)
        {
          a(90000L, i);
          a(parambbms);
          parambbmu.a(9014, 0, "response timeout");
          parambbmu.a().b(parambbmu, parambbmu);
          return;
          i = parambbmu.b().length;
        }
        return;
      }
      catch (Exception parambbmu)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.richmedia.HttpCommunicator", 2, "onResponseTimeout", parambbmu);
        }
      }
    }
  }
  
  /* Error */
  public void a(bbmu parambbmu, bbms parambbms, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 389	bbmu:a	()Lbbmw;
    //   4: astore 31
    //   6: aconst_null
    //   7: astore 24
    //   9: aconst_null
    //   10: astore 29
    //   12: aconst_null
    //   13: astore 27
    //   15: aconst_null
    //   16: astore 23
    //   18: aconst_null
    //   19: astore 30
    //   21: aconst_null
    //   22: astore 28
    //   24: iconst_m1
    //   25: istore 4
    //   27: lconst_0
    //   28: lstore 13
    //   30: lconst_0
    //   31: lstore 15
    //   33: iconst_0
    //   34: istore 11
    //   36: iconst_0
    //   37: istore 8
    //   39: iconst_0
    //   40: istore 7
    //   42: aload_0
    //   43: aload_1
    //   44: aconst_null
    //   45: iconst_1
    //   46: iload_3
    //   47: invokespecial 688	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Lbbmu;IZ)V
    //   50: iconst_0
    //   51: istore 6
    //   53: iconst_0
    //   54: istore 11
    //   56: aconst_null
    //   57: astore 25
    //   59: aload_0
    //   60: aload_1
    //   61: ldc_w 690
    //   64: ldc_w 490
    //   67: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload_0
    //   71: aload_2
    //   72: aload_1
    //   73: invokevirtual 692	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbms;Lbbmu;)V
    //   76: aload_0
    //   77: aload_1
    //   78: invokespecial 694	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;)Ljava/net/HttpURLConnection;
    //   81: astore 26
    //   83: aload 26
    //   85: astore 24
    //   87: aload_1
    //   88: aload 24
    //   90: putfield 697	bbmu:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   93: aload_1
    //   94: invokestatic 474	android/os/SystemClock:uptimeMillis	()J
    //   97: putfield 699	bbmu:jdField_d_of_type_Long	J
    //   100: aload_0
    //   101: aload_1
    //   102: ldc_w 701
    //   105: ldc_w 490
    //   108: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   111: iconst_1
    //   112: istore 11
    //   114: invokestatic 704	java/lang/System:currentTimeMillis	()J
    //   117: pop2
    //   118: aload_1
    //   119: invokevirtual 232	bbmu:e	()Ljava/lang/String;
    //   122: ldc 230
    //   124: invokevirtual 186	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   127: ifeq +5210 -> 5337
    //   130: new 706	com/tencent/mobileqq/utils/httputils/HttpCommunicator$1
    //   133: dup
    //   134: aload_0
    //   135: aload_1
    //   136: aload_2
    //   137: invokespecial 709	com/tencent/mobileqq/utils/httputils/HttpCommunicator$1:<init>	(Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator;Lbbmu;Lbbms;)V
    //   140: astore 26
    //   142: aload_0
    //   143: getfield 381	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   146: aload 26
    //   148: ldc2_w 611
    //   151: invokevirtual 713	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   154: pop
    //   155: aload_1
    //   156: invokevirtual 355	bbmu:b	()[B
    //   159: astore 32
    //   161: aload 24
    //   163: invokevirtual 717	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   166: astore 25
    //   168: aload_0
    //   169: aload_1
    //   170: ldc_w 719
    //   173: new 246	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   180: ldc_w 721
    //   183: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload 32
    //   188: arraylength
    //   189: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   192: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   198: iconst_0
    //   199: istore 5
    //   201: iload 5
    //   203: aload 32
    //   205: arraylength
    //   206: if_icmpge +46 -> 252
    //   209: aload_0
    //   210: aload_2
    //   211: aload_1
    //   212: invokevirtual 692	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbms;Lbbmu;)V
    //   215: aload 25
    //   217: aload 32
    //   219: iload 5
    //   221: sipush 10240
    //   224: aload 32
    //   226: arraylength
    //   227: iload 5
    //   229: isub
    //   230: invokestatic 727	java/lang/Math:min	(II)I
    //   233: invokevirtual 733	java/io/OutputStream:write	([BII)V
    //   236: aload 25
    //   238: invokevirtual 736	java/io/OutputStream:flush	()V
    //   241: iload 5
    //   243: sipush 10240
    //   246: iadd
    //   247: istore 5
    //   249: goto -48 -> 201
    //   252: aload_2
    //   253: ifnull +13 -> 266
    //   256: aload_2
    //   257: getfield 636	bbms:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   260: invokevirtual 441	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   263: ifne +14 -> 277
    //   266: aload_0
    //   267: aload_1
    //   268: ldc_w 738
    //   271: ldc_w 490
    //   274: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   277: aload 24
    //   279: invokevirtual 742	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   282: invokevirtual 743	java/net/URL:toString	()Ljava/lang/String;
    //   285: invokevirtual 746	java/lang/String:length	()I
    //   288: i2l
    //   289: lstore 17
    //   291: aload 32
    //   293: arraylength
    //   294: istore 5
    //   296: lload 13
    //   298: iload 5
    //   300: i2l
    //   301: ldc2_w 747
    //   304: lload 17
    //   306: ladd
    //   307: ladd
    //   308: ladd
    //   309: lstore 13
    //   311: aload_0
    //   312: aload_2
    //   313: aload_1
    //   314: invokevirtual 692	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbms;Lbbmu;)V
    //   317: aload 24
    //   319: invokevirtual 751	java/net/HttpURLConnection:getResponseCode	()I
    //   322: istore 5
    //   324: aload_0
    //   325: iload 5
    //   327: aload 24
    //   329: aload_1
    //   330: invokevirtual 753	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(ILjava/net/HttpURLConnection;Lbbmu;)V
    //   333: aload_2
    //   334: ifnull +231 -> 565
    //   337: aload_2
    //   338: getfield 636	bbms:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   341: invokevirtual 441	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   344: istore 12
    //   346: iload 12
    //   348: ifeq +217 -> 565
    //   351: iload 5
    //   353: sipush 200
    //   356: if_icmpeq +11 -> 367
    //   359: iload 5
    //   361: sipush 206
    //   364: if_icmpne +31 -> 395
    //   367: aload_0
    //   368: aload_1
    //   369: ldc_w 755
    //   372: new 246	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   379: ldc_w 757
    //   382: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: iconst_0
    //   386: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   389: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   395: aload_2
    //   396: ifnull +13 -> 409
    //   399: aload_2
    //   400: getfield 636	bbms:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   403: invokevirtual 441	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   406: ifne +47 -> 453
    //   409: aload_0
    //   410: aload_1
    //   411: ldc_w 759
    //   414: new 246	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   421: ldc_w 761
    //   424: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload_1
    //   428: invokevirtual 763	bbmu:d	()Ljava/lang/String;
    //   431: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: ldc_w 765
    //   437: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: aload_1
    //   441: invokevirtual 767	bbmu:c	()Ljava/lang/String;
    //   444: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   453: aload_0
    //   454: getfield 381	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   457: ifnull +17 -> 474
    //   460: aload 26
    //   462: ifnull +12 -> 474
    //   465: aload_0
    //   466: getfield 381	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   469: aload 26
    //   471: invokevirtual 496	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   474: lload 13
    //   476: lconst_0
    //   477: ladd
    //   478: lstore 13
    //   480: lload 13
    //   482: lconst_0
    //   483: lcmp
    //   484: ifeq +25 -> 509
    //   487: aload_1
    //   488: invokevirtual 232	bbmu:e	()Ljava/lang/String;
    //   491: ldc 230
    //   493: invokevirtual 186	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   496: ifeq +58 -> 554
    //   499: iconst_1
    //   500: istore_3
    //   501: aload_0
    //   502: aload_1
    //   503: iload_3
    //   504: lload 13
    //   506: invokevirtual 770	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;ZJ)V
    //   509: iconst_0
    //   510: ifeq +11 -> 521
    //   513: new 772	java/lang/NullPointerException
    //   516: dup
    //   517: invokespecial 773	java/lang/NullPointerException:<init>	()V
    //   520: athrow
    //   521: iconst_0
    //   522: ifeq +11 -> 533
    //   525: new 772	java/lang/NullPointerException
    //   528: dup
    //   529: invokespecial 773	java/lang/NullPointerException:<init>	()V
    //   532: athrow
    //   533: aload 25
    //   535: ifnull +8 -> 543
    //   538: aload 25
    //   540: invokevirtual 775	java/io/OutputStream:close	()V
    //   543: aload 24
    //   545: ifnull +8 -> 553
    //   548: aload 24
    //   550: invokevirtual 778	java/net/HttpURLConnection:disconnect	()V
    //   553: return
    //   554: iconst_0
    //   555: istore_3
    //   556: goto -55 -> 501
    //   559: astore_1
    //   560: aload_1
    //   561: invokevirtual 607	java/lang/Exception:printStackTrace	()V
    //   564: return
    //   565: aload_0
    //   566: getfield 381	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   569: ifnull +17 -> 586
    //   572: aload 26
    //   574: ifnull +12 -> 586
    //   577: aload_0
    //   578: getfield 381	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   581: aload 26
    //   583: invokevirtual 496	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   586: aload_0
    //   587: aload_1
    //   588: ldc_w 780
    //   591: new 246	java/lang/StringBuilder
    //   594: dup
    //   595: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   598: ldc_w 782
    //   601: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: iload 5
    //   606: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   609: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   612: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   615: iload 5
    //   617: sipush 302
    //   620: if_icmpeq +11 -> 631
    //   623: iload 5
    //   625: sipush 301
    //   628: if_icmpne +1584 -> 2212
    //   631: iload 6
    //   633: iconst_5
    //   634: if_icmpge +1289 -> 1923
    //   637: aload_0
    //   638: aload_1
    //   639: ldc_w 784
    //   642: new 246	java/lang/StringBuilder
    //   645: dup
    //   646: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   649: ldc_w 786
    //   652: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: aload_1
    //   656: getfield 365	bbmu:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   659: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: ldc_w 788
    //   665: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: aload_1
    //   669: getfield 544	bbmu:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   672: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   678: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   681: aload 24
    //   683: ldc_w 790
    //   686: invokevirtual 549	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   689: astore 32
    //   691: aload 32
    //   693: ifnull +758 -> 1451
    //   696: aload 25
    //   698: ifnull +8 -> 706
    //   701: aload 25
    //   703: invokevirtual 775	java/io/OutputStream:close	()V
    //   706: aload 24
    //   708: invokevirtual 778	java/net/HttpURLConnection:disconnect	()V
    //   711: iload 6
    //   713: ifne +377 -> 1090
    //   716: aload_1
    //   717: getfield 793	bbmu:l	Z
    //   720: istore 12
    //   722: iload 12
    //   724: ifeq +366 -> 1090
    //   727: aload_1
    //   728: getfield 795	bbmu:jdField_h_of_type_Boolean	Z
    //   731: ifeq +322 -> 1053
    //   734: aload_1
    //   735: invokevirtual 798	bbmu:a	()Ljava/util/HashMap;
    //   738: ldc_w 411
    //   741: invokevirtual 800	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   744: checkcast 135	java/lang/String
    //   747: astore 23
    //   749: aload 23
    //   751: invokestatic 806	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   754: ifne +336 -> 1090
    //   757: aload 23
    //   759: ldc_w 808
    //   762: invokevirtual 186	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   765: ifeq +325 -> 1090
    //   768: new 320	java/net/URL
    //   771: dup
    //   772: aload 32
    //   774: invokespecial 323	java/net/URL:<init>	(Ljava/lang/String;)V
    //   777: invokevirtual 811	java/net/URL:getHost	()Ljava/lang/String;
    //   780: invokestatic 816	auom:a	(Ljava/lang/String;)Z
    //   783: istore 12
    //   785: iload 12
    //   787: ifne +303 -> 1090
    //   790: iload 5
    //   792: sipush 200
    //   795: if_icmpeq +11 -> 806
    //   798: iload 5
    //   800: sipush 206
    //   803: if_icmpne +31 -> 834
    //   806: aload_0
    //   807: aload_1
    //   808: ldc_w 755
    //   811: new 246	java/lang/StringBuilder
    //   814: dup
    //   815: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   818: ldc_w 757
    //   821: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: iconst_0
    //   825: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   828: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   831: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   834: aload_2
    //   835: ifnull +13 -> 848
    //   838: aload_2
    //   839: getfield 636	bbms:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   842: invokevirtual 441	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   845: ifne +101 -> 946
    //   848: aload_0
    //   849: aload_1
    //   850: ldc_w 759
    //   853: new 246	java/lang/StringBuilder
    //   856: dup
    //   857: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   860: ldc_w 761
    //   863: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: aload_1
    //   867: invokevirtual 763	bbmu:d	()Ljava/lang/String;
    //   870: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: ldc_w 765
    //   876: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: aload_1
    //   880: invokevirtual 767	bbmu:c	()Ljava/lang/String;
    //   883: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   889: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   892: aload_1
    //   893: getfield 818	bbmu:jdField_f_of_type_Int	I
    //   896: sipush -9527
    //   899: if_icmpne +47 -> 946
    //   902: aload_0
    //   903: aload_1
    //   904: ldc_w 820
    //   907: new 246	java/lang/StringBuilder
    //   910: dup
    //   911: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   914: ldc_w 786
    //   917: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: aload_1
    //   921: getfield 365	bbmu:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   924: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: ldc_w 788
    //   930: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   933: aload_1
    //   934: getfield 544	bbmu:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   937: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   943: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   946: aload_0
    //   947: getfield 381	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   950: ifnull +17 -> 967
    //   953: aload 26
    //   955: ifnull +12 -> 967
    //   958: aload_0
    //   959: getfield 381	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   962: aload 26
    //   964: invokevirtual 496	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   967: lload 13
    //   969: lconst_0
    //   970: ladd
    //   971: lstore 13
    //   973: lload 13
    //   975: lconst_0
    //   976: lcmp
    //   977: ifeq +25 -> 1002
    //   980: aload_1
    //   981: invokevirtual 232	bbmu:e	()Ljava/lang/String;
    //   984: ldc 230
    //   986: invokevirtual 186	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   989: ifeq +83 -> 1072
    //   992: iconst_1
    //   993: istore_3
    //   994: aload_0
    //   995: aload_1
    //   996: iload_3
    //   997: lload 13
    //   999: invokevirtual 770	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;ZJ)V
    //   1002: iconst_0
    //   1003: ifeq +11 -> 1014
    //   1006: new 772	java/lang/NullPointerException
    //   1009: dup
    //   1010: invokespecial 773	java/lang/NullPointerException:<init>	()V
    //   1013: athrow
    //   1014: iconst_0
    //   1015: ifeq +11 -> 1026
    //   1018: new 772	java/lang/NullPointerException
    //   1021: dup
    //   1022: invokespecial 773	java/lang/NullPointerException:<init>	()V
    //   1025: athrow
    //   1026: aload 25
    //   1028: ifnull +8 -> 1036
    //   1031: aload 25
    //   1033: invokevirtual 775	java/io/OutputStream:close	()V
    //   1036: aload 24
    //   1038: ifnull -485 -> 553
    //   1041: aload 24
    //   1043: invokevirtual 778	java/net/HttpURLConnection:disconnect	()V
    //   1046: return
    //   1047: astore_1
    //   1048: aload_1
    //   1049: invokevirtual 607	java/lang/Exception:printStackTrace	()V
    //   1052: return
    //   1053: new 320	java/net/URL
    //   1056: dup
    //   1057: aload_1
    //   1058: invokevirtual 122	bbmu:a	()Ljava/lang/String;
    //   1061: invokespecial 323	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1064: invokevirtual 811	java/net/URL:getHost	()Ljava/lang/String;
    //   1067: astore 23
    //   1069: goto -320 -> 749
    //   1072: iconst_0
    //   1073: istore_3
    //   1074: goto -80 -> 994
    //   1077: astore 23
    //   1079: aload_0
    //   1080: aload_1
    //   1081: ldc_w 822
    //   1084: ldc_w 824
    //   1087: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   1090: aload_1
    //   1091: invokevirtual 826	bbmu:b	()Z
    //   1094: ifne +226 -> 1320
    //   1097: aload 31
    //   1099: aload 32
    //   1101: invokeinterface 827 2 0
    //   1106: iload 5
    //   1108: sipush 200
    //   1111: if_icmpeq +11 -> 1122
    //   1114: iload 5
    //   1116: sipush 206
    //   1119: if_icmpne +31 -> 1150
    //   1122: aload_0
    //   1123: aload_1
    //   1124: ldc_w 755
    //   1127: new 246	java/lang/StringBuilder
    //   1130: dup
    //   1131: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   1134: ldc_w 757
    //   1137: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: iconst_0
    //   1141: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1144: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1147: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   1150: aload_2
    //   1151: ifnull +13 -> 1164
    //   1154: aload_2
    //   1155: getfield 636	bbms:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1158: invokevirtual 441	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1161: ifne +47 -> 1208
    //   1164: aload_0
    //   1165: aload_1
    //   1166: ldc_w 759
    //   1169: new 246	java/lang/StringBuilder
    //   1172: dup
    //   1173: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   1176: ldc_w 761
    //   1179: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1182: aload_1
    //   1183: invokevirtual 763	bbmu:d	()Ljava/lang/String;
    //   1186: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1189: ldc_w 765
    //   1192: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1195: aload_1
    //   1196: invokevirtual 767	bbmu:c	()Ljava/lang/String;
    //   1199: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1202: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1205: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   1208: aload_0
    //   1209: getfield 381	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1212: ifnull +17 -> 1229
    //   1215: aload 26
    //   1217: ifnull +12 -> 1229
    //   1220: aload_0
    //   1221: getfield 381	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1224: aload 26
    //   1226: invokevirtual 496	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1229: lload 13
    //   1231: lconst_0
    //   1232: ladd
    //   1233: lstore 13
    //   1235: lload 13
    //   1237: lconst_0
    //   1238: lcmp
    //   1239: ifeq +25 -> 1264
    //   1242: aload_1
    //   1243: invokevirtual 232	bbmu:e	()Ljava/lang/String;
    //   1246: ldc 230
    //   1248: invokevirtual 186	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1251: ifeq +64 -> 1315
    //   1254: iconst_1
    //   1255: istore_3
    //   1256: aload_0
    //   1257: aload_1
    //   1258: iload_3
    //   1259: lload 13
    //   1261: invokevirtual 770	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;ZJ)V
    //   1264: iconst_0
    //   1265: ifeq +11 -> 1276
    //   1268: new 772	java/lang/NullPointerException
    //   1271: dup
    //   1272: invokespecial 773	java/lang/NullPointerException:<init>	()V
    //   1275: athrow
    //   1276: iconst_0
    //   1277: ifeq +11 -> 1288
    //   1280: new 772	java/lang/NullPointerException
    //   1283: dup
    //   1284: invokespecial 773	java/lang/NullPointerException:<init>	()V
    //   1287: athrow
    //   1288: aload 25
    //   1290: ifnull +8 -> 1298
    //   1293: aload 25
    //   1295: invokevirtual 775	java/io/OutputStream:close	()V
    //   1298: aload 24
    //   1300: ifnull -747 -> 553
    //   1303: aload 24
    //   1305: invokevirtual 778	java/net/HttpURLConnection:disconnect	()V
    //   1308: return
    //   1309: astore_1
    //   1310: aload_1
    //   1311: invokevirtual 607	java/lang/Exception:printStackTrace	()V
    //   1314: return
    //   1315: iconst_0
    //   1316: istore_3
    //   1317: goto -61 -> 1256
    //   1320: aload_1
    //   1321: getfield 828	bbmu:jdField_c_of_type_Boolean	Z
    //   1324: ifeq +12 -> 1336
    //   1327: aload 31
    //   1329: aload 32
    //   1331: invokeinterface 827 2 0
    //   1336: aload_1
    //   1337: getfield 831	bbmu:i	Z
    //   1340: ifne +14 -> 1354
    //   1343: aload_1
    //   1344: ldc_w 833
    //   1347: aload_1
    //   1348: invokevirtual 122	bbmu:a	()Ljava/lang/String;
    //   1351: invokevirtual 835	bbmu:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1354: aload_1
    //   1355: aload 32
    //   1357: invokevirtual 836	bbmu:a	(Ljava/lang/String;)V
    //   1360: aload_1
    //   1361: getfield 795	bbmu:jdField_h_of_type_Boolean	Z
    //   1364: ifeq +56 -> 1420
    //   1367: aload 32
    //   1369: invokestatic 840	ayxg:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1372: astore 23
    //   1374: aload 23
    //   1376: invokestatic 806	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1379: ifne +12 -> 1391
    //   1382: aload_1
    //   1383: ldc_w 411
    //   1386: aload 23
    //   1388: invokevirtual 835	bbmu:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1391: aload_0
    //   1392: aload_1
    //   1393: ldc_w 784
    //   1396: new 246	java/lang/StringBuilder
    //   1399: dup
    //   1400: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   1403: ldc_w 842
    //   1406: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1409: aload 23
    //   1411: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1414: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1417: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   1420: aload_1
    //   1421: ldc_w 844
    //   1424: invokevirtual 846	bbmu:b	(Ljava/lang/String;)V
    //   1427: iload 6
    //   1429: iconst_1
    //   1430: iadd
    //   1431: istore 6
    //   1433: iload 5
    //   1435: istore 4
    //   1437: aload 25
    //   1439: astore 23
    //   1441: iconst_1
    //   1442: istore 11
    //   1444: aload 26
    //   1446: astore 25
    //   1448: goto -1389 -> 59
    //   1451: new 648	java/io/IOException
    //   1454: dup
    //   1455: ldc_w 848
    //   1458: invokespecial 651	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1461: athrow
    //   1462: astore 29
    //   1464: aload 26
    //   1466: astore 28
    //   1468: iconst_0
    //   1469: istore 6
    //   1471: iconst_1
    //   1472: istore_3
    //   1473: lconst_0
    //   1474: lstore 17
    //   1476: iload 5
    //   1478: istore 4
    //   1480: aload 24
    //   1482: astore 23
    //   1484: aconst_null
    //   1485: astore 24
    //   1487: aconst_null
    //   1488: astore 27
    //   1490: aload 25
    //   1492: astore 26
    //   1494: aload 24
    //   1496: astore 25
    //   1498: lload 13
    //   1500: lstore 15
    //   1502: lload 17
    //   1504: lstore 13
    //   1506: iload 6
    //   1508: istore 5
    //   1510: aload 28
    //   1512: astore 24
    //   1514: aload 29
    //   1516: astore 28
    //   1518: iconst_1
    //   1519: istore 6
    //   1521: aload 28
    //   1523: instanceof 648
    //   1526: istore 11
    //   1528: iload 11
    //   1530: ifeq +62 -> 1592
    //   1533: aload 23
    //   1535: ifnull +57 -> 1592
    //   1538: aconst_null
    //   1539: astore 30
    //   1541: aload 23
    //   1543: invokevirtual 852	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   1546: astore 29
    //   1548: aload 29
    //   1550: astore 30
    //   1552: sipush 10240
    //   1555: newarray byte
    //   1557: astore 32
    //   1559: aload 29
    //   1561: ifnull +21 -> 1582
    //   1564: aload 29
    //   1566: astore 30
    //   1568: aload 29
    //   1570: aload 32
    //   1572: invokevirtual 858	java/io/InputStream:read	([B)I
    //   1575: istore 7
    //   1577: iload 7
    //   1579: ifgt -15 -> 1564
    //   1582: aload 29
    //   1584: ifnull +8 -> 1592
    //   1587: aload 29
    //   1589: invokevirtual 859	java/io/InputStream:close	()V
    //   1592: aload_0
    //   1593: iload_3
    //   1594: iload 4
    //   1596: aload 23
    //   1598: aload_1
    //   1599: aload 28
    //   1601: invokevirtual 862	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(ZILjava/net/HttpURLConnection;Lbbmu;Ljava/lang/Throwable;)V
    //   1604: iload_3
    //   1605: ifeq +48 -> 1653
    //   1608: iload 4
    //   1610: sipush 200
    //   1613: if_icmpeq +11 -> 1624
    //   1616: iload 4
    //   1618: sipush 206
    //   1621: if_icmpne +32 -> 1653
    //   1624: aload_0
    //   1625: aload_1
    //   1626: ldc_w 755
    //   1629: new 246	java/lang/StringBuilder
    //   1632: dup
    //   1633: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   1636: ldc_w 757
    //   1639: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1642: iload 5
    //   1644: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1647: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1650: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   1653: aload_2
    //   1654: ifnull +13 -> 1667
    //   1657: aload_2
    //   1658: getfield 636	bbms:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1661: invokevirtual 441	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1664: ifne +101 -> 1765
    //   1667: aload_0
    //   1668: aload_1
    //   1669: ldc_w 759
    //   1672: new 246	java/lang/StringBuilder
    //   1675: dup
    //   1676: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   1679: ldc_w 761
    //   1682: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1685: aload_1
    //   1686: invokevirtual 763	bbmu:d	()Ljava/lang/String;
    //   1689: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1692: ldc_w 765
    //   1695: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1698: aload_1
    //   1699: invokevirtual 767	bbmu:c	()Ljava/lang/String;
    //   1702: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1705: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1708: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   1711: aload_1
    //   1712: getfield 818	bbmu:jdField_f_of_type_Int	I
    //   1715: sipush -9527
    //   1718: if_icmpne +47 -> 1765
    //   1721: aload_0
    //   1722: aload_1
    //   1723: ldc_w 820
    //   1726: new 246	java/lang/StringBuilder
    //   1729: dup
    //   1730: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   1733: ldc_w 786
    //   1736: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1739: aload_1
    //   1740: getfield 365	bbmu:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1743: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1746: ldc_w 788
    //   1749: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1752: aload_1
    //   1753: getfield 544	bbmu:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1756: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1759: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1762: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   1765: aload_0
    //   1766: getfield 381	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1769: ifnull +17 -> 1786
    //   1772: aload 24
    //   1774: ifnull +12 -> 1786
    //   1777: aload_0
    //   1778: getfield 381	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1781: aload 24
    //   1783: invokevirtual 496	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1786: lload 15
    //   1788: lload 13
    //   1790: ladd
    //   1791: lstore 13
    //   1793: lload 13
    //   1795: lconst_0
    //   1796: lcmp
    //   1797: ifeq +25 -> 1822
    //   1800: aload_1
    //   1801: invokevirtual 232	bbmu:e	()Ljava/lang/String;
    //   1804: ldc 230
    //   1806: invokevirtual 186	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1809: ifeq +2549 -> 4358
    //   1812: iconst_1
    //   1813: istore_3
    //   1814: aload_0
    //   1815: aload_1
    //   1816: iload_3
    //   1817: lload 13
    //   1819: invokevirtual 770	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;ZJ)V
    //   1822: aload 25
    //   1824: ifnull +8 -> 1832
    //   1827: aload 25
    //   1829: invokevirtual 865	java/io/ByteArrayOutputStream:close	()V
    //   1832: aload 27
    //   1834: ifnull +8 -> 1842
    //   1837: aload 27
    //   1839: invokevirtual 859	java/io/InputStream:close	()V
    //   1842: aload 26
    //   1844: ifnull +8 -> 1852
    //   1847: aload 26
    //   1849: invokevirtual 775	java/io/OutputStream:close	()V
    //   1852: iload 6
    //   1854: istore 5
    //   1856: aload 23
    //   1858: ifnull +12 -> 1870
    //   1861: aload 23
    //   1863: invokevirtual 778	java/net/HttpURLConnection:disconnect	()V
    //   1866: iload 6
    //   1868: istore 5
    //   1870: aload_2
    //   1871: ifnull +13 -> 1884
    //   1874: aload_2
    //   1875: getfield 636	bbms:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1878: invokevirtual 441	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1881: ifne -1328 -> 553
    //   1884: aload_1
    //   1885: getfield 652	bbmu:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1888: invokevirtual 441	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1891: ifne -1338 -> 553
    //   1894: iload 5
    //   1896: ifeq +2494 -> 4390
    //   1899: aload 31
    //   1901: aload_1
    //   1902: aload_1
    //   1903: invokeinterface 462 3 0
    //   1908: return
    //   1909: astore_2
    //   1910: aload_0
    //   1911: aload_1
    //   1912: ldc_w 867
    //   1915: aload_2
    //   1916: invokestatic 873	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1919: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   1922: return
    //   1923: new 115	java/lang/Exception
    //   1926: dup
    //   1927: ldc_w 875
    //   1930: invokespecial 876	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1933: athrow
    //   1934: astore 23
    //   1936: iconst_0
    //   1937: istore 4
    //   1939: iload 11
    //   1941: istore_3
    //   1942: iload 7
    //   1944: istore 6
    //   1946: iload_3
    //   1947: ifeq +48 -> 1995
    //   1950: iload 5
    //   1952: sipush 200
    //   1955: if_icmpeq +11 -> 1966
    //   1958: iload 5
    //   1960: sipush 206
    //   1963: if_icmpne +32 -> 1995
    //   1966: aload_0
    //   1967: aload_1
    //   1968: ldc_w 755
    //   1971: new 246	java/lang/StringBuilder
    //   1974: dup
    //   1975: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   1978: ldc_w 757
    //   1981: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1984: iload 6
    //   1986: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1989: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1992: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   1995: aload_2
    //   1996: ifnull +13 -> 2009
    //   1999: aload_2
    //   2000: getfield 636	bbms:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2003: invokevirtual 441	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   2006: ifne +106 -> 2112
    //   2009: aload_0
    //   2010: aload_1
    //   2011: ldc_w 759
    //   2014: new 246	java/lang/StringBuilder
    //   2017: dup
    //   2018: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   2021: ldc_w 761
    //   2024: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2027: aload_1
    //   2028: invokevirtual 763	bbmu:d	()Ljava/lang/String;
    //   2031: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2034: ldc_w 765
    //   2037: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2040: aload_1
    //   2041: invokevirtual 767	bbmu:c	()Ljava/lang/String;
    //   2044: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2047: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2050: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   2053: iload 4
    //   2055: ifeq +57 -> 2112
    //   2058: aload_1
    //   2059: getfield 818	bbmu:jdField_f_of_type_Int	I
    //   2062: sipush -9527
    //   2065: if_icmpne +47 -> 2112
    //   2068: aload_0
    //   2069: aload_1
    //   2070: ldc_w 820
    //   2073: new 246	java/lang/StringBuilder
    //   2076: dup
    //   2077: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   2080: ldc_w 786
    //   2083: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2086: aload_1
    //   2087: getfield 365	bbmu:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2090: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2093: ldc_w 788
    //   2096: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2099: aload_1
    //   2100: getfield 544	bbmu:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2103: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2106: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2109: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   2112: aload_0
    //   2113: getfield 381	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2116: ifnull +17 -> 2133
    //   2119: aload 26
    //   2121: ifnull +12 -> 2133
    //   2124: aload_0
    //   2125: getfield 381	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2128: aload 26
    //   2130: invokevirtual 496	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   2133: lload 13
    //   2135: lload 15
    //   2137: ladd
    //   2138: lstore 13
    //   2140: lload 13
    //   2142: lconst_0
    //   2143: lcmp
    //   2144: ifeq +25 -> 2169
    //   2147: aload_1
    //   2148: invokevirtual 232	bbmu:e	()Ljava/lang/String;
    //   2151: ldc 230
    //   2153: invokevirtual 186	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2156: ifeq +2221 -> 4377
    //   2159: iconst_1
    //   2160: istore_3
    //   2161: aload_0
    //   2162: aload_1
    //   2163: iload_3
    //   2164: lload 13
    //   2166: invokevirtual 770	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;ZJ)V
    //   2169: aload 28
    //   2171: ifnull +8 -> 2179
    //   2174: aload 28
    //   2176: invokevirtual 865	java/io/ByteArrayOutputStream:close	()V
    //   2179: aload 27
    //   2181: ifnull +8 -> 2189
    //   2184: aload 27
    //   2186: invokevirtual 859	java/io/InputStream:close	()V
    //   2189: aload 25
    //   2191: ifnull +8 -> 2199
    //   2194: aload 25
    //   2196: invokevirtual 775	java/io/OutputStream:close	()V
    //   2199: aload 24
    //   2201: ifnull +8 -> 2209
    //   2204: aload 24
    //   2206: invokevirtual 778	java/net/HttpURLConnection:disconnect	()V
    //   2209: aload 23
    //   2211: athrow
    //   2212: aload_0
    //   2213: aload_1
    //   2214: aconst_null
    //   2215: iconst_2
    //   2216: iload_3
    //   2217: invokespecial 688	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Lbbmu;IZ)V
    //   2220: iload 5
    //   2222: sipush 200
    //   2225: if_icmpeq +11 -> 2236
    //   2228: iload 5
    //   2230: sipush 206
    //   2233: if_icmpne +1685 -> 3918
    //   2236: aload 24
    //   2238: invokevirtual 538	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   2241: astore 23
    //   2243: aload 23
    //   2245: ifnonnull +280 -> 2525
    //   2248: ldc_w 490
    //   2251: astore 23
    //   2253: iload_3
    //   2254: ifne +281 -> 2535
    //   2257: aload_1
    //   2258: getfield 877	bbmu:jdField_b_of_type_Boolean	Z
    //   2261: ifeq +274 -> 2535
    //   2264: aload 23
    //   2266: ldc_w 879
    //   2269: invokevirtual 882	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2272: iconst_m1
    //   2273: if_icmpne +15 -> 2288
    //   2276: aload 23
    //   2278: ldc_w 884
    //   2281: invokevirtual 882	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2284: iconst_m1
    //   2285: if_icmpeq +250 -> 2535
    //   2288: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2291: ifeq +18 -> 2309
    //   2294: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2297: ifeq +12 -> 2309
    //   2300: ldc 70
    //   2302: iconst_2
    //   2303: ldc_w 886
    //   2306: invokestatic 454	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2309: aload_0
    //   2310: aload_1
    //   2311: aload_2
    //   2312: iconst_1
    //   2313: invokevirtual 888	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Lbbms;Z)V
    //   2316: iload 5
    //   2318: sipush 200
    //   2321: if_icmpeq +11 -> 2332
    //   2324: iload 5
    //   2326: sipush 206
    //   2329: if_icmpne +31 -> 2360
    //   2332: aload_0
    //   2333: aload_1
    //   2334: ldc_w 755
    //   2337: new 246	java/lang/StringBuilder
    //   2340: dup
    //   2341: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   2344: ldc_w 757
    //   2347: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2350: iconst_0
    //   2351: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2354: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2357: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   2360: aload_2
    //   2361: ifnull +13 -> 2374
    //   2364: aload_2
    //   2365: getfield 636	bbms:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2368: invokevirtual 441	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   2371: ifne +47 -> 2418
    //   2374: aload_0
    //   2375: aload_1
    //   2376: ldc_w 759
    //   2379: new 246	java/lang/StringBuilder
    //   2382: dup
    //   2383: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   2386: ldc_w 761
    //   2389: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2392: aload_1
    //   2393: invokevirtual 763	bbmu:d	()Ljava/lang/String;
    //   2396: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2399: ldc_w 765
    //   2402: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2405: aload_1
    //   2406: invokevirtual 767	bbmu:c	()Ljava/lang/String;
    //   2409: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2412: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2415: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   2418: aload_0
    //   2419: getfield 381	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2422: ifnull +17 -> 2439
    //   2425: aload 26
    //   2427: ifnull +12 -> 2439
    //   2430: aload_0
    //   2431: getfield 381	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2434: aload 26
    //   2436: invokevirtual 496	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   2439: lload 13
    //   2441: lconst_0
    //   2442: ladd
    //   2443: lstore 13
    //   2445: lload 13
    //   2447: lconst_0
    //   2448: lcmp
    //   2449: ifeq +25 -> 2474
    //   2452: aload_1
    //   2453: invokevirtual 232	bbmu:e	()Ljava/lang/String;
    //   2456: ldc 230
    //   2458: invokevirtual 186	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2461: ifeq +2887 -> 5348
    //   2464: iconst_1
    //   2465: istore_3
    //   2466: aload_0
    //   2467: aload_1
    //   2468: iload_3
    //   2469: lload 13
    //   2471: invokevirtual 770	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;ZJ)V
    //   2474: iconst_0
    //   2475: ifeq +11 -> 2486
    //   2478: new 772	java/lang/NullPointerException
    //   2481: dup
    //   2482: invokespecial 773	java/lang/NullPointerException:<init>	()V
    //   2485: athrow
    //   2486: iconst_0
    //   2487: ifeq +11 -> 2498
    //   2490: new 772	java/lang/NullPointerException
    //   2493: dup
    //   2494: invokespecial 773	java/lang/NullPointerException:<init>	()V
    //   2497: athrow
    //   2498: aload 25
    //   2500: ifnull +8 -> 2508
    //   2503: aload 25
    //   2505: invokevirtual 775	java/io/OutputStream:close	()V
    //   2508: aload 24
    //   2510: ifnull -1957 -> 553
    //   2513: aload 24
    //   2515: invokevirtual 778	java/net/HttpURLConnection:disconnect	()V
    //   2518: return
    //   2519: astore_1
    //   2520: aload_1
    //   2521: invokevirtual 607	java/lang/Exception:printStackTrace	()V
    //   2524: return
    //   2525: aload 23
    //   2527: invokevirtual 891	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2530: astore 23
    //   2532: goto -279 -> 2253
    //   2535: aload_1
    //   2536: getfield 894	bbmu:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2539: ifnull +224 -> 2763
    //   2542: aload_1
    //   2543: getfield 894	bbmu:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2546: arraylength
    //   2547: ifle +216 -> 2763
    //   2550: aload 23
    //   2552: invokevirtual 746	java/lang/String:length	()I
    //   2555: ifle +208 -> 2763
    //   2558: iconst_0
    //   2559: istore 8
    //   2561: aload_1
    //   2562: getfield 894	bbmu:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2565: arraylength
    //   2566: iconst_1
    //   2567: if_icmpne +100 -> 2667
    //   2570: aload_1
    //   2571: getfield 894	bbmu:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2574: iconst_0
    //   2575: aaload
    //   2576: ifnull +91 -> 2667
    //   2579: aload_1
    //   2580: getfield 894	bbmu:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2583: iconst_0
    //   2584: aaload
    //   2585: invokevirtual 891	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2588: ldc_w 896
    //   2591: invokevirtual 186	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2594: ifeq +73 -> 2667
    //   2597: iconst_1
    //   2598: istore 4
    //   2600: iload 4
    //   2602: ifne +161 -> 2763
    //   2605: new 246	java/lang/StringBuilder
    //   2608: dup
    //   2609: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   2612: astore 29
    //   2614: aload_1
    //   2615: getfield 894	bbmu:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2618: astore 30
    //   2620: aload 30
    //   2622: arraylength
    //   2623: istore 6
    //   2625: iconst_0
    //   2626: istore 4
    //   2628: iload 4
    //   2630: iload 6
    //   2632: if_icmpge +88 -> 2720
    //   2635: aload 30
    //   2637: iload 4
    //   2639: aaload
    //   2640: astore 32
    //   2642: aload 32
    //   2644: ifnull +2709 -> 5353
    //   2647: aload 29
    //   2649: aload 32
    //   2651: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2654: pop
    //   2655: aload 29
    //   2657: ldc_w 898
    //   2660: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2663: pop
    //   2664: goto +2689 -> 5353
    //   2667: aload_1
    //   2668: getfield 894	bbmu:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2671: astore 30
    //   2673: aload 30
    //   2675: arraylength
    //   2676: istore 9
    //   2678: iconst_0
    //   2679: istore 6
    //   2681: iload 8
    //   2683: istore 4
    //   2685: iload 6
    //   2687: iload 9
    //   2689: if_icmpge -89 -> 2600
    //   2692: aload 30
    //   2694: iload 6
    //   2696: aaload
    //   2697: astore 29
    //   2699: aload 29
    //   2701: ifnull +2661 -> 5362
    //   2704: aload 23
    //   2706: aload 29
    //   2708: invokevirtual 901	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2711: ifeq +2651 -> 5362
    //   2714: iconst_1
    //   2715: istore 4
    //   2717: goto -117 -> 2600
    //   2720: new 648	java/io/IOException
    //   2723: dup
    //   2724: new 246	java/lang/StringBuilder
    //   2727: dup
    //   2728: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   2731: ldc_w 903
    //   2734: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2737: aload 23
    //   2739: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2742: ldc_w 905
    //   2745: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2748: aload 29
    //   2750: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2753: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2756: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2759: invokespecial 651	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   2762: athrow
    //   2763: aload_1
    //   2764: getfield 570	bbmu:jdField_a_of_type_Long	J
    //   2767: lconst_0
    //   2768: lcmp
    //   2769: ifne +26 -> 2795
    //   2772: aload_1
    //   2773: invokevirtual 232	bbmu:e	()Ljava/lang/String;
    //   2776: ldc 230
    //   2778: invokevirtual 186	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2781: ifne +14 -> 2795
    //   2784: new 648	java/io/IOException
    //   2787: dup
    //   2788: ldc_w 907
    //   2791: invokespecial 651	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   2794: athrow
    //   2795: aload_0
    //   2796: aload_1
    //   2797: ldc_w 909
    //   2800: new 246	java/lang/StringBuilder
    //   2803: dup
    //   2804: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   2807: ldc_w 911
    //   2810: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2813: aload_1
    //   2814: getfield 570	bbmu:jdField_a_of_type_Long	J
    //   2817: invokevirtual 602	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2820: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2823: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   2826: aload_1
    //   2827: getfield 699	bbmu:jdField_d_of_type_Long	J
    //   2830: lconst_0
    //   2831: lcmp
    //   2832: ifeq +15 -> 2847
    //   2835: aload_1
    //   2836: invokestatic 474	android/os/SystemClock:uptimeMillis	()J
    //   2839: aload_1
    //   2840: getfield 699	bbmu:jdField_d_of_type_Long	J
    //   2843: lsub
    //   2844: putfield 913	bbmu:jdField_e_of_type_Long	J
    //   2847: aload 31
    //   2849: aload_1
    //   2850: aload_1
    //   2851: iconst_3
    //   2852: invokeinterface 394 4 0
    //   2857: istore_3
    //   2858: iload_3
    //   2859: ifeq +2463 -> 5322
    //   2862: lconst_0
    //   2863: ldc2_w 747
    //   2866: ladd
    //   2867: lstore 15
    //   2869: aload 24
    //   2871: invokevirtual 916	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2874: astore 23
    //   2876: invokestatic 922	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   2879: astore 29
    //   2881: invokestatic 925	com/tencent/commonsdk/pool/ByteArrayPool:getMaxBufInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   2884: astore 27
    //   2886: aload_1
    //   2887: getfield 927	bbmu:jdField_e_of_type_Boolean	Z
    //   2890: ifeq +251 -> 3141
    //   2893: aload_1
    //   2894: invokevirtual 929	bbmu:a	()Z
    //   2897: ifne +244 -> 3141
    //   2900: new 931	bbfz
    //   2903: dup
    //   2904: aload 27
    //   2906: aload_1
    //   2907: getfield 570	bbmu:jdField_a_of_type_Long	J
    //   2910: l2i
    //   2911: invokespecial 934	bbfz:<init>	(Lcom/tencent/commonsdk/pool/ByteArrayPool;I)V
    //   2914: astore 27
    //   2916: aload_1
    //   2917: getfield 927	bbmu:jdField_e_of_type_Boolean	Z
    //   2920: ifeq +290 -> 3210
    //   2923: aload 29
    //   2925: sipush 10240
    //   2928: invokevirtual 938	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   2931: astore 28
    //   2933: iconst_0
    //   2934: istore 6
    //   2936: iconst_0
    //   2937: istore 4
    //   2939: iload 4
    //   2941: istore 9
    //   2943: lload 15
    //   2945: lstore 21
    //   2947: iload 4
    //   2949: istore 8
    //   2951: lload 15
    //   2953: lstore 17
    //   2955: aload 23
    //   2957: aload 28
    //   2959: iload 6
    //   2961: aload 28
    //   2963: arraylength
    //   2964: iload 6
    //   2966: isub
    //   2967: invokevirtual 941	java/io/InputStream:read	([BII)I
    //   2970: istore 7
    //   2972: iload 7
    //   2974: ifle +283 -> 3257
    //   2977: iload 4
    //   2979: istore 9
    //   2981: lload 15
    //   2983: lstore 21
    //   2985: iload 4
    //   2987: istore 8
    //   2989: lload 15
    //   2991: lstore 17
    //   2993: aload_0
    //   2994: aload_2
    //   2995: aload_1
    //   2996: invokevirtual 692	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbms;Lbbmu;)V
    //   2999: lload 15
    //   3001: iload 7
    //   3003: i2l
    //   3004: ladd
    //   3005: lstore 19
    //   3007: iload 6
    //   3009: iload 7
    //   3011: iadd
    //   3012: istore 10
    //   3014: iload 4
    //   3016: iload 7
    //   3018: iadd
    //   3019: istore 7
    //   3021: iload 7
    //   3023: istore 4
    //   3025: lload 19
    //   3027: lstore 15
    //   3029: iload 10
    //   3031: istore 6
    //   3033: iload 7
    //   3035: istore 9
    //   3037: lload 19
    //   3039: lstore 21
    //   3041: iload 7
    //   3043: istore 8
    //   3045: lload 19
    //   3047: lstore 17
    //   3049: iload 10
    //   3051: aload 28
    //   3053: arraylength
    //   3054: if_icmplt -115 -> 2939
    //   3057: iload 7
    //   3059: istore 9
    //   3061: lload 19
    //   3063: lstore 21
    //   3065: iload 7
    //   3067: istore 8
    //   3069: lload 19
    //   3071: lstore 17
    //   3073: aload_1
    //   3074: invokevirtual 929	bbmu:a	()Z
    //   3077: ifeq +143 -> 3220
    //   3080: iload 7
    //   3082: istore 9
    //   3084: lload 19
    //   3086: lstore 21
    //   3088: iload 7
    //   3090: istore 8
    //   3092: lload 19
    //   3094: lstore 17
    //   3096: aload_1
    //   3097: aload 28
    //   3099: invokevirtual 944	bbmu:a	([B)V
    //   3102: iload 7
    //   3104: istore 9
    //   3106: lload 19
    //   3108: lstore 21
    //   3110: iload 7
    //   3112: istore 8
    //   3114: lload 19
    //   3116: lstore 17
    //   3118: aload 31
    //   3120: aload_1
    //   3121: aload_1
    //   3122: invokeinterface 946 3 0
    //   3127: iconst_0
    //   3128: istore 6
    //   3130: iload 7
    //   3132: istore 4
    //   3134: lload 19
    //   3136: lstore 15
    //   3138: goto -199 -> 2939
    //   3141: new 864	java/io/ByteArrayOutputStream
    //   3144: dup
    //   3145: invokespecial 947	java/io/ByteArrayOutputStream:<init>	()V
    //   3148: astore 27
    //   3150: goto -234 -> 2916
    //   3153: astore 28
    //   3155: iconst_0
    //   3156: istore 6
    //   3158: iconst_1
    //   3159: istore_3
    //   3160: lload 15
    //   3162: lstore 17
    //   3164: aload 23
    //   3166: astore 27
    //   3168: iload 5
    //   3170: istore 4
    //   3172: aconst_null
    //   3173: astore 30
    //   3175: aload 24
    //   3177: astore 23
    //   3179: lload 13
    //   3181: lstore 15
    //   3183: aload 25
    //   3185: astore 29
    //   3187: aload 26
    //   3189: astore 24
    //   3191: iload 6
    //   3193: istore 5
    //   3195: lload 17
    //   3197: lstore 13
    //   3199: aload 30
    //   3201: astore 25
    //   3203: aload 29
    //   3205: astore 26
    //   3207: goto -1689 -> 1518
    //   3210: sipush 10240
    //   3213: newarray byte
    //   3215: astore 28
    //   3217: goto -284 -> 2933
    //   3220: iload 7
    //   3222: istore 9
    //   3224: lload 19
    //   3226: lstore 21
    //   3228: iload 7
    //   3230: istore 8
    //   3232: lload 19
    //   3234: lstore 17
    //   3236: aload 27
    //   3238: aload 28
    //   3240: invokevirtual 949	java/io/ByteArrayOutputStream:write	([B)V
    //   3243: iconst_0
    //   3244: istore 6
    //   3246: iload 7
    //   3248: istore 4
    //   3250: lload 19
    //   3252: lstore 15
    //   3254: goto -315 -> 2939
    //   3257: iload 4
    //   3259: istore 9
    //   3261: lload 15
    //   3263: lstore 21
    //   3265: iload 4
    //   3267: istore 8
    //   3269: lload 15
    //   3271: lstore 17
    //   3273: aload_1
    //   3274: invokevirtual 929	bbmu:a	()Z
    //   3277: ifeq +485 -> 3762
    //   3280: iload 6
    //   3282: ifle +99 -> 3381
    //   3285: iload 4
    //   3287: istore 9
    //   3289: lload 15
    //   3291: lstore 21
    //   3293: iload 4
    //   3295: istore 8
    //   3297: lload 15
    //   3299: lstore 17
    //   3301: iload 6
    //   3303: newarray byte
    //   3305: astore 30
    //   3307: iload 4
    //   3309: istore 9
    //   3311: lload 15
    //   3313: lstore 21
    //   3315: iload 4
    //   3317: istore 8
    //   3319: lload 15
    //   3321: lstore 17
    //   3323: aload 28
    //   3325: iconst_0
    //   3326: aload 30
    //   3328: iconst_0
    //   3329: iload 6
    //   3331: invokestatic 953	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3334: iload 4
    //   3336: istore 9
    //   3338: lload 15
    //   3340: lstore 21
    //   3342: iload 4
    //   3344: istore 8
    //   3346: lload 15
    //   3348: lstore 17
    //   3350: aload_1
    //   3351: aload 30
    //   3353: invokevirtual 944	bbmu:a	([B)V
    //   3356: iload 4
    //   3358: istore 9
    //   3360: lload 15
    //   3362: lstore 21
    //   3364: iload 4
    //   3366: istore 8
    //   3368: lload 15
    //   3370: lstore 17
    //   3372: aload 31
    //   3374: aload_1
    //   3375: aload_1
    //   3376: invokeinterface 946 3 0
    //   3381: iload 4
    //   3383: istore 9
    //   3385: lload 15
    //   3387: lstore 21
    //   3389: iload 4
    //   3391: istore 8
    //   3393: lload 15
    //   3395: lstore 17
    //   3397: aload_1
    //   3398: getfield 927	bbmu:jdField_e_of_type_Boolean	Z
    //   3401: ifeq +26 -> 3427
    //   3404: iload 4
    //   3406: istore 9
    //   3408: lload 15
    //   3410: lstore 21
    //   3412: iload 4
    //   3414: istore 8
    //   3416: lload 15
    //   3418: lstore 17
    //   3420: aload 29
    //   3422: aload 28
    //   3424: invokevirtual 956	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   3427: iload 4
    //   3429: istore 9
    //   3431: lload 15
    //   3433: lstore 21
    //   3435: iload 4
    //   3437: istore 8
    //   3439: lload 15
    //   3441: lstore 17
    //   3443: aload 27
    //   3445: invokevirtual 865	java/io/ByteArrayOutputStream:close	()V
    //   3448: aload 27
    //   3450: astore 28
    //   3452: aload 23
    //   3454: astore 27
    //   3456: aload 28
    //   3458: astore 23
    //   3460: aload 31
    //   3462: aload_1
    //   3463: aload_1
    //   3464: iconst_4
    //   3465: invokeinterface 394 4 0
    //   3470: pop
    //   3471: iload 4
    //   3473: istore 6
    //   3475: iconst_0
    //   3476: istore 4
    //   3478: iload 5
    //   3480: sipush 200
    //   3483: if_icmpeq +11 -> 3494
    //   3486: iload 5
    //   3488: sipush 206
    //   3491: if_icmpne +32 -> 3523
    //   3494: aload_0
    //   3495: aload_1
    //   3496: ldc_w 755
    //   3499: new 246	java/lang/StringBuilder
    //   3502: dup
    //   3503: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   3506: ldc_w 757
    //   3509: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3512: iload 6
    //   3514: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3517: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3520: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   3523: aload_2
    //   3524: ifnull +13 -> 3537
    //   3527: aload_2
    //   3528: getfield 636	bbms:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3531: invokevirtual 441	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   3534: ifne +106 -> 3640
    //   3537: aload_0
    //   3538: aload_1
    //   3539: ldc_w 759
    //   3542: new 246	java/lang/StringBuilder
    //   3545: dup
    //   3546: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   3549: ldc_w 761
    //   3552: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3555: aload_1
    //   3556: invokevirtual 763	bbmu:d	()Ljava/lang/String;
    //   3559: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3562: ldc_w 765
    //   3565: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3568: aload_1
    //   3569: invokevirtual 767	bbmu:c	()Ljava/lang/String;
    //   3572: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3575: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3578: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   3581: iload 4
    //   3583: ifeq +57 -> 3640
    //   3586: aload_1
    //   3587: getfield 818	bbmu:jdField_f_of_type_Int	I
    //   3590: sipush -9527
    //   3593: if_icmpne +47 -> 3640
    //   3596: aload_0
    //   3597: aload_1
    //   3598: ldc_w 820
    //   3601: new 246	java/lang/StringBuilder
    //   3604: dup
    //   3605: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   3608: ldc_w 786
    //   3611: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3614: aload_1
    //   3615: getfield 365	bbmu:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3618: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3621: ldc_w 788
    //   3624: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3627: aload_1
    //   3628: getfield 544	bbmu:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3631: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3634: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3637: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   3640: aload_0
    //   3641: getfield 381	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   3644: ifnull +17 -> 3661
    //   3647: aload 26
    //   3649: ifnull +12 -> 3661
    //   3652: aload_0
    //   3653: getfield 381	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   3656: aload 26
    //   3658: invokevirtual 496	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   3661: lload 15
    //   3663: lload 13
    //   3665: ladd
    //   3666: lstore 13
    //   3668: lload 13
    //   3670: lconst_0
    //   3671: lcmp
    //   3672: ifeq +25 -> 3697
    //   3675: aload_1
    //   3676: invokevirtual 232	bbmu:e	()Ljava/lang/String;
    //   3679: ldc 230
    //   3681: invokevirtual 186	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3684: ifeq +571 -> 4255
    //   3687: iconst_1
    //   3688: istore_3
    //   3689: aload_0
    //   3690: aload_1
    //   3691: iload_3
    //   3692: lload 13
    //   3694: invokevirtual 770	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;ZJ)V
    //   3697: aload 23
    //   3699: ifnull +8 -> 3707
    //   3702: aload 23
    //   3704: invokevirtual 865	java/io/ByteArrayOutputStream:close	()V
    //   3707: aload 27
    //   3709: ifnull +8 -> 3717
    //   3712: aload 27
    //   3714: invokevirtual 859	java/io/InputStream:close	()V
    //   3717: aload 25
    //   3719: ifnull +8 -> 3727
    //   3722: aload 25
    //   3724: invokevirtual 775	java/io/OutputStream:close	()V
    //   3727: iload 4
    //   3729: istore 5
    //   3731: aload 24
    //   3733: ifnull -1863 -> 1870
    //   3736: aload 24
    //   3738: invokevirtual 778	java/net/HttpURLConnection:disconnect	()V
    //   3741: iload 4
    //   3743: istore 5
    //   3745: goto -1875 -> 1870
    //   3748: astore 23
    //   3750: aload 23
    //   3752: invokevirtual 607	java/lang/Exception:printStackTrace	()V
    //   3755: iload 4
    //   3757: istore 5
    //   3759: goto -1889 -> 1870
    //   3762: iload 6
    //   3764: ifle +29 -> 3793
    //   3767: iload 4
    //   3769: istore 9
    //   3771: lload 15
    //   3773: lstore 21
    //   3775: iload 4
    //   3777: istore 8
    //   3779: lload 15
    //   3781: lstore 17
    //   3783: aload 27
    //   3785: aload 28
    //   3787: iconst_0
    //   3788: iload 6
    //   3790: invokevirtual 957	java/io/ByteArrayOutputStream:write	([BII)V
    //   3793: iload 4
    //   3795: istore 9
    //   3797: lload 15
    //   3799: lstore 21
    //   3801: iload 4
    //   3803: istore 8
    //   3805: lload 15
    //   3807: lstore 17
    //   3809: aload 27
    //   3811: invokevirtual 958	java/io/ByteArrayOutputStream:flush	()V
    //   3814: iload 4
    //   3816: istore 9
    //   3818: lload 15
    //   3820: lstore 21
    //   3822: iload 4
    //   3824: istore 8
    //   3826: lload 15
    //   3828: lstore 17
    //   3830: aload_1
    //   3831: aload 27
    //   3833: invokevirtual 961	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   3836: invokevirtual 944	bbmu:a	([B)V
    //   3839: iload 4
    //   3841: istore 9
    //   3843: lload 15
    //   3845: lstore 21
    //   3847: iload 4
    //   3849: istore 8
    //   3851: lload 15
    //   3853: lstore 17
    //   3855: aload 31
    //   3857: aload_1
    //   3858: aload_1
    //   3859: invokeinterface 946 3 0
    //   3864: goto -483 -> 3381
    //   3867: astore 28
    //   3869: aload 23
    //   3871: astore 29
    //   3873: aload 26
    //   3875: astore 30
    //   3877: iload 5
    //   3879: istore 4
    //   3881: iconst_1
    //   3882: istore_3
    //   3883: aload 24
    //   3885: astore 23
    //   3887: aload 25
    //   3889: astore 26
    //   3891: lload 13
    //   3893: lstore 15
    //   3895: aload 27
    //   3897: astore 25
    //   3899: aload 30
    //   3901: astore 24
    //   3903: iload 9
    //   3905: istore 5
    //   3907: lload 21
    //   3909: lstore 13
    //   3911: aload 29
    //   3913: astore 27
    //   3915: goto -2397 -> 1518
    //   3918: aload_1
    //   3919: getfield 189	bbmu:jdField_f_of_type_Boolean	Z
    //   3922: ifeq +300 -> 4222
    //   3925: aload_1
    //   3926: getfield 203	bbmu:jdField_h_of_type_Int	I
    //   3929: ifeq +293 -> 4222
    //   3932: aload_1
    //   3933: getfield 201	bbmu:jdField_g_of_type_Boolean	Z
    //   3936: ifne +286 -> 4222
    //   3939: aload_0
    //   3940: aload_1
    //   3941: ldc_w 963
    //   3944: ldc_w 965
    //   3947: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   3950: aload_1
    //   3951: iconst_1
    //   3952: putfield 201	bbmu:jdField_g_of_type_Boolean	Z
    //   3955: aload_0
    //   3956: aload_1
    //   3957: aload_2
    //   3958: iconst_0
    //   3959: invokevirtual 888	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Lbbms;Z)V
    //   3962: new 129	java/util/HashMap
    //   3965: dup
    //   3966: invokespecial 613	java/util/HashMap:<init>	()V
    //   3969: astore 23
    //   3971: aload 23
    //   3973: ldc_w 615
    //   3976: aload_1
    //   3977: getfield 203	bbmu:jdField_h_of_type_Int	I
    //   3980: invokestatic 617	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   3983: invokevirtual 621	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3986: pop
    //   3987: invokestatic 155	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3990: invokestatic 628	axrn:a	(Landroid/content/Context;)Laxrn;
    //   3993: aconst_null
    //   3994: ldc_w 967
    //   3997: iconst_0
    //   3998: lconst_0
    //   3999: lconst_0
    //   4000: aload 23
    //   4002: ldc_w 490
    //   4005: invokevirtual 633	axrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   4008: iload 5
    //   4010: sipush 200
    //   4013: if_icmpeq +11 -> 4024
    //   4016: iload 5
    //   4018: sipush 206
    //   4021: if_icmpne +31 -> 4052
    //   4024: aload_0
    //   4025: aload_1
    //   4026: ldc_w 755
    //   4029: new 246	java/lang/StringBuilder
    //   4032: dup
    //   4033: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   4036: ldc_w 757
    //   4039: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4042: iconst_0
    //   4043: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4046: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4049: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   4052: aload_2
    //   4053: ifnull +13 -> 4066
    //   4056: aload_2
    //   4057: getfield 636	bbms:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4060: invokevirtual 441	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   4063: ifne +47 -> 4110
    //   4066: aload_0
    //   4067: aload_1
    //   4068: ldc_w 759
    //   4071: new 246	java/lang/StringBuilder
    //   4074: dup
    //   4075: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   4078: ldc_w 761
    //   4081: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4084: aload_1
    //   4085: invokevirtual 763	bbmu:d	()Ljava/lang/String;
    //   4088: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4091: ldc_w 765
    //   4094: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4097: aload_1
    //   4098: invokevirtual 767	bbmu:c	()Ljava/lang/String;
    //   4101: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4104: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4107: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;Ljava/lang/String;Ljava/lang/String;)V
    //   4110: aload_0
    //   4111: getfield 381	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4114: ifnull +17 -> 4131
    //   4117: aload 26
    //   4119: ifnull +12 -> 4131
    //   4122: aload_0
    //   4123: getfield 381	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4126: aload 26
    //   4128: invokevirtual 496	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   4131: lload 13
    //   4133: lconst_0
    //   4134: ladd
    //   4135: lstore 13
    //   4137: lload 13
    //   4139: lconst_0
    //   4140: lcmp
    //   4141: ifeq +25 -> 4166
    //   4144: aload_1
    //   4145: invokevirtual 232	bbmu:e	()Ljava/lang/String;
    //   4148: ldc 230
    //   4150: invokevirtual 186	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4153: ifeq +64 -> 4217
    //   4156: iconst_1
    //   4157: istore_3
    //   4158: aload_0
    //   4159: aload_1
    //   4160: iload_3
    //   4161: lload 13
    //   4163: invokevirtual 770	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbbmu;ZJ)V
    //   4166: iconst_0
    //   4167: ifeq +11 -> 4178
    //   4170: new 772	java/lang/NullPointerException
    //   4173: dup
    //   4174: invokespecial 773	java/lang/NullPointerException:<init>	()V
    //   4177: athrow
    //   4178: iconst_0
    //   4179: ifeq +11 -> 4190
    //   4182: new 772	java/lang/NullPointerException
    //   4185: dup
    //   4186: invokespecial 773	java/lang/NullPointerException:<init>	()V
    //   4189: athrow
    //   4190: aload 25
    //   4192: ifnull +8 -> 4200
    //   4195: aload 25
    //   4197: invokevirtual 775	java/io/OutputStream:close	()V
    //   4200: aload 24
    //   4202: ifnull -3649 -> 553
    //   4205: aload 24
    //   4207: invokevirtual 778	java/net/HttpURLConnection:disconnect	()V
    //   4210: return
    //   4211: astore_1
    //   4212: aload_1
    //   4213: invokevirtual 607	java/lang/Exception:printStackTrace	()V
    //   4216: return
    //   4217: iconst_0
    //   4218: istore_3
    //   4219: goto -61 -> 4158
    //   4222: iconst_1
    //   4223: istore 4
    //   4225: aload_0
    //   4226: iload 5
    //   4228: aload 24
    //   4230: aload_1
    //   4231: invokevirtual 969	com/tencent/mobileqq/utils/httputils/HttpCommunicator:b	(ILjava/net/HttpURLConnection;Lbbmu;)V
    //   4234: lconst_0
    //   4235: lstore 15
    //   4237: iconst_1
    //   4238: istore 4
    //   4240: iload 8
    //   4242: istore 6
    //   4244: aload 30
    //   4246: astore 23
    //   4248: aload 29
    //   4250: astore 27
    //   4252: goto -774 -> 3478
    //   4255: iconst_0
    //   4256: istore_3
    //   4257: goto -568 -> 3689
    //   4260: astore 29
    //   4262: aload 30
    //   4264: ifnull -2672 -> 1592
    //   4267: aload 30
    //   4269: invokevirtual 859	java/io/InputStream:close	()V
    //   4272: goto -2680 -> 1592
    //   4275: astore 29
    //   4277: goto -2685 -> 1592
    //   4280: astore 28
    //   4282: aconst_null
    //   4283: astore 29
    //   4285: aload 29
    //   4287: ifnull +8 -> 4295
    //   4290: aload 29
    //   4292: invokevirtual 859	java/io/InputStream:close	()V
    //   4295: aload 28
    //   4297: athrow
    //   4298: astore 28
    //   4300: lload 15
    //   4302: lstore 17
    //   4304: aload 26
    //   4306: astore 30
    //   4308: aload 23
    //   4310: astore 29
    //   4312: iload 4
    //   4314: istore 7
    //   4316: iconst_1
    //   4317: istore 4
    //   4319: aload 28
    //   4321: astore 23
    //   4323: aload 24
    //   4325: astore 26
    //   4327: iload 5
    //   4329: istore 6
    //   4331: iload 7
    //   4333: istore 5
    //   4335: lload 13
    //   4337: lstore 15
    //   4339: lload 17
    //   4341: lstore 13
    //   4343: aload 25
    //   4345: astore 28
    //   4347: aload 30
    //   4349: astore 25
    //   4351: aload 29
    //   4353: astore 24
    //   4355: goto -2409 -> 1946
    //   4358: iconst_0
    //   4359: istore_3
    //   4360: goto -2546 -> 1814
    //   4363: astore 23
    //   4365: aload 23
    //   4367: invokevirtual 607	java/lang/Exception:printStackTrace	()V
    //   4370: iload 6
    //   4372: istore 5
    //   4374: goto -2504 -> 1870
    //   4377: iconst_0
    //   4378: istore_3
    //   4379: goto -2218 -> 2161
    //   4382: astore_1
    //   4383: aload_1
    //   4384: invokevirtual 607	java/lang/Exception:printStackTrace	()V
    //   4387: goto -2178 -> 2209
    //   4390: aload 31
    //   4392: aload_1
    //   4393: aload_1
    //   4394: iconst_5
    //   4395: invokeinterface 394 4 0
    //   4400: pop
    //   4401: return
    //   4402: astore_1
    //   4403: goto -3882 -> 521
    //   4406: astore_1
    //   4407: goto -3874 -> 533
    //   4410: astore_1
    //   4411: goto -3868 -> 543
    //   4414: astore_1
    //   4415: goto -3401 -> 1014
    //   4418: astore_1
    //   4419: goto -3393 -> 1026
    //   4422: astore_1
    //   4423: goto -3387 -> 1036
    //   4426: astore_1
    //   4427: goto -3151 -> 1276
    //   4430: astore_1
    //   4431: goto -3143 -> 1288
    //   4434: astore_1
    //   4435: goto -3137 -> 1298
    //   4438: astore_1
    //   4439: goto -1953 -> 2486
    //   4442: astore_1
    //   4443: goto -1945 -> 2498
    //   4446: astore_1
    //   4447: goto -1939 -> 2508
    //   4450: astore_1
    //   4451: goto -273 -> 4178
    //   4454: astore_1
    //   4455: goto -265 -> 4190
    //   4458: astore_1
    //   4459: goto -259 -> 4200
    //   4462: astore 23
    //   4464: goto -757 -> 3707
    //   4467: astore 23
    //   4469: goto -752 -> 3717
    //   4472: astore 23
    //   4474: goto -747 -> 3727
    //   4477: astore 29
    //   4479: goto -2887 -> 1592
    //   4482: astore 29
    //   4484: goto -189 -> 4295
    //   4487: astore 24
    //   4489: goto -2657 -> 1832
    //   4492: astore 24
    //   4494: goto -2652 -> 1842
    //   4497: astore 24
    //   4499: goto -2647 -> 1852
    //   4502: astore_1
    //   4503: goto -2324 -> 2179
    //   4506: astore_1
    //   4507: goto -2318 -> 2189
    //   4510: astore_1
    //   4511: goto -2312 -> 2199
    //   4514: astore 23
    //   4516: aconst_null
    //   4517: astore 26
    //   4519: iconst_0
    //   4520: istore_3
    //   4521: lconst_0
    //   4522: lstore 13
    //   4524: iconst_m1
    //   4525: istore 5
    //   4527: aconst_null
    //   4528: astore 25
    //   4530: aconst_null
    //   4531: astore 24
    //   4533: iconst_0
    //   4534: istore 4
    //   4536: iload 7
    //   4538: istore 6
    //   4540: goto -2594 -> 1946
    //   4543: astore 23
    //   4545: iload 4
    //   4547: istore 5
    //   4549: iconst_0
    //   4550: istore 4
    //   4552: iload 7
    //   4554: istore 6
    //   4556: iload 11
    //   4558: istore_3
    //   4559: goto -2613 -> 1946
    //   4562: astore 23
    //   4564: iload 4
    //   4566: istore 5
    //   4568: iconst_0
    //   4569: istore 4
    //   4571: iload 7
    //   4573: istore 6
    //   4575: iload 11
    //   4577: istore_3
    //   4578: goto -2632 -> 1946
    //   4581: astore 29
    //   4583: aload 25
    //   4585: astore 26
    //   4587: iload 11
    //   4589: istore_3
    //   4590: iload 4
    //   4592: istore 5
    //   4594: aload 23
    //   4596: astore 25
    //   4598: aload 29
    //   4600: astore 23
    //   4602: iconst_0
    //   4603: istore 4
    //   4605: iload 7
    //   4607: istore 6
    //   4609: goto -2663 -> 1946
    //   4612: astore 29
    //   4614: aload 25
    //   4616: astore 26
    //   4618: iload 11
    //   4620: istore_3
    //   4621: iload 4
    //   4623: istore 5
    //   4625: aload 23
    //   4627: astore 25
    //   4629: iconst_0
    //   4630: istore 4
    //   4632: aload 29
    //   4634: astore 23
    //   4636: iload 7
    //   4638: istore 6
    //   4640: goto -2694 -> 1946
    //   4643: astore 29
    //   4645: aload 25
    //   4647: astore 26
    //   4649: iload 4
    //   4651: istore 5
    //   4653: aload 23
    //   4655: astore 25
    //   4657: iconst_0
    //   4658: istore 4
    //   4660: aload 29
    //   4662: astore 23
    //   4664: iload 7
    //   4666: istore 6
    //   4668: iload 11
    //   4670: istore_3
    //   4671: goto -2725 -> 1946
    //   4674: astore 29
    //   4676: iload 4
    //   4678: istore 5
    //   4680: aload 23
    //   4682: astore 25
    //   4684: aload 29
    //   4686: astore 23
    //   4688: iconst_0
    //   4689: istore 4
    //   4691: iload 7
    //   4693: istore 6
    //   4695: iload 11
    //   4697: istore_3
    //   4698: goto -2752 -> 1946
    //   4701: astore 23
    //   4703: iconst_0
    //   4704: istore 4
    //   4706: iload 7
    //   4708: istore 6
    //   4710: iload 11
    //   4712: istore_3
    //   4713: goto -2767 -> 1946
    //   4716: astore 29
    //   4718: iconst_0
    //   4719: istore 4
    //   4721: aload 23
    //   4723: astore 27
    //   4725: aload 29
    //   4727: astore 23
    //   4729: iload 7
    //   4731: istore 6
    //   4733: iload 11
    //   4735: istore_3
    //   4736: goto -2790 -> 1946
    //   4739: astore 29
    //   4741: iconst_0
    //   4742: istore 4
    //   4744: aload 27
    //   4746: astore 28
    //   4748: aload 23
    //   4750: astore 27
    //   4752: aload 29
    //   4754: astore 23
    //   4756: iload 7
    //   4758: istore 6
    //   4760: iload 11
    //   4762: istore_3
    //   4763: goto -2817 -> 1946
    //   4766: astore 29
    //   4768: iload 8
    //   4770: istore 6
    //   4772: lload 17
    //   4774: lstore 15
    //   4776: aload 27
    //   4778: astore 28
    //   4780: aload 23
    //   4782: astore 27
    //   4784: iconst_0
    //   4785: istore 4
    //   4787: aload 29
    //   4789: astore 23
    //   4791: iload 11
    //   4793: istore_3
    //   4794: goto -2848 -> 1946
    //   4797: astore 29
    //   4799: iload 4
    //   4801: istore 6
    //   4803: aload 23
    //   4805: astore 28
    //   4807: aload 29
    //   4809: astore 23
    //   4811: iconst_0
    //   4812: istore 4
    //   4814: iload 11
    //   4816: istore_3
    //   4817: goto -2871 -> 1946
    //   4820: astore 23
    //   4822: iload 7
    //   4824: istore 6
    //   4826: iload 11
    //   4828: istore_3
    //   4829: goto -2883 -> 1946
    //   4832: astore 28
    //   4834: goto -549 -> 4285
    //   4837: astore 28
    //   4839: lconst_0
    //   4840: lstore 13
    //   4842: aconst_null
    //   4843: astore 25
    //   4845: aconst_null
    //   4846: astore 26
    //   4848: aconst_null
    //   4849: astore 24
    //   4851: aconst_null
    //   4852: astore 27
    //   4854: lconst_0
    //   4855: lstore 15
    //   4857: iconst_m1
    //   4858: istore 4
    //   4860: aconst_null
    //   4861: astore 23
    //   4863: iconst_0
    //   4864: istore 5
    //   4866: iload 11
    //   4868: istore_3
    //   4869: goto -3351 -> 1518
    //   4872: astore 28
    //   4874: aload 26
    //   4876: astore 27
    //   4878: iconst_0
    //   4879: istore 5
    //   4881: lconst_0
    //   4882: lstore 17
    //   4884: aload 25
    //   4886: astore 26
    //   4888: lload 13
    //   4890: lstore 15
    //   4892: iconst_1
    //   4893: istore_3
    //   4894: aconst_null
    //   4895: astore 29
    //   4897: aconst_null
    //   4898: astore 25
    //   4900: aload 24
    //   4902: astore 23
    //   4904: aload 27
    //   4906: astore 24
    //   4908: lload 17
    //   4910: lstore 13
    //   4912: aload 29
    //   4914: astore 27
    //   4916: goto -3398 -> 1518
    //   4919: astore 28
    //   4921: aload 26
    //   4923: astore 27
    //   4925: iconst_0
    //   4926: istore 5
    //   4928: iconst_1
    //   4929: istore_3
    //   4930: lconst_0
    //   4931: lstore 17
    //   4933: aload 25
    //   4935: astore 26
    //   4937: aload 24
    //   4939: astore 23
    //   4941: lload 13
    //   4943: lstore 15
    //   4945: aconst_null
    //   4946: astore 29
    //   4948: aconst_null
    //   4949: astore 25
    //   4951: aload 27
    //   4953: astore 24
    //   4955: lload 17
    //   4957: lstore 13
    //   4959: aload 29
    //   4961: astore 27
    //   4963: goto -3445 -> 1518
    //   4966: astore 28
    //   4968: lconst_0
    //   4969: lstore 17
    //   4971: aconst_null
    //   4972: astore 27
    //   4974: aload 23
    //   4976: astore 26
    //   4978: aconst_null
    //   4979: astore 29
    //   4981: iload 11
    //   4983: istore_3
    //   4984: lload 13
    //   4986: lstore 15
    //   4988: aload 24
    //   4990: astore 23
    //   4992: iconst_0
    //   4993: istore 5
    //   4995: aload 25
    //   4997: astore 24
    //   4999: lload 17
    //   5001: lstore 13
    //   5003: aload 27
    //   5005: astore 25
    //   5007: aload 29
    //   5009: astore 27
    //   5011: goto -3493 -> 1518
    //   5014: astore 28
    //   5016: iconst_0
    //   5017: istore 5
    //   5019: lconst_0
    //   5020: lstore 17
    //   5022: aconst_null
    //   5023: astore 29
    //   5025: aload 23
    //   5027: astore 26
    //   5029: lload 13
    //   5031: lstore 15
    //   5033: aconst_null
    //   5034: astore 27
    //   5036: iload 11
    //   5038: istore_3
    //   5039: aload 24
    //   5041: astore 23
    //   5043: aload 25
    //   5045: astore 24
    //   5047: lload 17
    //   5049: lstore 13
    //   5051: aload 29
    //   5053: astore 25
    //   5055: goto -3537 -> 1518
    //   5058: astore 28
    //   5060: iconst_0
    //   5061: istore 5
    //   5063: lconst_0
    //   5064: lstore 17
    //   5066: aload 23
    //   5068: astore 26
    //   5070: lload 13
    //   5072: lstore 15
    //   5074: aconst_null
    //   5075: astore 27
    //   5077: iconst_1
    //   5078: istore_3
    //   5079: aload 24
    //   5081: astore 23
    //   5083: aconst_null
    //   5084: astore 29
    //   5086: aload 25
    //   5088: astore 24
    //   5090: lload 17
    //   5092: lstore 13
    //   5094: aload 29
    //   5096: astore 25
    //   5098: goto -3580 -> 1518
    //   5101: astore 28
    //   5103: iconst_0
    //   5104: istore 5
    //   5106: iconst_1
    //   5107: istore_3
    //   5108: lconst_0
    //   5109: lstore 17
    //   5111: aload 23
    //   5113: astore 27
    //   5115: lload 13
    //   5117: lstore 15
    //   5119: aconst_null
    //   5120: astore 25
    //   5122: aconst_null
    //   5123: astore 29
    //   5125: aload 24
    //   5127: astore 23
    //   5129: aload 26
    //   5131: astore 24
    //   5133: lload 17
    //   5135: lstore 13
    //   5137: aload 27
    //   5139: astore 26
    //   5141: aload 29
    //   5143: astore 27
    //   5145: goto -3627 -> 1518
    //   5148: astore 28
    //   5150: iconst_0
    //   5151: istore 6
    //   5153: iconst_1
    //   5154: istore_3
    //   5155: aconst_null
    //   5156: astore 29
    //   5158: iload 5
    //   5160: istore 4
    //   5162: aconst_null
    //   5163: astore 30
    //   5165: lload 13
    //   5167: lstore 17
    //   5169: aload 24
    //   5171: astore 23
    //   5173: aload 25
    //   5175: astore 27
    //   5177: aload 26
    //   5179: astore 24
    //   5181: iload 6
    //   5183: istore 5
    //   5185: lload 15
    //   5187: lstore 13
    //   5189: lload 17
    //   5191: lstore 15
    //   5193: aload 30
    //   5195: astore 25
    //   5197: aload 27
    //   5199: astore 26
    //   5201: aload 29
    //   5203: astore 27
    //   5205: goto -3687 -> 1518
    //   5208: astore 28
    //   5210: iconst_0
    //   5211: istore 6
    //   5213: iconst_1
    //   5214: istore_3
    //   5215: aload 23
    //   5217: astore 29
    //   5219: iload 5
    //   5221: istore 4
    //   5223: aload 24
    //   5225: astore 23
    //   5227: lload 13
    //   5229: lstore 17
    //   5231: aload 25
    //   5233: astore 30
    //   5235: aload 26
    //   5237: astore 24
    //   5239: iload 6
    //   5241: istore 5
    //   5243: lload 15
    //   5245: lstore 13
    //   5247: lload 17
    //   5249: lstore 15
    //   5251: aload 27
    //   5253: astore 25
    //   5255: aload 30
    //   5257: astore 26
    //   5259: aload 29
    //   5261: astore 27
    //   5263: goto -3745 -> 1518
    //   5266: astore 28
    //   5268: iload 4
    //   5270: istore 6
    //   5272: lload 13
    //   5274: lstore 17
    //   5276: iload 5
    //   5278: istore 4
    //   5280: aload 25
    //   5282: astore 29
    //   5284: aload 23
    //   5286: astore 25
    //   5288: iconst_1
    //   5289: istore_3
    //   5290: aload 24
    //   5292: astore 23
    //   5294: aload 26
    //   5296: astore 24
    //   5298: iload 6
    //   5300: istore 5
    //   5302: lload 15
    //   5304: lstore 13
    //   5306: lload 17
    //   5308: lstore 15
    //   5310: aload 29
    //   5312: astore 26
    //   5314: goto -3796 -> 1518
    //   5317: astore 23
    //   5319: goto -4608 -> 711
    //   5322: iconst_0
    //   5323: istore 4
    //   5325: lconst_0
    //   5326: lstore 15
    //   5328: aconst_null
    //   5329: astore 23
    //   5331: aconst_null
    //   5332: astore 27
    //   5334: goto -1874 -> 3460
    //   5337: aload 25
    //   5339: astore 26
    //   5341: aload 23
    //   5343: astore 25
    //   5345: goto -5034 -> 311
    //   5348: iconst_0
    //   5349: istore_3
    //   5350: goto -2884 -> 2466
    //   5353: iload 4
    //   5355: iconst_1
    //   5356: iadd
    //   5357: istore 4
    //   5359: goto -2731 -> 2628
    //   5362: iload 6
    //   5364: iconst_1
    //   5365: iadd
    //   5366: istore 6
    //   5368: goto -2687 -> 2681
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5371	0	this	HttpCommunicator
    //   0	5371	1	parambbmu	bbmu
    //   0	5371	2	parambbms	bbms
    //   0	5371	3	paramBoolean	boolean
    //   25	5333	4	i	int
    //   199	5102	5	j	int
    //   51	5316	6	k	int
    //   40	4783	7	m	int
    //   37	4732	8	n	int
    //   2676	1228	9	i1	int
    //   3012	43	10	i2	int
    //   34	5003	11	bool1	boolean
    //   344	442	12	bool2	boolean
    //   28	5277	13	l1	long
    //   31	5296	15	l2	long
    //   289	5018	17	l3	long
    //   3005	246	19	l4	long
    //   2945	963	21	l5	long
    //   16	1052	23	str	String
    //   1077	1	23	localException1	Exception
    //   1372	490	23	localObject1	Object
    //   1934	276	23	localObject2	Object
    //   2241	1462	23	localObject3	Object
    //   3748	122	23	localException2	Exception
    //   3885	437	23	localObject4	Object
    //   4363	3	23	localException3	Exception
    //   4462	1	23	localIOException1	IOException
    //   4467	1	23	localIOException2	IOException
    //   4472	1	23	localIOException3	IOException
    //   4514	1	23	localObject5	Object
    //   4543	1	23	localObject6	Object
    //   4562	33	23	localObject7	Object
    //   4600	87	23	localObject8	Object
    //   4701	21	23	localObject9	Object
    //   4727	83	23	localObject10	Object
    //   4820	1	23	localObject11	Object
    //   4861	432	23	localObject12	Object
    //   5317	1	23	localThrowable1	Throwable
    //   5329	13	23	localObject13	Object
    //   7	4347	24	localObject14	Object
    //   4487	1	24	localIOException4	IOException
    //   4492	1	24	localIOException5	IOException
    //   4497	1	24	localIOException6	IOException
    //   4531	766	24	localObject15	Object
    //   57	5287	25	localObject16	Object
    //   81	5259	26	localObject17	Object
    //   13	5320	27	localObject18	Object
    //   22	3076	28	localObject19	Object
    //   3153	1	28	localThrowable2	Throwable
    //   3215	571	28	localObject20	Object
    //   3867	1	28	localThrowable3	Throwable
    //   4280	16	28	localObject21	Object
    //   4298	22	28	localObject22	Object
    //   4345	461	28	localObject23	Object
    //   4832	1	28	localObject24	Object
    //   4837	1	28	localThrowable4	Throwable
    //   4872	1	28	localThrowable5	Throwable
    //   4919	1	28	localThrowable6	Throwable
    //   4966	1	28	localThrowable7	Throwable
    //   5014	1	28	localThrowable8	Throwable
    //   5058	1	28	localThrowable9	Throwable
    //   5101	1	28	localThrowable10	Throwable
    //   5148	1	28	localThrowable11	Throwable
    //   5208	1	28	localThrowable12	Throwable
    //   5266	1	28	localThrowable13	Throwable
    //   10	1	29	localObject25	Object
    //   1462	53	29	localThrowable14	Throwable
    //   1546	2703	29	localObject26	Object
    //   4260	1	29	localException4	Exception
    //   4275	1	29	localIOException7	IOException
    //   4283	69	29	localObject27	Object
    //   4477	1	29	localIOException8	IOException
    //   4482	1	29	localIOException9	IOException
    //   4581	18	29	localObject28	Object
    //   4612	21	29	localObject29	Object
    //   4643	18	29	localObject30	Object
    //   4674	11	29	localObject31	Object
    //   4716	10	29	localObject32	Object
    //   4739	14	29	localObject33	Object
    //   4766	22	29	localObject34	Object
    //   4797	11	29	localObject35	Object
    //   4895	416	29	localObject36	Object
    //   19	5237	30	localObject37	Object
    //   4	4387	31	localbbmw	bbmw
    //   159	2491	32	localObject38	Object
    // Exception table:
    //   from	to	target	type
    //   453	460	559	java/lang/Exception
    //   465	474	559	java/lang/Exception
    //   487	499	559	java/lang/Exception
    //   501	509	559	java/lang/Exception
    //   513	521	559	java/lang/Exception
    //   525	533	559	java/lang/Exception
    //   538	543	559	java/lang/Exception
    //   548	553	559	java/lang/Exception
    //   946	953	1047	java/lang/Exception
    //   958	967	1047	java/lang/Exception
    //   980	992	1047	java/lang/Exception
    //   994	1002	1047	java/lang/Exception
    //   1006	1014	1047	java/lang/Exception
    //   1018	1026	1047	java/lang/Exception
    //   1031	1036	1047	java/lang/Exception
    //   1041	1046	1047	java/lang/Exception
    //   727	749	1077	java/lang/Exception
    //   749	785	1077	java/lang/Exception
    //   1053	1069	1077	java/lang/Exception
    //   1208	1215	1309	java/lang/Exception
    //   1220	1229	1309	java/lang/Exception
    //   1242	1254	1309	java/lang/Exception
    //   1256	1264	1309	java/lang/Exception
    //   1268	1276	1309	java/lang/Exception
    //   1280	1288	1309	java/lang/Exception
    //   1293	1298	1309	java/lang/Exception
    //   1303	1308	1309	java/lang/Exception
    //   324	333	1462	java/lang/Throwable
    //   337	346	1462	java/lang/Throwable
    //   565	572	1462	java/lang/Throwable
    //   577	586	1462	java/lang/Throwable
    //   586	615	1462	java/lang/Throwable
    //   637	691	1462	java/lang/Throwable
    //   716	722	1462	java/lang/Throwable
    //   727	749	1462	java/lang/Throwable
    //   749	785	1462	java/lang/Throwable
    //   1053	1069	1462	java/lang/Throwable
    //   1079	1090	1462	java/lang/Throwable
    //   1090	1106	1462	java/lang/Throwable
    //   1320	1336	1462	java/lang/Throwable
    //   1336	1354	1462	java/lang/Throwable
    //   1354	1391	1462	java/lang/Throwable
    //   1391	1420	1462	java/lang/Throwable
    //   1420	1427	1462	java/lang/Throwable
    //   1451	1462	1462	java/lang/Throwable
    //   1923	1934	1462	java/lang/Throwable
    //   2212	2220	1462	java/lang/Throwable
    //   2236	2243	1462	java/lang/Throwable
    //   2257	2288	1462	java/lang/Throwable
    //   2288	2309	1462	java/lang/Throwable
    //   2309	2316	1462	java/lang/Throwable
    //   2525	2532	1462	java/lang/Throwable
    //   2535	2558	1462	java/lang/Throwable
    //   2561	2597	1462	java/lang/Throwable
    //   2605	2625	1462	java/lang/Throwable
    //   2647	2664	1462	java/lang/Throwable
    //   2667	2678	1462	java/lang/Throwable
    //   2704	2714	1462	java/lang/Throwable
    //   2720	2763	1462	java/lang/Throwable
    //   2763	2795	1462	java/lang/Throwable
    //   2795	2847	1462	java/lang/Throwable
    //   2847	2858	1462	java/lang/Throwable
    //   3918	4008	1462	java/lang/Throwable
    //   4225	4234	1462	java/lang/Throwable
    //   1899	1908	1909	java/lang/Exception
    //   4390	4401	1909	java/lang/Exception
    //   324	333	1934	finally
    //   337	346	1934	finally
    //   565	572	1934	finally
    //   577	586	1934	finally
    //   586	615	1934	finally
    //   637	691	1934	finally
    //   701	706	1934	finally
    //   706	711	1934	finally
    //   716	722	1934	finally
    //   727	749	1934	finally
    //   749	785	1934	finally
    //   1053	1069	1934	finally
    //   1079	1090	1934	finally
    //   1090	1106	1934	finally
    //   1320	1336	1934	finally
    //   1336	1354	1934	finally
    //   1354	1391	1934	finally
    //   1391	1420	1934	finally
    //   1420	1427	1934	finally
    //   1451	1462	1934	finally
    //   1923	1934	1934	finally
    //   2212	2220	1934	finally
    //   2236	2243	1934	finally
    //   2257	2288	1934	finally
    //   2288	2309	1934	finally
    //   2309	2316	1934	finally
    //   2525	2532	1934	finally
    //   2535	2558	1934	finally
    //   2561	2597	1934	finally
    //   2605	2625	1934	finally
    //   2647	2664	1934	finally
    //   2667	2678	1934	finally
    //   2704	2714	1934	finally
    //   2720	2763	1934	finally
    //   2763	2795	1934	finally
    //   2795	2847	1934	finally
    //   2847	2858	1934	finally
    //   3918	4008	1934	finally
    //   2418	2425	2519	java/lang/Exception
    //   2430	2439	2519	java/lang/Exception
    //   2452	2464	2519	java/lang/Exception
    //   2466	2474	2519	java/lang/Exception
    //   2478	2486	2519	java/lang/Exception
    //   2490	2498	2519	java/lang/Exception
    //   2503	2508	2519	java/lang/Exception
    //   2513	2518	2519	java/lang/Exception
    //   2876	2916	3153	java/lang/Throwable
    //   3141	3150	3153	java/lang/Throwable
    //   3640	3647	3748	java/lang/Exception
    //   3652	3661	3748	java/lang/Exception
    //   3675	3687	3748	java/lang/Exception
    //   3689	3697	3748	java/lang/Exception
    //   3702	3707	3748	java/lang/Exception
    //   3712	3717	3748	java/lang/Exception
    //   3722	3727	3748	java/lang/Exception
    //   3736	3741	3748	java/lang/Exception
    //   2955	2972	3867	java/lang/Throwable
    //   2993	2999	3867	java/lang/Throwable
    //   3049	3057	3867	java/lang/Throwable
    //   3073	3080	3867	java/lang/Throwable
    //   3096	3102	3867	java/lang/Throwable
    //   3118	3127	3867	java/lang/Throwable
    //   3236	3243	3867	java/lang/Throwable
    //   3273	3280	3867	java/lang/Throwable
    //   3301	3307	3867	java/lang/Throwable
    //   3323	3334	3867	java/lang/Throwable
    //   3350	3356	3867	java/lang/Throwable
    //   3372	3381	3867	java/lang/Throwable
    //   3397	3404	3867	java/lang/Throwable
    //   3420	3427	3867	java/lang/Throwable
    //   3443	3448	3867	java/lang/Throwable
    //   3783	3793	3867	java/lang/Throwable
    //   3809	3814	3867	java/lang/Throwable
    //   3830	3839	3867	java/lang/Throwable
    //   3855	3864	3867	java/lang/Throwable
    //   4110	4117	4211	java/lang/Exception
    //   4122	4131	4211	java/lang/Exception
    //   4144	4156	4211	java/lang/Exception
    //   4158	4166	4211	java/lang/Exception
    //   4170	4178	4211	java/lang/Exception
    //   4182	4190	4211	java/lang/Exception
    //   4195	4200	4211	java/lang/Exception
    //   4205	4210	4211	java/lang/Exception
    //   1541	1548	4260	java/lang/Exception
    //   1552	1559	4260	java/lang/Exception
    //   1568	1577	4260	java/lang/Exception
    //   4267	4272	4275	java/io/IOException
    //   1541	1548	4280	finally
    //   1521	1528	4298	finally
    //   1587	1592	4298	finally
    //   1592	1604	4298	finally
    //   4267	4272	4298	finally
    //   4290	4295	4298	finally
    //   4295	4298	4298	finally
    //   1765	1772	4363	java/lang/Exception
    //   1777	1786	4363	java/lang/Exception
    //   1800	1812	4363	java/lang/Exception
    //   1814	1822	4363	java/lang/Exception
    //   1827	1832	4363	java/lang/Exception
    //   1837	1842	4363	java/lang/Exception
    //   1847	1852	4363	java/lang/Exception
    //   1861	1866	4363	java/lang/Exception
    //   2112	2119	4382	java/lang/Exception
    //   2124	2133	4382	java/lang/Exception
    //   2147	2159	4382	java/lang/Exception
    //   2161	2169	4382	java/lang/Exception
    //   2174	2179	4382	java/lang/Exception
    //   2184	2189	4382	java/lang/Exception
    //   2194	2199	4382	java/lang/Exception
    //   2204	2209	4382	java/lang/Exception
    //   513	521	4402	java/io/IOException
    //   525	533	4406	java/io/IOException
    //   538	543	4410	java/io/IOException
    //   1006	1014	4414	java/io/IOException
    //   1018	1026	4418	java/io/IOException
    //   1031	1036	4422	java/io/IOException
    //   1268	1276	4426	java/io/IOException
    //   1280	1288	4430	java/io/IOException
    //   1293	1298	4434	java/io/IOException
    //   2478	2486	4438	java/io/IOException
    //   2490	2498	4442	java/io/IOException
    //   2503	2508	4446	java/io/IOException
    //   4170	4178	4450	java/io/IOException
    //   4182	4190	4454	java/io/IOException
    //   4195	4200	4458	java/io/IOException
    //   3702	3707	4462	java/io/IOException
    //   3712	3717	4467	java/io/IOException
    //   3722	3727	4472	java/io/IOException
    //   1587	1592	4477	java/io/IOException
    //   4290	4295	4482	java/io/IOException
    //   1827	1832	4487	java/io/IOException
    //   1837	1842	4492	java/io/IOException
    //   1847	1852	4497	java/io/IOException
    //   2174	2179	4502	java/io/IOException
    //   2184	2189	4506	java/io/IOException
    //   2194	2199	4510	java/io/IOException
    //   42	50	4514	finally
    //   168	198	4543	finally
    //   201	241	4543	finally
    //   256	266	4543	finally
    //   266	277	4543	finally
    //   277	296	4543	finally
    //   311	324	4562	finally
    //   59	83	4581	finally
    //   87	111	4612	finally
    //   114	142	4643	finally
    //   142	168	4674	finally
    //   2869	2876	4701	finally
    //   2876	2916	4716	finally
    //   3141	3150	4716	finally
    //   2916	2933	4739	finally
    //   3210	3217	4739	finally
    //   2955	2972	4766	finally
    //   2993	2999	4766	finally
    //   3049	3057	4766	finally
    //   3073	3080	4766	finally
    //   3096	3102	4766	finally
    //   3118	3127	4766	finally
    //   3236	3243	4766	finally
    //   3273	3280	4766	finally
    //   3301	3307	4766	finally
    //   3323	3334	4766	finally
    //   3350	3356	4766	finally
    //   3372	3381	4766	finally
    //   3397	3404	4766	finally
    //   3420	3427	4766	finally
    //   3443	3448	4766	finally
    //   3783	3793	4766	finally
    //   3809	3814	4766	finally
    //   3830	3839	4766	finally
    //   3855	3864	4766	finally
    //   3460	3471	4797	finally
    //   4225	4234	4820	finally
    //   1552	1559	4832	finally
    //   1568	1577	4832	finally
    //   42	50	4837	java/lang/Throwable
    //   168	198	4872	java/lang/Throwable
    //   201	241	4872	java/lang/Throwable
    //   256	266	4872	java/lang/Throwable
    //   266	277	4872	java/lang/Throwable
    //   277	296	4872	java/lang/Throwable
    //   311	324	4919	java/lang/Throwable
    //   59	83	4966	java/lang/Throwable
    //   87	111	5014	java/lang/Throwable
    //   114	142	5058	java/lang/Throwable
    //   142	168	5101	java/lang/Throwable
    //   2869	2876	5148	java/lang/Throwable
    //   2916	2933	5208	java/lang/Throwable
    //   3210	3217	5208	java/lang/Throwable
    //   3460	3471	5266	java/lang/Throwable
    //   701	706	5317	java/lang/Throwable
    //   706	711	5317	java/lang/Throwable
  }
  
  public void a(bbmu parambbmu, String paramString1, String paramString2)
  {
    try
    {
      ayuk.a(ayuk.b(parambbmu.jdField_c_of_type_Int), parambbmu.e().equals("POST"), ayuk.c(parambbmu.jdField_b_of_type_Int), parambbmu.jdField_a_of_type_JavaLangString, paramString1, paramString2);
      return;
    }
    catch (OutOfMemoryError parambbmu) {}
  }
  
  protected void a(bbmu parambbmu, boolean paramBoolean, long paramLong)
  {
    parambbmu.jdField_g_of_type_Int = ((int)paramLong);
    int i = parambbmu.jdField_b_of_type_Int;
    int j = parambbmu.jdField_c_of_type_Int;
    int k = parambbmu.jdField_d_of_type_Int;
    if (((i == -1) || (j == -1)) && (QLog.isColorLevel())) {
      QLog.e("flowstat", 2, "fileType:" + i + ",busiType:" + j);
    }
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
      ((bbmv)this.jdField_a_of_type_MqqUtilWeakReference.get()).countFlow(paramBoolean, k, i, j, paramLong);
    }
  }
  
  public void a(String paramString)
  {
    int i = 0;
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.HttpCommunicator", 2, "queueSize:" + this.jdField_a_of_type_Bbmt.a() + " mConcurrentRunningMsgs:" + this.e + " mConcurrentLimit:" + this.jdField_d_of_type_Int + " reason:" + paramString + " tid:" + Thread.currentThread().getId());
      }
      if (this.jdField_a_of_type_Bbmt.a() == 0) {
        return;
      }
    }
    bbms[] arrayOfbbms;
    int j;
    if (this.e < this.jdField_d_of_type_Int)
    {
      paramString = this.jdField_a_of_type_Bbmt.a(false);
      if (paramString != null)
      {
        arrayOfbbms = this.jdField_a_of_type_ArrayOfBbms;
        j = arrayOfbbms.length;
      }
    }
    for (;;)
    {
      bbms localbbms;
      bbmu localbbmu;
      if (i < j)
      {
        localbbms = arrayOfbbms[i];
        localbbmu = localbbms.jdField_a_of_type_Bbmu;
        if (localbbms.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break label268;
        }
        this.jdField_a_of_type_Bbmt.a(paramString);
        paramString.b();
        localbbms.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        localbbms.jdField_a_of_type_Bbmu = paramString;
        localbbms.a(paramString);
        this.e += 1;
        paramString.jdField_h_of_type_Long = (SystemClock.uptimeMillis() - paramString.jdField_g_of_type_Long);
        if (QLog.isColorLevel()) {
          a(paramString, "attach", "");
        }
      }
      for (;;)
      {
        return;
        label268:
        if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!localbbms.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (localbbmu == null) || (localbbmu.b() <= paramString.b())) {
          break;
        }
        localbbms.a();
      }
      i += 1;
    }
  }
  
  void a(boolean paramBoolean, int paramInt, HttpURLConnection paramHttpURLConnection, bbmu parambbmu, Throwable paramThrowable)
  {
    if ((paramThrowable instanceof IllegalArgumentException))
    {
      parambbmu.a(9020, paramInt, paramThrowable.toString());
      return;
    }
    if ((paramThrowable instanceof IllegalStateException))
    {
      parambbmu.a(9057, paramInt, paramThrowable.toString());
      return;
    }
    if ((paramThrowable instanceof IOException))
    {
      if ("request cancelled".equals(paramThrowable.getMessage()))
      {
        parambbmu.a(9037, paramInt, paramThrowable.toString());
        return;
      }
      if ("httpcommunicator closed".equals(paramThrowable.getMessage()))
      {
        parambbmu.a(9366, paramInt, paramThrowable.getMessage());
        return;
      }
      if ("preempted by higher msg".equals(paramThrowable.getMessage()))
      {
        parambbmu.a(9361, paramInt, paramThrowable.toString());
        return;
      }
      if ("content-length zero".equals(paramThrowable.getMessage()))
      {
        paramHttpURLConnection = aypb.a("Q", -9531L);
        parambbmu.b(bbmu.jdField_f_of_type_JavaLangString, paramHttpURLConnection);
        parambbmu.a(-9527, paramInt, "content zero");
        return;
      }
      if ((paramThrowable instanceof MalformedURLException))
      {
        parambbmu.a(9048, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof InterruptedIOException))
      {
        if ((paramThrowable instanceof SocketTimeoutException))
        {
          if (paramBoolean)
          {
            parambbmu.a(9014, paramInt, paramThrowable.toString());
            return;
          }
          parambbmu.a(9050, paramInt, paramThrowable.toString());
          return;
        }
        parambbmu.a(9049, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof SocketException))
      {
        paramHttpURLConnection = paramThrowable.toString();
        if (QLog.isColorLevel())
        {
          paramHttpURLConnection = new StringBuilder();
          StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
          int j = arrayOfStackTraceElement.length;
          int i = 0;
          while (i < j)
          {
            StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
            paramHttpURLConnection.append("\n").append(localStackTraceElement.toString());
            i += 1;
          }
          paramHttpURLConnection = paramHttpURLConnection.toString();
        }
        if ((paramThrowable instanceof ConnectException))
        {
          parambbmu.a(9052, paramInt, paramHttpURLConnection);
          return;
        }
        if ((paramThrowable instanceof NoRouteToHostException))
        {
          parambbmu.a(9053, paramInt, paramHttpURLConnection);
          return;
        }
        if ((paramThrowable instanceof PortUnreachableException))
        {
          parambbmu.a(9054, paramInt, paramHttpURLConnection);
          return;
        }
        parambbmu.a(9051, paramInt, paramHttpURLConnection);
        return;
      }
      if ((paramThrowable instanceof UnknownHostException))
      {
        parambbmu.a(9055, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof EOFException))
      {
        parambbmu.a(9056, paramInt, paramThrowable.getMessage());
        return;
      }
      paramThrowable = paramThrowable.toString();
      if (paramThrowable.contains("unreachable)")) {
        paramHttpURLConnection = "N_" + -20005;
      }
      for (;;)
      {
        parambbmu.a(9047, paramInt, paramThrowable);
        parambbmu.b(bbmu.jdField_f_of_type_JavaLangString, paramHttpURLConnection);
        return;
        if (paramThrowable.contains("Connection refused"))
        {
          paramHttpURLConnection = "N_" + -20002;
        }
        else if (paramThrowable.contains("No route to host"))
        {
          if (paramThrowable.contains("SocketException")) {
            paramHttpURLConnection = "N_" + -20003;
          } else {
            paramHttpURLConnection = "N_" + -20004;
          }
        }
        else if (paramThrowable.contains("unexpected end of stream"))
        {
          paramHttpURLConnection = "N_" + -20005;
        }
        else if (paramThrowable.contains("Connection timed out"))
        {
          paramHttpURLConnection = "N_" + -20006;
        }
        else
        {
          if (paramThrowable.contains("unaccpet content type"))
          {
            parambbmu.a(9064, paramInt, paramThrowable);
            return;
          }
          paramHttpURLConnection = "N_" + -20007;
        }
      }
    }
    if ((paramThrowable instanceof SecurityException))
    {
      parambbmu.a(9022, paramInt, paramThrowable.toString());
      return;
    }
    paramHttpURLConnection = paramThrowable.getMessage();
    if ((!TextUtils.isEmpty(paramHttpURLConnection)) && (paramHttpURLConnection.contains("FlowDecoderExp")))
    {
      parambbmu.a(9058, paramInt, paramHttpURLConnection);
      return;
    }
    if ((!TextUtils.isEmpty(paramHttpURLConnection)) && (paramHttpURLConnection.contains("DecryptError")))
    {
      parambbmu.a(9059, paramInt, paramHttpURLConnection);
      return;
    }
    try
    {
      parambbmu.a(9322, paramInt, Log.getStackTraceString(paramThrowable));
      return;
    }
    catch (OutOfMemoryError paramHttpURLConnection) {}
  }
  
  public int b(bbmu parambbmu)
  {
    int i = this.jdField_c_of_type_Int;
    int j = -1;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Bbmt.a() < i))
        {
          i = this.jdField_a_of_type_Int + 1;
          this.jdField_a_of_type_Int = i;
          parambbmu.a(i);
          this.jdField_a_of_type_Bbmt.a(parambbmu);
          parambbmu.a().a(parambbmu, null, 0);
          j = this.jdField_a_of_type_Int;
          i = j;
          if (!this.jdField_b_of_type_Boolean)
          {
            a();
            i = j;
          }
          ??? = new Object();
          parambbmu.jdField_a_of_type_JavaLangObject = ???;
          parambbmu.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
          a("sendMsgSync");
          if (parambbmu.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
        }
      }
      try
      {
        ???.wait();
        return i;
        i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.richmedia.HttpCommunicator", 2, "exceed queue limit");
        i = j;
        continue;
        parambbmu = finally;
        throw parambbmu;
      }
      catch (InterruptedException parambbmu)
      {
        for (;;)
        {
          parambbmu.printStackTrace();
        }
      }
      finally {}
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new HttpCommunicator.3(this));
  }
  
  void b(int paramInt, HttpURLConnection paramHttpURLConnection, bbmu parambbmu)
  {
    new StringBuilder().append("Response code: ").append(paramInt).toString();
    long l2 = 0L;
    String str = paramHttpURLConnection.getHeaderField("X-ErrNo");
    if ((str != null) && (!str.equals(""))) {}
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(str);
        paramHttpURLConnection = aypb.a(paramInt, l1);
        parambbmu.b(bbmu.jdField_f_of_type_JavaLangString, paramHttpURLConnection);
        parambbmu.a(-9527, paramInt, paramHttpURLConnection);
        return;
      }
      catch (Exception paramHttpURLConnection)
      {
        paramHttpURLConnection.printStackTrace();
        l1 = l2;
        continue;
      }
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("User-ReturnCode");
      long l1 = l2;
      if (paramHttpURLConnection != null)
      {
        l1 = l2;
        if (!paramHttpURLConnection.equals("")) {
          try
          {
            l1 = Long.parseLong(paramHttpURLConnection);
          }
          catch (Exception paramHttpURLConnection)
          {
            paramHttpURLConnection.printStackTrace();
            l1 = l2;
          }
        }
      }
    }
  }
  
  public void b(bbmu parambbmu)
  {
    if (parambbmu != null)
    {
      bbmw localbbmw = parambbmu.a();
      if ((localbbmw instanceof aypb)) {
        ((aypb)localbbmw).a(2, 9014, "sscm http timeout");
      }
      parambbmu.a().b(parambbmu, null);
    }
  }
  
  public void c()
  {
    int i = 0;
    long l;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      l = System.currentTimeMillis();
      bbmu localbbmu;
      do
      {
        localbbmu = this.jdField_a_of_type_Bbmt.a(true);
        if (localbbmu == null) {
          break;
        }
      } while ((localbbmu == null) || (localbbmu.a() == null));
      localbbmu.a(9366, -1, "httpcommunicator_close");
      localbbmu.a().b(localbbmu, localbbmu);
    }
    this.jdField_a_of_type_Bbmt.a();
    if (this.jdField_a_of_type_ArrayOfBbms != null)
    {
      bbms[] arrayOfbbms = this.jdField_a_of_type_ArrayOfBbms;
      int j = arrayOfbbms.length;
      while (i < j)
      {
        arrayOfbbms[i].sendEmptyMessage(1);
        i += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfBbms = null;
    this.e = 0;
    this.jdField_d_of_type_Int = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.HttpCommunicator", 2, "HttpCommunicator close_inter.elapse:" + (System.currentTimeMillis() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.httputils.HttpCommunicator
 * JD-Core Version:    0.7.0.1
 */