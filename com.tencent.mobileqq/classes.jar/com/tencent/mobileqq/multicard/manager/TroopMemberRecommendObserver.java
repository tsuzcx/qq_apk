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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" onUpdate() type =");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("TroopMemberRecommend.obsever", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt != 1)
    {
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append(" default type =");
        paramObject.append(paramInt);
        QLog.d("TroopMemberRecommend.obsever", 2, paramObject.toString());
      }
    }
    else if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      localObject = (Map)paramObject[0];
      a(paramBoolean, (String)paramObject[1], ((Integer)paramObject[2]).intValue(), (Map)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.manager.TroopMemberRecommendObserver
 * JD-Core Version:    0.7.0.1
 */