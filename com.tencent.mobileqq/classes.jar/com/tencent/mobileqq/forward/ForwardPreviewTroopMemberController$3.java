package com.tencent.mobileqq.forward;

import android.graphics.Bitmap;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.widget.ImageView;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ForwardPreviewTroopMemberController$3
  implements DecodeTaskCompletionListener
{
  ForwardPreviewTroopMemberController$3(ForwardPreviewTroopMemberController paramForwardPreviewTroopMemberController) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    QLog.i("Forward.Preview.Dialog", 1, "onDecodeTaskCompleted uin: " + paramString);
    if (ForwardPreviewTroopMemberController.a(this.a) == null) {}
    while (ForwardPreviewTroopMemberController.a(this.a).isPausing()) {
      return;
    }
    paramInt2 = ForwardPreviewTroopMemberController.a(this.a).findFirstVisibleItemPosition();
    int i = ForwardPreviewTroopMemberController.a(this.a).getChildCount();
    paramInt1 = 1;
    label76:
    if (paramInt1 < i) {
      if (((String)((Pair)ForwardPreviewTroopMemberController.a(this.a).a.get(paramInt2 + paramInt1 - 1)).first).equals(paramString))
      {
        ForwardPreviewTroopMemberController.ViewHolder localViewHolder = (ForwardPreviewTroopMemberController.ViewHolder)ForwardPreviewTroopMemberController.a(this.a).getChildViewHolder(ForwardPreviewTroopMemberController.a(this.a).getChildAt(paramInt1));
        if (!(localViewHolder instanceof ForwardPreviewTroopMemberController.TroopMemberViewHolder)) {
          break label172;
        }
        ((ForwardPreviewTroopMemberController.TroopMemberViewHolder)localViewHolder).a.setImageBitmap(paramBitmap);
      }
    }
    for (;;)
    {
      paramInt1 += 1;
      break label76;
      break;
      label172:
      QLog.e("Forward.Preview.Dialog", 2, "onDecodeTaskCompleted viewHolder in wrong instance ! ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPreviewTroopMemberController.3
 * JD-Core Version:    0.7.0.1
 */