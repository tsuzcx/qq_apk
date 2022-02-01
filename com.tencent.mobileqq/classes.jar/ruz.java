import com.tencent.biz.pubaccount.VideoInfo;
import java.util.ArrayList;
import java.util.List;

class ruz
  extends rsj<VideoInfo>
{
  ruz(ruw paramruw) {}
  
  protected String a()
  {
    return "video_feeds";
  }
  
  protected List<VideoInfo> a()
  {
    return ruw.a(this.a);
  }
  
  public List<sds> a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt >= 0)
    {
      List localList = ruw.a(this.a);
      a(paramInt, paramBoolean, localList, localArrayList);
      b(paramInt - 1, paramBoolean, localList, localArrayList);
    }
    return localArrayList;
  }
  
  protected sdj a()
  {
    if ((ruw.a(this.a) != null) && (ruw.a(this.a).a != null)) {
      return ruw.a(this.a).a.a;
    }
    return null;
  }
  
  protected sds a(VideoInfo paramVideoInfo)
  {
    return new sds(paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, paramVideoInfo.jdField_a_of_type_Int, paramVideoInfo.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ruz
 * JD-Core Version:    0.7.0.1
 */