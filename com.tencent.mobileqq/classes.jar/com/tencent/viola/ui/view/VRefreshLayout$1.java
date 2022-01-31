package com.tencent.viola.ui.view;

import com.tencent.viola.ui.component.VRefresh;
import com.tencent.viola.ui.dom.DomObject;
import org.json.JSONArray;

class VRefreshLayout$1
  implements Runnable
{
  VRefreshLayout$1(VRefreshLayout paramVRefreshLayout) {}
  
  public void run()
  {
    if (VRefreshLayout.access$000(this.this$0) != null) {
      VRefreshLayout.access$000(this.this$0).onStateEnd();
    }
    JSONArray localJSONArray = new JSONArray();
    if ((this.this$0.getComponent() != null) && (this.this$0.getComponent().getDomObject() != null))
    {
      String str = this.this$0.getComponent().getDomObject().getRef();
      if (str != null) {
        localJSONArray.put(str);
      }
      localJSONArray.put("idle");
      this.this$0.getComponent().refreshFireEvent("idle", localJSONArray, VRefreshLayout.access$100(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.VRefreshLayout.1
 * JD-Core Version:    0.7.0.1
 */