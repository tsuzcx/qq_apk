package com.tencent.mobileqq.newfriend.ui.builder;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl;
import com.tencent.mobileqq.newfriend.config.NewFriendContactGuideConfBean;
import com.tencent.mobileqq.newfriend.config.NewFriendContactGuideConfBean.UIElement;
import com.tencent.mobileqq.newfriend.msg.NewFriendBindContactGuideMsgV2;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListBaseAdapter;
import com.tencent.mobileqq.newfriend.utils.NewFriendUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class NewFriendBindContactGuideBuilderV2
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  public NewFriendBindContactGuideMsgV2 a;
  
  public NewFriendBindContactGuideBuilderV2(Context paramContext, AppInterface paramAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    this.a = ((NewFriendBindContactGuideMsgV2)paramNewFriendMessage);
  }
  
  private void d()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      this.e.a(this);
      this.e.notifyDataSetChanged();
      return;
    }
    this.d.runOnUiThread(new NewFriendBindContactGuideBuilderV2.2(this));
  }
  
  private void e()
  {
    NewFriendBindContactGuideBuilderV2.3 local3 = new NewFriendBindContactGuideBuilderV2.3(this);
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).checkReadContactPermission(local3, this.c, this.d);
  }
  
  public View a(int paramInt, View paramView)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof NewFriendBindContactGuideBuilderV2.MyHolder)))
    {
      localObject = (NewFriendBindContactGuideBuilderV2.MyHolder)paramView.getTag();
    }
    else
    {
      paramView = LayoutInflater.from(this.c).inflate(2131627876, null);
      localObject = new NewFriendBindContactGuideBuilderV2.MyHolder(null);
      ((NewFriendBindContactGuideBuilderV2.MyHolder)localObject).b = ((Button)paramView.findViewById(2131427516));
      ((NewFriendBindContactGuideBuilderV2.MyHolder)localObject).c = ((TextView)paramView.findViewById(2131447463));
      ((NewFriendBindContactGuideBuilderV2.MyHolder)localObject).d = ((TextView)paramView.findViewById(2131446620));
      ((NewFriendBindContactGuideBuilderV2.MyHolder)localObject).a = ((ImageButton)paramView.findViewById(2131430806));
      paramView.setTag(localObject);
    }
    String str1;
    String str2;
    String str3;
    if (!this.a.b)
    {
      str1 = this.a.a.c.a;
      str2 = this.a.a.c.b;
      str3 = this.a.a.c.c;
    }
    else
    {
      str1 = this.a.a.d.a;
      str2 = this.a.a.d.b;
      str3 = this.a.a.d.c;
    }
    ((NewFriendBindContactGuideBuilderV2.MyHolder)localObject).c.setText(str1);
    ((NewFriendBindContactGuideBuilderV2.MyHolder)localObject).d.setText(str2);
    ((NewFriendBindContactGuideBuilderV2.MyHolder)localObject).b.setText(str3);
    paramView.setOnClickListener(this);
    ((NewFriendBindContactGuideBuilderV2.MyHolder)localObject).a.setOnClickListener(this);
    ((NewFriendBindContactGuideBuilderV2.MyHolder)localObject).b.setOnClickListener(this);
    NewFriendUtil.a(paramView, false);
    Object localObject = (NewFriendServiceImpl)this.d.getRuntimeService(INewFriendService.class, "");
    if (!this.a.b)
    {
      if (!((NewFriendServiceImpl)localObject).isGuidePermissionReported())
      {
        ((NewFriendServiceImpl)localObject).setIsGuidePermissionReported(true);
        ReportController.b(this.d, "dc00898", "", "", "0X8009F1D", "0X8009F1D", 0, 0, "", "", "", "");
        return paramView;
      }
    }
    else if (!((NewFriendServiceImpl)localObject).isGuideBindReported())
    {
      ((NewFriendServiceImpl)localObject).setIsGuideBindReported(true);
      ReportController.b(this.d, "dc00898", "", "", "0X8009F1F", "0X8009F1F", 0, 0, "", "", "", "");
    }
    return paramView;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendBindContactGuideBuilderV2", 2, "uploadContact");
    }
    ThreadManager.excute(new NewFriendBindContactGuideBuilderV2.1(this), 16, null, false);
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).startContactBindFromOther(this.d, 15, 2, null);
    d();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131430806)
    {
      ((NewFriendServiceImpl)this.d.getRuntimeService(INewFriendService.class, "")).setContactGuideCancelByUser();
      d();
    }
    else if ((i == 2131427516) || (i == 2131429498))
    {
      if (!NetworkUtil.isNetSupport(this.c))
      {
        BaseApplication localBaseApplication = BaseApplication.getContext();
        QQToast.makeText(localBaseApplication, 1, 2131892157, 0).show(localBaseApplication.getResources().getDimensionPixelSize(2131299920));
      }
      else if (this.a.b)
      {
        ReportController.b(this.d, "dc00898", "", "", "0X8009F20", "0X8009F20", 0, 0, "", "", "", "");
        c();
      }
      else
      {
        ReportController.b(this.d, "dc00898", "", "", "0X8009F1E", "0X8009F1E", 0, 0, "", "", "", "");
        e();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.NewFriendBindContactGuideBuilderV2
 * JD-Core Version:    0.7.0.1
 */