import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import java.util.Comparator;

class pad
  implements Comparator<ChannelInfo>
{
  pad(paa parampaa) {}
  
  public int a(ChannelInfo paramChannelInfo1, ChannelInfo paramChannelInfo2)
  {
    if (paramChannelInfo1.mSortOrder == paramChannelInfo2.mSortOrder) {
      return 0;
    }
    if (paramChannelInfo1.mSortOrder < paramChannelInfo2.mSortOrder) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pad
 * JD-Core Version:    0.7.0.1
 */