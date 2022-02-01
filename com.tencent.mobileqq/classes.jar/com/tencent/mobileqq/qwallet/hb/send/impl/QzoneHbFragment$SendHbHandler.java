package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.mobileqq.qwallet.hb.send.view.impl.RollNumberView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QzoneHbFragment$SendHbHandler
  extends Handler
{
  WeakReference<QzoneHbFragment> a;
  
  QzoneHbFragment$SendHbHandler(QzoneHbFragment paramQzoneHbFragment)
  {
    this.a = new WeakReference(paramQzoneHbFragment);
  }
  
  public void handleMessage(Message paramMessage)
  {
    QzoneHbFragment localQzoneHbFragment = (QzoneHbFragment)this.a.get();
    if (localQzoneHbFragment == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
    case 101: 
      if (!TextUtils.isEmpty(QzoneHbFragment.c(localQzoneHbFragment)))
      {
        QzoneHbFragment.d(localQzoneHbFragment).setText(QzoneHbFragment.c(localQzoneHbFragment));
        QzoneHbFragment.e(localQzoneHbFragment).setVisibility(8);
        QzoneHbFragment.d(localQzoneHbFragment).setVisibility(0);
        QzoneHbFragment.f(localQzoneHbFragment).setEnabled(true);
        if (QLog.isColorLevel())
        {
          QLog.d("QzoneHbFragment", 2, "MSG_ROLL_STOP AmountBtn.setEnabled(true)---");
          return;
        }
      }
      break;
    case 100: 
      if (QLog.isColorLevel()) {
        QLog.d("QzoneHbFragment", 2, "MSG_UPDATE----1");
      }
      if ((QzoneHbFragment.e(localQzoneHbFragment) != null) && (!TextUtils.isEmpty(QzoneHbFragment.c(localQzoneHbFragment)))) {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("QzoneHbFragment", 2, "MSG_UPDATE----in mModifyAmountBtn.setEnabled(false)");
          }
          double d = Double.parseDouble(QzoneHbFragment.c(localQzoneHbFragment));
          QzoneHbFragment.e(localQzoneHbFragment).b(d);
          QzoneHbFragment.e(localQzoneHbFragment).setVisibility(0);
          QzoneHbFragment.d(localQzoneHbFragment).setVisibility(8);
          QzoneHbFragment.e(localQzoneHbFragment).a();
          QzoneHbFragment.f(localQzoneHbFragment).setEnabled(false);
          return;
        }
        catch (Exception paramMessage)
        {
          paramMessage.printStackTrace();
        }
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.QzoneHbFragment.SendHbHandler
 * JD-Core Version:    0.7.0.1
 */