package cooperation.vip.web;

import cooperation.vip.reward.VasRewardAdCallback;
import kotlin.Metadata;
import kotlin.text.Charsets;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"cooperation/vip/web/VasAdvWebPlugin$handleRewardVideo$rewardCallback$1", "Lcooperation/vip/reward/VasRewardAdCallback;", "onReward", "", "retCode", "", "requestBizBuff", "", "reportBizBuff", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasAdvWebPlugin$handleRewardVideo$rewardCallback$1
  implements VasRewardAdCallback
{
  VasAdvWebPlugin$handleRewardVideo$rewardCallback$1(String paramString) {}
  
  public void a(int paramInt, @Nullable byte[] paramArrayOfByte1, @Nullable byte[] paramArrayOfByte2)
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("returnCode", paramInt);
    JSONObject localJSONObject2 = new JSONObject();
    if (paramArrayOfByte1 != null) {
      localJSONObject2.put("request_busi_buff", new String(paramArrayOfByte1, Charsets.UTF_8));
    }
    if (paramArrayOfByte2 != null) {
      localJSONObject2.put("report_busi_buff", new String(paramArrayOfByte2, Charsets.UTF_8));
    }
    localJSONObject1.put("data", localJSONObject2);
    this.jdField_a_of_type_CooperationVipWebVasAdvWebPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject1.toString(0) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.web.VasAdvWebPlugin.handleRewardVideo.rewardCallback.1
 * JD-Core Version:    0.7.0.1
 */