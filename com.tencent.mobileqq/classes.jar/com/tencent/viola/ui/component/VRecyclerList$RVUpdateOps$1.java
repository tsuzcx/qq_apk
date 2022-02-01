package com.tencent.viola.ui.component;

import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.view.list.VRecyclerView;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.Iterator;
import java.util.List;

class VRecyclerList$RVUpdateOps$1
  implements Runnable
{
  VRecyclerList$RVUpdateOps$1(VRecyclerList.RVUpdateOps paramRVUpdateOps) {}
  
  public void run()
  {
    int i = VRecyclerList.RVUpdateOps.access$300(this.this$1);
    Object localObject1 = this.this$1;
    boolean bool2 = true;
    boolean bool1;
    if (i > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localObject1 = VRecyclerList.RVUpdateOps.access$400((VRecyclerList.RVUpdateOps)localObject1, bool1);
    Object localObject2 = VRecyclerList.RVUpdateOps.access$500(this.this$1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      VRecyclerList.UpdateOp localUpdateOp = (VRecyclerList.UpdateOp)((Iterator)localObject2).next();
      VRecyclerList.RVUpdateOps.access$600(this.this$1, localUpdateOp);
    }
    VRecyclerList.RVUpdateOps.access$500(this.this$1).clear();
    int j = VRecyclerList.RVUpdateOps.access$700(this.this$1, (DomObject)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("handleBatch keepPosition=");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append(", dom is null?=");
    if (localObject1 == null) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    ((StringBuilder)localObject2).append(bool1);
    ((StringBuilder)localObject2).append(", position=");
    ((StringBuilder)localObject2).append(j);
    ViolaLogUtils.d("VRecyclerList", ((StringBuilder)localObject2).toString());
    if ((i > 0) && (j >= 0)) {
      ((VRecyclerView)this.this$1.this$0.getHostView()).scrollToPosition(j);
    }
    if (localObject1 != null) {
      ((DomObject)localObject1).getAttributes().remove("keepTop");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.component.VRecyclerList.RVUpdateOps.1
 * JD-Core Version:    0.7.0.1
 */