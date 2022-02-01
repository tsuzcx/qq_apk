package com.tencent.mobileqq.troop.troopcard.ui;

import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.utils.ViewUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

class TroopMoreDetailView$UpdateTroopMembersFaceTask
  implements Runnable
{
  private final WeakReference<TroopMoreDetailView> a;
  
  public TroopMoreDetailView$UpdateTroopMembersFaceTask(TroopMoreDetailView paramTroopMoreDetailView)
  {
    this.a = new WeakReference(paramTroopMoreDetailView);
  }
  
  public void run()
  {
    TroopMoreDetailView localTroopMoreDetailView = (TroopMoreDetailView)this.a.get();
    if (localTroopMoreDetailView == null) {
      return;
    }
    if (TroopMoreDetailView.a(localTroopMoreDetailView) == null) {
      return;
    }
    AppInterface localAppInterface = TroopMoreDetailView.b(localTroopMoreDetailView);
    if (localAppInterface == null) {
      return;
    }
    if (localTroopMoreDetailView.i == null) {
      return;
    }
    Object localObject2 = localTroopMoreDetailView.i[6];
    if (localObject2 == null) {
      return;
    }
    int k = localTroopMoreDetailView.g.size();
    if (k == 0)
    {
      ((View)localObject2).setVisibility(8);
      return;
    }
    ((LinearLayout)((View)localObject2).findViewById(2131432723)).setVisibility(0);
    Object localObject1 = (TextView)((View)localObject2).findViewById(2131438047);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131912926));
    localStringBuilder.append(k);
    localStringBuilder.append(HardCodeUtil.a(2131912919));
    ((TextView)localObject1).setText(localStringBuilder.toString());
    localObject2 = (TextView)((View)localObject2).findViewById(2131438053);
    int j = (localTroopMoreDetailView.h.widthPixels - ((TextView)localObject2).getMeasuredWidth() - ViewUtils.dip2px(27.0F) - ((TextView)localObject1).getMeasuredWidth() - ViewUtils.dip2px(24.0F)) / ViewUtils.dip2px(52.0F);
    int i = j;
    if (j > 6) {
      i = 6;
    }
    j = 0;
    while (j < i - 1)
    {
      localObject1 = (ImageView)localTroopMoreDetailView.j.get(j);
      if (j < k)
      {
        localObject2 = (String)localTroopMoreDetailView.g.get(j);
        ((ImageView)localObject1).setVisibility(0);
        ((ImageView)localObject1).setBackgroundDrawable(FaceDrawable.getFaceDrawableFrom(localAppInterface, 1, (String)localObject2, 3));
        ((ImageView)localObject1).setTag(localObject2);
        ((ImageView)localObject1).setOnClickListener(new TroopMoreDetailView.UpdateTroopMembersFaceTask.1(this, localTroopMoreDetailView));
        if (AppSetting.e)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131912916));
          ((StringBuilder)localObject2).append(j + 1);
          ((ImageView)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
          ViewCompat.setImportantForAccessibility((View)localObject1, 1);
        }
      }
      else
      {
        ((ImageView)localObject1).setVisibility(8);
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopMoreDetailView.UpdateTroopMembersFaceTask
 * JD-Core Version:    0.7.0.1
 */