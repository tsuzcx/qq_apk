package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.cache.Sizeable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.base.image.AggregateAvatarUrlDrawable;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.push.RIJMergeKanDianMessage;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.KandianRedDotInfo;
import com.tencent.mobileqq.kandian.repo.reddot.RIJKanDianRedDotUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.CommonImageCacheHelper;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class KandianSubscribeManager
  implements Manager
{
  public static final String a = "KandianSubscribeManager";
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new KandianSubscribeManager.2(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private KandianSubscribeManager.MsgBoxSetTopInfo jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianSubscribeManager$MsgBoxSetTopInfo;
  IReadInJoyUserInfoModule.RefreshUserInfoCallBack jdField_a_of_type_ComTencentMobileqqKandianGlueMsfApiIReadInJoyUserInfoModule$RefreshUserInfoCallBack = new KandianSubscribeManager.3(this);
  private List<KandianSubscribeManager.KandianSubscribeMessageObserver> jdField_a_of_type_JavaUtilList = new LinkedList();
  
  public KandianSubscribeManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianSubscribeManager$MsgBoxSetTopInfo = ((KandianSubscribeManager.MsgBoxSetTopInfo)RIJSPUtils.a(paramQQAppInterface, "kandian_subscribe_settop_info_key", true));
    paramQQAppInterface = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("read settop info from sp. ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianSubscribeManager$MsgBoxSetTopInfo);
    QLog.d(paramQQAppInterface, 1, localStringBuilder.toString());
  }
  
  public static Drawable a(Drawable paramDrawable, BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {
      return null;
    }
    Object localObject1 = ((QQAppInterface)paramBaseQQAppInterface).getMessageFacade();
    if (localObject1 == null) {
      return paramDrawable;
    }
    localObject1 = ((QQMessageFacade)localObject1).b(AppConstants.KANDIAN_SUBSCRIBE_UIN, 1008);
    if ((localObject1 != null) && (!((MessageRecord)localObject1).isread))
    {
      if (((MessageRecord)localObject1).msgtype != -2011) {
        return paramDrawable;
      }
      try
      {
        localObject2 = BaseApplicationImpl.getApplication().getResources();
        localObject1 = (MessageForStructing)localObject1;
        if (!((MessageForStructing)localObject1).mIsParsed) {
          ((MessageForStructing)localObject1).parse();
        }
        if (((MessageForStructing)localObject1).structingMsg != null)
        {
          if (TextUtils.isEmpty(((MessageForStructing)localObject1).structingMsg.mExtraData)) {
            return paramDrawable;
          }
          localObject1 = new JSONObject(((MessageForStructing)localObject1).structingMsg.mExtraData).optString("uin", "");
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            paramBaseQQAppInterface = (QQAppInterface)paramBaseQQAppInterface;
            Object localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("kd_dt_");
            ((StringBuilder)localObject3).append((String)localObject1);
            paramBaseQQAppInterface = paramBaseQQAppInterface.getFaceBitmapCacheKey(1, ((StringBuilder)localObject3).toString(), (byte)3, 0, 100, true);
            localObject3 = (AggregateAvatarUrlDrawable)CommonImageCacheHelper.a(paramBaseQQAppInterface);
            if (localObject3 != null)
            {
              localObject2 = jdField_a_of_type_JavaLangString;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("getMergeIcon From cache ! key : ");
              localStringBuilder.append(paramBaseQQAppInterface);
              localStringBuilder.append(", tipUin : ");
              localStringBuilder.append((String)localObject1);
              QLog.d((String)localObject2, 2, localStringBuilder.toString());
              return localObject3;
            }
            localObject3 = ImageUtil.a(paramDrawable);
            if (localObject3 == null) {
              return paramDrawable;
            }
            localObject2 = new AggregateAvatarUrlDrawable((Bitmap)localObject3, AIOUtils.b(50.0F, (Resources)localObject2), (Resources)localObject2, (String)localObject1, 1);
            a((String)localObject1, (AggregateAvatarUrlDrawable)localObject2);
            CommonImageCacheHelper.a(paramBaseQQAppInterface, (Sizeable)localObject2);
            return localObject2;
          }
        }
        else
        {
          return paramDrawable;
        }
      }
      catch (Exception paramBaseQQAppInterface)
      {
        paramBaseQQAppInterface.printStackTrace();
        localObject1 = jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("get merge icon has error : ");
        ((StringBuilder)localObject2).append(paramBaseQQAppInterface);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        return paramDrawable;
      }
      catch (OutOfMemoryError paramBaseQQAppInterface)
      {
        paramBaseQQAppInterface.printStackTrace();
        localObject1 = jdField_a_of_type_JavaLangString;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("get merge icon has error : ");
        ((StringBuilder)localObject2).append(paramBaseQQAppInterface);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
    }
    return paramDrawable;
  }
  
  public static KandianRedDotInfo a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
    if (localQQAppInterface == null) {
      return null;
    }
    MessageRecord localMessageRecord = localQQAppInterface.getMessageFacade().b(AppConstants.KANDIAN_SUBSCRIBE_UIN, 1008);
    if (localMessageRecord == null) {
      return null;
    }
    if ((localMessageRecord instanceof MessageForStructing))
    {
      RIJMergeKanDianMessage.a(AppConstants.KANDIAN_SUBSCRIBE_UIN, localQQAppInterface);
      return RIJKanDianRedDotUtils.a(localMessageRecord, "kandian_dt_red_dot_info");
    }
    return null;
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    a(paramContext, paramInt, -1);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).getJumpReadInJoyTabIntent(paramContext, paramInt2, 70);
    KandianRedDotInfo localKandianRedDotInfo = a();
    if (localKandianRedDotInfo != null) {
      localIntent.putExtra("kandian_feeds_red_pnt_info", localKandianRedDotInfo);
    }
    localIntent.putExtra("kandian_subscribe_launch_from", paramInt2);
    if (!(paramContext instanceof BaseActivity)) {
      localIntent.setFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  private static void a(String paramString, AggregateAvatarUrlDrawable paramAggregateAvatarUrlDrawable)
  {
    try
    {
      long l = Long.parseLong(paramString);
      if (l > 0L)
      {
        paramString = ReadInJoyUserInfoModule.a(l, new KandianSubscribeManager.5(l, paramAggregateAvatarUrlDrawable));
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[AggregateAvatarUrlDrawable] load aggregate avatar from 0xb81 userinfo success, uin:");
        localStringBuilder.append(l);
        QLog.d(str, 1, localStringBuilder.toString());
        if (paramString != null)
        {
          paramAggregateAvatarUrlDrawable.a(ReadInJoyUserInfoModule.a(paramString));
          return;
        }
      }
    }
    catch (NumberFormatException paramString)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, paramString.getMessage());
    }
  }
  
  private void b()
  {
    ThreadManager.getUIHandler().post(new KandianSubscribeManager.1(this));
  }
  
  private static void b(MessageRecord paramMessageRecord, String paramString1, long paramLong, String paramString2)
  {
    paramMessageRecord.issend = 1;
    paramMessageRecord.isread = true;
    paramMessageRecord.frienduin = AppConstants.KANDIAN_SUBSCRIBE_UIN;
    paramMessageRecord.senderuin = AppConstants.KANDIAN_SUBSCRIBE_UIN;
    paramMessageRecord.istroop = 1008;
    paramMessageRecord.msg = paramString1;
    paramMessageRecord.time = paramLong;
    paramMessageRecord.extLong = 0;
    paramMessageRecord.extStr = paramString2;
    paramMessageRecord.createMessageUniseq();
  }
  
  public MessageObserver a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  }
  
  public void a()
  {
    KandianSubscribeManager.MsgBoxSetTopInfo localMsgBoxSetTopInfo = this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianSubscribeManager$MsgBoxSetTopInfo;
    if (localMsgBoxSetTopInfo != null) {
      localMsgBoxSetTopInfo.tryToSetTop();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    KandianSubscribeManager.MsgBoxSetTopInfo localMsgBoxSetTopInfo = new KandianSubscribeManager.MsgBoxSetTopInfo();
    localMsgBoxSetTopInfo.setTopStartTime = paramInt1;
    localMsgBoxSetTopInfo.setTopPosition = paramInt2;
    boolean bool;
    if (paramInt3 == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localMsgBoxSetTopInfo.allowSettop = bool;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianSubscribeManager$MsgBoxSetTopInfo;
    if (localObject != null) {
      localMsgBoxSetTopInfo.lastSetTopTimeMillis = ((KandianSubscribeManager.MsgBoxSetTopInfo)localObject).lastSetTopTimeMillis;
    }
    RIJSPUtils.a("kandian_subscribe_settop_info_key", localMsgBoxSetTopInfo, true);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianSubscribeManager$MsgBoxSetTopInfo = localMsgBoxSetTopInfo;
    localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("update settop info : ");
    localStringBuilder.append(localMsgBoxSetTopInfo);
    QLog.d((String)localObject, 1, localStringBuilder.toString());
  }
  
  public void a(KandianSubscribeManager.KandianSubscribeMessageObserver paramKandianSubscribeMessageObserver)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramKandianSubscribeMessageObserver);
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, long paramLong)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    String str = ReadinjoyReportUtils.a(paramAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianGlueMsfApiIReadInJoyUserInfoModule$RefreshUserInfoCallBack);
    if (paramAbsBaseArticleInfo.msgBoxBriefPreFixType == 2) {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.msgBoxBriefPreFix;
    } else {
      paramAbsBaseArticleInfo = null;
    }
    if ((!TextUtils.isEmpty(str)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      ThreadManager.post(new KandianSubscribeManager.4(this, str, paramLong, paramAbsBaseArticleInfo), 10, null, false);
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "brief is empty, give up insert !");
  }
  
  public boolean a()
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(AppConstants.KANDIAN_SUBSCRIBE_UIN, 1008);
    return ((localMessageRecord instanceof MessageForStructing)) && (!localMessageRecord.isread);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianSubscribeManager
 * JD-Core Version:    0.7.0.1
 */