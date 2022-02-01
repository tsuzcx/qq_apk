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
  RIJDataManager a;
  AnimationSet b;
  
  public RIJDislikeAnimation(RIJDataManager paramRIJDataManager)
  {
    this.a = paramRIJDataManager;
  }
  
  public AnimationSet a()
  {
    if (this.b == null) {
      this.b = ((AnimationSet)AnimationUtils.loadAnimation(this.a.a().A(), 2130772146));
    }
    AnimationSet localAnimationSet = new AnimationSet(true);
    List localList = this.b.getAnimations();
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
    this.a.b().remove(paramAbsBaseArticleInfo);
    this.a.a().v().notifyDataSetChanged();
    this.a.a().e(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.dislike.RIJDislikeAnimation
 * JD-Core Version:    0.7.0.1
 */