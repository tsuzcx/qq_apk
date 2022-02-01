package com.tencent.mobileqq.winkpublish.model;

import FileUpload.MarkUinInfoBeforeUpload;
import NS_MOBILE_OPERATION.PicInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import cooperation.qzone.LbsDataV2.PoiInfo;
import java.util.HashMap;
import java.util.List;

public class ShuoshuoContent
{
  private String A;
  private boolean B;
  protected HashMap<String, MarkUinInfoBeforeUpload> a = new HashMap();
  protected HashMap<String, Boolean> b = new HashMap();
  protected HashMap<String, Boolean> c = new HashMap();
  private LbsDataV2.PoiInfo d;
  private HashMap<String, PicInfo> e;
  private boolean f = false;
  private String g;
  private String h;
  private LbsDataV2.PoiInfo i;
  private List<String> j;
  private HashMap<String, PicInfo> k;
  private HashMap<String, LocalMediaInfo> l;
  private ShuoshuoVideoInfo m;
  private HashMap<String, Integer> n = new HashMap();
  private int o;
  private HashMap<String, ShuoshuoVideoInfo> p;
  private HashMap<String, HashMap<String, Integer>> q = new HashMap();
  private HashMap<String, ShuoshuoVideoInfo> r;
  private HashMap<String, HashMap<String, Integer>> s = new HashMap();
  private int t = 0;
  private String u;
  private String v;
  private int w;
  private long x;
  private int y = -1;
  private int z = -1;
  
  public void a(int paramInt)
  {
    this.y = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.x = paramLong;
  }
  
  public void a(ShuoshuoVideoInfo paramShuoshuoVideoInfo)
  {
    this.m = paramShuoshuoVideoInfo;
  }
  
  public void a(String paramString)
  {
    this.A = paramString;
  }
  
  public void a(HashMap<String, LocalMediaInfo> paramHashMap)
  {
    this.l = paramHashMap;
  }
  
  public void a(List<String> paramList)
  {
    this.j = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.t |= 0x1;
      return;
    }
    this.t &= 0xFFFFFFFE;
  }
  
  public boolean a()
  {
    return this.B;
  }
  
  public int b()
  {
    return this.y;
  }
  
  public void b(int paramInt)
  {
    this.z = paramInt;
  }
  
  public void b(String paramString)
  {
    this.g = paramString;
  }
  
  public void b(HashMap<String, ShuoshuoVideoInfo> paramHashMap)
  {
    this.p = paramHashMap;
  }
  
  public int c()
  {
    return this.z;
  }
  
  public void c(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void c(String paramString)
  {
    this.h = paramString;
  }
  
  public void c(HashMap<String, ShuoshuoVideoInfo> paramHashMap)
  {
    this.r = paramHashMap;
  }
  
  public String d()
  {
    return this.A;
  }
  
  public void d(String paramString)
  {
    this.u = paramString;
  }
  
  public long e()
  {
    return this.x;
  }
  
  public void e(String paramString)
  {
    this.v = paramString;
  }
  
  public LbsDataV2.PoiInfo f()
  {
    return this.d;
  }
  
  public HashMap<String, PicInfo> g()
  {
    return this.e;
  }
  
  public String h()
  {
    return this.g;
  }
  
  public String i()
  {
    return this.h;
  }
  
  public LbsDataV2.PoiInfo j()
  {
    return this.i;
  }
  
  public List<String> k()
  {
    return this.j;
  }
  
  public HashMap<String, PicInfo> l()
  {
    return this.k;
  }
  
  public HashMap<String, LocalMediaInfo> m()
  {
    return this.l;
  }
  
  public ShuoshuoVideoInfo n()
  {
    return this.m;
  }
  
  public int o()
  {
    return this.o;
  }
  
  public int p()
  {
    return this.t;
  }
  
  public String q()
  {
    return this.u;
  }
  
  public String r()
  {
    return this.v;
  }
  
  public int s()
  {
    return this.w;
  }
  
  public HashMap<String, ShuoshuoVideoInfo> t()
  {
    return this.p;
  }
  
  public HashMap<String, ShuoshuoVideoInfo> u()
  {
    return this.r;
  }
  
  public HashMap<String, Boolean> v()
  {
    return this.c;
  }
  
  public HashMap<String, MarkUinInfoBeforeUpload> w()
  {
    return this.a;
  }
  
  public HashMap<String, Boolean> x()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.model.ShuoshuoContent
 * JD-Core Version:    0.7.0.1
 */