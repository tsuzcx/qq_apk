package com.tencent.mobileqq.flashshow.viewmodel.barrage.popup;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mobileqq.flashshow.bean.FSEvilReportInfo.Builder;
import com.tencent.mobileqq.flashshow.bean.FSEvilReportInfo.ContentIdBuilder;
import com.tencent.mobileqq.flashshow.thread.FSThreadUtils;
import com.tencent.mobileqq.flashshow.utils.FSEvilReportUtils;
import com.tencent.mobileqq.flashshow.viewmodel.barrage.holder.bean.BarrageHolderParam;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;

public class FSBarragePopupWindow
  implements View.OnClickListener, PopupWindow.OnDismissListener
{
  private static volatile FSBarragePopupWindow a;
  private PopupWindow b;
  private TextView c;
  private TextView d;
  private FSBarragePopupWindow.DelayCloseTask e;
  private PopupWindow.OnDismissListener f;
  private BarrageHolderParam g;
  private FeedCloudMeta.StFeed h;
  
  private View a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131624797, null);
    this.c = ((TextView)paramContext.findViewById(2131433332));
    this.d = ((TextView)paramContext.findViewById(2131433336));
    this.d.setOnClickListener(this);
    return paramContext;
  }
  
  public static FSBarragePopupWindow a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new FSBarragePopupWindow();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.d("DM-FSPopupWindowHelper", 1, "[updateTextView] ");
    }
    if (paramTextView == null)
    {
      QLog.d("DM-FSPopupWindowHelper", 1, "[updateTextView] view should not be null.");
      return;
    }
    paramTextView.setText(paramString);
  }
  
  private String b(FeedCloudMeta.StComment paramStComment)
  {
    if (paramStComment == null) {
      return "";
    }
    return paramStComment.postUser.id.get();
  }
  
  private void b()
  {
    d();
    this.e = new FSBarragePopupWindow.DelayCloseTask(this);
    FSThreadUtils.a(this.e, 6000L);
  }
  
  private String c(FeedCloudMeta.StComment paramStComment)
  {
    if (paramStComment == null) {
      return "";
    }
    return paramStComment.id.get();
  }
  
  private void c()
  {
    f();
  }
  
  private long d(FeedCloudMeta.StComment paramStComment)
  {
    if (paramStComment == null) {
      return 0L;
    }
    return paramStComment.createTime.get();
  }
  
  private void d()
  {
    FSBarragePopupWindow.DelayCloseTask localDelayCloseTask = this.e;
    if (localDelayCloseTask != null) {
      FSThreadUtils.c(localDelayCloseTask);
    }
  }
  
  private void e()
  {
    Object localObject = this.g;
    if (localObject == null)
    {
      QLog.d("DM-FSPopupWindowHelper", 1, "[updateBarragePopupValue] param should not be null.");
      return;
    }
    String str = a(((BarrageHolderParam)localObject).a());
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = a(this.g.b());
    }
    a(this.c, (String)localObject);
  }
  
  private void f()
  {
    PopupWindow localPopupWindow = this.b;
    if (localPopupWindow == null) {
      return;
    }
    if (localPopupWindow.isShowing()) {
      this.b.dismiss();
    }
  }
  
  private void g()
  {
    String str = new FSEvilReportInfo.ContentIdBuilder().b(h()).c(c(j())).a(i()).d(String.valueOf(d(j()))).a();
    FSEvilReportUtils.a(new FSEvilReportInfo.Builder().a("ks_comment").d(str).c(b(j())).b("25089").a());
  }
  
  private String h()
  {
    FeedCloudMeta.StFeed localStFeed = this.h;
    if (localStFeed == null) {
      return "";
    }
    return localStFeed.id.get();
  }
  
  private String i()
  {
    FeedCloudMeta.StFeed localStFeed = this.h;
    if (localStFeed == null) {
      return "";
    }
    return localStFeed.poster.id.get();
  }
  
  private FeedCloudMeta.StComment j()
  {
    BarrageHolderParam localBarrageHolderParam = this.g;
    if (localBarrageHolderParam == null) {
      return null;
    }
    return localBarrageHolderParam.a();
  }
  
  protected String a(FeedCloudMeta.StComment paramStComment)
  {
    if (paramStComment == null) {
      return null;
    }
    return paramStComment.content.get();
  }
  
  protected String a(FeedCloudMeta.StReply paramStReply)
  {
    if (paramStReply == null) {
      return null;
    }
    return paramStReply.content.get();
  }
  
  public void a(Context paramContext, View paramView)
  {
    paramContext = a(paramContext);
    e();
    this.b = new PopupWindow(-2, -2);
    this.b.setContentView(paramContext);
    this.b.setOnDismissListener(this);
    this.b.setBackgroundDrawable(new ColorDrawable(0));
    this.b.setOutsideTouchable(true);
    this.b.setFocusable(true);
    paramContext.measure(0, 0);
    int i = paramContext.getMeasuredWidth();
    int j = paramContext.getMeasuredHeight();
    int k = paramView.getWidth();
    int m = paramView.getHeight();
    int n = (k - i) / 2;
    int i1 = -(m / 2) + j;
    QLog.d("DM-FSPopupWindowHelper", 1, new Object[] { "[showBarragePopup] popupWidth: ", Integer.valueOf(i), " | popupHeight: ", Integer.valueOf(j), " | attachWidth: ", Integer.valueOf(k), " | attachHeight: ", Integer.valueOf(m), " | offsetX: ", Integer.valueOf(n), " | offsetY: ", Integer.valueOf(i1) });
    this.b.showAsDropDown(paramView, n, i1);
    b();
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.f = paramOnDismissListener;
  }
  
  public void a(BarrageHolderParam paramBarrageHolderParam)
  {
    this.g = paramBarrageHolderParam;
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    this.h = paramStFeed;
  }
  
  public void onClick(View paramView)
  {
    int i;
    if (paramView == null) {
      i = -1;
    } else {
      i = paramView.getId();
    }
    if (i == 2131433336)
    {
      f();
      g();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDismiss()
  {
    d();
    PopupWindow.OnDismissListener localOnDismissListener = this.f;
    if (localOnDismissListener != null) {
      localOnDismissListener.onDismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.barrage.popup.FSBarragePopupWindow
 * JD-Core Version:    0.7.0.1
 */