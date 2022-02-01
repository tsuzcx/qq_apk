package com.tencent.mobileqq.persistence.fts;

import android.os.Build.VERSION;
import android.text.TextUtils;
import azop;
import bhut;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.app.QQAppInterface;
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
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  public FTSDatatbase(QQAppInterface paramQQAppInterface)
  {
    if ((Build.VERSION.SDK_INT < 18) && (!SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "sqlite_qq"))) {
      apau.jdField_a_of_type_Boolean = false;
    }
    for (int i = 0;; i = 1)
    {
      boolean bool = SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "FTSDatabase");
      if (!bool) {
        apau.jdField_a_of_type_Boolean = false;
      }
      if ((i != 0) && (bool)) {}
      for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
        this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        this.jdField_c_of_type_JavaLangString = (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir().getAbsolutePath().replace("files", "databases") + File.separator + this.jdField_b_of_type_JavaLangString + "-IndexQQMsg.db");
        return;
      }
    }
  }
  
  private synchronized native int batchTrans(ArrayList<FTSEntity> paramArrayList, String paramString, int paramInt);
  
  private synchronized native int closeFTS();
  
  private synchronized native int createCursor(String paramString);
  
  private synchronized native int createIndexTable(String paramString, int paramInt);
  
  private synchronized native int deleteIndexTable(FTSEntity paramFTSEntity);
  
  private synchronized native int initFTS(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  private synchronized native int insertIndexTable(FTSEntity paramFTSEntity);
  
  private synchronized native int isTableExist(String paramString);
  
  private synchronized native ArrayList<String> queryCustomized(String paramString);
  
  private synchronized native int queryIndexCount(String paramString);
  
  private synchronized native ArrayList<FTSEntity> queryIndexTable(String paramString1, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3);
  
  private synchronized native int readCursor(String paramString);
  
  private synchronized native int updateIndexTable(FTSEntity paramFTSEntity);
  
  public int a(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
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
  
  public int a(ArrayList<FTSEntity> paramArrayList, int paramInt)
  {
    if (!this.jdField_b_of_type_Boolean) {}
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
  
  public int a(ArrayList<FTSEntity> paramArrayList, int paramInt1, int paramInt2)
  {
    if (!this.jdField_b_of_type_Boolean) {}
    long l;
    do
    {
      return -1;
      l = System.currentTimeMillis();
      if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.fts.db", 2, "transToDatabase: entities == null");
    return -1;
    Object localObject = paramArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FTSEntity localFTSEntity = (FTSEntity)((Iterator)localObject).next();
      if (localFTSEntity.mOpt == 16) {
        localFTSEntity.mContent = localFTSEntity.createDeleteSQL();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.db", 1, "msg transToDatabase create cost:" + (System.currentTimeMillis() - l));
    }
    if (paramInt1 == 2)
    {
      localObject = "DeleteCursor";
      if (paramInt1 != 2) {
        break label215;
      }
    }
    for (;;)
    {
      paramInt1 = batchTrans(paramArrayList, (String)localObject, paramInt2);
      if ((paramInt1 == -1) && (QLog.isColorLevel())) {
        QLog.w("Q.fts.db", 2, "transToDatabase: failure");
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.fts.db", 1, "msg transToDatabase batchTrans cost:" + (System.currentTimeMillis() - l));
      }
      return paramInt1;
      localObject = "SyncCursor";
      break;
      label215:
      paramInt2 = -1;
    }
  }
  
  public ArrayList<FTSEntity> a(azop paramazop)
  {
    long l1;
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramazop.jdField_a_of_type_JavaLangString))
        {
          if (!QLog.isColorLevel()) {
            break label333;
          }
          QLog.e("Q.fts.db", 2, "query: sql is null");
          break label333;
        }
        if (TextUtils.isEmpty(paramazop.jdField_c_of_type_JavaLangString))
        {
          if (!QLog.isColorLevel()) {
            break label335;
          }
          QLog.e("Q.fts.db", 2, "query: classpath is null");
          break label335;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.fts.db", 2, "query: sql = " + paramazop.jdField_a_of_type_JavaLangString);
        }
        l1 = System.nanoTime();
        paramazop = queryIndexTable(paramazop.jdField_a_of_type_JavaLangString, paramazop.jdField_a_of_type_ArrayOfJavaLangString, paramazop.jdField_a_of_type_Boolean, paramazop.jdField_b_of_type_Boolean, paramazop.jdField_a_of_type_Int, paramazop.jdField_b_of_type_Int, paramazop.jdField_b_of_type_JavaLangString, paramazop.jdField_c_of_type_JavaLangString, paramazop.jdField_c_of_type_Int);
        l2 = System.nanoTime();
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("query: list = ");
          if (paramazop == null)
          {
            i = 0;
            QLog.i("Q.fts.db", 2, i + ", cost = " + (l2 - l1) / 1000000L + "ms");
          }
        }
        else
        {
          if ((paramazop == null) || (paramazop.isEmpty())) {
            break label331;
          }
          l1 = System.nanoTime();
          localObject = paramazop.iterator();
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          ((FTSEntity)((Iterator)localObject).next()).postRead();
          continue;
        }
        int i = paramazop.size();
      }
      catch (Exception paramazop)
      {
        paramazop.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("Q.fts.db", 2, "query: failure, ", paramazop);
        }
        return null;
      }
    }
    long l2 = System.nanoTime();
    if (QLog.isColorLevel()) {
      QLog.i("Q.fts.db", 2, "query: postRead cost = " + (l2 - l1) / 1000000L + "ms");
    }
    return paramazop;
    label331:
    return null;
    label333:
    return null;
    label335:
    return null;
  }
  
  public void a()
  {
    String str = QLog.class.getName().replace('.', '/');
    if (QLog.isColorLevel()) {}
    for (int i = 1;; i = 0)
    {
      int j = bhut.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      QLog.d("Q.fts.db", 1, Thread.currentThread().getName() + " native initFTS V1");
      if (initFTS(this.jdField_b_of_type_JavaLangString, str, i, j) == 0) {
        break;
      }
      this.jdField_b_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.db", 2, "init: failure");
      }
      return;
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean);
  }
  
  public boolean a(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {}
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
    if (!this.jdField_b_of_type_Boolean) {}
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
    if (!a()) {
      return -1;
    }
    return queryIndexCount(paramString);
  }
  
  public void b()
  {
    if ((this.jdField_c_of_type_Boolean) || (a()))
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      QLog.d("Q.fts.db", 1, Thread.currentThread().getName() + " native closeFTS V1");
      if ((closeFTS() != 0) && (QLog.isColorLevel())) {
        QLog.e("Q.fts.db", 2, "close: failure");
      }
    }
  }
  
  public boolean b(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.fts.FTSDatatbase
 * JD-Core Version:    0.7.0.1
 */