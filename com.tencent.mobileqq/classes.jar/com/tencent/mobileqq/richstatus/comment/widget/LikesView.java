package com.tencent.mobileqq.richstatus.comment.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.richstatus.comment.bean.LikeItem;
import com.tencent.mobileqq.richstatus.comment.bean.User;
import com.tencent.mobileqq.richstatus.comment.spannable.CommentMovementMethod;
import com.tencent.mobileqq.text.QQText;
import java.util.List;

public class LikesView
  extends TextView
{
  private String a = "LikesView";
  private int b;
  private int c;
  private int d;
  private long e;
  private List<LikeItem> f;
  private LikesView.OnItemClickListener g;
  private Drawable h;
  
  public LikesView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public LikesView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
    a(paramAttributeSet);
  }
  
  public LikesView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
    a(paramAttributeSet);
  }
  
  private SpannableString a(String paramString1, String paramString2)
  {
    paramString1 = new SpannableString(paramString1);
    paramString1.setSpan(new LikesView.2(this, this.b, paramString2), 0, paramString1.length(), 33);
    return paramString1;
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.LikesView, 0, 0);
    try
    {
      this.b = paramAttributeSet.getColor(0, getResources().getColor(2131167338));
      this.c = paramAttributeSet.getColor(1, getResources().getColor(2131167910));
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  private void b()
  {
    this.d = getResources().getColor(2131167335);
    this.h = getResources().getDrawable(2130849332);
  }
  
  private SpannableString c()
  {
    SpannableString localSpannableString = new SpannableString("  ");
    int i = AIOUtils.b(20.0F, getResources());
    this.h.setBounds(0, 0, i, i);
    localSpannableString.setSpan(new ImageSpan(this.h, 0), 0, 1, 33);
    return localSpannableString;
  }
  
  public void a()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Object localObject = this.f;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      setVisibility(0);
      localSpannableStringBuilder.append(c());
      int i = 0;
      while (i < this.f.size())
      {
        localObject = (LikeItem)this.f.get(i);
        if (localObject != null)
        {
          localSpannableStringBuilder.append(a(((LikeItem)localObject).b.b, ((LikeItem)localObject).b.a));
          if (i != this.f.size() - 1) {
            localSpannableStringBuilder.append(", ");
          }
        }
        i += 1;
      }
      if (this.e > 1L) {
        localSpannableStringBuilder.append(String.format(getContext().getResources().getString(2131916685), new Object[] { Long.valueOf(this.e) }));
      } else {
        localSpannableStringBuilder.append(getContext().getResources().getString(2131916684));
      }
      setText(new QQText(localSpannableStringBuilder, 3, 12));
      setTextColor(this.d);
      setMovementMethod(new CommentMovementMethod(this.c, getContext().getResources().getColor(2131168376)));
      setOnClickListener(new LikesView.1(this));
      return;
    }
    setVisibility(8);
  }
  
  public void a(List<LikeItem> paramList, long paramLong)
  {
    this.e = paramLong;
    this.f = paramList;
    a();
  }
  
  public Drawable getLikeSpanDrawable()
  {
    return this.h;
  }
  
  public List<LikeItem> getLikes()
  {
    return this.f;
  }
  
  public LikesView.OnItemClickListener getOnItemClickListener()
  {
    return this.g;
  }
  
  public void setItemColor(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setLikSpanDrawable(Drawable paramDrawable)
  {
    this.h = paramDrawable;
  }
  
  public void setNormalTextColor(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setOnItemClickListener(LikesView.OnItemClickListener paramOnItemClickListener)
  {
    this.g = paramOnItemClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.comment.widget.LikesView
 * JD-Core Version:    0.7.0.1
 */