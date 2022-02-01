package com.tencent.timi.game.accusation.impl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.env.Env;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

final class TimiGameAccusationImpl$2
  implements Callback
{
  TimiGameAccusationImpl$2(AccusationParams paramAccusationParams) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    if (Env.b()) {
      QLog.d("TimiGameAccusationImpl", 4, "repose is failed jump to h5");
    }
    TimiGameAccusationImpl.a(false);
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    try
    {
      TimiGameAccusationImpl.a(false);
      paramCall = paramResponse.body().string();
      if (Env.b())
      {
        paramResponse = new StringBuilder();
        paramResponse.append("response is ");
        paramResponse.append(paramCall);
        QLog.d("TimiGameAccusationImpl", 4, paramResponse.toString());
      }
      paramCall = new JSONObject(paramCall).optString("key");
      if (Env.b()) {
        QLog.d("TimiGameAccusationImpl", 4, "response is success jump to h5");
      }
      TimiGameAccusationImpl.a(this.a, paramCall);
      return;
    }
    catch (Throwable paramCall)
    {
      if (Env.b())
      {
        paramResponse = new StringBuilder();
        paramResponse.append("response is failed");
        paramResponse.append(paramCall);
        QLog.d("TimiGameAccusationImpl", 4, paramResponse.toString());
        paramCall.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.accusation.impl.TimiGameAccusationImpl.2
 * JD-Core Version:    0.7.0.1
 */