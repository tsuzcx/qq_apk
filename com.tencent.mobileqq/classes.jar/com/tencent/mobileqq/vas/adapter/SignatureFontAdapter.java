package com.tencent.mobileqq.vas.adapter;

import android.os.Bundle;
import android.os.Handler;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.ETTextView.TextAnimationListener;
import com.etrump.mixlayout.FontInfo;
import com.etrump.mixlayout.FontManagerForTool;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.AppUtil;
import com.tencent.mobileqq.vas.VasResEngine.VasRes;
import com.tencent.mobileqq.vas.VasResEngine.VasResAdapter;
import com.tencent.mobileqq.vas.VasResEngine.VasResController;
import com.tencent.mobileqq.vas.font.api.FontLoadCallback;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.qphone.base.util.QLog;
import java.util.Observer;
import mqq.app.AppRuntime;

public class SignatureFontAdapter
  implements VasResAdapter, FontLoadCallback
{
  private float jdField_a_of_type_Float;
  protected int a;
  private long jdField_a_of_type_Long = System.currentTimeMillis();
  private ETTextView.TextAnimationListener jdField_a_of_type_ComEtrumpMixlayoutETTextView$TextAnimationListener = new SignatureFontAdapter.2(this);
  private ETTextView jdField_a_of_type_ComEtrumpMixlayoutETTextView;
  protected VasResController a;
  protected IFontManagerService a;
  private Observer jdField_a_of_type_JavaUtilObserver = new SignatureFontAdapter.1(this);
  protected AppRuntime a;
  private boolean jdField_a_of_type_Boolean;
  private int b = 1;
  private int c = 1;
  
  public SignatureFontAdapter(AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    VasRes localVasRes = new VasRes(paramAppInterface, paramInt1);
    this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController = localVasRes.a();
    this.jdField_a_of_type_Int = paramInt2;
    FontManagerForTool.a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
    localVasRes.a(this);
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppInterface;
  }
  
  public SignatureFontAdapter(VasRes paramVasRes, AppRuntime paramAppRuntime, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController = paramVasRes.a();
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_Int = paramInt;
    FontManagerForTool.a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  protected FontInfo a(int paramInt1, int paramInt2)
  {
    AppRuntime localAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)))
    {
      this.jdField_a_of_type_ComTencentMobileqqVasFontApiIFontManagerService = ((IFontManagerService)localAppRuntime.getRuntimeService(IFontManagerService.class, ""));
      this.jdField_a_of_type_ComTencentMobileqqVasFontApiIFontManagerService.addFontLoadCallback(this);
      return this.jdField_a_of_type_ComTencentMobileqqVasFontApiIFontManagerService.getFontInfo(paramInt1, paramInt2, false, ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getCurrentUin(), 0);
    }
    return null;
  }
  
  public void a()
  {
    FontInfo localFontInfo;
    if (AppUtil.a()) {
      localFontInfo = a(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController.a(), this.jdField_a_of_type_Int);
    } else {
      localFontInfo = FontManagerForTool.a().a(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController.a(), this.jdField_a_of_type_Int);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("load ");
    ((StringBuilder)localObject).append(localFontInfo);
    ((StringBuilder)localObject).append(" fontId:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController.a());
    QLog.i("SignatureFontAdapter", 1, ((StringBuilder)localObject).toString());
    if (localFontInfo != null)
    {
      localObject = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView;
      if (localObject != null) {
        a((ETTextView)localObject, localFontInfo, this.jdField_a_of_type_Float);
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setFont(0, System.currentTimeMillis());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController.a(paramInt1);
    this.jdField_a_of_type_Int = paramInt2;
    a();
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("downloadDone type = ");
      paramBundle.append(paramInt);
      QLog.d("SignatureFontAdapter", 2, paramBundle.toString());
    }
  }
  
  public void a(ETTextView paramETTextView, float paramFloat, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = paramETTextView;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextAnimationListener(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView$TextAnimationListener);
  }
  
  protected void a(ETTextView paramETTextView, FontInfo paramFontInfo, float paramFloat)
  {
    if (paramFontInfo.jdField_a_of_type_Int == 0)
    {
      paramETTextView.setFont(0, System.currentTimeMillis());
      return;
    }
    if (paramFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont != null)
    {
      paramFontInfo = paramFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont;
      paramFontInfo.setSize(paramFloat);
    }
    else
    {
      ETFont localETFont = new ETFont(paramFontInfo.jdField_a_of_type_Int, paramFontInfo.jdField_a_of_type_JavaLangString, paramFloat, paramFontInfo.b, paramFontInfo.jdField_a_of_type_AndroidGraphicsTypeface);
      paramFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont = localETFont;
      paramFontInfo = localETFont;
    }
    if ((paramETTextView.mFont == null) || (!paramFontInfo.equals(paramETTextView.mFont))) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    paramETTextView.shouldStartAnimation = this.jdField_a_of_type_Boolean;
    long l = this.jdField_a_of_type_Long;
    paramFontInfo.mAnimationId = l;
    paramETTextView.setFont(paramFontInfo, l);
    paramETTextView.requestLayout();
  }
  
  public void b()
  {
    FontManagerForTool.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    Object localObject = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView;
    if (localObject != null)
    {
      ((ETTextView)localObject).setTextAnimationListener(null);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqVasFontApiIFontManagerService;
    if (localObject != null) {
      ((IFontManagerService)localObject).removeFontLoadCallback(this);
    }
    if (this.jdField_a_of_type_MqqAppAppRuntime != null) {
      this.jdField_a_of_type_MqqAppAppRuntime = null;
    }
  }
  
  public void onFontLoaded()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController.a().sendEmptyMessage(10003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adapter.SignatureFontAdapter
 * JD-Core Version:    0.7.0.1
 */