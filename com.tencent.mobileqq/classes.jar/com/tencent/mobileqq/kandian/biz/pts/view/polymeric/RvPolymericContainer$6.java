package com.tencent.mobileqq.kandian.biz.pts.view.polymeric;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper.RecycleViewAdapterHelper;
import org.json.JSONArray;

class RvPolymericContainer$6
  implements Runnable
{
  RvPolymericContainer$6(RvPolymericContainer paramRvPolymericContainer, JSONArray paramJSONArray) {}
  
  public void run()
  {
    RvPolymericContainer.f(this.this$0).setCellArray(RvPolymericContainer.g(this.this$0).getTemplateFactory(), this.a);
    RvPolymericContainer.f(this.this$0).notifyDataSetChanged();
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.polymeric.RvPolymericContainer.6
 * JD-Core Version:    0.7.0.1
 */