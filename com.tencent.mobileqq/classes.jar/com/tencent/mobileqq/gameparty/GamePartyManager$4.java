package com.tencent.mobileqq.gameparty;

import aspf;
import aspj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.manager.TicketManager;

public class GamePartyManager$4
  implements Runnable
{
  public GamePartyManager$4(aspf paramaspf, String paramString, aspj paramaspj) {}
  
  public void run()
  {
    Object localObject3 = (QQAppInterface)aspf.a(this.this$0).get();
    if (localObject3 == null) {}
    label308:
    do
    {
      do
      {
        for (;;)
        {
          return;
          try
          {
            Object localObject1 = (HttpURLConnection)new URL(this.jdField_a_of_type_JavaLangString).openConnection();
            ((HttpURLConnection)localObject1).setRequestMethod("GET");
            ((HttpURLConnection)localObject1).setConnectTimeout(30000);
            ((HttpURLConnection)localObject1).setReadTimeout(30000);
            localObject2 = ((QQAppInterface)localObject3).getCurrentAccountUin();
            Object localObject4 = (TicketManager)((QQAppInterface)localObject3).getManager(2);
            localObject3 = ((TicketManager)localObject4).getSkey((String)localObject2);
            localObject4 = ((TicketManager)localObject4).getPskey((String)localObject2, "openmobile.qq.com");
            ((HttpURLConnection)localObject1).setRequestProperty("Cookie", "uin=o" + (String)localObject2 + "; skey=" + (String)localObject3 + "; p_uin=o" + (String)localObject2 + "; p_skey=" + (String)localObject4);
            if (((HttpURLConnection)localObject1).getResponseCode() != 200) {
              break label308;
            }
            localObject1 = new BufferedReader(new InputStreamReader(((HttpURLConnection)localObject1).getInputStream()));
            localObject2 = new StringBuffer();
            for (;;)
            {
              localObject3 = ((BufferedReader)localObject1).readLine();
              if (localObject3 == null) {
                break;
              }
              ((StringBuffer)localObject2).append((String)localObject3);
            }
          }
          catch (MalformedURLException localMalformedURLException)
          {
            Object localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("GamePartyManager", 2, "http request, url invalid, url = " + this.jdField_a_of_type_JavaLangString);
              return;
              if (QLog.isColorLevel()) {
                QLog.d("GamePartyManager", 2, "http request succeeded, url = " + this.jdField_a_of_type_JavaLangString);
              }
              if (this.jdField_a_of_type_Aspj != null)
              {
                this.jdField_a_of_type_Aspj.a(((StringBuffer)localObject2).toString());
                return;
              }
            }
          }
          catch (IOException localIOException) {}
        }
      } while (!QLog.isColorLevel());
      QLog.d("GamePartyManager", 2, "http request, ioexception");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("GamePartyManager", 2, "http request failed, url = " + this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gameparty.GamePartyManager.4
 * JD-Core Version:    0.7.0.1
 */