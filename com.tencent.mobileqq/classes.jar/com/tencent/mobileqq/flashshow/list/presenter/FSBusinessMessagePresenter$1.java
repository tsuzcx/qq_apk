package com.tencent.mobileqq.flashshow.list.presenter;

import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;

class FSBusinessMessagePresenter$1
  extends QCirclePicStateListener
{
  FSBusinessMessagePresenter$1(FSBusinessMessagePresenter paramFSBusinessMessagePresenter) {}
  
  public void onStateChang(int paramInt, Option paramOption)
  {
    super.onStateChang(paramInt, paramOption);
    paramOption = new StringBuilder();
    paramOption.append("state callback:");
    paramOption.append(paramInt);
    QLog.d("FSBusinessMessagePresenter", 4, paramOption.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.presenter.FSBusinessMessagePresenter.1
 * JD-Core Version:    0.7.0.1
 */