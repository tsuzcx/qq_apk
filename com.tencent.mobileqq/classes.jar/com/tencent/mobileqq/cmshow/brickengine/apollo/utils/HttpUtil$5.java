package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IRenderRunner;
import java.util.Map;

final class HttpUtil$5
  implements ApolloHttpResponseCallback
{
  HttpUtil$5(View paramView, long paramLong, String paramString1, String paramString2, ApolloRender paramApolloRender) {}
  
  public void a(int paramInt, @NonNull Map<String, String> paramMap, @NonNull byte[] paramArrayOfByte)
  {
    View localView = this.a;
    if (!(localView instanceof IRenderRunner)) {
      return;
    }
    ((IRenderRunner)localView).runRenderTask(new HttpUtil.5.1(this, paramMap, paramInt, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.HttpUtil.5
 * JD-Core Version:    0.7.0.1
 */