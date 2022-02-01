package com.tencent.mobileqq.kandian.biz.tab;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.SelectPositionModule;
import com.tencent.qphone.base.util.QLog;

class ReadinjoyTabFrame$23
  implements DialogInterface.OnClickListener
{
  ReadinjoyTabFrame$23(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyTabFrame", 2, "showLocationChangedDialog remain cancel");
    }
    paramDialogInterface = ReadInJoyLogicEngine.a().j();
    if (paramDialogInterface != null) {
      paramDialogInterface.f();
    }
    ReadInJoyLogicEngine.a().b(41695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame.23
 * JD-Core Version:    0.7.0.1
 */