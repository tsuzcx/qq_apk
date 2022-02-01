package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.open.agent.datamodel.AgentBaseAdapter;
import com.tencent.open.agent.datamodel.ImageLoader;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class BindGroupActivity$GroupListAdapter
  extends AgentBaseAdapter
{
  protected BindGroupActivity$GroupListAdapter(BindGroupActivity paramBindGroupActivity) {}
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilList.size();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    View localView;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = (BindGroupActivity.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      localObject = (BindGroupActivity.GroupInfo)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((BindGroupActivity.GroupInfo)localObject).b);
      paramView.jdField_a_of_type_JavaLangString = ((BindGroupActivity.GroupInfo)localObject).c;
      Bitmap localBitmap = ImageLoader.a().a(((BindGroupActivity.GroupInfo)localObject).c);
      if (localBitmap == null) {
        break label171;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562997, paramViewGroup, false);
      paramView = new BindGroupActivity.ViewHolder();
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131366520));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379987));
      localView.setTag(paramView);
      break;
      label171:
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840707);
      ImageLoader.a().a(((BindGroupActivity.GroupInfo)localObject).c, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupActivity.GroupListAdapter
 * JD-Core Version:    0.7.0.1
 */