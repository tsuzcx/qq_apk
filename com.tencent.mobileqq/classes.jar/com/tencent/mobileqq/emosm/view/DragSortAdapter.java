package com.tencent.mobileqq.emosm.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DragSortAdapter<T>
  extends BaseAdapter
{
  protected List<T> a;
  protected Context b;
  JSONArray c;
  Handler d;
  public int e;
  private boolean f;
  private LruCache<String, Drawable> g = new LruCache(30);
  private Drawable h;
  private Object i = new Object();
  private boolean j;
  private HashMap<EmoticonPackage, Boolean> k = new HashMap();
  
  public DragSortAdapter(Context paramContext, List<T> paramList)
  {
    this.b = paramContext;
    this.a = paramList;
    this.h = this.b.getResources().getDrawable(2130839282);
    ClubContentJsonTask.a((BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null), ClubContentJsonTask.d);
    paramContext = ClubContentJsonTask.d.a(this.b);
    if (paramContext != null) {
      try
      {
        this.c = paramContext.getJSONArray("wording");
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    this.d = new Handler();
  }
  
  private Drawable a(EmoticonPackage paramEmoticonPackage)
  {
    if (this.g.get(paramEmoticonPackage.epId) != null) {
      return (Drawable)this.g.get(paramEmoticonPackage.epId);
    }
    Drawable localDrawable = EmosmUtils.a(2, paramEmoticonPackage.epId);
    if (localDrawable != null)
    {
      this.g.put(paramEmoticonPackage.epId, localDrawable);
      return localDrawable;
    }
    return this.h;
  }
  
  public List<EmoticonPackage> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.k.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((Boolean)localEntry.getValue()).booleanValue()) {
        localArrayList.add(localEntry.getKey());
      }
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    boolean bool = b(paramInt);
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)getItem(paramInt);
    this.k.put(localEmoticonPackage, Boolean.valueOf(bool ^ true));
  }
  
  public void a(T paramT)
  {
    synchronized (this.i)
    {
      if ((paramT instanceof EmoticonPackage))
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramT;
        this.k.remove(localEmoticonPackage);
      }
      this.a.remove(paramT);
      if (this.j) {
        notifyDataSetChanged();
      }
      return;
    }
  }
  
  public void a(T paramT, int paramInt)
  {
    synchronized (this.i)
    {
      this.a.add(paramInt, paramT);
      if (this.j) {
        notifyDataSetChanged();
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void b()
  {
    this.k.clear();
  }
  
  public void b(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public boolean b(int paramInt)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)getItem(paramInt);
    if (this.k.containsKey(localEmoticonPackage)) {
      return ((Boolean)this.k.get(localEmoticonPackage)).booleanValue();
    }
    return false;
  }
  
  public void c()
  {
    this.g.evictAll();
  }
  
  public int getCount()
  {
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public T getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    DragSortAdapter.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localViewHolder = new DragSortAdapter.ViewHolder(this);
      paramView = View.inflate(this.b, 2131627953, null);
      localViewHolder.a = ((ImageView)paramView.findViewById(2131432452));
      localViewHolder.b = ((ImageView)paramView.findViewById(2131432457));
      localViewHolder.c = ((ImageView)paramView.findViewById(2131432152));
      localViewHolder.d = ((ImageView)paramView.findViewById(2131432153));
      localViewHolder.g = ((TextView)paramView.findViewById(2131432456));
      localViewHolder.h = ((ImageView)paramView.findViewById(2131432453));
      localViewHolder.j = ((TextView)paramView.findViewById(2131432458));
      localViewHolder.e = paramView.findViewById(2131445741);
      localViewHolder.f = paramView.findViewById(2131449135);
      localViewHolder.i = ((ImageView)paramView.findViewById(2131432454));
      localViewHolder.k = paramView.findViewById(2131432451);
      paramView.setTag(localViewHolder);
      paramViewGroup.setTag(localViewHolder);
      paramView.setBackgroundResource(2130840100);
    }
    else
    {
      localViewHolder = (DragSortAdapter.ViewHolder)paramView.getTag();
    }
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)this.a.get(paramInt);
    localViewHolder.g.setText(localEmoticonPackage.name);
    localViewHolder.a.setImageDrawable(a(localEmoticonPackage));
    localViewHolder.e.setVisibility(8);
    if (localEmoticonPackage.hasSound)
    {
      localViewHolder.h.setVisibility(0);
      if (localEmoticonPackage.isNewVoiceType()) {
        localViewHolder.h.setImageResource(2130838299);
      } else {
        localViewHolder.h.setImageResource(2130840112);
      }
    }
    else
    {
      localViewHolder.h.setVisibility(8);
    }
    if (this.f)
    {
      StringBuilder localStringBuilder;
      if (!b(paramInt))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.b.getString(2131889115));
        localStringBuilder.append(" ");
        localStringBuilder.append(localEmoticonPackage.name);
        paramView.setContentDescription(localStringBuilder.toString());
        localViewHolder.b.setImageResource(2130849003);
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.b.getString(2131889105));
        localStringBuilder.append(" ");
        localStringBuilder.append(localEmoticonPackage.name);
        paramView.setContentDescription(localStringBuilder.toString());
        localViewHolder.b.setImageResource(2130849004);
      }
      localViewHolder.b.setVisibility(0);
      localViewHolder.c.setVisibility(0);
      localViewHolder.k.setVisibility(8);
    }
    else
    {
      paramView.setContentDescription(localEmoticonPackage.name);
      localViewHolder.b.setVisibility(8);
      localViewHolder.c.setVisibility(8);
      localViewHolder.k.setVisibility(0);
    }
    if (localEmoticonPackage.mobileFeetype == 4)
    {
      localViewHolder.i.setVisibility(0);
      localViewHolder.i.setBackgroundDrawable(this.b.getResources().getDrawable(2130840111));
    }
    else if (localEmoticonPackage.mobileFeetype == 5)
    {
      localViewHolder.i.setVisibility(0);
      localViewHolder.i.setBackgroundDrawable(this.b.getResources().getDrawable(2130849322));
    }
    else
    {
      localViewHolder.i.setVisibility(8);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    this.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortAdapter
 * JD-Core Version:    0.7.0.1
 */