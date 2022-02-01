package com.tencent.mobileqq.multiaio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Vibrator;
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
    boolean bool = paramContext instanceof BaseActivity;
    Object localObject1 = null;
    Canvas localCanvas = null;
    Object localObject2;
    if (bool)
    {
      View localView = ((BaseActivity)paramContext).getWindow().getDecorView();
      int i = localView.getWidth();
      int j = localView.getHeight();
      try
      {
        localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        try
        {
          ((Bitmap)localObject1).setDensity(paramContext.getResources().getDisplayMetrics().densityDpi);
          localCanvas = new Canvas((Bitmap)localObject1);
          localView.draw(localCanvas);
          localCanvas.setBitmap(null);
        }
        catch (Throwable localThrowable1) {}
        QLog.e("MultiAIOStarter", 1, "getDecorViewBitmap: ", (Throwable)localObject2);
      }
      catch (Throwable localThrowable2)
      {
        localObject1 = localThrowable1;
        localObject2 = localThrowable2;
      }
      GC.a();
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getDecorViewBitmap() called with: context = [");
      ((StringBuilder)localObject2).append(paramContext);
      ((StringBuilder)localObject2).append("], bitmap = ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("MultiAIOStarter", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MultiAIOStarter start curType = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" from = ");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(", hasOpened = ");
      ((StringBuilder)localObject).append(a);
      QLog.d("MultiAIOStarter", 2, ((StringBuilder)localObject).toString());
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
      localObject = new Intent();
      ((Intent)localObject).putExtra("uin", paramString1);
      ((Intent)localObject).putExtra("uintype", paramInt);
      ((Intent)localObject).putExtra("uinname", paramString2);
      ((Intent)localObject).putExtra("conversation_tab_flag", paramString3);
      ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
      ((Intent)localObject).putExtra("OPEN_MULTI_FROM_ACTIVITY", paramContext.getClass().getSimpleName());
      MultiAIOHelper.a();
      BaseActivity localBaseActivity = (BaseActivity)paramContext;
      QQAppInterface localQQAppInterface = localBaseActivity.app;
      MultiAioContext localMultiAioContext = MultiAioContext.a(localQQAppInterface);
      Bitmap localBitmap = a(paramContext);
      int i = a(paramContext);
      a = true;
      localMultiAioContext.a(localBitmap);
      localMultiAioContext.a(i);
      a(localBaseActivity, localMultiAioContext);
      localMultiAioContext.a((QQAppInterface)localQQAppInterface, localBaseActivity, paramString3, paramInt, paramString1, paramString2);
      localMultiAioContext.a(new MultiAIOStarter.1(paramContext));
      ((Intent)localObject).putExtra("OPEN_MULTI_AIO_CONTEXT", localMultiAioContext.a());
      if ("open_from_aio".equals(paramString3)) {
        ((Intent)localObject).putExtra("OPEN_MULTI_AIO_LIST_VIEW_SPECIFY_BOTTOM", a(paramContext));
      }
      PublicFragmentActivity.Launcher.a(paramContext, (Intent)localObject, PublicTransFragmentActivity.class, MultiAIOFragment.class);
      return true;
    }
    return false;
  }
  
  private static int[] a(Context paramContext)
  {
    int[] arrayOfInt = new int[2];
    if ((paramContext instanceof BaseActivity))
    {
      paramContext = (ListView)((BaseActivity)paramContext).findViewById(2131370119);
      if (paramContext != null)
      {
        int j = paramContext.getBottom() - paramContext.getPaddingBottom();
        int i = paramContext.getChildCount();
        View localView;
        while (i >= 0)
        {
          localView = paramContext.getChildAt(i);
          if ((localView != null) && (j > localView.getTop()) && (j <= localView.getBottom())) {
            break label90;
          }
          i -= 1;
        }
        i = -1;
        label90:
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
      }
    }
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOStarter
 * JD-Core Version:    0.7.0.1
 */