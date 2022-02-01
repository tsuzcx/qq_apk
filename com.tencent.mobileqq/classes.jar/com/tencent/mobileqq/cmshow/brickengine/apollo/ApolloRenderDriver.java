package com.tencent.mobileqq.cmshow.brickengine.apollo;

import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.script.ScriptUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApolloRenderDriver
  implements Handler.Callback, IRenderCommInterface, ISetActionInterface
{
  ITriggerRenderCallback a;
  public ApolloEngine b;
  ReentrantLock c;
  WeakReferenceHandler d;
  public int e = 20;
  public AtomicBoolean f = new AtomicBoolean(false);
  public int g;
  private AtomicBoolean h = new AtomicBoolean(false);
  
  public ApolloRenderDriver(ITriggerRenderCallback paramITriggerRenderCallback, ApolloEngine paramApolloEngine)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloRenderDriver", 2, "[ApolloRenderDriver] constructor.");
    }
    if (paramApolloEngine != null)
    {
      this.a = paramITriggerRenderCallback;
      this.b = paramApolloEngine;
      this.d = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
      this.c = ApolloRender.getLock();
      this.h.set(true);
      return;
    }
    throw new NullPointerException();
  }
  
  private int a(int paramInt1, int paramInt2, String paramString, int paramInt3, QQAppInterface paramQQAppInterface)
  {
    ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    int i;
    if (paramString.equals(paramQQAppInterface.getCurrentAccountUin()))
    {
      if ((localApolloManagerServiceImpl != null) && (localApolloManagerServiceImpl.getAVIPStatus(paramString)))
      {
        if ((1 == paramInt1) && ((ApolloUtilImpl.isBubbleRscExist(0, 28)) || (ApolloUtilImpl.isBubbleRscExist(paramInt2, 28)))) {
          return 28;
        }
        i = paramInt3;
        if (2 == paramInt1) {
          if (!ApolloUtilImpl.isBubbleRscExist(0, 27))
          {
            i = paramInt3;
            if (!ApolloUtilImpl.isBubbleRscExist(paramInt2, 27)) {}
          }
          else
          {
            return 27;
          }
        }
      }
      else
      {
        return 25;
      }
    }
    else if ((localApolloManagerServiceImpl != null) && (localApolloManagerServiceImpl.getAVIPStatus(paramString)))
    {
      if ((1 == paramInt1) && ((ApolloUtilImpl.isBubbleRscExist(0, 30)) || (ApolloUtilImpl.isBubbleRscExist(paramInt2, 30)))) {
        return 30;
      }
      i = paramInt3;
      if (2 == paramInt1) {
        if (!ApolloUtilImpl.isBubbleRscExist(0, 29))
        {
          i = paramInt3;
          if (!ApolloUtilImpl.isBubbleRscExist(paramInt2, 29)) {}
        }
        else
        {
          return 29;
        }
      }
    }
    else
    {
      i = 26;
    }
    return i;
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
    a(new ApolloRenderDriver.RenderThreadRunnable(this, paramString, this.c, this.b));
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
      localStringBuilder.append(this.f.get());
      QLog.d("[cmshow]ApolloRenderDriver", 2, localStringBuilder.toString());
    }
    if ((this.d != null) && (this.h.get()))
    {
      this.d.removeMessages(15);
      if (!this.f.get())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[startLoop]. ticker Loop: gameId=");
        localStringBuilder.append(this.g);
        localStringBuilder.append(" view=");
        localStringBuilder.append(this.a);
        QLog.d("[cmshow]ApolloRenderDriver", 2, localStringBuilder.toString());
        a(new ApolloRenderDriver.2(this));
        this.f.set(true);
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
    a(new ApolloRenderDriver.RenderThreadRunnable(this, ScriptUtils.a(paramInt, paramString1, paramString2), this.c, this.b));
  }
  
  public void a(long paramLong)
  {
    WeakReferenceHandler localWeakReferenceHandler = this.d;
    if (localWeakReferenceHandler != null)
    {
      localWeakReferenceHandler.removeMessages(15);
      this.d.sendEmptyMessageDelayed(15, paramLong);
    }
  }
  
  public void a(IApolloRunnableTask paramIApolloRunnableTask)
  {
    if (paramIApolloRunnableTask != null)
    {
      ITriggerRenderCallback localITriggerRenderCallback = this.a;
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
    a(new ApolloRenderDriver.RenderThreadRunnable(this, String.format("if(%s){%s.removeFromParent();%s.dispose();}", new Object[] { paramString, paramString, paramString }), this.c, this.b));
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
    int j = paramString2.length();
    localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      localObject = (QQAppInterface)localObject;
    } else {
      localObject = null;
    }
    int i = 32;
    if ((1 == paramInt1) && (localObject != null))
    {
      if (paramString3.equals(((QQAppInterface)localObject).getCurrentAccountUin())) {
        paramString2 = HardCodeUtil.a(2131898762);
      }
      paramInt1 = a(paramInt2, paramInt3, paramString3, 0, (QQAppInterface)localObject);
    }
    else if ((paramInt1 != 0) && (8 != paramInt1))
    {
      if (2 == paramInt1)
      {
        paramString3 = paramString2;
        if (j > 8)
        {
          paramString3 = new StringBuilder();
          paramString3.append(paramString2.substring(0, 7));
          paramString3.append("…");
          paramString3 = paramString3.toString();
        }
        paramInt1 = 16;
        paramString2 = paramString3;
      }
      else if (3 == paramInt1)
      {
        paramInt1 = i;
      }
      else if (4 == paramInt1)
      {
        paramInt1 = ApolloUtilImpl.handleAITextType(157.0F, paramString2);
      }
      else if (5 == paramInt1)
      {
        paramInt1 = 40;
      }
      else if (6 == paramInt1)
      {
        paramInt1 = 33;
      }
      else if (7 == paramInt1)
      {
        paramInt1 = i;
      }
      else
      {
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
    a(new ApolloRenderDriver.RenderThreadRunnable(this, paramString1, this.c, this.b));
    return 0;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloRenderDriver", 2, "[stopLoop].");
    }
    if ((this.d != null) && (this.f.get()))
    {
      this.d.removeMessages(15);
      a(new ApolloRenderDriver.3(this));
      this.f.set(false);
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onEnterGame], scriptFilePath:");
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
    Object localObject = this.d;
    if (localObject != null)
    {
      ((WeakReferenceHandler)localObject).removeCallbacksAndMessages(null);
      this.d = null;
      localObject = this.h;
      if (localObject != null) {
        ((AtomicBoolean)localObject).set(false);
      }
    }
  }
  
  public void d()
  {
    a(new ApolloRenderDriver.RenderThreadRunnable(this, "dispose();", this.c, this.b));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 15) {
      b();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderDriver
 * JD-Core Version:    0.7.0.1
 */