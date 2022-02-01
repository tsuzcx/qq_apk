package com.tencent.mobileqq.kandian.biz.skin;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.skin.entity.SkinData;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.GuideInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.ReqBody;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo;

public class ReadInJoySkinHandler
  extends BusinessHandler
{
  private QQAppInterface a;
  
  public ReadInJoySkinHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  public void a(SkinData paramSkinData, GuideData paramGuideData1, RefreshData paramRefreshData, GuideData paramGuideData2, int paramInt)
  {
    paramGuideData1 = new oidb_0x5bd.ReqBody();
    paramGuideData1.uint64_uin.set(this.a.getLongAccountUin(), true);
    paramGuideData1.uint32_source.set(paramInt);
    if (paramSkinData != null) {
      paramGuideData1.msg_current_skin_info.set(paramSkinData.toBody(), true);
    }
    if (paramRefreshData != null) {
      paramGuideData1.msg_current_refresh_info.set(paramRefreshData.toRefreshInfoBody(), true);
    }
    if (paramGuideData2 != null) {
      paramGuideData1.msg_current_guide_info.set(paramGuideData2.toBody(), true);
    }
    ProtoUtils.a(this.a, new ReadInJoySkinHandler.1(this), paramGuideData1.toByteArray(), "OidbSvc.0x5bd_1", 1469, 1, new Bundle(), 6000L);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return ReadInJoySkinHandler.ReadInJoySkinObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinHandler
 * JD-Core Version:    0.7.0.1
 */