package com.tencent.mobileqq.flashshow.viewmodel.barrage.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.flashshow.viewmodel.barrage.holder.bean.BarrageHolderParam;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;

public class FSNormalBarrageHolder
  extends FSBaseBarrageHolder
{
  private TextView b;
  
  public FSNormalBarrageHolder(Context paramContext)
  {
    super(paramContext, 2131624791);
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
    this.b = ((TextView)paramView.findViewById(2131433337));
  }
  
  public void a(BarrageHolderParam paramBarrageHolderParam)
  {
    if (paramBarrageHolderParam == null)
    {
      QLog.d("DM-FSNormalBarrageHolder", 1, "[onBindView] param should not be null.");
      return;
    }
    b(paramBarrageHolderParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.barrage.holder.FSNormalBarrageHolder
 * JD-Core Version:    0.7.0.1
 */