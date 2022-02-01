package dov.com.qq.im.capture.data;

import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.model.SelectedItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage.Item;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage.Item;

public abstract interface IFaceSelectedListener
{
  public abstract void a();
  
  public abstract void a(SelectedItem paramSelectedItem, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper);
  
  public abstract void a(InfomationFacePackage.Item paramItem, String paramString, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void a(LocationFacePackage.Item paramItem, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void a(LocationFacePackage.Item paramItem, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper);
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void b(SelectedItem paramSelectedItem, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.data.IFaceSelectedListener
 * JD-Core Version:    0.7.0.1
 */