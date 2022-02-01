package com.tencent.mobileqq.wink.view;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask.Status;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTaskHelper;

class WinkMaterialPanelContentAdapter$2
  implements Runnable
{
  WinkMaterialPanelContentAdapter$2(WinkMaterialPanelContentAdapter paramWinkMaterialPanelContentAdapter, ApplyMaterialTask.Status paramStatus1, int paramInt, MetaMaterial paramMetaMaterial, ApplyMaterialTask.Status paramStatus2) {}
  
  public void run()
  {
    if (this.a == ApplyMaterialTask.Status.FAILED)
    {
      WinkMaterialPanelContentAdapter.a(this.this$0, this.b, this.c);
      return;
    }
    int i = WinkMaterialPanelContentAdapter.3.a[this.d.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      WinkMaterialPanelContentAdapter.a(this.this$0, this.b, this.c);
      return;
    }
    if (WinkMaterialPanelContentAdapter.a(this.this$0) == this.b)
    {
      ApplyMaterialTaskHelper.a("onApplyMaterialLocal", this.c, "start");
      this.this$0.a(this.b, true);
      WinkMaterialPanelContentAdapter.b(this.this$0).d(this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.view.WinkMaterialPanelContentAdapter.2
 * JD-Core Version:    0.7.0.1
 */