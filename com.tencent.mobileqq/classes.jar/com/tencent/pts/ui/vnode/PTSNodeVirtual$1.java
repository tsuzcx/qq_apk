package com.tencent.pts.ui.vnode;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.pts.bridge.PTSJSBridge;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.utils.PTSLog;

class PTSNodeVirtual$1
  implements View.OnClickListener
{
  PTSNodeVirtual$1(PTSNodeVirtual paramPTSNodeVirtual, Object paramObject) {}
  
  public void onClick(View paramView)
  {
    if (((this.val$statement instanceof String)) && (PTSNodeVirtual.access$000(this.this$0) != null)) {
      paramView = PTSNodeVirtual.access$000(this.this$0).getUniqueID();
    }
    try
    {
      int i = Integer.valueOf(paramView).intValue();
      PTSNodeVirtual.access$100(this.this$0).getJSBridge().callJSEventFunction((String)this.val$statement, i, "tap", PTSNodeVirtual.access$100(this.this$0));
      return;
    }
    catch (NumberFormatException paramView)
    {
      PTSLog.e(this.this$0.TAG, "[bindTapEvent], e = " + paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.ui.vnode.PTSNodeVirtual.1
 * JD-Core Version:    0.7.0.1
 */