package com.tencent.mobileqq.troop.troopcard;

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
    AppInterface localAppInterface = TroopMoreDetailView.a(localTroopMoreDetailView);
    if (localAppInterface == null) {
      return;
    }
    if (localTroopMoreDetailView.jdField_a_of_type_ArrayOfAndroidViewView == null) {
      return;
    }
    Object localObject2 = localTroopMoreDetailView.jdField_a_of_type_ArrayOfAndroidViewView[6];
    if (localObject2 == null) {
      return;
    }
    int k = localTroopMoreDetailView.jdField_a_of_type_JavaUtilArrayList.size();
    if (k == 0)
    {
      ((View)localObject2).setVisibility(8);
      return;
    }
    ((LinearLayout)((View)localObject2).findViewById(2131366410)).setVisibility(0);
    Object localObject1 = (TextView)((View)localObject2).findViewById(2131370746);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131715449));
    localStringBuilder.append(k);
    localStringBuilder.append(HardCodeUtil.a(2131715442));
    ((TextView)localObject1).setText(localStringBuilder.toString());
    localObject2 = (TextView)((View)localObject2).findViewById(2131370751);
    int j = (localTroopMoreDetailView.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels - ((TextView)localObject2).getMeasuredWidth() - ViewUtils.a(27.0F) - ((TextView)localObject1).getMeasuredWidth() - ViewUtils.a(24.0F)) / ViewUtils.a(52.0F);
    int i = j;
    if (j > 6) {
      i = 6;
    }
    j = 0;
    while (j < i - 1)
    {
      localObject1 = (ImageView)localTroopMoreDetailView.jdField_a_of_type_JavaUtilList.get(j);
      if (j < k)
      {
        localObject2 = (String)localTroopMoreDetailView.jdField_a_of_type_JavaUtilArrayList.get(j);
        ((ImageView)localObject1).setVisibility(0);
        ((ImageView)localObject1).setBackgroundDrawable(FaceDrawable.getFaceDrawableFrom(localAppInterface, 1, (String)localObject2, 3));
        ((ImageView)localObject1).setTag(localObject2);
        ((ImageView)localObject1).setOnClickListener(new TroopMoreDetailView.UpdateTroopMembersFaceTask.1(this, localTroopMoreDetailView));
        if (AppSetting.d)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131715439));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopMoreDetailView.UpdateTroopMembersFaceTask
 * JD-Core Version:    0.7.0.1
 */