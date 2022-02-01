package com.tencent.mobileqq.troop.homework.api.impl;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi;
import com.tencent.mobileqq.troop.homework.entry.ui.EntryDebugFragment;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;

public class HWTroopUIApiImpl
  implements IHWTroopUIApi
{
  public void startEntryDebugFragment(Activity paramActivity, Bundle paramBundle)
  {
    EntryDebugFragment.a(paramActivity, paramBundle);
  }
  
  public void startPublishHomeWorkFragment(Activity paramActivity, @Nullable Bundle paramBundle, @Nullable String paramString)
  {
    PublishHomeWorkFragment.a(paramActivity, paramBundle, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.api.impl.HWTroopUIApiImpl
 * JD-Core Version:    0.7.0.1
 */