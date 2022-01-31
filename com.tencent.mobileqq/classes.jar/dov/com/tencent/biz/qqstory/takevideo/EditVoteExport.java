package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.VoteLayer.VoteItem;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;

public abstract interface EditVoteExport
  extends EditVideoPart.EditExport
{
  public abstract Bitmap a();
  
  public abstract EditVideoVote.VoteInfo a();
  
  public abstract void a(VoteLayer.VoteItem paramVoteItem, float paramFloat1, float paramFloat2);
  
  public abstract void b(int paramInt, GenerateContext paramGenerateContext);
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVoteExport
 * JD-Core Version:    0.7.0.1
 */