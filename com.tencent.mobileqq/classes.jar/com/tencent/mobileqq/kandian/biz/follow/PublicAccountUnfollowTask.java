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
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PublicAccountUnfollowTask.UnFollowPublicAccountListenner jdField_a_of_type_ComTencentMobileqqKandianBizFollowPublicAccountUnfollowTask$UnFollowPublicAccountListenner;
  private String jdField_a_of_type_JavaLangString;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public PublicAccountUnfollowTask(QQAppInterface paramQQAppInterface, String paramString, Context paramContext)
  {
    this(paramQQAppInterface, paramString, paramContext, null);
  }
  
  public PublicAccountUnfollowTask(QQAppInterface paramQQAppInterface, String paramString, Context paramContext, PublicAccountUnfollowTask.UnFollowPublicAccountListenner paramUnFollowPublicAccountListenner)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFollowPublicAccountUnfollowTask$UnFollowPublicAccountListenner = paramUnFollowPublicAccountListenner;
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Int < 3) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new PublicAccountUnfollowTask.1(this));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("retry count reach max value or app = null ! retryCount : ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    QLog.d("PublicAccountUnfollowTask", 2, localStringBuilder.toString());
  }
  
  public void a(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    if (i < 3)
    {
      paramPublicAccountInfo = new StringBuilder();
      paramPublicAccountInfo.append("unfollow account fail ! uin : ");
      paramPublicAccountInfo.append(this.jdField_a_of_type_JavaLangString);
      paramPublicAccountInfo.append(" , errCode : ");
      paramPublicAccountInfo.append(paramInt);
      paramPublicAccountInfo.append(", retry : ");
      paramPublicAccountInfo.append(this.jdField_a_of_type_Int);
      QLog.d("PublicAccountUnfollowTask", 2, paramPublicAccountInfo.toString());
      this.jdField_a_of_type_MqqOsMqqHandler.post(new PublicAccountUnfollowTask.2(this));
      return;
    }
    paramPublicAccountInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizFollowPublicAccountUnfollowTask$UnFollowPublicAccountListenner;
    if (paramPublicAccountInfo != null) {
      paramPublicAccountInfo.a(false, this.jdField_a_of_type_JavaLangString);
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
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("PublicAccountUnfollowTask", 2, ((StringBuilder)localObject).toString());
      paramInt = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getUinType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      RecentUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, 1008);
      ((ReadInJoyLogicManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().e();
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFollowPublicAccountUnfollowTask$UnFollowPublicAccountListenner;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.follow.PublicAccountUnfollowTask
 * JD-Core Version:    0.7.0.1
 */