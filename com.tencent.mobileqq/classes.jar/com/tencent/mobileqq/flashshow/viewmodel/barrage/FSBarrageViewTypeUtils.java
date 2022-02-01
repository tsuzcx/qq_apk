package com.tencent.mobileqq.flashshow.viewmodel.barrage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.flashshow.viewmodel.barrage.holder.bean.BarrageHolderParam;
import com.tencent.mobileqq.flashshow.widgets.comment.helper.FSCommentHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;

public class FSBarrageViewTypeUtils
{
  public static int a(Object paramObject)
  {
    if (!(paramObject instanceof BarrageHolderParam)) {
      return 1;
    }
    paramObject = (BarrageHolderParam)paramObject;
    if (a(paramObject)) {
      return 2;
    }
    if (b(paramObject)) {
      return 3;
    }
    return 1;
  }
  
  private static boolean a(@NonNull BarrageHolderParam paramBarrageHolderParam)
  {
    paramBarrageHolderParam = paramBarrageHolderParam.a();
    if (paramBarrageHolderParam == null) {
      return false;
    }
    return FSCommentHelper.a(paramBarrageHolderParam.typeFlag2.get(), 4);
  }
  
  private static boolean b(@NonNull BarrageHolderParam paramBarrageHolderParam)
  {
    FeedCloudMeta.StReply localStReply = paramBarrageHolderParam.b();
    return (localStReply != null) && (TextUtils.equals(localStReply.id.get(), paramBarrageHolderParam.c()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.barrage.FSBarrageViewTypeUtils
 * JD-Core Version:    0.7.0.1
 */