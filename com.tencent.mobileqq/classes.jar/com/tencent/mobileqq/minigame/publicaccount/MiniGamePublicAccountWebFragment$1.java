package com.tencent.mobileqq.minigame.publicaccount;

import androidx.fragment.app.FragmentActivity;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class MiniGamePublicAccountWebFragment$1
  implements EIPCResultCallback
{
  MiniGamePublicAccountWebFragment$1(MiniGamePublicAccountWebFragment paramMiniGamePublicAccountWebFragment) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    this.this$0.getActivity().runOnUiThread(new MiniGamePublicAccountWebFragment.1.1(this, paramEIPCResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.1
 * JD-Core Version:    0.7.0.1
 */