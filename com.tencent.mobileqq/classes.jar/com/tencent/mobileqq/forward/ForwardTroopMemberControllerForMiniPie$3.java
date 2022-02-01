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
    QLog.i("ForwardTroopMemberControllerForMiniPie", 1, "onDecodeTaskCompleted uin: " + paramString);
    if (ForwardTroopMemberControllerForMiniPie.a(this.a) == null) {}
    while (ForwardTroopMemberControllerForMiniPie.a(this.a).isPausing()) {
      return;
    }
    paramInt2 = ForwardTroopMemberControllerForMiniPie.a(this.a).findFirstVisibleItemPosition();
    int i = ForwardTroopMemberControllerForMiniPie.a(this.a).getChildCount();
    paramInt1 = 1;
    label76:
    if (paramInt1 < i) {
      if (((String)((Pair)ForwardTroopMemberControllerForMiniPie.a(this.a).a.get(paramInt2 + paramInt1 - 1)).first).equals(paramString))
      {
        ForwardTroopMemberControllerForMiniPie.ViewHolder localViewHolder = (ForwardTroopMemberControllerForMiniPie.ViewHolder)ForwardTroopMemberControllerForMiniPie.a(this.a).getChildViewHolder(ForwardTroopMemberControllerForMiniPie.a(this.a).getChildAt(paramInt1));
        if (!(localViewHolder instanceof ForwardTroopMemberControllerForMiniPie.TroopMemberViewHolder)) {
          break label172;
        }
        ((ForwardTroopMemberControllerForMiniPie.TroopMemberViewHolder)localViewHolder).a.setImageBitmap(paramBitmap);
      }
    }
    for (;;)
    {
      paramInt1 += 1;
      break label76;
      break;
      label172:
      QLog.e("ForwardTroopMemberControllerForMiniPie", 2, "onDecodeTaskCompleted viewHolder in wrong instance ! ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardTroopMemberControllerForMiniPie.3
 * JD-Core Version:    0.7.0.1
 */