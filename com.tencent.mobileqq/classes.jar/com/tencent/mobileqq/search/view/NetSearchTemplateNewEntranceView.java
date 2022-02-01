package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateNewEntranceItem;
import com.tencent.mobileqq.search.business.net.model.RelativeWord;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateBaseView;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.widget.ThemeURLImageView;
import java.util.ArrayList;
import java.util.List;

public class NetSearchTemplateNewEntranceView
  extends NetSearchTemplateBaseView
{
  public LinearLayout a;
  public URLImageView b;
  public TextView c;
  public TextView d;
  public TextView n;
  public TextView o;
  public ImageView p;
  public View q;
  public LinearLayout y;
  public ArrayList<NetSearchTemplateNewEntranceView.NetSearchSubView> z = new ArrayList();
  
  public NetSearchTemplateNewEntranceView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    View localView = b(this.m);
    this.a = ((LinearLayout)localView.findViewById(2131432578));
    this.b = ((URLImageView)localView.findViewById(2131435357));
    URLImageView localURLImageView = this.b;
    if ((localURLImageView instanceof ThemeURLImageView)) {
      ((ThemeURLImageView)localURLImageView).setSupportMaskView(false);
    }
    this.c = ((TextView)localView.findViewById(2131447463));
    this.d = ((TextView)localView.findViewById(2131446539));
    this.n = ((TextView)localView.findViewById(2131446539));
    this.o = ((TextView)localView.findViewById(2131431757));
    this.p = ((ImageView)localView.findViewById(2131444823));
    this.q = localView.findViewById(2131435797);
    this.y = ((LinearLayout)localView.findViewById(2131446528));
  }
  
  public void a(NetSearchTemplateNewEntranceItem paramNetSearchTemplateNewEntranceItem)
  {
    this.z.clear();
    this.y.removeAllViews();
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      this.d.setTextColor(Color.parseColor("#004080"));
    }
    if ((paramNetSearchTemplateNewEntranceItem.t != null) && (paramNetSearchTemplateNewEntranceItem.t.size() != 0))
    {
      this.q.setVisibility(0);
      this.y.setVisibility(0);
      Context localContext = this.y.getContext();
      ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      int i = 0;
      while ((i < paramNetSearchTemplateNewEntranceItem.t.size()) && (i < 6))
      {
        RelativeWord localRelativeWord = (RelativeWord)paramNetSearchTemplateNewEntranceItem.t.get(i);
        NetSearchTemplateNewEntranceView.NetSearchSubView localNetSearchSubView = new NetSearchTemplateNewEntranceView.NetSearchSubView(this, localContext);
        if (!TextUtils.isEmpty(paramNetSearchTemplateNewEntranceItem.u))
        {
          Object localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = DisplayUtil.a(localContext, 16.0F);
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = DisplayUtil.a(localContext, 16.0F);
          ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "subItemLeftIconUrl";
          localObject = URLDrawable.getDrawable(paramNetSearchTemplateNewEntranceItem.u, (URLDrawable.URLDrawableOptions)localObject);
          ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.b);
          localNetSearchSubView.b.setImageDrawable((Drawable)localObject);
          if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
            ((URLDrawable)localObject).restartDownload();
          }
          localNetSearchSubView.b.setVisibility(0);
        }
        else
        {
          localNetSearchSubView.b.setVisibility(8);
        }
        localNetSearchSubView.a.setTag(2131449867, paramNetSearchTemplateNewEntranceItem);
        if (!TextUtils.isEmpty(localRelativeWord.a))
        {
          localNetSearchSubView.c.setText(localRelativeWord.a);
          localNetSearchSubView.c.setVisibility(0);
          localNetSearchSubView.a.setTag(2131446835, localRelativeWord.a);
        }
        else
        {
          localNetSearchSubView.c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(localRelativeWord.b))
        {
          localNetSearchSubView.a.setTag(2131446833, localRelativeWord.b);
          localNetSearchSubView.a.setTag(2131446804, Integer.valueOf(paramNetSearchTemplateNewEntranceItem.p));
        }
        this.y.addView(localNetSearchSubView.a);
        this.z.add(localNetSearchSubView);
        i += 1;
      }
      return;
    }
    this.q.setVisibility(8);
    this.y.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.NetSearchTemplateNewEntranceView
 * JD-Core Version:    0.7.0.1
 */