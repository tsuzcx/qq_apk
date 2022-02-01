package com.tencent.qqmini.miniapp.widget.media.live;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.ITXSnapshotListener;

class TXLivePusherJSAdapter$1
  implements TXLivePushListenerReflect.ITXSnapshotListener
{
  TXLivePusherJSAdapter$1(TXLivePusherJSAdapter paramTXLivePusherJSAdapter, TXLivePushListenerReflect.ITXSnapshotListener paramITXSnapshotListener, boolean paramBoolean) {}
  
  public void onSnapshot(Bitmap paramBitmap)
  {
    Object localObject = this.val$listener;
    if (localObject != null)
    {
      if (this.val$needCompress)
      {
        if (paramBitmap != null)
        {
          int i = paramBitmap.getWidth();
          int j = paramBitmap.getHeight();
          localObject = new Matrix();
          ((Matrix)localObject).setScale(0.5F, 0.5F);
          localObject = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject, false);
          this.val$listener.onSnapshot((Bitmap)localObject);
          TXLivePusherJSAdapter.access$000(this.this$0, paramBitmap);
          return;
        }
        ((TXLivePushListenerReflect.ITXSnapshotListener)localObject).onSnapshot(paramBitmap);
        return;
      }
      ((TXLivePushListenerReflect.ITXSnapshotListener)localObject).onSnapshot(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.live.TXLivePusherJSAdapter.1
 * JD-Core Version:    0.7.0.1
 */