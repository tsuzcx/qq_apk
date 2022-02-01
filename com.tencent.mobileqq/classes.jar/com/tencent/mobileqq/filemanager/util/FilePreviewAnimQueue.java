package com.tencent.mobileqq.filemanager.util;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.util.ArrayList;
import java.util.List;

public class FilePreviewAnimQueue
  implements Animation.AnimationListener
{
  public static int a;
  public static int b;
  int[] c = new int[1];
  List<FilePreviewAnimQueue.FilePreviewAnim> d;
  View e;
  boolean f = false;
  FilePreviewAnimQueue.FilePreviewAnim g;
  
  public FilePreviewAnimQueue(View paramView)
  {
    this.e = paramView;
  }
  
  private void b(FilePreviewAnimQueue.FilePreviewAnim paramFilePreviewAnim)
  {
    this.g = paramFilePreviewAnim;
    Animation localAnimation = (Animation)paramFilePreviewAnim.a;
    localAnimation.setDuration(paramFilePreviewAnim.d);
    localAnimation.setAnimationListener(this);
  }
  
  public void a()
  {
    if (this.f) {
      return;
    }
    if (this.d.size() == 0) {
      return;
    }
    synchronized (this.c)
    {
      FilePreviewAnimQueue.FilePreviewAnim localFilePreviewAnim = (FilePreviewAnimQueue.FilePreviewAnim)this.d.get(0);
      this.d.remove(0);
      if (localFilePreviewAnim == null) {
        return;
      }
      if ((localFilePreviewAnim.c == true) && (this.e.getVisibility() == 0)) {
        return;
      }
      if ((!localFilePreviewAnim.c) && ((this.e.getVisibility() == 8) || (this.e.getVisibility() == 4))) {
        return;
      }
      this.e.setAnimation((Animation)localFilePreviewAnim.a);
      this.e.startAnimation((Animation)localFilePreviewAnim.a);
      return;
    }
  }
  
  public void a(FilePreviewAnimQueue.FilePreviewAnim paramFilePreviewAnim)
  {
    if (this.d == null) {
      this.d = new ArrayList();
    }
    synchronized (this.c)
    {
      this.d.add(paramFilePreviewAnim);
      b(paramFilePreviewAnim);
      return;
    }
  }
  
  public void b()
  {
    synchronized (this.c)
    {
      this.d.clear();
      this.e.clearAnimation();
      return;
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.g.c) {
      this.e.setVisibility(0);
    } else {
      this.e.setVisibility(8);
    }
    this.f = false;
    a();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.f = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue
 * JD-Core Version:    0.7.0.1
 */