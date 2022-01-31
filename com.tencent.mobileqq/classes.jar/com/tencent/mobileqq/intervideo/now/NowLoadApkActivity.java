package com.tencent.mobileqq.intervideo.now;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.sixgod.pluginsdk.component.SixGodPreLoadActivity;

public class NowLoadApkActivity
  extends SixGodPreLoadActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    paramBundle = getWindow();
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.flags |= 0x10;
    localLayoutParams.flags |= 0x8;
    localLayoutParams.flags |= 0x80;
    paramBundle.addFlags(16);
    paramBundle.addFlags(8);
    localLayoutParams.alpha = 0.0F;
    paramBundle.setAttributes(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.NowLoadApkActivity
 * JD-Core Version:    0.7.0.1
 */