package com.tencent.mobileqq.extendfriend.fragment;

import android.support.v4.app.FragmentActivity;
import asxh;
import asxr;
import aszx;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class ExtendFriendBaseFragment$3
  implements Runnable
{
  ExtendFriendBaseFragment$3(ExtendFriendBaseFragment paramExtendFriendBaseFragment) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_Aszx == null) || (this.this$0.jdField_a_of_type_Aszx.a() <= 0) || (this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.this$0.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
      return;
    }
    Object localObject1 = ExtendFriendBaseFragment.a(this.this$0);
    Object localObject2 = new ArrayList();
    Object localObject3 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((ArrayList)localObject2).add(((asxr)((Iterator)localObject3).next()).jdField_a_of_type_Asxh.mUin);
    }
    localObject3 = ExtendFriendBaseFragment.a(this.this$0).keySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      String str = (String)((Iterator)localObject3).next();
      if (!((ArrayList)localObject2).contains(str)) {
        ExtendFriendBaseFragment.a(this.this$0).remove(str);
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (asxr)((Iterator)localObject1).next();
      localObject3 = ((asxr)localObject2).jdField_a_of_type_Asxh.mUin;
      if (!ExtendFriendBaseFragment.a(this.this$0).containsKey(localObject3))
      {
        ((asxr)localObject2).jdField_a_of_type_Long = System.currentTimeMillis();
        ExtendFriendBaseFragment.a(this.this$0).put(localObject3, localObject2);
      }
    }
    QLog.d("ExtendFriendBaseFragment", 2, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment.3
 * JD-Core Version:    0.7.0.1
 */