package dov.com.qq.im.aeeditor.module.toolbar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import bnri;
import boda;
import bodb;
import bodc;

public class VideoEditToolBar
  extends AEEditorToolBar
{
  private boolean a;
  private boolean b;
  
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
    this.b = bnri.a();
    a(0, "clip", 2130837726, 2130837652);
    a(1, "text", 2130837731, 2130837652);
    a(2, "music", 2130837921, 2130837652);
  }
  
  void a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Bocy != null)
    {
      localObject1 = localObject2;
      if ((this.jdField_a_of_type_Bocy instanceof bodc)) {
        localObject1 = (bodc)this.jdField_a_of_type_Bocy;
      }
    }
    if (paramString.equals("clip")) {
      if (localObject1 != null) {
        ((bodc)localObject1).x();
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
      ((bodc)localObject1).y();
      return;
    } while ((!paramString.equals("music")) || (localObject1 == null));
    ((bodc)localObject1).z();
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = bnri.a();
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      a("music", 2130837922);
      return;
    }
    a("music", 2130837921);
  }
  
  public void d()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(200L);
    localAnimationSet.setAnimationListener(new boda(this));
    startAnimation(localAnimationSet);
  }
  
  public void e()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(200L);
    localAnimationSet.setAnimationListener(new bodb(this));
    startAnimation(localAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.toolbar.VideoEditToolBar
 * JD-Core Version:    0.7.0.1
 */