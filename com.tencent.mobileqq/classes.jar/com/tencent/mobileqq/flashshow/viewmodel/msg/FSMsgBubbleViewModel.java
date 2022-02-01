package com.tencent.mobileqq.flashshow.viewmodel.msg;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.flashshow.api.data.FSRedPointData;
import com.tencent.mobileqq.flashshow.thread.FSThreadUtils;

public class FSMsgBubbleViewModel
  extends BaseViewModel
{
  private final MutableLiveData<FSRedPointData> a = new MutableLiveData();
  
  public String a()
  {
    return "FSTabMsgBubbleViewModel";
  }
  
  public MutableLiveData<FSRedPointData> b()
  {
    return this.a;
  }
  
  public void c()
  {
    FSThreadUtils.a(new FSMsgBubbleViewModel.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.msg.FSMsgBubbleViewModel
 * JD-Core Version:    0.7.0.1
 */