package com.tencent.mobileqq.troop.adapter;

import NearbyGroup.Color;
import NearbyGroup.GroupLabel;
import android.content.Context;
import android.graphics.drawable.Drawable;
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
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.utils.RecommendTroopUtils;
import com.tencent.mobileqq.troop.widget.TroopActiveLayout;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x935.oidb_0x935.RgroupInfo;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb.Color;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb.Label;

public abstract class RecommendTroopAdapter
  extends BaseAdapter
{
  private AppInterface a;
  private Context b;
  private List<RecommendTroopItem> c = new ArrayList();
  private View.OnClickListener d = new RecommendTroopAdapter.1(this);
  private View.OnClickListener e = new RecommendTroopAdapter.2(this);
  
  public RecommendTroopAdapter(Context paramContext, AppInterface paramAppInterface, boolean paramBoolean)
  {
    this.a = paramAppInterface;
    this.b = paramContext;
  }
  
  public static View a(Context paramContext, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener3)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131627889, null);
    RecommendTroopAdapter.ViewHolder localViewHolder = new RecommendTroopAdapter.ViewHolder();
    localViewHolder.a = paramContext;
    localViewHolder.b = ((ImageView)paramContext.findViewById(2131436633));
    if ((localViewHolder.b instanceof ThemeImageView)) {
      ((ThemeImageView)localViewHolder.b).setSupportMaskView(false);
    }
    localViewHolder.c = ((SingleLineTextView)paramContext.findViewById(2131448843));
    localViewHolder.d = ((Button)paramContext.findViewById(2131429917));
    localViewHolder.e = ((TroopActiveLayout)paramContext.findViewById(2131429299));
    localViewHolder.f = ((TroopLabelLayout)paramContext.findViewById(2131429306));
    localViewHolder.g = ((FolderTextView)paramContext.findViewById(2131448375));
    localViewHolder.h = ((TextView)paramContext.findViewById(2131448371));
    localViewHolder.d.setOnClickListener(paramOnClickListener2);
    paramContext.setOnClickListener(paramOnClickListener1);
    paramContext.setTag(localViewHolder);
    if (paramOnClickListener3 != null)
    {
      localViewHolder.h.setOnClickListener(paramOnClickListener3);
      localViewHolder.h.setVisibility(0);
      paramContext.setTag(-3, Integer.valueOf(ViewUtils.dip2px(100.0F)));
      return paramContext;
    }
    localViewHolder.h.setOnClickListener(null);
    localViewHolder.h.setVisibility(8);
    paramContext.setTag(-3, null);
    return paramContext;
  }
  
  public static void a(RecommendTroopAdapter.ViewHolder paramViewHolder, RecommendTroopItem paramRecommendTroopItem, Drawable paramDrawable)
  {
    if ((paramViewHolder != null) && (paramRecommendTroopItem != null))
    {
      paramViewHolder.b.setImageDrawable(paramDrawable);
      paramViewHolder.c.setText(paramRecommendTroopItem.name);
      paramViewHolder.c.setContentDescription(paramRecommendTroopItem.name);
      if (paramRecommendTroopItem.activity > 0)
      {
        paramViewHolder.e.setVisibility(0);
        paramViewHolder.e.setHotLevel(paramRecommendTroopItem.activity);
      }
      else
      {
        paramViewHolder.e.setVisibility(8);
      }
      paramDrawable = d(paramRecommendTroopItem);
      if ((paramDrawable != null) && (paramDrawable.size() > 0))
      {
        paramViewHolder.f.setVisibility(0);
        paramViewHolder.f.setLabelType(1);
        paramViewHolder.f.setAutoCreateDistanceTextView(true);
        paramViewHolder.f.a(paramDrawable);
      }
      else
      {
        paramViewHolder.f.setVisibility(8);
      }
      if ((!paramRecommendTroopItem.isJoined()) && (!paramRecommendTroopItem.hasRequestJoin))
      {
        paramViewHolder.d.setEnabled(true);
        paramViewHolder.d.setText(2131897519);
        paramViewHolder.d.setMinWidth(0);
        paramViewHolder.d.setMinHeight(0);
        int i = ViewUtils.dip2px(16.0F);
        paramViewHolder.d.setPadding(i, paramViewHolder.d.getPaddingTop(), i, paramViewHolder.d.getPaddingBottom());
        paramViewHolder.d.setBackgroundResource(2130839494);
      }
      else
      {
        paramViewHolder.d.setEnabled(false);
        if (paramRecommendTroopItem.hasRequestJoin) {
          paramViewHolder.d.setText(2131897520);
        } else {
          paramViewHolder.d.setText(2131897521);
        }
        paramViewHolder.d.setMinWidth(ViewUtils.dip2px(60.0F));
        paramViewHolder.d.setMinWidth(ViewUtils.dip2px(29.0F));
        paramViewHolder.d.setPadding(0, paramViewHolder.d.getPaddingTop(), 0, paramViewHolder.d.getPaddingBottom());
        paramViewHolder.d.setBackgroundDrawable(null);
      }
      if (TextUtils.isEmpty(paramRecommendTroopItem.intro)) {
        paramViewHolder.g.setText("");
      } else {
        paramViewHolder.g.setText(new QQText(paramRecommendTroopItem.intro, 11, 16));
      }
      paramViewHolder.d.setTag(-1, paramRecommendTroopItem);
      paramViewHolder.h.setTag(-1, paramRecommendTroopItem);
      paramViewHolder.a.setTag(-1, paramRecommendTroopItem);
      return;
    }
    QLog.d("RecommendTroop", 1, "viewHolder == null || troopItem == null");
  }
  
  public static ArrayList<GroupLabel> d(RecommendTroopItem paramRecommendTroopItem)
  {
    Object localObject = null;
    if (paramRecommendTroopItem == null) {
      return null;
    }
    if ((paramRecommendTroopItem.labelList == null) && (paramRecommendTroopItem.x935RgroupInfo != null))
    {
      oidb_0x935.RgroupInfo localRgroupInfo = new oidb_0x935.RgroupInfo();
      try
      {
        localRgroupInfo.mergeFrom(paramRecommendTroopItem.x935RgroupInfo);
        if (localRgroupInfo.rpt_group_label.has()) {
          paramRecommendTroopItem.labelList = RecommendTroopUtils.b(localRgroupInfo.rpt_group_label.get());
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
    if (paramRecommendTroopItem.labelList == null) {
      return null;
    }
    if (paramRecommendTroopItem.labelList.size() > 0)
    {
      ArrayList localArrayList = new ArrayList();
      paramRecommendTroopItem = paramRecommendTroopItem.labelList.iterator();
      for (;;)
      {
        localObject = localArrayList;
        if (!paramRecommendTroopItem.hasNext()) {
          break;
        }
        localObject = (oidb_0x9fb.Label)paramRecommendTroopItem.next();
        GroupLabel localGroupLabel = new GroupLabel();
        Color localColor = new Color();
        localColor.R = ((oidb_0x9fb.Label)localObject).edging_color.uint32_r.get();
        localColor.G = ((oidb_0x9fb.Label)localObject).edging_color.uint32_g.get();
        localColor.B = ((oidb_0x9fb.Label)localObject).edging_color.uint32_b.get();
        localGroupLabel.edging_color = localColor;
        localColor = new Color();
        localColor.R = ((oidb_0x9fb.Label)localObject).text_color.uint32_r.get();
        localColor.G = ((oidb_0x9fb.Label)localObject).text_color.uint32_g.get();
        localColor.B = ((oidb_0x9fb.Label)localObject).text_color.uint32_b.get();
        localGroupLabel.text_color = localColor;
        localGroupLabel.strWording = ((oidb_0x9fb.Label)localObject).bytes_name.get().toStringUtf8();
        localGroupLabel.type = ((oidb_0x9fb.Label)localObject).uint32_label_attr.get();
        localArrayList.add(localGroupLabel);
      }
    }
    return localObject;
  }
  
  protected abstract int a();
  
  public RecommendTroopItem a(int paramInt)
  {
    return (RecommendTroopItem)this.c.get(paramInt);
  }
  
  protected void a(RecommendTroopItem paramRecommendTroopItem) {}
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = this.c;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.c.iterator();
      while (((Iterator)localObject).hasNext())
      {
        RecommendTroopItem localRecommendTroopItem = (RecommendTroopItem)((Iterator)localObject).next();
        if (paramString.equals(localRecommendTroopItem.uin))
        {
          localRecommendTroopItem.hasRequestJoin = true;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("updateJoinStatus, troopUin: ");
            ((StringBuilder)localObject).append(paramString);
            QLog.d("RecommendTroop", 2, ((StringBuilder)localObject).toString());
          }
          notifyDataSetChanged();
        }
      }
    }
  }
  
  public void a(List<RecommendTroopItem> paramList)
  {
    if (paramList != null)
    {
      this.c.clear();
      this.c.addAll(paramList);
    }
  }
  
  protected abstract int b();
  
  protected void b(RecommendTroopItem paramRecommendTroopItem) {}
  
  protected abstract int c();
  
  protected void c(RecommendTroopItem paramRecommendTroopItem) {}
  
  public int getCount()
  {
    return this.c.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if ((paramView.getTag() instanceof RecommendTroopAdapter.ViewHolder)) {}
    }
    else
    {
      localView = a(this.b, this.e, this.d, null);
    }
    paramView = (RecommendTroopAdapter.ViewHolder)localView.getTag();
    RecommendTroopItem localRecommendTroopItem = a(paramInt);
    a(paramView, localRecommendTroopItem, FaceDrawable.getFaceDrawable(this.a, 4, localRecommendTroopItem.uin));
    c(localRecommendTroopItem);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.adapter.RecommendTroopAdapter
 * JD-Core Version:    0.7.0.1
 */