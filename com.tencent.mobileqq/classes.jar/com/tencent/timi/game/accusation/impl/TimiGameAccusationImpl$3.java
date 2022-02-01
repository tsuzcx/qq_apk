package com.tencent.timi.game.accusation.impl;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.base.ui.LoadingUtils;
import com.tencent.timi.game.ui.widget.EmptyDialog;
import mqq.util.WeakReference;

final class TimiGameAccusationImpl$3
  implements Runnable
{
  TimiGameAccusationImpl$3(QBaseActivity paramQBaseActivity) {}
  
  public void run()
  {
    EmptyDialog localEmptyDialog = new EmptyDialog(this.a);
    TimiGameAccusationImpl.a(new WeakReference(localEmptyDialog));
    QLog.d("TimiGameAccusationImpl", 4, "start to show Dialog ");
    localEmptyDialog.show();
    LoadingUtils.a.a(localEmptyDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.accusation.impl.TimiGameAccusationImpl.3
 * JD-Core Version:    0.7.0.1
 */