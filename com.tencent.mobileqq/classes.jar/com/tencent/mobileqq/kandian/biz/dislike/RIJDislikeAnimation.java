package com.tencent.mobileqq.kandian.biz.dislike;

import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.util.List;

public class RIJDislikeAnimation
{
  AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  RIJDataManager jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager;
  
  public RIJDislikeAnimation(RIJDataManager paramRIJDataManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager = paramRIJDataManager;
  }
  
  public AnimationSet a()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet == null) {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet = ((AnimationSet)AnimationUtils.loadAnimation(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a(), 2130772100));
    }
    AnimationSet localAnimationSet = new AnimationSet(true);
    List localList = this.jdField_a_of_type_AndroidViewAnimationAnimationSet.getAnimations();
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      localAnimationSet.addAnimation((Animation)localList.get(i));
      i += 1;
    }
    return localAnimationSet;
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().remove(paramAbsBaseArticleInfo);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a().notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().e(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.dislike.RIJDislikeAnimation
 * JD-Core Version:    0.7.0.1
 */