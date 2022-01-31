package com.tencent.mobileqq.extendfriend.fragment;

import android.support.v4.app.FragmentActivity;
import aoiu;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class ExtendFriendBaseFragment$2
  implements Runnable
{
  ExtendFriendBaseFragment$2(ExtendFriendBaseFragment paramExtendFriendBaseFragment) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_Aoiu == null) || (this.this$0.jdField_a_of_type_Aoiu.a() <= 0) || (this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.this$0.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {}
    for (;;)
    {
      return;
      if (ExtendFriendBaseFragment.a(this.this$0) == null) {
        ExtendFriendBaseFragment.a(this.this$0, new ConcurrentHashMap());
      }
      Object localObject1 = ExtendFriendBaseFragment.a(this.this$0);
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBaseFragment", 2, "mStartExposureReportRunnable currentUins:" + localObject1);
      }
      Object localObject2 = ExtendFriendBaseFragment.a(this.this$0).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        if ((((Long)localEntry.getValue()).longValue() > 0L) && (!((ArrayList)localObject1).contains(localEntry.getKey()))) {
          localEntry.setValue(Long.valueOf(-1L));
        }
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if ((!ExtendFriendBaseFragment.a(this.this$0).containsKey(localObject2)) || (((Long)ExtendFriendBaseFragment.a(this.this$0).get(localObject2)).longValue() < 0L)) {
          ExtendFriendBaseFragment.a(this.this$0).put(localObject2, Long.valueOf(System.currentTimeMillis()));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment.2
 * JD-Core Version:    0.7.0.1
 */