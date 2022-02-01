package com.tencent.mobileqq.nearby.profilecard.moment;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.moment.data.ChangMomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.LiveMomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.PicMomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.ShortVideoMomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.TextMomentFeedInfo;

public class NearbyCardMomentItemFactory
{
  private BaseMomentItemBuilder a;
  private BaseMomentItemBuilder b;
  private BaseMomentItemBuilder c;
  private BaseMomentItemBuilder d;
  private BaseMomentItemBuilder e;
  private QQAppInterface f;
  private Context g;
  
  public NearbyCardMomentItemFactory(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.f = paramQQAppInterface;
    this.g = paramContext;
  }
  
  public int a()
  {
    return 5;
  }
  
  public int a(MomentFeedInfo paramMomentFeedInfo)
  {
    if ((paramMomentFeedInfo instanceof LiveMomentFeedInfo)) {
      return 0;
    }
    if ((paramMomentFeedInfo instanceof ShortVideoMomentFeedInfo)) {
      return 1;
    }
    if ((paramMomentFeedInfo instanceof PicMomentFeedInfo)) {
      return 2;
    }
    if ((paramMomentFeedInfo instanceof ChangMomentFeedInfo)) {
      return 3;
    }
    if ((paramMomentFeedInfo instanceof TextMomentFeedInfo)) {
      return 4;
    }
    return -1;
  }
  
  public BaseMomentItemBuilder a(int paramInt)
  {
    Object localObject;
    if (paramInt == 0)
    {
      localObject = this.a;
      if (localObject != null) {
        return localObject;
      }
      localObject = new LiveMomentItemBuilder(this.g, this.f);
      this.a = ((BaseMomentItemBuilder)localObject);
      return localObject;
    }
    if (paramInt == 1)
    {
      localObject = this.b;
      if (localObject != null) {
        return localObject;
      }
      localObject = new ShortVideoMomentItemBuilder(this.g, this.f);
      this.b = ((BaseMomentItemBuilder)localObject);
      return localObject;
    }
    if (paramInt == 2)
    {
      localObject = this.c;
      if (localObject != null) {
        return localObject;
      }
      localObject = new PicMomentItemBuilder(this.g, this.f);
      this.c = ((BaseMomentItemBuilder)localObject);
      return localObject;
    }
    if (paramInt == 3)
    {
      localObject = this.d;
      if (localObject != null) {
        return localObject;
      }
      localObject = new ChangMomentItemBuilder(this.g, this.f);
      this.d = ((BaseMomentItemBuilder)localObject);
      return localObject;
    }
    if (paramInt == 4)
    {
      localObject = this.e;
      if (localObject != null) {
        return localObject;
      }
      localObject = new TextMomentItemBuilder(this.g, this.f);
      this.e = ((BaseMomentItemBuilder)localObject);
      return localObject;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyCardMomentItemFactory
 * JD-Core Version:    0.7.0.1
 */