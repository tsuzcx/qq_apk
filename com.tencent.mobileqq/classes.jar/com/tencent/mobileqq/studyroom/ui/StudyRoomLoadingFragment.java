package com.tencent.mobileqq.studyroom.ui;

import afez;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import anzj;
import bdwb;
import bdwc;
import bdwm;
import bjbs;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;

public class StudyRoomLoadingFragment
  extends PublicBaseFragment
{
  private bjbs jdField_a_of_type_Bjbs;
  private Future<?> jdField_a_of_type_JavaUtilConcurrentFuture;
  
  public static void a(Map<String, String> paramMap)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    if (paramMap == null) {}
    for (paramMap = new HashMap();; paramMap = new HashMap(paramMap))
    {
      localIntent.putExtra("param", paramMap);
      afez.a(localIntent, PublicTransFragmentActivity.class, StudyRoomLoadingFragment.class);
      return;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bjbs == null)
    {
      this.jdField_a_of_type_Bjbs = new bjbs(getActivity(), 40);
      this.jdField_a_of_type_Bjbs.a(anzj.a(2131706704));
      this.jdField_a_of_type_Bjbs.setOnCancelListener(new bdwb(this));
    }
    this.jdField_a_of_type_Bjbs.show();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Bjbs != null) {
      this.jdField_a_of_type_Bjbs.dismiss();
    }
  }
  
  public void a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    a();
    return super.onBackEvent();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = new FrameLayout(paramViewGroup.getContext());
    paramLayoutInflater.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_a_of_type_JavaUtilConcurrentFuture != null) && (!this.jdField_a_of_type_JavaUtilConcurrentFuture.isDone()))
    {
      this.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
      QLog.i("studyroom.StudyRoomLoadingFragment", 4, "cancel load plugin");
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    b();
    paramView = new Bundle();
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getSerializable("param");
      if ((paramBundle instanceof HashMap))
      {
        Iterator localIterator = ((HashMap)paramBundle).keySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = localIterator.next();
          if ((localObject1 instanceof String))
          {
            Object localObject2 = ((HashMap)paramBundle).get(localObject1);
            if ((localObject2 instanceof String)) {
              paramView.putString((String)localObject1, (String)localObject2);
            }
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentFuture = bdwm.a(getActivity().getApplicationContext(), paramView, false, new bdwc(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.ui.StudyRoomLoadingFragment
 * JD-Core Version:    0.7.0.1
 */