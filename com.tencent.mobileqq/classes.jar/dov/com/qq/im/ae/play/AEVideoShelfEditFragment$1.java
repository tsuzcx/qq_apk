package dov.com.qq.im.ae.play;

import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.videoshelf.model.template.VideoShelfTemplate;

class AEVideoShelfEditFragment$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  AEVideoShelfEditFragment$1(AEVideoShelfEditFragment paramAEVideoShelfEditFragment) {}
  
  public void onGlobalLayout()
  {
    double d;
    int i;
    if (Build.VERSION.SDK_INT >= 16)
    {
      AEVideoShelfEditFragment.access$000(this.this$0).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      d = 0.0D;
      if ((AEVideoShelfEditFragment.access$100(this.this$0) == null) || (AEVideoShelfEditFragment.access$100(this.this$0).getVideoHeight() == 0)) {
        break label345;
      }
      d = AEVideoShelfEditFragment.access$100(this.this$0).getVideoWidth() / AEVideoShelfEditFragment.access$100(this.this$0).getVideoHeight();
      if (d < 1.0D) {
        break label253;
      }
      i = 1;
    }
    for (;;)
    {
      label79:
      Object localObject;
      if (i != 0) {
        if (d < 3.0D)
        {
          i = (int)(AEVideoShelfEditFragment.access$000(this.this$0).getWidth() / d);
          localObject = (ViewGroup.MarginLayoutParams)AEVideoShelfEditFragment.access$000(this.this$0).getLayoutParams();
          ((ViewGroup.MarginLayoutParams)localObject).height = i;
          AEVideoShelfEditFragment.access$000(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
          AEVideoShelfEditFragment.access$202(this.this$0, AEVideoShelfEditFragment.access$000(this.this$0).getWidth());
          AEVideoShelfEditFragment.access$302(this.this$0, ((ViewGroup.MarginLayoutParams)localObject).height);
        }
      }
      for (;;)
      {
        if (QLog.isDebugVersion()) {
          QLog.d("AEVideoShelfEditFrag", 2, new Object[] { "centerView onGlobalLayout: ratio=", Double.valueOf(d), ", wxh=", Integer.valueOf(AEVideoShelfEditFragment.access$200(this.this$0)), "x", Integer.valueOf(AEVideoShelfEditFragment.access$300(this.this$0)) });
        }
        return;
        AEVideoShelfEditFragment.access$000(this.this$0).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        break;
        label253:
        i = 0;
        break label79;
        if (d > 0.3333333333333333D)
        {
          i = (int)(AEVideoShelfEditFragment.access$000(this.this$0).getHeight() * d);
          localObject = AEVideoShelfEditFragment.access$000(this.this$0).getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).width = i;
          AEVideoShelfEditFragment.access$000(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
          AEVideoShelfEditFragment.access$202(this.this$0, ((ViewGroup.LayoutParams)localObject).width);
          AEVideoShelfEditFragment.access$302(this.this$0, AEVideoShelfEditFragment.access$000(this.this$0).getHeight());
        }
      }
      label345:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEVideoShelfEditFragment.1
 * JD-Core Version:    0.7.0.1
 */