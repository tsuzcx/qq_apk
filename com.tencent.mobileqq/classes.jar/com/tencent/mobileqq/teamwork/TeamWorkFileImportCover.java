package com.tencent.mobileqq.teamwork;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AutoVerticalScrollTextView;

public class TeamWorkFileImportCover
{
  Handler a;
  DiniFlyAnimationView b;
  public AppInterface c;
  private View d;
  private TextView e;
  private TextView f;
  private View g;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k;
  private AutoVerticalScrollTextView l;
  private TeamWorkFileImportInfo m;
  private String[] n = new String[2];
  private int o = 1;
  private RelativeLayout p;
  private Activity q;
  private View r;
  private LinearLayout s;
  private QQCustomDialog t;
  
  public TeamWorkFileImportCover(RelativeLayout paramRelativeLayout, Activity paramActivity, AppInterface paramAppInterface)
  {
    this.p = paramRelativeLayout;
    this.q = paramActivity;
    this.c = paramAppInterface;
  }
  
  private void e()
  {
    QQCustomDialog localQQCustomDialog = this.t;
    if (localQQCustomDialog != null)
    {
      if (localQQCustomDialog.isShowing()) {
        try
        {
          this.t.dismiss();
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" dismiss exception: ");
          localStringBuilder.append(localException.toString());
          QLog.e("TeamWorkFileImportCover", 1, localStringBuilder.toString());
        }
      }
      this.t = null;
    }
  }
  
  public View a(int paramInt)
  {
    return this.q.findViewById(paramInt);
  }
  
  public View a(Bundle paramBundle)
  {
    this.r = LayoutInflater.from(BaseApplicationImpl.getApplication()).inflate(2131629375, this.p, false);
    paramBundle = new RelativeLayout.LayoutParams(-1, -1);
    paramBundle.addRule(3, 2131444897);
    paramBundle.topMargin = (-d());
    this.r.setLayoutParams(paramBundle);
    this.p.addView(this.r, 1);
    this.p.findViewById(2131444897).setBackgroundColor(-1);
    this.d = a(2131446942);
    this.e = ((TextView)a(2131446939));
    this.f = ((TextView)a(2131446938));
    this.g = a(2131446943);
    this.b = ((DiniFlyAnimationView)a(2131428368));
    paramBundle = (LinearLayout.LayoutParams)this.b.getLayoutParams();
    paramBundle.height = ViewUtils.dpToPx(60.0F);
    paramBundle.width = ViewUtils.dpToPx(60.0F);
    this.b.setLayoutParams(paramBundle);
    this.h = ((TextView)a(2131446944));
    this.i = ((TextView)a(2131446947));
    this.j = ((TextView)a(2131446945));
    this.k = ((TextView)a(2131446946));
    this.l = ((AutoVerticalScrollTextView)a(2131446940));
    this.n[0] = this.q.getString(2131917080);
    this.n[1] = this.q.getString(2131917081);
    this.l.setTextArray(this.n);
    a(this.q.getIntent(), this.q);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("show loading view start time [");
      paramBundle.append(System.currentTimeMillis() / 1000L);
      paramBundle.append("]");
      QLog.i("teamConvert", 2, paramBundle.toString());
    }
    this.s = ((LinearLayout)LayoutInflater.from(BaseApplicationImpl.getApplication()).inflate(2131629371, this.p, false));
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.addRule(14, -1);
    paramBundle.addRule(12, -1);
    paramBundle.bottomMargin = ViewUtils.dpToPx(12.0F);
    this.p.addView(this.s, paramBundle);
    ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(this.m, null, "0X8009ED4");
    return this.r;
  }
  
  public void a(int paramInt, String paramString)
  {
    this.o = 4;
    ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(this.m, null, "0X800A2F2");
    if (this.q == null)
    {
      QLog.i("teamConvert", 1, "showFailedView, but activity is null");
      return;
    }
    Object localObject = this.b;
    if (localObject != null)
    {
      ((DiniFlyAnimationView)localObject).cancelAnimation();
      this.b.setVisibility(8);
    }
    this.h.setVisibility(8);
    this.i.setVisibility(8);
    this.l.setVisibility(8);
    this.g.setVisibility(8);
    this.d.setVisibility(0);
    if ((paramInt != 116) && (paramInt != -116))
    {
      if (paramInt == 106)
      {
        localObject = this.q.getResources().getString(2131917111);
        this.e.setVisibility(8);
        this.f.setText((CharSequence)localObject);
      }
      else if ((Math.abs(paramInt) >= 100) && (Math.abs(paramInt) < 116))
      {
        if (TextUtils.isEmpty(paramString)) {
          localObject = this.q.getResources().getString(2131917090);
        } else {
          localObject = paramString;
        }
        this.e.setVisibility(8);
        this.f.setText((CharSequence)localObject);
      }
      else
      {
        this.e.setVisibility(8);
        this.f.setText(this.q.getResources().getString(2131917090));
      }
    }
    else
    {
      this.e.setVisibility(0);
      if (paramInt == 116) {
        this.e.setText(this.q.getResources().getString(2131917083));
      } else if (paramInt == -116) {
        this.e.setText(this.q.getResources().getString(2131917110));
      }
      if (TextUtils.isEmpty(paramString)) {
        localObject = this.q.getResources().getString(2131917090);
      } else {
        localObject = paramString;
      }
      this.f.setText((CharSequence)localObject);
    }
    this.p.findViewById(2131444897).setBackgroundColor(Color.parseColor("#f6f7f9"));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tencentdoc log:show failed view finish time [");
      ((StringBuilder)localObject).append(System.currentTimeMillis() / 1000L);
      ((StringBuilder)localObject).append("] error code = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" errorStr = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("teamConvert", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(Intent paramIntent, Context paramContext)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null))
    {
      paramIntent.getExtras().setClassLoader(TeamWorkFileImportInfo.class.getClassLoader());
      this.m = ((TeamWorkFileImportInfo)paramIntent.getParcelableExtra("key_team_work_file_import_info"));
      paramIntent = this.m;
      if (paramIntent != null)
      {
        if (paramIntent.d())
        {
          this.h.setText(paramContext.getString(2131917099));
          this.i.setText(paramContext.getString(2131917102));
        }
        else if (this.m.B == 6)
        {
          this.h.setText(paramContext.getString(2131917098));
          this.i.setText(paramContext.getString(2131917101));
        }
        else if (this.m.n == 12)
        {
          this.h.setText(paramContext.getString(2131917137));
          this.i.setText(paramContext.getString(2131917102));
        }
        else if (this.m.n == 13)
        {
          this.h.setText(paramContext.getString(2131917122));
          this.i.setVisibility(8);
          this.l.setVisibility(8);
          this.j.setVisibility(0);
          this.k.setVisibility(0);
        }
        else if (this.m.b())
        {
          this.h.setText(paramContext.getString(2131917137));
          this.i.setText(paramContext.getString(2131917102));
        }
        else
        {
          this.h.setText(paramContext.getString(2131917097));
          this.i.setText(paramContext.getString(2131917100));
        }
        this.o = 2;
        this.b.setAnimation("teamwork/tim_data_loading.json");
        this.b.loop(true);
        if (NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
        {
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder();
            paramIntent.append("tencentdoc log:---FileImport start, fileName： ");
            paramIntent.append(this.m.c);
            paramIntent.append(" ---");
            QLog.i("TeamWorkFileImportCover", 2, paramIntent.toString());
          }
          TenDocLogReportHelper.f("cover_loading_time");
          TenDocLogReportHelper.f("get_url_time");
          this.b.setVisibility(0);
          this.b.playAnimation();
          paramIntent = this.m;
          if ((paramIntent != null) && (paramIntent.n == 9)) {
            TenDocLogReportHelper.a(null, "0X800A4B4");
          }
        }
        else
        {
          QQToast.makeText(paramContext, 2131892104, 0).show(d());
          a(-1, null);
        }
      }
    }
  }
  
  public boolean a()
  {
    View localView = this.r;
    return (localView != null) && (localView.getVisibility() == 0);
  }
  
  public void b()
  {
    if (a()) {
      ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(this.m, null, "0X8009ED5");
    }
    this.c = null;
    this.q = null;
    this.p = null;
    AutoVerticalScrollTextView localAutoVerticalScrollTextView = this.l;
    if (localAutoVerticalScrollTextView != null) {
      localAutoVerticalScrollTextView.b();
    }
    this.b.cancelAnimation();
    this.b = null;
    e();
    this.a = null;
    this.r = null;
  }
  
  public void c()
  {
    this.p.findViewById(2131444897).setBackgroundColor(Color.parseColor("#f6f7f9"));
    this.r.setVisibility(8);
    this.s.setVisibility(8);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hide loading view finish time [");
      ((StringBuilder)localObject).append(System.currentTimeMillis() / 1000L);
      ((StringBuilder)localObject).append("]");
      QLog.i("teamConvert", 2, ((StringBuilder)localObject).toString());
    }
    long l1 = TenDocLogReportHelper.g("cover_loading_time");
    Object localObject = this.m;
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((TeamWorkFileImportInfo)localObject).A;
    }
    TenDocLogReportHelper.a(null, (String)localObject, "0X8009E9C", String.valueOf(l1), "", "");
    if (this.m != null)
    {
      TenDocLogReportHelper.a("TeamWorkFileImportCover", "cover_loading_time", String.valueOf(l1), this.m.A);
      return;
    }
    TenDocLogReportHelper.a("TeamWorkFileImportCover", "cover_loading_time", String.valueOf(l1));
  }
  
  public int d()
  {
    return this.q.getResources().getDimensionPixelSize(2131299920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportCover
 * JD-Core Version:    0.7.0.1
 */