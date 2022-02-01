package com.tencent.mobileqq.kandian.biz.pts.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.pts.constants.IReadInJoyUninterestComplainFragmentConst;
import com.tencent.mobileqq.kandian.biz.ugc.Utils;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ReadInJoyUninterestComplainFragment
  extends QIphoneTitleBarFragment
  implements TextWatcher, View.OnClickListener, IReadInJoyUninterestComplainFragmentConst
{
  private int jdField_a_of_type_Int;
  private Parcelable jdField_a_of_type_AndroidOsParcelable;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private EditText b;
  private TextView g;
  
  private void a(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("ad_complain_tel", paramString2);
    localBundle.putString("ad_complain_txt", paramString1);
    int i = this.jdField_a_of_type_Int;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        paramString1 = (AdData)this.jdField_a_of_type_AndroidOsParcelable;
        ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(getQBaseActivity()).a(3).b(1).a(((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(paramString1)).a(localBundle));
        return;
      }
      paramString1 = (VideoAdInfo)this.jdField_a_of_type_AndroidOsParcelable;
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(getQBaseActivity()).a(3).b(10).a(((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramString1)).a(paramString1).a(localBundle));
      return;
    }
    paramString1 = (AdvertisementInfo)this.jdField_a_of_type_AndroidOsParcelable;
    if (RIJFeedsType.a(paramString1)) {
      i = 11;
    } else {
      i = 3;
    }
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(getQBaseActivity()).a(3).b(i).a(paramString1).a(localBundle));
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.changeBg(true);
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131712746));
    }
    a(HardCodeUtil.a(2131712763));
    if (ThemeUtil.isInNightMode(ReadInJoyUtils.a())) {
      View.inflate(getQBaseActivity(), 2131560251, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_b_of_type_AndroidViewView.findViewById(2131365052));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.g = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131365265));
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)this.jdField_b_of_type_AndroidViewView.findViewById(2131372527));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131378061));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Int = getArguments().getInt("key_from_type", 0);
    this.jdField_a_of_type_AndroidOsParcelable = getArguments().getParcelable("key_ad_info");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initData fromType:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(", adinfo:");
      localStringBuilder.append(this.jdField_a_of_type_AndroidOsParcelable);
      QLog.d("ReadInJoyUninterestComplainFragment", 2, localStringBuilder.toString());
    }
    int i = this.jdField_a_of_type_Int;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          onBackEvent();
          return;
        }
        if (!(this.jdField_a_of_type_AndroidOsParcelable instanceof AdData))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ReadInJoyUninterestComplainFragment", 2, "adinfo is not AdData");
          }
          onBackEvent();
        }
      }
      else if (!(this.jdField_a_of_type_AndroidOsParcelable instanceof VideoAdInfo))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoyUninterestComplainFragment", 2, "adinfo is not VideoAdInfo");
        }
        onBackEvent();
      }
    }
    else if (!(this.jdField_a_of_type_AndroidOsParcelable instanceof AdvertisementInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyUninterestComplainFragment", 2, "adinfo is not AdvertisementInfo");
      }
      onBackEvent();
    }
  }
  
  private void f()
  {
    View localView = getQBaseActivity().getCurrentFocus();
    if (((InputMethodManager)getQBaseActivity().getSystemService("input_method")).showSoftInput(localView, 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUninterestComplainFragment", 2, "showKeyboard success");
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.e("ReadInJoyUninterestComplainFragment", 2, "showKeyboard fail");
    }
  }
  
  private void g()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_ad_info", this.jdField_a_of_type_AndroidOsParcelable);
    getQBaseActivity().setResult(-1, localIntent);
  }
  
  protected int a()
  {
    return 2131560310;
  }
  
  public void a()
  {
    View localView = getQBaseActivity().getCurrentFocus();
    if (localView != null) {
      ((InputMethodManager)getQBaseActivity().getSystemService("input_method")).hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    c();
    d();
    e();
    RIJDtReportHelper.a.a(getQBaseActivity());
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    this.g.setText(String.valueOf(getResources().getInteger(2131427370) - paramEditable.length()));
    if (paramEditable.trim().length() > 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getQBaseActivity().getWindow().setSoftInputMode(1);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131378061) {
      return;
    }
    a();
    paramView = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    String str = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString().trim();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSubmitClick complaints:");
      localStringBuilder.append(paramView);
      QLog.d("ReadInJoyUninterestComplainFragment", 2, localStringBuilder.toString());
    }
    a(paramView, str);
    g();
    onBackEvent();
  }
  
  public void onResume()
  {
    super.onResume();
    Utils.a(this);
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyUninterestComplainFragment.1(this), 300L);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.fragment.ReadInJoyUninterestComplainFragment
 * JD-Core Version:    0.7.0.1
 */