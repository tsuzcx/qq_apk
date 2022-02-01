package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TroopBarImagePreviewAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  protected Drawable a;
  protected URLDrawable.URLDrawableOptions b;
  protected CharSequence c;
  protected CharSequence d;
  protected boolean e;
  protected LayoutInflater f;
  protected List<String> g;
  protected ExtendGridView h;
  public Bitmap i;
  private HashMap<String, Drawable.ConstantState> j;
  
  private void a()
  {
    long l = System.currentTimeMillis();
    Object localObject = new HashMap();
    Iterator localIterator = this.j.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      List localList = this.g;
      if ((localList != null) && (localList.contains(str))) {
        ((HashMap)localObject).put(str, this.j.get(str));
      }
    }
    this.j.clear();
    this.j.putAll((Map)localObject);
    ((HashMap)localObject).clear();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("!!!clearDirtyCache time is ");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      QLog.d("TroopBar", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean a(int paramInt)
  {
    return (this.e) && (paramInt == getCount() - 1);
  }
  
  public int getCount()
  {
    List localList = this.g;
    int k;
    if (localList != null) {
      k = localList.size();
    } else {
      k = 0;
    }
    int m = k;
    if (this.e) {
      m = k + 1;
    }
    return m;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.g != null)
    {
      if (a(paramInt)) {
        return null;
      }
      return this.g.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if (this.g != null) {
      return paramInt;
    }
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    long l = System.currentTimeMillis();
    localObject = null;
    View localView;
    TroopBarImagePreviewAdapter.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localView = this.f.inflate(2131625957, null);
      localViewHolder = new TroopBarImagePreviewAdapter.ViewHolder();
      localViewHolder.a = ((URLImageView)localView.findViewById(2131449194));
      localViewHolder.c = ((ImageView)localView.findViewById(2131435570));
      localViewHolder.b = ((ImageView)localView.findViewById(2131445174));
      localView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (TroopBarImagePreviewAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
    }
    int k = this.h.a();
    paramView = localView.getLayoutParams();
    if ((paramView != null) && ((paramView instanceof AbsListView.LayoutParams)))
    {
      paramView.width = k;
      paramView.height = k;
    }
    else
    {
      paramView = new AbsListView.LayoutParams(k, k);
    }
    localView.setLayoutParams((AbsListView.LayoutParams)paramView);
    String str;
    int n;
    if (a(paramInt))
    {
      localViewHolder.a.setScaleType(ImageView.ScaleType.FIT_XY);
      localViewHolder.a.setImageResource(2130843551);
      localViewHolder.a.setContentDescription(this.c);
      localViewHolder.c.setVisibility(8);
    }
    else
    {
      str = (String)getItem(paramInt);
      if (!TextUtils.isEmpty(str))
      {
        if (k < 0) {
          m = 2147483647;
        } else {
          m = k;
        }
        n = Math.min(100, m);
        int m = k;
        if (k < 0) {
          m = 2147483647;
        }
        k = Math.min(100, m);
        localViewHolder.a.setAdjustViewBounds(false);
        paramView = new File(str);
        if (this.j.size() >= 18) {
          a();
        }
        Drawable.ConstantState localConstantState = (Drawable.ConstantState)this.j.get(str);
        if (((paramInt != 0) || (paramViewGroup.getChildCount() != 0)) && (localConstantState != null)) {
          paramView = localConstantState.newDrawable();
        }
      }
    }
    try
    {
      this.b.mRequestWidth = n;
      this.b.mRequestHeight = k;
      this.b.mPlayGifImage = true;
      if (paramView.exists()) {
        paramView = URLDrawable.getDrawable(paramView.toURL(), this.b);
      } else {
        paramView = this.a;
      }
    }
    catch (MalformedURLException paramView)
    {
      for (;;)
      {
        paramView = localObject;
      }
    }
    if (paramView == null) {
      paramView = this.a;
    } else {
      this.j.put(str, paramView.getConstantState());
    }
    paramView.setBounds(0, 0, n, k);
    localViewHolder.a.setImageDrawable(paramView);
    localViewHolder.a.setContentDescription(this.d);
    localViewHolder.c.setVisibility(0);
    localViewHolder.c.setTag(Integer.valueOf(paramInt));
    localViewHolder.c.setOnClickListener(this);
    localViewHolder.b.setImageBitmap(this.i);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("---getView time is ");
      paramView.append(System.currentTimeMillis() - l);
      QLog.d("TroopBar", 2, paramView.toString());
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    if (this.e) {
      return 2;
    }
    return 1;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131435570)
    {
      Integer localInteger = (Integer)paramView.getTag();
      Intent localIntent = new Intent("key_photo_delete_action");
      localIntent.putExtra("key_photo_delete_position", localInteger.intValue());
      BaseApplication.getContext().sendBroadcast(localIntent);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarImagePreviewAdapter
 * JD-Core Version:    0.7.0.1
 */