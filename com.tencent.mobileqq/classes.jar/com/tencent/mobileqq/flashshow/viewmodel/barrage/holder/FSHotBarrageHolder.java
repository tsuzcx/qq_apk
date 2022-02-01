package com.tencent.mobileqq.flashshow.viewmodel.barrage.holder;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.flashshow.viewmodel.barrage.holder.bean.BarrageHolderParam;
import com.tencent.mobileqq.flashshow.viewmodel.barrage.widgets.FSGradientTextView;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;

public class FSHotBarrageHolder
  extends FSBaseBarrageHolder
{
  private FSGradientTextView b;
  
  public FSHotBarrageHolder(Context paramContext)
  {
    super(paramContext, 2131624790);
  }
  
  private void b(@NonNull BarrageHolderParam paramBarrageHolderParam)
  {
    FeedCloudMeta.StComment localStComment = paramBarrageHolderParam.a();
    paramBarrageHolderParam = paramBarrageHolderParam.b();
    if (localStComment != null)
    {
      a(this.b, a(localStComment));
      return;
    }
    if (paramBarrageHolderParam != null) {
      a(this.b, a(paramBarrageHolderParam));
    }
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.b = ((FSGradientTextView)paramView.findViewById(2131433333));
  }
  
  public void a(BarrageHolderParam paramBarrageHolderParam)
  {
    if (paramBarrageHolderParam == null)
    {
      QLog.d("DM-FSHotBarrageHolder", 1, "[onBindView] param should not be null.");
      return;
    }
    b(paramBarrageHolderParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.barrage.holder.FSHotBarrageHolder
 * JD-Core Version:    0.7.0.1
 */