package com.tencent.mobileqq.relation.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.AgeSelectionActivity;
import com.tencent.mobileqq.relation.api.IAgeSelectionApi;

public class AgeSelectionApiImpl
  implements IAgeSelectionApi
{
  public void startAgeSelectionActivity(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, AgeSelectionActivity.class);
    localIntent.putExtras(paramIntent);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relation.api.impl.AgeSelectionApiImpl
 * JD-Core Version:    0.7.0.1
 */