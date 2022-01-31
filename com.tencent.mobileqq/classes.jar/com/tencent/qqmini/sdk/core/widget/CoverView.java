package com.tencent.qqmini.sdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import bdii;
import bdnw;
import bdyn;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CoverView
  extends FrameLayout
{
  private float jdField_a_of_type_Float;
  public int a;
  private bdii jdField_a_of_type_Bdii;
  private String jdField_a_of_type_JavaLangString;
  protected boolean a;
  private float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public CoverView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Float = bdyn.a(paramContext);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_Float > 0.0F)
    {
      Path localPath = new Path();
      int i = getWidth();
      int j = getPaddingLeft();
      int k = getPaddingRight();
      int m = getHeight();
      int n = getPaddingTop();
      int i1 = getPaddingBottom();
      localPath.addRoundRect(new RectF(getPaddingLeft(), getPaddingTop(), i - j - k + getPaddingLeft(), m - n - i1 + getPaddingTop()), this.jdField_b_of_type_Float, this.jdField_b_of_type_Float, Path.Direction.CCW);
      localPath.setFillType(Path.FillType.EVEN_ODD);
      paramCanvas.clipPath(localPath);
    }
    super.draw(paramCanvas);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    if (this.jdField_a_of_type_Boolean) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    while (this.jdField_b_of_type_Boolean)
    {
      return true;
      bdnw.a("CoverView", "--ACTION_DOWN--");
      int j;
      JSONObject localJSONObject5;
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        i = (int)(paramMotionEvent.getX() / this.jdField_a_of_type_Float);
        j = (int)(paramMotionEvent.getY() / this.jdField_a_of_type_Float);
        localJSONObject1.put("x", i);
        localJSONObject1.put("y", j);
        localJSONObject1.put("id", paramMotionEvent.getPointerId(0));
        localJSONObject5 = new JSONObject();
        localJSONObject5.put("data", this.jdField_a_of_type_JavaLangString);
        localJSONObject5.put("touch", localJSONObject1);
        if (this.jdField_a_of_type_Bdii == null) {
          continue;
        }
        this.jdField_a_of_type_Bdii.a("onTouchStart", localJSONObject5.toString());
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
      }
      continue;
      bdnw.a("CoverView", "--ACTION_POINTER_DOWN--" + paramMotionEvent.getPointerCount() + "   " + paramMotionEvent.getActionIndex() + "   " + paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
      int k;
      try
      {
        i = paramMotionEvent.getActionIndex();
        JSONObject localJSONObject2 = new JSONObject();
        j = (int)(paramMotionEvent.getX(i) / this.jdField_a_of_type_Float);
        k = (int)(paramMotionEvent.getY(i) / this.jdField_a_of_type_Float);
        localJSONObject2.put("x", j);
        localJSONObject2.put("y", k);
        localJSONObject2.put("id", paramMotionEvent.getPointerId(i));
        localJSONObject5 = new JSONObject();
        localJSONObject5.put("data", this.jdField_a_of_type_JavaLangString);
        localJSONObject5.put("touch", localJSONObject2);
        if (this.jdField_a_of_type_Bdii == null) {
          continue;
        }
        this.jdField_a_of_type_Bdii.a("onTouchStart", localJSONObject5.toString());
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
          k = (int)(paramMotionEvent.getX(i) / this.jdField_a_of_type_Float);
          int m = (int)(paramMotionEvent.getY(i) / this.jdField_a_of_type_Float);
          localJSONObject5.put("x", k);
          localJSONObject5.put("y", m);
          localJSONObject5.put("id", paramMotionEvent.getPointerId(i));
          localJSONArray1.put(localJSONObject5);
          i += 1;
        }
        localJSONObject5 = new JSONObject();
        localJSONObject5.put("data", this.jdField_a_of_type_JavaLangString);
        localJSONObject5.put("touches", localJSONArray1);
        if (this.jdField_a_of_type_Bdii == null) {
          continue;
        }
        this.jdField_a_of_type_Bdii.a("onTouchMove", localJSONObject5.toString());
      }
      catch (JSONException localJSONException3)
      {
        localJSONException3.printStackTrace();
      }
      continue;
      bdnw.a("CoverView", "--ACTION_UP--");
      try
      {
        JSONObject localJSONObject3 = new JSONObject();
        i = (int)bdyn.a(paramMotionEvent.getX());
        j = (int)bdyn.a(paramMotionEvent.getY());
        localJSONObject3.put("x", i);
        localJSONObject3.put("y", j);
        localJSONObject3.put("id", paramMotionEvent.getPointerId(0));
        localJSONObject5 = new JSONObject();
        localJSONObject5.put("data", this.jdField_a_of_type_JavaLangString);
        localJSONObject5.put("touch", localJSONObject3);
        if (this.jdField_a_of_type_Bdii == null) {
          continue;
        }
        this.jdField_a_of_type_Bdii.a("onTouchEnd", localJSONObject5.toString());
      }
      catch (JSONException localJSONException4)
      {
        localJSONException4.printStackTrace();
      }
      continue;
      bdnw.a("CoverView", "--ACTION_POINTER_UP--" + paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
      try
      {
        i = paramMotionEvent.getActionIndex();
        JSONObject localJSONObject4 = new JSONObject();
        j = (int)bdyn.a(paramMotionEvent.getX(i));
        k = (int)bdyn.a(paramMotionEvent.getY(i));
        localJSONObject4.put("x", j);
        localJSONObject4.put("y", k);
        localJSONObject4.put("id", paramMotionEvent.getPointerId(i));
        localJSONObject5 = new JSONObject();
        localJSONObject5.put("data", this.jdField_a_of_type_JavaLangString);
        localJSONObject5.put("touch", localJSONObject4);
        if (this.jdField_a_of_type_Bdii == null) {
          continue;
        }
        this.jdField_a_of_type_Bdii.a("onTouchEnd", localJSONObject5.toString());
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      continue;
      bdnw.a("CoverView", "--ACTION_CANCEL--");
      JSONArray localJSONArray2 = new JSONArray();
      try
      {
        localJSONObject5 = new JSONObject();
        i = (int)bdyn.a(paramMotionEvent.getX());
        j = (int)bdyn.a(paramMotionEvent.getY());
        localJSONObject5.put("x", i);
        localJSONObject5.put("y", j);
        localJSONObject5.put("id", paramMotionEvent.getPointerId(0));
        localJSONArray2.put(localJSONObject5);
        localJSONObject5 = new JSONObject();
        localJSONObject5.put("data", this.jdField_a_of_type_JavaLangString);
        localJSONObject5.put("touches", localJSONArray2);
        if (this.jdField_a_of_type_Bdii != null) {
          this.jdField_a_of_type_Bdii.a("onTouchCancel", localJSONObject5.toString());
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
    this.jdField_b_of_type_Float = paramFloat;
  }
  
  public void setData(String paramString, boolean paramBoolean, bdii parambdii)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Bdii = parambdii;
  }
  
  public void setFixed(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setIgnoreTouchEventToJS(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setParentId(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.CoverView
 * JD-Core Version:    0.7.0.1
 */