package com.tencent.mobileqq.richstatus;

import android.text.TextUtils;
import anyw;
import bbvd;
import bbvg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import gm;
import mqq.os.MqqHandler;

public class StatusManager$3$2
  implements Runnable
{
  public StatusManager$3$2(bbvg parambbvg, boolean paramBoolean) {}
  
  public void run()
  {
    int j = 0;
    bbvd.a(this.jdField_a_of_type_Bbvg.a, null);
    anyw localanyw = (anyw)bbvd.a(this.jdField_a_of_type_Bbvg.a).getManager(51);
    if (localanyw != null)
    {
      Object localObject2 = localanyw.a(bbvd.a(this.jdField_a_of_type_Bbvg.a).getAccount());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = bbvd.a(this.jdField_a_of_type_Bbvg.a).getAccount();
      }
      localObject2 = ((ExtensionInfo)localObject1).getRichStatus();
      if ((localObject2 != null) && ((!TextUtils.isEmpty(((RichStatus)localObject2).actionText)) || (!TextUtils.isEmpty(((RichStatus)localObject2).dataText)) || (!TextUtils.isEmpty(((RichStatus)localObject2).toSpannableStringWithoutAction())))) {
        break label218;
      }
      i = 1;
      if ((this.jdField_a_of_type_Boolean) && (i == 0))
      {
        long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
        ((ExtensionInfo)localObject1).setRichBuffer(new byte[0], l);
        localanyw.a((ExtensionInfo)localObject1);
      }
    }
    ThreadManager.getUIHandler().post(new StatusManager.3.2.1(this));
    Object localObject1 = gm.a();
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = j;; i = -1)
    {
      ((gm)localObject1).a(i, RichStatus.getEmptyStatus(), null, 1);
      return;
      label218:
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusManager.3.2
 * JD-Core Version:    0.7.0.1
 */