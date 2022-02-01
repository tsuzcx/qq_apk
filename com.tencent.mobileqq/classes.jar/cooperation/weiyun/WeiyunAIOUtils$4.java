package cooperation.weiyun;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

final class WeiyunAIOUtils$4
  implements FMDialogUtil.FMDialogInterface
{
  WeiyunAIOUtils$4(QQAppInterface paramQQAppInterface, List paramList1, List paramList2, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, MqqHandler paramMqqHandler, int paramInt) {}
  
  public void a()
  {
    if (WeiyunAIOUtils.b(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h))
    {
      QQToast.makeText(this.a.getApp(), 2131889761, 0).show(this.h);
      return;
    }
    QQToast.makeText(this.a.getApp(), 2131889814, 0).show(this.h);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.weiyun.WeiyunAIOUtils.4
 * JD-Core Version:    0.7.0.1
 */