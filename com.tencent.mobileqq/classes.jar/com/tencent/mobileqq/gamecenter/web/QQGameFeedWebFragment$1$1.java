package com.tencent.mobileqq.gamecenter.web;

import aahi;
import akwd;
import android.os.Bundle;
import asnh;
import asnk;
import asnm;
import asoo;
import bhsz;
import bkjb;
import com.tencent.mobileqq.gamecenter.web.view.QQGamePubWebView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QQGameFeedWebFragment$1$1
  implements Runnable
{
  public QQGameFeedWebFragment$1$1(asoo paramasoo, Bundle paramBundle) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    QQGameFeedWebFragment.a(this.jdField_a_of_type_Asoo.a, (List)this.jdField_a_of_type_AndroidOsBundle.getSerializable("key_get_msg"));
    if (QQGameFeedWebFragment.a(this.jdField_a_of_type_Asoo.a) == null) {
      QQGameFeedWebFragment.a(this.jdField_a_of_type_Asoo.a, new ArrayList());
    }
    int j = -1;
    Object localObject;
    int i;
    if (QQGameFeedWebFragment.a(this.jdField_a_of_type_Asoo.a).size() > 0)
    {
      localObject = QQGameFeedWebFragment.a(akwd.a());
      i = 0;
      if (i >= QQGameFeedWebFragment.a(this.jdField_a_of_type_Asoo.a).size()) {
        break label631;
      }
      if (!((QQGameMsgInfo)QQGameFeedWebFragment.a(this.jdField_a_of_type_Asoo.a).get(i)).paMsgid.equals(localObject)) {
        break label614;
      }
    }
    for (;;)
    {
      for (;;)
      {
        QQGameFeedWebFragment.a(this.jdField_a_of_type_Asoo.a, i);
        j = i;
        if (i == 0)
        {
          localObject = new HashMap();
          ((Map)localObject).put(Integer.valueOf(1), ((QQGameMsgInfo)QQGameFeedWebFragment.a(this.jdField_a_of_type_Asoo.a).get(i)).paMsgid);
          ((Map)localObject).put(Integer.valueOf(2), i + "");
          ((Map)localObject).put(Integer.valueOf(3), "8");
          ((Map)localObject).put(Integer.valueOf(24), "1");
          aahi.a(akwd.a(), "769", "205017", ((QQGameMsgInfo)QQGameFeedWebFragment.a(this.jdField_a_of_type_Asoo.a).get(i)).gameAppId, "76901", "1", "160", (Map)localObject);
          bkjb.a(2, ((QQGameMsgInfo)QQGameFeedWebFragment.a(this.jdField_a_of_type_Asoo.a).get(i)).paMsgid, "");
        }
        try
        {
          asnm.a(101, (QQGameMsgInfo)QQGameFeedWebFragment.a(this.jdField_a_of_type_Asoo.a).get(i), i);
          j = i;
          if (QQGameFeedWebFragment.a(this.jdField_a_of_type_Asoo.a) != null)
          {
            QQGameFeedWebFragment.a(this.jdField_a_of_type_Asoo.a, new asnh(this.jdField_a_of_type_Asoo.a.getActivity(), (QQGameMsgInfo)QQGameFeedWebFragment.a(this.jdField_a_of_type_Asoo.a).get(0)));
            QQGameFeedWebFragment.a(this.jdField_a_of_type_Asoo.a).a(QQGameFeedWebFragment.a(this.jdField_a_of_type_Asoo.a));
            QQGameFeedWebFragment.a(this.jdField_a_of_type_Asoo.a).c = true;
            QQGameFeedWebFragment.a(this.jdField_a_of_type_Asoo.a).a(akwd.a(), null, (QQGameMsgInfo)QQGameFeedWebFragment.a(this.jdField_a_of_type_Asoo.a).get(0));
            j = i;
          }
          if (QQGameFeedWebFragment.a(this.jdField_a_of_type_Asoo.a) != null)
          {
            localObject = asnk.a();
            if (bhsz.a((String)localObject))
            {
              localObject = QQGameFeedWebFragment.a(this.jdField_a_of_type_Asoo.a, (String)localObject, QQGameFeedWebFragment.a(this.jdField_a_of_type_Asoo.a), j);
              if (QLog.isColorLevel()) {
                QLog.d("GameWebPage", 1, "paramUrl = " + (String)localObject);
              }
              this.jdField_a_of_type_Asoo.a.d = System.currentTimeMillis();
              QQGameFeedWebFragment.a(this.jdField_a_of_type_Asoo.a).loadUrl((String)localObject);
            }
          }
          this.jdField_a_of_type_Asoo.a.l = (System.currentTimeMillis() - l);
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