package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.pts.ReadInJoyModelImpl;
import com.tencent.mobileqq.kandian.biz.ugc.voice.ReadInJoyVoicePlayController.IPlayCallback;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.handler.UGCVoiceInfo;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;

public class ComponentContentUGCVoice
  extends LinearLayout
  implements ComponentInheritView, ReadInJoyVoicePlayController.IPlayCallback
{
  public static final String a = "ComponentContentUGCVoice";
  private LinearLayout b;
  private TextView c;
  private ImageView d;
  private AbsBaseArticleInfo e;
  private UGCVoiceInfo f;
  
  public ComponentContentUGCVoice(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131626186, this, true);
  }
  
  public void a(View paramView)
  {
    this.b = ((LinearLayout)paramView.findViewById(2131449041));
    this.c = ((TextView)paramView.findViewById(2131449042));
    this.d = ((ImageView)paramView.findViewById(2131449040));
    this.b.setOnClickListener(new ComponentContentUGCVoice.1(this));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener) {}
  
  public void a(UGCVoiceInfo paramUGCVoiceInfo)
  {
    if (paramUGCVoiceInfo == this.f)
    {
      this.d.setImageResource(2130851527);
      ((AnimationDrawable)this.d.getDrawable()).start();
    }
  }
  
  public void a(Object paramObject)
  {
    this.e = ((ReadInJoyModelImpl)paramObject).k();
    paramObject = this.e;
    if ((paramObject != null) && (paramObject.mSocialFeedInfo != null) && (this.e.mSocialFeedInfo.s != null))
    {
      if (this.e.mSocialFeedInfo.s.d == null) {
        return;
      }
      paramObject = this.e.mSocialFeedInfo.s.d;
      if (paramObject.isEmpty()) {
        return;
      }
      int i;
      if (this.e.mFeedType == 1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if ((getParent() != null) && (getParent().getParent() != null)) {
          ((View)getParent().getParent()).setBackgroundColor(-460552);
        }
      }
      else if ((getParent() != null) && (getParent().getParent() != null)) {
        ((View)getParent().getParent()).setBackgroundColor(-1);
      }
      this.b.setVisibility(0);
      this.f = ((UGCVoiceInfo)paramObject.get(0));
      this.c.setText(String.format("%02d″", new Object[] { Integer.valueOf(this.f.duration) }));
      paramObject = (LinearLayout.LayoutParams)this.b.getLayoutParams();
      if (this.f.duration > 50) {
        paramObject.width = DisplayUtil.a(getContext(), 277.0F);
      } else if (this.f.duration > 40) {
        paramObject.width = DisplayUtil.a(getContext(), 237.0F);
      } else if (this.f.duration > 30) {
        paramObject.width = DisplayUtil.a(getContext(), 197.0F);
      } else if (this.f.duration > 20) {
        paramObject.width = DisplayUtil.a(getContext(), 157.0F);
      } else if (this.f.duration > 10) {
        paramObject.width = DisplayUtil.a(getContext(), 117.0F);
      } else {
        paramObject.width = DisplayUtil.a(getContext(), 85.0F);
      }
      this.b.setLayoutParams(paramObject);
      paramObject = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.e.mFeedId);
      localStringBuilder.append("");
      PublicAccountReportUtils.a(null, "", "0X8009CA3", "0X8009CA3", 0, 0, paramObject, localStringBuilder.toString(), "", "", false);
      if (this.f.isPlaying)
      {
        this.d.setImageResource(2130851527);
        ((AnimationDrawable)this.d.getDrawable()).start();
        return;
      }
      this.d.setImageResource(2130851526);
    }
  }
  
  public void b(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void b(UGCVoiceInfo paramUGCVoiceInfo)
  {
    if (paramUGCVoiceInfo == this.f) {
      this.d.setImageResource(2130851526);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentUGCVoice
 * JD-Core Version:    0.7.0.1
 */