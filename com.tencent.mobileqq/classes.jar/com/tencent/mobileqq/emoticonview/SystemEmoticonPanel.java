package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
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
  protected boolean mIsHighDifinition = false;
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
    if (Build.VERSION.SDK_INT < 24) {
      try
      {
        Field localField = Class.forName("android.view.LayoutInflater").getDeclaredField("sConstructorMap");
        localField.setAccessible(true);
        ((HashMap)localField.get(LayoutInflater.from(paramContext))).remove("androidx.viewpager.widget.ViewPager");
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        QLog.e("SystemEmoticonPanel", 2, "init SystemEmoticonPanel error.", localIllegalAccessException);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        QLog.e("SystemEmoticonPanel", 2, "init SystemEmoticonPanel error.", localNoSuchFieldException);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        QLog.e("SystemEmoticonPanel", 2, "init SystemEmoticonPanel error.", localClassNotFoundException);
      }
    }
    this.root = LayoutInflater.from(paramContext).inflate(getLayoutId(), this);
    this.mIsHighDifinition = paramBoolean;
    initUI(paramContext, paramEmoticonCallback);
  }
  
  public void destory()
  {
    EmoticonPagerAdapter localEmoticonPagerAdapter = this.pageAdapter;
    if (localEmoticonPagerAdapter != null) {
      localEmoticonPagerAdapter.destroy();
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    SystemEmoticonPanel.DispatchKeyEventListener localDispatchKeyEventListener = this.mDispatchKeyEventListener;
    if ((localDispatchKeyEventListener != null) && (localDispatchKeyEventListener.dispatchKeyEvent(paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected int getLayoutId()
  {
    return 2131562900;
  }
  
  protected void initUI(Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    this.pageRadioGroup = ((EmoticonPagerRadioGroup)this.root.findViewById(2131375962));
    this.viewPager = ((ViewPager)this.root.findViewById(2131380822));
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
      int i;
      try
      {
        i = paramMotionEvent.getAction() & 0xFF;
        if (i != 0) {
          break label55;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      catch (Exception localException)
      {
        QLog.e("SystemEmoticonPanel", 1, "onInterceptTouchEvent failed", localException);
      }
      getParent().requestDisallowInterceptTouchEvent(false);
      label55:
      do
      {
        return super.onInterceptTouchEvent(paramMotionEvent);
        if (i == 1) {
          break;
        }
      } while (i != 3);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemEmoticonPanel
 * JD-Core Version:    0.7.0.1
 */