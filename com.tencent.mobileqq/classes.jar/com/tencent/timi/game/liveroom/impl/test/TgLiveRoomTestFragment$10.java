package com.tencent.timi.game.liveroom.impl.test;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataBase;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataEnter;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataInit;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataThirdPushCheck;
import com.tencent.timi.game.component.qqlive.api.TgLiveAnchorStartListener;
import com.tencent.timi.game.env.Env;
import com.tencent.timi.game.liveroom.api.IAnchorRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.CommonButton;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.ClipboardUtil;
import com.tencent.timi.game.utils.Logger;

class TgLiveRoomTestFragment$10
  implements TgLiveAnchorStartListener
{
  TgLiveRoomTestFragment$10(TgLiveRoomTestFragment paramTgLiveRoomTestFragment, QQLiveAnchorStreamRecordType paramQQLiveAnchorStreamRecordType) {}
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("anchorStartLive_");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ### onCreateRoomStart");
    Logger.a("TgLiveTag_TgLiveUtilsTgLiveRoomTestFragment_", localStringBuilder.toString());
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("anchorStartLive_");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ### onFinalError, step = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", errorCode= ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", errorDisplayMsg= ");
    localStringBuilder.append(paramString);
    Logger.c("TgLiveTag_TgLiveUtilsTgLiveRoomTestFragment_", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("开播失败! ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("(");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(")");
    CustomToastView.a(localStringBuilder.toString());
  }
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramString);
    CustomToastView.a(localStringBuilder.toString());
  }
  
  public void a(QQLiveAnchorDataPullInfo paramQQLiveAnchorDataPullInfo)
  {
    paramQQLiveAnchorDataPullInfo = new StringBuilder();
    paramQQLiveAnchorDataPullInfo.append("anchorStartLive_");
    paramQQLiveAnchorDataPullInfo.append(this.a);
    paramQQLiveAnchorDataPullInfo.append(" ### onGetPullInfo");
    Logger.a("TgLiveTag_TgLiveUtilsTgLiveRoomTestFragment_", paramQQLiveAnchorDataPullInfo.toString());
  }
  
  public void a(QQLiveAnchorDataThirdPushCheck paramQQLiveAnchorDataThirdPushCheck)
  {
    paramQQLiveAnchorDataThirdPushCheck = new StringBuilder();
    paramQQLiveAnchorDataThirdPushCheck.append("anchorStartLive_");
    paramQQLiveAnchorDataThirdPushCheck.append(this.a);
    paramQQLiveAnchorDataThirdPushCheck.append(" ### onThirdPushChecked");
    Logger.a("TgLiveTag_TgLiveUtilsTgLiveRoomTestFragment_", paramQQLiveAnchorDataThirdPushCheck.toString());
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("anchorStartLive_");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ### onLiveSdkInitResult");
    Logger.a("TgLiveTag_TgLiveUtilsTgLiveRoomTestFragment_", localStringBuilder.toString());
  }
  
  public void a(boolean paramBoolean, QQLiveAnchorDataBase paramQQLiveAnchorDataBase, View paramView)
  {
    paramQQLiveAnchorDataBase = new StringBuilder();
    paramQQLiveAnchorDataBase.append("anchorStartLive_");
    paramQQLiveAnchorDataBase.append(this.a);
    paramQQLiveAnchorDataBase.append(" ### onPublishStreamResult");
    Logger.a("TgLiveTag_TgLiveUtilsTgLiveRoomTestFragment_", paramQQLiveAnchorDataBase.toString());
    if (paramBoolean) {
      ((IAnchorRoomService)ServiceCenter.a(IAnchorRoomService.class)).a(this.b.getContext(), true);
    }
  }
  
  public void a(boolean paramBoolean, QQLiveAnchorDataEnter paramQQLiveAnchorDataEnter)
  {
    paramQQLiveAnchorDataEnter = new StringBuilder();
    paramQQLiveAnchorDataEnter.append("anchorStartLive_");
    paramQQLiveAnchorDataEnter.append(this.a);
    paramQQLiveAnchorDataEnter.append(" ### onEnterRoomResult");
    Logger.a("TgLiveTag_TgLiveUtilsTgLiveRoomTestFragment_", paramQQLiveAnchorDataEnter.toString());
  }
  
  public void a(boolean paramBoolean, QQLiveAnchorDataInit paramQQLiveAnchorDataInit)
  {
    paramQQLiveAnchorDataInit = new StringBuilder();
    paramQQLiveAnchorDataInit.append("anchorStartLive_");
    paramQQLiveAnchorDataInit.append(this.a);
    paramQQLiveAnchorDataInit.append(" ### onCreateRoomInitResult");
    Logger.a("TgLiveTag_TgLiveUtilsTgLiveRoomTestFragment_", paramQQLiveAnchorDataInit.toString());
  }
  
  public void a(boolean paramBoolean, QQLiveAnchorDataPrepare paramQQLiveAnchorDataPrepare)
  {
    paramQQLiveAnchorDataPrepare = new StringBuilder();
    paramQQLiveAnchorDataPrepare.append("anchorStartLive_");
    paramQQLiveAnchorDataPrepare.append(this.a);
    paramQQLiveAnchorDataPrepare.append(" ### onPrepareResult");
    Logger.a("TgLiveTag_TgLiveUtilsTgLiveRoomTestFragment_", paramQQLiveAnchorDataPrepare.toString());
  }
  
  public void a(boolean paramBoolean, QQLiveAnchorDataPushInfo paramQQLiveAnchorDataPushInfo, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetThirdPushInfo");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ### onGetThirdPushInfo - ");
    localStringBuilder.append(paramBoolean);
    Logger.a("TgLiveTag_TgLiveUtilsTgLiveRoomTestFragment_", localStringBuilder.toString());
    if (!paramBoolean)
    {
      paramString1 = new StringBuilder();
      paramString1.append("获取第三方推流地址失败, ");
      paramString1.append(paramQQLiveAnchorDataPushInfo.errorMsg);
      CustomToastView.a(paramString1.toString());
      return;
    }
    TgLiveRoomTestFragment.d(this.b).setEnabled(true);
    TgLiveRoomTestFragment.e(this.b).setEnabled(true);
    TgLiveRoomTestFragment.b(this.b).setText(paramString1);
    TgLiveRoomTestFragment.c(this.b).setText(paramString2);
    paramQQLiveAnchorDataPushInfo = new StringBuilder();
    paramQQLiveAnchorDataPushInfo.append("推流地址:\nrtmpServer = ");
    paramQQLiveAnchorDataPushInfo.append(paramString1);
    paramQQLiveAnchorDataPushInfo.append("\nrtmpKey = ");
    paramQQLiveAnchorDataPushInfo.append(paramString2);
    paramQQLiveAnchorDataPushInfo = paramQQLiveAnchorDataPushInfo.toString();
    ClipboardUtil.a(Env.a(), paramQQLiveAnchorDataPushInfo);
    paramString1 = new StringBuilder();
    paramString1.append("已拷贝至剪贴板\n\n");
    paramString1.append(paramQQLiveAnchorDataPushInfo);
    CustomToastView.a(paramString1.toString());
  }
  
  public void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("anchorStartLive_");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ### onPrepareStart");
    Logger.a("TgLiveTag_TgLiveUtilsTgLiveRoomTestFragment_", localStringBuilder.toString());
  }
  
  public void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("anchorStartLive_");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ### onEnterRoomStart");
    Logger.a("TgLiveTag_TgLiveUtilsTgLiveRoomTestFragment_", localStringBuilder.toString());
  }
  
  public void d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("anchorStartLive_");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ### onPublishStreamStart");
    Logger.a("TgLiveTag_TgLiveUtilsTgLiveRoomTestFragment_", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.test.TgLiveRoomTestFragment.10
 * JD-Core Version:    0.7.0.1
 */