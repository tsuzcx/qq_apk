package com.tencent.mobileqq.startup.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.support.v4.util.SparseArrayCompat;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper.CustomBackground;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper.QQFavoriteSecurityFileHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.utils.VipComicSecurityFileHelper;
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
    a(3, new VipComicSecurityFileHelper());
  }
  
  private int a()
  {
    int k = 1;
    Object localObject1 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/MobileQQ/";
    Object localObject2 = BaseApplicationImpl.getApplication().getExternalCacheDir();
    File localFile;
    int i;
    if (localObject2 != null)
    {
      localObject2 = ((File)localObject2).getParentFile().getAbsolutePath() + "/Tencent/MobileQQ/";
      localFile = new File((String)localObject1);
      localObject1 = new File((String)localObject2);
      if (!localFile.exists())
      {
        i = 3;
        return i;
      }
    }
    else
    {
      QLog.d("UpdateSecureFileStrategy", 1, "externalCacheDir is null");
      return 2;
    }
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    localObject2 = localFile.listFiles(new UpdateSecureFileStrategy.1(this));
    if (localObject2 == null) {
      return 4;
    }
    int m = localObject2.length;
    int j = 0;
    for (;;)
    {
      i = k;
      if (j >= m) {
        break;
      }
      localFile = localObject2[j];
      FileUtils.a(localFile.getAbsolutePath(), ((File)localObject1).getAbsolutePath() + File.separator + localFile.getName());
      j += 1;
    }
  }
  
  private void a(int paramInt, ISecurityFileHelper paramISecurityFileHelper)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(paramInt, paramISecurityFileHelper);
  }
  
  protected boolean doStep()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("SecurityFileFrameworkManagerImpl", 4);
    boolean bool = localSharedPreferences.getBoolean("SP_KEY_MIGRATION_TO_PRIVATE_FILES", false);
    StringBuilder localStringBuilder;
    int i;
    if (!bool)
    {
      if (BaseApplicationImpl.isHasStoragePermission(BaseApplicationImpl.getApplication()))
      {
        QLog.d("UpdateSecureFileStrategy", 1, new Object[] { "doMigration, result=", Integer.valueOf(a()) });
        localSharedPreferences.edit().putBoolean("SP_KEY_MIGRATION_TO_PRIVATE_FILES", true).apply();
      }
    }
    else
    {
      File localFile = SecurityFileFrameworkManagerImpl.getRootFile();
      if (QLog.isColorLevel()) {
        QLog.d("UpdateSecureFileStrategy", 2, new Object[] { "rootFile Path=", localFile.getAbsolutePath() });
      }
      localStringBuilder = new StringBuilder();
      i = 0;
      label122:
      if (i >= this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size()) {
        break label467;
      }
      localStringBuilder.append(((ISecurityFileHelper)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(i)).declareBusinessFileName()).append("#");
      if (!((ISecurityFileHelper)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(i)).needMigration()) {
        break label457;
      }
      String[] arrayOfString = ((ISecurityFileHelper)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(i)).reportHistoryFileInfo();
      if (QLog.isColorLevel()) {
        QLog.d("UpdateSecureFileStrategy", 2, new Object[] { "BusinessName= ", ((ISecurityFileHelper)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(i)).declareBusinessFileName(), " File Size=", arrayOfString[0], " File Amount=", arrayOfString[1] });
      }
      bool = ((ISecurityFileHelper)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(i)).doMigrate(localFile);
      localSharedPreferences.edit().putBoolean(((ISecurityFileHelper)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(i)).declareBusinessFileName(), bool).apply();
      if (QLog.isColorLevel()) {
        QLog.d("UpdateSecureFileStrategy", 2, new Object[] { "BusinessName= ", ((ISecurityFileHelper)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(i)).declareBusinessFileName(), " Success=", Boolean.valueOf(bool) });
      }
      localStringBuilder.append(true).append("#").append(arrayOfString[0]).append("#").append(arrayOfString[1]).append("#").append(bool);
    }
    for (;;)
    {
      localStringBuilder.append("|");
      i += 1;
      break label122;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("UpdateSecureFileStrategy", 2, new Object[] { "hasMigration=", Boolean.valueOf(bool), " StoragePermission=false" });
      break;
      label457:
      localStringBuilder.append(false);
    }
    label467:
    if (QLog.isColorLevel()) {
      QLog.d("UpdateSecureFileStrategy", 2, new Object[] { "SP_KEY_UPDATE_SECURE_FILE_STRATEGY_REPORT", localStringBuilder.toString() });
    }
    localSharedPreferences.edit().putString("SP_KEY_UPDATE_SECURE_FILE_STRATEGY_REPORT", localStringBuilder.toString()).apply();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.UpdateSecureFileStrategy
 * JD-Core Version:    0.7.0.1
 */