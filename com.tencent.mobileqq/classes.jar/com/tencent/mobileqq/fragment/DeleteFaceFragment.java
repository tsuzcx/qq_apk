package com.tencent.mobileqq.fragment;

import aepi;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import asfj;
import asfk;
import azqs;
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
    return getResources().getDimensionPixelSize(2131298914);
  }
  
  public Drawable a(int paramInt)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(aepi.a(6.0F, getResources()));
    localGradientDrawable.setColor(paramInt);
    return localGradientDrawable;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = TroopBaseProxyActivity.a(getActivity());
      this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371587).getLayoutParams().width = -2;
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371894);
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
    if (i == 2131368624)
    {
      paramView.finish();
      return;
    }
    azqs.b(null, "dc00898", "", "", "0X800A855", "0X800A855", 0, 0, "", "", "", "");
    paramView = (TextView)this.b.findViewById(2131365237);
    TextView localTextView1 = (TextView)this.b.findViewById(2131365233);
    TextView localTextView2 = (TextView)this.b.findViewById(2131365222);
    TextView localTextView3 = (TextView)this.b.findViewById(2131365228);
    paramView.setText(getString(2131692358));
    localTextView1.setText(getString(2131692359));
    localTextView2.setText(getString(2131692356));
    localTextView3.setText(getString(2131692357));
    localTextView2.setOnClickListener(new asfj(this));
    localTextView3.setOnClickListener(new asfk(this));
    this.b.show();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560915, paramViewGroup, false);
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(2131378859);
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(2131378736);
    paramViewGroup.setOnClickListener(this);
    paramViewGroup.setBackgroundDrawable(a(getResources().getColor(2131166697)));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131368670));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131692214));
    ((TextView)paramLayoutInflater.findViewById(2131368624)).setOnClickListener(this);
    paramViewGroup = paramLayoutInflater.findViewById(2131375987);
    paramBundle = (LinearLayout.LayoutParams)paramViewGroup.getLayoutParams();
    paramBundle.topMargin = ImmersiveUtils.getStatusBarHeight(getActivity());
    paramViewGroup.setLayoutParams(paramBundle);
    this.b = new Dialog(getActivity(), 2131755801);
    this.b.setContentView(2131558919);
    azqs.b(null, "dc00898", "", "", "0X800A86F", "0X800A86F", 0, 0, "", "", "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.DeleteFaceFragment
 * JD-Core Version:    0.7.0.1
 */