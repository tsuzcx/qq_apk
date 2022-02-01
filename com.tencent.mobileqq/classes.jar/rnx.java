import com.tencent.biz.pubaccount.VideoInfo;
import java.util.ArrayList;
import java.util.List;

class rnx
  extends rlj<VideoInfo>
{
  rnx(rnu paramrnu) {}
  
  protected String a()
  {
    return "video_feeds";
  }
  
  protected List<VideoInfo> a()
  {
    return rnu.a(this.a);
  }
  
  public List<rwo> a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    if (paramInt >= 0)
    {
      List localList = rnu.a(this.a);
      ArrayList localArrayList2;
      if (rnu.a(this.a) != null)
      {
        localArrayList2 = ((VideoInfo)localList.get(rnu.a(this.a).c)).c;
        if (localArrayList2 != null) {
          a(rnu.a(this.a).b - 1, true, localArrayList2, localArrayList1);
        }
      }
      a(paramInt, paramBoolean, localList, localArrayList1);
      if (rnu.a(this.a) != null)
      {
        localArrayList2 = ((VideoInfo)localList.get(rnu.a(this.a).c)).c;
        if (localArrayList2 != null) {
          b(rnu.a(this.a).b - 1, false, localArrayList2, localArrayList1);
        }
      }
      b(paramInt - 1, paramBoolean, localList, localArrayList1);
    }
    return localArrayList1;
  }
  
  protected rwf a()
  {
    if ((rnu.a(this.a) != null) && (rnu.a(this.a).a != null)) {
      return rnu.a(this.a).a.a;
    }
    return null;
  }
  
  protected rwo a(VideoInfo paramVideoInfo)
  {
    return new rwo(paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, paramVideoInfo.jdField_a_of_type_Int, paramVideoInfo.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rnx
 * JD-Core Version:    0.7.0.1
 */