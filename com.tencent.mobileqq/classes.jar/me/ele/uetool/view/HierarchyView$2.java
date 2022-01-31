package me.ele.uetool.view;

import java.util.List;
import me.ele.uetool.recyclerview.BaseItem;
import me.ele.uetool.recyclerview.HierarchyItem;
import me.ele.uetool.recyclerview.UniversalAdapter.OnItemClickListener;

class HierarchyView$2
  implements UniversalAdapter.OnItemClickListener
{
  HierarchyView$2(HierarchyView paramHierarchyView) {}
  
  public void onItemClick(int paramInt, BaseItem paramBaseItem)
  {
    paramBaseItem = (HierarchyItem)paramBaseItem;
    List localList;
    if ((paramBaseItem.isGroup()) && (paramBaseItem.getChildCount() > 0))
    {
      if (paramBaseItem.isExpand) {
        break label47;
      }
      localList = paramBaseItem.assembleChildren();
      HierarchyView.access$000(this.this$0, localList, paramInt + 1);
    }
    for (;;)
    {
      paramBaseItem.toggleIcon();
      return;
      label47:
      localList = HierarchyView.access$100(this.this$0, paramBaseItem, paramInt + 1);
      HierarchyView.access$200(this.this$0, localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.view.HierarchyView.2
 * JD-Core Version:    0.7.0.1
 */