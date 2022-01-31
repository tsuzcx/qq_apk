import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberAQFragment;

public class qhh
  extends osp
{
  public qhh(ReadInJoySelectMemberAQFragment paramReadInJoySelectMemberAQFragment) {}
  
  public void a(String paramString, int paramInt)
  {
    if (("OidbSvc.0xbd4_1".equals(paramString)) && (this.a.getActivity() != null))
    {
      this.a.a = true;
      this.a.a();
      if (paramInt == 0)
      {
        ReadInJoySelectMemberAQFragment.a(this.a, 0);
        ReadInJoySelectMemberAQFragment.a(this.a, false);
        this.a.c();
        this.a.getActivity().finish();
        ReadInJoySelectMemberAQFragment.a(this.a, true);
      }
    }
    else
    {
      return;
    }
    ReadInJoySelectMemberAQFragment.a(this.a, true);
    ReadInJoySelectMemberAQFragment.a(this.a, 2);
    ReadInJoySelectMemberAQFragment.a(this.a, ajyc.a(2131712746) + paramInt);
    bcpw.a(this.a.getActivity(), 1, this.a.getString(2131718550), 0).b(ReadInJoySelectMemberAQFragment.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qhh
 * JD-Core Version:    0.7.0.1
 */