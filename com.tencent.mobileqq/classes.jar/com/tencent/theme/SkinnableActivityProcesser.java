package com.tencent.theme;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.lang.reflect.Field;

public class SkinnableActivityProcesser
  extends BroadcastReceiver
{
  public static final String TAG = "[SkinnableActivityProcesser]";
  private final Activity a;
  private final SkinnableActivityProcesser.Callback b;
  
  public SkinnableActivityProcesser(Activity paramActivity, SkinnableActivityProcesser.Callback paramCallback)
  {
    this.a = paramActivity;
    this.b = paramCallback;
    try
    {
      this.a.registerReceiver(this, new IntentFilter("com.tencent.qplus.THEME_INVALIDATE"), "com.tencent.msg.permission.pushnotify", null);
      return;
    }
    catch (Exception paramActivity) {}
  }
  
  static boolean a(Drawable paramDrawable)
  {
    if (!(paramDrawable instanceof DrawableContainer)) {
      return false;
    }
    paramDrawable = (DrawableContainer.DrawableContainerState)paramDrawable.getConstantState();
    Object localObject;
    boolean bool2;
    if (paramDrawable != null)
    {
      localObject = paramDrawable.getChildren();
      int j = paramDrawable.getChildCount();
      int i = 0;
      bool2 = false;
      if (i < j)
      {
        Drawable localDrawable = localObject[i];
        boolean bool1;
        if ((localDrawable instanceof SkinnableNinePatchDrawable)) {
          bool1 = true;
        }
        for (;;)
        {
          i += 1;
          bool2 = bool1;
          break;
          bool1 = bool2;
          if ((localDrawable instanceof DrawableContainer)) {
            bool1 = bool2 | a(localDrawable);
          }
        }
      }
    }
    try
    {
      localObject = DrawableContainer.DrawableContainerState.class.getDeclaredField("mComputedConstantSize");
      ((Field)localObject).setAccessible(true);
      ((Field)localObject).setBoolean(paramDrawable, false);
      label111:
      if (bool2) {
        try
        {
          localObject = DrawableContainer.DrawableContainerState.class.getDeclaredField("mPaddingChecked");
          ((Field)localObject).setAccessible(true);
          ((Field)localObject).setBoolean(paramDrawable, false);
          localObject = DrawableContainer.DrawableContainerState.class.getDeclaredField("mConstantPadding");
          ((Field)localObject).setAccessible(true);
          ((Field)localObject).set(paramDrawable, null);
          return true;
        }
        catch (Exception paramDrawable)
        {
          return true;
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      break label111;
    }
  }
  
  public void destory()
  {
    try
    {
      this.a.unregisterReceiver(this);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    j = 0;
    if (paramIntent.getIntExtra("pid", Process.myPid()) != Process.myPid()) {}
    View[] arrayOfView;
    for (;;)
    {
      return;
      i.a("SkinEngine", 1, "SkinnableActivityProcesser on pre theme changed");
      if (this.b != null) {
        this.b.onPreThemeChanged();
      }
      try
      {
        paramContext = this.a.getWindow().getDecorView();
        if (paramContext != null)
        {
          paramIntent = (ViewGroup)paramContext;
          arrayOfView = new View[paramIntent.getChildCount()];
          i = 0;
          while (i < paramIntent.getChildCount())
          {
            arrayOfView[i] = paramIntent.getChildAt(i);
            i += 1;
          }
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          paramContext = null;
        }
      }
    }
    try
    {
      paramIntent.removeAllViews();
      i = j;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      try
      {
        for (;;)
        {
          View localView;
          paramIntent.addView(localView);
          i += 1;
        }
        SkinEngine.invalidateAll(paramContext);
        if (this.b == null) {
          break label157;
        }
        this.b.onPostThemeChanged();
        i.a("SkinEngine", 1, "SkinnableActivityProcesser on post theme changed");
        return;
        localIllegalArgumentException = localIllegalArgumentException;
        i = j;
      }
      catch (Exception localException)
      {
        break label130;
      }
    }
    if (i < arrayOfView.length) {
      localView = arrayOfView[i];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.theme.SkinnableActivityProcesser
 * JD-Core Version:    0.7.0.1
 */