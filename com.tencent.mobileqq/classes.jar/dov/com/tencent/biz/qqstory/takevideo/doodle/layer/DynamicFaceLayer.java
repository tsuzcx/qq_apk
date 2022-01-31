package dov.com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import anwy;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.DynamicStickerData;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.paster.PasterParcelData;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InformationFaceConstant;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.InfoStickerDrawable;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DoodleUtil;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class DynamicFaceLayer
  extends FaceLayer
{
  public DynamicFaceLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
  }
  
  /* Error */
  public static Drawable a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: invokestatic 18	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnull +74 -> 86
    //   15: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   18: ifeq +43 -> 61
    //   21: ldc 26
    //   23: iconst_2
    //   24: new 28	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   31: ldc 33
    //   33: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_1
    //   37: invokevirtual 43	android/graphics/Bitmap:getWidth	()I
    //   40: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: ldc 48
    //   45: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokevirtual 51	android/graphics/Bitmap:getHeight	()I
    //   52: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 59	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: new 61	android/graphics/drawable/BitmapDrawable
    //   64: dup
    //   65: aload_1
    //   66: invokespecial 64	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   69: astore_0
    //   70: aload_0
    //   71: iconst_0
    //   72: iconst_0
    //   73: aload_1
    //   74: invokevirtual 43	android/graphics/Bitmap:getWidth	()I
    //   77: aload_1
    //   78: invokevirtual 51	android/graphics/Bitmap:getHeight	()I
    //   81: invokevirtual 70	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   84: aload_0
    //   85: areturn
    //   86: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +28 -> 117
    //   92: ldc 26
    //   94: iconst_2
    //   95: new 28	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   102: ldc 72
    //   104: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_0
    //   108: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 59	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: aconst_null
    //   118: astore_0
    //   119: goto -35 -> 84
    //   122: astore_1
    //   123: aconst_null
    //   124: astore_0
    //   125: aload_1
    //   126: invokevirtual 75	java/lang/OutOfMemoryError:printStackTrace	()V
    //   129: goto -45 -> 84
    //   132: astore_1
    //   133: goto -8 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramString	String
    //   10	68	1	localBitmap	android.graphics.Bitmap
    //   122	4	1	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   132	1	1	localOutOfMemoryError2	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   6	11	122	java/lang/OutOfMemoryError
    //   15	61	122	java/lang/OutOfMemoryError
    //   61	70	122	java/lang/OutOfMemoryError
    //   86	117	122	java/lang/OutOfMemoryError
    //   70	84	132	java/lang/OutOfMemoryError
  }
  
  public static String a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) && (!paramString.endsWith(".apng"))) {}
    do
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.d("DynamicFaceLayer", 2, "getDynamicStaticPicPath|path= " + paramString);
      }
      int i = paramString.length();
      paramString = paramString.substring(0, i - 5) + ".bpng";
      if (QLog.isColorLevel()) {
        QLog.d("DynamicFaceLayer", 2, "newPath= " + paramString);
      }
      if (new File(paramString).exists()) {
        return paramString;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DynamicFaceLayer", 2, "file not exist");
    return null;
  }
  
  public String a()
  {
    return "DynamicFaceLayer";
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    int j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_Int;
    int k = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_b_of_type_Int;
    int i;
    if (paramInt1 > paramInt2)
    {
      i = paramInt2;
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      float f1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_Int * 1.0F / this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_b_of_type_Int;
      float f2 = i * 1.0F / paramInt2;
      if (f2 != f1) {
        if (f1 > f2)
        {
          j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_Int;
          i = Math.round(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_Int / f2);
          paramInt2 = (i - this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_b_of_type_Int) / 2;
          paramInt1 = 0;
        }
      }
      for (;;)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("layerParams=").append(j).append("*").append(i).append(",heightOffset=").append(paramInt2).append(",widthOffset=").append(paramInt1);
          QLog.d("DynamicFaceLayer", 2, ((StringBuilder)localObject).toString());
        }
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b())
        {
          localObject = new ArrayList();
          Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)localIterator.next();
              DynamicStickerData localDynamicStickerData = new DynamicStickerData();
              localDynamicStickerData.jdField_a_of_type_AndroidGraphicsPointF = localFaceItem.jdField_a_of_type_AndroidGraphicsPointF;
              localDynamicStickerData.jdField_a_of_type_Float = localFaceItem.q;
              localDynamicStickerData.jdField_b_of_type_Float = localFaceItem.r;
              localDynamicStickerData.jdField_c_of_type_Float = (localFaceItem.s + paramInt1);
              localDynamicStickerData.jdField_d_of_type_Float = (localFaceItem.t + paramInt2);
              localDynamicStickerData.f = localFaceItem.v;
              localDynamicStickerData.jdField_e_of_type_Float = localFaceItem.u;
              localDynamicStickerData.jdField_a_of_type_JavaLangString = localFaceItem.jdField_f_of_type_JavaLangString;
              localDynamicStickerData.jdField_a_of_type_Int = localFaceItem.h;
              localDynamicStickerData.jdField_b_of_type_JavaLangString = localFaceItem.jdField_g_of_type_JavaLangString;
              localDynamicStickerData.jdField_b_of_type_Int = j;
              localDynamicStickerData.jdField_c_of_type_Int = i;
              localDynamicStickerData.jdField_a_of_type_JavaUtilMap = localFaceItem.jdField_a_of_type_JavaUtilMap;
              localDynamicStickerData.a(localFaceItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.a());
              localDynamicStickerData.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.b(false);
              ((ArrayList)localObject).add(localDynamicStickerData);
              continue;
              j = Math.round(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_b_of_type_Int * f2);
              i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_b_of_type_Int;
              paramInt1 = (j - this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_Int) / 2;
              paramInt2 = 0;
              break;
            }
          }
          if (((ArrayList)localObject).size() > 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("DynamicFaceLayer", 2, "generateDynamicStickers|size= " + ((ArrayList)localObject).size());
            }
            return DoodleUtil.a((ArrayList)localObject);
          }
        }
        return null;
        paramInt2 = 0;
        i = k;
        paramInt1 = 0;
      }
      i = paramInt1;
    }
  }
  
  public void a()
  {
    super.a();
    this.b.clear();
  }
  
  public void a(Canvas paramCanvas, float paramFloat) {}
  
  public void a(ArrayList paramArrayList, boolean paramBoolean, JSONArray paramJSONArray)
  {
    int i = 0;
    PasterParcelData localPasterParcelData;
    InfoStickerDrawable localInfoStickerDrawable;
    if (i < paramArrayList.size())
    {
      localPasterParcelData = (PasterParcelData)paramArrayList.get(i);
      if ((localPasterParcelData.jdField_d_of_type_Int == 3) && (!TextUtils.isEmpty(localPasterParcelData.jdField_e_of_type_JavaLangString)))
      {
        localInfoStickerDrawable = InformationFaceConstant.a(BaseApplicationImpl.getContext(), localPasterParcelData.jdField_e_of_type_JavaLangString);
        if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b())) {
          break label416;
        }
        paramJSONArray = localInfoStickerDrawable;
      }
    }
    for (;;)
    {
      label82:
      int j = (int)localPasterParcelData.jdField_a_of_type_AndroidGraphicsRectF.left;
      int k = (int)localPasterParcelData.jdField_a_of_type_AndroidGraphicsRectF.right;
      int m = (int)localPasterParcelData.jdField_a_of_type_AndroidGraphicsRectF.top;
      int n = (int)localPasterParcelData.jdField_a_of_type_AndroidGraphicsRectF.bottom;
      FaceLayer.FaceItem localFaceItem;
      if (paramJSONArray != null)
      {
        paramJSONArray.setBounds(j, m, k, n);
        SLog.b("DynamicFaceLayer", "Create Normal FaceItem.");
        localFaceItem = new FaceLayer.FaceItem(this, paramJSONArray, new FaceLayer.LayerParams(localPasterParcelData.jdField_a_of_type_AndroidGraphicsPointF.x, localPasterParcelData.jdField_a_of_type_AndroidGraphicsPointF.y, localPasterParcelData.jdField_a_of_type_Float, localPasterParcelData.jdField_b_of_type_Float, localPasterParcelData.jdField_c_of_type_Float, localPasterParcelData.jdField_d_of_type_Float, (int)localPasterParcelData.jdField_e_of_type_Float, (int)localPasterParcelData.f), localPasterParcelData.jdField_a_of_type_JavaLangString, localPasterParcelData.jdField_b_of_type_JavaLangString, localPasterParcelData.jdField_c_of_type_JavaLangString, localPasterParcelData.jdField_d_of_type_Int);
        localFaceItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.a(localPasterParcelData.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper);
        localFaceItem.jdField_g_of_type_JavaLangString = localPasterParcelData.jdField_e_of_type_JavaLangString;
        localFaceItem.jdField_g_of_type_Int = localPasterParcelData.jdField_e_of_type_Int;
        localFaceItem.jdField_e_of_type_Int = 0;
        localFaceItem.jdField_f_of_type_Int = 1;
        localFaceItem.b = InformationFaceConstant.a(localInfoStickerDrawable.a());
        if (localFaceItem.b)
        {
          this.b.add(localFaceItem);
          if (!TextUtils.isEmpty(localPasterParcelData.jdField_d_of_type_JavaLangString))
          {
            localFaceItem.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = new TroopBarPOI("-1", "", localPasterParcelData.jdField_d_of_type_JavaLangString, 0, "", 0, "");
            localFaceItem.jdField_a_of_type_Long = System.currentTimeMillis();
          }
        }
        if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b())) {
          break label444;
        }
        paramJSONArray.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
        this.jdField_a_of_type_JavaUtilList.add(localFaceItem);
      }
      for (;;)
      {
        i += 1;
        break;
        label416:
        if (localInfoStickerDrawable == null) {
          break label500;
        }
        paramJSONArray = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localInfoStickerDrawable.a());
        break label82;
        label444:
        localFaceItem.h = 0;
        paramJSONArray = (FaceLayer)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(FaceLayer.jdField_a_of_type_JavaLangString);
        if (paramJSONArray != null) {
          paramJSONArray.jdField_a_of_type_JavaUtilList.add(localFaceItem);
        }
      }
      ThreadManager.post(new anwy(this, paramArrayList), 8, null, false);
      return;
      label500:
      paramJSONArray = null;
    }
  }
  
  protected boolean b()
  {
    return b() == 10;
  }
  
  public void c(Canvas paramCanvas)
  {
    if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) {
      return;
    }
    paramCanvas.save();
    paramCanvas.scale(this.jdField_a_of_type_Float, this.jdField_a_of_type_Float);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)localIterator.next();
      Drawable localDrawable = a(a(localFaceItem.jdField_f_of_type_JavaLangString));
      Object localObject = localDrawable;
      if (localFaceItem.h == 3)
      {
        localObject = localDrawable;
        if (localFaceItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
        {
          localObject = localDrawable;
          if ((localFaceItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof InfoStickerDrawable))
          {
            localObject = (InfoStickerDrawable)localFaceItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), ((InfoStickerDrawable)localObject).a());
            ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
          }
        }
      }
      if (localObject != null)
      {
        paramCanvas.save();
        paramCanvas.concat(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(localFaceItem));
        paramCanvas.save();
        paramCanvas.translate(-localFaceItem.u / 2.0F, -localFaceItem.v / 2.0F);
        ((Drawable)localObject).draw(paramCanvas);
        paramCanvas.restore();
        paramCanvas.restore();
      }
    }
    paramCanvas.restore();
  }
  
  public int f_()
  {
    return 2147483647;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.DynamicFaceLayer
 * JD-Core Version:    0.7.0.1
 */