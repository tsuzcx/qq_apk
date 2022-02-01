package com.tencent.mobileqq.qqexpand.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.qqexpand.widget.PhotoWallListView.PhotoPath;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

class ExtendFriendNewEditFragment$15
  implements Runnable
{
  ExtendFriendNewEditFragment$15(ExtendFriendNewEditFragment paramExtendFriendNewEditFragment) {}
  
  public void run()
  {
    Bitmap localBitmap2 = null;
    Bitmap localBitmap1 = localBitmap2;
    try
    {
      Object localObject = new File(ExtendFriendNewEditFragment.g(this.this$0).b);
      localBitmap1 = localBitmap2;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localBitmap1 = localBitmap2;
      localObject = new BufferedInputStream(new FileInputStream((File)localObject));
      localBitmap1 = localBitmap2;
      localOptions.inSampleSize = ((int)ImageUtil.a((InputStream)localObject, ExtendFriendNewEditFragment.t(this.this$0).getWidth(), ExtendFriendNewEditFragment.t(this.this$0).getHeight()));
      localBitmap1 = localBitmap2;
      ((BufferedInputStream)localObject).close();
      localBitmap1 = localBitmap2;
      localBitmap2 = BitmapManager.a(ExtendFriendNewEditFragment.g(this.this$0).b, localOptions);
      localBitmap1 = localBitmap2;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        localBitmap2 = QQAppInterface.getCircleFaceBitmap(localBitmap2, localBitmap2.getWidth(), localBitmap2.getHeight());
        localBitmap1 = localBitmap2;
      }
    }
    catch (Exception localException)
    {
      QLog.d("ExtendFriendNewEditFragment", 1, localException.toString());
    }
    if (localBitmap1 != null) {
      UiThreadUtil.a(new ExtendFriendNewEditFragment.15.1(this, localBitmap1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendNewEditFragment.15
 * JD-Core Version:    0.7.0.1
 */