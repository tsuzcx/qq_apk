package com.tencent.mobileqq.minigame.manager;

import com.tencent.mobileqq.minigame.utils.GameLog;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

final class GamePreConnectManager$4
  implements Callback
{
  GamePreConnectManager$4(String paramString, long paramLong) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    paramCall = GameLog.getInstance();
    paramIOException = new StringBuilder();
    paramIOException.append("pre-connect onFailure: ");
    paramIOException.append(this.val$url);
    paramCall.e("GamePreConnectManager", paramIOException.toString());
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    long l = System.currentTimeMillis();
    paramCall = GameLog.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResponse [timecost: ");
    localStringBuilder.append(l - this.val$begin);
    localStringBuilder.append("] [url: ");
    localStringBuilder.append(this.val$url);
    localStringBuilder.append("] [code: ");
    localStringBuilder.append(paramResponse.code());
    localStringBuilder.append("]");
    paramCall.i("GamePreConnectManager", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GamePreConnectManager.4
 * JD-Core Version:    0.7.0.1
 */