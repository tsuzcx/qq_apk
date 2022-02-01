package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqpay.ui.R.color;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.qwallet.hb.send.view.impl.RectangleWithArcView;
import com.tencent.mobileqq.qwallet.utils.impl.QWalletUIUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.Calendar;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class BirthdayHbSuccessFragment
  extends QPublicBaseFragment
  implements View.OnClickListener
{
  private View a;
  private RelativeLayout b;
  private ImageView c;
  private TextView d;
  private TextView e;
  private RelativeLayout f;
  
  private boolean a(int paramInt1, int paramInt2)
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(2);
    int j = localCalendar.get(5);
    return (i > paramInt1) || ((i == paramInt1) && (j >= paramInt2));
  }
  
  private void c()
  {
    try
    {
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        View localView = this.a.findViewById(R.id.cl);
        localView.getLayoutParams().height = ImmersiveUtils.getStatusBarHeight(getContext());
        localView.requestLayout();
        if (getQBaseActivity().mSystemBarComp == null)
        {
          getQBaseActivity().setImmersiveStatus(0);
          return;
        }
        getQBaseActivity().mSystemBarComp.setStatusBarDrawable(null);
        getQBaseActivity().mSystemBarComp.setStatusBarColor(0);
        getQBaseActivity().mSystemBarComp.setStatusColor(0);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BirthdayHbSuccessFragment", 1, localThrowable, new Object[0]);
    }
  }
  
  private void d()
  {
    this.a.findViewById(R.id.aD).setVisibility(4);
    ((TextView)this.a.findViewById(R.id.aE)).setVisibility(8);
    TextView localTextView = (TextView)this.a.findViewById(R.id.aB);
    Drawable localDrawable = getResources().getDrawable(R.drawable.f);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    localTextView.setCompoundDrawables(localDrawable, null, null, null);
    localTextView.setOnClickListener(this);
    this.a.findViewById(R.id.bW).setBackgroundColor(getResources().getColor(R.color.g));
  }
  
  private void e()
  {
    Object localObject1 = getQBaseActivity().getIntent();
    Object localObject2 = ((Intent)localObject1).getStringExtra("recv_uin");
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
      if ((localAppRuntime instanceof AppInterface))
      {
        localObject2 = FaceDrawable.getUserFaceDrawable((AppInterface)localAppRuntime, (String)localObject2, (byte)3);
        this.c.setImageDrawable((Drawable)localObject2);
      }
    }
    localObject2 = ((Intent)localObject1).getStringExtra("recv_name");
    int i = ((Intent)localObject1).getIntExtra("birth_month", -1);
    int j = ((Intent)localObject1).getIntExtra("birth_day", -1);
    if ((i != -1) && (j != -1)) {
      if (a(i, j))
      {
        this.d.setText(String.format(getResources().getString(R.string.ap), new Object[] { localObject2 }));
        this.e.setVisibility(8);
      }
      else
      {
        this.d.setText(String.format(getResources().getString(R.string.aq), new Object[] { localObject2 }));
        this.e.setText(String.format(getResources().getString(R.string.as), new Object[] { Integer.valueOf(i + 1), Integer.valueOf(j) }));
        this.e.setVisibility(0);
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      this.d.setVisibility(0);
    }
    try
    {
      localObject2 = ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getString(getQBaseActivity().getAppRuntime().getCurrentAccountUin(), "birthdayHB_skinList_", "");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = new JSONArray((String)localObject2);
        if (((JSONArray)localObject2).length() > 0)
        {
          localObject2 = ((JSONArray)localObject2).optJSONObject(0).optString("bgURL");
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject2 = QWalletPicHelper.getNetDrawableForQWallet((String)localObject2, new ColorDrawable(-1), new ColorDrawable(-1));
            if (localObject2 != null) {
              this.b.setBackgroundDrawable((Drawable)localObject2);
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    Object localObject3 = ((Intent)localObject1).getStringExtra("pre_arc_color");
    localObject1 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject1 = "#fe6455";
    }
    localObject3 = QWalletUIUtils.a(getQBaseActivity());
    i = ViewUtils.dip2px(220.0F);
    localObject1 = new RectangleWithArcView(getQBaseActivity(), (String)localObject1, 0, ((Size)localObject3).b, ((Size)localObject3).a, i, ((Size)localObject3).a / 2, ((Size)localObject3).b - i + ViewUtils.dip2px(80.0F));
    this.f.addView((View)localObject1);
  }
  
  public void a()
  {
    c();
    d();
    this.b = ((RelativeLayout)this.a.findViewById(R.id.bX));
    ((Button)this.a.findViewById(R.id.h)).setOnClickListener(this);
    this.c = ((ImageView)this.a.findViewById(R.id.ak));
    this.d = ((TextView)this.a.findViewById(R.id.ch));
    this.e = ((TextView)this.a.findViewById(R.id.dd));
    this.f = ((RelativeLayout)this.a.findViewById(R.id.f));
  }
  
  public void b()
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if (localQBaseActivity != null) {
      localQBaseActivity.finish();
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == R.id.h) || (paramView.getId() == R.id.aB)) {
      b();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("onCreateView: ");
    paramViewGroup.append(getClass().getSimpleName());
    QLog.i("BirthdayHbSuccessFragment", 2, paramViewGroup.toString());
    this.a = paramLayoutInflater.inflate(R.layout.k, null);
    a();
    e();
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.BirthdayHbSuccessFragment
 * JD-Core Version:    0.7.0.1
 */