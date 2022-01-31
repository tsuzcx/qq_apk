package com.tencent.mobileqq.richmedia.capture.fragment;

import ahhw;
import ahhx;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.EditPicActivity;
import com.tencent.biz.qqstory.takevideo2.LayoutModifier;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CaptureParam;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.PhotoCaptureResult;
import com.tencent.mobileqq.troop.homework.entry.ui.BeginnerGuideFragment;
import com.tencent.mobileqq.util.TroopReportor;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class ArithmeticCameraCaptureFragment
  extends CameraCaptureFragment
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  
  protected CameraCaptureView.CaptureParam a()
  {
    CameraCaptureView.CaptureParam localCaptureParam = super.a();
    localCaptureParam.f(2);
    localCaptureParam.a(1280);
    localCaptureParam.b(720);
    localCaptureParam.a(false);
    return localCaptureParam;
  }
  
  public void a(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult)
  {
    paramPhotoCaptureResult = EditPicActivity.a(getActivity(), paramPhotoCaptureResult.jdField_a_of_type_JavaLangString, false, false, false, true, false, 11);
    paramPhotoCaptureResult.putExtra("arithmetic_ability", 1L);
    paramPhotoCaptureResult.putExtra("troop_uin", this.jdField_a_of_type_JavaLangString);
    startActivityForResult(paramPhotoCaptureResult, 10001);
  }
  
  protected int b()
  {
    return 2130971651;
  }
  
  public void b(boolean paramBoolean) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null)
    {
      ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        getActivity().setResult(paramInt2, paramIntent);
        getActivity().finish();
        getActivity().overridePendingTransition(2131034165, 2131034328);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131363993)
    {
      TroopReportor.a("Grp_edu", "Grp_oral", "Oral_Photo_Out", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString, "" });
      getActivity().finish();
      getActivity().overridePendingTransition(2131034165, 2131034328);
      return;
    }
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    for (;;)
    {
      BeginnerGuideFragment.b(getActivity(), null, 7);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      TroopReportor.a("Grp_edu", "Grp_oral", "Oral_Photo_Tip_In", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString, "" });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_JavaLangString = getArguments().getString("troop_uin", "");
    TroopReportor.a("Grp_edu", "Grp_oral", "Oral_Photo_In", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString, "" });
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    LayoutModifier.a(paramLayoutInflater, new ahhw(this, paramLayoutInflater));
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = paramLayoutInflater.findViewById(2131375267);
    paramBundle = paramLayoutInflater.findViewById(2131375268);
    View localView1 = paramLayoutInflater.findViewById(2131375269);
    View localView2 = paramLayoutInflater.findViewById(2131375270);
    View localView3 = paramLayoutInflater.findViewById(2131375271);
    int i = UIUtils.b(getActivity()) / 4;
    int j = UIUtils.a(getActivity()) / 3;
    ((RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams()).setMargins(0, i, 0, 0);
    ((RelativeLayout.LayoutParams)paramBundle.getLayoutParams()).setMargins(0, i * 2, 0, 0);
    ((RelativeLayout.LayoutParams)localView1.getLayoutParams()).setMargins(0, i * 3, 0, 0);
    ((RelativeLayout.LayoutParams)localView2.getLayoutParams()).setMargins(j, 0, 0, 0);
    ((RelativeLayout.LayoutParams)localView3.getLayoutParams()).setMargins(j * 2, 0, 0, 0);
    this.c.setVisibility(8);
    paramViewGroup = (Button)paramLayoutInflater.findViewById(2131365653);
    paramViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131375273));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131375272));
    if (getActivity().getAppInterface().getAppRuntime("peak").getPreferences().getBoolean("SP_ARITHMETIC_GUIDE_SHOW", true))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      getActivity().getAppInterface().getPreferences().edit().putBoolean("SP_ARITHMETIC_GUIDE_SHOW", false).apply();
    }
    for (;;)
    {
      paramViewGroup.setOnClickListener(this);
      paramLayoutInflater.setFocusable(true);
      paramLayoutInflater.setFocusableInTouchMode(true);
      paramLayoutInflater.requestFocus();
      paramLayoutInflater.setOnKeyListener(new ahhx(this, null));
      return paramLayoutInflater;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.setFunctionFlag(2);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.a();
  }
  
  protected void z_()
  {
    super.z_();
    this.c.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.fragment.ArithmeticCameraCaptureFragment
 * JD-Core Version:    0.7.0.1
 */