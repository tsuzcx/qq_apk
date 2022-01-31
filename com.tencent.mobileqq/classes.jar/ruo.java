import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyProteusFamilyListViewGroup;
import com.tencent.qphone.base.util.QLog;

public class ruo
  extends alox
{
  public ruo(ReadInJoyProteusFamilyListViewGroup paramReadInJoyProteusFamilyListViewGroup) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (((this.a.a == 0) || (this.a.a == 70)) && (paramBoolean))
    {
      QLog.d("ReadinJoyProteusFamilyListViewGroup", 1, "onUpdateFriendInfo uin:" + paramString);
      this.a.k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ruo
 * JD-Core Version:    0.7.0.1
 */