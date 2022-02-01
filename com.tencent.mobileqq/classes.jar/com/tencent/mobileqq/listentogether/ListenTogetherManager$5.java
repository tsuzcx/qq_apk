package com.tencent.mobileqq.listentogether;

import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.listentogether.player.IPlayCallback;

class ListenTogetherManager$5
  implements IPlayCallback
{
  ListenTogetherManager$5(ListenTogetherManager paramListenTogetherManager) {}
  
  public void a(ISong paramISong)
  {
    if (paramISong != null)
    {
      ListenTogetherManager.a(this.a, paramISong);
      this.a.b(paramISong.a());
      String str = (String)ListenTogetherManager.m(this.a).get(paramISong.a());
      if (!TextUtils.isEmpty(str))
      {
        ListenTogetherManager.a(this.a, paramISong.a(), str);
        return;
      }
      ListenTogetherManager.a(this.a, paramISong.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherManager.5
 * JD-Core Version:    0.7.0.1
 */