package com.tencent.mobileqq.flashshow.part;

import android.content.Context;
import com.tencent.mobileqq.flashshow.bean.FSShareInfo;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper.HostEnvironmentLifeCycle;
import com.tencent.widget.ActionSheet;

class FSDebugPart$2
  extends HostUIHelper.HostEnvironmentLifeCycle
{
  FSDebugPart$2(FSDebugPart paramFSDebugPart, FSShareInfo paramFSShareInfo) {}
  
  public void onEnvironmentCreated(Context paramContext)
  {
    super.onEnvironmentCreated(paramContext);
    paramContext = ActionSheet.create(paramContext);
    FSDebugPart.a(this.b, paramContext, this.a);
    paramContext.addButton(this.b.g().getString(2131889704));
    FSDebugPart.a(this.b, paramContext);
    paramContext.addButton(this.b.g().getString(2131887648));
    paramContext.setOnButtonClickListener(new FSDebugPart.2.1(this, paramContext));
    paramContext.setOnDismissListener(new FSDebugPart.2.2(this, paramContext));
    paramContext.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSDebugPart.2
 * JD-Core Version:    0.7.0.1
 */