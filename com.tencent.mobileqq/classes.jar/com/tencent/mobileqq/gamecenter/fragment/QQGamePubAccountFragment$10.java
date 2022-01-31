package com.tencent.mobileqq.gamecenter.fragment;

import ajae;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.widget.RelativeLayout;
import aqst;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.view.QQGameIndicator;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import java.util.ArrayList;
import yod;

class QQGamePubAccountFragment$10
  implements Runnable
{
  QQGamePubAccountFragment$10(QQGamePubAccountFragment paramQQGamePubAccountFragment, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    synchronized (QQGamePubAccountFragment.jdField_a_of_type_ArrayOfByte)
    {
      QQGamePubAccountFragment.a(this.this$0).add(0, this.a);
      if (this.this$0.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter != null) {
        this.this$0.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.notifyDataSetChanged();
      }
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator != null)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.a();
        int i = this.this$0.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.getCurrentItem();
        this.this$0.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGamePubViewpager.setCurrentItem(i + 1);
        this.this$0.jdField_a_of_type_ComTencentMobileqqGamecenterViewQQGameIndicator.setCurrentIndex(i + 1);
      }
      this.this$0.e();
      QQGamePubAccountFragment.a(this.this$0).setVisibility(0);
      QQGamePubAccountFragment.a(this.this$0).sendEmptyMessageDelayed(0, 3000L);
      QQGamePubAccountFragment.a(this.this$0).setTag(aqst.a(this.a));
      yod.a(ajae.a(), "769", "205030", "", "76901", "1", "160", new String[] { aqst.a(this.a), "", "8" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment.10
 * JD-Core Version:    0.7.0.1
 */