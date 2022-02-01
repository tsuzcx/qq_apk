package com.tencent.mobileqq.intervideo;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface ILoginKeyHelper
  extends QRouteApi
{
  public static final int FLAG_ACCESS_TOKEN = 2;
  public static final int FLAG_OPENID = 1;
  public static final int FLAG_PAY_TOKEN = 4;
  
  public abstract void cancelRequest();
  
  public abstract void clearAccount();
  
  public abstract boolean getA1(String paramString1, String paramString2, String paramString3, String paramString4, ILoginKeyHelper.GetLoginKeyListener paramGetLoginKeyListener, boolean paramBoolean, String paramString5);
  
  public abstract void getAccessToken(AppInterface paramAppInterface, String paramString1, Context paramContext, String paramString2, ILoginKeyHelper.GetLoginKeyListener paramGetLoginKeyListener);
  
  public abstract ILoginKeyHelper.AccountInfo getAccountInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.ILoginKeyHelper
 * JD-Core Version:    0.7.0.1
 */