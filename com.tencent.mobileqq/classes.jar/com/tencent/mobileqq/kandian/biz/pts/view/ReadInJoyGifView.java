package com.tencent.mobileqq.kandian.biz.pts.view;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeGifView;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoyGifView
  extends ViewBase
{
  private int jdField_a_of_type_Int;
  private NativeGifView jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeGifView;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  
  public ReadInJoyGifView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeGifView = new NativeGifView(paramVafContext.getContext());
  }
  
  private boolean a()
  {
    return this.mParams.mLayoutHeight * this.mParams.mLayoutWidth > 2000000;
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeGifView.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeGifView.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeGifView;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeGifView.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeGifView.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    if (this.jdField_a_of_type_Int > 0)
    {
      int i = this.b;
      if (i > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeGifView.setGifHeight(i);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeGifView.setGifWidth(this.jdField_a_of_type_Int);
      }
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeGifView.setGifUrl(this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeGifView.setIsBigImg(a());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeGifView.setBackgroundColor(this.mBackground);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeGifView.displayGif(this.mParams.mLayoutWidth, this.mParams.mLayoutHeight);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeGifView.invalidate();
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    Layout.Params localParams;
    if (paramInt != 58)
    {
      if (paramInt != 59) {
        return super.setAttribute(paramInt, paramObject);
      }
      try
      {
        localParams = this.mParams;
        paramInt = ((Integer)paramObject).intValue();
        localParams.mLayoutWidth = paramInt;
        this.jdField_a_of_type_Int = paramInt;
      }
      catch (Exception paramObject)
      {
        QLog.d("ReadInJoyGifView", 2, paramObject.getMessage());
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeGifView.requestLayout();
      return true;
    }
    try
    {
      localParams = this.mParams;
      paramInt = ((Integer)paramObject).intValue();
      localParams.mLayoutHeight = paramInt;
      this.b = paramInt;
    }
    catch (Exception paramObject)
    {
      QLog.d("ReadInJoyGifView", 2, paramObject.getMessage());
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeGifView.requestLayout();
    return true;
  }
  
  protected boolean setAttribute(int paramInt, String paramString)
  {
    if (paramInt != 51)
    {
      if (paramInt != 1164)
      {
        if (paramInt != 1155)
        {
          if (paramInt != 1156) {
            return super.setAttribute(paramInt, paramString);
          }
          if (!TextUtils.isEmpty(paramString))
          {
            this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeGifView.setNeedGifUrl("yes".equals(paramString.toLowerCase()));
            return true;
          }
          return false;
        }
        this.jdField_a_of_type_JavaLangString = paramString;
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeGifView.setCoverUrl(paramString);
      return true;
    }
    try
    {
      paramString = Utils.toInteger(paramString);
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeGifView != null) && (paramString != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeGifView.setScaleType(paramString.intValue());
        return true;
      }
    }
    catch (Exception paramString)
    {
      QLog.d("ReadInJoyGifView", 2, paramString.getMessage());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyGifView
 * JD-Core Version:    0.7.0.1
 */