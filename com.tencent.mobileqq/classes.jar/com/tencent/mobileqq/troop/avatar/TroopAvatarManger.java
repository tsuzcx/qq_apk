package com.tencent.mobileqq.troop.avatar;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.handler.ITroopAvatarHandler;
import com.tencent.mobileqq.troop.avatar.impl.NormalTroopUrlAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observer;

public class TroopAvatarManger
{
  protected static Map<String, UploadingTask> b;
  protected ITroopAvatarHandler a;
  public String c;
  private BaseUrlAction d = c();
  
  public TroopAvatarManger(String paramString, Class<? extends UploadingTask> paramClass, AppInterface paramAppInterface)
  {
    this.a = ((ITroopAvatarHandler)paramAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopAvatarHandlerName()));
    this.c = paramString;
    if (b == null) {
      b = new HashMap();
    }
    if ((UploadingTask)b.get(paramString) == null)
    {
      paramClass = UploadingFactory.a(paramClass);
      b.put(paramString, paramClass);
    }
  }
  
  private BaseUrlAction c()
  {
    return new NormalTroopUrlAction();
  }
  
  public ArrayList<UploadItem> a()
  {
    return ((UploadingTask)b.get(this.c)).a();
  }
  
  public void a(BaseUrlAction paramBaseUrlAction)
  {
    this.d = paramBaseUrlAction;
  }
  
  public void a(Class<? extends Thread> paramClass, AppInterface paramAppInterface, ArrayList<TroopClipPic> paramArrayList, Bundle paramBundle, HashMap<String, String> paramHashMap)
  {
    ThreadManager.executeOnNetWorkThread(new TroopAvatarManger.1(this, paramBundle, paramAppInterface, (UploadingTask)b.get(this.c), paramClass, paramArrayList, paramHashMap));
  }
  
  public void a(String paramString)
  {
    ITroopAvatarHandler localITroopAvatarHandler = this.a;
    if (localITroopAvatarHandler != null) {
      localITroopAvatarHandler.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt, ArrayList<Integer> paramArrayList)
  {
    ITroopAvatarHandler localITroopAvatarHandler = this.a;
    if (localITroopAvatarHandler != null) {
      localITroopAvatarHandler.a(paramString, paramInt, paramArrayList);
    }
  }
  
  public void a(Observer paramObserver)
  {
    ((UploadingTask)b.get(this.c)).addObserver(paramObserver);
  }
  
  public void b()
  {
    this.a = null;
  }
  
  public void b(Observer paramObserver)
  {
    ((UploadingTask)b.get(this.c)).a(paramObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.TroopAvatarManger
 * JD-Core Version:    0.7.0.1
 */