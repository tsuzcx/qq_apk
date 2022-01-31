package com.tencent.mobileqq.gamecenter.web;

import aact;
import akro;
import android.os.Bundle;
import asiy;
import asjb;
import asjd;
import askf;
import bhos;
import bkeu;
import com.tencent.mobileqq.gamecenter.web.view.QQGamePubWebView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QQGameFeedWebFragment$1$1
  implements Runnable
{
  public QQGameFeedWebFragment$1$1(askf paramaskf, Bundle paramBundle) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    QQGameFeedWebFragment.a(this.jdField_a_of_type_Askf.a, (List)this.jdField_a_of_type_AndroidOsBundle.getSerializable("key_get_msg"));
    if (QQGameFeedWebFragment.a(this.jdField_a_of_type_Askf.a) == null) {
      QQGameFeedWebFragment.a(this.jdField_a_of_type_Askf.a, new ArrayList());
    }
    int j = -1;
    Object localObject;
    int i;
    if (QQGameFeedWebFragment.a(this.jdField_a_of_type_Askf.a).size() > 0)
    {
      localObject = QQGameFeedWebFragment.a(akro.a());
      i = 0;
      if (i >= QQGameFeedWebFragment.a(this.jdField_a_of_type_Askf.a).size()) {
        break label631;
      }
      if (!((QQGameMsgInfo)QQGameFeedWebFragment.a(this.jdField_a_of_type_Askf.a).get(i)).paMsgid.equals(localObject)) {
        break label614;
      }
    }
    for (;;)
    {
      for (;;)
      {
        QQGameFeedWebFragment.a(this.jdField_a_of_type_Askf.a, i);
        j = i;
        if (i == 0)
        {
          localObject = new HashMap();
          ((Map)localObject).put(Integer.valueOf(1), ((QQGameMsgInfo)QQGameFeedWebFragment.a(this.jdField_a_of_type_Askf.a).get(i)).paMsgid);
          ((Map)localObject).put(Integer.valueOf(2), i + "");
          ((Map)localObject).put(Integer.valueOf(3), "8");
          ((Map)localObject).put(Integer.valueOf(24), "1");
          aact.a(akro.a(), "769", "205017", ((QQGameMsgInfo)QQGameFeedWebFragment.a(this.jdField_a_of_type_Askf.a).get(i)).gameAppId, "76901", "1", "160", (Map)localObject);
          bkeu.a(2, ((QQGameMsgInfo)QQGameFeedWebFragment.a(this.jdField_a_of_type_Askf.a).get(i)).paMsgid, "");
        }
        try
        {
          asjd.a(101, (QQGameMsgInfo)QQGameFeedWebFragment.a(this.jdField_a_of_type_Askf.a).get(i), i);
          j = i;
          if (QQGameFeedWebFragment.a(this.jdField_a_of_type_Askf.a) != null)
          {
            QQGameFeedWebFragment.a(this.jdField_a_of_type_Askf.a, new asiy(this.jdField_a_of_type_Askf.a.getActivity(), (QQGameMsgInfo)QQGameFeedWebFragment.a(this.jdField_a_of_type_Askf.a).get(0)));
            QQGameFeedWebFragment.a(this.jdField_a_of_type_Askf.a).a(QQGameFeedWebFragment.a(this.jdField_a_of_type_Askf.a));
            QQGameFeedWebFragment.a(this.jdField_a_of_type_Askf.a).c = true;
            QQGameFeedWebFragment.a(this.jdField_a_of_type_Askf.a).a(akro.a(), null, (QQGameMsgInfo)QQGameFeedWebFragment.a(this.jdField_a_of_type_Askf.a).get(0));
            j = i;
          }
          if (QQGameFeedWebFragment.a(this.jdField_a_of_type_Askf.a) != null)
          {
            localObject = asjb.a();
            if (bhos.a((String)localObject))
            {
              localObject = QQGameFeedWebFragment.a(this.jdField_a_of_type_Askf.a, (String)localObject, QQGameFeedWebFragment.a(this.jdField_a_of_type_Askf.a), j);
              if (QLog.isColorLevel()) {
                QLog.d("GameWebPage", 1, "paramUrl = " + (String)localObject);
              }
              this.jdField_a_of_type_Askf.a.d = System.currentTimeMillis();
              QQGameFeedWebFragment.a(this.jdField_a_of_type_Askf.a).loadUrl((String)localObject);
            }
          }
          this.jdField_a_of_type_Askf.a.l = (System.currentTimeMillis() - l);
          return;
          label614:
          i += 1;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            localThrowable.printStackTrace();
          }
        }
      }
      label631:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.1.1
 * JD-Core Version:    0.7.0.1
 */