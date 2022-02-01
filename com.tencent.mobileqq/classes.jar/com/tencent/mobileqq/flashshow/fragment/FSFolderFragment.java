package com.tencent.mobileqq.flashshow.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabBackEvent;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.mobileqq.auto.engine.lib.IASEngineDelegate;
import com.tencent.mobileqq.auto.engine.lib.IBackEventListener;
import com.tencent.mobileqq.flashshow.api.IFSJumpSelectPhotoUtils;
import com.tencent.mobileqq.flashshow.api.IFlashShowColdBootService;
import com.tencent.mobileqq.flashshow.config.FSConfig;
import com.tencent.mobileqq.flashshow.part.FSFolderFragmentPart;
import com.tencent.mobileqq.flashshow.report.dc.FSMonitorReporter;
import com.tencent.mobileqq.flashshow.report.dc.FSReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.QQWinkLaucher;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FSFolderFragment
  extends FSBaseFragment
{
  private List<Part> b;
  private FSFolderFragmentPart c;
  
  public FSFolderFragment()
  {
    ((IFlashShowColdBootService)QRoute.api(IFlashShowColdBootService.class)).activate();
  }
  
  private void a(ASEngineTabBackEvent paramASEngineTabBackEvent)
  {
    if (!paramASEngineTabBackEvent.getBusinessKey().equals("flash-show-app")) {
      return;
    }
    boolean bool = onBackEvent();
    ASInject.g().getOnBackEventListener().onBackEvent(bool, "flash-show-app");
  }
  
  private void a(ASEngineTabStatusEvent paramASEngineTabStatusEvent)
  {
    if (!paramASEngineTabStatusEvent.getBusinessKey().equals("flash-show-app")) {
      return;
    }
    if (paramASEngineTabStatusEvent.isSelected())
    {
      QLog.d("FSFolderFragment", 1, "receive onTab selected event");
      onResume();
      return;
    }
    onStop();
  }
  
  private boolean h()
  {
    boolean bool = ASInject.g().getAsEngineDelegate().isOnThirdTab("flash-show-app");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FsFolder back isPluginTab:");
    localStringBuilder.append(false);
    localStringBuilder.append("_");
    localStringBuilder.append(bool);
    localStringBuilder.append("_");
    localStringBuilder.append(false);
    QLog.d("ASDynamicEngine_back", 1, localStringBuilder.toString());
    return false;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    if (g()) {
      this.D.setBackgroundColor(getResources().getColor(2131166065));
    }
  }
  
  public String b()
  {
    return "FSFolderFragment";
  }
  
  protected int c()
  {
    return 2131624800;
  }
  
  protected List<Part> d()
  {
    if (this.b == null)
    {
      this.b = new ArrayList();
      this.c = new FSFolderFragmentPart();
      this.b.add(this.c);
    }
    return this.b;
  }
  
  public String e()
  {
    return "";
  }
  
  public boolean g()
  {
    if (getActivity() != null)
    {
      if (getActivity().getIntent() == null) {
        return false;
      }
      return getActivity().getIntent().getBooleanExtra("fs_key_bundle_individual_folder_page", false);
    }
    return false;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = super.getEventClass();
    localArrayList.add(ASEngineTabBackEvent.class);
    localArrayList.add(ASEngineTabStatusEvent.class);
    return localArrayList;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public int j()
  {
    return 0;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 20000) && (paramInt2 == -1)) {
      ((IFSJumpSelectPhotoUtils)QRoute.api(IFSJumpSelectPhotoUtils.class)).jumpPublishMood(getActivity(), paramIntent);
    }
  }
  
  public boolean onBackEvent()
  {
    if (h())
    {
      boolean bool = super.onBackEvent();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FsFolder back onBackEvent:");
      localStringBuilder.append(bool);
      QLog.d("ASDynamicEngine_back", 1, localStringBuilder.toString());
      ASInject.g().getOnBackEventListener().onBackEvent(bool, "flash-show-app");
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    FSMonitorReporter.a().b();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ((IFlashShowColdBootService)QRoute.api(IFlashShowColdBootService.class)).unlock();
    FSMonitorReporter.a().c();
  }
  
  public void onPause()
  {
    QLog.d("FSFolderFragment", 1, "fs_lifecycle onPause");
    super.onPause();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    super.onReceiveEvent(paramSimpleBaseEvent);
    if ((paramSimpleBaseEvent instanceof ASEngineTabBackEvent))
    {
      a((ASEngineTabBackEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof ASEngineTabStatusEvent)) {
      a((ASEngineTabStatusEvent)paramSimpleBaseEvent);
    }
  }
  
  public void onResume()
  {
    QLog.d("FSFolderFragment", 1, "fs_lifecycle onResume");
    super.onResume();
    if ((FSConfig.q()) && (getActivity() != null)) {
      QQWinkLaucher.a(getActivity());
    }
  }
  
  public void onStop()
  {
    super.onStop();
    FSReporter.a().d();
  }
  
  public boolean v()
  {
    return g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.fragment.FSFolderFragment
 * JD-Core Version:    0.7.0.1
 */