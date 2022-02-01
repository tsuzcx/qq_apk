package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.troop.robot.TroopRobotInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AddedRobotView
  extends LinearLayout
{
  private Context a;
  private TextView b;
  private TextView c;
  private RecyclerView d;
  private AddedRobotView.RobotListAdapter e;
  private GridLayoutManager f;
  private IFaceDecoder g;
  private RelativeLayout h;
  private String i;
  private DecodeTaskCompletionListener j = new AddedRobotView.1(this);
  private RecyclerView.OnScrollListener k = new AddedRobotView.2(this);
  
  public AddedRobotView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AddedRobotView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AddedRobotView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    setOrientation(1);
    paramContext = LayoutInflater.from(this.a);
    setBackgroundResource(2130852616);
    paramContext = paramContext.inflate(2131627892, null);
    this.b = ((TextView)paramContext.findViewById(2131437066));
    this.c = ((TextView)paramContext.findViewById(2131444784));
    addView(paramContext);
    this.d = new RecyclerView(this.a);
    this.f = new GridLayoutManager(this.a, 5);
    this.d.setLayoutManager(this.f);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.d.setLayoutParams(paramContext);
    this.d.setOverScrollMode(2);
    addView(this.d);
    paramContext = new TextView(this.a);
    paramContext.setText(getResources().getString(2131892144));
    paramContext.setTextSize(2, 14.0F);
    paramContext.setTextColor(getResources().getColor(2131168118));
    paramContext.setContentDescription(getResources().getString(2131892144));
    paramContext.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
    this.h = new RelativeLayout(this.a);
    this.h.setBackgroundResource(2130852616);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131299657));
    this.h.setLayoutParams(localLayoutParams);
    this.h.setGravity(17);
    this.h.addView(paramContext);
    addView(this.h);
    paramContext = new RelativeLayout(this.a);
    paramContext.setBackgroundResource(2130838958);
    paramContext.setLayoutParams(new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131299658)));
    addView(paramContext);
    paramContext = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.g = ((IQQAvatarService)paramContext.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramContext);
    this.g.setDecodeTaskCompletionListener(this.j);
    this.e = new AddedRobotView.RobotListAdapter(this, this.a);
    this.d.setAdapter(this.e);
    this.d.addOnScrollListener(this.k);
  }
  
  public void a()
  {
    QLog.i("AddedRobotView", 1, "onDestroy.");
    IFaceDecoder localIFaceDecoder = this.g;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
    this.a = null;
  }
  
  public void setAddList(ArrayList<TroopRobotInfo> paramArrayList, int paramInt, String paramString)
  {
    if (this.c != null)
    {
      int m;
      if (paramArrayList != null) {
        m = paramArrayList.size();
      } else {
        m = 0;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(m);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(paramInt);
      localObject = ((StringBuilder)localObject).toString();
      this.c.setText((CharSequence)localObject);
      this.c.setVisibility(0);
      this.c.setContentDescription((CharSequence)localObject);
    }
    Object localObject = this.b;
    if (localObject != null)
    {
      ((TextView)localObject).setText(this.a.getResources().getText(2131886311));
      this.b.setContentDescription(this.a.getResources().getText(2131886311));
    }
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      this.d.setVisibility(0);
      this.e.a(paramArrayList);
      this.h.setVisibility(8);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setAddList ");
      ((StringBuilder)localObject).append(paramArrayList.size());
      QLog.d("AddedRobotView", 2, ((StringBuilder)localObject).toString());
    }
    else
    {
      this.h.setVisibility(0);
      this.d.setVisibility(8);
      QLog.d("AddedRobotView", 2, "setAddList 0");
    }
    this.i = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AddedRobotView
 * JD-Core Version:    0.7.0.1
 */