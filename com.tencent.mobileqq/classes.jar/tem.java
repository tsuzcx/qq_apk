import UserGrowth.stFollowFeedsRsp;
import java.util.ArrayList;

class tem
  implements tgt
{
  tem(tel paramtel, boolean paramBoolean1, boolean paramBoolean2, teo paramteo, int paramInt) {}
  
  public void a(the paramthe)
  {
    if ((this.jdField_a_of_type_Boolean) || (this.b)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = paramthe.a();
      if (this.jdField_a_of_type_Teo != null) {
        this.jdField_a_of_type_Teo.a(this.b, bool2, paramthe.jdField_a_of_type_JavaLangObject);
      }
      if (bool2) {
        break;
      }
      tlo.d("FollowRequest", "[WSFeedDataManager.java][onTaskResponse] task fail, code: " + paramthe.jdField_a_of_type_Int + ", msg: " + paramthe.jdField_a_of_type_JavaLangString);
      return;
    }
    if (!(paramthe.jdField_a_of_type_JavaLangObject instanceof stFollowFeedsRsp))
    {
      tlo.d("FollowRequest", "[WSFeedDataManager.java][onTaskResponse] data error: " + paramthe.jdField_a_of_type_JavaLangObject);
      return;
    }
    stFollowFeedsRsp localstFollowFeedsRsp = (stFollowFeedsRsp)paramthe.jdField_a_of_type_JavaLangObject;
    this.jdField_a_of_type_Tel.jdField_a_of_type_JavaLangString = localstFollowFeedsRsp.attatch_info;
    this.jdField_a_of_type_Tel.jdField_a_of_type_Int = localstFollowFeedsRsp.cache_size;
    if (paramthe.jdField_a_of_type_Tgu != null) {
      tee.a().a(localstFollowFeedsRsp.trace_id, paramthe.jdField_a_of_type_Tgu.a);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Tel.b = localstFollowFeedsRsp.feeds_source;
      tjt.a(this.jdField_a_of_type_Tel.b);
    }
    if (tlf.a(localstFollowFeedsRsp.feeds))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[WSFeedDataManager.java][onTaskResponse] data empty: ");
      if (localstFollowFeedsRsp.feeds == null) {}
      for (paramthe = "null";; paramthe = "size = 0")
      {
        tlo.e("FollowRequest", paramthe);
        return;
      }
    }
    tlo.e("FollowRequest", "[WSFeedDataManager.java][onTaskResponse] data received, size: " + localstFollowFeedsRsp.feeds.size());
    tel.a(this.jdField_a_of_type_Tel, localstFollowFeedsRsp.feeds, bool1, this.jdField_a_of_type_Int, localstFollowFeedsRsp.is_finished, this.jdField_a_of_type_Teo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tem
 * JD-Core Version:    0.7.0.1
 */