import UserGrowth.stSimpleGetFeedListReq;
import UserGrowth.stSimpleGetFeedListRsp;
import java.util.ArrayList;

public class sac
  extends ryw<stSimpleGetFeedListRsp>
{
  public sac(String paramString1, byte paramByte1, byte paramByte2, ArrayList<String> paramArrayList, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    super("SimpleGetFeedList");
    stSimpleGetFeedListReq localstSimpleGetFeedListReq = new stSimpleGetFeedListReq();
    localstSimpleGetFeedListReq.attach_info = paramString1;
    localstSimpleGetFeedListReq.isrefresh = paramByte1;
    localstSimpleGetFeedListReq.isfirst = paramByte2;
    localstSimpleGetFeedListReq.channel_info = "from_android_qq";
    localstSimpleGetFeedListReq.context_feedids = paramArrayList;
    localstSimpleGetFeedListReq.scene = paramInt;
    localstSimpleGetFeedListReq.gdt_args = paramString2;
    localstSimpleGetFeedListReq.rowkey = paramString3;
    localstSimpleGetFeedListReq.session = paramString4;
    localstSimpleGetFeedListReq.push_info = paramString5;
    localstSimpleGetFeedListReq.linkStragetyArgs = saj.a();
    this.a = localstSimpleGetFeedListReq;
    sai.d("RecommendRequest", "stSimpleGetFeedListReq  = " + localstSimpleGetFeedListReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sac
 * JD-Core Version:    0.7.0.1
 */