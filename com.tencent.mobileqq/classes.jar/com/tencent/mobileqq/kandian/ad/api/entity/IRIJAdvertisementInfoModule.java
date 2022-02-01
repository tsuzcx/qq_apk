package com.tencent.mobileqq.kandian.ad.api.entity;

import android.content.Context;
import android.util.Pair;
import com.tencent.biz.pubaccount.NativeAd.data.AdRequestData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.biz.feeds.api.FixPosArticleInterface;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0xf30.oidb_cmd0xf30.InsertArticle;

public abstract interface IRIJAdvertisementInfoModule
  extends FixPosArticleInterface
{
  public abstract Pair<Integer, Integer> a(int paramInt);
  
  public abstract Pair<Integer, Integer> a(int paramInt1, int paramInt2);
  
  public abstract AdvertisementInfo a(int paramInt1, int paramInt2);
  
  public abstract Object a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, AdRequestData paramAdRequestData);
  
  public abstract List<AbsBaseArticleInfo> a(oidb_cmd0xf30.InsertArticle paramInsertArticle);
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, AdRequestData paramAdRequestData);
  
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public abstract void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, long paramLong, ArrayList<DislikeInfo> paramArrayList, boolean paramBoolean);
  
  public abstract void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject);
  
  public abstract void a(ToServiceMsg paramToServiceMsg, Object paramObject1, int paramInt1, int paramInt2, boolean paramBoolean, Object paramObject2);
  
  public abstract boolean a(int paramInt);
  
  public abstract AdvertisementInfo b(int paramInt1, int paramInt2);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.entity.IRIJAdvertisementInfoModule
 * JD-Core Version:    0.7.0.1
 */