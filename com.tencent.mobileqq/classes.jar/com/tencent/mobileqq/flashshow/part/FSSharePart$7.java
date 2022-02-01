package com.tencent.mobileqq.flashshow.part;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qcircleshadow.lib.variation.HostForwardUtils;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper.HostEnvironmentLifeCycle;
import com.tencent.qphone.base.util.QLog;

class FSSharePart$7
  extends HostUIHelper.HostEnvironmentLifeCycle
{
  FSSharePart$7(FSSharePart paramFSSharePart, Intent paramIntent) {}
  
  public void onEnvironmentCreated(Context paramContext)
  {
    if (FSSharePart.j(this.b) == null)
    {
      QLog.w("FSSharePart", 1, "[openHostEnvironment] host forward api should be not null.");
      return;
    }
    FSSharePart.j(this.b).startForwardActivityForResult(paramContext, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSSharePart.7
 * JD-Core Version:    0.7.0.1
 */