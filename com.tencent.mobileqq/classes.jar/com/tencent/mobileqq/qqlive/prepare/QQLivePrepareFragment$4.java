package com.tencent.mobileqq.qqlive.prepare;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import androidx.lifecycle.MutableLiveData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQLivePrepareFragment$4
  implements CompoundButton.OnCheckedChangeListener
{
  QQLivePrepareFragment$4(QQLivePrepareFragment paramQQLivePrepareFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    QQLivePrepareFragment.b(this.a).g.setValue(Boolean.valueOf(paramBoolean));
    ((PrepareDataRepository)QQLivePrepareFragment.b(this.a).v()).a(paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.QQLivePrepareFragment.4
 * JD-Core Version:    0.7.0.1
 */