package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;

final class QQFileManagerUtilImpl$17
  implements Runnable
{
  QQFileManagerUtilImpl$17(Context paramContext, int paramInt, String paramString1, BaseQQAppInterface paramBaseQQAppInterface, String paramString2) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
      BitmapFactory.decodeResource(this.a.getResources(), this.b, (BitmapFactory.Options)localObject1);
      ((BitmapFactory.Options)localObject1).inSampleSize = 1;
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
      Object localObject2 = BitmapFactory.decodeResource(this.a.getResources(), this.b, (BitmapFactory.Options)localObject1);
      if (localObject2 == null) {
        return;
      }
      int i = DisplayUtils.a(this.a);
      localObject1 = localObject2;
      if (((Bitmap)localObject2).getWidth() != i) {
        if (!MobileIssueSettings.c) {
          localObject1 = KapalaiAdapterUtil.a().a((Bitmap)localObject2, i);
        } else {
          localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject2, i, i, false);
        }
      }
      if (Build.VERSION.SDK_INT < 26)
      {
        localObject2 = new Intent("android.intent.action.MAIN");
        ((Intent)localObject2).addCategory("android.intent.category.LAUNCHER");
        ((Intent)localObject2).putExtra(this.c, true);
        ((Intent)localObject2).setClassName(this.a, ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getJumpActivityName());
        ((Intent)localObject2).setFlags(337641472);
        ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).createShortcut(this.d, (Intent)localObject2, this.e, (Bitmap)localObject1);
        return;
      }
      QQFileManagerUtilImpl.a(this.a, this.c, this.e, this.b);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.17
 * JD-Core Version:    0.7.0.1
 */