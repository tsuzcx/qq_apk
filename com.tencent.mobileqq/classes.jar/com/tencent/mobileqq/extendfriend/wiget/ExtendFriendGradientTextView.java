package com.tencent.mobileqq.extendfriend.wiget;

import aciy;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import bajq;
import com.tencent.mobileqq.R.styleable;
import java.util.HashMap;

public class ExtendFriendGradientTextView
  extends View
{
  private float jdField_a_of_type_Float = 50.0F;
  private int jdField_a_of_type_Int = -16777216;
  private StaticLayout jdField_a_of_type_AndroidTextStaticLayout;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private String jdField_a_of_type_JavaLangString = "";
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap;
  public boolean a;
  private int b = 50;
  private int c;
  
  public ExtendFriendGradientTextView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ExtendFriendGradientTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
    a();
  }
  
  public ExtendFriendGradientTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
    a();
  }
  
  private Bitmap a(StaticLayout paramStaticLayout)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramStaticLayout.getWidth(), paramStaticLayout.getHeight(), Bitmap.Config.ARGB_8888);
    localBitmap.setDensity((int)bajq.c());
    paramStaticLayout.draw(new Canvas(localBitmap));
    return localBitmap;
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.gradientTextViewDefinedAttr);
    this.jdField_a_of_type_Float = paramAttributeSet.getInt(1, 50);
    this.jdField_a_of_type_Int = paramAttributeSet.getInt(0, -16777216);
    paramAttributeSet.recycle();
  }
  
  public int a()
  {
    return this.c;
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
    localBitmap.setDensity((int)bajq.c());
    Object localObject = new Shader[2];
    localObject[0] = new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    localObject[1] = new LinearGradient(0.0F, 0.0F, 0.0F, paramBitmap.getHeight(), -16777216, 0, Shader.TileMode.CLAMP);
    localObject = new ComposeShader(localObject[0], localObject[1], PorterDuff.Mode.DST_IN);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setShader((Shader)localObject);
    new Canvas(localBitmap).drawPaint(localPaint);
    paramBitmap.recycle();
    return localBitmap;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.c = (getResources().getDisplayMetrics().widthPixels - aciy.a(26.0F, getResources()) * 2);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(12);
  }
  
  public void a(float paramFloat, int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Float = paramFloat;
    this.b = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramFloat);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(paramInt1);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
    this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(paramString, this.jdField_a_of_type_AndroidTextTextPaint, this.c, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    if ((this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() > paramInt2) && (paramBoolean)) {
      this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(paramString.substring(0, this.jdField_a_of_type_AndroidTextStaticLayout.getLineStart(paramInt2) - 1), this.jdField_a_of_type_AndroidTextTextPaint, this.c, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    }
    postInvalidate();
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_AndroidTextStaticLayout != null) {
      return this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount();
    }
    return 0;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    String str = this.jdField_a_of_type_Int + "_" + this.jdField_a_of_type_Float + "_" + this.b + "_" + this.jdField_a_of_type_Boolean + "_" + this.jdField_a_of_type_JavaLangString;
    Bitmap localBitmap2 = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(str);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      localBitmap2 = a(this.jdField_a_of_type_AndroidTextStaticLayout);
      localBitmap1 = localBitmap2;
      if (this.jdField_a_of_type_Boolean) {
        localBitmap1 = a(localBitmap2);
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(str, localBitmap1);
    }
    paramCanvas.drawBitmap(localBitmap1, 0.0F, 0.0F, this.jdField_a_of_type_AndroidTextTextPaint);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_a_of_type_AndroidTextStaticLayout != null)
    {
      paramInt1 = getResources().getDisplayMetrics().widthPixels;
      aciy.a(26.0F, getResources());
      setMeasuredDimension(this.jdField_a_of_type_AndroidTextStaticLayout.getWidth(), this.jdField_a_of_type_AndroidTextStaticLayout.getHeight());
    }
  }
  
  public void setFold(boolean paramBoolean)
  {
    a(this.jdField_a_of_type_Float, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, paramBoolean);
  }
  
  public void setMaxLines(int paramInt)
  {
    a(this.jdField_a_of_type_Float, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, paramInt, this.jdField_a_of_type_Boolean);
  }
  
  public void setText(String paramString)
  {
    a(this.jdField_a_of_type_Float, this.jdField_a_of_type_Int, paramString, this.b, this.jdField_a_of_type_Boolean);
  }
  
  public void setTextColor(int paramInt)
  {
    a(this.jdField_a_of_type_Float, paramInt, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Boolean);
  }
  
  public void setTextSize(float paramFloat)
  {
    a(paramFloat, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Boolean);
  }
  
  public void setViewWidth(int paramInt)
  {
    if (this.c == paramInt) {
      return;
    }
    this.c = paramInt;
    a(this.jdField_a_of_type_Float, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendGradientTextView
 * JD-Core Version:    0.7.0.1
 */