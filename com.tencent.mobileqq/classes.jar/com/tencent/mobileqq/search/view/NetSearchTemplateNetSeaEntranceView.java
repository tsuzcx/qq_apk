package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.search.business.net.model.NetSearchSubItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateNetSeaEntranceItem;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateBaseView;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import java.util.ArrayList;
import java.util.List;

public class NetSearchTemplateNetSeaEntranceView
  extends NetSearchTemplateBaseView
{
  public LinearLayout a;
  public URLImageView b;
  public TextView c;
  public TextView d;
  public TextView n;
  public URLImageView o;
  public View p;
  public LinearLayout q;
  public ArrayList<NetSearchTemplateNetSeaEntranceView.NetSearchSubView> y = new ArrayList();
  
  public NetSearchTemplateNetSeaEntranceView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    View localView = b(this.m);
    this.a = ((LinearLayout)localView.findViewById(2131432578));
    this.b = ((URLImageView)localView.findViewById(2131435357));
    this.c = ((TextView)localView.findViewById(2131447463));
    this.d = ((TextView)localView.findViewById(2131446539));
    this.n = ((TextView)localView.findViewById(2131431757));
    this.o = ((URLImageView)localView.findViewById(2131444823));
    this.p = localView.findViewById(2131435797);
    this.q = ((LinearLayout)localView.findViewById(2131446528));
  }
  
  public void a(NetSearchTemplateNetSeaEntranceItem paramNetSearchTemplateNetSeaEntranceItem)
  {
    this.y.clear();
    this.q.removeAllViews();
    if ((paramNetSearchTemplateNetSeaEntranceItem.t != null) && (paramNetSearchTemplateNetSeaEntranceItem.t.size() != 0))
    {
      this.p.setVisibility(0);
      this.q.setVisibility(0);
      Context localContext = this.q.getContext();
      ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      int i = 0;
      while (i < paramNetSearchTemplateNetSeaEntranceItem.t.size())
      {
        NetSearchSubItem localNetSearchSubItem = (NetSearchSubItem)paramNetSearchTemplateNetSeaEntranceItem.t.get(i);
        NetSearchTemplateNetSeaEntranceView.NetSearchSubView localNetSearchSubView = new NetSearchTemplateNetSeaEntranceView.NetSearchSubView(this, localContext);
        if (!TextUtils.isEmpty(localNetSearchSubItem.a))
        {
          Object localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = DisplayUtil.a(localContext, 18.0F);
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = DisplayUtil.a(localContext, 18.0F);
          ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
          localObject = URLDrawable.getDrawable(localNetSearchSubItem.a, (URLDrawable.URLDrawableOptions)localObject);
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
        if (!TextUtils.isEmpty(localNetSearchSubItem.b))
        {
          localNetSearchSubView.c.setText(localNetSearchSubItem.b);
          localNetSearchSubView.c.setVisibility(0);
        }
        else
        {
          localNetSearchSubView.c.setVisibility(8);
        }
        if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
        {
          localNetSearchSubView.c.setTextColor(Color.parseColor("#737373"));
          this.p.setBackgroundColor(Color.parseColor("#112037"));
        }
        else
        {
          localNetSearchSubView.c.setTextColor(Color.parseColor("#262626"));
          this.p.setBackgroundColor(Color.parseColor("#E6E6E6"));
        }
        this.q.addView(localNetSearchSubView.a);
        this.y.add(localNetSearchSubView);
        i += 1;
      }
      return;
    }
    this.p.setVisibility(8);
    this.q.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.NetSearchTemplateNetSeaEntranceView
 * JD-Core Version:    0.7.0.1
 */