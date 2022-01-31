import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.biz.pubaccount.readinjoy.model.FollowCoverInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.TopicRecommendFeedsInfo;

public class lra
  implements Runnable
{
  public lra(FollowCoverInfoModule paramFollowCoverInfoModule) {}
  
  public void run()
  {
    Object localObject1 = ReadInJoyHelper.a(FollowCoverInfoModule.a(this.a), true, false);
    if (localObject1 != null) {
      try
      {
        FollowCoverInfoModule.a(this.a, ((SharedPreferences)localObject1).getInt("follow_tab_topic_update_info_exists", 0));
        if (FollowCoverInfoModule.a(this.a) == 1)
        {
          Object localObject2 = ((SharedPreferences)localObject1).getString("follow_tab_topic_update_info", null);
          Object localObject3;
          if (localObject2 != null)
          {
            localObject2 = Base64.decode((String)localObject2, 0);
            localObject3 = new oidb_cmd0x68b.TopicRecommendFeedsInfo();
            ((oidb_cmd0x68b.TopicRecommendFeedsInfo)localObject3).mergeFrom((byte[])localObject2);
            FollowCoverInfoModule.a(this.a, TopicRecommendFeedsInfo.a((oidb_cmd0x68b.TopicRecommendFeedsInfo)localObject3));
          }
          localObject1 = ((SharedPreferences)localObject1).getString("follow_tab_topic_update_info_exposure", null);
          if (localObject1 != null)
          {
            localObject1 = new JSONObject((String)localObject1);
            localObject2 = ((JSONObject)localObject1).keys();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (String)((Iterator)localObject2).next();
              Long localLong = Long.valueOf(((JSONObject)localObject1).optLong((String)localObject3, 0L));
              if (localLong.longValue() != 0L) {
                FollowCoverInfoModule.a(this.a).put(Long.valueOf((String)localObject3), localLong);
              }
            }
          }
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        FollowCoverInfoModule.a(this.a, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lra
 * JD-Core Version:    0.7.0.1
 */