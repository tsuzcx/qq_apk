package com.tencent.mobileqq.matchchat;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;

public class MatchEmptyItemBuilder
  extends RecentItemBaseBuilder
{
  int a;
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramOnClickListener = paramContext.getResources();
    if (paramView == null) {
      paramRecentFaceDecoder = null;
    } else {
      paramRecentFaceDecoder = paramView.getTag();
    }
    if ((paramView != null) && ((paramView.getTag() instanceof MatchEmptyItemBuilder.ViewHolder)))
    {
      paramRecentFaceDecoder = (MatchEmptyItemBuilder.ViewHolder)paramRecentFaceDecoder;
    }
    else
    {
      paramView = LayoutInflater.from(paramContext).inflate(2131627435, null);
      paramRecentFaceDecoder = new MatchEmptyItemBuilder.ViewHolder();
      paramRecentFaceDecoder.a = ((ViewGroup)paramView.findViewById(2131436854));
      paramRecentFaceDecoder.b = ((ThemeImageView)paramView.findViewById(2131435219));
      paramRecentFaceDecoder.c = ((TextView)paramView.findViewById(2131448897));
      paramView.setTag(paramRecentFaceDecoder);
      this.a = (paramOnClickListener.getDimensionPixelSize(2131299068) + paramOnClickListener.getDimensionPixelSize(2131299070) + paramOnClickListener.getDimensionPixelSize(2131299069));
    }
    paramInt = paramViewGroup.getMeasuredHeight();
    int j = this.a;
    int i = paramInt - j;
    paramInt = i;
    if (i < 0) {
      paramInt = (int)(j * 1.5F);
    }
    if ((paramView.getLayoutParams() instanceof AbsListView.LayoutParams)) {
      paramViewGroup = (AbsListView.LayoutParams)paramView.getLayoutParams();
    } else {
      paramViewGroup = new AbsListView.LayoutParams(-1, paramInt);
    }
    paramViewGroup.width = -1;
    paramViewGroup.height = paramInt;
    paramView.setLayoutParams(paramViewGroup);
    if ((paramObject instanceof Integer))
    {
      paramInt = ((Integer)paramObject).intValue();
      if (paramInt == 20)
      {
        paramRecentFaceDecoder.b.setImageResource(2130839590);
        if ((paramRecentFaceDecoder.b.getDrawable() instanceof Animatable)) {
          ((Animatable)paramRecentFaceDecoder.b.getDrawable()).start();
        }
        paramRecentFaceDecoder.c.setText(2131897006);
        return paramView;
      }
      if (paramInt == 21)
      {
        if ((paramRecentFaceDecoder.b.getDrawable() instanceof Animatable)) {
          ((Animatable)paramRecentFaceDecoder.b.getDrawable()).stop();
        }
        paramObject = BitmapManager.a(paramContext.getResources(), 2130846571);
        if (paramObject != null)
        {
          paramRecentFaceDecoder.b.setImageBitmap(paramObject);
          paramRecentFaceDecoder.b.setMaskShape(ThemeImageWrapper.MODE_SQURE);
        }
        else
        {
          QLog.e("MatchEmptyItemBuilder", 1, "image qq_extend_friend_empty_normal decode failed.");
        }
        paramRecentFaceDecoder.c.setText(2131897005);
      }
    }
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchEmptyItemBuilder
 * JD-Core Version:    0.7.0.1
 */