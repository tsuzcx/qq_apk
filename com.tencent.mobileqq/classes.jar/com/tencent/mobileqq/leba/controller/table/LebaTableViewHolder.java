package com.tencent.mobileqq.leba.controller.table;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.leba.LebaConstant;
import com.tencent.mobileqq.leba.business.ILebaDiyIconPart;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.entity.UpdateRedTouchParam;
import com.tencent.mobileqq.leba.redtouch.LebaRedTouchBase;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchTempApi;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.TextHook;
import com.tencent.widget.ThemeURLImageView;
import mqq.app.AppRuntime;

public class LebaTableViewHolder
{
  private int jdField_a_of_type_Int = 18;
  public View a;
  public ImageView a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  public ILebaDiyIconPart a;
  public RedTouch a;
  public RoundRelativeLayout a;
  private ThemeURLImageView jdField_a_of_type_ComTencentWidgetThemeURLImageView;
  private ImageView b;
  public TextView b;
  public TextView c;
  public TextView d;
  private TextView e;
  
  public LebaTableViewHolder(Context paramContext, LayoutInflater paramLayoutInflater, int paramInt, ILebaDiyIconPart paramILebaDiyIconPart)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561146, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundRelativeLayout = ((RoundRelativeLayout)paramLayoutInflater.findViewById(2131376843));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131369917));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131369387));
    this.jdField_a_of_type_ComTencentWidgetThemeURLImageView = ((ThemeURLImageView)paramLayoutInflater.findViewById(2131369275));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379510));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379511));
    this.e = ((TextView)paramLayoutInflater.findViewById(2131379778));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131369558));
    this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaDiyIconPart = paramILebaDiyIconPart;
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379840));
    if (paramInt == 1)
    {
      this.d = ((TextView)paramLayoutInflater.findViewById(2131379841));
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(paramContext, paramLayoutInflater).b(17).c(16).f(28).a();
    }
    else
    {
      this.d = ((TextView)paramLayoutInflater.findViewById(2131379842));
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(paramContext, paramLayoutInflater).b(53).e(12).d(12).a();
    }
    paramContext = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
    paramContext.jdField_a_of_type_AndroidWidgetTextView = this.jdField_c_of_type_AndroidWidgetTextView;
    paramContext.jdField_b_of_type_AndroidWidgetTextView = this.d;
    paramContext.jdField_a_of_type_AndroidWidgetImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    paramContext.jdField_b_of_type_AndroidWidgetImageView = this.jdField_b_of_type_AndroidWidgetImageView;
    paramContext.jdField_c_of_type_AndroidWidgetImageView = this.jdField_a_of_type_ComTencentWidgetThemeURLImageView;
    paramContext.jdField_c_of_type_AndroidWidgetTextView = this.e;
    paramContext.d = this.jdField_a_of_type_AndroidWidgetTextView;
    paramContext.e = this.jdField_b_of_type_AndroidWidgetTextView;
    this.jdField_a_of_type_AndroidViewView = paramContext;
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" thread:");
      localStringBuilder.append(Thread.currentThread().getId());
      localStringBuilder.append(" v:");
      localStringBuilder.append(paramTextView.getVisibility());
      localStringBuilder.append(" w:");
      localStringBuilder.append(paramTextView.getWidth());
      localStringBuilder.append(" h:");
      localStringBuilder.append(paramTextView.getHeight());
      localStringBuilder.append(" x:");
      localStringBuilder.append(paramTextView.getX());
      localStringBuilder.append(" y:");
      localStringBuilder.append(paramTextView.getY());
      localStringBuilder.append(" colors:");
      localStringBuilder.append(paramTextView.getTextColors());
      localStringBuilder.append(" text:");
      localStringBuilder.append(paramTextView.getText());
      QLog.i("LebaTableViewHolder", 1, localStringBuilder.toString());
      return;
    }
    catch (Exception paramTextView)
    {
      QLog.i("LebaTableViewHolder", 1, "", paramTextView);
    }
  }
  
  public void a()
  {
    ((IRedTouchTempApi)QRoute.api(IRedTouchTempApi.class)).removeLebaIconAnim(this.jdField_a_of_type_ComTencentWidgetThemeURLImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.e, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView);
  }
  
  public void a(@NonNull LebaTableViewHolder.BindDataParam paramBindDataParam)
  {
    LebaViewItem localLebaViewItem = paramBindDataParam.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem;
    Context localContext = paramBindDataParam.jdField_a_of_type_AndroidContentContext;
    Object localObject2 = paramBindDataParam.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    int j = paramBindDataParam.jdField_a_of_type_Int;
    AppRuntime localAppRuntime = paramBindDataParam.jdField_a_of_type_MqqAppAppRuntime;
    LebaRedTouchBase localLebaRedTouchBase = paramBindDataParam.jdField_a_of_type_ComTencentMobileqqLebaRedtouchLebaRedTouchBase;
    boolean bool1 = paramBindDataParam.jdField_a_of_type_Boolean;
    boolean bool2 = paramBindDataParam.jdField_b_of_type_Boolean;
    int i = paramBindDataParam.jdField_b_of_type_Int;
    if (bool1) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130840561);
    } else {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839393);
    }
    LebaConstant.a(this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.jdField_b_of_type_AndroidWidgetImageView, bool1);
    Object localObject1 = "";
    if ((localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null))
    {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramBindDataParam.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidViewView.setEnabled(true);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (!TextUtils.isEmpty(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strGridIconUrl))
      {
        paramBindDataParam = URLDrawable.URLDrawableOptions.obtain();
        paramBindDataParam.mRequestWidth = ViewUtils.b(32.0F);
        paramBindDataParam.mRequestHeight = paramBindDataParam.mRequestWidth;
        paramBindDataParam.mLoadingDrawable = ((Drawable)localObject2);
        paramBindDataParam.mFailedDrawable = ((Drawable)localObject2);
        paramBindDataParam = URLDrawable.getDrawable(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strGridIconUrl, paramBindDataParam);
        paramBindDataParam.setTargetDensity(j);
        if (paramBindDataParam.getStatus() == 2) {
          paramBindDataParam.restartDownload();
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaDiyIconPart;
        if ((localObject2 != null) && (((ILebaDiyIconPart)localObject2).addPersonalBackgroundToIcon(localContext, this.jdField_b_of_type_AndroidWidgetImageView, (int)localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId)))
        {
          paramBindDataParam.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
          localObject2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
          int m = ((RelativeLayout.LayoutParams)localObject2).width;
          j = ((RelativeLayout.LayoutParams)localObject2).height;
          int k = ViewUtils.a(this.jdField_a_of_type_Int);
          localObject2 = this.jdField_b_of_type_AndroidWidgetImageView;
          m = (m - k) / 2;
          j = (j - k) / 2;
          ((ImageView)localObject2).setPadding(m, j, m, j);
        }
        else
        {
          paramBindDataParam.setColorFilter(-1, PorterDuff.Mode.DST_IN);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramBindDataParam);
          ViewUtils.a(this.jdField_b_of_type_AndroidWidgetImageView, null);
          this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramBindDataParam);
        this.jdField_b_of_type_AndroidWidgetImageView.invalidate();
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      }
      this.e.setVisibility(0);
      if (TextUtils.isEmpty(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName)) {
        paramBindDataParam = (LebaTableViewHolder.BindDataParam)localObject1;
      } else {
        paramBindDataParam = localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName;
      }
      this.e.setText(paramBindDataParam);
      TextHook.updateFont(this.jdField_a_of_type_AndroidViewView);
      if (TextUtils.isEmpty(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName))
      {
        localObject1 = this.e;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" tvName.setText:");
        ((StringBuilder)localObject2).append(paramBindDataParam);
        ((StringBuilder)localObject2).append(" index:");
        ((StringBuilder)localObject2).append(i);
        a((TextView)localObject1, ((StringBuilder)localObject2).toString());
      }
      if (AppSetting.d) {
        AccessibilityUtil.a(this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch, paramBindDataParam, Button.class.getName());
      }
      if (localLebaRedTouchBase != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.jdField_a_of_type_JavaLangString = localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.resConf;
        this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.h = bool2;
        paramBindDataParam = new UpdateRedTouchParam();
        paramBindDataParam.jdField_a_of_type_MqqAppAppRuntime = localAppRuntime;
        paramBindDataParam.jdField_a_of_type_AndroidContentContext = localContext;
        paramBindDataParam.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
        paramBindDataParam.jdField_a_of_type_Long = localLebaViewItem.jdField_a_of_type_Long;
        paramBindDataParam.jdField_a_of_type_JavaLangString = localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName;
        paramBindDataParam.jdField_a_of_type_Int = i;
        paramBindDataParam.jdField_a_of_type_Boolean = true;
        localLebaRedTouchBase.a(paramBindDataParam);
        this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.b();
      }
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
    this.jdField_a_of_type_AndroidViewView.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.e.setVisibility(8);
    if (AppSetting.d) {
      AccessibilityUtil.a(this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch, "", Button.class.getName());
    }
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.d();
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.d.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetThemeURLImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.controller.table.LebaTableViewHolder
 * JD-Core Version:    0.7.0.1
 */