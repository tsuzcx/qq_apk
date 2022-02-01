package com.tencent.mobileqq.flashshow.fragment.tab;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.flashshow.bean.FSMainTabInfo;
import com.tencent.mobileqq.flashshow.fragment.FSBaseFragment;
import com.tencent.mobileqq.flashshow.ioc.IFSTabFragmentIoc;
import com.tencent.mobileqq.flashshow.part.FSLayerPageBottomPart;
import com.tencent.mobileqq.flashshow.part.FSLayerTabPart;
import com.tencent.mobileqq.flashshow.part.FSRedPointTipsPart;
import com.tencent.mobileqq.flashshow.view.FSPageTurnContainer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public abstract class FSBaseTabFragment
  extends FSBaseFragment
{
  protected final FSMainTabInfo b;
  protected FSLayerTabPart c;
  protected IFSTabFragmentIoc d;
  private final int e;
  
  protected FSBaseTabFragment(FSMainTabInfo paramFSMainTabInfo, int paramInt)
  {
    this.b = paramFSMainTabInfo;
    this.e = paramInt;
  }
  
  public static FSBaseTabFragment a(FSMainTabInfo paramFSMainTabInfo, int paramInt)
  {
    if (paramFSMainTabInfo == null) {
      return null;
    }
    if (paramFSMainTabInfo.b() == 40) {
      return new FSFollowTabFragment(paramFSMainTabInfo, paramInt);
    }
    if (paramFSMainTabInfo.b() == 41) {
      return new FSRcmdTabFragment(paramFSMainTabInfo, paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createTabFragment unknown sourceType:");
    localStringBuilder.append(paramFSMainTabInfo.b());
    QLog.e("FSBaseTabFragment", 1, localStringBuilder.toString());
    return null;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void a(IFSTabFragmentIoc paramIFSTabFragmentIoc)
  {
    this.d = paramIFSTabFragmentIoc;
  }
  
  protected List<Part> d()
  {
    ArrayList localArrayList = new ArrayList();
    this.c = new FSLayerTabPart(this.b);
    this.c.a(this.d);
    this.c.b(this.e);
    localArrayList.add(this.c);
    Object localObject = new FSRedPointTipsPart(this.b);
    ((FSRedPointTipsPart)localObject).a(this.d);
    ((FSRedPointTipsPart)localObject).a(this.e);
    localArrayList.add(localObject);
    if (l())
    {
      localObject = new FSLayerPageBottomPart();
      ((FSLayerPageBottomPart)localObject).a(this.d);
      localArrayList.add(localObject);
    }
    return localArrayList;
  }
  
  public FSLayerTabPart g()
  {
    return this.c;
  }
  
  public FSMainTabInfo h()
  {
    return this.b;
  }
  
  public void i()
  {
    QLog.d(b(), 1, "scrollToTop");
    try
    {
      this.c.r().getViewPager2().setCurrentItem(0);
      return;
    }
    catch (Exception localException)
    {
      String str = b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scrollToTop exception:");
      localStringBuilder.append(localException.toString());
      QLog.d(str, 1, localStringBuilder.toString());
    }
  }
  
  public void k()
  {
    QLog.d(b(), 1, "scrollToTop");
    try
    {
      if (this.d != null) {
        this.d.a("event_hide_comment", new Object[0]);
      }
      this.c.v();
      return;
    }
    catch (Exception localException)
    {
      String str = b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scrollToTop exception:");
      localStringBuilder.append(localException.toString());
      QLog.d(str, 1, localStringBuilder.toString());
    }
  }
  
  public boolean l()
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
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean v()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.fragment.tab.FSBaseTabFragment
 * JD-Core Version:    0.7.0.1
 */