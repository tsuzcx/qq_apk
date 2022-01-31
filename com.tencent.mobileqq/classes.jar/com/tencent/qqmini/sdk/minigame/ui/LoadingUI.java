package com.tencent.qqmini.sdk.minigame.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bffu;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.widget.SquareImageView;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.ArrayList;

public class LoadingUI
  extends RelativeLayout
{
  int jdField_a_of_type_Int = bffu.a(getContext(), 100.0F);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SquareImageView jdField_a_of_type_ComTencentQqminiSdkCoreWidgetSquareImageView;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private String jdField_a_of_type_JavaLangString = "0%";
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  
  public LoadingUI(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LoadingUI(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LoadingUI(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    inflate(getContext(), 2131559298, this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376455);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366919));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366940));
    this.d = ((TextView)findViewById(2131368768));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363586));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363501));
    this.c = ((TextView)findViewById(2131366923));
    this.g = ((TextView)findViewById(2131365086));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131365087));
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetSquareImageView = ((SquareImageView)findViewById(2131369583));
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetSquareImageView.setRoundRect(this.jdField_a_of_type_Int);
    this.e = ((TextView)findViewById(2131378460));
    this.f = ((TextView)findViewById(2131376400));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131376397));
  }
  
  private void c()
  {
    this.jdField_a_of_type_Boolean = true;
    this.e.setText(this.jdField_a_of_type_JavaLangString);
    this.f.setText(this.jdField_a_of_type_JavaLangString);
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null)
    {
      this.c.setText(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.developerDesc)) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.qualifications != null) && (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.qualifications.size() > 0))
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          localObject1 = new StringBuilder();
          int i = 0;
          for (;;)
          {
            if (i < this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.qualifications.size())
            {
              if ((i > 0) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.qualifications.get(i - 1)))) {
                ((StringBuilder)localObject1).append("\n");
              }
              if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.qualifications.get(i))) {
                ((StringBuilder)localObject1).append((String)this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.qualifications.get(i));
              }
              i += 1;
              continue;
              this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              this.g.setText("由" + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.developerDesc + "提供");
              break;
            }
          }
          this.jdField_b_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject1).toString());
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.iconUrl))
          {
            localObject2 = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
            localObject1 = getContext().getResources().getDrawable(2130840764);
            localObject2 = ((MiniAppProxy)localObject2).getDrawable(getContext(), this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.iconUrl, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, (Drawable)localObject1);
            if (localObject2 != null) {
              break label356;
            }
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetSquareImageView.setImageDrawable((Drawable)localObject1);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      break;
      label356:
      localObject1 = localObject2;
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_Boolean = false;
    setVisibility(8);
  }
  
  public LoadingUI a(MiniAppInfo paramMiniAppInfo)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
    return this;
  }
  
  public void a()
  {
    d();
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (getVisibility() != 0) {
      setVisibility(0);
    }
    if (getParent() != null) {
      ((ViewGroup)getParent()).removeView(this);
    }
    paramViewGroup.addView(this);
    c();
  }
  
  public void setProgressTxt(String paramString)
  {
    this.e.setText(paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.ui.LoadingUI
 * JD-Core Version:    0.7.0.1
 */