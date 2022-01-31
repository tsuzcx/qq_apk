package com.tencent.mobileqq.startup.step;

import akhl;
import akhm;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.util.SparseArrayCompat;
import bfbb;
import bfld;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
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
    a(0, new bfld());
    a(1, new akhm());
    a(2, new akhl());
    a(3, new bfbb());
  }
  
  private void a(int paramInt, ISecurityFileHelper paramISecurityFileHelper)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(paramInt, paramISecurityFileHelper);
  }
  
  protected boolean doStep()
  {
    File localFile = SecurityFileFrameworkManagerImpl.getRootFile();
    if (QLog.isColorLevel()) {
      QLog.d("UpdateSecureFileStrategy", 2, new Object[] { "rootFile Path=", localFile.getAbsolutePath() });
    }
    StringBuilder localStringBuilder = new StringBuilder();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("SecurityFileFrameworkManagerImpl", 4);
    int i = 0;
    if (i < this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size())
    {
      localStringBuilder.append(((ISecurityFileHelper)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(i)).declareBusinessFileName()).append("#");
      if (((ISecurityFileHelper)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(i)).needMigration())
      {
        String[] arrayOfString = ((ISecurityFileHelper)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(i)).reportHistoryFileInfo();
        if (QLog.isColorLevel()) {
          QLog.d("UpdateSecureFileStrategy", 2, new Object[] { "BusinessName= ", ((ISecurityFileHelper)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(i)).declareBusinessFileName(), " File Size=", arrayOfString[0], " File Amount=", arrayOfString[1] });
        }
        boolean bool = ((ISecurityFileHelper)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(i)).doMigrate(localFile);
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
        break;
        localStringBuilder.append(false);
      }
    }
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