package com.tencent.mobileqq.flashshow.helper;

import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.biz.qqcircle.richframework.widget.menu.BubblePopupWindow;
import com.tencent.biz.qqcircle.richframework.widget.menu.BubblePopupWindow.OnDismissListener;
import com.tencent.biz.qqcircle.richframework.widget.menu.QQCustomMenuList;
import com.tencent.mobileqq.flashshow.utils.FSCommonUtil;
import com.tencent.mobileqq.flashshow.utils.FSHardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;

public class FSPopupWindowHelper
{
  private static volatile FSPopupWindowHelper a;
  private PopupWindow b;
  private BubblePopupWindow c;
  private CountDownTimer d;
  
  public static FSPopupWindowHelper a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new FSPopupWindowHelper();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(View paramView, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FSPopupWindowHelper.MenuClickListener paramMenuClickListener, BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.c = new BubblePopupWindow(-2, -2);
    paramStFeed = new QQCustomMenuList();
    paramStFeed.a(2131433380, FSHardCodeUtil.a(2131889725));
    if (FSCommonUtil.a((FeedCloudMeta.StUser)paramStComment.postUser.get())) {
      paramStFeed.a(2131433381, FSHardCodeUtil.a(2131889726));
    } else {
      paramStFeed.a(2131433382, FSHardCodeUtil.a(2131889727));
    }
    paramStComment = new FSPopupWindowHelper.1(this, paramMenuClickListener);
    paramMenuClickListener = this.c;
    paramMenuClickListener.a(BubbleContextMenu.a(paramMenuClickListener, paramView.getContext(), paramStFeed, paramStComment));
    this.c.a(paramOnDismissListener);
    this.c.a(new ColorDrawable(0));
    this.c.b(true);
    this.c.a(true);
    this.c.b(paramView);
  }
  
  public void a(View paramView, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StReply paramStReply, FSPopupWindowHelper.MenuClickListener paramMenuClickListener, BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.c = new BubblePopupWindow(-2, -2);
    paramStFeed = new QQCustomMenuList();
    paramStFeed.a(2131433380, FSHardCodeUtil.a(2131889725));
    if (FSCommonUtil.a((FeedCloudMeta.StUser)paramStReply.postUser.get())) {
      paramStFeed.a(2131433381, FSHardCodeUtil.a(2131889726));
    } else {
      paramStFeed.a(2131433382, FSHardCodeUtil.a(2131889727));
    }
    paramStReply = new FSPopupWindowHelper.2(this, paramMenuClickListener);
    paramMenuClickListener = this.c;
    paramMenuClickListener.a(BubbleContextMenu.a(paramMenuClickListener, paramView.getContext(), paramStFeed, paramStReply));
    this.c.a(paramOnDismissListener);
    this.c.a(new ColorDrawable(0));
    this.c.b(true);
    this.c.a(true);
    this.c.b(paramView);
  }
  
  public void b()
  {
    QLog.d("FSPopupWindowHelper", 1, "release");
    Object localObject = this.d;
    if (localObject != null)
    {
      ((CountDownTimer)localObject).cancel();
      this.d = null;
    }
    localObject = this.b;
    if (localObject != null)
    {
      ((PopupWindow)localObject).dismiss();
      this.b = null;
    }
    if (this.c != null) {
      this.c = null;
    }
    a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.helper.FSPopupWindowHelper
 * JD-Core Version:    0.7.0.1
 */