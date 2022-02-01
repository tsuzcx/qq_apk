package com.tencent.mobileqq.kandian.biz.biu;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class ReadInJoyDeliverBiuActivity$11
  implements Runnable
{
  ReadInJoyDeliverBiuActivity$11(ReadInJoyDeliverBiuActivity paramReadInJoyDeliverBiuActivity, ArrayList paramArrayList) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.app.getCurrentAccountUin();
    Object localObject2 = BaseApplicationImpl.getContext();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("sp_public_account_with_cuin_");
    ((StringBuilder)localObject3).append((String)localObject1);
    localObject1 = ((BaseApplication)localObject2).getSharedPreferences(((StringBuilder)localObject3).toString(), 4);
    if (localObject1 != null)
    {
      localObject2 = new HashSet();
      localObject3 = this.a.iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Set)localObject2).add(String.valueOf((Long)((Iterator)localObject3).next()));
      }
      ((SharedPreferences)localObject1).edit().putStringSet("readinjoy_deliver_biu_guide_uin", (Set)localObject2);
      ((SharedPreferences)localObject1).edit().commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity.11
 * JD-Core Version:    0.7.0.1
 */