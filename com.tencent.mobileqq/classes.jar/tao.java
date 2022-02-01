import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.qphone.base.util.QLog;

public class tao
  extends anvi
{
  public tao(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (((this.a.a == 0) || (this.a.a == 70)) && (paramBoolean))
    {
      QLog.d("ReadInJoyListViewGroup", 1, "onUpdateFriendInfo uin:" + paramString);
      this.a.m();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tao
 * JD-Core Version:    0.7.0.1
 */