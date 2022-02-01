package com.tencent.mobileqq.troop.entereffect;

import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class TroopEnterEffectConfig
{
  public boolean a;
  public TroopEnterEffectConfig.EffectInfo b;
  public AtomicBoolean c = new AtomicBoolean(false);
  public Vector<TroopEnterEffectConfig.GrayTipsConfig> d = new Vector();
  private Comparator<TroopEnterEffectConfig.GrayTipsConfig> e = new TroopEnterEffectConfig.1(this);
  
  public void a(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localObject = paramString.optJSONArray("effectSwitch");
        int i = 0;
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          if (((JSONArray)localObject).getJSONObject(0).optInt("androidSwitch") != 1) {
            break label234;
          }
          bool = true;
          this.a = bool;
        }
        paramString = paramString.optJSONArray("grayMsgList");
        if ((paramString != null) && (paramString.length() > 0))
        {
          if (i < paramString.length())
          {
            localObject = paramString.getJSONObject(i);
            TroopEnterEffectConfig.GrayTipsConfig localGrayTipsConfig = new TroopEnterEffectConfig.GrayTipsConfig();
            localGrayTipsConfig.a((JSONObject)localObject);
            this.d.add(localGrayTipsConfig);
            i += 1;
            continue;
          }
          Collections.sort(this.d, this.e);
        }
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("config mergeFromJSON enable = ");
          paramString.append(this.a);
          paramString.append(" graytips: ");
          paramString.append(this.d.size());
          QLog.d("TroopEnterEffectConfig.Config", 2, paramString.toString());
          return;
        }
      }
      catch (Exception paramString)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mergeFromJSON error: ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.e("TroopEnterEffectConfig.Config", 1, ((StringBuilder)localObject).toString());
      }
      return;
      label234:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.entereffect.TroopEnterEffectConfig
 * JD-Core Version:    0.7.0.1
 */