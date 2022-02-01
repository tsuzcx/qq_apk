package com.tencent.mobileqq.qqexpand.match;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqexpand.bean.match.MatchInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LimitChatProtoStateMachine
  implements Handler.Callback
{
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BaseStateHandler jdField_a_of_type_ComTencentMobileqqQqexpandMatchBaseStateHandler = null;
  private IdleStateHandler jdField_a_of_type_ComTencentMobileqqQqexpandMatchIdleStateHandler;
  LimitChatProtoStateMachine.LimitChatMachineListener jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine$LimitChatMachineListener;
  private MatchingStateHandler jdField_a_of_type_ComTencentMobileqqQqexpandMatchMatchingStateHandler;
  public final String a;
  private final Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  protected boolean a;
  
  public LimitChatProtoStateMachine(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = "ExtendFriendLimitChatStateMachine";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchIdleStateHandler = new IdleStateHandler(this, 100);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchMatchingStateHandler = new MatchingStateHandler(this, 101);
    a(100, null);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public void a(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0)
    {
      QLog.e("ExtendFriendLimitChatStateMachine", 2, "requestmatch with wrong id");
      i = 1;
    }
    Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, i, i).sendToTarget();
  }
  
  public void a(int paramInt, MatchInfo paramMatchInfo)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    if ((paramInt == 100) || (paramInt == 101)) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchBaseStateHandler = this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchMatchingStateHandler;
      break label43;
      this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchBaseStateHandler = this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchIdleStateHandler;
      label43:
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setStatus  ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("ExtendFriendLimitChatStateMachine", 2, ((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchBaseStateHandler;
      if (localObject != null) {
        ((BaseStateHandler)localObject).b(paramMatchInfo);
      }
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void a(LimitChatProtoStateMachine.LimitChatMachineListener paramLimitChatMachineListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchLimitChatProtoStateMachine$LimitChatMachineListener = paramLimitChatMachineListener;
  }
  
  public void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(boolean paramBoolean, int paramInt, MatchInfo paramMatchInfo, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(boolean paramBoolean, MatchInfo paramMatchInfo)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchIdleStateHandler;
    if (localObject != null)
    {
      ((IdleStateHandler)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchIdleStateHandler = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchMatchingStateHandler;
    if (localObject != null)
    {
      ((MatchingStateHandler)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchMatchingStateHandler = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchBaseStateHandler = null;
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendLimitChatStateMachine", 2, "machine Clear ");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchBaseStateHandler == null) {
      return true;
    }
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        MatchInfo localMatchInfo = null;
        boolean bool2 = false;
        boolean bool1 = false;
        if (i != 4)
        {
          if (i != 6)
          {
            if (i != 7) {
              return true;
            }
            if (paramMessage.arg1 == 1) {
              bool1 = true;
            }
            this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchBaseStateHandler.a(bool1);
            return true;
          }
          bool1 = bool2;
          if (paramMessage.arg1 == 1) {
            bool1 = true;
          }
          if (paramMessage.obj != null) {
            localMatchInfo = (MatchInfo)paramMessage.obj;
          }
          this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchBaseStateHandler.a(bool1, localMatchInfo);
          return true;
        }
        if (paramMessage.arg1 == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if ((paramMessage.obj != null) && ((paramMessage.obj instanceof Object[])))
        {
          Object localObject = (Object[])paramMessage.obj;
          if ((localObject != null) && (localObject.length == 2))
          {
            localMatchInfo = (MatchInfo)localObject[0];
            localObject = (String)localObject[1];
            this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchBaseStateHandler.a(bool1, paramMessage.arg2, localMatchInfo, (String)localObject);
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchBaseStateHandler.a(bool1, paramMessage.arg2, null, null);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchBaseStateHandler.a(bool1, paramMessage.arg2, null, null);
          QLog.e("ExtendFriendLimitChatStateMachine", 2, "CS_RESPONSE_MSG obj err");
        }
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendLimitChatStateMachine", 2, "CS_RESPONSE_MSG mIsGetMatchInfoWaitingHandle");
        }
        this.jdField_a_of_type_Boolean = false;
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchBaseStateHandler.a();
      return true;
    }
    i = paramMessage.arg1;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandMatchBaseStateHandler.a(i);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.match.LimitChatProtoStateMachine
 * JD-Core Version:    0.7.0.1
 */