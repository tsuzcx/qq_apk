package com.tencent.mobileqq.olympic.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.PromotionItem;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionPath;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionUtil;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;

public class PromotionGuide
{
  static final String a;
  boolean b = false;
  private Activity c;
  private PromotionGuide.OnPromotionStatusListener d;
  private ViewGroup e;
  private TextView f;
  private ImageView g;
  private LottieDrawable h = null;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(PromotionUtil.a);
    localStringBuilder.append("_Guide");
    a = localStringBuilder.toString();
  }
  
  public PromotionGuide(Activity paramActivity)
  {
    this.c = paramActivity;
    this.e = ((ViewGroup)this.c.findViewById(2131450241));
    this.f = ((TextView)this.c.findViewById(2131450242));
    this.g = ((ImageView)this.c.findViewById(2131450240));
  }
  
  private boolean a()
  {
    PromotionGuide.OnPromotionStatusListener localOnPromotionStatusListener = this.d;
    return (localOnPromotionStatusListener == null) || ((localOnPromotionStatusListener != null) && (!localOnPromotionStatusListener.j()));
  }
  
  public void a(int paramInt)
  {
    boolean bool = a();
    int i = 1;
    StringBuilder localStringBuilder;
    if (bool)
    {
      localObject = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("showText, isDestroyed, textIndex[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      return;
    }
    Object localObject = this.d;
    if (localObject == null)
    {
      localObject = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("showText, mPromotionRes为null, textIndex[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      return;
    }
    localObject = ((PromotionGuide.OnPromotionStatusListener)localObject).getCurrentPromotionItem();
    if (localObject != null)
    {
      localObject = ((PromotionConfigInfo.PromotionItem)localObject).a(paramInt);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.f.setText((CharSequence)localObject);
        paramInt = i;
        break label166;
      }
    }
    paramInt = 0;
    label166:
    localObject = this.f;
    if (paramInt != 0) {
      i = 0;
    } else {
      i = 8;
    }
    ((TextView)localObject).setVisibility(i);
    if (paramInt != 0)
    {
      this.e.setVisibility(0);
      return;
    }
    this.e.setVisibility(this.g.getVisibility());
  }
  
  public void a(AppInterface paramAppInterface)
  {
    this.c = null;
    paramAppInterface = this.g;
    if (paramAppInterface != null) {
      paramAppInterface.setImageDrawable(null);
    }
    paramAppInterface = this.h;
    if (paramAppInterface != null)
    {
      paramAppInterface.cancelAnimation();
      this.h = null;
    }
  }
  
  public void a(PromotionConfigInfo.PromotionItem paramPromotionItem)
  {
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadRes, hadLoad[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (a()) {
      return;
    }
    if (this.b) {
      return;
    }
    this.b = true;
    localObject = this.c.getResources();
    int i = ((Resources)localObject).getDisplayMetrics().densityDpi;
    int j = ((Resources)localObject).getDisplayMetrics().densityDpi;
    paramPromotionItem = PromotionPath.b(paramPromotionItem);
    if (TextUtils.isEmpty(paramPromotionItem))
    {
      QLog.w(a, 1, "PromotionGuide, path is null");
      return;
    }
    if (!new File(paramPromotionItem).exists())
    {
      QLog.w(a, 1, "PromotionGuide, file not exist");
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramPromotionItem);
    ((StringBuilder)localObject).append("guide.json");
    localObject = ((StringBuilder)localObject).toString();
    paramPromotionItem = new PromotionGuide.1(this, paramPromotionItem, i, j);
    try
    {
      LottieComposition.Factory.fromInputStream(this.c, new FileInputStream((String)localObject), paramPromotionItem);
      return;
    }
    catch (Exception paramPromotionItem)
    {
      localObject = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadWorldCupGuideAnimation failed. err = ");
      localStringBuilder.append(paramPromotionItem.getMessage());
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
  }
  
  public void a(PromotionGuide.OnPromotionStatusListener paramOnPromotionStatusListener)
  {
    this.d = paramOnPromotionStatusListener;
  }
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView = this.g;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
    if (paramBoolean)
    {
      this.e.setVisibility(0);
      return;
    }
    this.e.setVisibility(this.f.getVisibility());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.PromotionGuide
 * JD-Core Version:    0.7.0.1
 */