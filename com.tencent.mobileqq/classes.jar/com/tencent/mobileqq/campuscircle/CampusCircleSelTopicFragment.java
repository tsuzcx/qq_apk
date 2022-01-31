package com.tencent.mobileqq.campuscircle;

import abpx;
import abpy;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.HorizontalLabelLayout;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.List;

public class CampusCircleSelTopicFragment
  extends Fragment
  implements Handler.Callback, View.OnClickListener
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public IphoneTitleBarActivity a;
  CampusCircleObserver jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleObserver = new abpy(this);
  TopicAdapter jdField_a_of_type_ComTencentMobileqqCampuscircleTopicAdapter;
  public WeakReferenceHandler a;
  HorizontalLabelLayout jdField_a_of_type_ComTencentWidgetHorizontalLabelLayout;
  TopicAdapter jdField_b_of_type_ComTencentMobileqqCampuscircleTopicAdapter;
  HorizontalLabelLayout jdField_b_of_type_ComTencentWidgetHorizontalLabelLayout;
  TopicAdapter c;
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = 0;
    int i = 0;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if ((paramMessage.obj instanceof List))
      {
        this.jdField_a_of_type_ComTencentMobileqqCampuscircleTopicAdapter.a((ArrayList)paramMessage.obj);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
        i = 0;
        while (i < this.jdField_a_of_type_ComTencentMobileqqCampuscircleTopicAdapter.getCount())
        {
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqCampuscircleTopicAdapter.getView(i, null, null);
          if (paramMessage != null)
          {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramMessage);
            paramMessage = paramMessage.findViewById(2131368914);
            paramMessage.setTag(this.jdField_a_of_type_ComTencentMobileqqCampuscircleTopicAdapter.getItem(i));
            paramMessage.setOnClickListener(this);
          }
          i += 1;
        }
        if ((paramMessage.obj instanceof List))
        {
          this.jdField_b_of_type_ComTencentMobileqqCampuscircleTopicAdapter.a((ArrayList)paramMessage.obj);
          this.jdField_a_of_type_ComTencentWidgetHorizontalLabelLayout.removeAllViews();
          while (i < this.jdField_b_of_type_ComTencentMobileqqCampuscircleTopicAdapter.getCount())
          {
            paramMessage = this.jdField_b_of_type_ComTencentMobileqqCampuscircleTopicAdapter.getView(i, null, null);
            if (paramMessage != null)
            {
              this.jdField_a_of_type_ComTencentWidgetHorizontalLabelLayout.addView(paramMessage);
              paramMessage = paramMessage.findViewById(2131368914);
              paramMessage.setTag(this.jdField_b_of_type_ComTencentMobileqqCampuscircleTopicAdapter.getItem(i));
              paramMessage.setOnClickListener(this);
            }
            i += 1;
          }
          if ((paramMessage.obj instanceof List))
          {
            this.c.a((ArrayList)paramMessage.obj);
            this.jdField_b_of_type_ComTencentWidgetHorizontalLabelLayout.removeAllViews();
            i = j;
            while (i < this.c.getCount())
            {
              paramMessage = this.c.getView(i, null, null);
              if (paramMessage != null)
              {
                this.jdField_b_of_type_ComTencentWidgetHorizontalLabelLayout.addView(paramMessage);
                paramMessage.setTag(this.c.getItem(i));
                paramMessage.setOnClickListener(this);
              }
              i += 1;
            }
          }
        }
      }
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleObserver, true);
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources();
      i = paramBundle.getColor(2131493382);
      this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getTitleBarView().setBackgroundDrawable(paramBundle.getDrawable(2130842360));
      if (this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.mSystemBarComp != null) {
        break label197;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.setImmersiveStatus(i);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.setTitle("选择版块");
      this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.setLeftButton(2131432414, null);
      this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.centerView.setTextColor(paramBundle.getColorStateList(2131494127));
      TextView localTextView = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.leftViewNotBack;
      localTextView.setBackgroundDrawable(null);
      localTextView.setTextSize(1, 17.0F);
      localTextView.setTextColor(paramBundle.getColorStateList(2131494127));
      localTextView.setCompoundDrawablesWithIntrinsicBounds(2130842354, 0, 0, 0);
      localTextView.setCompoundDrawablePadding(8);
      ThreadManager.post(new abpx(this), 5, null, true);
      if (QLog.isDevelopLevel()) {
        QLog.i("CampusCircleSelTopicFragment", 4, "onActivityCreated");
      }
      return;
      label197:
      this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.mSystemBarComp.setStatusBarDrawable(null);
      this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.mSystemBarComp.setStatusBarColor(i);
      this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.mSystemBarComp.setStatusColor(i);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof IphoneTitleBarActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity = ((IphoneTitleBarActivity)paramActivity);
      this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getWindow().setSoftInputMode(2);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("CampusCircleSelTopicFragment", 4, "onAttach");
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof CampusTopic))
    {
      paramView = (CampusTopic)paramView;
      Intent localIntent = new Intent();
      localIntent.putExtra("topic", paramView.convert2JSONString());
      if (this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.setResult(-1, localIntent);
        this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.finish();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isDevelopLevel()) {
      QLog.i("CampusCircleSelTopicFragment", 4, "onCreate");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130970277, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131369927));
    this.jdField_a_of_type_ComTencentWidgetHorizontalLabelLayout = ((HorizontalLabelLayout)paramLayoutInflater.findViewById(2131369928));
    this.jdField_a_of_type_ComTencentWidgetHorizontalLabelLayout.setStyle(1);
    this.jdField_b_of_type_ComTencentWidgetHorizontalLabelLayout = ((HorizontalLabelLayout)paramLayoutInflater.findViewById(2131369930));
    this.jdField_a_of_type_ComTencentMobileqqCampuscircleTopicAdapter = new TopicAdapter(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 2);
    this.jdField_b_of_type_ComTencentMobileqqCampuscircleTopicAdapter = new TopicAdapter(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 2);
    this.c = new TopicAdapter(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 1);
    if (QLog.isDevelopLevel()) {
      QLog.i("CampusCircleSelTopicFragment", 4, "onCreateView");
    }
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleObserver);
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    super.onDestroy();
    if (QLog.isDevelopLevel()) {
      QLog.i("CampusCircleSelTopicFragment", 4, "onDestroy");
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity = null;
    if (QLog.isDevelopLevel()) {
      QLog.i("CampusCircleSelTopicFragment", 4, "onDetach");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusCircleSelTopicFragment
 * JD-Core Version:    0.7.0.1
 */