package cooperation.qzone.statistic.access.concept;

import java.util.List;

final class Assembler$1
  extends Assembler
{
  public String assemble(List<Statistic> paramList)
  {
    Key[] arrayOfKey = ((Statistic)paramList.get(0)).getKeys();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      Statistic localStatistic = (Statistic)paramList.get(i);
      int k = arrayOfKey.length;
      int j = 0;
      while (j < k)
      {
        Key localKey = arrayOfKey[j];
        localStringBuilder.append(localKey);
        localStringBuilder.append("→");
        localStringBuilder.append(localStatistic.getValue(localKey));
        localStringBuilder.append(",");
        j += 1;
      }
      localStringBuilder.append("\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.statistic.access.concept.Assembler.1
 * JD-Core Version:    0.7.0.1
 */