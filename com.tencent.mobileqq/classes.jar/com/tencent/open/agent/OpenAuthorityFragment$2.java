package com.tencent.open.agent;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentActivity;
import bfii;
import com.tencent.qphone.base.util.QLog;

class OpenAuthorityFragment$2
  implements Runnable
{
  OpenAuthorityFragment$2(OpenAuthorityFragment paramOpenAuthorityFragment, String paramString) {}
  
  public void run()
  {
    FragmentActivity localFragmentActivity2 = null;
    try
    {
      Bitmap localBitmap1 = BitmapFactory.decodeResource(this.this$0.getResources(), 2130840085);
      localFragmentActivity2 = this.this$0.getActivity();
      if (localFragmentActivity2 != null)
      {
        Bitmap localBitmap2 = bfii.a(localFragmentActivity2, localBitmap1, 63, 63);
        if (localBitmap1 != null) {
          localBitmap1.recycle();
        }
        localFragmentActivity2.runOnUiThread(new OpenAuthorityFragment.2.1(this, localBitmap2));
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        FragmentActivity localFragmentActivity1 = localFragmentActivity2;
        if (QLog.isColorLevel())
        {
          QLog.d("OpenAuthorityFragment", 2, "initUI decodeResource has OutOfMemoryError!");
          localFragmentActivity1 = localFragmentActivity2;
        }
      }
      QLog.e("OpenAuthorityFragment", 1, "showLocalInfo activity is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment.2
 * JD-Core Version:    0.7.0.1
 */