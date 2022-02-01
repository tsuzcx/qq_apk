package com.tencent.mobileqq.persistence.fts;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.fts.v1.FTSQueryArgs;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class FTSDatatbase
{
  private String jdField_a_of_type_JavaLangString;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  public FTSDatatbase(AppRuntime paramAppRuntime)
  {
    int i;
    if ((Build.VERSION.SDK_INT < 18) && (!SoLoadUtilNew.loadSoByName(MobileQQ.getContext(), "sqlite_qq")))
    {
      com.tencent.mobileqq.fts.api.impl.FTSDBRuntimeServiceImpl.ENABLE = false;
      i = 0;
    }
    else
    {
      i = 1;
    }
    boolean bool = SoLoadUtilNew.loadSoByName(MobileQQ.getContext(), "FTSDatabase");
    if (!bool) {
      com.tencent.mobileqq.fts.api.impl.FTSDBRuntimeServiceImpl.ENABLE = false;
    }
    if ((i != 0) && (bool)) {
      this.jdField_a_of_type_Boolean = true;
    } else {
      this.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_JavaLangString = paramAppRuntime.getCurrentAccountUin();
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append(this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getFilesDir().getAbsolutePath().replace("files", "databases"));
    paramAppRuntime.append(File.separator);
    paramAppRuntime.append(this.jdField_b_of_type_JavaLangString);
    paramAppRuntime.append("-IndexQQMsg.db");
    this.jdField_c_of_type_JavaLangString = paramAppRuntime.toString();
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
    if (!this.jdField_b_of_type_Boolean) {
      return -1;
    }
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.fts.db", 2, "insertAddWithTransToDatabase: entities == null");
      }
      return -1;
    }
    if (batchTrans(paramArrayList, "UpgradeCursor", paramInt) <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.db", 2, "insertAddWithTransToDatabase: failure");
      }
      return -1;
    }
    return 0;
  }
  
  public int a(ArrayList<FTSEntity> paramArrayList, int paramInt1, int paramInt2)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return -1;
    }
    long l = System.currentTimeMillis();
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      Object localObject = paramArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        FTSEntity localFTSEntity = (FTSEntity)((Iterator)localObject).next();
        if (localFTSEntity.mOpt == 16) {
          localFTSEntity.mContent = localFTSEntity.createDeleteSQL();
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("msg transToDatabase create cost:");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
        QLog.d("Q.fts.db", 1, ((StringBuilder)localObject).toString());
      }
      if (paramInt1 == 2) {
        localObject = "DeleteCursor";
      } else {
        localObject = "SyncCursor";
      }
      if (paramInt1 != 2) {
        paramInt2 = -1;
      }
      paramInt1 = batchTrans(paramArrayList, (String)localObject, paramInt2);
      if ((paramInt1 == -1) && (QLog.isColorLevel())) {
        QLog.w("Q.fts.db", 2, "transToDatabase: failure");
      }
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("msg transToDatabase batchTrans cost:");
        paramArrayList.append(System.currentTimeMillis() - l);
        QLog.d("Q.fts.db", 1, paramArrayList.toString());
      }
      return paramInt1;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.fts.db", 2, "transToDatabase: entities == null");
    }
    return -1;
  }
  
  public ArrayList<FTSEntity> a(FTSQueryArgs paramFTSQueryArgs)
  {
    try
    {
      if (TextUtils.isEmpty(paramFTSQueryArgs.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel())
        {
          QLog.e("Q.fts.db", 2, "query: sql is null");
          return null;
        }
      }
      else
      {
        if (TextUtils.isEmpty(paramFTSQueryArgs.jdField_c_of_type_JavaLangString))
        {
          if (!QLog.isColorLevel()) {
            break label376;
          }
          QLog.e("Q.fts.db", 2, "query: classpath is null");
          return null;
        }
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("query: sql = ");
          ((StringBuilder)localObject).append(paramFTSQueryArgs.jdField_a_of_type_JavaLangString);
          QLog.i("Q.fts.db", 2, ((StringBuilder)localObject).toString());
        }
        long l1 = System.nanoTime();
        paramFTSQueryArgs = queryIndexTable(paramFTSQueryArgs.jdField_a_of_type_JavaLangString, paramFTSQueryArgs.jdField_a_of_type_ArrayOfJavaLangString, paramFTSQueryArgs.jdField_a_of_type_Boolean, paramFTSQueryArgs.jdField_b_of_type_Boolean, paramFTSQueryArgs.jdField_a_of_type_Int, paramFTSQueryArgs.jdField_b_of_type_Int, paramFTSQueryArgs.jdField_b_of_type_JavaLangString, paramFTSQueryArgs.jdField_c_of_type_JavaLangString, paramFTSQueryArgs.jdField_c_of_type_Int);
        long l2 = System.nanoTime();
        boolean bool = QLog.isColorLevel();
        if (bool)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("query: list = ");
          int i;
          if (paramFTSQueryArgs == null) {
            i = 0;
          } else {
            i = paramFTSQueryArgs.size();
          }
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", cost = ");
          ((StringBuilder)localObject).append((l2 - l1) / 1000000L);
          ((StringBuilder)localObject).append("ms");
          QLog.i("Q.fts.db", 2, ((StringBuilder)localObject).toString());
        }
        if ((paramFTSQueryArgs != null) && (!paramFTSQueryArgs.isEmpty()))
        {
          l1 = System.nanoTime();
          localObject = paramFTSQueryArgs.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((FTSEntity)((Iterator)localObject).next()).postRead();
          }
          l2 = System.nanoTime();
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("query: postRead cost = ");
            ((StringBuilder)localObject).append((l2 - l1) / 1000000L);
            ((StringBuilder)localObject).append("ms");
            QLog.i("Q.fts.db", 2, ((StringBuilder)localObject).toString());
          }
          return paramFTSQueryArgs;
        }
        return null;
      }
    }
    catch (Exception paramFTSQueryArgs)
    {
      paramFTSQueryArgs.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.db", 2, "query: failure, ", paramFTSQueryArgs);
      }
      return null;
    }
    return null;
    label376:
    return null;
  }
  
  public void a()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean);
  }
  
  public boolean a(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return false;
    }
    if (createCursor(paramString) != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.db", 2, "creatAssistTable: failure");
      }
      return false;
    }
    return true;
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Thread.currentThread().getName());
      localStringBuilder.append(" native closeFTS V1");
      QLog.d("Q.fts.db", 1, localStringBuilder.toString());
      if ((closeFTS() != 0) && (QLog.isColorLevel())) {
        QLog.e("Q.fts.db", 2, "close: failure");
      }
    }
  }
  
  public boolean b(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return false;
    }
    return isTableExist(paramString) == 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.fts.FTSDatatbase
 * JD-Core Version:    0.7.0.1
 */