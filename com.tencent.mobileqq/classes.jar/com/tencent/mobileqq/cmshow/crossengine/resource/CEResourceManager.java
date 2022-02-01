package com.tencent.mobileqq.cmshow.crossengine.resource;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.crossengine.resource.downloader.CEResourceDownloader;
import com.tencent.mobileqq.cmshow.crossengine.resource.util.CEGetResPathUtil;
import com.tencent.mobileqq.cmshow.crossengine.resource.util.CEResUtil;
import com.tencent.mobileqq.cmshow.engine.EngineType;
import com.tencent.mobileqq.cmshow.engine.resource.AbsApolloResManager;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResDownloaderFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class CEResourceManager
  extends AbsApolloResManager
{
  private static final String[] e = { "/def/role/0/sayhi/1/action/action.json", "/def/role/0/friendcard/1/action/action.json", "/def/role/0/3D/sayhi/1/info.json", "/def/role/0/3D/friendcard/1/info.json" };
  private IApolloResDownloader d;
  
  @NonNull
  public IApolloResDownloader a()
  {
    if (this.d == null)
    {
      CEResourceDownloader localCEResourceDownloader = new CEResourceDownloader();
      ApolloResDownloaderFacade.a.a(EngineType.CE, localCEResourceDownloader);
      this.d = localCEResourceDownloader;
    }
    return this.d;
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    return CEResUtil.a(paramInt1, paramInt2);
  }
  
  public String a(ApolloActionData paramApolloActionData, int paramInt)
  {
    return CEGetResPathUtil.a(paramApolloActionData, paramInt);
  }
  
  public String a(String paramString1, String paramString2)
  {
    return CEGetResPathUtil.a(paramString1, paramString2);
  }
  
  public boolean a(int paramInt)
  {
    return CEResUtil.b(paramInt);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    return CEResUtil.a(paramInt1, paramInt2, paramInt3, paramBoolean);
  }
  
  public boolean a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    return CEResUtil.a(paramInt1, paramBoolean1, paramInt2, paramBoolean2);
  }
  
  public boolean a(ApolloActionData paramApolloActionData)
  {
    return CEResUtil.a(paramApolloActionData);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    if (!CEResUtil.a())
    {
      QLog.e("[cmshow]cm_res", 1, "[checkBasicActionExist] role0 not valid, need download");
      a().a(paramQQAppInterface, paramQQAppInterface.getCurrentUin(), null, 0, null, -1, -1, true);
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
  
  public boolean a(String paramString)
  {
    return CEResUtil.a(paramString);
  }
  
  public String b(String paramString)
  {
    return CEGetResPathUtil.a(paramString);
  }
  
  public boolean b(int paramInt)
  {
    return CEResUtil.c(paramInt);
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    return CEResUtil.d(paramInt1, paramInt2);
  }
  
  public String c(int paramInt)
  {
    return CEGetResPathUtil.b(paramInt);
  }
  
  public String c(String paramString)
  {
    return CEGetResPathUtil.b(paramString);
  }
  
  public boolean c(int paramInt1, int paramInt2)
  {
    return CEResUtil.b(paramInt1, paramInt2);
  }
  
  public String d(int paramInt)
  {
    return CEResUtil.e(paramInt);
  }
  
  public String d(int paramInt1, int paramInt2)
  {
    return CEGetResPathUtil.a(paramInt1, paramInt2);
  }
  
  public String e(int paramInt)
  {
    return CEGetResPathUtil.d(paramInt);
  }
  
  public boolean e(int paramInt1, int paramInt2)
  {
    return CEResUtil.c(paramInt1, paramInt2);
  }
  
  public String f(int paramInt)
  {
    return CEResUtil.d(paramInt);
  }
  
  public boolean f(int paramInt1, int paramInt2)
  {
    return CEResUtil.e(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.resource.CEResourceManager
 * JD-Core Version:    0.7.0.1
 */