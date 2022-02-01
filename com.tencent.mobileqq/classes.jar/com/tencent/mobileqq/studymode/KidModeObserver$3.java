package com.tencent.mobileqq.studymode;

import android.os.Bundle;

final class KidModeObserver$3
  implements KidModeObserver.Handler
{
  public void a(KidModeObserver paramKidModeObserver, boolean paramBoolean, Bundle paramBundle)
  {
    int i = paramBundle.getInt("advance_setting_field");
    paramBundle.getInt("advance_setting_value");
    paramKidModeObserver.a(paramBoolean, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeObserver.3
 * JD-Core Version:    0.7.0.1
 */