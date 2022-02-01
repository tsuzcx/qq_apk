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
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;

public class pal
  implements EmoticonCallback
{
  public pal(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void delete()
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
  
  public void emoticonMall() {}
  
  public void onHidePopup(EmoticonInfo paramEmoticonInfo) {}
  
  public boolean onLongClick(EmoticonInfo paramEmoticonInfo)
  {
    return true;
  }
  
  public void onShowPopup(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void send() {}
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo instanceof PicEmoticonInfo))
    {
      paramEmoticonInfo = (PicEmoticonInfo)paramEmoticonInfo;
      Context localContext = ReadInJoyCommentComponentFragment.a(this.a).getApplicationContext();
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramEmoticonInfo.getBigDrawable(localContext, localContext.getResources().getDisplayMetrics().density));
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      ReadInJoyCommentComponentFragment.a(this.a);
      return;
    }
    ReadInJoyBaseDeliverActivity.a(ReadInJoyCommentComponentFragment.a(this.a).app, paramEmoticonInfo, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText);
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pal
 * JD-Core Version:    0.7.0.1
 */