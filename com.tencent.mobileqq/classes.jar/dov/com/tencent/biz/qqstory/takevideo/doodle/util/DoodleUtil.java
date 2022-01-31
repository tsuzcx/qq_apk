package dov.com.tencent.biz.qqstory.takevideo.doodle.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.richmedia.capture.data.DynamicStickerData;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.paster.AnimationDecodeWrapper;
import dov.com.qq.im.capture.paster.ApngDecodeWrapper;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.AtLayer.LayerParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.LayerParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.model.SelectedItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage.Item;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage.Item.ItemParams;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DoodleUtil
{
  private static int a(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0) || (StringUtil.a(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleUtil", 2, "getLineHeight quit:" + paramInt1 + " " + paramInt2 + " " + paramString);
      }
      return 1;
    }
    Object localObject = new TextPaint();
    ((TextPaint)localObject).setTextSize(paramInt1);
    paramString = new StaticLayout(paramString, (TextPaint)localObject, paramInt2, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
    localObject = new Rect();
    paramString.getLineBounds(0, (Rect)localObject);
    return ((Rect)localObject).height();
  }
  
  public static AtLayer.LayerParams a(Context paramContext, @NonNull Drawable paramDrawable, @NonNull String paramString, int paramInt)
  {
    int i = AIOUtils.a(47.0F, paramContext.getResources());
    int k = AIOUtils.a(27.0F, paramContext.getResources());
    int m = AIOUtils.a(14.0F, paramContext.getResources());
    Paint localPaint = new Paint();
    localPaint.setTextSize(m);
    int j = (int)localPaint.measureText(paramString) + (AIOUtils.a(10.0F, paramContext.getResources()) + paramDrawable.getBounds().width() + AIOUtils.a(6.0F, paramContext.getResources())) + AIOUtils.a(8.0F, paramContext.getResources());
    if (j < i) {}
    for (;;)
    {
      paramContext = new AtLayer.LayerParams(i, k, -1, m, paramInt);
      SLog.b("DoodleUtil", "LayerParams:" + paramContext.toString());
      return paramContext;
      i = j;
    }
  }
  
  public static FaceLayer.LayerParams a(SelectedItem paramSelectedItem, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return new FaceLayer.LayerParams(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, paramSelectedItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), paramSelectedItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
  }
  
  public static FaceLayer.LayerParams a(LocationFacePackage.Item paramItem, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    if (!a(paramItem)) {
      return null;
    }
    SLog.b("DoodleUtil", "item:" + paramItem.toString());
    int i = 0;
    paramInt2 = 0;
    if (paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      i = paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().width();
      paramInt2 = paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().height();
    }
    float f2 = paramItem.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.jdField_c_of_type_Int;
    float f1 = paramItem.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.d;
    float f3 = paramItem.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.e;
    f2 = f2 * (paramInt1 / f3) / i;
    paramInt1 = (int)(paramItem.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.jdField_b_of_type_Int / f1 * paramInt2);
    paramItem = new FaceLayer.LayerParams(paramFloat1, paramFloat2, f2, 0.0F, 0.0F, 0.0F, i, paramInt2 + a(paramItem.jdField_b_of_type_JavaLangString, paramInt1, i) * 2 + 32, paramItem.jdField_b_of_type_JavaLangString, Color.parseColor(paramItem.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.jdField_a_of_type_JavaLangString), paramInt1);
    SLog.b("DoodleUtil", "LayerParams:" + paramItem.toString());
    return paramItem;
  }
  
  public static FaceLayer.LayerParams a(LocationFacePackage.Item paramItem, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (!a(paramItem)) {
      return null;
    }
    SLog.b("DoodleUtil", "item:" + paramItem.toString());
    int i = 0;
    paramInt2 = 0;
    if (paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      i = paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().width();
      paramInt2 = paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().height();
    }
    float f = paramItem.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.jdField_c_of_type_Int;
    f = paramItem.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.d;
    paramFloat3 = paramInt1 * paramFloat3 / i;
    paramInt1 = (int)(paramItem.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.jdField_b_of_type_Int / f * paramInt2);
    paramItem = new FaceLayer.LayerParams(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, i, paramInt2 + a(paramItem.jdField_b_of_type_JavaLangString, paramInt1, i) * 2 + 32, paramItem.jdField_b_of_type_JavaLangString, Color.parseColor(paramItem.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.jdField_a_of_type_JavaLangString), paramInt1);
    SLog.b("DoodleUtil", "LayerParams:" + paramItem.toString());
    return paramItem;
  }
  
  public static String a(ArrayList paramArrayList)
  {
    if (paramArrayList.isEmpty()) {
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    try
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject = (DynamicStickerData)paramArrayList.next();
        if (localObject != null)
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("centerP_x", ((DynamicStickerData)localObject).jdField_a_of_type_AndroidGraphicsPointF.x);
          localJSONObject.put("centerP_y", ((DynamicStickerData)localObject).jdField_a_of_type_AndroidGraphicsPointF.y);
          localJSONObject.put("scale", ((DynamicStickerData)localObject).jdField_a_of_type_Float);
          localJSONObject.put("rotate", ((DynamicStickerData)localObject).jdField_b_of_type_Float);
          localJSONObject.put("translateX", ((DynamicStickerData)localObject).jdField_c_of_type_Float);
          localJSONObject.put("translateY", ((DynamicStickerData)localObject).d);
          localJSONObject.put("width", ((DynamicStickerData)localObject).e);
          localJSONObject.put("height", ((DynamicStickerData)localObject).f);
          localJSONObject.put("path", ((DynamicStickerData)localObject).jdField_a_of_type_JavaLangString);
          localJSONObject.put("type", ((DynamicStickerData)localObject).jdField_a_of_type_Int);
          localJSONObject.put("data", ((DynamicStickerData)localObject).jdField_b_of_type_JavaLangString);
          localJSONObject.put("layerWidth", ((DynamicStickerData)localObject).jdField_b_of_type_Int);
          localJSONObject.put("layerHeight", ((DynamicStickerData)localObject).jdField_c_of_type_Int);
          localJSONObject.put("motionTrack", TrackerStickerParam.a(((DynamicStickerData)localObject).jdField_a_of_type_JavaUtilMap));
          localObject = ((DynamicStickerData)localObject).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.a();
          if (localObject != null) {
            localJSONObject.put("segmentdata", localObject);
          }
          localJSONArray.put(localJSONObject);
        }
      }
      paramArrayList = new JSONObject();
    }
    catch (JSONException paramArrayList)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleUtil", 2, "e= " + paramArrayList);
      }
      return null;
    }
    paramArrayList.put("list", localJSONArray);
    if (QLog.isColorLevel()) {
      QLog.d("DoodleUtil", 2, "DynamicStickersToJson result= " + paramArrayList.toString());
    }
    paramArrayList = paramArrayList.toString();
    return paramArrayList;
  }
  
  public static ArrayList a(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      ArrayList localArrayList;
      DynamicStickerData localDynamicStickerData;
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        localArrayList = new ArrayList();
        paramString = new JSONObject(paramString).optJSONArray("list");
        if (paramString == null) {
          break;
        }
        if (i >= paramString.length()) {
          break label400;
        }
        JSONObject localJSONObject = paramString.getJSONObject(i);
        if (localJSONObject == null) {
          break label434;
        }
        localDynamicStickerData = new DynamicStickerData();
        localDynamicStickerData.jdField_a_of_type_AndroidGraphicsPointF = new PointF((float)localJSONObject.optDouble("centerP_x"), (float)localJSONObject.optDouble("centerP_y"));
        localDynamicStickerData.jdField_a_of_type_Float = ((float)localJSONObject.optDouble("scale"));
        localDynamicStickerData.jdField_b_of_type_Float = ((float)localJSONObject.optDouble("rotate"));
        localDynamicStickerData.jdField_c_of_type_Float = ((float)localJSONObject.optDouble("translateX"));
        localDynamicStickerData.d = ((float)localJSONObject.optDouble("translateY"));
        localDynamicStickerData.e = ((float)localJSONObject.optDouble("width"));
        localDynamicStickerData.f = ((float)localJSONObject.optDouble("height"));
        localDynamicStickerData.jdField_b_of_type_Int = localJSONObject.optInt("layerWidth");
        localDynamicStickerData.jdField_c_of_type_Int = localJSONObject.optInt("layerHeight");
        localDynamicStickerData.jdField_a_of_type_JavaLangString = localJSONObject.optString("path");
        localDynamicStickerData.jdField_a_of_type_Int = localJSONObject.optInt("type", 0);
        localDynamicStickerData.jdField_b_of_type_JavaLangString = localJSONObject.optString("data", "");
        if (1 == localDynamicStickerData.jdField_a_of_type_Int)
        {
          localDynamicStickerData.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataGifDecoder = new ApngDecodeWrapper(localDynamicStickerData.jdField_a_of_type_JavaLangString);
          localDynamicStickerData.jdField_a_of_type_JavaUtilMap = TrackerStickerParam.a(localJSONObject.getJSONArray("motionTrack"));
          if (localJSONObject.has("segmentdata")) {
            localDynamicStickerData.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.a(localJSONObject.getJSONObject("segmentdata"));
          }
          localArrayList.add(localDynamicStickerData);
          break label434;
        }
        if (3 != localDynamicStickerData.jdField_a_of_type_Int) {
          break label380;
        }
        localDynamicStickerData.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataGifDecoder = new AnimationDecodeWrapper(localDynamicStickerData.jdField_a_of_type_Int, localDynamicStickerData.jdField_b_of_type_JavaLangString);
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception paramString) {}
      QLog.d("DoodleUtil", 2, "e= " + paramString);
      return null;
      label380:
      localDynamicStickerData.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataGifDecoder = new ApngDecodeWrapper(localDynamicStickerData.jdField_a_of_type_JavaLangString);
      continue;
      label400:
      if (QLog.isColorLevel()) {
        QLog.d("DoodleUtil", 2, "getDynamicStickersFromJson= " + localArrayList);
      }
      return localArrayList;
      label434:
      i += 1;
    }
  }
  
  public static void a(Bitmap paramBitmap, int paramInt)
  {
    int[] arrayOfInt = new int[paramInt * paramInt];
    int i3 = paramBitmap.getHeight() / paramInt;
    int i4 = paramBitmap.getWidth() / paramInt;
    int i5 = paramBitmap.getHeight() % paramInt;
    int i6 = paramBitmap.getWidth() % paramInt;
    int i = 0;
    int j;
    int i7;
    int i8;
    int k;
    int m;
    int n;
    int i1;
    int i2;
    while (i < i3)
    {
      j = 0;
      while (j < i4)
      {
        i7 = i * paramInt;
        i8 = j * paramInt;
        paramBitmap.getPixels(arrayOfInt, 0, paramInt, i8, i7, paramInt, paramInt);
        k = 0;
        m = 0;
        n = 0;
        i1 = 0;
        while (k < paramInt)
        {
          i2 = 0;
          while (i2 < paramInt)
          {
            int i9 = arrayOfInt[(k * paramInt + i2)];
            i1 += (i9 >> 16 & 0xFF);
            n += (i9 >> 8 & 0xFF);
            m += (i9 & 0xFF);
            i2 += 1;
          }
          k += 1;
        }
        i1 = i1 / paramInt / paramInt;
        n = n / paramInt / paramInt;
        i2 = m / paramInt / paramInt;
        k = 0;
        while (k < paramInt)
        {
          m = 0;
          while (m < paramInt)
          {
            arrayOfInt[(k * paramInt + m)] = (0xFF000000 | i1 << 16 | n << 8 | i2);
            m += 1;
          }
          k += 1;
        }
        paramBitmap.setPixels(arrayOfInt, 0, paramInt, i8, i7, paramInt, paramInt);
        j += 1;
      }
      i += 1;
    }
    if (i6 > 0)
    {
      i = 0;
      while (i < i3)
      {
        i2 = i * paramInt;
        i7 = i4 * paramInt;
        n = 0;
        m = 0;
        k = 0;
        j = 0;
        while (j < paramInt)
        {
          i1 = 0;
          while (i1 < i6)
          {
            i8 = paramBitmap.getPixel(i7 + i1, i2 + j);
            n += (i8 >> 16 & 0xFF);
            m += (i8 >> 8 & 0xFF);
            k += (i8 & 0xFF);
            i1 += 1;
          }
          j += 1;
        }
        n = n / paramInt / i6;
        m = m / paramInt / i6;
        i1 = k / paramInt / i6;
        j = 0;
        while (j < paramInt)
        {
          k = 0;
          while (k < i6)
          {
            paramBitmap.setPixel(i7 + k, i2 + j, 0xFF000000 | n << 16 | m << 8 | i1);
            k += 1;
          }
          j += 1;
        }
        i += 1;
      }
    }
    if (i5 > 0)
    {
      i = 0;
      while (i < i4)
      {
        i2 = i3 * paramInt;
        i6 = i * paramInt;
        n = 0;
        m = 0;
        k = 0;
        j = 0;
        while (j < i5)
        {
          i1 = 0;
          while (i1 < paramInt)
          {
            i7 = paramBitmap.getPixel(i6 + i1, i2 + j);
            n += (i7 >> 16 & 0xFF);
            m += (i7 >> 8 & 0xFF);
            k += (i7 & 0xFF);
            i1 += 1;
          }
          j += 1;
        }
        n = n / paramInt / i5;
        m = m / paramInt / i5;
        i1 = k / paramInt / i5;
        j = 0;
        while (j < i5)
        {
          k = 0;
          while (k < paramInt)
          {
            paramBitmap.setPixel(i6 + k, i2 + j, 0xFF000000 | n << 16 | m << 8 | i1);
            k += 1;
          }
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  public static boolean a(LocationFacePackage.Item paramItem)
  {
    if (paramItem == null)
    {
      SLog.e("DoodleUtil", "item is null.");
      return false;
    }
    if (TextUtils.isEmpty(paramItem.e))
    {
      SLog.e("DoodleUtil", "item layoutJson is empty,can't parse.");
      return false;
    }
    if (!paramItem.a())
    {
      SLog.e("DoodleUtil", "parseJson error:" + paramItem.e);
      return false;
    }
    if (paramItem.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.jdField_b_of_type_Int < 0)
    {
      SLog.e("DoodleUtil", "item textSize < 0. textSize:" + paramItem.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.jdField_b_of_type_Int);
      return false;
    }
    if ((paramItem.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.jdField_c_of_type_Int <= 0) || (paramItem.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.d <= 0))
    {
      SLog.e("DoodleUtil", "item pictureWidth <= 0 or item pictureHeight <= 0. pictureWidth:" + paramItem.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.jdField_c_of_type_Int + ",pictureHeight:" + paramItem.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.d);
      return false;
    }
    if ((paramItem.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.e <= 0) || (paramItem.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.f <= 0))
    {
      SLog.e("DoodleUtil", "item standardWidth <= 0 or item standardHeight <= 0. standardWidth:" + paramItem.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.e + ",standardHeight:" + paramItem.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.f);
      return false;
    }
    try
    {
      Color.parseColor(paramItem.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.jdField_a_of_type_JavaLangString);
      return true;
    }
    catch (Exception localException)
    {
      SLog.e("DoodleUtil", "item color is illegal:" + paramItem.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage$Item$ItemParams.jdField_a_of_type_JavaLangString);
      localException.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.util.DoodleUtil
 * JD-Core Version:    0.7.0.1
 */