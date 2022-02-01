package com.tencent.mobileqq.ocr;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.ocr.api.impl.OCRHandler;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.OptionItem;
import com.tencent.mobileqq.qqfavor.api.IFavoriteOCR;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.textpreview.BaseMenuUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.OCRBottomTabView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ScrollView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

public class TranslateFragment
  extends QPublicBaseFragment
  implements View.OnClickListener
{
  private TranslateLanguageOptionsView a;
  private TranslateLanguageOptionsView b;
  private QQProgressDialog c;
  private OCRBottomTabView d;
  private OCRBottomTabView e;
  private OCRBottomTabView f;
  private OCRBottomTabView g;
  private ImageView h;
  private ScrollView i;
  private ScrollView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private OCRHandler o;
  private TranslateResult p;
  private boolean q;
  private QBaseActivity r;
  private String s;
  private int t = 2;
  private OCRObserver u = new TranslateFragment.1(this);
  
  private void a()
  {
    QQProgressDialog localQQProgressDialog = this.c;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.c.dismiss();
    }
  }
  
  private void a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      TranslateResult localTranslateResult = this.p;
      if (localTranslateResult != null) {
        a(1, localTranslateResult);
      } else {
        b(OCRPerformUtil.d);
      }
      OCRPerformUtil.a("0X800AB95", 2);
      return;
    }
    a(2, this.p);
    OCRPerformUtil.a("0X800AB95", 1);
  }
  
  private void a(int paramInt, TranslateResult paramTranslateResult)
  {
    this.t = paramInt;
    Object localObject = this.d;
    if ((localObject != null) && (((OCRBottomTabView)localObject).getVisibility() == 0))
    {
      int i3 = 2131908221;
      String str = "#000000";
      int i1 = -1;
      int i2;
      if (paramInt == 1)
      {
        i1 = 2130842348;
        localObject = "#00CAFC";
        i2 = 2131908221;
      }
      else
      {
        localObject = "#000000";
        i2 = -1;
      }
      if (paramInt == 2)
      {
        i1 = 2130842347;
        i2 = i3;
        localObject = str;
      }
      this.d.setTabImage(getResources().getDrawable(i1));
      this.d.setTabText(getResources().getString(i2));
      this.d.setTabTextColor(Color.parseColor((String)localObject));
    }
    if (paramTranslateResult != null)
    {
      if (paramInt == 2)
      {
        this.i.setVisibility(0);
        this.j.setVisibility(0);
        this.k.setText(this.s);
        this.l.setText(b(paramInt, paramTranslateResult));
      }
      if (paramInt == 1)
      {
        this.j.setVisibility(0);
        this.i.setVisibility(8);
        this.l.setText(b(paramInt, paramTranslateResult));
      }
      if (OCRPerformUtil.d != null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("src:");
          ((StringBuilder)localObject).append(paramTranslateResult.b);
          ((StringBuilder)localObject).append(", dst:");
          ((StringBuilder)localObject).append(paramTranslateResult.c);
          ((StringBuilder)localObject).append(", OCRLanHolder:");
          ((StringBuilder)localObject).append(OCRPerformUtil.d.a());
          QLog.e("TranslateFragment", 2, ((StringBuilder)localObject).toString());
        }
        OCRPerformUtil.d.d(paramTranslateResult.b);
        OCRPerformUtil.d.e(paramTranslateResult.c);
        a(OCRPerformUtil.d);
      }
    }
  }
  
  public static void a(QBaseActivity paramQBaseActivity, String paramString)
  {
    Intent localIntent = new Intent(paramQBaseActivity, TranslateFragment.class);
    localIntent.putExtra("TranslateText", paramString);
    QPublicFragmentActivity.start(paramQBaseActivity, localIntent, TranslateFragment.class);
  }
  
  private void a(OCRPerformUtil.OCRLanHolder paramOCRLanHolder)
  {
    if (paramOCRLanHolder == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TranslateFragment", 2, "updateTranslateTitle, lanHolder is null");
      }
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateTranslateTitle, lanHolder:");
      ((StringBuilder)localObject).append(paramOCRLanHolder.a());
      QLog.d("TranslateFragment", 2, ((StringBuilder)localObject).toString());
    }
    this.m.setText(paramOCRLanHolder.b(paramOCRLanHolder.d));
    this.n.setText(paramOCRLanHolder.b(paramOCRLanHolder.e));
    if ((paramOCRLanHolder.f != null) && (paramOCRLanHolder.f.size() > 1))
    {
      this.m.setClickable(true);
      localObject = getResources().getDrawable(2130847827);
      this.m.setCompoundDrawablesWithIntrinsicBounds(null, null, null, (Drawable)localObject);
    }
    else
    {
      this.m.setClickable(false);
      this.m.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    if ((paramOCRLanHolder.g != null) && (paramOCRLanHolder.g.size() > 1))
    {
      this.n.setClickable(true);
      paramOCRLanHolder = getResources().getDrawable(2130847827);
      this.n.setCompoundDrawablesWithIntrinsicBounds(null, null, null, paramOCRLanHolder);
      return;
    }
    this.n.setClickable(false);
    this.n.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (!NetworkUtil.isNetworkAvailable(this.r))
    {
      QQToast.makeText(this.r, 1, 2131889169, 0).show();
      return;
    }
    if (TextUtils.isEmpty(this.s))
    {
      QLog.d("TranslateFragment", 1, "requestTranslate, mInputTransText null");
      return;
    }
    if (this.q)
    {
      QLog.d("TranslateFragment", 1, "requestTranslate, in translate request,");
      return;
    }
    b(2131897099);
    this.q = true;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestTranslate, srcLan:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", dstLan:");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("TranslateFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.o;
    if (localObject != null) {
      ((OCRHandler)localObject).a(this.s, paramString1, paramString2);
    }
  }
  
  private CharSequence b(int paramInt, TranslateResult paramTranslateResult)
  {
    if (paramInt == 1) {
      return paramTranslateResult.e();
    }
    if (paramInt == 2) {
      return paramTranslateResult.b();
    }
    return "";
  }
  
  private void b(int paramInt)
  {
    if (this.c == null)
    {
      this.c = new QQProgressDialog(this.r, getResources().getDimensionPixelSize(2131299920));
      this.c.c(paramInt);
    }
    if (!getActivity().isFinishing()) {
      this.c.show();
    }
  }
  
  private void b(OCRPerformUtil.OCRLanHolder paramOCRLanHolder)
  {
    if (paramOCRLanHolder == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TranslateFragment", 2, "updateTranslateTitle, lanHolder is null");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestTranslate, lanHolder:");
      localStringBuilder.append(paramOCRLanHolder.a());
      QLog.d("TranslateFragment", 2, localStringBuilder.toString());
    }
    a(paramOCRLanHolder.d, paramOCRLanHolder.e);
  }
  
  private void c(OCRPerformUtil.OCRLanHolder paramOCRLanHolder)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showTranslateSrcLanOptions, lanHolder:");
      ((StringBuilder)localObject).append(paramOCRLanHolder.a());
      QLog.d("TranslateFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    if ((localObject != null) && (((TranslateLanguageOptionsView)localObject).isShowing())) {
      this.a.dismiss();
    }
    localObject = this.b;
    if ((localObject != null) && (((TranslateLanguageOptionsView)localObject).isShowing()))
    {
      this.b.dismiss();
      return;
    }
    if (paramOCRLanHolder.f != null)
    {
      if (paramOCRLanHolder.f.size() == 0) {
        return;
      }
      localObject = new ArrayList();
      int i1 = 0;
      int i2 = 0;
      while (i1 < paramOCRLanHolder.f.size())
      {
        String str = (String)paramOCRLanHolder.f.get(i1);
        if (str.equalsIgnoreCase(paramOCRLanHolder.d)) {
          i2 = i1;
        }
        TranslateLanguageOptionsView.OptionItem localOptionItem = new TranslateLanguageOptionsView.OptionItem();
        localOptionItem.b = str;
        localOptionItem.a = OCRPerformUtil.a(str);
        ((List)localObject).add(localOptionItem);
        i1 += 1;
      }
      this.b = TranslateLanguageOptionsView.a(this.r, (List)localObject, i2, new TranslateFragment.2(this, paramOCRLanHolder));
      i1 = this.m.getMeasuredWidth() / 2;
      i2 = DisplayUtil.a(this.r, 75.0F);
      this.m.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.b.showAsDropDown(this.m, i1 - i2, 0);
      this.b.setOnDismissListener(new TranslateFragment.3(this, paramOCRLanHolder));
    }
  }
  
  private void d(OCRPerformUtil.OCRLanHolder paramOCRLanHolder)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showTranslateDstLanOptions, lanHolder:");
      ((StringBuilder)localObject).append(paramOCRLanHolder.a());
      QLog.d("TranslateFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.b;
    if ((localObject != null) && (((TranslateLanguageOptionsView)localObject).isShowing())) {
      this.b.dismiss();
    }
    localObject = this.a;
    if ((localObject != null) && (((TranslateLanguageOptionsView)localObject).isShowing()))
    {
      this.a.dismiss();
      return;
    }
    if (paramOCRLanHolder.g != null)
    {
      if (paramOCRLanHolder.g.size() == 0) {
        return;
      }
      localObject = new ArrayList();
      int i1 = 0;
      int i2 = 0;
      while (i1 < paramOCRLanHolder.g.size())
      {
        String str = (String)paramOCRLanHolder.g.get(i1);
        if (!str.equalsIgnoreCase(paramOCRLanHolder.d))
        {
          if (str.equalsIgnoreCase(paramOCRLanHolder.e)) {
            i2 = i1;
          }
          TranslateLanguageOptionsView.OptionItem localOptionItem = new TranslateLanguageOptionsView.OptionItem();
          localOptionItem.b = str;
          localOptionItem.a = OCRPerformUtil.a(str);
          ((List)localObject).add(localOptionItem);
        }
        i1 += 1;
      }
      this.a = TranslateLanguageOptionsView.a(this.r, (List)localObject, i2, new TranslateFragment.4(this, paramOCRLanHolder));
      i1 = this.n.getMeasuredWidth() / 2;
      i2 = DisplayUtil.a(this.r, 75.0F);
      this.n.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.a.showAsDropDown(this.n, i1 - i2, 0);
      this.a.setOnDismissListener(new TranslateFragment.5(this, paramOCRLanHolder));
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771996, 2130771994);
    paramActivity.getWindow().setFlags(1024, 1024);
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(1);
    if (Build.VERSION.SDK_INT >= 19) {
      paramActivity.getWindow().addFlags(134217728);
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.r = ((QBaseActivity)paramActivity);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131447814) {
      c(OCRPerformUtil.d);
    } else if (i1 == 2131447810) {
      d(OCRPerformUtil.d);
    } else if (i1 == 2131447809) {
      this.r.finish();
    } else if (i1 != 2131447815) {
      if (i1 == 2131432814)
      {
        ((IFavoriteOCR)QRoute.api(IFavoriteOCR.class)).favorite(this.r, String.valueOf(this.l.getText()));
        OCRPerformUtil.a("0X800AB94", 0);
      }
      else if (i1 == 2131433639)
      {
        OCRPerformUtil.a(this.r, String.valueOf(this.l.getText()));
        OCRPerformUtil.a("0X800AB93", 0);
      }
      else if (i1 == 2131431421)
      {
        BaseMenuUtil.copy(String.valueOf(this.l.getText()), "TranslateFragment");
        OCRPerformUtil.a("0X800AB92", 0);
      }
      else if (i1 == 2131431376)
      {
        a(this.t);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.s = getActivity().getIntent().getStringExtra("TranslateText");
    this.o = ((OCRHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(OCRHandler.a));
    this.r.addObserver(this.u);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i1 = 0;
    paramLayoutInflater = paramLayoutInflater.inflate(2131627882, paramViewGroup, false);
    this.m = ((TextView)paramLayoutInflater.findViewById(2131447814));
    this.n = ((TextView)paramLayoutInflater.findViewById(2131447810));
    this.h = ((ImageView)paramLayoutInflater.findViewById(2131447809));
    this.i = ((ScrollView)paramLayoutInflater.findViewById(2131447835));
    this.k = ((TextView)paramLayoutInflater.findViewById(2131447837));
    this.j = ((ScrollView)paramLayoutInflater.findViewById(2131447836));
    this.l = ((TextView)paramLayoutInflater.findViewById(2131447839));
    this.d = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131431376));
    this.g = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131432814));
    this.f = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131433639));
    this.e = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131431421));
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.m.setTextColor(Color.parseColor("#03081A"));
    this.n.setTextColor(Color.parseColor("#03081A"));
    this.d.setTabTextColor(-16777216);
    this.g.setTabTextColor(-16777216);
    this.f.setTabTextColor(-16777216);
    this.e.setTabTextColor(-16777216);
    this.k.setText(this.s);
    this.l.setText("");
    paramViewGroup = getResources().getDrawable(2130847825);
    this.h.setImageDrawable(paramViewGroup);
    a(OCRPerformUtil.d);
    b(OCRPerformUtil.d);
    boolean bool = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
    paramViewGroup = paramLayoutInflater.findViewById(2131439540);
    if (!bool) {
      i1 = 8;
    }
    paramViewGroup.setVisibility(i1);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.r.removeObserver(this.u);
    this.r = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.TranslateFragment
 * JD-Core Version:    0.7.0.1
 */