package com.tencent.mobileqq.fragment;

import adoe;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicPageView.OnHotPicItemClickListener;
import com.tencent.mobileqq.troop.utils.TribeUtils;
import com.tencent.mobileqq.troop.widget.QzoneHotPicPanel;
import com.tencent.mobileqq.util.DisplayUtil;

public class QzoneGifHotPicFragment
  extends PublicBaseFragment
  implements HotPicPageView.OnHotPicItemClickListener
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new adoe(this);
  private View jdField_a_of_type_AndroidViewView;
  protected FrameLayout a;
  public BaseActivity a;
  protected QzoneHotPicPanel a;
  private String jdField_a_of_type_JavaLangString;
  
  private void e()
  {
    try
    {
      this.jdField_a_of_type_JavaLangString = getActivity().getIntent().getStringExtra("DetailFeedDataKeys");
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QzoneGifHotPicFragment", 0, localException.toString());
    }
  }
  
  public void a(Activity paramActivity)
  {
    super.a(paramActivity);
    if (paramActivity != null)
    {
      paramActivity.getWindow().setFlags(1024, 1024);
      paramActivity.overridePendingTransition(0, 0);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(View paramView, String paramString, HotPicData paramHotPicData)
  {
    paramView = new Intent();
    paramView.putExtra("filePath", paramString);
    paramView.putExtra("qzoneGifHotPicUrl", paramHotPicData.url);
    paramView.putExtra("qzoneGifHotPicWidth", paramHotPicData.width);
    paramView.putExtra("qzoneGifHotPicHeight", paramHotPicData.height);
    if (this.jdField_a_of_type_JavaLangString != null) {
      paramView.putExtra("DetailFeedDataKeys", this.jdField_a_of_type_JavaLangString);
    }
    if (getActivity() != null)
    {
      getActivity().setResult(-1, paramView);
      d();
      getActivity().finish();
    }
    return false;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_AndroidViewView = getActivity().findViewById(2131373730);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)getActivity().findViewById(2131373729));
  }
  
  public boolean b()
  {
    return false;
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetQzoneHotPicPanel == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetQzoneHotPicPanel = ((QzoneHotPicPanel)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130971222, null));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetQzoneHotPicPanel.a(getActivity().app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetQzoneHotPicPanel, -1, DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 250.0F));
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetQzoneHotPicPanel.f();
    TribeUtils.a("pub_page_new", "exp_gif", 0, 0, new String[] { "", "" });
  }
  
  public boolean c()
  {
    return false;
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetQzoneHotPicPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetQzoneHotPicPanel.isShown())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetQzoneHotPicPanel.a(false);
    }
  }
  
  public boolean d()
  {
    return super.d();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    b();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    e();
    c();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130971212, null);
    paramLayoutInflater.setSystemUiVisibility(4);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void u_()
  {
    super.u_();
    if (getActivity() != null) {
      getActivity().overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QzoneGifHotPicFragment
 * JD-Core Version:    0.7.0.1
 */