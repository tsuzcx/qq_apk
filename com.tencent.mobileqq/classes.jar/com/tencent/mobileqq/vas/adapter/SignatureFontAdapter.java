package com.tencent.mobileqq.vas.adapter;

import android.os.Bundle;
import android.os.Handler;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.ETTextView.TextAnimationListener;
import com.etrump.mixlayout.FontInfo;
import com.etrump.mixlayout.FontManager;
import com.etrump.mixlayout.FontManager.FontLoadCallback;
import com.etrump.mixlayout.FontManagerForTool;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.util.AppUtil;
import com.tencent.mobileqq.vas.VasResEngine.VasRes;
import com.tencent.mobileqq.vas.VasResEngine.VasResAdapter;
import com.tencent.mobileqq.vas.VasResEngine.VasResController;
import com.tencent.qphone.base.util.QLog;
import java.util.Observer;
import mqq.app.AppRuntime;

public class SignatureFontAdapter
  implements FontManager.FontLoadCallback, VasResAdapter
{
  private float jdField_a_of_type_Float;
  protected int a;
  private long jdField_a_of_type_Long = System.currentTimeMillis();
  private ETTextView.TextAnimationListener jdField_a_of_type_ComEtrumpMixlayoutETTextView$TextAnimationListener = new SignatureFontAdapter.2(this);
  private ETTextView jdField_a_of_type_ComEtrumpMixlayoutETTextView;
  protected FontManager a;
  protected VasResController a;
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
    if ((this.jdField_a_of_type_MqqAppAppRuntime != null) && ((this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface)))
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutFontManager = ((FontManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.CHAT_FONT_MANAGER));
      this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a(this);
      return this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a(paramInt1, paramInt2, false, ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getCurrentUin(), 0);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController.a().sendEmptyMessage(10003);
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
    b();
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SignatureFontAdapter", 2, "downloadDone type = " + paramInt);
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
    for (;;)
    {
      if ((paramETTextView.mFont == null) || (!paramFontInfo.equals(paramETTextView.mFont))) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      paramETTextView.shouldStartAnimation = this.jdField_a_of_type_Boolean;
      paramFontInfo.mAnimationId = this.jdField_a_of_type_Long;
      paramETTextView.setFont(paramFontInfo, this.jdField_a_of_type_Long);
      paramETTextView.requestLayout();
      return;
      ETFont localETFont = new ETFont(paramFontInfo.jdField_a_of_type_Int, paramFontInfo.jdField_a_of_type_JavaLangString, paramFloat, paramFontInfo.b, paramFontInfo.jdField_a_of_type_AndroidGraphicsTypeface);
      paramFontInfo.jdField_a_of_type_ComEtrumpMixlayoutETFont = localETFont;
      paramFontInfo = localETFont;
    }
  }
  
  public void b()
  {
    if (AppUtil.a()) {}
    for (FontInfo localFontInfo = a(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController.a(), this.jdField_a_of_type_Int);; localFontInfo = FontManagerForTool.a().a(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController.a(), this.jdField_a_of_type_Int))
    {
      QLog.i("SignatureFontAdapter", 1, "load " + localFontInfo + " fontId:" + this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController.a());
      if ((localFontInfo != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null)) {
        a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, localFontInfo, this.jdField_a_of_type_Float);
      }
      return;
    }
  }
  
  public void c()
  {
    FontManagerForTool.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextAnimationListener(null);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = null;
    }
    if (this.jdField_a_of_type_ComEtrumpMixlayoutFontManager != null) {
      this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.b(this);
    }
    if (this.jdField_a_of_type_MqqAppAppRuntime != null) {
      this.jdField_a_of_type_MqqAppAppRuntime = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adapter.SignatureFontAdapter
 * JD-Core Version:    0.7.0.1
 */