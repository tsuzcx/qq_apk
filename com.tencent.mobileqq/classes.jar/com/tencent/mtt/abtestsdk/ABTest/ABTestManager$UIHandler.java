package com.tencent.mtt.abtestsdk.ABTest;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.LruCache;
import com.tencent.mtt.abtestsdk.listener.OnUpdateExperimentsListener;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import org.json.JSONException;
import org.json.JSONObject;

class ABTestManager$UIHandler
  extends Handler
{
  private OnUpdateExperimentsListener mListener;
  
  ABTestManager$UIHandler(OnUpdateExperimentsListener paramOnUpdateExperimentsListener)
  {
    super(Looper.getMainLooper());
    this.mListener = paramOnUpdateExperimentsListener;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      int i = paramMessage.arg1;
      String str = (String)paramMessage.obj;
      ABTestLog.debug("get experiments failed, errCode=" + i + "  errMsg:" + str, new Object[0]);
      if (this.mListener != null)
      {
        this.mListener.updateExperimentsFailed(paramMessage.arg1, (String)paramMessage.obj);
        return;
        try
        {
          ABTestManager.IS_SDK_HAS_INIT = true;
          ABTestLog.debug("get experiments success, resInfo =" + paramMessage.obj, new Object[0]);
          paramMessage = new JSONObject((String)paramMessage.obj);
          if (paramMessage.optInt("code") == 0) {
            ABTestManager.access$500().put("cache", paramMessage);
          }
          if (this.mListener != null)
          {
            this.mListener.updateExperimentsSucceed(paramMessage);
            return;
          }
        }
        catch (JSONException paramMessage)
        {
          ABTestLog.error(paramMessage.getMessage(), new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.ABTest.ABTestManager.UIHandler
 * JD-Core Version:    0.7.0.1
 */