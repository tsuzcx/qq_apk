import com.tencent.biz.pubaccount.VideoInfo;
import java.util.ArrayList;
import java.util.List;

class rax
  extends qyq<VideoInfo>
{
  rax(raw paramraw) {}
  
  protected String a()
  {
    return "video_feeds";
  }
  
  protected List<VideoInfo> a()
  {
    return raw.a(this.a);
  }
  
  public List<rjx> a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    if (paramInt >= 0)
    {
      List localList = raw.a(this.a);
      ArrayList localArrayList2;
      if (raw.a(this.a) != null)
      {
        localArrayList2 = ((VideoInfo)localList.get(raw.a(this.a).c)).jdField_d_of_type_JavaUtilArrayList;
        if (localArrayList2 != null) {
          a(raw.a(this.a).b - 1, true, localArrayList2, localArrayList1);
        }
      }
      a(paramInt, paramBoolean, localList, localArrayList1);
      if (raw.a(this.a) != null)
      {
        localArrayList2 = ((VideoInfo)localList.get(raw.a(this.a).c)).jdField_d_of_type_JavaUtilArrayList;
        if (localArrayList2 != null) {
          b(raw.a(this.a).b - 1, false, localArrayList2, localArrayList1);
        }
      }
      b(paramInt - 1, paramBoolean, localList, localArrayList1);
    }
    return localArrayList1;
  }
  
  protected rjn a()
  {
    return raw.a(this.a).a.a;
  }
  
  protected rjx a(VideoInfo paramVideoInfo)
  {
    return new rjx(paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, paramVideoInfo.jdField_a_of_type_Int, paramVideoInfo.jdField_d_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rax
 * JD-Core Version:    0.7.0.1
 */