package com.tencent.mobileqq.nearby.profilecard.moment;

import android.content.Context;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.moment.data.PublishableMomentInfo;

public abstract class PublishableMomentItemBuilder
  extends BaseMomentItemBuilder
{
  public PublishableMomentItemBuilder(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public boolean a(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    paramMomentViewHolder = (PublishableMomentInfo)paramMomentViewHolder.a;
    if (paramMomentViewHolder.a == null) {
      return false;
    }
    if (paramMomentViewHolder.a.publishState == 3) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean b(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    paramMomentViewHolder = (PublishableMomentInfo)paramMomentViewHolder.a;
    if (paramMomentViewHolder.a == null) {
      return false;
    }
    if (paramMomentViewHolder.a.publishState == 2) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.PublishableMomentItemBuilder
 * JD-Core Version:    0.7.0.1
 */