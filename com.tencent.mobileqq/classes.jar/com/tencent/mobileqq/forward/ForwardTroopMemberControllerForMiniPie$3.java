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

class ForwardTroopMemberControllerForMiniPie$3
  implements DecodeTaskCompletionListener
{
  ForwardTroopMemberControllerForMiniPie$3(ForwardTroopMemberControllerForMiniPie paramForwardTroopMemberControllerForMiniPie) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDecodeTaskCompleted uin: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("ForwardTroopMemberControllerForMiniPie", 1, ((StringBuilder)localObject).toString());
    if (ForwardTroopMemberControllerForMiniPie.e(this.a) == null) {
      return;
    }
    if (ForwardTroopMemberControllerForMiniPie.f(this.a).isPausing()) {
      return;
    }
    paramInt2 = ForwardTroopMemberControllerForMiniPie.g(this.a).findFirstVisibleItemPosition();
    int i = ForwardTroopMemberControllerForMiniPie.e(this.a).getChildCount();
    paramInt1 = 1;
    while (paramInt1 < i)
    {
      if (((String)((Pair)ForwardTroopMemberControllerForMiniPie.b(this.a).b.get(paramInt2 + paramInt1 - 1)).first).equals(paramString))
      {
        localObject = (ForwardTroopMemberControllerForMiniPie.ViewHolder)ForwardTroopMemberControllerForMiniPie.e(this.a).getChildViewHolder(ForwardTroopMemberControllerForMiniPie.e(this.a).getChildAt(paramInt1));
        if ((localObject instanceof ForwardTroopMemberControllerForMiniPie.TroopMemberViewHolder)) {
          ((ForwardTroopMemberControllerForMiniPie.TroopMemberViewHolder)localObject).a.setImageBitmap(paramBitmap);
        } else {
          QLog.e("ForwardTroopMemberControllerForMiniPie", 2, "onDecodeTaskCompleted viewHolder in wrong instance ! ");
        }
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardTroopMemberControllerForMiniPie.3
 * JD-Core Version:    0.7.0.1
 */