package com.tencent.qqmini.sdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@MiniKeep
public class CoverView
  extends FrameLayout
{
  public static final String TAG = "CoverView";
  private String data;
  private float density;
  private boolean enableGesture;
  private boolean fixed = false;
  private float mBorderRadius;
  protected boolean mIgnoreTouchEventToJS;
  private CoverView.JsRuntimeListener mJsRuntimeListener;
  public int parentId;
  
  public CoverView(Context paramContext)
  {
    super(paramContext);
    this.density = DisplayUtil.getDensity(paramContext);
  }
  
  private void handleTouchCancel(MotionEvent paramMotionEvent)
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      JSONObject localJSONObject = new JSONObject();
      int i = (int)DisplayUtil.px2mpx(paramMotionEvent.getX());
      int j = (int)DisplayUtil.px2mpx(paramMotionEvent.getY());
      localJSONObject.put("x", i);
      localJSONObject.put("y", j);
      localJSONObject.put("id", paramMotionEvent.getPointerId(0));
      localJSONArray.put(localJSONObject);
      paramMotionEvent = new JSONObject();
      paramMotionEvent.put("data", this.data);
      paramMotionEvent.put("touches", localJSONArray);
      if (this.mJsRuntimeListener != null) {
        this.mJsRuntimeListener.onEvaluateSubscribeJS("onTouchCancel", paramMotionEvent.toString());
      }
      return;
    }
    catch (JSONException paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
  }
  
  private void handleTouchDown(MotionEvent paramMotionEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      int i = (int)(paramMotionEvent.getX() / this.density);
      int j = (int)(paramMotionEvent.getY() / this.density);
      localJSONObject.put("x", i);
      localJSONObject.put("y", j);
      localJSONObject.put("id", paramMotionEvent.getPointerId(0));
      paramMotionEvent = new JSONObject();
      paramMotionEvent.put("data", this.data);
      paramMotionEvent.put("touch", localJSONObject);
      if (this.mJsRuntimeListener != null) {
        this.mJsRuntimeListener.onEvaluateSubscribeJS("onTouchStart", paramMotionEvent.toString());
      }
      return;
    }
    catch (JSONException paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
  }
  
  private void handleTouchMove(MotionEvent paramMotionEvent)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      int j = paramMotionEvent.getPointerCount();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = new JSONObject();
        int k = (int)(paramMotionEvent.getX(i) / this.density);
        int m = (int)(paramMotionEvent.getY(i) / this.density);
        localJSONObject.put("x", k);
        localJSONObject.put("y", m);
        localJSONObject.put("id", paramMotionEvent.getPointerId(i));
        localJSONArray.put(localJSONObject);
        i += 1;
      }
      paramMotionEvent = new JSONObject();
      paramMotionEvent.put("data", this.data);
      paramMotionEvent.put("touches", localJSONArray);
      if (this.mJsRuntimeListener != null) {
        this.mJsRuntimeListener.onEvaluateSubscribeJS("onTouchMove", paramMotionEvent.toString());
      }
      return;
    }
    catch (JSONException paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
  }
  
  private void handleTouchPointerDown(MotionEvent paramMotionEvent)
  {
    try
    {
      int i = paramMotionEvent.getActionIndex();
      JSONObject localJSONObject = new JSONObject();
      int j = (int)(paramMotionEvent.getX(i) / this.density);
      int k = (int)(paramMotionEvent.getY(i) / this.density);
      localJSONObject.put("x", j);
      localJSONObject.put("y", k);
      localJSONObject.put("id", paramMotionEvent.getPointerId(i));
      paramMotionEvent = new JSONObject();
      paramMotionEvent.put("data", this.data);
      paramMotionEvent.put("touch", localJSONObject);
      if (this.mJsRuntimeListener != null) {
        this.mJsRuntimeListener.onEvaluateSubscribeJS("onTouchStart", paramMotionEvent.toString());
      }
      return;
    }
    catch (JSONException paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
  }
  
  private void handleTouchPointerUp(MotionEvent paramMotionEvent)
  {
    try
    {
      int i = paramMotionEvent.getActionIndex();
      JSONObject localJSONObject = new JSONObject();
      int j = (int)DisplayUtil.px2mpx(paramMotionEvent.getX(i));
      int k = (int)DisplayUtil.px2mpx(paramMotionEvent.getY(i));
      localJSONObject.put("x", j);
      localJSONObject.put("y", k);
      localJSONObject.put("id", paramMotionEvent.getPointerId(i));
      paramMotionEvent = new JSONObject();
      paramMotionEvent.put("data", this.data);
      paramMotionEvent.put("touch", localJSONObject);
      if (this.mJsRuntimeListener != null) {
        this.mJsRuntimeListener.onEvaluateSubscribeJS("onTouchEnd", paramMotionEvent.toString());
      }
      return;
    }
    catch (Exception paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
  }
  
  private void handleTouchUp(MotionEvent paramMotionEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      int i = (int)DisplayUtil.px2mpx(paramMotionEvent.getX());
      int j = (int)DisplayUtil.px2mpx(paramMotionEvent.getY());
      localJSONObject.put("x", i);
      localJSONObject.put("y", j);
      localJSONObject.put("id", paramMotionEvent.getPointerId(0));
      paramMotionEvent = new JSONObject();
      paramMotionEvent.put("data", this.data);
      paramMotionEvent.put("touch", localJSONObject);
      if (this.mJsRuntimeListener != null) {
        this.mJsRuntimeListener.onEvaluateSubscribeJS("onTouchEnd", paramMotionEvent.toString());
      }
      return;
    }
    catch (JSONException paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mBorderRadius > 0.0F)
    {
      Path localPath = new Path();
      int i = getWidth();
      int j = getPaddingLeft();
      int k = getPaddingRight();
      int m = getHeight();
      int n = getPaddingTop();
      int i1 = getPaddingBottom();
      localPath.addRoundRect(new RectF(getPaddingLeft(), getPaddingTop(), i - j - k + getPaddingLeft(), m - n - i1 + getPaddingTop()), this.mBorderRadius, this.mBorderRadius, Path.Direction.CCW);
      localPath.setFillType(Path.FillType.EVEN_ODD);
      paramCanvas.clipPath(localPath);
    }
    super.draw(paramCanvas);
  }
  
  public int getParentId()
  {
    return this.parentId;
  }
  
  public boolean isFixed()
  {
    return this.fixed;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mIgnoreTouchEventToJS) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    while (this.enableGesture)
    {
      return true;
      QMLog.d("CoverView", "--ACTION_DOWN--");
      handleTouchDown(paramMotionEvent);
      continue;
      QMLog.d("CoverView", "--ACTION_POINTER_DOWN--" + paramMotionEvent.getPointerCount() + "   " + paramMotionEvent.getActionIndex() + "   " + paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
      handleTouchPointerDown(paramMotionEvent);
      continue;
      handleTouchMove(paramMotionEvent);
      continue;
      QMLog.d("CoverView", "--ACTION_UP--");
      handleTouchUp(paramMotionEvent);
      continue;
      QMLog.d("CoverView", "--ACTION_POINTER_UP--" + paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
      handleTouchPointerUp(paramMotionEvent);
      continue;
      QMLog.d("CoverView", "--ACTION_CANCEL--");
      handleTouchCancel(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBorderRadius(float paramFloat)
  {
    this.mBorderRadius = paramFloat;
  }
  
  public void setData(String paramString, boolean paramBoolean, CoverView.JsRuntimeListener paramJsRuntimeListener)
  {
    this.data = paramString;
    this.enableGesture = paramBoolean;
    this.mJsRuntimeListener = paramJsRuntimeListener;
  }
  
  public void setFixed(boolean paramBoolean)
  {
    this.fixed = paramBoolean;
  }
  
  public void setIgnoreTouchEventToJS(boolean paramBoolean)
  {
    this.mIgnoreTouchEventToJS = paramBoolean;
  }
  
  public void setParentId(int paramInt)
  {
    this.parentId = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.CoverView
 * JD-Core Version:    0.7.0.1
 */