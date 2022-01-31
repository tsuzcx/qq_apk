import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.gaudio.AVUserInfo;
import com.tencent.av.ui.GAudioMembersCtrlActivity;
import com.tencent.av.utils.EllipsisUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class jup
  implements Runnable
{
  jup(jul paramjul, ArrayList paramArrayList) {}
  
  public void run()
  {
    TextPaint localTextPaint = new TextView(GAudioMembersCtrlActivity.a(this.jdField_a_of_type_Jul.a)).getPaint();
    float f3 = GAudioMembersCtrlActivity.a(this.jdField_a_of_type_Jul.a).getDisplayMetrics().widthPixels;
    float f4 = localTextPaint.measureText("的版本过低，暂不支持静音控制。");
    StringBuilder localStringBuilder = new StringBuilder();
    int m = this.jdField_a_of_type_JavaUtilArrayList.size();
    float f1;
    if (m == 1)
    {
      f1 = f3 - DisplayUtil.a(GAudioMembersCtrlActivity.b(this.jdField_a_of_type_Jul.a), 60.0F) - f4;
      if (f1 > 0.0F) {
        break label638;
      }
      f1 = GAudioMembersCtrlActivity.b(this.jdField_a_of_type_Jul.a).getDimensionPixelSize(2131559834);
    }
    label351:
    label633:
    label638:
    for (;;)
    {
      AVUserInfo localAVUserInfo = (AVUserInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      String str = this.jdField_a_of_type_Jul.a.a.a(String.valueOf(localAVUserInfo.a), String.valueOf(this.jdField_a_of_type_Jul.a.a.a().f), 1);
      if (TextUtils.isEmpty(str)) {
        str = String.valueOf(String.valueOf(localAVUserInfo.a));
      }
      for (;;)
      {
        EllipsisUtil.b(localStringBuilder, str, localTextPaint, f1);
        for (;;)
        {
          localStringBuilder.append("的版本过低，暂不支持静音控制。");
          QQToast.a(this.jdField_a_of_type_Jul.a, localStringBuilder.toString(), 1).a();
          if (QLog.isColorLevel()) {
            QLog.d("GAudioMembersCtrlActivity", 2, localStringBuilder.toString());
          }
          return;
          f1 = localTextPaint.measureText("等99人" + "的版本过低，暂不支持静音控制。");
          float f5 = localTextPaint.measureText("...");
          float f2 = f3 - DisplayUtil.a(GAudioMembersCtrlActivity.c(this.jdField_a_of_type_Jul.a), 60.0F) - f1 - f5;
          f1 = f2;
          if (f2 <= 0.0F) {
            f1 = GAudioMembersCtrlActivity.c(this.jdField_a_of_type_Jul.a).getDimensionPixelSize(2131559834);
          }
          float f6 = localTextPaint.measureText("、");
          int i = 0;
          int j = 0;
          if (i < 2)
          {
            int k = 0;
            for (;;)
            {
              if (k < m)
              {
                localAVUserInfo = (AVUserInfo)this.jdField_a_of_type_JavaUtilArrayList.get(k);
                str = this.jdField_a_of_type_Jul.a.a.a(String.valueOf(localAVUserInfo.a), String.valueOf(this.jdField_a_of_type_Jul.a.a.a().f), 1);
                if (TextUtils.isEmpty(str))
                {
                  str = String.valueOf(String.valueOf(localAVUserInfo.a));
                  f2 = EllipsisUtil.a(localStringBuilder, str, localTextPaint, f1);
                  if ((2.0F * f6 < f2) && (k < m - 1))
                  {
                    localStringBuilder.append("、");
                    k += 1;
                    f1 = f2;
                    continue;
                  }
                  if ((k == 0) && (f2 == f1) && (!TextUtils.isEmpty(str))) {
                    EllipsisUtil.a(localStringBuilder, str, localTextPaint, GAudioMembersCtrlActivity.d(this.jdField_a_of_type_Jul.a).getDimensionPixelSize(2131559834));
                  }
                  if (f5 > f2)
                  {
                    localStringBuilder.append("...等");
                    localStringBuilder.append(m);
                    localStringBuilder.append("人");
                  }
                }
              }
            }
          }
          for (;;)
          {
            if ((f5 < f2) || (j != 0)) {
              break label633;
            }
            localStringBuilder.delete(0, localStringBuilder.length());
            f1 = f3 - DisplayUtil.a(GAudioMembersCtrlActivity.d(this.jdField_a_of_type_Jul.a), 60.0F) - f4;
            i += 1;
            j = 1;
            break label351;
            break;
            break label445;
            f2 = f1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jup
 * JD-Core Version:    0.7.0.1
 */