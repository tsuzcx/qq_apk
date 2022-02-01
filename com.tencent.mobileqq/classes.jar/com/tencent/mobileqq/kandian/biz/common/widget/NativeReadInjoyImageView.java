package com.tencent.mobileqq.kandian.biz.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.VirtualViewUtils;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.imageloader.DrawableController;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.common.FluencyOptUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class NativeReadInjoyImageView
  extends KandianUrlImageView
  implements IView
{
  private static final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
  private static Map<String, Drawable> jdField_a_of_type_JavaUtilMap = new HashMap();
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = null;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private int c;
  private int d;
  
  public NativeReadInjoyImageView(Context paramContext)
  {
    super(paramContext);
    this.mController.a(false);
  }
  
  public NativeReadInjoyImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mController.a(false);
  }
  
  public NativeReadInjoyImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mController.a(false);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = this.mController.a();
    if ((localObject == null) || (((ImageRequest)localObject).jdField_a_of_type_Boolean))
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      if (localObject != null) {
        setImageSrc((String)localObject);
      }
    }
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.d > 0) || (this.c > 0) || (this.jdField_a_of_type_Int > 0) || (this.jdField_b_of_type_Int > 0)) {
      VirtualViewUtils.clipCanvas(paramCanvas, getWidth(), getHeight(), 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.d, this.c);
    }
    super.onDraw(paramCanvas);
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    ImageRequest localImageRequest = this.mController.a();
    if (((localImageRequest == null) || (localImageRequest.jdField_a_of_type_Boolean)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      setImageSrc(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void setCorner(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt4;
    this.d = paramInt3;
  }
  
  public void setImageDrawable(Drawable paramDrawable, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_JavaLangString, paramDrawable);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setImageDrawable: path is ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("NativeReadInjoyImageView", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_Boolean) {
      paramBoolean = false;
    }
    super.setImageDrawable(paramDrawable, paramBoolean);
  }
  
  public void setImageSrc(String paramString)
  {
    try
    {
      if (this.jdField_b_of_type_Boolean)
      {
        localObject = (Drawable)jdField_a_of_type_JavaUtilMap.get(paramString);
        if (localObject != null)
        {
          setImageDrawable((Drawable)localObject);
          return;
        }
      }
      Object localObject = this.jdField_a_of_type_JavaLangString;
      if ((localObject != null) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString)))
      {
        QLog.d("NativeReadInjoyImageView", 2, "setImageSrc | current path unchanged ");
      }
      else
      {
        this.jdField_a_of_type_JavaLangString = paramString;
        QLog.d("NativeReadInjoyImageView", 2, "setImageSrc | current path changed ");
      }
      URL localURL = FluencyOptUtils.a.a(this.jdField_a_of_type_JavaLangString);
      localObject = localURL;
      if (localURL == null)
      {
        localObject = new URL(paramString);
        FluencyOptUtils.a.a((URL)localObject);
      }
      paramString = new StringBuilder();
      paramString.append("setImageSrc | mPathUrl :");
      paramString.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("NativeReadInjoyImageView", 2, paramString.toString());
      if (((IReadInJoyDisplayUtils)QRoute.api(IReadInJoyDisplayUtils.class)).shouldShowPlaceHolder(getContext(), (URL)localObject))
      {
        setImageResource(2130841770);
        return;
      }
      setImage((URL)localObject);
      return;
    }
    catch (MalformedURLException paramString) {}
  }
  
  public void setIsCacheIcon(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      setPublicAccountImageDownListener(new NativeReadInjoyImageView.BitmapRefListener(null));
    }
  }
  
  public void setIsClosedoAlphaAniamation(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      setImagePlaceHolder(jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView
 * JD-Core Version:    0.7.0.1
 */