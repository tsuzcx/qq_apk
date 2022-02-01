import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyForCanvasFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoCeilingFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import java.lang.ref.WeakReference;

public class olg
{
  public static GdtHandler.Params a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, olj paramolj)
  {
    if ((paramAdvertisementInfo == null) || (paramActivity == null)) {
      return null;
    }
    GdtHandler.Params localParams = new GdtHandler.Params();
    olj localolj = paramolj;
    if (paramolj == null) {
      localolj = new olj();
    }
    paramolj = ubb.a(paramAdvertisementInfo);
    localParams.c = 1;
    localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(paramolj);
    localParams.jdField_a_of_type_Boolean = localolj.jdField_a_of_type_Boolean;
    localParams.jdField_b_of_type_Boolean = localolj.jdField_b_of_type_Boolean;
    if (paramAdvertisementInfo.clickPos > 0)
    {
      localParams.jdField_b_of_type_Int = paramAdvertisementInfo.clickPos;
      paramAdvertisementInfo.resetClickPos();
    }
    localParams.jdField_a_of_type_Long = localolj.jdField_a_of_type_Long;
    if (ubb.a == null)
    {
      ubb.a = new GdtAppReceiver();
      ubb.a.register(BaseApplicationImpl.getContext());
    }
    localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(ubb.a);
    long l = paramAdvertisementInfo.mChannelID;
    if ((l != 3L) && (l != 4L) && (paramAdvertisementInfo.mAdJumpMode != 6) && (!localolj.d) && (l != 2000001L))
    {
      localParams.jdField_a_of_type_JavaLangClass = ReadInJoyVideoCeilingFragment.class;
      ubb.a(localParams, localolj.c, paramAdvertisementInfo, paramActivity);
    }
    localParams.jdField_b_of_type_JavaLangClass = ReadInJoyForCanvasFragment.class;
    localParams.jdField_a_of_type_AndroidOsBundle = new Bundle();
    localParams.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
    return localParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     olg
 * JD-Core Version:    0.7.0.1
 */