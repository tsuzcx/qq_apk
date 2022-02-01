package com.tencent.mobileqq.vas.adv.web;

import com.tencent.mobileqq.vas.adv.reward.callback.VasRewardAdCallback;
import kotlin.Metadata;
import kotlin.text.Charsets;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/adv/web/VasAdvWebPlugin$getVasRewardAdCallback$1", "Lcom/tencent/mobileqq/vas/adv/reward/callback/VasRewardAdCallback;", "onReward", "", "retCode", "", "requestBizBuff", "", "reportBizBuff", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasAdvWebPlugin$getVasRewardAdCallback$1
  implements VasRewardAdCallback
{
  VasAdvWebPlugin$getVasRewardAdCallback$1(String paramString) {}
  
  public void onReward(int paramInt, @Nullable byte[] paramArrayOfByte1, @Nullable byte[] paramArrayOfByte2)
  {
    paramArrayOfByte2 = new JSONObject();
    paramArrayOfByte2.put("returnCode", paramInt);
    JSONObject localJSONObject = new JSONObject();
    if (paramArrayOfByte1 != null) {
      localJSONObject.put("request_busi_buff", new String(paramArrayOfByte1, Charsets.UTF_8));
    }
    paramArrayOfByte2.put("data", localJSONObject);
    this.jdField_a_of_type_ComTencentMobileqqVasAdvWebVasAdvWebPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramArrayOfByte2.toString(0) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.web.VasAdvWebPlugin.getVasRewardAdCallback.1
 * JD-Core Version:    0.7.0.1
 */