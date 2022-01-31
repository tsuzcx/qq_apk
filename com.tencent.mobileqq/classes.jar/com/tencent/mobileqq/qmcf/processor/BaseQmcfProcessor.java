package com.tencent.mobileqq.qmcf.processor;

import android.text.TextUtils;
import com.tencent.mobileqq.qmcf.QMCF;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qmcf.QmcfModelItem;
import com.tencent.mobileqq.qmcf.QmcfReporter;
import com.tencent.sveffects.SLog;
import java.util.HashMap;

public class BaseQmcfProcessor
{
  protected static QMCF a;
  protected static QmcfManager a;
  protected static volatile Object a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 0L;
  private boolean jdField_b_of_type_Boolean = false;
  protected String c = "BaseQmcfProcessor";
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_ComTencentMobileqqQmcfQMCF = new QMCF();
    jdField_a_of_type_ComTencentMobileqqQmcfQmcfManager = QmcfManager.a();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected String a(int paramInt1, int paramInt2)
  {
    return "success";
  }
  
  protected String a(QmcfModelItem paramQmcfModelItem)
  {
    return "success";
  }
  
  public String a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      String str = paramString.replaceFirst("\\d{2,4}\\s\\d{2,4}", String.format("%d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramString;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  protected boolean a(QmcfModelItem paramQmcfModelItem)
  {
    return false;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaLangString = a(paramInt1, paramInt2);
    this.jdField_b_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_JavaLangString.startsWith("suc")) {
      QmcfManager.a().b(this.jdField_b_of_type_Long);
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b()
  {
    Object localObject1;
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean) && (!jdField_a_of_type_ComTencentMobileqqQmcfQmcfManager.c))
    {
      if (!TextUtils.isEmpty(jdField_a_of_type_ComTencentMobileqqQmcfQmcfManager.b))
      {
        localObject1 = jdField_a_of_type_ComTencentMobileqqQmcfQmcfManager.a();
        if (localObject1 == null) {
          break label118;
        }
        l1 = System.currentTimeMillis();
        boolean bool = a((QmcfModelItem)localObject1);
        if (SLog.a()) {
          SLog.d(this.c, String.format("switchModel type[%s], result[%s], cost[%s]", new Object[] { jdField_a_of_type_ComTencentMobileqqQmcfQmcfManager.b, Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l1) }));
        }
      }
      for (;;)
      {
        jdField_a_of_type_ComTencentMobileqqQmcfQmcfManager.b = null;
        return;
        label118:
        SLog.c(this.c, "error occur while switchModel!");
      }
    }
    i = jdField_a_of_type_ComTencentMobileqqQmcfQmcfManager.a();
    if (SLog.a()) {
      SLog.d(this.c, String.format("initProcessor, Inited[%s], Destroyed[%s], ModeChange[%s], qmcfMode[%s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Boolean.valueOf(jdField_a_of_type_ComTencentMobileqqQmcfQmcfManager.c), Integer.valueOf(i) }));
    }
    if (QmcfManager.a().a(i, true)) {}
    for (;;)
    {
      try
      {
        l1 = System.currentTimeMillis();
        jdField_a_of_type_ComTencentMobileqqQmcfQmcfManager.c();
        jdField_a_of_type_ComTencentMobileqqQmcfQmcfManager.a(false, true, i);
        localObject1 = jdField_a_of_type_ComTencentMobileqqQmcfQmcfManager.a();
        jdField_a_of_type_ComTencentMobileqqQmcfQmcfManager.b = null;
        if (localObject1 != null)
        {
          localObject1 = a((QmcfModelItem)localObject1);
          long l2 = System.currentTimeMillis();
          l1 = l2 - l1;
        }
      }
      catch (Exception localException1)
      {
        l1 = -1L;
        localObject4 = "NotNativeError";
        SLog.a(this.c, "initProcessor excep", localException1);
        Object localObject2 = localObject4;
        continue;
      }
      catch (Error localError1)
      {
        l1 = -1L;
        Object localObject4 = "NotNativeError";
        SLog.a(this.c, "initProcessor error", localError1);
        Object localObject3 = localObject4;
        continue;
        if ("NotNativeError".equals(localObject3))
        {
          QmcfManager.a().a(true, true, i);
          localObject4 = new HashMap();
          ((HashMap)localObject4).put("svaf_result", String.valueOf(localObject3));
          ((HashMap)localObject4).put("svaf_cost", String.valueOf(l1));
          ((HashMap)localObject4).put("svaf_qmcf_mode", String.valueOf(i));
          QmcfReporter.a("svaf_init_error", (HashMap)localObject4, true);
          jdField_a_of_type_ComTencentMobileqqQmcfQmcfManager.b(0);
          continue;
        }
        QmcfManager.a().a(false);
        continue;
      }
      try
      {
        SLog.d(this.c, String.format("initProcessor, result[%s], cost[%s], width[%s], heigth[%s], mode[%s], type[%s]", new Object[] { localObject1, Long.valueOf(l1), Integer.valueOf(a()), Integer.valueOf(b()), Integer.valueOf(jdField_a_of_type_ComTencentMobileqqQmcfQmcfManager.a()), Integer.valueOf(jdField_a_of_type_ComTencentMobileqqQmcfQmcfManager.b()) }));
        if (!"success".equals(localObject1)) {
          continue;
        }
        jdField_a_of_type_ComTencentMobileqqQmcfQmcfManager.a(true, true, i);
        jdField_a_of_type_ComTencentMobileqqQmcfQmcfManager.a(true);
        if (l1 > 3000L)
        {
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("svaf_cost", String.valueOf(l1));
          ((HashMap)localObject1).put("svaf_qmcf_mode", String.valueOf(i));
          QmcfReporter.a("svaf_init_cost3s", (HashMap)localObject1, true);
        }
        this.jdField_a_of_type_Boolean = true;
        this.jdField_b_of_type_Boolean = false;
        jdField_a_of_type_ComTencentMobileqqQmcfQmcfManager.c = false;
        return;
      }
      catch (Error localError2)
      {
        continue;
      }
      catch (Exception localException2)
      {
        continue;
      }
      localObject1 = "NotNativeError";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.qmcf.processor.BaseQmcfProcessor
 * JD-Core Version:    0.7.0.1
 */