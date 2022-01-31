package com.tencent.mobileqq.emosm.favroaming;

import ansa;
import ansp;
import ansr;
import axrl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.List;

public class EmoAddedAuthCallback$4
  implements Runnable
{
  public EmoAddedAuthCallback$4(ansa paramansa) {}
  
  public void run()
  {
    int i = ((ansr)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(149)).b().size();
    if (i != ansp.b)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("local_size", String.valueOf(i));
      localHashMap.put("roaming_max_size", String.valueOf(ansp.b));
      axrl.a(BaseApplication.getContext()).a(null, "AddFavEmotionError", false, 0L, 0L, localHashMap, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback.4
 * JD-Core Version:    0.7.0.1
 */