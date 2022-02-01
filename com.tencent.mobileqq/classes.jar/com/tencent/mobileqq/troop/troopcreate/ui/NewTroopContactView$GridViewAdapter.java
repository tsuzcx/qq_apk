package com.tencent.mobileqq.troop.troopcreate.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.api.troopcreate.IQQBase;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;
import java.util.ArrayList;

public class NewTroopContactView$GridViewAdapter
  extends BaseAdapter
  implements DecodeTaskCompletionListener
{
  private final Drawable b;
  private boolean c = false;
  private Context d;
  
  public NewTroopContactView$GridViewAdapter(NewTroopContactView paramNewTroopContactView, Context paramContext)
  {
    this.b = paramContext.getResources().getDrawable(2130846389);
    this.d = paramContext;
  }
  
  public void a()
  {
    if (this.c)
    {
      if ((this.a.o != null) && (this.a.o.size() > 0))
      {
        String str = ((ResultRecord)this.a.o.get(this.a.o.size() - 1)).uin;
        if (this.a.a(str))
        {
          NewTroopContactView.a(this.a, str);
          this.a.y.notifyDataSetChanged();
          this.a.b(false);
          this.a.p();
        }
      }
      this.c = false;
      return;
    }
    this.c = true;
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.a.o.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.o.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ResultRecord localResultRecord = (ResultRecord)getItem(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = this.a.a.getLayoutInflater().inflate(2131625198, null);
    }
    localView.setTag(localResultRecord);
    ImageView localImageView = (ImageView)localView.findViewById(2131432714);
    if (paramInt == getCount() - 1)
    {
      if (this.c) {
        paramView = this.b;
      } else {
        paramView = null;
      }
      localImageView.setImageDrawable(paramView);
    }
    else
    {
      localImageView.setImageDrawable(null);
    }
    localImageView.setBackgroundDrawable(null);
    int i;
    if (localResultRecord.type == 4) {
      i = 11;
    } else {
      i = 1;
    }
    TextView localTextView = (TextView)localView.findViewById(2131448522);
    if (localResultRecord.type == 5)
    {
      localImageView.setImageResource(2130843087);
      localTextView.setVisibility(0);
      localTextView.setText(NewTroopContactView.b(this.a).getHeaderText(localResultRecord.name));
    }
    else
    {
      String str = localResultRecord.uin;
      Bitmap localBitmap = this.a.s.getBitmapFromCache(i, str);
      paramView = localBitmap;
      if (localBitmap == null)
      {
        this.a.s.requestDecodeFace(str, i, true);
        paramView = this.a.t;
      }
      localImageView.setBackgroundDrawable(new BitmapDrawable(this.a.a.getResources(), paramView));
      localTextView.setVisibility(8);
    }
    if (AppSetting.e) {
      localImageView.setContentDescription(localResultRecord.name);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void notifyDataSetChanged()
  {
    this.c = false;
    super.notifyDataSetChanged();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (this.a.i == null) {
      return;
    }
    paramInt1 = 0;
    while (paramInt1 < this.a.i.getChildCount())
    {
      View localView = this.a.i.getChildAt(paramInt1);
      Object localObject = localView.getTag();
      if ((localObject != null) && ((localObject instanceof ResultRecord)) && (paramString.equals(((ResultRecord)localObject).uin))) {
        ((ImageView)localView.findViewById(2131432714)).setBackgroundDrawable(new BitmapDrawable(this.a.a.getResources(), paramBitmap));
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.NewTroopContactView.GridViewAdapter
 * JD-Core Version:    0.7.0.1
 */