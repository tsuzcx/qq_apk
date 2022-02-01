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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
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
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839272);
    ClubContentJsonTask.a((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime(), ClubContentJsonTask.d);
    paramContext = ClubContentJsonTask.d.a(this.jdField_a_of_type_AndroidContentContext);
    if (paramContext != null) {}
    try
    {
      this.jdField_a_of_type_OrgJsonJSONArray = paramContext.getJSONArray("wording");
      this.jdField_a_of_type_AndroidOsHandler = new Handler();
      return;
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
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
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (!bool) {}
    for (bool = true;; bool = false)
    {
      localHashMap.put(localEmoticonPackage, Boolean.valueOf(bool));
      return;
    }
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
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
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
    View localView;
    Object localObject;
    if (paramView == null)
    {
      paramView = new DragSortAdapter.ViewHolder(this);
      localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559228, null);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131366277));
      paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131366282));
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131366057));
      paramView.d = ((ImageView)localView.findViewById(2131366058));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131366281));
      paramView.e = ((ImageView)localView.findViewById(2131366278));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131366283));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131377928);
      paramView.jdField_b_of_type_AndroidViewView = localView.findViewById(2131380951);
      paramView.f = ((ImageView)localView.findViewById(2131366279));
      paramView.jdField_c_of_type_AndroidViewView = localView.findViewById(2131366276);
      localView.setTag(paramView);
      paramViewGroup.setTag(paramView);
      localView.setBackgroundResource(2130839773);
      localObject = (EmoticonPackage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((EmoticonPackage)localObject).name);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a((EmoticonPackage)localObject));
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (!((EmoticonPackage)localObject).hasSound) {
        break label458;
      }
      paramView.e.setVisibility(0);
      if (!((EmoticonPackage)localObject).isNewVoiceType()) {
        break label445;
      }
      paramView.e.setImageResource(2130838404);
      label280:
      if (!this.jdField_a_of_type_Boolean) {
        break label525;
      }
      if (a(paramInt)) {
        break label470;
      }
      localView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131692208) + " " + ((EmoticonPackage)localObject).name);
      paramView.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847482);
      label347:
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramView.jdField_c_of_type_AndroidViewView.setVisibility(8);
      label372:
      if (((EmoticonPackage)localObject).mobileFeetype != 4) {
        break label564;
      }
      paramView.f.setVisibility(0);
      paramView.f.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839782));
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (DragSortAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label445:
      paramView.e.setImageResource(2130839783);
      break label280;
      label458:
      paramView.e.setVisibility(8);
      break label280;
      label470:
      localView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131692198) + " " + ((EmoticonPackage)localObject).name);
      paramView.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847483);
      break label347;
      label525:
      localView.setContentDescription(((EmoticonPackage)localObject).name);
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramView.jdField_c_of_type_AndroidViewView.setVisibility(0);
      break label372;
      label564:
      if (((EmoticonPackage)localObject).mobileFeetype == 5)
      {
        paramView.f.setVisibility(0);
        paramView.f.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847795));
      }
      else
      {
        paramView.f.setVisibility(8);
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    this.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortAdapter
 * JD-Core Version:    0.7.0.1
 */