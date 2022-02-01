package com.tencent.mobileqq.profilecard.vas.view;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.widget.RatioLayout;
import com.tencent.mobileqq.widget.RatioLayout.LayoutParams;
import java.util.List;

class VasProfileTagView$2$1
  implements Runnable
{
  VasProfileTagView$2$1(VasProfileTagView.2 param2, List paramList) {}
  
  public void run()
  {
    if (this.val$tags != null)
    {
      int j = VasProfileTagView.access$100().length - 1;
      int i;
      if (this.val$tags.size() >= j) {
        i = j;
      } else {
        i = this.val$tags.size();
      }
      if ((this.this$1.this$0.isFullScreen) && (!VasProfileTagView.access$200(this.this$1.this$0)) && (VasProfileTagView.access$300(this.this$1.this$0)[j] != null) && (i == 0)) {
        VasProfileTagView.access$400(this.this$1.this$0).setVisibility(0);
      } else {
        VasProfileTagView.access$400(this.this$1.this$0).setVisibility(4);
      }
      if ((this.this$1.val$cardInfo.allInOne.pa == 0) && (VasProfileTagView.access$300(this.this$1.this$0)[j] == null))
      {
        Object localObject = VasProfileTagView.access$300(this.this$1.this$0);
        View localView = View.inflate(this.this$1.this$0.getContext(), 2131628480, null);
        localObject[j] = localView;
        localObject = new RatioLayout.LayoutParams(-2, -2, 0.5F, 0.5F, 0.5F, 0.5F);
        VasProfileTagView.access$500(this.this$1.this$0).addView(localView, (ViewGroup.LayoutParams)localObject);
        localView.setVisibility(4);
        localView.setTag(new DataTag(32, null));
        localView.setOnClickListener(VasProfileTagView.access$600(this.this$1.this$0));
        localView.setId(2131443124);
        localView.setTag(2131443124, Integer.valueOf(-1));
        localView.setTag(2131443126, Integer.valueOf(VasProfileTagView.access$100().length - 1));
      }
      VasProfileTagView.access$700(this.this$1.this$0, j);
      VasProfileTagView.access$800(this.this$1.this$0, i, this.val$tags, this.this$1.val$cardInfo);
    }
    this.this$1.this$0.setColorScheme((int)this.this$1.val$cardInfo.card.backgroundColor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.2.1
 * JD-Core Version:    0.7.0.1
 */