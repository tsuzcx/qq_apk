import com.tencent.biz.pubaccount.VideoInfo;
import java.util.ArrayList;
import java.util.List;

class pzt
  extends pxo<VideoInfo>
{
  pzt(pzs parampzs) {}
  
  protected List<VideoInfo> a()
  {
    return pzs.a(this.a);
  }
  
  public List<qig> a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    if (paramInt >= 0)
    {
      List localList = pzs.a(this.a);
      ArrayList localArrayList2;
      if (pzs.a(this.a) != null)
      {
        localArrayList2 = ((VideoInfo)localList.get(pzs.a(this.a).c)).jdField_d_of_type_JavaUtilArrayList;
        if (localArrayList2 != null) {
          a(pzs.a(this.a).b - 1, true, localArrayList2, localArrayList1);
        }
      }
      a(paramInt, paramBoolean, localList, localArrayList1);
      if (pzs.a(this.a) != null)
      {
        localArrayList2 = ((VideoInfo)localList.get(pzs.a(this.a).c)).jdField_d_of_type_JavaUtilArrayList;
        if (localArrayList2 != null) {
          b(pzs.a(this.a).b - 1, false, localArrayList2, localArrayList1);
        }
      }
      b(paramInt - 1, paramBoolean, localList, localArrayList1);
    }
    return localArrayList1;
  }
  
  protected qig a(VideoInfo paramVideoInfo)
  {
    return new qig(paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, paramVideoInfo.jdField_a_of_type_Int, paramVideoInfo.jdField_d_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pzt
 * JD-Core Version:    0.7.0.1
 */