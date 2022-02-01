package com.tencent.mobileqq.qwallet.hb.aio.specify.impl;

import android.text.TextUtils;
import android.view.WindowManager;
import com.qwallet.temp.IAIOAnimationControlManager;
import com.qwallet.temp.IAnimationMessageProxy;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.aio.specify.ISpecifyRedPacketAnimMsg;
import com.tencent.mobileqq.qwallet.hb.aio.specify.ISpecifyRedPacketAnimMsg.OnAnimEndListener;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class SpecifyRedPacketAnimMsg
  implements IAnimationMessageProxy, ISpecifyRedPacketAnimMsg
{
  WindowManager jdField_a_of_type_AndroidViewWindowManager;
  public MessageForQQWalletMsg a;
  SpecifyGiftView jdField_a_of_type_ComTencentMobileqqQwalletHbAioSpecifyImplSpecifyGiftView;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean = false;
  
  public SpecifyRedPacketAnimMsg(MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg = paramMessageForQQWalletMsg;
  }
  
  public static boolean a(BaseQQAppInterface paramBaseQQAppInterface, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    if (paramBaseQQAppInterface != null)
    {
      if (paramMessageForQQWalletMsg == null) {
        return false;
      }
      boolean bool = a(paramMessageForQQWalletMsg, paramBaseQQAppInterface);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tryScheduleSpecifyAnim isValidAnim=");
        localStringBuilder.append(bool);
        QLog.i("SpecifyRedPacketAnimMsg", 2, localStringBuilder.toString());
      }
      if (bool)
      {
        paramMessageForQQWalletMsg = new SpecifyRedPacketAnimMsg(paramMessageForQQWalletMsg);
        ((IAIOAnimationControlManager)paramBaseQQAppInterface.getRuntimeService(IAIOAnimationControlManager.class)).addPlayAnimationList(paramMessageForQQWalletMsg, false);
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(Object paramObject, BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (!(paramObject instanceof MessageForQQWalletMsg)) {
      return false;
    }
    paramObject = (MessageForQQWalletMsg)paramObject;
    int i = paramObject.messageType;
    if ((i != 7) && (i != 8) && (i != 11) && (i != 12)) {
      return false;
    }
    if (TextUtils.isEmpty(paramObject.mQQWalletRedPacketMsg.body.feedId)) {
      return false;
    }
    if (paramObject.isRedPackExpired()) {
      return false;
    }
    if ((!RedPacketConfigManager.a().a()) && (!paramBaseQQAppInterface.getCurrentUin().equals(paramObject.senderuin)))
    {
      if (paramObject.mQQWalletRedPacketMsg.specifyUinList != null)
      {
        paramObject = paramObject.mQQWalletRedPacketMsg.specifyUinList.iterator();
        while (paramObject.hasNext())
        {
          Long localLong = (Long)paramObject.next();
          String str = paramBaseQQAppInterface.getCurrentUin();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localLong);
          localStringBuilder.append("");
          if (str.equals(localStringBuilder.toString()))
          {
            i = 1;
            break label190;
          }
        }
      }
      i = 0;
      label190:
      if (i == 0) {
        return false;
      }
    }
    return true;
  }
  
  public long a()
  {
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin);
      return l;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0L;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin;
  }
  
  public void a()
  {
    SpecifyGiftView localSpecifyGiftView = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioSpecifyImplSpecifyGiftView;
    if (localSpecifyGiftView != null) {
      try
      {
        localSpecifyGiftView.removeAllViews();
        this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioSpecifyImplSpecifyGiftView);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e(".troop.send_gift", 2, "closeRedPackGiftAnimation exception ", localException);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioSpecifyImplSpecifyGiftView = null;
    this.jdField_a_of_type_AndroidViewWindowManager = null;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(Object paramObject, ISpecifyRedPacketAnimMsg.OnAnimEndListener paramOnAnimEndListener)
  {
    Object localObject = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).createBaseChatPie(paramObject);
    QWalletTools.a(QWalletTools.a(), "212", "only.animation.show");
    paramObject = new StringBuilder();
    paramObject.append(SpecifyAnimInfo.a());
    paramObject.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.feedId);
    paramObject.append(".zip");
    paramObject = paramObject.toString();
    WeakReference localWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
    localObject = new WeakReference(localObject);
    if (QLog.isColorLevel()) {
      QLog.i("SpecifyRedPacketAnimMsg", 2, "showAnim start");
    }
    paramOnAnimEndListener = new SpecifyRedPacketAnimMsg.1(this, paramOnAnimEndListener);
    this.jdField_a_of_type_JavaLangRunnable = new SpecifyRedPacketAnimMsg.2(this, paramOnAnimEndListener);
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
    PreloadStaticApi.a().getResPath(paramObject, new SpecifyRedPacketAnimMsg.3(this, localWeakReference, paramOnAnimEndListener, (WeakReference)localObject));
  }
  
  public boolean a()
  {
    return false;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.shmsgseq;
  }
  
  public String b()
  {
    return "LIMIT_TYPE_SPECIFY_RED_PACK";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.specify.impl.SpecifyRedPacketAnimMsg
 * JD-Core Version:    0.7.0.1
 */