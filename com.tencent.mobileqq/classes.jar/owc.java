import com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel;
import java.util.Comparator;

class owc
  implements Comparator<DynamicChannelDataModel>
{
  owc(ovz paramovz) {}
  
  public int a(DynamicChannelDataModel paramDynamicChannelDataModel1, DynamicChannelDataModel paramDynamicChannelDataModel2)
  {
    if (paramDynamicChannelDataModel1.recommendSeq == paramDynamicChannelDataModel2.recommendSeq) {
      return 0;
    }
    if (paramDynamicChannelDataModel1.recommendSeq < paramDynamicChannelDataModel2.recommendSeq) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     owc
 * JD-Core Version:    0.7.0.1
 */