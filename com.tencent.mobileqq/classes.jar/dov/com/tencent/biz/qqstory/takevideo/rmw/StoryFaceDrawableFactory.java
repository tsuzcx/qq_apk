package dov.com.tencent.biz.qqstory.takevideo.rmw;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import aomf;
import aomg;
import aomh;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.view.StoryFaceDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.ArrayList;

public class StoryFaceDrawableFactory
{
  public int a;
  private BroadcastReceiver a;
  protected Context a;
  public Handler a;
  public LruCache a;
  public StoryFaceDrawableFactory.FaceDrawableListener a;
  public ArrayList a;
  public int b;
  public LruCache b;
  
  public StoryFaceDrawableFactory(Context paramContext)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(60);
    this.jdField_b_of_type_AndroidSupportV4UtilLruCache = new LruCache(120);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new aomf(this, Looper.getMainLooper());
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aomg(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.qqhead.getheadresp");
    paramContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.qim.qqhead.permission.getheadresp", null);
  }
  
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
    this.jdField_b_of_type_Int = ((int)(f1 * this.jdField_b_of_type_Int));
    i = this.jdField_a_of_type_Int;
    SLog.c("Q.qqstory.record.StoryFaceDrawableFactory", "getCircleFaceBitmap end.");
    return ImageUtil.a(paramBitmap, i, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
  }
  
  public Bitmap a(String paramString)
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
  
  public Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString))
    {
      SLog.e("Q.qqstory.record.StoryFaceDrawableFactory", "getStoryFaceDrawable uin is null!");
      return null;
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (!TextUtils.isEmpty((CharSequence)this.jdField_b_of_type_AndroidSupportV4UtilLruCache.get(paramString)))
    {
      localStoryFaceDrawable = (StoryFaceDrawable)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
      if (localStoryFaceDrawable != null)
      {
        SLog.c("Q.qqstory.record.StoryFaceDrawableFactory", "getStoryFaceDrawable, hit cache:" + paramString);
        return localStoryFaceDrawable;
      }
    }
    SLog.c("Q.qqstory.record.StoryFaceDrawableFactory", "getStoryFaceDrawable, not in cache:" + paramString);
    StoryFaceDrawable localStoryFaceDrawable = new StoryFaceDrawable(paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, localStoryFaceDrawable);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1000);
    localMessage.obj = paramString;
    localMessage.sendToTarget();
    return localStoryFaceDrawable;
  }
  
  public void a()
  {
    SLog.c("Q.qqstory.record.StoryFaceDrawableFactory", "onDestory");
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_AndroidSupportV4UtilLruCache.evictAll();
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
      return;
    }
    catch (Exception localException)
    {
      SLog.e("Q.qqstory.record.StoryFaceDrawableFactory", "onDestory:" + localException.toString());
    }
  }
  
  public void a(StoryFaceDrawableFactory.FaceDrawableListener paramFaceDrawableListener)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoRmwStoryFaceDrawableFactory$FaceDrawableListener = paramFaceDrawableListener;
  }
  
  public void a(String paramString)
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
  
  public void a(String paramString1, String paramString2)
  {
    ThreadManager.post(new aomh(this, paramString2, paramString1), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.rmw.StoryFaceDrawableFactory
 * JD-Core Version:    0.7.0.1
 */