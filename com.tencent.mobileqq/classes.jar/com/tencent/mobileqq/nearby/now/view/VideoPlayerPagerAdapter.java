package com.tencent.mobileqq.nearby.now.view;

import aeyg;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.StoryPlayController;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.logic.VideoInfoListenerImpl;
import com.tencent.qphone.base.util.QLog;
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
  implements View.OnClickListener, VideoPlayerView.ShowLoadingWhenLoadingCoverListener
{
  public int a;
  public SparseArray a;
  protected LayoutInflater a;
  public QQAppInterface a;
  public StoryPlayController a;
  private StuffContainerView.OnCloseListener a;
  public List a;
  public boolean a;
  public SparseArray b;
  private boolean b;
  private boolean c;
  
  public VideoPlayerPagerAdapter(Context paramContext, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  private void a(ImageView paramImageView)
  {
    if ((paramImageView != null) && (paramImageView.getDrawable() != null) && ((paramImageView.getDrawable() instanceof URLDrawable)) && (((URLDrawable)paramImageView.getDrawable()).getCurrDrawable() != null) && ((((URLDrawable)paramImageView.getDrawable()).getCurrDrawable() instanceof RegionDrawable)) && (((RegionDrawable)((URLDrawable)paramImageView.getDrawable()).getCurrDrawable()).getBitmap() != null))
    {
      ((RegionDrawable)((URLDrawable)paramImageView.getDrawable()).getCurrDrawable()).getBitmap().recycle();
      if (((URLDrawable)paramImageView.getDrawable()).getURL() != null) {
        URLDrawable.removeMemoryCacheByUrl(((URLDrawable)paramImageView.getDrawable()).getURL().toString() + "#now");
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
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
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
      VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i));
      if ((localVideoViewHolder != null) && (localVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null)) {
        localVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.c();
      }
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    HashMap localHashMap = this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.jdField_a_of_type_JavaUtilHashMap;
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
      localHashMap.put(Integer.valueOf(j + paramInt), (VideoInfoListenerImpl)localHashMap.get(Integer.valueOf(j)));
      localHashMap.remove(Integer.valueOf(j));
      i -= 1;
    }
  }
  
  public void a(int paramInt, List paramList)
  {
    if (paramInt == 0)
    {
      i = paramList.size();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController;
      ((StoryPlayController)localObject1).jdField_a_of_type_Int += i;
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
      while (paramInt >= 0)
      {
        j = ((Integer)localObject1[paramInt]).intValue();
        localObject2 = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_AndroidUtilSparseArray.get(j);
        ((VideoPlayerPagerAdapter.VideoViewHolder)localObject2).jdField_a_of_type_Int += i;
        this.jdField_a_of_type_AndroidUtilSparseArray.put(((VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_AndroidUtilSparseArray.get(j)).jdField_a_of_type_Int, this.jdField_a_of_type_AndroidUtilSparseArray.get(j));
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
    }
    while (paramInt != 1)
    {
      int i;
      Object localObject1;
      int j;
      Object localObject2;
      return;
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(StoryPlayController paramStoryPlayController, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController = paramStoryPlayController;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(StuffContainerView.OnCloseListener paramOnCloseListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$OnCloseListener = paramOnCloseListener;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return;
      } while ((VideoPlayerPagerAdapter.VideoViewHolder)((View)paramObject).getTag() == null);
      View localView = (View)paramObject;
      ((VideoPlayerPagerAdapter.VideoViewHolder)((View)paramObject).getTag()).jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.c();
      paramViewGroup.removeView(localView);
    } while (((ShortVideoCommentsView)paramObject).jdField_a_of_type_AndroidViewView == null);
    a((ImageView)((ShortVideoCommentsView)paramObject).jdField_a_of_type_AndroidViewView.findViewById(2131366378));
    a((ImageView)((ShortVideoCommentsView)paramObject).jdField_a_of_type_AndroidViewView.findViewById(2131370642));
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
    if (paramObject.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.jdField_a_of_type_Int)
    {
      if (this.c)
      {
        this.c = false;
        return -2;
      }
      return paramObject.jdField_a_of_type_Int + 50 - this.jdField_a_of_type_Int;
    }
    return paramObject.jdField_a_of_type_Int + 50 - this.jdField_a_of_type_Int;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    boolean bool = true;
    paramInt = paramInt - 50 + this.jdField_a_of_type_Int;
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()))
    {
      QLog.i("VideoPlayerPagerAdapter", 1, "position =" + paramInt + " ! realIndex is:" + this.jdField_a_of_type_Int);
      if ((paramInt == -1) || (paramInt == this.jdField_a_of_type_JavaUtilList.size())) {
        return new View(paramViewGroup.getContext());
      }
      return null;
    }
    VideoData localVideoData = (VideoData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder = new VideoPlayerPagerAdapter.VideoViewHolder(this);
    ShortVideoCommentsView localShortVideoCommentsView = new ShortVideoCommentsView(paramViewGroup.getContext());
    localShortVideoCommentsView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localShortVideoCommentsView.a(localVideoViewHolder, localVideoData);
    localVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setOnCloseListener(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$OnCloseListener);
    localVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setOnCommentClickListener(new aeyg(this, localShortVideoCommentsView));
    localVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData = localVideoData;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.a(this.jdField_a_of_type_AndroidViewLayoutInflater, this, localVideoViewHolder);
    }
    localVideoViewHolder.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localVideoViewHolder);
    this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt, localShortVideoCommentsView);
    localShortVideoCommentsView.setTag(localVideoViewHolder);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController != null)
    {
      StoryPlayController localStoryPlayController = this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController;
      if (paramInt == this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.c) {}
      for (;;)
      {
        localStoryPlayController.a(localVideoViewHolder, localVideoData, bool, localShortVideoCommentsView);
        if (paramInt == this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.jdField_a_of_type_Int) {
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.a(paramInt);
        }
        paramViewGroup.addView(localShortVideoCommentsView, -1, -1);
        return localShortVideoCommentsView;
        bool = false;
      }
    }
    throw new InvalidParameterException("VideoPlayerPagerAdapter not set mStoryPlayerController");
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter
 * JD-Core Version:    0.7.0.1
 */