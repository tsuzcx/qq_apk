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
  public int a;
  public SparseArray<VideoPlayerPagerAdapter.VideoViewHolder> a;
  protected LayoutInflater a;
  public AppInterface a;
  public IStoryPlayController a;
  private StuffContainerView.OnCloseListener a;
  public List<VideoData> a;
  public boolean a;
  public SparseArray<View> b;
  private boolean b;
  private boolean c;
  
  public VideoPlayerPagerAdapter(Context paramContext, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$OnCloseListener = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
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
  
  public View a(int paramInt)
  {
    return (View)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public VideoData a(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (paramInt >= 0) && (paramInt < localList.size())) {
      return (VideoData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public VideoPlayerPagerAdapter.VideoViewHolder a(int paramInt)
  {
    return (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      Object localObject = this.jdField_a_of_type_AndroidUtilSparseArray;
      localObject = (VideoPlayerPagerAdapter.VideoViewHolder)((SparseArray)localObject).get(((SparseArray)localObject).keyAt(i));
      if ((localObject != null) && (((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null)) {
        ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.c();
      }
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    HashMap localHashMap = this.jdField_a_of_type_ComTencentMobileqqNearbyNowIStoryPlayController.getItemListeners();
    Object localObject = new ArrayList();
    Iterator localIterator = localHashMap.keySet().iterator();
    while (localIterator.hasNext()) {
      ((List)localObject).add(Integer.valueOf(((Integer)localIterator.next()).intValue()));
    }
    localObject = ((List)localObject).toArray();
    Arrays.sort((Object[])localObject);
    int i = localObject.length - 1;
    while (i >= 0)
    {
      int j = ((Integer)localObject[i]).intValue();
      localHashMap.put(Integer.valueOf(j + paramInt), (IVideoInfoListener)localHashMap.get(Integer.valueOf(j)));
      localHashMap.remove(Integer.valueOf(j));
      i -= 1;
    }
  }
  
  public void a(int paramInt, List<VideoData> paramList)
  {
    if (paramInt == 0)
    {
      int i = paramList.size();
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyNowIStoryPlayController;
      ((IStoryPlayController)localObject1).setCurrentIndex(((IStoryPlayController)localObject1).getCurrentIndex() + i);
      a(i);
      localObject1 = new ArrayList();
      paramInt = 0;
      while (paramInt < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        ((List)localObject1).add(Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(paramInt)));
        paramInt += 1;
      }
      localObject1 = ((List)localObject1).toArray();
      Arrays.sort((Object[])localObject1);
      paramInt = localObject1.length - 1;
      int j;
      Object localObject2;
      while (paramInt >= 0)
      {
        j = ((Integer)localObject1[paramInt]).intValue();
        localObject2 = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_AndroidUtilSparseArray.get(j);
        ((VideoPlayerPagerAdapter.VideoViewHolder)localObject2).jdField_a_of_type_Int += i;
        localObject2 = this.jdField_a_of_type_AndroidUtilSparseArray;
        ((SparseArray)localObject2).put(((VideoPlayerPagerAdapter.VideoViewHolder)((SparseArray)localObject2).get(j)).jdField_a_of_type_Int, this.jdField_a_of_type_AndroidUtilSparseArray.get(j));
        this.jdField_a_of_type_AndroidUtilSparseArray.delete(j);
        paramInt -= 1;
      }
      localObject1 = new ArrayList();
      paramInt = 0;
      while (paramInt < this.jdField_b_of_type_AndroidUtilSparseArray.size())
      {
        ((List)localObject1).add(Integer.valueOf(this.jdField_b_of_type_AndroidUtilSparseArray.keyAt(paramInt)));
        paramInt += 1;
      }
      localObject1 = ((List)localObject1).toArray();
      Arrays.sort((Object[])localObject1);
      paramInt = localObject1.length - 1;
      while (paramInt >= 0)
      {
        j = ((Integer)localObject1[paramInt]).intValue();
        localObject2 = (View)this.jdField_b_of_type_AndroidUtilSparseArray.get(j);
        this.jdField_b_of_type_AndroidUtilSparseArray.put(j + i, localObject2);
        this.jdField_b_of_type_AndroidUtilSparseArray.remove(j);
        paramInt -= 1;
      }
      this.jdField_a_of_type_Int += i;
      this.jdField_a_of_type_JavaUtilList.addAll(0, paramList);
      return;
    }
    if (paramInt == 1) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public void a(IStoryPlayController paramIStoryPlayController, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowIStoryPlayController = paramIStoryPlayController;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(StuffContainerView.OnCloseListener paramOnCloseListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$OnCloseListener = paramOnCloseListener;
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
    ((VideoPlayerPagerAdapter.VideoViewHolder)localView.getTag()).jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.c();
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
    int j;
    if (paramObject.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqNearbyNowIStoryPlayController.getCurrentIndex())
    {
      if (this.c)
      {
        this.c = false;
        return -2;
      }
      j = paramObject.jdField_a_of_type_Int + 50;
    }
    for (int i = this.jdField_a_of_type_Int;; i = this.jdField_a_of_type_Int)
    {
      return j - i;
      j = paramObject.jdField_a_of_type_Int + 50;
    }
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    paramInt = paramInt - 50 + this.jdField_a_of_type_Int;
    boolean bool = true;
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      localObject = (VideoData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder = new VideoPlayerPagerAdapter.VideoViewHolder(this);
      IShortVideoCommentsView localIShortVideoCommentsView = ((INowViewCreater)QRoute.api(INowViewCreater.class)).createShortVideoCommentsView(paramViewGroup.getContext());
      localIShortVideoCommentsView.setApp(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      localIShortVideoCommentsView.init(localVideoViewHolder, (VideoData)localObject);
      View localView = (View)localIShortVideoCommentsView;
      localVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setOnCloseListener(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$OnCloseListener);
      localVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setOnCommentClickListener(new VideoPlayerPagerAdapter.1(this, localIShortVideoCommentsView));
      localVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData = ((VideoData)localObject);
      IStoryPlayController localIStoryPlayController = this.jdField_a_of_type_ComTencentMobileqqNearbyNowIStoryPlayController;
      if (localIStoryPlayController != null) {
        localIStoryPlayController.onViewConstruct(this.jdField_a_of_type_AndroidViewLayoutInflater, this, localVideoViewHolder);
      }
      localVideoViewHolder.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localVideoViewHolder);
      this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt, localView);
      localView.setTag(localVideoViewHolder);
      localIStoryPlayController = this.jdField_a_of_type_ComTencentMobileqqNearbyNowIStoryPlayController;
      if (localIStoryPlayController != null)
      {
        if (paramInt != localIStoryPlayController.getFirstShowIndex()) {
          bool = false;
        }
        localIStoryPlayController.onFillData(localVideoViewHolder, (VideoData)localObject, bool, localIShortVideoCommentsView);
        if (paramInt == this.jdField_a_of_type_ComTencentMobileqqNearbyNowIStoryPlayController.getCurrentIndex()) {
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowIStoryPlayController.startPlayVideo(paramInt);
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
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    QLog.i("VideoPlayerPagerAdapter", 1, ((StringBuilder)localObject).toString());
    if ((paramInt != -1) && (paramInt != this.jdField_a_of_type_JavaUtilList.size())) {
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
    IStoryPlayController localIStoryPlayController = this.jdField_a_of_type_ComTencentMobileqqNearbyNowIStoryPlayController;
    if (localIStoryPlayController != null) {
      localIStoryPlayController.onPagerItemClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter
 * JD-Core Version:    0.7.0.1
 */