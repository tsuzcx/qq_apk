package com.tencent.tmediacodec.hook;

import android.graphics.SurfaceTexture;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class HookManager$1
  implements THookTextureView.SurfaceTextureHookCallback
{
  public boolean onSurfaceTextureDestroyedCalled(@Nullable SurfaceTexture paramSurfaceTexture)
  {
    if (paramSurfaceTexture == null) {
      return true;
    }
    Object localObject = paramSurfaceTexture.toString();
    Iterator localIterator = HookManager.access$000().keySet().iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.equals((String)localIterator.next(), (CharSequence)localObject))
      {
        localObject = (SurfaceCallback)HookManager.access$000().get(localObject);
        if (localObject != null) {
          ((SurfaceCallback)localObject).onDestroy(paramSurfaceTexture);
        }
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmediacodec.hook.HookManager.1
 * JD-Core Version:    0.7.0.1
 */