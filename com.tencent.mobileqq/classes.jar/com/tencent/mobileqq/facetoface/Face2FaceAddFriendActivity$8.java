package com.tencent.mobileqq.facetoface;

import android.content.res.Resources;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class Face2FaceAddFriendActivity$8
  extends MessageObserver
{
  Face2FaceAddFriendActivity$8(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  protected void onGetSystemMsgFin(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "onGetSystemMsgFin.bengin");
    }
    if (paramBoolean1) {
      if (QLog.isColorLevel()) {
        QLog.i(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "onGetSystemMsgFin.success");
      }
    }
    for (;;)
    {
      int j;
      try
      {
        new ArrayList();
        Object localObject1 = this.a.app.getMessageFacade().a(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
        Object localObject3;
        if (QLog.isColorLevel())
        {
          localObject2 = Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("onGetSystemMsgFin mDataList size=");
          ((StringBuilder)localObject3).append(((List)localObject1).size());
          QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
        }
        int i = ((List)localObject1).size() - 1;
        if (i < 0) {
          break label745;
        }
        Object localObject2 = (MessageForSystemMsg)((List)localObject1).get(i);
        if (localObject2 == null) {
          return;
        }
        Object localObject4;
        if (QLog.isColorLevel())
        {
          localObject3 = Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("msg_type=");
          ((StringBuilder)localObject4).append(((MessageForSystemMsg)localObject2).structMsg.msg_type.get());
          ((StringBuilder)localObject4).append("source id");
          ((StringBuilder)localObject4).append(((MessageForSystemMsg)localObject2).structMsg.msg.src_id.get());
          ((StringBuilder)localObject4).append("senderuin");
          ((StringBuilder)localObject4).append(((MessageForSystemMsg)localObject2).senderuin);
          QLog.d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
          localObject3 = Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("onGetSystemMsgFin");
          ((StringBuilder)localObject4).append(((MessageForSystemMsg)localObject2).senderuin);
          ((StringBuilder)localObject4).append("请求加好友");
          QLog.d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
        }
        if ((((MessageForSystemMsg)localObject2).structMsg.msg.src_id.get() != 3021) && (((MessageForSystemMsg)localObject2).structMsg.msg.src_id.get() != 2021))
        {
          if (!QLog.isColorLevel()) {
            break label753;
          }
          QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "此请求加好友来源不是面对面不予处理");
          return;
        }
        if (((MessageForSystemMsg)localObject2).structMsg.msg_type.get() == 1)
        {
          localObject3 = Face2FaceAddFriendActivity.a(this.a, ((MessageForSystemMsg)localObject2).senderuin, 1);
          if (localObject3 == null)
          {
            this.a.c.put(((MessageForSystemMsg)localObject2).senderuin, Integer.valueOf(3));
            if (!QLog.isColorLevel()) {
              break label754;
            }
            QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "onGetSystemMsgFin getViewFromUin=null");
            return;
          }
          localObject4 = this.a.e.iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label755;
          }
          String str2 = (String)((Iterator)localObject4).next();
          if (!((MessageForSystemMsg)localObject2).senderuin.equals(str2)) {
            continue;
          }
          bool = true;
          if ((localObject3 != null) && (bool) && (Face2FaceAddFriendActivity.a(this.a, ((MessageForSystemMsg)localObject2).senderuin)))
          {
            if (!QLog.isColorLevel()) {
              break label761;
            }
            localObject1 = Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("onGetSystemMsgFin isAddFriend=true");
            ((StringBuilder)localObject2).append(bool);
            QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
            return;
          }
          j = ((MessageForSystemMsg)localObject2).structMsg.msg.sub_type.get();
          if (!QLog.isColorLevel()) {
            break label762;
          }
          localObject3 = Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("onGetSystemMsgFin subType=");
          ((StringBuilder)localObject4).append(j);
          QLog.d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
          break label762;
          localObject1 = Face2FaceAddFriendActivity.a(this.a).obtainMessage();
          ((Message)localObject1).what = 2;
          ((Message)localObject1).arg1 = 3;
          ((Message)localObject1).obj = ((MessageForSystemMsg)localObject2).senderuin;
          Face2FaceAddFriendActivity.a(this.a).sendMessage((Message)localObject1);
          Face2FaceAddFriendActivity.a(this.a, 3, ((MessageForSystemMsg)localObject2).senderuin);
          return;
        }
        i -= 1;
        continue;
        if (!paramBoolean2) {
          break label745;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      String str1 = this.a.getResources().getString(2131719416);
      QQToast.a(this.a, 1, str1, 0).b(this.a.getTitleBarHeight());
      label745:
      super.onGetSystemMsgFin(paramBoolean1, paramBoolean2, paramList);
      return;
      label753:
      return;
      label754:
      return;
      label755:
      boolean bool = false;
      continue;
      label761:
      return;
      label762:
      if (j != 1)
      {
        if (j == 6) {
          break;
        }
        if ((j == 9) || (j == 10)) {}
      }
    }
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      String str = Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSendSystemMsgActionError.benginisSuccess=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("uin");
      localStringBuilder.append(paramString);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    super.onSendResult(paramBoolean, paramString, paramLong);
  }
  
  protected void onSendSystemMsgActionError(String paramString)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      String str = Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onSendSystemMsgActionError.bengin 同意添加好友失败");
      ((StringBuilder)localObject2).append(paramString);
      QLog.i(str, 2, ((StringBuilder)localObject2).toString());
    }
    long l2 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getCurrStructMsgKey();
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        l1 = Long.parseLong(paramString);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        l1 = l2;
      }
    }
    Object localObject1 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(l1));
    if (localObject1 != null)
    {
      localObject1 = String.valueOf(((structmsg.StructMsg)localObject1).req_uin.get());
      localObject2 = Face2FaceAddFriendActivity.a(this.a).obtainMessage();
      ((Message)localObject2).what = 2;
      ((Message)localObject2).arg1 = 3;
      ((Message)localObject2).obj = localObject1;
      Face2FaceAddFriendActivity.a(this.a).sendMessage((Message)localObject2);
      Face2FaceAddFriendActivity.a(this.a, 3, (String)localObject1);
      this.a.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendAnim.b((String)localObject1);
    }
    else if (QLog.isColorLevel())
    {
      QLog.i(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "onSendSystemMsgActionError structMsg = null");
    }
    localObject1 = this.a.getResources().getString(2131692139);
    QQToast.a(this.a, 0, (CharSequence)localObject1, 0).b(this.a.getTitleBarHeight());
    super.onSendSystemMsgActionError(paramString);
  }
  
  protected void onSendSystemMsgActionFin(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    Object localObject1;
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject1 = Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("onSendSystemMsgActionFin 同意加对方好友回调 issuc");
      ((StringBuilder)localObject3).append(paramBoolean);
      ((StringBuilder)localObject3).append("logStr=");
      ((StringBuilder)localObject3).append(paramString1);
      ((StringBuilder)localObject3).append(";actionType=");
      ((StringBuilder)localObject3).append(paramInt1);
      ((StringBuilder)localObject3).append(";msgDetail=");
      ((StringBuilder)localObject3).append(paramString2);
      ((StringBuilder)localObject3).append(";resultCode=");
      ((StringBuilder)localObject3).append(paramInt2);
      ((StringBuilder)localObject3).append(";respType=");
      ((StringBuilder)localObject3).append(paramInt3);
      ((StringBuilder)localObject3).append(";msgFail=");
      ((StringBuilder)localObject3).append(paramString3);
      ((StringBuilder)localObject3).append(";msgInvalidDecided=");
      ((StringBuilder)localObject3).append(paramString4);
      ((StringBuilder)localObject3).append(";remarkRet=");
      ((StringBuilder)localObject3).append(paramInt4);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject3).toString());
    }
    long l2 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getCurrStructMsgKey();
    if ((!paramBoolean) && (paramInt2 == 32))
    {
      QQToast.a(this.a, 0, paramString3, 0).b(this.a.getTitleBarHeight());
      localObject1 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(l2));
      if (localObject1 != null)
      {
        localObject1 = String.valueOf(((structmsg.StructMsg)localObject1).req_uin.get());
        localObject3 = Face2FaceAddFriendActivity.a(this.a).obtainMessage();
        ((Message)localObject3).what = 2;
        ((Message)localObject3).arg1 = 3;
        ((Message)localObject3).obj = localObject1;
        Face2FaceAddFriendActivity.a(this.a).sendMessage((Message)localObject3);
        Face2FaceAddFriendActivity.a(this.a, 3, (String)localObject1);
      }
      super.onSendSystemMsgActionFin(paramBoolean, paramString1, paramInt1, paramString2, paramInt2, paramInt3, paramString3, paramString4, paramInt4);
      return;
    }
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString1)) {
      try
      {
        l1 = Long.parseLong(paramString1);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        l1 = l2;
      }
    }
    Object localObject2 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(l1));
    if (localObject2 != null)
    {
      localObject2 = String.valueOf(((structmsg.StructMsg)localObject2).req_uin.get());
      if ((QLog.isColorLevel()) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        localObject3 = Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSendSystemMsgActionFin 同意加对方好友回调 =");
        localStringBuilder.append(((String)localObject2).substring(0, 4));
        QLog.i((String)localObject3, 2, localStringBuilder.toString());
      }
      this.a.e.add(localObject2);
    }
    else if (QLog.isColorLevel())
    {
      QLog.i(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "onSendSystemMsgActionFin structMsg = null");
    }
    super.onSendSystemMsgActionFin(paramBoolean, paramString1, paramInt1, paramString2, paramInt2, paramInt3, paramString3, paramString4, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.8
 * JD-Core Version:    0.7.0.1
 */