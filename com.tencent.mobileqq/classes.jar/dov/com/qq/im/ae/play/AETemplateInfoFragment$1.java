package dov.com.qq.im.ae.play;

import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.videoshelf.model.template.VideoShelfTemplate;

class AETemplateInfoFragment$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  AETemplateInfoFragment$1(AETemplateInfoFragment paramAETemplateInfoFragment) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      AETemplateInfoFragment.access$000(this.this$0).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      if (AETemplateInfoFragment.access$100(this.this$0) != null) {
        break label50;
      }
    }
    label50:
    float f1;
    float f2;
    do
    {
      do
      {
        return;
        AETemplateInfoFragment.access$000(this.this$0).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        break;
      } while ((AETemplateInfoFragment.access$100(this.this$0).getVideoHeight() == 0) || (AETemplateInfoFragment.access$100(this.this$0).getVideoWidth() == 0));
      f1 = AETemplateInfoFragment.access$100(this.this$0).getVideoWidth() / AETemplateInfoFragment.access$100(this.this$0).getVideoHeight();
      i = AETemplateInfoFragment.access$000(this.this$0).getWidth();
      int j = AETemplateInfoFragment.access$000(this.this$0).getHeight();
      f2 = i / j;
      if (QLog.isDebugVersion()) {
        QLog.d("AETemplateInfoFragment", 2, new Object[] { "adjust player size---origin w:h=", Integer.valueOf(i), ":", Integer.valueOf(j), " availableRatio(w/h)=", Float.valueOf(f2), " video aspectRation(w/h)=" + f1 });
      }
      if (f1 < f2)
      {
        double d = AETemplateInfoFragment.access$000(this.this$0).getHeight();
        i = (int)(f1 * d);
        localObject = AETemplateInfoFragment.access$000(this.this$0).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = i;
        AETemplateInfoFragment.access$000(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
    } while (f1 <= f2);
    int i = (int)(AETemplateInfoFragment.access$000(this.this$0).getWidth() / f1);
    Object localObject = (ViewGroup.MarginLayoutParams)AETemplateInfoFragment.access$000(this.this$0).getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).height = i;
    AETemplateInfoFragment.access$000(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AETemplateInfoFragment.1
 * JD-Core Version:    0.7.0.1
 */