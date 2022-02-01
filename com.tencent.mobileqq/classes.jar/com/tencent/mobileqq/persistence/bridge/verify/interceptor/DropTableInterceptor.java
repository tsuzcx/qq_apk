package com.tencent.mobileqq.persistence.bridge.verify.interceptor;

import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.data.entitymanager.FindTableNameInterceptorChain;
import com.tencent.mobileqq.data.entitymanager.Interceptor.Chain;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.util.ArrayUtils;

public class DropTableInterceptor
  extends FindTableClassInterceptor
{
  static final String[] a = { "WhiteListItem", "TroopAIOCommonAppInfo", "TroopVideoUrlEntity", "FreshNewsInfo", "GodListConfig", "GodEntity", "DatingSig", "DatingFeedInfo", "OpenTroopInfo", "TroopStorySnapListEntity", "SearchHistoryEntity", "TroopTopicDetailInfo", "MiniAppInfo" };
  
  private boolean a(String paramString, int paramInt)
  {
    if ((paramString.startsWith("RedPacketData_")) && (paramInt < 214)) {
      return true;
    }
    return ArrayUtils.a(a, paramString);
  }
  
  public Class a(Interceptor.Chain<Class> paramChain)
  {
    FindTableNameInterceptorChain localFindTableNameInterceptorChain = (FindTableNameInterceptorChain)paramChain;
    String str = a(paramChain);
    if (a(str, localFindTableNameInterceptorChain.oldVersion))
    {
      localFindTableNameInterceptorChain.db.execSQL(TableBuilder.dropSQLStatement(str));
      return null;
    }
    return (Class)paramChain.proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.verify.interceptor.DropTableInterceptor
 * JD-Core Version:    0.7.0.1
 */