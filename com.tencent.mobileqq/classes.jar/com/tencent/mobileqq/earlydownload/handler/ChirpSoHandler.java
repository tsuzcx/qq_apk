package com.tencent.mobileqq.earlydownload.handler;

import abrt;
import abru;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.xmldata.ChirpSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import mqq.os.MqqHandler;

public class ChirpSoHandler
  extends EarlyHandler
{
  private LinkedList a = new LinkedList();
  private QQAppInterface b;
  private boolean d;
  
  public ChirpSoHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.system.chirp", paramQQAppInterface);
    this.b = paramQQAppInterface;
  }
  
  public int a()
  {
    return 10040;
  }
  
  public Class a()
  {
    return ChirpSoData.class;
  }
  
  public String a()
  {
    return "actEarlyChirpSo";
  }
  
  public void a(ChirpSoHandler.Callback paramCallback)
  {
    synchronized (this.a)
    {
      if (!this.a.contains(paramCallback)) {
        this.a.add(paramCallback);
      }
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChirpSoHandler", 2, "onDownload success " + paramString);
    }
    paramString = new abrt(this, paramString);
    if (Looper.getMainLooper() == Looper.myLooper()) {
      ThreadManager.getSubThreadHandler().post(paramString);
    }
    for (;;)
    {
      BaseApplicationImpl.sUiHandler.post(new abru(this));
      return;
      paramString.run();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChirpSoHandler", 2, "restartDownload " + paramBoolean);
    }
    if (!this.d) {
      this.d = paramBoolean;
    }
    if ((a() != null) && (a().loadState == 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChirpSoHandler", 2, "is in downloading");
      }
      return;
    }
    super.a(paramBoolean);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return null;
  }
  
  public void b(ChirpSoHandler.Callback paramCallback)
  {
    synchronized (this.a)
    {
      this.a.remove(paramCallback);
      return;
    }
  }
  
  public boolean e_()
  {
    if (this.d)
    {
      this.b.D();
      if (QLog.isColorLevel()) {
        QLog.d("ChirpSoHandler", 2, "isNetValid2Download by user " + AppSetting.b);
      }
      return AppSetting.b;
    }
    this.b.D();
    if (QLog.isColorLevel()) {
      QLog.d("ChirpSoHandler", 2, "isNetValid2Download by startup " + AppSetting.b);
    }
    return (AppSetting.b) && (super.e_());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler
 * JD-Core Version:    0.7.0.1
 */