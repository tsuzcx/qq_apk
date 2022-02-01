package com.tencent.mobileqq.fragment;

import afur;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import ault;
import aulu;
import aulw;
import aulx;
import aves;
import bccl;
import bcst;
import com.tencent.mobileqq.activity.QQIdentiferActivity;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.troop.TroopBaseProxyActivity;
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
  
  private void a(String paramString)
  {
    if (a())
    {
      QLog.d("DeleteFaceFragment", 1, "getSkeyError, activity is empty");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("DeleteFaceFragment", 1, "errorMSg is empty");
      return;
    }
    QQToast.a(getActivity(), paramString, 0).a();
    b();
  }
  
  private void a(String paramString1, String paramString2)
  {
    bccl.a(101868556, paramString1, "skey", paramString2, "clean", new aulw(this, paramString1));
  }
  
  private void a(String paramString1, String paramString2, FaceDetectForThirdPartyManager.AppConf paramAppConf)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQIdentiferActivity.class);
    localIntent.putExtra("platformAppId", 101868556);
    localIntent.putExtra("srcAppId", 101868556);
    localIntent.putExtra("srcOpenId", paramString2);
    localIntent.putExtra("key", paramString1);
    localIntent.putExtra("method", "deleteFace");
    localIntent.putExtra("serviceType", 2);
    localIntent.putExtra("FaceRecognition.AppConf", paramAppConf);
    localIntent.putExtra("key_identification_type", paramAppConf.mode);
    startActivityForResult(localIntent, 22);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    aves.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString1, "deleteFace", paramString2, 0L, 101868556, new aulx(this, paramString1, paramString3));
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing());
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131298998);
  }
  
  public Drawable a(int paramInt)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(afur.a(6.0F, getResources()));
    localGradientDrawable.setColor(paramInt);
    return localGradientDrawable;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = TroopBaseProxyActivity.a(getActivity());
      this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372161).getLayoutParams().width = -2;
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372466);
      localTextView.setSingleLine();
      localTextView.setPadding(15, 0, 15, 0);
      localTextView.setText(getString(2131705542));
    }
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void b()
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
          return;
          b();
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
    if (i == 2131368947) {
      localFragmentActivity.finish();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bcst.b(null, "dc00898", "", "", "0X800A855", "0X800A855", 0, 0, "", "", "", "");
      TextView localTextView1 = (TextView)this.b.findViewById(2131365479);
      TextView localTextView2 = (TextView)this.b.findViewById(2131365475);
      TextView localTextView3 = (TextView)this.b.findViewById(2131365464);
      TextView localTextView4 = (TextView)this.b.findViewById(2131365470);
      localTextView1.setText(getString(2131691951));
      localTextView2.setText(getString(2131691952));
      localTextView3.setText(getString(2131691950));
      localTextView4.setText(getString(2131691824));
      localTextView3.setOnClickListener(new ault(this));
      localTextView4.setOnClickListener(new aulu(this, localFragmentActivity));
      this.b.show();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    paramLayoutInflater = paramLayoutInflater.inflate(2131561120, paramViewGroup, false);
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(2131379601);
    paramViewGroup.setOnClickListener(this);
    paramViewGroup.setBackgroundDrawable(a(getResources().getColor(2131166777)));
    ((TextView)paramLayoutInflater.findViewById(2131368994)).setText(getString(2131691832));
    ((TextView)paramLayoutInflater.findViewById(2131368947)).setOnClickListener(this);
    paramViewGroup = paramLayoutInflater.findViewById(2131376734);
    paramBundle = (LinearLayout.LayoutParams)paramViewGroup.getLayoutParams();
    paramBundle.topMargin = ImmersiveUtils.getStatusBarHeight(getActivity());
    paramViewGroup.setLayoutParams(paramBundle);
    this.b = new ReportDialog(getActivity(), 2131755823);
    this.b.setContentView(2131558985);
    bcst.b(null, "dc00898", "", "", "0X800A86F", "0X800A86F", 0, 0, "", "", "", "");
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.DeleteFaceFragment
 * JD-Core Version:    0.7.0.1
 */