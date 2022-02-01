package com.tencent.mobileqq.guild.live.fragment.audience.module.subvideobar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.guild.live.QQGuildLiveRoomStartParams;
import com.tencent.mobileqq.guild.live.QQGuildLiveStartParamsCache;
import com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment;
import com.tencent.mobileqq.guild.live.fragment.base.control.IGuildLiveSubVideoBarControl;
import com.tencent.mobileqq.guild.live.fragment.base.control.QQGuildLiveModuleControl;
import com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveEventHelper;
import com.tencent.mobileqq.guild.live.livemanager.anchor.QQGuildLiveAnchorRoomMgr;
import com.tencent.mobileqq.guild.live.livemanager.model.QQGuildEndLiveModel;
import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.mobileqq.guild.live.widget.GuildLiveBlurURLImageView;
import com.tencent.mobileqq.guild.util.GuildAVPriorityManager;
import com.tencent.mobileqq.guild.util.GuildFastClickUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Locale;

public class QQGuildSubVideoBarLiveFragment
  extends QQGuildLiveModuleBaseFragment
  implements View.OnClickListener, IGuildLiveSubVideoBarControl
{
  private final Handler a = new Handler(Looper.getMainLooper());
  private View d;
  private boolean e = false;
  private TextView f;
  private TextView g;
  private GuildLiveBlurURLImageView h;
  private View i;
  private View j;
  private View k;
  private QQProgressDialog l;
  private final int m = 1010;
  
  private void a(boolean paramBoolean)
  {
    View localView = this.d;
    int n;
    if (paramBoolean) {
      n = 8;
    } else {
      n = 0;
    }
    localView.setVisibility(n);
  }
  
  private void b(boolean paramBoolean)
  {
    View localView = this.j;
    int i1 = 0;
    int n;
    if (paramBoolean) {
      n = 0;
    } else {
      n = 8;
    }
    localView.setVisibility(n);
    localView = this.k;
    if (paramBoolean) {
      n = i1;
    } else {
      n = 8;
    }
    localView.setVisibility(n);
  }
  
  public static QQGuildLiveModuleBaseFragment d()
  {
    return new QQGuildSubVideoBarLiveFragment();
  }
  
  private void e()
  {
    if (!GuildAVPriorityManager.a(i(), "频道直播", QQGuildLiveEventHelper.a()))
    {
      QLog.i("QGL.QQGuildSubVideoBarLiveFragment", 1, "requestAVFocus failure.");
      return;
    }
    if (QQGuildLiveStartParamsCache.a().getChannelInfo() == null)
    {
      QLog.e("QGL.QQGuildSubVideoBarLiveFragment", 1, "getCache().getChannelInfo() == null, please check it.");
      return;
    }
    g();
  }
  
  private void g()
  {
    h();
  }
  
  private void h()
  {
    if (this.l == null) {
      this.l = new QQProgressDialog(getActivity());
    }
    this.l.show();
    QQGuildLiveAnchorRoomMgr.a().b().observe(getViewLifecycleOwner(), new QQGuildSubVideoBarLiveFragment.4(this));
  }
  
  protected void a(@NonNull View paramView)
  {
    this.d = paramView.findViewById(2131434656);
    this.j = paramView.findViewById(2131434647);
    this.k = paramView.findViewById(2131434648);
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.i = paramView.findViewById(2131434653);
    this.f = ((TextView)paramView.findViewById(2131434657));
    this.g = ((TextView)paramView.findViewById(2131434654));
    this.h = ((GuildLiveBlurURLImageView)paramView.findViewById(2131434626));
  }
  
  public void a(@NonNull QQGuildEndLiveModel paramQQGuildEndLiveModel)
  {
    Boolean localBoolean = (Boolean)QQGuildLiveRoomUiData.a().h().getValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEndLiveEvent allowStartLive:");
    localStringBuilder.append(localBoolean);
    QLog.i("QGL.QQGuildSubVideoBarLiveFragment", 1, localStringBuilder.toString());
    this.i.setVisibility(0);
    this.g.setText(String.valueOf(paramQQGuildEndLiveModel.c()));
    long l1 = paramQQGuildEndLiveModel.b();
    paramQQGuildEndLiveModel = String.format(Locale.getDefault(), "%02d:%02d", new Object[] { Long.valueOf(l1 / 60L), Long.valueOf(l1 % 60L) });
    this.f.setText(paramQQGuildEndLiveModel);
    this.a.postDelayed(new QQGuildSubVideoBarLiveFragment.5(this), 180000L);
  }
  
  protected int b()
  {
    return 2131625076;
  }
  
  protected void cs_()
  {
    QQGuildLiveRoomUiData.a().c().observe(getViewLifecycleOwner(), new QQGuildSubVideoBarLiveFragment.1(this));
    QQGuildLiveRoomUiData.a().h().observe(getViewLifecycleOwner(), new QQGuildSubVideoBarLiveFragment.2(this));
    QQGuildLiveRoomUiData.a().j().observe(getViewLifecycleOwner(), new QQGuildSubVideoBarLiveFragment.3(this));
  }
  
  public void onAttach(@NonNull Context paramContext)
  {
    super.onAttach(paramContext);
    this.c.a(this);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131434647) || (paramView.getId() == 2131434648)) {
      if (GuildFastClickUtil.a("QGL.start_live_click"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QGL.QQGuildSubVideoBarLiveFragment", 2, "click too fast return");
        }
      }
      else {
        e();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.a.removeCallbacksAndMessages(null);
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.c.a(null);
  }
  
  public void onResume()
  {
    super.onResume();
    this.e = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.audience.module.subvideobar.QQGuildSubVideoBarLiveFragment
 * JD-Core Version:    0.7.0.1
 */