package com.tencent.mobileqq.facetoface;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class Face2FaceTroopFriendListAdapter
  extends FacePreloadBaseAdapter
{
  private List<Face2FaceUserData> a = null;
  
  public Face2FaceTroopFriendListAdapter(BaseActivity paramBaseActivity, XListView paramXListView)
  {
    super(paramBaseActivity, paramBaseActivity.app, paramXListView, 1, true);
    paramXListView.setAdapter(this);
  }
  
  public Face2FaceUserProfile a(int paramInt)
  {
    List localList = this.a;
    if ((localList != null) && (localList.size() > paramInt)) {
      return (Face2FaceUserProfile)this.a.get(paramInt);
    }
    return null;
  }
  
  public void a(Face2FaceUserProfile paramFace2FaceUserProfile)
  {
    if (getCount() == 0) {
      this.a = new ArrayList();
    }
    this.a.add(0, paramFace2FaceUserProfile);
    notifyDataSetChanged();
  }
  
  public void a(List<Face2FaceUserData> paramList)
  {
    this.a = new ArrayList(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.a;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    long l3 = System.currentTimeMillis();
    View localView;
    Face2FaceTroopFriendListAdapter.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localView = LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131559115, null);
      localViewHolder = new Face2FaceTroopFriendListAdapter.ViewHolder();
      localViewHolder.c = ((ImageView)localView.findViewById(2131367322));
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367348));
      localView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (Face2FaceTroopFriendListAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
    }
    long l2 = System.currentTimeMillis();
    Face2FaceUserProfile localFace2FaceUserProfile = a(paramInt);
    long l1 = l2;
    if (localFace2FaceUserProfile != null)
    {
      localViewHolder.jdField_a_of_type_JavaLangString = localFace2FaceUserProfile.e;
      localViewHolder.c.setImageBitmap(a(1, localFace2FaceUserProfile.e));
      l1 = System.currentTimeMillis() - l2;
      String str = localFace2FaceUserProfile.jdField_a_of_type_JavaLangString;
      if (str == null)
      {
        paramView = localFace2FaceUserProfile.e;
      }
      else
      {
        paramView = str;
        if (TextUtils.isEmpty(str.trim())) {
          paramView = localFace2FaceUserProfile.e;
        }
      }
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append(paramInt);
      paramView.append(": totalTime = ");
      paramView.append(System.currentTimeMillis() - l3);
      paramView.append(", faceBitmap = ");
      paramView.append(l1);
      QLog.d("zivonchen", 2, paramView.toString());
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceTroopFriendListAdapter
 * JD-Core Version:    0.7.0.1
 */