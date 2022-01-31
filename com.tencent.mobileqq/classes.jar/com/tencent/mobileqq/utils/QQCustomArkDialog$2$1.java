package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.graphics.Color;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import baes;
import baeu;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class QQCustomArkDialog$2$1
  implements Runnable
{
  public QQCustomArkDialog$2$1(baeu parambaeu, int paramInt) {}
  
  public void run()
  {
    Object localObject;
    if (baes.a(this.jdField_a_of_type_Baeu.a) != null) {
      localObject = (Activity)baes.a(this.jdField_a_of_type_Baeu.a).get();
    }
    while ((localObject != null) && (!((Activity)localObject).isFinishing())) {
      if (this.jdField_a_of_type_Int != 1)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Baeu.a.a.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(14);
        ((RelativeLayout.LayoutParams)localObject).width = this.jdField_a_of_type_Baeu.a.d;
        ((RelativeLayout.LayoutParams)localObject).height = this.jdField_a_of_type_Baeu.a.d;
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
        this.jdField_a_of_type_Baeu.a.rBtn.setEnabled(false);
        this.jdField_a_of_type_Baeu.a.rBtn.setTextColor(Color.parseColor("#656565"));
        return;
        localObject = null;
      }
      else
      {
        this.jdField_a_of_type_Baeu.a.rBtn.setEnabled(true);
        return;
      }
    }
    QLog.d("QQCustomArkDialog", 1, "onLoadFinish.right now activity is null or finished");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialog.2.1
 * JD-Core Version:    0.7.0.1
 */