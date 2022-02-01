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
  protected VasResController a;
  protected int b;
  protected AppRuntime c;
  protected IFontManagerService d;
  private long e = System.currentTimeMillis();
  private ETTextView f;
  private float g;
  private boolean h;
  private int i = 1;
  private int j = 1;
  private Observer k = new SignatureFontAdapter.1(this);
  private ETTextView.TextAnimationListener l = new SignatureFontAdapter.2(this);
  
  public SignatureFontAdapter(AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    VasRes localVasRes = new VasRes(paramAppInterface, paramInt1);
    this.a = localVasRes.b();
    this.b = paramInt2;
    FontManagerForTool.a().addObserver(this.k);
    localVasRes.a(this);
    this.c = paramAppInterface;
  }
  
  public SignatureFontAdapter(VasRes paramVasRes, AppRuntime paramAppRuntime, int paramInt)
  {
    this.a = paramVasRes.b();
    this.c = paramAppRuntime;
    this.b = paramInt;
    FontManagerForTool.a().addObserver(this.k);
  }
  
  public void a()
  {
    FontInfo localFontInfo;
    if (AppUtil.a()) {
      localFontInfo = b(this.a.b(), this.b);
    } else {
      localFontInfo = FontManagerForTool.a().a(this.a.b(), this.b);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("load ");
    ((StringBuilder)localObject).append(localFontInfo);
    ((StringBuilder)localObject).append(" fontId:");
    ((StringBuilder)localObject).append(this.a.b());
    QLog.i("SignatureFontAdapter", 1, ((StringBuilder)localObject).toString());
    if (localFontInfo != null)
    {
      localObject = this.f;
      if (localObject != null) {
        a((ETTextView)localObject, localFontInfo, this.g);
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      this.f.setFont(0, System.currentTimeMillis());
      return;
    }
    this.a.a(paramInt1);
    this.b = paramInt2;
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
    this.f = paramETTextView;
    this.g = paramFloat;
    this.h = paramBoolean;
    this.f.setTextAnimationListener(this.l);
  }
  
  protected void a(ETTextView paramETTextView, FontInfo paramFontInfo, float paramFloat)
  {
    if (paramFontInfo.a == 0)
    {
      paramETTextView.setFont(0, System.currentTimeMillis());
      return;
    }
    if (paramFontInfo.f != null)
    {
      paramFontInfo = paramFontInfo.f;
      paramFontInfo.setSize(paramFloat);
    }
    else
    {
      ETFont localETFont = new ETFont(paramFontInfo.a, paramFontInfo.b, paramFloat, paramFontInfo.c, paramFontInfo.d);
      paramFontInfo.f = localETFont;
      paramFontInfo = localETFont;
    }
    if ((paramETTextView.mFont == null) || (!paramFontInfo.equals(paramETTextView.mFont))) {
      this.e = System.currentTimeMillis();
    }
    paramETTextView.shouldStartAnimation = this.h;
    long l1 = this.e;
    paramFontInfo.mAnimationId = l1;
    paramETTextView.setFont(paramFontInfo, l1);
    paramETTextView.requestLayout();
  }
  
  protected FontInfo b(int paramInt1, int paramInt2)
  {
    AppRuntime localAppRuntime = this.c;
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)))
    {
      this.d = ((IFontManagerService)localAppRuntime.getRuntimeService(IFontManagerService.class, ""));
      this.d.addFontLoadCallback(this);
      return this.d.getFontInfo(paramInt1, paramInt2, false, ((QQAppInterface)this.c).getCurrentUin(), 0);
    }
    return null;
  }
  
  public void b()
  {
    FontManagerForTool.a().deleteObserver(this.k);
    Object localObject = this.f;
    if (localObject != null)
    {
      ((ETTextView)localObject).setTextAnimationListener(null);
      this.f = null;
    }
    localObject = this.d;
    if (localObject != null) {
      ((IFontManagerService)localObject).removeFontLoadCallback(this);
    }
    if (this.c != null) {
      this.c = null;
    }
  }
  
  public void onFontLoaded()
  {
    this.a.a().sendEmptyMessage(10003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adapter.SignatureFontAdapter
 * JD-Core Version:    0.7.0.1
 */