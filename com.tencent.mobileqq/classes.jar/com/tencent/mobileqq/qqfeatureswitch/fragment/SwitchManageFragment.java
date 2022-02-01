package com.tencent.mobileqq.qqfeatureswitch.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqfeatureswitch.FeatureSwitch;
import com.tencent.mobileqq.qqfeatureswitch.SwitchManageAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import mqq.app.AppRuntime;

public class SwitchManageFragment
  extends QPublicBaseFragment
  implements View.OnClickListener, SwitchManageController.ISwitchManageView
{
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private SwitchManageAdapter jdField_a_of_type_ComTencentMobileqqQqfeatureswitchSwitchManageAdapter;
  private SwitchManageController jdField_a_of_type_ComTencentMobileqqQqfeatureswitchFragmentSwitchManageController;
  
  private void a(View paramView)
  {
    ((TextView)paramView.findViewById(2131379864)).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131366332));
    this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
    Object localObject = paramView.findViewById(2131376752);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
    localLayoutParams.topMargin += ImmersiveUtils.getStatusBarHeight(getActivity());
    ((View)localObject).setLayoutParams(localLayoutParams);
    localObject = (ListView)paramView.findViewById(2131370510);
    this.jdField_a_of_type_ComTencentMobileqqQqfeatureswitchSwitchManageAdapter = new SwitchManageAdapter(getQBaseActivity());
    ((ListView)localObject).setAdapter(this.jdField_a_of_type_ComTencentMobileqqQqfeatureswitchSwitchManageAdapter);
    ((TextView)paramView.findViewById(2131369249)).setText(getString(2131692239));
    ((TextView)paramView.findViewById(2131369202)).setOnClickListener(this);
    ((TextView)paramView.findViewById(2131379852)).setOnClickListener(this);
  }
  
  public AppRuntime a()
  {
    return getQBaseActivity().getAppRuntime();
  }
  
  public void a(List<FeatureSwitch> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqfeatureswitchSwitchManageAdapter.a(paramList);
    this.jdField_a_of_type_ComTencentMobileqqQqfeatureswitchSwitchManageAdapter.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131379864)
    {
      String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      this.jdField_a_of_type_ComTencentMobileqqQqfeatureswitchFragmentSwitchManageController.a(str);
    }
    else if (paramView.getId() == 2131369202)
    {
      getActivity().finish();
    }
    else if (paramView.getId() == 2131379852)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqfeatureswitchFragmentSwitchManageController.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqfeatureswitchFragmentSwitchManageController = new SwitchManageController(this);
    paramLayoutInflater = paramLayoutInflater.inflate(2131562903, paramViewGroup, false);
    a(paramLayoutInflater);
    this.jdField_a_of_type_ComTencentMobileqqQqfeatureswitchFragmentSwitchManageController.b();
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqfeatureswitch.fragment.SwitchManageFragment
 * JD-Core Version:    0.7.0.1
 */