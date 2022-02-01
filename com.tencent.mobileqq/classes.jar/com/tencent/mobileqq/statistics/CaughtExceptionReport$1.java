package com.tencent.mobileqq.statistics;

import com.tencent.biz.qqstory.utils.StoryDebugUtils.StoryExceptionCallback;
import com.tencent.hotpatch.PatchDownloadManager;
import com.tencent.imcore.message.msgproxy.MsgProxyUtilsCallback;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.ChatItemAnimLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerInitialler;
import com.tencent.mobileqq.app.message.MsgHelper;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.ConversationInfoErrorReporter;
import com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher;
import com.tencent.mobileqq.intervideo.huayang.HuayangPluginNewDownloader;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.mobileqq.mutualmark.MutualMarkBusinessLogicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.TbsAccelerator;
import com.tencent.open.base.MD5Utils;
import com.tencent.widget.SingleLineTextView;
import java.util.HashSet;

final class CaughtExceptionReport$1
  extends HashSet<String>
{
  CaughtExceptionReport$1(int paramInt)
  {
    super(paramInt);
    add(BaseActivity.class.getName());
    add(FDStats.class.getName());
    add(SwiftWebAccelerator.TbsAccelerator.class.getName());
    add(StoryDebugUtils.StoryExceptionCallback.class.getName());
    add(ShortVideoExceptionReporter.class.getName());
    add(PatchDownloadManager.class.getName());
    add(SingleLineTextView.class.getName());
    add(BaseBubbleBuilder.class.getName());
    add(ChatItemAnimLayout.class.getName());
    add(SecurityUtile.class.getName());
    add(MsgHelper.class.getName());
    add(ConversationInfo.class.getName());
    add(HuayangPluginNewDownloader.class.getName());
    add(HuayangPluginLauncher.class.getName());
    add(ReportLog.class.getName());
    add(FightReporter.class.getName());
    add(ThreadManagerInitialler.class.getName());
    add(RichMediaBugReport.class.getName());
    add(MD5Utils.class.getName());
    add(RecentUserProxy.class.getName());
    add(((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getBGLocateMonitorClassName());
    add(MutualMarkBusinessLogicHelper.class.getName());
    add(ConversationInfoErrorReporter.class.getName());
    add(MsgProxyUtilsCallback.class.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.CaughtExceptionReport.1
 * JD-Core Version:    0.7.0.1
 */