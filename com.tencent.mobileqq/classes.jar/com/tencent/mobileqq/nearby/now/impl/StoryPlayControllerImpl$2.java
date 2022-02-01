package com.tencent.mobileqq.nearby.now.impl;

import android.util.SparseArray;
import android.widget.ImageView;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.mobileqq.nearby.now.ProgressControler;
import com.tencent.mobileqq.nearby.now.model.BasePlayListDataModel;
import com.tencent.mobileqq.nearby.now.model.BasePlayListDataModel.OnDataComeListener;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.utils.QualityReporter;
import com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.OperationView;
import com.tencent.mobileqq.nearby.now.view.QQStoryVideoPlayerErrorView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class StoryPlayControllerImpl$2
  implements BasePlayListDataModel.OnDataComeListener
{
  StoryPlayControllerImpl$2(StoryPlayControllerImpl paramStoryPlayControllerImpl) {}
  
  public void a()
  {
    if ((NetworkUtil.a(this.a.getContext())) && (this.a.mAdapter.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      this.a.stuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.a();
      this.a.stuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setVisibility(0);
      this.a.stuffContainerView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.a.stuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setOnRetryClickListener(new StoryPlayControllerImpl.2.1(this));
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDataCome ! type is: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" errorCode is ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.i("VideoPlayController", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramInt2 <= 0) && (this.a.mPlayListDataModel.a().size() != 0))
    {
      this.a.stuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setVisibility(8);
      this.a.stuffContainerView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.a.stuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowProgressControler.a(this.a.mPlayListDataModel.a());
      this.a.stuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowProgressControler.b(this.a.mPlayListDataModel.a());
      if (this.a.mAdapter.jdField_a_of_type_Boolean)
      {
        if (StoryPlayControllerImpl.access$100(this.a))
        {
          paramInt2 = 0;
          while (paramInt2 < this.a.mPlayListDataModel.a().size())
          {
            if (((VideoData)this.a.mPlayListDataModel.a().get(paramInt2)).jdField_a_of_type_JavaLangString.equals(StoryPlayControllerImpl.access$200(this.a))) {
              break label242;
            }
            paramInt2 += 1;
          }
          paramInt2 = -1;
          label242:
          int i = paramInt2;
          if (paramInt2 == -1) {
            i = this.a.mPlayListDataModel.a().size() / 2 - 1;
          }
          localObject = this.a;
          ((StoryPlayControllerImpl)localObject).mFirstShowIndex = i;
          if (i != -1)
          {
            ((StoryPlayControllerImpl)localObject).mCurrentIndex = i;
            ((StoryPlayControllerImpl)localObject).mAdapter.jdField_a_of_type_Int = this.a.mCurrentIndex;
          }
          QualityReporter.b();
        }
        else if (paramInt1 == 0)
        {
          paramInt2 = this.a.mCurrentIndex;
          this.a.mPlayListDataModel.a().size();
        }
        this.a.mAdapter.a(paramInt1, this.a.mPlayListDataModel.a());
        this.a.initReporterFeedType();
        if (StoryPlayControllerImpl.access$100(this.a))
        {
          this.a.stuffContainerView.setCurrentItem(this.a.mCurrentIndex, false);
          StoryPlayControllerImpl.access$102(this.a, false);
        }
        this.a.mAdapter.notifyDataSetChanged();
        localObject = this.a;
        StoryPlayControllerImpl.access$300((StoryPlayControllerImpl)localObject, ((StoryPlayControllerImpl)localObject).mCurrentIndex);
        return;
      }
      if (!this.a.mAdapter.jdField_a_of_type_Boolean)
      {
        this.a.mAdapter.a(paramInt1, this.a.mPlayListDataModel.a());
        this.a.initReporterFeedType();
        this.a.mAdapter.notifyDataSetChanged();
        this.a.stuffContainerView.setCurrentItem(this.a.mCurrentIndex, false);
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDataCome errorCode > 0, errorCode=");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" mPlayListDataModel.getDataList().size() is : ");
    ((StringBuilder)localObject).append(this.a.mPlayListDataModel.a().size());
    QLog.e("VideoPlayController", 1, ((StringBuilder)localObject).toString());
    if (paramInt2 == 1000730)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onDataCome error! errorCode is: ");
        ((StringBuilder)localObject).append(paramInt2);
        QLog.i("VideoPlayController", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (this.a.mAdapter.jdField_a_of_type_JavaUtilList.size() != 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onDataCome error! pass it! errorCode is: ");
        ((StringBuilder)localObject).append(paramInt2);
        QLog.i("VideoPlayController", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    this.a.stuffContainerView.b(false);
    this.a.stuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setVisibility(0);
    this.a.stuffContainerView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.a.stuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.a(paramInt2);
  }
  
  public void a(VideoData paramVideoData)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onFillData ! data is: ");
      ((StringBuilder)localObject).append(paramVideoData.toString());
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramVideoData.c);
      QLog.i("VideoPlayController", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.a.mAdapter.jdField_a_of_type_JavaUtilList.size() == 1) && (this.a.mAdapter.jdField_a_of_type_AndroidUtilSparseArray.size() == 1) && (this.a.mAdapter.b.size() == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayController", 2, "onFillData ! suc");
      }
      paramVideoData.c = ((VideoData)this.a.mAdapter.jdField_a_of_type_JavaUtilList.get(0)).c;
      this.a.mAdapter.jdField_a_of_type_JavaUtilList.set(0, paramVideoData);
      ((VideoPlayerPagerAdapter.VideoViewHolder)this.a.mAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(0)).jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData = paramVideoData;
      localObject = (VideoPlayerPagerAdapter.VideoViewHolder)this.a.mAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(0);
      IShortVideoCommentsView localIShortVideoCommentsView = (IShortVideoCommentsView)this.a.mAdapter.b.get(0);
      localIShortVideoCommentsView.setVideoData(paramVideoData);
      localIShortVideoCommentsView.initLocationView();
      localIShortVideoCommentsView.initRecorderInfoView();
      ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setCurrentAnchorUin(paramVideoData.jdField_a_of_type_Long);
      this.a.onFillData(localObject, paramVideoData, false, localIShortVideoCommentsView, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.impl.StoryPlayControllerImpl.2
 * JD-Core Version:    0.7.0.1
 */