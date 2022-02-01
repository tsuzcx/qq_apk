package com.tencent.mobileqq.profilecard.base.view;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

class AbsProfileHeaderView$UpdateProfileSetCardTask$1
  implements Runnable
{
  AbsProfileHeaderView$UpdateProfileSetCardTask$1(AbsProfileHeaderView.UpdateProfileSetCardTask paramUpdateProfileSetCardTask, AbsProfileHeaderView paramAbsProfileHeaderView) {}
  
  public void run()
  {
    try
    {
      if (this.val$headerView.mHeaderChildMap != null)
      {
        ReportController.b(null, "CliOper", "", "", "card_mall", "0X80066D3", 0, 0, "", "", "", "");
        View localView = (View)this.val$headerView.mHeaderChildMap.get("map_key_tips_set_card");
        TextView localTextView = (TextView)localView.findViewById(2131368173);
        ImageView localImageView = (ImageView)localView.findViewById(2131368158);
        Resources localResources = localView.getResources();
        localTextView.setText(localResources.getString(2131719973));
        localImageView.setContentDescription(localResources.getString(2131719973));
        localView.setTag(new DataTag(29, "CLICK_BANNER"));
        localView.setOnClickListener(this.val$headerView.mOnClickListener);
        AbsProfileHeaderView.access$000(this.val$headerView).set(true);
        AbsProfileHeaderView.access$400(this.val$headerView);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.UpdateProfileSetCardTask.1
 * JD-Core Version:    0.7.0.1
 */