package com.tencent.mobileqq.flashshow.part;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qcircleshadow.lib.variation.HostAppSettingUtil;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.flashshow.bean.FSShareInfo;
import com.tencent.mobileqq.flashshow.request.root.FSFeedHitRequest;
import com.tencent.mobileqq.flashshow.thread.FSThreadUtils;
import com.tencent.mobileqq.flashshow.utils.FSSpUtil;
import com.tencent.mobileqq.flashshow.utils.FSTransUtils;
import com.tencent.mobileqq.flashshow.widgets.common.FSCustomDialog;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.List;
import qqcircle.QQCircleFeedbackhit.StFeedbackCommonInfo;

public class FSDebugPart
  extends FSBasePart
{
  private Handler a;
  
  private void a(FSShareInfo paramFSShareInfo)
  {
    HostUIHelper.openHostEnvironment(new FSDebugPart.2(this, paramFSShareInfo));
  }
  
  private void a(ActionSheet paramActionSheet)
  {
    if ((paramActionSheet != null) && (paramActionSheet.isShowing()))
    {
      paramActionSheet.dismiss();
      QLog.d("FSDebugPart", 1, "safeCloseSheet  dismiss");
      if (this.a == null) {
        this.a = new Handler(Looper.getMainLooper());
      }
    }
    d();
  }
  
  private void a(ActionSheet paramActionSheet, FSShareInfo paramFSShareInfo)
  {
    int i;
    if ((paramFSShareInfo != null) && (paramFSShareInfo.a != null) && (paramFSShareInfo.a.opMask2 != null) && (paramFSShareInfo.a.opMask2.get().contains(Integer.valueOf(13)))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramActionSheet.addButton(g().getString(2131889706));
    }
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed, int paramInt1, int paramInt2)
  {
    QQCircleFeedbackhit.StFeedbackCommonInfo localStFeedbackCommonInfo = new QQCircleFeedbackhit.StFeedbackCommonInfo();
    localStFeedbackCommonInfo.feedId.set(paramStFeed.id.get());
    localStFeedbackCommonInfo.sourceUin.set(paramStFeed.poster.id.get());
    localStFeedbackCommonInfo.operationUin.set(FSTransUtils.a());
    localStFeedbackCommonInfo.level.set(paramInt2);
    Object localObject2 = paramStFeed.poster.nick.get();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramStFeed.id.get();
    }
    localStFeedbackCommonInfo.sourceUinName.set((String)localObject1);
    localObject1 = new FeedCloudCommon.StCommonExt();
    localObject2 = new FeedCloudCommon.Entry();
    ((FeedCloudCommon.Entry)localObject2).key.set("appid");
    ((FeedCloudCommon.Entry)localObject2).value.set("7");
    ((FeedCloudCommon.StCommonExt)localObject1).mapInfo.add((MessageMicro)localObject2);
    VSNetworkHelper.getInstance().sendRequest(new FSFeedHitRequest(localStFeedbackCommonInfo, paramInt1, (FeedCloudCommon.StCommonExt)localObject1), new FSDebugPart.6(this, paramStFeed));
  }
  
  private void b(FSShareInfo paramFSShareInfo)
  {
    if (paramFSShareInfo == null) {
      return;
    }
    String str = g().getResources().getString(2131889707);
    FSCustomDialog.a(g(), str, null, 2131887648, 2131887629, new FSDebugPart.4(this, paramFSShareInfo), new FSDebugPart.5(this)).show();
  }
  
  private void b(ActionSheet paramActionSheet)
  {
    int i = 0;
    if (((Integer)FSSpUtil.b("FSFeedChildDebugInfoPresenter", Integer.valueOf(0))).intValue() == 1) {
      i = 1;
    }
    String str;
    if (i != 0) {
      str = g().getString(2131889708);
    } else {
      str = g().getString(2131889743);
    }
    paramActionSheet.addButton(str);
  }
  
  private void d()
  {
    Handler localHandler = this.a;
    if (localHandler == null)
    {
      QLog.e("FSDebugPart", 1, "mUIHandler == null");
      return;
    }
    localHandler.postDelayed(new FSDebugPart.3(this), 200L);
  }
  
  public String a()
  {
    return "FSDebugPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
  }
  
  public void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    if (!HostAppSettingUtil.isPublicVersion())
    {
      if (!"SHOW_DEBUG_INFO".equals(paramString)) {
        return;
      }
      FSThreadUtils.a(new FSDebugPart.1(this, paramObject), 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSDebugPart
 * JD-Core Version:    0.7.0.1
 */