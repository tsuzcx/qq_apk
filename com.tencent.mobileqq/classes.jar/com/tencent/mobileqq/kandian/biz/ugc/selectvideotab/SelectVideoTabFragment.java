package com.tencent.mobileqq.kandian.biz.ugc.selectvideotab;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.biz.ugc.selectvideo.SelectVideoFragment;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.repo.db.struct.ColumnInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import com.tencent.mobileqq.widget.ViewPagerCompat;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.ArrayList;

public class SelectVideoTabFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  public static String a;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131717942, 2131717953 };
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private QBaseFragment jdField_a_of_type_ComTencentMobileqqAppQBaseFragment;
  private ViolaFragment jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment;
  private ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new SelectVideoTabFragment.1(this);
  private TabLayoutCompat jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat;
  private ViewPagerCompat jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private ArrayList<QBaseFragment> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private String b = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "KEY_BUNDLE";
  }
  
  private void a()
  {
    if ((VersionUtils.k()) && (!SystemUtil.b()) && (!SystemUtil.d()))
    {
      getBaseActivity().getWindow().getDecorView().setSystemUiVisibility(9216);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-1);
    }
  }
  
  private void b()
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      ColumnInfo localColumnInfo = (ColumnInfo)localBundle.getParcelable("key_column_info");
      int i;
      if (localColumnInfo != null) {
        i = localColumnInfo.columnID;
      } else {
        i = 0;
      }
      this.jdField_a_of_type_Int = i;
      this.b = localBundle.getString("arg_callback");
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseFragment = SelectVideoFragment.a(false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(RIJUgcUtils.b());
    localStringBuilder.append(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment = ViolaFragment.newInstance(localStringBuilder.toString(), null, true);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqAppQBaseFragment);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.a(new SelectVideoTabFragment.2(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.setTabMode(1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.setTabGravity(1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.setSelectedTabIndicatorHeight(DisplayUtil.a(getBaseActivity(), 2.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.setSelectedTabIndicatorColor(Color.parseColor("#262626"));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.setSelectedTabIndicatorPaddingLeft(DisplayUtil.a(getBaseActivity(), 32.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.setSelectedTabIndicatorPaddingRight(DisplayUtil.a(getBaseActivity(), 32.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.setSelectedTabIndicatorPaddingBottom(DisplayUtil.a(getBaseActivity(), 0.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.setTabTextColors(Color.parseColor("#737373"), Color.parseColor("#262626"));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.setTabTextSize(DisplayUtil.c(getBaseActivity(), 16.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.setupWithViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat, false);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 10001) && (paramInt2 == -1)) {
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364715) {
      getBaseActivity().finish();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    RIJDtReportHelper.a.a(getBaseActivity());
    return View.inflate(this.jdField_a_of_type_AndroidAppActivity, 2131560280, null);
  }
  
  public void onDetach()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    super.onDetach();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)paramView.findViewById(2131378881));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364715));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat = ((ViewPagerCompat)paramView.findViewById(2131377165));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat = ((TabLayoutCompat)paramView.findViewById(2131377161));
    b();
    c();
    d();
    this.jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat.setScrollable(false);
    getBaseActivity().getSupportFragmentManager();
    this.jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat.setCurrentItem(0);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectvideotab.SelectVideoTabFragment
 * JD-Core Version:    0.7.0.1
 */