package com.tencent.mobileqq.qqlive.anchor.prepare;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperPrepare;
import com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperSet;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareScreenRecord;
import com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareThirdPush;
import com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareWrapper;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;

public class QQLiveAnchorPrepareWrapper
  implements IQQLiveAnchorPrepareWrapper
{
  private IQQLiveSDK a;
  private QQLiveAnchorRoomInfo b = new QQLiveAnchorRoomInfo();
  private QQLiveAnchorHelperPrepare c = new QQLiveAnchorHelperPrepare();
  private QQLiveAnchorHelperSet d = new QQLiveAnchorHelperSet();
  private QQLiveAnchorPrepareThirdPush e = new QQLiveAnchorPrepareThirdPush();
  private QQLiveAnchorPrepareScreenRecord f = new QQLiveAnchorPrepareScreenRecord();
  
  public void destroy()
  {
    this.f.destroy();
    this.e.destroy();
  }
  
  public QQLiveAnchorRoomInfo getRoomInfo()
  {
    return this.b;
  }
  
  public IQQLiveAnchorPrepareScreenRecord getScreenRecordModule()
  {
    return this.f;
  }
  
  public IQQLiveAnchorPrepareThirdPush getThirdPushModule(ViewGroup paramViewGroup)
  {
    this.e.setPreViewContainer(paramViewGroup);
    return this.e;
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK, long paramLong, String paramString)
  {
    this.a = paramIQQLiveSDK;
    this.e.init(paramIQQLiveSDK);
    this.f.init(paramIQQLiveSDK);
    paramIQQLiveSDK = this.b;
    paramIQQLiveSDK.uid = paramLong;
    paramIQQLiveSDK.source = paramString;
  }
  
  public void prepare(Activity paramActivity, IQQLiveAnchorRoomThirdPushCallback paramIQQLiveAnchorRoomThirdPushCallback)
  {
    this.c.a(paramActivity, this.a, new QQLiveAnchorPrepareWrapper.1(this, paramIQQLiveAnchorRoomThirdPushCallback));
  }
  
  public void set(QQLiveAnchorDataRoomAttr paramQQLiveAnchorDataRoomAttr, IQQLiveAnchorRoomThirdPushCallback paramIQQLiveAnchorRoomThirdPushCallback)
  {
    this.d.a(this.a, this.b, paramQQLiveAnchorDataRoomAttr, paramIQQLiveAnchorRoomThirdPushCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.prepare.QQLiveAnchorPrepareWrapper
 * JD-Core Version:    0.7.0.1
 */