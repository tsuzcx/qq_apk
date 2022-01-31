import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoAdInfo.NegFeedback;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import java.util.ArrayList;

public class nzy
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bfsr jdField_a_of_type_Bfsr;
  private qxc jdField_a_of_type_Qxc;
  
  public nzy(Activity paramActivity, qxc paramqxc)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Qxc = paramqxc;
    this.jdField_a_of_type_Bfsr = new bfsr(paramActivity);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bfsr != null) && (this.jdField_a_of_type_Bfsr.isShowing())) {
      this.jdField_a_of_type_Bfsr.dismiss();
    }
  }
  
  public void a(View paramView, int paramInt, VideoInfo paramVideoInfo)
  {
    nzz localnzz = new nzz(this, paramInt, paramVideoInfo);
    if (!this.jdField_a_of_type_Bfsr.a()) {
      this.jdField_a_of_type_Bfsr.a();
    }
    this.jdField_a_of_type_Bfsr.b = false;
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
      nmf.a(paramVideoInfo.a);
      if (this.jdField_a_of_type_Bfsr.a(paramInt, localArrayList)) {
        this.jdField_a_of_type_Bfsr.a(paramView, localnzz);
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bfsr != null) && (this.jdField_a_of_type_Bfsr.isShowing())) {
      this.jdField_a_of_type_Bfsr.dismiss();
    }
    this.jdField_a_of_type_Bfsr = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzy
 * JD-Core Version:    0.7.0.1
 */