package com.tencent.mobileqq.nearby.profilecard.moment;

import com.tencent.mobileqq.nearby.profilecard.moment.data.ChangMomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.CommentInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.ShortVideoMomentFeedInfo;
import java.util.Iterator;
import java.util.List;

class NearbyMomentFragment$10
  extends NearbyMomentManager.MomentDataChangeObserver
{
  NearbyMomentFragment$10(NearbyMomentFragment paramNearbyMomentFragment) {}
  
  public void a(String paramString)
  {
    paramString = NearbyMomentFragment.a(this.a, paramString);
    if (paramString != null)
    {
      NearbyMomentFragment.a(this.a).a().remove(paramString);
      NearbyMomentFragment.a(this.a).notifyDataSetChanged();
      NearbyMomentFragment.b(this.a, paramString.c);
    }
    if (NearbyMomentFragment.a(this.a).a().size() == 0) {
      this.a.a(1);
    }
    NearbyMomentFragment.a(this.a).remove(paramString);
  }
  
  public void a(String paramString, long paramLong)
  {
    MomentFeedInfo localMomentFeedInfo = NearbyMomentFragment.a(this.a, paramString);
    if (localMomentFeedInfo != null)
    {
      if (localMomentFeedInfo.g > 0) {
        localMomentFeedInfo.g -= 1;
      }
      if ((localMomentFeedInfo.jdField_a_of_type_JavaUtilList != null) && (localMomentFeedInfo.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        Iterator localIterator = localMomentFeedInfo.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          paramString = (CommentInfo)localIterator.next();
        } while (paramString.a != paramLong);
      }
    }
    for (;;)
    {
      if (paramString != null) {
        localMomentFeedInfo.jdField_a_of_type_JavaUtilList.remove(paramString);
      }
      NearbyMomentFragment.a(this.a).notifyDataSetChanged();
      return;
      paramString = null;
    }
  }
  
  public void b(String paramString)
  {
    paramString = NearbyMomentFragment.a(this.a, paramString);
    if (paramString != null)
    {
      paramString.g += 1;
      NearbyMomentFragment.a(this.a).notifyDataSetChanged();
    }
  }
  
  public void b(String paramString, long paramLong)
  {
    paramString = NearbyMomentFragment.a(this.a, paramString);
    if (paramString != null)
    {
      if (!paramString.jdField_a_of_type_Boolean)
      {
        paramString.jdField_a_of_type_Boolean = true;
        paramString.f += 1;
      }
      NearbyMomentFragment.a(this.a).notifyDataSetChanged();
    }
  }
  
  public void c(String paramString)
  {
    paramString = NearbyMomentFragment.a(this.a, paramString);
    if ((paramString instanceof ShortVideoMomentFeedInfo))
    {
      paramString = (ShortVideoMomentFeedInfo)paramString;
      paramString.e += 1;
    }
    for (;;)
    {
      NearbyMomentFragment.a(this.a).notifyDataSetChanged();
      return;
      if ((paramString instanceof ChangMomentFeedInfo))
      {
        paramString = (ChangMomentFeedInfo)paramString;
        paramString.e += 1;
      }
    }
  }
  
  public void c(String paramString, long paramLong)
  {
    paramString = NearbyMomentFragment.a(this.a, paramString);
    if ((paramString != null) && (paramString.jdField_a_of_type_Boolean))
    {
      paramString.jdField_a_of_type_Boolean = false;
      if (paramString.f > 0) {
        paramString.f -= 1;
      }
      NearbyMomentFragment.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment.10
 * JD-Core Version:    0.7.0.1
 */