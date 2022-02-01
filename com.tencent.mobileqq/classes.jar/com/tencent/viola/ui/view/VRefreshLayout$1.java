package com.tencent.viola.ui.view;

import com.tencent.viola.ui.component.VRefresh;
import com.tencent.viola.ui.dom.DomObject;
import java.util.Iterator;
import java.util.List;
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
    if (VRefreshLayout.access$100(this.this$0) != null)
    {
      localObject = VRefreshLayout.access$100(this.this$0).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VRefreshLayout.OnHeaderStateChangeListener)((Iterator)localObject).next()).onStateEnd();
      }
    }
    Object localObject = new JSONArray();
    if ((this.this$0.getComponent() != null) && (this.this$0.getComponent().getDomObject() != null))
    {
      String str = this.this$0.getComponent().getDomObject().getRef();
      if (str != null) {
        ((JSONArray)localObject).put(str);
      }
      ((JSONArray)localObject).put("idle");
      this.this$0.getComponent().refreshFireEvent("idle", (JSONArray)localObject, VRefreshLayout.access$200(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.view.VRefreshLayout.1
 * JD-Core Version:    0.7.0.1
 */