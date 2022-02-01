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
  public static final String TAG = "TAVStickerEditView";
  private Paint borderPaint = null;
  protected float centerX = 0.0F;
  protected float centerY = 0.0F;
  private Region clipRegion = new Region();
  private Context context = null;
  private PointF convertPoint = new PointF();
  protected float correctedOriginalCenterX = 0.0F;
  protected float correctedOriginalCenterY = 0.0F;
  protected int eventType = 15;
  private boolean isDrawMovieLimitRect = false;
  protected boolean isFirstDraw = true;
  protected boolean isNeedInitLocation = true;
  private boolean isShowDefaultBorder = true;
  protected TAVStickerMode mode = TAVStickerMode.DEFAULT;
  protected int moveRegionHeight = 0;
  protected int moveRegionWidth = 0;
  protected int moveStartOffsetX = 0;
  protected int moveStartOffsetY = 0;
  private Paint movieRectPaint = null;
  protected float originalCenterX = 0.0F;
  protected float originalCenterY = 0.0F;
  private PointF[] originalVertexPoints = { new PointF(), new PointF(), new PointF(), new PointF() };
  protected PAGView pagView = null;
  private Path path = new Path();
  protected float positionX = 0.0F;
  protected float positionY = 0.0F;
  private RectF rectF = new RectF();
  private Region region = new Region();
  protected float rotate = 0.0F;
  protected float scale = 1.0F;
  protected float scaleMax = 0.0F;
  protected float scaleMin = 0.0F;
  protected RectF singleZoomRotateRect = null;
  protected TAVSticker sticker = null;
  protected int stickerContainerHeight = 0;
  protected int stickerContainerWidth = 0;
  protected ITAVStickerEventListener stickerEventListener = null;
  protected int stickerHeight = 0;
  protected Rect stickerMoveLimitRect = null;
  private View.OnTouchListener stickerTouchListener = null;
  protected int stickerWidth = 0;
  private List<View.OnTouchListener> touchListeners = new ArrayList();
  protected PointF[] vertexPoints = { new PointF(), new PointF(), new PointF(), new PointF() };
  
  public TAVStickerEditView(@NonNull Context paramContext, @NonNull TAVSticker paramTAVSticker)
  {
    super(paramContext);
    if ((paramContext != null) && (paramTAVSticker != null))
    {
      this.context = paramContext;
      this.sticker = paramTAVSticker;
      init();
      return;
    }
    throw new IllegalArgumentException("<init> can not initialization TAVStickerEditView, parameter 'context' and 'sticker' must not is null!");
  }
  
  private PointF convertCoordinate(float paramFloat1, float paramFloat2)
  {
    if (this.convertPoint == null) {
      this.convertPoint = new PointF();
    }
    int i = getWidth();
    int j = getHeight();
    float f2 = i;
    float f5 = f2 / 2.0F;
    float f1 = j;
    float f3 = f1 / 2.0F;
    float f6 = this.correctedOriginalCenterX;
    float f4 = this.correctedOriginalCenterY;
    paramFloat1 += f5 - f6;
    paramFloat2 += f3 - f4;
    if ((i > 0) && (j > 0))
    {
      PAGView localPAGView = this.pagView;
      if (localPAGView != null)
      {
        f5 = this.centerX;
        f6 = this.originalCenterX;
        f3 = this.centerY;
        f4 = this.originalCenterY;
        paramFloat1 = (paramFloat1 - (f5 - f6)) / f2;
        f2 = localPAGView.getWidth();
        paramFloat2 = (paramFloat2 - (f3 - f4)) / f1;
        f1 = this.pagView.getHeight();
        this.convertPoint.set(paramFloat1 * f2, paramFloat2 * f1);
        return this.convertPoint;
      }
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
    this.stickerTouchListener = new TAVStickerEditView.TavStickerTouchListener(this, null);
    addOnTouchListener(this.stickerTouchListener);
  }
  
  private void initLocationData()
  {
    this.vertexPoints[0].set(this.positionX, this.positionY);
    this.vertexPoints[1].set(this.positionX + this.stickerWidth, this.positionY);
    this.vertexPoints[2].set(this.positionX + this.stickerWidth, this.positionY + this.stickerHeight);
    this.vertexPoints[3].set(this.positionX, this.positionY + this.stickerHeight);
    PointF[] arrayOfPointF1 = this.originalVertexPoints;
    PointF[] arrayOfPointF2 = this.vertexPoints;
    arrayOfPointF1[0] = arrayOfPointF2[0];
    arrayOfPointF1[1] = arrayOfPointF2[1];
    arrayOfPointF1[2] = arrayOfPointF2[2];
    arrayOfPointF1[3] = arrayOfPointF2[3];
    this.centerX = TAVStickerUtil.getMiddlePoint(arrayOfPointF2[0], arrayOfPointF2[2]).x;
    arrayOfPointF1 = this.vertexPoints;
    this.centerY = TAVStickerUtil.getMiddlePoint(arrayOfPointF1[0], arrayOfPointF1[2]).y;
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
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initPagView -> pagFile.width() : ");
      localStringBuilder.append(localPAGFile.width());
      localStringBuilder.append(", pagFile.height() : ");
      localStringBuilder.append(localPAGFile.height());
      TLog.d(str, localStringBuilder.toString());
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
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isTouchInStickerEditView -> contains : ");
    localStringBuilder.append(bool);
    TLog.d(str, localStringBuilder.toString());
    return bool;
  }
  
  public void addOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    if (paramOnTouchListener == null) {
      return;
    }
    this.touchListeners.add(paramOnTouchListener);
  }
  
  protected void adjustLocation(TAVStickerOperationMode paramTAVStickerOperationMode)
  {
    updateVertexPoints();
    Object localObject = this.vertexPoints;
    this.centerX = TAVStickerUtil.getMiddlePoint(localObject[0], localObject[2]).x;
    localObject = this.vertexPoints;
    this.centerY = TAVStickerUtil.getMiddlePoint(localObject[0], localObject[2]).y;
    handleMoveLimit();
    int i = this.stickerContainerWidth;
    float f2 = 0.5F;
    float f1;
    if (i != 0) {
      f1 = this.centerX / i;
    } else {
      f1 = 0.5F;
    }
    i = this.stickerContainerHeight;
    if (i != 0) {
      f2 = this.centerY / i;
    }
    updateStickerOnAdjustLocation(f1, f2);
    localObject = this.stickerEventListener;
    if (localObject != null) {
      ((ITAVStickerEventListener)localObject).onDataChanged(this.sticker, paramTAVStickerOperationMode, this.centerX, this.centerY, this.scale, this.rotate);
    }
  }
  
  public long duration()
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null) {
      return localPAGView.duration() / 1000L;
    }
    return 0L;
  }
  
  public boolean flush()
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null) {
      return localPAGView.flush();
    }
    return false;
  }
  
  public boolean flush(boolean paramBoolean)
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null) {
      return localPAGView.flush(paramBoolean);
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
  
  protected float getPositionX()
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null) {
      return localPAGView.getTranslationX();
    }
    return 0.0F;
  }
  
  protected float getPositionY()
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null) {
      return localPAGView.getTranslationY();
    }
    return 0.0F;
  }
  
  public double getProgress()
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null) {
      return localPAGView.getProgress();
    }
    return 0.0D;
  }
  
  public TAVSticker getSticker()
  {
    return this.sticker;
  }
  
  protected View.OnTouchListener getStickerTouchListener()
  {
    return this.stickerTouchListener;
  }
  
  public void getUnderPointLayerItems(int paramInt1, int paramInt2, ITAVTouchStickerLayerListener paramITAVTouchStickerLayerListener)
  {
    if (paramITAVTouchStickerLayerListener == null) {
      return;
    }
    if (this.pagView == null) {
      return;
    }
    Object localObject = null;
    if (isTouchInStickerEditView(paramInt1, paramInt2))
    {
      ArrayList localArrayList = new ArrayList();
      localObject = convertCoordinate(paramInt1, paramInt2);
      PAGLayer[] arrayOfPAGLayer = this.pagView.getLayersUnderPoint(((PointF)localObject).x, ((PointF)localObject).y);
      if (arrayOfPAGLayer != null)
      {
        if (arrayOfPAGLayer.length <= 0) {
          return;
        }
        paramInt2 = arrayOfPAGLayer.length;
        paramInt1 = 0;
        for (;;)
        {
          localObject = localArrayList;
          if (paramInt1 >= paramInt2) {
            break;
          }
          localObject = arrayOfPAGLayer[paramInt1];
          if (localObject != null)
          {
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
          paramInt1 += 1;
        }
      }
      return;
    }
    paramITAVTouchStickerLayerListener.onTouchSticker(this.sticker, (List)localObject);
  }
  
  protected void handleMoveLimit()
  {
    float f3 = this.centerX;
    float f6 = this.centerY;
    float f7;
    float f8;
    int i;
    float f2;
    int j;
    float f1;
    float f5;
    float f4;
    if (TAVStickerMoveLimit.LIMIT_VERTEX == this.sticker.getStickerMoveLimit())
    {
      PointF[] arrayOfPointF = this.vertexPoints;
      float f9 = TAVStickerUtil.getMinXBy4Point(arrayOfPointF[0], arrayOfPointF[1], arrayOfPointF[2], arrayOfPointF[3]);
      arrayOfPointF = this.vertexPoints;
      float f10 = TAVStickerUtil.getMaxXBy4Point(arrayOfPointF[0], arrayOfPointF[1], arrayOfPointF[2], arrayOfPointF[3]);
      arrayOfPointF = this.vertexPoints;
      f7 = TAVStickerUtil.getMinYBy4Point(arrayOfPointF[0], arrayOfPointF[1], arrayOfPointF[2], arrayOfPointF[3]);
      arrayOfPointF = this.vertexPoints;
      f8 = TAVStickerUtil.getMaxYBy4Point(arrayOfPointF[0], arrayOfPointF[1], arrayOfPointF[2], arrayOfPointF[3]);
      i = this.moveStartOffsetX;
      if (f9 < i)
      {
        f2 = i - f9;
        f3 += f2;
      }
      else
      {
        f2 = 0.0F;
      }
      i = this.moveRegionWidth;
      j = this.moveStartOffsetX;
      f1 = f3;
      if (f10 > i + j)
      {
        f2 = i + j - f10;
        f1 = f3 + f2;
      }
      i = this.moveStartOffsetY;
      if (f7 < i)
      {
        f5 = i - f7;
        f3 = f6 + f5;
      }
      else
      {
        f5 = 0.0F;
        f3 = f6;
      }
      i = this.moveRegionHeight;
      j = this.moveStartOffsetY;
      f4 = f3;
      if (f8 > i + j)
      {
        f5 = i + j - f8;
        f4 = f3 + f5;
      }
      i = this.moveStartOffsetX;
      f6 = f1;
      f3 = f2;
      if (f9 < i)
      {
        f6 = f1;
        f3 = f2;
        if (f10 > this.moveRegionWidth + i)
        {
          f6 = f1 + 0.0F;
          f3 = 0.0F;
        }
      }
      i = this.moveStartOffsetY;
      f1 = f4;
      f2 = f5;
      if (f7 < i)
      {
        f1 = f4;
        f2 = f5;
        if (f8 > this.moveRegionHeight + i)
        {
          f1 = f4 + 0.0F;
          f2 = 0.0F;
        }
      }
      f7 = f6;
      f5 = f1;
      f6 = f2;
      f8 = f3;
    }
    else
    {
      i = this.moveStartOffsetX;
      if (f3 < i)
      {
        f2 = i;
        f1 = i + 0;
        f2 -= f3;
        f3 = f1;
      }
      else
      {
        f2 = 0.0F;
      }
      i = this.moveRegionWidth;
      j = this.moveStartOffsetX;
      f1 = f3;
      if (f3 > i + j)
      {
        f2 = i + j - f3;
        f1 = i + j;
      }
      i = this.moveStartOffsetY;
      if (f6 < i)
      {
        f3 = i;
        f5 = i + 0;
        f4 = f3 - f6;
      }
      else
      {
        f4 = 0.0F;
        f5 = f6;
      }
      i = this.moveRegionHeight;
      j = this.moveStartOffsetY;
      f3 = f5;
      if (f5 > i + j)
      {
        f4 = i + j - f5;
        f3 = i + j;
      }
      i = this.moveStartOffsetX;
      if ((f1 < i) && (f1 > this.moveRegionWidth + i))
      {
        f1 += 0.0F;
        f2 = 0.0F;
      }
      i = this.moveStartOffsetY;
      f7 = f1;
      f5 = f3;
      f6 = f4;
      f8 = f2;
      if (f3 < i)
      {
        f7 = f1;
        f5 = f3;
        f6 = f4;
        f8 = f2;
        if (f3 > this.moveRegionHeight + i)
        {
          f5 = f3 + 0.0F;
          f6 = 0.0F;
          f8 = f2;
          f7 = f1;
        }
      }
    }
    this.centerX = f7;
    this.centerY = f5;
    if ((Math.abs(f8) > 0.0F) || (Math.abs(f6) > 0.0F))
    {
      setPosition(getPositionX() + f8, getPositionY() + f6);
      updateVertexPoints();
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
  
  public void initLocation(int paramInt1, int paramInt2)
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
    localObject = this.pagView;
    if (localObject != null)
    {
      localObject = ((PAGView)localObject).getLayoutParams();
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
      this.scaleMax = (Math.max(this.moveRegionWidth, this.moveRegionHeight) * 1.0F / Math.min(this.sticker.getWidth(), this.sticker.getHeight()));
    }
    float f2;
    if (TAVStickerMoveLimit.LIMIT_VERTEX == this.sticker.getStickerMoveLimit())
    {
      f1 = Math.min(this.moveRegionWidth, this.moveRegionHeight);
      PointF[] arrayOfPointF = this.vertexPoints;
      f2 = TAVStickerUtil.getDistance(arrayOfPointF[0], arrayOfPointF[2]);
      if (f2 > 0.0F) {
        this.scaleMax = Math.min(f1 / f2, this.scaleMax);
      }
    }
    this.scaleMin = this.sticker.getMinScale();
    if (this.scaleMin < 0.0F) {
      this.scaleMin = 0.0F;
    }
    float f1 = this.scaleMin;
    if ((f1 > 0.0F) && (this.scaleMax > 0.0F))
    {
      if (this.scale < f1) {
        this.scale = f1;
      }
      f1 = this.scale;
      f2 = this.scaleMax;
      if (f1 > f2) {
        this.scale = f2;
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
  
  public boolean isNeedInitLocation()
  {
    return this.isNeedInitLocation;
  }
  
  public boolean isPlaying()
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null) {
      return localPAGView.isPlaying();
    }
    return false;
  }
  
  public float maxFrameRate()
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null) {
      localPAGView.maxFrameRate();
    }
    return 0.0F;
  }
  
  public void needInitLocation()
  {
    this.isNeedInitLocation = true;
  }
  
  protected void onDraw(Canvas paramCanvas)
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
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("play -> repeatCount : ");
    localStringBuilder.append(paramInt);
    TLog.d((String)localObject, localStringBuilder.toString());
    localObject = this.pagView;
    if (localObject != null)
    {
      ((PAGView)localObject).setRepeatCount(paramInt);
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
    if (paramOnTouchListener == null) {
      return;
    }
    Iterator localIterator = new ArrayList(this.touchListeners).iterator();
    while (localIterator.hasNext())
    {
      View.OnTouchListener localOnTouchListener = (View.OnTouchListener)localIterator.next();
      if ((localOnTouchListener != null) && (localOnTouchListener == paramOnTouchListener)) {
        this.touchListeners.remove(paramOnTouchListener);
      }
    }
  }
  
  @FloatRange(from=0.0D, to=360.0D)
  protected float rotateInterceptor(float paramFloat)
  {
    return paramFloat;
  }
  
  protected float scaleInterceptor(float paramFloat)
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
    PAGView localPAGView = this.pagView;
    if (localPAGView != null) {
      localPAGView.replaceImage(paramInt, paramPAGImage);
    }
  }
  
  public void setLayerColor(String paramString, int paramInt)
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null)
    {
      paramString = ((PAGFile)localPAGView.getComposition()).getLayersByName(paramString);
      if (paramString == null) {
        return;
      }
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        localPAGView = paramString[i];
        if ((localPAGView instanceof PAGSolidLayer)) {
          ((PAGSolidLayer)localPAGView).setSolidColor(paramInt);
        }
        i += 1;
      }
    }
  }
  
  public void setMaxFrameRate(float paramFloat)
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null) {
      localPAGView.setMaxFrameRate(paramFloat);
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
  
  protected void setPosition(float paramFloat1, float paramFloat2)
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null)
    {
      localPAGView.setTranslationX(paramFloat1);
      this.pagView.setTranslationY(paramFloat2);
    }
  }
  
  public void setProgress(double paramDouble)
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null) {
      localPAGView.setProgress(paramDouble);
    }
  }
  
  protected void setRotate(float paramFloat)
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null) {
      localPAGView.setRotation(paramFloat);
    }
    this.rotate = paramFloat;
  }
  
  protected void setScale(float paramFloat)
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null)
    {
      localPAGView.setScaleX(paramFloat);
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
    PAGView localPAGView = this.pagView;
    if (localPAGView != null) {
      localPAGView.setTextData(paramInt, paramPAGText);
    }
  }
  
  public void stop()
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null) {
      localPAGView.stop();
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
    PointF[] arrayOfPointF1 = TAVStickerUtil.computeRectanglePoints(this.pagView.getMatrix(), this.stickerWidth, this.stickerHeight);
    PointF[] arrayOfPointF2 = this.vertexPoints;
    arrayOfPointF2[0] = arrayOfPointF1[0];
    arrayOfPointF2[1] = arrayOfPointF1[1];
    arrayOfPointF2[2] = arrayOfPointF1[2];
    arrayOfPointF2[3] = arrayOfPointF1[3];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerEditView
 * JD-Core Version:    0.7.0.1
 */