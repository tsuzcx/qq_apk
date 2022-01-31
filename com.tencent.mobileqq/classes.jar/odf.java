import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoAdInfo.NegFeedback;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import java.util.ArrayList;

public class odf
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bhym jdField_a_of_type_Bhym;
  private rmo jdField_a_of_type_Rmo;
  
  public odf(Activity paramActivity, rmo paramrmo)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Rmo = paramrmo;
    this.jdField_a_of_type_Bhym = new bhym(paramActivity);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bhym != null) && (this.jdField_a_of_type_Bhym.isShowing())) {
      this.jdField_a_of_type_Bhym.dismiss();
    }
  }
  
  public void a(View paramView, int paramInt, VideoInfo paramVideoInfo)
  {
    odg localodg = new odg(this, paramInt, paramVideoInfo);
    if (!this.jdField_a_of_type_Bhym.a()) {
      this.jdField_a_of_type_Bhym.a();
    }
    this.jdField_a_of_type_Bhym.b = false;
    ArrayList localArrayList = new ArrayList();
    if ((paramVideoInfo.a != null) && (paramVideoInfo.a.e != null))
    {
      int i = 0;
      while (i < paramVideoInfo.a.e.size())
      {
        DislikeInfo localDislikeInfo = new DislikeInfo();
        localDislikeInfo.jdField_a_of_type_Long = ((VideoAdInfo.NegFeedback)paramVideoInfo.a.e.get(i)).jdField_a_of_type_Long;
        localDislikeInfo.jdField_a_of_type_JavaLangString = ((VideoAdInfo.NegFeedback)paramVideoInfo.a.e.get(i)).jdField_a_of_type_JavaLangString;
        localArrayList.add(localDislikeInfo);
        i += 1;
      }
    }
    if (localArrayList.size() > 0)
    {
      noy.a(paramVideoInfo.a);
      if (this.jdField_a_of_type_Bhym.a(paramInt, localArrayList)) {
        this.jdField_a_of_type_Bhym.a(paramView, localodg);
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bhym != null) && (this.jdField_a_of_type_Bhym.isShowing())) {
      this.jdField_a_of_type_Bhym.dismiss();
    }
    this.jdField_a_of_type_Bhym = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     odf
 * JD-Core Version:    0.7.0.1
 */