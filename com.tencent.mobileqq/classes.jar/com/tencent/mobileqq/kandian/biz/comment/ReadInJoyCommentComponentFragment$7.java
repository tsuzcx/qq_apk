package com.tencent.mobileqq.kandian.biz.comment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.kandian.biz.biu.BiuEditText;
import com.tencent.mobileqq.kandian.biz.comment.emotion.util.RIJEmotionUtil;

class ReadInJoyCommentComponentFragment$7
  implements EmoticonCallback
{
  ReadInJoyCommentComponentFragment$7(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void delete()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText.getSelectionStart() == 0) {
      return;
    }
    try
    {
      Editable localEditable = this.a.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText.getText();
      int i = this.a.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText.getSelectionStart();
      int j = TextUtils.getOffsetBefore(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText.getText(), i);
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
    if ((paramEmoticonInfo instanceof IPicEmoticonInfo))
    {
      paramEmoticonInfo = (IPicEmoticonInfo)paramEmoticonInfo;
      Context localContext = ReadInJoyCommentComponentFragment.a(this.a).getApplicationContext();
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramEmoticonInfo.getBigDrawable(localContext, localContext.getResources().getDisplayMetrics().density));
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      ReadInJoyCommentComponentFragment.a(this.a);
      return;
    }
    RIJEmotionUtil.a(ReadInJoyCommentComponentFragment.a(this.a).app, paramEmoticonInfo, this.a.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText);
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentComponentFragment.7
 * JD-Core Version:    0.7.0.1
 */