import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.qphone.base.util.QLog;

public class qrq
  extends ajjh
{
  public qrq(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (((this.a.a == 0) || (this.a.a == 70)) && (paramBoolean))
    {
      QLog.d("ReadInJoyListViewGroup", 1, "onUpdateFriendInfo uin:" + paramString);
      this.a.q();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qrq
 * JD-Core Version:    0.7.0.1
 */