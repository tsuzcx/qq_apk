package com.tencent.mobileqq.multiaio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Vibrator;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.multiaio.model.MultiAIOManager;
import com.tencent.mobileqq.multiaio.presenter.MultiAioContext;
import com.tencent.mobileqq.multiaio.utils.GC;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import mqq.app.AppRuntime;

public class MultiAIOStarter
{
  public static boolean a = false;
  
  public static int a(Context paramContext)
  {
    if ((paramContext instanceof Activity))
    {
      paramContext = ((Activity)paramContext).findViewById(16908290);
      if (paramContext != null) {
        return paramContext.getHeight();
      }
    }
    return 0;
  }
  
  public static Bitmap a(Context paramContext)
  {
    View localView;
    int i;
    int j;
    if ((paramContext instanceof BaseActivity))
    {
      localView = ((BaseActivity)paramContext).getWindow().getDecorView();
      i = localView.getWidth();
      j = localView.getHeight();
    }
    for (;;)
    {
      try
      {
        localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        Canvas localCanvas;
        QLog.e("MultiAIOStarter", 1, "getDecorViewBitmap: ", localThrowable1);
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          localBitmap.setDensity(paramContext.getResources().getDisplayMetrics().densityDpi);
          localCanvas = new Canvas(localBitmap);
          localView.draw(localCanvas);
          localCanvas.setBitmap(null);
          if (QLog.isColorLevel()) {
            QLog.d("MultiAIOStarter", 2, "getDecorViewBitmap() called with: context = [" + paramContext + "], bitmap = " + localBitmap);
          }
          return localBitmap;
        }
        catch (Throwable localThrowable2)
        {
          break label123;
        }
        localThrowable1 = localThrowable1;
        localBitmap = null;
      }
      label123:
      GC.a();
      continue;
      Bitmap localBitmap = null;
    }
  }
  
  public static void a(int paramInt)
  {
    try
    {
      ((Vibrator)BaseApplicationImpl.getApplication().getApplicationContext().getSystemService("vibrator")).vibrate(paramInt);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MultiAIOStarter", 2, "vibratorExecute Vibrator exception.");
      localException.printStackTrace();
    }
  }
  
  private static void a(BaseActivity paramBaseActivity, MultiAioContext paramMultiAioContext)
  {
    ThreadManagerV2.postImmediately(new MultiAIOStarter.2(paramBaseActivity, paramMultiAioContext), null, false);
  }
  
  public static boolean a(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOStarter", 2, "MultiAIOStarter start curType = " + paramInt + " from = " + paramString3 + ", hasOpened = " + a);
    }
    if (!MultiAIOHelper.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOStarter", 2, "MultiAIOStarter start is forbid: local switch is closed! do not start multiAIO!");
      }
      return false;
    }
    if (!((MultiAIOManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.AIO_MULTI_WINDOW_MANAGER)).a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOStarter", 2, "MultiAIOStarter start error: 配置下发限制 do not start multiAIO!");
      }
      return false;
    }
    if (AppSetting.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOStarter", 2, "MultiAIOStarter start error: 无障碍 mode do not start multiAIO!");
      }
      return false;
    }
    if (((paramContext instanceof BaseActivity)) && (((BaseActivity)paramContext).isInMultiWindow()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOStarter", 2, "MultiAIOStarter start error: 分屏 mode do not start multiAIO!");
      }
      return false;
    }
    if (a) {
      return true;
    }
    if (MultiAIOHelper.a(paramInt))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("uintype", paramInt);
      localIntent.putExtra("uinname", paramString2);
      localIntent.putExtra("conversation_tab_flag", paramString3);
      localIntent.putExtra("public_fragment_window_feature", 1);
      localIntent.putExtra("OPEN_MULTI_FROM_ACTIVITY", paramContext.getClass().getSimpleName());
      MultiAIOHelper.a();
      QQAppInterface localQQAppInterface = ((BaseActivity)paramContext).app;
      MultiAioContext localMultiAioContext = MultiAioContext.a(localQQAppInterface);
      Bitmap localBitmap = a(paramContext);
      int i = a(paramContext);
      a = true;
      localMultiAioContext.a(localBitmap);
      localMultiAioContext.a(i);
      a((BaseActivity)paramContext, localMultiAioContext);
      localMultiAioContext.a((QQAppInterface)localQQAppInterface, (FragmentActivity)paramContext, paramString3, paramInt, paramString1, paramString2);
      localMultiAioContext.a(new MultiAIOStarter.1(paramContext));
      localIntent.putExtra("OPEN_MULTI_AIO_CONTEXT", localMultiAioContext.a());
      if ("open_from_aio".equals(paramString3)) {
        localIntent.putExtra("OPEN_MULTI_AIO_LIST_VIEW_SPECIFY_BOTTOM", a(paramContext));
      }
      PublicFragmentActivity.Launcher.a(paramContext, localIntent, PublicTransFragmentActivity.class, MultiAIOFragment.class);
      return true;
    }
    return false;
  }
  
  private static int[] a(Context paramContext)
  {
    int[] arrayOfInt = new int[2];
    int j;
    int i;
    View localView;
    if ((paramContext instanceof BaseActivity))
    {
      paramContext = (ListView)((BaseActivity)paramContext).findViewById(2131370460);
      if (paramContext != null)
      {
        j = paramContext.getBottom() - paramContext.getPaddingBottom();
        i = paramContext.getChildCount();
        if (i < 0) {
          break label145;
        }
        localView = paramContext.getChildAt(i);
        if ((localView == null) || (j <= localView.getTop()) || (j > localView.getBottom())) {
          break label138;
        }
      }
    }
    for (;;)
    {
      j = i;
      if (i == -1) {
        j = paramContext.getChildCount() - 1;
      }
      if (j != -1)
      {
        arrayOfInt[0] = (paramContext.getFirstVisiblePosition() + j);
        localView = paramContext.getChildAt(j);
        if (localView != null) {
          arrayOfInt[1] = (paramContext.getBottom() - paramContext.getPaddingBottom() - localView.getBottom());
        }
      }
      return arrayOfInt;
      label138:
      i -= 1;
      break;
      label145:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOStarter
 * JD-Core Version:    0.7.0.1
 */