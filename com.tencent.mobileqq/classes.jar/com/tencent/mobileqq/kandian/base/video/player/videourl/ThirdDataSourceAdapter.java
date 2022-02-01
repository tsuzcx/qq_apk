package com.tencent.mobileqq.kandian.base.video.player.videourl;

import com.tencent.image.AbsThirdDataSourceAdapter;
import com.tencent.image.AbsThirdDataSourceAdapter.OnPreparedCallback;

public class ThirdDataSourceAdapter
  extends AbsThirdDataSourceAdapter
{
  int jdField_a_of_type_Int = 2;
  private AbsThirdDataSourceAdapter.OnPreparedCallback jdField_a_of_type_ComTencentImageAbsThirdDataSourceAdapter$OnPreparedCallback;
  private String jdField_a_of_type_JavaLangString = "";
  private int b = 0;
  private int c = 0;
  
  public ThirdDataSourceAdapter(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int getPlayType()
  {
    return this.c;
  }
  
  public int getStaus()
  {
    return this.b;
  }
  
  public String getURL()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void requestPrepare(String paramString, AbsThirdDataSourceAdapter.OnPreparedCallback paramOnPreparedCallback)
  {
    this.jdField_a_of_type_ComTencentImageAbsThirdDataSourceAdapter$OnPreparedCallback = paramOnPreparedCallback;
    this.b = 1;
    paramOnPreparedCallback = ThirdVideoManager.a();
    ThirdDataSourceAdapter.1 local1 = new ThirdDataSourceAdapter.1(this);
    int i = this.jdField_a_of_type_Int;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdDataSourceAdapter
 * JD-Core Version:    0.7.0.1
 */