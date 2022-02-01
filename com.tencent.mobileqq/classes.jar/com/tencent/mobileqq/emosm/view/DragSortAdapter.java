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
  public int a;
  protected Context a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Handler jdField_a_of_type_AndroidOsHandler;
  private LruCache<String, Drawable> jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(30);
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private HashMap<EmoticonPackage, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  protected List<T> a;
  JSONArray jdField_a_of_type_OrgJsonJSONArray;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public DragSortAdapter(Context paramContext, List<T> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839126);
    ClubContentJsonTask.a((BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null), ClubContentJsonTask.d);
    paramContext = ClubContentJsonTask.d.a(this.jdField_a_of_type_AndroidContentContext);
    if (paramContext != null) {
      try
      {
        this.jdField_a_of_type_OrgJsonJSONArray = paramContext.getJSONArray("wording");
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private Drawable a(EmoticonPackage paramEmoticonPackage)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramEmoticonPackage.epId) != null) {
      return (Drawable)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramEmoticonPackage.epId);
    }
    Drawable localDrawable = EmosmUtils.a(2, paramEmoticonPackage.epId);
    if (localDrawable != null)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramEmoticonPackage.epId, localDrawable);
      return localDrawable;
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public List<EmoticonPackage> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((Boolean)localEntry.getValue()).booleanValue()) {
        localArrayList.add(localEntry.getKey());
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(int paramInt)
  {
    boolean bool = a(paramInt);
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)getItem(paramInt);
    this.jdField_a_of_type_JavaUtilHashMap.put(localEmoticonPackage, Boolean.valueOf(bool ^ true));
  }
  
  public void a(T paramT)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((paramT instanceof EmoticonPackage))
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramT;
        this.jdField_a_of_type_JavaUtilHashMap.remove(localEmoticonPackage);
      }
      this.jdField_a_of_type_JavaUtilList.remove(paramT);
      if (this.b) {
        notifyDataSetChanged();
      }
      return;
    }
  }
  
  public void a(T paramT, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramInt, paramT);
      if (this.b) {
        notifyDataSetChanged();
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(int paramInt)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)getItem(paramInt);
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localEmoticonPackage)) {
      return ((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localEmoticonPackage)).booleanValue();
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public T getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
      paramView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131561590, null);
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366165));
      localViewHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366170));
      localViewHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365886));
      localViewHolder.d = ((ImageView)paramView.findViewById(2131365887));
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366169));
      localViewHolder.e = ((ImageView)paramView.findViewById(2131366166));
      localViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366171));
      localViewHolder.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131377351);
      localViewHolder.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131380217);
      localViewHolder.f = ((ImageView)paramView.findViewById(2131366167));
      localViewHolder.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131366164);
      paramView.setTag(localViewHolder);
      paramViewGroup.setTag(localViewHolder);
      paramView.setBackgroundResource(2130839631);
    }
    else
    {
      localViewHolder = (DragSortAdapter.ViewHolder)paramView.getTag();
    }
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localEmoticonPackage.name);
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a(localEmoticonPackage));
    localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if (localEmoticonPackage.hasSound)
    {
      localViewHolder.e.setVisibility(0);
      if (localEmoticonPackage.isNewVoiceType()) {
        localViewHolder.e.setImageResource(2130838234);
      } else {
        localViewHolder.e.setImageResource(2130839643);
      }
    }
    else
    {
      localViewHolder.e.setVisibility(8);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      StringBuilder localStringBuilder;
      if (!a(paramInt))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getString(2131692134));
        localStringBuilder.append(" ");
        localStringBuilder.append(localEmoticonPackage.name);
        paramView.setContentDescription(localStringBuilder.toString());
        localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847352);
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getString(2131692124));
        localStringBuilder.append(" ");
        localStringBuilder.append(localEmoticonPackage.name);
        paramView.setContentDescription(localStringBuilder.toString());
        localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847353);
      }
      localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      localViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      localViewHolder.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    else
    {
      paramView.setContentDescription(localEmoticonPackage.name);
      localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      localViewHolder.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    if (localEmoticonPackage.mobileFeetype == 4)
    {
      localViewHolder.f.setVisibility(0);
      localViewHolder.f.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839642));
    }
    else if (localEmoticonPackage.mobileFeetype == 5)
    {
      localViewHolder.f.setVisibility(0);
      localViewHolder.f.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847662));
    }
    else
    {
      localViewHolder.f.setVisibility(8);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    this.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortAdapter
 * JD-Core Version:    0.7.0.1
 */