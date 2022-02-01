package com.tencent.mobileqq.vas.troopnick;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.VasResEngine.VasResAdapter;
import com.tencent.mobileqq.vas.VasResEngine.VasResController;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable.VasResDrawableAdapter;
import com.tencent.mobileqq.vas.ipc.RemoteProxy;
import com.tencent.mobileqq.vas.ipc.remote.EmoticonManagerIPC;
import com.tencent.mobileqq.vas.ipc.remote.IEmoticonManager;
import com.tencent.mobileqq.vas.updatesystem.business.TroopNickNameBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.TroopNickNameBusiness.Config;
import com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class TroopNickAdapter
  implements VasResAdapter, VasResDrawable.VasResDrawableAdapter
{
  public int a;
  public int b;
  private VasResController c;
  private String d = "";
  private boolean e = false;
  
  public TroopNickAdapter(VasResDrawable paramVasResDrawable)
  {
    this(paramVasResDrawable, null, 2130847784);
  }
  
  public TroopNickAdapter(VasResDrawable paramVasResDrawable, AppRuntime paramAppRuntime, int paramInt)
  {
    this.c = paramVasResDrawable.a();
    paramVasResDrawable.d().b = 2130849325;
    paramVasResDrawable.d().c = paramInt;
    paramVasResDrawable.d().g = 104;
    if (paramAppRuntime != null) {
      paramVasResDrawable.b("my_uin", paramAppRuntime.getAccount());
    }
  }
  
  public void a()
  {
    VasResController localVasResController = this.c;
    if (localVasResController == null) {
      return;
    }
    try
    {
      if (this.c == null) {
        return;
      }
      int j = this.c.b();
      boolean bool = ((TroopNickNameBusiness)QQVasUpdateBusinessUtil.a(TroopNickNameBusiness.class)).d(j);
      int i = -1;
      if (bool)
      {
        this.d = ((TroopNickNameBusiness)QQVasUpdateBusinessUtil.a(TroopNickNameBusiness.class)).c(j);
        TroopNickNameBusiness.Config localConfig = TroopNickNameBusiness.a(this.d);
        if (localConfig != null)
        {
          this.a = localConfig.fontId;
          this.b = localConfig.fontType;
          String str = this.d;
          j = localConfig.delay;
          if (!this.e) {
            i = localConfig.repeatCount;
          }
          a(str, j, i);
        }
      }
      else
      {
        ((IEmoticonManager)RemoteProxy.getProxy(EmoticonManagerIPC.class)).startTroopNickDownload(j, null, -1, new TroopNickAdapter.1(this));
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    boolean bool = QLog.isColorLevel();
    int i = 0;
    if (bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadDone isMainThread:");
      if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId()) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("TroopNickAdapter", 2, localStringBuilder.toString());
    }
    if (paramBundle != null) {
      i = paramBundle.getInt("resType");
    }
    if (i != 2) {
      return;
    }
    if ((3 == paramInt) || (paramInt == 0)) {
      ThreadManager.excute(new TroopNickAdapter.3(this, paramBundle), 128, null, true);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    ThreadManagerV2.excute(new TroopNickAdapter.2(this, paramString, paramInt1, paramInt2), 16, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public String[] a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new File(paramString);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory())) {
      localObject1 = ((File)localObject1).listFiles();
    }
    for (;;)
    {
      try
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(File.separator);
        if (!new File(paramString, "01.9.png").exists()) {
          break label268;
        }
        paramString = "%s.9.png";
        ((StringBuilder)localObject2).append(paramString);
        localObject2 = ((StringBuilder)localObject2).toString();
        int i = 1;
        if (i < localObject1.length)
        {
          if (i < 10)
          {
            paramString = new StringBuilder();
            paramString.append("0");
            paramString.append(i);
            paramString = paramString.toString();
          }
          else
          {
            paramString = new StringBuilder();
            paramString.append(i);
            paramString.append("");
            continue;
          }
          paramString = String.format((String)localObject2, new Object[] { paramString });
          if (new File(paramString).exists())
          {
            localArrayList.add(paramString);
            i += 1;
            continue;
          }
          paramString = (String[])localArrayList.toArray(new String[localArrayList.size()]);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      return (String[])localArrayList.toArray(new String[localArrayList.size()]);
      if (QLog.isColorLevel()) {
        QLog.d("TroopNickAdapter", 2, "SignatureView DynamicItem png file path error.");
      }
      return null;
      label268:
      paramString = "%s.png";
    }
  }
  
  public void b()
  {
    VasResController localVasResController = this.c;
    if (localVasResController != null) {
      try
      {
        this.c = null;
        return;
      }
      finally {}
    }
  }
  
  public String c()
  {
    File localFile = new File(this.d, "bg.png");
    if (localFile.exists()) {
      return localFile.getAbsolutePath();
    }
    return new File(this.d, "bg.9.png").getAbsolutePath();
  }
  
  public boolean d()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.TroopNickAdapter
 * JD-Core Version:    0.7.0.1
 */