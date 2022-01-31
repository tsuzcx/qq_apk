package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.InteractPasterLayer.InteractItem;
import dov.com.tencent.biz.qqstory.takevideo.interact.InteractPasterItem.InteractPasterInfo;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;

public abstract interface EditInteractExport
  extends EditVideoPart.EditExport
{
  public abstract Bitmap a();
  
  public abstract InteractPasterItem.InteractPasterInfo a();
  
  public abstract void a(InteractPasterLayer.InteractItem paramInteractItem, float paramFloat1, float paramFloat2);
  
  public abstract void a_(int paramInt, GenerateContext paramGenerateContext);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditInteractExport
 * JD-Core Version:    0.7.0.1
 */