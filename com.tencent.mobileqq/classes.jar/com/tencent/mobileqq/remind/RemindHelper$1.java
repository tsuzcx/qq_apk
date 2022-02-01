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
    if ((paramArrayOfInt.length == 3) && (paramArrayOfWheelView.length == 3))
    {
      if (AppSetting.d)
      {
        String str2 = TimeHelper.a(paramArrayOfInt[0]);
        int i = paramArrayOfInt[1];
        StringBuilder localStringBuilder = null;
        String str1;
        if ((i >= 0) && (paramArrayOfInt[1] < TimeHelper.a.length)) {
          str1 = TimeHelper.a[paramArrayOfInt[1]];
        } else {
          str1 = null;
        }
        Object localObject = localStringBuilder;
        if (paramArrayOfInt[2] >= 0)
        {
          localObject = localStringBuilder;
          if (paramArrayOfInt[2] < TimeHelper.b.length) {
            localObject = TimeHelper.b[paramArrayOfInt[2]];
          }
        }
        if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131713315));
          localStringBuilder.append(str2);
          localStringBuilder.append(str1);
          localStringBuilder.append(HardCodeUtil.a(2131713313));
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(HardCodeUtil.a(2131713314));
          str1 = localStringBuilder.toString();
          int j = paramArrayOfWheelView.length;
          i = 0;
          while (i < j)
          {
            paramArrayOfWheelView[i].setContentDescription(str1);
            i += 1;
          }
        }
      }
      return TimeHelper.a(paramArrayOfInt[0], paramArrayOfInt[1], paramArrayOfInt[2]);
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.remind.RemindHelper.1
 * JD-Core Version:    0.7.0.1
 */