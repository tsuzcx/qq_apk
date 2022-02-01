package com.tencent.mobileqq.vas.avatar;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngDrawable.OnPlayRepeatListener;
import com.tencent.image.ApngImage;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class VasFaceManager$Replayer
  implements ApngDrawable.OnPlayRepeatListener, Runnable
{
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private String jdField_a_of_type_JavaLangString;
  public WeakReference<ApngImage> a;
  private boolean jdField_a_of_type_Boolean;
  private long b;
  
  public VasFaceManager$Replayer(String paramString, ApngDrawable paramApngDrawable, Handler paramHandler)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramApngDrawable.getImage());
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    paramApngDrawable.setOnPlayRepeatListener(this);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      long l = SystemClock.uptimeMillis();
      this.b += l - this.jdField_a_of_type_Long;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      long l = this.b;
      if (l >= 5000L)
      {
        this.jdField_a_of_type_AndroidOsHandler.post(this);
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 5000L - l);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(this);
  }
  
  public void onPlayRepeat(int paramInt)
  {
    if (paramInt == 3)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onPlayRepeat: ");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(" image: ");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangRefWeakReference.get());
        QLog.e("Q.qqhead.VasFaceManager", 1, localStringBuilder.toString());
      }
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.b = 0L;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 5000L);
    }
  }
  
  public void run()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this);
    ApngImage localApngImage = (ApngImage)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localApngImage != null)
    {
      localApngImage.replay();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("replay ");
        localStringBuilder.append(localApngImage);
        localStringBuilder.append(" in ");
        localStringBuilder.append(this);
        QLog.i("Q.qqhead.VasFaceManager", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.VasFaceManager.Replayer
 * JD-Core Version:    0.7.0.1
 */