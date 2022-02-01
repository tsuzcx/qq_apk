package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.utils.IImageLoader;
import com.tencent.mobileqq.nearby.now.view.presenter.impl.CommentsPresenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class CommentsAdapter
  extends BaseAdapter
{
  public boolean a;
  private final String b = "CommentsAdapter";
  private int c = 1;
  private int d = 2;
  private LayoutInflater e;
  private Comments f;
  private VideoData g;
  private CommentsPresenter h;
  private Context i;
  private Paint j;
  private int k;
  private boolean l = false;
  
  public CommentsAdapter(Context paramContext, Comments paramComments, VideoData paramVideoData, CommentsPresenter paramCommentsPresenter, Paint paramPaint, int paramInt)
  {
    this.i = paramContext;
    this.e = LayoutInflater.from(paramContext);
    this.f = paramComments;
    this.g = paramVideoData;
    this.h = paramCommentsPresenter;
    this.j = paramPaint;
    this.k = paramInt;
  }
  
  public Comments.Comment a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.f.c.size())) {
      return (Comments.Comment)this.f.c.get(paramInt);
    }
    return null;
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public boolean a(Comments.Comment paramComment)
  {
    return this.f.a(paramComment);
  }
  
  public int getCount()
  {
    if ((this.f.c != null) && (this.f.c.size() > 0)) {
      return this.f.c.size();
    }
    return 1;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getview position is: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("CommentsAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.f.c != null) && (this.f.c.size() > 0))
    {
      if ((paramView != null) && ((paramView.getTag() instanceof CommentsViewHolder)))
      {
        localObject = (CommentsViewHolder)paramView.getTag();
        paramViewGroup = paramView;
        paramView = (View)localObject;
      }
      else
      {
        paramView = new CommentsViewHolder();
        paramViewGroup = this.e.inflate(2131627559, paramViewGroup, false);
        paramView.a = ((ImageView)paramViewGroup.findViewById(2131436330));
        paramView.b = ((TextView)paramViewGroup.findViewById(2131448598));
        paramView.c = ((TextView)paramViewGroup.findViewById(2131448353));
        paramView.d = ((TextView)paramViewGroup.findViewById(2131448664));
        paramView.e = ((ImageView)paramViewGroup.findViewById(2131435124));
        paramView.f = ((ImageView)paramViewGroup.findViewById(2131432793));
        paramView.g = ((ImageView)paramViewGroup.findViewById(2131447727));
        paramViewGroup.setTag(2131431080, paramView);
      }
      paramView.b.setText(((Comments.Comment)this.f.c.get(paramInt)).e);
      if ((((Comments.Comment)this.f.c.get(paramInt)).k <= 0L) && (((Comments.Comment)this.f.c.get(paramInt)).n <= 0L)) {
        paramView.a(((Comments.Comment)this.f.c.get(paramInt)).b);
      } else {
        paramView.a(((Comments.Comment)this.f.c.get(paramInt)).j, ((Comments.Comment)this.f.c.get(paramInt)).b);
      }
      paramView.a(((Comments.Comment)this.f.c.get(paramInt)).c);
      localObject = ((BaseActivity)this.i).app;
      String str1 = ((Comments.Comment)this.f.c.get(paramInt)).g;
      String str2 = String.valueOf(((Comments.Comment)this.f.c.get(paramInt)).f);
      if (((str1 == null) || (str1.isEmpty())) && (str2.equals(((QQAppInterface)localObject).getCurrentAccountUin())))
      {
        localObject = FaceDrawable.getFaceDrawable((AppInterface)localObject, 32, str2, 3, paramView.a.getResources().getDrawable(2130847053), paramView.a.getResources().getDrawable(2130847053));
        paramView.a.setImageDrawable((Drawable)localObject);
      }
      else
      {
        ((IImageLoader)QRoute.api(IImageLoader.class)).displayImage(paramView.a, ((Comments.Comment)this.f.c.get(paramInt)).g, paramView.a.getResources().getDrawable(2130847053), paramView.a.getResources().getDrawable(2130847053), null, true);
      }
      paramView.a(((Comments.Comment)this.f.c.get(paramInt)).o, this.k, this.j, this.l);
      long l1 = ((Comments.Comment)this.f.c.get(paramInt)).f;
      long l2 = ((Comments.Comment)this.f.c.get(paramInt)).i;
      long l3 = ((Comments.Comment)this.f.c.get(paramInt)).h;
      paramView.a.setOnClickListener(new CommentsAdapter.1(this, l1, l2, l3));
      if (((Comments.Comment)this.f.c.get(paramInt)).d == 2) {
        paramView.g.setVisibility(0);
      }
      paramViewGroup.setTag(2131431072, this.f.c.get(paramInt));
      paramViewGroup.setTag(2131431126, this.f);
      return paramViewGroup;
    }
    if (this.g.a())
    {
      paramView = new View(this.i);
      paramView.setLayoutParams(new AbsListView.LayoutParams(0, 0));
      return paramView;
    }
    if (this.a)
    {
      if ((paramView == null) || (!(paramView.getTag() instanceof String)) || (!"badnet".equals((String)paramView.getTag()))) {
        paramView = this.e.inflate(2131627549, paramViewGroup, false);
      }
      paramView.setBackgroundColor(Color.parseColor("#ffffff"));
      paramView.findViewById(2131437546).setOnClickListener(new CommentsAdapter.2(this));
      paramView.setTag("badnet");
      return paramView;
    }
    if ((paramView != null) && ((paramView.getTag() instanceof String)) && ("empty".equals((String)paramView.getTag()))) {
      return paramView;
    }
    paramView = this.e.inflate(2131627550, paramViewGroup, false);
    paramView.setTag("empty");
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.CommentsAdapter
 * JD-Core Version:    0.7.0.1
 */