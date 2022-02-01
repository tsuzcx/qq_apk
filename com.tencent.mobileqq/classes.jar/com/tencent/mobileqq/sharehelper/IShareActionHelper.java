package com.tencent.mobileqq.sharehelper;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

@QAPI(process={"all"})
public abstract interface IShareActionHelper
  extends QRouteApi
{
  public abstract void doSharTextToWeChat(String paramString1, int paramInt, Activity paramActivity, String paramString2, String paramString3);
  
  public abstract void doShareArkBySelect(String paramString, Activity paramActivity, ArkShareInfo paramArkShareInfo);
  
  public abstract void doShareArkDirectly(String paramString1, Activity paramActivity, ArkShareInfo paramArkShareInfo, int paramInt, String paramString2);
  
  public abstract void doShareImageToQQBySelect(String paramString, Activity paramActivity, ImageShareInfo paramImageShareInfo);
  
  public abstract void doShareImageToQQDirectly(String paramString1, Activity paramActivity, ImageShareInfo paramImageShareInfo, int paramInt, String paramString2);
  
  public abstract void doShareLinkToWeChat(String paramString1, int paramInt, String paramString2, Activity paramActivity, String paramString3, String paramString4, String paramString5, String paramString6);
  
  public abstract void doSharePicToWX(String paramString1, Activity paramActivity, String paramString2, String paramString3, int paramInt);
  
  public abstract void doShareTextBySelect(String paramString1, Activity paramActivity, String paramString2);
  
  public abstract void doShareTextDirectly(String paramString1, Activity paramActivity, String paramString2, int paramInt, String paramString3);
  
  public abstract void doShareToQZoneWithLink(String paramString, Context paramContext, QzoneLinkShareInfo paramQzoneLinkShareInfo);
  
  public abstract void doShareToQZoneWithPics(String paramString, Context paramContext, ArrayList<String> paramArrayList, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.sharehelper.IShareActionHelper
 * JD-Core Version:    0.7.0.1
 */