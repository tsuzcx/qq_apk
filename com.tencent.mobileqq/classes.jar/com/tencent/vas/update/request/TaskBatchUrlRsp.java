package com.tencent.vas.update.request;

import android.text.TextUtils;
import com.tencent.vas.update.entity.UpdateUrlInfoPtr;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class TaskBatchUrlRsp
{
  public int mCookie;
  public ArrayList<UpdateUrlInfoPtr> mUpdateList;
  
  public static TaskBatchUrlRsp parseResponse(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        TaskBatchUrlRsp localTaskBatchUrlRsp = new TaskBatchUrlRsp();
        Object localObject = new JSONObject(paramString);
        localTaskBatchUrlRsp.mCookie = ((JSONObject)localObject).optInt("cookie");
        paramString = new ArrayList();
        if (((JSONObject)localObject).has("update_list"))
        {
          localObject = ((JSONObject)localObject).optJSONArray("update_list");
          i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            UpdateUrlInfoPtr localUpdateUrlInfoPtr = UpdateUrlInfoPtr.parseUpdateInfo(((JSONArray)localObject).getJSONObject(i));
            if (localUpdateUrlInfoPtr == null) {
              break label109;
            }
            paramString.add(localUpdateUrlInfoPtr);
            break label109;
          }
        }
        localTaskBatchUrlRsp.mUpdateList = paramString;
        return localTaskBatchUrlRsp;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      label109:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.request.TaskBatchUrlRsp
 * JD-Core Version:    0.7.0.1
 */