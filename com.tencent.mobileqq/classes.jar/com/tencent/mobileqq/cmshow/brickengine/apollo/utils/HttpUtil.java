package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.qphone.base.util.QLog;

public class HttpUtil
{
  public static void a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String[] paramArrayOfString, boolean paramBoolean)
  {
    View localView = ApolloRender.getCurrentRenderView();
    if (localView == null) {
      return;
    }
    if ((paramString2 != null) && (!"".equals(paramString2)))
    {
      ThreadManager.post(new HttpUtil.4(paramString2, paramString1, paramArrayOfString, new HttpUtil.3(localView, paramLong), paramBoolean, paramString3, paramString4, paramString5), 5, null, true);
      return;
    }
    QLog.e("[cmshow]HttpUtil", 2, "httpLog  httpRequest method null ");
  }
  
  public static void a(long paramLong, String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, String paramString4, String[] paramArrayOfString, boolean paramBoolean)
  {
    paramString3 = ApolloRender.getCurrentRenderView();
    if (paramString3 == null) {
      return;
    }
    if ((paramString2 != null) && (!"".equals(paramString2)))
    {
      ThreadManager.post(new HttpUtil.2(paramString2, paramString1, paramArrayOfByte, paramArrayOfString, new HttpUtil.1(paramString3, paramLong)), 5, null, true);
      return;
    }
    QLog.e("[cmshow]HttpUtil", 2, "httpLog  httpRequest method null ");
  }
  
  public static void a(long paramLong, @NonNull String paramString1, @NonNull String paramString2, @NonNull String[] paramArrayOfString, @Nullable byte[] paramArrayOfByte)
  {
    View localView = ApolloRender.getCurrentRenderView();
    if (localView == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("[cmshow]HttpUtil", 1, "sendHttpRequest url is empty");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]HttpUtil", 2, new Object[] { "ApolloHttpUtil sendHttpRequest http:", Long.valueOf(paramLong), " url:", paramString1, " method:", paramString2 });
    }
    ApolloRender localApolloRender = ApolloRender.getCurrentRender();
    if (localApolloRender == null) {
      return;
    }
    ThreadManager.post(new HttpUtil.8(paramString1, paramArrayOfString, new HttpUtil.5(localView, paramLong, paramString1, paramString2, localApolloRender), paramString2, paramArrayOfByte, new HttpUtil.6(localView, localApolloRender, paramLong), new HttpUtil.7(localView, localApolloRender, paramLong)), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.HttpUtil
 * JD-Core Version:    0.7.0.1
 */