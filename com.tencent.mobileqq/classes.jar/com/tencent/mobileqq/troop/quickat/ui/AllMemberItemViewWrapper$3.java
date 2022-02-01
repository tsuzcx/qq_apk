package com.tencent.mobileqq.troop.quickat.ui;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.observer.TroopMessageObserver;

class AllMemberItemViewWrapper$3
  extends TroopMessageObserver
{
  AllMemberItemViewWrapper$3(AllMemberItemViewWrapper paramAllMemberItemViewWrapper) {}
  
  protected void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, boolean paramBoolean3)
  {
    ThreadManager.getUIHandlerV2().post(new AllMemberItemViewWrapper.3.1(this, paramBoolean1, paramString1, paramBoolean2, paramString2, paramString3, paramBoolean3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AllMemberItemViewWrapper.3
 * JD-Core Version:    0.7.0.1
 */