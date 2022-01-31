package com.tencent.sveffects;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.resource.PtuFilterResource;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;

public class SvEffectSdkInitor$QQPtuFilterResource
  implements PtuFilterResource
{
  public String a()
  {
    return PtvFilterSoLoad.b(BaseApplicationImpl.getContext());
  }
  
  public String b()
  {
    return PtvFilterSoLoad.d(BaseApplicationImpl.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.sveffects.SvEffectSdkInitor.QQPtuFilterResource
 * JD-Core Version:    0.7.0.1
 */