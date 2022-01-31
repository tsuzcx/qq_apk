import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public class pgw
  extends ampt
{
  public pgw(SelectPositionModule paramSelectPositionModule, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectPositionModule", 2, "onLocationFinish() errCode=" + paramInt);
    }
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null) && (!TextUtils.isEmpty(paramSosoLbsInfo.a.e)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPositionModule", 2, "onLocationFinish() info.mLocation =" + paramSosoLbsInfo.a);
      }
      SelectPositionModule.a(this.a, new SelectPositionModule.PositionData(paramSosoLbsInfo.a));
      SelectPositionModule.a(this.a, SelectPositionModule.a(this.a));
      SelectPositionModule.b(this.a, SelectPositionModule.a(this.a));
      if (SelectPositionModule.a(this.a) != null) {
        SelectPositionModule.a(this.a).a(SelectPositionModule.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pgw
 * JD-Core Version:    0.7.0.1
 */