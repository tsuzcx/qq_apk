package com.tencent.mobileqq.fragment;

import android.app.Dialog;
import android.content.Intent;
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
import atqx;
import atqy;
import bcef;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Arrays;
import java.util.List;

public class DeleteFaceFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private static final List<Integer> jdField_a_of_type_JavaUtilList = Arrays.asList(new Integer[] { Integer.valueOf(206), Integer.valueOf(205), Integer.valueOf(203) });
  public Dialog a;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private Dialog b;
  
  private boolean a()
  {
    return (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing());
  }
  
  public Drawable a(int paramInt)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(AIOUtils.dp2px(6.0F, getResources()));
    localGradientDrawable.setColor(paramInt);
    return localGradientDrawable;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (a()) {
      QLog.e("DeleteFaceFragment", 1, "onActivityResult activity is null");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            a();
            if (paramInt1 != 1001) {
              break;
            }
          } while (paramInt2 != -1);
          Intent localIntent = paramIntent;
          if (paramIntent == null) {
            localIntent = new Intent();
          }
          localIntent.putExtra("key_face_scan_result", true);
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(paramInt2, localIntent);
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
          return;
        } while ((paramInt2 != -1) || (paramIntent == null));
        if (paramIntent.getBooleanExtra("key_face_scan_result", false))
        {
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(paramInt2, paramIntent);
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
          return;
        }
      } while (paramIntent.getBundleExtra("data") == null);
      paramIntent = paramIntent.getBundleExtra("data");
      paramInt1 = paramIntent.getInt("ret", -1);
    } while (!jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt1)));
    paramIntent = paramIntent.getString("errMsg");
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramIntent, 0).a();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    FragmentActivity localFragmentActivity = getActivity();
    if (i == 2131369068) {
      localFragmentActivity.finish();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bcef.b(null, "dc00898", "", "", "0X800A855", "0X800A855", 0, 0, "", "", "", "");
      TextView localTextView1 = (TextView)this.b.findViewById(2131365556);
      TextView localTextView2 = (TextView)this.b.findViewById(2131365552);
      TextView localTextView3 = (TextView)this.b.findViewById(2131365541);
      TextView localTextView4 = (TextView)this.b.findViewById(2131365547);
      localTextView1.setText(getString(2131692001));
      localTextView2.setText(getString(2131692002));
      localTextView3.setText(getString(2131692000));
      localTextView4.setText(getString(2131691916));
      localTextView3.setOnClickListener(new atqx(this));
      localTextView4.setOnClickListener(new atqy(this, localFragmentActivity));
      this.b.show();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    paramLayoutInflater = paramLayoutInflater.inflate(2131561030, paramViewGroup, false);
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(2131379557);
    paramViewGroup.setOnClickListener(this);
    paramViewGroup.setBackgroundDrawable(a(getResources().getColor(2131166800)));
    ((TextView)paramLayoutInflater.findViewById(2131369115)).setText(getString(2131691882));
    ((TextView)paramLayoutInflater.findViewById(2131369068)).setOnClickListener(this);
    paramViewGroup = paramLayoutInflater.findViewById(2131376628);
    paramBundle = (LinearLayout.LayoutParams)paramViewGroup.getLayoutParams();
    paramBundle.topMargin = ImmersiveUtils.getStatusBarHeight(getActivity());
    paramViewGroup.setLayoutParams(paramBundle);
    this.b = new ReportDialog(getActivity(), 2131755826);
    this.b.setContentView(2131558992);
    bcef.b(null, "dc00898", "", "", "0X800A86F", "0X800A86F", 0, 0, "", "", "", "");
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.DeleteFaceFragment
 * JD-Core Version:    0.7.0.1
 */