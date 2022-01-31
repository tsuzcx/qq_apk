import com.tencent.biz.pubaccount.VideoInfo;
import java.util.ArrayList;
import java.util.List;

class qlu
  extends qjj<VideoInfo>
{
  qlu(qlp paramqlp) {}
  
  protected List<VideoInfo> a()
  {
    return qlp.a(this.a);
  }
  
  public List<qui> a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    if (paramInt >= 0)
    {
      List localList = qlp.a(this.a);
      ArrayList localArrayList2;
      if (qlp.a(this.a) != null)
      {
        localArrayList2 = ((VideoInfo)localList.get(qlp.a(this.a).c)).jdField_d_of_type_JavaUtilArrayList;
        if (localArrayList2 != null) {
          a(qlp.a(this.a).b - 1, true, localArrayList2, localArrayList1);
        }
      }
      a(paramInt, paramBoolean, localList, localArrayList1);
      if (qlp.a(this.a) != null)
      {
        localArrayList2 = ((VideoInfo)localList.get(qlp.a(this.a).c)).jdField_d_of_type_JavaUtilArrayList;
        if (localArrayList2 != null) {
          b(qlp.a(this.a).b - 1, false, localArrayList2, localArrayList1);
        }
      }
      b(paramInt - 1, paramBoolean, localList, localArrayList1);
    }
    return localArrayList1;
  }
  
  protected qui a(VideoInfo paramVideoInfo)
  {
    return new qui(paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, paramVideoInfo.jdField_a_of_type_Int, paramVideoInfo.jdField_d_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qlu
 * JD-Core Version:    0.7.0.1
 */