package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.support.v4.app.FragmentActivity;
import bdal;
import bdhj;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

class CreateVirtualAccountFragment$5
  implements Runnable
{
  CreateVirtualAccountFragment$5(CreateVirtualAccountFragment paramCreateVirtualAccountFragment, String paramString) {}
  
  public void run()
  {
    label138:
    do
    {
      for (;;)
      {
        try
        {
          localObject2 = new File(this.a);
          localObject1 = new BitmapFactory.Options();
          localObject2 = new BufferedInputStream(new FileInputStream((File)localObject2));
          ((BitmapFactory.Options)localObject1).inSampleSize = ((int)bdhj.a((InputStream)localObject2, CreateVirtualAccountFragment.a(this.this$0).getWidth(), CreateVirtualAccountFragment.a(this.this$0).getHeight()));
          ((BufferedInputStream)localObject2).close();
          localObject1 = bdal.a(this.a, (BitmapFactory.Options)localObject1);
          localObject2 = localObject1;
          if (localObject1 != null) {}
          localObject2 = localObject1;
        }
        catch (Exception localException1)
        {
          try
          {
            localObject2 = CreateVirtualAccountFragment.a(this.this$0).a((Bitmap)localObject1, CreateVirtualAccountFragment.a(this.this$0).getWidth(), CreateVirtualAccountFragment.a(this.this$0).getWidth());
            if (this.this$0.getActivity() != null) {
              break;
            }
            QLog.e("CreateVirtualAccountFragment", 1, "showAvatar activity is null");
            return;
          }
          catch (Exception localException2)
          {
            Object localObject2;
            Object localObject1;
            break label138;
          }
          localException1 = localException1;
          localObject1 = null;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("AvatarPendantActivity", 2, localException1.toString());
          localObject2 = localObject1;
        }
      }
    } while (localObject2 == null);
    this.this$0.getActivity().runOnUiThread(new CreateVirtualAccountFragment.5.1(this, (Bitmap)localObject2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.CreateVirtualAccountFragment.5
 * JD-Core Version:    0.7.0.1
 */