package cooperation.qzone.panorama.piece;

import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqperf.monitor.memory.MemoryManager;
import cooperation.qzone.panorama.callback.PanoramaTouchListener;
import cooperation.qzone.panorama.model.ShapeModel;
import cooperation.qzone.panorama.util.PanoramaConfig.Builder;
import cooperation.qzone.panorama.util.TextureUtil;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.io.IOException;

public class PanoramaPieceManager
  implements PanoramaTouchListener
{
  public static final int CACHE_PIECE_SIZE = 8;
  private static final String TAG = "PanoramaPieceManager";
  private BitmapRegionDecoder bitmapRegionDecoder;
  private PanoramaConfig.Builder builder;
  private int cacheEndIndex = -1;
  private int[] cacheIndex = new int[8];
  private PieceCacheList cachePieceDataList;
  private int cacheStartIndex = -1;
  private volatile int endIndex;
  private boolean isRightOrientataion;
  private long maxSize;
  private int orgHeight;
  private int orgWidth;
  private Bitmap pieceOrgBitmap;
  private Bitmap pieceOrgBitmap2;
  private int pieceSize;
  private volatile PanoramaPieceManager.ProcessState processState;
  private float scaleRate = 1.0F;
  private int screenHeight;
  private int screenWidth;
  private float sectorDegree;
  private ShapeModel shapeModel;
  private volatile int startIndex;
  private int tempEndIndex = -1;
  private int tempEndIndex2 = -1;
  private int tempStartIndex = -1;
  private int tempStartIndex2 = -1;
  
  public PanoramaPieceManager(PanoramaConfig.Builder paramBuilder, String paramString)
  {
    this.builder = paramBuilder;
    this.shapeModel = paramBuilder.getShapeModel();
    try
    {
      this.bitmapRegionDecoder = BitmapRegionDecoder.newInstance(paramString, false);
    }
    catch (IOException paramBuilder)
    {
      paramBuilder.printStackTrace();
    }
    initManager();
  }
  
  public PanoramaPieceManager(PanoramaConfig.Builder paramBuilder, byte[] paramArrayOfByte)
  {
    this.builder = paramBuilder;
    this.shapeModel = paramBuilder.getShapeModel();
    try
    {
      this.bitmapRegionDecoder = BitmapRegionDecoder.newInstance(paramArrayOfByte, 0, paramArrayOfByte.length, false);
    }
    catch (IOException paramBuilder)
    {
      paramBuilder.printStackTrace();
    }
    initManager();
  }
  
  private Bitmap checkIfScale(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    int j = this.orgWidth;
    int k = this.orgHeight;
    int i = j;
    if (j > k) {
      i = k;
    }
    j = this.screenHeight;
    Bitmap localBitmap = paramBitmap;
    if (i > j)
    {
      this.scaleRate = (j / i);
      localBitmap = scaleBitmap(paramBitmap, this.scaleRate);
    }
    return localBitmap;
  }
  
  private void checkListSize(int paramInt1, int paramInt2)
  {
    Object localObject = this.cachePieceDataList;
    if ((localObject != null) && (((PieceCacheList)localObject).size() >= 8))
    {
      if (!this.cachePieceDataList.isNeedCheckSize()) {
        return;
      }
      localObject = this.cacheIndex;
      int n = localObject.length;
      int j = 0;
      while (j < n)
      {
        int i1 = localObject[j];
        int m = 1;
        int i;
        if (paramInt1 < paramInt2)
        {
          i = paramInt1;
          while (i < paramInt2)
          {
            if (i1 == i)
            {
              i = m;
              break label160;
            }
            i += 1;
          }
          i = 0;
        }
        else
        {
          i = paramInt1;
          while (i < this.pieceSize)
          {
            if (i1 == i)
            {
              i = 1;
              break label129;
            }
            i += 1;
          }
          i = 0;
          label129:
          int k = 0;
          while (k < paramInt2)
          {
            if (i1 == k)
            {
              i = m;
              break;
            }
            k += 1;
          }
        }
        label160:
        if (i == 0) {
          removeCache(i1);
        }
        j += 1;
      }
    }
  }
  
  private void dividePiece()
  {
    Bitmap localBitmap = this.pieceOrgBitmap;
    int j;
    int k;
    int i;
    if ((localBitmap != null) && (!localBitmap.isRecycled()) && (this.tempStartIndex != -1) && (this.tempEndIndex != -1))
    {
      j = this.pieceOrgBitmap.getWidth();
      k = this.tempEndIndex;
      i = this.tempStartIndex;
      j /= (k + 1 - i);
      for (;;)
      {
        k = this.tempEndIndex;
        if (i > k) {
          break;
        }
        setCachePieceDataList(this.cachePieceDataList, i, (i - this.tempStartIndex) * j, j, this.pieceOrgBitmap, this.isRightOrientataion);
        i += 1;
      }
      if (this.tempStartIndex != k) {
        this.pieceOrgBitmap.recycle();
      }
      this.pieceOrgBitmap = null;
    }
    localBitmap = this.pieceOrgBitmap2;
    if ((localBitmap != null) && (!localBitmap.isRecycled()) && (this.tempStartIndex2 != -1) && (this.tempEndIndex2 != -1))
    {
      j = this.pieceOrgBitmap2.getWidth();
      k = this.tempEndIndex2;
      i = this.tempStartIndex2;
      j /= (k + 1 - i);
      for (;;)
      {
        k = this.tempEndIndex2;
        if (i > k) {
          break;
        }
        setCachePieceDataList(this.cachePieceDataList, i, (i - this.tempStartIndex2) * j, j, this.pieceOrgBitmap2, this.isRightOrientataion);
        i += 1;
      }
      if (this.tempStartIndex2 != k) {
        this.pieceOrgBitmap2.recycle();
      }
      this.pieceOrgBitmap2 = null;
    }
  }
  
  private Bitmap getOrgBitmap(int paramInt1, int paramInt2)
  {
    QZLog.e("PanoramaPieceManager", 4, new Object[] { "startIndex = ", Integer.valueOf(this.startIndex), " endIndex = ", Integer.valueOf(this.endIndex), " tempStart = ", Integer.valueOf(paramInt1), " tempEnd = ", Integer.valueOf(paramInt2) });
    if (this.bitmapRegionDecoder == null) {
      return null;
    }
    int i = this.orgWidth;
    int j = this.orgHeight;
    if (i <= j) {
      i = j;
    }
    int m = (int)(i / (this.sectorDegree / 10.0F));
    j = this.orgWidth;
    int k = this.orgHeight;
    i = j;
    if (j > k) {
      i = k;
    }
    Object localObject = new Rect(paramInt1 * m, 0, (paramInt1 + 1) * m, i);
    Rect localRect = new Rect(paramInt2 * m, 0, (paramInt2 + 1) * m, i);
    if (this.orgWidth < this.orgHeight) {
      localObject = new Rect(((Rect)localObject).top, this.orgHeight - localRect.right, localRect.bottom, this.orgHeight - ((Rect)localObject).left);
    } else {
      localObject = new Rect(((Rect)localObject).left, ((Rect)localObject).top, localRect.right, localRect.bottom);
    }
    try
    {
      localObject = this.bitmapRegionDecoder.decodeRegion((Rect)localObject, null);
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      QZLog.e("PanoramaPieceManager", "decodeRegion OutOfMemoryError");
      return null;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
      QZLog.e("PanoramaPieceManager", "decodeRegion IllegalArgumentException");
    }
    return null;
  }
  
  private void initManager()
  {
    Object localObject = this.shapeModel;
    if (localObject != null) {
      this.pieceSize = ((ShapeModel)localObject).getPieceSize();
    }
    this.processState = PanoramaPieceManager.ProcessState.INIT_LOCATION;
    localObject = this.bitmapRegionDecoder;
    if (localObject != null)
    {
      this.orgWidth = ((BitmapRegionDecoder)localObject).getWidth();
      this.orgHeight = this.bitmapRegionDecoder.getHeight();
      int i = this.orgWidth;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" orgHeight = ");
      ((StringBuilder)localObject).append(this.orgHeight);
      QZLog.i("PanoramaPieceManager", 4, new Object[] { "orgWidth = ", Integer.valueOf(i), ((StringBuilder)localObject).toString() });
    }
    this.screenWidth = ViewUtils.a();
    this.screenHeight = ViewUtils.b();
    this.maxSize = (MemoryManager.a() / 8L);
    if (this.cachePieceDataList == null) {
      this.cachePieceDataList = new PieceCacheList(this.maxSize);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initManager: maxSize = ");
    ((StringBuilder)localObject).append(this.maxSize);
    QZLog.i("PanoramaPieceManager", 4, ((StringBuilder)localObject).toString());
  }
  
  private void notifyPieceChange()
  {
    if (this.cachePieceDataList == null) {
      return;
    }
    int i = 0;
    while (i < this.cachePieceDataList.size())
    {
      ((PieceData)this.cachePieceDataList.valueAt(i)).notifyTextureChange();
      i += 1;
    }
  }
  
  private Bitmap pieceOperation(int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    Object localObject2 = getOrgBitmap(paramInt1, paramInt2);
    Object localObject1 = localObject2;
    if (this.orgWidth < this.orgHeight) {
      localObject1 = rotateBitmap((Bitmap)localObject2, 90.0F);
    }
    if (localObject1 == null) {
      return null;
    }
    localObject1 = checkIfScale((Bitmap)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("pieceOperation:current time =  ");
    ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
    QZLog.i("PanoramaPieceManager", 4, ((StringBuilder)localObject2).toString());
    return localObject1;
  }
  
  private void removeCache(int paramInt)
  {
    PieceCacheList localPieceCacheList = this.cachePieceDataList;
    if (localPieceCacheList == null) {
      return;
    }
    localPieceCacheList.remove(paramInt);
  }
  
  private Bitmap rotateBitmap(Bitmap paramBitmap, float paramFloat)
  {
    Object localObject1 = null;
    if (paramBitmap == null) {
      return null;
    }
    Object localObject2 = new Matrix();
    ((Matrix)localObject2).postRotate(paramFloat);
    try
    {
      localObject2 = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject2, true);
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label49:
      break label49;
    }
    QZLog.e("PanoramaPieceManager", "rotateBitmap OutOfMemoryError");
    paramBitmap.recycle();
    return localObject1;
  }
  
  private Bitmap scaleBitmap(Bitmap paramBitmap, float paramFloat)
  {
    if (paramBitmap == null) {
      return null;
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).postScale(paramFloat, paramFloat);
    localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
    paramBitmap.recycle();
    return localObject;
  }
  
  private void setCachePieceDataList(PieceCacheList paramPieceCacheList, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap, boolean paramBoolean)
  {
    QZLog.i("PanoramaPieceManager", 4, new Object[] { "index = ", Integer.valueOf(paramInt1), " x = ", Integer.valueOf(paramInt2), " perWidth = ", Integer.valueOf(paramInt3), " (orgHeight * scaleRate) = ", Float.valueOf(this.orgHeight * this.scaleRate) });
    if (paramBitmap != null)
    {
      if (paramBitmap.isRecycled()) {
        return;
      }
      if (paramPieceCacheList.get(paramInt1) == null) {
        try
        {
          PieceData localPieceData = new PieceData();
          localPieceData.setPieceIndex(paramInt1);
          int i;
          if (this.orgWidth > this.orgHeight) {
            i = this.orgHeight;
          } else {
            i = this.orgWidth;
          }
          localPieceData.setOrgBitmap(Bitmap.createBitmap(paramBitmap, paramInt2, 0, paramInt3, (int)(i * this.scaleRate)));
          paramPieceCacheList.put(paramInt1, localPieceData, paramBoolean);
          return;
        }
        catch (OutOfMemoryError paramPieceCacheList)
        {
          paramPieceCacheList.printStackTrace();
          QZLog.e("PanoramaPieceManager", "createBitmap OutOfMemoryError");
          return;
        }
        catch (IllegalArgumentException paramPieceCacheList)
        {
          paramPieceCacheList.printStackTrace();
          QZLog.e("PanoramaPieceManager", "createBitmap IllegalArgumentException");
        }
      }
    }
  }
  
  public void doProcess()
  {
    int i;
    int j;
    switch (PanoramaPieceManager.2.$SwitchMap$cooperation$qzone$panorama$piece$PanoramaPieceManager$ProcessState[this.processState.ordinal()])
    {
    default: 
    case 8: 
      this.cacheStartIndex = -1;
      this.cacheEndIndex = -1;
      this.processState = PanoramaPieceManager.ProcessState.INIT_LOCATION;
      return;
    case 7: 
      PieceCacheList localPieceCacheList = this.cachePieceDataList;
      if (localPieceCacheList != null)
      {
        TextureUtil.deleteTexture(localPieceCacheList);
        this.cachePieceDataList.clear();
      }
      this.processState = PanoramaPieceManager.ProcessState.END;
      return;
    case 6: 
      notifyPieceChange();
      this.processState = PanoramaPieceManager.ProcessState.END;
      return;
    case 5: 
      dividePiece();
      this.processState = PanoramaPieceManager.ProcessState.NOTIFY;
      return;
    case 3: 
      i = this.cacheStartIndex;
      if (i != -1)
      {
        j = this.cacheEndIndex;
        if ((j != -1) && (i != j))
        {
          this.processState = PanoramaPieceManager.ProcessState.WAITING;
          QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new PanoramaPieceManager.1(this));
          return;
        }
      }
      this.processState = PanoramaPieceManager.ProcessState.END;
      return;
    case 2: 
      i = this.cacheStartIndex;
      if (i != -1)
      {
        j = this.cacheEndIndex;
        if ((j != -1) && (i != j))
        {
          checkListSize(i, j);
          this.processState = PanoramaPieceManager.ProcessState.CLIPPING;
          return;
        }
      }
      this.processState = PanoramaPieceManager.ProcessState.END;
      return;
    case 1: 
      this.cacheStartIndex = this.startIndex;
      this.cacheEndIndex = this.endIndex;
      this.processState = PanoramaPieceManager.ProcessState.CHECK_SIZE;
    }
  }
  
  public PieceCacheList getCachePieceDataList()
  {
    return this.cachePieceDataList;
  }
  
  public void loadOrgPieceData()
  {
    if (this.bitmapRegionDecoder == null) {
      return;
    }
    int j = this.cacheStartIndex;
    int m = this.cacheEndIndex;
    if ((j != -1) && (m != -1))
    {
      if (j == m) {
        return;
      }
      int[] arrayOfInt = this.cacheIndex;
      boolean bool2 = false;
      boolean bool1 = false;
      int k = arrayOfInt[0];
      int n = arrayOfInt[(arrayOfInt.length - 1)];
      this.tempStartIndex = -1;
      this.tempEndIndex = -1;
      int i;
      if (j < m)
      {
        i = 0;
        while (j < m)
        {
          if (this.cachePieceDataList.get(j) == null)
          {
            if (this.tempStartIndex == -1) {
              this.tempStartIndex = j;
            }
            this.tempEndIndex = j;
          }
          this.cacheIndex[i] = j;
          j += 1;
          i += 1;
        }
        if ((k < this.tempStartIndex) || (n < this.tempEndIndex)) {
          bool1 = true;
        }
        this.isRightOrientataion = bool1;
        i = this.tempStartIndex;
        if (i != -1)
        {
          j = this.tempEndIndex;
          if (j != -1) {
            this.pieceOrgBitmap = pieceOperation(i, j);
          }
        }
      }
      else
      {
        k = j;
        i = 0;
        while (k < this.pieceSize)
        {
          if (this.cachePieceDataList.get(k) == null)
          {
            if (this.tempStartIndex == -1) {
              this.tempStartIndex = k;
            }
            this.tempEndIndex = k;
          }
          this.cacheIndex[i] = k;
          k += 1;
          i += 1;
        }
        k = this.tempStartIndex;
        if (k != -1)
        {
          n = this.tempEndIndex;
          if (n != -1) {
            this.pieceOrgBitmap = pieceOperation(k, n);
          }
        }
        this.tempStartIndex2 = -1;
        this.tempEndIndex2 = -1;
        k = 0;
        while (k < m)
        {
          if (this.cachePieceDataList.get(k) == null)
          {
            if (this.tempStartIndex2 == -1) {
              this.tempStartIndex2 = k;
            }
            this.tempEndIndex2 = k;
          }
          this.cacheIndex[i] = k;
          k += 1;
          i += 1;
        }
        i = this.tempStartIndex2;
        if (i != -1)
        {
          k = this.tempEndIndex2;
          if (k != -1) {
            this.pieceOrgBitmap2 = pieceOperation(i, k);
          }
        }
        bool1 = bool2;
        if (this.pieceSize - j > 4) {
          bool1 = true;
        }
        this.isRightOrientataion = bool1;
      }
    }
  }
  
  public void onClickListener() {}
  
  public void onResume()
  {
    this.processState = PanoramaPieceManager.ProcessState.ONRESUME;
  }
  
  public void onTouchMove(float paramFloat1, float paramFloat2)
  {
    paramFloat1 = paramFloat2 % 360.0F;
    int i = this.pieceSize;
    int k = 360 / i;
    paramFloat2 = this.sectorDegree;
    if (paramFloat2 == 360.0F)
    {
      if (paramFloat1 <= 0.0F)
      {
        i = -(int)(paramFloat1 / k);
        break label72;
      }
    }
    else {
      i = (int)(paramFloat2 / 10.0F);
    }
    i -= (int)(paramFloat1 / k);
    label72:
    paramFloat2 = Math.abs(paramFloat1);
    float f = k;
    int j = i;
    if (paramFloat2 % f >= k / 2)
    {
      j = i;
      if (Math.abs(paramFloat1) % f < f) {
        j = i + 1;
      }
    }
    if (this.sectorDegree == 360.0F)
    {
      this.startIndex = ((j - 4) % this.pieceSize);
      if (this.startIndex < 0) {
        this.startIndex += this.pieceSize;
      }
      this.endIndex = ((j + 4) % this.pieceSize);
      i = this.startIndex;
      j = this.pieceSize;
      if (i == j - 8) {
        this.endIndex = j;
      }
    }
    else
    {
      this.startIndex = (j - 4);
      this.endIndex = (j + 4);
      if (this.startIndex < 0) {
        this.startIndex = 0;
      }
      paramFloat1 = this.endIndex;
      paramFloat2 = this.sectorDegree;
      if (paramFloat1 > paramFloat2 / 10.0F) {
        this.endIndex = ((int)(paramFloat2 / 10.0F));
      }
    }
  }
  
  public void onTouchScale(float paramFloat) {}
  
  public void setSectorDegree(float paramFloat)
  {
    this.sectorDegree = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.panorama.piece.PanoramaPieceManager
 * JD-Core Version:    0.7.0.1
 */