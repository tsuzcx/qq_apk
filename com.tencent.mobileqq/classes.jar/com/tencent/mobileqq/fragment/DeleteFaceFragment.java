package com.tencent.mobileqq.fragment;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import apnv;
import apnw;
import awqx;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.troop.TroopBaseProxyActivity;

public class DeleteFaceFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  public Dialog a;
  private TextView a;
  private Dialog b;
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131167766);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = TroopBaseProxyActivity.a(getActivity());
      this.jdField_a_of_type_AndroidAppDialog.findViewById(2131305560).getLayoutParams().width = -2;
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131305861);
      localTextView.setSingleLine();
      localTextView.setPadding(15, 0, 15, 0);
      localTextView.setText("正在删除...");
    }
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.cancel();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    paramView = getActivity();
    if (i == 2131302804)
    {
      paramView.finish();
      return;
    }
    awqx.b(null, "dc00898", "", "", "0X800A855", "0X800A855", 0, 0, "", "", "", "");
    paramView = (TextView)this.b.findViewById(2131299583);
    TextView localTextView1 = (TextView)this.b.findViewById(2131299579);
    TextView localTextView2 = (TextView)this.b.findViewById(2131299568);
    TextView localTextView3 = (TextView)this.b.findViewById(2131299574);
    paramView.setText(getString(2131626694));
    localTextView1.setText(getString(2131626695));
    localTextView2.setText(getString(2131626692));
    localTextView3.setText(getString(2131626693));
    localTextView2.setOnClickListener(new apnv(this));
    localTextView3.setOnClickListener(new apnw(this));
    this.b.show();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131495147, paramViewGroup, false);
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(2131312407);
    ((TextView)paramLayoutInflater.findViewById(2131312301)).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131302847));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131626696));
    ((TextView)paramLayoutInflater.findViewById(2131302804)).setOnClickListener(this);
    paramViewGroup = paramLayoutInflater.findViewById(2131309690);
    paramBundle = (LinearLayout.LayoutParams)paramViewGroup.getLayoutParams();
    paramBundle.topMargin = ImmersiveUtils.getStatusBarHeight(getActivity());
    paramViewGroup.setLayoutParams(paramBundle);
    this.b = new Dialog(getActivity(), 2131690181);
    this.b.setContentView(2131493323);
    awqx.b(null, "dc00898", "", "", "0X800A86F", "0X800A86F", 0, 0, "", "", "", "");
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.DeleteFaceFragment
 * JD-Core Version:    0.7.0.1
 */