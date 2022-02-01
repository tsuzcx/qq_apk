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
import com.tencent.mobileqq.kandian.ad.api.IRIJAdShakeManager;
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
  private EditText a;
  private TextView b;
  private EditText c;
  private Button d;
  private int e;
  private Parcelable f;
  
  private void a(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("ad_complain_tel", paramString2);
    localBundle.putString("ad_complain_txt", paramString1);
    int i = this.e;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        paramString1 = (AdData)this.f;
        ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(getQBaseActivity()).a(3).b(1).a(((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(paramString1)).a(localBundle));
        return;
      }
      paramString1 = (VideoAdInfo)this.f;
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(getQBaseActivity()).a(3).b(10).a(((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramString1)).a(paramString1).a(localBundle));
      return;
    }
    paramString1 = (AdvertisementInfo)this.f;
    if (RIJFeedsType.a(paramString1)) {
      i = 11;
    } else {
      i = 3;
    }
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(getQBaseActivity()).a(3).b(i).a(paramString1).a(localBundle));
  }
  
  private void c()
  {
    this.p.changeBg(true);
    if (this.h != null) {
      this.h.setText(HardCodeUtil.a(2131901576));
    }
    a(HardCodeUtil.a(2131910337));
    if (ThemeUtil.isInNightMode(ReadInJoyUtils.b())) {
      View.inflate(getQBaseActivity(), 2131626298, this.s);
    }
  }
  
  private void d()
  {
    this.a = ((EditText)this.t.findViewById(2131431185));
    this.a.addTextChangedListener(this);
    this.b = ((TextView)this.t.findViewById(2131431437));
    this.c = ((EditText)this.t.findViewById(2131440051));
    this.d = ((Button)this.t.findViewById(2131446561));
    this.d.setOnClickListener(this);
  }
  
  private void e()
  {
    this.e = getArguments().getInt("key_from_type", 0);
    this.f = getArguments().getParcelable("key_ad_info");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initData fromType:");
      localStringBuilder.append(this.e);
      localStringBuilder.append(", adinfo:");
      localStringBuilder.append(this.f);
      QLog.d("ReadInJoyUninterestComplainFragment", 2, localStringBuilder.toString());
    }
    int i = this.e;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          onBackEvent();
          return;
        }
        if (!(this.f instanceof AdData))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ReadInJoyUninterestComplainFragment", 2, "adinfo is not AdData");
          }
          onBackEvent();
        }
      }
      else if (!(this.f instanceof VideoAdInfo))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoyUninterestComplainFragment", 2, "adinfo is not VideoAdInfo");
        }
        onBackEvent();
      }
    }
    else if (!(this.f instanceof AdvertisementInfo))
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
    localIntent.putExtra("key_ad_info", this.f);
    getQBaseActivity().setResult(-1, localIntent);
  }
  
  protected int a()
  {
    return 2131626356;
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
    this.b.setText(String.valueOf(getResources().getInteger(2131492925) - paramEditable.length()));
    if (paramEditable.trim().length() > 0)
    {
      this.d.setEnabled(true);
      return;
    }
    this.d.setEnabled(false);
  }
  
  public void b()
  {
    View localView = getQBaseActivity().getCurrentFocus();
    if (localView != null) {
      ((InputMethodManager)getQBaseActivity().getSystemService("input_method")).hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getQBaseActivity().getWindow().setSoftInputMode(1);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131446561) {
      return;
    }
    b();
    paramView = this.a.getText().toString().trim();
    String str = this.c.getText().toString().trim();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSubmitClick complaints:");
      localStringBuilder.append(paramView);
      QLog.d("ReadInJoyUninterestComplainFragment", 2, localStringBuilder.toString());
    }
    ((IRIJAdShakeManager)QRoute.api(IRIJAdShakeManager.class)).onComplainBackToFeeds();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.fragment.ReadInJoyUninterestComplainFragment
 * JD-Core Version:    0.7.0.1
 */