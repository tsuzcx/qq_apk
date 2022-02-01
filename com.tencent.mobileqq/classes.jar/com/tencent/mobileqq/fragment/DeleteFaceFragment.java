package com.tencent.mobileqq.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Arrays;
import java.util.List;

public class DeleteFaceFragment
  extends QPublicBaseFragment
  implements View.OnClickListener
{
  private static final List<Integer> a = Arrays.asList(new Integer[] { Integer.valueOf(206), Integer.valueOf(205), Integer.valueOf(203) });
  private Dialog b;
  private QBaseActivity c;
  
  private boolean a()
  {
    QBaseActivity localQBaseActivity = this.c;
    return (localQBaseActivity == null) || (localQBaseActivity.isFinishing());
  }
  
  public Drawable a(int paramInt)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(Utils.a(6.0F, getResources()));
    localGradientDrawable.setColor(paramInt);
    return localGradientDrawable;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (a())
    {
      QLog.e("DeleteFaceFragment", 1, "onActivityResult activity is null");
      return;
    }
    if (paramInt1 == 1001)
    {
      if (paramInt2 == -1)
      {
        Intent localIntent = paramIntent;
        if (paramIntent == null) {
          localIntent = new Intent();
        }
        localIntent.putExtra("key_face_scan_result", true);
        this.c.setResult(paramInt2, localIntent);
        this.c.finish();
      }
    }
    else if ((paramInt2 == -1) && (paramIntent != null))
    {
      if (paramIntent.getBooleanExtra("key_face_scan_result", false))
      {
        this.c.setResult(paramInt2, paramIntent);
        this.c.finish();
        return;
      }
      if (paramIntent.getBundleExtra("data") != null)
      {
        paramIntent = paramIntent.getBundleExtra("data");
        paramInt1 = paramIntent.getInt("ret", -1);
        if (a.contains(Integer.valueOf(paramInt1)))
        {
          paramIntent = paramIntent.getString("errMsg");
          QQToast.makeText(this.c, paramIntent, 0).show();
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if (i == 2131436180)
    {
      localQBaseActivity.finish();
    }
    else
    {
      ReportController.b(null, "dc00898", "", "", "0X800A855", "0X800A855", 0, 0, "", "", "", "");
      TextView localTextView1 = (TextView)this.b.findViewById(2131431880);
      TextView localTextView2 = (TextView)this.b.findViewById(2131431876);
      TextView localTextView3 = (TextView)this.b.findViewById(2131431864);
      TextView localTextView4 = (TextView)this.b.findViewById(2131431870);
      localTextView1.setText(getString(2131889133));
      localTextView2.setText(getString(2131889134));
      localTextView3.setText(getString(2131889132));
      localTextView4.setText(getString(2131889020));
      localTextView3.setOnClickListener(new DeleteFaceFragment.1(this));
      localTextView4.setOnClickListener(new DeleteFaceFragment.2(this, localQBaseActivity));
      this.b.show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.c = getQBaseActivity();
    paramLayoutInflater = paramLayoutInflater.inflate(2131627383, paramViewGroup, false);
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(2131448372);
    paramViewGroup.setOnClickListener(this);
    paramViewGroup.setBackgroundDrawable(a(getResources().getColor(2131167753)));
    ((TextView)paramLayoutInflater.findViewById(2131436227)).setText(getString(2131888986));
    ((TextView)paramLayoutInflater.findViewById(2131436180)).setOnClickListener(this);
    paramViewGroup = paramLayoutInflater.findViewById(2131445043);
    paramBundle = (LinearLayout.LayoutParams)paramViewGroup.getLayoutParams();
    paramBundle.topMargin = ImmersiveUtils.getStatusBarHeight(getActivity());
    paramViewGroup.setLayoutParams(paramBundle);
    this.b = new ReportDialog(getActivity(), 2131953338);
    this.b.setContentView(2131624587);
    ReportController.b(null, "dc00898", "", "", "0X800A86F", "0X800A86F", 0, 0, "", "", "", "");
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.DeleteFaceFragment
 * JD-Core Version:    0.7.0.1
 */