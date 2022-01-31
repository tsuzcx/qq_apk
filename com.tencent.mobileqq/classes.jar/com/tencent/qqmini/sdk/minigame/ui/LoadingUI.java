package com.tencent.qqmini.sdk.minigame.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bglp;
import bgvs;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.widget.SquareImageView;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import java.util.ArrayList;

public class LoadingUI
  extends RelativeLayout
{
  int jdField_a_of_type_Int = DisplayUtil.dip2px(getContext(), 100.0F);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SquareImageView jdField_a_of_type_ComTencentQqminiSdkCoreWidgetSquareImageView;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private String jdField_a_of_type_JavaLangString = "0%";
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_b_of_type_AndroidWidgetProgressBar;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private SquareImageView jdField_b_of_type_ComTencentQqminiSdkCoreWidgetSquareImageView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  
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
  
  private String a(String paramString1, String paramString2)
  {
    int j = 0;
    try
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        if (TextUtils.isEmpty(paramString2)) {
          return null;
        }
        paramString1 = paramString1.split(";");
        if ((paramString1 != null) && (paramString1.length > 0)) {
          while (j < paramString1.length)
          {
            String[] arrayOfString = paramString1[j].split("\\|\\|");
            if ((arrayOfString != null) && (arrayOfString.length == 2) && (paramString2.equals(arrayOfString[0])))
            {
              paramString1 = arrayOfString[1];
              return paramString1;
            }
            j += 1;
          }
        }
      }
      return null;
    }
    catch (Throwable paramString1) {}
  }
  
  private void b()
  {
    inflate(getContext(), 2131559346, this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376957);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367037));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367058));
    this.d = ((TextView)findViewById(2131368987));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363630));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363541));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367041));
    this.g = ((TextView)findViewById(2131365170));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131365171));
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetSquareImageView = ((SquareImageView)findViewById(2131369845));
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetSquareImageView.setRoundRect(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363407));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370632));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367036));
    this.jdField_b_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131370630));
    this.i = ((TextView)findViewById(2131370631));
    this.h = ((TextView)findViewById(2131370629));
    this.jdField_b_of_type_ComTencentQqminiSdkCoreWidgetSquareImageView = ((SquareImageView)findViewById(2131370628));
    this.jdField_b_of_type_ComTencentQqminiSdkCoreWidgetSquareImageView.setRoundRect(10);
    this.e = ((TextView)findViewById(2131379077));
    this.f = ((TextView)findViewById(2131376906));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131376903));
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
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name);
      this.h.setText(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name);
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
          int j = 0;
          for (;;)
          {
            if (j < this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.qualifications.size())
            {
              if ((j > 0) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.qualifications.get(j - 1)))) {
                ((StringBuilder)localObject1).append("\n");
              }
              if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.qualifications.get(j))) {
                ((StringBuilder)localObject1).append((String)this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.qualifications.get(j));
              }
              j += 1;
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
            localObject1 = getContext().getResources().getDrawable(2130840873);
            localObject2 = ((MiniAppProxy)localObject2).getDrawable(getContext(), this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.iconUrl, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, (Drawable)localObject1);
            if (localObject2 != null) {
              break label382;
            }
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetSquareImageView.setImageDrawable((Drawable)localObject1);
      this.jdField_b_of_type_ComTencentQqminiSdkCoreWidgetSquareImageView.setImageDrawable((Drawable)localObject1);
      e();
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      break;
      label382:
      localObject1 = localObject2;
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_Boolean = false;
    setVisibility(8);
  }
  
  private void e()
  {
    Object localObject2 = a(GameWnsUtils.getFakeFristFrameUrl(), this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId);
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) || (bglp.a((String)localObject2))) {}
    for (;;)
    {
      try
      {
        MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
        Drawable localDrawable = getContext().getResources().getDrawable(2131167138);
        localObject2 = localMiniAppProxy.getDrawable(getContext(), (String)localObject2, getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, localDrawable);
        if (localObject2 == null)
        {
          this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
          localMiniAppProxy.setDrawableCallback(localDrawable, new bgvs(this));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        return;
      }
      Object localObject1 = localObject2;
    }
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
  
  public void setProgressInt(float paramFloat)
  {
    this.jdField_b_of_type_AndroidWidgetProgressBar.setProgress((int)(paramFloat * 100.0F));
    this.i.setText((int)(100.0F * paramFloat) + "%");
  }
  
  public void setProgressTxt(String paramString)
  {
    this.e.setText(paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.ui.LoadingUI
 * JD-Core Version:    0.7.0.1
 */