package com.tencent.mobileqq.tribe.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import bbdj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

class TribeVideoPreviewFragment$4
  implements Runnable
{
  TribeVideoPreviewFragment$4(TribeVideoPreviewFragment paramTribeVideoPreviewFragment, String paramString) {}
  
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
      bbdj.d(this.a, (String)localObject1);
      localObject2 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      ((Intent)localObject2).setData(Uri.parse("file://" + (String)localObject1));
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject2);
      TribeVideoPreviewFragment.a(this.this$0, true);
      return;
    }
    catch (Exception localException)
    {
      TribeVideoPreviewFragment.a(this.this$0, false);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      TribeVideoPreviewFragment.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoPreviewFragment.4
 * JD-Core Version:    0.7.0.1
 */