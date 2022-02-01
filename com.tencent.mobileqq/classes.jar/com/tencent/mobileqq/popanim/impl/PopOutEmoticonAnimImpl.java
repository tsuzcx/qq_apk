package com.tencent.mobileqq.popanim.impl;

import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.popanim.IPopOutEmoticonAnim;
import com.tencent.mobileqq.popanim.PopOutAnimConfig;
import com.tencent.mobileqq.popanim.PopOutAnimViewHolder;
import com.tencent.mobileqq.popanim.PopOutEmoticonReceive;
import mqq.os.MqqHandler;

public class PopOutEmoticonAnimImpl
  implements IPopOutEmoticonAnim
{
  public void playPopEmoAnimation(ViewGroup paramViewGroup, PopOutAnimConfig paramPopOutAnimConfig, int paramInt1, int paramInt2)
  {
    paramViewGroup = new PopOutEmoticonReceive(paramViewGroup, paramPopOutAnimConfig, paramInt1, paramInt2);
    ThreadManager.getUIHandler().post(paramViewGroup);
  }
  
  public void stopAndCleanPopOutAnim()
  {
    PopOutAnimViewHolder.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.impl.PopOutEmoticonAnimImpl
 * JD-Core Version:    0.7.0.1
 */