package com.tencent.mobileqq.persistence.fts;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class FTSDatatbase
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String c;
  
  public FTSDatatbase(QQAppInterface paramQQAppInterface)
  {
    if ((Build.VERSION.SDK_INT < 18) && (!SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "sqlite_qq"))) {
      com.tencent.mobileqq.app.proxy.FTSDBManager.jdField_a_of_type_Boolean = false;
    }
    if (!SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "FTSDatabase")) {
      com.tencent.mobileqq.app.proxy.FTSDBManager.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir().getAbsolutePath().replace("files", "databases") + File.separator + this.jdField_b_of_type_JavaLangString + "-IndexQQMsg.db");
  }
  
  private synchronized native int batchTrans(ArrayList paramArrayList, String paramString, int paramInt);
  
  private synchronized native int closeFTS();
  
  private synchronized native int createCursor(String paramString);
  
  private synchronized native int createIndexTable(String paramString, int paramInt);
  
  private synchronized native int deleteIndexTable(FTSEntity paramFTSEntity);
  
  private synchronized native int initFTS(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  private synchronized native int insertIndexTable(FTSEntity paramFTSEntity);
  
  private synchronized native int isTableExist(String paramString);
  
  private synchronized native int queryIndexCount(String paramString);
  
  private synchronized native ArrayList queryIndexTable(String paramString1, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3);
  
  private synchronized native int readCursor(String paramString);
  
  private synchronized native int updateIndexTable(FTSEntity paramFTSEntity);
  
  public int a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return -1;
    }
    try
    {
      int i = readCursor(paramString);
      return i;
    }
    catch (Throwable paramString)
    {
      QLog.e("Q.fts.db", 2, paramString, new Object[0]);
    }
    return -1;
  }
  
  public int a(ArrayList paramArrayList)
  {
    int i;
    if (!this.jdField_a_of_type_Boolean) {
      i = -1;
    }
    int j;
    do
    {
      do
      {
        return i;
        if ((paramArrayList == null) || (paramArrayList.isEmpty()))
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.fts.db", 2, "transToDatabase: entities == null");
          }
          return -1;
        }
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext())
        {
          FTSEntity localFTSEntity = (FTSEntity)localIterator.next();
          if (localFTSEntity.mOpt == 16) {
            localFTSEntity.mContent = localFTSEntity.createDeleteSQL();
          }
        }
        j = batchTrans(paramArrayList, "SyncCursor", -1);
        i = j;
      } while (j != -1);
      i = j;
    } while (!QLog.isColorLevel());
    QLog.w("Q.fts.db", 2, "transToDatabase: failure");
    return j;
  }
  
  public int a(ArrayList paramArrayList, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return -1;
        if (paramArrayList != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("Q.fts.db", 2, "insertAddWithTransToDatabase: entities == null");
      return -1;
      if (batchTrans(paramArrayList, "UpgradeCursor", paramInt) > 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.fts.db", 2, "insertAddWithTransToDatabase: failure");
    return -1;
    return 0;
  }
  
  public ArrayList a(FTSQueryArgs paramFTSQueryArgs)
  {
    long l1;
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramFTSQueryArgs.jdField_a_of_type_JavaLangString))
        {
          if (!QLog.isColorLevel()) {
            break label329;
          }
          QLog.e("Q.fts.db", 2, "query: sql is null");
          break label329;
        }
        if (TextUtils.isEmpty(paramFTSQueryArgs.jdField_c_of_type_JavaLangString))
        {
          if (!QLog.isColorLevel()) {
            break label331;
          }
          QLog.e("Q.fts.db", 2, "query: classpath is null");
          break label331;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.fts.db", 2, "query: sql = " + paramFTSQueryArgs.jdField_a_of_type_JavaLangString);
        }
        l1 = System.nanoTime();
        paramFTSQueryArgs = queryIndexTable(paramFTSQueryArgs.jdField_a_of_type_JavaLangString, paramFTSQueryArgs.jdField_a_of_type_ArrayOfJavaLangString, paramFTSQueryArgs.jdField_a_of_type_Boolean, paramFTSQueryArgs.jdField_b_of_type_Boolean, paramFTSQueryArgs.jdField_a_of_type_Int, paramFTSQueryArgs.jdField_b_of_type_Int, paramFTSQueryArgs.jdField_b_of_type_JavaLangString, paramFTSQueryArgs.jdField_c_of_type_JavaLangString, paramFTSQueryArgs.jdField_c_of_type_Int);
        l2 = System.nanoTime();
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("query: list = ");
          if (paramFTSQueryArgs == null)
          {
            i = 0;
            QLog.i("Q.fts.db", 2, i + ", cost = " + (l2 - l1) / 1000000L + "ms");
          }
        }
        else
        {
          if ((paramFTSQueryArgs == null) || (paramFTSQueryArgs.isEmpty())) {
            break label327;
          }
          l1 = System.nanoTime();
          localObject = paramFTSQueryArgs.iterator();
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          ((FTSEntity)((Iterator)localObject).next()).postRead();
          continue;
        }
        int i = paramFTSQueryArgs.size();
      }
      catch (Exception paramFTSQueryArgs)
      {
        paramFTSQueryArgs.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("Q.fts.db", 2, "query: failure, ", paramFTSQueryArgs);
        }
        return null;
      }
    }
    long l2 = System.nanoTime();
    if (QLog.isColorLevel()) {
      QLog.i("Q.fts.db", 2, "query: postRead cost = " + (l2 - l1) / 1000000L + "ms");
    }
    return paramFTSQueryArgs;
    label327:
    return null;
    label329:
    return null;
    label331:
    return null;
  }
  
  public void a()
  {
    String str = QLog.class.getName().replace('.', '/');
    if (QLog.isColorLevel()) {}
    for (int i = 1;; i = 0)
    {
      int j = SQLiteFTSUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      QLog.d("Q.fts.db", 1, Thread.currentThread().getName() + " native initFTS V1");
      if (initFTS(this.jdField_b_of_type_JavaLangString, str, i, j) == 0) {
        break;
      }
      this.jdField_a_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.db", 2, "init: failure");
      }
      return;
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return false;
      if (createCursor(paramString) == 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.fts.db", 2, "creatAssistTable: failure");
    return false;
    return true;
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return false;
      int i;
      if (paramBoolean) {
        i = 1;
      }
      try
      {
        for (;;)
        {
          i = createIndexTable(paramString, i);
          if (i == 0) {
            break label65;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("Q.fts.db", 2, "createIndexTable: failure");
          return false;
          i = 0;
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          QLog.e("Q.fts.db", 2, paramString, new Object[0]);
          i = -1;
        }
      }
    }
    label65:
    return true;
  }
  
  public int b(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return -1;
    }
    return queryIndexCount(paramString);
  }
  
  public void b()
  {
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Boolean = false;
      QLog.d("Q.fts.db", 1, Thread.currentThread().getName() + " native closeFTS V1");
      if ((closeFTS() != 0) && (QLog.isColorLevel())) {
        QLog.e("Q.fts.db", 2, "close: failure");
      }
    }
  }
  
  public boolean b(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while (isTableExist(paramString) != 0) {
      return false;
    }
    return true;
  }
  
  public void c()
  {
    b();
    File localFile = new File(this.jdField_c_of_type_JavaLangString);
    if ((localFile.exists()) && (localFile.isFile())) {
      localFile.delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.fts.FTSDatatbase
 * JD-Core Version:    0.7.0.1
 */