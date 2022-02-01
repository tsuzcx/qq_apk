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
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.TroopNickNameBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.TroopNickNameBusiness.Config;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class TroopNickAdapter
  implements VasResAdapter, VasResDrawable.VasResDrawableAdapter
{
  public int a;
  private VasResController jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  public int b;
  
  public TroopNickAdapter(VasResDrawable paramVasResDrawable)
  {
    this(paramVasResDrawable, null, 2130846437);
  }
  
  public TroopNickAdapter(VasResDrawable paramVasResDrawable, AppRuntime paramAppRuntime, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController = paramVasResDrawable.a();
    paramVasResDrawable.a().jdField_a_of_type_Int = 2130847798;
    paramVasResDrawable.a().b = paramInt;
    paramVasResDrawable.a().e = 104;
    if (paramAppRuntime != null) {
      paramVasResDrawable.a("my_uin", paramAppRuntime.getAccount());
    }
  }
  
  public String a()
  {
    File localFile = new File(this.jdField_a_of_type_JavaLangString, "bg.png");
    if (localFile.exists()) {
      return localFile.getAbsolutePath();
    }
    return new File(this.jdField_a_of_type_JavaLangString, "bg.9.png").getAbsolutePath();
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    int i = 0;
    boolean bool;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("downloadDone isMainThread:");
      if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId())
      {
        bool = true;
        QLog.d("TroopNickAdapter", 2, bool);
      }
    }
    else
    {
      if (paramBundle != null) {
        i = paramBundle.getInt("resType");
      }
      switch (i)
      {
      }
    }
    do
    {
      return;
      bool = false;
      break;
    } while ((3 != paramInt) && (paramInt != 0));
    ThreadManager.excute(new TroopNickAdapter.3(this, paramBundle), 128, null, true);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    ThreadManagerV2.excute(new TroopNickAdapter.2(this, paramString, paramInt1, paramInt2), 16, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String[] a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new File(paramString);
    if ((localObject1 == null) || (!((File)localObject1).exists()) || (!((File)localObject1).isDirectory()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNickAdapter", 2, "SignatureView DynamicItem png file path error.");
      }
      return null;
    }
    localObject1 = ((File)localObject1).listFiles();
    for (;;)
    {
      try
      {
        Object localObject2 = new StringBuilder();
        StringBuilder localStringBuilder = ((StringBuilder)localObject2).append(paramString).append(File.separator);
        if (!new File(paramString, "01.9.png").exists()) {
          break label254;
        }
        paramString = "%s.9.png";
        localStringBuilder.append(paramString);
        localObject2 = ((StringBuilder)localObject2).toString();
        int i = 1;
        if (i < localObject1.length)
        {
          if (i < 10)
          {
            paramString = "0" + i;
            paramString = String.format((String)localObject2, new Object[] { paramString });
            if (new File(paramString).exists())
            {
              localArrayList.add(paramString);
              i += 1;
            }
          }
          else
          {
            paramString = i + "";
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
      label254:
      paramString = "%s.png";
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController == null) {
        return;
      }
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController.a();
    TroopNickNameBusiness.Config localConfig;
    if (((TroopNickNameBusiness)QQVasUpdateBusiness.a(TroopNickNameBusiness.class)).a(i))
    {
      this.jdField_a_of_type_JavaLangString = ((TroopNickNameBusiness)QQVasUpdateBusiness.a(TroopNickNameBusiness.class)).b(i);
      localConfig = TroopNickNameBusiness.a(this.jdField_a_of_type_JavaLangString);
      if (localConfig != null)
      {
        this.jdField_a_of_type_Int = localConfig.fontId;
        this.b = localConfig.fontType;
        String str = this.jdField_a_of_type_JavaLangString;
        int j = localConfig.delay;
        if (!this.jdField_a_of_type_Boolean) {
          break label135;
        }
        i = -1;
        a(str, j, i);
      }
    }
    for (;;)
    {
      return;
      label135:
      i = localConfig.repeatCount;
      break;
      ((IEmoticonManager)RemoteProxy.getProxy(EmoticonManagerIPC.class)).startTroopNickDownload(i, null, -1, new TroopNickAdapter.1(this));
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController != null) {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController)
      {
        this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController = null;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.TroopNickAdapter
 * JD-Core Version:    0.7.0.1
 */