package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public class StructMsgItemLayout31
  extends AbsStructMsgItem
{
  public static ArrayList<AdExposureChecker> aA = new ArrayList();
  private static final int aB = Color.parseColor("#C7C7C7");
  public static AdExposureChecker.ExposureCallback az;
  private int aC;
  private int aD;
  
  @NotNull
  private LinearLayout a(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    paramContext = new LinearLayout(paramContext);
    paramContext.setId(2131443047);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(8, 2131443046);
    paramRelativeLayout.addView(paramContext, localLayoutParams);
    return paramContext;
  }
  
  private RelativeLayout a(Context paramContext)
  {
    paramContext = new RelativeLayout(paramContext);
    Object localObject = new RelativeLayout.LayoutParams(-1, ViewUtils.dpToPx(74.0F));
    paramContext.setPadding(this.aC, 0, this.aD, 0);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getItemRootView...left:");
      ((StringBuilder)localObject).append(this.aC);
      ((StringBuilder)localObject).append(",right:");
      ((StringBuilder)localObject).append(this.aD);
      ((StringBuilder)localObject).append(",top:");
      ((StringBuilder)localObject).append(0);
      ((StringBuilder)localObject).append(",bottom:");
      ((StringBuilder)localObject).append(0);
      QLog.i("QWalletGdtAdApi_StructMsgItemLayout31", 2, ((StringBuilder)localObject).toString());
    }
    return paramContext;
  }
  
  private void a(Context paramContext, RelativeLayout paramRelativeLayout, ImageView paramImageView, LinearLayout paramLinearLayout, TextView paramTextView)
  {
    paramLinearLayout = BaseApplicationImpl.sApplication.getRuntime().getAccount();
    String str1 = ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getString(paramLinearLayout, "walletPubMsgTail_title", "");
    String str2 = ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getString(paramLinearLayout, "walletPubMsgTail_jumpURL", "");
    String str3 = ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getString(paramLinearLayout, "walletPubMsgTail_imgURL", "");
    Drawable localDrawable = paramContext.getResources().getDrawable(2130849243);
    paramImageView.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(str3, localDrawable, localDrawable));
    paramTextView.setText(str1);
    paramRelativeLayout.setOnClickListener(new StructMsgItemLayout31.1(this, str2, paramContext, paramLinearLayout, str1));
  }
  
  private void a(Context paramContext, TextView paramTextView)
  {
    if ((paramContext instanceof BaseActivity))
    {
      paramContext = (IQWalletConfigService)((BaseActivity)paramContext).app.getRuntimeService(IQWalletConfigService.class, "");
      TextPaint localTextPaint = paramTextView.getPaint();
      boolean bool;
      if (paramContext.getInt("common", 0, new String[] { "pub_ad_control", "gdt_content_bold" }) == 1) {
        bool = true;
      } else {
        bool = false;
      }
      localTextPaint.setFakeBoldText(bool);
      paramTextView.setTextSize(1, Math.min(Math.max(paramContext.getInt("common", 24, new String[] { "pub_ad_control", "gdt_content_size" }), 24), 36) >> 1);
      try
      {
        paramTextView.setTextColor(Color.parseColor(paramContext.getString("common", "#000000", new String[] { "pub_ad_control", "gdt_content_color" })));
        return;
      }
      catch (Throwable paramContext)
      {
        QLog.e("QWalletGdtAdApi_StructMsgItemLayout31", 1, paramContext, new Object[0]);
        paramTextView.setTextColor(Color.parseColor("#000000"));
      }
    }
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    int i = paramRelativeLayout.getPaddingTop();
    int j = paramRelativeLayout.getPaddingBottom();
    paramRelativeLayout.setBackgroundResource(2130838313);
    paramRelativeLayout.setPadding(this.aC, i, this.aD, j);
  }
  
  @NotNull
  private TextView b(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    TextView localTextView = new TextView(paramContext);
    localTextView.setId(2131443044);
    localTextView.setText(paramContext.getResources().getText(2131914435));
    localTextView.setSingleLine(false);
    localTextView.setMaxLines(2);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(1, 2131443046);
    localLayoutParams.addRule(0, 2131443047);
    localLayoutParams.addRule(15);
    localLayoutParams.setMargins(ViewUtils.dip2px(12.0F), 0, ViewUtils.dip2px(12.0F), 0);
    paramRelativeLayout.addView(localTextView, localLayoutParams);
    a(paramContext, localTextView);
    return localTextView;
  }
  
  @NotNull
  private ImageView c(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    ImageView localImageView = new ImageView(paramContext);
    localImageView.setId(2131443046);
    int i = ViewUtils.dpToPx(50.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i * 16 / 9, i);
    localLayoutParams.addRule(15);
    localImageView.setImageDrawable(paramContext.getResources().getDrawable(2130849243));
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramRelativeLayout.addView(localImageView, localLayoutParams);
    return localImageView;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (paramBundle != null) {}
    try
    {
      if (paramBundle.getBoolean("isShowQWalletPubAd"))
      {
        this.aC = (paramContext.getResources().getDimensionPixelSize(2131299802) - ViewUtils.dip2px(3.0F));
        this.aD = (paramContext.getResources().getDimensionPixelSize(2131299803) - ViewUtils.dip2px(3.0F));
        if ((paramView instanceof RelativeLayout))
        {
          paramView = (RelativeLayout)paramView;
          paramView.removeAllViews();
        }
        else
        {
          paramView = a(paramContext);
        }
        a(paramView);
        a(paramContext, paramView, c(paramContext, paramView), a(paramContext, paramView), b(paramContext, paramView));
        return paramView;
      }
      paramContext = new View(paramContext);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      QLog.e("QWalletGdtAdApi_StructMsgItemLayout31", 1, paramContext, new Object[0]);
    }
    return null;
  }
  
  protected int c()
  {
    return 31;
  }
  
  public String e()
  {
    return "Layout31";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout31
 * JD-Core Version:    0.7.0.1
 */