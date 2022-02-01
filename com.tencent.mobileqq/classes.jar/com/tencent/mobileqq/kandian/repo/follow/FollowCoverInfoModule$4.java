package com.tencent.mobileqq.kandian.repo.follow;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class FollowCoverInfoModule$4
  implements Runnable
{
  public void run()
  {
    Object localObject = RIJSPUtils.a(FollowCoverInfoModule.a(this.this$0), true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null) {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          Iterator localIterator = this.a.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(localEntry.getKey());
            localJSONObject.put(localStringBuilder.toString(), localEntry.getValue());
          }
          ((SharedPreferences.Editor)localObject).putString("follow_tab_topic_update_info_exposure", localJSONObject.toString());
          RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
          return;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.follow.FollowCoverInfoModule.4
 * JD-Core Version:    0.7.0.1
 */