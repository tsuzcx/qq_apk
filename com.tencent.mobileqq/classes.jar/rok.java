import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberAQFragment;
import com.tencent.mobileqq.widget.QQToast;

public class rok
  extends pkt
{
  public rok(ReadInJoySelectMemberAQFragment paramReadInJoySelectMemberAQFragment) {}
  
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
    ReadInJoySelectMemberAQFragment.a(this.a, amtj.a(2131711861) + paramInt);
    QQToast.a(this.a.getActivity(), 1, this.a.getString(2131717494), 0).b(ReadInJoySelectMemberAQFragment.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rok
 * JD-Core Version:    0.7.0.1
 */