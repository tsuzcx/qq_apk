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
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new RecommendTroopAdapter.1(this);
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private List<RecommendTroopItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  private View.OnClickListener b = new RecommendTroopAdapter.2(this);
  
  public RecommendTroopAdapter(Context paramContext, AppInterface paramAppInterface, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static View a(Context paramContext, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener3)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131561528, null);
    RecommendTroopAdapter.ViewHolder localViewHolder = new RecommendTroopAdapter.ViewHolder();
    localViewHolder.jdField_a_of_type_AndroidViewView = paramContext;
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131369534));
    if ((localViewHolder.jdField_a_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
      ((ThemeImageView)localViewHolder.jdField_a_of_type_AndroidWidgetImageView).setSupportMaskView(false);
    }
    localViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramContext.findViewById(2131379955));
    localViewHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)paramContext.findViewById(2131363961));
    localViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout = ((TroopActiveLayout)paramContext.findViewById(2131363409));
    localViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramContext.findViewById(2131363416));
    localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView = ((FolderTextView)paramContext.findViewById(2131379611));
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131379609));
    localViewHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener2);
    paramContext.setOnClickListener(paramOnClickListener1);
    paramContext.setTag(localViewHolder);
    if (paramOnClickListener3 != null)
    {
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener3);
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramContext.setTag(-3, Integer.valueOf(ViewUtils.a(100.0F)));
      return paramContext;
    }
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramContext.setTag(-3, null);
    return paramContext;
  }
  
  public static ArrayList<GroupLabel> a(RecommendTroopItem paramRecommendTroopItem)
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
  
  public static void a(RecommendTroopAdapter.ViewHolder paramViewHolder, RecommendTroopItem paramRecommendTroopItem, Drawable paramDrawable)
  {
    if ((paramViewHolder != null) && (paramRecommendTroopItem != null))
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      paramViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecommendTroopItem.name);
      paramViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setContentDescription(paramRecommendTroopItem.name);
      if (paramRecommendTroopItem.activity > 0)
      {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setVisibility(0);
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setHotLevel(paramRecommendTroopItem.activity);
      }
      else
      {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setVisibility(8);
      }
      paramDrawable = a(paramRecommendTroopItem);
      if ((paramDrawable != null) && (paramDrawable.size() > 0))
      {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setVisibility(0);
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setAutoCreateDistanceTextView(true);
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(paramDrawable);
      }
      else
      {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setVisibility(8);
      }
      if ((!paramRecommendTroopItem.isJoined()) && (!paramRecommendTroopItem.hasRequestJoin))
      {
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(2131699488);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setMinWidth(0);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setMinHeight(0);
        int i = ViewUtils.a(16.0F);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setPadding(i, paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getPaddingTop(), i, paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getPaddingBottom());
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839314);
      }
      else
      {
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        if (paramRecommendTroopItem.hasRequestJoin) {
          paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(2131699489);
        } else {
          paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(2131699490);
        }
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setMinWidth(ViewUtils.a(60.0F));
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setMinWidth(ViewUtils.a(29.0F));
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setPadding(0, paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getPaddingTop(), 0, paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getPaddingBottom());
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      }
      if (TextUtils.isEmpty(paramRecommendTroopItem.intro)) {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.setText("");
      } else {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.setText(new QQText(paramRecommendTroopItem.intro, 11, 16));
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTag(-1, paramRecommendTroopItem);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTag(-1, paramRecommendTroopItem);
      paramViewHolder.jdField_a_of_type_AndroidViewView.setTag(-1, paramRecommendTroopItem);
      return;
    }
    QLog.d("RecommendTroop", 1, "viewHolder == null || troopItem == null");
  }
  
  protected abstract int a();
  
  public RecommendTroopItem a(int paramInt)
  {
    return (RecommendTroopItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  protected void a(RecommendTroopItem paramRecommendTroopItem) {}
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
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
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  protected abstract int b();
  
  protected void b(RecommendTroopItem paramRecommendTroopItem) {}
  
  protected abstract int c();
  
  protected void c(RecommendTroopItem paramRecommendTroopItem) {}
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
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
      localView = a(this.jdField_a_of_type_AndroidContentContext, this.b, this.jdField_a_of_type_AndroidViewView$OnClickListener, null);
    }
    paramView = (RecommendTroopAdapter.ViewHolder)localView.getTag();
    RecommendTroopItem localRecommendTroopItem = a(paramInt);
    a(paramView, localRecommendTroopItem, FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 4, localRecommendTroopItem.uin));
    c(localRecommendTroopItem);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.adapter.RecommendTroopAdapter
 * JD-Core Version:    0.7.0.1
 */