package com.tencent.mobileqq.qqlive.prepare;

import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class QQLivePrepareFragment$10
  implements ActionSheet.OnButtonClickListener
{
  QQLivePrepareFragment$10(QQLivePrepareFragment paramQQLivePrepareFragment, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        QQLivePrepareFragment.o(this.b);
      }
    }
    else {
      QQLivePrepareFragment.a(this.b, ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).profileCardUtils_enterSnapshot(this.b.getQBaseActivity(), 1));
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.QQLivePrepareFragment.10
 * JD-Core Version:    0.7.0.1
 */