package com.tencent.mobileqq.graytip;

import android.os.Bundle;
import com.tencent.imcore.message.InitMsgModule;
import com.tencent.mobileqq.data.GrayTipsMessageConstants.HighlightItem;
import java.util.ArrayList;

public class UniteGrayTipParam
{
  private static UniteGrayTipParam.Callback jdField_a_of_type_ComTencentMobileqqGraytipUniteGrayTipParam$Callback = new UniteGrayTipParam.1();
  public static final int[] a;
  public int a;
  public long a;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  private ArrayList<GrayTipsMessageConstants.HighlightItem> jdField_a_of_type_JavaUtilArrayList;
  protected boolean a;
  public int b;
  public String b;
  protected boolean b;
  public int[] b;
  public int c;
  public String c;
  protected boolean c;
  public int d;
  public String d;
  public boolean d = true;
  public boolean e;
  public boolean f = true;
  public boolean g = false;
  public boolean h = false;
  
  static
  {
    InitMsgModule.a();
    jdField_a_of_type_ArrayOfInt = new int[] { 1, 131073, 131078, 135176, 1376257, 2097153, 2097154, 2097155, 2097156, 1245186, 1245187, 65560, 2359297, 65560, 655362, 2424833, 2490369, 2555907, 1179651, 2686977, 2621441, 2359298, 3145729, 2555906, 3145729, 3211265, 135178, 135179, 655378, 655379, 655369, 655376, 3276801, 3276802, 655377, 1179653, 3342339, 135180, 135181, 655381, 131080, 131081, 655383, 655392, 131082, 655384, 655385, 2359299, 2359300, 3276804, 131090, 131091, 655393, 131083, 655397, 131084, 131085, 131092, 131087, 131086, 131088, 2, 656395, 459802, 459803, 3, 459817, 656396, 656398, 656397 };
  }
  
  public UniteGrayTipParam(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt3;
    this.jdField_a_of_type_Long = paramLong;
    b();
  }
  
  public static void a(UniteGrayTipParam.Callback paramCallback)
  {
    jdField_a_of_type_ComTencentMobileqqGraytipUniteGrayTipParam$Callback = paramCallback;
  }
  
  private void b()
  {
    int i = this.jdField_c_of_type_Int;
    if (i == -5020)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    if (i == -5021)
    {
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    if (i == -5022)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    if (i == -5023)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    this.jdField_c_of_type_Int = -5040;
  }
  
  public ArrayList<GrayTipsMessageConstants.HighlightItem> a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      return localArrayList;
    }
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(GrayTipsMessageConstants.HighlightItem paramHighlightItem)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramHighlightItem);
      }
      return;
    }
  }
  
  public void a(ArrayList<GrayTipsMessageConstants.HighlightItem> paramArrayList)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if (paramArrayList != null) {}
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      break label39;
      this.jdField_a_of_type_JavaUtilArrayList = null;
      label39:
      return;
    }
    finally {}
  }
  
  public boolean a()
  {
    boolean bool3 = jdField_a_of_type_ComTencentMobileqqGraytipUniteGrayTipParam$Callback.a(this.jdField_c_of_type_Int);
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    int k = arrayOfInt.length;
    boolean bool2 = false;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      if (arrayOfInt[i] == this.jdField_b_of_type_Int) {
        j = 1;
      }
      i += 1;
    }
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (j != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.graytip.UniteGrayTipParam
 * JD-Core Version:    0.7.0.1
 */