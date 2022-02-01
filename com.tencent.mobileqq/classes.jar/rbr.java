import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyUgcSearchTopicFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class rbr
  extends pfh
{
  public rbr(ReadInJoyUgcSearchTopicFragment paramReadInJoyUgcSearchTopicFragment) {}
  
  public void a(int paramInt, long paramLong, String paramString)
  {
    if ((0L != paramLong) && (!TextUtils.isEmpty(paramString))) {
      if ((ReadInJoyUgcSearchTopicFragment.a(this.a) != null) && (ReadInJoyUgcSearchTopicFragment.a(this.a).size() == 1))
      {
        TopicInfo localTopicInfo = (TopicInfo)ReadInJoyUgcSearchTopicFragment.a(this.a).get(0);
        long l = localTopicInfo.a();
        String str1 = localTopicInfo.a();
        String str2 = localTopicInfo.b();
        String str3 = localTopicInfo.c();
        localTopicInfo.d();
        localTopicInfo = TopicInfo.a().a(l).a("#" + str1).b(str2).c(str3).d(paramString).a();
        ReadInJoyUgcSearchTopicFragment.a(this.a, localTopicInfo);
        ozs.a("0X800980A", ReadInJoyUgcSearchTopicFragment.a(this.a), paramLong, "1");
        raa.a(String.valueOf(paramLong), "1");
      }
    }
    for (;;)
    {
      ReadInJoyUgcSearchTopicFragment.a(this.a, false);
      QLog.d("ReadInJoyUgcSearchTopicFragment", 1, "handle0xc16CreateTopic, topicID:" + paramLong + "  topicUrl:" + paramString + " result:" + paramInt);
      return;
      this.a.a(1, this.a.getString(2131717067));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rbr
 * JD-Core Version:    0.7.0.1
 */