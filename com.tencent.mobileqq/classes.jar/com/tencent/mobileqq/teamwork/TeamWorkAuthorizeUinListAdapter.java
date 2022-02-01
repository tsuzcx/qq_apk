package com.tencent.mobileqq.teamwork;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XBaseAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamWorkAuthorizeUinListAdapter
  extends XBaseAdapter
{
  List<TeamWorkAuthorizeUinListAdapter.ItemData> a;
  Map<String, TeamWorkAuthorizeUinListAdapter.ItemData> b = new HashMap();
  Context c;
  QQAppInterface d;
  View.OnClickListener e;
  int f;
  
  public TeamWorkAuthorizeUinListAdapter(QQAppInterface paramQQAppInterface, Context paramContext, View.OnClickListener paramOnClickListener, List<TeamWorkAuthorizeUinListAdapter.ItemData> paramList)
  {
    this.d = paramQQAppInterface;
    this.a = paramList;
    this.c = paramContext;
    this.e = paramOnClickListener;
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(TeamWorkAuthorizeUinListAdapter.ItemData paramItemData)
  {
    if (paramItemData == null) {
      return;
    }
    this.a.add(0, paramItemData);
    this.b.put(paramItemData.b, paramItemData);
  }
  
  public void a(String paramString)
  {
    TeamWorkAuthorizeUinListAdapter.ItemData localItemData = (TeamWorkAuthorizeUinListAdapter.ItemData)this.b.get(paramString);
    if (localItemData == null) {
      return;
    }
    localItemData.e = b(paramString);
    notifyDataSetChanged();
  }
  
  public String b(String paramString)
  {
    Object localObject = (TeamWorkAuthorizeUinListAdapter.ItemData)this.b.get(paramString);
    if (localObject == null) {
      return paramString;
    }
    localObject = ContactUtils.a(this.d, ((TeamWorkAuthorizeUinListAdapter.ItemData)localObject).b, ((TeamWorkAuthorizeUinListAdapter.ItemData)localObject).d, ((TeamWorkAuthorizeUinListAdapter.ItemData)localObject).c);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      ((TeamWorkAuthorizeUinListAdapter.ItemData)this.b.get(paramString)).e = ((String)localObject);
    }
    return ((TeamWorkAuthorizeUinListAdapter.ItemData)this.b.get(paramString)).e;
  }
  
  public void c(String paramString)
  {
    paramString = (TeamWorkAuthorizeUinListAdapter.ItemData)this.b.remove(paramString);
    this.a.remove(paramString);
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.c).inflate(2131629372, null);
      paramView = new TeamWorkAuthorizeUinListAdapter.Holder(this);
      paramView.a = ((URLImageView)localView.findViewById(2131434994));
      paramView.b = ((TextView)localView.findViewById(2131439295));
      paramView.c = ((TextView)localView.findViewById(2131446326));
      paramView.d = ((ImageView)localView.findViewById(2131428790));
      localView.setTag(paramView);
    }
    else
    {
      localObject = (TeamWorkAuthorizeUinListAdapter.Holder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    if (this.f == 2)
    {
      paramView.c.setVisibility(8);
      paramView.d.setVisibility(8);
    }
    else
    {
      paramView.c.setVisibility(0);
      paramView.d.setVisibility(0);
    }
    Object localObject = (TeamWorkAuthorizeUinListAdapter.ItemData)getItem(paramInt);
    String str = String.valueOf(((TeamWorkAuthorizeUinListAdapter.ItemData)localObject).a.uint64_uin.get());
    FaceDrawable localFaceDrawable = FaceDrawable.getFaceDrawable(this.d, 1, str);
    paramView.a.setImageDrawable(localFaceDrawable);
    str = b(str);
    paramView.b.setText(str);
    int i = ((TeamWorkAuthorizeUinListAdapter.ItemData)localObject).a.uint32_right.get();
    if (i == 1) {
      paramView.c.setText(2131917065);
    } else if (i == 2) {
      paramView.c.setText(2131917066);
    } else {
      paramView.c.setText(HardCodeUtil.a(2131912095));
    }
    paramView.e = ((TeamWorkAuthorizeUinListAdapter.ItemData)localObject).a;
    localView.setOnClickListener(this.e);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkAuthorizeUinListAdapter
 * JD-Core Version:    0.7.0.1
 */