package com.tencent.mobileqq.fragment;

import actj;
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
import aqhl;
import aqhm;
import axqy;
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
    return getResources().getDimensionPixelSize(2131298865);
  }
  
  public Drawable a(int paramInt)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(actj.a(6.0F, getResources()));
    localGradientDrawable.setColor(paramInt);
    return localGradientDrawable;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = TroopBaseProxyActivity.a(getActivity());
      this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371256).getLayoutParams().width = -2;
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371557);
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
    if (i == 2131368429)
    {
      paramView.finish();
      return;
    }
    axqy.b(null, "dc00898", "", "", "0X800A855", "0X800A855", 0, 0, "", "", "", "");
    paramView = (TextView)this.b.findViewById(2131365150);
    TextView localTextView1 = (TextView)this.b.findViewById(2131365146);
    TextView localTextView2 = (TextView)this.b.findViewById(2131365135);
    TextView localTextView3 = (TextView)this.b.findViewById(2131365141);
    paramView.setText(getString(2131692281));
    localTextView1.setText(getString(2131692282));
    localTextView2.setText(getString(2131692279));
    localTextView3.setText(getString(2131692280));
    localTextView2.setOnClickListener(new aqhl(this));
    localTextView3.setOnClickListener(new aqhm(this));
    this.b.show();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560721, paramViewGroup, false);
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(2131378236);
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(2131378124);
    paramViewGroup.setOnClickListener(this);
    paramViewGroup.setBackgroundDrawable(a(getResources().getColor(2131166648)));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131368472));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131692142));
    ((TextView)paramLayoutInflater.findViewById(2131368429)).setOnClickListener(this);
    paramViewGroup = paramLayoutInflater.findViewById(2131375447);
    paramBundle = (LinearLayout.LayoutParams)paramViewGroup.getLayoutParams();
    paramBundle.topMargin = ImmersiveUtils.getStatusBarHeight(getActivity());
    paramViewGroup.setLayoutParams(paramBundle);
    this.b = new Dialog(getActivity(), 2131755791);
    this.b.setContentView(2131558883);
    axqy.b(null, "dc00898", "", "", "0X800A86F", "0X800A86F", 0, 0, "", "", "", "");
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