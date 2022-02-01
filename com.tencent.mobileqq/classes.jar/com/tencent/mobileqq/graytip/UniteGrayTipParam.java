package com.tencent.mobileqq.graytip;

import android.os.Bundle;
import com.tencent.imcore.message.InitMsgModule;
import com.tencent.mobileqq.data.GrayTipsMessageConstants.HighlightItem;
import java.util.ArrayList;

public class UniteGrayTipParam
{
  public static final int[] a = { 1, 131073, 131078, 135176, 1376257, 2097153, 2097154, 2097155, 2097156, 1245186, 1245187, 65560, 2359297, 65560, 655362, 2424833, 2490369, 2555907, 1179651, 2686977, 2621441, 2359298, 3145729, 2555906, 3145729, 3211265, 135178, 135179, 655378, 655379, 655369, 655376, 3276801, 3276802, 655377, 1179653, 3342339, 135180, 135181, 655381, 131080, 131081, 655383, 655392, 131082, 655384, 655385, 2359299, 2359300, 3276804, 131090, 131091, 655393, 131083, 655397, 131084, 131085, 131092, 131087, 131086, 131088, 2, 656395, 459802, 459803, 3, 459817, 656396, 656398, 131093, 656397, 4194305 };
  private static UniteGrayTipParam.Callback v = new UniteGrayTipParam.1();
  protected boolean b = true;
  protected boolean c = true;
  protected boolean d = true;
  public String e;
  public String f;
  public String g;
  public int h;
  public int i;
  public long j;
  public int k;
  public boolean l = true;
  public boolean m;
  public int n;
  public int[] o;
  public String p;
  public boolean q = true;
  public boolean r = false;
  public boolean s = false;
  private ArrayList<GrayTipsMessageConstants.HighlightItem> t;
  private final Object u = new Object();
  
  static {}
  
  public UniteGrayTipParam(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramString3;
    this.h = paramInt1;
    this.k = paramInt2;
    this.i = paramInt3;
    this.j = paramLong;
    d();
  }
  
  public static void a(UniteGrayTipParam.Callback paramCallback)
  {
    v = paramCallback;
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 39) || (paramInt == 40) || (paramInt == 65) || (paramInt == 11) || (paramInt == 36) || (paramInt == 67);
  }
  
  private boolean b(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 1)
    {
      bool1 = bool2;
      if (paramInt != 3)
      {
        bool1 = bool2;
        if (paramInt != 2)
        {
          bool1 = bool2;
          if (paramInt != 21)
          {
            bool1 = bool2;
            if (paramInt != 15)
            {
              bool1 = bool2;
              if (paramInt != 16)
              {
                bool1 = bool2;
                if (paramInt != 20)
                {
                  bool1 = bool2;
                  if (paramInt != 23)
                  {
                    bool1 = bool2;
                    if (paramInt != 24)
                    {
                      bool1 = bool2;
                      if (paramInt != 14)
                      {
                        bool1 = bool2;
                        if (paramInt != 13)
                        {
                          bool1 = bool2;
                          if (paramInt != 27)
                          {
                            bool1 = bool2;
                            if (paramInt != 29)
                            {
                              bool1 = bool2;
                              if (paramInt != 30)
                              {
                                bool1 = bool2;
                                if (paramInt != 32)
                                {
                                  bool1 = bool2;
                                  if (paramInt != 44)
                                  {
                                    bool1 = bool2;
                                    if (paramInt != 45)
                                    {
                                      bool1 = bool2;
                                      if (paramInt != 52)
                                      {
                                        bool1 = bool2;
                                        if (paramInt != 53)
                                        {
                                          bool1 = bool2;
                                          if (paramInt != 54)
                                          {
                                            bool1 = bool2;
                                            if (paramInt != 61)
                                            {
                                              bool1 = bool2;
                                              if (paramInt != 58)
                                              {
                                                bool1 = bool2;
                                                if (paramInt != 62)
                                                {
                                                  bool1 = bool2;
                                                  if (paramInt != 63)
                                                  {
                                                    if (paramInt == 38) {
                                                      return true;
                                                    }
                                                    bool1 = false;
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private void d()
  {
    int i1 = this.k;
    if (i1 == -5020)
    {
      this.b = false;
      return;
    }
    if (i1 == -5021)
    {
      this.d = false;
      return;
    }
    if (i1 == -5022)
    {
      this.b = false;
      this.c = false;
      return;
    }
    if (i1 == -5023)
    {
      this.b = false;
      this.d = false;
      return;
    }
    this.k = -5040;
  }
  
  public void a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(GrayTipsMessageConstants.HighlightItem paramHighlightItem)
  {
    synchronized (this.u)
    {
      if (this.t != null) {
        this.t.add(paramHighlightItem);
      }
      return;
    }
  }
  
  public void a(ArrayList<GrayTipsMessageConstants.HighlightItem> paramArrayList)
  {
    Object localObject = this.u;
    if (paramArrayList != null) {}
    try
    {
      this.t = new ArrayList();
      this.t.addAll(paramArrayList);
      break label39;
      this.t = null;
      label39:
      return;
    }
    finally {}
  }
  
  public boolean a()
  {
    boolean bool3 = v.a(this.k);
    int[] arrayOfInt = a;
    int i3 = arrayOfInt.length;
    boolean bool2 = false;
    int i1 = 0;
    int i2 = 0;
    while (i1 < i3)
    {
      if (arrayOfInt[i1] == this.i) {
        i2 = 1;
      }
      i1 += 1;
    }
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (i2 != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public ArrayList<GrayTipsMessageConstants.HighlightItem> b()
  {
    synchronized (this.u)
    {
      if (this.t == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList(this.t);
      return localArrayList;
    }
  }
  
  public void c()
  {
    synchronized (this.u)
    {
      if (this.t != null) {
        this.t.clear();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.graytip.UniteGrayTipParam
 * JD-Core Version:    0.7.0.1
 */