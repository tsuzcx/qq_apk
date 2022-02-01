package com.tencent.mobileqq.matchchat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.qqexpand.manager.IExpandLimitChatManager;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.network.IExpandHandler;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class MatchChatSettingFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private QQAppInterface a;
  private FormSwitchItem b;
  private Button c;
  private ExpandObserver d = new MatchChatSettingFragment.1(this);
  
  private void a()
  {
    boolean bool = ((IExpandLimitChatManager)this.a.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER)).a(this.a);
    a(bool);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initDefaultValue chatSwitchOpen:");
      localStringBuilder.append(bool);
      QLog.i("MatchChatSettingFragment", 2, localStringBuilder.toString());
    }
    ((IExpandHandler)this.a.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).c(this.a.getCurrentUin());
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.b = ((FormSwitchItem)paramView.findViewById(2131442494));
    this.c = ((Button)paramView.findViewById(2131442493));
    this.b.setOnCheckedChangeListener(this);
    this.c.setOnClickListener(this);
  }
  
  private void a(boolean paramBoolean)
  {
    this.b.setOnCheckedChangeListener(null);
    this.b.setChecked(paramBoolean);
    this.b.setOnCheckedChangeListener(this);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getBaseActivity().getAppRuntime() instanceof QQAppInterface))
    {
      this.a = ((QQAppInterface)getBaseActivity().getAppRuntime());
      paramLayoutInflater = this.a;
      if (paramLayoutInflater != null)
      {
        paramLayoutInflater.addObserver(this.d);
        a(this.mContentView);
        a();
      }
    }
    else
    {
      paramLayoutInflater = new StringBuilder();
      paramLayoutInflater.append("error runtime?");
      paramLayoutInflater.append(getQBaseActivity().getAppRuntime());
      QLog.w("MatchChatSettingFragment", 1, paramLayoutInflater.toString());
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131629181;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton == this.b.getSwitch()) {
      if (NetworkUtil.isNetSupport(getBaseActivity()))
      {
        ((IExpandHandler)this.a.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).b(this.a.getCurrentUin(), paramBoolean);
        ReportController.b(this.a, "dc00898", "", "", "0X800A690", "0X800A690", paramBoolean ^ true, 0, "", "", "", "");
        HashMap localHashMap = new HashMap();
        String str;
        if (paramBoolean) {
          str = "1";
        } else {
          str = "0";
        }
        localHashMap.put("ext_int1", str);
        ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#message_setting_page#dnd_mode", true, -1L, -1L, localHashMap, true, true);
      }
      else
      {
        a(paramBoolean ^ true);
        QQToast.makeText(getBaseActivity(), 2131892114, 0).show();
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131442493) {
      ThreadManagerV2.excute(new MatchChatSettingFragment.2(this), 16, null, true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getBaseActivity().getString(2131897002));
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.d);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#message_setting_page#view", true, -1L, -1L, null, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatSettingFragment
 * JD-Core Version:    0.7.0.1
 */