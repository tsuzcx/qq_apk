package com.tencent.mobileqq.uniformdownload.downloader;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.transfile.HttpCommunicator;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr;
import com.tencent.mobileqq.uniformdownload.filemanager.HttpUrlProcessor;
import com.tencent.mobileqq.uniformdownload.util.UDConstants;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import mqq.app.AppRuntime;

public class UniformDownloaderGenWorker
  implements IHttpCommunicatorListener
{
  public static int a = 1;
  public static String a = "UniformDownloaderGenWorker";
  public static int b = 2;
  public static int c = 3;
  long jdField_a_of_type_Long = 0L;
  private HttpCommunicator jdField_a_of_type_ComTencentMobileqqTransfileHttpCommunicator;
  private UniformDownloaderGen.IUniformDownloaderGenListener jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloaderGen$IUniformDownloaderGenListener = null;
  private HttpMsg jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
  private OutputStream jdField_a_of_type_JavaIoOutputStream = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  long jdField_b_of_type_Long = 0L;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private final String jdField_b_of_type_JavaLangString;
  private final long jdField_c_of_type_Long;
  private Object jdField_c_of_type_JavaLangObject = new Object();
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int = jdField_b_of_type_Int;
  private long jdField_d_of_type_Long;
  private Object jdField_d_of_type_JavaLangObject = new Object();
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int = 0;
  private long jdField_e_of_type_Long = 0L;
  private Object jdField_e_of_type_JavaLangObject = new Object();
  private int f = 0;
  
  public UniformDownloaderGenWorker(long paramLong1, AppRuntime paramAppRuntime, String paramString1, long paramLong2, String paramString2, UniformDownloaderGen.IUniformDownloaderGenListener paramIUniformDownloaderGenListener)
  {
    this.jdField_c_of_type_Long = paramLong1;
    this.jdField_b_of_type_JavaLangString = new HttpUrlProcessor(paramAppRuntime, paramString1).a();
    this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloaderGen$IUniformDownloaderGenListener = paramIUniformDownloaderGenListener;
    this.jdField_d_of_type_Long = paramLong2;
    this.jdField_d_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqTransfileHttpCommunicator = ((HttpCommunicator)((IHttpEngineService)paramAppRuntime.getRuntimeService(IHttpEngineService.class, "")).getCommunicator());
    paramAppRuntime = jdField_a_of_type_JavaLangString;
    paramString1 = new StringBuilder();
    paramString1.append("[UniformDL][HttpCommunicator]:");
    paramString1.append(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpCommunicator.toString());
    QLog.w(paramAppRuntime, 1, paramString1.toString());
  }
  
  private int a()
  {
    int i = jdField_b_of_type_Int;
    synchronized (this.jdField_e_of_type_JavaLangObject)
    {
      i = this.jdField_d_of_type_Int;
      return i;
    }
  }
  
  private long a()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      long l = this.jdField_e_of_type_Long;
      return l;
    }
  }
  
  private UniformDownloaderGen.IUniformDownloaderGenListener a()
  {
    synchronized (this.jdField_d_of_type_JavaLangObject)
    {
      UniformDownloaderGen.IUniformDownloaderGenListener localIUniformDownloaderGenListener = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloaderGen$IUniformDownloaderGenListener;
      return localIUniformDownloaderGenListener;
    }
  }
  
  private HttpMsg a()
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      HttpMsg localHttpMsg = this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
      return localHttpMsg;
    }
  }
  
  private void a(int paramInt)
  {
    synchronized (this.jdField_e_of_type_JavaLangObject)
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.jdField_c_of_type_Long);
      localStringBuilder.append("]. setStatus: ");
      localStringBuilder.append(this.jdField_d_of_type_Int);
      localStringBuilder.append(" -> ");
      localStringBuilder.append(paramInt);
      QLog.i(str, 1, localStringBuilder.toString());
      this.jdField_d_of_type_Int = paramInt;
      return;
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    c();
    Object localObject = UniformDownloadMgr.a().a();
    if (localObject != null)
    {
      localObject = (BaseQQAppInterface)localObject;
      long l1 = this.jdField_c_of_type_Long;
      long l2 = this.jdField_a_of_type_Long;
      long l3 = paramInt;
      QQFileManagerUtil.a((BaseQQAppInterface)localObject, l1, "actFileUfGenDownload", l2, "", "", "", "", l3, paramString1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_b_of_type_JavaLangString, "", this.jdField_e_of_type_Int, paramString2, null);
      QQFileManagerUtil.a((BaseQQAppInterface)localObject, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", l3, paramString1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_b_of_type_JavaLangString, "", this.jdField_e_of_type_Int, paramString2, null);
    }
    else
    {
      paramString2 = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[UniformDL][");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Long);
      ((StringBuilder)localObject).append("].report failed - 3");
      QLog.w(paramString2, 1, ((StringBuilder)localObject).toString());
    }
    paramString2 = a();
    if (paramString2 != null) {
      paramString2.a(paramInt, paramString1, null);
    }
  }
  
  private void a(long paramLong)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_e_of_type_Long = paramLong;
      return;
    }
  }
  
  private void a(UniformDownloaderGen.IUniformDownloaderGenListener paramIUniformDownloaderGenListener)
  {
    synchronized (this.jdField_d_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloaderGen$IUniformDownloaderGenListener = paramIUniformDownloaderGenListener;
      return;
    }
  }
  
  private void a(HttpMsg paramHttpMsg)
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = paramHttpMsg;
      return;
    }
  }
  
  private boolean a()
  {
    return jdField_b_of_type_Int == a();
  }
  
  private boolean a(long paramLong)
  {
    try
    {
      a(paramLong);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("bytes=");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append("-");
      Object localObject3 = ((StringBuilder)localObject1).toString();
      if ((this.jdField_b_of_type_JavaLangString != null) && (!this.jdField_b_of_type_JavaLangString.contains("?")))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject1).append("?&range=");
        ((StringBuilder)localObject1).append(String.valueOf(paramLong));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject1).append("&range=");
        ((StringBuilder)localObject1).append(String.valueOf(paramLong));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      HttpMsg localHttpMsg = new HttpMsg((String)localObject1, null, this, true);
      localObject1 = "gprs";
      if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
        localObject1 = "wifi";
      }
      localHttpMsg.setRequestProperty("Net-type", (String)localObject1);
      localHttpMsg.setRequestProperty("Range", (String)localObject3);
      localHttpMsg.setPriority(1);
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        localHttpMsg.setRequestProperty("Cookie", this.jdField_d_of_type_JavaLangString);
      }
      localHttpMsg.setDataSlice(true);
      localHttpMsg.fileType = 5;
      localHttpMsg.busiType = 0;
      localHttpMsg.msgId = String.valueOf(System.currentTimeMillis());
      localHttpMsg.setRequestProperty("Accept-Encoding", "identity");
      a(localHttpMsg);
      if (UniformDownloadMgr.a().a() == null)
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[UniformDL][");
        ((StringBuilder)localObject3).append(this.jdField_c_of_type_Long);
        ((StringBuilder)localObject3).append("]. downloadFile failed. APP=null. POS:");
        ((StringBuilder)localObject3).append(paramLong);
        ((StringBuilder)localObject3).append(" PGR:");
        ((StringBuilder)localObject3).append((int)(paramLong / this.jdField_d_of_type_Long));
        QLog.i((String)localObject1, 1, ((StringBuilder)localObject3).toString());
        return false;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileHttpCommunicator.sendMsg(localHttpMsg);
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[UniformDL][");
      ((StringBuilder)localObject3).append(this.jdField_c_of_type_Long);
      ((StringBuilder)localObject3).append("]. >>>>>>>>>>downloadFile. POS:");
      ((StringBuilder)localObject3).append(paramLong);
      ((StringBuilder)localObject3).append(" PGR:");
      ((StringBuilder)localObject3).append((int)(paramLong / this.jdField_d_of_type_Long));
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject3).toString());
      return true;
    }
    finally {}
  }
  
  private boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (paramHttpMsg1 == null) {
      return false;
    }
    if (paramHttpMsg2 == null) {
      return true;
    }
    return paramHttpMsg2.permitRetry();
  }
  
  private boolean a(byte[] paramArrayOfByte)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        if (this.jdField_a_of_type_JavaIoOutputStream == null)
        {
          paramArrayOfByte = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[UniformDL][");
          localStringBuilder.append(this.jdField_c_of_type_Long);
          localStringBuilder.append("]. writeFileStream: stream = null:");
          QLog.e(paramArrayOfByte, 1, localStringBuilder.toString());
          return false;
        }
        this.jdField_a_of_type_JavaIoOutputStream.write(paramArrayOfByte);
        return true;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return false;
      }
      throw paramArrayOfByte;
    }
  }
  
  private boolean b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Object localObject2 = this.jdField_a_of_type_JavaIoOutputStream;
      Object localObject4;
      if (localObject2 == null)
      {
        try
        {
          this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_c_of_type_JavaLangString, true);
          localObject2 = jdField_a_of_type_JavaLangString;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("[UniformDL][");
          ((StringBuilder)localObject4).append(this.jdField_c_of_type_Long);
          ((StringBuilder)localObject4).append("]. openFileStream: filepath:");
          ((StringBuilder)localObject4).append(this.jdField_c_of_type_JavaLangString);
          QLog.i((String)localObject2, 1, ((StringBuilder)localObject4).toString());
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          localObject4 = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[UniformDL][");
          localStringBuilder.append(this.jdField_c_of_type_Long);
          localStringBuilder.append("]. openFileStream: exception");
          QLog.e((String)localObject4, 1, localStringBuilder.toString());
          localFileNotFoundException.printStackTrace();
          return false;
        }
      }
      else
      {
        String str = jdField_a_of_type_JavaLangString;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("[UniformDL][");
        ((StringBuilder)localObject4).append(this.jdField_c_of_type_Long);
        ((StringBuilder)localObject4).append("]. openFileStream: had be opened");
        QLog.w(str, 1, ((StringBuilder)localObject4).toString());
      }
      return true;
    }
  }
  
  private void c()
  {
    try
    {
      a(jdField_b_of_type_Int);
      d();
      c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean c()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        String str;
        if (this.jdField_a_of_type_JavaIoOutputStream != null)
        {
          this.jdField_a_of_type_JavaIoOutputStream.close();
          this.jdField_a_of_type_JavaIoOutputStream = null;
          str = jdField_a_of_type_JavaLangString;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("[UniformDL][");
          ((StringBuilder)localObject3).append(this.jdField_c_of_type_Long);
          ((StringBuilder)localObject3).append("]. closeFileStream: filepath:");
          ((StringBuilder)localObject3).append(this.jdField_c_of_type_JavaLangString);
          QLog.i(str, 1, ((StringBuilder)localObject3).toString());
        }
        else
        {
          str = jdField_a_of_type_JavaLangString;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("[UniformDL][");
          ((StringBuilder)localObject3).append(this.jdField_c_of_type_Long);
          ((StringBuilder)localObject3).append("]. closeFileStream.had closed: stream = null:");
          QLog.w(str, 1, ((StringBuilder)localObject3).toString());
        }
        return true;
      }
      catch (IOException localIOException)
      {
        Object localObject3 = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[UniformDL][");
        localStringBuilder.append(this.jdField_c_of_type_Long);
        localStringBuilder.append("]. closeFileStream: exception");
        QLog.e((String)localObject3, 1, localStringBuilder.toString());
        localIOException.printStackTrace();
        return false;
      }
      throw localIOException;
    }
  }
  
  private void d()
  {
    Object localObject1 = a();
    if (localObject1 != null)
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.jdField_c_of_type_Long);
      localStringBuilder.append("]. stopHttpRequest");
      QLog.i((String)localObject2, 1, localStringBuilder.toString());
      a(null);
      if (UniformDownloadMgr.a().a() == null)
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[UniformDL][");
        ((StringBuilder)localObject2).append(this.jdField_c_of_type_Long);
        ((StringBuilder)localObject2).append("]. stopHttpRequest failed.APP=null");
        QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileHttpCommunicator.cancelMsg((HttpMsg)localObject1);
      return;
    }
    localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[UniformDL][");
    ((StringBuilder)localObject2).append(this.jdField_c_of_type_Long);
    ((StringBuilder)localObject2).append("]. stopHttpRequest: no request");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
  }
  
  public void a()
  {
    c();
    a(null);
  }
  
  public boolean a(String paramString, long paramLong)
  {
    if (paramString == null)
    {
      paramString = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.jdField_c_of_type_Long);
      localStringBuilder.append("]. start failed. filepath = null. POS:");
      localStringBuilder.append(paramLong);
      QLog.e(paramString, 1, localStringBuilder.toString());
      return false;
    }
    if (jdField_a_of_type_Int == a())
    {
      paramString = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.jdField_c_of_type_Long);
      localStringBuilder.append("]. start. is runing. POS:");
      localStringBuilder.append(paramLong);
      QLog.w(paramString, 1, localStringBuilder.toString());
      return true;
    }
    this.jdField_c_of_type_JavaLangString = paramString;
    if (!b())
    {
      paramString = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.jdField_c_of_type_Long);
      localStringBuilder.append("]. start failed. openFileStream failed. POS:");
      localStringBuilder.append(paramLong);
      QLog.w(paramString, 1, localStringBuilder.toString());
      paramString = UDConstants.a(8);
      a(8, paramString, paramString);
      return false;
    }
    if (!a(paramLong))
    {
      paramString = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(this.jdField_c_of_type_Long);
      localStringBuilder.append("]. start download failed. POS:");
      localStringBuilder.append(paramLong);
      QLog.e(paramString, 1, localStringBuilder.toString());
      paramString = UDConstants.a(6);
      a(6, paramString, paramString);
      return false;
    }
    a(jdField_a_of_type_Int);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramString = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append("]. start to run download . POS:");
    localStringBuilder.append(paramLong);
    QLog.i(paramString, 1, localStringBuilder.toString());
    return true;
  }
  
  public void b()
  {
    a(jdField_c_of_type_Int);
  }
  
  public void decode(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (a())
    {
      paramHttpMsg1 = jdField_a_of_type_JavaLangString;
      paramHttpMsg2 = new StringBuilder();
      paramHttpMsg2.append("[UniformDL][");
      paramHttpMsg2.append(this.jdField_c_of_type_Long);
      paramHttpMsg2.append("]. decode. but had stoped");
      QLog.e(paramHttpMsg1, 1, paramHttpMsg2.toString());
      return;
    }
    try
    {
      if ((paramHttpMsg2.getResponseCode() == 206) || (paramHttpMsg2.getResponseCode() == 200))
      {
        int i;
        if (!a(paramHttpMsg2.getRecvData()))
        {
          i = 3;
          paramHttpMsg1 = UDConstants.a(3);
          l1 = 0L;
          if (SystemUtil.a()) {
            l1 = SystemUtil.a() * 1024L;
          }
          if (l1 < this.jdField_d_of_type_Long - a())
          {
            paramHttpMsg1 = jdField_a_of_type_JavaLangString;
            paramHttpMsg2 = new StringBuilder();
            paramHttpMsg2.append("[UniformDL][");
            paramHttpMsg2.append(this.jdField_c_of_type_Long);
            paramHttpMsg2.append("] write file failed. sd card space is no enough:[");
            paramHttpMsg2.append(this.jdField_d_of_type_Long);
            paramHttpMsg2.append(" ");
            paramHttpMsg2.append(a());
            paramHttpMsg2.append(" ");
            paramHttpMsg2.append(l1);
            paramHttpMsg2.append("]");
            QLog.e(paramHttpMsg1, 1, paramHttpMsg2.toString());
            i = 9;
            paramHttpMsg1 = UDConstants.a(9);
          }
          a(i, paramHttpMsg1, paramHttpMsg1);
          return;
        }
        long l1 = a() + paramHttpMsg2.getRecvData().length;
        long l2 = paramHttpMsg2.getTotalLen();
        if (this.jdField_d_of_type_Long != l2) {
          this.jdField_d_of_type_Long = l2;
        }
        a(l1);
        this.jdField_b_of_type_Long += paramHttpMsg2.getRecvData().length;
        if (l1 >= this.jdField_d_of_type_Long)
        {
          if (!c())
          {
            paramHttpMsg1 = jdField_a_of_type_JavaLangString;
            paramHttpMsg2 = new StringBuilder();
            paramHttpMsg2.append("[UniformDL][");
            paramHttpMsg2.append(this.jdField_c_of_type_Long);
            paramHttpMsg2.append("].closeFileStream falied.path=");
            paramHttpMsg2.append(this.jdField_c_of_type_JavaLangString);
            QLog.e(paramHttpMsg1, 1, paramHttpMsg2.toString());
            paramHttpMsg1 = UDConstants.a(4);
            a(4, paramHttpMsg1, paramHttpMsg1);
            return;
          }
          paramHttpMsg1 = jdField_a_of_type_JavaLangString;
          paramHttpMsg2 = new StringBuilder();
          paramHttpMsg2.append("[UniformDL][");
          paramHttpMsg2.append(this.jdField_c_of_type_Long);
          paramHttpMsg2.append("].decode >>>>>>>. SUCESSFUL!!!");
          QLog.i(paramHttpMsg1, 1, paramHttpMsg2.toString());
          paramHttpMsg1 = a();
          if (paramHttpMsg1 != null)
          {
            paramHttpMsg2 = new Bundle();
            paramHttpMsg2.putLong("EXT_TRANS_SIZE ", this.jdField_e_of_type_Long);
            paramHttpMsg2.putLong("EXT_TTRANS_SIZE ", this.jdField_b_of_type_Long);
            paramHttpMsg2.putInt("EXT_AUTOTRY_COUNT", this.jdField_e_of_type_Int);
            paramHttpMsg1.a(this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Long, paramHttpMsg2);
          }
        }
        else
        {
          i = (int)((float)l1 / (float)this.jdField_d_of_type_Long * 100.0F);
          paramHttpMsg1 = a();
          if (paramHttpMsg1 != null)
          {
            paramHttpMsg1.a(i, null);
            return;
          }
        }
      }
    }
    catch (Exception paramHttpMsg1)
    {
      paramHttpMsg1.printStackTrace();
      paramHttpMsg1 = UDConstants.a(12);
      a(12, paramHttpMsg1, paramHttpMsg1);
    }
  }
  
  public void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (a())
    {
      paramHttpMsg1 = jdField_a_of_type_JavaLangString;
      paramHttpMsg2 = new StringBuilder();
      paramHttpMsg2.append("[UniformDL][");
      paramHttpMsg2.append(this.jdField_c_of_type_Long);
      paramHttpMsg2.append("]. handleError..user puase");
      QLog.i(paramHttpMsg1, 1, paramHttpMsg2.toString());
      return;
    }
    long l3;
    if (paramHttpMsg2 == null)
    {
      paramHttpMsg1 = jdField_a_of_type_JavaLangString;
      paramHttpMsg2 = new StringBuilder();
      paramHttpMsg2.append("[UniformDL][");
      paramHttpMsg2.append(this.jdField_c_of_type_Long);
      paramHttpMsg2.append("]. handleError.. response=NULL:");
      QLog.e(paramHttpMsg1, 1, paramHttpMsg2.toString());
      c();
      paramHttpMsg1 = UDConstants.a(2);
      paramHttpMsg2 = UniformDownloadMgr.a().a();
      if (paramHttpMsg2 != null)
      {
        paramHttpMsg2 = (BaseQQAppInterface)paramHttpMsg2;
        l1 = this.jdField_c_of_type_Long;
        l2 = this.jdField_a_of_type_Long;
        l3 = 2;
        QQFileManagerUtil.a(paramHttpMsg2, l1, "actFileUfGenDownload", l2, "", "", "", "", l3, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, paramHttpMsg1, null);
        QQFileManagerUtil.a(paramHttpMsg2, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", l3, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, paramHttpMsg1, null);
      }
      else
      {
        paramHttpMsg2 = jdField_a_of_type_JavaLangString;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[UniformDL][");
        ((StringBuilder)localObject1).append(this.jdField_c_of_type_Long);
        ((StringBuilder)localObject1).append("].report failed - 111");
        QLog.w(paramHttpMsg2, 1, ((StringBuilder)localObject1).toString());
      }
      paramHttpMsg2 = a();
      if (paramHttpMsg2 != null) {
        paramHttpMsg2.a(2, paramHttpMsg1, null);
      }
      return;
    }
    Object localObject2 = paramHttpMsg2.getErrorString();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "null";
    }
    localObject2 = jdField_a_of_type_JavaLangString;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("[UniformDL][");
    ((StringBuilder)localObject3).append(this.jdField_c_of_type_Long);
    ((StringBuilder)localObject3).append("]. handleError.. errString:");
    ((StringBuilder)localObject3).append((String)localObject1);
    QLog.e((String)localObject2, 1, ((StringBuilder)localObject3).toString());
    if (jdField_c_of_type_Int == a())
    {
      paramHttpMsg1 = jdField_a_of_type_JavaLangString;
      paramHttpMsg2 = new StringBuilder();
      paramHttpMsg2.append("[UniformDL][");
      paramHttpMsg2.append(this.jdField_c_of_type_Long);
      paramHttpMsg2.append("]. handleError.. slience pause. may app destroy!!");
      QLog.w(paramHttpMsg1, 1, paramHttpMsg2.toString());
      c();
      return;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      c();
      paramHttpMsg1 = UDConstants.a(5);
      paramHttpMsg2 = UniformDownloadMgr.a().a();
      if (paramHttpMsg2 != null)
      {
        paramHttpMsg2 = (BaseQQAppInterface)paramHttpMsg2;
        l1 = this.jdField_c_of_type_Long;
        l2 = this.jdField_a_of_type_Long;
        l3 = 5;
        QQFileManagerUtil.a(paramHttpMsg2, l1, "actFileUfGenDownload", l2, "", "", "", "", l3, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, paramHttpMsg1, null);
        QQFileManagerUtil.a(paramHttpMsg2, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", l3, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_b_of_type_JavaLangString, "", 0, paramHttpMsg1, null);
      }
      else
      {
        paramHttpMsg2 = jdField_a_of_type_JavaLangString;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[UniformDL][");
        ((StringBuilder)localObject1).append(this.jdField_c_of_type_Long);
        ((StringBuilder)localObject1).append("].report failed - 11");
        QLog.w(paramHttpMsg2, 1, ((StringBuilder)localObject1).toString());
      }
      paramHttpMsg2 = a();
      if (paramHttpMsg2 != null) {
        paramHttpMsg2.a(5, paramHttpMsg1, null);
      }
      return;
    }
    long l2 = paramHttpMsg2.errCode;
    localObject3 = String.valueOf(paramHttpMsg2.getSerial());
    String str = paramHttpMsg2.getErrorString();
    long l1 = l2;
    localObject1 = localObject3;
    localObject2 = str;
    if (a(paramHttpMsg1, paramHttpMsg2))
    {
      int i = this.jdField_e_of_type_Int;
      l1 = l2;
      localObject1 = localObject3;
      localObject2 = str;
      if (i < 3)
      {
        this.jdField_e_of_type_Int = (i + 1);
        if ((this.f < 3) && (paramHttpMsg2.errCode == 9056))
        {
          this.f += 1;
          this.jdField_e_of_type_Int -= 1;
        }
        else
        {
          this.f = 0;
        }
        paramHttpMsg1 = jdField_a_of_type_JavaLangString;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[UniformDL][");
        ((StringBuilder)localObject1).append(this.jdField_c_of_type_Long);
        ((StringBuilder)localObject1).append("]. handleError. auto retry to download. autoRetry=");
        ((StringBuilder)localObject1).append(this.jdField_e_of_type_Int);
        ((StringBuilder)localObject1).append(" eofRetry=");
        ((StringBuilder)localObject1).append(this.f);
        QLog.w(paramHttpMsg1, 1, ((StringBuilder)localObject1).toString());
        d();
        if (!a(a()))
        {
          paramHttpMsg1 = jdField_a_of_type_JavaLangString;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[UniformDL][");
          ((StringBuilder)localObject1).append(this.jdField_c_of_type_Long);
          ((StringBuilder)localObject1).append("]. auto retry dowload failed.");
          QLog.e(paramHttpMsg1, 1, ((StringBuilder)localObject1).toString());
          localObject1 = UDConstants.a((int)13L);
          localObject2 = localObject1;
          l1 = 13L;
        }
        else
        {
          paramHttpMsg1 = jdField_a_of_type_JavaLangString;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[UniformDL][");
          ((StringBuilder)localObject1).append(this.jdField_c_of_type_Long);
          ((StringBuilder)localObject1).append("]. auto retry dowload started.");
          QLog.i(paramHttpMsg1, 1, ((StringBuilder)localObject1).toString());
          paramHttpMsg1 = UniformDownloadMgr.a().a();
          if (paramHttpMsg1 != null)
          {
            QQFileManagerUtil.a((BaseQQAppInterface)paramHttpMsg1, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", paramHttpMsg2.errCode, String.valueOf(paramHttpMsg2.getSerial()), this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.jdField_e_of_type_Int, paramHttpMsg2.getErrorString(), null);
            return;
          }
          paramHttpMsg1 = jdField_a_of_type_JavaLangString;
          paramHttpMsg2 = new StringBuilder();
          paramHttpMsg2.append("[UniformDL][");
          paramHttpMsg2.append(this.jdField_c_of_type_Long);
          paramHttpMsg2.append("].report failed - 1");
          QLog.w(paramHttpMsg1, 1, paramHttpMsg2.toString());
          return;
        }
      }
    }
    this.jdField_e_of_type_Int = 0;
    this.f = 0;
    c();
    localObject3 = UniformDownloadMgr.a().a();
    if (localObject3 != null)
    {
      if (13L != l1)
      {
        paramHttpMsg1 = UDConstants.a((int)11L);
        l1 = 11L;
        localObject2 = paramHttpMsg1;
      }
      else
      {
        paramHttpMsg1 = (HttpMsg)localObject1;
      }
      localObject1 = (BaseQQAppInterface)localObject3;
      QQFileManagerUtil.a((BaseQQAppInterface)localObject1, this.jdField_c_of_type_Long, "actFileUfGenDownload", this.jdField_a_of_type_Long, "", "", "", "", l1, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.jdField_e_of_type_Int, (String)localObject2, null);
      QQFileManagerUtil.a((BaseQQAppInterface)localObject1, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", paramHttpMsg2.errCode, String.valueOf(paramHttpMsg2.getSerial()), this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.jdField_e_of_type_Int, paramHttpMsg2.getErrorString(), null);
    }
    else
    {
      paramHttpMsg1 = jdField_a_of_type_JavaLangString;
      paramHttpMsg2 = new StringBuilder();
      paramHttpMsg2.append("[UniformDL][");
      paramHttpMsg2.append(this.jdField_c_of_type_Long);
      paramHttpMsg2.append("].report failed - 2");
      QLog.w(paramHttpMsg1, 1, paramHttpMsg2.toString());
    }
    paramHttpMsg1 = a();
    if (paramHttpMsg1 != null) {
      paramHttpMsg1.a(6, "downloader fialed", null);
    }
  }
  
  public void handleRedirect(String paramString) {}
  
  public boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    paramHttpMsg1 = jdField_a_of_type_JavaLangString;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[UniformDL][");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_Long);
    ((StringBuilder)localObject).append("]. HttpCommunicator statusChanged. status:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i(paramHttpMsg1, 1, ((StringBuilder)localObject).toString());
    if ((5 == paramInt) && (a() < this.jdField_d_of_type_Long))
    {
      c();
      paramHttpMsg1 = UDConstants.a(14);
      localObject = UniformDownloadMgr.a().a();
      if (localObject != null)
      {
        localObject = (BaseQQAppInterface)localObject;
        long l1 = this.jdField_c_of_type_Long;
        long l2 = this.jdField_a_of_type_Long;
        long l3 = 14;
        QQFileManagerUtil.a((BaseQQAppInterface)localObject, l1, "actFileUfGenDownload", l2, "", "", "", "", l3, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.jdField_e_of_type_Int, paramHttpMsg1, null);
        QQFileManagerUtil.a((BaseQQAppInterface)localObject, this.jdField_c_of_type_Long, "actFileUfGenDownloadDetail", this.jdField_a_of_type_Long, "", "", "", "", l3, paramHttpMsg1, this.jdField_b_of_type_Long, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.getRealUrl(), paramHttpMsg2.rawRespHeader, this.jdField_e_of_type_Int, paramHttpMsg1, null);
      }
      else
      {
        paramHttpMsg1 = jdField_a_of_type_JavaLangString;
        paramHttpMsg2 = new StringBuilder();
        paramHttpMsg2.append("[UniformDL][");
        paramHttpMsg2.append(this.jdField_c_of_type_Long);
        paramHttpMsg2.append("].report failed - 2");
        QLog.w(paramHttpMsg1, 1, paramHttpMsg2.toString());
      }
      paramHttpMsg1 = a();
      if (paramHttpMsg1 != null) {
        paramHttpMsg1.a(14, "downloader fialed", null);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderGenWorker
 * JD-Core Version:    0.7.0.1
 */