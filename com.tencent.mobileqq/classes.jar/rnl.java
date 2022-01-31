import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

class rnl
  extends ntc
{
  private boolean jdField_a_of_type_Boolean;
  
  private rnl(rnj paramrnj) {}
  
  private void a()
  {
    rnj.a(this.jdField_a_of_type_Rnj).j();
  }
  
  private void a(VideoInfo paramVideoInfo1, VideoInfo paramVideoInfo2)
  {
    if (!TextUtils.isEmpty(paramVideoInfo1.jdField_c_of_type_JavaLangString)) {
      paramVideoInfo2.jdField_c_of_type_JavaLangString = paramVideoInfo1.jdField_c_of_type_JavaLangString;
    }
    if ((paramVideoInfo1.jdField_b_of_type_JavaUtilArrayList != null) && (paramVideoInfo1.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      if (paramVideoInfo2.jdField_b_of_type_JavaUtilArrayList == null) {
        paramVideoInfo2.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      }
      paramVideoInfo2.jdField_b_of_type_JavaUtilArrayList.addAll(paramVideoInfo1.jdField_b_of_type_JavaUtilArrayList);
    }
    if ((paramVideoInfo2.jdField_b_of_type_Long <= 0L) && (paramVideoInfo1.jdField_b_of_type_Long > 0L)) {
      paramVideoInfo2.jdField_b_of_type_Long = paramVideoInfo1.jdField_b_of_type_Long;
    }
    if ((paramVideoInfo1.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (paramVideoInfo2.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null))
    {
      paramVideoInfo2.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramVideoInfo1.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
      paramVideoInfo2.jdField_a_of_type_Int = paramVideoInfo1.jdField_a_of_type_Int;
    }
    if (paramVideoInfo1.jdField_o_of_type_Int > 0) {
      paramVideoInfo2.jdField_o_of_type_Int = paramVideoInfo1.jdField_o_of_type_Int;
    }
    if (paramVideoInfo1.jdField_f_of_type_Long > 0L) {
      paramVideoInfo2.jdField_f_of_type_Long = paramVideoInfo1.jdField_f_of_type_Long;
    }
    if ((paramVideoInfo2.jdField_b_of_type_Int <= 0) && (paramVideoInfo1.jdField_b_of_type_Int > 0)) {
      paramVideoInfo2.jdField_b_of_type_Int = paramVideoInfo1.jdField_b_of_type_Int;
    }
    if ((paramVideoInfo2.jdField_c_of_type_Int <= 0) && (paramVideoInfo1.jdField_c_of_type_Int > 0)) {
      paramVideoInfo2.jdField_c_of_type_Int = paramVideoInfo1.jdField_c_of_type_Int;
    }
    if ((paramVideoInfo2.jdField_d_of_type_Int <= 0) && (paramVideoInfo1.jdField_d_of_type_Int > 0)) {
      paramVideoInfo2.jdField_d_of_type_Int = paramVideoInfo1.jdField_d_of_type_Int;
    }
    if ((paramVideoInfo2.jdField_p_of_type_Int <= 0) && (paramVideoInfo1.jdField_p_of_type_Int > 0)) {
      paramVideoInfo2.jdField_p_of_type_Int = paramVideoInfo1.jdField_p_of_type_Int;
    }
    if ((paramVideoInfo2.q <= 0) && (paramVideoInfo1.q > 0)) {
      paramVideoInfo2.q = paramVideoInfo1.q;
    }
    if (!TextUtils.isEmpty(paramVideoInfo1.i)) {
      paramVideoInfo2.i = paramVideoInfo1.i;
    }
    if ((TextUtils.isEmpty(paramVideoInfo2.jdField_k_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo1.jdField_k_of_type_JavaLangString))) {
      paramVideoInfo2.jdField_k_of_type_JavaLangString = paramVideoInfo1.jdField_k_of_type_JavaLangString;
    }
    if ((TextUtils.isEmpty(paramVideoInfo2.j)) && (!TextUtils.isEmpty(paramVideoInfo1.j))) {
      paramVideoInfo2.j = paramVideoInfo1.j;
    }
    if ((TextUtils.isEmpty(paramVideoInfo2.g)) && (!TextUtils.isEmpty(paramVideoInfo1.g))) {
      paramVideoInfo2.g = paramVideoInfo1.g;
    }
    if ((TextUtils.isEmpty(paramVideoInfo2.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo1.jdField_a_of_type_JavaLangString)))
    {
      paramVideoInfo2.jdField_a_of_type_JavaLangString = paramVideoInfo1.jdField_a_of_type_JavaLangString;
      paramVideoInfo2.jdField_a_of_type_Int = paramVideoInfo1.jdField_a_of_type_Int;
    }
    if ((TextUtils.isEmpty(paramVideoInfo2.jdField_f_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo1.jdField_f_of_type_JavaLangString))) {
      paramVideoInfo2.jdField_f_of_type_JavaLangString = paramVideoInfo1.jdField_f_of_type_JavaLangString;
    }
    if ((TextUtils.isEmpty(paramVideoInfo2.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo1.jdField_d_of_type_JavaLangString))) {
      paramVideoInfo2.jdField_d_of_type_JavaLangString = paramVideoInfo1.jdField_d_of_type_JavaLangString;
    }
    if ((TextUtils.isEmpty(paramVideoInfo2.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo1.jdField_c_of_type_JavaLangString))) {
      paramVideoInfo2.jdField_c_of_type_JavaLangString = paramVideoInfo1.jdField_c_of_type_JavaLangString;
    }
    if ((TextUtils.isEmpty(paramVideoInfo2.n)) && (!TextUtils.isEmpty(paramVideoInfo1.n))) {
      paramVideoInfo2.n = paramVideoInfo1.n;
    }
    if ((TextUtils.isEmpty(paramVideoInfo2.m)) && (!TextUtils.isEmpty(paramVideoInfo1.m))) {
      paramVideoInfo2.m = paramVideoInfo1.m;
    }
    if ((TextUtils.isEmpty(paramVideoInfo2.jdField_p_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo1.jdField_p_of_type_JavaLangString))) {
      paramVideoInfo2.jdField_p_of_type_JavaLangString = paramVideoInfo1.jdField_p_of_type_JavaLangString;
    }
    if ((TextUtils.isEmpty(paramVideoInfo2.jdField_p_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo1.jdField_p_of_type_JavaLangString))) {
      paramVideoInfo2.jdField_p_of_type_JavaLangString = paramVideoInfo1.jdField_p_of_type_JavaLangString;
    }
    if ((TextUtils.isEmpty(paramVideoInfo2.h)) && (!TextUtils.isEmpty(paramVideoInfo1.h))) {
      paramVideoInfo2.h = paramVideoInfo1.h;
    }
    if (!paramVideoInfo2.jdField_b_of_type_Boolean) {
      paramVideoInfo2.jdField_o_of_type_Boolean = paramVideoInfo1.jdField_o_of_type_Boolean;
    }
    if (!TextUtils.isEmpty(paramVideoInfo1.jdField_b_of_type_JavaLangString)) {
      paramVideoInfo2.jdField_b_of_type_JavaLangString = paramVideoInfo1.jdField_b_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramVideoInfo1.w)) {
      paramVideoInfo2.w = paramVideoInfo1.w;
    }
    if (!TextUtils.isEmpty(paramVideoInfo1.x)) {
      paramVideoInfo2.x = paramVideoInfo1.x;
    }
    paramVideoInfo2.jdField_k_of_type_Int = 0;
    rdm.a(paramVideoInfo2);
  }
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1 = null;
    rnj.a(this.jdField_a_of_type_Rnj).set(false);
    if (!paramBoolean) {
      a();
    }
    for (;;)
    {
      rnj.a(this.jdField_a_of_type_Rnj);
      ArrayList localArrayList;
      do
      {
        return;
        rnj.a(this.jdField_a_of_type_Rnj, paramBundle.getString("VALUE_COOKIE", null));
        localArrayList = paramBundle.getParcelableArrayList("VIDEO_RECOMMEND_LIST");
      } while ((localArrayList == null) || (localArrayList.size() == 0));
      int i = rnj.a(this.jdField_a_of_type_Rnj).size();
      Object localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        VideoInfo localVideoInfo = (VideoInfo)((Iterator)localObject2).next();
        if (rnj.a(this.jdField_a_of_type_Rnj).contains(localVideoInfo.jdField_a_of_type_JavaLangString)) {
          ((Iterator)localObject2).remove();
        }
        if (localVideoInfo.jdField_c_of_type_Boolean) {
          rdm.b(localVideoInfo);
        }
        rnj.a(this.jdField_a_of_type_Rnj).add(localVideoInfo.jdField_a_of_type_JavaLangString);
      }
      rnj.a(this.jdField_a_of_type_Rnj).addAll(localArrayList);
      localObject2 = (VideoInfo)paramBundle.getParcelable("VALUE_REQUEST_VIDEO_DETAIL_INFO");
      paramBundle = localObject1;
      if (rnj.a(this.jdField_a_of_type_Rnj).size() > 0) {
        paramBundle = (VideoInfo)rnj.a(this.jdField_a_of_type_Rnj).get(0);
      }
      if ((!this.jdField_a_of_type_Boolean) && (paramBundle != null) && (localObject2 != null))
      {
        if ((paramBundle.g != null) && (paramBundle.g.equals(((VideoInfo)localObject2).g)))
        {
          a(paramBundle, (VideoInfo)localObject2);
          paramBundle.a((VideoInfo)localObject2);
        }
        this.jdField_a_of_type_Boolean = true;
        rnj.a(this.jdField_a_of_type_Rnj).a(0);
      }
      rnj.a(this.jdField_a_of_type_Rnj).a(i, localArrayList.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rnl
 * JD-Core Version:    0.7.0.1
 */