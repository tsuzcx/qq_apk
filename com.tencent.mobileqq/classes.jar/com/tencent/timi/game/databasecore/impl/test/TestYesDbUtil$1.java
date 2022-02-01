package com.tencent.timi.game.databasecore.impl.test;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.timi.game.databasecore.impl.YesDataBaseHelper;
import com.tencent.timi.game.utils.Logger;
import java.util.List;

final class TestYesDbUtil$1
  implements Runnable
{
  public void run()
  {
    Object localObject1 = YesDataBaseHelper.a();
    Object localObject2 = ((YesDataBaseHelper)localObject1).a(TestYesEntity.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("testDb#queryDb -- ");
    localStringBuilder.append(localObject2);
    Logger.a("TestYesDbUtil", localStringBuilder.toString());
    localObject2 = new TestYesEntity();
    ((TestYesEntity)localObject2).uid = "1111";
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("");
    ((TestYesEntity)localObject2).openid = localStringBuilder.toString();
    ((TestYesEntity)localObject2).testValue = 3;
    ((YesDataBaseHelper)localObject1).a((Entity)localObject2);
    localObject2 = new TestYesEntity();
    ((TestYesEntity)localObject2).uid = "2222";
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("");
    ((TestYesEntity)localObject2).openid = localStringBuilder.toString();
    ((TestYesEntity)localObject2).testValue = 4;
    ((YesDataBaseHelper)localObject1).a((Entity)localObject2);
    localObject2 = ((YesDataBaseHelper)localObject1).a(TestYesEntity.class);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("testDb#queryDb2 after insert -- ");
    localStringBuilder.append(localObject2);
    Logger.a("TestYesDbUtil", localStringBuilder.toString());
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      ((YesDataBaseHelper)localObject1).b((Entity)((List)localObject2).get(0));
      localObject1 = ((YesDataBaseHelper)localObject1).a(TestYesEntity.class);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("testDb#queryDb3 after delete -- ");
      ((StringBuilder)localObject2).append(localObject1);
      Logger.a("TestYesDbUtil", ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.databasecore.impl.test.TestYesDbUtil.1
 * JD-Core Version:    0.7.0.1
 */