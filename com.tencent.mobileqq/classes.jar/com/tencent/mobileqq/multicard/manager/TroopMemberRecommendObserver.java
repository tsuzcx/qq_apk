package com.tencent.mobileqq.multicard.manager;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.multicard.RecommendPerson;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

public class TroopMemberRecommendObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, String paramString, int paramInt, Map<Integer, List<RecommendPerson>> paramMap) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.obsever", 2, " onUpdate() type =" + paramInt + " isSuccess = " + paramBoolean);
    }
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberRecommend.obsever", 2, " default type =" + paramInt);
      }
      break;
    }
    do
    {
      return;
    } while (!(paramObject instanceof Object[]));
    paramObject = (Object[])paramObject;
    Map localMap = (Map)paramObject[0];
    a(paramBoolean, (String)paramObject[1], ((Integer)paramObject[2]).intValue(), localMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.manager.TroopMemberRecommendObserver
 * JD-Core Version:    0.7.0.1
 */