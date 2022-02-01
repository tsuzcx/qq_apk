package com.tencent.mobileqq.mini.entry.desktop;

import android.app.Activity;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopMostCommonlyUsedInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import java.lang.ref.WeakReference;

class MiniAppDesktopAdapter$DesktopMostCommonlyUsedViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private WeakReference<Activity> activityReference;
  private ImageView addBtn;
  private View backgroundView;
  private ImageView closeBtn;
  private TextView helpInfo;
  private ImageView icon;
  private MiniAppInfo miniAppInfo;
  public int state = -1;
  private TextView title;
  
  public MiniAppDesktopAdapter$DesktopMostCommonlyUsedViewHolder(View paramView, WeakReference<Activity> paramWeakReference)
  {
    super(paramView);
    this.activityReference = paramWeakReference;
    this.backgroundView = paramView.findViewById(2131371087);
    this.icon = ((ImageView)paramView.findViewById(2131371090));
    this.title = ((TextView)paramView.findViewById(2131371093));
    this.helpInfo = ((TextView)paramView.findViewById(2131371089));
    this.addBtn = ((ImageView)paramView.findViewById(2131371086));
    this.closeBtn = ((ImageView)paramView.findViewById(2131371088));
    this.helpInfo.setText(HardCodeUtil.a(2131706928));
    this.backgroundView.setOnClickListener(this);
    this.addBtn.setOnClickListener(this);
    this.closeBtn.setOnClickListener(this);
  }
  
  private void onAddBtnClicked()
  {
    if (this.miniAppInfo == null) {
      return;
    }
    this.state = 1;
    setAllVisibility(8);
    DesktopDataManager localDesktopDataManager = (DesktopDataManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER);
    localDesktopDataManager.addAppToMyApp(this.miniAppInfo);
    MiniAppCmdUtil.getInstance().setUserAppTop(this.miniAppInfo.appId, 1, this.miniAppInfo.verType, null, new MiniAppDesktopAdapter.DesktopMostCommonlyUsedViewHolder.1(this));
    localDesktopDataManager.removeAppByModuleType(this.miniAppInfo.appId, 8);
    MiniProgramLpReportDC04239.reportAsync("desktop", "add", "add_commonly", null);
  }
  
  private void onCloseBtnClicked()
  {
    this.state = 2;
    setAllVisibility(8);
    rejectFrequentlyRecommends();
    ((DesktopDataManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER)).removeAppByModuleType(this.miniAppInfo.appId, 8);
    MiniProgramLpReportDC04239.reportAsync("desktop", "commonly", "close", null);
  }
  
  private void onOtherClicked()
  {
    if (this.miniAppInfo == null) {
      return;
    }
    this.state = 3;
    MiniAppDesktopAdapter.startMiniApp((Activity)this.activityReference.get(), this.miniAppInfo, 3027);
    MiniProgramLpReportDC04239.reportAsync("desktop", "commonly", "click", null);
  }
  
  private void setAllVisibility(int paramInt)
  {
    View localView = this.backgroundView;
    if (localView != null) {
      localView.setVisibility(paramInt);
    }
  }
  
  public void bindView(DesktopMostCommonlyUsedInfo paramDesktopMostCommonlyUsedInfo)
  {
    if (paramDesktopMostCommonlyUsedInfo != null)
    {
      if (paramDesktopMostCommonlyUsedInfo.appInfo == null) {
        return;
      }
      this.miniAppInfo = paramDesktopMostCommonlyUsedInfo.appInfo;
      paramDesktopMostCommonlyUsedInfo = this.icon;
      paramDesktopMostCommonlyUsedInfo.setImageDrawable(MiniAppUtils.getIcon(paramDesktopMostCommonlyUsedInfo.getContext(), this.miniAppInfo.iconUrl, true));
      String str = this.miniAppInfo.name;
      paramDesktopMostCommonlyUsedInfo = str;
      if (str != null)
      {
        paramDesktopMostCommonlyUsedInfo = str;
        if (str.length() >= 7)
        {
          paramDesktopMostCommonlyUsedInfo = new StringBuilder();
          paramDesktopMostCommonlyUsedInfo.append(str.substring(0, 5));
          paramDesktopMostCommonlyUsedInfo.append("...");
          paramDesktopMostCommonlyUsedInfo = paramDesktopMostCommonlyUsedInfo.toString();
        }
      }
      this.title.setText(paramDesktopMostCommonlyUsedInfo);
      this.state = 0;
      setAllVisibility(0);
      paramDesktopMostCommonlyUsedInfo = new MiniAppConfig(this.miniAppInfo);
      paramDesktopMostCommonlyUsedInfo.launchParam.scene = 3027;
      MiniProgramLpReportDC04239.reportAsync(paramDesktopMostCommonlyUsedInfo, "page_view", "expo", null, null);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131371086)
    {
      if (i != 2131371088)
      {
        onOtherClicked();
        return;
      }
      onCloseBtnClicked();
      return;
    }
    onAddBtnClicked();
  }
  
  public void rejectFrequentlyRecommends()
  {
    if (this.miniAppInfo == null) {
      return;
    }
    MiniAppCmdUtil.getInstance().rejectFrequentlyRecommends(this.miniAppInfo.appId, new MiniAppDesktopAdapter.DesktopMostCommonlyUsedViewHolder.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.DesktopMostCommonlyUsedViewHolder
 * JD-Core Version:    0.7.0.1
 */