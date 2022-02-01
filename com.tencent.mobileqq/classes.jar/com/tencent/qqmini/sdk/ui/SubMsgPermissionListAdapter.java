package com.tencent.qqmini.sdk.ui;

import NS_MINI_INTERFACE.INTERFACE.StExampleDetail;
import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.layout;
import com.tencent.qqmini.sdk.launcher.widget.Switch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SubMsgPermissionListAdapter
  extends BaseAdapter
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private CompoundButton.OnCheckedChangeListener checkedChangeListener;
  private Context context;
  private CompoundButton.OnCheckedChangeListener innerCheckedChangeListener;
  private View.OnClickListener innerOnClickListener;
  private LayoutInflater mInflater;
  private List<INTERFACE.StSubscribeMessage> subMsgMaintainAuth;
  
  public SubMsgPermissionListAdapter(Context paramContext, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.context = paramContext;
    this.checkedChangeListener = paramOnCheckedChangeListener;
    this.mInflater = LayoutInflater.from(paramContext);
    this.subMsgMaintainAuth = new ArrayList();
  }
  
  public int getCount()
  {
    return this.subMsgMaintainAuth.size();
  }
  
  public INTERFACE.StSubscribeMessage getItem(int paramInt)
  {
    if ((paramInt > -1) && (paramInt < this.subMsgMaintainAuth.size())) {
      return (INTERFACE.StSubscribeMessage)this.subMsgMaintainAuth.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    INTERFACE.StSubscribeMessage localStSubscribeMessage = getItem(paramInt);
    Object localObject = paramView;
    if (localStSubscribeMessage != null)
    {
      if (paramView != null)
      {
        localObject = (SubMsgPermissionListAdapter.ViewHolder)paramView.getTag();
      }
      else
      {
        localObject = new SubMsgPermissionListAdapter.ViewHolder(null);
        paramView = this.mInflater.inflate(R.layout.mini_sdk_once_sub_item_switcher, null);
        ((SubMsgPermissionListAdapter.ViewHolder)localObject).tvAuthTitle = ((TextView)paramView.findViewById(R.id.tv_auth_title));
        ((SubMsgPermissionListAdapter.ViewHolder)localObject).ivAuthDetail = ((ImageView)paramView.findViewById(R.id.iv_auth_detail));
        ((SubMsgPermissionListAdapter.ViewHolder)localObject).authSwitcher = ((Switch)paramView.findViewById(R.id.sw_auth));
        paramView.setTag(localObject);
      }
      ((SubMsgPermissionListAdapter.ViewHolder)localObject).tvAuthTitle.setText(localStSubscribeMessage.example.title.get());
      ((SubMsgPermissionListAdapter.ViewHolder)localObject).ivAuthDetail.setTag(localStSubscribeMessage);
      ((SubMsgPermissionListAdapter.ViewHolder)localObject).ivAuthDetail.setOnClickListener(this);
      ((SubMsgPermissionListAdapter.ViewHolder)localObject).authSwitcher.setTag(localStSubscribeMessage);
      Switch localSwitch = ((SubMsgPermissionListAdapter.ViewHolder)localObject).authSwitcher;
      int i = localStSubscribeMessage.authState.get();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      localSwitch.setChecked(bool);
      ((SubMsgPermissionListAdapter.ViewHolder)localObject).authSwitcher.setOnCheckedChangeListener(this);
      localObject = paramView;
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    CompoundButton.OnCheckedChangeListener localOnCheckedChangeListener = this.innerCheckedChangeListener;
    if (localOnCheckedChangeListener != null) {
      localOnCheckedChangeListener.onCheckedChanged(paramCompoundButton, paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    View.OnClickListener localOnClickListener = this.innerOnClickListener;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setInnerCheckedChangeListener(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.innerCheckedChangeListener = paramOnCheckedChangeListener;
  }
  
  public void setInnerOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.innerOnClickListener = paramOnClickListener;
  }
  
  public void setSubMsgMaintainAuth(List<INTERFACE.StSubscribeMessage> paramList)
  {
    this.subMsgMaintainAuth.clear();
    if (paramList != null) {
      this.subMsgMaintainAuth.addAll(paramList);
    }
  }
  
  public void updateSubMsgItem(INTERFACE.StSubscribeMessage paramStSubscribeMessage, boolean paramBoolean)
  {
    Iterator localIterator = this.subMsgMaintainAuth.iterator();
    while (localIterator.hasNext())
    {
      INTERFACE.StSubscribeMessage localStSubscribeMessage = (INTERFACE.StSubscribeMessage)localIterator.next();
      if (localStSubscribeMessage.templateId.get().equals(paramStSubscribeMessage.templateId.get()))
      {
        int i;
        if (paramBoolean) {
          i = 1;
        } else {
          i = 2;
        }
        localStSubscribeMessage.authState.set(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.SubMsgPermissionListAdapter
 * JD-Core Version:    0.7.0.1
 */