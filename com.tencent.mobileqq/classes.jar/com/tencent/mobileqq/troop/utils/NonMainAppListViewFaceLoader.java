package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.ViewHolder;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import java.util.ArrayList;

public class NonMainAppListViewFaceLoader
  implements AbsListView.OnScrollListener
{
  protected float a;
  protected int a;
  protected Context a;
  protected Bitmap a;
  protected Handler a;
  protected LruCache<String, Bitmap> a;
  protected NonMainAppListViewFaceLoader.DecodeHandler a;
  protected AbsListView.OnScrollListener a;
  protected ListView a;
  protected ArrayList<String> a;
  protected int b;
  protected LruCache<String, String> b;
  protected int c;
  protected int d;
  
  protected Bitmap a(Bitmap paramBitmap)
  {
    int j = this.c;
    int i = this.d;
    float f2 = this.jdField_a_of_type_Float;
    int k = paramBitmap.getWidth();
    float f1 = f2;
    if (k > 0)
    {
      f1 = f2;
      if (k < j * f2) {
        f1 = k / j;
      }
    }
    j = (int)(j * f1);
    i = (int)(f1 * i);
    return ImageUtil.a(paramBitmap, j, j, i);
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    Object localObject;
    for (;;)
    {
      try
      {
        localObject = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
        if (localObject != null)
        {
          if (!QLog.isColorLevel()) {
            return localObject;
          }
          QLog.d("NonMainAppListViewFaceLoader", 2, "getFaceBitmap, hit cache:" + paramString);
          return localObject;
        }
        if (QLog.isColorLevel()) {
          QLog.d("NonMainAppListViewFaceLoader", 2, "getFaceBitmap, not in cache:" + paramString + ", add2Request=" + paramBoolean);
        }
        if (this.jdField_a_of_type_Int == 0)
        {
          if (TextUtils.isEmpty((CharSequence)this.jdField_b_of_type_AndroidSupportV4UtilLruCache.get(paramString))) {
            continue;
          }
          localObject = Message.obtain();
          ((Message)localObject).obj = paramString;
          ((Message)localObject).what = 1001;
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNonMainAppListViewFaceLoader$DecodeHandler.sendMessage((Message)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("NonMainAppListViewFaceLoader", 2, "getFaceBitmap, in file cache:" + paramString + ", send decode msg ");
          }
        }
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("NonMainAppListViewFaceLoader", 2, "getFaceBitmap, exception:" + paramString.toString());
        continue;
      }
      return this.jdField_a_of_type_AndroidGraphicsBitmap;
      if ((paramBoolean) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString)))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 350L);
        if (QLog.isColorLevel()) {
          QLog.d("NonMainAppListViewFaceLoader", 2, "getFaceBitmap, not in file cache:" + paramString + ", send getQQHead msg ");
        }
      }
    }
    return localObject;
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NonMainAppListViewFaceLoader", 2, "sendQQHeadRequest, mRequestUinList:" + this.jdField_a_of_type_JavaUtilArrayList.toString() + " mFaceBmpCacheSize:" + this.jdField_a_of_type_AndroidSupportV4UtilLruCache.size() + ", mFacePathCacheSize:" + this.jdField_b_of_type_AndroidSupportV4UtilLruCache.size());
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
      return;
    }
    Intent localIntent = new Intent("com.tencent.qqhead.getheadreq");
    localIntent.setPackage(this.jdField_a_of_type_AndroidContentContext.getPackageName());
    localIntent.putExtra("faceType", this.jdField_b_of_type_Int);
    localIntent.putStringArrayListExtra("uinList", this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent, "com.tencent.qqhead.permission.getheadresp");
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NonMainAppListViewFaceLoader", 2, "refreshListFace, add2Request:" + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentWidgetListView == null) {
      return;
    }
    int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
    int i = 0;
    label49:
    Object localObject;
    if (i < j)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag();
      if (!(localObject instanceof FacePreloadBaseAdapter.ViewHolder)) {
        break label131;
      }
      localObject = (FacePreloadBaseAdapter.ViewHolder)localObject;
      if ((localObject != null) && (((FacePreloadBaseAdapter.ViewHolder)localObject).a != null) && (((FacePreloadBaseAdapter.ViewHolder)localObject).a.length() > 0)) {
        ((FacePreloadBaseAdapter.ViewHolder)localObject).c.setImageBitmap(a(((FacePreloadBaseAdapter.ViewHolder)localObject).a, paramBoolean));
      }
    }
    for (;;)
    {
      i += 1;
      break label49;
      break;
      label131:
      if ((localObject instanceof VideoItemHolder))
      {
        localObject = (VideoItemHolder)localObject;
        if ((((VideoItemHolder)localObject).a != null) && (((VideoItemHolder)localObject).a.a != null) && ((((VideoItemHolder)localObject).a.a.jdField_a_of_type_Int == 1) || (((VideoItemHolder)localObject).a.a.jdField_a_of_type_Int == 6)) && (!TextUtils.isEmpty(((VideoItemHolder)localObject).a.a.j)) && (((VideoItemHolder)localObject).b != null)) {
          ((VideoItemHolder)localObject).b.setImageBitmap(a(((VideoItemHolder)localObject).a.a.j, paramBoolean));
        }
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
    }
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetListView == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("NonMainAppListViewFaceLoader", 2, "onScrollStateChanged, " + this.jdField_a_of_type_Int + " => " + paramInt);
      }
      this.jdField_a_of_type_Int = paramInt;
      if (paramInt == 0)
      {
        a(true);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 350L);
      }
      while (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null)
      {
        this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
        return;
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.NonMainAppListViewFaceLoader
 * JD-Core Version:    0.7.0.1
 */