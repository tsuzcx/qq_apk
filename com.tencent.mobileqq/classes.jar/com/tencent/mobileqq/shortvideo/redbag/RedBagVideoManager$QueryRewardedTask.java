package com.tencent.mobileqq.shortvideo.redbag;

import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class RedBagVideoManager$QueryRewardedTask
  extends AsyncTask<String, Integer, Boolean>
{
  RedBagVideoManager$QueryRewardedTask(RedBagVideoManager paramRedBagVideoManager) {}
  
  protected Boolean a(String... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    if (paramVarArgs == null) {
      paramVarArgs = Boolean.valueOf(false);
    }
    Object localObject;
    do
    {
      do
      {
        return paramVarArgs;
        localObject = new Bundle();
        ((Bundle)localObject).putString("VALUE_MSG_VIDEO_ID", paramVarArgs);
        paramVarArgs = VideoPlayIPCClient.a().a("CMD_QUERY_VIDEO_REDBAG_STAT", (Bundle)localObject);
        if (paramVarArgs == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RedBagVideoManager", 2, "QueryRewardedTask VideoPlayIPCClient.callServer value=null");
          }
          return Boolean.valueOf(false);
        }
        localObject = Boolean.valueOf(paramVarArgs.getBoolean("VALUE_MSG_REDBAG_STAT"));
        paramVarArgs = (String[])localObject;
      } while (!((Boolean)localObject).booleanValue());
      paramVarArgs = (String[])localObject;
    } while (RedBagVideoManager.b(this.a) == null);
    RedBagVideoManager.b(this.a).h = 1;
    return localObject;
  }
  
  protected void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue()) {
      RedBagVideoManager.c(this.a);
    }
    while (RedBagVideoManager.a(this.a)) {
      return;
    }
    RedBagVideoManager.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.QueryRewardedTask
 * JD-Core Version:    0.7.0.1
 */