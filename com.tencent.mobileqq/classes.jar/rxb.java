import com.tencent.biz.pubaccount.VideoInfo;
import java.util.ArrayList;
import java.util.List;

class rxb
  extends run<VideoInfo>
{
  rxb(rwy paramrwy) {}
  
  protected String a()
  {
    return "video_feeds";
  }
  
  protected List<VideoInfo> a()
  {
    return rwy.a(this.a);
  }
  
  public List<sfk> a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    if (paramInt >= 0)
    {
      List localList = rwy.a(this.a);
      ArrayList localArrayList2;
      if (rwy.a(this.a) != null)
      {
        localArrayList2 = ((VideoInfo)localList.get(rwy.a(this.a).c)).jdField_d_of_type_JavaUtilArrayList;
        if (localArrayList2 != null) {
          a(rwy.a(this.a).b - 1, true, localArrayList2, localArrayList1);
        }
      }
      a(paramInt, paramBoolean, localList, localArrayList1);
      if (rwy.a(this.a) != null)
      {
        localArrayList2 = ((VideoInfo)localList.get(rwy.a(this.a).c)).jdField_d_of_type_JavaUtilArrayList;
        if (localArrayList2 != null) {
          b(rwy.a(this.a).b - 1, false, localArrayList2, localArrayList1);
        }
      }
      b(paramInt - 1, paramBoolean, localList, localArrayList1);
    }
    return localArrayList1;
  }
  
  protected sfb a()
  {
    if ((rwy.a(this.a) != null) && (rwy.a(this.a).a != null)) {
      return rwy.a(this.a).a.a;
    }
    return null;
  }
  
  protected sfk a(VideoInfo paramVideoInfo)
  {
    return new sfk(paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, paramVideoInfo.jdField_a_of_type_Int, paramVideoInfo.jdField_d_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rxb
 * JD-Core Version:    0.7.0.1
 */