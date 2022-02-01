package me.ele.uetool.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import me.ele.uetool.recyclerview.HierarchyItem;
import me.ele.uetool.recyclerview.UniversalAdapter;
import me.ele.uetool.util.JarResource;

class HierarchyView$3
  implements View.OnClickListener
{
  HierarchyView$3(HierarchyView paramHierarchyView) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    ((View)((HierarchyItem)HierarchyView.access$300(this.this$0).getItem(i)).data).setTag(JarResource.getIdByName("id", "pd_view_tag_for_unique"), new Object());
    if (HierarchyView.access$400(this.this$0) != null)
    {
      View localView = (View)((HierarchyItem)HierarchyView.access$300(this.this$0).getItem(i)).data;
      HierarchyView.access$400(this.this$0).findByViewAndShowDialog(localView);
    }
    HierarchyView.access$500(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.view.HierarchyView.3
 * JD-Core Version:    0.7.0.1
 */