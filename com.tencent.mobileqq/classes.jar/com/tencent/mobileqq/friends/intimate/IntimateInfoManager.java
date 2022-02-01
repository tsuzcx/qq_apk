package com.tencent.mobileqq.friends.intimate;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ArConfigUtils;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.manager.Manager;

public class IntimateInfoManager
  implements Manager
{
  private QQAppInterface a;
  private EntityManager b;
  private IPreDownloadController c;
  private String d;
  private String e;
  
  public IntimateInfoManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  public static boolean a(String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (!new File(str).exists())
      {
        QLog.e("IntimateInfoManager", 1, String.format("isFilesExist check fail. filePath=%s", new Object[] { str }));
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    boolean bool3 = new File(paramString1).exists();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramString1 = PortalUtils.a(paramString1);
      bool1 = bool2;
      if (paramString2 != null)
      {
        bool1 = bool2;
        if (paramString2.equalsIgnoreCase(paramString1)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private String c(String paramString)
  {
    return String.format("%s/%s.zip", new Object[] { g(), paramString });
  }
  
  private boolean c(String paramString1, String paramString2)
  {
    try
    {
      ArConfigUtils.a(paramString1, paramString2);
      return true;
    }
    catch (Exception paramString1)
    {
      QLog.e("IntimateInfoManager", 1, "unzipResource fail.", paramString1);
    }
    return false;
  }
  
  public static String d()
  {
    return String.format("%s/res", new Object[] { g() });
  }
  
  private void d(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  private boolean e()
  {
    if (!TextUtils.isEmpty(this.e)) {
      return b(c(this.e), this.e);
    }
    return false;
  }
  
  private boolean f()
  {
    if (!TextUtils.isEmpty(this.e))
    {
      String str = d();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("/boy_add");
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("/boy_reduce");
      localObject2 = ((StringBuilder)localObject2).toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(str);
      ((StringBuilder)localObject3).append("/couple_add");
      localObject3 = ((StringBuilder)localObject3).toString();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(str);
      ((StringBuilder)localObject4).append("/couple_reduce");
      localObject4 = ((StringBuilder)localObject4).toString();
      Object localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(str);
      ((StringBuilder)localObject5).append("/girl_add");
      localObject5 = ((StringBuilder)localObject5).toString();
      Object localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append(str);
      ((StringBuilder)localObject6).append("/girl_reduce");
      localObject6 = ((StringBuilder)localObject6).toString();
      Object localObject7 = new StringBuilder();
      ((StringBuilder)localObject7).append(str);
      ((StringBuilder)localObject7).append("/bestfriend_add");
      localObject7 = ((StringBuilder)localObject7).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("/bestfriend_reduce");
      if (a(new String[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localStringBuilder.toString() })) {
        return true;
      }
    }
    return false;
  }
  
  private static String g()
  {
    Object localObject1 = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject1 != null)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
      ((StringBuilder)localObject2).append("/pddata/prd/intimate_res");
      localObject2 = ((StringBuilder)localObject2).toString();
      File localFile = new File((String)localObject2);
      localObject1 = localObject2;
      if (!localFile.exists())
      {
        localFile.mkdirs();
        return localObject2;
      }
    }
    else
    {
      localObject1 = null;
    }
    return localObject1;
  }
  
  public IntimateInfo a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    EntityManager localEntityManager = this.b;
    Object localObject1 = localObject2;
    if (localEntityManager != null)
    {
      localObject1 = localObject2;
      if (localEntityManager.isOpen()) {
        localObject1 = (IntimateInfo)this.b.find(IntimateInfo.class, paramString);
      }
    }
    return localObject1;
  }
  
  public String a(int paramInt, boolean paramBoolean)
  {
    String str = d();
    StringBuilder localStringBuilder;
    if (paramInt == 3)
    {
      if (paramBoolean)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("/boy_add/data.json");
        str = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("/boy_reduce/data.json");
        str = localStringBuilder.toString();
      }
    }
    else if (paramInt == 2)
    {
      if (paramBoolean)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("/girl_add/data.json");
        str = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("/girl_reduce/data.json");
        str = localStringBuilder.toString();
      }
    }
    else if (paramInt == 26)
    {
      if (paramBoolean)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("/bestfriend_add/data.json");
        str = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("/bestfriend_reduce/data.json");
        str = localStringBuilder.toString();
      }
    }
    else
    {
      if (paramInt != 1) {
        break label359;
      }
      if (paramBoolean)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("/couple_add/data.json");
        str = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("/couple_reduce/data.json");
        str = localStringBuilder.toString();
      }
    }
    if ((!new File(str).exists()) && (QLog.isColorLevel()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getIntimateScoreAnimJsonPath not exists:");
      localStringBuilder.append(str);
      QLog.d("IntimateInfoManager", 2, localStringBuilder.toString());
    }
    return str;
    label359:
    return null;
  }
  
  public void a()
  {
    if ((!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(this.e)))
    {
      if (this.c == null) {
        this.c = ((IPreDownloadController)this.a.getRuntimeService(IPreDownloadController.class));
      }
      String str = c(this.e);
      if (!b(str, this.e))
      {
        d(str);
        if (this.c != null)
        {
          Object localObject = new HttpNetReq();
          ((HttpNetReq)localObject).mCallback = new IntimateInfoManager.1(this);
          ((HttpNetReq)localObject).mReqUrl = this.d;
          ((HttpNetReq)localObject).mHttpMethod = 0;
          ((HttpNetReq)localObject).mOutPath = str;
          ((HttpNetReq)localObject).mPrioty = 0;
          ((HttpNetReq)localObject).mSupportBreakResume = true;
          localObject = new HttpEngineTask(this.a, this.e, new IntimateInfoManager.2(this), (HttpNetReq)localObject);
          this.c.requestPreDownload(10089, "prd", this.e, 0, this.d, str, 2, 0, false, (AbsPreDownloadTask)localObject);
        }
      }
      else if (!f())
      {
        boolean bool1 = c(str, d());
        boolean bool2 = f();
        if (QLog.isColorLevel()) {
          QLog.d("IntimateInfoManager", 2, String.format("downloadResource unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
        }
      }
      return;
    }
    QLog.e("IntimateInfoManager", 1, "downloadResource invalid parameters.");
  }
  
  public void a(IntimateInfo paramIntimateInfo)
  {
    if (paramIntimateInfo == null) {
      return;
    }
    EntityManager localEntityManager = this.b;
    if ((localEntityManager != null) && (localEntityManager.isOpen())) {
      this.b.update(paramIntimateInfo);
    }
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("updateIntimateInfo, uin: %s", new Object[] { paramIntimateInfo.friendUin }));
    }
  }
  
  public void a(String paramString, IntimateInfo paramIntimateInfo)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramIntimateInfo == null) {
        return;
      }
      EntityManager localEntityManager = this.b;
      if ((localEntityManager != null) && (localEntityManager.isOpen())) {
        this.b.persistOrReplace(paramIntimateInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, String.format("updateIntimateInfo, uin: %s", new Object[] { paramString }));
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("checkAndDownloadIntimateResources url=%s md5=%s", new Object[] { paramString1, paramString2 }));
    }
    this.d = paramString1;
    this.e = paramString2;
    if (!b()) {
      a();
    }
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = this.b;
    if ((localObject != null) && (((EntityManager)localObject).isOpen()))
    {
      paramString = (IntimateInfo)this.b.find(IntimateInfo.class, paramString);
      if (paramString != null) {
        this.b.remove(paramString);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("removeIntimateInfo: ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("intimate_relationship", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public boolean b()
  {
    boolean bool1 = e();
    boolean bool2 = f();
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("checkResourceReady download=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
    }
    return (bool1) && (bool2);
  }
  
  public void c()
  {
    if ((this.c != null) && (!TextUtils.isEmpty(this.d))) {
      this.c.cancelPreDownload(this.d);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "IntimateInfoManager onDestroy");
    }
    this.b.close();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.friends.intimate.IntimateInfoManager
 * JD-Core Version:    0.7.0.1
 */