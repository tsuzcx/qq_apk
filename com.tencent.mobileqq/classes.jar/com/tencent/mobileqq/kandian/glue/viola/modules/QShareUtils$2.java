package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import java.io.IOException;
import java.util.Map;

class QShareUtils$2
  implements Runnable
{
  QShareUtils$2(QShareUtils paramQShareUtils, String paramString, boolean paramBoolean1, boolean paramBoolean2, Map paramMap, AppInterface paramAppInterface, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      Object localObject = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), MsfSdkUtils.insertMtype("GameCenter", this.jdField_a_of_type_JavaLangString), "GET", null, null);
      if (localObject != null)
      {
        localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
        if ((!this.jdField_a_of_type_Boolean) && (localObject != null))
        {
          boolean bool = this.b;
          if (bool) {
            this.jdField_a_of_type_JavaUtilMap.put("image", QShareUtils.a((Bitmap)localObject));
          } else {
            this.jdField_a_of_type_JavaUtilMap.put("image", QShareUtils.a(this.this$0, (Bitmap)localObject));
          }
        }
      }
    }
    catch (IOException|OutOfMemoryError localIOException)
    {
      label91:
      break label91;
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.runOnUiThread(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.QShareUtils.2
 * JD-Core Version:    0.7.0.1
 */