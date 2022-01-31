import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

class qxz
  extends npw
{
  private boolean jdField_a_of_type_Boolean;
  
  private qxz(qxx paramqxx) {}
  
  private void a()
  {
    qxx.a(this.jdField_a_of_type_Qxx).j();
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
    if (paramVideoInfo1.r > 0) {
      paramVideoInfo2.r = paramVideoInfo1.r;
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
    if ((paramVideoInfo2.s <= 0) && (paramVideoInfo1.s > 0)) {
      paramVideoInfo2.s = paramVideoInfo1.s;
    }
    if ((paramVideoInfo2.t <= 0) && (paramVideoInfo1.t > 0)) {
      paramVideoInfo2.t = paramVideoInfo1.t;
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
    if ((TextUtils.isEmpty(paramVideoInfo2.E)) && (!TextUtils.isEmpty(paramVideoInfo1.E))) {
      paramVideoInfo2.E = paramVideoInfo1.E;
    }
    if ((TextUtils.isEmpty(paramVideoInfo2.D)) && (!TextUtils.isEmpty(paramVideoInfo1.D))) {
      paramVideoInfo2.D = paramVideoInfo1.D;
    }
    if ((TextUtils.isEmpty(paramVideoInfo2.G)) && (!TextUtils.isEmpty(paramVideoInfo1.G))) {
      paramVideoInfo2.G = paramVideoInfo1.G;
    }
    if ((TextUtils.isEmpty(paramVideoInfo2.G)) && (!TextUtils.isEmpty(paramVideoInfo1.G))) {
      paramVideoInfo2.G = paramVideoInfo1.G;
    }
    if ((TextUtils.isEmpty(paramVideoInfo2.h)) && (!TextUtils.isEmpty(paramVideoInfo1.h))) {
      paramVideoInfo2.h = paramVideoInfo1.h;
    }
    if (!paramVideoInfo2.jdField_b_of_type_Boolean) {
      paramVideoInfo2.jdField_k_of_type_Boolean = paramVideoInfo1.jdField_k_of_type_Boolean;
    }
    if (!TextUtils.isEmpty(paramVideoInfo1.jdField_b_of_type_JavaLangString)) {
      paramVideoInfo2.jdField_b_of_type_JavaLangString = paramVideoInfo1.jdField_b_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramVideoInfo1.L)) {
      paramVideoInfo2.L = paramVideoInfo1.L;
    }
    if (!TextUtils.isEmpty(paramVideoInfo1.M)) {
      paramVideoInfo2.M = paramVideoInfo1.M;
    }
    paramVideoInfo2.o = 0;
    qol.a(paramVideoInfo2);
  }
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1 = null;
    qxx.a(this.jdField_a_of_type_Qxx).set(false);
    if (!paramBoolean) {
      a();
    }
    for (;;)
    {
      qxx.a(this.jdField_a_of_type_Qxx);
      ArrayList localArrayList;
      do
      {
        return;
        qxx.a(this.jdField_a_of_type_Qxx, paramBundle.getString("VALUE_COOKIE", null));
        localArrayList = paramBundle.getParcelableArrayList("VIDEO_RECOMMEND_LIST");
      } while ((localArrayList == null) || (localArrayList.size() == 0));
      int i = qxx.a(this.jdField_a_of_type_Qxx).size();
      Object localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        VideoInfo localVideoInfo = (VideoInfo)((Iterator)localObject2).next();
        if (qxx.a(this.jdField_a_of_type_Qxx).contains(localVideoInfo.jdField_a_of_type_JavaLangString)) {
          ((Iterator)localObject2).remove();
        }
        if (localVideoInfo.jdField_c_of_type_Boolean) {
          qol.b(localVideoInfo);
        }
        qxx.a(this.jdField_a_of_type_Qxx).add(localVideoInfo.jdField_a_of_type_JavaLangString);
      }
      qxx.a(this.jdField_a_of_type_Qxx).addAll(localArrayList);
      localObject2 = (VideoInfo)paramBundle.getParcelable("VALUE_REQUEST_VIDEO_DETAIL_INFO");
      paramBundle = localObject1;
      if (qxx.a(this.jdField_a_of_type_Qxx).size() > 0) {
        paramBundle = (VideoInfo)qxx.a(this.jdField_a_of_type_Qxx).get(0);
      }
      if ((!this.jdField_a_of_type_Boolean) && (paramBundle != null) && (localObject2 != null))
      {
        if ((paramBundle.g != null) && (paramBundle.g.equals(((VideoInfo)localObject2).g)))
        {
          a(paramBundle, (VideoInfo)localObject2);
          paramBundle.a((VideoInfo)localObject2);
        }
        this.jdField_a_of_type_Boolean = true;
        qxx.a(this.jdField_a_of_type_Qxx).a(0);
      }
      qxx.a(this.jdField_a_of_type_Qxx).a(i, localArrayList.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qxz
 * JD-Core Version:    0.7.0.1
 */