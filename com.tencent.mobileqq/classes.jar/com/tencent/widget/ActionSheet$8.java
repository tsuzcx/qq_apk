package com.tencent.widget;

import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;

class ActionSheet$8
  implements View.OnClickListener
{
  ActionSheet$8(ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if ((ActionSheet.access$800(this.this$0)) && ((ActionSheet.access$900(this.this$0) == null) || (!ActionSheet.access$900(this.this$0).contains(Integer.valueOf(i)))) && (ActionSheet.access$1000(this.this$0) != -1) && (i != ActionSheet.access$1000(this.this$0)))
    {
      localObject = (View)ActionSheet.access$1100(this.this$0).get(ActionSheet.access$1000(this.this$0));
      ((View)localObject).findViewById(2131361974).setVisibility(8);
      localObject = (TextView)((View)localObject).findViewById(2131361973);
      ActionSheet.access$1200(this.this$0, (TextView)localObject, false);
      localObject = (View)ActionSheet.access$1100(this.this$0).get(i);
      ((View)localObject).findViewById(2131361974).setVisibility(0);
      localObject = (TextView)((View)localObject).findViewById(2131361973);
      ActionSheet.access$1200(this.this$0, (TextView)localObject, true);
      ActionSheet.access$1002(this.this$0, i);
    }
    if (ActionSheet.access$1300(this.this$0) != null) {
      ActionSheet.access$1300(this.this$0).OnClick(paramView, i);
    }
    if (ActionSheet.access$1400(this.this$0) != null)
    {
      localObject = (TextView)paramView.findViewById(2131361973);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        ActionSheet.access$1400(this.this$0).OnClick(paramView, i, ((TextView)localObject).getText().toString());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.ActionSheet.8
 * JD-Core Version:    0.7.0.1
 */