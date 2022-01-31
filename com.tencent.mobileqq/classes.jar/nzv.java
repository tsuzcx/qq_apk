import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoAdInfo.NegFeedback;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import java.util.ArrayList;

public class nzv
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bfti jdField_a_of_type_Bfti;
  private qwz jdField_a_of_type_Qwz;
  
  public nzv(Activity paramActivity, qwz paramqwz)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Qwz = paramqwz;
    this.jdField_a_of_type_Bfti = new bfti(paramActivity);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bfti != null) && (this.jdField_a_of_type_Bfti.isShowing())) {
      this.jdField_a_of_type_Bfti.dismiss();
    }
  }
  
  public void a(View paramView, int paramInt, VideoInfo paramVideoInfo)
  {
    nzw localnzw = new nzw(this, paramInt, paramVideoInfo);
    if (!this.jdField_a_of_type_Bfti.a()) {
      this.jdField_a_of_type_Bfti.a();
    }
    this.jdField_a_of_type_Bfti.b = false;
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
      nmc.a(paramVideoInfo.a);
      if (this.jdField_a_of_type_Bfti.a(paramInt, localArrayList)) {
        this.jdField_a_of_type_Bfti.a(paramView, localnzw);
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bfti != null) && (this.jdField_a_of_type_Bfti.isShowing())) {
      this.jdField_a_of_type_Bfti.dismiss();
    }
    this.jdField_a_of_type_Bfti = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzv
 * JD-Core Version:    0.7.0.1
 */