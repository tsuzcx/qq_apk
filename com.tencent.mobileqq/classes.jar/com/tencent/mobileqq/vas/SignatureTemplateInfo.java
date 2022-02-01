package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.persistence.unique;
import java.util.concurrent.atomic.AtomicBoolean;

public class SignatureTemplateInfo
{
  public String A;
  public int B;
  public String C;
  public SignatureTemplateInfo.ImageItem D;
  public int E;
  public AtomicBoolean a;
  @unique
  public String b;
  public String c;
  public int d;
  public int e;
  public String f;
  public int g;
  public String h;
  public int i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  public String t;
  public String u;
  public SignatureTemplateInfo.DynamicItem[] v;
  public int w;
  public String x;
  public String y;
  public String z;
  
  public SignatureTemplateInfo()
  {
    this.a = new AtomicBoolean(false);
  }
  
  public SignatureTemplateInfo(String paramString)
  {
    int i1 = 0;
    this.a = new AtomicBoolean(false);
    this.b = paramString;
    if (paramString.equals("0")) {
      a();
    }
    this.v = new SignatureTemplateInfo.DynamicItem[5];
    while (i1 < 5)
    {
      this.v[i1] = new SignatureTemplateInfo.DynamicItem(this);
      i1 += 1;
    }
  }
  
  public void a()
  {
    this.b = "0";
    this.c = HardCodeUtil.a(2131911516);
    this.d = 1;
    this.e = -1;
    this.j = "#FF03081A";
    this.u = "#FF878B99";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.SignatureTemplateInfo
 * JD-Core Version:    0.7.0.1
 */