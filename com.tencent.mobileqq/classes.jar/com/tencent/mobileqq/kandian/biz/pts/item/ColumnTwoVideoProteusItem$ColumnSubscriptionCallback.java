package com.tencent.mobileqq.kandian.biz.pts.item;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.MultiVideoColumnInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xd4b.oidb_0xd4b.RspBody;
import tencent.im.oidb.cmd0xd4b.oidb_0xd4b.SubscribeVideoColumnRsp;

class ColumnTwoVideoProteusItem$ColumnSubscriptionCallback
  extends ProtoUtils.TroopProtocolObserver
{
  private AbsBaseArticleInfo a;
  private int b;
  
  ColumnTwoVideoProteusItem$ColumnSubscriptionCallback(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    this.a = paramAbsBaseArticleInfo;
    this.b = paramInt;
  }
  
  private void a()
  {
    int i = this.a.multiVideoColumnInfo.i;
    int j = this.b;
    boolean bool = true;
    if (j == 1) {
      i += 1;
    } else {
      i -= 1;
    }
    MultiVideoColumnInfo localMultiVideoColumnInfo = this.a.multiVideoColumnInfo;
    if (this.b != 1) {
      bool = false;
    }
    localMultiVideoColumnInfo.j = bool;
    this.a.multiVideoColumnInfo.i = i;
    ThreadManager.getUIHandler().post(new ColumnTwoVideoProteusItem.ColumnSubscriptionCallback.1(this));
  }
  
  private void a(byte[] paramArrayOfByte, Bundle paramBundle)
  {
    oidb_0xd4b.RspBody localRspBody = new oidb_0xd4b.RspBody();
    try
    {
      localRspBody.mergeFrom(paramArrayOfByte);
      int i = ((oidb_0xd4b.SubscribeVideoColumnRsp)((oidb_0xd4b.RspBody)localRspBody.get()).msg_subscribe_video_column_rsp.get()).uint32_guide_type.get();
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("ColumnSubscriptionCallback ");
      paramArrayOfByte.append(i);
      QLog.i("ColumnTwoVideoProteusItem", 1, paramArrayOfByte.toString());
      ThreadManager.getUIHandler().post(new ColumnTwoVideoProteusItem.ColumnSubscriptionCallback.2(this, paramBundle, i));
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.e("ColumnTwoVideoProteusItem", 1, paramArrayOfByte.toString());
    }
  }
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      a();
      a(paramArrayOfByte, paramBundle);
      return;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("ColumnTwoVideoProteusItem subscribe column fail. columnId:");
    paramArrayOfByte.append(this.a.multiVideoColumnInfo.a);
    paramArrayOfByte.append(" subscribeAction:");
    paramArrayOfByte.append(this.b);
    QLog.e("ColumnTwoVideoProteusItem", 1, paramArrayOfByte.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.ColumnTwoVideoProteusItem.ColumnSubscriptionCallback
 * JD-Core Version:    0.7.0.1
 */