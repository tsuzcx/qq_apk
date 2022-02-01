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
      NearbyMomentFragment.f(this.a).a().remove(paramString);
      NearbyMomentFragment.f(this.a).notifyDataSetChanged();
      NearbyMomentFragment.b(this.a, paramString.f);
    }
    if (NearbyMomentFragment.f(this.a).a().size() == 0) {
      this.a.a(1);
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    MomentFeedInfo localMomentFeedInfo = NearbyMomentFragment.a(this.a, paramString);
    if (localMomentFeedInfo != null)
    {
      if (localMomentFeedInfo.w > 0) {
        localMomentFeedInfo.w -= 1;
      }
      if ((localMomentFeedInfo.x != null) && (localMomentFeedInfo.x.size() > 0))
      {
        Object localObject = null;
        Iterator localIterator = localMomentFeedInfo.x.iterator();
        do
        {
          paramString = localObject;
          if (!localIterator.hasNext()) {
            break;
          }
          paramString = (CommentInfo)localIterator.next();
        } while (paramString.a != paramLong);
        if (paramString != null) {
          localMomentFeedInfo.x.remove(paramString);
        }
      }
      NearbyMomentFragment.f(this.a).notifyDataSetChanged();
    }
  }
  
  public void b(String paramString)
  {
    paramString = NearbyMomentFragment.a(this.a, paramString);
    if (paramString != null)
    {
      paramString.w += 1;
      NearbyMomentFragment.f(this.a).notifyDataSetChanged();
    }
  }
  
  public void b(String paramString, long paramLong)
  {
    paramString = NearbyMomentFragment.a(this.a, paramString);
    if (paramString != null)
    {
      if (!paramString.u)
      {
        paramString.u = true;
        paramString.v += 1;
      }
      NearbyMomentFragment.f(this.a).notifyDataSetChanged();
    }
  }
  
  public void c(String paramString)
  {
    paramString = NearbyMomentFragment.a(this.a, paramString);
    if ((paramString instanceof ShortVideoMomentFeedInfo))
    {
      paramString = (ShortVideoMomentFeedInfo)paramString;
      paramString.t += 1;
    }
    else if ((paramString instanceof ChangMomentFeedInfo))
    {
      paramString = (ChangMomentFeedInfo)paramString;
      paramString.t += 1;
    }
    NearbyMomentFragment.f(this.a).notifyDataSetChanged();
  }
  
  public void c(String paramString, long paramLong)
  {
    paramString = NearbyMomentFragment.a(this.a, paramString);
    if ((paramString != null) && (paramString.u))
    {
      paramString.u = false;
      if (paramString.v > 0) {
        paramString.v -= 1;
      }
      NearbyMomentFragment.f(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment.10
 * JD-Core Version:    0.7.0.1
 */