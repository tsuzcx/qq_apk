package com.tencent.mobileqq.gamecenter.fragment;

import aahi;
import akwd;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.widget.RelativeLayout;
import asnl;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.view.QQGameIndicator;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import java.util.ArrayList;

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
      QQGamePubAccountFragment.a(this.this$0).setTag(asnl.a(this.a));
      aahi.a(akwd.a(), "769", "205030", "", "76901", "1", "160", new String[] { asnl.a(this.a), "", "8" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment.10
 * JD-Core Version:    0.7.0.1
 */