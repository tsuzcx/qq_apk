package com.tencent.mobileqq.cmshow.brickengine.resource;

import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.brickengine.resource.downloader.BKResourceDownloader;
import com.tencent.mobileqq.cmshow.brickengine.resource.util.BKGetResPathUtil;
import com.tencent.mobileqq.cmshow.brickengine.resource.util.BKResUtil;
import com.tencent.mobileqq.cmshow.engine.EngineType;
import com.tencent.mobileqq.cmshow.engine.resource.AbsApolloResManager;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResDownloaderFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public class BKResourceManager
  extends AbsApolloResManager
{
  private static final String[] e = { "/def/role/0/sayhi/1/action/action.json", "/def/role/0/friendcard/1/action/action.json", "/def/role/0/3D/sayhi/1/action.bin", "/def/role/0/3D/3DConfig.json" };
  private IApolloResDownloader d;
  
  @NotNull
  public IApolloResDownloader a()
  {
    if (this.d == null)
    {
      BKResourceDownloader localBKResourceDownloader = new BKResourceDownloader();
      ApolloResDownloaderFacade.a.a(EngineType.BK, localBKResourceDownloader);
      this.d = localBKResourceDownloader;
    }
    return this.d;
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    return BKResUtil.a(paramInt1, paramInt2);
  }
  
  @NotNull
  public String a(ApolloActionData paramApolloActionData, int paramInt)
  {
    return BKGetResPathUtil.a(paramApolloActionData, paramInt);
  }
  
  public String a(@NotNull String paramString1, @NotNull String paramString2)
  {
    return BKGetResPathUtil.a(paramString1, paramString2);
  }
  
  public void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2) {}
  
  public boolean a(int paramInt)
  {
    return BKResUtil.b(paramInt);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    return BKResUtil.a(paramInt1, paramInt2, paramInt3, paramBoolean);
  }
  
  public boolean a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    return BKResUtil.a(paramInt1, paramBoolean1, paramInt2, paramBoolean2);
  }
  
  public boolean a(@NotNull ApolloActionData paramApolloActionData)
  {
    return BKResUtil.a(paramApolloActionData);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    String[] arrayOfString = e;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfString[i];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ApolloConstant.a);
      localStringBuilder.append((String)localObject);
      localObject = new File(localStringBuilder.toString());
      if (!((File)localObject).exists())
      {
        QLog.d("[cmshow]cm_res", 1, new Object[] { "[checkBasicActionExit] rsc file not exist:", ((File)localObject).toString() });
        a().a(paramQQAppInterface, paramQQAppInterface.getCurrentUin(), null, 0, null, -1, -1, true);
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public boolean a(@NotNull String paramString)
  {
    return BKResUtil.a(paramString);
  }
  
  public String b(String paramString)
  {
    return BKGetResPathUtil.a(paramString);
  }
  
  public boolean b(int paramInt)
  {
    return BKResUtil.c(paramInt);
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    return BKResUtil.d(paramInt1, paramInt2);
  }
  
  public String c(int paramInt)
  {
    return BKGetResPathUtil.b(paramInt);
  }
  
  public String c(String paramString)
  {
    return BKGetResPathUtil.b(paramString);
  }
  
  public boolean c(int paramInt1, int paramInt2)
  {
    return BKResUtil.b(paramInt1, paramInt2);
  }
  
  public String d(int paramInt)
  {
    return BKResUtil.e(paramInt);
  }
  
  public String d(int paramInt1, int paramInt2)
  {
    return BKGetResPathUtil.a(paramInt1, paramInt2);
  }
  
  public String e(int paramInt)
  {
    return BKGetResPathUtil.d(paramInt);
  }
  
  public boolean e(int paramInt1, int paramInt2)
  {
    return BKResUtil.c(paramInt1, paramInt2);
  }
  
  public String f(int paramInt)
  {
    return BKResUtil.d(paramInt);
  }
  
  public boolean f(int paramInt1, int paramInt2)
  {
    return BKResUtil.e(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.resource.BKResourceManager
 * JD-Core Version:    0.7.0.1
 */