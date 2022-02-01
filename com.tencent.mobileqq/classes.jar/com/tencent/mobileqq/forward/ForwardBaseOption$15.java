package com.tencent.mobileqq.forward;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ForwardBaseOption$15
  extends DiscussionObserver
{
  ForwardBaseOption$15(ForwardBaseOption paramForwardBaseOption) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateDiscussionInfo start: isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("ForwardOption.ForwardBaseOption", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a.t.getString("uin");
    paramObject = (ArrayList)paramObject;
    int i = paramObject.indexOf(localObject);
    if (i != -1)
    {
      paramObject = (Boolean)paramObject.get(i + 1);
      if ((paramBoolean) && (paramObject.booleanValue()))
      {
        paramObject = ((DiscussionManager)this.a.q.getManager(QQManagerFactory.DISCUSSION_MANAGER)).d((String)localObject);
        if ((paramObject != null) && (!TextUtils.isEmpty(paramObject.discussionName)) && (this.a.A != null))
        {
          localObject = this.a.A;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131902736));
          localStringBuilder.append(ForwardConstants.d_);
          localStringBuilder.append(paramObject.discussionName);
          ((QQCustomDialog)localObject).setTitle(localStringBuilder.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardBaseOption.15
 * JD-Core Version:    0.7.0.1
 */