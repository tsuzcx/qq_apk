package com.tencent.mobileqq.listentogether;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.util.SystemUtil;
import java.io.File;

public class ListenTogetherConstants
{
  public static String a;
  public static final int[] b = { -1182476, -16725252, -16717828, 2136267007, -1567, -996497, -1356, 2147468069, -924417, -9253895, -218377, 2147454710 };
  
  static
  {
    if (SystemUtil.a()) {
      a = new File(AppConstants.SDCARD_PATH, "ListenTogether_v828").getAbsolutePath();
    } else {
      a = new File(BaseApplicationImpl.getApplication().getFilesDir(), "ListenTogether_v828").getAbsolutePath();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherConstants
 * JD-Core Version:    0.7.0.1
 */