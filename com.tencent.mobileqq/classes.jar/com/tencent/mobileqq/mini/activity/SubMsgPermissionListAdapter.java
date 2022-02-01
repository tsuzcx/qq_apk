package com.tencent.mobileqq.mini.activity;

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
import com.tencent.widget.Switch;
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
    Switch localSwitch;
    if (localStSubscribeMessage != null)
    {
      if (paramView == null) {
        break label135;
      }
      localObject = (SubMsgPermissionListAdapter.ViewHolder)paramView.getTag();
      ((SubMsgPermissionListAdapter.ViewHolder)localObject).tvAuthTitle.setText(localStSubscribeMessage.example.title.get());
      ((SubMsgPermissionListAdapter.ViewHolder)localObject).ivAuthDetail.setTag(localStSubscribeMessage);
      ((SubMsgPermissionListAdapter.ViewHolder)localObject).ivAuthDetail.setOnClickListener(this);
      ((SubMsgPermissionListAdapter.ViewHolder)localObject).authSwitcher.setTag(localStSubscribeMessage);
      localSwitch = ((SubMsgPermissionListAdapter.ViewHolder)localObject).authSwitcher;
      if (localStSubscribeMessage.authState.get() != 1) {
        break label207;
      }
    }
    label135:
    label207:
    for (boolean bool = true;; bool = false)
    {
      localSwitch.setChecked(bool);
      ((SubMsgPermissionListAdapter.ViewHolder)localObject).authSwitcher.setOnCheckedChangeListener(this);
      localObject = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
      return localObject;
      localObject = new SubMsgPermissionListAdapter.ViewHolder(null);
      paramView = this.mInflater.inflate(2131559404, null);
      ((SubMsgPermissionListAdapter.ViewHolder)localObject).tvAuthTitle = ((TextView)paramView.findViewById(2131379471));
      ((SubMsgPermissionListAdapter.ViewHolder)localObject).ivAuthDetail = ((ImageView)paramView.findViewById(2131369153));
      ((SubMsgPermissionListAdapter.ViewHolder)localObject).authSwitcher = ((Switch)paramView.findViewById(2131378040));
      paramView.setTag(localObject);
      break;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.innerCheckedChangeListener != null) {
      this.innerCheckedChangeListener.onCheckedChanged(paramCompoundButton, paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    if (this.innerOnClickListener != null) {
      this.innerOnClickListener.onClick(paramView);
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
        if (paramBoolean) {}
        for (int i = 1;; i = 2)
        {
          localStSubscribeMessage.authState.set(i);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.SubMsgPermissionListAdapter
 * JD-Core Version:    0.7.0.1
 */