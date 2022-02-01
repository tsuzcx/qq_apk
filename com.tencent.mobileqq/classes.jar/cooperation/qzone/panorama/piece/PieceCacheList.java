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
    int j = 0;
    if (this.currentSize + this.pieceSize > this.maxSize) {
      if (!paramBoolean) {}
    }
    for (;;)
    {
      int i;
      try
      {
        if (paramInt >= size()) {
          break label150;
        }
        i = paramInt;
        removeAt(i);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        localIndexOutOfBoundsException.printStackTrace();
        if ((isNeedCheckSize()) || (size() <= 0)) {
          continue;
        }
        if (!paramBoolean) {
          break label139;
        }
        i = j;
        removeAt(i);
        QZLog.e("PieceCacheList", "trimToSize: IndexOutOfBoundsException temp " + (size() - (36 - paramInt)));
        return;
      }
      if (paramInt < size())
      {
        i = size() - 1;
      }
      else
      {
        i = size();
        i -= 36 - paramInt;
        continue;
        label139:
        i = size() - 1;
        continue;
        return;
        label150:
        i = 0;
      }
    }
  }
  
  public void clear()
  {
    super.clear();
    this.currentSize = 0L;
  }
  
  public boolean isNeedCheckSize()
  {
    if (this.pieceSize == 0L) {}
    while (this.maxSize > this.pieceSize * 8L) {
      return false;
    }
    return true;
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