package com.tencent.mobileqq.cmshow.brickengine.apollo;

import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.render.IApolloRunnableTask;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.task.OnDressDoneListener;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.script.ScriptUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApolloRenderDriver
  implements Handler.Callback, IRenderCommInterface, ISetActionInterface
{
  public int a;
  public ApolloEngine a;
  ITriggerRenderCallback jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloITriggerRenderCallback;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  public AtomicBoolean a;
  ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
  public int b;
  private AtomicBoolean b;
  
  public ApolloRenderDriver(ITriggerRenderCallback paramITriggerRenderCallback, ApolloEngine paramApolloEngine)
  {
    this.jdField_a_of_type_Int = 20;
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloRenderDriver", 2, "[ApolloRenderDriver] constructor.");
    }
    if (paramApolloEngine != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloITriggerRenderCallback = paramITriggerRenderCallback;
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloEngine = paramApolloEngine;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = ApolloActionManager.a().a();
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return;
    }
    throw new NullPointerException();
  }
  
  public int a(int paramInt1, int paramInt2, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onSetActions], actionId:");
      localStringBuilder.append(paramInt1);
      QLog.d("[cmshow]ApolloRenderDriver", 2, localStringBuilder.toString());
    }
    if ((paramArrayOfString1 != null) && (paramArrayOfString1.length != 2)) {
      return 1;
    }
    a(new ApolloRenderDriver.1(this, paramInt1, paramInt2, paramArrayOfString1, paramArrayOfString2));
    return 0;
  }
  
  public int a(int paramInt1, String paramString, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(", roleId:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("[cmshow]ApolloRenderDriver", 2, new Object[] { "[onLoadRole] apolloId=", paramString, ", roleType=", Integer.valueOf(paramInt1), ((StringBuilder)localObject).toString() });
    }
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = ApolloUtilImpl.getApolloId(paramInt1);
    }
    paramString = ApolloActionHelperImpl.getRoleScriptString((String)localObject, paramInt2, paramFloat1, paramFloat2, paramFloat3);
    if (TextUtils.isEmpty(paramString)) {
      return 1;
    }
    a(new ApolloRenderDriver.RenderThreadRunnable(this, paramString, this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock, this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloEngine));
    return 0;
  }
  
  public int a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloRenderDriver", 2, new Object[] { "[onExecAction] apolloId=", paramString1, ", actionId=", Integer.valueOf(paramInt2) });
    }
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = ApolloUtilImpl.getApolloId(paramInt1);
    }
    paramString1 = ApolloActionHelperImpl.getActionScriptString(str, paramInt2, paramInt3, paramString2, paramString3);
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloRenderDriver", 2, "errInfo->luaParam is null.");
      }
      return 1;
    }
    a(new ApolloRenderDriver.4(this, paramString1));
    return 0;
  }
  
  public int a(int paramInt, String paramString, int[] paramArrayOfInt, OnDressDoneListener paramOnDressDoneListener)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onChangeDress], roleType:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("[cmshow]ApolloRenderDriver", 2, ((StringBuilder)localObject).toString());
    }
    if (paramArrayOfInt == null) {
      return 1;
    }
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = ApolloUtilImpl.getApolloId(paramInt);
    }
    paramString = ApolloActionHelperImpl.getDressScriptString((String)localObject, paramArrayOfInt);
    if (paramString == null) {
      return 1;
    }
    a(new ApolloRenderDriver.5(this, paramString, paramOnDressDoneListener));
    return 0;
  }
  
  public void a()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[startLoop]. mIsLoopStart:");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      QLog.d("[cmshow]ApolloRenderDriver", 2, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null) && (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(15);
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[startLoop]. ticker Loop: gameId=");
        localStringBuilder.append(this.jdField_b_of_type_Int);
        localStringBuilder.append(" view=");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloITriggerRenderCallback);
        QLog.d("[cmshow]ApolloRenderDriver", 2, localStringBuilder.toString());
        a(new ApolloRenderDriver.2(this));
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      }
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onRemoveBubble], roleType");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",bubbleName:");
      localStringBuilder.append(paramString2);
      QLog.d("[cmshow]ApolloRenderDriver", 2, localStringBuilder.toString());
    }
    a(new ApolloRenderDriver.RenderThreadRunnable(this, ScriptUtil.a(paramInt, paramString1, paramString2), this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock, this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloEngine));
  }
  
  public void a(long paramLong)
  {
    WeakReferenceHandler localWeakReferenceHandler = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
    if (localWeakReferenceHandler != null)
    {
      localWeakReferenceHandler.removeMessages(15);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(15, paramLong);
    }
  }
  
  public void a(IApolloRunnableTask paramIApolloRunnableTask)
  {
    if (paramIApolloRunnableTask != null)
    {
      ITriggerRenderCallback localITriggerRenderCallback = this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloITriggerRenderCallback;
      if (localITriggerRenderCallback == null) {
        return;
      }
      if ((localITriggerRenderCallback instanceof ApolloSurfaceView))
      {
        ((ApolloSurfaceView)localITriggerRenderCallback).runRenderTask(paramIApolloRunnableTask);
        return;
      }
      if ((localITriggerRenderCallback instanceof ApolloTextureView)) {
        ((ApolloTextureView)localITriggerRenderCallback).queueEvent(paramIApolloRunnableTask);
      }
    }
  }
  
  public void a(String paramString)
  {
    a(new ApolloRenderDriver.RenderThreadRunnable(this, String.format("if(%s){%s.removeFromParent();%s.dispose();}", new Object[] { paramString, paramString, paramString }), this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock, this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloEngine));
  }
  
  public int b(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloRenderDriver", 2, new Object[] { "[onAddBubble] bubbleType=", Integer.valueOf(paramInt1), ", apolloId=", paramString1, ", roleType=", Integer.valueOf(paramInt2), ", text=", paramString2, ", roleId=", Integer.valueOf(paramInt3), ", uin=", paramString3 });
    }
    if (TextUtils.isEmpty(paramString2)) {
      return 1;
    }
    paramString2 = paramString2.replace("\\", "").replace("'", "");
    if (TextUtils.isEmpty(paramString2)) {
      return 1;
    }
    Object localObject = Pattern.compile("\t|\r|\n").matcher(paramString2);
    if (localObject != null) {
      paramString2 = ((Matcher)localObject).replaceAll("");
    }
    int i = paramString2.length();
    localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      localObject = (QQAppInterface)localObject;
    } else {
      localObject = null;
    }
    if ((1 == paramInt1) && (localObject != null))
    {
      ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)((QQAppInterface)localObject).getRuntimeService(IApolloManagerService.class, "all");
      if (paramString3.equals(((QQAppInterface)localObject).getCurrentAccountUin()))
      {
        paramString2 = HardCodeUtil.a(2131700736);
        if ((localApolloManagerServiceImpl != null) && (localApolloManagerServiceImpl.getAVIPStatus(paramString3)))
        {
          if ((1 == paramInt2) && ((ApolloUtilImpl.isBubbleRscExist(0, 28)) || (ApolloUtilImpl.isBubbleRscExist(paramInt3, 28))))
          {
            paramInt1 = 28;
            break label589;
          }
          paramString3 = paramString2;
          if (2 == paramInt2) {
            if (!ApolloUtilImpl.isBubbleRscExist(0, 27))
            {
              paramString3 = paramString2;
              if (!ApolloUtilImpl.isBubbleRscExist(paramInt3, 27)) {}
            }
            else
            {
              paramInt1 = 27;
              break label589;
            }
          }
        }
        else
        {
          paramInt1 = 25;
          break label589;
        }
      }
      else
      {
        if ((localApolloManagerServiceImpl == null) || (!localApolloManagerServiceImpl.getAVIPStatus(paramString3))) {
          break label418;
        }
        if ((1 == paramInt2) && ((ApolloUtilImpl.isBubbleRscExist(0, 30)) || (ApolloUtilImpl.isBubbleRscExist(paramInt3, 30))))
        {
          paramInt1 = 30;
          break label589;
        }
        paramString3 = paramString2;
        if (2 == paramInt2) {
          if (!ApolloUtilImpl.isBubbleRscExist(0, 29))
          {
            paramString3 = paramString2;
            if (!ApolloUtilImpl.isBubbleRscExist(paramInt3, 29)) {}
          }
          else
          {
            paramInt1 = 29;
            break label589;
          }
        }
      }
      paramInt1 = 0;
      paramString2 = paramString3;
      break label589;
      label418:
      paramInt1 = 26;
    }
    else if ((paramInt1 != 0) && (8 != paramInt1))
    {
      if (2 == paramInt1)
      {
        paramString3 = paramString2;
        if (i > 8)
        {
          paramString3 = new StringBuilder();
          paramString3.append(paramString2.substring(0, 7));
          paramString3.append("…");
          paramString3 = paramString3.toString();
        }
        paramInt1 = 16;
        paramString2 = paramString3;
      }
      else
      {
        if (3 == paramInt1) {}
        do
        {
          paramInt1 = 32;
          break;
          if (4 == paramInt1)
          {
            paramInt1 = ApolloUtilImpl.handleAITextType(157.0F, paramString2);
            break;
          }
          if (5 == paramInt1)
          {
            paramInt1 = 40;
            break;
          }
          if (6 == paramInt1)
          {
            paramInt1 = 33;
            break;
          }
        } while (7 == paramInt1);
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloRenderDriver", 2, "Other bubble type, NOT Handle.");
        }
        return 1;
      }
    }
    else
    {
      paramInt1 = ApolloUtilImpl.handleBubbleType(208.0F, paramString2, 1);
    }
    label589:
    if ((!ApolloUtilImpl.isBubbleRscExist(paramInt3, paramInt1)) && (!ApolloUtilImpl.isBubbleRscExist(0, paramInt1))) {
      return 2;
    }
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = ApolloUtilImpl.getApolloId(paramInt2);
    }
    paramString1 = ApolloActionHelperImpl.getBubbleScriptString(paramString1, paramInt1, paramInt3, paramString2);
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloRenderDriver", 2, "errInfo->luaParam is NULL.");
      }
      return 1;
    }
    a(new ApolloRenderDriver.RenderThreadRunnable(this, paramString1, this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock, this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloEngine));
    return 0;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloRenderDriver", 2, "[stopLoop].");
    }
    if ((this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(15);
      a(new ApolloRenderDriver.3(this));
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onEnterGame], luaFilePath:");
      localStringBuilder.append(paramString);
      QLog.d("[cmshow]ApolloRenderDriver", 2, localStringBuilder.toString());
    }
    a(new ApolloRenderDriver.7(this, paramString));
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloRenderDriver", 2, "[onDestroy]");
    }
    b();
    Object localObject = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
    if (localObject != null)
    {
      ((WeakReferenceHandler)localObject).removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = null;
      localObject = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
      if (localObject != null) {
        ((AtomicBoolean)localObject).set(false);
      }
    }
  }
  
  public void d()
  {
    a(new ApolloRenderDriver.RenderThreadRunnable(this, "dispose();", this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock, this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloEngine));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 15) {
      b();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderDriver
 * JD-Core Version:    0.7.0.1
 */