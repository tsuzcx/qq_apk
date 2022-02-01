package com.tencent.mobileqq.kandian.biz.ugc.coverselect;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import com.tencent.mobileqq.widget.ViewPagerCompat;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.ArrayList;
import java.util.List;

public class CoverSelectTabFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { ReadInJoyUtils.a(2131717831), ReadInJoyUtils.a(2131717830) };
  private int jdField_a_of_type_Int;
  protected Activity a;
  private View jdField_a_of_type_AndroidViewView;
  private GalleryFragment jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectGalleryFragment;
  private VideoCaptureFragment jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectVideoCaptureFragment;
  private TabLayoutCompat jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat;
  private ViewPagerCompat jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private List<BaseFragment> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private View b;
  
  private void a()
  {
    Object localObject = getArguments();
    if (localObject == null) {
      return;
    }
    String str = ((Bundle)localObject).getString("ARG_VIDEO_URL");
    float f = ((Bundle)localObject).getFloat("ARG_INITIAL_PROGRESS");
    this.jdField_a_of_type_Int = ((Bundle)localObject).getInt("ARG_SELECTED_ITEM");
    int i = ((Bundle)localObject).getInt("ARG_VIDEO_WIDTH");
    int j = ((Bundle)localObject).getInt("ARG_VIDEO_HEIGHT");
    localObject = ((Bundle)localObject).getString("ARG_PLACEHOLDER_URL");
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectVideoCaptureFragment = VideoCaptureFragment.a(str, f);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectGalleryFragment = GalleryFragment.a(i, j, (String)localObject);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectVideoCaptureFragment);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectGalleryFragment);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectVideoCaptureFragment.a(new CoverSelectTabFragment.2(this));
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, float paramFloat, String paramString, UgcVideo paramUgcVideo)
  {
    a(paramActivity, paramInt1, paramInt2, paramFloat, paramString, paramUgcVideo.filePath, paramUgcVideo.width, paramUgcVideo.height);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, float paramFloat, String paramString1, String paramString2, int paramInt3, int paramInt4)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("ARG_SELECTED_ITEM", paramInt2);
    localIntent.putExtra("ARG_VIDEO_URL", paramString2);
    localIntent.putExtra("ARG_INITIAL_PROGRESS", paramFloat);
    localIntent.putExtra("ARG_VIDEO_WIDTH", paramInt3);
    localIntent.putExtra("ARG_VIDEO_HEIGHT", paramInt4);
    localIntent.putExtra("ARG_PLACEHOLDER_URL", paramString1);
    PublicFragmentActivity.a(paramActivity, localIntent, CoverSelectTabFragment.class, paramInt1);
  }
  
  private void a(OutputPicListener paramOutputPicListener)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat.getCurrentItem() == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectVideoCaptureFragment.a(paramOutputPicListener);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectGalleryFragment.a(paramOutputPicListener);
  }
  
  private void a(String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("ARG_SELECTED_COVER", paramString);
    localIntent.putExtra("ARG_SELECTED_ITEM", paramInt);
    if (paramInt == 0) {
      localIntent.putExtra("ARG_INITIAL_PROGRESS", this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectVideoCaptureFragment.a());
    } else if (paramInt == 1) {
      localIntent.putExtra("ARG_PLACEHOLDER_URL", paramString);
    }
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.a(new CoverSelectTabFragment.3(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.setTabMode(1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.setTabGravity(1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.setSelectedTabIndicatorHeight(DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 3.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.setSelectedTabIndicatorColor(-1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.setSelectedTabIndicatorPaddingLeft(DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 32.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.setSelectedTabIndicatorPaddingRight(DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 32.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.setSelectedTabIndicatorPaddingBottom(DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 6.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.setTabTextColors(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165539), -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.setTabTextSize(DisplayUtil.c(this.jdField_a_of_type_AndroidAppActivity, 16.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat.setupWithViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat, false);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == this.jdField_a_of_type_AndroidViewView.getId())
    {
      a(new CoverSelectTabFragment.4(this));
      return;
    }
    if (i == this.b.getId()) {
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return View.inflate(getBaseActivity(), 2131559977, null);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)paramView.findViewById(2131378881));
    this.jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat = ((ViewPagerCompat)paramView.findViewById(2131365302));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat = ((TabLayoutCompat)paramView.findViewById(2131365300));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365301);
    this.b = paramView.findViewById(2131365299);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.resetBkColor(0);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    a();
    b();
    this.jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat.setScrollable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat.setAdapter(new CoverSelectTabFragment.1(this, getBaseActivity().getSupportFragmentManager()));
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat.setCurrentItem(1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat.setCurrentItem(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.CoverSelectTabFragment
 * JD-Core Version:    0.7.0.1
 */