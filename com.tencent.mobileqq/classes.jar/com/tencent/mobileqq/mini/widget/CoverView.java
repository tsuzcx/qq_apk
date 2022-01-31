package com.tencent.mobileqq.mini.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CoverView
  extends FrameLayout
{
  public static final String TAG = "CoverView";
  private String data;
  private float density;
  private boolean enableGesture;
  private boolean fixed;
  private float mBorderRadius;
  protected boolean mIgnoreTouchEventToJS;
  public int parentId;
  private WebviewContainer webviewContainer;
  
  public CoverView(Context paramContext)
  {
    super(paramContext);
    this.density = DisplayUtil.getDensity(paramContext);
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
    int i = 0;
    if (this.mIgnoreTouchEventToJS) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    while (this.enableGesture)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.e("CoverView", 2, "--ACTION_DOWN--");
      }
      int j;
      JSONObject localJSONObject5;
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        i = (int)(paramMotionEvent.getX() / this.density);
        j = (int)(paramMotionEvent.getY() / this.density);
        localJSONObject1.put("x", i);
        localJSONObject1.put("y", j);
        localJSONObject1.put("id", paramMotionEvent.getPointerId(0));
        localJSONObject5 = new JSONObject();
        localJSONObject5.put("data", this.data);
        localJSONObject5.put("touch", localJSONObject1);
        if ((this.webviewContainer == null) || (this.webviewContainer.appBrandRuntime == null)) {
          continue;
        }
        this.webviewContainer.appBrandRuntime.getPageWebView().evaluateSubcribeJS("onTouchStart", localJSONObject5.toString(), this.webviewContainer.getPageWebview().pageWebviewId);
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
      }
      continue;
      if (QLog.isColorLevel()) {
        QLog.e("CoverView", 2, "--ACTION_POINTER_DOWN--" + paramMotionEvent.getPointerCount() + "   " + paramMotionEvent.getActionIndex() + "   " + paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
      }
      int k;
      try
      {
        i = paramMotionEvent.getActionIndex();
        JSONObject localJSONObject2 = new JSONObject();
        j = (int)(paramMotionEvent.getX(i) / this.density);
        k = (int)(paramMotionEvent.getY(i) / this.density);
        localJSONObject2.put("x", j);
        localJSONObject2.put("y", k);
        localJSONObject2.put("id", paramMotionEvent.getPointerId(i));
        localJSONObject5 = new JSONObject();
        localJSONObject5.put("data", this.data);
        localJSONObject5.put("touch", localJSONObject2);
        if ((this.webviewContainer == null) || (this.webviewContainer.appBrandRuntime == null)) {
          continue;
        }
        this.webviewContainer.appBrandRuntime.getPageWebView().evaluateSubcribeJS("onTouchStart", localJSONObject5.toString(), this.webviewContainer.getPageWebview().pageWebviewId);
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
      }
      continue;
      try
      {
        JSONArray localJSONArray1 = new JSONArray();
        j = paramMotionEvent.getPointerCount();
        while (i < j)
        {
          localJSONObject5 = new JSONObject();
          k = (int)(paramMotionEvent.getX(i) / this.density);
          int m = (int)(paramMotionEvent.getY(i) / this.density);
          localJSONObject5.put("x", k);
          localJSONObject5.put("y", m);
          localJSONObject5.put("id", paramMotionEvent.getPointerId(i));
          localJSONArray1.put(localJSONObject5);
          i += 1;
        }
        localJSONObject5 = new JSONObject();
        localJSONObject5.put("data", this.data);
        localJSONObject5.put("touches", localJSONArray1);
        if ((this.webviewContainer == null) || (this.webviewContainer.appBrandRuntime == null)) {
          continue;
        }
        this.webviewContainer.appBrandRuntime.getPageWebView().evaluateSubcribeJS("onTouchMove", localJSONObject5.toString(), this.webviewContainer.getPageWebview().pageWebviewId);
      }
      catch (JSONException localJSONException3)
      {
        localJSONException3.printStackTrace();
      }
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("CoverView", 2, "--ACTION_UP--");
      }
      try
      {
        JSONObject localJSONObject3 = new JSONObject();
        i = (int)DisplayUtil.px2mpx(paramMotionEvent.getX());
        j = (int)DisplayUtil.px2mpx(paramMotionEvent.getY());
        localJSONObject3.put("x", i);
        localJSONObject3.put("y", j);
        localJSONObject3.put("id", paramMotionEvent.getPointerId(0));
        localJSONObject5 = new JSONObject();
        localJSONObject5.put("data", this.data);
        localJSONObject5.put("touch", localJSONObject3);
        if ((this.webviewContainer == null) || (this.webviewContainer.appBrandRuntime == null)) {
          continue;
        }
        this.webviewContainer.appBrandRuntime.getPageWebView().evaluateSubcribeJS("onTouchEnd", localJSONObject5.toString(), this.webviewContainer.getPageWebview().pageWebviewId);
      }
      catch (JSONException localJSONException4)
      {
        localJSONException4.printStackTrace();
      }
      continue;
      if (QLog.isColorLevel()) {
        QLog.e("CoverView", 2, "--ACTION_POINTER_UP--" + paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
      }
      try
      {
        i = paramMotionEvent.getActionIndex();
        JSONObject localJSONObject4 = new JSONObject();
        j = (int)DisplayUtil.px2mpx(paramMotionEvent.getX(i));
        k = (int)DisplayUtil.px2mpx(paramMotionEvent.getY(i));
        localJSONObject4.put("x", j);
        localJSONObject4.put("y", k);
        localJSONObject4.put("id", paramMotionEvent.getPointerId(i));
        localJSONObject5 = new JSONObject();
        localJSONObject5.put("data", this.data);
        localJSONObject5.put("touch", localJSONObject4);
        if ((this.webviewContainer == null) || (this.webviewContainer.appBrandRuntime == null)) {
          continue;
        }
        this.webviewContainer.appBrandRuntime.getPageWebView().evaluateSubcribeJS("onTouchEnd", localJSONObject5.toString(), this.webviewContainer.getPageWebview().pageWebviewId);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("CoverView", 2, "--ACTION_CANCEL--");
      }
      JSONArray localJSONArray2 = new JSONArray();
      try
      {
        localJSONObject5 = new JSONObject();
        i = (int)DisplayUtil.px2mpx(paramMotionEvent.getX());
        j = (int)DisplayUtil.px2mpx(paramMotionEvent.getY());
        localJSONObject5.put("x", i);
        localJSONObject5.put("y", j);
        localJSONObject5.put("id", paramMotionEvent.getPointerId(0));
        localJSONArray2.put(localJSONObject5);
        localJSONObject5 = new JSONObject();
        localJSONObject5.put("data", this.data);
        localJSONObject5.put("touches", localJSONArray2);
        if ((this.webviewContainer != null) && (this.webviewContainer.appBrandRuntime != null) && (this.webviewContainer.appBrandRuntime.getPageWebView() != null)) {
          this.webviewContainer.appBrandRuntime.getPageWebView().evaluateSubcribeJS("onTouchCancel", localJSONObject5.toString(), this.webviewContainer.getPageWebview().pageWebviewId);
        }
      }
      catch (JSONException localJSONException5)
      {
        localJSONException5.printStackTrace();
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBorderRadius(float paramFloat)
  {
    this.mBorderRadius = paramFloat;
  }
  
  public void setData(String paramString, boolean paramBoolean, WebviewContainer paramWebviewContainer)
  {
    this.data = paramString;
    this.enableGesture = paramBoolean;
    this.webviewContainer = paramWebviewContainer;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.CoverView
 * JD-Core Version:    0.7.0.1
 */