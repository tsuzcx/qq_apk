package com.tencent.mobileqq.shortvideo.panoramicvideo;

import java.util.Iterator;
import java.util.List;

class GroupRenderObj$2
  implements Runnable
{
  GroupRenderObj$2(GroupRenderObj paramGroupRenderObj, List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.val$renderObjList.iterator();
    while (localIterator.hasNext())
    {
      BaseRenderObj localBaseRenderObj = (BaseRenderObj)localIterator.next();
      localBaseRenderObj.init();
      this.this$0.renderObjLists.add(localBaseRenderObj);
    }
    this.this$0.onRenderObjChanged(this.this$0.surfaceWidth, this.this$0.surfaceHeight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.panoramicvideo.GroupRenderObj.2
 * JD-Core Version:    0.7.0.1
 */