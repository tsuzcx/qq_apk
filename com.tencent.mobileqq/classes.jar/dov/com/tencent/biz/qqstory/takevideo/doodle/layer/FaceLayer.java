package dov.com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import anwz;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.paster.PasterParcelData;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;

@TargetApi(11)
public class FaceLayer
  extends BaseLayer
{
  public static final String a;
  public int a;
  public Paint a;
  public Drawable a;
  public TextPaint a;
  public FaceLayer.FaceItem a;
  public FaceLayer.LayerEventListener a;
  public GestureHelper a;
  public List a;
  public Map a;
  public boolean a;
  public Paint b;
  public List b;
  public Paint c;
  public Paint d;
  public Paint e;
  public Paint f;
  public Paint g;
  
  static
  {
    jdField_a_of_type_JavaLangString = FaceLayer.class.getSimpleName();
  }
  
  public FaceLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    e();
  }
  
  private int a(float paramFloat, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = (int)paramFloat;
    if ((paramInt2 == 0) || (paramInt3 == 0)) {}
    float f1;
    do
    {
      return i;
      f1 = paramFloat;
      if (paramFloat - paramInt1 / 2 < paramInt2) {
        f1 = paramInt1 / 2 + paramInt2;
      }
    } while (paramInt1 / 2 + f1 <= paramInt3);
    paramFloat = paramInt3 - paramInt1 / 2;
    return i;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (a(paramMotionEvent.getX(0), paramMotionEvent.getY(0)))
    {
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem);
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem);
    }
  }
  
  private void a(FaceLayer.FaceItem paramFaceItem, Canvas paramCanvas)
  {
    if (paramFaceItem == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.concat(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(paramFaceItem));
    paramFaceItem.a(paramCanvas, true);
    paramCanvas.restore();
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    if (i >= 0)
    {
      FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((localFaceItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper != null) && (localFaceItem.d()) && (!localFaceItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.c())) {}
      while (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(localFaceItem, paramFloat1, paramFloat2, false))
      {
        i -= 1;
        break;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem = localFaceItem;
      return true;
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {
      return true;
    }
    if (paramString1 != null) {
      return paramString1.equals(paramString2);
    }
    return false;
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem.jdField_d_of_type_Boolean = false;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem = null;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a();
    super.k();
    super.d(false);
    n();
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843658);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.DEFAULT);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-65536);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.c = new Paint();
    this.c.setAntiAlias(true);
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setColor(-16711936);
    this.c.setStrokeWidth(2.0F);
    this.i.setStrokeWidth(2.0F);
    this.d = new Paint();
    this.d.setStrokeWidth(1.0F);
    this.d.setColor(-1);
    this.d.setStyle(Paint.Style.STROKE);
    this.d.setPathEffect(new DashPathEffect(new float[] { 8.0F, 6.0F }, 0.0F));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper = new GestureHelper();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(true);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(18.0F);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.b(0.2F);
    this.e = new Paint();
    this.e.setAntiAlias(true);
    this.e.setStyle(Paint.Style.STROKE);
    this.e.setColor(-1);
    this.e.setStrokeWidth(2.0F);
    this.g = new Paint();
    this.g.setAntiAlias(true);
    this.g.setColor(-1);
    this.g.setStyle(Paint.Style.FILL);
    this.f = new Paint();
    this.f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.f.setStyle(Paint.Style.FILL);
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$LayerEventListener != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$LayerEventListener.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem))) {
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem);
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem.c();
    }
  }
  
  public float a(GestureHelper.ZoomItem paramZoomItem)
  {
    if (paramZoomItem != null) {
      return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.b(paramZoomItem);
    }
    return 0.0F;
  }
  
  public Rect a(Rect paramRect)
  {
    paramRect.setEmpty();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem != null)
    {
      int i = (int)(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem.u * this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem.q);
      paramRect.set(0, 0, i, i);
    }
    return paramRect;
  }
  
  public Bundle a()
  {
    Bundle localBundle = super.a();
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localArrayList.add(new PasterParcelData((FaceLayer.FaceItem)this.jdField_a_of_type_JavaUtilList.get(i)));
      i += 1;
    }
    localBundle.putParcelableArrayList("StickerParcelDataList", localArrayList);
    return localBundle;
  }
  
  public FaceLayer.FaceItem a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      return (FaceLayer.FaceItem)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    }
    return null;
  }
  
  public GestureHelper.ZoomItem a(GestureHelper.ZoomItem paramZoomItem, String paramString1, String paramString2, Drawable paramDrawable, FaceLayer.LayerParams paramLayerParams, String paramString3, int paramInt1, boolean paramBoolean, String paramString4, String paramString5, int paramInt2)
  {
    if (paramDrawable == null)
    {
      SLog.e(jdField_a_of_type_JavaLangString, "Face drawable is null.");
      return null;
    }
    if (paramLayerParams == null)
    {
      SLog.e(jdField_a_of_type_JavaLangString, "ItemParams is null.");
      return null;
    }
    FaceLayer.LayerParams localLayerParams = FaceLayer.LayerParams.a(paramZoomItem, paramLayerParams);
    FaceLayer.FaceItem localFaceItem;
    if ((paramZoomItem instanceof FaceLayer.FaceItem))
    {
      localFaceItem = (FaceLayer.FaceItem)paramZoomItem;
      if (localFaceItem.b) {
        this.jdField_b_of_type_JavaUtilList.remove(localFaceItem);
      }
    }
    else
    {
      if (!TextUtils.isEmpty(paramLayerParams.jdField_a_of_type_JavaLangString)) {
        break label247;
      }
      SLog.b(jdField_a_of_type_JavaLangString, "Create Normal FaceItem.");
      paramString1 = new FaceLayer.FaceItem(this, paramDrawable, localLayerParams, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      paramString1.a(paramBoolean);
      if (TextUtils.isEmpty(paramString4)) {
        break label362;
      }
      paramString1.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = new TroopBarPOI("-1", "", paramString4, 0, "", 0, "");
      paramString1.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    label362:
    for (;;)
    {
      paramString1.b = paramBoolean;
      if (!TextUtils.isEmpty(paramString5)) {
        paramString1.jdField_g_of_type_JavaLangString = paramString5;
      }
      paramString1.a(paramZoomItem);
      if (paramString1.b)
      {
        this.jdField_b_of_type_JavaUtilList.add(paramString1);
        return paramString1;
        List localList = (List)this.jdField_a_of_type_JavaUtilMap.get(localFaceItem.jdField_d_of_type_JavaLangString);
        if (localList == null) {
          break;
        }
        localList.remove(localFaceItem.e);
        break;
        label247:
        SLog.b(jdField_a_of_type_JavaLangString, "Create FaceAndTextItem with text:" + localLayerParams.jdField_a_of_type_JavaLangString);
        paramString1 = new FaceLayer.FaceAndTextItem(this, paramDrawable, localLayerParams, paramString1, paramString2, paramString3, paramInt1, paramInt2);
        continue;
      }
      paramDrawable = this.jdField_a_of_type_JavaUtilMap;
      paramString2 = (List)paramDrawable.get(paramString1.jdField_d_of_type_JavaLangString);
      paramZoomItem = paramString2;
      if (paramString2 == null)
      {
        paramZoomItem = new ArrayList();
        paramDrawable.put(paramString1.jdField_d_of_type_JavaLangString, paramZoomItem);
      }
      paramZoomItem.add(paramString1.e);
      return paramString1;
    }
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)localIterator.next();
        if ((localFaceItem.c()) || (localFaceItem.d()))
        {
          TrackerStickerParam localTrackerStickerParam = new TrackerStickerParam(localFaceItem.jdField_a_of_type_AndroidGraphicsPointF.x, localFaceItem.jdField_a_of_type_AndroidGraphicsPointF.y, localFaceItem.q, localFaceItem.r, localFaceItem.s, localFaceItem.t, localFaceItem.u, localFaceItem.v, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_Int, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.b, localFaceItem.f, localFaceItem.jdField_a_of_type_JavaUtilMap);
          localTrackerStickerParam.a(localFaceItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.a());
          localArrayList.add(localTrackerStickerParam);
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem = null;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a();
    SLog.b(jdField_a_of_type_JavaLangString, "clear over.");
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)localIterator.next();
      if (localFaceItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper != null) {
        localFaceItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.a(paramInt);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      SLog.b(jdField_a_of_type_JavaLangString, "mFaceItems = null or size<=0");
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)localIterator.next();
        paramInt1 = (int)(localFaceItem.u * localFaceItem.q);
        paramInt2 = (int)(localFaceItem.v * localFaceItem.q);
        localFaceItem.jdField_a_of_type_AndroidGraphicsPointF.x = a(localFaceItem.jdField_a_of_type_AndroidGraphicsPointF.x, paramInt1, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.right);
        localFaceItem.jdField_a_of_type_AndroidGraphicsPointF.y = a(localFaceItem.jdField_a_of_type_AndroidGraphicsPointF.y, paramInt2, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
      }
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      a((FaceLayer.FaceItem)localIterator.next(), paramCanvas);
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)localIterator.next();
      if ((!localFaceItem.c()) && (!localFaceItem.d()))
      {
        paramCanvas.save();
        paramCanvas.concat(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(localFaceItem));
        localFaceItem.a(paramCanvas, false);
        paramCanvas.restore();
      }
    }
    paramCanvas.restore();
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    super.a(paramBundle);
    a(paramBundle.getParcelableArrayList("StickerParcelDataList"), paramBundle.getBoolean("edit_type_photo"), null);
  }
  
  public void a(FaceLayer.FaceItem paramFaceItem)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()) && (this.jdField_a_of_type_JavaUtilList.remove(paramFaceItem)))
    {
      if (!paramFaceItem.b) {
        break label69;
      }
      DoodleLayout.a("delete_poi");
      VideoEditReport.a("0X80076D2");
      VideoEditReport.b("0X80075E7");
      this.jdField_b_of_type_JavaUtilList.remove(paramFaceItem);
    }
    label69:
    List localList;
    do
    {
      do
      {
        return;
        DoodleLayout.a("delete_oneface");
        VideoEditReport.a("0X80076CB");
        VideoEditReport.b("0X80075E0");
        localList = (List)this.jdField_a_of_type_JavaUtilMap.get(paramFaceItem.jdField_d_of_type_JavaLangString);
      } while (localList == null);
      localList.remove(paramFaceItem.e);
    } while (!localList.isEmpty());
    this.jdField_a_of_type_JavaUtilMap.remove(paramFaceItem.jdField_d_of_type_JavaLangString);
  }
  
  public void a(FaceLayer.FaceItem paramFaceItem, TroopBarPOI paramTroopBarPOI)
  {
    if (paramFaceItem != null)
    {
      paramFaceItem.a(paramTroopBarPOI);
      paramFaceItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a);
      k();
    }
  }
  
  public void a(FaceLayer.LayerEventListener paramLayerEventListener)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$LayerEventListener = paramLayerEventListener;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)localIterator.next();
        if ((a(localFaceItem.jdField_d_of_type_JavaLangString, paramString1)) && (a(localFaceItem.e, paramString2))) {
          a(localFaceItem);
        }
      }
    }
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean, JSONArray paramJSONArray)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      ThreadManager.post(new anwz(this, paramArrayList, paramJSONArray, paramBoolean), 8, null, false);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty());
  }
  
  public boolean a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((FaceLayer.FaceItem)localIterator.next()).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.b(paramLong)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getY();
    int j = Math.abs(i - this.jdField_a_of_type_Int);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(paramMotionEvent, false);
      return true;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Boolean = false;
      a(paramMotionEvent);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem);
      }
      d();
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem != null)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem.b();
        continue;
        h();
        continue;
        if (j > 5)
        {
          this.jdField_a_of_type_Boolean = true;
          h();
          continue;
          h();
          if (!this.jdField_a_of_type_Boolean) {
            g();
          }
          b(paramMotionEvent);
        }
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2, Drawable paramDrawable, FaceLayer.LayerParams paramLayerParams, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, SegmentKeeper paramSegmentKeeper)
  {
    if (paramDrawable == null)
    {
      SLog.e(jdField_a_of_type_JavaLangString, "Face drawable is null.");
      return false;
    }
    if (paramLayerParams == null)
    {
      SLog.e(jdField_a_of_type_JavaLangString, "ItemParams is null.");
      return false;
    }
    if (b())
    {
      SLog.e(jdField_a_of_type_JavaLangString, "has max face count. add face failed.");
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$LayerEventListener != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$LayerEventListener.a(40);
      }
      return false;
    }
    if ((paramInt1 == 1) || (paramInt1 == 3)) {
      paramDrawable.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    }
    SLog.a(jdField_a_of_type_JavaLangString, "addFace before, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, paramLayerParams);
    FaceLayer.LayerParams localLayerParams = FaceLayer.LayerParams.a(paramLayerParams);
    int i = (int)(localLayerParams.jdField_a_of_type_Int * localLayerParams.jdField_a_of_type_Float);
    int j = (int)(localLayerParams.b * localLayerParams.jdField_a_of_type_Float);
    float f1 = localLayerParams.jdField_a_of_type_AndroidGraphicsPointF.x;
    float f2 = localLayerParams.jdField_a_of_type_AndroidGraphicsPointF.y;
    localLayerParams.jdField_a_of_type_AndroidGraphicsPointF.x = a(f1, i, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.right);
    localLayerParams.jdField_a_of_type_AndroidGraphicsPointF.y = a(f2, j, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    SLog.b(jdField_a_of_type_JavaLangString, "addFace after drawRect.left=" + this.jdField_a_of_type_AndroidGraphicsRect.left + " drawRect.right" + this.jdField_a_of_type_AndroidGraphicsRect.right + " drawRect.top=" + this.jdField_a_of_type_AndroidGraphicsRect.bottom + " drawRect.left" + this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    SLog.a(jdField_a_of_type_JavaLangString, "addFace after, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, paramLayerParams);
    if (TextUtils.isEmpty(localLayerParams.jdField_a_of_type_JavaLangString))
    {
      SLog.b(jdField_a_of_type_JavaLangString, "Create Normal FaceItem.");
      paramString1 = new FaceLayer.FaceItem(this, paramDrawable, localLayerParams, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      paramString1.a(paramBoolean);
      paramString1.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper(paramSegmentKeeper);
      if (paramInt2 == 0) {
        SegmentKeeper.b(-1L * System.currentTimeMillis());
      }
      this.jdField_a_of_type_JavaUtilList.add(paramString1);
      super.k();
      if (!paramString1.b) {
        break label481;
      }
      this.jdField_b_of_type_JavaUtilList.add(paramString1);
    }
    for (;;)
    {
      return true;
      SLog.b(jdField_a_of_type_JavaLangString, "Create FaceAndTextItem with text:" + localLayerParams.jdField_a_of_type_JavaLangString);
      paramString1 = new FaceLayer.FaceAndTextItem(this, paramDrawable, localLayerParams, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      ((FaceLayer.FaceAndTextItem)paramString1).a();
      break;
      label481:
      paramLayerParams = this.jdField_a_of_type_JavaUtilMap;
      paramDrawable = (List)paramLayerParams.get(paramString1.jdField_d_of_type_JavaLangString);
      paramString2 = paramDrawable;
      if (paramDrawable == null)
      {
        paramString2 = new ArrayList();
        paramLayerParams.put(paramString1.jdField_d_of_type_JavaLangString, paramString2);
      }
      paramString2.add(paramString1.e);
    }
  }
  
  public boolean a(String paramString1, String paramString2, Drawable paramDrawable, FaceLayer.LayerParams paramLayerParams, String paramString3, boolean paramBoolean, String paramString4, int paramInt1, String paramString5, int paramInt2, int paramInt3)
  {
    if (paramDrawable == null)
    {
      SLog.e(jdField_a_of_type_JavaLangString, "Face drawable is null.");
      return false;
    }
    if (paramLayerParams == null)
    {
      SLog.e(jdField_a_of_type_JavaLangString, "ItemParams is null.");
      return false;
    }
    if (b())
    {
      SLog.e(jdField_a_of_type_JavaLangString, "has max face count. add face failed.");
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$LayerEventListener != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$LayerEventListener.a(40);
      }
      return false;
    }
    if ((paramInt1 == 1) || (paramInt1 == 3)) {
      paramDrawable.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
    }
    SLog.a(jdField_a_of_type_JavaLangString, "addFace before, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, paramLayerParams);
    FaceLayer.LayerParams localLayerParams = FaceLayer.LayerParams.a(paramLayerParams);
    int i = (int)(localLayerParams.jdField_a_of_type_Int * localLayerParams.jdField_a_of_type_Float);
    int j = (int)(localLayerParams.b * localLayerParams.jdField_a_of_type_Float);
    float f1 = localLayerParams.jdField_a_of_type_AndroidGraphicsPointF.x;
    float f2 = localLayerParams.jdField_a_of_type_AndroidGraphicsPointF.y;
    localLayerParams.jdField_a_of_type_AndroidGraphicsPointF.x = a(f1, i, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.right);
    localLayerParams.jdField_a_of_type_AndroidGraphicsPointF.y = a(f2, j, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    SLog.b(jdField_a_of_type_JavaLangString, "addFace after drawRect.left=" + this.jdField_a_of_type_AndroidGraphicsRect.left + " drawRect.right" + this.jdField_a_of_type_AndroidGraphicsRect.right + " drawRect.top=" + this.jdField_a_of_type_AndroidGraphicsRect.bottom + " drawRect.left" + this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    SLog.a(jdField_a_of_type_JavaLangString, "addFace after, category : %s , name : %s , LayerParams : %s", paramString1, paramString2, paramLayerParams);
    if (TextUtils.isEmpty(localLayerParams.jdField_a_of_type_JavaLangString))
    {
      SLog.b(jdField_a_of_type_JavaLangString, "Create Normal FaceItem.");
      paramString1 = new FaceLayer.FaceItem(this, paramDrawable, localLayerParams, paramString1, paramString2, paramString3, paramInt1, paramInt3);
      paramString1.jdField_g_of_type_JavaLangString = paramString5;
      paramString1.a(paramBoolean);
      if (TextUtils.isEmpty(paramString4)) {
        break label604;
      }
      if ((paramString1 instanceof FaceLayer.FaceAndTextItem)) {
        paramString1.a(new TroopBarPOI("-1", "", paramString4, 0, "", 0, ""));
      }
    }
    label604:
    for (;;)
    {
      paramString1.jdField_g_of_type_Int = paramInt2;
      this.jdField_a_of_type_JavaUtilList.add(paramString1);
      super.k();
      if (paramString1.b) {
        this.jdField_b_of_type_JavaUtilList.add(paramString1);
      }
      for (;;)
      {
        return true;
        paramString1.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = new TroopBarPOI("-1", "", paramString4, 0, "", 0, "");
        paramString1.jdField_a_of_type_Long = System.currentTimeMillis();
        break;
        SLog.b(jdField_a_of_type_JavaLangString, "Create FaceAndTextItem with text:" + localLayerParams.jdField_a_of_type_JavaLangString);
        paramString1 = new FaceLayer.FaceAndTextItem(this, paramDrawable, localLayerParams, paramString1, paramString2, paramString3, paramInt1);
        ((FaceLayer.FaceAndTextItem)paramString1).a();
        break;
        paramLayerParams = this.jdField_a_of_type_JavaUtilMap;
        paramDrawable = (List)paramLayerParams.get(paramString1.jdField_d_of_type_JavaLangString);
        paramString2 = paramDrawable;
        if (paramDrawable == null)
        {
          paramString2 = new ArrayList();
          paramLayerParams.put(paramString1.jdField_d_of_type_JavaLangString, paramString2);
        }
        paramString2.add(paramString1.e);
      }
    }
  }
  
  public int[] a()
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((FaceLayer.FaceItem)localIterator.next() instanceof FaceLayer.FaceAndTextItem)) {
        arrayOfInt[1] += 1;
      } else {
        arrayOfInt[0] += 1;
      }
    }
    return arrayOfInt;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaUtilList.size())
    {
      SLog.b(jdField_a_of_type_JavaLangString, "FaceLayer, DoodleCount:" + i);
      return i;
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      a((FaceLayer.FaceItem)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1));
    }
  }
  
  public void b(Canvas paramCanvas)
  {
    a(paramCanvas, this.jdField_a_of_type_Float);
  }
  
  protected boolean b()
  {
    return b() == 40;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    if (i >= 0)
    {
      FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((localFaceItem.d()) && (!localFaceItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.c())) {}
      while (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(localFaceItem, f1, f2, false))
      {
        i -= 1;
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "accept inside x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY());
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "accept outside x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY());
    }
    return false;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem != null) && (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem.a()) && (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem.b())) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$FaceItem.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer
 * JD-Core Version:    0.7.0.1
 */