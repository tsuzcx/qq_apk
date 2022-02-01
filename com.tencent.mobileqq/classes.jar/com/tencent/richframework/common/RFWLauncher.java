package com.tencent.richframework.common;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.richframework.common.fragment.RFWChangeMsfServerFragment;

public class RFWLauncher
{
  public static void a(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, CompatPublicActivity.class);
    localIntent.putExtra("public_fragment_class", RFWChangeMsfServerFragment.class.getCanonicalName());
    localIntent.putExtra("public_fragment_window_feature", 1);
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.common.RFWLauncher
 * JD-Core Version:    0.7.0.1
 */