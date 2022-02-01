package com.tencent.mobileqq.earlydownload.handler;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.xmldata.SystemFaceData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class SystemFaceHandler
  extends EarlyHandler
  implements Handler.Callback
{
  public static final String c = SystemFaceData.class.getSimpleName();
  private Handler a;
  private ArrayList<String> b;
  
  public SystemFaceHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.system.face.gifv14", paramQQAppInterface);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private void c(String paramString)
  {
    int j = 0;
    int i = j;
    try
    {
      int m = Integer.parseInt(paramString);
      i = j;
      int k = com.tencent.mobileqq.text.EmotcationConstants.STATIC_SYS_EMO_GIF_RES[m];
      i = j;
      j = com.tencent.mobileqq.text.EmotcationConstants.STATIC_SYS_EMOTCATION_RESOURCE[m];
      i = j;
      URL localURL = new URL("emotion", BaseApplicationImpl.getContext().getResources().getResourceEntryName(k), "");
      i = j;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      if (QLog.isColorLevel()) {
        QLog.d(c, 2, "reloadFaceOnUI() ", localMalformedURLException);
      }
      localObject1 = null;
    }
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = BaseApplicationImpl.getApplication().getResources().getDrawable(i);
    Object localObject1 = URLDrawable.getDrawable((URL)localObject1, (Drawable)localObject2, (Drawable)localObject2, true);
    StringBuilder localStringBuilder;
    if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = c;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("reloadFaceOnUI() idx=");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" d.status!=successed||loading. go to restartDownload");
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
      }
      ((URLDrawable)localObject1).addHeader("faceIdx", paramString);
      ((URLDrawable)localObject1).restartDownload();
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reloadFaceOnUI() idx=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" d.status=");
      localStringBuilder.append(((URLDrawable)localObject1).getStatus());
      localStringBuilder.append(" do nothing..");
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
  }
  
  public int a()
  {
    return 10055;
  }
  
  public Class<? extends XmlData> a()
  {
    return SystemFaceData.class;
  }
  
  public String a()
  {
    return "actEarlySysFaceGif";
  }
  
  public void a(String paramString)
  {
    try
    {
      File localFile = BaseApplicationImpl.getContext().getDir("systemface", 0);
      FileUtils.uncompressZip(paramString, localFile.getAbsolutePath(), true);
      if (QLog.isColorLevel())
      {
        String str = c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doOnDownloadFinish() uncompressZip to:");
        localStringBuilder.append(localFile.getAbsolutePath());
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    super.a(paramString);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(196864);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return null;
  }
  
  public void b(String paramString)
  {
    IEarlyDownloadService localIEarlyDownloadService = (IEarlyDownloadService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IEarlyDownloadService.class, "");
    localIEarlyDownloadService.setEarlyDownloadLock();
    try
    {
      if (this.b == null) {
        this.b = new ArrayList();
      }
      if (!this.b.contains(paramString))
      {
        this.b.add(0, paramString);
        if (QLog.isColorLevel())
        {
          String str = c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("addWaittingFace idx=");
          localStringBuilder.append(paramString);
          QLog.d(str, 2, localStringBuilder.toString());
        }
      }
      return;
    }
    finally
    {
      localIEarlyDownloadService.setEarlyDownloadUnLock();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 196864) {
      return false;
    }
    paramMessage = null;
    Object localObject = this.b;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = (IEarlyDownloadService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IEarlyDownloadService.class, "");
      ((IEarlyDownloadService)localObject).setEarlyDownloadLock();
      try
      {
        if (this.b.size() > 0) {
          paramMessage = (String)this.b.remove(0);
        }
        ((IEarlyDownloadService)localObject).setEarlyDownloadUnLock();
        if ((paramMessage != null) && (paramMessage.length() > 0))
        {
          c(paramMessage);
          if (this.b.size() > 0)
          {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(196864, 2000L);
            return false;
          }
        }
      }
      finally
      {
        ((IEarlyDownloadService)localObject).setEarlyDownloadUnLock();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.SystemFaceHandler
 * JD-Core Version:    0.7.0.1
 */