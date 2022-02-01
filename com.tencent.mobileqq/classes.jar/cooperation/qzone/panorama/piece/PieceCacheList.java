package cooperation.qzone.panorama.piece;

import android.util.SparseArray;
import cooperation.qzone.util.QZLog;

public class PieceCacheList
  extends SparseArray<PieceData>
{
  private static final String TAG = "PieceCacheList";
  private long currentSize;
  private long maxSize;
  private long pieceSize;
  
  public PieceCacheList(long paramLong)
  {
    this.maxSize = paramLong;
  }
  
  private void trimToSize(int paramInt, boolean paramBoolean)
  {
    int j;
    if (this.currentSize + this.pieceSize > this.maxSize)
    {
      j = 0;
      if (!paramBoolean) {}
    }
    for (;;)
    {
      try
      {
        if (paramInt >= size()) {
          break label157;
        }
        i = paramInt;
        continue;
        if (paramInt < size()) {
          i = size() - 1;
        } else {
          i = size() - (36 - paramInt);
        }
        removeAt(i);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        localIndexOutOfBoundsException.printStackTrace();
        if ((!isNeedCheckSize()) && (size() > 0))
        {
          if (paramBoolean) {
            i = j;
          } else {
            i = size() - 1;
          }
          removeAt(i);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("trimToSize: IndexOutOfBoundsException temp ");
        localStringBuilder.append(size() - (36 - paramInt));
        QZLog.e("PieceCacheList", localStringBuilder.toString());
      }
      return;
      label157:
      int i = 0;
    }
  }
  
  public void clear()
  {
    super.clear();
    this.currentSize = 0L;
  }
  
  public boolean isNeedCheckSize()
  {
    long l = this.pieceSize;
    boolean bool = false;
    if (l == 0L) {
      return false;
    }
    if (this.maxSize <= l * 8L) {
      bool = true;
    }
    return bool;
  }
  
  public void put(int paramInt, PieceData paramPieceData)
  {
    if (paramPieceData != null)
    {
      super.put(paramInt, paramPieceData);
      this.currentSize += paramPieceData.sizeOf();
    }
  }
  
  public void put(int paramInt, PieceData paramPieceData, boolean paramBoolean)
  {
    if (paramPieceData != null) {}
    try
    {
      if (this.pieceSize == 0L)
      {
        this.pieceSize = paramPieceData.sizeOf();
        if (this.maxSize < this.pieceSize * 8L) {
          this.maxSize = (this.pieceSize * 8L);
        }
      }
      trimToSize(paramInt, paramBoolean);
      put(paramInt, paramPieceData);
      return;
    }
    finally {}
  }
  
  public void remove(int paramInt)
  {
    PieceData localPieceData = (PieceData)get(paramInt);
    if (localPieceData != null) {
      localPieceData.recycleOrgTexture();
    }
    super.remove(paramInt);
    this.currentSize -= this.pieceSize;
  }
  
  public void removeAt(int paramInt)
  {
    PieceData localPieceData = (PieceData)valueAt(paramInt);
    if (localPieceData != null) {
      localPieceData.recycleOrgTexture();
    }
    super.removeAt(paramInt);
    this.currentSize -= this.pieceSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.panorama.piece.PieceCacheList
 * JD-Core Version:    0.7.0.1
 */