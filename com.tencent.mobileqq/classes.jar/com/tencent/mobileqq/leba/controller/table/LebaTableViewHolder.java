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
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;
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
  private ThemeImageView jdField_a_of_type_ComTencentWidgetThemeImageView;
  private ThemeURLImageView jdField_a_of_type_ComTencentWidgetThemeURLImageView;
  public TextView b;
  public TextView c;
  public TextView d;
  private TextView e;
  
  public LebaTableViewHolder(Context paramContext, LayoutInflater paramLayoutInflater, int paramInt, ILebaDiyIconPart paramILebaDiyIconPart)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561303, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundRelativeLayout = ((RoundRelativeLayout)paramLayoutInflater.findViewById(2131377393));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131370249));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)paramLayoutInflater.findViewById(2131369690));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(ThemeImageWrapper.MODE_OTHER);
    this.jdField_a_of_type_ComTencentWidgetThemeURLImageView = ((ThemeURLImageView)paramLayoutInflater.findViewById(2131369564));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131380191));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131380192));
    this.e = ((TextView)paramLayoutInflater.findViewById(2131380475));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131369873));
    this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaDiyIconPart = paramILebaDiyIconPart;
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131380555));
    if (paramInt == 1) {
      this.d = ((TextView)paramLayoutInflater.findViewById(2131380556));
    }
    for (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(paramContext, paramLayoutInflater).b(17).c(16).f(28).a();; this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(paramContext, paramLayoutInflater).b(53).e(12).d(12).a())
    {
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.jdField_a_of_type_AndroidWidgetTextView = this.jdField_c_of_type_AndroidWidgetTextView;
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.jdField_b_of_type_AndroidWidgetTextView = this.d;
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.jdField_a_of_type_AndroidWidgetImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.jdField_b_of_type_AndroidWidgetImageView = this.jdField_a_of_type_ComTencentWidgetThemeImageView;
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.jdField_c_of_type_AndroidWidgetImageView = this.jdField_a_of_type_ComTencentWidgetThemeURLImageView;
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.jdField_c_of_type_AndroidWidgetTextView = this.e;
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.d = this.jdField_a_of_type_AndroidWidgetTextView;
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.e = this.jdField_b_of_type_AndroidWidgetTextView;
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
      return;
      this.d = ((TextView)paramLayoutInflater.findViewById(2131380557));
    }
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    try
    {
      QLog.i("LebaTableViewHolder", 1, paramString + " thread:" + Thread.currentThread().getId() + " v:" + paramTextView.getVisibility() + " w:" + paramTextView.getWidth() + " h:" + paramTextView.getHeight() + " x:" + paramTextView.getX() + " y:" + paramTextView.getY() + " colors:" + paramTextView.getTextColors() + " text:" + paramTextView.getText());
      return;
    }
    catch (Exception paramTextView)
    {
      QLog.i("LebaTableViewHolder", 1, "", paramTextView);
    }
  }
  
  public void a()
  {
    ((IRedTouchTempApi)QRoute.api(IRedTouchTempApi.class)).removeLebaIconAnim(this.jdField_a_of_type_ComTencentWidgetThemeURLImageView, this.jdField_a_of_type_ComTencentWidgetThemeImageView, this.e, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView);
  }
  
  public void a(@NonNull LebaTableViewHolder.BindDataParam paramBindDataParam)
  {
    LebaViewItem localLebaViewItem = paramBindDataParam.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem;
    Context localContext = paramBindDataParam.jdField_a_of_type_AndroidContentContext;
    Object localObject = paramBindDataParam.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    int j = paramBindDataParam.jdField_a_of_type_Int;
    AppRuntime localAppRuntime = paramBindDataParam.jdField_a_of_type_MqqAppAppRuntime;
    LebaRedTouchBase localLebaRedTouchBase = paramBindDataParam.jdField_a_of_type_ComTencentMobileqqLebaRedtouchLebaRedTouchBase;
    boolean bool1 = paramBindDataParam.jdField_a_of_type_Boolean;
    boolean bool2 = paramBindDataParam.jdField_b_of_type_Boolean;
    int i = paramBindDataParam.jdField_b_of_type_Int;
    if (bool1) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130840686);
    }
    while ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo == null))
    {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setVisibility(8);
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
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839537);
    }
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramBindDataParam.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidViewView.setEnabled(true);
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setVisibility(0);
    if (!TextUtils.isEmpty(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strGridIconUrl))
    {
      paramBindDataParam = URLDrawable.URLDrawableOptions.obtain();
      paramBindDataParam.mRequestWidth = ViewUtils.b(32.0F);
      paramBindDataParam.mRequestHeight = paramBindDataParam.mRequestWidth;
      paramBindDataParam.mLoadingDrawable = ((Drawable)localObject);
      paramBindDataParam.mFailedDrawable = ((Drawable)localObject);
      paramBindDataParam = URLDrawable.getDrawable(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strGridIconUrl, paramBindDataParam);
      paramBindDataParam.setTargetDensity(j);
      if (paramBindDataParam.getStatus() == 2) {
        paramBindDataParam.restartDownload();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaDiyIconPart != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaDiyIconPart.addPersonalBackgroundToIcon(localContext, this.jdField_a_of_type_ComTencentWidgetThemeImageView, (int)localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId)))
      {
        paramBindDataParam.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetThemeImageView.getLayoutParams();
        j = ((RelativeLayout.LayoutParams)localObject).width;
        int k = ((RelativeLayout.LayoutParams)localObject).height;
        int m = ViewUtils.a(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentWidgetThemeImageView.setPadding((j - m) / 2, (k - m) / 2, (j - m) / 2, (k - m) / 2);
        label429:
        this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(paramBindDataParam);
        this.jdField_a_of_type_ComTencentWidgetThemeImageView.invalidate();
        label444:
        this.e.setVisibility(0);
        if (!TextUtils.isEmpty(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName)) {
          break label719;
        }
      }
    }
    label719:
    for (paramBindDataParam = "";; paramBindDataParam = localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName)
    {
      this.e.setText(paramBindDataParam);
      TextHook.updateFont(this.jdField_a_of_type_AndroidViewView);
      if (TextUtils.isEmpty(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName)) {
        a(this.e, " tvName.setText:" + paramBindDataParam + " index:" + i);
      }
      if (AppSetting.d) {
        AccessibilityUtil.a(this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch, paramBindDataParam, Button.class.getName());
      }
      if (localLebaRedTouchBase == null) {
        break;
      }
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
      return;
      paramBindDataParam.setColorFilter(-1, PorterDuff.Mode.DST_IN);
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(paramBindDataParam);
      ViewUtils.a(this.jdField_a_of_type_ComTencentWidgetThemeImageView, null);
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setPadding(0, 0, 0, 0);
      break label429;
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable((Drawable)localObject);
      break label444;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.controller.table.LebaTableViewHolder
 * JD-Core Version:    0.7.0.1
 */