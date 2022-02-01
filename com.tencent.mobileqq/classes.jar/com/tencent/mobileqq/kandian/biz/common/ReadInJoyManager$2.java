package com.tencent.mobileqq.kandian.biz.common;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import java.util.List;

class ReadInJoyManager$2
  implements Runnable
{
  public void run()
  {
    int i = 0;
    Object localObject1 = "";
    while (i < this.a.size())
    {
      int j = ((Integer)this.a.get(i)).intValue();
      localObject2 = localObject1;
      if (i > 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(",");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(j);
      localObject1 = ((StringBuilder)localObject1).toString();
      i += 1;
    }
    if (ReadInJoyManager.a(this.this$0) == null) {
      return;
    }
    Object localObject2 = ReadInJoyManager.a(this.this$0).getString("config_new_channel_id_list", "");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    if (((String)localObject2).equals(localObject1)) {
      return;
    }
    localObject2 = ReadInJoyManager.a(this.this$0).edit();
    ((SharedPreferences.Editor)localObject2).putString("config_new_channel_id_list", (String)localObject1);
    ((SharedPreferences.Editor)localObject2).putInt("config_new_channel_notify_flag", 1);
    RIJSPUtils.a((SharedPreferences.Editor)localObject2, true);
    ReadInJoyManager.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyManager.2
 * JD-Core Version:    0.7.0.1
 */