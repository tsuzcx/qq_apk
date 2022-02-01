package com.tencent.qcircle.tavcut.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.qcircle.tavcut.view.ext.OnActiveBasePicListener;
import com.tencent.qcircle.tavcut.view.ext.OnGestureListener;
import com.tencent.qcircle.tavcut.view.ext.OnLongPressListener;
import com.tencent.qcircle.tavcut.view.ext.OnOutsidePhotoTapListener;
import com.tencent.qcircle.tavcut.view.ext.OnPhotoTapListener;
import com.tencent.qcircle.tavcut.view.ext.OnRotationListener;
import com.tencent.qcircle.tavcut.view.ext.OnScaleChangedListener;
import com.tencent.qcircle.tavcut.view.ext.OnSingleFlingListener;
import com.tencent.qcircle.tavcut.view.ext.OnViewDragListener;
import com.tencent.qcircle.tavcut.view.ext.OnViewTapListener;
import com.tencent.qcircle.tavcut.view.ext.TAVGestureDetector;
import com.tencent.tavsticker.utils.ViewUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qcircle/tavcut/view/TAVCutImageView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnTouchListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DEFAULT_MAX_SCALE", "", "DEFAULT_MID_SCALE", "DEFAULT_MIN_SCALE", "DEFAULT_ZOOM_DURATION", "HORIZONTAL_EDGE_BOTH", "HORIZONTAL_EDGE_LEFT", "HORIZONTAL_EDGE_NONE", "HORIZONTAL_EDGE_RIGHT", "SINGLE_TOUCH", "VERTICAL_EDGE_BOTH", "VERTICAL_EDGE_BOTTOM", "VERTICAL_EDGE_NONE", "VERTICAL_EDGE_TOP", "bitmapBound", "Landroid/graphics/RectF;", "getBitmapBound", "()Landroid/graphics/RectF;", "setBitmapBound", "(Landroid/graphics/RectF;)V", "bmpZoom", "Landroid/graphics/Bitmap;", "getBmpZoom", "()Landroid/graphics/Bitmap;", "setBmpZoom", "(Landroid/graphics/Bitmap;)V", "borderLines", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Landroid/graphics/PointF;", "Lkotlin/collections/ArrayList;", "center", "innerImageView", "Landroid/widget/ImageView;", "innerLines", "innerStickerContainer", "isActive", "", "mActiveBasePicListener", "Lcom/tencent/qcircle/tavcut/view/ext/OnActiveBasePicListener;", "mAllowParentInterceptOnEdge", "mBlockParentIntercept", "mGestureCallback", "Lcom/tencent/qcircle/tavcut/view/TAVCutImageView$GestureCallback;", "mGestureDetector", "Landroid/view/GestureDetector;", "mHorizontalScrollEdge", "mLongPressListener", "Lcom/tencent/qcircle/tavcut/view/ext/OnLongPressListener;", "mOnClickListener", "Landroid/view/View$OnClickListener;", "mOnDragListener", "Lcom/tencent/qcircle/tavcut/view/ext/OnViewDragListener;", "mOnRotationListener", "Lcom/tencent/qcircle/tavcut/view/ext/OnRotationListener;", "mOutsidePhotoTapListener", "Lcom/tencent/qcircle/tavcut/view/ext/OnOutsidePhotoTapListener;", "mPhotoTapListener", "Lcom/tencent/qcircle/tavcut/view/ext/OnPhotoTapListener;", "mScaleChangeListener", "Lcom/tencent/qcircle/tavcut/view/ext/OnScaleChangedListener;", "mSingleFlingListener", "Lcom/tencent/qcircle/tavcut/view/ext/OnSingleFlingListener;", "mTAVDetector", "Lcom/tencent/qcircle/tavcut/view/ext/TAVGestureDetector;", "mVerticalScrollEdge", "mViewTapListener", "Lcom/tencent/qcircle/tavcut/view/ext/OnViewTapListener;", "maxDis", "onGestureListener", "Lcom/tencent/qcircle/tavcut/view/ext/OnGestureListener;", "points", "", "zoomBtnRect", "getZoomBtnRect", "setZoomBtnRect", "value", "zoomResId", "getZoomResId", "()I", "setZoomResId", "(I)V", "checkInside", "point", "isFromSticker", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "dispatchStickerTouchEvent", "e", "Landroid/view/MotionEvent;", "drawZoomBtn", "getCross", "p1", "p2", "getRotate", "getStickerContainer", "makePointPairs", "onTouch", "v", "Landroid/view/View;", "ev", "setActiveBasePicListener", "onActiveBasePicListener", "setAllowParentInterceptOnEdge", "allow", "setBasePicActive", "active", "setGestureCallback", "gestureCallback", "setImageBitmap", "bitmap", "setLongPressListener", "onLongPressListener", "setOnClick", "listener", "setOnOutsidePhotoTapListener", "setOnPhotoTapListener", "setOnRotationListener", "onRotationListener", "setOnScaleChangeListener", "onScaleChangedListener", "setOnSingleFlingListener", "onSingleFlingListener", "setOnViewDragListener", "setOnViewTapListener", "GestureCallback", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class TAVCutImageView
  extends FrameLayout
  implements View.OnTouchListener
{
  private final float DEFAULT_MAX_SCALE = 3.0F;
  private final float DEFAULT_MID_SCALE = 1.75F;
  private final float DEFAULT_MIN_SCALE = 1.0F;
  private final int DEFAULT_ZOOM_DURATION = 200;
  private final int HORIZONTAL_EDGE_BOTH = 2;
  private final int HORIZONTAL_EDGE_LEFT;
  private final int HORIZONTAL_EDGE_NONE = -1;
  private final int HORIZONTAL_EDGE_RIGHT = 1;
  private final int SINGLE_TOUCH = 1;
  private final int VERTICAL_EDGE_BOTH = 2;
  private final int VERTICAL_EDGE_BOTTOM = 1;
  private final int VERTICAL_EDGE_NONE = -1;
  private final int VERTICAL_EDGE_TOP;
  private HashMap _$_findViewCache;
  @Nullable
  private RectF bitmapBound;
  @Nullable
  private Bitmap bmpZoom;
  private ArrayList<Pair<PointF, PointF>> borderLines;
  private PointF center;
  private ImageView innerImageView = new ImageView(getContext());
  private ArrayList<Pair<PointF, PointF>> innerLines;
  private FrameLayout innerStickerContainer = new FrameLayout(getContext());
  private boolean isActive;
  private OnActiveBasePicListener mActiveBasePicListener;
  private boolean mAllowParentInterceptOnEdge = true;
  private boolean mBlockParentIntercept;
  private TAVCutImageView.GestureCallback mGestureCallback;
  private GestureDetector mGestureDetector;
  private int mHorizontalScrollEdge = this.HORIZONTAL_EDGE_BOTH;
  private OnLongPressListener mLongPressListener;
  private View.OnClickListener mOnClickListener;
  private OnViewDragListener mOnDragListener;
  private OnRotationListener mOnRotationListener;
  private OnOutsidePhotoTapListener mOutsidePhotoTapListener;
  private OnPhotoTapListener mPhotoTapListener;
  private OnScaleChangedListener mScaleChangeListener;
  private OnSingleFlingListener mSingleFlingListener;
  private TAVGestureDetector mTAVDetector;
  private int mVerticalScrollEdge = this.VERTICAL_EDGE_BOTH;
  private OnViewTapListener mViewTapListener;
  private float maxDis;
  private final OnGestureListener onGestureListener = (OnGestureListener)new TAVCutImageView.onGestureListener.1(this);
  private List<? extends PointF> points;
  @NotNull
  private RectF zoomBtnRect = new RectF();
  private int zoomResId;
  
  public TAVCutImageView(@NotNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TAVCutImageView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TAVCutImageView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    addView((View)this.innerImageView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    addView((View)this.innerStickerContainer, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.mTAVDetector = new TAVGestureDetector(getContext(), this.onGestureListener);
    this.mGestureDetector = new GestureDetector(getContext(), (GestureDetector.OnGestureListener)new TAVCutImageView.1(this));
    paramContext = this.mGestureDetector;
    if (paramContext != null) {
      paramContext.setOnDoubleTapListener((GestureDetector.OnDoubleTapListener)new TAVCutImageView.2(this));
    }
    setOnTouchListener((View.OnTouchListener)this);
    setOnViewTapListener((OnViewTapListener)new TAVCutImageView.3(this));
  }
  
  private final void drawZoomBtn(Canvas paramCanvas)
  {
    if (paramCanvas != null)
    {
      paramCanvas.save();
      Object localObject = this.points;
      if (localObject != null)
      {
        if (((List)localObject).size() >= 4)
        {
          float f1 = ((PointF)((List)localObject).get(2)).x;
          float f2 = ((PointF)((List)localObject).get(2)).y;
          paramCanvas.rotate(getRotate(), f1, f2);
          paramCanvas.scale(0.5F, 0.5F, f1, f2);
          localObject = this.bmpZoom;
          if (localObject != null)
          {
            Rect localRect = new Rect(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
            this.zoomBtnRect = new RectF(f1 - ((Bitmap)localObject).getWidth(), f2 - ((Bitmap)localObject).getHeight(), f1 + ((Bitmap)localObject).getWidth(), f2 + ((Bitmap)localObject).getHeight());
            paramCanvas.setDrawFilter((DrawFilter)new PaintFlagsDrawFilter(0, 3));
            paramCanvas.drawBitmap((Bitmap)localObject, localRect, this.zoomBtnRect, null);
          }
        }
        paramCanvas.restore();
      }
    }
  }
  
  private final float getCross(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3)
  {
    return (paramPointF3.x - paramPointF1.x) * (paramPointF3.y - paramPointF2.y) - (paramPointF3.x - paramPointF2.x) * (paramPointF3.y - paramPointF1.y);
  }
  
  public void _$_clearFindViewByIdCache()
  {
    HashMap localHashMap = this._$_findViewCache;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public final boolean checkInside(@NotNull PointF paramPointF, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramPointF, "point");
    Object localObject1 = paramPointF;
    if (paramBoolean) {
      localObject1 = new PointF(paramPointF.x + this.innerStickerContainer.getX(), paramPointF.y + this.innerStickerContainer.getY());
    }
    paramPointF = this.borderLines;
    if (paramPointF != null)
    {
      Object localObject2 = (Iterable)paramPointF;
      paramPointF = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject2).next();
        paramPointF.add(Float.valueOf(getCross((PointF)localPair.getFirst(), (PointF)localPair.getSecond(), (PointF)localObject1)));
      }
      paramPointF = (List)paramPointF;
      localObject1 = (Iterable)paramPointF;
      paramBoolean = localObject1 instanceof Collection;
      boolean bool = true;
      if ((paramBoolean) && (((Collection)localObject1).isEmpty())) {
        return true;
      }
      localObject1 = ((Iterable)localObject1).iterator();
      int i;
      do
      {
        paramBoolean = bool;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        if (Math.signum(((Number)((Iterator)localObject1).next()).floatValue()) == Math.signum(((Number)paramPointF.get(0)).floatValue())) {
          i = 1;
        } else {
          i = 0;
        }
      } while (i != 0);
      paramBoolean = false;
      return paramBoolean;
    }
    paramPointF = (TAVCutImageView)this;
    return false;
  }
  
  protected void dispatchDraw(@Nullable Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (!this.isActive) {
      return;
    }
    if (paramCanvas != null) {
      paramCanvas.save();
    }
    ArrayList localArrayList = this.innerLines;
    if (localArrayList != null)
    {
      Object localObject = this.bitmapBound;
      if ((localObject != null) && (paramCanvas != null)) {
        paramCanvas.clipRect((RectF)localObject);
      }
      localObject = new Paint();
      ((Paint)localObject).setColor(-1);
      ((Paint)localObject).setStrokeWidth(ViewUtils.dip2px(0.5F));
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      Paint localPaint = new Paint();
      localPaint.setColor(Color.parseColor("#B3FFFFFF"));
      localPaint.setStrokeWidth(ViewUtils.dip2px(0.5F));
      localPaint.setStyle(Paint.Style.STROKE);
      if (localArrayList.size() < 8) {
        return;
      }
      int i = 0;
      while (i <= 7)
      {
        Path localPath = new Path();
        localPath.moveTo(((PointF)((Pair)localArrayList.get(i)).getFirst()).x, ((PointF)((Pair)localArrayList.get(i)).getFirst()).y);
        localPath.lineTo(((PointF)((Pair)localArrayList.get(i)).getSecond()).x, ((PointF)((Pair)localArrayList.get(i)).getSecond()).y);
        if (i <= 3)
        {
          if (paramCanvas != null) {
            paramCanvas.drawPath(localPath, (Paint)localObject);
          }
        }
        else if (paramCanvas != null) {
          paramCanvas.drawPath(localPath, localPaint);
        }
        i += 1;
      }
    }
    drawZoomBtn(paramCanvas);
    if (paramCanvas != null) {
      paramCanvas.restore();
    }
  }
  
  public final void dispatchStickerTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "e");
    this.innerStickerContainer.dispatchTouchEvent(paramMotionEvent);
  }
  
  @Nullable
  public final RectF getBitmapBound()
  {
    return this.bitmapBound;
  }
  
  @Nullable
  protected final Bitmap getBmpZoom()
  {
    return this.bmpZoom;
  }
  
  public final float getRotate()
  {
    TAVCutImageView.GestureCallback localGestureCallback = this.mGestureCallback;
    if (localGestureCallback != null) {
      return localGestureCallback.getRotate();
    }
    return 0.0F;
  }
  
  @NotNull
  public final FrameLayout getStickerContainer()
  {
    return this.innerStickerContainer;
  }
  
  @NotNull
  protected final RectF getZoomBtnRect()
  {
    return this.zoomBtnRect;
  }
  
  public final int getZoomResId()
  {
    return this.zoomResId;
  }
  
  @Nullable
  public final ArrayList<Pair<PointF, PointF>> makePointPairs(@NotNull List<? extends PointF> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "points");
    if (((((Collection)paramList).isEmpty() ^ true)) && (paramList.size() >= 4))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int i = 1;
      float f1 = 0.0F;
      int j = -1;
      float f3;
      float f2;
      while (i <= 3)
      {
        f3 = TAVCutImageViewKt.calcDistance((PointF)paramList.get(0), (PointF)paramList.get(i));
        f2 = f1;
        if (f3 > f1)
        {
          j = i;
          f2 = f3;
        }
        i += 1;
        f1 = f2;
      }
      this.maxDis = f1;
      if (this.center == null)
      {
        localObject = (TAVCutImageView)this;
        this.center = new PointF();
        localObject = Unit.INSTANCE;
      }
      Object localObject = this.center;
      if (localObject != null)
      {
        f1 = ((PointF)paramList.get(0)).x;
        f2 = ((PointF)paramList.get(j)).x;
        f3 = 2;
        ((PointF)localObject).x = ((f1 + f2) / f3);
        ((PointF)localObject).y = ((((PointF)paramList.get(0)).y + ((PointF)paramList.get(j)).y) / f3);
      }
      i = 1;
      int i1;
      for (int k = 0; i <= 3; k = i1)
      {
        if (i != j)
        {
          if (k != 0)
          {
            localArrayList1.add(new Pair(paramList.get(0), paramList.get(i)));
            localArrayList2.add(new Pair(paramList.get(0), paramList.get(i)));
            i1 = k;
          }
          else
          {
            localArrayList1.add(new Pair(paramList.get(i), paramList.get(0)));
            localArrayList2.add(new Pair(paramList.get(i), paramList.get(0)));
            i1 = 1;
          }
        }
        else
        {
          int m = 1;
          for (int n = 0;; n = i1)
          {
            i1 = k;
            if (m > 3) {
              break;
            }
            i1 = n;
            if (i != m) {
              if (n != 0)
              {
                localArrayList1.add(new Pair(paramList.get(i), paramList.get(m)));
                localArrayList2.add(new Pair(paramList.get(m), paramList.get(i)));
                i1 = n;
              }
              else
              {
                localArrayList1.add(new Pair(paramList.get(m), paramList.get(i)));
                localArrayList2.add(new Pair(paramList.get(i), paramList.get(m)));
                i1 = 1;
              }
            }
            m += 1;
          }
        }
        i += 1;
      }
      this.borderLines = new ArrayList((Collection)localArrayList2);
      i = 1;
      for (;;)
      {
        paramList = localArrayList1;
        if (i > 2) {
          break;
        }
        f2 = ((PointF)((Pair)localArrayList1.get(0)).getFirst()).x;
        f3 = ((PointF)((Pair)localArrayList1.get(0)).getSecond()).x;
        f1 = 3;
        f2 = (f2 - f3) / f1;
        f3 = i;
        float f4 = ((PointF)((Pair)localArrayList1.get(0)).getSecond()).x;
        float f5 = (((PointF)((Pair)localArrayList1.get(0)).getFirst()).y - ((PointF)((Pair)localArrayList1.get(0)).getSecond()).y) / f1;
        float f6 = ((PointF)((Pair)localArrayList1.get(0)).getSecond()).y;
        float f7 = (((PointF)((Pair)localArrayList1.get(1)).getFirst()).x - ((PointF)((Pair)localArrayList1.get(1)).getSecond()).x) / f1;
        float f8 = ((PointF)((Pair)localArrayList1.get(1)).getSecond()).x;
        float f9 = (((PointF)((Pair)localArrayList1.get(1)).getFirst()).y - ((PointF)((Pair)localArrayList1.get(1)).getSecond()).y) / f1;
        float f10 = ((PointF)((Pair)localArrayList1.get(1)).getSecond()).y;
        float f11 = (((PointF)((Pair)localArrayList1.get(2)).getFirst()).x - ((PointF)((Pair)localArrayList1.get(2)).getSecond()).x) / f1;
        float f12 = ((PointF)((Pair)localArrayList1.get(2)).getSecond()).x;
        float f13 = (((PointF)((Pair)localArrayList1.get(2)).getFirst()).y - ((PointF)((Pair)localArrayList1.get(2)).getSecond()).y) / f1;
        float f14 = ((PointF)((Pair)localArrayList1.get(2)).getSecond()).y;
        float f15 = (((PointF)((Pair)localArrayList1.get(3)).getFirst()).x - ((PointF)((Pair)localArrayList1.get(3)).getSecond()).x) / f1;
        float f16 = ((PointF)((Pair)localArrayList1.get(3)).getSecond()).x;
        f1 = (((PointF)((Pair)localArrayList1.get(3)).getFirst()).y - ((PointF)((Pair)localArrayList1.get(3)).getSecond()).y) / f1;
        float f17 = ((PointF)((Pair)localArrayList1.get(3)).getSecond()).y;
        localArrayList1.add(new Pair(new PointF(f2 * f3 + f4, f5 * f3 + f6), new PointF(f11 * f3 + f12, f13 * f3 + f14)));
        localArrayList1.add(new Pair(new PointF(f7 * f3 + f8, f9 * f3 + f10), new PointF(f15 * f3 + f16, f1 * f3 + f17)));
        i += 1;
      }
    }
    paramList = null;
    return paramList;
  }
  
  public boolean onTouch(@NotNull View paramView, @NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "ev");
    int i = paramMotionEvent.getAction();
    boolean bool3 = false;
    if (i != 0)
    {
      if ((i == 1) || (i == 3))
      {
        paramView = this.mLongPressListener;
        if (paramView != null) {
          paramView.onLongPressRelease();
        }
      }
    }
    else
    {
      paramView = paramView.getParent();
      if (paramView != null) {
        paramView.requestDisallowInterceptTouchEvent(true);
      }
      if (this.zoomBtnRect.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
      {
        bool1 = true;
        break label100;
      }
    }
    boolean bool1 = false;
    label100:
    paramView = this.mTAVDetector;
    if ((paramView != null) && (paramView.isScaling() == true)) {
      j = 1;
    } else {
      j = 0;
    }
    paramView = this.mTAVDetector;
    if ((paramView != null) && (paramView.isDragging() == true)) {
      k = 1;
    } else {
      k = 0;
    }
    paramView = this.mTAVDetector;
    if ((paramView != null) && (paramView.isRotating() == true)) {
      i = 1;
    } else {
      i = 0;
    }
    paramView = this.mTAVDetector;
    if (paramView != null) {
      paramView.setCenter(this.center, this.maxDis);
    }
    paramView = this.mTAVDetector;
    if ((paramView != null) && (paramView.onTouchEvent(paramMotionEvent, bool1) == true)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (j == 0)
    {
      paramView = this.mTAVDetector;
      if ((paramView != null) && (!paramView.isScaling()))
      {
        j = 1;
        break label256;
      }
    }
    int j = 0;
    label256:
    if (k == 0)
    {
      paramView = this.mTAVDetector;
      if ((paramView != null) && (!paramView.isDragging()))
      {
        k = 1;
        break label286;
      }
    }
    int k = 0;
    label286:
    if (i == 0)
    {
      paramView = this.mTAVDetector;
      if ((paramView != null) && (!paramView.isRotating()))
      {
        i = 1;
        break label313;
      }
    }
    i = 0;
    label313:
    boolean bool2 = bool3;
    if (j != 0)
    {
      bool2 = bool3;
      if (k != 0)
      {
        bool2 = bool3;
        if (i != 0) {
          bool2 = true;
        }
      }
    }
    this.mBlockParentIntercept = bool2;
    paramView = this.mGestureDetector;
    bool2 = bool1;
    if (paramView != null)
    {
      bool2 = bool1;
      if (paramView.onTouchEvent(paramMotionEvent) == true) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public final void setActiveBasePicListener(@NotNull OnActiveBasePicListener paramOnActiveBasePicListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnActiveBasePicListener, "onActiveBasePicListener");
    this.mActiveBasePicListener = paramOnActiveBasePicListener;
  }
  
  public final void setAllowParentInterceptOnEdge(boolean paramBoolean)
  {
    this.mAllowParentInterceptOnEdge = paramBoolean;
  }
  
  public final void setBasePicActive(boolean paramBoolean)
  {
    if (paramBoolean != this.isActive)
    {
      this.isActive = paramBoolean;
      postInvalidate();
    }
  }
  
  public final void setBitmapBound(@Nullable RectF paramRectF)
  {
    this.bitmapBound = paramRectF;
  }
  
  protected final void setBmpZoom(@Nullable Bitmap paramBitmap)
  {
    this.bmpZoom = paramBitmap;
  }
  
  public final void setGestureCallback(@NotNull TAVCutImageView.GestureCallback paramGestureCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramGestureCallback, "gestureCallback");
    this.mGestureCallback = paramGestureCallback;
  }
  
  public final void setImageBitmap(@NotNull Bitmap paramBitmap, @NotNull List<? extends PointF> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap, "bitmap");
    Intrinsics.checkParameterIsNotNull(paramList, "points");
    post((Runnable)new TAVCutImageView.setImageBitmap.1(this, paramList, paramBitmap));
  }
  
  public final void setLongPressListener(@NotNull OnLongPressListener paramOnLongPressListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnLongPressListener, "onLongPressListener");
    this.mLongPressListener = paramOnLongPressListener;
  }
  
  public final void setOnClick(@NotNull View.OnClickListener paramOnClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnClickListener, "listener");
    this.mOnClickListener = paramOnClickListener;
  }
  
  public final void setOnOutsidePhotoTapListener(@Nullable OnOutsidePhotoTapListener paramOnOutsidePhotoTapListener)
  {
    this.mOutsidePhotoTapListener = paramOnOutsidePhotoTapListener;
  }
  
  public final void setOnPhotoTapListener(@Nullable OnPhotoTapListener paramOnPhotoTapListener)
  {
    this.mPhotoTapListener = paramOnPhotoTapListener;
  }
  
  public final void setOnRotationListener(@NotNull OnRotationListener paramOnRotationListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnRotationListener, "onRotationListener");
    this.mOnRotationListener = paramOnRotationListener;
  }
  
  public final void setOnScaleChangeListener(@Nullable OnScaleChangedListener paramOnScaleChangedListener)
  {
    this.mScaleChangeListener = paramOnScaleChangedListener;
  }
  
  public final void setOnSingleFlingListener(@Nullable OnSingleFlingListener paramOnSingleFlingListener)
  {
    this.mSingleFlingListener = paramOnSingleFlingListener;
  }
  
  public final void setOnViewDragListener(@Nullable OnViewDragListener paramOnViewDragListener)
  {
    this.mOnDragListener = paramOnViewDragListener;
  }
  
  public final void setOnViewTapListener(@Nullable OnViewTapListener paramOnViewTapListener)
  {
    this.mViewTapListener = paramOnViewTapListener;
  }
  
  protected final void setZoomBtnRect(@NotNull RectF paramRectF)
  {
    Intrinsics.checkParameterIsNotNull(paramRectF, "<set-?>");
    this.zoomBtnRect = paramRectF;
  }
  
  public final void setZoomResId(int paramInt)
  {
    this.zoomResId = paramInt;
    this.bmpZoom = BitmapFactory.decodeResource(getResources(), this.zoomResId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.view.TAVCutImageView
 * JD-Core Version:    0.7.0.1
 */