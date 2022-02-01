import com.tencent.biz.pubaccount.VideoInfo;
import java.util.ArrayList;
import java.util.List;

class shn
  extends sey<VideoInfo>
{
  shn(shl paramshl) {}
  
  protected String a()
  {
    return "video_feeds";
  }
  
  protected List<VideoInfo> a()
  {
    return shl.a(this.a);
  }
  
  public List<spw> a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt >= 0)
    {
      List localList = shl.a(this.a);
      a(paramInt, paramBoolean, localList, localArrayList);
      b(paramInt - 1, paramBoolean, localList, localArrayList);
    }
    return localArrayList;
  }
  
  protected spn a()
  {
    if ((shl.a(this.a) != null) && (shl.a(this.a).a != null)) {
      return shl.a(this.a).a.a;
    }
    return null;
  }
  
  protected spw a(VideoInfo paramVideoInfo)
  {
    return new spw(paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, paramVideoInfo.jdField_a_of_type_Int, paramVideoInfo.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     shn
 * JD-Core Version:    0.7.0.1
 */