package com.tencent.mobileqq.soload.api.impl;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.soload.biz.OnGetSoLoadInfoListener;
import com.tencent.mobileqq.soload.biz.entity.SoLoadInfo;

class SoLoaderLogic$1
  implements OnGetSoLoadInfoListener
{
  SoLoaderLogic$1(SoLoaderLogic paramSoLoaderLogic) {}
  
  public void onGetLoadInfo(@NonNull SoLoadInfo paramSoLoadInfo)
  {
    int i = SoLoaderLogic.a(this.a, paramSoLoadInfo);
    SoLoaderLogic.a(this.a, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.SoLoaderLogic.1
 * JD-Core Version:    0.7.0.1
 */