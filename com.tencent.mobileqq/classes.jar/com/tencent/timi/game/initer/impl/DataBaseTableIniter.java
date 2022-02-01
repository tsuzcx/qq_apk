package com.tencent.timi.game.initer.impl;

import android.text.TextUtils;
import com.tencent.timi.game.databasecore.impl.YesDataBaseHelper;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.userinfo.api.IUserInfoService;
import com.tencent.timi.game.utils.Logger;

public class DataBaseTableIniter
{
  public static void a()
  {
    Logger.a("DataBaseTableIniter", 1, "init");
    b();
    String str = ((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).b();
    if (!TextUtils.isEmpty(str))
    {
      YesDataBaseHelper.a().a(str);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin is empty!!! ");
    localStringBuilder.append(str);
    Logger.a("DataBaseTableIniter", localStringBuilder.toString(), new Exception());
  }
  
  private static void b()
  {
    Logger.a("DataBaseTableIniter", "registerTables");
    ((IUserInfoService)ServiceCenter.a(IUserInfoService.class)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.initer.impl.DataBaseTableIniter
 * JD-Core Version:    0.7.0.1
 */