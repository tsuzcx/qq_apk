package com.tencent.mobileqq.wink.editor.music;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.editor.music.lyric.util.UIUtils;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Map;

class WinkEditorMusicAdapter$WinkEditorMusicViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private View a;
  private FrameLayout b;
  private ImageView c;
  private FrameLayout d;
  private ImageView e;
  private ImageView f;
  private TextView g;
  private WinkEditorMusicAdapter.ClickCallback h;
  private SparseArray<Boolean> i = new SparseArray();
  private WinkEditorMusicInfo j;
  private int k;
  private final int l;
  
  public WinkEditorMusicAdapter$WinkEditorMusicViewHolder(@NonNull View paramView, @Nullable WinkEditorMusicAdapter.ClickCallback paramClickCallback, int paramInt)
  {
    super(paramView);
    this.a = paramView;
    this.b = ((FrameLayout)paramView.findViewById(2131444194));
    this.c = ((ImageView)paramView.findViewById(2131436464));
    this.d = ((FrameLayout)paramView.findViewById(2131433272));
    this.e = ((ImageView)paramView.findViewById(2131436467));
    this.f = ((ImageView)paramView.findViewById(2131436447));
    this.g = ((TextView)paramView.findViewById(2131448595));
    this.b.setOnClickListener(this);
    this.h = paramClickCallback;
    this.l = paramInt;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(@NonNull WinkEditorMusicInfo paramWinkEditorMusicInfo, int paramInt1, int paramInt2)
  {
    this.j = paramWinkEditorMusicInfo;
    this.k = paramInt1;
    VideoReport.setElementId(this.itemView, "em_xsj_music_item");
    Object localObject = this.itemView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("em_xsj_music_item");
    localStringBuilder.append(paramWinkEditorMusicInfo.hashCode());
    VideoReport.setElementReuseIdentifier(localObject, localStringBuilder.toString());
    VideoReport.setElementClickPolicy(this.itemView, ClickPolicy.REPORT_ALL);
    VideoReport.setElementExposePolicy(this.itemView, ExposurePolicy.REPORT_NONE);
    if ((paramWinkEditorMusicInfo.f == 2) && (!TextUtils.isEmpty(paramWinkEditorMusicInfo.i())))
    {
      this.c.setVisibility(0);
      ViewUtilsKt.a(this.c, paramWinkEditorMusicInfo.i(), UIUtils.a(this.c.getContext(), this.l), UIUtils.a(this.c.getContext(), this.l), null, null);
    }
    else
    {
      this.c.setVisibility(4);
    }
    if (paramWinkEditorMusicInfo.c)
    {
      this.g.setTextColor(this.a.getContext().getResources().getColor(2131168464));
      if (paramWinkEditorMusicInfo.f == 3)
      {
        this.c.setVisibility(0);
        this.c.setImageResource(2130848847);
      }
      localObject = (Boolean)this.i.get(paramInt1);
      if ((paramWinkEditorMusicInfo.d != 2) && ((localObject == null) || (!((Boolean)localObject).booleanValue())))
      {
        if (paramWinkEditorMusicInfo.d == 1)
        {
          this.d.setVisibility(0);
          this.d.setBackgroundDrawable(null);
          this.e.setVisibility(8);
          if (paramWinkEditorMusicInfo.e > 0) {
            this.f.setVisibility(0);
          } else {
            this.f.setVisibility(8);
          }
        }
        else
        {
          if (paramWinkEditorMusicInfo.f == 3)
          {
            this.d.setVisibility(0);
            this.d.setBackgroundResource(2130848739);
          }
          this.e.setVisibility(8);
          this.f.setVisibility(8);
        }
      }
      else
      {
        this.d.setVisibility(0);
        this.d.setBackgroundResource(2130848739);
        this.i.put(paramInt1, Boolean.TRUE);
      }
      localObject = this.g;
      ((TextView)localObject).setTypeface(((TextView)localObject).getTypeface(), 1);
    }
    else
    {
      this.g.setTextColor(this.a.getContext().getResources().getColor(2131165866));
      if (paramWinkEditorMusicInfo.f == 0)
      {
        this.d.setVisibility(0);
        this.e.setVisibility(8);
      }
      else if (paramWinkEditorMusicInfo.f == 1)
      {
        this.d.setVisibility(0);
        this.d.setBackgroundColor(this.a.getContext().getResources().getColor(2131165731));
        this.e.setVisibility(0);
        this.e.setImageResource(2130848877);
        this.f.setVisibility(8);
      }
      else if (paramWinkEditorMusicInfo.f == 3)
      {
        this.d.setVisibility(4);
        this.d.setBackgroundResource(2130848739);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        this.c.setVisibility(0);
        this.c.setImageResource(2130848847);
      }
      else
      {
        if (paramWinkEditorMusicInfo.d == 1)
        {
          if (paramWinkEditorMusicInfo.e > 0) {
            this.f.setVisibility(0);
          } else {
            this.f.setVisibility(8);
          }
        }
        else
        {
          this.d.setVisibility(8);
          this.f.setVisibility(8);
        }
        this.e.setVisibility(8);
      }
      this.g.setTypeface(null, 0);
    }
    if (paramWinkEditorMusicInfo.f == 1)
    {
      paramWinkEditorMusicInfo = this.g.getContext().getString(2131886337);
    }
    else if (paramWinkEditorMusicInfo.f == 3)
    {
      paramWinkEditorMusicInfo = this.g.getContext().getString(2131886338);
    }
    else if (TextUtils.isEmpty(paramWinkEditorMusicInfo.e()))
    {
      paramWinkEditorMusicInfo = "";
    }
    else if (paramWinkEditorMusicInfo.e().length() > 5)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramWinkEditorMusicInfo.e().substring(0, 5));
      ((StringBuilder)localObject).append("...");
      paramWinkEditorMusicInfo = ((StringBuilder)localObject).toString();
    }
    else
    {
      paramWinkEditorMusicInfo = paramWinkEditorMusicInfo.e();
    }
    this.g.setText(paramWinkEditorMusicInfo);
    paramWinkEditorMusicInfo = (ViewGroup.MarginLayoutParams)this.a.getLayoutParams();
    if (paramInt1 == 0)
    {
      paramWinkEditorMusicInfo.leftMargin = ViewUtils.dip2px(12.0F);
      paramWinkEditorMusicInfo.rightMargin = (-ViewUtils.dip2px(2.0F));
    }
    else if (paramInt1 == paramInt2 - 1)
    {
      paramWinkEditorMusicInfo.leftMargin = (-ViewUtils.dip2px(2.0F));
      paramWinkEditorMusicInfo.rightMargin = ViewUtils.dip2px(12.0F);
    }
    else
    {
      paramWinkEditorMusicInfo.leftMargin = (-ViewUtils.dip2px(2.0F));
      paramWinkEditorMusicInfo.rightMargin = (-ViewUtils.dip2px(2.0F));
    }
    this.a.setLayoutParams(paramWinkEditorMusicInfo);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131444194)
    {
      Object localObject = this.j;
      if ((localObject != null) && (((WinkEditorMusicInfo)localObject).f != 0) && (this.h != null))
      {
        if (this.j.f == 2)
        {
          Map localMap = WinkDTParamBuilder.buildElementParams();
          boolean bool = TextUtils.isEmpty(this.j.c());
          String str = "none";
          if (!bool) {
            localObject = this.j.c();
          } else {
            localObject = "none";
          }
          if (!TextUtils.isEmpty(this.j.e())) {
            str = this.j.e();
          }
          localMap.put("xsj_music_id", localObject);
          localMap.put("xsj_music_name", str);
          VideoReport.reportEvent("dt_clck", this.itemView, localMap);
        }
        this.h.a(this.j, getAdapterPosition(), this.j.c ^ true, this.j.f);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.WinkEditorMusicAdapter.WinkEditorMusicViewHolder
 * JD-Core Version:    0.7.0.1
 */