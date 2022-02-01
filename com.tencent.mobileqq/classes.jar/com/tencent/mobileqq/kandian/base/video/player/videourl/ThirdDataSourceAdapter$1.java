package com.tencent.mobileqq.kandian.base.video.player.videourl;

import com.tencent.image.AbsThirdDataSourceAdapter.OnPreparedCallback;

class ThirdDataSourceAdapter$1
  implements ThirdVideoManager.UUIDToUrlCallback
{
  ThirdDataSourceAdapter$1(ThirdDataSourceAdapter paramThirdDataSourceAdapter) {}
  
  public void a(VideoUrlInfo paramVideoUrlInfo)
  {
    ThirdDataSourceAdapter.a(this.a, 2);
    ThirdDataSourceAdapter localThirdDataSourceAdapter = this.a;
    String str;
    if (paramVideoUrlInfo.a == null) {
      str = "";
    } else {
      str = paramVideoUrlInfo.a;
    }
    ThirdDataSourceAdapter.a(localThirdDataSourceAdapter, str);
    if (paramVideoUrlInfo.d == 1) {
      ThirdDataSourceAdapter.b(this.a, 1);
    } else {
      ThirdDataSourceAdapter.b(this.a, 0);
    }
    if (ThirdDataSourceAdapter.a(this.a) != null) {
      ThirdDataSourceAdapter.a(this.a).onPrepared();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdDataSourceAdapter.1
 * JD-Core Version:    0.7.0.1
 */