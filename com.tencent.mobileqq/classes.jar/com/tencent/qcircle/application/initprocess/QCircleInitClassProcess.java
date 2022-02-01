package com.tencent.qcircle.application.initprocess;

import com.tencent.biz.qqcircle.activity.QCircleFolderActivity;
import com.tencent.biz.qqcircle.adapter.QCircleTianShuBannerBlock;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseBlockPart;
import com.tencent.biz.qqcircle.bizparts.QCircleCommentPanelPart;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderActivityChipPart;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderSplashPart;
import com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart;
import com.tencent.biz.qqcircle.bizparts.QCirclePublishFeedPart;
import com.tencent.biz.qqcircle.bizparts.QCirclePublishStatusBoxPart;
import com.tencent.biz.qqcircle.bizparts.QCirclePushToastPart;
import com.tencent.biz.qqcircle.bizparts.QCircleRichMediaDownLoadPart;
import com.tencent.biz.qqcircle.bizparts.QCircleSharePartV2;
import com.tencent.biz.qqcircle.bizparts.QCircleTaskCenterPart;
import com.tencent.biz.qqcircle.bizparts.QCircleTopAuthPart;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.fragments.main.QCircleFolderActivityFragment;
import com.tencent.biz.qqcircle.fragments.main.QCircleFolderFollowTabFragment;
import com.tencent.biz.qqcircle.fragments.main.QCircleFolderRcmdTabFragment;
import com.tencent.biz.qqcircle.fragments.main.part.QCircleFolderFragmentsTabPart;
import com.tencent.biz.qqcircle.fragments.main.part.QCircleMainTabTipPart;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeFrameLayout;
import com.tencent.biz.qqcircle.publish.queue.QCircleTaskQueue;
import com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat;
import com.tencent.biz.qqcircle.richframework.widget.ViewPagerCompat;
import com.tencent.biz.qqcircle.widgets.QCircleGuideBubbleView;
import com.tencent.biz.qqcircle.widgets.QCirclePushToastView;
import com.tencent.biz.qqcircle.widgets.dialog.QCircleLoadingDialog;
import com.tencent.biz.richframework.widget.MultiTabViewPager;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

public class QCircleInitClassProcess
  extends QCircleBaseInitProcess
{
  private static String a = "QCircleInitClassProcess";
  
  private void c()
  {
    long l = System.currentTimeMillis();
    QCircleFolderActivity.class.getClass();
    QCircleFolderActivityFragment.class.getClass();
    QCircleFolderFollowTabFragment.class.getClass();
    QCircleFolderRcmdTabFragment.class.getClass();
    QCircleFolderActivityChipPart.class.getClass();
    QCirclePublishStatusBoxPart.class.getClass();
    QCirclePublishFeedPart.class.getClass();
    QCircleLightInteractListPart.class.getClass();
    QCircleCommentPanelPart.class.getClass();
    QCircleFolderFragmentsTabPart.class.getClass();
    QCircleFolderFragmentsPart.class.getClass();
    QCircleFolderSplashPart.class.getClass();
    QCircleTaskCenterPart.class.getClass();
    QCirclePushToastPart.class.getClass();
    QCircleSharePartV2.class.getClass();
    QCircleMainTabTipPart.class.getClass();
    QCircleRichMediaDownLoadPart.class.getClass();
    QCircleTopAuthPart.class.getClass();
    QCircleTianShuBannerBlock.class.getClass();
    QCircleBaseBlockPart.class.getClass();
    TabLayoutCompat.class.getClass();
    MultiTabViewPager.class.getClass();
    ViewPagerCompat.class.getClass();
    QCirclePushToastView.class.getClass();
    QCircleBlockContainer.class.getClass();
    QCirclePolyLikeFrameLayout.class.getClass();
    QCircleTaskQueue.class.getClass();
    QCircleLoadingDialog.class.getClass();
    QCircleGuideBubbleView.class.getClass();
    URLImageView.class.getClass();
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preload class:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    QLog.d(str, 1, localStringBuilder.toString());
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b()
  {
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.application.initprocess.QCircleInitClassProcess
 * JD-Core Version:    0.7.0.1
 */