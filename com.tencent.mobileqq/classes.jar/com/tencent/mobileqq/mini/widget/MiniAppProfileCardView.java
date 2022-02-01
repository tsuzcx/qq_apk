package com.tencent.mobileqq.mini.widget;

import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.profilecard.BaseMiniAppProfileCardView;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MiniAppProfileCardView
  extends BaseMiniAppProfileCardView
{
  private ColorStateList attrValue;
  private int colorInt;
  private boolean isTheme;
  protected MiniAppProfileCardView.HorzionAdapter mAdapter;
  private Context mContext;
  protected LayoutInflater mLayoutInflater;
  protected HorizontalListView mListView;
  
  public MiniAppProfileCardView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public MiniAppProfileCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public MiniAppProfileCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(paramContext);
    this.mLayoutInflater.inflate(2131561510, this, true);
    this.mListView = ((HorizontalListView)findViewById(2131373544));
    this.mAdapter = new MiniAppProfileCardView.HorzionAdapter(this);
    this.mListView.setAdapter(this.mAdapter);
    this.mListView.setVisibility(0);
  }
  
  public void setData(ArrayList<MiniAppInfo> paramArrayList)
  {
    if (this.mAdapter != null) {
      this.mAdapter.setData(paramArrayList);
    }
  }
  
  public void setData(List<INTERFACE.StApiAppInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(MiniAppInfo.from((INTERFACE.StApiAppInfo)paramList.next()));
    }
    setData(localArrayList);
  }
  
  public void setTextColor(int paramInt)
  {
    this.isTheme = true;
    this.colorInt = paramInt;
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    this.isTheme = true;
    this.attrValue = paramColorStateList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniAppProfileCardView
 * JD-Core Version:    0.7.0.1
 */