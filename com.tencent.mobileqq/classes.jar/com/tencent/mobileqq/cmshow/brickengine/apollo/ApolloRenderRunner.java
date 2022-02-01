package com.tencent.mobileqq.cmshow.brickengine.apollo;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.apollo.render.IRenderRunner;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ApolloRenderRunner
{
  private List<WeakReference<IRenderRunner>> a = new ArrayList();
  
  public IRenderRunner a()
  {
    try
    {
      int i = this.a.size();
      Object localObject3 = new ArrayList();
      i -= 1;
      Object localObject1;
      while (i >= 0)
      {
        Object localObject4 = (WeakReference)this.a.get(i);
        if (localObject4 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("apollochannel_JsRenderRunner", 2, "getRunningRenderRunner apolloViewWeakReference is null");
          }
        }
        else
        {
          localObject1 = (IRenderRunner)((WeakReference)localObject4).get();
          if (localObject1 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("apollochannel_JsRenderRunner", 2, "getRunningRenderRunner apolloSurfaceView is null");
            }
            ((List)localObject3).add(localObject4);
          }
          else if (((localObject1 instanceof View)) && (((View)localObject1).getVisibility() == 0))
          {
            if (QLog.isColorLevel())
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("getRunningRenderRunner find renderTask:");
              ((StringBuilder)localObject4).append(localObject1);
              QLog.d("apollochannel_JsRenderRunner", 2, ((StringBuilder)localObject4).toString());
            }
            if (!((List)localObject3).isEmpty())
            {
              this.a.removeAll((Collection)localObject3);
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("mRenderRunners.removeAll(invalidRunners):");
                ((StringBuilder)localObject3).append(this.a.size());
                QLog.d("apollochannel_JsRenderRunner", 2, ((StringBuilder)localObject3).toString());
              }
            }
            return localObject1;
          }
        }
        i -= 1;
      }
      if (!((List)localObject3).isEmpty())
      {
        this.a.removeAll((Collection)localObject3);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("mRenderRunners.removeAll(invalidRunners):");
          ((StringBuilder)localObject1).append(this.a.size());
          QLog.d("apollochannel_JsRenderRunner", 2, ((StringBuilder)localObject1).toString());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_JsRenderRunner", 2, "getRunningRenderRunner not find");
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public IRenderRunner a(int paramInt)
  {
    try
    {
      int i = this.a.size();
      Object localObject3 = new ArrayList();
      i -= 1;
      Object localObject1;
      while (i >= 0)
      {
        Object localObject4 = (WeakReference)this.a.get(i);
        if (localObject4 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("apollochannel_JsRenderRunner", 2, "getRunningRenderRunner apolloViewWeakReference is null");
          }
        }
        else
        {
          localObject1 = (IRenderRunner)((WeakReference)localObject4).get();
          if (localObject1 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("apollochannel_JsRenderRunner", 2, "getRunningRenderRunner apolloSurfaceView is null");
            }
            ((List)localObject3).add(localObject4);
          }
          else if (((localObject1 instanceof ApolloSurfaceView)) && (((ApolloSurfaceView)localObject1).getGameId() == paramInt))
          {
            if (QLog.isColorLevel())
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("getRunningRenderRunner find renderTask:");
              ((StringBuilder)localObject4).append(localObject1);
              QLog.d("apollochannel_JsRenderRunner", 2, ((StringBuilder)localObject4).toString());
            }
            if (!((List)localObject3).isEmpty())
            {
              this.a.removeAll((Collection)localObject3);
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("mRenderRunners.removeAll(invalidRunners):");
                ((StringBuilder)localObject3).append(this.a.size());
                QLog.d("apollochannel_JsRenderRunner", 2, ((StringBuilder)localObject3).toString());
              }
            }
            return localObject1;
          }
        }
        i -= 1;
      }
      if (!((List)localObject3).isEmpty())
      {
        this.a.removeAll((Collection)localObject3);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("mRenderRunners.removeAll(invalidRunners):");
          ((StringBuilder)localObject1).append(this.a.size());
          QLog.d("apollochannel_JsRenderRunner", 2, ((StringBuilder)localObject1).toString());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_JsRenderRunner", 2, "getRunningRenderRunner not find");
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public IRenderRunner a(long paramLong)
  {
    try
    {
      Object localObject3 = new ArrayList();
      Object localObject4 = this.a.iterator();
      Object localObject1;
      while (((Iterator)localObject4).hasNext())
      {
        Object localObject5 = (WeakReference)((Iterator)localObject4).next();
        if (localObject5 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerJsContext apolloViewWeakReference is null");
          }
        }
        else
        {
          localObject1 = (IRenderRunner)((WeakReference)localObject5).get();
          if (localObject1 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerJsContext apolloSurfaceView is null");
            }
            ((List)localObject3).add(localObject5);
          }
          else
          {
            long l = ((IRenderRunner)localObject1).getLuaState();
            if (QLog.isColorLevel())
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("getRenderRunnerJsContext getLuaState:");
              ((StringBuilder)localObject5).append(l);
              QLog.d("apollochannel_JsRenderRunner", 2, ((StringBuilder)localObject5).toString());
            }
            if (paramLong == l)
            {
              if (QLog.isColorLevel())
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("getRenderRunnerJsContext find getLuaState:");
                ((StringBuilder)localObject4).append(l);
                QLog.d("apollochannel_JsRenderRunner", 2, ((StringBuilder)localObject4).toString());
              }
              if (!((List)localObject3).isEmpty())
              {
                this.a.removeAll((Collection)localObject3);
                if (QLog.isColorLevel())
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("mRenderRunners.removeAll(invalidRunners):");
                  ((StringBuilder)localObject3).append(this.a.size());
                  QLog.d("apollochannel_JsRenderRunner", 2, ((StringBuilder)localObject3).toString());
                }
              }
              return localObject1;
            }
          }
        }
      }
      if (!((List)localObject3).isEmpty())
      {
        this.a.removeAll((Collection)localObject3);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("mRenderRunners.removeAll(invalidRunners):");
          ((StringBuilder)localObject1).append(this.a.size());
          QLog.d("apollochannel_JsRenderRunner", 2, ((StringBuilder)localObject1).toString());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerJsContext not find");
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a()
  {
    try
    {
      this.a.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(IRenderRunner paramIRenderRunner)
  {
    if (paramIRenderRunner == null) {
      return;
    }
    try
    {
      Object localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
        if ((localWeakReference != null) && (paramIRenderRunner == localWeakReference.get()))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("addRunner has add the same iRenderRunner:");
            ((StringBuilder)localObject).append(paramIRenderRunner);
            QLog.d("apollochannel_JsRenderRunner", 2, ((StringBuilder)localObject).toString());
          }
          return;
        }
      }
      this.a.add(new WeakReference(paramIRenderRunner));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("addRunner iRenderRunner:");
        ((StringBuilder)localObject).append(paramIRenderRunner);
        ((StringBuilder)localObject).append(", size: ");
        ((StringBuilder)localObject).append(this.a);
        QLog.d("apollochannel_JsRenderRunner", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramIRenderRunner;
    }
  }
  
  public void a(ApolloCmdChannel paramApolloCmdChannel, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("callbackEngine cmd:");
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append(",respData:");
        ((StringBuilder)localObject1).append(paramString2);
        QLog.d("apollochannel_JsRenderRunner", 2, ((StringBuilder)localObject1).toString());
      }
      if (paramApolloCmdChannel == null) {
        return;
      }
      boolean bool = TextUtils.isEmpty(paramString2);
      if (bool) {
        return;
      }
      Object localObject1 = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (WeakReference)localIterator.next();
        if (localObject2 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("apollochannel_JsRenderRunner", 2, "callbackEngine apolloViewWeakReference is null");
          }
        }
        else
        {
          IRenderRunner localIRenderRunner = (IRenderRunner)((WeakReference)localObject2).get();
          if (localIRenderRunner == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("apollochannel_JsRenderRunner", 2, "callbackEngine apolloSurfaceView is null");
            }
            ((List)localObject1).add(localObject2);
          }
          else
          {
            long l = localIRenderRunner.getLuaState();
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("callbackEngine getLuaState runtimeState:");
              ((StringBuilder)localObject2).append(l);
              QLog.d("apollochannel_JsRenderRunner", 2, ((StringBuilder)localObject2).toString());
            }
            if (paramLong == l)
            {
              localIRenderRunner.runRenderTask(new ApolloRenderRunner.1(this, localIRenderRunner, paramLong, paramApolloCmdChannel, paramInt, paramString1, paramString2));
              if (!QLog.isColorLevel()) {
                break;
              }
              paramApolloCmdChannel = new StringBuilder();
              paramApolloCmdChannel.append("callbackEngine getRenderRunner find runtimeState:");
              paramApolloCmdChannel.append(l);
              QLog.d("apollochannel_JsRenderRunner", 2, paramApolloCmdChannel.toString());
              break;
            }
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("lState != apolloSurfaceView.getLuaState(), renderThreadId:");
              ((StringBuilder)localObject2).append(localIRenderRunner.getLuaState());
              QLog.d("apollochannel_JsRenderRunner", 2, ((StringBuilder)localObject2).toString());
            }
          }
        }
      }
      if (!((List)localObject1).isEmpty())
      {
        this.a.removeAll((Collection)localObject1);
        if (QLog.isColorLevel())
        {
          paramApolloCmdChannel = new StringBuilder();
          paramApolloCmdChannel.append("after mRenderRunners.removeAll(invalidRunners):");
          paramApolloCmdChannel.append(this.a.size());
          QLog.d("apollochannel_JsRenderRunner", 2, paramApolloCmdChannel.toString());
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramApolloCmdChannel;
    }
  }
  
  public IRenderRunner b(long paramLong)
  {
    try
    {
      Object localObject3 = new ArrayList();
      Object localObject4 = this.a.iterator();
      Object localObject1;
      while (((Iterator)localObject4).hasNext())
      {
        Object localObject5 = (WeakReference)((Iterator)localObject4).next();
        if (localObject5 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerByThreadId apolloViewWeakReference is null");
          }
        }
        else
        {
          localObject1 = (IRenderRunner)((WeakReference)localObject5).get();
          if (localObject1 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerByThreadId apolloSurfaceView is null");
            }
            ((List)localObject3).add(localObject5);
          }
          else
          {
            long l = ((IRenderRunner)localObject1).getRenderThreadId();
            if (QLog.isColorLevel())
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("getRenderRunnerByThreadId getRenderThreadId:");
              ((StringBuilder)localObject5).append(l);
              QLog.d("apollochannel_JsRenderRunner", 2, ((StringBuilder)localObject5).toString());
            }
            if (paramLong == l)
            {
              if (QLog.isColorLevel())
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("getRenderRunnerByThreadId find getRenderThreadId:");
                ((StringBuilder)localObject4).append(l);
                QLog.d("apollochannel_JsRenderRunner", 2, ((StringBuilder)localObject4).toString());
              }
              if (!((List)localObject3).isEmpty())
              {
                this.a.removeAll((Collection)localObject3);
                if (QLog.isColorLevel())
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("mRenderRunners.removeAll(invalidRunners):");
                  ((StringBuilder)localObject3).append(this.a.size());
                  QLog.d("apollochannel_JsRenderRunner", 2, ((StringBuilder)localObject3).toString());
                }
              }
              return localObject1;
            }
          }
        }
      }
      if (!((List)localObject3).isEmpty())
      {
        this.a.removeAll((Collection)localObject3);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("mRenderRunners.removeAll(invalidRunners):");
          ((StringBuilder)localObject1).append(this.a.size());
          QLog.d("apollochannel_JsRenderRunner", 2, ((StringBuilder)localObject1).toString());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_JsRenderRunner", 2, "getRenderRunnerByThreadId not find");
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void b(IRenderRunner paramIRenderRunner)
  {
    if (paramIRenderRunner == null) {
      return;
    }
    try
    {
      Object localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
        if ((localWeakReference != null) && (paramIRenderRunner == localWeakReference.get()))
        {
          ((Iterator)localObject).remove();
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("removeRunner find it:");
            ((StringBuilder)localObject).append(paramIRenderRunner);
            QLog.d("apollochannel_JsRenderRunner", 2, ((StringBuilder)localObject).toString());
          }
          return;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("removeRunner not find it:");
        ((StringBuilder)localObject).append(paramIRenderRunner);
        QLog.d("apollochannel_JsRenderRunner", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramIRenderRunner;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderRunner
 * JD-Core Version:    0.7.0.1
 */