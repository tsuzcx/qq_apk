package com.tencent.mobileqq.qassistant.util;

import android.app.Activity;
import com.tencent.mobileqq.testassister.ShareAppLogHelper.OnGetLocalLogListener;
import java.util.ArrayList;
import java.util.List;

final class CommandUtils$3
  implements ShareAppLogHelper.OnGetLocalLogListener
{
  CommandUtils$3(List paramList, Activity paramActivity) {}
  
  public void a(int paramInt)
  {
    CommandUtils.a(this.a, this.b);
  }
  
  public void a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = this.a;
    if (localList != null) {
      localArrayList.addAll(localList);
    }
    if (paramString != null) {
      localArrayList.add(paramString);
    }
    CommandUtils.a(localArrayList, this.b);
  }
  
  public void b(int paramInt)
  {
    CommandUtils.a(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.util.CommandUtils.3
 * JD-Core Version:    0.7.0.1
 */