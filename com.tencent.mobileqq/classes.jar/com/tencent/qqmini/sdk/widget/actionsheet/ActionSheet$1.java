package com.tencent.qqmini.sdk.widget.actionsheet;

import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.R.id;
import java.util.HashSet;

class ActionSheet$1
  implements View.OnClickListener
{
  ActionSheet$1(ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if ((ActionSheet.access$000(this.this$0)) && ((ActionSheet.access$100(this.this$0) == null) || (!ActionSheet.access$100(this.this$0).contains(Integer.valueOf(i)))) && (ActionSheet.access$200(this.this$0) != -1) && (i != ActionSheet.access$200(this.this$0)))
    {
      localObject = (View)ActionSheet.access$300(this.this$0).get(ActionSheet.access$200(this.this$0));
      ((View)localObject).findViewById(R.id.action_sheet_checkedIcon).setVisibility(8);
      localObject = (TextView)((View)localObject).findViewById(R.id.action_sheet_button);
      ActionSheet.access$400(this.this$0, (TextView)localObject, false);
      localObject = (View)ActionSheet.access$300(this.this$0).get(i);
      ((View)localObject).findViewById(R.id.action_sheet_checkedIcon).setVisibility(0);
      localObject = (TextView)((View)localObject).findViewById(R.id.action_sheet_button);
      ActionSheet.access$400(this.this$0, (TextView)localObject, true);
      ActionSheet.access$202(this.this$0, i);
    }
    if (ActionSheet.access$500(this.this$0) != null) {
      ActionSheet.access$500(this.this$0).onClick(paramView, i);
    }
    if (ActionSheet.access$600(this.this$0) != null)
    {
      localObject = (TextView)paramView.findViewById(R.id.action_sheet_button);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        ActionSheet.access$600(this.this$0).onClick(paramView, i, ((TextView)localObject).getText().toString());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet.1
 * JD-Core Version:    0.7.0.1
 */