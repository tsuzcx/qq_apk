package com.tencent.mobileqq.shortvideo.panoramicvideo;

import java.util.Iterator;
import java.util.List;

class GroupRenderObj$2
  implements Runnable
{
  GroupRenderObj$2(GroupRenderObj paramGroupRenderObj, List paramList) {}
  
  public void run()
  {
    Object localObject = this.val$renderObjList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      BaseRenderObj localBaseRenderObj = (BaseRenderObj)((Iterator)localObject).next();
      localBaseRenderObj.init();
      this.this$0.renderObjLists.add(localBaseRenderObj);
    }
    localObject = this.this$0;
    ((GroupRenderObj)localObject).onRenderObjChanged(((GroupRenderObj)localObject).surfaceWidth, this.this$0.surfaceHeight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.panoramicvideo.GroupRenderObj.2
 * JD-Core Version:    0.7.0.1
 */