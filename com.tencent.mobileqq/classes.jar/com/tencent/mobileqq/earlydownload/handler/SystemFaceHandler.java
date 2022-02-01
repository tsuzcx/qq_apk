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
  public static final String h = SystemFaceData.class.getSimpleName();
  private Handler i = new Handler(Looper.getMainLooper(), this);
  private ArrayList<String> j;
  
  public SystemFaceHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.system.face.gifv14", paramQQAppInterface);
  }
  
  private void d(String paramString)
  {
    int m = 0;
    int k = m;
    try
    {
      int i1 = Integer.parseInt(paramString);
      k = m;
      int n = com.tencent.mobileqq.text.EmotcationConstants.STATIC_SYS_EMO_GIF_RES[i1];
      k = m;
      m = com.tencent.mobileqq.text.EmotcationConstants.STATIC_SYS_EMOTCATION_RESOURCE[i1];
      k = m;
      URL localURL = new URL("emotion", BaseApplicationImpl.getContext().getResources().getResourceEntryName(n), "");
      k = m;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      if (QLog.isColorLevel()) {
        QLog.d(h, 2, "reloadFaceOnUI() ", localMalformedURLException);
      }
      localObject1 = null;
    }
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = BaseApplicationImpl.getApplication().getResources().getDrawable(k);
    Object localObject1 = URLDrawable.getDrawable((URL)localObject1, (Drawable)localObject2, (Drawable)localObject2, true);
    StringBuilder localStringBuilder;
    if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = h;
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
      localObject2 = h;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reloadFaceOnUI() idx=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" d.status=");
      localStringBuilder.append(((URLDrawable)localObject1).getStatus());
      localStringBuilder.append(" do nothing..");
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
  }
  
  public Class<? extends XmlData> a()
  {
    return SystemFaceData.class;
  }
  
  public void a(String paramString)
  {
    try
    {
      File localFile = BaseApplicationImpl.getContext().getDir("systemface", 0);
      FileUtils.uncompressZip(paramString, localFile.getAbsolutePath(), true);
      if (QLog.isColorLevel())
      {
        String str = h;
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
    this.i.sendEmptyMessage(196864);
  }
  
  public String b()
  {
    return "actEarlySysFaceGif";
  }
  
  public int c()
  {
    return 10055;
  }
  
  public void c(String paramString)
  {
    IEarlyDownloadService localIEarlyDownloadService = (IEarlyDownloadService)this.c.getRuntimeService(IEarlyDownloadService.class, "");
    localIEarlyDownloadService.setEarlyDownloadLock();
    try
    {
      if (this.j == null) {
        this.j = new ArrayList();
      }
      if (!this.j.contains(paramString))
      {
        this.j.add(0, paramString);
        if (QLog.isColorLevel())
        {
          String str = h;
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
  
  public String d()
  {
    return null;
  }
  
  public boolean e()
  {
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 196864) {
      return false;
    }
    paramMessage = null;
    Object localObject = this.j;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = (IEarlyDownloadService)this.c.getRuntimeService(IEarlyDownloadService.class, "");
      ((IEarlyDownloadService)localObject).setEarlyDownloadLock();
      try
      {
        if (this.j.size() > 0) {
          paramMessage = (String)this.j.remove(0);
        }
        ((IEarlyDownloadService)localObject).setEarlyDownloadUnLock();
        if ((paramMessage != null) && (paramMessage.length() > 0))
        {
          d(paramMessage);
          if (this.j.size() > 0)
          {
            this.i.sendEmptyMessageDelayed(196864, 2000L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.SystemFaceHandler
 * JD-Core Version:    0.7.0.1
 */