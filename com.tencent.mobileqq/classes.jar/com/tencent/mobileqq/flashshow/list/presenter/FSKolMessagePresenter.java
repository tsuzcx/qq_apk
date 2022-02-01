package com.tencent.mobileqq.flashshow.list.presenter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.flashshow.widgets.common.FSAsyncTextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StNotice;

public class FSKolMessagePresenter
  extends FSBaseMessagePresenter
{
  private Drawable q;
  
  public FSKolMessagePresenter(int paramInt)
  {
    super(paramInt);
  }
  
  void b(Context paramContext, View paramView)
  {
    this.h.setOnClickListener(new FSKolMessagePresenter.1(this, paramContext));
    if (this.b != null)
    {
      paramContext = (LinearLayout.LayoutParams)this.b.getLayoutParams();
      paramContext.rightMargin = ImmersiveUtils.dpToPx(16.0F);
      this.b.setLayoutParams(paramContext);
    }
  }
  
  void b(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    if ((paramStNotice != null) && (paramStNotice.message.get() != null))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      paramStNotice = paramStNotice.feed.content.get();
      localSpannableStringBuilder.append(paramStNotice);
      String str = this.c.getString(2131889719);
      localSpannableStringBuilder.append(str);
      localSpannableStringBuilder.setSpan(new StyleSpan(1), paramStNotice.length(), paramStNotice.length() + str.length(), 33);
      if (this.q == null)
      {
        this.q = this.h.getContext().getResources().getDrawable(2130840410);
        this.q.setBounds(0, ImmersiveUtils.dpToPx(1.5F), ImmersiveUtils.dpToPx(14.0F), ImmersiveUtils.dpToPx(14.0F));
      }
      this.h.a(localSpannableStringBuilder, localSpannableStringBuilder.length(), this.q);
      this.h.setText(localSpannableStringBuilder);
      this.h.setVisibility(0);
      return;
    }
    this.h.setVisibility(8);
  }
  
  void c() {}
  
  protected String f()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.presenter.FSKolMessagePresenter
 * JD-Core Version:    0.7.0.1
 */