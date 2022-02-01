package com.tencent.mobileqq.studymode;

import android.os.Bundle;

final class KidModeObserver$10
  implements KidModeObserver.Handler
{
  public void a(KidModeObserver paramKidModeObserver, boolean paramBoolean, Bundle paramBundle)
  {
    paramKidModeObserver.a((KidModeObserver.ClearPasswordResult)paramBundle.getSerializable("NOTIFY_RESULT_OBJECT"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeObserver.10
 * JD-Core Version:    0.7.0.1
 */