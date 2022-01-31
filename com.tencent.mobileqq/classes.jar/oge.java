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

public class oge
  implements anyg
{
  public oge(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void a(anyh paramanyh)
  {
    if ((paramanyh instanceof aobp))
    {
      paramanyh = (aobp)paramanyh;
      Context localContext = ReadInJoyCommentComponentFragment.a(this.a).getApplicationContext();
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramanyh.a(localContext, localContext.getResources().getDisplayMetrics().density));
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      ReadInJoyCommentComponentFragment.a(this.a);
      return;
    }
    ReadInJoyBaseDeliverActivity.a(ReadInJoyCommentComponentFragment.a(this.a).app, paramanyh, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText);
  }
  
  public void a(anyh paramanyh1, anyh paramanyh2, Drawable paramDrawable) {}
  
  public boolean a(anyh paramanyh)
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
  
  public void b(anyh paramanyh) {}
  
  public void c() {}
  
  public void d() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     oge
 * JD-Core Version:    0.7.0.1
 */