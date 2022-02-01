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
    if ((this.a != null) && (this.a.size() > paramInt)) {
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
    if (this.a != null) {
      return this.a.size();
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
    Face2FaceUserProfile localFace2FaceUserProfile;
    long l1;
    String str;
    if (paramView == null)
    {
      localView = LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131559238, null);
      localViewHolder = new Face2FaceTroopFriendListAdapter.ViewHolder();
      localViewHolder.c = ((ImageView)localView.findViewById(2131367564));
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367590));
      localView.setTag(localViewHolder);
      long l2 = System.currentTimeMillis();
      localFace2FaceUserProfile = a(paramInt);
      l1 = l2;
      if (localFace2FaceUserProfile != null)
      {
        localViewHolder.jdField_a_of_type_JavaLangString = localFace2FaceUserProfile.e;
        localViewHolder.c.setImageBitmap(a(1, localFace2FaceUserProfile.e));
        l1 = System.currentTimeMillis() - l2;
        str = localFace2FaceUserProfile.jdField_a_of_type_JavaLangString;
        if (str != null) {
          break label236;
        }
        paramView = localFace2FaceUserProfile.e;
      }
    }
    for (;;)
    {
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, paramInt + ": totalTime = " + (System.currentTimeMillis() - l3) + ", faceBitmap = " + l1);
      }
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localViewHolder = (Face2FaceTroopFriendListAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      break;
      label236:
      paramView = str;
      if (TextUtils.isEmpty(str.trim())) {
        paramView = localFace2FaceUserProfile.e;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceTroopFriendListAdapter
 * JD-Core Version:    0.7.0.1
 */