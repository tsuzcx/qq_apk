package com.tencent.mobileqq.utils.httputils;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import azri;
import barf;
import bavg;
import bawk;
import bawn;
import bawq;
import baws;
import bdpu;
import bdpv;
import bdpw;
import bdpx;
import bdpy;
import bdpz;
import bdqa;
import bdqb;
import bigj;
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
  implements bigj
{
  private static long jdField_a_of_type_Long = 1L;
  private int jdField_a_of_type_Int;
  private bdpw jdField_a_of_type_Bdpw = new bdpw();
  private Object jdField_a_of_type_JavaLangObject = new ReentrantLock();
  private Runnable jdField_a_of_type_JavaLangRunnable;
  String jdField_a_of_type_JavaLangString = null;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private WeakReference<bdpy> jdField_a_of_type_MqqUtilWeakReference;
  boolean jdField_a_of_type_Boolean = true;
  private bdpv[] jdField_a_of_type_ArrayOfBdpv;
  private final int jdField_b_of_type_Int = 4;
  private volatile boolean jdField_b_of_type_Boolean;
  private final int jdField_c_of_type_Int;
  private volatile boolean jdField_c_of_type_Boolean;
  private int d;
  private int e;
  
  public HttpCommunicator(bdpy parambdpy, int paramInt)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(parambdpy);
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
  
  private HttpURLConnection a(bdpx parambdpx)
  {
    Object localObject1 = parambdpx.a();
    String str1 = (String)parambdpx.jdField_a_of_type_JavaUtilHashMap.remove("mType");
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
      String str3 = bdqa.b((String)localObject1);
      parambdpx.jdField_f_of_type_Boolean = bdqa.jdField_d_of_type_JavaLangString.equals(str3);
      if (!str3.equals(this.jdField_a_of_type_JavaLangString))
      {
        if ((j == 1) || (str3.equals(bdqa.jdField_d_of_type_JavaLangString))) {
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
          if ((str3.equals(bdqa.jdField_d_of_type_JavaLangString)) || (str3.equals(bdqa.jdField_f_of_type_JavaLangString)) || (str3.equals(bdqa.h))) {
            if (!parambdpx.jdField_g_of_type_Boolean) {
              switch (parambdpx.jdField_h_of_type_Int)
              {
              default: 
                localObject1 = bdqa.b(str1, str2, i1);
                i = 1;
                a((HttpURLConnection)localObject1, parambdpx);
                parambdpx.jdField_d_of_type_Int = j;
                i2 = bavg.a().a();
                if (parambdpx.jdField_a_of_type_Bawq == null)
                {
                  localObject3 = bawk.a(i2);
                  n = ((bawn)localObject3).a();
                  if ("POST".equals(parambdpx.e())) {
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
          a(parambdpx, "gettingConn", "getConnection type:" + i2 + " activeNetworkInfo: " + localObject2 + " defaultHost:" + str2 + " defaultPort: " + i1 + " last apnType:" + this.jdField_a_of_type_JavaLangString + " forceDirect:" + this.jdField_a_of_type_Boolean + ",connectTimeOut:" + n + ",readTimeout:" + j);
          ((HttpURLConnection)localObject1).setInstanceFollowRedirects(false);
          localObject2 = parambdpx.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
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
          localObject1 = bdqa.a(str1, str2, i1);
          i = 1;
          break label285;
          localObject1 = bdqa.b(str1, str2, i1);
          i = 1;
          break label285;
          if (str3.equals(bdqa.b))
          {
            localObject1 = bdqa.a(str1, str2, i1);
            i = 1;
            break label285;
          }
          localObject1 = bdqa.a(str1, str2, i1);
          i = 1;
          break label285;
          localObject1 = (HttpURLConnection)new URL(str1).openConnection();
          i = 0;
          break label285;
          j = ((bawn)localObject3).b();
          continue;
          n = parambdpx.jdField_a_of_type_Bawq.b(i2);
          j = parambdpx.jdField_a_of_type_Bawq.a(i2);
        }
        if (parambdpx.e().equals("POST"))
        {
          ((HttpURLConnection)localObject1).setDoOutput(true);
          if (parambdpx.b() != null) {
            ((HttpURLConnection)localObject1).setFixedLengthStreamingMode(parambdpx.b().length);
          }
        }
        parambdpx.jdField_c_of_type_JavaLangString = ((HttpURLConnection)localObject1).getRequestProperties().toString();
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
  
  private void a(bdpx parambdpx1, bdpx parambdpx2, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SSCM", 2, "msg statuschanged: " + paramInt);
      }
      parambdpx1.a().a(parambdpx1, parambdpx2, paramInt);
    }
  }
  
  private void a(HttpURLConnection paramHttpURLConnection, bdpx parambdpx)
  {
    String str;
    bdpu localbdpu;
    if ((parambdpx.j) && ((paramHttpURLConnection instanceof HttpsURLConnection)))
    {
      paramHttpURLConnection = (HttpsURLConnection)paramHttpURLConnection;
      str = parambdpx.jdField_e_of_type_JavaLangString;
      localbdpu = new bdpu(this, str, parambdpx);
      if (parambdpx.k)
      {
        paramHttpURLConnection.setRequestProperty("host", str);
        paramHttpURLConnection.setSSLSocketFactory(new bdqb(str, localbdpu));
        paramHttpURLConnection.setHostnameVerifier(localbdpu);
      }
    }
    else
    {
      return;
    }
    paramHttpURLConnection.setRequestProperty("host", str);
    paramHttpURLConnection.setHostnameVerifier(localbdpu);
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
      if (this.jdField_a_of_type_Bdpw.a() > 0) {
        return false;
      }
    }
    if ((this.jdField_a_of_type_ArrayOfBdpv == null) || (this.jdField_a_of_type_ArrayOfBdpv.length == 0)) {
      return false;
    }
    if (this.e > 0) {
      return false;
    }
    bdpv[] arrayOfbdpv = this.jdField_a_of_type_ArrayOfBdpv;
    int k = arrayOfbdpv.length;
    int i = 0;
    for (;;)
    {
      if (i < k)
      {
        bdpv localbdpv = arrayOfbdpv[i];
        if ((localbdpv != null) && (localbdpv.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) && (localbdpv.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
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
          arrayOfbdpv = this.jdField_a_of_type_ArrayOfBdpv;
          k = arrayOfbdpv.length;
          i = j;
          while (i < k)
          {
            arrayOfbdpv[i].sendEmptyMessage(1);
            i += 1;
          }
          this.e = 0;
          this.jdField_d_of_type_Int = 0;
          this.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_ArrayOfBdpv = null;
        }
        return true;
      }
      i += 1;
    }
  }
  
  public int a(bdpx parambdpx)
  {
    int i = -1;
    int k = this.jdField_c_of_type_Int;
    int j = 1;
    if (this.jdField_c_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.richmedia.HttpCommunicator", 2, "sendMsg closed");
      }
      if ((parambdpx != null) && (parambdpx.a() != null))
      {
        parambdpx.a(9366, -1, "close");
        parambdpx.a().b(parambdpx, parambdpx);
        k = i;
        return k;
      }
    }
    if (!this.jdField_b_of_type_Boolean) {
      a();
    }
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if (parambdpx != null) {}
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Bdpw.a() < k)
        {
          i = this.jdField_a_of_type_Int + 1;
          this.jdField_a_of_type_Int = i;
          parambdpx.a(i);
          parambdpx.jdField_g_of_type_Long = SystemClock.uptimeMillis();
          this.jdField_a_of_type_Bdpw.a(parambdpx);
          parambdpx.a().a(parambdpx, null, 0);
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
        if ((parambdpx != null) && (parambdpx.a() != null))
        {
          parambdpx.a(9367, -1, "queen full");
          parambdpx.a().b(parambdpx, parambdpx);
        }
      }
      finally {}
      j = 0;
    }
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Bdpw != null) {
      return this.jdField_a_of_type_Bdpw.a();
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
        if (this.jdField_a_of_type_ArrayOfBdpv == null)
        {
          this.jdField_a_of_type_ArrayOfBdpv = new bdpv[4];
          if (i < 4)
          {
            HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("httpcommunicator_norm_" + i, 5);
            localHandlerThread.start();
            this.jdField_a_of_type_ArrayOfBdpv[i] = new bdpv(this, localHandlerThread.getLooper());
            this.jdField_a_of_type_ArrayOfBdpv[i].jdField_a_of_type_Int = i;
            i += 1;
            continue;
          }
        }
        i = bavg.a().a();
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
  
  void a(int paramInt, HttpURLConnection paramHttpURLConnection, bdpx parambdpx)
  {
    if ((paramHttpURLConnection == null) || (parambdpx == null)) {
      return;
    }
    parambdpx.c(paramInt);
    parambdpx.b("Content-Type", paramHttpURLConnection.getContentType());
    parambdpx.jdField_d_of_type_JavaLangString = paramHttpURLConnection.getHeaderFields().toString();
    if (paramHttpURLConnection.getHeaderField("User-ReturnCode") != null) {
      parambdpx.b("User-ReturnCode", paramHttpURLConnection.getHeaderField("User-ReturnCode"));
    }
    if (paramHttpURLConnection.getHeaderField("X-User-ReturnCode") != null) {
      parambdpx.b("X-User-ReturnCode", paramHttpURLConnection.getHeaderField("X-User-ReturnCode"));
    }
    if (paramHttpURLConnection.getHeaderField("content-range") != null) {
      parambdpx.b("content-range", paramHttpURLConnection.getHeaderField("content-range"));
    }
    if (paramHttpURLConnection.getHeaderField("Range") != null) {
      parambdpx.b("Range", paramHttpURLConnection.getHeaderField("Range"));
    }
    if (paramHttpURLConnection.getHeaderField("X-Range") != null) {
      parambdpx.b("X-Range", paramHttpURLConnection.getHeaderField("X-Range"));
    }
    if (paramHttpURLConnection.getHeaderField("Content-Encoding") != null) {
      parambdpx.b("Content-Encoding", paramHttpURLConnection.getHeaderField("Content-Encoding"));
    }
    if (paramHttpURLConnection.getHeaderField("Transfer-Encoding") != null) {
      parambdpx.b("Transfer-Encoding", paramHttpURLConnection.getHeaderField("Transfer-Encoding"));
    }
    if (paramHttpURLConnection.getHeaderField("X-RtFlag") != null) {
      parambdpx.b("X-RtFlag", paramHttpURLConnection.getHeaderField("X-RtFlag"));
    }
    if (paramHttpURLConnection.getHeaderField("X-httime") != null) {
      parambdpx.b("X-httime", paramHttpURLConnection.getHeaderField("X-httime"));
    }
    if (paramHttpURLConnection.getHeaderField("X-piccachetime") != null) {
      parambdpx.b("X-piccachetime", paramHttpURLConnection.getHeaderField("X-piccachetime"));
    }
    parambdpx.jdField_a_of_type_Long = -1L;
    String str = paramHttpURLConnection.getHeaderField("content-range");
    int i;
    if (str != null) {
      i = str.lastIndexOf("/");
    }
    for (;;)
    {
      try
      {
        parambdpx.jdField_a_of_type_Long = Long.valueOf(str.substring(i + 1)).longValue();
        parambdpx.jdField_b_of_type_Long = paramHttpURLConnection.getContentLength();
        a(parambdpx, "copyRespHeader", "resultCode:" + paramInt + " totalLen:" + parambdpx.jdField_a_of_type_Long + ",totalBlockLen:" + parambdpx.jdField_b_of_type_Long);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      parambdpx.jdField_a_of_type_Long = paramHttpURLConnection.getContentLength();
      parambdpx.jdField_b_of_type_Long = parambdpx.jdField_a_of_type_Long;
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
      azri.a(BaseApplication.getContext()).a(null, "LongHttpRespTime", false, paramLong, 0L, localHashMap, "");
      return;
      i = j;
    }
  }
  
  public void a(bdpv parambdpv)
  {
    if (this.jdField_c_of_type_Boolean) {}
    int i;
    do
    {
      do
      {
        return;
      } while (parambdpv == null);
      parambdpv.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      i = parambdpv.jdField_a_of_type_Int;
      if ((i >= 0) && (i < 4))
      {
        ??? = new HandlerThread("httpcommunicator_norm_new_" + i, 5);
        ((HandlerThread)???).start();
        bdpv localbdpv = new bdpv(this, ((HandlerThread)???).getLooper());
        localbdpv.jdField_a_of_type_Int = i;
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_ArrayOfBdpv[i] = localbdpv;
          if (parambdpv.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            this.e -= 1;
          }
          a("replaceNewThread index:" + i);
          return;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.richmedia.HttpCommunicator", 2, "replaceNewThread,index error occurs. " + i);
  }
  
  void a(bdpv parambdpv, bdpx parambdpx)
  {
    if (!this.jdField_b_of_type_Boolean) {
      throw new IOException("httpcommunicator closed");
    }
    if (parambdpx.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      throw new IOException("request cancelled");
    }
    if ((parambdpv != null) && (parambdpv.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
      throw new RuntimeException("thread should close");
    }
    if (parambdpx.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      a(parambdpx, "interrupt", "preempted");
      throw new IOException("preempted by higher msg");
    }
  }
  
  public void a(bdpx parambdpx)
  {
    if (parambdpx == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Bdpw.a(parambdpx);
      parambdpx.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return;
    }
  }
  
  public void a(bdpx parambdpx, bdpv parambdpv)
  {
    int i = 0;
    if ((parambdpx != null) && (parambdpv != null)) {
      try
      {
        a(parambdpx, "responseTimeout", "");
        if (parambdpx.b() == null) {}
        for (;;)
        {
          a(90000L, i);
          a(parambdpv);
          parambdpx.a(9014, 0, "response timeout");
          parambdpx.a().b(parambdpx, parambdpx);
          return;
          i = parambdpx.b().length;
        }
        return;
      }
      catch (Exception parambdpx)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.richmedia.HttpCommunicator", 2, "onResponseTimeout", parambdpx);
        }
      }
    }
  }
  
  /* Error */
  public void a(bdpx parambdpx, bdpv parambdpv, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 389	bdpx:a	()Lbdpz;
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
    //   47: invokespecial 688	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Lbdpx;IZ)V
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
    //   67: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload_0
    //   71: aload_2
    //   72: aload_1
    //   73: invokevirtual 692	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpv;Lbdpx;)V
    //   76: aload_0
    //   77: aload_1
    //   78: invokespecial 694	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;)Ljava/net/HttpURLConnection;
    //   81: astore 26
    //   83: aload 26
    //   85: astore 24
    //   87: aload_1
    //   88: aload 24
    //   90: putfield 697	bdpx:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   93: aload_1
    //   94: invokestatic 474	android/os/SystemClock:uptimeMillis	()J
    //   97: putfield 699	bdpx:jdField_d_of_type_Long	J
    //   100: aload_0
    //   101: aload_1
    //   102: ldc_w 701
    //   105: ldc_w 490
    //   108: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
    //   111: iconst_1
    //   112: istore 11
    //   114: invokestatic 704	java/lang/System:currentTimeMillis	()J
    //   117: pop2
    //   118: aload_1
    //   119: invokevirtual 232	bdpx:e	()Ljava/lang/String;
    //   122: ldc 230
    //   124: invokevirtual 186	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   127: ifeq +5222 -> 5349
    //   130: new 706	com/tencent/mobileqq/utils/httputils/HttpCommunicator$1
    //   133: dup
    //   134: aload_0
    //   135: aload_1
    //   136: aload_2
    //   137: invokespecial 709	com/tencent/mobileqq/utils/httputils/HttpCommunicator$1:<init>	(Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator;Lbdpx;Lbdpv;)V
    //   140: astore 26
    //   142: aload_0
    //   143: getfield 381	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   146: aload 26
    //   148: ldc2_w 611
    //   151: invokevirtual 713	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   154: pop
    //   155: aload_1
    //   156: invokevirtual 355	bdpx:b	()[B
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
    //   195: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
    //   198: iconst_0
    //   199: istore 5
    //   201: iload 5
    //   203: aload 32
    //   205: arraylength
    //   206: if_icmpge +46 -> 252
    //   209: aload_0
    //   210: aload_2
    //   211: aload_1
    //   212: invokevirtual 692	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpv;Lbdpx;)V
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
    //   257: getfield 636	bdpv:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   260: invokevirtual 441	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   263: ifne +14 -> 277
    //   266: aload_0
    //   267: aload_1
    //   268: ldc_w 738
    //   271: ldc_w 490
    //   274: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
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
    //   314: invokevirtual 692	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpv;Lbdpx;)V
    //   317: aload 24
    //   319: invokevirtual 751	java/net/HttpURLConnection:getResponseCode	()I
    //   322: istore 5
    //   324: aload_0
    //   325: iload 5
    //   327: aload 24
    //   329: aload_1
    //   330: invokevirtual 753	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(ILjava/net/HttpURLConnection;Lbdpx;)V
    //   333: aload_2
    //   334: ifnull +231 -> 565
    //   337: aload_2
    //   338: getfield 636	bdpv:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
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
    //   392: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
    //   395: aload_2
    //   396: ifnull +13 -> 409
    //   399: aload_2
    //   400: getfield 636	bdpv:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
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
    //   428: invokevirtual 763	bdpx:d	()Ljava/lang/String;
    //   431: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: ldc_w 765
    //   437: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: aload_1
    //   441: invokevirtual 767	bdpx:c	()Ljava/lang/String;
    //   444: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
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
    //   488: invokevirtual 232	bdpx:e	()Ljava/lang/String;
    //   491: ldc 230
    //   493: invokevirtual 186	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   496: ifeq +58 -> 554
    //   499: iconst_1
    //   500: istore_3
    //   501: aload_0
    //   502: aload_1
    //   503: iload_3
    //   504: lload 13
    //   506: invokevirtual 770	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;ZJ)V
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
    //   612: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
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
    //   656: getfield 365	bdpx:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   659: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: ldc_w 788
    //   665: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: aload_1
    //   669: getfield 544	bdpx:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   672: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   678: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
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
    //   717: getfield 793	bdpx:l	Z
    //   720: istore 12
    //   722: iload 12
    //   724: ifeq +366 -> 1090
    //   727: aload_1
    //   728: getfield 795	bdpx:jdField_h_of_type_Boolean	Z
    //   731: ifeq +322 -> 1053
    //   734: aload_1
    //   735: invokevirtual 798	bdpx:a	()Ljava/util/HashMap;
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
    //   780: invokestatic 816	awkd:a	(Ljava/lang/String;)Z
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
    //   831: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
    //   834: aload_2
    //   835: ifnull +13 -> 848
    //   838: aload_2
    //   839: getfield 636	bdpv:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
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
    //   867: invokevirtual 763	bdpx:d	()Ljava/lang/String;
    //   870: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: ldc_w 765
    //   876: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: aload_1
    //   880: invokevirtual 767	bdpx:c	()Ljava/lang/String;
    //   883: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   889: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
    //   892: aload_1
    //   893: getfield 818	bdpx:jdField_f_of_type_Int	I
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
    //   921: getfield 365	bdpx:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   924: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: ldc_w 788
    //   930: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   933: aload_1
    //   934: getfield 544	bdpx:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   937: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   943: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
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
    //   981: invokevirtual 232	bdpx:e	()Ljava/lang/String;
    //   984: ldc 230
    //   986: invokevirtual 186	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   989: ifeq +83 -> 1072
    //   992: iconst_1
    //   993: istore_3
    //   994: aload_0
    //   995: aload_1
    //   996: iload_3
    //   997: lload 13
    //   999: invokevirtual 770	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;ZJ)V
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
    //   1058: invokevirtual 122	bdpx:a	()Ljava/lang/String;
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
    //   1087: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
    //   1090: aload_1
    //   1091: invokevirtual 826	bdpx:b	()Z
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
    //   1147: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
    //   1150: aload_2
    //   1151: ifnull +13 -> 1164
    //   1154: aload_2
    //   1155: getfield 636	bdpv:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
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
    //   1183: invokevirtual 763	bdpx:d	()Ljava/lang/String;
    //   1186: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1189: ldc_w 765
    //   1192: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1195: aload_1
    //   1196: invokevirtual 767	bdpx:c	()Ljava/lang/String;
    //   1199: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1202: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1205: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
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
    //   1243: invokevirtual 232	bdpx:e	()Ljava/lang/String;
    //   1246: ldc 230
    //   1248: invokevirtual 186	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1251: ifeq +64 -> 1315
    //   1254: iconst_1
    //   1255: istore_3
    //   1256: aload_0
    //   1257: aload_1
    //   1258: iload_3
    //   1259: lload 13
    //   1261: invokevirtual 770	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;ZJ)V
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
    //   1321: getfield 828	bdpx:jdField_c_of_type_Boolean	Z
    //   1324: ifeq +12 -> 1336
    //   1327: aload 31
    //   1329: aload 32
    //   1331: invokeinterface 827 2 0
    //   1336: aload_1
    //   1337: getfield 831	bdpx:i	Z
    //   1340: ifne +14 -> 1354
    //   1343: aload_1
    //   1344: ldc_w 833
    //   1347: aload_1
    //   1348: invokevirtual 122	bdpx:a	()Ljava/lang/String;
    //   1351: invokevirtual 835	bdpx:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1354: aload_1
    //   1355: aload 32
    //   1357: invokevirtual 836	bdpx:a	(Ljava/lang/String;)V
    //   1360: aload_1
    //   1361: getfield 795	bdpx:jdField_h_of_type_Boolean	Z
    //   1364: ifeq +56 -> 1420
    //   1367: aload 32
    //   1369: invokestatic 840	bazo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1372: astore 23
    //   1374: aload 23
    //   1376: invokestatic 806	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1379: ifne +12 -> 1391
    //   1382: aload_1
    //   1383: ldc_w 411
    //   1386: aload 23
    //   1388: invokevirtual 835	bdpx:a	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   1417: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
    //   1420: aload_1
    //   1421: ldc_w 844
    //   1424: invokevirtual 846	bdpx:b	(Ljava/lang/String;)V
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
    //   1601: invokevirtual 862	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(ZILjava/net/HttpURLConnection;Lbdpx;Ljava/lang/Throwable;)V
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
    //   1650: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
    //   1653: aload_2
    //   1654: ifnull +13 -> 1667
    //   1657: aload_2
    //   1658: getfield 636	bdpv:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
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
    //   1686: invokevirtual 763	bdpx:d	()Ljava/lang/String;
    //   1689: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1692: ldc_w 765
    //   1695: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1698: aload_1
    //   1699: invokevirtual 767	bdpx:c	()Ljava/lang/String;
    //   1702: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1705: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1708: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
    //   1711: aload_1
    //   1712: getfield 818	bdpx:jdField_f_of_type_Int	I
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
    //   1740: getfield 365	bdpx:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1743: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1746: ldc_w 788
    //   1749: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1752: aload_1
    //   1753: getfield 544	bdpx:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1756: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1759: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1762: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
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
    //   1801: invokevirtual 232	bdpx:e	()Ljava/lang/String;
    //   1804: ldc 230
    //   1806: invokevirtual 186	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1809: ifeq +2557 -> 4366
    //   1812: iconst_1
    //   1813: istore_3
    //   1814: aload_0
    //   1815: aload_1
    //   1816: iload_3
    //   1817: lload 13
    //   1819: invokevirtual 770	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;ZJ)V
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
    //   1875: getfield 636	bdpv:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1878: invokevirtual 441	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1881: ifne -1328 -> 553
    //   1884: aload_1
    //   1885: getfield 652	bdpx:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1888: invokevirtual 441	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1891: ifne -1338 -> 553
    //   1894: iload 5
    //   1896: ifeq +2502 -> 4398
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
    //   1919: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
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
    //   1992: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
    //   1995: aload_2
    //   1996: ifnull +13 -> 2009
    //   1999: aload_2
    //   2000: getfield 636	bdpv:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
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
    //   2028: invokevirtual 763	bdpx:d	()Ljava/lang/String;
    //   2031: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2034: ldc_w 765
    //   2037: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2040: aload_1
    //   2041: invokevirtual 767	bdpx:c	()Ljava/lang/String;
    //   2044: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2047: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2050: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
    //   2053: iload 4
    //   2055: ifeq +57 -> 2112
    //   2058: aload_1
    //   2059: getfield 818	bdpx:jdField_f_of_type_Int	I
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
    //   2087: getfield 365	bdpx:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2090: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2093: ldc_w 788
    //   2096: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2099: aload_1
    //   2100: getfield 544	bdpx:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2103: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2106: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2109: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
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
    //   2148: invokevirtual 232	bdpx:e	()Ljava/lang/String;
    //   2151: ldc 230
    //   2153: invokevirtual 186	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2156: ifeq +2229 -> 4385
    //   2159: iconst_1
    //   2160: istore_3
    //   2161: aload_0
    //   2162: aload_1
    //   2163: iload_3
    //   2164: lload 13
    //   2166: invokevirtual 770	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;ZJ)V
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
    //   2217: invokespecial 688	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Lbdpx;IZ)V
    //   2220: iload 5
    //   2222: sipush 200
    //   2225: if_icmpeq +11 -> 2236
    //   2228: iload 5
    //   2230: sipush 206
    //   2233: if_icmpne +1693 -> 3926
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
    //   2258: getfield 877	bdpx:jdField_b_of_type_Boolean	Z
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
    //   2313: invokevirtual 888	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Lbdpv;Z)V
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
    //   2357: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
    //   2360: aload_2
    //   2361: ifnull +13 -> 2374
    //   2364: aload_2
    //   2365: getfield 636	bdpv:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
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
    //   2393: invokevirtual 763	bdpx:d	()Ljava/lang/String;
    //   2396: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2399: ldc_w 765
    //   2402: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2405: aload_1
    //   2406: invokevirtual 767	bdpx:c	()Ljava/lang/String;
    //   2409: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2412: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2415: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
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
    //   2453: invokevirtual 232	bdpx:e	()Ljava/lang/String;
    //   2456: ldc 230
    //   2458: invokevirtual 186	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2461: ifeq +2899 -> 5360
    //   2464: iconst_1
    //   2465: istore_3
    //   2466: aload_0
    //   2467: aload_1
    //   2468: iload_3
    //   2469: lload 13
    //   2471: invokevirtual 770	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;ZJ)V
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
    //   2536: getfield 894	bdpx:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2539: ifnull +224 -> 2763
    //   2542: aload_1
    //   2543: getfield 894	bdpx:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2546: arraylength
    //   2547: ifle +216 -> 2763
    //   2550: aload 23
    //   2552: invokevirtual 746	java/lang/String:length	()I
    //   2555: ifle +208 -> 2763
    //   2558: iconst_0
    //   2559: istore 8
    //   2561: aload_1
    //   2562: getfield 894	bdpx:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2565: arraylength
    //   2566: iconst_1
    //   2567: if_icmpne +100 -> 2667
    //   2570: aload_1
    //   2571: getfield 894	bdpx:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2574: iconst_0
    //   2575: aaload
    //   2576: ifnull +91 -> 2667
    //   2579: aload_1
    //   2580: getfield 894	bdpx:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
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
    //   2612: astore 32
    //   2614: aload_1
    //   2615: getfield 894	bdpx:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2618: astore 29
    //   2620: aload 29
    //   2622: arraylength
    //   2623: istore 6
    //   2625: iconst_0
    //   2626: istore 4
    //   2628: iload 4
    //   2630: iload 6
    //   2632: if_icmpge +88 -> 2720
    //   2635: aload 29
    //   2637: iload 4
    //   2639: aaload
    //   2640: astore 30
    //   2642: aload 30
    //   2644: ifnull +2721 -> 5365
    //   2647: aload 32
    //   2649: aload 30
    //   2651: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2654: pop
    //   2655: aload 32
    //   2657: ldc_w 898
    //   2660: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2663: pop
    //   2664: goto +2701 -> 5365
    //   2667: aload_1
    //   2668: getfield 894	bdpx:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
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
    //   2701: ifnull +2673 -> 5374
    //   2704: aload 23
    //   2706: aload 29
    //   2708: invokevirtual 901	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2711: ifeq +2663 -> 5374
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
    //   2748: aload 32
    //   2750: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2753: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2756: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2759: invokespecial 651	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   2762: athrow
    //   2763: aload_1
    //   2764: getfield 570	bdpx:jdField_a_of_type_Long	J
    //   2767: lconst_0
    //   2768: lcmp
    //   2769: ifne +26 -> 2795
    //   2772: aload_1
    //   2773: invokevirtual 232	bdpx:e	()Ljava/lang/String;
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
    //   2814: getfield 570	bdpx:jdField_a_of_type_Long	J
    //   2817: invokevirtual 602	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2820: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2823: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
    //   2826: aload_1
    //   2827: getfield 699	bdpx:jdField_d_of_type_Long	J
    //   2830: lconst_0
    //   2831: lcmp
    //   2832: ifeq +15 -> 2847
    //   2835: aload_1
    //   2836: invokestatic 474	android/os/SystemClock:uptimeMillis	()J
    //   2839: aload_1
    //   2840: getfield 699	bdpx:jdField_d_of_type_Long	J
    //   2843: lsub
    //   2844: putfield 913	bdpx:jdField_e_of_type_Long	J
    //   2847: aload 31
    //   2849: aload_1
    //   2850: aload_1
    //   2851: iconst_3
    //   2852: invokeinterface 394 4 0
    //   2857: istore_3
    //   2858: iload_3
    //   2859: ifeq +2475 -> 5334
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
    //   2887: getfield 927	bdpx:jdField_e_of_type_Boolean	Z
    //   2890: ifeq +251 -> 3141
    //   2893: aload_1
    //   2894: invokevirtual 929	bdpx:a	()Z
    //   2897: ifne +244 -> 3141
    //   2900: new 931	bdje
    //   2903: dup
    //   2904: aload 27
    //   2906: aload_1
    //   2907: getfield 570	bdpx:jdField_a_of_type_Long	J
    //   2910: l2i
    //   2911: invokespecial 934	bdje:<init>	(Lcom/tencent/commonsdk/pool/ByteArrayPool;I)V
    //   2914: astore 27
    //   2916: aload_1
    //   2917: getfield 927	bdpx:jdField_e_of_type_Boolean	Z
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
    //   2941: istore 8
    //   2943: lload 15
    //   2945: lstore 19
    //   2947: iload 4
    //   2949: istore 9
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
    //   2979: istore 8
    //   2981: lload 15
    //   2983: lstore 19
    //   2985: iload 4
    //   2987: istore 9
    //   2989: lload 15
    //   2991: lstore 17
    //   2993: aload_0
    //   2994: aload_2
    //   2995: aload_1
    //   2996: invokevirtual 692	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpv;Lbdpx;)V
    //   2999: lload 15
    //   3001: iload 7
    //   3003: i2l
    //   3004: ladd
    //   3005: lstore 21
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
    //   3025: lload 21
    //   3027: lstore 15
    //   3029: iload 10
    //   3031: istore 6
    //   3033: iload 7
    //   3035: istore 8
    //   3037: lload 21
    //   3039: lstore 19
    //   3041: iload 7
    //   3043: istore 9
    //   3045: lload 21
    //   3047: lstore 17
    //   3049: iload 10
    //   3051: aload 28
    //   3053: arraylength
    //   3054: if_icmplt -115 -> 2939
    //   3057: iload 7
    //   3059: istore 8
    //   3061: lload 21
    //   3063: lstore 19
    //   3065: iload 7
    //   3067: istore 9
    //   3069: lload 21
    //   3071: lstore 17
    //   3073: aload_1
    //   3074: invokevirtual 929	bdpx:a	()Z
    //   3077: ifeq +143 -> 3220
    //   3080: iload 7
    //   3082: istore 8
    //   3084: lload 21
    //   3086: lstore 19
    //   3088: iload 7
    //   3090: istore 9
    //   3092: lload 21
    //   3094: lstore 17
    //   3096: aload_1
    //   3097: aload 28
    //   3099: invokevirtual 944	bdpx:a	([B)V
    //   3102: iload 7
    //   3104: istore 8
    //   3106: lload 21
    //   3108: lstore 19
    //   3110: iload 7
    //   3112: istore 9
    //   3114: lload 21
    //   3116: lstore 17
    //   3118: aload 31
    //   3120: aload_1
    //   3121: aload_1
    //   3122: invokeinterface 946 3 0
    //   3127: iconst_0
    //   3128: istore 6
    //   3130: iload 7
    //   3132: istore 4
    //   3134: lload 21
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
    //   3160: aload 23
    //   3162: astore 27
    //   3164: iload 5
    //   3166: istore 4
    //   3168: aconst_null
    //   3169: astore 30
    //   3171: aload 24
    //   3173: astore 23
    //   3175: lload 13
    //   3177: lstore 17
    //   3179: aload 25
    //   3181: astore 29
    //   3183: aload 26
    //   3185: astore 24
    //   3187: iload 6
    //   3189: istore 5
    //   3191: lload 15
    //   3193: lstore 13
    //   3195: lload 17
    //   3197: lstore 15
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
    //   3222: istore 8
    //   3224: lload 21
    //   3226: lstore 19
    //   3228: iload 7
    //   3230: istore 9
    //   3232: lload 21
    //   3234: lstore 17
    //   3236: aload 27
    //   3238: aload 28
    //   3240: invokevirtual 949	java/io/ByteArrayOutputStream:write	([B)V
    //   3243: iconst_0
    //   3244: istore 6
    //   3246: iload 7
    //   3248: istore 4
    //   3250: lload 21
    //   3252: lstore 15
    //   3254: goto -315 -> 2939
    //   3257: iload 4
    //   3259: istore 8
    //   3261: lload 15
    //   3263: lstore 19
    //   3265: iload 4
    //   3267: istore 9
    //   3269: lload 15
    //   3271: lstore 17
    //   3273: aload_1
    //   3274: invokevirtual 929	bdpx:a	()Z
    //   3277: ifeq +493 -> 3770
    //   3280: iload 6
    //   3282: ifle +99 -> 3381
    //   3285: iload 4
    //   3287: istore 8
    //   3289: lload 15
    //   3291: lstore 19
    //   3293: iload 4
    //   3295: istore 9
    //   3297: lload 15
    //   3299: lstore 17
    //   3301: iload 6
    //   3303: newarray byte
    //   3305: astore 30
    //   3307: iload 4
    //   3309: istore 8
    //   3311: lload 15
    //   3313: lstore 19
    //   3315: iload 4
    //   3317: istore 9
    //   3319: lload 15
    //   3321: lstore 17
    //   3323: aload 28
    //   3325: iconst_0
    //   3326: aload 30
    //   3328: iconst_0
    //   3329: iload 6
    //   3331: invokestatic 953	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3334: iload 4
    //   3336: istore 8
    //   3338: lload 15
    //   3340: lstore 19
    //   3342: iload 4
    //   3344: istore 9
    //   3346: lload 15
    //   3348: lstore 17
    //   3350: aload_1
    //   3351: aload 30
    //   3353: invokevirtual 944	bdpx:a	([B)V
    //   3356: iload 4
    //   3358: istore 8
    //   3360: lload 15
    //   3362: lstore 19
    //   3364: iload 4
    //   3366: istore 9
    //   3368: lload 15
    //   3370: lstore 17
    //   3372: aload 31
    //   3374: aload_1
    //   3375: aload_1
    //   3376: invokeinterface 946 3 0
    //   3381: iload 4
    //   3383: istore 8
    //   3385: lload 15
    //   3387: lstore 19
    //   3389: iload 4
    //   3391: istore 9
    //   3393: lload 15
    //   3395: lstore 17
    //   3397: aload_1
    //   3398: getfield 927	bdpx:jdField_e_of_type_Boolean	Z
    //   3401: ifeq +26 -> 3427
    //   3404: iload 4
    //   3406: istore 8
    //   3408: lload 15
    //   3410: lstore 19
    //   3412: iload 4
    //   3414: istore 9
    //   3416: lload 15
    //   3418: lstore 17
    //   3420: aload 29
    //   3422: aload 28
    //   3424: invokevirtual 956	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   3427: iload 4
    //   3429: istore 8
    //   3431: lload 15
    //   3433: lstore 19
    //   3435: iload 4
    //   3437: istore 9
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
    //   3478: aload 23
    //   3480: astore 28
    //   3482: aload 27
    //   3484: astore 23
    //   3486: iload 5
    //   3488: sipush 200
    //   3491: if_icmpeq +11 -> 3502
    //   3494: iload 5
    //   3496: sipush 206
    //   3499: if_icmpne +32 -> 3531
    //   3502: aload_0
    //   3503: aload_1
    //   3504: ldc_w 755
    //   3507: new 246	java/lang/StringBuilder
    //   3510: dup
    //   3511: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   3514: ldc_w 757
    //   3517: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3520: iload 6
    //   3522: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3525: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3528: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
    //   3531: aload_2
    //   3532: ifnull +13 -> 3545
    //   3535: aload_2
    //   3536: getfield 636	bdpv:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3539: invokevirtual 441	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   3542: ifne +106 -> 3648
    //   3545: aload_0
    //   3546: aload_1
    //   3547: ldc_w 759
    //   3550: new 246	java/lang/StringBuilder
    //   3553: dup
    //   3554: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   3557: ldc_w 761
    //   3560: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3563: aload_1
    //   3564: invokevirtual 763	bdpx:d	()Ljava/lang/String;
    //   3567: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3570: ldc_w 765
    //   3573: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3576: aload_1
    //   3577: invokevirtual 767	bdpx:c	()Ljava/lang/String;
    //   3580: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3583: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3586: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
    //   3589: iload 4
    //   3591: ifeq +57 -> 3648
    //   3594: aload_1
    //   3595: getfield 818	bdpx:jdField_f_of_type_Int	I
    //   3598: sipush -9527
    //   3601: if_icmpne +47 -> 3648
    //   3604: aload_0
    //   3605: aload_1
    //   3606: ldc_w 820
    //   3609: new 246	java/lang/StringBuilder
    //   3612: dup
    //   3613: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   3616: ldc_w 786
    //   3619: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3622: aload_1
    //   3623: getfield 365	bdpx:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3626: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3629: ldc_w 788
    //   3632: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3635: aload_1
    //   3636: getfield 544	bdpx:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3639: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3642: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3645: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
    //   3648: aload_0
    //   3649: getfield 381	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   3652: ifnull +17 -> 3669
    //   3655: aload 26
    //   3657: ifnull +12 -> 3669
    //   3660: aload_0
    //   3661: getfield 381	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   3664: aload 26
    //   3666: invokevirtual 496	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   3669: lload 15
    //   3671: lload 13
    //   3673: ladd
    //   3674: lstore 13
    //   3676: lload 13
    //   3678: lconst_0
    //   3679: lcmp
    //   3680: ifeq +25 -> 3705
    //   3683: aload_1
    //   3684: invokevirtual 232	bdpx:e	()Ljava/lang/String;
    //   3687: ldc 230
    //   3689: invokevirtual 186	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3692: ifeq +571 -> 4263
    //   3695: iconst_1
    //   3696: istore_3
    //   3697: aload_0
    //   3698: aload_1
    //   3699: iload_3
    //   3700: lload 13
    //   3702: invokevirtual 770	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;ZJ)V
    //   3705: aload 28
    //   3707: ifnull +8 -> 3715
    //   3710: aload 28
    //   3712: invokevirtual 865	java/io/ByteArrayOutputStream:close	()V
    //   3715: aload 23
    //   3717: ifnull +8 -> 3725
    //   3720: aload 23
    //   3722: invokevirtual 859	java/io/InputStream:close	()V
    //   3725: aload 25
    //   3727: ifnull +8 -> 3735
    //   3730: aload 25
    //   3732: invokevirtual 775	java/io/OutputStream:close	()V
    //   3735: iload 4
    //   3737: istore 5
    //   3739: aload 24
    //   3741: ifnull -1871 -> 1870
    //   3744: aload 24
    //   3746: invokevirtual 778	java/net/HttpURLConnection:disconnect	()V
    //   3749: iload 4
    //   3751: istore 5
    //   3753: goto -1883 -> 1870
    //   3756: astore 23
    //   3758: aload 23
    //   3760: invokevirtual 607	java/lang/Exception:printStackTrace	()V
    //   3763: iload 4
    //   3765: istore 5
    //   3767: goto -1897 -> 1870
    //   3770: iload 6
    //   3772: ifle +29 -> 3801
    //   3775: iload 4
    //   3777: istore 8
    //   3779: lload 15
    //   3781: lstore 19
    //   3783: iload 4
    //   3785: istore 9
    //   3787: lload 15
    //   3789: lstore 17
    //   3791: aload 27
    //   3793: aload 28
    //   3795: iconst_0
    //   3796: iload 6
    //   3798: invokevirtual 957	java/io/ByteArrayOutputStream:write	([BII)V
    //   3801: iload 4
    //   3803: istore 8
    //   3805: lload 15
    //   3807: lstore 19
    //   3809: iload 4
    //   3811: istore 9
    //   3813: lload 15
    //   3815: lstore 17
    //   3817: aload 27
    //   3819: invokevirtual 958	java/io/ByteArrayOutputStream:flush	()V
    //   3822: iload 4
    //   3824: istore 8
    //   3826: lload 15
    //   3828: lstore 19
    //   3830: iload 4
    //   3832: istore 9
    //   3834: lload 15
    //   3836: lstore 17
    //   3838: aload_1
    //   3839: aload 27
    //   3841: invokevirtual 961	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   3844: invokevirtual 944	bdpx:a	([B)V
    //   3847: iload 4
    //   3849: istore 8
    //   3851: lload 15
    //   3853: lstore 19
    //   3855: iload 4
    //   3857: istore 9
    //   3859: lload 15
    //   3861: lstore 17
    //   3863: aload 31
    //   3865: aload_1
    //   3866: aload_1
    //   3867: invokeinterface 946 3 0
    //   3872: goto -491 -> 3381
    //   3875: astore 28
    //   3877: aload 23
    //   3879: astore 29
    //   3881: iload 5
    //   3883: istore 4
    //   3885: iconst_1
    //   3886: istore_3
    //   3887: aload 24
    //   3889: astore 23
    //   3891: aload 25
    //   3893: astore 30
    //   3895: lload 13
    //   3897: lstore 15
    //   3899: aload 27
    //   3901: astore 25
    //   3903: aload 26
    //   3905: astore 24
    //   3907: iload 8
    //   3909: istore 5
    //   3911: lload 19
    //   3913: lstore 13
    //   3915: aload 30
    //   3917: astore 26
    //   3919: aload 29
    //   3921: astore 27
    //   3923: goto -2405 -> 1518
    //   3926: aload_1
    //   3927: getfield 189	bdpx:jdField_f_of_type_Boolean	Z
    //   3930: ifeq +300 -> 4230
    //   3933: aload_1
    //   3934: getfield 203	bdpx:jdField_h_of_type_Int	I
    //   3937: ifeq +293 -> 4230
    //   3940: aload_1
    //   3941: getfield 201	bdpx:jdField_g_of_type_Boolean	Z
    //   3944: ifne +286 -> 4230
    //   3947: aload_0
    //   3948: aload_1
    //   3949: ldc_w 963
    //   3952: ldc_w 965
    //   3955: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
    //   3958: aload_1
    //   3959: iconst_1
    //   3960: putfield 201	bdpx:jdField_g_of_type_Boolean	Z
    //   3963: aload_0
    //   3964: aload_1
    //   3965: aload_2
    //   3966: iconst_0
    //   3967: invokevirtual 888	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Lbdpv;Z)V
    //   3970: new 129	java/util/HashMap
    //   3973: dup
    //   3974: invokespecial 613	java/util/HashMap:<init>	()V
    //   3977: astore 23
    //   3979: aload 23
    //   3981: ldc_w 615
    //   3984: aload_1
    //   3985: getfield 203	bdpx:jdField_h_of_type_Int	I
    //   3988: invokestatic 617	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   3991: invokevirtual 621	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3994: pop
    //   3995: invokestatic 155	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3998: invokestatic 628	azri:a	(Landroid/content/Context;)Lazri;
    //   4001: aconst_null
    //   4002: ldc_w 967
    //   4005: iconst_0
    //   4006: lconst_0
    //   4007: lconst_0
    //   4008: aload 23
    //   4010: ldc_w 490
    //   4013: invokevirtual 633	azri:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   4016: iload 5
    //   4018: sipush 200
    //   4021: if_icmpeq +11 -> 4032
    //   4024: iload 5
    //   4026: sipush 206
    //   4029: if_icmpne +31 -> 4060
    //   4032: aload_0
    //   4033: aload_1
    //   4034: ldc_w 755
    //   4037: new 246	java/lang/StringBuilder
    //   4040: dup
    //   4041: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   4044: ldc_w 757
    //   4047: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4050: iconst_0
    //   4051: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4054: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4057: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
    //   4060: aload_2
    //   4061: ifnull +13 -> 4074
    //   4064: aload_2
    //   4065: getfield 636	bdpv:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4068: invokevirtual 441	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   4071: ifne +47 -> 4118
    //   4074: aload_0
    //   4075: aload_1
    //   4076: ldc_w 759
    //   4079: new 246	java/lang/StringBuilder
    //   4082: dup
    //   4083: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   4086: ldc_w 761
    //   4089: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4092: aload_1
    //   4093: invokevirtual 763	bdpx:d	()Ljava/lang/String;
    //   4096: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4099: ldc_w 765
    //   4102: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4105: aload_1
    //   4106: invokevirtual 767	bdpx:c	()Ljava/lang/String;
    //   4109: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4112: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4115: invokevirtual 282	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;Ljava/lang/String;Ljava/lang/String;)V
    //   4118: aload_0
    //   4119: getfield 381	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4122: ifnull +17 -> 4139
    //   4125: aload 26
    //   4127: ifnull +12 -> 4139
    //   4130: aload_0
    //   4131: getfield 381	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4134: aload 26
    //   4136: invokevirtual 496	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   4139: lload 13
    //   4141: lconst_0
    //   4142: ladd
    //   4143: lstore 13
    //   4145: lload 13
    //   4147: lconst_0
    //   4148: lcmp
    //   4149: ifeq +25 -> 4174
    //   4152: aload_1
    //   4153: invokevirtual 232	bdpx:e	()Ljava/lang/String;
    //   4156: ldc 230
    //   4158: invokevirtual 186	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4161: ifeq +64 -> 4225
    //   4164: iconst_1
    //   4165: istore_3
    //   4166: aload_0
    //   4167: aload_1
    //   4168: iload_3
    //   4169: lload 13
    //   4171: invokevirtual 770	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lbdpx;ZJ)V
    //   4174: iconst_0
    //   4175: ifeq +11 -> 4186
    //   4178: new 772	java/lang/NullPointerException
    //   4181: dup
    //   4182: invokespecial 773	java/lang/NullPointerException:<init>	()V
    //   4185: athrow
    //   4186: iconst_0
    //   4187: ifeq +11 -> 4198
    //   4190: new 772	java/lang/NullPointerException
    //   4193: dup
    //   4194: invokespecial 773	java/lang/NullPointerException:<init>	()V
    //   4197: athrow
    //   4198: aload 25
    //   4200: ifnull +8 -> 4208
    //   4203: aload 25
    //   4205: invokevirtual 775	java/io/OutputStream:close	()V
    //   4208: aload 24
    //   4210: ifnull -3657 -> 553
    //   4213: aload 24
    //   4215: invokevirtual 778	java/net/HttpURLConnection:disconnect	()V
    //   4218: return
    //   4219: astore_1
    //   4220: aload_1
    //   4221: invokevirtual 607	java/lang/Exception:printStackTrace	()V
    //   4224: return
    //   4225: iconst_0
    //   4226: istore_3
    //   4227: goto -61 -> 4166
    //   4230: iconst_1
    //   4231: istore 4
    //   4233: aload_0
    //   4234: iload 5
    //   4236: aload 24
    //   4238: aload_1
    //   4239: invokevirtual 969	com/tencent/mobileqq/utils/httputils/HttpCommunicator:b	(ILjava/net/HttpURLConnection;Lbdpx;)V
    //   4242: lconst_0
    //   4243: lstore 15
    //   4245: iconst_1
    //   4246: istore 4
    //   4248: iload 8
    //   4250: istore 6
    //   4252: aload 30
    //   4254: astore 28
    //   4256: aload 29
    //   4258: astore 23
    //   4260: goto -774 -> 3486
    //   4263: iconst_0
    //   4264: istore_3
    //   4265: goto -568 -> 3697
    //   4268: astore 29
    //   4270: aload 30
    //   4272: ifnull -2680 -> 1592
    //   4275: aload 30
    //   4277: invokevirtual 859	java/io/InputStream:close	()V
    //   4280: goto -2688 -> 1592
    //   4283: astore 29
    //   4285: goto -2693 -> 1592
    //   4288: astore 28
    //   4290: aconst_null
    //   4291: astore 29
    //   4293: aload 29
    //   4295: ifnull +8 -> 4303
    //   4298: aload 29
    //   4300: invokevirtual 859	java/io/InputStream:close	()V
    //   4303: aload 28
    //   4305: athrow
    //   4306: astore 28
    //   4308: lload 15
    //   4310: lstore 17
    //   4312: aload 26
    //   4314: astore 30
    //   4316: aload 23
    //   4318: astore 29
    //   4320: iload 4
    //   4322: istore 7
    //   4324: iconst_1
    //   4325: istore 4
    //   4327: aload 28
    //   4329: astore 23
    //   4331: aload 24
    //   4333: astore 26
    //   4335: iload 5
    //   4337: istore 6
    //   4339: iload 7
    //   4341: istore 5
    //   4343: lload 13
    //   4345: lstore 15
    //   4347: lload 17
    //   4349: lstore 13
    //   4351: aload 25
    //   4353: astore 28
    //   4355: aload 30
    //   4357: astore 25
    //   4359: aload 29
    //   4361: astore 24
    //   4363: goto -2417 -> 1946
    //   4366: iconst_0
    //   4367: istore_3
    //   4368: goto -2554 -> 1814
    //   4371: astore 23
    //   4373: aload 23
    //   4375: invokevirtual 607	java/lang/Exception:printStackTrace	()V
    //   4378: iload 6
    //   4380: istore 5
    //   4382: goto -2512 -> 1870
    //   4385: iconst_0
    //   4386: istore_3
    //   4387: goto -2226 -> 2161
    //   4390: astore_1
    //   4391: aload_1
    //   4392: invokevirtual 607	java/lang/Exception:printStackTrace	()V
    //   4395: goto -2186 -> 2209
    //   4398: aload 31
    //   4400: aload_1
    //   4401: aload_1
    //   4402: iconst_5
    //   4403: invokeinterface 394 4 0
    //   4408: pop
    //   4409: return
    //   4410: astore_1
    //   4411: goto -3890 -> 521
    //   4414: astore_1
    //   4415: goto -3882 -> 533
    //   4418: astore_1
    //   4419: goto -3876 -> 543
    //   4422: astore_1
    //   4423: goto -3409 -> 1014
    //   4426: astore_1
    //   4427: goto -3401 -> 1026
    //   4430: astore_1
    //   4431: goto -3395 -> 1036
    //   4434: astore_1
    //   4435: goto -3159 -> 1276
    //   4438: astore_1
    //   4439: goto -3151 -> 1288
    //   4442: astore_1
    //   4443: goto -3145 -> 1298
    //   4446: astore_1
    //   4447: goto -1961 -> 2486
    //   4450: astore_1
    //   4451: goto -1953 -> 2498
    //   4454: astore_1
    //   4455: goto -1947 -> 2508
    //   4458: astore_1
    //   4459: goto -273 -> 4186
    //   4462: astore_1
    //   4463: goto -265 -> 4198
    //   4466: astore_1
    //   4467: goto -259 -> 4208
    //   4470: astore 26
    //   4472: goto -757 -> 3715
    //   4475: astore 23
    //   4477: goto -752 -> 3725
    //   4480: astore 23
    //   4482: goto -747 -> 3735
    //   4485: astore 29
    //   4487: goto -2895 -> 1592
    //   4490: astore 29
    //   4492: goto -189 -> 4303
    //   4495: astore 24
    //   4497: goto -2665 -> 1832
    //   4500: astore 24
    //   4502: goto -2660 -> 1842
    //   4505: astore 24
    //   4507: goto -2655 -> 1852
    //   4510: astore_1
    //   4511: goto -2332 -> 2179
    //   4514: astore_1
    //   4515: goto -2326 -> 2189
    //   4518: astore_1
    //   4519: goto -2320 -> 2199
    //   4522: astore 23
    //   4524: aconst_null
    //   4525: astore 26
    //   4527: iconst_0
    //   4528: istore_3
    //   4529: lconst_0
    //   4530: lstore 13
    //   4532: iconst_m1
    //   4533: istore 5
    //   4535: aconst_null
    //   4536: astore 25
    //   4538: aconst_null
    //   4539: astore 24
    //   4541: iconst_0
    //   4542: istore 4
    //   4544: iload 7
    //   4546: istore 6
    //   4548: goto -2602 -> 1946
    //   4551: astore 23
    //   4553: iload 4
    //   4555: istore 5
    //   4557: iconst_0
    //   4558: istore 4
    //   4560: iload 7
    //   4562: istore 6
    //   4564: iload 11
    //   4566: istore_3
    //   4567: goto -2621 -> 1946
    //   4570: astore 23
    //   4572: iload 4
    //   4574: istore 5
    //   4576: iconst_0
    //   4577: istore 4
    //   4579: iload 7
    //   4581: istore 6
    //   4583: iload 11
    //   4585: istore_3
    //   4586: goto -2640 -> 1946
    //   4589: astore 29
    //   4591: aload 25
    //   4593: astore 26
    //   4595: iload 11
    //   4597: istore_3
    //   4598: iload 4
    //   4600: istore 5
    //   4602: aload 23
    //   4604: astore 25
    //   4606: aload 29
    //   4608: astore 23
    //   4610: iconst_0
    //   4611: istore 4
    //   4613: iload 7
    //   4615: istore 6
    //   4617: goto -2671 -> 1946
    //   4620: astore 29
    //   4622: aload 25
    //   4624: astore 26
    //   4626: iload 11
    //   4628: istore_3
    //   4629: iload 4
    //   4631: istore 5
    //   4633: aload 23
    //   4635: astore 25
    //   4637: iconst_0
    //   4638: istore 4
    //   4640: aload 29
    //   4642: astore 23
    //   4644: iload 7
    //   4646: istore 6
    //   4648: goto -2702 -> 1946
    //   4651: astore 29
    //   4653: aload 25
    //   4655: astore 26
    //   4657: iload 4
    //   4659: istore 5
    //   4661: aload 23
    //   4663: astore 25
    //   4665: iconst_0
    //   4666: istore 4
    //   4668: aload 29
    //   4670: astore 23
    //   4672: iload 7
    //   4674: istore 6
    //   4676: iload 11
    //   4678: istore_3
    //   4679: goto -2733 -> 1946
    //   4682: astore 29
    //   4684: iload 4
    //   4686: istore 5
    //   4688: aload 23
    //   4690: astore 25
    //   4692: aload 29
    //   4694: astore 23
    //   4696: iconst_0
    //   4697: istore 4
    //   4699: iload 7
    //   4701: istore 6
    //   4703: iload 11
    //   4705: istore_3
    //   4706: goto -2760 -> 1946
    //   4709: astore 23
    //   4711: iconst_0
    //   4712: istore 4
    //   4714: iload 7
    //   4716: istore 6
    //   4718: iload 11
    //   4720: istore_3
    //   4721: goto -2775 -> 1946
    //   4724: astore 29
    //   4726: iconst_0
    //   4727: istore 4
    //   4729: aload 23
    //   4731: astore 27
    //   4733: aload 29
    //   4735: astore 23
    //   4737: iload 7
    //   4739: istore 6
    //   4741: iload 11
    //   4743: istore_3
    //   4744: goto -2798 -> 1946
    //   4747: astore 29
    //   4749: iconst_0
    //   4750: istore 4
    //   4752: aload 27
    //   4754: astore 28
    //   4756: aload 23
    //   4758: astore 27
    //   4760: aload 29
    //   4762: astore 23
    //   4764: iload 7
    //   4766: istore 6
    //   4768: iload 11
    //   4770: istore_3
    //   4771: goto -2825 -> 1946
    //   4774: astore 29
    //   4776: iload 9
    //   4778: istore 6
    //   4780: lload 17
    //   4782: lstore 15
    //   4784: aload 27
    //   4786: astore 28
    //   4788: aload 23
    //   4790: astore 27
    //   4792: iconst_0
    //   4793: istore 4
    //   4795: aload 29
    //   4797: astore 23
    //   4799: iload 11
    //   4801: istore_3
    //   4802: goto -2856 -> 1946
    //   4805: astore 29
    //   4807: iload 4
    //   4809: istore 6
    //   4811: aload 23
    //   4813: astore 28
    //   4815: aload 29
    //   4817: astore 23
    //   4819: iconst_0
    //   4820: istore 4
    //   4822: iload 11
    //   4824: istore_3
    //   4825: goto -2879 -> 1946
    //   4828: astore 23
    //   4830: iload 7
    //   4832: istore 6
    //   4834: iload 11
    //   4836: istore_3
    //   4837: goto -2891 -> 1946
    //   4840: astore 28
    //   4842: goto -549 -> 4293
    //   4845: astore 28
    //   4847: lconst_0
    //   4848: lstore 13
    //   4850: aconst_null
    //   4851: astore 25
    //   4853: aconst_null
    //   4854: astore 26
    //   4856: aconst_null
    //   4857: astore 24
    //   4859: aconst_null
    //   4860: astore 27
    //   4862: lconst_0
    //   4863: lstore 15
    //   4865: iconst_m1
    //   4866: istore 4
    //   4868: aconst_null
    //   4869: astore 23
    //   4871: iconst_0
    //   4872: istore 5
    //   4874: iload 11
    //   4876: istore_3
    //   4877: goto -3359 -> 1518
    //   4880: astore 28
    //   4882: aload 26
    //   4884: astore 27
    //   4886: iconst_0
    //   4887: istore 5
    //   4889: lconst_0
    //   4890: lstore 17
    //   4892: aload 25
    //   4894: astore 26
    //   4896: lload 13
    //   4898: lstore 15
    //   4900: iconst_1
    //   4901: istore_3
    //   4902: aconst_null
    //   4903: astore 29
    //   4905: aconst_null
    //   4906: astore 25
    //   4908: aload 24
    //   4910: astore 23
    //   4912: aload 27
    //   4914: astore 24
    //   4916: lload 17
    //   4918: lstore 13
    //   4920: aload 29
    //   4922: astore 27
    //   4924: goto -3406 -> 1518
    //   4927: astore 28
    //   4929: aload 26
    //   4931: astore 27
    //   4933: iconst_0
    //   4934: istore 5
    //   4936: iconst_1
    //   4937: istore_3
    //   4938: lconst_0
    //   4939: lstore 17
    //   4941: aload 25
    //   4943: astore 26
    //   4945: aload 24
    //   4947: astore 23
    //   4949: lload 13
    //   4951: lstore 15
    //   4953: aconst_null
    //   4954: astore 29
    //   4956: aconst_null
    //   4957: astore 25
    //   4959: aload 27
    //   4961: astore 24
    //   4963: lload 17
    //   4965: lstore 13
    //   4967: aload 29
    //   4969: astore 27
    //   4971: goto -3453 -> 1518
    //   4974: astore 28
    //   4976: lconst_0
    //   4977: lstore 17
    //   4979: aconst_null
    //   4980: astore 27
    //   4982: aload 23
    //   4984: astore 26
    //   4986: aconst_null
    //   4987: astore 29
    //   4989: iload 11
    //   4991: istore_3
    //   4992: lload 13
    //   4994: lstore 15
    //   4996: aload 24
    //   4998: astore 23
    //   5000: iconst_0
    //   5001: istore 5
    //   5003: aload 25
    //   5005: astore 24
    //   5007: lload 17
    //   5009: lstore 13
    //   5011: aload 27
    //   5013: astore 25
    //   5015: aload 29
    //   5017: astore 27
    //   5019: goto -3501 -> 1518
    //   5022: astore 28
    //   5024: iconst_0
    //   5025: istore 5
    //   5027: lconst_0
    //   5028: lstore 17
    //   5030: aconst_null
    //   5031: astore 27
    //   5033: aload 23
    //   5035: astore 26
    //   5037: lload 13
    //   5039: lstore 15
    //   5041: aconst_null
    //   5042: astore 29
    //   5044: iload 11
    //   5046: istore_3
    //   5047: aload 24
    //   5049: astore 23
    //   5051: aload 25
    //   5053: astore 24
    //   5055: lload 17
    //   5057: lstore 13
    //   5059: aload 27
    //   5061: astore 25
    //   5063: aload 29
    //   5065: astore 27
    //   5067: goto -3549 -> 1518
    //   5070: astore 28
    //   5072: iconst_0
    //   5073: istore 5
    //   5075: lconst_0
    //   5076: lstore 17
    //   5078: aload 23
    //   5080: astore 26
    //   5082: lload 13
    //   5084: lstore 15
    //   5086: aconst_null
    //   5087: astore 27
    //   5089: iconst_1
    //   5090: istore_3
    //   5091: aload 24
    //   5093: astore 23
    //   5095: aconst_null
    //   5096: astore 29
    //   5098: aload 25
    //   5100: astore 24
    //   5102: lload 17
    //   5104: lstore 13
    //   5106: aload 29
    //   5108: astore 25
    //   5110: goto -3592 -> 1518
    //   5113: astore 28
    //   5115: iconst_0
    //   5116: istore 5
    //   5118: iconst_1
    //   5119: istore_3
    //   5120: lconst_0
    //   5121: lstore 17
    //   5123: aload 23
    //   5125: astore 27
    //   5127: lload 13
    //   5129: lstore 15
    //   5131: aconst_null
    //   5132: astore 25
    //   5134: aconst_null
    //   5135: astore 29
    //   5137: aload 24
    //   5139: astore 23
    //   5141: aload 26
    //   5143: astore 24
    //   5145: lload 17
    //   5147: lstore 13
    //   5149: aload 27
    //   5151: astore 26
    //   5153: aload 29
    //   5155: astore 27
    //   5157: goto -3639 -> 1518
    //   5160: astore 28
    //   5162: iconst_0
    //   5163: istore 6
    //   5165: iconst_1
    //   5166: istore_3
    //   5167: lload 15
    //   5169: lstore 17
    //   5171: aconst_null
    //   5172: astore 29
    //   5174: iload 5
    //   5176: istore 4
    //   5178: aconst_null
    //   5179: astore 30
    //   5181: lload 13
    //   5183: lstore 15
    //   5185: aload 24
    //   5187: astore 23
    //   5189: aload 25
    //   5191: astore 27
    //   5193: aload 26
    //   5195: astore 24
    //   5197: iload 6
    //   5199: istore 5
    //   5201: lload 17
    //   5203: lstore 13
    //   5205: aload 30
    //   5207: astore 25
    //   5209: aload 27
    //   5211: astore 26
    //   5213: aload 29
    //   5215: astore 27
    //   5217: goto -3699 -> 1518
    //   5220: astore 28
    //   5222: iconst_0
    //   5223: istore 6
    //   5225: iconst_1
    //   5226: istore_3
    //   5227: lload 15
    //   5229: lstore 17
    //   5231: aload 23
    //   5233: astore 29
    //   5235: iload 5
    //   5237: istore 4
    //   5239: aload 26
    //   5241: astore 30
    //   5243: aload 24
    //   5245: astore 23
    //   5247: lload 13
    //   5249: lstore 15
    //   5251: aload 25
    //   5253: astore 26
    //   5255: aload 30
    //   5257: astore 24
    //   5259: iload 6
    //   5261: istore 5
    //   5263: lload 17
    //   5265: lstore 13
    //   5267: aload 27
    //   5269: astore 25
    //   5271: aload 29
    //   5273: astore 27
    //   5275: goto -3757 -> 1518
    //   5278: astore 28
    //   5280: iload 4
    //   5282: istore 6
    //   5284: lload 13
    //   5286: lstore 17
    //   5288: iload 5
    //   5290: istore 4
    //   5292: aload 25
    //   5294: astore 29
    //   5296: aload 23
    //   5298: astore 25
    //   5300: iconst_1
    //   5301: istore_3
    //   5302: aload 24
    //   5304: astore 23
    //   5306: aload 26
    //   5308: astore 24
    //   5310: iload 6
    //   5312: istore 5
    //   5314: lload 15
    //   5316: lstore 13
    //   5318: lload 17
    //   5320: lstore 15
    //   5322: aload 29
    //   5324: astore 26
    //   5326: goto -3808 -> 1518
    //   5329: astore 23
    //   5331: goto -4620 -> 711
    //   5334: iconst_0
    //   5335: istore 4
    //   5337: lconst_0
    //   5338: lstore 15
    //   5340: aconst_null
    //   5341: astore 23
    //   5343: aconst_null
    //   5344: astore 27
    //   5346: goto -1886 -> 3460
    //   5349: aload 25
    //   5351: astore 26
    //   5353: aload 23
    //   5355: astore 25
    //   5357: goto -5046 -> 311
    //   5360: iconst_0
    //   5361: istore_3
    //   5362: goto -2896 -> 2466
    //   5365: iload 4
    //   5367: iconst_1
    //   5368: iadd
    //   5369: istore 4
    //   5371: goto -2743 -> 2628
    //   5374: iload 6
    //   5376: iconst_1
    //   5377: iadd
    //   5378: istore 6
    //   5380: goto -2699 -> 2681
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5383	0	this	HttpCommunicator
    //   0	5383	1	parambdpx	bdpx
    //   0	5383	2	parambdpv	bdpv
    //   0	5383	3	paramBoolean	boolean
    //   25	5345	4	i	int
    //   199	5114	5	j	int
    //   51	5328	6	k	int
    //   40	4791	7	m	int
    //   37	4212	8	n	int
    //   2676	2101	9	i1	int
    //   3012	43	10	i2	int
    //   34	5011	11	bool1	boolean
    //   344	442	12	bool2	boolean
    //   28	5289	13	l1	long
    //   31	5308	15	l2	long
    //   289	5030	17	l3	long
    //   2945	967	19	l4	long
    //   3005	246	21	l5	long
    //   16	1052	23	str	String
    //   1077	1	23	localException1	Exception
    //   1372	490	23	localObject1	Object
    //   1934	276	23	localObject2	Object
    //   2241	1480	23	localObject3	Object
    //   3756	122	23	localException2	Exception
    //   3889	441	23	localObject4	Object
    //   4371	3	23	localException3	Exception
    //   4475	1	23	localIOException1	IOException
    //   4480	1	23	localIOException2	IOException
    //   4522	1	23	localObject5	Object
    //   4551	1	23	localObject6	Object
    //   4570	33	23	localObject7	Object
    //   4608	87	23	localObject8	Object
    //   4709	21	23	localObject9	Object
    //   4735	83	23	localObject10	Object
    //   4828	1	23	localObject11	Object
    //   4869	436	23	localObject12	Object
    //   5329	1	23	localThrowable1	Throwable
    //   5341	13	23	localObject13	Object
    //   7	4355	24	localObject14	Object
    //   4495	1	24	localIOException3	IOException
    //   4500	1	24	localIOException4	IOException
    //   4505	1	24	localIOException5	IOException
    //   4539	770	24	localObject15	Object
    //   57	5299	25	localObject16	Object
    //   81	4253	26	localObject17	Object
    //   4470	1	26	localIOException6	IOException
    //   4525	827	26	localObject18	Object
    //   13	5332	27	localObject19	Object
    //   22	3076	28	localObject20	Object
    //   3153	1	28	localThrowable2	Throwable
    //   3215	579	28	localObject21	Object
    //   3875	1	28	localThrowable3	Throwable
    //   4254	1	28	localObject22	Object
    //   4288	16	28	localObject23	Object
    //   4306	22	28	localObject24	Object
    //   4353	461	28	localObject25	Object
    //   4840	1	28	localObject26	Object
    //   4845	1	28	localThrowable4	Throwable
    //   4880	1	28	localThrowable5	Throwable
    //   4927	1	28	localThrowable6	Throwable
    //   4974	1	28	localThrowable7	Throwable
    //   5022	1	28	localThrowable8	Throwable
    //   5070	1	28	localThrowable9	Throwable
    //   5113	1	28	localThrowable10	Throwable
    //   5160	1	28	localThrowable11	Throwable
    //   5220	1	28	localThrowable12	Throwable
    //   5278	1	28	localThrowable13	Throwable
    //   10	1	29	localObject27	Object
    //   1462	53	29	localThrowable14	Throwable
    //   1546	2711	29	localObject28	Object
    //   4268	1	29	localException4	Exception
    //   4283	1	29	localIOException7	IOException
    //   4291	69	29	localObject29	Object
    //   4485	1	29	localIOException8	IOException
    //   4490	1	29	localIOException9	IOException
    //   4589	18	29	localObject30	Object
    //   4620	21	29	localObject31	Object
    //   4651	18	29	localObject32	Object
    //   4682	11	29	localObject33	Object
    //   4724	10	29	localObject34	Object
    //   4747	14	29	localObject35	Object
    //   4774	22	29	localObject36	Object
    //   4805	11	29	localObject37	Object
    //   4903	420	29	localObject38	Object
    //   19	5237	30	localObject39	Object
    //   4	4395	31	localbdpz	bdpz
    //   159	2590	32	localObject40	Object
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
    //   3926	4016	1462	java/lang/Throwable
    //   4233	4242	1462	java/lang/Throwable
    //   1899	1908	1909	java/lang/Exception
    //   4398	4409	1909	java/lang/Exception
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
    //   3926	4016	1934	finally
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
    //   3648	3655	3756	java/lang/Exception
    //   3660	3669	3756	java/lang/Exception
    //   3683	3695	3756	java/lang/Exception
    //   3697	3705	3756	java/lang/Exception
    //   3710	3715	3756	java/lang/Exception
    //   3720	3725	3756	java/lang/Exception
    //   3730	3735	3756	java/lang/Exception
    //   3744	3749	3756	java/lang/Exception
    //   2955	2972	3875	java/lang/Throwable
    //   2993	2999	3875	java/lang/Throwable
    //   3049	3057	3875	java/lang/Throwable
    //   3073	3080	3875	java/lang/Throwable
    //   3096	3102	3875	java/lang/Throwable
    //   3118	3127	3875	java/lang/Throwable
    //   3236	3243	3875	java/lang/Throwable
    //   3273	3280	3875	java/lang/Throwable
    //   3301	3307	3875	java/lang/Throwable
    //   3323	3334	3875	java/lang/Throwable
    //   3350	3356	3875	java/lang/Throwable
    //   3372	3381	3875	java/lang/Throwable
    //   3397	3404	3875	java/lang/Throwable
    //   3420	3427	3875	java/lang/Throwable
    //   3443	3448	3875	java/lang/Throwable
    //   3791	3801	3875	java/lang/Throwable
    //   3817	3822	3875	java/lang/Throwable
    //   3838	3847	3875	java/lang/Throwable
    //   3863	3872	3875	java/lang/Throwable
    //   4118	4125	4219	java/lang/Exception
    //   4130	4139	4219	java/lang/Exception
    //   4152	4164	4219	java/lang/Exception
    //   4166	4174	4219	java/lang/Exception
    //   4178	4186	4219	java/lang/Exception
    //   4190	4198	4219	java/lang/Exception
    //   4203	4208	4219	java/lang/Exception
    //   4213	4218	4219	java/lang/Exception
    //   1541	1548	4268	java/lang/Exception
    //   1552	1559	4268	java/lang/Exception
    //   1568	1577	4268	java/lang/Exception
    //   4275	4280	4283	java/io/IOException
    //   1541	1548	4288	finally
    //   1521	1528	4306	finally
    //   1587	1592	4306	finally
    //   1592	1604	4306	finally
    //   4275	4280	4306	finally
    //   4298	4303	4306	finally
    //   4303	4306	4306	finally
    //   1765	1772	4371	java/lang/Exception
    //   1777	1786	4371	java/lang/Exception
    //   1800	1812	4371	java/lang/Exception
    //   1814	1822	4371	java/lang/Exception
    //   1827	1832	4371	java/lang/Exception
    //   1837	1842	4371	java/lang/Exception
    //   1847	1852	4371	java/lang/Exception
    //   1861	1866	4371	java/lang/Exception
    //   2112	2119	4390	java/lang/Exception
    //   2124	2133	4390	java/lang/Exception
    //   2147	2159	4390	java/lang/Exception
    //   2161	2169	4390	java/lang/Exception
    //   2174	2179	4390	java/lang/Exception
    //   2184	2189	4390	java/lang/Exception
    //   2194	2199	4390	java/lang/Exception
    //   2204	2209	4390	java/lang/Exception
    //   513	521	4410	java/io/IOException
    //   525	533	4414	java/io/IOException
    //   538	543	4418	java/io/IOException
    //   1006	1014	4422	java/io/IOException
    //   1018	1026	4426	java/io/IOException
    //   1031	1036	4430	java/io/IOException
    //   1268	1276	4434	java/io/IOException
    //   1280	1288	4438	java/io/IOException
    //   1293	1298	4442	java/io/IOException
    //   2478	2486	4446	java/io/IOException
    //   2490	2498	4450	java/io/IOException
    //   2503	2508	4454	java/io/IOException
    //   4178	4186	4458	java/io/IOException
    //   4190	4198	4462	java/io/IOException
    //   4203	4208	4466	java/io/IOException
    //   3710	3715	4470	java/io/IOException
    //   3720	3725	4475	java/io/IOException
    //   3730	3735	4480	java/io/IOException
    //   1587	1592	4485	java/io/IOException
    //   4298	4303	4490	java/io/IOException
    //   1827	1832	4495	java/io/IOException
    //   1837	1842	4500	java/io/IOException
    //   1847	1852	4505	java/io/IOException
    //   2174	2179	4510	java/io/IOException
    //   2184	2189	4514	java/io/IOException
    //   2194	2199	4518	java/io/IOException
    //   42	50	4522	finally
    //   168	198	4551	finally
    //   201	241	4551	finally
    //   256	266	4551	finally
    //   266	277	4551	finally
    //   277	296	4551	finally
    //   311	324	4570	finally
    //   59	83	4589	finally
    //   87	111	4620	finally
    //   114	142	4651	finally
    //   142	168	4682	finally
    //   2869	2876	4709	finally
    //   2876	2916	4724	finally
    //   3141	3150	4724	finally
    //   2916	2933	4747	finally
    //   3210	3217	4747	finally
    //   2955	2972	4774	finally
    //   2993	2999	4774	finally
    //   3049	3057	4774	finally
    //   3073	3080	4774	finally
    //   3096	3102	4774	finally
    //   3118	3127	4774	finally
    //   3236	3243	4774	finally
    //   3273	3280	4774	finally
    //   3301	3307	4774	finally
    //   3323	3334	4774	finally
    //   3350	3356	4774	finally
    //   3372	3381	4774	finally
    //   3397	3404	4774	finally
    //   3420	3427	4774	finally
    //   3443	3448	4774	finally
    //   3791	3801	4774	finally
    //   3817	3822	4774	finally
    //   3838	3847	4774	finally
    //   3863	3872	4774	finally
    //   3460	3471	4805	finally
    //   4233	4242	4828	finally
    //   1552	1559	4840	finally
    //   1568	1577	4840	finally
    //   42	50	4845	java/lang/Throwable
    //   168	198	4880	java/lang/Throwable
    //   201	241	4880	java/lang/Throwable
    //   256	266	4880	java/lang/Throwable
    //   266	277	4880	java/lang/Throwable
    //   277	296	4880	java/lang/Throwable
    //   311	324	4927	java/lang/Throwable
    //   59	83	4974	java/lang/Throwable
    //   87	111	5022	java/lang/Throwable
    //   114	142	5070	java/lang/Throwable
    //   142	168	5113	java/lang/Throwable
    //   2869	2876	5160	java/lang/Throwable
    //   2916	2933	5220	java/lang/Throwable
    //   3210	3217	5220	java/lang/Throwable
    //   3460	3471	5278	java/lang/Throwable
    //   701	706	5329	java/lang/Throwable
    //   706	711	5329	java/lang/Throwable
  }
  
  public void a(bdpx parambdpx, String paramString1, String paramString2)
  {
    try
    {
      baws.a(baws.b(parambdpx.jdField_c_of_type_Int), parambdpx.e().equals("POST"), baws.c(parambdpx.jdField_b_of_type_Int), parambdpx.jdField_a_of_type_JavaLangString, paramString1, paramString2);
      return;
    }
    catch (OutOfMemoryError parambdpx) {}
  }
  
  protected void a(bdpx parambdpx, boolean paramBoolean, long paramLong)
  {
    parambdpx.jdField_g_of_type_Int = ((int)paramLong);
    int i = parambdpx.jdField_b_of_type_Int;
    int j = parambdpx.jdField_c_of_type_Int;
    int k = parambdpx.jdField_d_of_type_Int;
    if (((i == -1) || (j == -1)) && (QLog.isColorLevel())) {
      QLog.e("flowstat", 2, "fileType:" + i + ",busiType:" + j);
    }
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
      ((bdpy)this.jdField_a_of_type_MqqUtilWeakReference.get()).countFlow(paramBoolean, k, i, j, paramLong);
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
        QLog.d("Q.richmedia.HttpCommunicator", 2, "queueSize:" + this.jdField_a_of_type_Bdpw.a() + " mConcurrentRunningMsgs:" + this.e + " mConcurrentLimit:" + this.jdField_d_of_type_Int + " reason:" + paramString + " tid:" + Thread.currentThread().getId());
      }
      if (this.jdField_a_of_type_Bdpw.a() == 0) {
        return;
      }
    }
    bdpv[] arrayOfbdpv;
    int j;
    if (this.e < this.jdField_d_of_type_Int)
    {
      paramString = this.jdField_a_of_type_Bdpw.a(false);
      if (paramString != null)
      {
        arrayOfbdpv = this.jdField_a_of_type_ArrayOfBdpv;
        j = arrayOfbdpv.length;
      }
    }
    for (;;)
    {
      bdpv localbdpv;
      bdpx localbdpx;
      if (i < j)
      {
        localbdpv = arrayOfbdpv[i];
        localbdpx = localbdpv.jdField_a_of_type_Bdpx;
        if (localbdpv.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break label268;
        }
        this.jdField_a_of_type_Bdpw.a(paramString);
        paramString.b();
        localbdpv.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        localbdpv.jdField_a_of_type_Bdpx = paramString;
        localbdpv.a(paramString);
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
        if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!localbdpv.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (localbdpx == null) || (localbdpx.b() <= paramString.b())) {
          break;
        }
        localbdpv.a();
      }
      i += 1;
    }
  }
  
  void a(boolean paramBoolean, int paramInt, HttpURLConnection paramHttpURLConnection, bdpx parambdpx, Throwable paramThrowable)
  {
    if ((paramThrowable instanceof IllegalArgumentException))
    {
      parambdpx.a(9020, paramInt, paramThrowable.toString());
      return;
    }
    if ((paramThrowable instanceof IllegalStateException))
    {
      parambdpx.a(9057, paramInt, paramThrowable.toString());
      return;
    }
    if ((paramThrowable instanceof IOException))
    {
      if ("request cancelled".equals(paramThrowable.getMessage()))
      {
        parambdpx.a(9037, paramInt, paramThrowable.toString());
        return;
      }
      if ("httpcommunicator closed".equals(paramThrowable.getMessage()))
      {
        parambdpx.a(9366, paramInt, paramThrowable.getMessage());
        return;
      }
      if ("preempted by higher msg".equals(paramThrowable.getMessage()))
      {
        parambdpx.a(9361, paramInt, paramThrowable.toString());
        return;
      }
      if ("content-length zero".equals(paramThrowable.getMessage()))
      {
        paramHttpURLConnection = barf.a("Q", -9531L);
        parambdpx.b(bdpx.jdField_f_of_type_JavaLangString, paramHttpURLConnection);
        parambdpx.a(-9527, paramInt, "content zero");
        return;
      }
      if ((paramThrowable instanceof MalformedURLException))
      {
        parambdpx.a(9048, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof InterruptedIOException))
      {
        if ((paramThrowable instanceof SocketTimeoutException))
        {
          if (paramBoolean)
          {
            parambdpx.a(9014, paramInt, paramThrowable.toString());
            return;
          }
          parambdpx.a(9050, paramInt, paramThrowable.toString());
          return;
        }
        parambdpx.a(9049, paramInt, paramThrowable.toString());
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
          parambdpx.a(9052, paramInt, paramHttpURLConnection);
          return;
        }
        if ((paramThrowable instanceof NoRouteToHostException))
        {
          parambdpx.a(9053, paramInt, paramHttpURLConnection);
          return;
        }
        if ((paramThrowable instanceof PortUnreachableException))
        {
          parambdpx.a(9054, paramInt, paramHttpURLConnection);
          return;
        }
        parambdpx.a(9051, paramInt, paramHttpURLConnection);
        return;
      }
      if ((paramThrowable instanceof UnknownHostException))
      {
        parambdpx.a(9055, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof EOFException))
      {
        parambdpx.a(9056, paramInt, paramThrowable.getMessage());
        return;
      }
      paramThrowable = paramThrowable.toString();
      if (paramThrowable.contains("unreachable)")) {
        paramHttpURLConnection = "N_" + -20005;
      }
      for (;;)
      {
        parambdpx.a(9047, paramInt, paramThrowable);
        parambdpx.b(bdpx.jdField_f_of_type_JavaLangString, paramHttpURLConnection);
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
            parambdpx.a(9064, paramInt, paramThrowable);
            return;
          }
          paramHttpURLConnection = "N_" + -20007;
        }
      }
    }
    if ((paramThrowable instanceof SecurityException))
    {
      parambdpx.a(9022, paramInt, paramThrowable.toString());
      return;
    }
    paramHttpURLConnection = paramThrowable.getMessage();
    if ((!TextUtils.isEmpty(paramHttpURLConnection)) && (paramHttpURLConnection.contains("FlowDecoderExp")))
    {
      parambdpx.a(9058, paramInt, paramHttpURLConnection);
      return;
    }
    if ((!TextUtils.isEmpty(paramHttpURLConnection)) && (paramHttpURLConnection.contains("DecryptError")))
    {
      parambdpx.a(9059, paramInt, paramHttpURLConnection);
      return;
    }
    try
    {
      parambdpx.a(9322, paramInt, Log.getStackTraceString(paramThrowable));
      return;
    }
    catch (OutOfMemoryError paramHttpURLConnection) {}
  }
  
  public int b(bdpx parambdpx)
  {
    int i = this.jdField_c_of_type_Int;
    int j = -1;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Bdpw.a() < i))
        {
          i = this.jdField_a_of_type_Int + 1;
          this.jdField_a_of_type_Int = i;
          parambdpx.a(i);
          this.jdField_a_of_type_Bdpw.a(parambdpx);
          parambdpx.a().a(parambdpx, null, 0);
          j = this.jdField_a_of_type_Int;
          i = j;
          if (!this.jdField_b_of_type_Boolean)
          {
            a();
            i = j;
          }
          ??? = new Object();
          parambdpx.jdField_a_of_type_JavaLangObject = ???;
          parambdpx.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
          a("sendMsgSync");
          if (parambdpx.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
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
        parambdpx = finally;
        throw parambdpx;
      }
      catch (InterruptedException parambdpx)
      {
        for (;;)
        {
          parambdpx.printStackTrace();
        }
      }
      finally {}
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new HttpCommunicator.3(this));
  }
  
  void b(int paramInt, HttpURLConnection paramHttpURLConnection, bdpx parambdpx)
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
        paramHttpURLConnection = barf.a(paramInt, l1);
        parambdpx.b(bdpx.jdField_f_of_type_JavaLangString, paramHttpURLConnection);
        parambdpx.a(-9527, paramInt, paramHttpURLConnection);
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
  
  public void b(bdpx parambdpx)
  {
    if (parambdpx != null)
    {
      bdpz localbdpz = parambdpx.a();
      if ((localbdpz instanceof barf)) {
        ((barf)localbdpz).a(2, 9014, "sscm http timeout");
      }
      parambdpx.a().b(parambdpx, null);
    }
  }
  
  public void c()
  {
    int i = 0;
    long l;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      l = System.currentTimeMillis();
      bdpx localbdpx;
      do
      {
        localbdpx = this.jdField_a_of_type_Bdpw.a(true);
        if (localbdpx == null) {
          break;
        }
      } while ((localbdpx == null) || (localbdpx.a() == null));
      localbdpx.a(9366, -1, "httpcommunicator_close");
      localbdpx.a().b(localbdpx, localbdpx);
    }
    this.jdField_a_of_type_Bdpw.a();
    if (this.jdField_a_of_type_ArrayOfBdpv != null)
    {
      bdpv[] arrayOfbdpv = this.jdField_a_of_type_ArrayOfBdpv;
      int j = arrayOfbdpv.length;
      while (i < j)
      {
        arrayOfbdpv[i].sendEmptyMessage(1);
        i += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfBdpv = null;
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