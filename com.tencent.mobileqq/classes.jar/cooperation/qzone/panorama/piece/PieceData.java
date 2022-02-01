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
    if (this.orgBitmap == null) {}
    while (this.textureOrgObjectId > 0) {
      return;
    }
    this.textureOrgObjectId = TextureUtil.genTextureId(this.orgBitmap, true);
  }
  
  public void recycleOrgTexture()
  {
    if (this.orgBitmap != null)
    {
      this.orgBitmap.recycle();
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
    if (this.orgBitmap != null) {
      return this.orgBitmap.getByteCount();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.panorama.piece.PieceData
 * JD-Core Version:    0.7.0.1
 */