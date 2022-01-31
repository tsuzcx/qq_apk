import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuEditText;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;

public class okr
  implements appt
{
  public okr(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void a(appw paramappw)
  {
    if ((paramappw instanceof aptm))
    {
      paramappw = (aptm)paramappw;
      Context localContext = ReadInJoyCommentComponentFragment.a(this.a).getApplicationContext();
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramappw.a(localContext, localContext.getResources().getDisplayMetrics().density));
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      ReadInJoyCommentComponentFragment.a(this.a);
      return;
    }
    ReadInJoyBaseDeliverActivity.a(ReadInJoyCommentComponentFragment.a(this.a).app, paramappw, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText);
  }
  
  public void a(appw paramappw1, appw paramappw2, Drawable paramDrawable) {}
  
  public boolean a(appw paramappw)
  {
    return true;
  }
  
  public void b()
  {
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getSelectionStart() == 0) {}
    for (;;)
    {
      return;
      try
      {
        Editable localEditable = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getText();
        int i = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getSelectionStart();
        int j = TextUtils.getOffsetBefore(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getText(), i);
        if (i != j)
        {
          localEditable.delete(Math.min(i, j), Math.max(i, j));
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void b(appw paramappw) {}
  
  public void c() {}
  
  public void d() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okr
 * JD-Core Version:    0.7.0.1
 */