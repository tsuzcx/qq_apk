package com.tencent.mobileqq.cmshow.brickengine.apollo;

import android.text.TextUtils;
import com.tencent.mobileqq.cmshow.brickengine.resource.util.BKGetResPathUtil;
import com.tencent.mobileqq.cmshow.brickengine.resource.util.BKResUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ApolloRenderInterfaceImpl
  implements IRenderCommInterface, ISetActionInterface
{
  public static String a = "ApolloRenderInterfaceImpl";
  private ApolloRenderDriver b;
  private ApolloRender c;
  
  public ApolloRenderInterfaceImpl(ApolloRenderDriver paramApolloRenderDriver, ApolloRender paramApolloRender)
  {
    this.b = paramApolloRenderDriver;
    this.c = paramApolloRender;
  }
  
  public int a(int paramInt1, int paramInt2, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onSetActions], actionId:");
      localStringBuilder.append(paramInt1);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if ((paramArrayOfString1 != null) && (paramArrayOfString1.length == 2) && (this.b != null))
    {
      int i = 0;
      localObject = new File(BKGetResPathUtil.a(paramArrayOfString1[0], "json"));
      if (!((File)localObject).exists())
      {
        if (QLog.isColorLevel())
        {
          paramArrayOfString1 = a;
          paramArrayOfString2 = new StringBuilder();
          paramArrayOfString2.append("errInfo->rsc NOT exist. rscFile:");
          paramArrayOfString2.append(localObject);
          QLog.d(paramArrayOfString1, 2, paramArrayOfString2.toString());
        }
        return 2;
      }
      if ((paramArrayOfString2 != null) && (paramArrayOfString2.length == 2))
      {
        localObject = new File(BKGetResPathUtil.a(paramArrayOfString2[0], "json"));
        if (!((File)localObject).exists())
        {
          if (QLog.isColorLevel())
          {
            paramArrayOfString1 = a;
            paramArrayOfString2 = new StringBuilder();
            paramArrayOfString2.append("errInfo->rsc NOT exist. rscFile:");
            paramArrayOfString2.append(localObject);
            QLog.d(paramArrayOfString1, 2, paramArrayOfString2.toString());
          }
          return 2;
        }
      }
      localObject = this.b;
      if (localObject != null) {
        i = ((ApolloRenderDriver)localObject).a(paramInt1, paramInt2, paramArrayOfString1, paramArrayOfString2);
      }
      return i;
    }
    return 1;
  }
  
  public int a(int paramInt1, String paramString, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    boolean bool = QLog.isColorLevel();
    int i = 0;
    if (bool) {
      QLog.d(a, 2, new Object[] { "[onLoadRole] roleType=", Integer.valueOf(paramInt1), ", apolloId=", paramString, ", roleId=", Integer.valueOf(paramInt2), ", roleScale=", Float.valueOf(paramFloat1), ", xPos=", Float.valueOf(paramFloat2), ", yPos=", Float.valueOf(paramFloat3) });
    }
    if (!BKResUtil.c(paramInt2))
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "errInfo->role rsc NOT exist.");
      }
      return 2;
    }
    ApolloRenderDriver localApolloRenderDriver = this.b;
    if (localApolloRenderDriver != null)
    {
      i = localApolloRenderDriver.a(paramInt1, paramString, paramInt2, paramFloat1, paramFloat2, paramFloat3);
      this.b.a();
    }
    return i;
  }
  
  public int a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    boolean bool = QLog.isColorLevel();
    int i = 0;
    if (bool) {
      QLog.d(a, 2, new Object[] { "[onExecAction] apolloId=", paramString1, ", actionId=", Integer.valueOf(paramInt2), ", roleType=", Integer.valueOf(paramInt1), ", actionId=", Integer.valueOf(paramInt2), ", taskId=", Integer.valueOf(paramInt3), ", actionRscName=", paramString2, ", animName=", paramString3 });
    }
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (this.b != null))
    {
      Object localObject = new File(BKGetResPathUtil.a(paramString2, "json"));
      if (!((File)localObject).exists())
      {
        if (QLog.isColorLevel())
        {
          paramString1 = a;
          paramString2 = new StringBuilder();
          paramString2.append("errInfo->rsc NOT exist. rscFile:");
          paramString2.append(localObject);
          QLog.d(paramString1, 2, paramString2.toString());
        }
        return 2;
      }
      if (this.b != null)
      {
        localObject = this.c;
        if (localObject != null) {
          ((ApolloRender)localObject).mIsFrameMode = false;
        }
        this.b.a();
        i = this.b.a(paramInt1, paramString1, paramInt2, paramInt3, paramString2, paramString3);
      }
      return i;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "errInfo->null param.");
    }
    return 1;
  }
  
  public int a(int paramInt, String paramString, int[] paramArrayOfInt, OnDressDoneListener paramOnDressDoneListener)
  {
    boolean bool = QLog.isColorLevel();
    int j = 0;
    if (bool) {
      QLog.d(a, 2, new Object[] { "[onChangeDress] apolloId=", paramString, ", roleType=", Integer.valueOf(paramInt), ", dressId=", paramArrayOfInt, ", callback=", paramOnDressDoneListener });
    }
    if (paramArrayOfInt == null) {
      return 1;
    }
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      if (!BKResUtil.b(paramArrayOfInt[i]))
      {
        if (QLog.isColorLevel())
        {
          paramString = a;
          paramOnDressDoneListener = new StringBuilder();
          paramOnDressDoneListener.append("errInfo->dress rsc NOT exist, id:");
          paramOnDressDoneListener.append(paramArrayOfInt[i]);
          QLog.d(paramString, 2, paramOnDressDoneListener.toString());
        }
        return 2;
      }
      i += 1;
    }
    ApolloRenderDriver localApolloRenderDriver = this.b;
    i = j;
    if (localApolloRenderDriver != null)
    {
      i = localApolloRenderDriver.a(paramInt, paramString, paramArrayOfInt, paramOnDressDoneListener);
      this.b.a();
    }
    return i;
  }
  
  public void a()
  {
    ApolloRenderDriver localApolloRenderDriver = this.b;
    if (localApolloRenderDriver != null) {
      localApolloRenderDriver.d();
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    ApolloRenderDriver localApolloRenderDriver = this.b;
    if (localApolloRenderDriver != null) {
      localApolloRenderDriver.a(paramInt, paramString1, paramString2);
    }
  }
  
  public void a(long paramLong)
  {
    ApolloRenderDriver localApolloRenderDriver = this.b;
    if (localApolloRenderDriver != null) {
      localApolloRenderDriver.a(paramLong);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, new Object[] { "[onExecDispose] apolloId=", paramString });
    }
    if ((this.b != null) && (!TextUtils.isEmpty(paramString))) {
      this.b.a(paramString);
    }
  }
  
  public int b(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    ApolloRenderDriver localApolloRenderDriver = this.b;
    if (localApolloRenderDriver != null) {
      return localApolloRenderDriver.b(paramInt1, paramString1, paramInt2, paramInt3, paramString2, paramString3);
    }
    return 1;
  }
  
  public void b()
  {
    ApolloRenderDriver localApolloRenderDriver = this.b;
    if (localApolloRenderDriver != null) {
      localApolloRenderDriver.a();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "[onDestroy]");
    }
    ApolloRenderDriver localApolloRenderDriver = this.b;
    if (localApolloRenderDriver != null) {
      localApolloRenderDriver.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */