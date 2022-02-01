package com.tencent.mobileqq.forward;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ImageUtil;

class ForwardPreviewTroopMemberController$TroopMemberViewHolder
  extends ForwardPreviewTroopMemberController.ViewHolder
{
  public ImageView a;
  public TextView a;
  
  public ForwardPreviewTroopMemberController$TroopMemberViewHolder(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_Int = ForwardPreviewTroopMemberController.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368996));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380813));
    paramView.setTag(this);
  }
  
  public void a(String paramString1, String paramString2, IFaceDecoder paramIFaceDecoder)
  {
    Object localObject = paramString2;
    if (paramString2 == null) {
      localObject = paramString1;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(new QQText((CharSequence)localObject, 2));
    localObject = paramIFaceDecoder.getBitmapFromCache(1, paramString1);
    paramString2 = (String)localObject;
    if (localObject == null)
    {
      localObject = ImageUtil.c();
      paramString2 = (String)localObject;
      if (!paramIFaceDecoder.isPausing())
      {
        paramIFaceDecoder.requestDecodeFace(paramString1, 1, false);
        paramString2 = (String)localObject;
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPreviewTroopMemberController.TroopMemberViewHolder
 * JD-Core Version:    0.7.0.1
 */