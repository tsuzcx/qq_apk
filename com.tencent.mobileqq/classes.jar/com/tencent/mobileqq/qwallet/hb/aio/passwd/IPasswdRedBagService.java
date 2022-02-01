package com.tencent.mobileqq.qwallet.hb.aio.passwd;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.annotation.DrawableRes;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import mqq.app.api.IRuntimeService;
import mqq.observer.BusinessObserver;
import tencent.im.msg.im_msg_body.QQWalletAioBody;

@Service(process={"all"})
public abstract interface IPasswdRedBagService
  extends IRuntimeService
{
  public static final int FLAG_FINISH = 2;
  public static final int FLAG_NORMAL = 0;
  public static final int FLAG_NOT_FINISH = 1;
  public static final int FLAG_OTHER = 4;
  public static final int FLAG_OVERDUE = 3;
  public static final String TAG = "PasswdRedBagSgervice";
  public static final int TYPE_C2C = 3;
  public static final int TYPE_DISCUSS = 2;
  public static final int TYPE_GROUP = 1;
  public static final int TYPE_NONE = 0;
  
  public abstract void createPasswdRedBagAnonymousTips(String paramString, int paramInt);
  
  public abstract void createPasswdRedBagBanTips(String paramString, int paramInt);
  
  public abstract void fetchNewestIdomRedbagWordWhenFirstEnterAIO(BaseSessionInfo paramBaseSessionInfo);
  
  public abstract Map<String, String> getAuthKeyCache();
  
  public abstract Bitmap getIconFromCacheByType(String paramString, @DrawableRes int paramInt);
  
  public abstract String getLastIdiom(String paramString);
  
  public abstract String getLastIdiomPinyin(String paramString);
  
  public abstract PasswdRedBagInfo getPasswdRedBagInfoById(String paramString);
  
  public abstract void getRandomIdiomList(BusinessObserver paramBusinessObserver, int paramInt1, int paramInt2);
  
  public abstract String getRandomPasswd();
  
  public abstract String hanleShengpiziGrayTips(String paramString1, int paramInt, String paramString2);
  
  public abstract boolean isFirstInAio();
  
  public abstract void loadConfigs();
  
  public abstract void loadDBToCache();
  
  public abstract void loadRedBagInfoToCache(boolean paramBoolean);
  
  public abstract void loadRedBagRelationToCache();
  
  public abstract void openPasswdBagByTenpay(BaseSessionInfo paramBaseSessionInfo, PasswdRedBagInfo paramPasswdRedBagInfo, long paramLong, int paramInt);
  
  public abstract void openPasswdBagByTenpay(BaseSessionInfo paramBaseSessionInfo, PasswdRedBagInfo paramPasswdRedBagInfo, long paramLong, int paramInt1, int paramInt2, Bundle paramBundle);
  
  public abstract void openPasswdBagByTenpay(BaseSessionInfo paramBaseSessionInfo, PasswdRedBagInfo paramPasswdRedBagInfo, long paramLong, int paramInt, Bundle paramBundle);
  
  public abstract void openPasswdBagByTenpay(BaseSessionInfo paramBaseSessionInfo, PasswdRedBagInfo paramPasswdRedBagInfo, long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3, Bundle paramBundle);
  
  public abstract Object[] openPasswdRedBagById(String paramString1, BaseSessionInfo paramBaseSessionInfo, String paramString2, int paramInt);
  
  public abstract Object[] openPasswdRedBagByPassword(BaseSessionInfo paramBaseSessionInfo, String paramString, int paramInt);
  
  public abstract void refreshCureentIdomResbag(BaseSessionInfo paramBaseSessionInfo, ArrayList<String> paramArrayList);
  
  public abstract void reportPasswdRedBagClick(String paramString, boolean paramBoolean);
  
  public abstract void reportPasswdTipsClick(String paramString);
  
  public abstract void saveDisGroupInfos(HashMap<String, String> paramHashMap);
  
  public abstract void saveGroupInfos(HashMap<String, String> paramHashMap);
  
  public abstract void savePasswdRedBag(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, boolean paramBoolean1, boolean paramBoolean2, int paramInt);
  
  public abstract void savePasswdRedBag(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString8, String paramString9);
  
  public abstract void savePasswdRedBagFromNet(im_msg_body.QQWalletAioBody paramQQWalletAioBody, int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2, String paramString1, String paramString2);
  
  public abstract void setPasswdRedBagFinish(String paramString);
  
  public abstract void setPasswdRedBagLastedWord(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4);
  
  public abstract void setPasswdRedBagOpen(String paramString1, String paramString2, int paramInt);
  
  public abstract int transType(int paramInt);
  
  public abstract void updateIdiomBubbleView(Context paramContext, String paramString1, String paramString2);
  
  public abstract void updateIdiomRedbagsLastword(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5);
  
  public abstract void updatePasswdConfig(HashSet<String> paramHashSet);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService
 * JD-Core Version:    0.7.0.1
 */