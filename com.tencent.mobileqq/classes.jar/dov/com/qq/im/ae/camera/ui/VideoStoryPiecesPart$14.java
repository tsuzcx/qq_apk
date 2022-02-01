package dov.com.qq.im.ae.camera.ui;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bloe;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import dov.com.qq.im.ae.mode.AECaptureMode;
import java.util.ArrayList;

public class VideoStoryPiecesPart$14
  implements Runnable
{
  public VideoStoryPiecesPart$14(bloe parambloe) {}
  
  public void run()
  {
    Object localObject3 = (RelativeLayout)bloe.e(this.this$0).findViewById(2131376539);
    if (localObject3 != null)
    {
      Object localObject1 = bloe.a(this.this$0).getLayoutParams();
      if ((localObject1 instanceof RelativeLayout.LayoutParams))
      {
        Object localObject2 = new ArrayList();
        ((RelativeLayout)localObject3).findViewsWithText((ArrayList)localObject2, bloe.h(this.this$0).getText(AECaptureMode.GIF.textId), 1);
        if (((ArrayList)localObject2).size() == 1)
        {
          localObject3 = new Rect();
          ((View)((ArrayList)localObject2).get(0)).getGlobalVisibleRect((Rect)localObject3);
          int i = bloe.a(this.this$0).getMeasuredWidth();
          localObject2 = (RelativeLayout.LayoutParams)localObject1;
          int j = ((Rect)localObject3).left;
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((((Rect)localObject3).right + j) / 2 - i / 2);
          bloe.a(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          bloe.a(this.this$0).setVisibility(0);
          localObject1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -15.0F);
          ((TranslateAnimation)localObject1).setDuration(300L);
          ((TranslateAnimation)localObject1).setRepeatCount(-1);
          ((TranslateAnimation)localObject1).setRepeatMode(2);
          bloe.a(this.this$0).startAnimation((Animation)localObject1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.14
 * JD-Core Version:    0.7.0.1
 */