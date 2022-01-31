package com.tencent.mobileqq.gamecenter.web;

import ajac;
import android.os.Bundle;
import aqsr;
import aqsu;
import aqtt;
import bfnx;
import com.tencent.mobileqq.gamecenter.web.view.QQGamePubWebView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class QQGameFeedWebFragment$1$1
  implements Runnable
{
  public QQGameFeedWebFragment$1$1(aqtt paramaqtt, Bundle paramBundle) {}
  
  public void run()
  {
    QQGameFeedWebFragment.a(this.jdField_a_of_type_Aqtt.a, (List)this.jdField_a_of_type_AndroidOsBundle.getSerializable("key_get_msg"));
    if (QQGameFeedWebFragment.a(this.jdField_a_of_type_Aqtt.a) == null) {
      QQGameFeedWebFragment.a(this.jdField_a_of_type_Aqtt.a, new ArrayList());
    }
    String str;
    int i;
    if ((QQGameFeedWebFragment.a(this.jdField_a_of_type_Aqtt.a) != null) && (QQGameFeedWebFragment.a(this.jdField_a_of_type_Aqtt.a).size() > 0))
    {
      str = QQGameFeedWebFragment.a(ajac.a());
      i = 0;
      if (i < QQGameFeedWebFragment.a(this.jdField_a_of_type_Aqtt.a).size()) {
        if (((QQGameMsgInfo)QQGameFeedWebFragment.a(this.jdField_a_of_type_Aqtt.a).get(i)).paMsgid.equals(str))
        {
          label142:
          QQGameFeedWebFragment.a(this.jdField_a_of_type_Aqtt.a, i);
          j = i;
          if (i == 0)
          {
            j = i;
            if (QQGameFeedWebFragment.a(this.jdField_a_of_type_Aqtt.a) != null)
            {
              QQGameFeedWebFragment.a(this.jdField_a_of_type_Aqtt.a, new aqsr(this.jdField_a_of_type_Aqtt.a.getActivity(), (QQGameMsgInfo)QQGameFeedWebFragment.a(this.jdField_a_of_type_Aqtt.a).get(0)));
              QQGameFeedWebFragment.a(this.jdField_a_of_type_Aqtt.a).a(QQGameFeedWebFragment.a(this.jdField_a_of_type_Aqtt.a));
              QQGameFeedWebFragment.a(this.jdField_a_of_type_Aqtt.a).c = true;
              QQGameFeedWebFragment.a(this.jdField_a_of_type_Aqtt.a).a(ajac.a(), null, (QQGameMsgInfo)QQGameFeedWebFragment.a(this.jdField_a_of_type_Aqtt.a).get(0));
            }
          }
        }
      }
    }
    for (int j = i;; j = -1)
    {
      if (QQGameFeedWebFragment.a(this.jdField_a_of_type_Aqtt.a) != null)
      {
        str = aqsu.a();
        if (bfnx.a(str))
        {
          str = QQGameFeedWebFragment.a(this.jdField_a_of_type_Aqtt.a, str, QQGameFeedWebFragment.a(this.jdField_a_of_type_Aqtt.a), j);
          if (QLog.isColorLevel()) {
            QLog.d("GameWebPage", 1, "paramUrl = " + str);
          }
          QQGameFeedWebFragment.a(this.jdField_a_of_type_Aqtt.a).loadUrl(str);
        }
      }
      return;
      i += 1;
      break;
      i = -1;
      break label142;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.1.1
 * JD-Core Version:    0.7.0.1
 */