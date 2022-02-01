package com.tencent.mobileqq.qqexpand.feed;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo;
import com.tencent.mobileqq.qqexpand.fragment.SquareItemClickListener;
import com.tencent.mobileqq.qqexpand.utils.ProfileGuideDialogUtils;

public class FooterViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private final SquareItemClickListener a;
  private final TextView b;
  
  public FooterViewHolder(View paramView, SquareItemClickListener paramSquareItemClickListener)
  {
    super(paramView);
    this.a = paramSquareItemClickListener;
    this.b = ((TextView)paramView.findViewById(2131448960));
    this.b.setOnClickListener(this);
    this.b.setOnTouchListener(ProfileGuideDialogUtils.a);
  }
  
  public void a(FooterViewHolder paramFooterViewHolder, StrangerInfo paramStrangerInfo)
  {
    int i = paramStrangerInfo.mFooterType;
    boolean bool = false;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          paramStrangerInfo = "";
        } else {
          paramStrangerInfo = HardCodeUtil.a(2131902712);
        }
      }
      else
      {
        paramStrangerInfo = HardCodeUtil.a(2131902713);
        bool = true;
      }
    }
    else {
      paramStrangerInfo = HardCodeUtil.a(2131902711);
    }
    paramFooterViewHolder.b.setText(paramStrangerInfo);
    paramFooterViewHolder.b.setEnabled(bool);
  }
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    if (paramView != null) {
      paramView.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.feed.FooterViewHolder
 * JD-Core Version:    0.7.0.1
 */