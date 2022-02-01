package com.tencent.mobileqq.confess;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.campuscircle.CampusCircleIpcClient;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

class ConfessPlugin$6
  implements Runnable
{
  ConfessPlugin$6(ConfessPlugin paramConfessPlugin) {}
  
  public void run()
  {
    String str = this.this$0.g;
    if (TextUtils.isEmpty(str))
    {
      ThreadManager.getUIHandler().post(new ConfessPlugin.6.1(this));
      return;
    }
    Object localObject = CampusCircleIpcClient.a().b(str);
    ThreadManager.getUIHandler().post(new ConfessPlugin.6.2(this));
    if ((localObject != null) && (localObject.length == 3))
    {
      boolean bool1 = ((Boolean)localObject[0]).booleanValue();
      boolean bool2 = ((Boolean)localObject[1]).booleanValue();
      if (localObject[2] == null) {
        localObject = null;
      } else {
        localObject = (List)localObject[2];
      }
      if (!bool2)
      {
        localObject = this.this$0;
        ((ConfessPlugin)localObject).callJs(((ConfessPlugin)localObject).h, new String[] { "\"本群成员不能向好友发起加群邀请。\"" });
        return;
      }
      if ((localObject != null) && (((List)localObject).size() != 0))
      {
        if (!ConfessPlugin.a(this.this$0, str, bool1, (ArrayList)localObject))
        {
          localObject = this.this$0;
          ((ConfessPlugin)localObject).callJs(((ConfessPlugin)localObject).h, new String[] { "\"邀请群成员异常。\"" });
        }
      }
      else
      {
        localObject = this.this$0;
        ((ConfessPlugin)localObject).callJs(((ConfessPlugin)localObject).h, new String[] { "\"获取群成员失败，请重试。\"" });
      }
    }
    else
    {
      localObject = this.this$0;
      ((ConfessPlugin)localObject).callJs(((ConfessPlugin)localObject).h, new String[] { "\"邀请群成员异常。\"" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessPlugin.6
 * JD-Core Version:    0.7.0.1
 */