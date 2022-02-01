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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDecodeTaskCompleted uin: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("Forward.Preview.Dialog", 1, ((StringBuilder)localObject).toString());
    if (ForwardPreviewTroopMemberController.d(this.a) == null) {
      return;
    }
    if (ForwardPreviewTroopMemberController.e(this.a).isPausing()) {
      return;
    }
    paramInt2 = ForwardPreviewTroopMemberController.f(this.a).findFirstVisibleItemPosition();
    int i = ForwardPreviewTroopMemberController.d(this.a).getChildCount();
    paramInt1 = 1;
    while (paramInt1 < i)
    {
      if (((String)((Pair)ForwardPreviewTroopMemberController.b(this.a).c.get(paramInt2 + paramInt1 - 1)).first).equals(paramString))
      {
        localObject = (ForwardPreviewTroopMemberController.ViewHolder)ForwardPreviewTroopMemberController.d(this.a).getChildViewHolder(ForwardPreviewTroopMemberController.d(this.a).getChildAt(paramInt1));
        if ((localObject instanceof ForwardPreviewTroopMemberController.TroopMemberViewHolder)) {
          ((ForwardPreviewTroopMemberController.TroopMemberViewHolder)localObject).a.setImageBitmap(paramBitmap);
        } else {
          QLog.e("Forward.Preview.Dialog", 2, "onDecodeTaskCompleted viewHolder in wrong instance ! ");
        }
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPreviewTroopMemberController.3
 * JD-Core Version:    0.7.0.1
 */