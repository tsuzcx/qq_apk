package com.tencent.mobileqq.startup.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.support.v4.util.SparseArrayCompat;
import com.tencent.comic.api.IQQComicUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper.CustomBackground;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper.QQFavoriteSecurityFileHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqreader.QQReaderSecurityFileHelper;
import java.io.File;
import mqq.app.ISecurityFileHelper;
import mqq.app.SecurityFileFrameworkManagerImpl;

public class UpdateSecureFileStrategy
  extends Step
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "ReaderZone", "QQ_Favorite", "QQComicOffline" };
  private SparseArrayCompat<ISecurityFileHelper> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  
  public UpdateSecureFileStrategy()
  {
    a(0, new QQReaderSecurityFileHelper());
    a(1, new DiySecureFileHelper.QQFavoriteSecurityFileHelper());
    a(2, new DiySecureFileHelper.CustomBackground());
    a(3, ((IQQComicUtil)QRoute.api(IQQComicUtil.class)).getComicSecurityFileHelper());
  }
  
  private int a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory().getAbsolutePath());
    ((StringBuilder)localObject1).append("/Tencent/MobileQQ/");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = BaseApplicationImpl.getApplication().getExternalCacheDir();
    if (localObject2 != null)
    {
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(((File)localObject2).getParentFile().getAbsolutePath());
      ((StringBuilder)localObject3).append("/Tencent/MobileQQ/");
      localObject2 = ((StringBuilder)localObject3).toString();
      localObject3 = new File((String)localObject1);
      localObject1 = new File((String)localObject2);
      if (!((File)localObject3).exists()) {
        return 3;
      }
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdirs();
      }
      localObject2 = ((File)localObject3).listFiles(new UpdateSecureFileStrategy.1(this));
      if (localObject2 == null) {
        return 4;
      }
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        localObject3 = localObject2[i];
        String str = ((File)localObject3).getAbsolutePath();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((File)localObject1).getAbsolutePath());
        localStringBuilder.append(File.separator);
        localStringBuilder.append(((File)localObject3).getName());
        FileUtils.quickMove(str, localStringBuilder.toString());
        i += 1;
      }
      return 1;
    }
    QLog.d("UpdateSecureFileStrategy", 1, "externalCacheDir is null");
    return 2;
  }
  
  private void a(int paramInt, ISecurityFileHelper paramISecurityFileHelper)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(paramInt, paramISecurityFileHelper);
  }
  
  protected boolean doStep()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("SecurityFileFrameworkManagerImpl", 4);
    boolean bool = localSharedPreferences.getBoolean("SP_KEY_MIGRATION_TO_PRIVATE_FILES", false);
    if (!bool)
    {
      if (BaseApplicationImpl.isHasStoragePermission(BaseApplicationImpl.getApplication())) {
        QLog.d("UpdateSecureFileStrategy", 1, new Object[] { "doMigration, result=", Integer.valueOf(a()) });
      } else if (QLog.isColorLevel()) {
        QLog.d("UpdateSecureFileStrategy", 2, new Object[] { "hasMigration=", Boolean.valueOf(bool), " StoragePermission=false" });
      }
      localSharedPreferences.edit().putBoolean("SP_KEY_MIGRATION_TO_PRIVATE_FILES", true).apply();
    }
    File localFile = SecurityFileFrameworkManagerImpl.getRootFile();
    if (QLog.isColorLevel()) {
      QLog.d("UpdateSecureFileStrategy", 2, new Object[] { "rootFile Path=", localFile.getAbsolutePath() });
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      localStringBuilder.append(((ISecurityFileHelper)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(i)).declareBusinessFileName());
      localStringBuilder.append("#");
      if (((ISecurityFileHelper)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(i)).needMigration())
      {
        String[] arrayOfString = ((ISecurityFileHelper)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(i)).reportHistoryFileInfo();
        if (QLog.isColorLevel()) {
          QLog.d("UpdateSecureFileStrategy", 2, new Object[] { "BusinessName= ", ((ISecurityFileHelper)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(i)).declareBusinessFileName(), " File Size=", arrayOfString[0], " File Amount=", arrayOfString[1] });
        }
        bool = ((ISecurityFileHelper)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(i)).doMigrate(localFile);
        localSharedPreferences.edit().putBoolean(((ISecurityFileHelper)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(i)).declareBusinessFileName(), bool).apply();
        if (QLog.isColorLevel()) {
          QLog.d("UpdateSecureFileStrategy", 2, new Object[] { "BusinessName= ", ((ISecurityFileHelper)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(i)).declareBusinessFileName(), " Success=", Boolean.valueOf(bool) });
        }
        localStringBuilder.append(true);
        localStringBuilder.append("#");
        localStringBuilder.append(arrayOfString[0]);
        localStringBuilder.append("#");
        localStringBuilder.append(arrayOfString[1]);
        localStringBuilder.append("#");
        localStringBuilder.append(bool);
      }
      else
      {
        localStringBuilder.append(false);
      }
      localStringBuilder.append("|");
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpdateSecureFileStrategy", 2, new Object[] { "SP_KEY_UPDATE_SECURE_FILE_STRATEGY_REPORT", localStringBuilder.toString() });
    }
    localSharedPreferences.edit().putString("SP_KEY_UPDATE_SECURE_FILE_STRATEGY_REPORT", localStringBuilder.toString()).apply();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.UpdateSecureFileStrategy
 * JD-Core Version:    0.7.0.1
 */