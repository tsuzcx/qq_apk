package com.tencent.mobileqq.profile;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

class ProfileCardManager$1
  implements Runnable
{
  ProfileCardManager$1(ProfileCardManager paramProfileCardManager, File paramFile, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = FileUtils.readFileToStringEx(this.a, -1);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        localObject1 = new JSONObject((String)localObject1).optJSONArray("baseInfo");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(0);
          localObject1 = new ProfileCardManager.DefaultCardItem(this.this$0, this.b);
          ((ProfileCardManager.DefaultCardItem)localObject1).b = localJSONObject.optString("name");
          Object localObject2 = localJSONObject.optJSONObject("previewImage");
          StringBuilder localStringBuilder;
          if (localObject2 != null)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(ProfileCardManager.c);
            localStringBuilder.append(((JSONObject)localObject2).optString("src"));
            ((ProfileCardManager.DefaultCardItem)localObject1).c = localStringBuilder.toString();
          }
          localObject2 = localJSONObject.optJSONObject("coverImg");
          if (localObject2 != null)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(ProfileCardManager.c);
            localStringBuilder.append(((JSONObject)localObject2).optString("src"));
            ((ProfileCardManager.DefaultCardItem)localObject1).d = localStringBuilder.toString();
          }
          localJSONObject = localJSONObject.optJSONObject("detailImage");
          if (localJSONObject != null)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(ProfileCardManager.c);
            ((StringBuilder)localObject2).append(localJSONObject.optString("src"));
            ((ProfileCardManager.DefaultCardItem)localObject1).e = ((StringBuilder)localObject2).toString();
          }
          ((ProfileCardManager.DefaultCardItem)localObject1).f = true;
          ProfileCardManager.a(this.this$0).put(Integer.valueOf(this.b), localObject1);
          if (this.this$0.h != null)
          {
            this.this$0.h.removeMessages(101);
            this.this$0.h.sendEmptyMessageDelayed(101, 100L);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("ProfileCardManager", 2, "getDefaultCardItem: ", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardManager.1
 * JD-Core Version:    0.7.0.1
 */