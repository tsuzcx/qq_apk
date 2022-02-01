package com.tencent.timi.game.tgpa.helper;

import android.text.TextUtils;
import com.ihoc.mgpa.dataforwardsdk.ICallBack;
import com.tencent.timi.game.env.Env;
import com.tencent.timi.game.tgpa.TGPAUtil.TGPAGameDataCallback;
import com.tencent.timi.game.tgpa.data.CyminiTGPAData;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class TGPAInnerHelper
{
  private static volatile TGPAInnerHelper a;
  private List<TGPAUtil.TGPAGameDataCallback> b = new ArrayList();
  private ICallBack c;
  private TGPAUtil.TGPAGameDataCallback d = new TGPAInnerHelper.1(this);
  
  private TGPAInnerHelper()
  {
    Logger.a("CyminiTGPAHelper", "CyminiTGPAHelper");
  }
  
  public static TGPAInnerHelper a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new TGPAInnerHelper();
        }
      }
      finally {}
    }
    return a;
  }
  
  private ICallBack e()
  {
    return this.c;
  }
  
  public void a(ICallBack paramICallBack)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tgpaService###setTGPACallback ");
    localStringBuilder.append(paramICallBack);
    Logger.a("CyminiTGPAHelper", localStringBuilder.toString());
    this.c = paramICallBack;
    if (Env.b()) {
      a(CyminiTGPAData.a());
    }
  }
  
  public void a(TGPAUtil.TGPAGameDataCallback paramTGPAGameDataCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tgpaService###registerGameDataCallback ");
    localStringBuilder.append(paramTGPAGameDataCallback);
    Logger.a("CyminiTGPAHelper", localStringBuilder.toString());
    if ((paramTGPAGameDataCallback != null) && (!this.b.contains(paramTGPAGameDataCallback))) {
      this.b.add(paramTGPAGameDataCallback);
    }
  }
  
  public void a(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("tgpaService###receiveDataFromGame ");
    ((StringBuilder)localObject1).append(paramString);
    Logger.a("CyminiTGPAHelper", ((StringBuilder)localObject1).toString());
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
      }
      catch (Exception paramString)
      {
        Logger.a("CyminiTGPAHelper", "parse Json error", paramString);
      }
    } else {
      paramString = null;
    }
    Iterator localIterator;
    if ((paramString != null) && (paramString.keys().hasNext())) {
      localIterator = paramString.keys();
    }
    while (localIterator.hasNext())
    {
      localObject1 = (String)localIterator.next();
      int i = CyminiTGPAData.a((String)localObject1);
      Object localObject3;
      float f;
      if (i >= 0)
      {
        boolean bool = true;
        if (i != 1) {
          if (i != 2) {
            if (i != 4) {
              switch (i)
              {
              default: 
                break;
              case 79: 
                localObject3 = paramString.optString((String)localObject1);
                try
                {
                  localObject1 = new JSONObject((String)localObject3);
                }
                catch (Exception localException1)
                {
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append(i);
                  localStringBuilder.append(" JSONObject error - ");
                  localStringBuilder.append((String)localObject3);
                  Logger.a("CyminiTGPAHelper", localStringBuilder.toString(), localException1);
                  localObject2 = null;
                }
                if (localObject2 == null)
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("parse data error, ");
                  ((StringBuilder)localObject2).append(i);
                  ((StringBuilder)localObject2).append(" - ");
                  ((StringBuilder)localObject2).append(paramString);
                  Logger.c("CyminiTGPAHelper", ((StringBuilder)localObject2).toString());
                  continue;
                }
                i = CyminiTGPAData.c(((JSONObject)localObject2).optString("type"));
                if (i < 0)
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("TGPAResourceProgressType null, progressJson = ");
                  ((StringBuilder)localObject3).append(localObject2);
                  Logger.c("CyminiTGPAHelper", ((StringBuilder)localObject3).toString());
                  continue;
                }
                f = Float.parseFloat(((JSONObject)localObject2).optString("progress"));
                this.d.a(i, (int)f);
                break;
              case 78: 
                localObject2 = paramString.optJSONObject((String)localObject2);
                if (localObject2 != null) {
                  continue;
                }
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("parse data error, ");
                ((StringBuilder)localObject3).append(i);
                ((StringBuilder)localObject3).append(" - ");
                ((StringBuilder)localObject3).append(localObject2);
                Logger.c("CyminiTGPAHelper", ((StringBuilder)localObject3).toString());
                break;
              case 77: 
                localObject2 = paramString.optJSONObject((String)localObject2);
                if (localObject2 != null) {
                  continue;
                }
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("parse data error, ");
                ((StringBuilder)localObject3).append(i);
                ((StringBuilder)localObject3).append(" - ");
                ((StringBuilder)localObject3).append(localObject2);
                Logger.c("CyminiTGPAHelper", ((StringBuilder)localObject3).toString());
                break;
              case 76: 
                i = paramString.optInt((String)localObject2);
                localObject2 = this.d;
                if (i != 1) {
                  bool = false;
                }
                ((TGPAUtil.TGPAGameDataCallback)localObject2).a(bool);
                break;
              case 75: 
                localObject2 = paramString.optString((String)localObject2);
              }
            }
          }
        }
      }
      try
      {
        f = Float.parseFloat((String)localObject2);
        this.d.a(2, (int)f);
      }
      catch (Exception localException2)
      {
        label581:
        int j;
        int k;
        break label581;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("parse data error, ");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(" - ");
      ((StringBuilder)localObject2).append(paramString);
      Logger.c("CyminiTGPAHelper", ((StringBuilder)localObject2).toString());
      continue;
      j = paramString.optInt((String)localObject2);
      k = CyminiTGPAData.b(String.valueOf(j));
      if (k < 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("KEY_GAME_SCENE_CHANGE null, ");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(" gameScene = ");
        ((StringBuilder)localObject2).append(j);
        Logger.c("CyminiTGPAHelper", ((StringBuilder)localObject2).toString());
      }
      else
      {
        this.d.a(k);
        continue;
        localObject2 = paramString.optString((String)localObject2);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("parse data error, ");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(" - ");
          ((StringBuilder)localObject2).append(paramString);
          Logger.c("CyminiTGPAHelper", ((StringBuilder)localObject2).toString());
        }
        else if ("1".equals(localObject2))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("invalid param!!! ");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(" - ");
          ((StringBuilder)localObject2).append(paramString);
          Logger.c("CyminiTGPAHelper", ((StringBuilder)localObject2).toString());
        }
        else
        {
          this.d.b((String)localObject2);
          continue;
          localObject2 = paramString.optString((String)localObject2);
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("parse data error, ");
            ((StringBuilder)localObject2).append(i);
            ((StringBuilder)localObject2).append(" - ");
            ((StringBuilder)localObject2).append(paramString);
            Logger.c("CyminiTGPAHelper", ((StringBuilder)localObject2).toString());
          }
          else if ("1".equals(localObject2))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("invalid param!!! ");
            ((StringBuilder)localObject2).append(i);
            ((StringBuilder)localObject2).append(" - ");
            ((StringBuilder)localObject2).append(paramString);
            Logger.c("CyminiTGPAHelper", ((StringBuilder)localObject2).toString());
          }
          else
          {
            this.d.a((String)localObject2);
            continue;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("parse TGPADataKey error, key is - ");
            ((StringBuilder)localObject3).append((String)localObject2);
            Logger.c("CyminiTGPAHelper", ((StringBuilder)localObject3).toString());
            localObject3 = paramString.opt((String)localObject2);
            this.d.a((String)localObject2, localObject3);
            continue;
            Logger.c("CyminiTGPAHelper", "jsonObject is null!!!");
          }
        }
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tgpaService###sendDataToGame ");
    ((StringBuilder)localObject).append(paramJSONObject);
    Logger.a("CyminiTGPAHelper", ((StringBuilder)localObject).toString());
    if (paramJSONObject == null)
    {
      Logger.a("CyminiTGPAHelper", "jsonObject is null!!!");
      return;
    }
    localObject = e();
    if (localObject != null) {
      try
      {
        ((ICallBack)localObject).a(paramJSONObject.toString());
        return;
      }
      catch (Exception paramJSONObject)
      {
        Logger.a("CyminiTGPAHelper", "sendDataToGame error", paramJSONObject);
        return;
      }
    }
    Logger.c("CyminiTGPAHelper", "ICallBack is null!!!");
  }
  
  public void b() {}
  
  public void b(TGPAUtil.TGPAGameDataCallback paramTGPAGameDataCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tgpaService###unRegisterGameDataCallback ");
    localStringBuilder.append(paramTGPAGameDataCallback);
    Logger.a("CyminiTGPAHelper", localStringBuilder.toString());
    if ((paramTGPAGameDataCallback != null) && (this.b.contains(paramTGPAGameDataCallback))) {
      this.b.remove(paramTGPAGameDataCallback);
    }
  }
  
  public void c() {}
  
  public void d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tgpaService###clearGameDataCallback ");
    localStringBuilder.append(this.b.size());
    Logger.a("CyminiTGPAHelper", localStringBuilder.toString());
    this.b.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tgpa.helper.TGPAInnerHelper
 * JD-Core Version:    0.7.0.1
 */