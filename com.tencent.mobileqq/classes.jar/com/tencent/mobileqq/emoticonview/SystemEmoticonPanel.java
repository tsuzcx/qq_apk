package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SystemEmoticonPanel
  extends RelativeLayout
{
  protected Context context;
  private SystemEmoticonPanel.DispatchKeyEventListener mDispatchKeyEventListener;
  protected boolean mIsHighDifinition;
  protected EmoticonPagerAdapter pageAdapter;
  protected EmoticonPagerRadioGroup pageRadioGroup;
  protected View root;
  protected ViewPager viewPager;
  
  public SystemEmoticonPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  public SystemEmoticonPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
  }
  
  public SystemEmoticonPanel(Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    this(paramContext, paramEmoticonCallback, false);
  }
  
  public SystemEmoticonPanel(Context paramContext, EmoticonCallback paramEmoticonCallback, boolean paramBoolean)
  {
    super(paramContext);
    if (Build.VERSION.SDK_INT < 24) {}
    try
    {
      Field localField = Class.forName("android.view.LayoutInflater").getDeclaredField("sConstructorMap");
      localField.setAccessible(true);
      ((HashMap)localField.get(LayoutInflater.from(paramContext))).remove("android.support.v4.view.ViewPager");
      this.root = LayoutInflater.from(paramContext).inflate(getLayoutId(), this);
      this.mIsHighDifinition = paramBoolean;
      initUI(paramContext, paramEmoticonCallback);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        QLog.e("SystemEmoticonPanel", 2, "init SystemEmoticonPanel error.", localClassNotFoundException);
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        QLog.e("SystemEmoticonPanel", 2, "init SystemEmoticonPanel error.", localNoSuchFieldException);
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        QLog.e("SystemEmoticonPanel", 2, "init SystemEmoticonPanel error.", localIllegalAccessException);
      }
    }
  }
  
  public void destory()
  {
    if (this.pageAdapter != null) {
      this.pageAdapter.destroy();
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((this.mDispatchKeyEventListener != null) && (this.mDispatchKeyEventListener.dispatchKeyEvent(paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected int getLayoutId()
  {
    return 2131559174;
  }
  
  protected void initUI(Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    this.pageRadioGroup = ((EmoticonPagerRadioGroup)this.root.findViewById(2131376072));
    this.viewPager = ((ViewPager)this.root.findViewById(2131381118));
    this.pageRadioGroup.setViewPager(this.viewPager);
    this.pageAdapter = new EmoticonPagerAdapter();
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(new SystemEmoticonPanelViewBinder(paramContext, paramEmoticonCallback, 0));
    this.pageAdapter.setViewBinderList(localArrayList);
    this.viewPager.setAdapter(this.pageAdapter);
    this.viewPager.setCurrentItem(0);
    this.pageRadioGroup.synButton(this.pageAdapter.getCount());
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    for (;;)
    {
      try
      {
        i = paramMotionEvent.getAction() & 0xFF;
        if (i != 0) {
          continue;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      catch (Exception localException)
      {
        int i;
        QLog.e("SystemEmoticonPanel", 1, "onInterceptTouchEvent failed", localException);
        continue;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void setCallBack(EmoticonCallback paramEmoticonCallback)
  {
    initUI(this.context, paramEmoticonCallback);
  }
  
  public void setDispatchKeyEventListener(SystemEmoticonPanel.DispatchKeyEventListener paramDispatchKeyEventListener)
  {
    this.mDispatchKeyEventListener = paramDispatchKeyEventListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemEmoticonPanel
 * JD-Core Version:    0.7.0.1
 */