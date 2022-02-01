package com.tencent.mobileqq.qqgamepub.mvp.model.bean;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.model.GameMsgData;
import com.tencent.mobileqq.qqgamepub.mvp.model.base.IModel;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.base.IPresenter;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameWebPresenter;
import com.tencent.mobileqq.qqgamepub.view.IHeaderView;
import com.tencent.mobileqq.qqgamepub.view.MoreMsgHeaderView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class QQGameWebFeedModel
  implements IModel
{
  protected GameMsgData a;
  private QQGameWebPresenter b;
  private int c = 0;
  private IHeaderView d;
  private int e;
  
  public QQGameWebFeedModel(QQGameWebPresenter paramQQGameWebPresenter)
  {
    a(paramQQGameWebPresenter);
    this.a = new GameMsgData();
  }
  
  private String a(AppInterface paramAppInterface)
  {
    SharedPreferences localSharedPreferences = paramAppInterface.getApp().getSharedPreferences("game_center_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("msgPos_web");
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    return localSharedPreferences.getString(localStringBuilder.toString(), "");
  }
  
  public int a(String paramString)
  {
    if (g().a()) {
      QLog.e("QQGameWebFeedModel", 1, "handleAdReverseFeedBack, msgInfoList is null");
    }
    int i = 0;
    while (i < i())
    {
      if (paramString.equals(String.valueOf(((QQGameMsgInfo)this.a.d().get(i)).uniseq))) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public String a(String paramString, int paramInt)
  {
    int i = f();
    Object localObject = this.a.d();
    if ((!TextUtils.isEmpty(paramString)) && (localObject != null) && (((List)localObject).size() > 0))
    {
      if (paramString.indexOf("?") == -1) {}
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("?gameData=");
        ((StringBuilder)localObject).append(URLEncoder.encode(e(), "utf-8"));
        ((StringBuilder)localObject).append("&index=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("&height=");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("&_bid=4235");
        return ((StringBuilder)localObject).toString();
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return paramString;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("&gameData=");
      ((StringBuilder)localObject).append(URLEncoder.encode(e(), "utf-8"));
      ((StringBuilder)localObject).append("&index=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("&height=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("&_bid=4235");
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    if (paramString.indexOf("?") == -1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("?height=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("&_bid=4235");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("&height=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("&_bid=4235");
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    this.c += 1;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(Activity paramActivity)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = g().d().iterator();
    while (localIterator.hasNext())
    {
      QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)localIterator.next();
      localArrayList.add(((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).createHeader(localQQGameMsgInfo, paramActivity));
      if (!TextUtils.isEmpty(localQQGameMsgInfo.arkAppName)) {
        this.b.a(localQQGameMsgInfo.arkAppName);
      }
    }
    localArrayList.add(new MoreMsgHeaderView(paramActivity));
    g().b(localArrayList);
  }
  
  public void a(AppInterface paramAppInterface, String paramString)
  {
    SharedPreferences localSharedPreferences = paramAppInterface.getApp().getSharedPreferences("game_center_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("msgPos_web");
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    paramAppInterface = localStringBuilder.toString();
    localSharedPreferences.edit().putString(paramAppInterface, paramString).apply();
  }
  
  public void a(IPresenter paramIPresenter)
  {
    this.b = ((QQGameWebPresenter)paramIPresenter);
  }
  
  public void a(IHeaderView paramIHeaderView)
  {
    this.d = paramIHeaderView;
  }
  
  public void a(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.code == 0) && (paramEIPCResult.data != null))
    {
      List localList = (List)paramEIPCResult.data.getSerializable("key_get_msg");
      paramEIPCResult = localList;
      if (localList == null) {
        paramEIPCResult = new ArrayList();
      }
      this.a.a(paramEIPCResult);
    }
  }
  
  public QQGameMsgInfo b(int paramInt)
  {
    return this.a.a(paramInt);
  }
  
  public boolean b()
  {
    return this.c > 0;
  }
  
  public IHeaderView c(int paramInt)
  {
    return this.a.b(paramInt);
  }
  
  public void c()
  {
    this.c -= 1;
  }
  
  public int d()
  {
    String str = a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface());
    if (!TextUtils.isEmpty(str))
    {
      int i = 0;
      while (i < i())
      {
        QQGameMsgInfo localQQGameMsgInfo = b(i);
        if ((localQQGameMsgInfo != null) && (!TextUtils.isEmpty(localQQGameMsgInfo.paMsgid)) && (localQQGameMsgInfo.paMsgid.equals(str))) {
          return i;
        }
        i += 1;
      }
    }
    return 0;
  }
  
  public boolean d(int paramInt)
  {
    return this.a.c(paramInt);
  }
  
  public String e()
  {
    Object localObject2 = this.a.d();
    if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
      try
      {
        Object localObject1 = new JSONArray();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)((Iterator)localObject2).next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("msgID", localQQGameMsgInfo.paMsgid);
          localJSONObject.put("appID", localQQGameMsgInfo.gameAppId);
          localJSONObject.put("msgTime", localQQGameMsgInfo.msgTime);
          if (!TextUtils.isEmpty(localQQGameMsgInfo.sortedConfigs)) {
            localJSONObject.put("sorted_configs", localQQGameMsgInfo.sortedConfigs);
          }
          if (!TextUtils.isEmpty(localQQGameMsgInfo.extJson)) {
            localJSONObject.put("extJson", localQQGameMsgInfo.extJson);
          }
          ((JSONArray)localObject1).put(localJSONObject);
        }
        localObject1 = ((JSONArray)localObject1).toString();
        return localObject1;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    return "";
  }
  
  public boolean e(int paramInt)
  {
    return this.a.d(paramInt);
  }
  
  public int f()
  {
    return this.e;
  }
  
  public GameMsgData g()
  {
    return this.a;
  }
  
  public IHeaderView h()
  {
    return this.d;
  }
  
  public int i()
  {
    return this.a.b();
  }
  
  public int j()
  {
    return this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.mvp.model.bean.QQGameWebFeedModel
 * JD-Core Version:    0.7.0.1
 */