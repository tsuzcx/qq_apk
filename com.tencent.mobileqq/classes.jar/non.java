import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoAdInfo.NegFeedback;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import java.util.ArrayList;

public class non
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bekx jdField_a_of_type_Bekx;
  private qkx jdField_a_of_type_Qkx;
  
  public non(Activity paramActivity, qkx paramqkx)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Qkx = paramqkx;
    this.jdField_a_of_type_Bekx = new bekx(paramActivity);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bekx != null) && (this.jdField_a_of_type_Bekx.isShowing())) {
      this.jdField_a_of_type_Bekx.dismiss();
    }
  }
  
  public void a(View paramView, int paramInt, VideoInfo paramVideoInfo)
  {
    noo localnoo = new noo(this, paramInt, paramVideoInfo);
    if (!this.jdField_a_of_type_Bekx.a()) {
      this.jdField_a_of_type_Bekx.a();
    }
    this.jdField_a_of_type_Bekx.b = false;
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
      nbe.a(paramVideoInfo.a);
      if (this.jdField_a_of_type_Bekx.a(paramInt, localArrayList)) {
        this.jdField_a_of_type_Bekx.a(paramView, localnoo);
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bekx != null) && (this.jdField_a_of_type_Bekx.isShowing())) {
      this.jdField_a_of_type_Bekx.dismiss();
    }
    this.jdField_a_of_type_Bekx = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     non
 * JD-Core Version:    0.7.0.1
 */