package com.tencent.tbs.one.impl.debug;

import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.optional.TBSOneDebugPlugin;

class DebugPanelView$1
  extends TBSOneCallback<TBSOneDebugPlugin>
{
  DebugPanelView$1(DebugPanelView paramDebugPanelView) {}
  
  public void onCompleted(TBSOneDebugPlugin paramTBSOneDebugPlugin)
  {
    DebugPanelView.access$100(this.this$0, new DebugPanelView.1.2(this, paramTBSOneDebugPlugin));
  }
  
  public void onError(int paramInt, String paramString)
  {
    DebugPanelView.access$100(this.this$0, new DebugPanelView.1.3(this));
  }
  
  public void onProgressChanged(int paramInt1, int paramInt2)
  {
    DebugPanelView.access$100(this.this$0, new DebugPanelView.1.1(this, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.debug.DebugPanelView.1
 * JD-Core Version:    0.7.0.1
 */