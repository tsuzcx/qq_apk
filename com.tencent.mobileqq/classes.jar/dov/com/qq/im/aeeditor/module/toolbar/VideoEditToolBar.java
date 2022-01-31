package dov.com.qq.im.aeeditor.module.toolbar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import bllf;
import bllg;
import bllh;

public class VideoEditToolBar
  extends AEEditorToolBar
{
  private boolean a;
  
  public VideoEditToolBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public VideoEditToolBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VideoEditToolBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a()
  {
    a(0, "clip", 2130837649);
    a(1, "text", 2130837650);
    a(2, "music", 2130837668);
  }
  
  void a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Blld != null)
    {
      localObject1 = localObject2;
      if ((this.jdField_a_of_type_Blld instanceof bllh)) {
        localObject1 = (bllh)this.jdField_a_of_type_Blld;
      }
    }
    if (paramString.equals("clip")) {
      if (localObject1 != null) {
        ((bllh)localObject1).i();
      }
    }
    do
    {
      do
      {
        return;
        if (!paramString.equals("text")) {
          break;
        }
      } while (localObject1 == null);
      ((bllh)localObject1).n();
      return;
    } while ((!paramString.equals("music")) || (localObject1 == null));
    ((bllh)localObject1).o();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      a("music", 2130837667);
      return;
    }
    a("music", 2130837668);
  }
  
  public void d()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(350L);
    localAnimationSet.setAnimationListener(new bllf(this));
    startAnimation(localAnimationSet);
  }
  
  public void e()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(350L);
    localAnimationSet.setAnimationListener(new bllg(this));
    startAnimation(localAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.toolbar.VideoEditToolBar
 * JD-Core Version:    0.7.0.1
 */