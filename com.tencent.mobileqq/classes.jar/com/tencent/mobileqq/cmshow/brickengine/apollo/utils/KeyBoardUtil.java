package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.os.MqqHandler;

public class KeyBoardUtil
{
  public static boolean a = false;
  public static boolean b = false;
  
  public static void a(long paramLong)
  {
    ApolloRender localApolloRender = ApolloRender.getCurrentRender();
    localApolloRender.mEditorAddr = paramLong;
    View localView = ApolloRender.getCurrentRenderView();
    if (localView == null) {
      return;
    }
    a = false;
    b = false;
    if (localApolloRender.mEditWindow == null) {
      localView.getViewTreeObserver().addOnGlobalLayoutListener(new KeyBoardUtil.1(localApolloRender, localView));
    }
    ThreadManager.getUIHandler().post(new KeyBoardUtil.2(localApolloRender, localView));
    ThreadManager.getUIHandler().postDelayed(new KeyBoardUtil.3(), 500L);
  }
  
  public static void a(long paramLong, String paramString)
  {
    ApolloRender localApolloRender = ApolloRender.getCurrentRender();
    localApolloRender.mEditorAddr = paramLong;
    if (localApolloRender.mEditWindow == null)
    {
      localApolloRender.mEditorDefaultText = paramString;
      return;
    }
    ThreadManager.getUIHandler().post(new KeyBoardUtil.5(localApolloRender, paramString));
  }
  
  private static void a(ApolloSurfaceView paramApolloSurfaceView, ApolloRender paramApolloRender)
  {
    if (paramApolloRender.mEditorBtn != null) {
      paramApolloRender.mEditorBtn.setOnClickListener(new KeyBoardUtil.8(paramApolloRender, paramApolloSurfaceView));
    }
  }
  
  public static void b(long paramLong)
  {
    ApolloRender localApolloRender = ApolloRender.getCurrentRender();
    localApolloRender.mEditorAddr = paramLong;
    ThreadManager.getUIHandler().post(new KeyBoardUtil.4(localApolloRender));
  }
  
  private static void b(View paramView, ApolloRender paramApolloRender)
  {
    if (paramApolloRender == null) {
      return;
    }
    if (paramApolloRender.mEditWindow == null)
    {
      paramApolloRender.mEditWindow = new PopupWindow(paramView.getContext());
      localObject = (RelativeLayout)LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131558618, null);
      paramApolloRender.mEditWindow.setContentView((View)localObject);
      paramApolloRender.mEditorPop = ((EditText)((RelativeLayout)localObject).findViewById(2131362758));
      ((RelativeLayout)localObject).requestLayout();
      ((RelativeLayout)localObject).post(new KeyBoardUtil.6(paramApolloRender, (RelativeLayout)localObject));
      paramApolloRender.mEditorBtn = ((Button)((RelativeLayout)localObject).findViewById(2131362759));
      paramApolloRender.mEditorBtn.setWidth((int)(DeviceInfoUtil.a * 50.0F));
      paramApolloRender.mEditWindow.setOutsideTouchable(false);
      paramApolloRender.mEditWindow.setFocusable(true);
      if (paramApolloRender.mEditorDefaultText != null)
      {
        paramApolloRender.mEditorPop.setText(paramApolloRender.mEditorDefaultText);
        paramApolloRender.mEditorPop.setSelection(paramApolloRender.mEditorDefaultText.length());
      }
      localObject = BaseApplicationImpl.getContext().getResources().getDrawable(2130850178);
      paramApolloRender.mEditWindow.setBackgroundDrawable((Drawable)localObject);
    }
    Object localObject = (ApolloSurfaceView)paramView;
    b((ApolloSurfaceView)localObject, paramApolloRender);
    a((ApolloSurfaceView)localObject, paramApolloRender);
    int i = (int)(DeviceInfoUtil.a * 55.0F);
    if (paramApolloRender.mEditWindow != null)
    {
      paramApolloRender.mEditWindow.setWidth(-1);
      paramApolloRender.mEditWindow.setHeight(i);
    }
    i = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0).getInt("sp_key_apollo_keyboard_height", 0);
    if (i > 0)
    {
      paramView.getRootView().postDelayed(new KeyBoardUtil.7(paramApolloRender, paramView, i), 1000L);
      return;
    }
    if ((paramApolloRender != null) && (paramApolloRender.mEditWindow != null))
    {
      if (paramView == null) {
        return;
      }
      i = ((ApolloSurfaceView)localObject).getHeight();
      paramApolloRender.mEditWindow.showAtLocation(paramView.getRootView(), 0, 0, i - paramApolloRender.mEditWindow.getHeight());
      paramApolloRender.mEditWindow.update(0, i - paramApolloRender.mEditWindow.getHeight(), paramApolloRender.mEditWindow.getWidth(), paramApolloRender.mEditWindow.getHeight());
    }
  }
  
  private static void b(ApolloSurfaceView paramApolloSurfaceView, ApolloRender paramApolloRender)
  {
    if (paramApolloRender.mEditorPop == null) {
      return;
    }
    paramApolloRender.mEditorPop.addTextChangedListener(new KeyBoardUtil.9(paramApolloSurfaceView, paramApolloRender));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.KeyBoardUtil
 * JD-Core Version:    0.7.0.1
 */