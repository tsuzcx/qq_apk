package com.tencent.mobileqq.kandian.biz.accesslayer.data;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.mobileqq.kandian.biz.ad.entity.IExposureSupplementManager;
import com.tencent.mobileqq.kandian.biz.dislike.RIJDislikeManager;
import com.tencent.mobileqq.kandian.biz.framework.PrefetchListener;
import com.tencent.mobileqq.kandian.biz.framework.RIJPreloadImage;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.util.DynamicItemViewHelper;
import com.tencent.mobileqq.kandian.biz.share.VideoShareHelper;
import com.tencent.mobileqq.kandian.biz.video.PlayableItem;
import com.tencent.mobileqq.kandian.biz.video.VideoAutoPlayController;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr;
import com.tencent.mobileqq.kandian.glue.video.VideoRecommendManager;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public final class RIJDataManager$Builder
{
  boolean A = false;
  Context a;
  int b;
  VideoRecommendManager c;
  VideoPlayManager d;
  long e;
  ReadInJoyBaseAdapter f;
  VideoAutoPlayController g;
  VideoPreDownloadMgr h;
  PlayableItem i;
  boolean j = false;
  boolean k = false;
  int l;
  boolean m = false;
  boolean n = false;
  Set<Long> o = null;
  Map<Long, BaseReportData> p = null;
  ArrayList<BaseReportData> q = new ArrayList();
  DynamicItemViewHelper r;
  boolean s = false;
  RIJPreloadImage t;
  VafContext u;
  boolean v = false;
  RIJDislikeManager w;
  VideoShareHelper x;
  PrefetchListener y;
  IExposureSupplementManager z;
  
  public Context A()
  {
    return this.a;
  }
  
  public int B()
  {
    return this.b;
  }
  
  public Builder a(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public Builder a(long paramLong)
  {
    this.e = paramLong;
    return this;
  }
  
  public Builder a(Context paramContext)
  {
    this.a = paramContext;
    return this;
  }
  
  public Builder a(VafContext paramVafContext)
  {
    this.u = paramVafContext;
    return this;
  }
  
  public Builder a(IExposureSupplementManager paramIExposureSupplementManager)
  {
    this.z = paramIExposureSupplementManager;
    return this;
  }
  
  public Builder a(RIJDislikeManager paramRIJDislikeManager)
  {
    this.w = paramRIJDislikeManager;
    return this;
  }
  
  public Builder a(PrefetchListener paramPrefetchListener)
  {
    this.y = paramPrefetchListener;
    return this;
  }
  
  public Builder a(RIJPreloadImage paramRIJPreloadImage)
  {
    this.t = paramRIJPreloadImage;
    return this;
  }
  
  public Builder a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.f = paramReadInJoyBaseAdapter;
    return this;
  }
  
  public Builder a(DynamicItemViewHelper paramDynamicItemViewHelper)
  {
    this.r = paramDynamicItemViewHelper;
    return this;
  }
  
  public Builder a(VideoShareHelper paramVideoShareHelper)
  {
    this.x = paramVideoShareHelper;
    return this;
  }
  
  public Builder a(PlayableItem paramPlayableItem)
  {
    this.i = paramPlayableItem;
    return this;
  }
  
  public Builder a(VideoAutoPlayController paramVideoAutoPlayController)
  {
    this.g = paramVideoAutoPlayController;
    return this;
  }
  
  public Builder a(VideoPlayManager paramVideoPlayManager)
  {
    this.d = paramVideoPlayManager;
    return this;
  }
  
  public Builder a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.h = paramVideoPreDownloadMgr;
    return this;
  }
  
  public Builder a(VideoRecommendManager paramVideoRecommendManager)
  {
    this.c = paramVideoRecommendManager;
    return this;
  }
  
  public Builder a(Set<Long> paramSet, Map<Long, BaseReportData> paramMap)
  {
    this.o = paramSet;
    this.p = paramMap;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.j = paramBoolean;
    return this;
  }
  
  public boolean a()
  {
    return this.A;
  }
  
  public Builder b(boolean paramBoolean)
  {
    this.k = paramBoolean;
    return this;
  }
  
  public IExposureSupplementManager b()
  {
    return this.z;
  }
  
  public Builder c(boolean paramBoolean)
  {
    this.m = paramBoolean;
    return this;
  }
  
  public PrefetchListener c()
  {
    return this.y;
  }
  
  public Builder d(boolean paramBoolean)
  {
    this.n = paramBoolean;
    return this;
  }
  
  public VideoShareHelper d()
  {
    return this.x;
  }
  
  public Builder e(boolean paramBoolean)
  {
    this.s = paramBoolean;
    return this;
  }
  
  public RIJDislikeManager e()
  {
    return this.w;
  }
  
  public Builder f(boolean paramBoolean)
  {
    this.v = paramBoolean;
    return this;
  }
  
  public boolean f()
  {
    return this.v;
  }
  
  public VafContext g()
  {
    return this.u;
  }
  
  public Builder g(boolean paramBoolean)
  {
    this.A = paramBoolean;
    return this;
  }
  
  public RIJPreloadImage h()
  {
    return this.t;
  }
  
  public boolean i()
  {
    return this.s;
  }
  
  public DynamicItemViewHelper j()
  {
    return this.r;
  }
  
  public Set<Long> k()
  {
    return this.o;
  }
  
  public Map<Long, BaseReportData> l()
  {
    return this.p;
  }
  
  public ArrayList<BaseReportData> m()
  {
    return this.q;
  }
  
  public boolean n()
  {
    return this.n;
  }
  
  public DynamicItemViewHelper o()
  {
    return this.r;
  }
  
  public boolean p()
  {
    return this.m;
  }
  
  public PlayableItem q()
  {
    return this.i;
  }
  
  public int r()
  {
    return this.l;
  }
  
  public boolean s()
  {
    return this.k;
  }
  
  public boolean t()
  {
    return this.j;
  }
  
  public VideoPreDownloadMgr u()
  {
    return this.h;
  }
  
  public ReadInJoyBaseAdapter v()
  {
    return this.f;
  }
  
  public VideoAutoPlayController w()
  {
    return this.g;
  }
  
  public long x()
  {
    return this.e;
  }
  
  public VideoRecommendManager y()
  {
    return this.c;
  }
  
  public VideoPlayManager z()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder
 * JD-Core Version:    0.7.0.1
 */