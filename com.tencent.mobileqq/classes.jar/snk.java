import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class snk
  extends suv
{
  snk(smg paramsmg) {}
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if ((paramVideoInfo.n != null) && (paramVideoInfo.n.contains("kandianshare.html5.qq.com")))
    {
      smg.a(this.a, paramVideoInfo.c, "", paramVideoInfo.n, paramVideoInfo.b);
      return;
    }
    smg.a(this.a, paramVideoInfo.c, "", paramString + "&sourcefrom=4", paramVideoInfo.b);
  }
  
  public int b()
  {
    return 5;
  }
  
  public int c()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     snk
 * JD-Core Version:    0.7.0.1
 */