package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import android.graphics.Bitmap;
import android.text.TextUtils;
import aokx;
import aokz;
import aola;
import aole;
import aolf;
import aolg;
import aolh;
import aoli;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class VideoFrameLoader
  implements aola
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private aokz jdField_a_of_type_Aokz;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private int c;
  private int d;
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFrameLoader", 2, "onDecodeStart， useretriever:" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    ThreadManager.getUIHandler().post(new aole(this));
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFrameLoader", 2, "onDecodeError , code:" + paramInt);
    }
    ThreadManager.getUIHandler().post(new aolh(this));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFrameLoader", 2, "start， nCount:" + paramInt1 + " nFrameWidth:" + this.jdField_a_of_type_Int + " nFrameHeight:" + paramInt3);
    }
    if ((paramInt1 <= 0) || (paramInt2 <= 0) || (paramInt3 <= 0)) {
      return;
    }
    this.c = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt3;
    this.jdField_a_of_type_Aokz = new aokx(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, this.d, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this);
    ThreadManager.post(this.jdField_a_of_type_Aokz, 10, null, true);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt, long paramLong, Bitmap paramBitmap)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onDecodeFrame, index:").append(paramInt).append(" ltimeus:").append(paramLong).append(" bitmap:");
      if (paramBitmap == null) {
        break label93;
      }
    }
    label93:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("VideoFrameLoader", 2, bool);
      if ((paramInt >= 0) && (paramInt < this.c)) {
        ThreadManager.getUIHandler().post(new aolf(this, paramInt, paramBitmap));
      }
      return;
    }
  }
  
  public void a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFrameLoader", 2, "onDecodeKeyFrameList");
    }
    ThreadManager.getUIHandler().post(new aoli(this, paramList));
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFrameLoader", 2, "onDecodeEnd, finish:" + paramBoolean);
    }
    ThreadManager.getUIHandler().post(new aolg(this));
  }
  
  public boolean a(String paramString, long paramLong1, long paramLong2, int paramInt, VideoFrameLoader.VideoFrameLoaderListener paramVideoFrameLoaderListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramVideoFrameLoaderListener);
    this.jdField_a_of_type_Long = paramLong1;
    this.d = paramInt;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_a_of_type_JavaLangString = paramString;
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long <= 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFrameLoader", 2, "init error, path:" + this.jdField_a_of_type_JavaLangString + " time:" + this.jdField_a_of_type_Long + "-" + this.jdField_b_of_type_Long);
      }
      return false;
    }
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFrameLoader", 2, "stop， mListItems: :" + this.jdField_a_of_type_JavaUtilList.size() + " useRetriever:" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Aokz != null)
    {
      this.jdField_a_of_type_Aokz.a();
      this.jdField_a_of_type_Aokz = null;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFrameLoader", 2, "uinit..");
    }
    b();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader
 * JD-Core Version:    0.7.0.1
 */