import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.4;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import java.util.Comparator;

public class pfh
  implements Comparator<TabChannelCoverInfo>
{
  public pfh(ChannelCoverInfoModule.4 param4) {}
  
  public int a(TabChannelCoverInfo paramTabChannelCoverInfo1, TabChannelCoverInfo paramTabChannelCoverInfo2)
  {
    return paramTabChannelCoverInfo1.seq - paramTabChannelCoverInfo2.seq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pfh
 * JD-Core Version:    0.7.0.1
 */