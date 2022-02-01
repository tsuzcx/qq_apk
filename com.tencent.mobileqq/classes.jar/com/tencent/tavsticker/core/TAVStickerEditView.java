package com.tencent.tavsticker.core;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.model.TAVStickerMoveLimit;
import com.tencent.tavsticker.model.TAVStickerOperationMode;
import com.tencent.tavsticker.utils.RectUtil;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGLayer;
import org.libpag.PAGSolidLayer;
import org.libpag.PAGText;
import org.libpag.PAGView;

public class TAVStickerEditView
  extends FrameLayout
  implements ITAVStickerRenderer
{
  public static final String TAG = TAVStickerEditView.class.getSimpleName();
  private Paint borderPaint = null;
  protected float centerX = 0.0F;
  protected float centerY = 0.0F;
  private Region clipRegion = new Region();
  private Context context = null;
  private PointF convertPoint = new PointF();
  protected float correctedOriginalCenterX = 0.0F;
  protected float correctedOriginalCenterY = 0.0F;
  public int eventType = 15;
  private boolean isDrawMovieLimitRect = false;
  protected boolean isFirstDraw = true;
  protected boolean isNeedInitLocation = true;
  private boolean isShowDefaultBorder = true;
  private TAVStickerMode mode = TAVStickerMode.DEFAULT;
  protected int moveRegionHeight = 0;
  protected int moveRegionWidth = 0;
  protected int moveStartOffsetX = 0;
  protected int moveStartOffsetY = 0;
  private Paint movieRectPaint = null;
  protected float originalCenterX = 0.0F;
  protected float originalCenterY = 0.0F;
  private PointF[] originalVertexPoints = { new PointF(), new PointF(), new PointF(), new PointF() };
  public PAGView pagView = null;
  private Path path = new Path();
  public float positionX = 0.0F;
  public float positionY = 0.0F;
  private RectF rectF = new RectF();
  private Region region = new Region();
  public float rotate = 0.0F;
  public float scale = 1.0F;
  public float scaleMax = 0.0F;
  public float scaleMin = 0.0F;
  public RectF singleZoomRotateRect = null;
  public TAVSticker sticker = null;
  protected int stickerContainerHeight = 0;
  protected int stickerContainerWidth = 0;
  public ITAVStickerEventListener stickerEventListener = null;
  protected int stickerHeight = 0;
  protected Rect stickerMoveLimitRect = null;
  private View.OnTouchListener stickerTouchListener = null;
  protected int stickerWidth = 0;
  private List<View.OnTouchListener> touchListeners = new ArrayList();
  public PointF[] vertexPoints = { new PointF(), new PointF(), new PointF(), new PointF() };
  
  public TAVStickerEditView(@NonNull Context paramContext, @NonNull TAVSticker paramTAVSticker)
  {
    super(paramContext);
    if ((paramContext == null) || (paramTAVSticker == null)) {
      throw new IllegalArgumentException("<init> can not initialization TAVStickerEditView, parameter 'context' and 'sticker' must not is null!");
    }
    this.context = paramContext;
    this.sticker = paramTAVSticker;
    init();
  }
  
  private PointF convertCoordinate(float paramFloat1, float paramFloat2)
  {
    if (this.convertPoint == null) {
      this.convertPoint = new PointF();
    }
    int i = getWidth();
    int j = getHeight();
    float f3 = i / 2.0F;
    float f1 = j / 2.0F;
    float f4 = this.correctedOriginalCenterX;
    float f2 = this.correctedOriginalCenterY;
    paramFloat1 = f3 - f4 + paramFloat1;
    paramFloat2 = f1 - f2 + paramFloat2;
    if ((i > 0) && (j > 0) && (this.pagView != null))
    {
      f3 = this.centerX;
      f4 = this.originalCenterX;
      f1 = this.centerY;
      f2 = this.originalCenterY;
      paramFloat1 = (paramFloat1 - (f3 - f4)) / i;
      f3 = this.pagView.getWidth();
      paramFloat2 = (paramFloat2 - (f1 - f2)) / j;
      f1 = this.pagView.getHeight();
      this.convertPoint.set(paramFloat1 * f3, paramFloat2 * f1);
      return this.convertPoint;
    }
    this.convertPoint.set(paramFloat1, paramFloat2);
    return this.convertPoint;
  }
  
  private void init()
  {
    initStickerData();
    initPaint();
    initPagView();
    if (getLayoutParams() == null) {
      setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }
    setWillNotDraw(false);
    this.sticker.registerRenderer(this);
    this.stickerTouchListener = getStickerTouchListener();
    addOnTouchListener(this.stickerTouchListener);
  }
  
  private void initLocationData()
  {
    this.vertexPoints[0].set(this.positionX, this.positionY);
    this.vertexPoints[1].set(this.positionX + this.stickerWidth, this.positionY);
    this.vertexPoints[2].set(this.positionX + this.stickerWidth, this.positionY + this.stickerHeight);
    this.vertexPoints[3].set(this.positionX, this.positionY + this.stickerHeight);
    this.originalVertexPoints[0] = this.vertexPoints[0];
    this.originalVertexPoints[1] = this.vertexPoints[1];
    this.originalVertexPoints[2] = this.vertexPoints[2];
    this.originalVertexPoints[3] = this.vertexPoints[3];
    this.centerX = TAVStickerUtil.getMiddlePoint(this.vertexPoints[0], this.vertexPoints[2]).x;
    this.centerY = TAVStickerUtil.getMiddlePoint(this.vertexPoints[0], this.vertexPoints[2]).y;
    this.originalCenterX = this.centerX;
    this.originalCenterY = this.centerY;
  }
  
  private void initMoveRectPaint()
  {
    this.movieRectPaint = new Paint();
    this.movieRectPaint.setAntiAlias(true);
    this.movieRectPaint.setStrokeWidth(this.sticker.getStrokeWidth());
    this.movieRectPaint.setColor(-65536);
    this.movieRectPaint.setStyle(Paint.Style.STROKE);
  }
  
  private void initPagView()
  {
    this.pagView = new PAGView(this.context);
    addView(this.pagView);
    PAGFile localPAGFile = this.sticker.getPagFile();
    if (localPAGFile != null)
    {
      TLog.d(TAG, "initPagView -> pagFile.width() : " + localPAGFile.width() + ", pagFile.height() : " + localPAGFile.height());
      this.pagView.setFile(localPAGFile);
    }
    if (this.sticker.isAutoPlay()) {
      play(0);
    }
  }
  
  private void initPaint()
  {
    this.borderPaint = new Paint();
    this.borderPaint.setAntiAlias(true);
    this.borderPaint.setStrokeWidth(this.sticker.getStrokeWidth());
    this.borderPaint.setColor(this.sticker.getStrokeColor());
  }
  
  private boolean isTouchInStickerEditView(int paramInt1, int paramInt2)
  {
    this.path.reset();
    this.path.moveTo(this.vertexPoints[0].x, this.vertexPoints[0].y);
    this.path.lineTo(this.vertexPoints[1].x, this.vertexPoints[1].y);
    this.path.lineTo(this.vertexPoints[2].x, this.vertexPoints[2].y);
    this.path.lineTo(this.vertexPoints[3].x, this.vertexPoints[3].y);
    this.path.lineTo(this.vertexPoints[0].x, this.vertexPoints[0].y);
    this.path.computeBounds(this.rectF, true);
    this.clipRegion.set((int)this.rectF.left, (int)this.rectF.top, (int)this.rectF.right, (int)this.rectF.bottom);
    this.region.setPath(this.path, this.clipRegion);
    boolean bool = this.region.contains(paramInt1, paramInt2);
    TLog.d(TAG, "isTouchInStickerEditView -> contains : " + bool);
    return bool;
  }
  
  public void addOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    if (paramOnTouchListener == null) {
      return;
    }
    this.touchListeners.add(paramOnTouchListener);
  }
  
  public void adjustLocation(TAVStickerOperationMode paramTAVStickerOperationMode)
  {
    float f2 = 0.5F;
    updateVertexPoints();
    this.centerX = TAVStickerUtil.getMiddlePoint(this.vertexPoints[0], this.vertexPoints[2]).x;
    this.centerY = TAVStickerUtil.getMiddlePoint(this.vertexPoints[0], this.vertexPoints[2]).y;
    handleMoveLimit();
    if (this.stickerContainerWidth != 0) {}
    for (float f1 = this.centerX / this.stickerContainerWidth;; f1 = 0.5F)
    {
      if (this.stickerContainerHeight != 0) {
        f2 = this.centerY / this.stickerContainerHeight;
      }
      updateStickerOnAdjustLocation(f1, f2);
      if (this.stickerEventListener != null) {
        this.stickerEventListener.onDataChanged(this.sticker, paramTAVStickerOperationMode, this.centerX, this.centerY, this.scale, this.rotate);
      }
      return;
    }
  }
  
  public long duration()
  {
    if (this.pagView != null) {
      return this.pagView.duration() / 1000L;
    }
    return 0L;
  }
  
  public boolean flush()
  {
    if (this.pagView != null) {
      return this.pagView.flush();
    }
    return false;
  }
  
  public boolean flush(boolean paramBoolean)
  {
    if (this.pagView != null) {
      return this.pagView.flush(paramBoolean);
    }
    return false;
  }
  
  public TAVStickerMode getMode()
  {
    return this.mode;
  }
  
  public PointF[] getOriginalVertexPoints()
  {
    return this.originalVertexPoints;
  }
  
  public float getPositionX()
  {
    if (this.pagView != null) {
      return this.pagView.getTranslationX();
    }
    return 0.0F;
  }
  
  public float getPositionY()
  {
    if (this.pagView != null) {
      return this.pagView.getTranslationY();
    }
    return 0.0F;
  }
  
  public double getProgress()
  {
    if (this.pagView != null) {
      return this.pagView.getProgress();
    }
    return 0.0D;
  }
  
  public TAVSticker getSticker()
  {
    return this.sticker;
  }
  
  protected View.OnTouchListener getStickerTouchListener()
  {
    return new TAVStickerEditView.TavStickerTouchListener(this, null);
  }
  
  public void getUnderPointLayerItems(int paramInt1, int paramInt2, ITAVTouchStickerLayerListener paramITAVTouchStickerLayerListener)
  {
    if (paramITAVTouchStickerLayerListener == null) {}
    ArrayList localArrayList;
    PAGLayer[] arrayOfPAGLayer;
    do
    {
      do
      {
        return;
      } while (this.pagView == null);
      localObject = null;
      if (!isTouchInStickerEditView(paramInt1, paramInt2)) {
        break;
      }
      localArrayList = new ArrayList();
      localObject = convertCoordinate(paramInt1, paramInt2);
      arrayOfPAGLayer = this.pagView.getLayersUnderPoint(((PointF)localObject).x, ((PointF)localObject).y);
    } while ((arrayOfPAGLayer == null) || (arrayOfPAGLayer.length <= 0));
    paramInt2 = arrayOfPAGLayer.length;
    paramInt1 = 0;
    Object localObject = localArrayList;
    if (paramInt1 < paramInt2)
    {
      localObject = arrayOfPAGLayer[paramInt1];
      if (localObject == null) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        int i = ((PAGLayer)localObject).editableIndex();
        if (3 == ((PAGLayer)localObject).layerType())
        {
          localObject = this.sticker.getTavStickerTextItem(i);
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
        else if (5 == ((PAGLayer)localObject).layerType())
        {
          localObject = this.sticker.getTavStickerImageItem(i);
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
        else if (2 == ((PAGLayer)localObject).layerType())
        {
          localObject = this.sticker.getTavStickerSolidItem(i);
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
    }
    paramITAVTouchStickerLayerListener.onTouchSticker(this.sticker, (List)localObject);
  }
  
  protected void handleMoveLimit()
  {
    float f3 = this.centerX;
    float f5 = this.centerY;
    float f7;
    float f8;
    float f9;
    float f10;
    float f2;
    if (TAVStickerMoveLimit.LIMIT_VERTEX == this.sticker.getStickerMoveLimit())
    {
      f7 = TAVStickerUtil.getMinXBy4Point(this.vertexPoints[0], this.vertexPoints[1], this.vertexPoints[2], this.vertexPoints[3]);
      f8 = TAVStickerUtil.getMaxXBy4Point(this.vertexPoints[0], this.vertexPoints[1], this.vertexPoints[2], this.vertexPoints[3]);
      f9 = TAVStickerUtil.getMinYBy4Point(this.vertexPoints[0], this.vertexPoints[1], this.vertexPoints[2], this.vertexPoints[3]);
      f10 = TAVStickerUtil.getMaxYBy4Point(this.vertexPoints[0], this.vertexPoints[1], this.vertexPoints[2], this.vertexPoints[3]);
      if (f7 >= this.moveStartOffsetX) {
        break label706;
      }
      f2 = this.moveStartOffsetX - f7;
      f3 += f2;
    }
    for (;;)
    {
      float f1 = f3;
      if (f8 > this.moveRegionWidth + this.moveStartOffsetX)
      {
        f2 = this.moveRegionWidth + this.moveStartOffsetX - f8;
        f1 = f3 + f2;
      }
      float f4;
      if (f9 < this.moveStartOffsetY)
      {
        f4 = this.moveStartOffsetY - f9;
        f5 += f4;
      }
      for (;;)
      {
        f3 = f5;
        if (f10 > this.moveRegionHeight + this.moveStartOffsetY)
        {
          f4 = this.moveRegionHeight + this.moveStartOffsetY - f10;
          f3 = f5 + f4;
        }
        float f6 = f1;
        f5 = f2;
        if (f7 < this.moveStartOffsetX)
        {
          f6 = f1;
          f5 = f2;
          if (f8 > this.moveRegionWidth + this.moveStartOffsetX)
          {
            f6 = f1 + 0.0F;
            f5 = 0.0F;
          }
        }
        f7 = f6;
        f8 = f5;
        f1 = f3;
        f2 = f4;
        if (f9 < this.moveStartOffsetY)
        {
          f7 = f6;
          f8 = f5;
          f1 = f3;
          f2 = f4;
          if (f10 > this.moveRegionHeight + this.moveStartOffsetY)
          {
            f1 = f3 + 0.0F;
            f2 = 0.0F;
            f8 = f5;
            f7 = f6;
          }
        }
        this.centerX = f7;
        this.centerY = f1;
        if ((Math.abs(f8) > 0.0F) || (Math.abs(f2) > 0.0F))
        {
          setPosition(getPositionX() + f8, getPositionY() + f2);
          updateVertexPoints();
        }
        return;
        if (f3 < this.moveStartOffsetX)
        {
          f2 = this.moveStartOffsetX - f3;
          f3 = this.moveStartOffsetX + 0;
        }
        for (;;)
        {
          f1 = f3;
          if (f3 > this.moveRegionWidth + this.moveStartOffsetX)
          {
            f2 = this.moveRegionWidth + this.moveStartOffsetX - f3;
            f1 = this.moveRegionWidth + this.moveStartOffsetX;
          }
          if (f5 < this.moveStartOffsetY)
          {
            f4 = this.moveStartOffsetY - f5;
            f5 = this.moveStartOffsetY + 0;
          }
          for (;;)
          {
            f3 = f5;
            if (f5 > this.moveRegionHeight + this.moveStartOffsetY)
            {
              f4 = this.moveRegionHeight + this.moveStartOffsetY - f5;
              f3 = this.moveRegionHeight + this.moveStartOffsetY;
            }
            f6 = f1;
            f5 = f2;
            if (f1 < this.moveStartOffsetX)
            {
              f6 = f1;
              f5 = f2;
              if (f1 > this.moveRegionWidth + this.moveStartOffsetX)
              {
                f6 = f1 + 0.0F;
                f5 = 0.0F;
              }
            }
            f7 = f6;
            f8 = f5;
            f1 = f3;
            f2 = f4;
            if (f3 >= this.moveStartOffsetY) {
              break;
            }
            f7 = f6;
            f8 = f5;
            f1 = f3;
            f2 = f4;
            if (f3 <= this.moveRegionHeight + this.moveStartOffsetY) {
              break;
            }
            f1 = f3 + 0.0F;
            f2 = 0.0F;
            f7 = f6;
            f8 = f5;
            break;
            f4 = 0.0F;
          }
          f2 = 0.0F;
        }
        f4 = 0.0F;
      }
      label706:
      f2 = 0.0F;
    }
  }
  
  boolean handleTouchEvent(View paramView, MotionEvent paramMotionEvent)
  {
    int i = this.touchListeners.size() - 1;
    while (i >= 0)
    {
      View.OnTouchListener localOnTouchListener = (View.OnTouchListener)this.touchListeners.get(i);
      if ((localOnTouchListener != null) && (localOnTouchListener.onTouch(paramView, paramMotionEvent))) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  void initLocation(int paramInt1, int paramInt2)
  {
    this.isNeedInitLocation = false;
    this.stickerContainerWidth = paramInt1;
    this.stickerContainerHeight = paramInt2;
    updateStickerMoveRect();
    Object localObject = TAVStickerUtil.getStickerRect(this.sticker, paramInt1, paramInt2, 1.0F);
    if (localObject != null)
    {
      this.stickerWidth = ((int)RectUtil.getRectWidth((RectF)localObject));
      this.stickerHeight = ((int)RectUtil.getRectHeight((RectF)localObject));
      this.positionX = ((int)((RectF)localObject).left);
      this.positionY = ((int)((RectF)localObject).top);
    }
    if (this.pagView != null)
    {
      localObject = this.pagView.getLayoutParams();
      if (localObject != null)
      {
        ((ViewGroup.LayoutParams)localObject).width = this.stickerWidth;
        ((ViewGroup.LayoutParams)localObject).height = this.stickerHeight;
        this.pagView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    initLocationData();
    initScaleData();
    setPosition(this.positionX, this.positionY);
    setScale(this.scale);
    setRotate(this.rotate);
    updateVertexPoints();
  }
  
  protected void initScaleData()
  {
    this.scaleMax = this.sticker.getMaxScale();
    if ((this.scaleMax < 0.0F) && (this.sticker.getWidth() > 0) && (this.sticker.getHeight() > 0)) {
      this.scaleMax = (1.0F * Math.max(this.moveRegionWidth, this.moveRegionHeight) / Math.min(this.sticker.getWidth(), this.sticker.getHeight()));
    }
    if (TAVStickerMoveLimit.LIMIT_VERTEX == this.sticker.getStickerMoveLimit())
    {
      float f1 = Math.min(this.moveRegionWidth, this.moveRegionHeight);
      float f2 = TAVStickerUtil.getDistance(this.vertexPoints[0], this.vertexPoints[2]);
      if (f2 > 0.0F) {
        this.scaleMax = Math.min(f1 / f2, this.scaleMax);
      }
    }
    this.scaleMin = this.sticker.getMinScale();
    if (this.scaleMin < 0.0F) {
      this.scaleMin = 0.0F;
    }
    if ((this.scaleMin > 0.0F) && (this.scaleMax > 0.0F))
    {
      if (this.scale < this.scaleMin) {
        this.scale = this.scaleMin;
      }
      if (this.scale > this.scaleMax) {
        this.scale = this.scaleMax;
      }
    }
  }
  
  protected void initStickerData()
  {
    this.isShowDefaultBorder = this.sticker.isShowDefaultBorder();
    this.scale = this.sticker.getScale();
    if (this.scale <= 0.0F)
    {
      this.scale = 1.0F;
      this.sticker.setScale(this.scale);
    }
    this.rotate = this.sticker.getRotate();
  }
  
  boolean isNeedInitLocation()
  {
    return this.isNeedInitLocation;
  }
  
  public boolean isPlaying()
  {
    if (this.pagView != null) {
      return this.pagView.isPlaying();
    }
    return false;
  }
  
  public float maxFrameRate()
  {
    if (this.pagView != null) {
      this.pagView.maxFrameRate();
    }
    return 0.0F;
  }
  
  void needInitLocation()
  {
    this.isNeedInitLocation = true;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.isFirstDraw)
    {
      this.isFirstDraw = false;
      adjustLocation(TAVStickerOperationMode.OP_NONE);
      this.correctedOriginalCenterX = this.centerX;
      this.correctedOriginalCenterY = this.centerY;
    }
    if ((this.isShowDefaultBorder) && (TAVStickerMode.ACTIVE == this.mode))
    {
      paramCanvas.drawLine(this.vertexPoints[0].x, this.vertexPoints[0].y, this.vertexPoints[1].x, this.vertexPoints[1].y, this.borderPaint);
      paramCanvas.drawLine(this.vertexPoints[1].x, this.vertexPoints[1].y, this.vertexPoints[2].x, this.vertexPoints[2].y, this.borderPaint);
      paramCanvas.drawLine(this.vertexPoints[2].x, this.vertexPoints[2].y, this.vertexPoints[3].x, this.vertexPoints[3].y, this.borderPaint);
      paramCanvas.drawLine(this.vertexPoints[3].x, this.vertexPoints[3].y, this.vertexPoints[0].x, this.vertexPoints[0].y, this.borderPaint);
    }
    if ((this.isDrawMovieLimitRect) && (RectUtil.rectIsValid(this.stickerMoveLimitRect)))
    {
      if (this.movieRectPaint == null) {
        initMoveRectPaint();
      }
      paramCanvas.drawRect(this.stickerMoveLimitRect, this.movieRectPaint);
    }
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
  }
  
  public void play(int paramInt)
  {
    TLog.d(TAG, "play -> repeatCount : " + paramInt);
    if (this.pagView != null)
    {
      this.pagView.setRepeatCount(paramInt);
      if (!this.pagView.isPlaying()) {
        this.pagView.play();
      }
    }
  }
  
  @NonNull
  protected PointF positionInterceptor(float paramFloat1, float paramFloat2)
  {
    return new PointF(paramFloat1, paramFloat2);
  }
  
  public void removeOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    if (paramOnTouchListener == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = new ArrayList(this.touchListeners).iterator();
      while (localIterator.hasNext())
      {
        View.OnTouchListener localOnTouchListener = (View.OnTouchListener)localIterator.next();
        if ((localOnTouchListener != null) && (localOnTouchListener == paramOnTouchListener)) {
          this.touchListeners.remove(paramOnTouchListener);
        }
      }
    }
  }
  
  @FloatRange(from=0.0D, to=360.0D)
  protected float rotateInterceptor(float paramFloat)
  {
    return paramFloat;
  }
  
  public float scaleInterceptor(float paramFloat)
  {
    return paramFloat;
  }
  
  public void setDrawMovieLimitRect(boolean paramBoolean)
  {
    this.isDrawMovieLimitRect = paramBoolean;
    postInvalidate();
  }
  
  public void setEventType(int paramInt)
  {
    this.eventType = paramInt;
  }
  
  public void setImageData(int paramInt, PAGImage paramPAGImage)
  {
    if (this.pagView != null) {
      this.pagView.replaceImage(paramInt, paramPAGImage);
    }
  }
  
  public void setLayerColor(int paramInt1, int paramInt2)
  {
    PAGLayer[] arrayOfPAGLayer;
    if (this.pagView != null)
    {
      arrayOfPAGLayer = ((PAGFile)this.pagView.getComposition()).getLayersByEditableIndex(paramInt1, 2);
      if (arrayOfPAGLayer != null) {
        break label30;
      }
    }
    for (;;)
    {
      return;
      label30:
      int i = arrayOfPAGLayer.length;
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        PAGLayer localPAGLayer = arrayOfPAGLayer[paramInt1];
        if ((localPAGLayer instanceof PAGSolidLayer)) {
          ((PAGSolidLayer)localPAGLayer).setSolidColor(paramInt2);
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void setMaxFrameRate(float paramFloat)
  {
    if (this.pagView != null) {
      this.pagView.setMaxFrameRate(paramFloat);
    }
  }
  
  public void setMode(TAVStickerMode paramTAVStickerMode)
  {
    this.mode = paramTAVStickerMode;
    postInvalidate();
  }
  
  public void setOnStickerEventListener(ITAVStickerEventListener paramITAVStickerEventListener)
  {
    this.stickerEventListener = paramITAVStickerEventListener;
  }
  
  @Deprecated
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    addOnTouchListener(paramOnTouchListener);
  }
  
  public void setPosition(float paramFloat1, float paramFloat2)
  {
    if (this.pagView != null)
    {
      this.pagView.setTranslationX(paramFloat1);
      this.pagView.setTranslationY(paramFloat2);
    }
  }
  
  public void setProgress(double paramDouble)
  {
    if (this.pagView != null) {
      this.pagView.setProgress(paramDouble);
    }
  }
  
  public void setRotate(float paramFloat)
  {
    if (this.pagView != null) {
      this.pagView.setRotation(paramFloat);
    }
    this.rotate = paramFloat;
  }
  
  protected void setScale(float paramFloat)
  {
    if (this.pagView != null)
    {
      this.pagView.setScaleX(paramFloat);
      this.pagView.setScaleY(paramFloat);
    }
    this.scale = paramFloat;
  }
  
  public void setSingleZoomRotateRect(RectF paramRectF)
  {
    this.singleZoomRotateRect = paramRectF;
  }
  
  public void setTextData(int paramInt, PAGText paramPAGText)
  {
    if (this.pagView != null) {
      this.pagView.setTextData(paramInt, paramPAGText);
    }
  }
  
  public void stop()
  {
    if (this.pagView != null) {
      this.pagView.stop();
    }
  }
  
  public void updateStickerMoveRect()
  {
    this.stickerMoveLimitRect = RectUtil.getStickerMoveLimitRect(this.sticker.getMoveRect(), this.stickerContainerWidth, this.stickerContainerHeight);
    if (RectUtil.rectIsValid(this.stickerMoveLimitRect))
    {
      this.moveStartOffsetX = this.stickerMoveLimitRect.left;
      this.moveStartOffsetY = this.stickerMoveLimitRect.top;
      this.moveRegionWidth = RectUtil.getRectWidth(this.stickerMoveLimitRect);
      this.moveRegionHeight = RectUtil.getRectHeight(this.stickerMoveLimitRect);
      return;
    }
    this.moveStartOffsetX = 0;
    this.moveStartOffsetY = 0;
    this.moveRegionWidth = this.stickerContainerWidth;
    this.moveRegionHeight = this.stickerContainerHeight;
  }
  
  protected void updateStickerOnAdjustLocation(float paramFloat1, float paramFloat2)
  {
    this.sticker.setCenterX(paramFloat1).setCenterY(paramFloat2).setScale(this.scale).setRotate(this.rotate);
  }
  
  protected void updateVertexPoints()
  {
    PointF[] arrayOfPointF = TAVStickerUtil.computeRectanglePoints(this.pagView.getMatrix(), this.stickerWidth, this.stickerHeight);
    this.vertexPoints[0] = arrayOfPointF[0];
    this.vertexPoints[1] = arrayOfPointF[1];
    this.vertexPoints[2] = arrayOfPointF[2];
    this.vertexPoints[3] = arrayOfPointF[3];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerEditView
 * JD-Core Version:    0.7.0.1
 */