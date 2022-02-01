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
      initManager();
      return;
    }
    catch (IOException paramBuilder)
    {
      for (;;)
      {
        paramBuilder.printStackTrace();
      }
    }
  }
  
  public PanoramaPieceManager(PanoramaConfig.Builder paramBuilder, byte[] paramArrayOfByte)
  {
    this.builder = paramBuilder;
    this.shapeModel = paramBuilder.getShapeModel();
    try
    {
      this.bitmapRegionDecoder = BitmapRegionDecoder.newInstance(paramArrayOfByte, 0, paramArrayOfByte.length, false);
      initManager();
      return;
    }
    catch (IOException paramBuilder)
    {
      for (;;)
      {
        paramBuilder.printStackTrace();
      }
    }
  }
  
  private Bitmap checkIfScale(Bitmap paramBitmap)
  {
    Bitmap localBitmap;
    if (paramBitmap == null)
    {
      localBitmap = null;
      return localBitmap;
    }
    if (this.orgWidth > this.orgHeight) {}
    for (int i = this.orgHeight;; i = this.orgWidth)
    {
      localBitmap = paramBitmap;
      if (i <= this.screenHeight) {
        break;
      }
      this.scaleRate = (this.screenHeight / i);
      return scaleBitmap(paramBitmap, this.scaleRate);
    }
  }
  
  private void checkListSize(int paramInt1, int paramInt2)
  {
    if ((this.cachePieceDataList == null) || (this.cachePieceDataList.size() < 8) || (!this.cachePieceDataList.isNeedCheckSize())) {
      return;
    }
    int[] arrayOfInt = this.cacheIndex;
    int n = arrayOfInt.length;
    int k = 0;
    label44:
    int i1;
    int i;
    if (k < n)
    {
      i1 = arrayOfInt[k];
      if (paramInt1 >= paramInt2) {
        break label104;
      }
      i = paramInt1;
      label65:
      if (i >= paramInt2) {
        break label169;
      }
      if (i1 != i) {
        break label97;
      }
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {
        removeCache(i1);
      }
      k += 1;
      break label44;
      break;
      label97:
      i += 1;
      break label65;
      label104:
      i = paramInt1;
      label106:
      if (i < this.pieceSize) {
        if (i1 != i) {}
      }
      for (int j = 1;; j = 0)
      {
        int m = 0;
        for (;;)
        {
          i = j;
          if (m >= paramInt2) {
            break;
          }
          if (i1 == m)
          {
            i = 1;
            break;
            i += 1;
            break label106;
          }
          m += 1;
        }
      }
      label169:
      i = 0;
    }
  }
  
  private void dividePiece()
  {
    int j;
    int i;
    if ((this.pieceOrgBitmap != null) && (!this.pieceOrgBitmap.isRecycled()) && (this.tempStartIndex != -1) && (this.tempEndIndex != -1))
    {
      j = this.pieceOrgBitmap.getWidth() / (this.tempEndIndex + 1 - this.tempStartIndex);
      i = this.tempStartIndex;
      while (i <= this.tempEndIndex)
      {
        setCachePieceDataList(this.cachePieceDataList, i, (i - this.tempStartIndex) * j, j, this.pieceOrgBitmap, this.isRightOrientataion);
        i += 1;
      }
      if (this.tempStartIndex != this.tempEndIndex) {
        this.pieceOrgBitmap.recycle();
      }
      this.pieceOrgBitmap = null;
    }
    if ((this.pieceOrgBitmap2 != null) && (!this.pieceOrgBitmap2.isRecycled()) && (this.tempStartIndex2 != -1) && (this.tempEndIndex2 != -1))
    {
      j = this.pieceOrgBitmap2.getWidth() / (this.tempEndIndex2 + 1 - this.tempStartIndex2);
      i = this.tempStartIndex2;
      while (i <= this.tempEndIndex2)
      {
        setCachePieceDataList(this.cachePieceDataList, i, (i - this.tempStartIndex2) * j, j, this.pieceOrgBitmap2, this.isRightOrientataion);
        i += 1;
      }
      if (this.tempStartIndex2 != this.tempEndIndex2) {
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
    int j;
    if (this.orgWidth > this.orgHeight)
    {
      i = this.orgWidth;
      j = (int)(i / (this.sectorDegree / 10.0F));
      if (this.orgWidth <= this.orgHeight) {
        break label183;
      }
    }
    Rect localRect;
    label183:
    for (int i = this.orgHeight;; i = this.orgWidth)
    {
      localObject = new Rect(paramInt1 * j, 0, (paramInt1 + 1) * j, i);
      localRect = new Rect(paramInt2 * j, 0, j * (paramInt2 + 1), i);
      if ((localObject != null) && (localRect != null)) {
        break label191;
      }
      return null;
      i = this.orgHeight;
      break;
    }
    label191:
    if (this.orgWidth < this.orgHeight) {}
    for (Object localObject = new Rect(((Rect)localObject).top, this.orgHeight - localRect.right, localRect.bottom, this.orgHeight - ((Rect)localObject).left);; localObject = new Rect(((Rect)localObject).left, ((Rect)localObject).top, localRect.right, localRect.bottom)) {
      try
      {
        localObject = this.bitmapRegionDecoder.decodeRegion((Rect)localObject, null);
        return localObject;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
        QZLog.e("PanoramaPieceManager", "decodeRegion IllegalArgumentException");
        return null;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        QZLog.e("PanoramaPieceManager", "decodeRegion OutOfMemoryError");
      }
    }
    return null;
  }
  
  private void initManager()
  {
    if (this.shapeModel != null) {
      this.pieceSize = this.shapeModel.getPieceSize();
    }
    this.processState = PanoramaPieceManager.ProcessState.INIT_LOCATION;
    if (this.bitmapRegionDecoder != null)
    {
      this.orgWidth = this.bitmapRegionDecoder.getWidth();
      this.orgHeight = this.bitmapRegionDecoder.getHeight();
      QZLog.i("PanoramaPieceManager", 4, new Object[] { "orgWidth = ", Integer.valueOf(this.orgWidth), " orgHeight = " + this.orgHeight });
    }
    this.screenWidth = ViewUtils.a();
    this.screenHeight = ViewUtils.b();
    this.maxSize = (MemoryManager.a() / 8L);
    if (this.cachePieceDataList == null) {
      this.cachePieceDataList = new PieceCacheList(this.maxSize);
    }
    QZLog.i("PanoramaPieceManager", 4, "initManager: maxSize = " + this.maxSize);
  }
  
  private void notifyPieceChange()
  {
    if (this.cachePieceDataList == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.cachePieceDataList.size())
      {
        ((PieceData)this.cachePieceDataList.valueAt(i)).notifyTextureChange();
        i += 1;
      }
    }
  }
  
  private Bitmap pieceOperation(int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    Bitmap localBitmap2 = getOrgBitmap(paramInt1, paramInt2);
    Bitmap localBitmap1 = localBitmap2;
    if (this.orgWidth < this.orgHeight) {
      localBitmap1 = rotateBitmap(localBitmap2, 90.0F);
    }
    if (localBitmap1 == null) {
      return null;
    }
    localBitmap1 = checkIfScale(localBitmap1);
    QZLog.i("PanoramaPieceManager", 4, "pieceOperation:current time =  " + (System.currentTimeMillis() - l));
    return localBitmap1;
  }
  
  private void removeCache(int paramInt)
  {
    if (this.cachePieceDataList == null) {
      return;
    }
    this.cachePieceDataList.remove(paramInt);
  }
  
  private Bitmap rotateBitmap(Bitmap paramBitmap, float paramFloat)
  {
    if (paramBitmap == null) {
      return null;
    }
    Object localObject1 = new Matrix();
    ((Matrix)localObject1).postRotate(paramFloat);
    try
    {
      localObject1 = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject1, true);
      paramBitmap.recycle();
      return localObject1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QZLog.e("PanoramaPieceManager", "rotateBitmap OutOfMemoryError");
        Object localObject2 = null;
      }
    }
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
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {}
    while (paramPieceCacheList.get(paramInt1) != null) {
      return;
    }
    try
    {
      PieceData localPieceData = new PieceData();
      localPieceData.setPieceIndex(paramInt1);
      if (this.orgWidth > this.orgHeight)
      {
        i = this.orgHeight;
        localPieceData.setOrgBitmap(Bitmap.createBitmap(paramBitmap, paramInt2, 0, paramInt3, (int)(i * this.scaleRate)));
        paramPieceCacheList.put(paramInt1, localPieceData, paramBoolean);
        return;
      }
    }
    catch (IllegalArgumentException paramPieceCacheList)
    {
      for (;;)
      {
        paramPieceCacheList.printStackTrace();
        QZLog.e("PanoramaPieceManager", "createBitmap IllegalArgumentException");
        return;
        int i = this.orgWidth;
      }
    }
    catch (OutOfMemoryError paramPieceCacheList)
    {
      paramPieceCacheList.printStackTrace();
      QZLog.e("PanoramaPieceManager", "createBitmap OutOfMemoryError");
    }
  }
  
  public void doProcess()
  {
    switch (PanoramaPieceManager.2.$SwitchMap$cooperation$qzone$panorama$piece$PanoramaPieceManager$ProcessState[this.processState.ordinal()])
    {
    case 4: 
    default: 
      return;
    case 1: 
      this.cacheStartIndex = this.startIndex;
      this.cacheEndIndex = this.endIndex;
      this.processState = PanoramaPieceManager.ProcessState.CHECK_SIZE;
      return;
    case 2: 
      if ((this.cacheStartIndex != -1) && (this.cacheEndIndex != -1) && (this.cacheStartIndex != this.cacheEndIndex))
      {
        checkListSize(this.cacheStartIndex, this.cacheEndIndex);
        this.processState = PanoramaPieceManager.ProcessState.CLIPPING;
        return;
      }
      this.processState = PanoramaPieceManager.ProcessState.END;
      return;
    case 3: 
      if ((this.cacheStartIndex != -1) && (this.cacheEndIndex != -1) && (this.cacheStartIndex != this.cacheEndIndex))
      {
        this.processState = PanoramaPieceManager.ProcessState.WAITING;
        QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new PanoramaPieceManager.1(this));
        return;
      }
      this.processState = PanoramaPieceManager.ProcessState.END;
      return;
    case 5: 
      dividePiece();
      this.processState = PanoramaPieceManager.ProcessState.NOTIFY;
      return;
    case 6: 
      notifyPieceChange();
      this.processState = PanoramaPieceManager.ProcessState.END;
      return;
    case 7: 
      if (this.cachePieceDataList != null)
      {
        TextureUtil.deleteTexture(this.cachePieceDataList);
        this.cachePieceDataList.clear();
      }
      this.processState = PanoramaPieceManager.ProcessState.END;
      return;
    }
    this.cacheStartIndex = -1;
    this.cacheEndIndex = -1;
    this.processState = PanoramaPieceManager.ProcessState.INIT_LOCATION;
  }
  
  public PieceCacheList getCachePieceDataList()
  {
    return this.cachePieceDataList;
  }
  
  public void loadOrgPieceData()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (this.bitmapRegionDecoder == null) {}
    int j;
    int m;
    do
    {
      do
      {
        return;
        j = this.cacheStartIndex;
        m = this.cacheEndIndex;
      } while ((j == -1) || (m == -1) || (j == m));
      k = this.cacheIndex[0];
      int n = this.cacheIndex[(this.cacheIndex.length - 1)];
      this.tempStartIndex = -1;
      this.tempEndIndex = -1;
      if (j >= m) {
        break;
      }
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
      if (k >= this.tempStartIndex)
      {
        bool1 = bool2;
        if (n >= this.tempEndIndex) {}
      }
      else
      {
        bool1 = true;
      }
      this.isRightOrientataion = bool1;
    } while ((this.tempStartIndex == -1) || (this.tempEndIndex == -1));
    this.pieceOrgBitmap = pieceOperation(this.tempStartIndex, this.tempEndIndex);
    return;
    int k = j;
    int i = 0;
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
    if ((this.tempStartIndex != -1) && (this.tempEndIndex != -1)) {
      this.pieceOrgBitmap = pieceOperation(this.tempStartIndex, this.tempEndIndex);
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
    if ((this.tempStartIndex2 != -1) && (this.tempEndIndex2 != -1)) {
      this.pieceOrgBitmap2 = pieceOperation(this.tempStartIndex2, this.tempEndIndex2);
    }
    if (this.pieceSize - j > 4) {}
    for (;;)
    {
      this.isRightOrientataion = bool1;
      return;
      bool1 = false;
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
    int k = 360 / this.pieceSize;
    int i;
    int j;
    if (this.sectorDegree == 360.0F) {
      if (paramFloat1 > 0.0F)
      {
        i = this.pieceSize - (int)(paramFloat1 / k);
        j = i;
        if (Math.abs(paramFloat1) % k >= k / 2)
        {
          j = i;
          if (Math.abs(paramFloat1) % k < k) {
            j = i + 1;
          }
        }
        if (this.sectorDegree != 360.0F) {
          break label198;
        }
        this.startIndex = ((j - 4) % this.pieceSize);
        if (this.startIndex < 0) {
          this.startIndex += this.pieceSize;
        }
        this.endIndex = ((j + 4) % this.pieceSize);
        if (this.startIndex == this.pieceSize - 8) {
          this.endIndex = this.pieceSize;
        }
      }
    }
    label198:
    do
    {
      return;
      i = -(int)(paramFloat1 / k);
      break;
      i = (int)(this.sectorDegree / 10.0F) - (int)(paramFloat1 / k);
      break;
      this.startIndex = (j - 4);
      this.endIndex = (j + 4);
      if (this.startIndex < 0) {
        this.startIndex = 0;
      }
    } while (this.endIndex <= this.sectorDegree / 10.0F);
    this.endIndex = ((int)(this.sectorDegree / 10.0F));
  }
  
  public void onTouchScale(float paramFloat) {}
  
  public void setSectorDegree(float paramFloat)
  {
    this.sectorDegree = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.panorama.piece.PanoramaPieceManager
 * JD-Core Version:    0.7.0.1
 */