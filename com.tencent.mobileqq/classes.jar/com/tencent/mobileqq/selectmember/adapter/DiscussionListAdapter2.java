package com.tencent.mobileqq.selectmember.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DiscussionListAdapter2
  extends BaseAdapter
  implements DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  AppInterface a;
  protected DiscussionListAdapter2.DiscussionListListener b;
  protected boolean c = false;
  public boolean d = true;
  protected View.OnClickListener e = new DiscussionListAdapter2.3(this);
  private Context f;
  private LayoutInflater g;
  private List<DiscussionInfo> h = new ArrayList();
  private List<Entity> i = new ArrayList();
  private ArrayList<Object> j = new ArrayList();
  private IFaceDecoder k;
  private ListView l;
  private int m = 0;
  private View.OnClickListener n = new DiscussionListAdapter2.2(this);
  
  public DiscussionListAdapter2(Context paramContext, DiscussionListAdapter2.DiscussionListListener paramDiscussionListListener, ListView paramListView, AppInterface paramAppInterface, boolean paramBoolean)
  {
    this.f = paramContext;
    this.a = paramAppInterface;
    this.g = LayoutInflater.from(paramContext);
    if (paramBoolean) {
      b();
    }
    this.k = ((IQQAvatarService)paramAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramAppInterface);
    this.k.setDecodeTaskCompletionListener(this);
    this.l = paramListView;
    this.b = paramDiscussionListListener;
    paramListView.setOnScrollListener(this);
  }
  
  private void a(String paramString, Bitmap paramBitmap)
  {
    int i2 = this.l.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = this.l.getChildAt(i1).getTag();
      Bitmap localBitmap = paramBitmap;
      if (localObject != null)
      {
        localBitmap = paramBitmap;
        if ((localObject instanceof DiscussionListAdapter2.ViewTag))
        {
          localObject = (DiscussionListAdapter2.ViewTag)localObject;
          if ((paramString == null) && (!TextUtils.isEmpty(((DiscussionListAdapter2.ViewTag)localObject).a)))
          {
            localBitmap = this.k.getBitmapFromCache(101, ((DiscussionListAdapter2.ViewTag)localObject).a);
            if (localBitmap != null) {
              ((DiscussionListAdapter2.ViewTag)localObject).b.setBackgroundDrawable(new BitmapDrawable(this.f.getResources(), localBitmap));
            } else {
              this.k.requestDecodeFace(((DiscussionListAdapter2.ViewTag)localObject).a, 101, true);
            }
          }
          else
          {
            localBitmap = paramBitmap;
            if (TextUtils.equals(paramString, ((DiscussionListAdapter2.ViewTag)localObject).a))
            {
              ((DiscussionListAdapter2.ViewTag)localObject).b.setBackgroundDrawable(new BitmapDrawable(this.f.getResources(), paramBitmap));
              return;
            }
          }
        }
      }
      i1 += 1;
      paramBitmap = localBitmap;
    }
  }
  
  private void b()
  {
    this.h = ((ArrayList)((IDiscussionService)this.a.getRuntimeService(IDiscussionService.class, "")).getDiscussList());
    Object localObject1 = new HashMap();
    Object localObject2 = this.f.getResources().getString(2131917722);
    String str1 = this.f.getResources().getString(2131887955);
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      DiscussionInfo localDiscussionInfo = (DiscussionInfo)localIterator.next();
      long l1 = 0L;
      String str2 = CommonUtils.a(this.f, localDiscussionInfo);
      String str3 = ChnToSpell.b(str2, 1);
      if ((str2.matches((String)localObject2)) || (str2.contains(str1))) {
        l1 = 65536L;
      }
      if ((str3 != null) && (str3.length() != 0))
      {
        if (StringUtil.isAsciiAlpha(str3.charAt(0))) {}
        for (long l2 = str3.charAt(0);; l2 = 65534L)
        {
          l1 |= l2;
          break label215;
          if (!Character.isDigit(str3.charAt(0))) {
            break;
          }
        }
      }
      l1 |= 0xFFFF;
      label215:
      ((HashMap)localObject1).put(localDiscussionInfo.uin, Long.valueOf(l1));
    }
    Collections.sort(this.h, new DiscussionListAdapter2.1(this, (HashMap)localObject1));
    this.i.clear();
    localObject1 = this.h.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (DiscussionInfo)((Iterator)localObject1).next();
      if (((DiscussionInfo)localObject2).hasCollect) {
        this.i.add(localObject2);
      }
    }
    this.j.clear();
    if (this.h.size() > 0)
    {
      int i1 = this.i.size();
      if (i1 > 0)
      {
        this.j.add(Integer.valueOf(i1));
        this.j.addAll(this.i);
      }
      this.j.add(Integer.valueOf(i1));
      this.j.addAll(this.h);
    }
  }
  
  public void a()
  {
    this.k.destory();
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public int getCount()
  {
    return this.j.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.j.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if ((localObject instanceof DiscussionInfo)) {
      return Long.parseLong(((DiscussionInfo)localObject).uin);
    }
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((getItem(paramInt) instanceof Integer)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    DiscussionListAdapter2.ViewTag localViewTag;
    if (getItemViewType(paramInt) == 1)
    {
      if (paramView == null)
      {
        paramView = this.g.inflate(2131624728, paramViewGroup, false);
        localViewTag = new DiscussionListAdapter2.ViewTag(null);
        localViewTag.b = ((ImageView)paramView.findViewById(2131435219));
        localViewTag.c = ((TextView)paramView.findViewById(2131447063));
        localViewTag.d = ((TextView)paramView.findViewById(2131447065));
        localViewTag.f = ((ImageView)paramView.findViewById(2131431966));
        localViewTag.b.setImageBitmap(null);
        localViewTag.b.setClickable(false);
        localViewTag.d.setVisibility(0);
        paramView.setTag(localViewTag);
        paramView.setOnClickListener(this.n);
        ((Button)paramView.findViewById(2131431959)).setOnClickListener(this.e);
      }
      else
      {
        localViewTag = (DiscussionListAdapter2.ViewTag)paramView.getTag();
      }
      DiscussionInfo localDiscussionInfo = (DiscussionInfo)getItem(paramInt);
      String str = localDiscussionInfo.uin;
      Object localObject = CommonUtils.a(this.f, localDiscussionInfo);
      localViewTag.c.setText((CharSequence)localObject);
      localViewTag.d.setText(String.format("(%d)", new Object[] { Integer.valueOf(((IDiscussionService)this.a.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNum(str)) }));
      localObject = this.k.getBitmapFromCache(101, str);
      if (localObject == null) {
        localViewTag.b.setBackgroundDrawable(BaseImageUtil.h());
      } else {
        localViewTag.b.setBackgroundDrawable(new BitmapDrawable(this.l.getResources(), (Bitmap)localObject));
      }
      if (this.m == 0) {
        this.k.requestDecodeFace(str, 101, false);
      }
      localViewTag.a = str;
      localViewTag.e = localDiscussionInfo;
      if (this.c) {
        localViewTag.f.setVisibility(0);
      } else {
        localViewTag.f.setVisibility(8);
      }
    }
    else
    {
      if (paramView == null)
      {
        localViewTag = new DiscussionListAdapter2.ViewTag(null);
        paramView = this.g.inflate(2131624727, paramViewGroup, false);
        localViewTag.c = ((TextView)paramView.findViewById(2131431982));
        paramView.setTag(localViewTag);
      }
      else
      {
        localViewTag = (DiscussionListAdapter2.ViewTag)paramView.getTag();
      }
      localViewTag.a = "";
      if ((paramInt == 0) && (this.i.size() > 0)) {
        localViewTag.c.setText(2131892017);
      } else {
        localViewTag.c.setText(2131892010);
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void notifyDataSetChanged()
  {
    b();
    super.notifyDataSetChanged();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.m == 0)) {
      a(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.m = paramInt;
    if (paramInt == 0)
    {
      a(null, null);
      this.k.resume();
      return;
    }
    this.k.pause();
    this.k.cancelPendingRequests();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.adapter.DiscussionListAdapter2
 * JD-Core Version:    0.7.0.1
 */