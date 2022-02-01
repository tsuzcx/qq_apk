package dov.com.qq.im.aeeditor.module.aifilter;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.session.TAVCutVideoSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SilentVideoAIFilterProxy
  extends VideoAIFilterProxy
{
  public SilentVideoAIFilterProxy(TAVCutVideoSession paramTAVCutVideoSession)
  {
    super(paramTAVCutVideoSession);
  }
  
  protected AIFilterResult a(List<AIFilterResponse> paramList)
  {
    VideoAIFilterResult localVideoAIFilterResult = new VideoAIFilterResult();
    ArrayList localArrayList = new ArrayList();
    AIFilterResponse localAIFilterResponse;
    if ((paramList != null) && (paramList.size() > 0))
    {
      String str = a(paramList);
      paramList = paramList.iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
        localAIFilterResponse = (AIFilterResponse)paramList.next();
      } while (!localAIFilterResponse.jdField_a_of_type_JavaLangString.equals(str));
    }
    for (paramList = localAIFilterResponse.jdField_a_of_type_JavaUtilList;; paramList = localArrayList)
    {
      localVideoAIFilterResult.jdField_a_of_type_JavaUtilList = paramList;
      return localVideoAIFilterResult;
    }
  }
  
  protected List<Long> a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.a != null) && (this.a.getDuration() != null))
    {
      long l1 = this.a.getDuration().getTimeUs() / 1000L;
      int i = 3000;
      if (l1 > 30000L) {
        i = 6000;
      }
      int j = 0;
      while ((j <= l1 / i) && (j < 3))
      {
        long l2 = j * i;
        if (l2 < l1) {
          localArrayList.add(Long.valueOf(l2));
        }
        j += 1;
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.SilentVideoAIFilterProxy
 * JD-Core Version:    0.7.0.1
 */