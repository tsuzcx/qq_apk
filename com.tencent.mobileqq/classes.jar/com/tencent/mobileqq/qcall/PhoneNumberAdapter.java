package com.tencent.mobileqq.qcall;

import android.content.Context;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class PhoneNumberAdapter
  extends BaseAdapter
{
  private Context a;
  private List<PhoneContact> b;
  
  public PhoneNumberAdapter(Context paramContext, List<PhoneContact> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131627343, null);
    PhoneNumberAdapter.Holder localHolder = new PhoneNumberAdapter.Holder(null);
    localHolder.a = ((TextView)paramViewGroup.findViewById(2131442292));
    localHolder.b = ((TextView)paramViewGroup.findViewById(2131442291));
    paramViewGroup.setTag(localHolder);
    return paramViewGroup;
  }
  
  private void a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (PhoneNumberAdapter.Holder)paramView.getTag();
    PhoneContact localPhoneContact = (PhoneContact)this.b.get(paramInt);
    paramInt = localPhoneContact.type;
    if (paramInt == 0) {
      paramView = localPhoneContact.label;
    } else {
      paramView = null;
    }
    paramView = (String)ContactsContract.CommonDataKinds.Phone.getTypeLabel(this.a.getResources(), paramInt, paramView);
    paramViewGroup.a.setText(paramView);
    paramViewGroup.b.setText(localPhoneContact.mobileNo);
  }
  
  public int getCount()
  {
    int j = this.b.size();
    int i = j;
    if (j > 20) {
      i = 20;
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null) {
      localView = a(paramInt, paramViewGroup);
    } else {
      localView = paramView;
    }
    a(paramInt, localView, paramViewGroup);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.PhoneNumberAdapter
 * JD-Core Version:    0.7.0.1
 */