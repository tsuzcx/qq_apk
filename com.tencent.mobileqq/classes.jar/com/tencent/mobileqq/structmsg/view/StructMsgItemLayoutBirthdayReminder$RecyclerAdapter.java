package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class StructMsgItemLayoutBirthdayReminder$RecyclerAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private Context b;
  private List<StructMsgItemLayoutBirthdayReminder.BirthdayReminder> c;
  
  public StructMsgItemLayoutBirthdayReminder$RecyclerAdapter(Context paramContext, List<StructMsgItemLayoutBirthdayReminder.BirthdayReminder> paramList)
  {
    this.b = paramList;
    Object localObject;
    this.c = localObject;
  }
  
  public StructMsgItemLayoutBirthdayReminder.MyHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new StructMsgItemLayoutBirthdayReminder.MyHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131628372, paramViewGroup, false), null);
  }
  
  public int getItemCount()
  {
    return this.c.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof StructMsgItemLayoutBirthdayReminder.MyHolder))
    {
      StructMsgItemLayoutBirthdayReminder.MyHolder localMyHolder = (StructMsgItemLayoutBirthdayReminder.MyHolder)paramViewHolder;
      StructMsgItemLayoutBirthdayReminder.BirthdayReminder localBirthdayReminder = (StructMsgItemLayoutBirthdayReminder.BirthdayReminder)this.c.get(paramInt);
      if (localBirthdayReminder != null)
      {
        Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if ((localObject instanceof AppInterface))
        {
          localObject = FaceDrawable.getUserFaceDrawable((AppInterface)localObject, localBirthdayReminder.a(), (byte)3);
          localMyHolder.a.setImageDrawable((Drawable)localObject);
        }
        localMyHolder.b.setText(localBirthdayReminder.b());
        if (!TextUtils.isEmpty(localBirthdayReminder.f()))
        {
          localMyHolder.c.setText(localBirthdayReminder.f());
          localMyHolder.c.setVisibility(0);
        }
        localObject = StructMsgItemLayoutBirthdayReminder.a(this.a, this.b, localBirthdayReminder.d(), localBirthdayReminder.e());
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localMyHolder.d.setText((CharSequence)localObject);
          localMyHolder.d.setVisibility(0);
        }
        localObject = StructMsgItemLayoutBirthdayReminder.a(localBirthdayReminder.g(), localBirthdayReminder.h(), 10.0F);
        if (localObject != null) {
          localMyHolder.c.setBackgroundDrawable((Drawable)localObject);
        }
        String str = BaseApplicationImpl.sApplication.getRuntime().getAccount();
        boolean bool = ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getBoolean(str, StructMsgItemLayoutBirthdayReminder.BirthdayReminder.a(localBirthdayReminder), localBirthdayReminder.c(), false);
        if (bool)
        {
          localMyHolder.e.setText(this.b.getResources().getString(2131899387));
          localMyHolder.e.setTextColor(this.b.getResources().getColor(2131166854));
          localObject = StructMsgItemLayoutBirthdayReminder.a(20.0F, this.b.getResources().getColor(2131165795), 1.0F, this.b.getResources().getColor(2131167469));
        }
        else
        {
          localMyHolder.e.setText(this.b.getResources().getString(2131899394));
          localMyHolder.e.setTextColor(-1);
          localObject = StructMsgItemLayoutBirthdayReminder.a(localBirthdayReminder.i(), localBirthdayReminder.j(), 20.0F);
        }
        localMyHolder.e.setBackgroundDrawable((Drawable)localObject);
        localMyHolder.e.setOnClickListener(new StructMsgItemLayoutBirthdayReminder.RecyclerAdapter.1(this, bool, localBirthdayReminder, str));
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutBirthdayReminder.RecyclerAdapter
 * JD-Core Version:    0.7.0.1
 */