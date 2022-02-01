package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyNickNameTextView;
import java.util.List;

public class ReadInJoyPrivacyListAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private Context a;
  private List<Long> b;
  
  public ReadInJoyPrivacyListAdapter(Context paramContext, List<Long> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public int getCount()
  {
    List localList = this.b;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    List localList = this.b;
    View localView = null;
    if (localList != null)
    {
      if (localList.size() <= paramInt) {
        return null;
      }
      if (paramView == null)
      {
        localView = LayoutInflater.from(this.a).inflate(2131626305, paramViewGroup, false);
        paramViewGroup = new ReadInJoyPrivacyListAdapter.PrivacyItemViewHolder();
        paramViewGroup.a = ((LinearLayout)localView.findViewById(2131445148));
        paramViewGroup.b = ((ReadInJoyHeadImageView)localView.findViewById(2131436404));
        paramViewGroup.c = ((ReadInJoyNickNameTextView)localView.findViewById(2131448606));
        localView.setTag(paramViewGroup);
      }
      else
      {
        paramViewGroup = localView;
        localView = paramView;
        if ((paramView.getTag() instanceof ReadInJoyPrivacyListAdapter.PrivacyItemViewHolder))
        {
          paramViewGroup = (ReadInJoyPrivacyListAdapter.PrivacyItemViewHolder)paramView.getTag();
          localView = paramView;
        }
      }
      if (paramViewGroup != null)
      {
        long l = ((Long)this.b.get(paramInt)).longValue();
        paramViewGroup.b.setHeadImgByUin(l);
        paramViewGroup.c.setNickNameByUin(l);
        paramViewGroup.a.setTag(2131444312, Integer.valueOf(paramInt));
        paramViewGroup.a.setOnClickListener(this);
      }
      return localView;
    }
    return null;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131445148) {
      return;
    }
    if (paramView.getTag(2131444312) != null)
    {
      int i = ((Integer)paramView.getTag(2131444312)).intValue();
      paramView = this.b;
      if ((paramView != null) && (paramView.size() > i)) {
        ReadInJoyCommentUtils.a(String.valueOf(this.b.get(i)), this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyPrivacyListAdapter
 * JD-Core Version:    0.7.0.1
 */