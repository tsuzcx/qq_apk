package com.tencent.mobileqq.winkpublish.qcircle.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.winkpublish.base.PublishBaseFragment;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.part.PublishContentPart;
import com.tencent.mobileqq.winkpublish.part.PublishLabelPart;
import com.tencent.mobileqq.winkpublish.part.PublishLbsPart;
import com.tencent.mobileqq.winkpublish.part.PublishMediaPart;
import com.tencent.mobileqq.winkpublish.part.PublishSavePart;
import com.tencent.mobileqq.winkpublish.part.PublishSharePart;
import com.tencent.mobileqq.winkpublish.part.PublishTitlePart;
import com.tencent.mobileqq.winkpublish.viewmodel.PublishLabelViewModel;
import com.tencent.mobileqq.winkpublish.viewmodel.PublishViewModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QCircleUploadActivityFragment
  extends PublishBaseFragment
{
  public static final String b;
  private List<Part> c;
  private PublishTitlePart d;
  private PublishContentPart e;
  private PublishMediaPart f;
  private PublishLabelPart g;
  private PublishLbsPart h;
  private PublishSharePart i;
  private PublishSavePart j;
  private PublishViewModel k;
  private PublishLabelViewModel l;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(UploadConstants.a);
    localStringBuilder.append("FSUploadActivityFragment");
    b = localStringBuilder.toString();
  }
  
  private void f()
  {
    QLog.d(b, 1, "initViewModelData...");
    if (this.k == null) {
      this.k = ((PublishViewModel)a(PublishViewModel.class));
    }
    this.k.a(this, getActivity().getIntent(), false);
    if (this.l == null) {
      this.l = ((PublishLabelViewModel)a(PublishLabelViewModel.class));
    }
    this.l.a(getActivity().getIntent());
  }
  
  protected Map<String, Object> a()
  {
    return super.a();
  }
  
  public String b()
  {
    return b;
  }
  
  protected int c()
  {
    return 2131627216;
  }
  
  protected List<Part> d()
  {
    f();
    if (this.c == null)
    {
      this.c = new ArrayList();
      this.d = new PublishTitlePart();
      this.c.add(this.d);
      this.e = new PublishContentPart();
      this.c.add(this.e);
      this.f = new PublishMediaPart();
      this.c.add(this.f);
      this.g = new PublishLabelPart();
      this.c.add(this.g);
      this.h = new PublishLbsPart();
      this.c.add(this.h);
      this.i = new PublishSharePart();
      this.c.add(this.i);
      this.j = new PublishSavePart();
      this.c.add(this.j);
    }
    return this.c;
  }
  
  public String e()
  {
    return "pg_xsj_publish_new_page";
  }
  
  protected int j()
  {
    return 0;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (getActivity() != null) {
      getActivity().getWindow().setSoftInputMode(3);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    super.onCreate(paramBundle);
    ImmersiveUtils.setStatusTextColor(QQTheme.isNowThemeIsNight() ^ true, getActivity().getWindow());
    paramBundle = new StringBuilder();
    paramBundle.append("[Performance2]");
    paramBundle.append(b);
    paramBundle = paramBundle.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onCreate...] + END, time cost:");
    localStringBuilder.append(System.currentTimeMillis() - l1);
    QLog.d(paramBundle, 1, localStringBuilder.toString());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("[Performance2]");
    paramViewGroup.append(b);
    paramViewGroup = paramViewGroup.toString();
    paramBundle = new StringBuilder();
    paramBundle.append("[onCreateView...] + END, time cost:");
    paramBundle.append(System.currentTimeMillis() - l1);
    QLog.d(paramViewGroup, 1, paramBundle.toString());
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    PublishViewModel localPublishViewModel = this.k;
    if (localPublishViewModel != null) {
      localPublishViewModel.onCleared();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    QLog.d(b, 1, "onNewIntent...");
    getActivity().setIntent(paramIntent);
    if (this.k == null) {
      this.k = ((PublishViewModel)a(PublishViewModel.class));
    }
    this.k.a(this, getActivity().getIntent(), true);
  }
  
  public void onPause()
  {
    long l1 = System.currentTimeMillis();
    super.onPause();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[Performance2]");
    ((StringBuilder)localObject).append(b);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onPause...] + END, time cost:");
    localStringBuilder.append(System.currentTimeMillis() - l1);
    QLog.d((String)localObject, 1, localStringBuilder.toString());
  }
  
  public void onResume()
  {
    super.onResume();
    PublishViewModel localPublishViewModel = this.k;
    if (localPublishViewModel != null) {
      int m = localPublishViewModel.m;
    }
  }
  
  public void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle = this.k;
    if ((paramBundle != null) && (paramBundle.e()) && (!this.k.f()) && (!this.k.o)) {
      this.k.a(this, 2);
    }
  }
  
  public void onStart()
  {
    long l1 = System.currentTimeMillis();
    super.onStart();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[Performance2]");
    ((StringBuilder)localObject).append(b);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onStart...] + END, time cost:");
    localStringBuilder.append(System.currentTimeMillis() - l1);
    QLog.d((String)localObject, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.qcircle.activity.QCircleUploadActivityFragment
 * JD-Core Version:    0.7.0.1
 */