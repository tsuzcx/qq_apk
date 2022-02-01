package com.tencent.mobileqq.filemanageraux.util;

import java.util.ArrayList;
import java.util.HashMap;

public class PrivacyInfoUtil
{
  private final String a = "DESede/ECB/PKCS5Padding";
  private final String b = "random";
  private final ArrayList<byte[]> c = new ArrayList(10);
  private final byte d = 0;
  private final byte[] e = "gavinhuangdaydayup_happy".getBytes();
  private final byte[] f = "doscarlettmarryrenzzhang".getBytes();
  private final byte[] g = "wangpeilin_georgewangson".getBytes();
  private final byte[] h = "georgebirthdayis19790526".getBytes();
  private final byte[] i = "qlinkwillthebestfunction".getBytes();
  private final byte[] j = "qqwillbebetterthanwechat".getBytes();
  private final byte[] k = "whowillbethenextbigtiger".getBytes();
  private final byte[] l = "whenwillwefindmahang_370".getBytes();
  private final byte[] m = "whenwillchinagetworldcap".getBytes();
  private final byte n = 0;
  private final byte o = 1;
  private final byte p = 0;
  private final int q = 20;
  private HashMap<Long, String> r = new HashMap();
  private byte[] s = null;
  
  public PrivacyInfoUtil()
  {
    this.c.add(this.e);
    this.c.add(this.f);
    this.c.add(this.g);
    this.c.add(this.h);
    this.c.add(this.i);
    this.c.add(this.j);
    this.c.add(this.k);
    this.c.add(this.l);
    this.c.add(this.m);
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      paramString = paramString.getBytes();
    } else {
      paramString = null;
    }
    this.s = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.util.PrivacyInfoUtil
 * JD-Core Version:    0.7.0.1
 */