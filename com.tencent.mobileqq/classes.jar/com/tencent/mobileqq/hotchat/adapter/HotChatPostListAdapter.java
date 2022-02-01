package com.tencent.mobileqq.hotchat.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import com.tencent.biz.viewplugin.ViewPluginManager;
import com.tencent.mobileqq.hotchat.api.IHotChatPostListAdapter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.widget.HotChatPostItemView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HotChatPostListAdapter
  extends BaseAdapter
  implements IHotChatPostListAdapter
{
  static final String EXTRA_INFO_KEY = "extra_info_key";
  protected static final String TAG = "HotChatPostListAdapter";
  Context mContext;
  JSONObject mExtraInfo = null;
  protected int mFiltedCount;
  boolean mIsPluginMode;
  boolean mLastPullUpEnded;
  private HashSet<String> mLoadedPids;
  ViewPluginManager mViewPluginManager;
  ArrayList<JSONObject> mlistItems = new ArrayList();
  
  public HotChatPostListAdapter(Context paramContext, JSONArray paramJSONArray, ViewPluginManager paramViewPluginManager)
  {
    boolean bool = false;
    this.mIsPluginMode = false;
    this.mLastPullUpEnded = true;
    this.mFiltedCount = 0;
    this.mLoadedPids = new HashSet();
    this.mContext = paramContext;
    this.mViewPluginManager = paramViewPluginManager;
    if (this.mViewPluginManager != null) {
      bool = true;
    }
    this.mIsPluginMode = bool;
    setListItemsAndNotify(paramJSONArray);
  }
  
  public void destroy()
  {
    if (this.mIsPluginMode)
    {
      ViewPluginManager localViewPluginManager = this.mViewPluginManager;
      if (localViewPluginManager != null)
      {
        localViewPluginManager.a("com.tencent.biz.hotchatpostlist.widget.HotChatPostItemView");
        this.mViewPluginManager = null;
      }
    }
    else
    {
      HotChatPostItemView.jdField_a_of_type_JavaUtilHashMap.clear();
      HotChatPostItemView.jdField_a_of_type_JavaUtilQueue.clear();
    }
  }
  
  public int getCount()
  {
    ArrayList localArrayList = this.mlistItems;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    ArrayList localArrayList = this.mlistItems;
    if (localArrayList == null) {
      return null;
    }
    return (JSONObject)localArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getLastPullUpEndIndex()
  {
    ArrayList localArrayList = this.mlistItems;
    int i;
    if (localArrayList == null) {
      i = 0;
    } else {
      i = localArrayList.size();
    }
    return i + this.mFiltedCount;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = paramView;
      if (this.mIsPluginMode) {
        paramViewGroup = this.mViewPluginManager.a("com.tencent.biz.hotchatpostlist.widget.HotChatPostItemView");
      }
    }
    paramView = paramViewGroup;
    if (paramViewGroup == null)
    {
      paramView = new HotChatPostItemView(this.mContext);
      if (QLog.isColorLevel()) {
        QLog.e("HotChatPostListAdapter", 2, "loadPluginView failed");
      }
      this.mIsPluginMode = false;
    }
    paramViewGroup = (JSONObject)getItem(paramInt);
    if (paramViewGroup != null)
    {
      paramView.setOnClickListener(new HotChatPostListAdapter.2(this, paramViewGroup.optString("bid"), paramViewGroup.optString("pid")));
      try
      {
        if (this.mExtraInfo == null)
        {
          this.mExtraInfo = new JSONObject();
          paramInt = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
          this.mExtraInfo.put("densityDpi", this.mContext.getResources().getDisplayMetrics().densityDpi);
          this.mExtraInfo.put("screenWidth", paramInt);
        }
        this.mExtraInfo.put("currentTime", NetConnInfoCenter.getServerTime());
        paramViewGroup.put("extra_info_key", this.mExtraInfo);
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HotChatPostListAdapter", 2, localJSONException.toString());
        }
      }
      if (this.mIsPluginMode)
      {
        ViewPluginManager.a(paramView, paramViewGroup.toString());
        return paramView;
      }
      ((HotChatPostItemView)paramView).setData(paramViewGroup.toString());
    }
    return paramView;
  }
  
  public boolean isLastPullUpEnded()
  {
    try
    {
      boolean bool = this.mLastPullUpEnded;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void joinListItemsAndNotify(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      ArrayList localArrayList = new ArrayList();
      StringBuilder localStringBuilder = new StringBuilder("filterPids:");
      int i = 0;
      while (i < paramJSONArray.length())
      {
        try
        {
          JSONObject localJSONObject = (JSONObject)paramJSONArray.get(i);
          if (localJSONObject.has("pid"))
          {
            localObject = localJSONObject.optString("pid");
            if (!this.mLoadedPids.add(localObject))
            {
              localStringBuilder.append((String)localObject);
              localStringBuilder.append(",");
              this.mFiltedCount += 1;
            }
            else
            {
              localArrayList.add(localJSONObject);
            }
          }
        }
        catch (JSONException localJSONException)
        {
          Object localObject;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("process array");
            ((StringBuilder)localObject).append(localJSONException.toString());
            QLog.e("HotChatPostListAdapterQ.hotchat.aio_post_list_req", 2, ((StringBuilder)localObject).toString());
          }
        }
        i += 1;
      }
      if (!localArrayList.isEmpty())
      {
        this.mlistItems.addAll(localArrayList);
        notifyDataSetChanged();
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    Collections.sort(this.mlistItems, new HotChatPostListAdapter.1(this));
    super.notifyDataSetChanged();
  }
  
  public void setListItemsAndNotify(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      this.mlistItems.clear();
      this.mLoadedPids.clear();
      int i = 0;
      while (i < paramJSONArray.length())
      {
        try
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          localObject = localJSONObject.optString("pid");
          this.mLoadedPids.add(localObject);
          this.mlistItems.add(localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          Object localObject;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("setListItemsAndNotify JSONException:");
            ((StringBuilder)localObject).append(localJSONException.toString());
            QLog.e("HotChatPostListAdapterQ.hotchat.aio_post_list_req", 2, ((StringBuilder)localObject).toString());
          }
        }
        i += 1;
      }
      notifyDataSetChanged();
    }
  }
  
  public void setPullUpEnded()
  {
    try
    {
      this.mLastPullUpEnded = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setPullUpStarted()
  {
    try
    {
      this.mLastPullUpEnded = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.adapter.HotChatPostListAdapter
 * JD-Core Version:    0.7.0.1
 */