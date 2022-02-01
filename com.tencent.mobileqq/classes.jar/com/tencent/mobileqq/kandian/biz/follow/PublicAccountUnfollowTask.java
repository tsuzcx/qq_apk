package com.tencent.mobileqq.kandian.biz.follow;

import android.content.Context;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.repo.account.api.Ox978RespCallBack;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class PublicAccountUnfollowTask
  implements Ox978RespCallBack
{
  private int a = 0;
  private QQAppInterface b;
  private String c;
  private Context d;
  private MqqHandler e;
  private PublicAccountUnfollowTask.UnFollowPublicAccountListenner f;
  
  public PublicAccountUnfollowTask(QQAppInterface paramQQAppInterface, String paramString, Context paramContext)
  {
    this(paramQQAppInterface, paramString, paramContext, null);
  }
  
  public PublicAccountUnfollowTask(QQAppInterface paramQQAppInterface, String paramString, Context paramContext, PublicAccountUnfollowTask.UnFollowPublicAccountListenner paramUnFollowPublicAccountListenner)
  {
    this.b = paramQQAppInterface;
    this.c = paramString;
    this.f = paramUnFollowPublicAccountListenner;
    this.d = paramContext.getApplicationContext();
    this.e = ThreadManager.getSubThreadHandler();
  }
  
  public void a()
  {
    if ((this.a < 3) && (this.b != null))
    {
      this.e.post(new PublicAccountUnfollowTask.1(this));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("retry count reach max value or app = null ! retryCount : ");
    localStringBuilder.append(this.a);
    QLog.d("PublicAccountUnfollowTask", 2, localStringBuilder.toString());
  }
  
  public void a(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    int i = this.a;
    this.a = (i + 1);
    if (i < 3)
    {
      paramPublicAccountInfo = new StringBuilder();
      paramPublicAccountInfo.append("unfollow account fail ! uin : ");
      paramPublicAccountInfo.append(this.c);
      paramPublicAccountInfo.append(" , errCode : ");
      paramPublicAccountInfo.append(paramInt);
      paramPublicAccountInfo.append(", retry : ");
      paramPublicAccountInfo.append(this.a);
      QLog.d("PublicAccountUnfollowTask", 2, paramPublicAccountInfo.toString());
      this.e.post(new PublicAccountUnfollowTask.2(this));
      return;
    }
    paramPublicAccountInfo = this.f;
    if (paramPublicAccountInfo != null) {
      paramPublicAccountInfo.a(false, this.c);
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unfollow account success ! uin : ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",retry : ");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("PublicAccountUnfollowTask", 2, ((StringBuilder)localObject).toString());
      paramInt = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getUinType(this.b, this.c);
      RecentUtil.b(this.b, this.c, paramInt);
      this.b.getMessageFacade().a(this.c, 1008);
      ((ReadInJoyLogicManager)this.b.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().y();
      localObject = this.f;
      if (localObject != null) {
        ((PublicAccountUnfollowTask.UnFollowPublicAccountListenner)localObject).a(true, paramString);
      }
    }
    else
    {
      a(-1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.follow.PublicAccountUnfollowTask
 * JD-Core Version:    0.7.0.1
 */