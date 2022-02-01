package com.tencent.mobileqq.emosm.api.impl;

import android.util.SparseArray;
import com.tencent.mobileqq.emoticon.EmoticonManagerConstants;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x5RspBQRecommend;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class EmoticonManagerServiceImpl$25
  implements Runnable
{
  EmoticonManagerServiceImpl$25(EmoticonManagerServiceImpl paramEmoticonManagerServiceImpl, EmosmPb.SubCmd0x5RspBQRecommend paramSubCmd0x5RspBQRecommend, int paramInt) {}
  
  public void run()
  {
    if (this.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "recommendresp is null");
      }
      return;
    }
    this.this$0.recommendRspMap.put(this.b, this.a);
    int i = this.a.int32_exposure_num.get();
    if (i > 0) {
      EmoticonManagerConstants.RECOMMEND_EXPOSE_MAX = i;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveAndUpdateRecommendEmosInfo maxexposenum = ");
      ((StringBuilder)localObject).append(EmoticonManagerConstants.RECOMMEND_EXPOSE_MAX);
      QLog.d("EmoticonManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a.st_new_tab_info.get();
    if ((localObject != null) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveAndUpdateRecommendEmosInfo recommend emotion num = ");
      localStringBuilder.append(((List)localObject).size());
      QLog.d("EmoticonManager", 2, localStringBuilder.toString());
    }
    EmoticonManagerServiceImpl.access$500(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.25
 * JD-Core Version:    0.7.0.1
 */