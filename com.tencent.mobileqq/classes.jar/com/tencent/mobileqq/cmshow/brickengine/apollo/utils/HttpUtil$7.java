package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.view.View;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IRenderRunner;

final class HttpUtil$7
  implements ApolloHttpProgressCallback
{
  HttpUtil$7(View paramView, ApolloRender paramApolloRender, long paramLong) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    View localView = this.a;
    if (!(localView instanceof IRenderRunner)) {
      return;
    }
    ((IRenderRunner)localView).runRenderTask(new HttpUtil.7.1(this, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.HttpUtil.7
 * JD-Core Version:    0.7.0.1
 */