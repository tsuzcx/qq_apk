package com.tencent.mobileqq.troop.filemanager.data;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class TroopFileSearchManager$CallableForSearchData
  implements Callable<List<IContactSearchable>>
{
  private Context b;
  private QQAppInterface c;
  private long d;
  
  public TroopFileSearchManager$CallableForSearchData(TroopFileSearchManager paramTroopFileSearchManager, Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    this.b = paramContext;
    this.c = paramQQAppInterface;
    this.d = paramLong;
  }
  
  public List<IContactSearchable> a()
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    long l2 = IContactSearchable.I;
    long l3 = this.d;
    Object localObject;
    if (l2 == l3)
    {
      localObject = this.a;
      ((TroopFileSearchManager)localObject).a = ((TroopFileSearchManager)localObject).a(this.b, this.c, l3, true);
      localArrayList.addAll(this.a.a);
      localObject = this.a;
      ((TroopFileSearchManager)localObject).b = ((TroopFileSearchManager)localObject).a(this.b, this.c, false);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CallableForSearchData time = ");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
      QLog.d("zivonchen", 2, ((StringBuilder)localObject).toString());
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchManager.CallableForSearchData
 * JD-Core Version:    0.7.0.1
 */