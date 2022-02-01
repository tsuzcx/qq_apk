package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.PopupWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

final class KeyBoardUtil$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  KeyBoardUtil$1(ApolloRender paramApolloRender, View paramView) {}
  
  public void onGlobalLayout()
  {
    if ((this.a.mEditWindow != null) && (this.a.mShowEditWindow))
    {
      Object localObject = new Rect();
      this.b.getWindowVisibleDisplayFrame((Rect)localObject);
      int i = (int)DeviceInfoUtil.G();
      int j = ((Rect)localObject).bottom;
      int k = ((Rect)localObject).top;
      ImmersiveUtils.getStatusBarHeight(this.b.getContext());
      if (i - (j - k) < 200)
      {
        if (KeyBoardUtil.b)
        {
          this.a.mEditWindow.dismiss();
          KeyBoardUtil.a = true;
        }
      }
      else
      {
        i = ((Rect)localObject).bottom - this.a.mEditWindow.getHeight();
        localObject = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0);
        j = ((SharedPreferences)localObject).getInt("sp_key_apollo_keyboard_height", 0);
        if ((this.b.getContext() instanceof Activity))
        {
          if (((Activity)this.b.getContext()).isFinishing())
          {
            QLog.e("[cmshow]KeyBoardUtil", 1, "showKeyBorad activity is isFinishing");
            return;
          }
          if ((Build.VERSION.SDK_INT >= 17) && (((Activity)this.b.getContext()).isDestroyed()))
          {
            QLog.e("[cmshow]KeyBoardUtil", 1, "showKeyBorad activity is destroy");
            return;
          }
        }
        if (j != i) {}
        try
        {
          ((SharedPreferences)localObject).edit().putInt("sp_key_apollo_keyboard_height", i).commit();
          this.a.mEditWindow.showAtLocation(this.b.getRootView(), 0, 0, i);
          this.a.mEditWindow.update(0, i, this.a.mEditWindow.getWidth(), this.a.mEditWindow.getHeight());
          KeyBoardUtil.a = false;
          if (KeyBoardUtil.a)
          {
            this.a.mEditWindow.showAtLocation(this.b.getRootView(), 0, 0, i);
            this.a.mEditWindow.update(0, i, this.a.mEditWindow.getWidth(), this.a.mEditWindow.getHeight());
            KeyBoardUtil.a = false;
          }
        }
        catch (Exception localException)
        {
          QLog.e("[cmshow]KeyBoardUtil", 1, localException, new Object[0]);
        }
        KeyBoardUtil.b = true;
      }
      return;
    }
    QLog.e("rogersxiao", 2, "render.mEditWindow return");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.KeyBoardUtil.1
 * JD-Core Version:    0.7.0.1
 */