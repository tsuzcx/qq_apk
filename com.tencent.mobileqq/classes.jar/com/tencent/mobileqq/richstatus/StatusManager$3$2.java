package com.tencent.mobileqq.richstatus;

import android.text.TextUtils;
import anvk;
import bbvn;
import bbvq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import gk;
import mqq.os.MqqHandler;

public class StatusManager$3$2
  implements Runnable
{
  public StatusManager$3$2(bbvq parambbvq, boolean paramBoolean) {}
  
  public void run()
  {
    int j = 0;
    bbvn.a(this.jdField_a_of_type_Bbvq.a, null);
    anvk localanvk = (anvk)bbvn.a(this.jdField_a_of_type_Bbvq.a).getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localanvk != null)
    {
      Object localObject2 = localanvk.a(bbvn.a(this.jdField_a_of_type_Bbvq.a).getAccount());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = bbvn.a(this.jdField_a_of_type_Bbvq.a).getAccount();
      }
      localObject2 = ((ExtensionInfo)localObject1).getRichStatus();
      if ((localObject2 != null) && ((!TextUtils.isEmpty(((RichStatus)localObject2).actionText)) || (!TextUtils.isEmpty(((RichStatus)localObject2).dataText)) || (!TextUtils.isEmpty(((RichStatus)localObject2).toSpannableStringWithoutAction())))) {
        break label219;
      }
      i = 1;
      if ((this.jdField_a_of_type_Boolean) && (i == 0))
      {
        long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
        ((ExtensionInfo)localObject1).setRichBuffer(new byte[0], l);
        localanvk.a((ExtensionInfo)localObject1);
      }
    }
    ThreadManager.getUIHandler().post(new StatusManager.3.2.1(this));
    Object localObject1 = gk.a();
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = j;; i = -1)
    {
      ((gk)localObject1).a(i, RichStatus.getEmptyStatus(), null, 1);
      return;
      label219:
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusManager.3.2
 * JD-Core Version:    0.7.0.1
 */