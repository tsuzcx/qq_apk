package com.tencent.mobileqq.shortvideo.panoramicvideo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class GroupRenderObj$4
  implements Runnable
{
  GroupRenderObj$4(GroupRenderObj paramGroupRenderObj, BaseRenderObj paramBaseRenderObj, int paramInt) {}
  
  public void run()
  {
    this.val$filter.init();
    Object localObject = new ArrayList();
    int i = 0;
    BaseRenderObj localBaseRenderObj;
    while (i < this.this$0.renderObjLists.size())
    {
      localBaseRenderObj = (BaseRenderObj)this.this$0.renderObjLists.get(i);
      if (i == this.val$pos)
      {
        ((List)localObject).add(this.val$filter);
        localBaseRenderObj.destroy();
      }
      else
      {
        ((List)localObject).add(localBaseRenderObj);
      }
      i += 1;
    }
    this.this$0.renderObjLists.clear();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      localBaseRenderObj = (BaseRenderObj)((Iterator)localObject).next();
      this.this$0.renderObjLists.add(localBaseRenderObj);
    }
    localObject = this.this$0;
    ((GroupRenderObj)localObject).onRenderObjChanged(((GroupRenderObj)localObject).surfaceWidth, this.this$0.surfaceHeight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.panoramicvideo.GroupRenderObj.4
 * JD-Core Version:    0.7.0.1
 */