package com.tencent.mobileqq.intervideo.huayang;

import android.os.Handler;
import aszn;
import atar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.Map;

public final class HuayangOpenHelper$1
  implements Runnable
{
  public HuayangOpenHelper$1(String paramString1, atar paramatar, QQAppInterface paramQQAppInterface, String paramString2, String paramString3, Map paramMap) {}
  
  public void run()
  {
    aszn.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Atar);
    ThreadManagerV2.getUIHandlerV2().post(new HuayangOpenHelper.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangOpenHelper.1
 * JD-Core Version:    0.7.0.1
 */