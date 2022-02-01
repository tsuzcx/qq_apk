package com.tencent.mobileqq.flashshow.viewmodel.barrage.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.flashshow.viewmodel.barrage.holder.bean.BarrageHolderParam;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rfw.barrage.render.RFWViewBarrageRender.ViewHolder;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;

public abstract class FSBaseBarrageHolder
  extends RFWViewBarrageRender.ViewHolder
{
  public FSBaseBarrageHolder(Context paramContext, int paramInt)
  {
    super(a(paramContext, paramInt));
    a(this.a);
  }
  
  private static View a(Context paramContext, int paramInt)
  {
    return LayoutInflater.from(paramContext).inflate(paramInt, null);
  }
  
  protected String a(FeedCloudMeta.StComment paramStComment)
  {
    if (paramStComment == null) {
      return null;
    }
    return paramStComment.content.get();
  }
  
  protected String a(FeedCloudMeta.StReply paramStReply)
  {
    if (paramStReply == null) {
      return null;
    }
    return paramStReply.content.get();
  }
  
  public abstract void a(View paramView);
  
  protected void a(TextView paramTextView, String paramString)
  {
    if (paramTextView == null)
    {
      QLog.d("DM-FSBaseBarrageHolder", 1, "[setViewText] view should not is null.");
      return;
    }
    paramTextView.setText(paramString);
  }
  
  public abstract void a(BarrageHolderParam paramBarrageHolderParam);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.barrage.holder.FSBaseBarrageHolder
 * JD-Core Version:    0.7.0.1
 */