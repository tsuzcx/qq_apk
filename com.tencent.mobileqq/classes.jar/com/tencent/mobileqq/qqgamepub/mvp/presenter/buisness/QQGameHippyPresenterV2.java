package com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.mvp.model.buisness.QQGameHippyModel;
import com.tencent.mobileqq.qqgamepub.mvp.view.buisness.IQQGameHippyViewV2;
import com.tencent.mobileqq.qqgamepub.utils.GamePAPreloadHelper;
import com.tencent.mobileqq.qqgamepub.utils.GamePAPreloadHelper.OnPreloadFeedsListener;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QQGameHippyPresenterV2
  extends QQGameHippyBasePresenter<IQQGameHippyViewV2, QQGameHippyModel>
{
  @SuppressLint({"HandlerLeak"})
  private final Handler i = new QQGameHippyPresenterV2.1(this);
  private final GamePAPreloadHelper.OnPreloadFeedsListener j = new QQGameHippyPresenterV2.2(this);
  
  private void z()
  {
    String str = GamePubAccountHelper.a(this.e, ((QQGameHippyModel)this.b).e(), ((QQGameHippyModel)this.b).b()).toString();
    this.i.removeMessages(2);
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.arg1 = -1;
    localMessage.arg2 = -1;
    localMessage.obj = str;
    this.i.sendMessage(localMessage);
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return super.a(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public JSONObject a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        k = ((QQGameHippyModel)this.b).b();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("gameData", GamePubAccountHelper.a(this.e, ((QQGameHippyModel)this.b).e(), k));
        localJSONObject.put("headerHeight", 373);
        localJSONObject.put("messageHeight", 0);
        localJSONObject.put("msgNum", k);
        localJSONObject.put("gameMsgNum", ((QQGameHippyModel)b()).h());
        if (k != 0) {
          break label241;
        }
        Object localObject = GamePubAccountHelper.a(this.c);
        k = 0;
        if (k >= this.e.size()) {
          break label241;
        }
        QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)this.e.get(k);
        if ((localQQGameMsgInfo.paMsgid == null) || (!localQQGameMsgInfo.paMsgid.equals(localObject))) {
          break label234;
        }
        localJSONObject.put("index", k);
        paramJSONObject.put("GpInitData", localJSONObject);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("feedEventJson=");
          ((StringBuilder)localObject).append(localJSONObject.toString());
          QLog.d("QQGamePub_QQGameHippyPresenterV2", 1, ((StringBuilder)localObject).toString());
          return paramJSONObject;
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("QQGamePub_QQGameHippyPresenterV2", 1, localJSONException.getMessage());
      }
      return paramJSONObject;
      label234:
      k += 1;
      continue;
      label241:
      int k = 0;
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hippyV2,call handleAdReverseFeedBack arkViewId:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QQGamePub_QQGameHippyPresenterV2", 1, ((StringBuilder)localObject).toString());
      localObject = this.e.iterator();
      while (((Iterator)localObject).hasNext())
      {
        QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)((Iterator)localObject).next();
        if (paramString.equals(String.valueOf(localQQGameMsgInfo.uniseq)))
        {
          this.e.remove(localQQGameMsgInfo);
          z();
        }
      }
    }
  }
  
  public void a(ArrayList<QQGameMsgInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      this.e.addAll(0, paramArrayList);
      z();
    }
  }
  
  public void g()
  {
    super.g();
    this.i.removeCallbacksAndMessages(null);
    GamePAPreloadHelper.f();
  }
  
  protected int p()
  {
    return 10;
  }
  
  protected int q()
  {
    return 12;
  }
  
  public String t()
  {
    return "3";
  }
  
  protected QQGameHippyModel x()
  {
    return new QQGameHippyModel(this);
  }
  
  public void y()
  {
    GamePAPreloadHelper.a(this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyPresenterV2
 * JD-Core Version:    0.7.0.1
 */