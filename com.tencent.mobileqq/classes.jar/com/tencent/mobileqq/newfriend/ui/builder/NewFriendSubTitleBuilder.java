package com.tencent.mobileqq.newfriend.ui.builder;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.newfriend.data.NewFriendSubTitle;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendSubTitleMessage;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class NewFriendSubTitleBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  NewFriendSubTitleBuilder.NewFriendSubTitleHolder a;
  
  public NewFriendSubTitleBuilder(Context paramContext, AppInterface paramAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
  }
  
  public View a(int paramInt, View paramView)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof NewFriendSubTitleBuilder.NewFriendSubTitleHolder)))
    {
      this.a = ((NewFriendSubTitleBuilder.NewFriendSubTitleHolder)paramView.getTag());
    }
    else
    {
      this.a = new NewFriendSubTitleBuilder.NewFriendSubTitleHolder();
      paramView = LayoutInflater.from(this.c).inflate(2131627609, null);
      this.a.a = ((TextView)paramView.findViewById(2131447463));
      this.a.b = paramView.findViewById(2131432580);
      this.a.b.setOnClickListener(this);
      this.a.c = ((ImageView)paramView.findViewById(2131436352));
      paramView.setTag(this.a);
    }
    this.a.a.setText(((NewFriendSubTitleMessage)this.g).a.a);
    Object localObject = this.a.b;
    boolean bool = ((NewFriendSubTitleMessage)this.g).a.b;
    int i = 0;
    if (bool) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    ((View)localObject).setVisibility(paramInt);
    localObject = this.a.c;
    if (((NewFriendSubTitleMessage)this.g).a.c) {
      paramInt = i;
    } else {
      paramInt = 8;
    }
    ((ImageView)localObject).setVisibility(paramInt);
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131432580)
    {
      ((INewFriendApi)QRoute.api(INewFriendApi.class)).jumpToNewFriendVerifyListAct((Activity)this.c);
      ((INewFriendVerificationService)this.d.getRuntimeService(INewFriendVerificationService.class, "")).clearRedPointAtNewFriendBanner();
      NewFriendSubTitleBuilder.NewFriendSubTitleHolder localNewFriendSubTitleHolder = this.a;
      if ((localNewFriendSubTitleHolder != null) && (localNewFriendSubTitleHolder.c != null)) {
        this.a.c.setVisibility(8);
      }
      ReportController.b(null, "dc00898", "", "", "0X800A3A5", "0X800A3A5", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.NewFriendSubTitleBuilder
 * JD-Core Version:    0.7.0.1
 */