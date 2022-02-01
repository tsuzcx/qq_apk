package com.tencent.mobileqq.flashshow.viewmodel.barrage;

import android.content.Context;
import android.view.TextureView;
import com.tencent.mobileqq.flashshow.api.bean.FSReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

public abstract interface IFSBarrageViewModel<T>
{
  public abstract void a();
  
  public abstract void a(Context paramContext, TextureView paramTextureView);
  
  public abstract void a(FSReportBean paramFSReportBean);
  
  public abstract void a(IFSBarrageViewModel.OnBarrageClickPopupListener paramOnBarrageClickPopupListener);
  
  public abstract void a(IFSBarrageViewModel.OnBarrageLoadMoreListener paramOnBarrageLoadMoreListener);
  
  public abstract void a(IFSBarrageViewModel.OnMeasureBarrageListener paramOnMeasureBarrageListener);
  
  public abstract void a(FeedCloudMeta.StFeed paramStFeed);
  
  public abstract void a(List<T> paramList, int paramInt, long paramLong);
  
  public abstract void a(List<T> paramList, int paramInt1, long paramLong, int paramInt2);
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract FSReportBean e();
  
  public abstract int f();
  
  public abstract void g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.barrage.IFSBarrageViewModel
 * JD-Core Version:    0.7.0.1
 */