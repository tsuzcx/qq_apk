package com.tencent.mobileqq.kandian.base.video.player.videourl;

import com.tencent.image.AbsThirdDataSourceAdapter;
import com.tencent.image.AbsThirdDataSourceAdapter.OnPreparedCallback;

public class ThirdDataSourceAdapter
  extends AbsThirdDataSourceAdapter
{
  int a = 2;
  private String b = "";
  private int c = 0;
  private AbsThirdDataSourceAdapter.OnPreparedCallback d;
  private int e = 0;
  
  public ThirdDataSourceAdapter(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int getPlayType()
  {
    return this.e;
  }
  
  public int getStaus()
  {
    return this.c;
  }
  
  public String getURL()
  {
    return this.b;
  }
  
  public void requestPrepare(String paramString, AbsThirdDataSourceAdapter.OnPreparedCallback paramOnPreparedCallback)
  {
    this.d = paramOnPreparedCallback;
    this.c = 1;
    paramOnPreparedCallback = ThirdVideoManager.a();
    ThirdDataSourceAdapter.1 local1 = new ThirdDataSourceAdapter.1(this);
    int i = this.a;
    if ((i != 2) && (i != 6))
    {
      if (i == 4) {
        paramOnPreparedCallback.a(paramString, "SQQShopAdSvr.GetUrlByVid", local1);
      }
    }
    else {
      paramOnPreparedCallback.a(paramString, local1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdDataSourceAdapter
 * JD-Core Version:    0.7.0.1
 */