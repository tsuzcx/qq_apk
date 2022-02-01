package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;

public abstract interface EditVideoPlayerExport
  extends EditVideoPart.EditExport
{
  public abstract Bitmap a(int paramInt);
  
  public abstract void a(float paramFloat);
  
  public abstract void a(int paramInt1, int paramInt2, float paramFloat);
  
  public abstract void a(int paramInt, byte[] paramArrayOfByte);
  
  public abstract void a(Bitmap paramBitmap);
  
  public abstract void a(Bitmap paramBitmap, boolean paramBoolean);
  
  public abstract void a(TransferData paramTransferData);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void aK_();
  
  public abstract void b(int paramInt);
  
  public abstract void m();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayerExport
 * JD-Core Version:    0.7.0.1
 */