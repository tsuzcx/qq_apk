package com.tencent.mobileqq.shortvideo.panoramicvideo;

import java.util.List;

class GroupRenderObj$1
  implements Runnable
{
  GroupRenderObj$1(GroupRenderObj paramGroupRenderObj, BaseRenderObj paramBaseRenderObj) {}
  
  public void run()
  {
    this.val$renderObj.init();
    this.this$0.renderObjLists.add(this.val$renderObj);
    this.this$0.onRenderObjChanged(this.this$0.surfaceWidth, this.this$0.surfaceHeight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.panoramicvideo.GroupRenderObj.1
 * JD-Core Version:    0.7.0.1
 */