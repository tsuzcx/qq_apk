package com.tencent.mobileqq.remind;

import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.remind.widget.IosTimepicker.FormatDataListener;
import com.tencent.mobileqq.remind.widget.WheelView;

final class RemindHelper$1
  implements IosTimepicker.FormatDataListener
{
  public long a(WheelView[] paramArrayOfWheelView, int[] paramArrayOfInt)
  {
    Object localObject2 = null;
    if ((paramArrayOfInt.length != 3) || (paramArrayOfWheelView.length != 3)) {
      return -1L;
    }
    String str2;
    if (AppSetting.d)
    {
      str2 = TimeHelper.a(paramArrayOfInt[0]);
      if ((paramArrayOfInt[1] < 0) || (paramArrayOfInt[1] >= TimeHelper.a.length)) {
        break label206;
      }
    }
    label206:
    for (String str1 = TimeHelper.a[paramArrayOfInt[1]];; str1 = null)
    {
      Object localObject1 = localObject2;
      if (paramArrayOfInt[2] >= 0)
      {
        localObject1 = localObject2;
        if (paramArrayOfInt[2] < TimeHelper.b.length) {
          localObject1 = TimeHelper.b[paramArrayOfInt[2]];
        }
      }
      if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        str1 = HardCodeUtil.a(2131713347) + str2 + str1 + HardCodeUtil.a(2131713345) + (String)localObject1 + HardCodeUtil.a(2131713346);
        int j = paramArrayOfWheelView.length;
        int i = 0;
        while (i < j)
        {
          paramArrayOfWheelView[i].setContentDescription(str1);
          i += 1;
        }
      }
      return TimeHelper.a(paramArrayOfInt[0], paramArrayOfInt[1], paramArrayOfInt[2]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.remind.RemindHelper.1
 * JD-Core Version:    0.7.0.1
 */