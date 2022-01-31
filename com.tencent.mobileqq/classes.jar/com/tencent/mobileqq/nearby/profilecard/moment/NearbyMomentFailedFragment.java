package com.tencent.mobileqq.nearby.profilecard.moment;

import aewz;
import aexa;
import aexb;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.profilecard.moment.data.PublishableMomentInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.ShortVideoMomentFeedInfo;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.ListView;

public class NearbyMomentFailedFragment
  extends IphoneTitleBarFragment
  implements AdapterView.OnItemClickListener
{
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private NearbyMomentFailedAdapter jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFailedAdapter;
  private NearbyMomentManager.MomentDataChangeObserver jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentManager$MomentDataChangeObserver = new aexb(this);
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  
  private void b()
  {
    ((NearbyMomentManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(262)).a(new aexa(this));
  }
  
  protected int a()
  {
    return 2130969123;
  }
  
  public void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    a(getResources().getString(2131437403));
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)this.e.findViewById(2131365251));
    this.jdField_a_of_type_ComTencentWidgetListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFailedAdapter = new NearbyMomentFailedAdapter(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFailedAdapter);
    b();
    ((NearbyMomentManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(262)).a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentManager$MomentDataChangeObserver);
    new NowVideoReporter().h("video_public").i("exp_repubic").d("5").b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (aewz)paramView.getTag();
    if (paramAdapterView != null)
    {
      if ((paramAdapterView.a instanceof ShortVideoMomentFeedInfo)) {
        NearbyMomentUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramAdapterView.a.a, 2);
      }
    }
    else {
      return;
    }
    NearbyMomentUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramAdapterView.a.a, 4);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = ((FragmentActivity)paramActivity);
  }
  
  public void onDestroyView()
  {
    ((NearbyMomentManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(262)).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentManager$MomentDataChangeObserver);
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFailedFragment
 * JD-Core Version:    0.7.0.1
 */