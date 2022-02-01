package cooperation.ilive.util;

import android.content.Context;
import android.content.Intent;
import arnz;
import aroa;
import bilz;
import bmfy;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.qphone.base.util.QLog;

public final class IlivePreloadHelper$1
  implements Runnable
{
  public IlivePreloadHelper$1(int paramInt, Context paramContext) {}
  
  public void run()
  {
    if (!aroa.c().d()) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Int == 1) && (!bmfy.a()))
      {
        QLog.e("IlivePreloadHelper", 1, "preloadLiveShopping checkDrawerSwitchEnable = false");
        return;
      }
      bmfy.b();
      QLog.e("IlivePreloadHelper", 1, "ilive start preloadLiveShopping , source = " + this.jdField_a_of_type_Int);
      bilz.b(-1);
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, PreloadWebService.class);
      localIntent.putExtra("isPreloadLiveShopping", true);
      localIntent.putExtra("source", this.jdField_a_of_type_Int);
      try
      {
        this.jdField_a_of_type_AndroidContentContext.startService(localIntent);
        return;
      }
      catch (Throwable localThrowable) {}
    } while (!QLog.isColorLevel());
    QLog.e("IlivePreloadHelper", 2, "preDownloadIfNecessary=>" + localThrowable.getMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.ilive.util.IlivePreloadHelper.1
 * JD-Core Version:    0.7.0.1
 */