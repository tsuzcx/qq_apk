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
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private IPreDownloadController jdField_a_of_type_ComTencentMobileqqTransfilePredownloadIPreDownloadController;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public IntimateInfoManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  public static String a()
  {
    return String.format("%s/res", new Object[] { b() });
  }
  
  private String a(String paramString)
  {
    return String.format("%s/%s.zip", new Object[] { b(), paramString });
  }
  
  private boolean a(String paramString1, String paramString2)
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
  
  private static String b()
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
  
  private void b(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  private boolean b()
  {
    if (!TextUtils.isEmpty(this.b)) {
      return a(a(this.b), this.b);
    }
    return false;
  }
  
  private boolean b(String paramString1, String paramString2)
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
  
  private boolean c()
  {
    if (!TextUtils.isEmpty(this.b))
    {
      String str = a();
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
  
  public IntimateInfo a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    Object localObject1 = localObject2;
    if (localEntityManager != null)
    {
      localObject1 = localObject2;
      if (localEntityManager.isOpen()) {
        localObject1 = (IntimateInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(IntimateInfo.class, paramString);
      }
    }
    return localObject1;
  }
  
  public String a(int paramInt, boolean paramBoolean)
  {
    String str = a();
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
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.b)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadIPreDownloadController == null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadIPreDownloadController = ((IPreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPreDownloadController.class));
      }
      String str = a(this.b);
      if (!a(str, this.b))
      {
        b(str);
        if (this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadIPreDownloadController != null)
        {
          Object localObject = new HttpNetReq();
          ((HttpNetReq)localObject).mCallback = new IntimateInfoManager.1(this);
          ((HttpNetReq)localObject).mReqUrl = this.jdField_a_of_type_JavaLangString;
          ((HttpNetReq)localObject).mHttpMethod = 0;
          ((HttpNetReq)localObject).mOutPath = str;
          ((HttpNetReq)localObject).mPrioty = 0;
          ((HttpNetReq)localObject).mSupportBreakResume = true;
          localObject = new HttpEngineTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b, new IntimateInfoManager.2(this), (HttpNetReq)localObject);
          this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadIPreDownloadController.requestPreDownload(10089, "prd", this.b, 0, this.jdField_a_of_type_JavaLangString, str, 2, 0, false, (AbsPreDownloadTask)localObject);
        }
      }
      else if (!c())
      {
        boolean bool1 = b(str, a());
        boolean bool2 = c();
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
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    if ((localEntityManager != null) && (localEntityManager.isOpen())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramIntimateInfo);
    }
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("updateIntimateInfo, uin: %s", new Object[] { paramIntimateInfo.friendUin }));
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    if ((localObject != null) && (((EntityManager)localObject).isOpen()))
    {
      paramString = (IntimateInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(IntimateInfo.class, paramString);
      if (paramString != null) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(paramString);
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
  
  public void a(String paramString, IntimateInfo paramIntimateInfo)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramIntimateInfo == null) {
        return;
      }
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
      if ((localEntityManager != null) && (localEntityManager.isOpen())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramIntimateInfo);
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
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    if (!a()) {
      a();
    }
  }
  
  public boolean a()
  {
    boolean bool1 = b();
    boolean bool2 = c();
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("checkResourceReady download=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
    }
    return (bool1) && (bool2);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadIPreDownloadController != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadIPreDownloadController.cancelPreDownload(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "IntimateInfoManager onDestroy");
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friends.intimate.IntimateInfoManager
 * JD-Core Version:    0.7.0.1
 */