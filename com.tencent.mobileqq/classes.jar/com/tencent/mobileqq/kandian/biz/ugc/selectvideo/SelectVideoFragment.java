package com.tencent.mobileqq.kandian.biz.ugc.selectvideo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.kandian.base.utils.AlbumUtils.LocalMediaInfo;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.view.widget.AlbumPermissionView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.ugc.coverselect.LocalMediaGridAdapter;
import com.tencent.mobileqq.kandian.biz.ugc.coverselect.LocalMediaGridAdapter.OnItemListener;
import com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture.PlayerCaptureProxy;
import com.tencent.mobileqq.kandian.biz.ugc.finishdialog.KanDianPublishSuccessGuideDialogFragment;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.QQPermissionCallback;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.JudgeUserStatusReq;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.ReqBody;

public class SelectVideoFragment
  extends PublicBaseFragment
  implements View.OnClickListener, LocalMediaGridAdapter.OnItemListener, ISelectVideoView, QQPermissionCallback
{
  private Activity a;
  private RecyclerView b;
  private LocalMediaGridAdapter c;
  private TextView d;
  private ViewGroup e;
  private ViewGroup f;
  private ImmersiveTitleBar2 g;
  private View h;
  private AlbumPermissionView i;
  private View j;
  private boolean k = true;
  private SelectVideoPresenter l;
  
  public static SelectVideoFragment a(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAMS_IS_SHOW_TITLEBAR", paramBoolean);
    SelectVideoFragment localSelectVideoFragment = new SelectVideoFragment();
    localSelectVideoFragment.setArguments(localBundle);
    return localSelectVideoFragment;
  }
  
  private void c()
  {
    if ((VersionUtils.k()) && (!SystemUtil.d()) && (!SystemUtil.g()))
    {
      getBaseActivity().getWindow().getDecorView().setSystemUiVisibility(9216);
      this.g.setBackgroundColor(-1);
    }
  }
  
  private void d()
  {
    if (this.l.c().booleanValue())
    {
      Dialog localDialog = new Dialog(getActivity());
      localDialog.setContentView(2131629137);
      Object localObject = this.l.d();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ((TextView)localDialog.findViewById(2131447463)).setText((CharSequence)localObject);
      }
      localObject = this.l.e();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ((TextView)localDialog.findViewById(2131431322)).setText((CharSequence)localObject);
      }
      localObject = (TextView)localDialog.findViewById(2131437091);
      boolean bool = this.l.f();
      if (bool) {
        ((TextView)localObject).setText(2131915423);
      } else {
        ((TextView)localObject).setText(2131915424);
      }
      ((TextView)localObject).setOnClickListener(new SelectVideoFragment.2(this, bool, localDialog));
      localDialog.findViewById(2131444812).setOnClickListener(new SelectVideoFragment.3(this, localDialog));
      localDialog.setCanceledOnTouchOutside(false);
      localDialog.show();
      this.l.b(bool);
    }
  }
  
  private void e()
  {
    if (this.i.a())
    {
      this.l.b();
      return;
    }
    this.b.setVisibility(8);
    this.i.setVisibility(0);
  }
  
  private void f()
  {
    this.k = getArguments().getBoolean("PARAMS_IS_SHOW_TITLEBAR", true);
  }
  
  private void g()
  {
    if (this.k)
    {
      this.f.setVisibility(0);
      this.g.setVisibility(0);
      c();
      return;
    }
    this.f.setVisibility(8);
    this.g.setVisibility(8);
  }
  
  public int a()
  {
    return this.c.getItemCount();
  }
  
  public void a(int paramInt)
  {
    this.l.a(paramInt);
  }
  
  public void a(AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    this.l.a(paramLocalMediaInfo);
  }
  
  public void a(List<AlbumUtils.LocalMediaInfo> paramList, boolean paramBoolean)
  {
    this.c.appendList(paramList);
    if (this.c.isEmpty())
    {
      this.j.setVisibility(0);
      return;
    }
    this.j.setVisibility(8);
  }
  
  public boolean a(int paramInt, AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    return this.l.b(paramLocalMediaInfo);
  }
  
  @VisibleForTesting
  void b()
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (ReadInJoyHelper.v(localAppRuntime))
    {
      if (QLog.isColorLevel()) {
        QLog.i("RIJUGC.SelectVideoFragment", 2, "user has already shown guide dialog");
      }
      return;
    }
    oidb_0xe2a.ReqBody localReqBody = new oidb_0xe2a.ReqBody();
    localReqBody.msg_judge_user_status_req = new oidb_0xe2a.JudgeUserStatusReq();
    ProtoUtils.a(localAppRuntime, new SelectVideoFragment.4(this, localAppRuntime), localReqBody.toByteArray(), "OidbSvc.0xe2a", 3626, 9);
  }
  
  public void b(int paramInt)
  {
    this.c.a(paramInt);
  }
  
  public AlbumUtils.LocalMediaInfo c(int paramInt)
  {
    return (AlbumUtils.LocalMediaInfo)this.c.getItem(paramInt);
  }
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt == 10000)
    {
      this.b.setVisibility(0);
      this.i.setVisibility(8);
      this.l.b();
    }
  }
  
  public boolean needImmersive()
  {
    return this.k ^ true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 10001) && ((paramInt2 == -1) || (paramInt2 == 3)))
    {
      this.a.setResult(paramInt2, paramIntent);
      this.a.finish();
      if (!ReadInJoyHelper.v(RIJQQAppInterfaceUtil.e()))
      {
        this.a.finish();
        QPublicFragmentActivity.Launcher.a(this.a, QPublicTransFragmentActivity.class, KanDianPublishSuccessGuideDialogFragment.class);
      }
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.a = paramActivity;
    this.l = new SelectVideoPresenter(getBaseActivity(), this);
    PlayerCaptureProxy.e();
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    if (m == this.d.getId())
    {
      this.l.g();
      return;
    }
    if (m == this.h.getId()) {
      this.a.finish();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    f();
    RIJDtReportHelper.a.a(getBaseActivity());
    return View.inflate(this.a, 2131626023, null);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.l.a().c();
  }
  
  public void onPause()
  {
    super.onPause();
    this.l.a().b();
  }
  
  public void onResume()
  {
    super.onResume();
    this.l.a().a();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.b = ((RecyclerView)paramView.findViewById(2131449627));
    this.d = ((TextView)paramView.findViewById(2131448602));
    this.e = ((ViewGroup)paramView.findViewById(2131449686));
    this.f = ((ViewGroup)paramView.findViewById(2131447492));
    this.g = ((ImmersiveTitleBar2)paramView.findViewById(2131447582));
    this.h = paramView.findViewById(2131430821);
    this.i = ((AlbumPermissionView)paramView.findViewById(2131428229));
    this.j = paramView.findViewById(2131432507);
    g();
    this.h.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.c = new LocalMediaGridAdapter(this.a);
    this.c.a(this);
    this.b.setLayoutManager(new GridLayoutManager(this.a, 3, 1, false));
    this.b.setAdapter(this.c);
    this.b.addItemDecoration(new SelectVideoFragment.1(this));
    this.i.setContextStyleBlack(false);
    this.i.setCallback(this);
    this.l.a().a(this.e);
    e();
    b();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectvideo.SelectVideoFragment
 * JD-Core Version:    0.7.0.1
 */