package com.tencent.mobileqq.forward;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ImageUtil;

class ForwardTroopMemberControllerForMiniPie$TroopMemberViewHolder
  extends ForwardTroopMemberControllerForMiniPie.ViewHolder
{
  public ImageView a;
  public TextView b;
  
  public ForwardTroopMemberControllerForMiniPie$TroopMemberViewHolder(View paramView)
  {
    super(paramView);
    this.c = ForwardTroopMemberControllerForMiniPie.a;
    this.a = ((ImageView)paramView.findViewById(2131435631));
    this.b = ((TextView)paramView.findViewById(2131448989));
    paramView.setTag(this);
  }
  
  public void a(String paramString1, String paramString2, IFaceDecoder paramIFaceDecoder)
  {
    Object localObject = paramString2;
    if (paramString2 == null) {
      localObject = paramString1;
    }
    this.b.setText(new QQText((CharSequence)localObject, 2));
    localObject = paramIFaceDecoder.getBitmapFromCache(1, paramString1);
    paramString2 = (String)localObject;
    if (localObject == null)
    {
      localObject = ImageUtil.k();
      paramString2 = (String)localObject;
      if (!paramIFaceDecoder.isPausing())
      {
        paramIFaceDecoder.requestDecodeFace(paramString1, 1, false);
        paramString2 = (String)localObject;
      }
    }
    this.a.setImageBitmap(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardTroopMemberControllerForMiniPie.TroopMemberViewHolder
 * JD-Core Version:    0.7.0.1
 */