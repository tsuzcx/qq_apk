package com.tencent.mobileqq.kandian.biz.ugc.video.transfer;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoErrorReport;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceStatus.ISVConfig;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;
import java.util.List;

class NormalVideoDeliverController$3
  implements ShortVideoResourceStatus.ISVConfig
{
  NormalVideoDeliverController$3(NormalVideoDeliverController paramNormalVideoDeliverController) {}
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onConfigResult result=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", serverError=");
    ((StringBuilder)localObject).append(paramInt2);
    VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", ((StringBuilder)localObject).toString(), null);
    if ((paramInt1 != 1) && (paramInt1 != 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131707615));
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("]");
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", ((StringBuilder)localObject).toString(), null);
      ShortVideoErrorReport.a(1, paramInt2);
      return;
    }
    if (paramInt2 != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131707624));
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("]");
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", ((StringBuilder)localObject).toString(), null);
      ShortVideoErrorReport.a(1, paramInt2);
      return;
    }
    localObject = new ArrayList(1);
    paramInt1 = ShortVideoResourceManager.a(NormalVideoDeliverController.a(this.a), (List)localObject);
    if (paramInt1 == 0)
    {
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", HardCodeUtil.a(2131707621), null);
      ShortVideoResourceManager.a(NormalVideoDeliverController.a(this.a), (List)localObject, this.a.a);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131707622));
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("]");
    VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", ((StringBuilder)localObject).toString(), null);
    ShortVideoErrorReport.a(1, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.video.transfer.NormalVideoDeliverController.3
 * JD-Core Version:    0.7.0.1
 */