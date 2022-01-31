package com.tencent.mobileqq.tribe.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import bace;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

class TribeVideoPreviewFragment$3
  implements Runnable
{
  TribeVideoPreviewFragment$3(TribeVideoPreviewFragment paramTribeVideoPreviewFragment, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = new File(this.a);
      Object localObject2 = Environment.getExternalStorageDirectory() + "/tencent/QQfile_recv/" + ((File)localObject1).getName();
      localObject1 = localObject2;
      if (((String)localObject2).endsWith("mp4.tmp.mp4")) {
        localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 11) + "_" + System.currentTimeMillis() + ".mp4";
      }
      bace.d(this.a, (String)localObject1);
      localObject2 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      ((Intent)localObject2).setData(Uri.parse("file://" + (String)localObject1));
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject2);
      this.this$0.getActivity().runOnUiThread(new TribeVideoPreviewFragment.3.1(this));
      return;
    }
    catch (Exception localException)
    {
      this.this$0.getActivity().runOnUiThread(new TribeVideoPreviewFragment.3.2(this));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      this.this$0.getActivity().runOnUiThread(new TribeVideoPreviewFragment.3.3(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoPreviewFragment.3
 * JD-Core Version:    0.7.0.1
 */