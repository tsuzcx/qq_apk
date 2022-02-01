package cooperation.qzone.panorama.piece;

import android.graphics.Bitmap;
import cooperation.qzone.panorama.util.TextureUtil;

public class PieceData
{
  private Bitmap orgBitmap;
  private int pieceIndex;
  private int textureOrgObjectId = -1;
  
  public Bitmap getOrgBitmap()
  {
    return this.orgBitmap;
  }
  
  public int getPieceIndex()
  {
    return this.pieceIndex;
  }
  
  public int getTextureOrgObjectId()
  {
    return this.textureOrgObjectId;
  }
  
  public void notifyTextureChange()
  {
    Bitmap localBitmap = this.orgBitmap;
    if (localBitmap == null) {
      return;
    }
    if (this.textureOrgObjectId <= 0) {
      this.textureOrgObjectId = TextureUtil.genTextureId(localBitmap, true);
    }
  }
  
  public void recycleOrgTexture()
  {
    Bitmap localBitmap = this.orgBitmap;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      this.orgBitmap = null;
    }
    TextureUtil.deleteTexture(this.textureOrgObjectId);
    this.textureOrgObjectId = -1;
  }
  
  public void setOrgBitmap(Bitmap paramBitmap)
  {
    this.orgBitmap = paramBitmap;
  }
  
  public void setPieceIndex(int paramInt)
  {
    this.pieceIndex = paramInt;
  }
  
  public int sizeOf()
  {
    Bitmap localBitmap = this.orgBitmap;
    if (localBitmap != null) {
      return localBitmap.getByteCount();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.panorama.piece.PieceData
 * JD-Core Version:    0.7.0.1
 */