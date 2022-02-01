package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemAnimator;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqpay.ui.R.color;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.qwallet.hb.HbInfo;
import com.tencent.mobileqq.qwallet.hb.HbInfo.BundleInfo;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.MoneyWatcher;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.SendHbLogic;
import com.tencent.mobileqq.qwallet.hb.send.view.impl.BirthdayHbAdapter;
import com.tencent.mobileqq.qwallet.hb.send.view.impl.BirthdayHbAdapter.DataInfo;
import com.tencent.mobileqq.qwallet.hb.send.view.impl.HorizontalPageLayoutManager;
import com.tencent.mobileqq.qwallet.hb.send.view.impl.PageIndicatorView;
import com.tencent.mobileqq.qwallet.hb.send.view.impl.PagingScrollHelper;
import com.tencent.mobileqq.qwallet.hb.send.view.impl.PagingScrollHelper.onPageChangeListener;
import com.tencent.mobileqq.qwallet.hb.send.view.impl.RectangleWithArcView;
import com.tencent.mobileqq.qwallet.report.impl.ReportUtils;
import com.tencent.mobileqq.qwallet.utils.impl.QWalletUIUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qwallet.QwUtils;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class BirthdayHbFragment
  extends BaseHbUIFragment
  implements View.OnClickListener, PagingScrollHelper.onPageChangeListener
{
  private RelativeLayout A;
  private View B;
  private RelativeLayout C;
  private RelativeLayout D;
  private ImageView E;
  private TextView F;
  private TextView G;
  private LinearLayout H;
  private RelativeLayout I;
  private TextView J;
  private EditText K;
  private EditText L;
  private EditText M;
  private RecyclerView N = null;
  private PageIndicatorView O;
  private List<BirthdayHbAdapter.DataInfo> P = new ArrayList();
  private BirthdayHbAdapter Q;
  private PagingScrollHelper R = new PagingScrollHelper();
  private HorizontalPageLayoutManager S = null;
  private boolean T;
  private String o;
  private String p;
  private String q;
  private String r;
  private int s;
  private int t;
  private String u;
  private int v;
  private int w;
  private String x = "#ffffff";
  private String y = "#fe6455";
  private String z = "#cd4e1c";
  
  private void l()
  {
    try
    {
      int i = ImmersiveUtils.isSupporImmersive();
      int j = ImmersiveUtils.getStatusBarHeight(this.f);
      if (i == 1)
      {
        Object localObject = this.a.findViewById(R.id.cl);
        ((View)localObject).getLayoutParams().height = j;
        ((View)localObject).requestLayout();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("initImmersive:");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(" barHeight: ");
          ((StringBuilder)localObject).append(j);
          QLog.i("BirthdayHbFragment", 2, ((StringBuilder)localObject).toString());
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BirthdayHbFragment", 1, localThrowable, new Object[0]);
    }
  }
  
  private void m()
  {
    ((InputMethodManager)this.f.getSystemService("input_method")).hideSoftInputFromWindow(this.f.getWindow().getDecorView().getWindowToken(), 0);
  }
  
  private void n()
  {
    if (!i()) {
      return;
    }
    Object localObject1 = QwUtils.b(String.valueOf(QwUtils.a(this.d.getText().toString())));
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      QQToast.makeText(getActivity(), R.string.h, 0).show();
      return;
    }
    Object localObject2 = this.M.getText().toString().trim();
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      return;
    }
    a(this.m, this.i, 1, (String)localObject1, "hongbao.wrap.go");
    Map localMap = this.f.getMapPacketExtra();
    localMap.put("channel", String.valueOf(this.i));
    localMap.put("type", "1");
    localMap.put("wishing", localObject2);
    localMap.put("bus_type", "1");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(1);
    ((StringBuilder)localObject2).append("");
    localMap.put("total_num", ((StringBuilder)localObject2).toString());
    localMap.put("total_amount", localObject1);
    localMap.put("birthday", this.r);
    if (this.w > 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.w);
      ((StringBuilder)localObject1).append("");
      localMap.put("skin_id", ((StringBuilder)localObject1).toString());
    }
    this.h.a(localMap);
    ReportUtils.a(this.g, "redpack.paybtn.click", null, this.m.panel_name);
  }
  
  private void o()
  {
    for (;;)
    {
      int i;
      try
      {
        this.u = ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getString(this.o, "birthdayHB_wishPlaceholder_", "");
        if (!TextUtils.isEmpty(this.u))
        {
          this.M.setHint(this.u);
          this.K.setHint(this.u);
        }
        this.v = ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getInt(this.o, "birthdayHB_wishMaxLen_", 28);
        this.K.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.v) });
        Object localObject1 = this.J;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("0/");
        ((StringBuilder)localObject2).append(this.v);
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
        this.K.addTextChangedListener(new BirthdayHbFragment.7(this));
        localObject1 = ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getString(this.o, "birthdayHB_themeList_", "");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          JSONArray localJSONArray = new JSONArray((String)localObject1);
          i = 0;
          if (i < localJSONArray.length())
          {
            localObject1 = localJSONArray.get(i).toString();
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label632;
            }
            localObject1 = new JSONObject((String)localObject1);
            localObject2 = ((JSONObject)localObject1).optString("money");
            String str1 = ((JSONObject)localObject1).optString("text");
            String str2 = ((JSONObject)localObject1).optString("wishText");
            if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(str1))) {
              break label632;
            }
            localObject1 = localObject2;
            if (((String)localObject2).contains("birthday"))
            {
              int j = this.s;
              int k = this.r.lastIndexOf("-");
              if (k <= 0) {
                break label632;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(j + 1);
              ((StringBuilder)localObject1).append(".");
              ((StringBuilder)localObject1).append(this.r.substring(k + 1));
              localObject1 = ((StringBuilder)localObject1).toString();
            }
            localObject1 = new BirthdayHbAdapter.DataInfo((String)localObject1, str1, str2);
            this.P.add(localObject1);
            break label632;
          }
          if (this.P.size() > 0) {
            this.a.findViewById(R.id.bR).setVisibility(0);
          }
        }
        localObject1 = ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getString(this.o, "birthdayHB_skinList_", "");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = new JSONArray((String)localObject1);
          if (((JSONArray)localObject1).length() > 0)
          {
            localObject1 = ((JSONArray)localObject1).optJSONObject(0);
            this.w = ((JSONObject)localObject1).optInt("skinId");
            localObject2 = ((JSONObject)localObject1).optString("bgURL");
            this.x = ((JSONObject)localObject1).optString("bgColor");
            this.y = ((JSONObject)localObject1).optString("preArcColor");
            this.z = ((JSONObject)localObject1).optString("backArcColor");
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject1 = QWalletPicHelper.getNetDrawableForQWallet((String)localObject2, new ColorDrawable(-1), new ColorDrawable(-1));
              if (localObject1 != null)
              {
                this.A.setBackgroundDrawable((Drawable)localObject1);
                return;
              }
              this.A.setBackgroundColor(Color.parseColor(this.x));
              return;
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
      label632:
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    this.O.setSelectedPage(paramInt);
  }
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bundleInfo: ");
      localStringBuilder.append(this.m);
      QLog.i("BirthdayHbFragment", 2, localStringBuilder.toString());
    }
    HbInfo.a(paramBundle, this.m);
    l();
    k();
    this.A = ((RelativeLayout)this.a.findViewById(R.id.bX));
    this.C = ((RelativeLayout)this.a.findViewById(R.id.i));
    this.D = ((RelativeLayout)this.a.findViewById(R.id.bj));
    this.E = ((ImageView)this.a.findViewById(R.id.ak));
    this.F = ((TextView)this.a.findViewById(R.id.ch));
    this.G = ((TextView)this.a.findViewById(R.id.dd));
    this.d = ((EditText)this.a.findViewById(R.id.b));
    this.d.addTextChangedListener(this.n);
    this.d.addTextChangedListener(new MoneyWatcher(this.d));
    this.b = ((Button)this.a.findViewById(R.id.z));
    this.b.setOnClickListener(this);
    this.l = ((EditText)this.a.findViewById(R.id.aX));
    this.B = this.a.findViewById(R.id.cJ);
    this.B.setOnClickListener(this);
    this.H = ((LinearLayout)this.a.findViewById(R.id.c));
    this.M = ((EditText)this.a.findViewById(R.id.aj));
    this.M.addTextChangedListener(this.n);
    this.L = ((EditText)this.a.findViewById(R.id.d));
    this.L.setOnEditorActionListener(new BirthdayHbFragment.1(this));
    this.d.setOnTouchListener(new BirthdayHbFragment.2(this));
    this.I = ((RelativeLayout)this.a.findViewById(R.id.de));
    this.K = ((EditText)this.a.findViewById(R.id.df));
    this.J = ((TextView)this.a.findViewById(R.id.dg));
    this.K.setOnEditorActionListener(new BirthdayHbFragment.3(this));
    this.M.setOnTouchListener(new BirthdayHbFragment.4(this));
    this.N = ((RecyclerView)this.a.findViewById(R.id.bT));
    paramBundle = QWalletUIUtils.a();
    if (paramBundle != null)
    {
      this.d.setTypeface(paramBundle);
      this.L.setTypeface(paramBundle);
    }
  }
  
  public void c()
  {
    this.o = this.e.getString("send_uin");
    Object localObject1 = getArguments();
    this.p = ((Bundle)localObject1).getString("recv_uin");
    if (!TextUtils.isEmpty(this.p))
    {
      localObject2 = FaceDrawable.getUserFaceDrawable(this.g, this.p, (byte)3);
      this.E.setImageDrawable((Drawable)localObject2);
    }
    this.q = ((Bundle)localObject1).getString("recv_name");
    if (!TextUtils.isEmpty(this.q))
    {
      this.F.setText(String.format(getResources().getString(R.string.ar), new Object[] { this.q }));
      this.F.setVisibility(0);
    }
    this.r = ((Bundle)localObject1).getString("birthday");
    if (!TextUtils.isEmpty(this.r))
    {
      localObject1 = new SimpleDateFormat("yyyy-MM-dd");
      try
      {
        localObject1 = ((SimpleDateFormat)localObject1).parse(this.r);
        localObject2 = Calendar.getInstance();
        ((Calendar)localObject2).setTime((Date)localObject1);
        this.s = ((Calendar)localObject2).get(2);
        this.t = ((Calendar)localObject2).get(5);
        localObject1 = Calendar.getInstance();
        i = ((Calendar)localObject1).get(2);
        j = ((Calendar)localObject1).get(5);
        if ((i <= this.s) && ((i != this.s) || (j < this.t)))
        {
          this.G.setText(String.format(getResources().getString(R.string.as), new Object[] { Integer.valueOf(this.s + 1), Integer.valueOf(this.t) }));
          this.G.setVisibility(0);
          this.T = false;
        }
        else
        {
          this.G.setVisibility(8);
          this.T = true;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    o();
    Size localSize = QWalletUIUtils.a(this.f);
    Object localObject2 = (LinearLayout.LayoutParams)this.N.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).width = localSize.a;
    ((LinearLayout.LayoutParams)localObject2).height = ViewUtils.dip2px(140.0F);
    int i = ViewUtils.dip2px(200.0F);
    localObject2 = this.f;
    String str = this.z;
    int j = localSize.b;
    int k = localSize.a;
    int m = localSize.a / 2;
    int n = localSize.b;
    localObject2 = new RectangleWithArcView((Context)localObject2, str, 0, j, k, i, m, ViewUtils.dip2px(80.0F) + (n - i));
    this.C.addView((View)localObject2);
    i = DisplayUtil.a(this.f, 175.0F);
    localObject2 = new RectangleWithArcView(this.f, this.y, 0, localSize.b, localSize.a, i, localSize.a / 2, localSize.b - i + ViewUtils.dip2px(80.0F));
    this.D.addView((View)localObject2);
    localObject2 = new DefaultItemAnimator();
    ((DefaultItemAnimator)localObject2).setSupportsChangeAnimations(false);
    this.N.setItemAnimator((RecyclerView.ItemAnimator)localObject2);
    this.N.getItemAnimator().setChangeDuration(0L);
    this.O = ((PageIndicatorView)this.a.findViewById(R.id.aA));
    this.Q = new BirthdayHbAdapter(this.P, new BirthdayHbFragment.5(this));
    this.N.setAdapter(this.Q);
    this.R.a(this.N);
    this.R.a(this);
    this.N.setHorizontalScrollBarEnabled(true);
    this.S = new HorizontalPageLayoutManager(localSize.a - this.N.getPaddingLeft() - this.N.getPaddingRight(), ViewUtils.dip2px(70.0F) * 2 - this.N.getPaddingTop() - this.N.getPaddingBottom(), 2, 3);
    this.N.setLayoutManager(this.S);
    this.N.addItemDecoration(new BirthdayHbFragment.6(this));
    this.R.a();
    this.R.a(0);
    float f = this.Q.getItemCount() / 6.0F;
    this.O.a((int)Math.ceil(f));
    this.O.setSelectedPage(0);
  }
  
  protected String d()
  {
    return HardCodeUtil.a(R.string.ao);
  }
  
  public boolean h()
  {
    if ((QwUtils.a(this.d.getText().toString()) > 0.0F) && (!TextUtils.isEmpty(this.M.getText().toString().trim())))
    {
      this.b.setEnabled(true);
      return true;
    }
    this.b.setEnabled(false);
    return false;
  }
  
  public int j()
  {
    return R.layout.i;
  }
  
  public void k()
  {
    this.a.findViewById(R.id.aD).setVisibility(4);
    ((TextView)this.a.findViewById(R.id.aE)).setVisibility(8);
    TextView localTextView = (TextView)this.a.findViewById(R.id.aB);
    Drawable localDrawable = getResources().getDrawable(R.drawable.f);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    localTextView.setCompoundDrawables(localDrawable, null, null, null);
    localTextView.setOnClickListener(this);
    this.a.findViewById(R.id.bW).setBackgroundColor(this.f.getResources().getColor(R.color.g));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 9) && (this.i == 1000004))
    {
      SendHbActivity localSendHbActivity = this.f;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramIntent = paramIntent.getStringExtra("result");
        if ((paramIntent != null) && (paramIntent.length() > 0)) {
          try
          {
            paramIntent = new JSONObject(paramIntent);
            paramInt1 = paramIntent.optInt("resultCode", -1);
            paramIntent = paramIntent.optString("data");
            if ((paramIntent != null) && (paramIntent.length() > 0))
            {
              new JSONObject(paramIntent);
              if (paramInt1 == 0)
              {
                ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).putBoolean(this.o, this.p, this.r, true);
                if (!this.T)
                {
                  paramInt1 = ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getInt(this.o, 0);
                  ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).putInt(this.o, paramInt1 + 1);
                }
                paramIntent = new Intent();
                paramIntent.putExtra("recv_uin", this.p);
                paramIntent.putExtra("recv_name", this.q);
                paramIntent.putExtra("birth_month", this.s);
                paramIntent.putExtra("birth_day", this.t);
                paramIntent.putExtra("pre_arc_color", this.y);
                QPublicFragmentActivity.start(this.f, paramIntent, BirthdayHbSuccessFragment.class);
                return;
              }
            }
          }
          catch (Exception paramIntent)
          {
            paramIntent.printStackTrace();
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.z)
    {
      n();
      paramView = this.f.getAppRuntime();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(NetConnInfoCenter.getServerTimeMillis());
      localStringBuilder.append("");
      ReportController.b(paramView, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "redpack.paybtn.click", 0, 0, "", localStringBuilder.toString(), "生日红包", "");
      return;
    }
    if (paramView.getId() == R.id.aB)
    {
      this.f.cancelCallBack();
      this.f.finish();
      return;
    }
    if (paramView.getId() == R.id.cJ)
    {
      this.B.setVisibility(8);
      if (this.H.getVisibility() == 0)
      {
        this.H.setVisibility(8);
        this.d.setText(this.L.getText());
        m();
      }
      if (this.I.getVisibility() == 0)
      {
        this.I.setVisibility(8);
        this.M.setText(this.K.getText());
        m();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.f.getWindow().setSoftInputMode(32);
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.BirthdayHbFragment
 * JD-Core Version:    0.7.0.1
 */