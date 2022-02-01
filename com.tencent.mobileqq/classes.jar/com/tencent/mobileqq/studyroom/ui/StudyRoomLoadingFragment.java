package com.tencent.mobileqq.studyroom.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.studyroom.utils.PluginUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;

public class StudyRoomLoadingFragment
  extends QPublicBaseFragment
{
  private QQProgressDialog a;
  private Future<?> b = null;
  
  public static void a(String paramString, Map<String, String> paramMap)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    if (paramMap == null) {
      paramMap = new HashMap();
    } else {
      paramMap = new HashMap(paramMap);
    }
    paramMap.put("action", paramString);
    localIntent.putExtra("param", paramMap);
    QPublicFragmentActivity.Launcher.a(localIntent, QPublicTransFragmentActivity.class, StudyRoomLoadingFragment.class);
  }
  
  private void b()
  {
    if (this.a == null)
    {
      this.a = new QQProgressDialog(getQBaseActivity(), 40);
      this.a.a(HardCodeUtil.a(2131905642));
      this.a.setOnCancelListener(new StudyRoomLoadingFragment.1(this));
    }
    this.a.show();
  }
  
  private void c()
  {
    QQProgressDialog localQQProgressDialog = this.a;
    if (localQQProgressDialog != null) {
      localQQProgressDialog.dismiss();
    }
  }
  
  public void a()
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if (localQBaseActivity != null) {
      localQBaseActivity.finish();
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
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Future localFuture = this.b;
    if ((localFuture != null) && (!localFuture.isDone()))
    {
      this.b.cancel(true);
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
        paramBundle = (HashMap)paramBundle;
        Iterator localIterator = paramBundle.keySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = localIterator.next();
          if ((localObject1 instanceof String))
          {
            Object localObject2 = paramBundle.get(localObject1);
            if ((localObject2 instanceof String)) {
              paramView.putString((String)localObject1, (String)localObject2);
            }
          }
        }
      }
    }
    this.b = PluginUtils.a(getQBaseActivity().getApplicationContext(), paramView, false, new StudyRoomLoadingFragment.WeakCallback(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.ui.StudyRoomLoadingFragment
 * JD-Core Version:    0.7.0.1
 */