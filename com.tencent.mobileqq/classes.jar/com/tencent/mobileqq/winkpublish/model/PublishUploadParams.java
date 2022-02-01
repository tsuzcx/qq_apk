package com.tencent.mobileqq.winkpublish.model;

import NS_MOBILE_OPERATION.PicInfo;
import NS_MOBILE_PHOTO.shuoshuo_privacy;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.LbsDataV2.PoiInfo;
import cooperation.qzone.model.LabelInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PublishUploadParams
{
  public Map<String, String> A;
  public int B = 2;
  public String C;
  public ArrayList<MediaWrapper> D;
  public PicInfo E;
  public ArrayList<String> F;
  public Map<String, String> G;
  public boolean H = true;
  public String I;
  public int J;
  public int K;
  public boolean L = false;
  public ArrayList<LabelInfo> M;
  public boolean N = false;
  public String O = "";
  public ArrayList<String> P;
  public ArrayList<String> Q;
  public boolean R = true;
  public boolean S = true;
  public String T;
  public long U;
  public String V;
  public long W;
  public String X;
  public String a;
  public String b;
  public List<String> c;
  public List<LocalMediaInfo> d;
  public HashMap<String, String> e;
  public shuoshuo_privacy f;
  public ShuoshuoVideoInfo g;
  public HashMap<String, PicInfo> h;
  public LbsDataV2.PoiInfo i;
  public LbsDataV2.PoiInfo j;
  public boolean k;
  public boolean l;
  public boolean m;
  public Map<String, String> n;
  public int o;
  public long p;
  public long q;
  public int r;
  public ArrayList<String> s;
  public String t;
  public LbsDataV2.GpsInfo u;
  public String v;
  public int w;
  public Map<String, byte[]> x;
  public HashMap<String, String> y;
  public Map<String, byte[]> z;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("title: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" content: ");
    localStringBuilder.append(this.b);
    if (this.c != null)
    {
      localStringBuilder.append(" imageFiles: ");
      localStringBuilder.append(this.c);
    }
    if (this.f != null)
    {
      localStringBuilder.append(" shuoshuoPrivacy:");
      localStringBuilder.append(this.f.mood_permission);
    }
    localStringBuilder.append(" syncWeibo:");
    localStringBuilder.append(this.k);
    localStringBuilder.append(" syncQQ:");
    localStringBuilder.append(this.l);
    localStringBuilder.append(" photoQuality:");
    localStringBuilder.append(this.o);
    localStringBuilder.append("  publishTime;:");
    localStringBuilder.append(this.p);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.model.PublishUploadParams
 * JD-Core Version:    0.7.0.1
 */