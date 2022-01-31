package com.tencent.mobileqq.mini.entry.desktop;

import agtk;
import android.app.Activity;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.HongBaoResBuilder;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;

class MiniAppDesktopAdapter$ModuleViewHolder
  extends RecyclerView.ViewHolder
{
  private WeakReference<Activity> mActivityReference;
  private MiniAppInfo mAppStoreInfo;
  private TextView mModuleText;
  private ImageView mMoreMiniApp;
  
  public MiniAppDesktopAdapter$ModuleViewHolder(View paramView, Activity paramActivity)
  {
    super(paramView);
    this.mActivityReference = new WeakReference(paramActivity);
    this.mModuleText = ((TextView)paramView.findViewById(2131304535));
    this.mMoreMiniApp = ((ImageView)paramView.findViewById(2131304534));
  }
  
  public void update(DesktopAppModuleInfo paramDesktopAppModuleInfo)
  {
    this.mModuleText.setText(paramDesktopAppModuleInfo.moduleTitle);
    Object localObject2 = MiniAppUtils.getAppInterface();
    if (localObject2 != null)
    {
      Object localObject1 = (agtk)((AppInterface)localObject2).getManager(342);
      if ((localObject1 == null) || (!((agtk)localObject1).h())) {
        break label193;
      }
      DesktopDataManager localDesktopDataManager = (DesktopDataManager)((AppInterface)localObject2).getManager(336);
      localObject2 = ((agtk)localObject1).a();
      localObject1 = localObject2;
      if (localDesktopDataManager != null)
      {
        localObject1 = localObject2;
        if (localDesktopDataManager.getHongBaoResBuilder() != null) {
          localObject1 = localDesktopDataManager.getHongBaoResBuilder();
        }
      }
      if (localObject1 != null)
      {
        if ((((DesktopDataManager.HongBaoResBuilder)localObject1).getTextColor() != 2147483647) && (this.mModuleText != null)) {
          this.mModuleText.setTextColor(((DesktopDataManager.HongBaoResBuilder)localObject1).getTextColor());
        }
        if ((((DesktopDataManager.HongBaoResBuilder)localObject1).getModuleMoreIconResId() != -1) && (this.mMoreMiniApp != null)) {
          this.mMoreMiniApp.setImageResource(((DesktopDataManager.HongBaoResBuilder)localObject1).getModuleMoreIconResId());
        }
      }
    }
    if ((paramDesktopAppModuleInfo.getModuleType() == 1) || (paramDesktopAppModuleInfo.getModuleType() == 2))
    {
      if (paramDesktopAppModuleInfo.appStoreInfo != null)
      {
        this.mAppStoreInfo = paramDesktopAppModuleInfo.appStoreInfo;
        this.mMoreMiniApp.setVisibility(0);
      }
      for (;;)
      {
        this.mMoreMiniApp.setOnClickListener(new MiniAppDesktopAdapter.ModuleViewHolder.1(this));
        return;
        label193:
        this.mModuleText.setTextColor(BaseApplicationImpl.getContext().getResources().getColor(2131101336));
        this.mMoreMiniApp.setImageResource(2130848851);
        break;
        this.mMoreMiniApp.setVisibility(8);
      }
    }
    this.mMoreMiniApp.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.ModuleViewHolder
 * JD-Core Version:    0.7.0.1
 */