package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.now.NowVideoLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgItemLive;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class StructMsgItemLayout18
  extends AbsStructMsgItem
{
  private QQAppInterface a;
  
  protected int b()
  {
    return 18;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemLayout18", 2, "getView.");
    }
    paramBundle = BaseApplicationImpl.getApplication().getRuntime();
    paramContext.getResources();
    if ((paramBundle instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramBundle);
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    paramBundle = null;
    StructMsgItemLive localStructMsgItemLive = null;
    while (((Iterator)localObject).hasNext())
    {
      AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
      if ("live".equals(localAbsStructMsgElement.a)) {
        localStructMsgItemLive = (StructMsgItemLive)localAbsStructMsgElement;
      }
    }
    if (localStructMsgItemLive == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsgItemLayout18", 2, "getView itemLive is null.");
      }
      return null;
    }
    if (paramView != null)
    {
      localObject = (StructMsgItemLayout18.ViewHolder)paramView.getTag();
      paramContext = paramBundle;
      paramBundle = (Bundle)localObject;
    }
    else
    {
      paramView = localStructMsgItemLive.a(paramContext, null, null);
      paramContext = (NowVideoLayout)paramView.findViewById(2131377987);
      paramContext.a();
      paramBundle = null;
    }
    if (paramBundle == null)
    {
      paramBundle = new StructMsgItemLayout18.ViewHolder();
      paramBundle.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgItemLive = localStructMsgItemLive;
      paramBundle.jdField_a_of_type_ComTencentBizNowNowVideoLayout = paramContext;
    }
    else
    {
      paramContext = paramBundle.jdField_a_of_type_ComTencentBizNowNowVideoLayout;
    }
    paramView.setTag(paramBundle);
    paramBundle = paramView.findViewById(2131377987);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(localStructMsgItemLive.a);
    }
    if (paramContext != null) {
      paramContext.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localStructMsgItemLive, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message);
    }
    return paramView;
  }
  
  public String b()
  {
    return "Layout18";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout18
 * JD-Core Version:    0.7.0.1
 */