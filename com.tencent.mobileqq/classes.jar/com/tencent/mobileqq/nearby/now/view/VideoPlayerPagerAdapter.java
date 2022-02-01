package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.common.app.AppInterface;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.nearby.now.IResourceUtil;
import com.tencent.mobileqq.nearby.now.IStoryPlayController;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.logic.IVideoInfoListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class VideoPlayerPagerAdapter
  extends PagerAdapter
  implements View.OnClickListener, IVideoPlayerView.ShowLoadingWhenLoadingCoverListener
{
  protected LayoutInflater a;
  public SparseArray<VideoPlayerPagerAdapter.VideoViewHolder> b = new SparseArray();
  public SparseArray<View> c = new SparseArray();
  public List<VideoData> d = new ArrayList();
  public IStoryPlayController e;
  public AppInterface f;
  public boolean g = false;
  public int h = 0;
  private boolean i = true;
  private StuffContainerView.OnCloseListener j = null;
  private boolean k;
  
  public VideoPlayerPagerAdapter(Context paramContext, boolean paramBoolean)
  {
    this.g = paramBoolean;
    this.a = LayoutInflater.from(paramContext);
  }
  
  private void a(ImageView paramImageView)
  {
    if ((paramImageView != null) && (paramImageView.getDrawable() != null) && ((paramImageView.getDrawable() instanceof URLDrawable)) && (((URLDrawable)paramImageView.getDrawable()).getCurrDrawable() != null) && ((((URLDrawable)paramImageView.getDrawable()).getCurrDrawable() instanceof RegionDrawable)) && (((RegionDrawable)((URLDrawable)paramImageView.getDrawable()).getCurrDrawable()).getBitmap() != null))
    {
      ((RegionDrawable)((URLDrawable)paramImageView.getDrawable()).getCurrDrawable()).getBitmap().recycle();
      if (((URLDrawable)paramImageView.getDrawable()).getURL() != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((URLDrawable)paramImageView.getDrawable()).getURL().toString());
        localStringBuilder.append("#now");
        URLDrawable.removeMemoryCacheByUrl(localStringBuilder.toString());
      }
      paramImageView.setImageBitmap(null);
      paramImageView.setImageDrawable(null);
    }
  }
  
  public VideoPlayerPagerAdapter.VideoViewHolder a(int paramInt)
  {
    return (VideoPlayerPagerAdapter.VideoViewHolder)this.b.get(paramInt);
  }
  
  public void a()
  {
    int m = 0;
    while (m < this.b.size())
    {
      Object localObject = this.b;
      localObject = (VideoPlayerPagerAdapter.VideoViewHolder)((SparseArray)localObject).get(((SparseArray)localObject).keyAt(m));
      if ((localObject != null) && (((VideoPlayerPagerAdapter.VideoViewHolder)localObject).d != null)) {
        ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).d.c();
      }
      m += 1;
    }
  }
  
  public void a(int paramInt, List<VideoData> paramList)
  {
    if (paramInt == 0)
    {
      int m = paramList.size();
      Object localObject1 = this.e;
      ((IStoryPlayController)localObject1).setCurrentIndex(((IStoryPlayController)localObject1).getCurrentIndex() + m);
      b(m);
      localObject1 = new ArrayList();
      paramInt = 0;
      while (paramInt < this.b.size())
      {
        ((List)localObject1).add(Integer.valueOf(this.b.keyAt(paramInt)));
        paramInt += 1;
      }
      localObject1 = ((List)localObject1).toArray();
      Arrays.sort((Object[])localObject1);
      paramInt = localObject1.length - 1;
      int n;
      Object localObject2;
      while (paramInt >= 0)
      {
        n = ((Integer)localObject1[paramInt]).intValue();
        localObject2 = (VideoPlayerPagerAdapter.VideoViewHolder)this.b.get(n);
        ((VideoPlayerPagerAdapter.VideoViewHolder)localObject2).a += m;
        localObject2 = this.b;
        ((SparseArray)localObject2).put(((VideoPlayerPagerAdapter.VideoViewHolder)((SparseArray)localObject2).get(n)).a, this.b.get(n));
        this.b.delete(n);
        paramInt -= 1;
      }
      localObject1 = new ArrayList();
      paramInt = 0;
      while (paramInt < this.c.size())
      {
        ((List)localObject1).add(Integer.valueOf(this.c.keyAt(paramInt)));
        paramInt += 1;
      }
      localObject1 = ((List)localObject1).toArray();
      Arrays.sort((Object[])localObject1);
      paramInt = localObject1.length - 1;
      while (paramInt >= 0)
      {
        n = ((Integer)localObject1[paramInt]).intValue();
        localObject2 = (View)this.c.get(n);
        this.c.put(n + m, localObject2);
        this.c.remove(n);
        paramInt -= 1;
      }
      this.h += m;
      this.d.addAll(0, paramList);
      return;
    }
    if (paramInt == 1) {
      this.d.addAll(paramList);
    }
  }
  
  public void a(IStoryPlayController paramIStoryPlayController, Bundle paramBundle)
  {
    this.e = paramIStoryPlayController;
    this.i = false;
  }
  
  public void a(StuffContainerView.OnCloseListener paramOnCloseListener)
  {
    this.j = paramOnCloseListener;
  }
  
  public void b(int paramInt)
  {
    HashMap localHashMap = this.e.getItemListeners();
    Object localObject = new ArrayList();
    Iterator localIterator = localHashMap.keySet().iterator();
    while (localIterator.hasNext()) {
      ((List)localObject).add(Integer.valueOf(((Integer)localIterator.next()).intValue()));
    }
    localObject = ((List)localObject).toArray();
    Arrays.sort((Object[])localObject);
    int m = localObject.length - 1;
    while (m >= 0)
    {
      int n = ((Integer)localObject[m]).intValue();
      localHashMap.put(Integer.valueOf(n + paramInt), (IVideoInfoListener)localHashMap.get(Integer.valueOf(n)));
      localHashMap.remove(Integer.valueOf(n));
      m -= 1;
    }
  }
  
  public VideoData c(int paramInt)
  {
    List localList = this.d;
    if ((localList != null) && (paramInt >= 0) && (paramInt < localList.size())) {
      return (VideoData)this.d.get(paramInt);
    }
    return null;
  }
  
  public View d(int paramInt)
  {
    return (View)this.c.get(paramInt);
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    View localView = (View)paramObject;
    if ((VideoPlayerPagerAdapter.VideoViewHolder)localView.getTag() == null) {
      return;
    }
    ((VideoPlayerPagerAdapter.VideoViewHolder)localView.getTag()).d.c();
    paramViewGroup.removeView(localView);
    paramViewGroup = (IShortVideoCommentsView)paramObject;
    if (paramViewGroup.getPlayerView() != null)
    {
      a((ImageView)paramViewGroup.getPlayerView().findViewById(((IResourceUtil)QRoute.api(IResourceUtil.class)).getIvCover()));
      a((ImageView)paramViewGroup.getPlayerView().findViewById(((IResourceUtil)QRoute.api(IResourceUtil.class)).getDoodleView()));
    }
  }
  
  public int getCount()
  {
    return 100;
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (paramObject == null) {
      return -2;
    }
    paramObject = (VideoPlayerPagerAdapter.VideoViewHolder)((View)paramObject).getTag();
    if (paramObject == null) {
      return -2;
    }
    int n;
    if (paramObject.a == this.e.getCurrentIndex())
    {
      if (this.k)
      {
        this.k = false;
        return -2;
      }
      n = paramObject.a + 50;
    }
    for (int m = this.h;; m = this.h)
    {
      return n - m;
      n = paramObject.a + 50;
    }
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    paramInt = paramInt - 50 + this.h;
    boolean bool = true;
    if ((paramInt >= 0) && (paramInt < this.d.size()))
    {
      localObject = (VideoData)this.d.get(paramInt);
      VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder = new VideoPlayerPagerAdapter.VideoViewHolder(this);
      IShortVideoCommentsView localIShortVideoCommentsView = ((INowViewCreater)QRoute.api(INowViewCreater.class)).createShortVideoCommentsView(paramViewGroup.getContext());
      localIShortVideoCommentsView.setApp(this.f);
      localIShortVideoCommentsView.init(localVideoViewHolder, (VideoData)localObject);
      View localView = (View)localIShortVideoCommentsView;
      localVideoViewHolder.d.setOnCloseListener(this.j);
      localVideoViewHolder.d.setOnCommentClickListener(new VideoPlayerPagerAdapter.1(this, localIShortVideoCommentsView));
      localVideoViewHolder.h = ((VideoData)localObject);
      IStoryPlayController localIStoryPlayController = this.e;
      if (localIStoryPlayController != null) {
        localIStoryPlayController.onViewConstruct(this.a, this, localVideoViewHolder);
      }
      localVideoViewHolder.a = paramInt;
      this.b.put(paramInt, localVideoViewHolder);
      this.c.put(paramInt, localView);
      localView.setTag(localVideoViewHolder);
      localIStoryPlayController = this.e;
      if (localIStoryPlayController != null)
      {
        if (paramInt != localIStoryPlayController.getFirstShowIndex()) {
          bool = false;
        }
        localIStoryPlayController.onFillData(localVideoViewHolder, (VideoData)localObject, bool, localIShortVideoCommentsView);
        if (paramInt == this.e.getCurrentIndex()) {
          this.e.startPlayVideo(paramInt);
        }
        paramViewGroup.addView(localView, -1, -1);
        return localView;
      }
      throw new InvalidParameterException("VideoPlayerPagerAdapter not set mStoryPlayerController");
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("position =");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" ! realIndex is:");
    ((StringBuilder)localObject).append(this.h);
    QLog.i("VideoPlayerPagerAdapter", 1, ((StringBuilder)localObject).toString());
    if ((paramInt != -1) && (paramInt != this.d.size())) {
      return null;
    }
    return new View(paramViewGroup.getContext());
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void onClick(View paramView)
  {
    IStoryPlayController localIStoryPlayController = this.e;
    if (localIStoryPlayController != null) {
      localIStoryPlayController.onPagerItemClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter
 * JD-Core Version:    0.7.0.1
 */