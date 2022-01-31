package com.tencent.mobileqq.gamecenter.fragment;

import android.text.TextUtils;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.gamecenter.view.QQGameStatusView;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

class QQGamePubAccountFragment$16
  implements Runnable
{
  QQGamePubAccountFragment$16(QQGamePubAccountFragment paramQQGamePubAccountFragment, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      WadlResult localWadlResult = (WadlResult)localIterator.next();
      if ((localWadlResult != null) && (localWadlResult.a != null) && (localWadlResult.a.a.equals(this.this$0.a().gameAppId)) && (localWadlResult.jdField_b_of_type_Int == 6) && (!TextUtils.isEmpty(localWadlResult.jdField_b_of_type_JavaLangString)))
      {
        QQGamePubAccountFragment.a(this.this$0).a(localWadlResult.a.a, 6);
        QQGamePubAccountFragment.a(this.this$0).a(localWadlResult.jdField_b_of_type_JavaLangString);
        this.this$0.a.put(localWadlResult.a.a, localWadlResult.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment.16
 * JD-Core Version:    0.7.0.1
 */