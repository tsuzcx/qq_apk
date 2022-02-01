package com.tencent.mobileqq.troop.widget;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.QLog;

class AddedRobotView$1
  implements DecodeTaskCompletionListener
{
  AddedRobotView$1(AddedRobotView paramAddedRobotView) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDecodeTaskCompleted uin: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("AddedRobotView", 1, ((StringBuilder)localObject).toString());
    if (AddedRobotView.c(this.a) == null) {
      return;
    }
    if (AddedRobotView.b(this.a).isPausing()) {
      return;
    }
    paramInt1 = 0;
    paramInt2 = AddedRobotView.c(this.a).getChildCount();
    while (paramInt1 < paramInt2)
    {
      localObject = AddedRobotView.c(this.a).getChildViewHolder(AddedRobotView.c(this.a).getChildAt(paramInt1));
      if ((localObject instanceof AddedRobotView.RobotListAdapter.RobotViewHolder))
      {
        localObject = (AddedRobotView.RobotListAdapter.RobotViewHolder)localObject;
        if ((!TextUtils.isEmpty(((AddedRobotView.RobotListAdapter.RobotViewHolder)localObject).d)) && (((AddedRobotView.RobotListAdapter.RobotViewHolder)localObject).d.equals(paramString))) {
          ((AddedRobotView.RobotListAdapter.RobotViewHolder)localObject).b.setImageBitmap(paramBitmap);
        }
      }
      else
      {
        QLog.i("AddedRobotView", 2, "onDecodeTaskCompleted viewHolder correct uin not found ! ");
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AddedRobotView.1
 * JD-Core Version:    0.7.0.1
 */