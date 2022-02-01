package dov.com.tencent.biz.qqstory.takevideo.rmw;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.view.StoryFaceDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.ArrayList;

public class StoryFaceDrawableFactory
{
  protected int a;
  protected Context a;
  protected Handler a;
  protected LruCache<String, StoryFaceDrawable> a;
  protected StoryFaceDrawableFactory.FaceDrawableListener a;
  protected ArrayList<String> a;
  protected int b;
  protected LruCache<String, String> b;
  
  protected Bitmap a(Bitmap paramBitmap)
  {
    SLog.c("Q.qqstory.record.StoryFaceDrawableFactory", "getCircleFaceBitmap start.");
    float f2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    int i = paramBitmap.getWidth();
    float f1 = f2;
    if (i > 0)
    {
      f1 = f2;
      if (i < this.jdField_a_of_type_Int * f2) {
        f1 = i / this.jdField_a_of_type_Int;
      }
    }
    this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Int * f1));
    this.b = ((int)(f1 * this.b));
    i = this.jdField_a_of_type_Int;
    SLog.c("Q.qqstory.record.StoryFaceDrawableFactory", "getCircleFaceBitmap end.");
    return ImageUtil.a(paramBitmap, i, this.jdField_a_of_type_Int, this.b);
  }
  
  protected Bitmap a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      SLog.e("Q.qqstory.record.StoryFaceDrawableFactory", "localPath = null!");
      return null;
    }
    SLog.b("Q.qqstory.record.StoryFaceDrawableFactory", "getFaceBitmapByPath start. localPath:%s.", paramString);
    try
    {
      paramString = BitmapFactory.decodeFile(paramString);
      if (paramString == null)
      {
        SLog.e("Q.qqstory.record.StoryFaceDrawableFactory", "BitmapFactory.decodeFile return null!");
        return null;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        SLog.c("Q.qqstory.record.StoryFaceDrawableFactory", "BitmapFactory.decodeFile error : %s.", paramString);
        paramString = null;
      }
      Bitmap localBitmap = a(paramString);
      if (localBitmap == null)
      {
        SLog.e("Q.qqstory.record.StoryFaceDrawableFactory", "getCircleFaceBitmap return null!");
        return null;
      }
      if ((paramString != null) && (!paramString.isRecycled())) {
        paramString.recycle();
      }
      SLog.c("Q.qqstory.record.StoryFaceDrawableFactory", "getFaceBitmapByPath end.");
      return localBitmap;
    }
  }
  
  protected void a(String paramString)
  {
    SLog.b("Q.qqstory.record.StoryFaceDrawableFactory", "sendQQHeadRequest uin:%s.", paramString);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    paramString = new Intent("com.tencent.qqhead.getheadreq");
    paramString.setPackage(this.jdField_a_of_type_AndroidContentContext.getPackageName());
    paramString.putExtra("faceType", 1);
    paramString.putStringArrayListExtra("uinList", localArrayList);
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(paramString, "com.tencent.qim.qqhead.permission.getheadresp");
  }
  
  protected void a(String paramString1, String paramString2)
  {
    ThreadManager.post(new StoryFaceDrawableFactory.3(this, paramString2, paramString1), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.rmw.StoryFaceDrawableFactory
 * JD-Core Version:    0.7.0.1
 */