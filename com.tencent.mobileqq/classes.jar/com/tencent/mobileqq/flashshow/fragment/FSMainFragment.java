package com.tencent.mobileqq.flashshow.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qcircleshadow.lib.variation.HostAppSettingUtil;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.flashshow.ioc.IFSFolderIoc;
import com.tencent.mobileqq.flashshow.part.FSCommentPanelPart;
import com.tencent.mobileqq.flashshow.part.FSDebugPart;
import com.tencent.mobileqq.flashshow.part.FSFolderFragmentPart;
import com.tencent.mobileqq.flashshow.part.FSMainChipPart;
import com.tencent.mobileqq.flashshow.part.FSMainMultiTabFragmentPart;
import com.tencent.mobileqq.flashshow.part.FSPublishStatusBoxPart;
import com.tencent.mobileqq.flashshow.part.FSSharePart;
import com.tencent.mobileqq.flashshow.part.FSTopPopBannerPart;
import com.tencent.mobileqq.flashshow.report.dc.FSMonitorReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.List;

public class FSMainFragment
  extends FSBaseFragment
{
  private List<Part> b;
  private FSMainMultiTabFragmentPart c;
  private IFSFolderIoc d;
  private FSCommentPanelPart e;
  private FSSharePart f;
  private FSTopPopBannerPart g;
  private FSPublishStatusBoxPart h;
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    if (g())
    {
      paramLayoutInflater = this.D.findViewById(2131433322);
      paramLayoutInflater.setVisibility(0);
      paramLayoutInflater.setOnClickListener(new FSMainFragment.1(this));
    }
  }
  
  public void a(FSFolderFragmentPart paramFSFolderFragmentPart)
  {
    this.d = paramFSFolderFragmentPart;
  }
  
  public String b()
  {
    return "FSMainFragment";
  }
  
  protected int c()
  {
    return 2131624815;
  }
  
  protected List<Part> d()
  {
    if (this.b == null)
    {
      this.b = new ArrayList();
      this.c = new FSMainMultiTabFragmentPart();
      this.b.add(this.c);
      this.b.add(new FSMainChipPart());
      this.e = new FSCommentPanelPart();
      this.b.add(this.e);
      this.f = new FSSharePart();
      this.b.add(this.f);
      this.g = new FSTopPopBannerPart();
      this.b.add(this.g);
      if (!HostAppSettingUtil.isPublicVersion()) {
        this.b.add(new FSDebugPart());
      }
      this.h = new FSPublishStatusBoxPart();
      this.b.add(this.h);
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
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    if (g()) {
      FSMonitorReporter.a().h();
    }
    return super.onBackEvent();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    FSMainMultiTabFragmentPart localFSMainMultiTabFragmentPart = this.c;
    if (localFSMainMultiTabFragmentPart != null) {
      localFSMainMultiTabFragmentPart.a(this.d);
    }
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onPause()
  {
    QLog.d(b(), 1, "fs_lifecycle onPause");
    super.onPause();
  }
  
  public void onResume()
  {
    QLog.d(b(), 1, "fs_lifecycle onResume");
    super.onResume();
  }
  
  public boolean v()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.fragment.FSMainFragment
 * JD-Core Version:    0.7.0.1
 */