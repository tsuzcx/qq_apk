package com.tencent.mobileqq.nearby.profilecard;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.picbrowser.PicInfo;

class NearbyProfileEditPanel$24
  implements View.OnLongClickListener
{
  NearbyProfileEditPanel$24(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
  @TargetApi(11)
  public boolean onLongClick(View paramView)
  {
    if (this.a.i.getChildCount() <= 1) {
      return true;
    }
    Object localObject = new ClipData.Item("");
    paramView.startDrag(new ClipData("", new String[] { "text/plain" }, (ClipData.Item)localObject), new NearbyProfileEditPanel.PicDragShadowBuilder(this.a, paramView), paramView, 0);
    localObject = NearbyProfileEditPanel.a(this.a, (PicInfo)paramView.getTag(), null);
    ((RelativeLayout)localObject).setVisibility(4);
    NearbyProfileEditPanel.a(this.a, (RelativeLayout)localObject);
    int i = this.a.i.indexOfChild(paramView);
    if (i != -1)
    {
      this.a.i.removeView(paramView);
      this.a.i.addView(NearbyProfileEditPanel.h(this.a), i);
      return true;
    }
    paramView.setVisibility(4);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.24
 * JD-Core Version:    0.7.0.1
 */