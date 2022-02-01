package com.tencent.mobileqq.emosm.api.impl;

import android.util.SparseArray;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x5RspBQRecommend;

class EmoticonManagerServiceImpl$26$1
  implements Runnable
{
  EmoticonManagerServiceImpl$26$1(EmoticonManagerServiceImpl.26 param26, EmosmPb.SubCmd0x5RspBQRecommend paramSubCmd0x5RspBQRecommend) {}
  
  public void run()
  {
    this.b.this$0.recommendRspMap.put(this.b.a, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.26.1
 * JD-Core Version:    0.7.0.1
 */