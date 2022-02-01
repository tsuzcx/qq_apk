package com.tencent.mobileqq.nearby.profilecard;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.picbrowser.PicInfo;

class NearbyProfileEditTribePanel$18
  implements View.OnLongClickListener
{
  NearbyProfileEditTribePanel$18(NearbyProfileEditTribePanel paramNearbyProfileEditTribePanel) {}
  
  @TargetApi(11)
  public boolean onLongClick(View paramView)
  {
    if (this.a.h.getChildCount() <= 1) {
      return true;
    }
    Object localObject = new ClipData.Item("");
    paramView.startDrag(new ClipData("", new String[] { "text/plain" }, (ClipData.Item)localObject), new NearbyProfileEditTribePanel.PicDragShadowBuilder(this.a, paramView), paramView, 0);
    localObject = NearbyProfileEditTribePanel.a(this.a, (PicInfo)paramView.getTag(), null);
    ((RelativeLayout)localObject).setVisibility(4);
    NearbyProfileEditTribePanel.a(this.a, (RelativeLayout)localObject);
    int i = this.a.h.indexOfChild(paramView);
    if (i != -1)
    {
      this.a.h.removeView(paramView);
      this.a.h.addView(NearbyProfileEditTribePanel.e(this.a), i);
      return true;
    }
    paramView.setVisibility(4);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.18
 * JD-Core Version:    0.7.0.1
 */