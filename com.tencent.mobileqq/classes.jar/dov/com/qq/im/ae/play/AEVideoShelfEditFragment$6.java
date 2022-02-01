package dov.com.qq.im.ae.play;

import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;

class AEVideoShelfEditFragment$6
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  AEVideoShelfEditFragment$6(AEVideoShelfEditFragment paramAEVideoShelfEditFragment, ScaleMoveImageViewer paramScaleMoveImageViewer, NodeItem paramNodeItem) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.val$moveView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    for (;;)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.val$moveView.getLayoutParams();
      int i = (int)(this.val$nodeItem.maskRect.left * AEVideoShelfEditFragment.access$200(this.this$0));
      int j = (int)(this.val$nodeItem.maskRect.top * AEVideoShelfEditFragment.access$300(this.this$0));
      int k = (int)((1.0F - this.val$nodeItem.maskRect.right) * AEVideoShelfEditFragment.access$200(this.this$0));
      int m = (int)((1.0F - this.val$nodeItem.maskRect.bottom) * AEVideoShelfEditFragment.access$300(this.this$0));
      localMarginLayoutParams.leftMargin = i;
      localMarginLayoutParams.topMargin = j;
      localMarginLayoutParams.rightMargin = k;
      localMarginLayoutParams.bottomMargin = m;
      localMarginLayoutParams.width = (AEVideoShelfEditFragment.access$200(this.this$0) - k - i);
      localMarginLayoutParams.height = (AEVideoShelfEditFragment.access$300(this.this$0) - m - j);
      this.val$moveView.setLayoutParams(localMarginLayoutParams);
      AEVideoShelfEditFragment.access$1600(this.this$0, this.val$moveView, AEVideoShelfEditFragment.access$200(this.this$0), AEVideoShelfEditFragment.access$300(this.this$0));
      if (QLog.isDebugVersion()) {
        QLog.d("AEVideoShelfEditFrag", 2, new Object[] { "initAllNodeViewer onGlobalLayout: wxh=", Integer.valueOf(localMarginLayoutParams.width), "x", Integer.valueOf(localMarginLayoutParams.height) });
      }
      return;
      this.val$moveView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEVideoShelfEditFragment.6
 * JD-Core Version:    0.7.0.1
 */