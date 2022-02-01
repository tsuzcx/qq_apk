package com.tencent.tbs.one.impl.common.statistic;

import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.net.HttpRequestJob.Client;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class StatisticReport$1
  implements HttpRequestJob.Client
{
  StatisticReport$1(StatisticReport paramStatisticReport) {}
  
  public void onResponseReceived(int paramInt, Map<String, List<String>> paramMap, InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      Logging.d("Statistic reporter received empty input stream!", new Object[0]);
    }
    do
    {
      return;
      try
      {
        paramMap = new ByteArrayOutputStream();
        byte[] arrayOfByte = new byte[1024];
        for (;;)
        {
          paramInt = paramInputStream.read(arrayOfByte);
          if (paramInt == -1) {
            break;
          }
          paramMap.write(arrayOfByte, 0, paramInt);
        }
        paramMap.close();
      }
      catch (IOException paramMap)
      {
        paramMap.printStackTrace();
        return;
      }
      paramInputStream.close();
      paramMap = new String(paramMap.toByteArray());
      Logging.e(paramMap, new Object[0]);
      try
      {
        paramInt = new JSONObject(paramMap).getInt("CODE");
        if (paramInt == 0)
        {
          Logging.i("Statistic report successfully!", new Object[0]);
          return;
        }
      }
      catch (JSONException paramMap)
      {
        paramMap.printStackTrace();
        return;
      }
      if (paramInt == -1001)
      {
        Logging.e("Statistic report error! Not post method!", new Object[0]);
        return;
      }
      if (paramInt == -1002)
      {
        Logging.e("Statistic report error! Params not valid!", new Object[0]);
        return;
      }
      if (paramInt == -1003)
      {
        Logging.e("Statistic report error! Server exception!", new Object[0]);
        return;
      }
      if (paramInt == -1004)
      {
        Logging.e("Statistic report error! Server over charge!", new Object[0]);
        return;
      }
      if (paramInt == -1005)
      {
        Logging.e("Statistic report error! DB exception!", new Object[0]);
        return;
      }
      if (paramInt == -1006)
      {
        Logging.e("Statistic report error! DB exception!", new Object[0]);
        return;
      }
    } while (paramInt != -1007);
    Logging.e("Statistic report error! Config not hit!", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.statistic.StatisticReport.1
 * JD-Core Version:    0.7.0.1
 */