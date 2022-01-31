package com.tencent.plato.sdk.render;

import android.animation.Animator;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.JSONWritableArray;
import com.tencent.plato.JSONWritableMap;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.core.utils.PLog;
import com.tencent.plato.sdk.dom.EventCenter;
import com.tencent.plato.sdk.render.data.ElementItem;
import com.tencent.plato.sdk.utils.Dimension;
import com.tencent.plato.sdk.utils.DrawableUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class PView
  implements IPView
{
  private int TOUCH_INTERVAL = 15;
  protected int curHeight = -1;
  protected int curLeft = -1;
  protected int curTop = -1;
  protected int curWidth = -1;
  protected int id;
  private int lastTouchPosX = 0;
  private int lastTouchPosY = 0;
  Map<String, List<Animator>> mAnimators = new HashMap();
  ArrayList<IPView> mChildren;
  private EventCenter mEventCenter;
  protected IPView mParent;
  protected IPlatoRuntime mPlatoRuntime;
  protected int pageId;
  protected View view;
  
  public static JSONWritableMap getClickInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    JSONWritableMap localJSONWritableMap1 = new JSONWritableMap();
    JSONWritableArray localJSONWritableArray = new JSONWritableArray();
    paramInt1 = Math.round(Dimension.devicePx2RemPx(paramInt1));
    paramInt2 = Math.round(Dimension.devicePx2RemPx(paramInt2));
    JSONWritableMap localJSONWritableMap2 = new JSONWritableMap();
    localJSONWritableMap2.put("identifier", paramInt3);
    localJSONWritableMap2.put("clientX", paramInt1);
    localJSONWritableMap2.put("clientY", paramInt2);
    localJSONWritableMap2.put("pageX", paramInt1);
    localJSONWritableMap2.put("pageY", paramInt2);
    localJSONWritableArray.add(localJSONWritableMap2);
    localJSONWritableMap1.put("id", paramInt3);
    localJSONWritableMap1.put("touches", localJSONWritableArray);
    localJSONWritableMap1.put("changedTouches", localJSONWritableArray);
    paramInt1 = paramInt4;
    if (paramInt4 < 0) {
      paramInt1 = 0;
    }
    paramInt2 = paramInt5;
    if (paramInt5 < 0) {
      paramInt2 = 0;
    }
    localJSONWritableMap1.put("width", Math.round(Dimension.devicePx2RemPx(paramInt1)));
    localJSONWritableMap1.put("height", Math.round(Dimension.devicePx2RemPx(paramInt2)));
    return localJSONWritableMap1;
  }
  
  public static JSONWritableMap getTouchMotionInfo(MotionEvent paramMotionEvent, int paramInt1, int paramInt2, int paramInt3)
  {
    JSONWritableMap localJSONWritableMap1 = new JSONWritableMap();
    JSONWritableArray localJSONWritableArray = new JSONWritableArray();
    int j = paramMotionEvent.getPointerCount();
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getX();
    float f3 = paramMotionEvent.getRawY();
    float f4 = paramMotionEvent.getY();
    int i = 0;
    while (i < j)
    {
      float f5 = paramMotionEvent.getX() + (f1 - f2);
      float f6 = paramMotionEvent.getY() + (f3 - f4);
      int k = Math.round(Dimension.devicePx2RemPx(f5));
      int m = Math.round(Dimension.devicePx2RemPx(f6));
      JSONWritableMap localJSONWritableMap2 = new JSONWritableMap();
      localJSONWritableMap2.put("identifier", paramInt1);
      localJSONWritableMap2.put("clientX", k);
      localJSONWritableMap2.put("clientY", m);
      localJSONWritableMap2.put("pageX", k);
      localJSONWritableMap2.put("pageY", m);
      localJSONWritableMap2.put("screenX", f5);
      localJSONWritableMap2.put("screenY", f6);
      localJSONWritableArray.add(localJSONWritableMap2);
      i += 1;
    }
    localJSONWritableMap1.put("id", paramInt1);
    localJSONWritableMap1.put("touches", localJSONWritableArray);
    localJSONWritableMap1.put("changedTouches", localJSONWritableArray);
    paramInt1 = paramInt2;
    if (paramInt2 < 0) {
      paramInt1 = 0;
    }
    paramInt2 = paramInt3;
    if (paramInt3 < 0) {
      paramInt2 = 0;
    }
    localJSONWritableMap1.put("width", Math.round(Dimension.devicePx2RemPx(paramInt1)));
    localJSONWritableMap1.put("height", Math.round(Dimension.devicePx2RemPx(paramInt2)));
    return localJSONWritableMap1;
  }
  
  public void addAnimator(String paramString, Animator paramAnimator)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAnimator == null)) {
      return;
    }
    List localList = (List)this.mAnimators.get(paramString);
    paramString = localList;
    if (localList == null) {
      paramString = new ArrayList();
    }
    paramString.add(paramAnimator);
  }
  
  public void addChild(IPView paramIPView, int paramInt)
  {
    if (paramIPView.getParent() != null) {
      throw new IllegalStateException("Child already has a parent, it must be removed first. : " + paramIPView.getId());
    }
    if (this.mChildren == null) {
      this.mChildren = new ArrayList(4);
    }
    if (paramInt >= 0) {
      if (this.mChildren.size() >= paramInt) {
        this.mChildren.add(paramInt, paramIPView);
      }
    }
    for (;;)
    {
      if (this.view != null)
      {
        ((ViewGroup)this.view).addView(paramIPView.getView(), paramInt);
        ((PView)paramIPView).mParent = this;
      }
      return;
      throw new IllegalStateException("parent has less child: parent :" + getId() + "  size:" + this.mChildren.size() + "  child id:" + paramIPView.getId() + "  index:" + paramInt);
      this.mChildren.add(paramIPView);
    }
  }
  
  public void attachEvent(final List<String> paramList)
  {
    final int m = this.id;
    Object localObject;
    if ((this.view != null) && (paramList != null) && (paramList.size() > 0))
    {
      int j = 0;
      int i = 0;
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        int k = j;
        if ("click".equals(str)) {
          k = 1;
        }
        if ((!"touchstart".equals(str)) && (!"touchend".equals(str)))
        {
          j = k;
          if (!"touchmove".equals(str)) {}
        }
        else
        {
          i = 1;
          j = k;
        }
      }
      if (j != 0) {
        this.view.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            PLog.i("MotionEvent", "perf log --- onClick id:" + m);
            int[] arrayOfInt = new int[2];
            paramAnonymousView.getLocationOnScreen(arrayOfInt);
            PView.this.fireEvent(PView.this.getPageId(), m, "click", PView.getClickInfo(arrayOfInt[0], arrayOfInt[1], m, paramAnonymousView.getWidth(), paramAnonymousView.getHeight()));
          }
        });
      }
      if (i != 0)
      {
        localObject = this.view;
        if ((this.view instanceof PScrollView.PVScrollView)) {
          localObject = ((PScrollView.PVScrollView)this.view).getRefreshableView();
        }
        if (localObject != null) {
          break label180;
        }
      }
    }
    return;
    label180:
    ((View)localObject).setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        switch (paramAnonymousMotionEvent.getActionMasked())
        {
        }
        while ((paramAnonymousView instanceof PScrollView.PVScrollView))
        {
          return false;
          PLog.e("MotionEvent", "perf log --- ACTION_DOWN id:" + m);
          if (paramList.contains("touchstart"))
          {
            PView.access$002(PView.this, (int)paramAnonymousMotionEvent.getRawX());
            PView.access$102(PView.this, (int)paramAnonymousMotionEvent.getRawY());
            PView.this.fireEvent(PView.this.getPageId(), m, "touchstart", PView.getTouchMotionInfo(paramAnonymousMotionEvent, m, paramAnonymousView.getWidth(), paramAnonymousView.getHeight()));
            continue;
            PLog.e("MotionEvent", "perf log --- ACTION_MOVE id:" + m);
            if (paramList.contains("touchmove"))
            {
              PView.this.fireEvent(PView.this.getPageId(), m, "touchmove", PView.getTouchMotionInfo(paramAnonymousMotionEvent, m, paramAnonymousView.getWidth(), paramAnonymousView.getHeight()));
              continue;
              PLog.e("MotionEvent", "perf log --- ACTION_UP id:" + m);
              if (paramList.contains("touchend"))
              {
                paramAnonymousView.getWidth();
                paramAnonymousView.getHeight();
                PView.this.fireEvent(PView.this.getPageId(), m, "touchend", PView.getTouchMotionInfo(paramAnonymousMotionEvent, m, paramAnonymousView.getWidth(), paramAnonymousView.getHeight()));
                int j = (int)paramAnonymousMotionEvent.getRawX();
                int i = (int)paramAnonymousMotionEvent.getRawY();
                j = Math.abs(PView.this.lastTouchPosX - j);
                i = Math.abs(PView.this.lastTouchPosY - i);
                double d = Math.sqrt(j * j + i * i);
                PLog.e("MotionEvent", "perf log --- ACTION_UP distance:" + d);
                if (d < PView.this.TOUCH_INTERVAL)
                {
                  paramAnonymousView.performClick();
                  continue;
                  PLog.e("MotionEvent", "perf log --- ACTION_CANCEL id:" + m);
                  if (paramList.contains("touchcancel")) {
                    PView.this.fireEvent(PView.this.getPageId(), m, "touchcancel", PView.getTouchMotionInfo(paramAnonymousMotionEvent, m, paramAnonymousView.getWidth(), paramAnonymousView.getHeight()));
                  }
                }
              }
            }
          }
        }
        return true;
      }
    });
  }
  
  public void attachTransform(Map<String, Object> paramMap)
  {
    if (paramMap == null) {}
    for (;;)
    {
      return;
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject = (Map.Entry)paramMap.next();
        if (((((Map.Entry)localObject).getValue() instanceof Object[])) && (((Object[])((Map.Entry)localObject).getValue()).length > 0) && ((((Object[])(Object[])localObject.getValue())[0] instanceof Float)))
        {
          Float localFloat = (Float)((Object[])(Object[])localObject.getValue())[0];
          localObject = (String)((Map.Entry)localObject).getKey();
          label216:
          int i;
          switch (((String)localObject).hashCode())
          {
          default: 
            i = -1;
          }
          for (;;)
          {
            switch (i)
            {
            default: 
              break;
            case 0: 
              this.view.setRotationX(localFloat.floatValue());
              break;
              if (!((String)localObject).equals("rotateX")) {
                break label216;
              }
              i = 0;
              continue;
              if (!((String)localObject).equals("rotateY")) {
                break label216;
              }
              i = 1;
              continue;
              if (!((String)localObject).equals("rotateZ")) {
                break label216;
              }
              i = 2;
              continue;
              if (!((String)localObject).equals("rotate")) {
                break label216;
              }
              i = 3;
              continue;
              if (!((String)localObject).equals("scaleX")) {
                break label216;
              }
              i = 4;
              continue;
              if (!((String)localObject).equals("scaleY")) {
                break label216;
              }
              i = 5;
              continue;
              if (!((String)localObject).equals("scale")) {
                break label216;
              }
              i = 6;
              continue;
              if (!((String)localObject).equals("translateX")) {
                break label216;
              }
              i = 7;
              continue;
              if (!((String)localObject).equals("translateY")) {
                break label216;
              }
              i = 8;
              continue;
              if (!((String)localObject).equals("translateZ")) {
                break label216;
              }
              i = 9;
            }
          }
          this.view.setRotationY(localFloat.floatValue());
          continue;
          this.view.setRotation(localFloat.floatValue());
          continue;
          this.view.setScaleX(localFloat.floatValue());
          continue;
          this.view.setScaleY(localFloat.floatValue());
          continue;
          this.view.setScaleX(localFloat.floatValue());
          this.view.setScaleY(localFloat.floatValue());
          continue;
          this.view.setTranslationX(localFloat.floatValue());
          continue;
          this.view.setTranslationY(localFloat.floatValue());
          continue;
          if (Build.VERSION.SDK_INT >= 21) {
            this.view.setTranslationZ(localFloat.floatValue());
          }
        }
      }
    }
  }
  
  public void draw(int paramInt1, int paramInt2) {}
  
  protected void fireEvent(int paramInt1, int paramInt2, String paramString, IReadableMap paramIReadableMap)
  {
    this.mEventCenter.fireEvent(paramInt1, paramInt2, paramString, paramIReadableMap);
  }
  
  public List<Animator> getAnimator(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (List)this.mAnimators.get(paramString);
  }
  
  public IPView getChild(int paramInt)
  {
    if ((this.mChildren != null) && (this.mChildren.size() > paramInt)) {
      return (IPView)this.mChildren.get(paramInt);
    }
    return null;
  }
  
  public int getChildCount()
  {
    if (this.mChildren != null) {
      return this.mChildren.size();
    }
    return 0;
  }
  
  public int getHeight()
  {
    return this.curHeight;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public int getPageId()
  {
    return this.pageId;
  }
  
  public IPView getParent()
  {
    return this.mParent;
  }
  
  public IPlatoRuntime getPlatoRuntime()
  {
    return this.mPlatoRuntime;
  }
  
  public View getView()
  {
    return this.view;
  }
  
  public int getWidth()
  {
    return this.curWidth;
  }
  
  public void init(IPlatoRuntime paramIPlatoRuntime, IPView paramIPView, ElementItem paramElementItem)
  {
    this.mPlatoRuntime = paramIPlatoRuntime;
    this.mEventCenter = ((EventCenter)paramIPlatoRuntime.getJSModule(EventCenter.class));
  }
  
  public void removeAnimator(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.mAnimators.remove(paramString);
  }
  
  public void removeChild(IPView paramIPView)
  {
    if (this.mChildren != null)
    {
      this.mChildren.remove(paramIPView);
      ((PView)paramIPView).mParent = null;
      if ((paramIPView.getView() != null) && (this.view != null)) {
        ((ViewGroup)this.view).removeView(paramIPView.getView());
      }
      return;
    }
    PLog.d("PView", "removeChild [mChildren == null] ");
  }
  
  public IPView removeChildAt(int paramInt)
  {
    IPView localIPView = (IPView)this.mChildren.remove(paramInt);
    ((PView)localIPView).mParent = null;
    if ((localIPView.getView() != null) && (this.view != null)) {
      ((ViewGroup)this.view).removeView(localIPView.getView());
    }
    return localIPView;
  }
  
  public void setPageId(int paramInt)
  {
    this.pageId = paramInt;
  }
  
  public void setStyles(IReadableMap paramIReadableMap)
  {
    if (this.view == null) {}
    int[] arrayOfInt1;
    int[] arrayOfInt2;
    int i;
    int j;
    do
    {
      do
      {
        return;
        arrayOfInt1 = (int[])paramIReadableMap.get("borderWidth");
        arrayOfInt2 = (int[])paramIReadableMap.get("borderColor");
        i = paramIReadableMap.getInt("roundRadius", 0);
        j = paramIReadableMap.getInt("backgroundColor", 0);
        if (i > 0)
        {
          if ((arrayOfInt1 != null) && (arrayOfInt2 != null) && (arrayOfInt1[0] == arrayOfInt1[1]) && (arrayOfInt1[1] == arrayOfInt1[2]) && (arrayOfInt1[2] == arrayOfInt1[3]))
          {
            this.view.setBackground(DrawableUtils.createDrawable(arrayOfInt1[0], arrayOfInt2[0], j, i));
            return;
          }
          this.view.setBackground(DrawableUtils.createDrawable(0, j, j, i));
          return;
        }
        if ((arrayOfInt1 == null) || (arrayOfInt1[0] != 0) || (arrayOfInt1[1] != 0) || (arrayOfInt1[2] != 0) || (arrayOfInt1[3] != 0)) {
          break;
        }
      } while (j == 0);
      this.view.setBackgroundColor(j);
      return;
    } while (arrayOfInt2 == null);
    paramIReadableMap = (FrameLayout.LayoutParams)this.view.getLayoutParams();
    this.view.setBackground(DrawableUtils.createDrawable(arrayOfInt1, arrayOfInt2, j, i, paramIReadableMap.width, paramIReadableMap.height));
  }
  
  public void setTopView(IPView paramIPView) {}
  
  public void updateRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.curLeft != paramInt1) || (this.curTop != paramInt2) || (this.curWidth != paramInt3) || (this.curHeight != paramInt4)) && (this.view != null))
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramInt3, paramInt4);
      localLayoutParams.leftMargin = paramInt1;
      localLayoutParams.topMargin = paramInt2;
      this.view.setLayoutParams(localLayoutParams);
      this.curLeft = paramInt1;
      this.curTop = paramInt2;
      this.curWidth = paramInt3;
      this.curHeight = paramInt4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.sdk.render.PView
 * JD-Core Version:    0.7.0.1
 */